package com.bytedance.sdk.openadsdk.activity;

import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.b.m.p.l;
import com.bytedance.sdk.openadsdk.b.m.q.b;
import com.bytedance.sdk.openadsdk.b.m.q.h;
import com.bytedance.sdk.openadsdk.component.reward.view.c;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.d.g;
import com.kbeanie.imagechooser.api.ChooserType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.j0.c.b
    public boolean a(long j, boolean z) {
        c cVar = this.f400b.J;
        g gVar = (cVar == null || cVar.d() == null) ? new g() : this.f400b.J.d().getAdShowTime();
        b bVar = this.c;
        if (bVar == null || !(bVar instanceof h)) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
            aVar.G.a(aVar.J.f(), gVar);
        } else {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.f400b;
            if (aVar2.i) {
                com.bytedance.sdk.openadsdk.b.m.p.a aVar3 = this.f400b;
                aVar3.G.a(aVar3.J.f(), gVar);
            } else {
                aVar2.G.a(((h) bVar).D(), gVar);
            }
        }
        HashMap map = new HashMap();
        c cVar2 = this.f400b.J;
        if (cVar2 != null) {
            map.put("dynamic_show_type", Integer.valueOf(cVar2.c()));
        }
        this.f400b.G.a(map);
        this.f400b.G.a(new a());
        return this.f400b.G.a(j, z, map, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean l() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean r() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void s() {
    }

    class a implements b.a.a.a.a.a.a.g.c.a {
        boolean a;

        a() {
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, int i) {
            TTFullScreenExpressVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            if (TTFullScreenExpressVideoActivity.this.f400b.G.w()) {
                TTFullScreenExpressVideoActivity.this.t();
                return;
            }
            TTFullScreenExpressVideoActivity.this.f400b.G.D();
            m.b("TTAD.FSEVA", "fullscreen_interstitial_ad", "onError、、、、、、、、");
            TTFullScreenExpressVideoActivity.this.f400b.J.b(true);
            TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
            if (!tTFullScreenExpressVideoActivity.f400b.f490b) {
                tTFullScreenExpressVideoActivity.finish();
                return;
            }
            tTFullScreenExpressVideoActivity.b(false);
            l lVar = TTFullScreenExpressVideoActivity.this.f400b.G;
            lVar.a(!lVar.q() ? 1 : 0, 2);
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void b(long j, int i) {
            if (this.a) {
                return;
            }
            this.a = true;
            TTFullScreenExpressVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            TTFullScreenExpressVideoActivity.this.o();
            TTFullScreenExpressVideoActivity.this.f400b.J.a(true);
            if (TTFullScreenExpressVideoActivity.this.f400b.a.v() == 21 && !TTFullScreenExpressVideoActivity.this.f400b.a.b1()) {
                TTFullScreenExpressVideoActivity.this.f400b.a.c(true);
                TTFullScreenExpressVideoActivity.this.f400b.T.o();
            }
            TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = tTFullScreenExpressVideoActivity.f400b;
            if (aVar.f490b) {
                tTFullScreenExpressVideoActivity.b(false);
                return;
            }
            if (q.c(aVar.a)) {
                TTFullScreenExpressVideoActivity.this.finish();
                return;
            }
            c cVar = TTFullScreenExpressVideoActivity.this.f400b.J;
            if (cVar == null || cVar.d() == null) {
                return;
            }
            TTFullScreenExpressVideoActivity.this.f400b.J.d().a("0", 0, 0, false);
            if (TTFullScreenExpressVideoActivity.this.f400b.J.g()) {
                TTFullScreenExpressVideoActivity.this.f400b.R.a("0", "X");
                TTFullScreenExpressVideoActivity.this.f400b.R.d(true);
            }
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void h() {
            TTFullScreenExpressVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            TTFullScreenExpressVideoActivity.this.o();
            m.a("TTAD.FSEVA", "fullscreen_interstitial_ad", "onTimeOut、、、、、、、、");
            TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
            if (tTFullScreenExpressVideoActivity.f400b.f490b) {
                tTFullScreenExpressVideoActivity.b(false);
            } else {
                tTFullScreenExpressVideoActivity.finish();
            }
            l lVar = TTFullScreenExpressVideoActivity.this.f400b.G;
            lVar.a(!lVar.q() ? 1 : 0, !TTFullScreenExpressVideoActivity.this.f400b.G.q() ? 1 : 0);
            TTFullScreenExpressVideoActivity.this.f400b.G.D();
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, long j2) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = TTFullScreenExpressVideoActivity.this.f400b;
            if (!aVar.e && aVar.G.w()) {
                TTFullScreenExpressVideoActivity.this.f400b.G.B();
            }
            if (TTFullScreenExpressVideoActivity.this.f400b.u.get()) {
                return;
            }
            TTFullScreenExpressVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            if (j != TTFullScreenExpressVideoActivity.this.f400b.G.n()) {
                TTFullScreenExpressVideoActivity.this.o();
            }
            if (TTFullScreenExpressVideoActivity.this.f400b.G.w()) {
                TTFullScreenExpressVideoActivity.this.f400b.G.b(j);
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                long j3 = j / 1000;
                tTFullScreenExpressVideoActivity.f = (int) (tTFullScreenExpressVideoActivity.f400b.G.o() - j3);
                int i = (int) j3;
                if ((TTFullScreenExpressVideoActivity.this.f400b.E.get() || TTFullScreenExpressVideoActivity.this.f400b.v.get()) && TTFullScreenExpressVideoActivity.this.f400b.G.w()) {
                    TTFullScreenExpressVideoActivity.this.f400b.G.B();
                }
                c cVar = TTFullScreenExpressVideoActivity.this.f400b.J;
                if (cVar != null && cVar.d() != null) {
                    TTFullScreenExpressVideoActivity.this.f400b.J.d().a(String.valueOf(TTFullScreenExpressVideoActivity.this.f), i, 0, false);
                }
                if (TTFullScreenExpressVideoActivity.this.f400b.J.g() || TTFullScreenExpressVideoActivity.this.f400b.a.X0()) {
                    TTFullScreenExpressVideoActivity.this.e(i);
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity2 = TTFullScreenExpressVideoActivity.this;
                    if (tTFullScreenExpressVideoActivity2.f >= 0) {
                        tTFullScreenExpressVideoActivity2.f400b.R.b(true);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity3 = TTFullScreenExpressVideoActivity.this;
                        tTFullScreenExpressVideoActivity3.f400b.R.a(String.valueOf(tTFullScreenExpressVideoActivity3.f), null);
                    }
                }
            }
        }
    }
}
