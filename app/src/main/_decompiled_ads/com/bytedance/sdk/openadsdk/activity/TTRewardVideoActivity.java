package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.b.m.p.l;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.y;
import com.kbeanie.imagechooser.api.ChooserType;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static String u;
    private static String v;
    private static String w;
    private static String x;
    private static String y;
    private static com.bytedance.sdk.openadsdk.a.f.a z;
    private String m;
    private String n;
    protected int o;
    protected int p;
    protected com.bytedance.sdk.openadsdk.a.f.a q;
    private final AtomicBoolean r = new AtomicBoolean(false);
    private int s = -1;
    private boolean t;

    class a extends b.b.a.a.k.g {
        final /* synthetic */ String c;
        final /* synthetic */ boolean d;
        final /* synthetic */ int e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;
        final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, boolean z, int i, String str3, int i2, String str4) {
            super(str);
            this.c = str2;
            this.d = z;
            this.e = i;
            this.f = str3;
            this.g = i2;
            this.h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTRewardVideoActivity.this.c(0).executeRewardVideoCallback(TTRewardVideoActivity.this.f400b.c, this.c, this.d, this.e, this.f, this.g, this.h);
            } catch (Throwable th) {
                m.a("TTAD.RVA", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TTRewardVideoActivity.this.f400b.Q.t() && TTRewardVideoActivity.this.f400b.u.get()) {
                TTRewardVideoActivity.this.f400b.Q.v();
                TTRewardVideoActivity.this.f400b.T.b(8);
                TTRewardVideoActivity.this.f400b.X.sendEmptyMessageDelayed(600, 5000L);
                return;
            }
            boolean zF = false;
            if (TTRewardVideoActivity.this.f400b.a.c()) {
                if (TTRewardVideoActivity.this.f400b.a.k1()) {
                    com.bytedance.sdk.openadsdk.b.m.p.a aVar = TTRewardVideoActivity.this.f400b;
                    if (aVar.S != null) {
                        aVar.a.l(2);
                        zF = TTRewardVideoActivity.this.f400b.S.f();
                    }
                } else if (TTRewardVideoActivity.this.f400b.a.G() == 0 && !TTRewardVideoActivity.this.f400b.Q.n()) {
                    TTRewardVideoActivity.this.f400b.a.l(11);
                    if (TTRewardVideoActivity.this.f400b.Q.p()) {
                        TTRewardVideoActivity.this.f400b.a.l(12);
                    }
                    try {
                        TTRewardVideoActivity.this.f400b.T.o();
                        zF = true;
                    } catch (Exception unused) {
                    }
                }
            }
            if (zF) {
                return;
            }
            TTRewardVideoActivity.this.f400b.Q.x();
            TTRewardVideoActivity.this.f400b.L.h();
            if (!t.h(TTRewardVideoActivity.this.f400b.a) || t.g(TTRewardVideoActivity.this.f400b.a)) {
                TTRewardVideoActivity.this.finish();
            } else {
                TTRewardVideoActivity.this.b(true, true);
            }
        }
    }

    class c implements com.bytedance.sdk.openadsdk.component.reward.top.b {
        c() {
        }

        @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
        public void a(View view) {
            if (TTRewardVideoActivity.this.f400b.a.b()) {
                if (TTRewardVideoActivity.this.f400b.T.d() != null) {
                    TTRewardVideoActivity.this.f400b.a.l(2);
                    TTRewardVideoActivity.this.f400b.T.o();
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = TTRewardVideoActivity.this.f400b;
            if (!aVar.f490b && aVar.a.c() && !TTRewardVideoActivity.this.f400b.a.k1()) {
                TTRewardVideoActivity.this.f400b.a.l(13);
                try {
                    TTRewardVideoActivity.this.f400b.T.o();
                    return;
                } catch (Exception unused) {
                }
            }
            TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
            tTRewardVideoActivity.b(t.h(tTRewardVideoActivity.f400b.a), false);
        }

        @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
        public void b(View view) {
            TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
            tTRewardVideoActivity.f400b.N.b(tTRewardVideoActivity.c);
        }

        @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
        public void c(View view) {
            com.bytedance.sdk.openadsdk.b.m.q.b bVar = TTRewardVideoActivity.this.c;
            if (bVar != null && bVar.j() != null) {
                TTRewardVideoActivity.this.c.j().a(TTRewardVideoActivity.this.f400b.d);
            }
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = TTRewardVideoActivity.this.f400b;
            aVar.d = !aVar.d;
            m.a("TTAD.RVA", "rewarded_video", "will set is Mute " + TTRewardVideoActivity.this.f400b.d + " mLastVolume=" + TTRewardVideoActivity.this.f400b.O.a());
            com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = TTRewardVideoActivity.this.f400b;
            aVar2.G.b(aVar2.d);
            if (!t.m(TTRewardVideoActivity.this.f400b.a) || TTRewardVideoActivity.this.f400b.u.get()) {
                if (t.i(TTRewardVideoActivity.this.f400b.a)) {
                    com.bytedance.sdk.openadsdk.b.m.p.a aVar3 = TTRewardVideoActivity.this.f400b;
                    aVar3.O.a(aVar3.d, true);
                }
                com.bytedance.sdk.openadsdk.b.m.p.a aVar4 = TTRewardVideoActivity.this.f400b;
                aVar4.Q.b(aVar4.d);
                q qVar = TTRewardVideoActivity.this.f400b.a;
                if (qVar == null || qVar.M0() == null || TTRewardVideoActivity.this.f400b.a.M0().m() == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.b.m.p.a aVar5 = TTRewardVideoActivity.this.f400b;
                if (aVar5.G != null) {
                    if (aVar5.d) {
                        aVar5.a.M0().m().e(TTRewardVideoActivity.this.f400b.G.e());
                    } else {
                        aVar5.a.M0().m().i(TTRewardVideoActivity.this.f400b.G.e());
                    }
                }
            }
        }
    }

    class d implements com.bytedance.sdk.openadsdk.core.widget.a.c {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.widget.a f412b;

        d(boolean z, com.bytedance.sdk.openadsdk.core.widget.a aVar) {
            this.a = z;
            this.f412b = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.a.c
        public void a() {
            TTRewardVideoActivity.this.f400b.G.E();
            if (this.a) {
                TTRewardVideoActivity.this.f400b.I.a(1000L);
            }
            this.f412b.dismiss();
            TTRewardVideoActivity.this.f400b.E.set(false);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.a.c
        public void b() {
            this.f412b.dismiss();
            TTRewardVideoActivity.this.t = true;
            TTRewardVideoActivity.this.f400b.E.set(false);
            TTRewardVideoActivity.this.f400b.I.e(Integer.MAX_VALUE);
            if (!this.a) {
                TTRewardVideoActivity.this.x();
            } else if (t.g(TTRewardVideoActivity.this.f400b.a)) {
                TTRewardVideoActivity.this.f400b.Q.H();
            } else {
                TTRewardVideoActivity.this.f400b.L.h();
                TTRewardVideoActivity.this.finish();
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
            com.bytedance.sdk.openadsdk.a.f.a aVar = tTRewardVideoActivity.q;
            if (aVar != null) {
                aVar.onRewardVerify(true, tTRewardVideoActivity.f400b.a.A0(), TTRewardVideoActivity.this.f400b.a.B0(), 0, "");
            }
        }
    }

    class g implements p.b {

        class a implements Runnable {
            final /* synthetic */ int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f414b;

            a(int i, String str) {
                this.a = i;
                this.f414b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.f.a aVar = TTRewardVideoActivity.this.q;
                if (aVar != null) {
                    aVar.onRewardVerify(false, 0, "", this.a, this.f414b);
                }
            }
        }

        class b implements Runnable {
            final /* synthetic */ com.bytedance.sdk.openadsdk.core.q.k a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f415b;
            final /* synthetic */ String c;

            b(com.bytedance.sdk.openadsdk.core.q.k kVar, int i, String str) {
                this.a = kVar;
                this.f415b = i;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.a.f.a aVar = TTRewardVideoActivity.this.q;
                if (aVar != null) {
                    aVar.onRewardVerify(this.a.f667b, this.f415b, this.c, 0, "");
                }
            }
        }

        g() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.b
        public void a(com.bytedance.sdk.openadsdk.core.q.k kVar) {
            m.a("TTAD.RVA", "onVerify: " + kVar.f667b);
            int iA = kVar.c.a();
            String strB = kVar.c.b();
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                TTRewardVideoActivity.this.a("onRewardVerify", kVar.f667b, iA, strB, 0, "");
            } else {
                TTRewardVideoActivity.this.d.post(new b(kVar, iA, strB));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.b
        public void onError(int i, String str) {
            m.a("TTAD.RVA", "onError: " + i + ", " + str);
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "", i, str);
            } else {
                TTRewardVideoActivity.this.d.post(new a(i, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2, boolean z3) {
        if (!z3 && this.t && t.g(this.f400b.a)) {
            this.f400b.Q.H();
            return;
        }
        if (!o.d().e(String.valueOf(this.f400b.o))) {
            if (!z3 && this.f400b.u.get() && t.g(this.f400b.a)) {
                this.f400b.Q.H();
                return;
            } else if (z2) {
                finish();
                return;
            } else {
                x();
                return;
            }
        }
        if (this.r.get()) {
            if (t.g(this.f400b.a)) {
                this.f400b.Q.H();
                return;
            } else if (z2) {
                finish();
                return;
            } else {
                x();
                return;
            }
        }
        if (t.g(this.f400b.a) && this.f400b.Q.h().getVisibility() == 0) {
            this.f400b.Q.H();
            return;
        }
        this.f400b.E.set(true);
        this.f400b.G.B();
        if (z2) {
            this.f400b.I.n();
        }
        com.bytedance.sdk.openadsdk.core.widget.a aVar = new com.bytedance.sdk.openadsdk.core.widget.a(this);
        this.c.l = aVar;
        if (z2) {
            aVar.a(v).c(y).b(w);
        } else {
            aVar.a(u).c(x).b(w);
        }
        this.c.l.a(new d(z2, aVar)).show();
    }

    private JSONObject v() {
        String strT;
        JSONObject jSONObject = new JSONObject();
        int iF = (int) this.f400b.G.f();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_NAME, this.f400b.a.B0());
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.f400b.a.A0());
            jSONObject.put("network", com.bytedance.sdk.component.utils.p.b(getApplicationContext()));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int iL0 = this.f400b.a.L0();
            if (iL0 == 2) {
                strT = a0.e();
            } else {
                strT = iL0 == 1 ? a0.t() : "unKnow";
            }
            jSONObject.put("user_agent", strT);
            jSONObject.put("extra", this.f400b.a.O());
            jSONObject.put("media_extra", this.m);
            jSONObject.put("video_duration", this.f400b.a.N0().s());
            jSONObject.put("play_start_ts", this.o);
            jSONObject.put("play_end_ts", this.p);
            jSONObject.put("duration", iF);
            jSONObject.put("user_id", this.n);
            jSONObject.put("trans_id", com.bytedance.sdk.openadsdk.utils.q.a().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            m.b("TTAD.RVA", "", th);
            return null;
        }
    }

    private void w() {
        if (this.g) {
            return;
        }
        this.g = true;
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.a.f.a aVar = this.q;
        if (aVar != null) {
            aVar.onAdClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.bytedance.sdk.openadsdk.d.r.b.o.a aVar = new com.bytedance.sdk.openadsdk.d.r.b.o.a();
        aVar.b(this.f400b.G.e());
        aVar.c(this.f400b.G.k());
        aVar.a(this.f400b.G.d());
        aVar.a(3);
        aVar.b(this.f400b.G.c());
        com.bytedance.sdk.openadsdk.d.r.a.a.a(this.f400b.G.i(), aVar, this.f400b.G.b());
        r.a(this.f400b.o);
        this.f400b.G.a("skip");
        if (this.f400b.f490b) {
            b(true);
            if (com.bytedance.sdk.openadsdk.core.f0.o.h(this.f400b.a) && !this.f400b.A.get()) {
                finish();
            }
        } else {
            finish();
        }
        com.bytedance.sdk.openadsdk.core.i0.a aVarM0 = this.f400b.a.M0();
        if (aVarM0 != null) {
            com.bytedance.sdk.openadsdk.core.i0.d dVarM = aVarM0.m();
            long jE = this.f400b.G.e();
            dVarM.h(jE);
            dVarM.b(jE);
        }
        com.bytedance.sdk.openadsdk.q.c.e.a(this.f400b.a, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.b
    public void d() {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdVideoBarClick");
        } else {
            com.bytedance.sdk.openadsdk.a.f.a aVar = this.q;
            if (aVar != null) {
                aVar.onAdVideoBarClick();
            }
        }
        this.f400b.a.o1();
        this.f400b.a.e(true);
        if (q.c(this.f400b.a)) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.f400b;
            q qVar = aVar2.a;
            com.bytedance.sdk.openadsdk.d.c.a(qVar, aVar2.g, qVar.v0());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.j0.c.c
    public void f() {
        y();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        z = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void finish() {
        w();
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
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void n() {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.a.f.a aVar = this.q;
            if (aVar != null) {
                aVar.onAdShow();
            }
        }
        if (l()) {
            this.f400b.J.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (u == null) {
                u = com.bytedance.sdk.component.utils.t.k(this, "tt_reward_msg");
                v = com.bytedance.sdk.component.utils.t.k(this, "tt_msgPlayable");
                w = com.bytedance.sdk.component.utils.t.k(this, "tt_negtiveBtnBtnText");
                x = com.bytedance.sdk.component.utils.t.k(this, "tt_postiveBtnText");
                y = com.bytedance.sdk.component.utils.t.k(this, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            m.b("TTAD.RVA", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        w();
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("recycleRes");
        }
        this.q = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.j0.c.b
    public void onRewardBarClick(View view) {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.a.f.a aVar = this.q;
        if (aVar != null) {
            aVar.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        z = this.q;
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void p() {
        this.f400b.R.a(null, TTAdDislikeToast.getSkipText());
        this.f400b.R.d(true);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007a  */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void u() {
        int i = o.d().l(String.valueOf(this.f400b.o)).f;
        boolean z2 = true;
        if (t.m(this.f400b.a)) {
            if ((1.0d - (((double) this.f) / this.f400b.G.o())) * 100.0d < i) {
                z2 = false;
            }
        } else {
            boolean z3 = (1.0f - (((float) this.f400b.I.d()) / ((float) this.f400b.a.r0()))) * 100.0f >= ((float) i);
            int iV = o.d().v(String.valueOf(this.f400b.o));
            if (iV == 0) {
                if (!z3 || !this.f400b.Q.d().w()) {
                    z2 = false;
                }
            } else if (iV == 1) {
                z2 = z3;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            y();
        }
    }

    protected void y() {
        if (this.r.get()) {
            return;
        }
        this.r.set(true);
        boolean zX = o.d().x(String.valueOf(this.f400b.o));
        m.a("TTAD.RVA", "verifyRewardVideo: dir=" + zX);
        if (!zX) {
            o.c().a(v(), new g());
        } else if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onRewardVerify", true, this.f400b.a.A0(), this.f400b.a.B0(), 0, "");
        } else {
            this.d.post(new f());
        }
    }

    protected void a(String str) {
        a(str, false, 0, "", 0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z2, int i, String str2, int i2, String str3) {
        y.a(new a("Reward_executeMultiProcessCallback", str, z2, i, str2, i2, str3), 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.j0.c.b
    public void a(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.m.b.b()) {
            this.q = s.g().f();
        }
        if (this.q != null || bundle == null) {
            return;
        }
        this.q = z;
        z = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void a(Intent intent) {
        super.a(intent);
        this.m = intent.getStringExtra("media_extra");
        this.n = intent.getStringExtra("user_id");
    }

    class e implements b.a.a.a.a.a.a.g.c.a {
        boolean a;

        e() {
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, int i) {
            TTRewardVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            if (TTRewardVideoActivity.this.f400b.G.w()) {
                TTRewardVideoActivity.this.t();
                return;
            }
            TTRewardVideoActivity.this.f400b.G.D();
            TTRewardVideoActivity.this.y();
            TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
            if (tTRewardVideoActivity.f400b.f490b) {
                tTRewardVideoActivity.a(false, true);
            } else {
                tTRewardVideoActivity.finish();
            }
            l lVar = TTRewardVideoActivity.this.f400b.G;
            lVar.a(!lVar.q() ? 1 : 0, 2);
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void b(long j, int i) {
            if (this.a) {
                return;
            }
            this.a = true;
            TTRewardVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            TTRewardVideoActivity.this.o();
            TTRewardVideoActivity.this.y();
            TTRewardVideoActivity.this.f400b.D.set(true);
            if (TTRewardVideoActivity.this.f400b.a.a()) {
                TTRewardVideoActivity.this.f400b.a.l(1);
                TTRewardVideoActivity.this.f400b.T.o();
            }
            if (TTRewardVideoActivity.this.f400b.a.v() == 21 && !TTRewardVideoActivity.this.f400b.a.b1()) {
                TTRewardVideoActivity.this.f400b.a.c(true);
                TTRewardVideoActivity.this.f400b.T.o();
            }
            TTRewardVideoActivity.this.p = (int) (System.currentTimeMillis() / 1000);
            if (com.bytedance.sdk.openadsdk.core.f0.o.b(TTRewardVideoActivity.this.f400b.a) || com.bytedance.sdk.openadsdk.core.f0.o.f(TTRewardVideoActivity.this.f400b.a)) {
                TTRewardVideoActivity.this.b(false);
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.f0.o.h(TTRewardVideoActivity.this.f400b.a) && !TTRewardVideoActivity.this.f400b.A.get()) {
                TTRewardVideoActivity.this.f400b.a(true);
                TTRewardVideoActivity.this.f400b.R.d(true);
                return;
            }
            TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
            if (tTRewardVideoActivity.f400b.f490b) {
                tTRewardVideoActivity.b(false);
            } else {
                tTRewardVideoActivity.finish();
            }
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void h() {
            TTRewardVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            TTRewardVideoActivity.this.o();
            TTRewardVideoActivity.this.y();
            TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
            if (tTRewardVideoActivity.f400b.f490b) {
                tTRewardVideoActivity.a(false, true);
            } else {
                tTRewardVideoActivity.finish();
            }
            l lVar = TTRewardVideoActivity.this.f400b.G;
            lVar.a(!lVar.q() ? 1 : 0, 1 ^ (TTRewardVideoActivity.this.f400b.G.q() ? 1 : 0));
            TTRewardVideoActivity.this.f400b.G.D();
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, long j2) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = TTRewardVideoActivity.this.f400b;
            if (!aVar.e && aVar.G.w()) {
                TTRewardVideoActivity.this.f400b.G.B();
            }
            if (TTRewardVideoActivity.this.f400b.u.get()) {
                return;
            }
            TTRewardVideoActivity.this.d.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            if (j != TTRewardVideoActivity.this.f400b.G.n()) {
                TTRewardVideoActivity.this.o();
            }
            TTRewardVideoActivity.this.f400b.G.b(j);
            TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
            long j3 = j / 1000;
            double d = j3;
            tTRewardVideoActivity.f = (int) (tTRewardVideoActivity.f400b.G.o() - d);
            TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
            int i = tTRewardVideoActivity2.f;
            if (i >= 0) {
                tTRewardVideoActivity2.f400b.R.a(String.valueOf(i), null);
            }
            TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
            tTRewardVideoActivity3.f = (int) (tTRewardVideoActivity3.f400b.G.o() - d);
            int i2 = (int) j3;
            int iA = o.d().a(String.valueOf(TTRewardVideoActivity.this.f400b.o));
            boolean z = iA >= 0;
            if ((TTRewardVideoActivity.this.f400b.E.get() || TTRewardVideoActivity.this.f400b.v.get()) && TTRewardVideoActivity.this.f400b.G.w()) {
                TTRewardVideoActivity.this.f400b.G.B();
            }
            TTRewardVideoActivity.this.f400b.T.f(i2);
            TTRewardVideoActivity.this.a(j, j2);
            TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
            if (tTRewardVideoActivity4.f > 0) {
                tTRewardVideoActivity4.f400b.R.b(true);
                if (z && i2 >= iA) {
                    TTRewardVideoActivity.this.f400b.a(true);
                    TTRewardVideoActivity tTRewardVideoActivity5 = TTRewardVideoActivity.this;
                    tTRewardVideoActivity5.f400b.R.a(String.valueOf(tTRewardVideoActivity5.f), TTAdDislikeToast.getSkipText());
                    TTRewardVideoActivity.this.f400b.R.d(true);
                    return;
                }
                TTRewardVideoActivity tTRewardVideoActivity6 = TTRewardVideoActivity.this;
                tTRewardVideoActivity6.f400b.R.a(String.valueOf(tTRewardVideoActivity6.f), null);
            }
        }
    }

    public boolean a(long j, boolean z2) {
        com.bytedance.sdk.openadsdk.d.g gVar = new com.bytedance.sdk.openadsdk.d.g();
        gVar.a(System.currentTimeMillis(), 1.0f);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        aVar.G.a(aVar.T.e(), gVar);
        e eVar = new e();
        this.f400b.G.a(eVar);
        com.bytedance.sdk.openadsdk.core.f0.o oVar = this.f400b.T.s;
        if (oVar != null) {
            oVar.a(eVar);
        }
        boolean zA = this.f400b.G.a(j, z2, null, this.c);
        if (zA && !z2) {
            this.o = (int) (System.currentTimeMillis() / 1000);
        }
        return zA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.b
    public void b(int i) {
        if (i == 10000) {
            y();
        }
    }

    protected void a(long j, long j2) {
        long j3 = j + (((long) this.f400b.h) * 1000);
        if (this.s == -1) {
            this.s = o.d().l(String.valueOf(this.f400b.o)).f;
        }
        if (j2 <= 0) {
            return;
        }
        if (j2 >= 30000 && j3 >= 27000) {
            m.a("TTAD.RVA", "try verify reward 1");
            y();
        } else if ((j3 * 100) / j2 >= this.s) {
            m.a("TTAD.RVA", "try verify reward 2");
            y();
        }
    }
}
