package com.adxcorp.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.DataKeys;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.gdpr.GoogleMobileAdsConsentManager;
import com.adxcorp.gdpr.SendSDKVersionTask;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.ump.FormError;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class ADXSdk {
    private static final String TAG = "ADXSdk";
    private static final ADXSdk ourInstance = new ADXSdk();
    private final AtomicBoolean isAdNetworkInitializeCalled = new AtomicBoolean(false);
    private String mAppId;
    private Context mContext;
    private ADXConfiguration.GdprType mGdprType;
    private OnInitializedListener mInitializedListener;
    private boolean mIsInitialized;
    private List<String> mTestDeviceIds;

    public interface OnInitializedListener {
        void onCompleted(boolean z, ADXGDPR.ADXConsentState aDXConsentState);
    }

    private ADXSdk() {
        ADXLogUtil.d(TAG, "ADX SDK instance is created.");
    }

    public static ADXSdk getInstance() {
        return ourInstance;
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public synchronized void initialize(Context context, ADXConfiguration aDXConfiguration) {
        initialize(context, aDXConfiguration, null);
    }

    public synchronized void initialize(Context context, ADXConfiguration aDXConfiguration, OnInitializedListener onInitializedListener) {
        String str = TAG;
        Log.d(str, ":::ADX Library Initialize:::" + ADXGDPR.ADX_SDK_VERSION);
        this.mContext = context;
        this.mAppId = aDXConfiguration.getAppId();
        this.mGdprType = aDXConfiguration.getGdprType();
        this.mTestDeviceIds = aDXConfiguration.getTestDeviceIds();
        this.mInitializedListener = onInitializedListener;
        if (context == null) {
            Log.e(str, "Context cannot be null.");
            OnInitializedListener onInitializedListener2 = this.mInitializedListener;
            if (onInitializedListener2 != null) {
                onInitializedListener2.onCompleted(false, ADXGDPR.ADXConsentState.ADXConsentStateUnknown);
            }
            return;
        }
        Log.d(str, ":::ADX App ID :" + this.mAppId);
        if (TextUtils.isEmpty(this.mAppId)) {
            Log.e(str, "AppId cannot be null.");
            OnInitializedListener onInitializedListener3 = this.mInitializedListener;
            if (onInitializedListener3 != null) {
                onInitializedListener3.onCompleted(false, ADXGDPR.ADXConsentState.ADXConsentStateUnknown);
            }
            return;
        }
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adNetworkInitialize() {
        if (this.isAdNetworkInitializeCalled.getAndSet(true)) {
            return;
        }
        try {
            Bundle bundle = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128).metaData;
            String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
            String str = TAG;
            Log.d(str, ":::AdMob App ID : " + string);
            if (!TextUtils.isEmpty(string)) {
                MobileAds.initialize(this.mContext, new OnInitializationCompleteListener() { // from class: com.adxcorp.ads.ADXSdk.1
                    @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                        Log.d(ADXSdk.TAG, ":::AdMob initialization completed:::" + initializationStatus);
                        try {
                            MobileAds.setAppMuted(true);
                        } catch (Exception unused) {
                        }
                    }
                });
            }
            String string2 = bundle.getString("applovin.sdk.key");
            Log.d(str, ":::AppLovin SDK Key : " + string2);
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            try {
                Class.forName("com.applovin.sdk.AppLovinSdk");
                AppLovinSdkSettings settings = AppLovinSdk.getInstance(this.mContext).getSettings();
                String stringValue = Preference.getStringValue(this.mContext, DataKeys.APPLOVIN_DISABLE_PRECACHE, "");
                ADXLogUtil.d(str, "disablePrecache : " + stringValue);
                if (!TextUtils.isEmpty(stringValue)) {
                    settings.setExtraParameter("disable_b2b_ad_unit_ids", stringValue);
                }
                settings.setCreativeDebuggerEnabled(false);
                settings.setMuted(true);
                settings.setLocationCollectionEnabled(false);
                AppLovinSdk.getInstance(this.mContext).setMediationProvider("max");
                AppLovinSdk.getInstance(this.mContext).initializeSdk(new AppLovinSdk.SdkInitializationListener() { // from class: com.adxcorp.ads.ADXSdk.2
                    @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
                    public void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                        Log.d(ADXSdk.TAG, ":::AppLovin initialization completed:::" + appLovinSdkConfiguration);
                    }
                });
            } catch (ClassNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException e) {
            ADXLogUtil.d(TAG, e.getMessage());
        } catch (Exception e2) {
            ADXLogUtil.d(TAG, e2.getMessage());
        }
    }

    private void initialize() {
        if (this.mGdprType != ADXConfiguration.GdprType.POPUP_LOCATION && this.mGdprType != ADXConfiguration.GdprType.POPUP_DEBUG) {
            adNetworkInitialize();
        }
        MediationSDK.getInstance().initialize(this.mContext, this.mAppId);
        this.mIsInitialized = true;
        switch (AnonymousClass6.$SwitchMap$com$adxcorp$ads$ADXConfiguration$GdprType[this.mGdprType.ordinal()]) {
            case 1:
                initWithShowUmpConsent(false);
                break;
            case 2:
                initWithShowUmpConsent(true);
                break;
            case 3:
                initWithSaveGDPRState(ADXGDPR.ADXConsentState.ADXConsentStateUnknown);
                break;
            case 4:
                initWithSaveGDPRState(ADXGDPR.ADXConsentState.ADXConsentStateNotRequired);
                break;
            case 5:
                initWithSaveGDPRState(ADXGDPR.ADXConsentState.ADXConsentStateDenied);
                break;
            case 6:
                initWithSaveGDPRState(ADXGDPR.ADXConsentState.ADXConsentStateConfirm);
                break;
            default:
                OnInitializedListener onInitializedListener = this.mInitializedListener;
                if (onInitializedListener != null) {
                    onInitializedListener.onCompleted(false, ADXGDPR.ADXConsentState.ADXConsentStateUnknown);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: com.adxcorp.ads.ADXSdk$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$adxcorp$ads$ADXConfiguration$GdprType;

        static {
            int[] iArr = new int[ADXConfiguration.GdprType.values().length];
            $SwitchMap$com$adxcorp$ads$ADXConfiguration$GdprType = iArr;
            try {
                iArr[ADXConfiguration.GdprType.POPUP_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$ADXConfiguration$GdprType[ADXConfiguration.GdprType.POPUP_DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$ADXConfiguration$GdprType[ADXConfiguration.GdprType.DIRECT_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$ADXConfiguration$GdprType[ADXConfiguration.GdprType.DIRECT_NOT_REQUIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$ADXConfiguration$GdprType[ADXConfiguration.GdprType.DIRECT_DENIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$ADXConfiguration$GdprType[ADXConfiguration.GdprType.DIRECT_CONFIRM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String getAppId() {
        return this.mAppId;
    }

    private void initWithShowUmpConsent(boolean z) {
        String str = TAG;
        Log.d(str, "ADXLibrary Android ver - " + ADXGDPR.ADX_SDK_VERSION);
        Log.d(str, "Call initWithShowUmpConsent");
        Context context = this.mContext;
        if (context == null || !(context instanceof Activity)) {
            Log.e(str, "An Activity Context is required.");
            adNetworkInitialize();
            OnInitializedListener onInitializedListener = this.mInitializedListener;
            if (onInitializedListener != null) {
                onInitializedListener.onCompleted(false, ADXGDPR.ADXConsentState.ADXConsentStateUnknown);
                return;
            }
            return;
        }
        GoogleMobileAdsConsentManager.getInstance(context).gatherConsent((Activity) this.mContext, z, this.mTestDeviceIds, new GoogleMobileAdsConsentManager.OnConsentGatheringCompleteListener() { // from class: com.adxcorp.ads.ADXSdk.3
            @Override // com.adxcorp.gdpr.GoogleMobileAdsConsentManager.OnConsentGatheringCompleteListener
            public void consentGatheringComplete(FormError formError) {
                int consentStatus = GoogleMobileAdsConsentManager.getInstance(ADXSdk.this.mContext).getConsentStatus();
                ADXLogUtil.d(ADXSdk.TAG, "consentGatheringComplete : " + formError);
                if (formError != null) {
                    Log.w(ADXSdk.TAG, String.format("consentGatheringComplete (Error) %s: %s", Integer.valueOf(formError.getErrorCode()), formError.getMessage()));
                }
                ADXGDPR.ADXConsentState aDXConsentState = ADXGDPR.ADXConsentState.ADXConsentStateUnknown;
                if (consentStatus == 1) {
                    aDXConsentState = ADXGDPR.ADXConsentState.ADXConsentStateNotRequired;
                } else if (consentStatus == 3) {
                    try {
                        String string = PreferenceManager.getDefaultSharedPreferences(ADXSdk.this.mContext).getString("IABTCF_PurposeConsents", "");
                        Log.d(ADXSdk.TAG, "purposeConsents : " + string);
                        if (!TextUtils.isEmpty(string)) {
                            if (string.length() >= 10 && !string.contains("0")) {
                                aDXConsentState = ADXGDPR.ADXConsentState.ADXConsentStateConfirm;
                            } else if (string.equals("0")) {
                                aDXConsentState = ADXGDPR.ADXConsentState.ADXConsentStateDenied;
                            } else {
                                aDXConsentState = ADXGDPR.ADXConsentState.ADXConsentStateDenied;
                            }
                        } else {
                            aDXConsentState = ADXGDPR.ADXConsentState.ADXConsentStateUnknown;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        Class.forName("com.applovin.sdk.AppLovinPrivacySettings");
                        if (aDXConsentState == ADXGDPR.ADXConsentState.ADXConsentStateDenied) {
                            AppLovinPrivacySettings.setHasUserConsent(false, ADXSdk.this.mContext);
                        } else {
                            AppLovinPrivacySettings.setHasUserConsent(true, ADXSdk.this.mContext);
                        }
                    } catch (ClassNotFoundException unused) {
                    }
                }
                ADXSdk.this.adNetworkInitialize();
                ADXGdprManager.saveResultGDPR(ADXSdk.this.mContext, aDXConsentState);
                if (ADXSdk.this.mInitializedListener != null) {
                    ADXSdk.this.mInitializedListener.onCompleted(ADXSdk.this.mIsInitialized, aDXConsentState);
                }
            }
        });
        new SendSDKVersionTask().execute(this.mContext);
    }

    private void initWithShowAdxConsent(boolean z) {
        Context context = this.mContext;
        if (context == null || !(context instanceof Activity)) {
            Log.e(TAG, "An Activity Context is required.");
            OnInitializedListener onInitializedListener = this.mInitializedListener;
            if (onInitializedListener != null) {
                onInitializedListener.onCompleted(false, ADXGDPR.ADXConsentState.ADXConsentStateUnknown);
                return;
            }
            return;
        }
        ADXGdprManager.initWithShowAdxConsent((Activity) context, z, new ADXGDPR.ADXConsentListener() { // from class: com.adxcorp.ads.ADXSdk.4
            @Override // com.adxcorp.gdpr.ADXGDPR.ADXConsentListener
            public void onResult(ADXGDPR.ADXConsentState aDXConsentState) {
                if (ADXSdk.this.mInitializedListener != null) {
                    ADXSdk.this.mInitializedListener.onCompleted(ADXSdk.this.mIsInitialized, aDXConsentState);
                }
            }
        });
    }

    private void initWithSaveGDPRState(ADXGDPR.ADXConsentState aDXConsentState) {
        ADXGdprManager.initWithSaveGDPRState(this.mContext, aDXConsentState, new ADXGDPR.ADXConsentListener() { // from class: com.adxcorp.ads.ADXSdk.5
            @Override // com.adxcorp.gdpr.ADXGDPR.ADXConsentListener
            public void onResult(ADXGDPR.ADXConsentState aDXConsentState2) {
                if (ADXSdk.this.mInitializedListener != null) {
                    ADXSdk.this.mInitializedListener.onCompleted(ADXSdk.this.mIsInitialized, aDXConsentState2);
                }
            }
        });
    }
}
