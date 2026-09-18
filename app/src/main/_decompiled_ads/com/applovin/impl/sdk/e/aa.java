package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class aa extends d {
    protected abstract int KL();

    protected abstract void x(JSONObject jSONObject);

    protected abstract String zJ();

    protected aa(String str, com.applovin.impl.sdk.n nVar) {
        super(str, nVar);
    }

    void a(JSONObject jSONObject, final com.applovin.impl.sdk.network.b.d<JSONObject> dVar) {
        Map<String, String> mapF = com.applovin.impl.sdk.utils.i.F(this.sdk);
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQa)).booleanValue() || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue()) {
            JsonUtils.putAll(jSONObject, mapF);
            mapF = null;
        }
        w<JSONObject> wVar = new w<JSONObject>(com.applovin.impl.sdk.network.c.D(this.sdk).da(com.applovin.impl.sdk.utils.i.c(zJ(), this.sdk)).dc(com.applovin.impl.sdk.utils.i.d(zJ(), this.sdk)).k(mapF).K(jSONObject).db("POST").aU(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQj)).booleanValue()).ad(new JSONObject()).gC(KL()).a(com.applovin.impl.sdk.utils.p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPS)).intValue())).Ie(), this.sdk) { // from class: com.applovin.impl.sdk.e.aa.1
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(JSONObject jSONObject2, int i) {
                dVar.d(jSONObject2, i);
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, JSONObject jSONObject2) {
                dVar.a(i, str, jSONObject2);
            }
        };
        wVar.e(com.applovin.impl.sdk.c.b.aLr);
        wVar.f(com.applovin.impl.sdk.c.b.aLs);
        this.sdk.BM().b(wVar);
    }

    protected JSONObject KM() {
        JSONObject jSONObject = new JSONObject();
        String strBx = this.sdk.Bx();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOp)).booleanValue() && StringUtils.isValidString(strBx)) {
            JsonUtils.putString(jSONObject, "cuid", strBx);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOr)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.sdk.By());
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOt)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.sdk.Bz());
        }
        x(jSONObject);
        return jSONObject;
    }

    protected void gu(int i) {
        com.applovin.impl.sdk.utils.i.b(i, this.sdk);
    }
}
