package com.bytedance.sdk.openadsdk.j.b;

import b.b.a.a.e.r;
import com.bytedance.sdk.openadsdk.core.x;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: DoGetAdsFromNetworkAsyncMethod.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends b.b.a.a.e.d<JSONObject, JSONObject> {
    private WeakReference<x> d;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.j.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DoGetAdsFromNetworkAsyncMethod.java */
    static class C0238a implements b.b.a.a.e.d.b {
        final /* synthetic */ x a;

        C0238a(x xVar) {
            this.a = xVar;
        }

        @Override // b.b.a.a.e.d.b
        public b.b.a.a.e.d a() {
            return new a(this.a);
        }
    }

    /* JADX INFO: compiled from: DoGetAdsFromNetworkAsyncMethod.java */
    class b implements com.bytedance.sdk.openadsdk.k.c {
        b(a aVar) {
        }
    }

    public a(x xVar) {
        this.d = new WeakReference<>(xVar);
    }

    @Override // b.b.a.a.e.d
    protected void f() {
    }

    public static void a(r rVar, x xVar) {
        rVar.a("getNetworkData", new C0238a(xVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.b.a.a.e.d
    public void a(JSONObject jSONObject, b.b.a.a.e.f fVar) throws Exception {
        x xVar = this.d.get();
        if (xVar == null) {
            d();
        } else {
            xVar.a(jSONObject, new b(this));
        }
    }
}
