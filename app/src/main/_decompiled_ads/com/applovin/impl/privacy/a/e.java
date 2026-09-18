package com.applovin.impl.privacy.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    protected final JSONObject axQ;
    protected final n sdk;

    public enum a {
        NONE,
        IS_AL_GDPR
    }

    public enum b {
        ALERT,
        EVENT,
        HAS_USER_CONSENT,
        REINIT,
        CMP_LOAD,
        CMP_SHOW,
        DECISION,
        TERMS_FLOW
    }

    public e(JSONObject jSONObject, n nVar) {
        this.sdk = nVar;
        this.axQ = jSONObject;
    }

    public static e g(JSONObject jSONObject, n nVar) {
        b bVarCj = cj(JsonUtils.getString(jSONObject, "type", null));
        if (bVarCj == b.ALERT) {
            return new f(jSONObject, nVar);
        }
        if (bVarCj == b.EVENT) {
            return new h(jSONObject, nVar);
        }
        return new e(jSONObject, nVar);
    }

    public String mQ() {
        return JsonUtils.getString(this.axQ, "id", null);
    }

    public b Aa() {
        return cj(JsonUtils.getString(this.axQ, "type", null));
    }

    public a Ab() {
        return ck(JsonUtils.getString(this.axQ, "decision_type", null));
    }

    public boolean Ac() {
        return JsonUtils.getBoolean(this.axQ, "is_initial_state", false).booleanValue();
    }

    public String b(Boolean bool) {
        String string = JsonUtils.getString(this.axQ, "destination_state_id", null);
        if (StringUtils.isValidString(string)) {
            return string;
        }
        if (bool != null) {
            return bool.booleanValue() ? JsonUtils.getString(this.axQ, "destination_state_id_true", null) : JsonUtils.getString(this.axQ, "destination_state_id_false", null);
        }
        throw new IllegalStateException("Decision needed for state: " + string);
    }

    private static b cj(String str) {
        if ("alert".equalsIgnoreCase(str)) {
            return b.ALERT;
        }
        if ("event".equalsIgnoreCase(str)) {
            return b.EVENT;
        }
        if ("cmp_load".equalsIgnoreCase(str)) {
            return b.CMP_LOAD;
        }
        if ("cmp_show".equalsIgnoreCase(str)) {
            return b.CMP_SHOW;
        }
        if ("decision".equalsIgnoreCase(str)) {
            return b.DECISION;
        }
        if ("terms_flow".equalsIgnoreCase(str)) {
            return b.TERMS_FLOW;
        }
        if (AppLovinSdkExtraParameterKey.HAS_USER_CONSENT.equalsIgnoreCase(str)) {
            return b.HAS_USER_CONSENT;
        }
        if ("reinit".equalsIgnoreCase(str)) {
            return b.REINIT;
        }
        throw new IllegalArgumentException("Invalid type provided: " + str);
    }

    private static a ck(String str) {
        if ("is_al_gdpr".equalsIgnoreCase(str)) {
            return a.IS_AL_GDPR;
        }
        return a.NONE;
    }

    protected String cl(String str) {
        String name;
        JSONObject jSONObject = JsonUtils.getJSONObject(this.axQ, str, (JSONObject) null);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "replacements", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = JsonUtils.getObjectAtIndex(jSONArray, i, "").toString();
            if ("<APP_NAME>".equalsIgnoreCase(string)) {
                if (this.sdk.BT() != null) {
                    name = this.sdk.BS().Eg().getName();
                } else {
                    name = (String) this.sdk.BQ().CR().get(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                }
                if (StringUtils.isValidString(name)) {
                    arrayList.add(name);
                } else {
                    arrayList.add(n.cl("THIS_APP"));
                }
            } else {
                arrayList.add(string);
            }
        }
        return n.b(JsonUtils.getString(jSONObject, SDKConstants.PARAM_KEY, null), arrayList);
    }

    public String toString() {
        return "ConsentFlowState{id=" + mQ() + "type=" + Aa() + "isInitialState=" + Ac() + "}";
    }
}
