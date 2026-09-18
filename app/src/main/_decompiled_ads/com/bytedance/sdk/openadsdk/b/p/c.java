package com.bytedance.sdk.openadsdk.b.p;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.d.r.b.o;

/* JADX INFO: compiled from: TTAppOpenVideoManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f520b;
    private q c;
    private b d;

    public c(Context context) {
        this.a = context.getApplicationContext();
    }

    public void a(FrameLayout frameLayout, q qVar) {
        this.f520b = frameLayout;
        this.c = qVar;
        this.d = new b(this.a, frameLayout, qVar);
    }

    public long b() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.o();
        }
        return 0L;
    }

    public long c() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.a() + this.d.l();
        }
        return 0L;
    }

    public boolean d() {
        b bVar = this.d;
        return (bVar == null || bVar.h() == null || !this.d.h().i()) ? false : true;
    }

    public boolean e() {
        b bVar = this.d;
        return (bVar == null || bVar.h() == null || !this.d.h().h()) ? false : true;
    }

    public void f() {
        b bVar = this.d;
        if (bVar == null) {
            return;
        }
        this.a = null;
        bVar.e();
        this.d = null;
    }

    public void g() {
        try {
            if (e()) {
                this.d.d();
            }
        } catch (Throwable th) {
            m.b("TTAppOpenVideoManager", "open_ad", "AppOpenVideoManager onPause throw Exception :" + th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a
    public long getVideoProgress() {
        return b();
    }

    public boolean h() {
        String strB;
        if (Build.VERSION.SDK_INT >= 23) {
            strB = CacheDirFactory.getICacheDir(0).a();
        } else {
            try {
                strB = com.bytedance.sdk.openadsdk.b.o.a.b();
            } catch (Throwable unused) {
                strB = "";
            }
        }
        com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(strB, this.c);
        bVarA.b(this.c.e());
        bVarA.f(this.f520b.getWidth());
        bVarA.b(this.f520b.getHeight());
        bVarA.e(this.c.N());
        bVarA.a(0L);
        bVarA.a(true);
        return this.d.a(bVarA);
    }

    public void i() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.f();
        }
    }

    public void a(b.a.a.a.a.a.a.g.c.a aVar) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public long a() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.l();
        }
        return 0L;
    }

    public void a(int i) {
        if (this.d != null) {
            o.a aVar = new o.a();
            aVar.b(b());
            aVar.c(c());
            aVar.a(a());
            aVar.a(i);
            aVar.b(this.d.j());
            this.d.a(aVar);
        }
    }
}
