package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p<T extends com.fyber.inneractive.sdk.response.e> extends q<T> {
    public com.fyber.inneractive.sdk.web.t g;
    public final com.fyber.inneractive.sdk.ignite.j h;

    public p(com.fyber.inneractive.sdk.config.b0 b0Var, com.fyber.inneractive.sdk.config.global.s sVar) {
        super(b0Var, sVar);
        this.h = new a();
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public void a(String str) {
        com.fyber.inneractive.sdk.ignite.k kVar;
        com.fyber.inneractive.sdk.ignite.k kVar2 = com.fyber.inneractive.sdk.ignite.k.NONE;
        T t = this.f927b;
        if (t != null) {
            com.fyber.inneractive.sdk.ignite.k kVar3 = t.F;
            kVar3.getClass();
            kVar = com.fyber.inneractive.sdk.ignite.k.SINGLE_TAP;
            if (!(kVar3 == kVar)) {
                if (!this.f927b.F.e() || isVideoAd()) {
                    kVar = this.f927b.F;
                } else {
                    ((a) this.h).a(com.fyber.inneractive.sdk.network.q.IGNITE_FLOW_MODE_NOT_COMPATIBLE, null, null, null);
                }
            }
        } else {
            kVar = kVar2;
        }
        if (!j()) {
            T t2 = this.f927b;
            if (t2 != null) {
                t2.a(kVar2);
                return;
            }
            return;
        }
        T t3 = this.f927b;
        String str2 = t3 != null ? t3.y : null;
        com.fyber.inneractive.sdk.web.v vVar = new com.fyber.inneractive.sdk.web.v();
        vVar.a = str2;
        vVar.f1372b = kVar;
        vVar.c = str;
        vVar.d = this.c;
        vVar.e = t3 != null ? t3.E : null;
        vVar.f = t3 != null ? t3.G : null;
        vVar.g = this.h;
        com.fyber.inneractive.sdk.web.t tVar = new com.fyber.inneractive.sdk.web.t(vVar);
        this.g = tVar;
        com.fyber.inneractive.sdk.config.global.features.p pVar = (com.fyber.inneractive.sdk.config.global.features.p) this.c.a(com.fyber.inneractive.sdk.config.global.features.p.class);
        if (pVar == null || str2 == null) {
            return;
        }
        String strA = pVar.a("detail_url", "https://cdn2.inner-active.mobi/app-detail-page-v0/[BUNDLE_ID].html");
        tVar.g(strA == null ? "" : strA.replace("[BUNDLE_ID]", str2));
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public com.fyber.inneractive.sdk.web.t c() {
        return this.g;
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public boolean f() {
        com.fyber.inneractive.sdk.web.t tVar = this.g;
        return tVar != null && tVar.l;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0020  */
    @Override // com.fyber.inneractive.sdk.flow.q
    public void i() {
        boolean z;
        T t;
        if (j()) {
            com.fyber.inneractive.sdk.web.t tVar = this.g;
            z = ((tVar != null && tVar.l) || (t = this.f927b) == null || t.F == com.fyber.inneractive.sdk.ignite.k.NONE) ? false : true;
        }
        if (z) {
            IAlog.a("ignite webpage was not loaded yet, stopping the loading process", new Object[0]);
            this.f927b.a(com.fyber.inneractive.sdk.ignite.k.NONE);
            com.fyber.inneractive.sdk.web.t tVar2 = this.g;
            if (tVar2 != null) {
                Runnable runnable = tVar2.p;
                if (runnable != null) {
                    com.fyber.inneractive.sdk.util.m.f1343b.removeCallbacks(runnable);
                    tVar2.p = null;
                }
                if (!tVar2.y) {
                    tVar2.a.stopLoading();
                }
                ((a) this.h).a(com.fyber.inneractive.sdk.network.q.IGNITE_FLOW_FAILED_TO_LOAD_WEBPAGE, this.g.k, com.fyber.inneractive.sdk.ignite.i.WEBPAGE_NOT_LOADED_BEFORE_SHOW.e(), this.f927b.F);
            }
        }
    }

    public final boolean j() {
        com.fyber.inneractive.sdk.ignite.c cVar = IAConfigManager.M.E;
        T t = this.f927b;
        return t != null && t.b() && cVar != null && cVar.d();
    }

    public class a implements com.fyber.inneractive.sdk.ignite.j {
        public a() {
        }

        public void a(com.fyber.inneractive.sdk.network.r rVar, com.fyber.inneractive.sdk.ignite.k kVar) {
            p pVar = p.this;
            InneractiveAdRequest inneractiveAdRequest = pVar.a;
            T t = pVar.f927b;
            com.fyber.inneractive.sdk.config.global.s sVar = pVar.c;
            JSONArray jSONArrayC = sVar != null ? sVar.c() : null;
            com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(t);
            aVar.c = rVar;
            aVar.a = inneractiveAdRequest;
            aVar.d = jSONArrayC;
            JSONObject jSONObject = new JSONObject();
            String strF = kVar.f();
            try {
                jSONObject.put("ignitem", strF);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "ignitem", strF);
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
        }

        public void a(com.fyber.inneractive.sdk.network.q qVar, String str, String str2, com.fyber.inneractive.sdk.ignite.k kVar) {
            p pVar = p.this;
            InneractiveAdRequest inneractiveAdRequest = pVar.a;
            T t = pVar.f927b;
            com.fyber.inneractive.sdk.config.global.s sVar = pVar.c;
            JSONArray jSONArrayC = sVar != null ? sVar.c() : null;
            com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(t);
            aVar.f992b = qVar;
            aVar.a = inneractiveAdRequest;
            aVar.d = jSONArrayC;
            JSONObject jSONObject = new JSONObject();
            if (kVar != null) {
                String strF = kVar.f();
                try {
                    jSONObject.put("ignitem", strF);
                } catch (Exception unused) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "ignitem", strF);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put("message", str);
                } catch (Exception unused2) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "message", str);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONObject.put("error_code", str2);
                } catch (Exception unused3) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "error_code", str2);
                }
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public boolean a(boolean z, com.fyber.inneractive.sdk.util.e eVar) {
        com.fyber.inneractive.sdk.ignite.k kVar;
        T t = this.f927b;
        if (t != null) {
            kVar = t.F;
        } else {
            kVar = com.fyber.inneractive.sdk.ignite.k.NONE;
        }
        return !z && kVar != null && kVar.e() && (eVar == com.fyber.inneractive.sdk.util.e.VIDEO_CTA || eVar == com.fyber.inneractive.sdk.util.e.DEFAULT_ENDCARD);
    }
}
