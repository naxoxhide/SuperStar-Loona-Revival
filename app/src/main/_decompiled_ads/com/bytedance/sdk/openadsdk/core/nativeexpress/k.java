package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.utils.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExpressRenderEventMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements b.b.a.a.d.f.i {
    private final com.bytedance.sdk.openadsdk.d.o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f657b;
    private final q c;
    private final String d;
    private long e;

    /* JADX INFO: compiled from: ExpressRenderEventMonitor.java */
    class a extends b.b.a.a.k.g {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.d.c.b(k.this.c, k.this.f657b, this.c, (JSONObject) null);
        }
    }

    /* JADX INFO: compiled from: ExpressRenderEventMonitor.java */
    class b extends b.b.a.a.k.g {
        b(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.d.c.b(k.this.c, k.this.f657b, "dynamic_backup_render", (JSONObject) null);
        }
    }

    public k(com.bytedance.sdk.openadsdk.d.o oVar, String str, q qVar, String str2) {
        this.a = oVar;
        this.f657b = str;
        this.d = str2;
        this.c = qVar;
    }

    @Override // b.b.a.a.d.f.i
    public void c() {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "WebView start load");
    }

    @Override // b.b.a.a.d.f.i
    public void d() {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "webview render success");
        this.a.l();
    }

    @Override // b.b.a.a.d.f.i
    public void e(int i) {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "onDynamicStart() called with: renderType = [" + i + "]");
        this.e = System.currentTimeMillis();
        if (i == 3) {
            this.a.b("dynamic_render2_start");
        } else {
            this.a.b("dynamic_render_start");
        }
    }

    @Override // b.b.a.a.d.f.i
    public void f() {
        this.a.k();
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "start render ");
    }

    @Override // b.b.a.a.d.f.i
    public void g(int i) {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "onDynamicParseEnd() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.a("dynamic_sub_analysis2_end");
        } else {
            this.a.a("dynamic_sub_analysis_end");
        }
    }

    @Override // b.b.a.a.d.f.i
    public void h() {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "native success");
        this.a.a(true);
        this.a.g();
        y.c(new b("native_success"), 10);
    }

    public void i() {
        this.a.p();
        this.a.q();
    }

    @Override // b.b.a.a.d.f.i
    public void a(boolean z) {
        this.a.a(z ? 1 : 0);
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "webview start request");
    }

    @Override // b.b.a.a.d.f.i
    public void b(int i) {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "onDynamicRealRenderStart() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.a("dynamic_sub_render2_start");
        } else {
            this.a.a("dynamic_sub_render_start");
        }
    }

    @Override // b.b.a.a.d.f.i
    public void c(int i) {
        String str;
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "dynamic render success render type: " + i + "; ****cost time(ms): " + (System.currentTimeMillis() - this.e) + "****");
        if (i == 3) {
            this.a.c("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.a.c("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.a.a(true);
        y.c(new a("dynamic_success", str), 10);
    }

    @Override // b.b.a.a.d.f.i
    public void d(int i) {
        this.a.b(i);
        i.a(i, this.f657b, this.d, this.c);
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "onWebViewFail() called with: errorCode = [" + i + "]");
    }

    @Override // b.b.a.a.d.f.i
    public void f(int i) {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "onDynamicRealRenderEnd() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.a("dynamic_sub_render2_end");
        } else {
            this.a.a("dynamic_sub_render_end");
        }
    }

    @Override // b.b.a.a.d.f.i
    public void a(int i) {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "onDynamicParseStart() called with: renderType = [" + i + "]");
        if (i == 3) {
            this.a.a("dynamic_sub_analysis2_start");
        } else {
            this.a.a("dynamic_sub_analysis_start");
        }
    }

    @Override // b.b.a.a.d.f.i
    public void g() {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "render success");
        this.a.l();
    }

    @Override // b.b.a.a.d.f.i
    public void b() {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "no native render");
        this.a.i();
    }

    @Override // b.b.a.a.d.f.i
    public void e() {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "native render start");
        this.a.h();
    }

    @Override // b.b.a.a.d.f.i
    public void a(int i, int i2, boolean z) {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "onDynamicFail() called with: renderType = [" + i + "], errorCode = [" + i2 + "], hasNext = [" + z + "]");
        if (!z) {
            this.a.a(true);
        }
        if (i == 3) {
            this.a.a(i2, "dynamic_render2_error");
        } else {
            this.a.a(i2, "dynamic_render_error");
        }
        i.a(i2, this.f657b, this.d, this.c);
    }

    @Override // b.b.a.a.d.f.i
    public void a() {
        com.bytedance.sdk.component.utils.m.a("ExpressRenderEventMonitor", "render fail");
        this.a.j();
    }
}
