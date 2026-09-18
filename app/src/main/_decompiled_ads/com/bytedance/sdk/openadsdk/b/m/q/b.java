package com.bytedance.sdk.openadsdk.b.m.q;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.b.m.p.j;
import com.bytedance.sdk.openadsdk.b.m.p.l;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RFDownloadBarLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.o;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.kbeanie.imagechooser.api.ChooserType;

/* JADX INFO: compiled from: RewardFullAdType.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends com.bytedance.sdk.openadsdk.b.m.q.a {
    protected String j;
    protected com.bytedance.sdk.openadsdk.core.c0.e k;
    public com.bytedance.sdk.openadsdk.core.widget.a l;
    public LinearLayout m;
    private com.bytedance.sdk.openadsdk.k.e n;

    /* JADX INFO: compiled from: RewardFullAdType.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a.T.b().performClick();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.m.q.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RewardFullAdType.java */
    class RunnableC0188b implements Runnable {
        RunnableC0188b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.a.O.a() > 0) {
                b.this.a.O.a(false);
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullAdType.java */
    public interface c {
        void a(boolean z);
    }

    public b(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        super(aVar);
    }

    static void b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(com.bytedance.sdk.openadsdk.utils.h.j);
        frameLayout.addView(pAGFrameLayout, new FrameLayout.LayoutParams(-1, -1));
        pAGFrameLayout.addView(a(context));
        RFDownloadBarLayout rFDownloadBarLayout = new RFDownloadBarLayout(context);
        rFDownloadBarLayout.setId(com.bytedance.sdk.openadsdk.utils.h.l);
        rFDownloadBarLayout.setPadding(b0.a(context, 15.0f), 0, 0, 0);
        rFDownloadBarLayout.setBackgroundColor(t.c(context, "tt_download_bar_background_new"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, b0.a(context, 90.0f));
        layoutParams.gravity = 80;
        frameLayout.addView(rFDownloadBarLayout, layoutParams);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(com.bytedance.sdk.openadsdk.utils.h.m);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setVisibility(8);
        frameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setId(com.bytedance.sdk.openadsdk.utils.h.n);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        frameLayout.addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView2 = new SSWebView(context, true);
        sSWebView2.setId(com.bytedance.sdk.openadsdk.utils.h.o);
        sSWebView2.setVisibility(8);
        frameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
    }

    private void c(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        frameLayout.addView(a(context));
        RFDownloadBarLayout rFDownloadBarLayout = new RFDownloadBarLayout(context);
        rFDownloadBarLayout.setBackgroundResource(t.e(context, "tt_reward_full_new_bar_bg"));
        rFDownloadBarLayout.setPadding(b0.a(context, 15.0f), 0, 0, 0);
        rFDownloadBarLayout.setId(com.bytedance.sdk.openadsdk.utils.h.l);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, b0.a(context, 76.0f));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = b0.a(context, 10.0f);
        layoutParams.rightMargin = b0.a(context, 10.0f);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        layoutParams.bottomMargin = b0.a(context, 14.0f);
        frameLayout.addView(rFDownloadBarLayout, layoutParams);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(com.bytedance.sdk.openadsdk.utils.h.m);
        pAGLinearLayout.setVisibility(8);
        frameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        sSWebView.setId(com.bytedance.sdk.openadsdk.utils.h.n);
        frameLayout.addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView2 = new SSWebView(context, true);
        sSWebView2.setVisibility(8);
        sSWebView2.setId(com.bytedance.sdk.openadsdk.utils.h.o);
        frameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
    }

    public void A() {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        if (aVar.s) {
            return;
        }
        aVar.R.d();
        this.a.T.b(0);
    }

    public void B() {
    }

    public void C() {
        this.a.R.f();
        this.a.R.d(true);
    }

    public abstract void a(FrameLayout frameLayout);

    @Override // com.bytedance.sdk.openadsdk.b.m.q.a
    public void a(com.bytedance.sdk.openadsdk.core.j0.c.b bVar, y yVar) {
        super.a(bVar, yVar);
        if (this.a.V.l()) {
            this.a.Q.d(false);
        }
        if (com.bytedance.sdk.openadsdk.core.f0.t.h(this.a.a)) {
            this.a.I.o();
        }
    }

    public void d() {
        if (!q() && ((this instanceof g) || (this instanceof h))) {
            this.a.L.g();
        } else {
            if (this.h.a(this.e.h(), false)) {
                return;
            }
            this.i.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            y();
            l lVar = this.e;
            lVar.a(!lVar.q() ? 1 : 0, 4);
        }
    }

    public void e() {
        com.bytedance.sdk.openadsdk.core.widget.a aVar = this.l;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.l.dismiss();
    }

    protected boolean f() {
        return true;
    }

    public RFEndCardBackUpLayout g() {
        return new RFEndCardBackUpLayout(this.a.V);
    }

    public View h() {
        PAGRelativeLayout pAGRelativeLayout;
        if (this.f514b.p0() != 5) {
            pAGRelativeLayout = new PAGRelativeLayout(this.a.V);
            pAGRelativeLayout.setId(com.bytedance.sdk.openadsdk.utils.h.f1);
        } else {
            pAGRelativeLayout = null;
        }
        m.a("TTAD.RFAdType", "getLoadingFrameView" + pAGRelativeLayout);
        return pAGRelativeLayout;
    }

    protected int i() {
        float f = 100.0f;
        if (this.f514b.p0() == 1 && !com.bytedance.sdk.openadsdk.core.f0.t.h(this.f514b)) {
            f = 20.0f;
        }
        return b0.a(this.a.W, f);
    }

    public c j() {
        return null;
    }

    public View k() {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this.a.V);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(this.a.V);
        pAGRelativeLayout.setId(520093708);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b0.a(this.a.V, 28.0f), b0.a(this.a.V, 28.0f));
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = b0.a(this.a.V, 20.0f);
        layoutParams.rightMargin = b0.a(this.a.V, 24.0f);
        pAGRelativeLayout.setLayoutParams(layoutParams);
        pAGRelativeLayout.setBackgroundResource(t.e(this.a.V, "tt_mute_btn_bg"));
        pAGRelativeLayout.setGravity(17);
        pAGRelativeLayout.setVisibility(8);
        pAGRelativeLayout.setContentDescription(t.k(this.a.V, "tt_ad_close_text"));
        PAGImageView pAGImageView = new PAGImageView(this.a.V);
        pAGImageView.setId(520093706);
        pAGImageView.setLayoutParams(new RelativeLayout.LayoutParams(b0.a(this.a.V, 12.0f), b0.a(this.a.V, 12.0f)));
        pAGImageView.setImageResource(t.e(this.a.V, "tt_video_close_drawable"));
        pAGImageView.setContentDescription(t.k(this.a.V, "tt_ad_close_text"));
        pAGRelativeLayout.addView(pAGImageView);
        PAGTextView pAGTextView = new PAGTextView(this.a.V);
        pAGTextView.setId(520093757);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b0.a(this.a.V, 32.0f), b0.a(this.a.V, 14.0f));
        layoutParams2.gravity = 8388691;
        layoutParams2.leftMargin = b0.a(this.a.V, 16.0f);
        layoutParams2.bottomMargin = b0.a(this.a.V, 100.0f);
        pAGTextView.setLayoutParams(layoutParams2);
        pAGTextView.setBackgroundResource(t.e(this.a.V, "tt_ad_logo_new"));
        pAGTextView.setGravity(17);
        PAGImageView pAGImageView2 = new PAGImageView(this.a.V);
        pAGImageView2.setId(com.bytedance.sdk.openadsdk.utils.h.g1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(b0.a(this.a.V, 32.0f), b0.a(this.a.V, 14.0f));
        layoutParams3.gravity = 8388693;
        layoutParams3.rightMargin = b0.a(this.a.V, 7.0f);
        layoutParams3.bottomMargin = b0.a(this.a.V, 100.0f);
        pAGImageView2.setLayoutParams(layoutParams3);
        pAGImageView2.setPadding(b0.a(this.a.V, 9.0f), 0, b0.a(this.a.V, 9.0f), 0);
        pAGImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        PlayableLoadingView playableLoadingView = new PlayableLoadingView(this.a.V);
        playableLoadingView.setId(com.bytedance.sdk.openadsdk.utils.h.h1);
        playableLoadingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        playableLoadingView.setClickable(true);
        playableLoadingView.setFocusable(true);
        View topProxyLayout = new TopProxyLayout(this.a.V);
        topProxyLayout.setId(com.bytedance.sdk.openadsdk.utils.h.i1);
        topProxyLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        pAGFrameLayout.addView(pAGRelativeLayout);
        pAGFrameLayout.addView(pAGTextView);
        pAGFrameLayout.addView(pAGImageView2);
        pAGFrameLayout.addView(playableLoadingView);
        pAGFrameLayout.addView(topProxyLayout);
        return pAGFrameLayout;
    }

    public void l() {
        this.k = this.a.L.e();
    }

    protected final void m() {
        this.a.Q.k();
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        String str = aVar.f ? "reward_endcard" : "fullscreen_endcard";
        aVar.Q.a(Boolean.valueOf(aVar.V.m()), this.n, str);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
        aVar2.Q.a(str, aVar2.V);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar3 = this.a;
        aVar3.I.a(this.n, aVar3.d);
        this.a.Q.E();
    }

    public void n() {
        LinearLayout linearLayout = (LinearLayout) this.a.V.findViewById(com.bytedance.sdk.openadsdk.utils.h.m);
        this.m = linearLayout;
        b0.a((View) linearLayout, 8);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        aVar.P = new com.bytedance.sdk.openadsdk.common.f(aVar.V, aVar.a, "landingpage_endcard");
        this.a.P.a().setOnClickListener(new a());
        this.m.addView(this.a.P.b(), new LinearLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
        aVar2.Q.a(aVar2.P);
    }

    public abstract void o();

    public void p() {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        aVar.K.a(aVar.f);
        this.a.T.f();
        this.a.T.d(i());
        this.a.S.c();
        if (!this.a.a.k1()) {
            if (this.a.s) {
                n();
            }
            this.a.Q.j();
        }
        this.a.I.f();
        this.a.R.c();
        if (com.bytedance.sdk.openadsdk.core.f0.t.i(this.a.a)) {
            this.a.Q.c().setBackgroundColor(-16777216);
            this.a.Q.h().setBackgroundColor(-16777216);
            this.a.R.c(true);
            if (com.bytedance.sdk.openadsdk.core.f0.t.h(this.a.a)) {
                this.a.T.s();
                b0.a((View) this.a.Q.c(), 4);
                b0.a((View) this.a.Q.h(), 0);
            }
        }
        if (o.b(this.a.a) || o.f(this.a.a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
        com.bytedance.sdk.openadsdk.component.reward.view.e eVar = aVar2.T;
        int iA = b0.a(aVar2.W, aVar2.l);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar3 = this.a;
        eVar.a(iA, b0.a(aVar3.W, aVar3.m));
        this.a.H.b();
        if (com.bytedance.sdk.openadsdk.core.f0.t.h(this.a.a)) {
            this.a.Q.d(true);
            this.a.Q.E();
            a(false, false, false);
        } else if (this.a.V.r()) {
            this.a.T.a(0);
        }
    }

    public abstract boolean q();

    public abstract boolean r();

    public void s() {
        int iA;
        com.bytedance.sdk.openadsdk.b.m.p.g gVar;
        j jVar;
        Log.d("TTAD.RFAdType", "onBackPressed: ");
        if (com.bytedance.sdk.openadsdk.core.o.d().u(String.valueOf(this.a.o)) == 1) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
            if (aVar.f) {
                iA = com.bytedance.sdk.openadsdk.core.f0.t.h(aVar.a) ? com.bytedance.sdk.openadsdk.core.o.d().a(String.valueOf(this.a.o), true) : com.bytedance.sdk.openadsdk.core.o.d().a(String.valueOf(this.a.o));
            } else {
                iA = com.bytedance.sdk.openadsdk.core.f0.t.h(aVar.a) ? com.bytedance.sdk.openadsdk.core.o.d().a(String.valueOf(this.a.o), false) : com.bytedance.sdk.openadsdk.core.o.d().r(String.valueOf(this.a.o));
            }
            com.bytedance.sdk.openadsdk.component.reward.view.e eVar = this.a.T;
            if (eVar != null && eVar.c()) {
                com.bytedance.sdk.openadsdk.component.reward.view.e eVar2 = this.a.T;
                if (eVar2 != null) {
                    eVar2.b().performClick();
                    return;
                }
                return;
            }
            if ((!this.a.u.get() || com.bytedance.sdk.openadsdk.core.f0.t.h(this.a.a)) && iA != -1) {
                l lVar = this.a.G;
                if (((lVar == null || lVar.n() < iA * 1000) && ((gVar = this.a.I) == null || gVar.a() - this.a.I.d() < iA)) || (jVar = this.a.R) == null) {
                    return;
                }
                jVar.a();
            }
        }
    }

    public void t() {
        Log.d("TTAD.RFAdType", "onDestroy: ");
        com.bytedance.sdk.openadsdk.component.reward.view.c cVar = this.a.J;
        if (cVar != null) {
            cVar.b();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.e eVar = this.a.T;
        if (eVar != null) {
            eVar.j();
        }
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        aVar.G.a(aVar.f);
        if (!r() && !this.a.u.get()) {
            this.a.Q.a();
        }
        this.a.Q.w();
        this.a.I.k();
        this.a.T.q();
        this.a.S.e();
    }

    public void u() {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        if (aVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.view.e eVar = aVar.T;
        if (eVar != null) {
            eVar.k();
        }
        this.a.e = false;
        m.a("TTAD.RFAdType", "onPause mIsActivityShow=" + this.a.e + " mIsMute=" + this.a.d);
        if (!this.a.v.get()) {
            this.a.G.x();
        }
        z();
        this.a.Q.B();
        this.a.I.l();
        if (this.a.u.get()) {
            this.a.F.set(true);
        }
    }

    public void v() {
    }

    public void w() {
        if (this.a.u.get()) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
            if (aVar.s || !aVar.F.getAndSet(false)) {
                return;
            }
            int i = this.a.t;
            if (i >= 0 || i == -1) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 700;
                com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
                messageObtain.arg1 = aVar2.t;
                aVar2.X.sendMessage(messageObtain);
            }
        }
    }

    public void x() {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        if (aVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.view.e eVar = aVar.T;
        if (eVar != null) {
            eVar.m();
        }
        m.a("TTAD.RFAdType", "onStop mIsMute=" + this.a.d + " mLast=" + this.a.O.a() + " mVolume=" + DeviceUtils.d());
        this.a.Q.D();
        com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
        if (aVar2.d) {
            aVar2.V.runOnUiThread(new RunnableC0188b());
        }
    }

    public void y() {
        this.e.D();
        a(false, true, false);
        if (this.a.f) {
            this.h.b(10000);
        }
    }

    public void z() {
        this.i.removeMessages(ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
    }

    private void e(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(context);
        pAGRelativeLayout.setBackgroundColor(-16777216);
        frameLayout.addView(pAGRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        int i = com.bytedance.sdk.openadsdk.utils.h.k;
        pAGFrameLayout.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, b0.a(context, 211.0f));
        layoutParams.addRule(13);
        pAGRelativeLayout.addView(pAGFrameLayout, layoutParams);
        View view = new View(context);
        view.setVisibility(8);
        view.setId(com.bytedance.sdk.openadsdk.utils.h.p);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(2, i);
        pAGRelativeLayout.addView(view, layoutParams2);
        RFDownloadBarLayout rFDownloadBarLayout = new RFDownloadBarLayout(context);
        rFDownloadBarLayout.setId(com.bytedance.sdk.openadsdk.utils.h.l);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(b0.a(context, 280.0f), b0.a(context, 70.0f));
        layoutParams3.addRule(2, i);
        layoutParams3.addRule(14);
        layoutParams3.bottomMargin = b0.a(context, 33.0f);
        pAGRelativeLayout.addView(rFDownloadBarLayout, layoutParams3);
        View view2 = new View(context);
        view2.setId(com.bytedance.sdk.openadsdk.utils.h.q0);
        view2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(3, i);
        pAGRelativeLayout.addView(view2, layoutParams4);
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setLines(1);
        pAGTextView.setGravity(17);
        pAGTextView.setText(t.j(context, "tt_video_download_apk"));
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 15.0f);
        pAGTextView.setBackgroundResource(t.e(context, "tt_reward_video_download_btn_bg"));
        pAGTextView.setId(520093705);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(b0.a(context, 260.0f), b0.a(context, 36.0f));
        layoutParams5.addRule(3, i);
        layoutParams5.addRule(14);
        layoutParams5.topMargin = b0.a(context, 70.0f);
        pAGRelativeLayout.addView(pAGTextView, layoutParams5);
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        sSWebView.setId(com.bytedance.sdk.openadsdk.utils.h.n);
        pAGRelativeLayout.addView(sSWebView, new RelativeLayout.LayoutParams(-1, -1));
        SSWebView sSWebView2 = new SSWebView(context, true);
        sSWebView2.setVisibility(8);
        sSWebView2.setId(com.bytedance.sdk.openadsdk.utils.h.o);
        pAGRelativeLayout.addView(sSWebView2, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(RewardFullBaseLayout rewardFullBaseLayout) {
        int iP0 = this.f514b.p0();
        if (iP0 == 1 && !com.bytedance.sdk.openadsdk.core.f0.t.h(this.f514b)) {
            e(rewardFullBaseLayout);
            return;
        }
        if (iP0 == 3) {
            c(rewardFullBaseLayout);
        } else if (iP0 == 5) {
            d(rewardFullBaseLayout);
        } else {
            b(rewardFullBaseLayout);
        }
    }

    private void d(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        frameLayout.addView(a(context));
        RFDownloadBarLayout rFDownloadBarLayout = new RFDownloadBarLayout(context);
        rFDownloadBarLayout.setBackgroundResource(t.e(context, "tt_reward_full_new_bar_bg"));
        rFDownloadBarLayout.setPadding(b0.a(context, 15.0f), 0, 0, 0);
        rFDownloadBarLayout.setId(com.bytedance.sdk.openadsdk.utils.h.l);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, b0.a(context, 76.0f));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = b0.a(context, 10.0f);
        layoutParams.rightMargin = b0.a(context, 10.0f);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        layoutParams.bottomMargin = b0.a(context, 14.0f);
        frameLayout.addView(rFDownloadBarLayout, layoutParams);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(com.bytedance.sdk.openadsdk.utils.h.m);
        pAGLinearLayout.setVisibility(8);
        frameLayout.addView(pAGLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(context, true);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        sSWebView.setId(com.bytedance.sdk.openadsdk.utils.h.n);
        frameLayout.addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        SSWebView sSWebView2 = new SSWebView(context, true);
        sSWebView2.setVisibility(8);
        sSWebView2.setId(com.bytedance.sdk.openadsdk.utils.h.o);
        frameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
    }

    public void a(boolean z, boolean z2, boolean z3) {
        this.a.S.a(z, z2, z3, this);
    }

    public void a(com.bytedance.sdk.openadsdk.k.e eVar) {
        this.n = eVar;
        b();
        if (!this.a.a.k1() && f()) {
            m();
        }
        if (f()) {
            this.a.S.d();
        }
        if (o.b(this.a.a)) {
            this.i.sendEmptyMessageDelayed(500, 100L);
        }
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        aVar.T.a(aVar.k == 100.0f);
        l();
        o();
    }

    public void a(Message message) {
        m.a("TTAD.RFAdType", "handleMsg: " + message.what);
        int i = message.what;
        if (i == 1) {
            C();
            return;
        }
        if (i == 300) {
            y();
            l lVar = this.a.G;
            lVar.a(!lVar.q() ? 1 : 0, 1 ^ (this.a.G.q() ? 1 : 0));
            if (this.a.a.M0() == null || this.a.a.M0().m() == null) {
                return;
            }
            this.a.a.M0().m().a(com.bytedance.sdk.openadsdk.core.i0.k.a.GENERAL_LINEAR_AD_ERROR);
            return;
        }
        if (i == 400) {
            this.a.G.D();
            a(false, true, false);
            return;
        }
        if (i == 500) {
            if (!com.bytedance.sdk.openadsdk.core.f0.t.i(this.a.a)) {
                this.a.R.c(false);
            }
            SSWebView sSWebViewC = this.a.Q.c();
            if (sSWebViewC != null && sSWebViewC.getWebView() != null) {
                sSWebViewC.p();
                sSWebViewC.getWebView().resumeTimers();
            }
            if (this.a.Q.c() != null) {
                this.a.Q.a(1.0f);
                this.a.T.a(1.0f);
            }
            if (!this.a.V.m() && this.a.G.w() && this.a.C.get()) {
                this.a.G.D();
                return;
            }
            return;
        }
        if (i == 600) {
            A();
            return;
        }
        if (i != 700) {
            return;
        }
        int i2 = message.arg1;
        if (this.a.F.get()) {
            return;
        }
        if (i2 > 0) {
            this.a.R.e();
            this.a.R.a((i2 / 1000) + "s");
            this.a.R.d(false);
            Message messageObtain = Message.obtain();
            messageObtain.what = 700;
            messageObtain.arg1 = i2 - 1000;
            this.a.t -= 1000;
            this.i.sendMessageDelayed(messageObtain, 1000L);
            return;
        }
        this.i.removeMessages(700);
        if (com.bytedance.sdk.openadsdk.core.f0.t.g(this.f514b) && this.a.Q.u()) {
            C();
        } else {
            A();
        }
    }

    protected static FrameLayout a(Context context) {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
        pAGFrameLayout.setId(com.bytedance.sdk.openadsdk.utils.h.k);
        pAGFrameLayout.setBackgroundColor(-16777216);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        pAGFrameLayout.setLayoutParams(layoutParams);
        return pAGFrameLayout;
    }
}
