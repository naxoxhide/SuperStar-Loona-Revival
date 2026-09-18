package com.applovin.impl.privacy.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private final JSONObject axQ;
    private final n sdk;

    public enum a {
        NEUTRAL,
        POSITIVE,
        NEGATIVE
    }

    public static g h(JSONObject jSONObject, n nVar) {
        String string = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "title", (JSONObject) null), SDKConstants.PARAM_KEY, null);
        if ("TOS".equalsIgnoreCase(string) && nVar.Cj().getTermsOfServiceUri() == null) {
            return null;
        }
        if ("PP".equalsIgnoreCase(string) && nVar.Cj().getPrivacyPolicyUri() == null) {
            return null;
        }
        return new g(jSONObject, nVar);
    }

    private g(JSONObject jSONObject, n nVar) {
        this.sdk = nVar;
        this.axQ = jSONObject;
    }

    public String getTitle() {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.axQ, "title", (JSONObject) null);
        return n.b(JsonUtils.getString(jSONObject, SDKConstants.PARAM_KEY, ""), (List<String>) JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "replacements", null), null));
    }

    public a Ae() {
        String string = JsonUtils.getString(this.axQ, "style", null);
        if ("default".equalsIgnoreCase(string)) {
            return a.POSITIVE;
        }
        if ("destructive".equalsIgnoreCase(string) || "cancel".equalsIgnoreCase(string)) {
            return a.NEGATIVE;
        }
        return a.NEUTRAL;
    }

    public String Af() {
        return JsonUtils.getString(this.axQ, "destination_state_id", null);
    }

    public String Ag() {
        return JsonUtils.getString(this.axQ, "event", null);
    }

    public String toString() {
        return "ConsentFlowStateAlertAction{title=" + getTitle() + "destinationStateId=" + Af() + "event=" + Ag() + "}";
    }
}
