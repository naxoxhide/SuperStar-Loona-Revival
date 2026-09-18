package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.e.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.e;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    private static final Map<String, AppLovinSdk> sdkInstances = new HashMap(1);
    private static final Object sdkInstancesLock = new Object();
    private final n coreSdk;

    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    private static String getVersion() {
        return "12.0.0";
    }

    private static int getVersionCode() {
        return 12000099;
    }

    public void initializeSdk() {
    }

    public String getSdkKey() {
        return this.coreSdk.getSdkKey();
    }

    public AppLovinSdkSettings getSettings() {
        return this.coreSdk.getSettings();
    }

    public void setPluginVersion(String str) {
        this.coreSdk.setPluginVersion(str);
    }

    public void setUserIdentifier(String str) {
        this.coreSdk.cE(str);
    }

    public String getUserIdentifier() {
        return this.coreSdk.Bx();
    }

    public AppLovinUserSegment getUserSegment() {
        return this.coreSdk.getUserSegment();
    }

    public AppLovinTargetingData getTargetingData() {
        return this.coreSdk.BA();
    }

    public AppLovinAdService getAdService() {
        return this.coreSdk.BB();
    }

    public AppLovinEventService getEventService() {
        return this.coreSdk.BD();
    }

    public AppLovinCmpService getCmpService() {
        return this.coreSdk.Cl();
    }

    public AppLovinUserService getUserService() {
        return this.coreSdk.BE();
    }

    public void setMediationProvider(String str) {
        this.coreSdk.setMediationProvider(str);
    }

    public String getMediationProvider() {
        return this.coreSdk.getMediationProvider();
    }

    public List<MaxMediatedNetworkInfo> getAvailableMediatedNetworks() {
        JSONArray jSONArrayF = c.f(this.coreSdk);
        ArrayList arrayList = new ArrayList(jSONArrayF.length());
        for (int i = 0; i < jSONArrayF.length(); i++) {
            arrayList.add(new MaxMediatedNetworkInfoImpl(JsonUtils.getJSONObject(jSONArrayF, i, (JSONObject) null)));
        }
        return arrayList;
    }

    public void showMediationDebugger() {
        this.coreSdk.showMediationDebugger();
    }

    public void showMediationDebugger(Map<String, List<?>> map) {
        this.coreSdk.showMediationDebugger(map);
    }

    public void showCreativeDebugger() {
        this.coreSdk.showCreativeDebugger();
    }

    public boolean isInitialized() {
        return this.coreSdk.isEnabled();
    }

    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.coreSdk.initializeSdk(sdkInitializationListener);
    }

    public static void initializeSdk(Context context) {
        initializeSdk(context, null);
    }

    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        AppLovinSdk appLovinSdk = getInstance(context);
        if (appLovinSdk != null) {
            appLovinSdk.initializeSdk(sdkInitializationListener);
        } else {
            x.H(TAG, "Unable to initialize AppLovin SDK: SDK object not created");
        }
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.coreSdk.getConfiguration();
    }

    public static AppLovinSdk getInstance(Context context) {
        return getInstance(new a(context), context);
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        return getInstance(e.V(context).L("applovin.sdk.key", ""), appLovinSdkSettings, context);
    }

    public static AppLovinSdk getInstance(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        AppLovinSdk appLovinSdk;
        if (appLovinSdkSettings == null) {
            throw new IllegalArgumentException("No userSettings specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        synchronized (sdkInstancesLock) {
            Map<String, AppLovinSdk> map = sdkInstances;
            if (map.containsKey(str)) {
                appLovinSdk = map.get(str);
            } else {
                if (!TextUtils.isEmpty(str) && str.contains(File.separator)) {
                    x.H(TAG, "\n**************************************************\nINVALID SDK KEY: " + str + "\n**************************************************\n");
                    if (!map.isEmpty()) {
                        return map.values().iterator().next();
                    }
                    str = str.replace(File.separator, "");
                }
                n nVar = new n();
                nVar.a(str, appLovinSdkSettings, context);
                AppLovinSdk appLovinSdk2 = new AppLovinSdk(nVar);
                nVar.a(appLovinSdk2);
                appLovinSdkSettings.attachAppLovinSdk(nVar);
                map.put(str, appLovinSdk2);
                appLovinSdk = appLovinSdk2;
            }
            return appLovinSdk;
        }
    }

    public boolean isEnabled() {
        return this.coreSdk.isEnabled();
    }

    private AppLovinSdk(n nVar) {
        this.coreSdk = nVar;
    }

    static void reinitializeAll(Boolean bool, Boolean bool2, Boolean bool3) {
        synchronized (sdkInstancesLock) {
            for (AppLovinSdk appLovinSdk : sdkInstances.values()) {
                appLovinSdk.coreSdk.Bk();
                appLovinSdk.coreSdk.Bs();
                if (bool != null) {
                    appLovinSdk.coreSdk.BL();
                    if (x.Fk()) {
                        appLovinSdk.coreSdk.BL().g(TAG, "Toggled 'huc' to " + bool);
                    }
                    appLovinSdk.getEventService().trackEvent(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, CollectionUtils.map("value", bool.toString()));
                }
                if (bool2 != null) {
                    appLovinSdk.coreSdk.BL();
                    if (x.Fk()) {
                        appLovinSdk.coreSdk.BL().g(TAG, "Toggled 'aru' to " + bool2);
                    }
                    appLovinSdk.getEventService().trackEvent(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, CollectionUtils.map("value", bool2.toString()));
                }
                if (bool3 != null) {
                    appLovinSdk.coreSdk.BL();
                    if (x.Fk()) {
                        appLovinSdk.coreSdk.BL().g(TAG, "Toggled 'dns' to " + bool3);
                    }
                    appLovinSdk.getEventService().trackEvent(AppLovinSdkExtraParameterKey.DO_NOT_SELL, CollectionUtils.map("value", bool3.toString()));
                }
            }
        }
    }

    private static class a extends AppLovinSdkSettings {
        a(Context context) {
            super(context);
        }
    }

    public String toString() {
        return "AppLovinSdk{sdkKey='" + getSdkKey() + "', isEnabled=" + isEnabled() + ", isFirstSession=" + this.coreSdk.CH() + '}';
    }

    public n a() {
        return this.coreSdk;
    }

    @Deprecated
    public AppLovinPostbackService getPostbackService() {
        return this.coreSdk.Cr();
    }
}
