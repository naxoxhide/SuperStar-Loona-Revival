package com.applovin.sdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.privacy.a.c;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.sdk.AppLovinSdkSettingsBase;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinSdkSettings extends AppLovinSdkSettingsBase {
    private boolean aZm;
    private String aZr;
    private String abm;
    private boolean it;
    private n sdk;
    private boolean aZq = true;
    private final Map<String, Object> localSettings = new HashMap();
    private final Map<String, String> metaData = new HashMap();
    private List<String> aZs = Collections.emptyList();
    private List<String> aZt = Collections.emptyList();
    private final Map<String, String> extraParameters = new HashMap();
    private final Object aZu = new Object();
    private boolean aZn = true;
    private boolean aZo = true;
    private boolean aZp = true;

    public interface TermsAndPrivacyPolicyFlowSettings extends TermsFlowSettings {
        AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography();

        void setDebugUserGeography(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography);
    }

    public interface TermsFlowSettings {
        Uri getPrivacyPolicyUri();

        Uri getTermsOfServiceUri();

        boolean isEnabled();

        void setEnabled(boolean z);

        void setPrivacyPolicyUri(Uri uri);

        void setTermsOfServiceUri(Uri uri);
    }

    public AppLovinSdkSettings(Context context) {
        this.abm = "";
        if (context == null) {
            x.H("AppLovinSdkSettings", "context cannot be null. Please provide a valid context.");
        }
        Context contextAl = u.al(context);
        this.aZm = u.ac(contextAl);
        this.backingConsentFlowSettings = c.D(contextAl);
        this.abm = contextAl.getPackageName();
        an(contextAl);
    }

    public TermsAndPrivacyPolicyFlowSettings getTermsAndPrivacyPolicyFlowSettings() {
        ((d) this.backingConsentFlowSettings).a(d.a.UNIFIED);
        return this.backingConsentFlowSettings;
    }

    public void setTestDeviceAdvertisingIds(List<String> list) {
        x.logApiCall("AppLovinSdkSettings", "setTestDeviceAdvertisingIds(testDeviceAdvertisingIds=" + list + ")");
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                if (str != null && str.length() == 36) {
                    arrayList.add(str);
                } else {
                    x.H("AppLovinSdkSettings", "Unable to set test device advertising id (" + str + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
                }
            }
            this.aZs = arrayList;
            return;
        }
        this.aZs = Collections.emptyList();
    }

    public List<String> getTestDeviceAdvertisingIds() {
        return this.aZs;
    }

    public void setInitializationAdUnitIds(List<String> list) {
        x.logApiCall("AppLovinSdkSettings", "setInitializationAdUnitIds(initializationAdUnitIds=" + list + ")");
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                if (StringUtils.isValidString(str) && str.length() > 0) {
                    if (str.length() == 16) {
                        arrayList.add(str);
                    } else {
                        x.H("AppLovinSdkSettings", "Unable to set initialization ad unit id (" + str + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                    }
                }
            }
            this.aZt = arrayList;
            return;
        }
        this.aZt = Collections.emptyList();
    }

    public List<String> getInitializationAdUnitIds() {
        return this.aZt;
    }

    public void setVerboseLogging(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setVerboseLogging(isVerboseLoggingEnabled=" + z + ")");
        if (u.Lu()) {
            x.H("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already.");
            if (u.ac(null) != z) {
                x.H("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
                return;
            }
            return;
        }
        this.aZm = z;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.aZm;
    }

    public boolean isMuted() {
        return this.it;
    }

    public void setMuted(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setMuted(muted=" + z + ")");
        this.it = z;
    }

    public void setCreativeDebuggerEnabled(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setCreativeDebuggerEnabled(creativeDebuggerEnabled=" + z + ")");
        if (this.aZn == z) {
            return;
        }
        this.aZn = z;
        n nVar = this.sdk;
        if (nVar == null) {
            return;
        }
        if (z) {
            nVar.Cm().tv();
        } else {
            nVar.Cm().tw();
        }
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.aZn;
    }

    public void setExceptionHandlerEnabled(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setExceptionHandlerEnabled(exceptionHandlerEnabled=" + z + ")");
        this.aZo = z;
    }

    public boolean isExceptionHandlerEnabled() {
        return this.aZo;
    }

    public void setLocationCollectionEnabled(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setLocationCollectionEnabled(locationCollectionEnabled=" + z + ")");
        this.aZp = z;
    }

    public boolean isLocationCollectionEnabled() {
        return this.aZp;
    }

    public Map<String, String> getExtraParameters() {
        Map<String, String> map;
        synchronized (this.aZu) {
            map = CollectionUtils.map(this.extraParameters);
        }
        return map;
    }

    public void setExtraParameter(String str, String str2) {
        x.logApiCall("AppLovinSdkSettings", "setExtraParameter(key=" + str + ", value=" + str2 + ")");
        if (TextUtils.isEmpty(str)) {
            x.H("AppLovinSdkSettings", "Failed to set extra parameter for null or empty key: " + str);
            return;
        }
        String strTrim = str2 != null ? str2.trim() : null;
        if ("test_mode_network".equalsIgnoreCase(str)) {
            if (this.sdk != null) {
                if (StringUtils.isValidString(strTrim)) {
                    this.sdk.CC().C(Arrays.asList(strTrim.split(",")));
                } else {
                    this.sdk.CC().bT(null);
                }
            } else {
                this.aZr = strTrim;
            }
        } else if ((AppLovinSdkExtraParameterKey.FILTER_AD_NETWORK.equals(str) || AppLovinSdkExtraParameterKey.ENABLE_SEQUENTIAL_CACHING.equals(str)) && !this.abm.startsWith("com.unity.")) {
            return;
        }
        synchronized (this.aZu) {
            this.extraParameters.put(str, strTrim);
        }
    }

    public void setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(shouldFailAdDisplayIfDontKeepActivitiesIsEnabled=" + z + ")");
        this.aZq = z;
    }

    public boolean shouldFailAdDisplayIfDontKeepActivitiesIsEnabled() {
        return this.aZq;
    }

    protected void attachAppLovinSdk(n nVar) {
        this.sdk = nVar;
        if (StringUtils.isValidString(this.aZr)) {
            nVar.CC().C(Arrays.asList(this.aZr.split(",")));
            this.aZr = null;
        }
    }

    private void an(Context context) {
        int identifier = context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName());
        if (identifier == 0) {
            return;
        }
        String strA = u.a(identifier, context, (n) null);
        Map<String, String> mapTryToStringMap = JsonUtils.tryToStringMap(StringUtils.isValidString(strA) ? JsonUtils.jsonObjectFromJsonString(strA, new JSONObject()) : new JSONObject());
        synchronized (this.aZu) {
            this.extraParameters.putAll(mapTryToStringMap);
        }
    }

    @Deprecated
    public TermsFlowSettings getTermsFlowSettings() {
        ((d) this.backingConsentFlowSettings).a(d.a.TERMS);
        return this.backingConsentFlowSettings;
    }

    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.aZm + ", muted=" + this.it + ", testDeviceAdvertisingIds=" + this.aZs.toString() + ", initializationAdUnitIds=" + this.aZt.toString() + ", creativeDebuggerEnabled=" + this.aZn + ", exceptionHandlerEnabled=" + this.aZo + ", locationCollectionEnabled=" + this.aZp + '}';
    }
}
