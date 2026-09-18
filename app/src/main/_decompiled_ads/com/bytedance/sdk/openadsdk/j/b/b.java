package com.bytedance.sdk.openadsdk.j.b;

import b.b.a.a.e.r;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.x;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: DoInterstitialWebViewCloseMethod.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends b.b.a.a.e.d<JSONObject, JSONObject> {
    private WeakReference<x> d;

    /* JADX INFO: compiled from: DoInterstitialWebViewCloseMethod.java */
    static class a implements b.b.a.a.e.d.b {
        final /* synthetic */ x a;

        a(x xVar) {
            this.a = xVar;
        }

        @Override // b.b.a.a.e.d.b
        public b.b.a.a.e.d a() {
            return new b(this.a);
        }
    }

    public b(x xVar) {
        this.d = new WeakReference<>(xVar);
    }

    @Override // b.b.a.a.e.d
    protected void f() {
    }

    public static void a(r rVar, x xVar) {
        rVar.a("interstitial_webview_close", new a(xVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.b.a.a.e.d
    public void a(JSONObject jSONObject, b.b.a.a.e.f fVar) throws Exception {
        h.a().p();
        x xVar = this.d.get();
        if (xVar == null) {
            m.b("DoInterstitialWebViewCloseMethod", "invoke error");
            d();
        } else {
            xVar.h();
        }
    }
}
