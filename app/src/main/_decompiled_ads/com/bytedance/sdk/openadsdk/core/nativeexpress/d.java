package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: DynamicViewRender.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends b.b.a.a.d.d.g.a {
    private b.b.a.a.d.f.m i;
    private b.b.a.a.d.f.g j;
    private final b.b.a.a.k.g k;
    private final Runnable l;

    /* JADX INFO: compiled from: DynamicViewRender.java */
    class a extends b.b.a.a.k.g {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.i.q();
            com.bytedance.sdk.openadsdk.core.l.c().post(d.this.l);
        }
    }

    /* JADX INFO: compiled from: DynamicViewRender.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.j != null) {
                d dVar = d.this;
                d.super.a(dVar.j);
            }
        }
    }

    public d(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, b.b.a.a.d.d.i.g gVar, b.b.a.a.d.f.m mVar, b.b.a.a.d.d.j.a aVar) {
        super(context, themeStatusBroadcastReceiver, z, gVar, mVar, aVar);
        this.k = new a("dynamic_render_template");
        this.l = new b();
        this.i = mVar;
    }

    @Override // b.b.a.a.d.d.g.a
    public void g() {
        super.g();
        com.bytedance.sdk.openadsdk.core.l.c().removeCallbacks(this.l);
    }

    @Override // b.b.a.a.d.d.g.a, b.b.a.a.d.f.d
    public void a(b.b.a.a.d.f.g gVar) {
        this.j = gVar;
        y.c(this.k);
    }
}
