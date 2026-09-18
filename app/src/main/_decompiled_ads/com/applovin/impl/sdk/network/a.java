package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.sdk.e.d {
    private final c<JSONObject> aHh;
    private final String aoK;

    public a(String str, c<JSONObject> cVar, n nVar) {
        super("CommunicatorRequestTask", nVar, str);
        this.aoK = str;
        this.aHh = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.sdk.BM().b(new w<JSONObject>(this.aHh, this.sdk, Kf()) { // from class: com.applovin.impl.sdk.network.a.1
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(JSONObject jSONObject, int i) {
                this.sdk.Cf().a(a.this.aoK, a.this.aHh.zJ(), i, jSONObject, null, true);
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, JSONObject jSONObject) {
                this.sdk.Cf().a(a.this.aoK, a.this.aHh.zJ(), i, jSONObject, str, false);
            }
        });
    }
}
