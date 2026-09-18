package com.gomfactory.adpie.sdk;

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
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.ActivityCompat;
import com.gomfactory.adpie.sdk.common.AdRequest;
import com.gomfactory.adpie.sdk.common.Configuration;
import com.gomfactory.adpie.sdk.common.DataKeys;
import com.gomfactory.adpie.sdk.id.GAID;
import com.gomfactory.adpie.sdk.id.OnGAIDListener;
import com.gomfactory.adpie.sdk.network.NetworkServiceManager;
import com.gomfactory.adpie.sdk.pref.Preference;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.ClickThroughUtil;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdPieSDK {
    public static final String TAG = "AdPieSDK";
    private static Configuration configuration = new Configuration();
    private static AdPieSDK ourInstance = new AdPieSDK();
    private AdRequest mAdRequest;
    private String mAppID;
    private String mCacheDir;
    private AdRequest mCommonHeader;
    private Context mContext;
    private OnInitializedListener mInitializedListener;
    private boolean mIsInitialized;
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

    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    private AdPieSDK() {
        AdPieLog.d(TAG, "AdPieSDK instance is created.");
    }

    public static AdPieSDK getInstance() {
        return ourInstance;
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public synchronized void initialize(Context context, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("adpie_server_log", false);
            String strOptString = jSONObject.optString("adpie_config_url", configuration.getAdpieConfigUrl());
            String strOptString2 = jSONObject.optString("adpie_ssp_url", configuration.getAdpieSspUrl());
            configuration.setAdpieServerLog(zOptBoolean);
            configuration.setAdpieConfigUrl(strOptString);
            configuration.setAdpieSspUrl(strOptString2);
            this.mContext = context;
            try {
                Preference.putString(context, DataKeys.CONFIG_URL_KEY, strOptString);
                Preference.putString(this.mContext, DataKeys.SSP_REQUEST_URL_KEY, strOptString2);
            } catch (Exception e) {
                if (getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.e(TAG, e);
                }
            }
        }
        initialize(context, str);
    }

    public synchronized void initialize(Context context, String str) {
        String str2 = TAG;
        AdPieLog.d(str2, "AdPie SDK is starting initialization.");
        if (context == null) {
            AdPieLog.e(str2, new Exception("Context cannot be null."));
            OnInitializedListener onInitializedListener = this.mInitializedListener;
            if (onInitializedListener != null) {
                onInitializedListener.onCompleted(false);
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            AdPieLog.e(str2, new Exception("Media ID cannot be null."));
            OnInitializedListener onInitializedListener2 = this.mInitializedListener;
            if (onInitializedListener2 != null) {
                onInitializedListener2.onCompleted(false);
            }
            return;
        }
        this.mContext = context;
        this.mAppID = str;
        new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdPieSDK.1
            @Override // java.lang.Runnable
            public void run() {
                AdPieSDK.this.checkLogging();
                AdPieSDK.this.getCommonHeader();
                final OnGAIDListener onGAIDListener = new OnGAIDListener() { // from class: com.gomfactory.adpie.sdk.AdPieSDK.1.1
                    @Override // com.gomfactory.adpie.sdk.id.OnGAIDListener
                    public void onCompleted(String str3, boolean z) {
                        AdPieLog.d(AdPieSDK.TAG, "AdPie SDK got advertising id : " + str3);
                        AdPieSDK.this.getCommonHeader().setUdid(str3);
                        AdPieSDK.this.getCommonHeader().setUdidType("1");
                        if (z) {
                            AdPieSDK.this.getCommonHeader().setDoNotTracking("1");
                        } else {
                            AdPieSDK.this.getCommonHeader().setDoNotTracking("0");
                        }
                        AdPieSDK.this.mIsInitialized = true;
                        AdPieLog.d(AdPieSDK.TAG, "AdPie SDK initialization is completed.");
                        AdPieSDK.this.requestConfigData(false);
                        if (AdPieSDK.this.mInitializedListener != null) {
                            AdPieSDK.this.mInitializedListener.onCompleted(true);
                        }
                    }

                    @Override // com.gomfactory.adpie.sdk.id.OnGAIDListener
                    public void onFailed() {
                        AdPieSDK.this.getCommonHeader().setUdid("");
                        AdPieSDK.this.getCommonHeader().setUdidType("0");
                        AdPieSDK.this.getCommonHeader().setDoNotTracking("0");
                        AdPieSDK.this.mIsInitialized = true;
                        AdPieLog.d(AdPieSDK.TAG, "AdPie SDK initialization is completed.");
                        AdPieSDK.this.requestConfigData(false);
                        if (AdPieSDK.this.mInitializedListener != null) {
                            AdPieSDK.this.mInitializedListener.onCompleted(true);
                        }
                    }
                };
                AdPieSDK adPieSDK = AdPieSDK.this;
                adPieSDK.mCacheDir = adPieSDK.mContext.getCacheDir().getAbsolutePath();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdPieSDK.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        GAID.getInstance().getAdvertisingId(AdPieSDK.this.mContext, onGAIDListener);
                    }
                });
            }
        }).start();
    }

    public synchronized void initialize(Context context, String str, OnInitializedListener onInitializedListener) {
        this.mInitializedListener = onInitializedListener;
        initialize(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestConfigData(final boolean z) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String str = simpleDateFormat.format(new Date(Preference.getLongValue(this.mContext, DataKeys.getKeyWithMedia(DataKeys.CONFIG_UTIME_KEY, this.mAppID), 0L)));
            String str2 = simpleDateFormat.format(new Date());
            if (getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "updateDate : " + str + ", currentDate : " + str2);
            }
            if (str2.equals(str)) {
                if (getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "AdPie SDK Configuration was already updated!");
                    return;
                }
                return;
            }
        } catch (Exception unused) {
        }
        int networkConnectionType = getNetworkConnectionType();
        if (networkConnectionType == 0) {
            return;
        }
        getRequest(z).setConnectionType(networkConnectionType);
        if (getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "AdPie SDK is preparing to send configuration." + (z ? "" : ":)"));
        }
        NetworkServiceManager.getInstance().post(getRequest(z).getRequestURL(), getRequest(z).toUri().getEncodedQuery(), new Handler(Looper.getMainLooper()) { // from class: com.gomfactory.adpie.sdk.AdPieSDK.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    if (message.what == 200) {
                        JSONObject jSONObject = new JSONObject((String) message.obj);
                        if (jSONObject.optInt("result", -1) == 0) {
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                            if (jSONObjectOptJSONObject != null) {
                                AdPieSDK.this.updateConfig(jSONObjectOptJSONObject);
                                Preference.putString(AdPieSDK.this.mContext, DataKeys.getKeyWithMedia(DataKeys.CONFIG_ACCESS_DATE_KEY, AdPieSDK.this.mAppID), jSONObjectOptJSONObject.optString("access_date"));
                            }
                        } else if (!z) {
                            AdPieSDK.this.requestConfigData(true);
                        }
                    } else if (message.what == -1 && !z) {
                        AdPieSDK.this.requestConfigData(true);
                    }
                } catch (Exception e) {
                    if (AdPieSDK.this.getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(AdPieSDK.TAG, e);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConfig(JSONObject jSONObject) {
        try {
            Preference.putLong(this.mContext, DataKeys.getKeyWithMedia(DataKeys.CONFIG_UTIME_KEY, this.mAppID), new Date().getTime());
            boolean z = false;
            z = false;
            boolean z2 = jSONObject.optInt("ssp_enable", 1) != 0;
            String strOptString = jSONObject.optString("ssp_req_url");
            Preference.putBoolean(this.mContext, DataKeys.getKeyWithMedia("SSP_ENABLE", this.mAppID), z2);
            Preference.putString(this.mContext, DataKeys.SSP_REQUEST_URL_KEY, strOptString);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ScarConstants.TOKEN_ID_KEY);
            String udid = getCommonHeader().getUdid();
            if (jSONArrayOptJSONArray != null && !TextUtils.isEmpty(udid)) {
                boolean z3 = false;
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    if (jSONArrayOptJSONArray.get(i).equals(udid)) {
                        z3 = true;
                    }
                }
                z = z3;
            }
            Preference.putBoolean(this.mContext, "LOG_ENABLE", z);
            checkLogging();
        } catch (Exception e) {
            if (getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    public String getAppId() {
        return this.mAppID;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0233 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x02ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0105 A[Catch: Exception -> 0x0311, TRY_LEAVE, TryCatch #8 {Exception -> 0x0311, blocks: (B:5:0x000c, B:7:0x0032, B:27:0x00ed, B:29:0x0105, B:88:0x02f0, B:90:0x02fa, B:92:0x0301, B:94:0x030b, B:65:0x0251, B:67:0x025b, B:54:0x0224, B:56:0x022e, B:39:0x01d3, B:41:0x01dd, B:24:0x00de, B:26:0x00e8, B:14:0x00b1, B:16:0x00bb, B:18:0x00c2, B:20:0x00cc, B:8:0x0038, B:57:0x0233, B:59:0x0237, B:62:0x0245, B:21:0x00d1, B:42:0x01e2, B:44:0x01e6, B:46:0x01ec, B:48:0x020b, B:50:0x0215, B:51:0x021d, B:47:0x01ff, B:30:0x014f, B:32:0x0163, B:33:0x017f, B:35:0x0192, B:36:0x01c8, B:9:0x003d, B:11:0x0065, B:68:0x0260, B:70:0x026a, B:71:0x0288, B:73:0x029c, B:75:0x029f, B:77:0x02a2, B:79:0x02ae, B:80:0x02c8, B:82:0x02d6, B:84:0x02e0, B:85:0x02e7), top: B:110:0x000c, inners: #0, #3, #6, #7, #9, #8 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0163 A[Catch: Exception -> 0x01d2, TryCatch #7 {Exception -> 0x01d2, blocks: (B:30:0x014f, B:32:0x0163, B:33:0x017f, B:35:0x0192, B:36:0x01c8), top: B:108:0x014f, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0192 A[Catch: Exception -> 0x01d2, TryCatch #7 {Exception -> 0x01d2, blocks: (B:30:0x014f, B:32:0x0163, B:33:0x017f, B:35:0x0192, B:36:0x01c8), top: B:108:0x014f, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x01e6 A[Catch: Exception -> 0x0223, TryCatch #6 {Exception -> 0x0223, blocks: (B:42:0x01e2, B:44:0x01e6, B:46:0x01ec, B:48:0x020b, B:50:0x0215, B:51:0x021d, B:47:0x01ff), top: B:106:0x01e2, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01ec A[Catch: Exception -> 0x0223, TryCatch #6 {Exception -> 0x0223, blocks: (B:42:0x01e2, B:44:0x01e6, B:46:0x01ec, B:48:0x020b, B:50:0x0215, B:51:0x021d, B:47:0x01ff), top: B:106:0x01e2, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x01ff A[Catch: Exception -> 0x0223, TryCatch #6 {Exception -> 0x0223, blocks: (B:42:0x01e2, B:44:0x01e6, B:46:0x01ec, B:48:0x020b, B:50:0x0215, B:51:0x021d, B:47:0x01ff), top: B:106:0x01e2, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0215 A[Catch: Exception -> 0x0223, TryCatch #6 {Exception -> 0x0223, blocks: (B:42:0x01e2, B:44:0x01e6, B:46:0x01ec, B:48:0x020b, B:50:0x0215, B:51:0x021d, B:47:0x01ff), top: B:106:0x01e2, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0237 A[Catch: Exception -> 0x0250, TryCatch #0 {Exception -> 0x0250, blocks: (B:57:0x0233, B:59:0x0237, B:62:0x0245), top: B:102:0x0233, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0243 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:70:0x026a A[Catch: Exception -> 0x02ef, NameNotFoundException -> 0x0300, TryCatch #8 {NameNotFoundException -> 0x0300, Exception -> 0x02ef, blocks: (B:68:0x0260, B:70:0x026a, B:71:0x0288, B:73:0x029c, B:75:0x029f, B:77:0x02a2, B:79:0x02ae, B:80:0x02c8, B:82:0x02d6, B:84:0x02e0, B:85:0x02e7), top: B:113:0x0260, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x029c A[Catch: Exception -> 0x02ef, NameNotFoundException -> 0x0300, TryCatch #8 {NameNotFoundException -> 0x0300, Exception -> 0x02ef, blocks: (B:68:0x0260, B:70:0x026a, B:71:0x0288, B:73:0x029c, B:75:0x029f, B:77:0x02a2, B:79:0x02ae, B:80:0x02c8, B:82:0x02d6, B:84:0x02e0, B:85:0x02e7), top: B:113:0x0260, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x02a2 A[Catch: Exception -> 0x02ef, NameNotFoundException -> 0x0300, TryCatch #8 {NameNotFoundException -> 0x0300, Exception -> 0x02ef, blocks: (B:68:0x0260, B:70:0x026a, B:71:0x0288, B:73:0x029c, B:75:0x029f, B:77:0x02a2, B:79:0x02ae, B:80:0x02c8, B:82:0x02d6, B:84:0x02e0, B:85:0x02e7), top: B:113:0x0260, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x02ae A[Catch: Exception -> 0x02ef, NameNotFoundException -> 0x0300, TryCatch #8 {NameNotFoundException -> 0x0300, Exception -> 0x02ef, blocks: (B:68:0x0260, B:70:0x026a, B:71:0x0288, B:73:0x029c, B:75:0x029f, B:77:0x02a2, B:79:0x02ae, B:80:0x02c8, B:82:0x02d6, B:84:0x02e0, B:85:0x02e7), top: B:113:0x0260, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x02d6 A[Catch: Exception -> 0x02ef, NameNotFoundException -> 0x0300, TryCatch #8 {NameNotFoundException -> 0x0300, Exception -> 0x02ef, blocks: (B:68:0x0260, B:70:0x026a, B:71:0x0288, B:73:0x029c, B:75:0x029f, B:77:0x02a2, B:79:0x02ae, B:80:0x02c8, B:82:0x02d6, B:84:0x02e0, B:85:0x02e7), top: B:113:0x0260, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x02e0 A[Catch: Exception -> 0x02ef, NameNotFoundException -> 0x0300, TryCatch #8 {NameNotFoundException -> 0x0300, Exception -> 0x02ef, blocks: (B:68:0x0260, B:70:0x026a, B:71:0x0288, B:73:0x029c, B:75:0x029f, B:77:0x02a2, B:79:0x02ae, B:80:0x02c8, B:82:0x02d6, B:84:0x02e0, B:85:0x02e7), top: B:113:0x0260, outer: #8 }] */
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
                this.mCommonHeader.setSdkVersion(BuildConfig.VERSION_NAME);
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
                    if (getConfiguration().isAdpieSdkLog()) {
                        String str = TAG;
                        AdPieLog.d(str, "packageName:" + packageInfo.packageName);
                        AdPieLog.d(str, "versionName:" + packageInfo.versionName);
                        AdPieLog.d(str, "versionCode:" + packageInfo.versionCode);
                        try {
                            this.mCommonHeader.setUserAgent(System.getProperty("http.agent"));
                        } catch (Exception e) {
                            if (getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.e(TAG, e);
                            }
                        }
                        this.mCommonHeader.setManufacturer(Build.MANUFACTURER);
                        this.mCommonHeader.setModel(Build.MODEL);
                        if (getConfiguration().isAdpieSdkLog()) {
                            String str2 = TAG;
                            AdPieLog.d(str2, "BRAND:" + Build.BRAND);
                            AdPieLog.d(str2, "MANUFACTURER:" + Build.MANUFACTURER);
                            AdPieLog.d(str2, "MODEL:" + Build.MODEL);
                        }
                        try {
                            telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
                            if (getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(TAG, "operationName:" + telephonyManager.getNetworkOperatorName());
                            }
                            this.mCommonHeader.setServiceProvider(telephonyManager.getNetworkOperatorName());
                            if (getConfiguration().isAdpieSdkLog()) {
                                String str3 = TAG;
                                AdPieLog.d(str3, "getNETWORKCountryIso:" + telephonyManager.getNetworkCountryIso());
                                AdPieLog.d(str3, "getSimCountryIso:" + telephonyManager.getSimCountryIso());
                            }
                            this.mCommonHeader.setCountryCode(telephonyManager.getNetworkCountryIso());
                        } catch (Exception e2) {
                            if (getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.e(TAG, e2);
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
                                        if (getConfiguration().isAdpieSdkLog()) {
                                            AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                        }
                                        activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                        if (activityInfoArr != null) {
                                            for (ActivityInfo activityInfo : activityInfoArr) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                                }
                                                if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                    if (getConfiguration().isAdpieSdkLog()) {
                                                        AdPieLog.d(TAG, "Available InAppBrowser!");
                                                    }
                                                    this.mCommonHeader.setAvailableInAppBrowser(true);
                                                }
                                            }
                                        }
                                    } else {
                                        if (getConfiguration().isAdpieSdkLog()) {
                                            AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                        }
                                        activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                        if (activityInfoArr != null) {
                                            while (i < r2) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                                }
                                                if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                    if (getConfiguration().isAdpieSdkLog()) {
                                                        AdPieLog.d(TAG, "Available InAppBrowser!");
                                                    }
                                                    this.mCommonHeader.setAvailableInAppBrowser(true);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (getConfiguration().isAdpieSdkLog()) {
                                        AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isAdpieSdkLog()) {
                                                AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.d(TAG, "Available InAppBrowser!");
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
                                            if (getConfiguration().isAdpieSdkLog()) {
                                                AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                            }
                                            activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                            if (activityInfoArr != null) {
                                                while (i < r2) {
                                                    if (getConfiguration().isAdpieSdkLog()) {
                                                        AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                                    }
                                                    if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                        if (getConfiguration().isAdpieSdkLog()) {
                                                            AdPieLog.d(TAG, "Available InAppBrowser!");
                                                        }
                                                        this.mCommonHeader.setAvailableInAppBrowser(true);
                                                    }
                                                }
                                            }
                                        } else {
                                            try {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                                }
                                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                                if (activityInfoArr != null && activityInfoArr.length > 0) {
                                                    while (i < r2) {
                                                        if (getConfiguration().isAdpieSdkLog()) {
                                                            AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                                        }
                                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                            if (getConfiguration().isAdpieSdkLog()) {
                                                                AdPieLog.d(TAG, "Available InAppBrowser!");
                                                            }
                                                            this.mCommonHeader.setAvailableInAppBrowser(true);
                                                        }
                                                    }
                                                }
                                            } catch (PackageManager.NameNotFoundException e3) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.e(TAG, e3);
                                                }
                                            } catch (Exception e4) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.e(TAG, e4);
                                                }
                                            }
                                        }
                                    } else {
                                        if (getConfiguration().isAdpieSdkLog()) {
                                            AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                        }
                                        activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                        if (activityInfoArr != null) {
                                            while (i < r2) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                                }
                                                if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                    if (getConfiguration().isAdpieSdkLog()) {
                                                        AdPieLog.d(TAG, "Available InAppBrowser!");
                                                    }
                                                    this.mCommonHeader.setAvailableInAppBrowser(true);
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e5) {
                                    if (getConfiguration().isAdpieSdkLog()) {
                                        AdPieLog.e(TAG, e5);
                                    }
                                }
                            }
                        } catch (Exception e6) {
                            if (getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.e(TAG, e6);
                            }
                        }
                    } else {
                        this.mCommonHeader.setUserAgent(System.getProperty("http.agent"));
                        this.mCommonHeader.setManufacturer(Build.MANUFACTURER);
                        this.mCommonHeader.setModel(Build.MODEL);
                        if (getConfiguration().isAdpieSdkLog()) {
                            String str4 = TAG;
                            AdPieLog.d(str4, "BRAND:" + Build.BRAND);
                            AdPieLog.d(str4, "MANUFACTURER:" + Build.MANUFACTURER);
                            AdPieLog.d(str4, "MODEL:" + Build.MODEL);
                        }
                        telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
                        if (getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(TAG, "operationName:" + telephonyManager.getNetworkOperatorName());
                        }
                        this.mCommonHeader.setServiceProvider(telephonyManager.getNetworkOperatorName());
                        if (getConfiguration().isAdpieSdkLog()) {
                            String str5 = TAG;
                            AdPieLog.d(str5, "getNETWORKCountryIso:" + telephonyManager.getNetworkCountryIso());
                            AdPieLog.d(str5, "getSimCountryIso:" + telephonyManager.getSimCountryIso());
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
                                    if (getConfiguration().isAdpieSdkLog()) {
                                        AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isAdpieSdkLog()) {
                                                AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                } else {
                                    if (getConfiguration().isAdpieSdkLog()) {
                                        AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isAdpieSdkLog()) {
                                                AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (getConfiguration().isAdpieSdkLog()) {
                                    AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                }
                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                if (activityInfoArr != null) {
                                    while (i < r2) {
                                        if (getConfiguration().isAdpieSdkLog()) {
                                            AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                        }
                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                            if (getConfiguration().isAdpieSdkLog()) {
                                                AdPieLog.d(TAG, "Available InAppBrowser!");
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
                                    if (getConfiguration().isAdpieSdkLog()) {
                                        AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isAdpieSdkLog()) {
                                                AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                } else {
                                    if (getConfiguration().isAdpieSdkLog()) {
                                        AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                    }
                                    activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                    if (activityInfoArr != null) {
                                        while (i < r2) {
                                            if (getConfiguration().isAdpieSdkLog()) {
                                                AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                            }
                                            if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                                if (getConfiguration().isAdpieSdkLog()) {
                                                    AdPieLog.d(TAG, "Available InAppBrowser!");
                                                }
                                                this.mCommonHeader.setAvailableInAppBrowser(true);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (getConfiguration().isAdpieSdkLog()) {
                                    AdPieLog.d(TAG, "InAppBrowser Name : " + InAppBrowser.class.getName());
                                }
                                activityInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1).activities;
                                if (activityInfoArr != null) {
                                    while (i < r2) {
                                        if (getConfiguration().isAdpieSdkLog()) {
                                            AdPieLog.d(TAG, "Activity Name:" + activityInfo.name);
                                        }
                                        if (!activityInfo.name.contains(InAppBrowser.class.getName())) {
                                            if (getConfiguration().isAdpieSdkLog()) {
                                                AdPieLog.d(TAG, "Available InAppBrowser!");
                                            }
                                            this.mCommonHeader.setAvailableInAppBrowser(true);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e7) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e7);
                    }
                } catch (Exception e8) {
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e8);
                    }
                }
            } catch (Exception e9) {
                if (getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.e(TAG, e9);
                }
            }
        }
        return this.mCommonHeader;
    }

    private AdRequest getRequest(boolean z) {
        if (this.mAdRequest == null) {
            this.mAdRequest = (AdRequest) getCommonHeader().clone();
        }
        try {
            String stringValue = Preference.getStringValue(this.mContext, DataKeys.CONFIG_URL_KEY, "");
            if (!TextUtils.isEmpty(stringValue) && !z) {
                this.mAdRequest.setRequestURL(stringValue, true);
            } else {
                this.mAdRequest.setRequestURL(getConfiguration().getAdpieConfigUrl(), true);
            }
        } catch (Exception unused) {
            this.mAdRequest.setRequestURL(getConfiguration().getAdpieConfigUrl(), true);
        }
        this.mAdRequest.setAppID(getAppId());
        try {
            this.mAdRequest.setAccessDate(Preference.getStringValue(this.mContext, DataKeys.getKeyWithMedia(DataKeys.CONFIG_ACCESS_DATE_KEY, this.mAppID), ""));
        } catch (Exception unused2) {
        }
        return this.mAdRequest;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0144  */
    public int getNetworkConnectionType() {
        try {
            if (this.mContext == null) {
                return 0;
            }
            if (!checkPermission("android.permission.INTERNET")) {
                AdPieLog.d(TAG, "android.permission.INTERNET permission must be added in AndroidManifest.xml!");
                return 0;
            }
            if (!checkPermission("android.permission.ACCESS_NETWORK_STATE")) {
                AdPieLog.d(TAG, "android.permission.ACCESS_NETWORK_STATE permission must be added in AndroidManifest.xml!");
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
                            if (getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.e(TAG, e);
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
                    if (getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(TAG, e2);
                    }
                }
            }
            return 0;
            if (getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
            return 0;
        } catch (Exception e3) {
            if (getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e3);
            }
        }
    }

    public boolean checkPermission(String str) {
        try {
            return this.mContext.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLogging() {
        try {
            if (Preference.getBooleanValue(this.mContext, "LOG_ENABLE", false)) {
                configuration.setAdpieSdkLog(true);
                AdPieLog.setLogEnable(true);
                AdPieLog.setLogLevel(3);
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
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdPieSDK.3
                        @Override // java.lang.Runnable
                        public void run() {
                            WebView webView = new WebView(AdPieSDK.this.mContext);
                            AdPieSDK.this.mUserAgent = webView.getSettings().getUserAgentString();
                            webView.destroy();
                        }
                    });
                }
            } catch (Exception e) {
                AdPieLog.e(TAG, e);
            }
        }
        return this.mUserAgent;
    }
}
