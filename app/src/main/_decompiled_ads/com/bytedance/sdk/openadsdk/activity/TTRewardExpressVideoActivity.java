package com.bytedance.sdk.openadsdk.activity;

import com.bytedance.sdk.openadsdk.b.m.p.l;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.view.c;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.d.g;
import com.kbeanie.imagechooser.api.ChooserType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.j0.c.b
    public boolean a(long j, boolean z) {
        c cVar = this.f400b.J;
        g gVar = (cVar == null || cVar.d() == null) ? new g() : this.f400b.J.d().getAdShowTime();
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        aVar.G.a(aVar.J.f(), gVar);
        HashMap map = new HashMap();
        c cVar2 = this.f400b.J;
        if (cVar2 != null) {
            map.put("dynamic_show_type", Integer.valueOf(cVar2.c()));
        }
        this.f400b.G.a(map);
        this.f400b.G.a(new a());
        boolean zA = this.f400b.G.a(j, z, map, this.c);
        if (zA && !z) {
            this.o = (int) (System.currentTimeMillis() / 1000);
        }
        return zA;
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
            TTRewardExpressVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            if (TTRewardExpressVideoActivity.this.f400b.G.w()) {
                TTRewardExpressVideoActivity.this.t();
                return;
            }
            TTRewardExpressVideoActivity.this.y();
            TTRewardExpressVideoActivity.this.f400b.G.D();
            TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
            if (tTRewardExpressVideoActivity.f400b.f490b) {
                tTRewardExpressVideoActivity.b(false);
            } else {
                tTRewardExpressVideoActivity.finish();
            }
            TTRewardExpressVideoActivity.this.f400b.J.b(true);
            l lVar = TTRewardExpressVideoActivity.this.f400b.G;
            lVar.a(1 ^ (lVar.q() ? 1 : 0), 2);
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void b(long j, int i) {
            if (this.a) {
                return;
            }
            this.a = true;
            TTRewardExpressVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            TTRewardExpressVideoActivity.this.o();
            TTRewardExpressVideoActivity.this.f400b.J.a(true);
            if (TTRewardExpressVideoActivity.this.f400b.a.v() == 21 && !TTRewardExpressVideoActivity.this.f400b.a.b1()) {
                TTRewardExpressVideoActivity.this.f400b.a.c(true);
                TTRewardExpressVideoActivity.this.f400b.T.o();
            }
            TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
            if (tTRewardExpressVideoActivity.f400b.f490b) {
                tTRewardExpressVideoActivity.b(false);
            } else {
                tTRewardExpressVideoActivity.finish();
            }
            TTRewardExpressVideoActivity.this.p = (int) (System.currentTimeMillis() / 1000);
            TTRewardExpressVideoActivity.this.y();
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void h() {
            TTRewardExpressVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            TTRewardExpressVideoActivity.this.o();
            TTRewardExpressVideoActivity.this.y();
            TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
            if (tTRewardExpressVideoActivity.f400b.f490b) {
                tTRewardExpressVideoActivity.b(false);
            } else {
                tTRewardExpressVideoActivity.finish();
            }
            l lVar = TTRewardExpressVideoActivity.this.f400b.G;
            lVar.a(!lVar.q() ? 1 : 0, !TTRewardExpressVideoActivity.this.f400b.G.q() ? 1 : 0);
            TTRewardExpressVideoActivity.this.f400b.G.D();
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, long j2) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = TTRewardExpressVideoActivity.this.f400b;
            if (!aVar.e && aVar.G.w()) {
                TTRewardExpressVideoActivity.this.f400b.G.B();
            }
            if (TTRewardExpressVideoActivity.this.f400b.u.get()) {
                return;
            }
            TTRewardExpressVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            if (j != TTRewardExpressVideoActivity.this.f400b.G.n()) {
                TTRewardExpressVideoActivity.this.o();
            }
            if (TTRewardExpressVideoActivity.this.f400b.G.w()) {
                TTRewardExpressVideoActivity.this.f400b.G.b(j);
                int iA = o.d().a(String.valueOf(TTRewardExpressVideoActivity.this.f400b.o));
                boolean z = TTRewardExpressVideoActivity.this.f400b.J.g() && iA != -1 && iA >= 0;
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                long j3 = j / 1000;
                tTRewardExpressVideoActivity.f = (int) (tTRewardExpressVideoActivity.f400b.G.o() - j3);
                int i = (int) j3;
                if ((TTRewardExpressVideoActivity.this.f400b.E.get() || TTRewardExpressVideoActivity.this.f400b.v.get()) && TTRewardExpressVideoActivity.this.f400b.G.w()) {
                    TTRewardExpressVideoActivity.this.f400b.G.B();
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity2 = TTRewardExpressVideoActivity.this;
                int i2 = tTRewardExpressVideoActivity2.f;
                if (i2 >= 0) {
                    tTRewardExpressVideoActivity2.f400b.R.a(String.valueOf(i2), null);
                }
                TTRewardExpressVideoActivity.this.f400b.T.f(i);
                TTRewardExpressVideoActivity.this.a(j, j2);
                c cVar = TTRewardExpressVideoActivity.this.f400b.J;
                if (cVar != null && cVar.d() != null) {
                    TTRewardExpressVideoActivity.this.f400b.J.d().a(String.valueOf(TTRewardExpressVideoActivity.this.f), i, 0, false);
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity3 = TTRewardExpressVideoActivity.this;
                if (tTRewardExpressVideoActivity3.f > 0) {
                    if (z && i >= iA && tTRewardExpressVideoActivity3.f400b.a.v() != 5) {
                        TTRewardExpressVideoActivity.this.f400b.a(true);
                        TTRewardExpressVideoActivity tTRewardExpressVideoActivity4 = TTRewardExpressVideoActivity.this;
                        tTRewardExpressVideoActivity4.f400b.R.a(String.valueOf(tTRewardExpressVideoActivity4.f), TTAdDislikeToast.getSkipText());
                        TTRewardExpressVideoActivity.this.f400b.R.d(true);
                        return;
                    }
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity5 = TTRewardExpressVideoActivity.this;
                    tTRewardExpressVideoActivity5.f400b.R.a(String.valueOf(tTRewardExpressVideoActivity5.f), null);
                }
            }
        }
    }
}
