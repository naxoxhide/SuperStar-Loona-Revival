package com.bytedance.sdk.openadsdk.b.m.p;

import android.os.Build;
import android.os.Message;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.f0.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.b0;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardFullEndCardManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.component.reward.view.b f494b;

    public e(a aVar) {
        this.a = aVar;
        this.f494b = new com.bytedance.sdk.openadsdk.component.reward.view.b(aVar);
    }

    private void b() {
        if (t.m(this.a.a)) {
            a aVar = this.a;
            if (aVar.d) {
                aVar.R.e(true);
                this.a.O.a(true);
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.c0.e eVar) {
        this.f494b.a(eVar);
    }

    public void c() {
        this.f494b.a();
    }

    public void d() {
        this.f494b.b();
    }

    public void e() {
        this.f494b.c();
    }

    public boolean f() {
        com.bytedance.sdk.openadsdk.component.reward.view.b bVar = this.f494b;
        if (bVar != null) {
            return bVar.d();
        }
        return false;
    }

    public void g() {
        if (!q.a(this.a.a)) {
            com.bytedance.sdk.component.utils.m.a("TTAD.RFEndM", "TimeTrackLog report 408 from backup page");
            this.a.Q.a(false, TTAdConstant.DOWNLOAD_URL_CODE, "end_card_timeout");
        }
        this.a.Q.A();
        this.a.Q.b(8);
        a aVar = this.a;
        if (aVar.s) {
            b0.a((View) aVar.Y.m, 8);
            this.a.T.b(0);
        }
        this.a.T.e(8);
        if (!this.a.a.k1()) {
            this.f494b.e();
        } else if (!this.f494b.a(this.a.G)) {
            this.a.V.finish();
        }
        this.a.T.r();
        a(this.a.Y);
        this.a.R.c(false);
        a aVar2 = this.a;
        aVar2.L.c(aVar2.V.m());
    }

    public void a(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.b.m.q.b bVar) {
        j jVar;
        com.bytedance.sdk.component.utils.m.a("TTAD.RFEndM", "showEndCard() called with: isSkip = [" + z + "], force = [" + z2 + "], isFromLandingPage = [" + z3 + "], mAdType = [" + bVar + "]");
        if (this.a.V.isFinishing() || bVar == null) {
            return;
        }
        this.a.T.q();
        if (z2) {
            this.a.z.set(true);
        }
        if (!this.a.A.get() && !o.c(this.a.a) && (!o.f(this.a.a) || !this.a.z.get() || !this.a.B.get())) {
            if (o.f(this.a.a) && z3) {
                return;
            }
            if ((o.f(this.a.a) || o.b(this.a.a)) && (jVar = this.a.R) != null) {
                jVar.c(false);
                bVar.A();
                return;
            }
        }
        if ((Build.VERSION.SDK_INT < 17 || !this.a.V.isDestroyed()) && !this.a.V.isFinishing()) {
            if (this.a.a.X0()) {
                this.a.V.finish();
                return;
            }
            this.a.G.D();
            this.a.Q.y();
            this.a.v.set(false);
            this.a.w.set(false);
            this.a.N.b();
            a aVar = this.a;
            aVar.R.a(!aVar.s && aVar.a.g1());
            if (this.a.u.getAndSet(true)) {
                return;
            }
            if (this.a.V.l() && t.i(this.a.a) && z) {
                this.a.R.b(true);
            }
            b();
            if (t.h(this.a.a)) {
                return;
            }
            this.a.C.set(z);
            bVar.e();
            if (this.a.a.k1()) {
                this.a.R.b(false);
            } else {
                a aVar2 = this.a;
                aVar2.R.b(t.h(aVar2.a));
            }
            a aVar3 = this.a;
            aVar3.R.c(t.i(aVar3.a));
            if (this.a.V.l() && t.i(this.a.a) && z) {
                this.a.R.b(true);
            }
            this.a.Q.G();
            o oVar = this.a.T.s;
            if (oVar != null) {
                oVar.d();
            }
            this.a.T.p();
            if (!q.b(this.a.a) && !this.a.Q.s()) {
                a aVar4 = this.a;
                if (q.a(aVar4.a, aVar4.Q.u(), this.a.I.i(), this.a.Q.o()) || t.i(this.a.a)) {
                    if (!q.a(this.a.a) && !t.i(this.a.a)) {
                        com.bytedance.sdk.component.utils.m.a("TTAD.RFEndM", "TimeTrackLog report Success from Android");
                        this.a.Q.a(true, 0, (String) null);
                    }
                    this.a.Q.a(0.0f);
                    this.a.T.a(0.0f);
                    this.a.Q.b(0);
                    if (this.a.s) {
                        b0.a((View) bVar.m, 0);
                        this.a.T.b(8);
                    }
                    if (t.i(this.a.a)) {
                        int iS0 = this.a.a.s0();
                        if (t.h(this.a.a)) {
                            iS0 = (this.a.a.r0() + 1) * 1000;
                        }
                        com.bytedance.sdk.component.utils.m.a("TTAD.RFEndM", "showEndCard1: cT=" + iS0);
                        if (iS0 == -1) {
                            if (t.g(this.a.a)) {
                                bVar.C();
                            } else {
                                bVar.A();
                            }
                        } else if (iS0 >= 0) {
                            if (t.g(this.a.a)) {
                                this.a.X.sendEmptyMessageDelayed(1, iS0);
                            } else {
                                this.a.X.sendEmptyMessageDelayed(600, iS0);
                            }
                        }
                    } else {
                        a(bVar);
                    }
                    this.a.X.sendEmptyMessageDelayed(500, 100L);
                    a aVar5 = this.a;
                    aVar5.Q.a(aVar5.d, true);
                    this.a.Q.a(true);
                    this.a.T.e(8);
                    this.a.T.r();
                    this.a.Q.c(true);
                    this.a.Q.d().a("prerender_page_show", (JSONObject) null);
                    return;
                }
            }
            g();
        }
    }

    public boolean a(com.bytedance.sdk.openadsdk.b.m.q.b bVar) {
        this.a.t = a();
        com.bytedance.sdk.component.utils.m.a("TTAD.RFEndM", "showEndCard: cT2=" + this.a.t);
        if (this.a.a.Z0()) {
            return false;
        }
        a aVar = this.a;
        int i = aVar.t;
        if (i == -1) {
            if (t.g(aVar.a) && this.a.Q.u()) {
                bVar.C();
                return true;
            }
            bVar.A();
            return true;
        }
        if (i < 0) {
            return true;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 700;
        a aVar2 = this.a;
        messageObtain.arg1 = aVar2.t;
        aVar2.X.sendMessage(messageObtain);
        return true;
    }

    private int a() {
        int iK = this.a.a.K();
        if (iK <= 5000 && iK >= 0) {
            if (iK < 1000) {
                iK += 1000;
            }
            int iA = com.bytedance.sdk.openadsdk.core.o.d().a(this.a.a.S());
            if (iA <= 5000 && iA >= 0) {
                if (iA < 1000) {
                    iA += 1000;
                }
                return Math.min(iK, iA);
            }
        }
        return -1;
    }
}
