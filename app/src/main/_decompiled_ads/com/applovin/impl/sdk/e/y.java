package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class y extends aa {
    protected abstract void y(JSONObject jSONObject);

    protected abstract com.applovin.impl.sdk.b.c yg();

    protected abstract void zK();

    protected y(String str, com.applovin.impl.sdk.n nVar) {
        super(str, nVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.applovin.impl.sdk.b.c cVarYg = yg();
        if (cVarYg != null) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Reporting pending reward: " + cVarYg + "...");
            }
            a(c(cVarYg), new com.applovin.impl.sdk.network.b.d<JSONObject>() { // from class: com.applovin.impl.sdk.e.y.1
                @Override // com.applovin.impl.sdk.network.b.d
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void d(JSONObject jSONObject, int i) {
                    y.this.y(jSONObject);
                }

                @Override // com.applovin.impl.sdk.network.b.d
                public void a(int i, String str, JSONObject jSONObject) {
                    y.this.gu(i);
                }
            });
            return;
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "Pending reward not found");
        }
        zK();
    }

    @Override // com.applovin.impl.sdk.e.aa
    protected int KL() {
        return ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMb)).intValue();
    }

    private JSONObject c(com.applovin.impl.sdk.b.c cVar) {
        JSONObject jSONObjectKM = KM();
        JsonUtils.putString(jSONObjectKM, "result", cVar.JA());
        Map<String, String> mapJz = cVar.Jz();
        if (mapJz != null) {
            JsonUtils.putJSONObject(jSONObjectKM, "params", new JSONObject(mapJz));
        }
        return jSONObjectKM;
    }
}
