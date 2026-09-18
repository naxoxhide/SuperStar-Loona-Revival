package com.bytedance.sdk.openadsdk.b.m.p;

import android.app.Activity;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.kbeanie.imagechooser.api.ChooserType;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: RewardFullVideoPlayerManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    private final Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f506b;
    private FrameLayout c;
    private final String d;
    private long e;
    String g;
    b.a.a.a.a.a.a.g.c i;
    private long j;
    private boolean k;
    private final com.bytedance.sdk.openadsdk.b.m.p.a l;
    private boolean m;
    private com.bytedance.sdk.openadsdk.d.g n;
    protected boolean f = false;
    protected boolean h = false;

    /* JADX INFO: compiled from: RewardFullVideoPlayerManager.java */
    class a implements Runnable {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(l.this.g)) {
                if (this.a) {
                    com.bytedance.sdk.openadsdk.b.m.l.a(o.a()).b();
                } else {
                    com.bytedance.sdk.openadsdk.b.m.e.a(o.a()).b();
                }
            }
        }
    }

    public l(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.l = aVar;
        this.a = aVar.V;
        this.f506b = aVar.a;
        boolean z = aVar.f;
        this.d = aVar.g;
    }

    private void p() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar == null || cVar.h() == null) {
            return;
        }
        this.e = this.i.o();
        if (this.i.h().f() || !this.i.h().d()) {
            this.i.d();
            this.i.e();
            this.f = true;
        }
    }

    public void A() {
        try {
            if (w()) {
                this.h = true;
                B();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.m.b("TTAD.RFVideoPlayerMag", "onPause throw Exception :" + e.getMessage());
        }
    }

    public void B() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void C() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar == null) {
            return;
        }
        cVar.e();
        this.i = null;
    }

    public void D() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void E() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            cVar.f();
        }
    }

    public void a(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.d.g gVar) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.c = frameLayout;
        this.n = gVar;
        if (!q.c(this.f506b)) {
            this.i = new com.bytedance.sdk.openadsdk.b.m.c(this.f506b);
        } else {
            this.i = new com.bytedance.sdk.openadsdk.core.j0.c.a(this.a, this.c, this.f506b, gVar);
            d(this.m);
        }
    }

    public com.bytedance.sdk.openadsdk.d.g b() {
        return this.n;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public long d() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            return cVar.l();
        }
        return 0L;
    }

    public long e() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        return cVar != null ? cVar.o() : this.e;
    }

    public long f() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            return cVar.a();
        }
        return 0L;
    }

    public View g() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.j0.c.a) {
            return (View) ((com.bytedance.sdk.openadsdk.core.j0.c.a) cVar).H();
        }
        return null;
    }

    public long h() {
        return this.e;
    }

    public b.a.a.a.a.a.a.e.a i() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            return cVar.g();
        }
        return null;
    }

    public int j() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            return cVar.m();
        }
        return 0;
    }

    public long k() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            return cVar.a() + this.i.l();
        }
        return 0L;
    }

    public long l() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            return cVar.a();
        }
        return 0L;
    }

    public String m() {
        return this.g;
    }

    public long n() {
        return this.j;
    }

    public double o() {
        if (com.bytedance.sdk.openadsdk.core.f0.o.b(this.f506b) && this.f506b.h0() != null) {
            return this.f506b.h0().c();
        }
        b.a.a.a.a.a.a.f.b bVarN0 = this.f506b.N0();
        if (bVarN0 != null) {
            return bVarN0.s() * ((double) bVarN0.m());
        }
        return 0.0d;
    }

    public boolean q() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar == null || cVar.h() == null) {
            return false;
        }
        return this.i.h().e();
    }

    public boolean r() {
        return this.f;
    }

    public boolean s() {
        return this.i != null;
    }

    public boolean t() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        return cVar != null && cVar.h() == null;
    }

    public boolean u() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        return cVar != null && cVar.b();
    }

    public boolean v() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        return (cVar == null || cVar.h() == null || !this.i.h().i()) ? false : true;
    }

    public boolean w() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        return (cVar == null || cVar.h() == null || !this.i.h().h()) ? false : true;
    }

    public void x() {
        try {
            if (w()) {
                this.i.d();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("RewardFullVideoPlayerManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void y() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.j0.c.a) {
            ((com.bytedance.sdk.openadsdk.core.j0.c.a) cVar).M();
        }
    }

    public void z() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.j0.c.a) {
            ((com.bytedance.sdk.openadsdk.core.j0.c.a) cVar).N();
        }
    }

    public void b(long j) {
        this.j = j;
    }

    public int c() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            return cVar.j();
        }
        return 0;
    }

    public void b(boolean z) {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            cVar.e(z);
        }
    }

    public void d(boolean z) {
        this.m = z;
        if (this.i instanceof com.bytedance.sdk.openadsdk.core.j0.c.a) {
            if (z) {
                ((com.bytedance.sdk.openadsdk.core.j0.c.a) this.i).d(this.f506b.N0().m());
            } else {
                this.f506b.N0().h(1);
                ((com.bytedance.sdk.openadsdk.core.j0.c.a) this.i).d(1);
            }
        }
    }

    public void b(String str) {
        this.g = str;
    }

    protected void b(com.bytedance.sdk.openadsdk.core.j0.c.b bVar) {
        if (!a() || bVar == null) {
            return;
        }
        bVar.a(h(), true);
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(int i, int i2) {
        if (this.i != null) {
            com.bytedance.sdk.openadsdk.d.r.b.o.a aVar = new com.bytedance.sdk.openadsdk.d.r.b.o.a();
            aVar.a(d());
            aVar.c(k());
            aVar.b(e());
            aVar.d(i);
            aVar.c(i2);
            com.bytedance.sdk.openadsdk.d.r.a.a.a(this.i.g(), aVar);
        }
    }

    public void a(Map<String, Object> map) {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            cVar.a(map);
        }
    }

    public void a(b.a.a.a.a.a.a.g.c.a aVar) {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void a(String str) {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            com.bytedance.sdk.openadsdk.d.c.a(this.f506b, this.d, str, e(), j(), a0.a(this.f506b, cVar.l(), this.i.h()), this.n);
            com.bytedance.sdk.component.utils.m.a("TTAD.RFVideoPlayerMag", "event tag:" + this.d + ", TotalPlayDuration=" + k() + ",mBasevideoController.getPct()=" + j());
        }
        z();
    }

    public boolean a() {
        b.a.a.a.a.a.a.g.c cVar = this.i;
        if (cVar != null) {
            if (cVar.h() != null) {
                b.a.a.a.a.a.a.a aVarH = this.i.h();
                if (aVarH.i() || aVarH.g()) {
                    b.a.a.a.a.a.a.g.c cVar2 = this.i;
                    if (cVar2 instanceof com.bytedance.sdk.openadsdk.core.j0.c.a) {
                        ((com.bytedance.sdk.openadsdk.core.j0.c.a) cVar2).Q();
                    }
                    return true;
                }
            } else if (r()) {
                c(false);
                b.a.a.a.a.a.a.g.c cVar3 = this.i;
                if (cVar3 instanceof com.bytedance.sdk.openadsdk.core.j0.c.a) {
                    ((com.bytedance.sdk.openadsdk.core.j0.c.a) cVar3).Q();
                }
                return true;
            }
        }
        return false;
    }

    public boolean a(long j, boolean z, Map<String, Object> map, com.bytedance.sdk.openadsdk.b.m.q.b bVar) {
        boolean zA = false;
        if (!s()) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.f0.o.b(this.l.a)) {
            return true;
        }
        if (!z || !t()) {
            a(bVar);
        }
        try {
            zA = a(j, this.l.d);
        } catch (Exception e) {
            Log.e("TTAD.RFVideoPlayerMag", "playVideo: ", e);
        }
        if (zA && !z) {
            this.l.L.a(map);
        }
        return zA;
    }

    public void a(com.bytedance.sdk.openadsdk.b.m.q.b bVar) {
        if (this.l.u.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.l;
        if (!aVar.e || t.h(aVar.a)) {
            return;
        }
        if ((!q.c(this.l.a) && o.d().j(String.valueOf(this.l.o)) == 1 && this.l.J.h()) || com.bytedance.sdk.openadsdk.core.f0.o.b(this.l.a) || !bVar.q()) {
            return;
        }
        this.l.X.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
        Message messageObtain = Message.obtain();
        messageObtain.what = ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO;
        this.l.X.sendMessageDelayed(messageObtain, 5000L);
    }

    private boolean a(long j, boolean z) {
        com.bytedance.sdk.component.utils.m.a("TTAD.RFVideoPlayerMag", "playVideo start");
        if (this.i != null && this.f506b.N0() != null) {
            String strB = CacheDirFactory.getICacheDir(this.f506b.u0()).b();
            File file = new File(strB, this.f506b.N0().h());
            if (file.exists()) {
                file.length();
            }
            com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(strB, this.f506b);
            bVarA.b(this.f506b.e());
            bVarA.f(this.c.getWidth());
            bVarA.b(this.c.getHeight());
            bVarA.e(this.f506b.N());
            bVarA.a(j);
            bVarA.a(z);
            if (this.l.V.l() && !this.l.J.g() && q.c(this.f506b)) {
                bVarA.q = 1;
            }
            return this.i.a(bVarA);
        }
        com.bytedance.sdk.component.utils.m.a("TTAD.RFVideoPlayerMag", "playVideo controller is Empty");
        return false;
    }

    public void a(boolean z) {
        C();
        com.bytedance.sdk.openadsdk.core.l.a().post(new a(z));
    }

    public void a(com.bytedance.sdk.openadsdk.core.j0.c.b bVar) {
        try {
            this.h = false;
            if (r()) {
                p();
                b(bVar);
            } else if (v()) {
                E();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTAD.RFVideoPlayerMag", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void a(boolean z, com.bytedance.sdk.openadsdk.core.j0.c.b bVar, boolean z2) {
        if (!z2 || z || this.h) {
            return;
        }
        if (v()) {
            E();
            Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: continue play");
        } else {
            p();
            b(bVar);
            Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: recreate video player & exec play");
        }
    }
}
