package com.adxcorp.ads.mediation;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.ActivityCompat;
import com.adxcorp.ads.mediation.common.AdRequest;
import com.adxcorp.ads.mediation.common.Configuration;
import com.adxcorp.ads.mediation.id.GAID;
import com.adxcorp.ads.mediation.id.OnGAIDListener;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.ads.mediation.util.ClickThroughUtil;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class MediationSDK {
    public static final String TAG = "MediationSDK";
    private static Configuration configuration = new Configuration();
    private static MediationSDK ourInstance = new MediationSDK();
    private String mAppID;
    private String mCacheDir;
    private AdRequest mCommonHeader;
    private Context mContext;
    private OnInitializedListener mInitializedListener;
    private boolean mIsInitialized;
    private String mRandomId;
    private String mUserAgent;

    public interface OnInitializedListener {
        void onCompleted(boolean z);
    }

    private int getNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 2;
            case 13:
            case 18:
            case 19:
                return 3;
            case 20:
                return 4;
            default:
                return 0;
        }
    }

    private MediationSDK() {
        ADXLogUtil.d(TAG, "AdSDK instance is created.");
    }

    public static MediationSDK getInstance() {
        return ourInstance;
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public synchronized void initialize(Context context, String str) {
        String str2 = TAG;
        ADXLogUtil.d(str2, "AdSDK is starting initialization.");
        if (context == null) {
            ADXLogUtil.e(str2, new Exception("Context cannot be null."));
            OnInitializedListener onInitializedListener = this.mInitializedListener;
            if (onInitializedListener != null) {
                onInitializedListener.onCompleted(false);
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            ADXLogUtil.e(str2, new Exception("Media ID cannot be null."));
            OnInitializedListener onInitializedListener2 = this.mInitializedListener;
            if (onInitializedListener2 != null) {
                onInitializedListener2.onCompleted(false);
            }
            return;
        }
        this.mContext = context;
        this.mAppID = str;
        new Thread(new Runnable() { // from class: com.adxcorp.ads.mediation.MediationSDK.1
            @Override // java.lang.Runnable
            public void run() {
                MediationSDK.this.checkLogging();
                MediationSDK.this.getCommonHeader();
                final OnGAIDListener onGAIDListener = new OnGAIDListener() { // from class: com.adxcorp.ads.mediation.MediationSDK.1.1
                    @Override // com.adxcorp.ads.mediation.id.OnGAIDListener
                    public void onCompleted(String str3, boolean z) {
                        Log.d(MediationSDK.TAG, "AdSDK SDK got advertising id : " + str3);
                        MediationSDK.this.getCommonHeader().setUdid(str3);
                        MediationSDK.this.getCommonHeader().setUdidType("1");
                        if (z) {
                            MediationSDK.this.getCommonHeader().setDoNotTracking("1");
                        } else {
                            MediationSDK.this.getCommonHeader().setDoNotTracking("0");
                        }
                        if (!TextUtils.isEmpty(str3) && (str3.equals("13e07771-2121-4e7a-ae74-10ca1ad1abe1") || str3.equals("73fc8bc4-f23a-4ac2-b93a-10ca1ad1abe1") || str3.equals("c66335e5-89fc-42c9-ae95-10ca1ad1abe1") || str3.equals("e2cc9108-94b2-4d7b-82ab-10ca1ad1abe1") || str3.equals("09b596d3-1785-4c9b-bd17-10ca1ad1abe1") || str3.equals("c8e9c278-44b0-465a-9bbd-58eea5f16bff"))) {
                            MediationSDK.this.getConfiguration().setSdkLog(true);
                            ADXLogUtil.setLogEnable(true);
                            ADXLogUtil.setLogLevel(3);
                        }
                        MediationSDK.this.mIsInitialized = true;
                        Log.d(MediationSDK.TAG, "Mediation SDK initialization is completed.");
                        if (MediationSDK.this.mInitializedListener != null) {
                            MediationSDK.this.mInitializedListener.onCompleted(true);
                        }
                    }

                    @Override // com.adxcorp.ads.mediation.id.OnGAIDListener
                    public void onFailed() {
                        MediationSDK.this.getCommonHeader().setUdid("");
                        MediationSDK.this.getCommonHeader().setUdidType("0");
                        MediationSDK.this.getCommonHeader().setDoNotTracking("0");
                        MediationSDK.this.mIsInitialized = true;
                        Log.d(MediationSDK.TAG, "Mediation initialization is completed.");
                        if (MediationSDK.this.mInitializedListener != null) {
                            MediationSDK.this.mInitializedListener.onCompleted(true);
                        }
                    }
                };
                MediationSDK mediationSDK = MediationSDK.this;
                mediationSDK.mCacheDir = mediationSDK.mContext.getCacheDir().getAbsolutePath();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.adxcorp.ads.mediation.MediationSDK.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        GAID.getInstance().getAdvertisingId(MediationSDK.this.mContext, onGAIDListener);
                    }
                });
            }
        }).start();
    }

    public synchronized void initialize(Context context, String str, OnInitializedListener onInitializedListener) {
        this.mInitializedListener = onInitializedListener;
        initialize(context, str);
    }

    public String getAppId() {
        return this.mAppID;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x023f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x026c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x00dd A[Catch: Exception -> 0x00e9, TRY_LEAVE, TryCatch #6 {Exception -> 0x00e9, blocks: (B:21:0x00d1, B:23:0x00dd), top: B:113:0x00d1, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00f9 A[Catch: Exception -> 0x031d, TryCatch #3 {Exception -> 0x031d, blocks: (B:5:0x000c, B:7:0x0032, B:29:0x00f9, B:31:0x0111, B:90:0x02fc, B:92:0x0306, B:94:0x030d, B:96:0x0317, B:67:0x025d, B:69:0x0267, B:56:0x0230, B:58:0x023a, B:41:0x01df, B:43:0x01e9, B:26:0x00ea, B:28:0x00f4, B:14:0x00b1, B:16:0x00bb, B:18:0x00c2, B:20:0x00cc, B:8:0x0038, B:44:0x01ee, B:46:0x01f2, B:48:0x01f8, B:50:0x0217, B:52:0x0221, B:53:0x0229, B:49:0x020b, B:32:0x015b, B:34:0x016f, B:35:0x018b, B:37:0x019e, B:38:0x01d4, B:59:0x023f, B:61:0x0243, B:64:0x0251, B:70:0x026c, B:72:0x0276, B:73:0x0294, B:75:0x02a8, B:77:0x02ab, B:79:0x02ae, B:81:0x02ba, B:82:0x02d4, B:84:0x02e2, B:86:0x02ec, B:87:0x02f3, B:21:0x00d1, B:23:0x00dd, B:9:0x003d, B:11:0x0065), top: B:108:0x000c, inners: #1, #2, #4, #5, #6, #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0111 A[Catch: Exception -> 0x031d, TRY_LEAVE, TryCatch #3 {Exception -> 0x031d, blocks: (B:5:0x000c, B:7:0x0032, B:29:0x00f9, B:31:0x0111, B:90:0x02fc, B:92:0x0306, B:94:0x030d, B:96:0x0317, B:67:0x025d, B:69:0x0267, B:56:0x0230, B:58:0x023a, B:41:0x01df, B:43:0x01e9, B:26:0x00ea, B:28:0x00f4, B:14:0x00b1, B:16:0x00bb, B:18:0x00c2, B:20:0x00cc, B:8:0x0038, B:44:0x01ee, B:46:0x01f2, B:48:0x01f8, B:50:0x0217, B:52:0x0221, B:53:0x0229, B:49:0x020b, B:32:0x015b, B:34:0x016f, B:35:0x018b, B:37:0x019e, B:38:0x01d4, B:59:0x023f, B:61:0x0243, B:64:0x0251, B:70:0x026c, B:72:0x0276, B:73:0x0294, B:75:0x02a8, B:77:0x02ab, B:79:0x02ae, B:81:0x02ba, B:82:0x02d4, B:84:0x02e2, B:86:0x02ec, B:87:0x02f3, B:21:0x00d1, B:23:0x00dd, B:9:0x003d, B:11:0x0065), top: B:108:0x000c, inners: #1, #2, #4, #5, #6, #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x016f A[Catch: Exception -> 0x01de, TryCatch #2 {Exception -> 0x01de, blocks: (B:32:0x015b, B:34:0x016f, B:35:0x018b, B:37:0x019e, B:38:0x01d4), top: B:106:0x015b, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x019e A[Catch: Exception -> 0x01de, TryCatch #2 {Exception -> 0x01de, blocks: (B:32:0x015b, B:34:0x016f, B:35:0x018b, B:37:0x019e, B:38:0x01d4), top: B:106:0x015b, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01f2 A[Catch: Exception -> 0x022f, TryCatch #1 {Exception -> 0x022f, blocks: (B:44:0x01ee, B:46:0x01f2, B:48:0x01f8, B:50:0x0217, B:52:0x0221, B:53:0x0229, B:49:0x020b), top: B:104:0x01ee, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x01f8 A[Catch: Exception -> 0x022f, TryCatch #1 {Exception -> 0x022f, blocks: (B:44:0x01ee, B:46:0x01f2, B:48:0x01f8, B:50:0x0217, B:52:0x0221, B:53:0x0229, B:49:0x020b), top: B:104:0x01ee, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x020b A[Catch: Exception -> 0x022f, TryCatch #1 {Exception -> 0x022f, blocks: (B:44:0x01ee, B:46:0x01f2, B:48:0x01f8, B:50:0x0217, B:52:0x0221, B:53:0x0229, B:49:0x020b), top: B:104:0x01ee, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0221 A[Catch: Exception -> 0x022f, TryCatch #1 {Exception -> 0x022f, blocks: (B:44:0x01ee, B:46:0x01f2, B:48:0x01f8, B:50:0x0217, B:52:0x0221, B:53:0x0229, B:49:0x020b), top: B:104:0x01ee, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0243 A[Catch: Exception -> 0x025c, TryCatch #4 {Exception -> 0x025c, blocks: (B:59:0x023f, B:61:0x0243, B:64:0x0251), top: B:109:0x023f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x024f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:72:0x0276 A[Catch: Exception -> 0x02fb, NameNotFoundException -> 0x030c, TryCatch #5 {Exception -> 0x02fb, blocks: (B:70:0x026c, B:72:0x0276, B:73:0x0294, B:75:0x02a8, B:77:0x02ab, B:79:0x02ae, B:81:0x02ba, B:82:0x02d4, B:84:0x02e2, B:86:0x02ec, B:87:0x02f3), top: B:111:0x026c, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x02a8 A[Catch: Exception -> 0x02fb, NameNotFoundException -> 0x030c, TryCatch #5 {Exception -> 0x02fb, blocks: (B:70:0x026c, B:72:0x0276, B:73:0x0294, B:75:0x02a8, B:77:0x02ab, B:79:0x02ae, B:81:0x02ba, B:82:0x02d4, B:84:0x02e2, B:86:0x02ec, B:87:0x02f3), top: B:111:0x026c, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x02ae A[Catch: Exception -> 0x02fb, NameNotFoundException -> 0x030c, TryCatch #5 {Exception -> 0x02fb, blocks: (B:70:0x026c, B:72:0x0276, B:73:0x0294, B:75:0x02a8, B:77:0x02ab, B:79:0x02ae, B:81:0x02ba, B:82:0x02d4, B:84:0x02e2, B:86:0x02ec, B:87:0x02f3), top: B:111:0x026c, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x02ba A[Catch: Exception -> 0x02fb, NameNotFoundException -> 0x030c, TryCatch #5 {Exception -> 0x02fb, blocks: (B:70:0x026c, B:72:0x0276, B:73:0x0294, B:75:0x02a8, B:77:0x02ab, B:79:0x02ae, B:81:0x02ba, B:82:0x02d4, B:84:0x02e2, B:86:0x02ec, B:87:0x02f3), top: B:111:0x026c, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x02e2 A[Catch: Exception -> 0x02fb, NameNotFoundException -> 0x030c, TryCatch #5 {Exception -> 0x02fb, blocks: (B:70:0x026c, B:72:0x0276, B:73:0x0294, B:75:0x02a8, B:77:0x02ab, B:79:0x02ae, B:81:0x02ba, B:82:0x02d4, B:84:0x02e2, B:86:0x02ec, B:87:0x02f3), top: B:111:0x026c, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x02ec A[Catch: Exception -> 0x02fb, NameNotFoundException -> 0x030c, TryCatch #5 {Exception -> 0x02fb, blocks: (B:70:0x026c, B:72:0x0276, B:73:0x0294, B:75:0x02a8, B:77:0x02ab, B:79:0x02ae, B:81:0x02ba, B:82:0x02d4, B:84:0x02e2, B:86:0x02ec, B:87:0x02f3), top: B:111:0x026c, outer: #3 }] */
    public AdRequest getCommonHeader() {
        ActivityInfo[] activityInfoArr;
        Context context;
        int deviceWidth;
        Locale locale;
        String language;
        TelephonyManager telephonyManager;
        if (this.mCommonHeader == null) {
            AdRequest adRequest = new AdRequest();
            this.mCommonHeader = adRequest;
            try {
                adRequest.setDeviceType(Integer.toString(2));
                this.mCommonHeader.setOsType(Integer.toString(1));
                this.mCommonHeader.setSdkVersion(ADXGDPR.ADX_SDK_VERSION);
                this.mCommonHeader.setOsVersion(Build.VERSION.RELEASE);
                if (Build.VERSION.SDK_INT >= 16) {
                    this.mCommonHeader.setAvailableVideo(true);
                } else {
                    this.mCommonHeader.setAvailableVideo(false);
                }
                try {
                    PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
                    this.mCommonHeader.setAppPackageName(packageInfo.packageName);
                    this.mCommonHeader.setAppVersionName(packageInfo.versionName);
                    if (getConfiguration().isSdkLog()) {
                        String str = TAG;
                        ADXLogUtil.d(str, "packageName:" + packageInfo.packageName);
                        ADXLogUtil.d(str, "versionName:" + packageInfo.versionName);
                        ADXLogUtil.d(str, "versionCode:" + packageInfo.versionCode);
                        try {
                            if (TextUtils.isEmpty(this.mCommonHeader.getUserAgent())) {
                                this.mCommonHeader.setUserAgent(System.getProperty("http.agent"));
                                this.mCommonHeader.setManufacturer(Build.MANUFACTURER);
                                this.mCommonHeader.setModel(Build.MODEL);
                                if (getConfiguration().isSdkLog()) {
                                    String str2 = TAG;
                                    ADXLogUtil.d(str2, "BRAND:" + Build.BRAND);
                                    ADXLogUtil.d(str2, "MANUFACTURER:" + Build.MANUFACTURER);
                                    ADXLogUtil.d(str2, "MODEL:" + Build.MODEL);
                                }
                                try {
                                    telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "operationName:" + telephonyManager.getNetworkOperatorName());
                                    }
                                    this.mCommonHeader.setServiceProvider(telephonyManager.getNetworkOperatorName());
                                    if (getConfiguration().isSdkLog()) {
                                        String str3 = TAG;
                                        ADXLogUtil.d(str3, "getNETWORKCountryIso:" + telephonyManager.getNetworkCountryIso());
                                        ADXLogUtil.d(str3, "getSimCountryIso:" + telephonyManager.getSimCountryIso());
                                    }
                                    this.mCommonHeader.setCountryCode(telephonyManager.getNetworkCountryIso());
                                } catch (Exception e) {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.e(TAG, e);
                                    }
                                }
                                try {
                                    if (this.mContext == null) {
                                        if (Build.VERSION.SDK_INT >= 24) {
                                            locale = this.mContext.getResources().getConfiguration().getLocales().get(0);
                                        } else {
                                            locale = this.mContext.getResources().getConfiguration().locale;
                                        }
                                        language = locale.getLanguage();
                                        if (TextUtils.isEmpty(language)) {
                                            language = Locale.getDefault().getLanguage();
                                        }
                                        this.mCommonHeader.setLanguage(language);
                                        context = this.mContext;
                                        if (context != null) {
                                            deviceWidth = DisplayUtil.getDeviceWidth(context);
                                            int deviceHeight = DisplayUtil.getDeviceHeight(this.mContext);
                                            if (deviceWidth <= 0) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                                }
                                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                                if (activityInfoArr != null) {
                                                    for (ActivityInfo activityInfo : activityInfoArr) {
                                                        if (getConfiguration().isSdkLog()) {
                                                            ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                        }
                                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                            if (getConfiguration().isSdkLog()) {
                                                                ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                            }
                                                            this.mCommonHeader.setAvailableInAppBrowser(true);
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                                }
                                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                                if (activityInfoArr != null) {
                                                    while (i < r2) {
                                                        if (getConfiguration().isSdkLog()) {
                                                            ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                        }
                                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                            if (getConfiguration().isSdkLog()) {
                                                                ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                            }
                                                            this.mCommonHeader.setAvailableInAppBrowser(true);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                            }
                                            activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                            if (activityInfoArr != null) {
                                                while (i < r2) {
                                                    if (getConfiguration().isSdkLog()) {
                                                        ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                    }
                                                    if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                        if (getConfiguration().isSdkLog()) {
                                                            ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                        }
                                                        this.mCommonHeader.setAvailableInAppBrowser(true);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        try {
                                            context = this.mContext;
                                            if (context != null) {
                                                deviceWidth = DisplayUtil.getDeviceWidth(context);
                                                int deviceHeight2 = DisplayUtil.getDeviceHeight(this.mContext);
                                                if (deviceWidth <= 0 && deviceHeight2 > 0) {
                                                    this.mCommonHeader.setDeviceWidth(deviceWidth);
                                                    this.mCommonHeader.setDeviceHeight(deviceHeight2);
                                                    if (getConfiguration().isSdkLog()) {
                                                        ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                                    }
                                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                                    if (activityInfoArr != null) {
                                                        while (i < r2) {
                                                            if (getConfiguration().isSdkLog()) {
                                                                ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                            }
                                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                                if (getConfiguration().isSdkLog()) {
                                                                    ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                                }
                                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    try {
                                                        try {
                                                            if (getConfiguration().isSdkLog()) {
                                                                ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                                            }
                                                            activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                                            if (activityInfoArr != null && activityInfoArr.length > 0) {
                                                                while (i < r2) {
                                                                    if (getConfiguration().isSdkLog()) {
                                                                        ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                                    }
                                                                    if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                                        if (getConfiguration().isSdkLog()) {
                                                                            ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                                        }
                                                                        this.mCommonHeader.setAvailableInAppBrowser(true);
                                                                    }
                                                                }
                                                            }
                                                        } catch (PackageManager.NameNotFoundException e2) {
                                                            if (getConfiguration().isSdkLog()) {
                                                                ADXLogUtil.e(TAG, e2);
                                                            }
                                                        }
                                                    } catch (Exception e3) {
                                                        if (getConfiguration().isSdkLog()) {
                                                            ADXLogUtil.e(TAG, e3);
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                                }
                                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                                if (activityInfoArr != null) {
                                                    while (i < r2) {
                                                        if (getConfiguration().isSdkLog()) {
                                                            ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                        }
                                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                            if (getConfiguration().isSdkLog()) {
                                                                ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                            }
                                                            this.mCommonHeader.setAvailableInAppBrowser(true);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e4) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.e(TAG, e4);
                                            }
                                        }
                                    }
                                } catch (Exception e5) {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.e(TAG, e5);
                                    }
                                }
                            } else {
                                this.mCommonHeader.setManufacturer(Build.MANUFACTURER);
                                this.mCommonHeader.setModel(Build.MODEL);
                                if (getConfiguration().isSdkLog()) {
                                    String str4 = TAG;
                                    ADXLogUtil.d(str4, "BRAND:" + Build.BRAND);
                                    ADXLogUtil.d(str4, "MANUFACTURER:" + Build.MANUFACTURER);
                                    ADXLogUtil.d(str4, "MODEL:" + Build.MODEL);
                                }
                                telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
                                if (getConfiguration().isSdkLog()) {
                                    ADXLogUtil.d(TAG, "operationName:" + telephonyManager.getNetworkOperatorName());
                                }
                                this.mCommonHeader.setServiceProvider(telephonyManager.getNetworkOperatorName());
                                if (getConfiguration().isSdkLog()) {
                                    String str5 = TAG;
                                    ADXLogUtil.d(str5, "getNETWORKCountryIso:" + telephonyManager.getNetworkCountryIso());
                                    ADXLogUtil.d(str5, "getSimCountryIso:" + telephonyManager.getSimCountryIso());
                                }
                                this.mCommonHeader.setCountryCode(telephonyManager.getNetworkCountryIso());
                                if (this.mContext == null) {
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        locale = this.mContext.getResources().getConfiguration().getLocales().get(0);
                                    } else {
                                        locale = this.mContext.getResources().getConfiguration().locale;
                                    }
                                    language = locale.getLanguage();
                                    if (TextUtils.isEmpty(language)) {
                                        language = Locale.getDefault().getLanguage();
                                    }
                                    this.mCommonHeader.setLanguage(language);
                                    context = this.mContext;
                                    if (context != null) {
                                        deviceWidth = DisplayUtil.getDeviceWidth(context);
                                        int deviceHeight3 = DisplayUtil.getDeviceHeight(this.mContext);
                                        if (deviceWidth <= 0) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                            }
                                            activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                            if (activityInfoArr != null) {
                                                while (i < r2) {
                                                    if (getConfiguration().isSdkLog()) {
                                                        ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                    }
                                                    if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                        if (getConfiguration().isSdkLog()) {
                                                            ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                        }
                                                        this.mCommonHeader.setAvailableInAppBrowser(true);
                                                    }
                                                }
                                            }
                                        } else {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                            }
                                            activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                            if (activityInfoArr != null) {
                                                while (i < r2) {
                                                    if (getConfiguration().isSdkLog()) {
                                                        ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                    }
                                                    if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                        if (getConfiguration().isSdkLog()) {
                                                            ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                        }
                                                        this.mCommonHeader.setAvailableInAppBrowser(true);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (getConfiguration().isSdkLog()) {
                                            ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                        }
                                        activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                        if (activityInfoArr != null) {
                                            while (i < r2) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                }
                                                if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                    if (getConfiguration().isSdkLog()) {
                                                        ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                    }
                                                    this.mCommonHeader.setAvailableInAppBrowser(true);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    context = this.mContext;
                                    if (context != null) {
                                        deviceWidth = DisplayUtil.getDeviceWidth(context);
                                        int deviceHeight4 = DisplayUtil.getDeviceHeight(this.mContext);
                                        if (deviceWidth <= 0) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                            }
                                            activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                            if (activityInfoArr != null) {
                                                while (i < r2) {
                                                    if (getConfiguration().isSdkLog()) {
                                                        ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                    }
                                                    if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                        if (getConfiguration().isSdkLog()) {
                                                            ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                        }
                                                        this.mCommonHeader.setAvailableInAppBrowser(true);
                                                    }
                                                }
                                            }
                                        } else {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                            }
                                            activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                            if (activityInfoArr != null) {
                                                while (i < r2) {
                                                    if (getConfiguration().isSdkLog()) {
                                                        ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                    }
                                                    if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                        if (getConfiguration().isSdkLog()) {
                                                            ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                        }
                                                        this.mCommonHeader.setAvailableInAppBrowser(true);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (getConfiguration().isSdkLog()) {
                                            ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                        }
                                        activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                        if (activityInfoArr != null) {
                                            while (i < r2) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                                }
                                                if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                    if (getConfiguration().isSdkLog()) {
                                                        ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                    }
                                                    this.mCommonHeader.setAvailableInAppBrowser(true);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e6) {
                            if (getConfiguration().isSdkLog()) {
                                ADXLogUtil.e(TAG, e6);
                            }
                        }
                    } else if (TextUtils.isEmpty(this.mCommonHeader.getUserAgent())) {
                        this.mCommonHeader.setUserAgent(System.getProperty("http.agent"));
                        this.mCommonHeader.setManufacturer(Build.MANUFACTURER);
                        this.mCommonHeader.setModel(Build.MODEL);
                        if (getConfiguration().isSdkLog()) {
                            String str6 = TAG;
                            ADXLogUtil.d(str6, "BRAND:" + Build.BRAND);
                            ADXLogUtil.d(str6, "MANUFACTURER:" + Build.MANUFACTURER);
                            ADXLogUtil.d(str6, "MODEL:" + Build.MODEL);
                        }
                        telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
                        if (getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(TAG, "operationName:" + telephonyManager.getNetworkOperatorName());
                        }
                        this.mCommonHeader.setServiceProvider(telephonyManager.getNetworkOperatorName());
                        if (getConfiguration().isSdkLog()) {
                            String str7 = TAG;
                            ADXLogUtil.d(str7, "getNETWORKCountryIso:" + telephonyManager.getNetworkCountryIso());
                            ADXLogUtil.d(str7, "getSimCountryIso:" + telephonyManager.getSimCountryIso());
                        }
                        this.mCommonHeader.setCountryCode(telephonyManager.getNetworkCountryIso());
                        if (this.mContext == null) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                locale = this.mContext.getResources().getConfiguration().getLocales().get(0);
                            } else {
                                locale = this.mContext.getResources().getConfiguration().locale;
                            }
                            language = locale.getLanguage();
                            if (TextUtils.isEmpty(language)) {
                                language = Locale.getDefault().getLanguage();
                            }
                            this.mCommonHeader.setLanguage(language);
                            context = this.mContext;
                            if (context != null) {
                                deviceWidth = DisplayUtil.getDeviceWidth(context);
                                int deviceHeight5 = DisplayUtil.getDeviceHeight(this.mContext);
                                if (deviceWidth <= 0) {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                } else {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (getConfiguration().isSdkLog()) {
                                    ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                }
                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                if (activityInfoArr != null) {
                                    while (i < r2) {
                                        if (getConfiguration().isSdkLog()) {
                                            ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                        }
                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                            }
                                            this.mCommonHeader.setAvailableInAppBrowser(true);
                                        }
                                    }
                                }
                            }
                        } else {
                            context = this.mContext;
                            if (context != null) {
                                deviceWidth = DisplayUtil.getDeviceWidth(context);
                                int deviceHeight6 = DisplayUtil.getDeviceHeight(this.mContext);
                                if (deviceWidth <= 0) {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                } else {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (getConfiguration().isSdkLog()) {
                                    ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                }
                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                if (activityInfoArr != null) {
                                    while (i < r2) {
                                        if (getConfiguration().isSdkLog()) {
                                            ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                        }
                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                            }
                                            this.mCommonHeader.setAvailableInAppBrowser(true);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        this.mCommonHeader.setManufacturer(Build.MANUFACTURER);
                        this.mCommonHeader.setModel(Build.MODEL);
                        if (getConfiguration().isSdkLog()) {
                            String str8 = TAG;
                            ADXLogUtil.d(str8, "BRAND:" + Build.BRAND);
                            ADXLogUtil.d(str8, "MANUFACTURER:" + Build.MANUFACTURER);
                            ADXLogUtil.d(str8, "MODEL:" + Build.MODEL);
                        }
                        telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
                        if (getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(TAG, "operationName:" + telephonyManager.getNetworkOperatorName());
                        }
                        this.mCommonHeader.setServiceProvider(telephonyManager.getNetworkOperatorName());
                        if (getConfiguration().isSdkLog()) {
                            String str9 = TAG;
                            ADXLogUtil.d(str9, "getNETWORKCountryIso:" + telephonyManager.getNetworkCountryIso());
                            ADXLogUtil.d(str9, "getSimCountryIso:" + telephonyManager.getSimCountryIso());
                        }
                        this.mCommonHeader.setCountryCode(telephonyManager.getNetworkCountryIso());
                        if (this.mContext == null) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                locale = this.mContext.getResources().getConfiguration().getLocales().get(0);
                            } else {
                                locale = this.mContext.getResources().getConfiguration().locale;
                            }
                            language = locale.getLanguage();
                            if (TextUtils.isEmpty(language)) {
                                language = Locale.getDefault().getLanguage();
                            }
                            this.mCommonHeader.setLanguage(language);
                            context = this.mContext;
                            if (context != null) {
                                deviceWidth = DisplayUtil.getDeviceWidth(context);
                                int deviceHeight7 = DisplayUtil.getDeviceHeight(this.mContext);
                                if (deviceWidth <= 0) {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                } else {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (getConfiguration().isSdkLog()) {
                                    ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                }
                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                if (activityInfoArr != null) {
                                    while (i < r2) {
                                        if (getConfiguration().isSdkLog()) {
                                            ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                        }
                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                            }
                                            this.mCommonHeader.setAvailableInAppBrowser(true);
                                        }
                                    }
                                }
                            }
                        } else {
                            context = this.mContext;
                            if (context != null) {
                                deviceWidth = DisplayUtil.getDeviceWidth(context);
                                int deviceHeight8 = DisplayUtil.getDeviceHeight(this.mContext);
                                if (deviceWidth <= 0) {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                } else {
                                    if (getConfiguration().isSdkLog()) {
                                        ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isSdkLog()) {
                                                    ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (getConfiguration().isSdkLog()) {
                                    ADXLogUtil.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                }
                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                if (activityInfoArr != null) {
                                    while (i < r2) {
                                        if (getConfiguration().isSdkLog()) {
                                            ADXLogUtil.d(TAG, "Activity Name:" + activityInfo.name);
                                        }
                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                            if (getConfiguration().isSdkLog()) {
                                                ADXLogUtil.d(TAG, "Available InAppBrowser!");
                                            }
                                            this.mCommonHeader.setAvailableInAppBrowser(true);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e7) {
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(TAG, e7);
                    }
                } catch (Exception e8) {
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(TAG, e8);
                    }
                }
            } catch (Exception e9) {
                if (getConfiguration().isSdkLog()) {
                    ADXLogUtil.e(TAG, e9);
                }
            }
        }
        return this.mCommonHeader;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0144  */
    public int getNetworkConnectionType() {
        try {
            if (this.mContext == null) {
                return 0;
            }
            if (!checkPermission("android.permission.INTERNET")) {
                ADXLogUtil.d(TAG, "android.permission.INTERNET permission must be added in AndroidManifest.xml!");
                return 0;
            }
            if (!checkPermission("android.permission.ACCESS_NETWORK_STATE")) {
                ADXLogUtil.d(TAG, "android.permission.ACCESS_NETWORK_STATE permission must be added in AndroidManifest.xml!");
                return 0;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT > 28) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(1)) {
                        getCommonHeader().setConnectionType(2);
                        return 2;
                    }
                    if (networkCapabilities.hasTransport(0)) {
                        try {
                            if (Build.VERSION.SDK_INT >= 30 && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.READ_PHONE_STATE") != 0) {
                                getCommonHeader().setConnectionType(3);
                                return 3;
                            }
                            int networkClass = getNetworkClass(((TelephonyManager) this.mContext.getSystemService("phone")).getNetworkType());
                            if (networkClass == 1) {
                                getCommonHeader().setConnectionType(4);
                                return 4;
                            }
                            if (networkClass == 2) {
                                getCommonHeader().setConnectionType(5);
                                return 5;
                            }
                            if (networkClass == 3) {
                                getCommonHeader().setConnectionType(6);
                                return 6;
                            }
                            if (networkClass == 4) {
                                getCommonHeader().setConnectionType(7);
                                return 7;
                            }
                            getCommonHeader().setConnectionType(3);
                            return 3;
                        } catch (Exception e) {
                            if (getConfiguration().isSdkLog()) {
                                ADXLogUtil.e(TAG, e);
                            }
                        }
                    }
                }
                return 0;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                getCommonHeader().setConnectionType(2);
                return 2;
            }
            if (activeNetworkInfo.getType() == 0) {
                try {
                    int networkClass2 = getNetworkClass(((TelephonyManager) this.mContext.getSystemService("phone")).getNetworkType());
                    if (networkClass2 == 1) {
                        getCommonHeader().setConnectionType(4);
                        return 4;
                    }
                    if (networkClass2 == 2) {
                        getCommonHeader().setConnectionType(5);
                        return 5;
                    }
                    if (networkClass2 == 3) {
                        getCommonHeader().setConnectionType(6);
                        return 6;
                    }
                    if (networkClass2 == 4) {
                        getCommonHeader().setConnectionType(7);
                        return 7;
                    }
                    getCommonHeader().setConnectionType(3);
                    return 3;
                } catch (Exception e2) {
                    if (getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(TAG, e2);
                    }
                }
            }
            return 0;
            if (getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            return 0;
        } catch (Exception e3) {
            if (getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e3);
            }
        }
    }

    public boolean checkPermission(String str) {
        try {
            return this.mContext.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            return false;
        }
    }

    public String getVersion() {
        return ADXGDPR.ADX_SDK_VERSION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLogging() {
        try {
            if (Preference.getBooleanValue(this.mContext, "LOG_ENABLE", false)) {
                configuration.setSdkLog(true);
                ADXLogUtil.setLogEnable(true);
                ADXLogUtil.setLogLevel(3);
            }
        } catch (Exception unused) {
        }
    }

    public String getCacheDir() {
        return this.mCacheDir;
    }

    public void addTargetBrowser(String str) {
        ClickThroughUtil.addTargetBrowser(str);
    }

    public void clearTargetBrowser() {
        ClickThroughUtil.clearTargetBrowser();
    }

    public String getUserAgent() {
        if (TextUtils.isEmpty(this.mUserAgent)) {
            String property = null;
            try {
                try {
                    property = System.getProperty("http.agent");
                } catch (SecurityException unused) {
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    return property;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    this.mUserAgent = WebSettings.getDefaultUserAgent(this.mContext);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.adxcorp.ads.mediation.MediationSDK.2
                        @Override // java.lang.Runnable
                        public void run() {
                            WebView webView = new WebView(MediationSDK.this.mContext);
                            MediationSDK.this.mUserAgent = webView.getSettings().getUserAgentString();
                            webView.destroy();
                        }
                    });
                }
            } catch (Exception e) {
                ADXLogUtil.e(TAG, e);
            }
        }
        return this.mUserAgent;
    }

    public String getRandomId() {
        try {
            if (TextUtils.isEmpty(this.mRandomId)) {
                String stringValue = Preference.getStringValue(this.mContext, "randomID", "");
                this.mRandomId = stringValue;
                if (TextUtils.isEmpty(stringValue)) {
                    String string = UUID.randomUUID().toString();
                    this.mRandomId = string;
                    Preference.putString(this.mContext, "randomID", string);
                }
            }
        } catch (Exception unused) {
        }
        return this.mRandomId;
    }
}
