package com.applovin.impl.mediation.b;

import android.os.Bundle;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private final JSONObject adObject;
    private String amL;
    private String amQ;
    private final JSONObject fullResponse;
    private final Map<String, Object> localExtraParameters;
    protected final n sdk;
    private final Object adObjectLock = new Object();
    private final Object fullResponseLock = new Object();

    public f(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        }
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        }
        this.sdk = nVar;
        this.fullResponse = jSONObject2;
        this.adObject = jSONObject;
        this.localExtraParameters = map;
    }

    public JSONObject yx() {
        JSONObject jSONObject;
        synchronized (this.fullResponseLock) {
            jSONObject = this.fullResponse;
        }
        return jSONObject;
    }

    protected boolean bW(String str) {
        boolean zHas;
        synchronized (this.fullResponseLock) {
            zHas = this.fullResponse.has(str);
        }
        return zHas;
    }

    protected Boolean a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.fullResponseLock) {
            bool2 = JsonUtils.getBoolean(this.fullResponse, str, bool);
        }
        return bool2;
    }

    protected int getIntFromFullResponse(String str, int i) {
        int i2;
        synchronized (this.fullResponseLock) {
            i2 = JsonUtils.getInt(this.fullResponse, str, i);
        }
        return i2;
    }

    protected JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.fullResponseLock) {
            jSONArray2 = JsonUtils.getJSONArray(this.fullResponse, str, jSONArray);
        }
        return jSONArray2;
    }

    protected long getLongFromFullResponse(String str, long j) {
        long j2;
        synchronized (this.fullResponseLock) {
            j2 = JsonUtils.getLong(this.fullResponse, str, j);
        }
        return j2;
    }

    protected String getStringFromFullResponse(String str, String str2) {
        String string;
        synchronized (this.fullResponseLock) {
            string = JsonUtils.getString(this.fullResponse, str, str2);
        }
        return string;
    }

    protected JSONObject yy() {
        JSONObject jSONObject;
        synchronized (this.adObjectLock) {
            jSONObject = this.adObject;
        }
        return jSONObject;
    }

    protected boolean bX(String str) {
        boolean zHas;
        synchronized (this.adObjectLock) {
            zHas = this.adObject.has(str);
        }
        return zHas;
    }

    protected Boolean b(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.adObjectLock) {
            bool2 = JsonUtils.getBoolean(this.adObject, str, bool);
        }
        return bool2;
    }

    protected float getFloatFromAdObject(String str, float f) {
        float f2;
        synchronized (this.adObjectLock) {
            f2 = JsonUtils.getFloat(this.adObject, str, f);
        }
        return f2;
    }

    protected double a(String str, float f) {
        double d;
        synchronized (this.adObjectLock) {
            d = JsonUtils.getDouble(this.adObject, str, f);
        }
        return d;
    }

    protected int getIntFromAdObject(String str, int i) {
        int i2;
        synchronized (this.adObjectLock) {
            i2 = JsonUtils.getInt(this.adObject, str, i);
        }
        return i2;
    }

    protected JSONArray b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.adObjectLock) {
            jSONArray2 = JsonUtils.getJSONArray(this.adObject, str, jSONArray);
        }
        return jSONArray2;
    }

    protected JSONObject getJsonObjectFromAdObject(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.adObjectLock) {
            jSONObject2 = JsonUtils.getJSONObject(this.adObject, str, jSONObject);
        }
        return jSONObject2;
    }

    protected long getLongFromAdObject(String str, long j) {
        long j2;
        synchronized (this.adObjectLock) {
            j2 = JsonUtils.getLong(this.adObject, str, j);
        }
        return j2;
    }

    protected Object bY(String str) {
        Object objOpt;
        synchronized (this.adObjectLock) {
            objOpt = this.adObject.opt(str);
        }
        return objOpt;
    }

    protected String getStringFromAdObject(String str, String str2) {
        String string;
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, str, str2);
        }
        return string;
    }

    protected void d(String str, int i) {
        synchronized (this.adObjectLock) {
            JsonUtils.putInt(this.adObject, str, i);
        }
    }

    protected void e(String str, long j) {
        synchronized (this.adObjectLock) {
            JsonUtils.putLong(this.adObject, str, j);
        }
    }

    protected void x(String str, String str2) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, str, str2);
        }
    }

    protected void a(String str, Object obj) {
        synchronized (this.adObjectLock) {
            JsonUtils.putObject(this.adObject, str, obj);
        }
    }

    public String getAdUnitId() {
        return getStringFromFullResponse("ad_unit_id", "");
    }

    public String vt() {
        return getStringFromAdObject("class", null);
    }

    public String yz() {
        return getStringFromAdObject("name", null);
    }

    public String yA() {
        return yz().split("_")[0];
    }

    public boolean isTesting() {
        return b("is_testing", (Boolean) false).booleanValue();
    }

    public Boolean hasUserConsent() {
        String str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT);
        if (StringUtils.isValidString(str)) {
            return Boolean.valueOf(str);
        }
        if (bX(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT)) {
            return b(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, (Boolean) false);
        }
        return a(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, (Boolean) null);
    }

    public Boolean isAgeRestrictedUser() {
        String str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER);
        if (StringUtils.isValidString(str)) {
            return Boolean.valueOf(str);
        }
        if (bX(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER)) {
            return b(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, (Boolean) false);
        }
        return a(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, (Boolean) null);
    }

    public Boolean isDoNotSell() {
        String str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.DO_NOT_SELL);
        if (StringUtils.isValidString(str)) {
            return Boolean.valueOf(str);
        }
        if (bX(AppLovinSdkExtraParameterKey.DO_NOT_SELL)) {
            return b(AppLovinSdkExtraParameterKey.DO_NOT_SELL, (Boolean) false);
        }
        return a(AppLovinSdkExtraParameterKey.DO_NOT_SELL, (Boolean) null);
    }

    public String getConsentString() {
        if (bX("consent_string")) {
            return getStringFromAdObject("consent_string", null);
        }
        if (bW("consent_string")) {
            return getStringFromFullResponse("consent_string", null);
        }
        return this.sdk.Ck().Aq();
    }

    public boolean yB() {
        return b("run_on_ui_thread", (Boolean) true).booleanValue();
    }

    public Map<String, Object> getLocalExtraParameters() {
        return this.localExtraParameters;
    }

    public Bundle getServerParameters() {
        Bundle bundle;
        if (bY("server_parameters") instanceof JSONObject) {
            bundle = JsonUtils.toBundle(getJsonObjectFromAdObject("server_parameters", null));
        } else {
            bundle = new Bundle();
        }
        int iYC = yC();
        if (iYC != -1) {
            if (iYC == 2) {
                bundle.putBoolean("is_muted", this.sdk.getSettings().isMuted());
            } else {
                bundle.putBoolean("is_muted", iYC == 0);
            }
        }
        if (!bundle.containsKey("amount")) {
            bundle.putLong("amount", getLongFromFullResponse("amount", 0L));
        }
        if (!bundle.containsKey("currency")) {
            bundle.putString("currency", getStringFromFullResponse("currency", ""));
        }
        return bundle;
    }

    public Bundle getCustomParameters() {
        return BundleUtils.getBundle("custom_parameters", new Bundle(), getServerParameters());
    }

    private int yC() {
        return getIntFromAdObject("mute_state", getIntFromFullResponse("mute_state", ((Integer) this.sdk.a(com.applovin.impl.sdk.c.a.aJO)).intValue()));
    }

    public long yD() {
        return getLongFromAdObject("adapter_timeout_ms", ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJk)).longValue());
    }

    public long yE() {
        return getLongFromAdObject("init_completion_delay_ms", -1L);
    }

    public void setPlacement(String str) {
        this.amL = str;
    }

    public String getPlacement() {
        return this.amL;
    }

    public void setCustomData(String str) {
        this.amQ = str;
    }

    public String yF() {
        return this.amQ;
    }

    public List<String> bZ(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        List listOptList = JsonUtils.optList(a(str, new JSONArray()), Collections.EMPTY_LIST);
        List listOptList2 = JsonUtils.optList(b(str, new JSONArray()), Collections.EMPTY_LIST);
        ArrayList arrayList = new ArrayList(listOptList.size() + listOptList2.size());
        arrayList.addAll(listOptList);
        arrayList.addAll(listOptList2);
        return arrayList;
    }

    public String ca(String str) {
        String stringFromAdObject = getStringFromAdObject(str, "");
        return StringUtils.isValidString(stringFromAdObject) ? stringFromAdObject : getStringFromFullResponse(str, "");
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + vt() + "', adapterName='" + yz() + "', isTesting=" + isTesting() + '}';
    }
}
