package com.applovin.impl.privacy.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends e {
    private Map<String, String> ayh;

    public Map<String, String> Ah() {
        return this.ayh;
    }

    public h(JSONObject jSONObject, n nVar) {
        super(jSONObject, nVar);
    }

    public String getName() {
        return JsonUtils.getString(this.axQ, "name", null);
    }

    @Override // com.applovin.impl.privacy.a.e
    public String toString() {
        return "ConsentFlowState{id=" + mQ() + "type=" + Aa() + "isInitialState=" + Ac() + "name=" + getName() + "}";
    }
}
