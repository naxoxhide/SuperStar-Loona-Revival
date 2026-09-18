package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private final String aop;
    private final f aoq;
    private final List<e> aor;
    private final List<e> aos;
    private boolean aot = false;
    private final String name;

    b(JSONObject jSONObject, Map<String, com.applovin.impl.mediation.debugger.b.c.b> map, MaxAdFormat maxAdFormat, n nVar) {
        this.name = JsonUtils.getString(jSONObject, "name", "");
        this.aop = JsonUtils.getString(jSONObject, "experiment", null);
        this.aoq = d(jSONObject);
        this.aor = a("bidders", jSONObject, map, maxAdFormat, nVar);
        this.aos = a("waterfall", jSONObject, map, maxAdFormat, nVar);
    }

    public String getName() {
        return this.name;
    }

    public String uJ() {
        return this.aop;
    }

    public f uK() {
        return this.aoq;
    }

    public List<e> uL() {
        return this.aor;
    }

    public List<e> uM() {
        return this.aos;
    }

    public boolean uN() {
        return this.aot;
    }

    private f d(JSONObject jSONObject) {
        return new f(JsonUtils.getJSONObject(jSONObject, "targeting"));
    }

    private List<e> a(String str, JSONObject jSONObject, Map<String, com.applovin.impl.mediation.debugger.b.c.b> map, MaxAdFormat maxAdFormat, n nVar) {
        com.applovin.impl.mediation.debugger.b.c.b bVar;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, str, new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null && (bVar = map.get(JsonUtils.getString(jSONObject2, "adapter_class", ""))) != null) {
                if (bVar.uN()) {
                    this.aot = true;
                }
                arrayList.add(new e(jSONObject2, maxAdFormat, bVar, nVar));
            }
        }
        return arrayList;
    }
}
