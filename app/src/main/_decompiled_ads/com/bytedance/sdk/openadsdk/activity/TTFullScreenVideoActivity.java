package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.b.m.p.l;
import com.bytedance.sdk.openadsdk.b.m.q.h;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.f0.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.q.c.e;
import com.bytedance.sdk.openadsdk.utils.y;
import com.kbeanie.imagechooser.api.ChooserType;

/* JADX INFO: loaded from: classes2.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static com.bytedance.sdk.openadsdk.a.d.b o;
    private com.bytedance.sdk.openadsdk.a.d.b m;
    private boolean n;

    class a extends g {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTFullScreenVideoActivity.this.c(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.f400b.c, this.c);
            } catch (Throwable th) {
                m.a("TTAD.FSVA", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TTFullScreenVideoActivity.this.f400b.Q.t() && TTFullScreenVideoActivity.this.f400b.u.get()) {
                TTFullScreenVideoActivity.this.f400b.Q.v();
                TTFullScreenVideoActivity.this.f400b.T.b(8);
                TTFullScreenVideoActivity.this.f400b.X.sendEmptyMessageDelayed(600, 5000L);
                return;
            }
            boolean zF = false;
            if (TTFullScreenVideoActivity.this.f400b.a.c()) {
                if (TTFullScreenVideoActivity.this.f400b.a.k1()) {
                    com.bytedance.sdk.openadsdk.b.m.p.a aVar = TTFullScreenVideoActivity.this.f400b;
                    if (aVar.S != null) {
                        aVar.a.l(2);
                        zF = TTFullScreenVideoActivity.this.f400b.S.f();
                    }
                } else if (TTFullScreenVideoActivity.this.f400b.a.G() == 0 && !TTFullScreenVideoActivity.this.f400b.Q.n()) {
                    TTFullScreenVideoActivity.this.f400b.a.l(11);
                    if (TTFullScreenVideoActivity.this.f400b.Q.p()) {
                        TTFullScreenVideoActivity.this.f400b.a.l(12);
                    }
                    try {
                        TTFullScreenVideoActivity.this.f400b.T.o();
                        zF = true;
                    } catch (Exception unused) {
                    }
                }
            }
            if (zF) {
                return;
            }
            TTFullScreenVideoActivity.this.f400b.Q.x();
            TTFullScreenVideoActivity.this.f400b.L.h();
            TTFullScreenVideoActivity.this.finish();
        }
    }

    class c implements com.bytedance.sdk.openadsdk.component.reward.top.b {
        c() {
        }

        @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
        public void a(View view) {
            if (t.g(TTFullScreenVideoActivity.this.f400b.a) && (t.h(TTFullScreenVideoActivity.this.f400b.a) || TTFullScreenVideoActivity.this.f400b.u.get())) {
                TTFullScreenVideoActivity.this.f400b.Q.H();
                return;
            }
            if (t.h(TTFullScreenVideoActivity.this.f400b.a) || (o.h(TTFullScreenVideoActivity.this.f400b.a) && !TTFullScreenVideoActivity.this.f400b.A.get())) {
                TTFullScreenVideoActivity.this.finish();
                return;
            }
            if (TTFullScreenVideoActivity.this.f400b.a.b()) {
                if (TTFullScreenVideoActivity.this.f400b.T.d() != null) {
                    TTFullScreenVideoActivity.this.f400b.a.l(2);
                    TTFullScreenVideoActivity.this.f400b.T.o();
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = TTFullScreenVideoActivity.this.f400b;
            if (!aVar.f490b && aVar.a.c() && !TTFullScreenVideoActivity.this.f400b.a.k1()) {
                TTFullScreenVideoActivity.this.f400b.a.l(13);
                try {
                    TTFullScreenVideoActivity.this.f400b.T.o();
                    return;
                } catch (Exception unused) {
                }
            }
            com.bytedance.sdk.openadsdk.d.r.b.o.a aVar2 = new com.bytedance.sdk.openadsdk.d.r.b.o.a();
            aVar2.b(TTFullScreenVideoActivity.this.f400b.G.e());
            aVar2.c(TTFullScreenVideoActivity.this.f400b.G.k());
            aVar2.a(TTFullScreenVideoActivity.this.f400b.G.d());
            aVar2.a(3);
            aVar2.b(TTFullScreenVideoActivity.this.f400b.G.c());
            com.bytedance.sdk.openadsdk.d.r.a.a.a(TTFullScreenVideoActivity.this.f400b.G.i(), aVar2, TTFullScreenVideoActivity.this.f400b.G.b());
            r.a(TTFullScreenVideoActivity.this.f400b.o);
            TTFullScreenVideoActivity.this.f400b.G.a("skip");
            TTFullScreenVideoActivity.this.f400b.R.b(false);
            TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
            if (tTFullScreenVideoActivity.f400b.f490b) {
                tTFullScreenVideoActivity.b(true);
            } else {
                tTFullScreenVideoActivity.finish();
            }
            q qVar = TTFullScreenVideoActivity.this.f400b.a;
            if (qVar != null && qVar.M0() != null) {
                com.bytedance.sdk.openadsdk.b.m.p.a aVar3 = TTFullScreenVideoActivity.this.f400b;
                if (aVar3.G != null) {
                    aVar3.a.M0().m().h(TTFullScreenVideoActivity.this.f400b.G.e());
                    TTFullScreenVideoActivity.this.f400b.a.M0().m().b(TTFullScreenVideoActivity.this.f400b.G.e());
                }
            }
            e.a(TTFullScreenVideoActivity.this.f400b.a, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
        public void b(View view) {
            TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
            tTFullScreenVideoActivity.f400b.N.b(tTFullScreenVideoActivity.c);
        }

        @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
        public void c(View view) {
            TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = tTFullScreenVideoActivity.f400b;
            aVar.d = !aVar.d;
            com.bytedance.sdk.openadsdk.b.m.q.b bVar = tTFullScreenVideoActivity.c;
            if (bVar != null && bVar.j() != null) {
                TTFullScreenVideoActivity.this.c.j().a(TTFullScreenVideoActivity.this.f400b.d);
            }
            com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = TTFullScreenVideoActivity.this.f400b;
            aVar2.G.b(aVar2.d);
            if (!t.m(TTFullScreenVideoActivity.this.f400b.a) || TTFullScreenVideoActivity.this.f400b.u.get()) {
                if (t.i(TTFullScreenVideoActivity.this.f400b.a)) {
                    com.bytedance.sdk.openadsdk.b.m.p.a aVar3 = TTFullScreenVideoActivity.this.f400b;
                    aVar3.O.a(aVar3.d, true);
                }
                com.bytedance.sdk.openadsdk.b.m.p.a aVar4 = TTFullScreenVideoActivity.this.f400b;
                aVar4.Q.b(aVar4.d);
                q qVar = TTFullScreenVideoActivity.this.f400b.a;
                if (qVar == null || qVar.M0() == null || TTFullScreenVideoActivity.this.f400b.a.M0().m() == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.b.m.p.a aVar5 = TTFullScreenVideoActivity.this.f400b;
                if (aVar5.G != null) {
                    if (aVar5.d) {
                        aVar5.a.M0().m().e(TTFullScreenVideoActivity.this.f400b.G.e());
                    } else {
                        aVar5.a.M0().m().i(TTFullScreenVideoActivity.this.f400b.G.e());
                    }
                }
            }
        }
    }

    private void a(String str) {
        y.a(new a("FullScreen_executeMultiProcessCallback", str), 5);
    }

    private boolean b(q qVar) {
        return qVar == null || qVar.o() == 100.0f;
    }

    private void d(int i) {
        this.f400b.R.a(null, new SpannableStringBuilder(String.format(com.bytedance.sdk.component.utils.t.k(com.bytedance.sdk.openadsdk.core.o.a(), "tt_skip_ad_time_text"), Integer.valueOf(i))));
    }

    private void v() {
        if (this.g) {
            return;
        }
        this.g = true;
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.a.d.b bVar = this.m;
        if (bVar != null) {
            bVar.onAdClose();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.b
    public void b(int i) {
    }

    protected void e(int i) {
        int iR = com.bytedance.sdk.openadsdk.core.o.d().r(String.valueOf(this.f400b.o));
        if (iR < 0) {
            iR = 5;
        }
        if (!com.bytedance.sdk.openadsdk.core.o.d().c(String.valueOf(this.f400b.o)) || (!q.c(this.f400b.a) && !this.f400b.f490b)) {
            if (i >= iR) {
                com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
                if (!aVar.p) {
                    aVar.a(true);
                }
                p();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.f400b;
        if (!aVar2.p) {
            aVar2.a(true);
        }
        if (i > iR) {
            p();
        } else {
            d(iR - i);
            this.f400b.R.d(false);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        o = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void finish() {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        if (aVar != null) {
            aVar.I.e(aVar.q);
        }
        try {
            v();
        } catch (Exception unused) {
        }
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void i() {
        View viewB = this.f400b.T.b();
        if (viewB != null) {
            b bVar = new b();
            viewB.setOnClickListener(bVar);
            viewB.setTag(viewB.getId(), bVar);
        }
        this.f400b.R.a(new c());
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void n() {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.a.d.b bVar = this.m;
            if (bVar != null) {
                bVar.onAdShow();
            }
        }
        if (l()) {
            this.f400b.J.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        if (aVar == null || q.c(aVar.a)) {
            return;
        }
        b.a.a.a.a.a.a.f.b bVarN0 = this.f400b.a.N0();
        if (bVarN0 == null) {
            b.a.a.a.a.a.a.f.b bVar = new b.a.a.a.a.a.a.f.b();
            bVar.a(10.0d);
            this.f400b.a.c(bVar);
        } else if (bVarN0.s() <= 0.0d) {
            bVarN0.a(10.0d);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        v();
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("recycleRes");
        }
        this.m = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.j0.c.b
    public void onRewardBarClick(View view) {
        if (this.f400b.a.o() != 100.0f) {
            this.n = true;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.a.d.b bVar = this.m;
        if (bVar != null) {
            bVar.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        o = this.m;
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        if (aVar == null || !a(aVar.a) || b(this.f400b.a)) {
            return;
        }
        if (this.n) {
            this.n = false;
            finish();
        } else if (this.f400b.Q.q()) {
            finish();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void p() {
        if (q.c(this.f400b.a)) {
            this.f400b.R.a(null, TTAdDislikeToast.getSkipText());
        } else {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
            if (aVar.f490b) {
                this.f400b.R.a(null, TTAdDislikeToast.getSkipText());
            } else {
                aVar.R.a(null, "X");
            }
        }
        this.f400b.R.d(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void a(Intent intent) {
        super.a(intent);
        this.f400b.q = intent.getBooleanExtra("is_verity_playable", false);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.j0.c.b
    public void a(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.m.b.b()) {
            this.m = s.g().d();
        }
        if (this.m != null || bundle == null) {
            return;
        }
        this.m = o;
        o = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.b
    public void d() {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdVideoBarClick");
        } else {
            com.bytedance.sdk.openadsdk.a.d.b bVar = this.m;
            if (bVar != null) {
                bVar.onAdVideoBarClick();
            }
        }
        this.f400b.a.o1();
        this.f400b.a.e(true);
        if (q.c(this.f400b.a)) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
            q qVar = aVar.a;
            com.bytedance.sdk.openadsdk.d.c.a(qVar, aVar.g, qVar.v0());
        }
    }

    public boolean a(long j, boolean z) {
        com.bytedance.sdk.openadsdk.d.g gVar = new com.bytedance.sdk.openadsdk.d.g();
        gVar.a(System.currentTimeMillis(), 1.0f);
        com.bytedance.sdk.openadsdk.b.m.q.b bVar = this.c;
        if (bVar != null && (bVar instanceof h)) {
            this.f400b.G.a(((h) bVar).D(), gVar);
        } else {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
            aVar.G.a(aVar.T.e(), gVar);
        }
        d dVar = new d();
        this.f400b.G.a(dVar);
        o oVar = this.f400b.T.s;
        if (oVar != null) {
            oVar.a(dVar);
        }
        return this.f400b.G.a(j, z, null, this.c);
    }

    class d implements b.a.a.a.a.a.a.g.c.a {
        boolean a;

        d() {
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, int i) {
            TTFullScreenVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            if (TTFullScreenVideoActivity.this.f400b.G.w()) {
                TTFullScreenVideoActivity.this.t();
                return;
            }
            TTFullScreenVideoActivity.this.f400b.G.D();
            m.b("TTAD.FSVA", "fullscreen_interstitial_ad", "onError、、、、、、、、");
            TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
            if (!tTFullScreenVideoActivity.f400b.f490b) {
                tTFullScreenVideoActivity.finish();
                return;
            }
            tTFullScreenVideoActivity.a(false, true);
            l lVar = TTFullScreenVideoActivity.this.f400b.G;
            lVar.a(!lVar.q() ? 1 : 0, 2);
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void b(long j, int i) {
            if (this.a) {
                return;
            }
            this.a = true;
            TTFullScreenVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            TTFullScreenVideoActivity.this.o();
            TTFullScreenVideoActivity.this.f400b.D.set(true);
            if (TTFullScreenVideoActivity.this.f400b.a.a()) {
                TTFullScreenVideoActivity.this.f400b.a.l(1);
                TTFullScreenVideoActivity.this.f400b.T.o();
            }
            if (TTFullScreenVideoActivity.this.f400b.a.v() == 21 && !TTFullScreenVideoActivity.this.f400b.a.b1()) {
                TTFullScreenVideoActivity.this.f400b.a.c(true);
                TTFullScreenVideoActivity.this.f400b.T.o();
            }
            TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
            if (tTFullScreenVideoActivity.f400b.f490b) {
                tTFullScreenVideoActivity.b(false);
            } else {
                tTFullScreenVideoActivity.finish();
            }
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void h() {
            TTFullScreenVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            TTFullScreenVideoActivity.this.o();
            m.a("TTAD.FSVA", "fullscreen_interstitial_ad", "onTimeOut、、、、、、、、");
            TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
            if (tTFullScreenVideoActivity.f400b.f490b) {
                tTFullScreenVideoActivity.a(false, true);
            } else {
                tTFullScreenVideoActivity.finish();
            }
            l lVar = TTFullScreenVideoActivity.this.f400b.G;
            lVar.a(!lVar.q() ? 1 : 0, !TTFullScreenVideoActivity.this.f400b.G.q() ? 1 : 0);
            TTFullScreenVideoActivity.this.f400b.G.D();
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, long j2) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = TTFullScreenVideoActivity.this.f400b;
            if (!aVar.e && aVar.G.w()) {
                TTFullScreenVideoActivity.this.f400b.G.B();
            }
            if (TTFullScreenVideoActivity.this.f400b.u.get()) {
                return;
            }
            TTFullScreenVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            if (j != TTFullScreenVideoActivity.this.f400b.G.n()) {
                TTFullScreenVideoActivity.this.o();
            }
            TTFullScreenVideoActivity.this.f400b.G.b(j);
            TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
            long j3 = j / 1000;
            tTFullScreenVideoActivity.f = (int) (tTFullScreenVideoActivity.f400b.G.o() - j3);
            int i = (int) j3;
            if ((TTFullScreenVideoActivity.this.f400b.E.get() || TTFullScreenVideoActivity.this.f400b.v.get()) && TTFullScreenVideoActivity.this.f400b.G.w()) {
                TTFullScreenVideoActivity.this.f400b.G.B();
            }
            TTFullScreenVideoActivity.this.e(i);
            TTFullScreenVideoActivity tTFullScreenVideoActivity2 = TTFullScreenVideoActivity.this;
            int i2 = tTFullScreenVideoActivity2.f;
            if (i2 >= 0) {
                tTFullScreenVideoActivity2.f400b.R.a(String.valueOf(i2), null);
            }
        }
    }

    private boolean a(q qVar) {
        if (qVar == null) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.o.d().k(String.valueOf(this.f400b.o));
    }
}
