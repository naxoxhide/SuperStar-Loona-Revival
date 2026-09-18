package com.applovin.impl.privacy.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends e {
    public f(JSONObject jSONObject, n nVar) {
        super(jSONObject, nVar);
    }

    public String getTitle() {
        return cl("title");
    }

    public String getMessage() {
        return cl("message");
    }

    public List<g> Ad() {
        g gVarH;
        JSONArray jSONArray = JsonUtils.getJSONArray(this.axQ, "transitions", null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject != null && (gVarH = g.h(jSONObject, this.sdk)) != null) {
                arrayList.add(gVarH);
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.privacy.a.e
    public String toString() {
        return "ConsentFlowState{id=" + mQ() + "type=" + Aa() + "isInitialState=" + Ac() + "title=" + getTitle() + "message=" + getMessage() + "actions=" + Ad() + "}";
    }
}
