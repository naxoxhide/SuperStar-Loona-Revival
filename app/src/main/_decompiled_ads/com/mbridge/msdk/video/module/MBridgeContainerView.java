package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.video.dynview.moffer.a;
import com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView;
import com.mbridge.msdk.video.module.a.a.i;
import com.mbridge.msdk.video.module.a.a.k;
import com.mbridge.msdk.video.module.a.a.l;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.video.signal.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MBridgeContainerView extends MBridgeBaseView implements e, g {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private String Q;
    private b R;
    private boolean S;
    private boolean T;
    private List<CampaignEx> U;
    private MBridgePlayableView n;
    private MBridgeClickCTAView o;
    private MBridgeClickMiniCardView p;
    private MBridgeNativeEndCardView q;
    private MBridgeH5EndCardView r;
    private MBridgeVastEndCardView s;
    private MBridgeLandingPageView t;
    private MBridgeVideoEndCoverView u;
    private MBridgeAlertWebview v;
    private MBridgeOrderCampView w;
    private String x;
    private int y;
    private int z;

    public void setJSFactory(b bVar) {
        this.R = bVar;
    }

    public void addOrderViewData(List<CampaignEx> list) {
        if (list == null) {
            return;
        }
        this.U = list;
    }

    public int getVideoSkipTime() {
        return this.I;
    }

    public void setVideoSkipTime(int i) {
        this.I = i;
    }

    public MBridgeContainerView(Context context) {
        super(context);
        this.z = 1;
        this.A = 1;
        this.B = 1;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.S = false;
        this.T = false;
        this.U = new ArrayList();
    }

    public MBridgeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = 1;
        this.A = 1;
        this.B = 1;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.S = false;
        this.T = false;
        this.U = new ArrayList();
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        setVisibility(0);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u};
        for (int i = 0; i < 8; i++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i];
            if (mBridgeBaseView != null && (mBridgeBaseView instanceof MBridgeClickMiniCardView)) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            } else if (mBridgeBaseView != null && mBridgeBaseView.getVisibility() == 0 && mBridgeBaseView.getParent() != null && !isLast()) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void preLoadData(final b bVar) {
        this.R = bVar;
        if (this.f2526b != null) {
            if (this.f2526b.getPlayable_ads_without_video() != 2) {
                b(this.y);
                if (this.f2526b.isDynamicView()) {
                    try {
                        a(bVar, Integer.valueOf(this.f2526b.getVideo_end_type()));
                    } catch (Throwable th) {
                        aa.d(MBridgeBaseView.TAG, th.getMessage());
                        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                                mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f2526b.getVideo_end_type()));
                            }
                        });
                    }
                    if (!af.j(this.f2526b.getendcard_url())) {
                        try {
                            String strA = al.a(this.f2526b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(strA) && Integer.parseInt(strA) == 1) {
                                a.a().a(this.f2526b, 2);
                            }
                        } catch (Exception e) {
                            aa.d(MBridgeBaseView.TAG, e.getMessage());
                        }
                    }
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f2526b.getVideo_end_type()));
                        }
                    }, getVideoSkipTime());
                }
            } else {
                if (this.n == null) {
                    this.n = new MBridgePlayableView(this.a);
                }
                this.n.setCloseDelayShowTime(this.A);
                this.n.setPlayCloseBtnTm(this.B);
                this.n.setCampaign(this.f2526b);
                this.n.setNotifyListener(new i(this.e) { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.4
                    @Override // com.mbridge.msdk.video.module.a.a.i, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
                    public final void a(int i, Object obj) {
                        super.a(i, obj);
                        if (i == 100) {
                            MBridgeContainerView.this.webviewshow();
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.onConfigurationChanged(mBridgeContainerView.getResources().getConfiguration());
                            n nVar = new n();
                            nVar.m(MBridgeContainerView.this.f2526b.getRequestId());
                            nVar.o(MBridgeContainerView.this.f2526b.getRequestIdNotice());
                            nVar.q(MBridgeContainerView.this.f2526b.getId());
                            nVar.b(MBridgeContainerView.this.f2526b.isMraid() ? n.a : n.f2098b);
                            com.mbridge.msdk.foundation.same.report.n.a(nVar, MBridgeContainerView.this.a, MBridgeContainerView.this.x);
                        }
                    }
                });
                this.n.preLoadData(bVar);
            }
            g();
        }
    }

    public void showPlayableView() {
        if (this.f2526b == null || this.H) {
            return;
        }
        removeAllViews();
        setMatchParent();
        if (this.n == null) {
            preLoadData(this.R);
        }
        addView(this.n);
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.setUnitId(this.x);
            if (this.f2526b != null && this.f2526b.isMraid() && this.f2526b.getPlayable_ads_without_video() == 2) {
                this.n.setCloseVisible(0);
            }
            this.n.setNotchValue(this.Q, this.L, this.M, this.N, this.O);
        }
        this.T = true;
        bringToFront();
    }

    @Override // com.mbridge.msdk.video.signal.e
    public boolean showAlertWebView() {
        MBridgeAlertWebview mBridgeAlertWebview = this.v;
        if (mBridgeAlertWebview == null || !mBridgeAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (!(viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1) && !this.T) {
            removeAllViews();
            bringToFront();
            this.S = true;
        }
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
            return false;
        }
        if (this.v == null) {
            g();
        }
        MBridgeAlertWebview mBridgeAlertWebview2 = this.v;
        if (mBridgeAlertWebview2 != null && mBridgeAlertWebview2.getParent() != null) {
            removeView(this.v);
        }
        addView(this.v);
        setBackgroundColor(0);
        this.v.webviewshow();
        return true;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void showVideoClickView(int i) {
        if (this.f2526b != null) {
            if (i == -1) {
                if (isLast() || endCardShowing()) {
                    return;
                }
                h();
                return;
            }
            if (i == 1) {
                if (this.C) {
                    return;
                }
                MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
                if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getParent() != null) {
                    removeView(this.r);
                }
                MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
                if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
                    removeView(this.p);
                }
                MBridgeClickCTAView mBridgeClickCTAView = this.o;
                if (mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null) {
                    try {
                        if (this.f2526b != null && this.f2526b.getPlayable_ads_without_video() == 1) {
                            this.T = true;
                            if (this.o == null) {
                                b(-1);
                            }
                            if (this.o != null && (this.f2526b == null || !this.f2526b.isDynamicView())) {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(12, -1);
                                addView(this.o, 0, layoutParams);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                    return;
                }
                return;
            }
            if (i != 2) {
                return;
            }
            MBridgeClickCTAView mBridgeClickCTAView2 = this.o;
            if (mBridgeClickCTAView2 != null && mBridgeClickCTAView2.getParent() != null) {
                removeView(this.o);
            }
            MBridgeAlertWebview mBridgeAlertWebview = this.v;
            if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
                MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.p;
                if (mBridgeClickMiniCardView2 == null || mBridgeClickMiniCardView2.getParent() == null) {
                    try {
                        if (this.f2526b != null && this.f2526b.getPlayable_ads_without_video() == 1) {
                            setMatchParent();
                            f();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (miniCardLoaded()) {
                    MBridgeH5EndCardView mBridgeH5EndCardView2 = this.r;
                    if (mBridgeH5EndCardView2 != null && mBridgeH5EndCardView2.getParent() != null) {
                        removeView(this.r);
                    }
                    this.e.a(112, "");
                    if (this.f2526b != null && !this.f2526b.isHasReportAdTrackPause()) {
                        this.f2526b.setHasReportAdTrackPause(true);
                        com.mbridge.msdk.video.module.b.b.f(this.a, this.f2526b);
                    }
                    if (this.E) {
                        this.e.a(115, "");
                    } else {
                        this.T = true;
                        bringToFront();
                        webviewshow();
                        onConfigurationChanged(getResources().getConfiguration());
                    }
                    this.D = true;
                    return;
                }
                h();
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void showEndcard(int i) {
        if (this.f2526b != null) {
            if (i == 1) {
                this.e.a(104, "");
            } else if (i == 100) {
                if (this.f2526b.getPlayable_ads_without_video() == 2) {
                    this.H = true;
                }
                a(this.n);
                setMatchParent();
                e();
            } else if (i == 3) {
                removeAllViews();
                setMatchParent();
                if (this.s == null) {
                    a(this.R, 3);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.s, layoutParams);
                this.s.notifyShowListener();
                this.T = true;
                bringToFront();
            } else if (i == 4) {
                this.e.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.t == null) {
                    a(this.R, 4);
                }
                this.t.setUnitId(this.x);
                this.t.preLoadData(this.R);
                addView(this.t);
                this.T = true;
                bringToFront();
            } else if (i == 5) {
                this.e.a(106, "");
            } else {
                removeAllViews();
                setMatchParent();
                this.T = true;
                bringToFront();
                a();
                this.e.a(117, "");
            }
        }
        this.C = true;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        MBridgeVideoEndCoverView mBridgeVideoEndCoverView = this.u;
        if (mBridgeVideoEndCoverView == null) {
            b bVar = this.R;
            this.R = bVar;
            if (mBridgeVideoEndCoverView == null) {
                MBridgeVideoEndCoverView mBridgeVideoEndCoverView2 = new MBridgeVideoEndCoverView(this.a);
                this.u = mBridgeVideoEndCoverView2;
                mBridgeVideoEndCoverView2.setCampaign(this.f2526b);
                this.u.setNotifyListener(new i(this.e));
                this.u.preLoadData(bVar);
            }
        }
        addView(this.u);
        onConfigurationChanged(getResources().getConfiguration());
        this.T = true;
        bringToFront();
    }

    public void showOrderCampView() {
        MBridgeOrderCampView mBridgeOrderCampView = new MBridgeOrderCampView(this.a);
        this.w = mBridgeOrderCampView;
        mBridgeOrderCampView.setCampaignExes(this.U);
        if (this.e != null && (this.e instanceof k)) {
            ((k) this.e).a(this.U);
        }
        this.w.setNotifyListener(new i(this.e));
        this.w.setRewarded(this.K);
        this.w.setNotchPadding(this.L, this.M, this.N, this.O);
        this.w.setCampOrderViewBuildCallback(new com.mbridge.msdk.video.dynview.e.b() { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.3
            @Override // com.mbridge.msdk.video.dynview.e.b
            public final void a() {
                if (MBridgeContainerView.this.e != null) {
                    MBridgeContainerView.this.e.a(117, "");
                }
            }

            @Override // com.mbridge.msdk.video.dynview.e.b
            public final void b() {
                if (MBridgeContainerView.this.f2526b.getAdSpaceT() == 2) {
                    MBridgeContainerView.this.showVideoEndCover();
                } else {
                    MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                    mBridgeContainerView.showEndcard(mBridgeContainerView.f2526b.getVideo_end_type());
                }
            }
        });
        this.w.createView(this);
    }

    @Override // com.mbridge.msdk.video.signal.e
    public boolean endCardShowing() {
        return this.C;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public boolean miniCardShowing() {
        return this.D;
    }

    public boolean miniCardLoaded() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        return mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.isLoadSuccess();
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void toggleCloseBtn(int i) {
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.toggleCloseBtn(i);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.toggleCloseBtn(i);
        }
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void notifyCloseBtn(int i) {
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.notifyCloseBtn(i);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.notifyCloseBtn(i);
        }
    }

    public void triggerCloseBtn(String str) {
        try {
            HashMap map = new HashMap();
            map.put("type", "2");
            m.a().c(this.f2526b.getCurrentLRid(), "2000152", map);
            m.a().a("2000134", this.f2526b, new HashMap());
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
        if (this.f2526b != null) {
            this.e.a(122, "");
            this.e.a(104, "");
        }
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void readyStatus(int i) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.readyStatus(i);
        }
    }

    public void handlerPlayableException(String str) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.handlerPlayableException(str);
            if (!this.J) {
                return;
            }
        }
        a();
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMiniCardLocation(i, i2, i3, i4);
            this.p.setRadius(i5);
            this.p.setCloseVisible(8);
            this.p.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            f();
            if (this.G) {
                return;
            }
            this.G = true;
            this.e.a(109, "");
            this.e.a(117, "");
        }
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void resizeMiniCard(int i, int i2, int i3) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.resizeMiniCard(i, i2);
            this.p.setRadius(i3);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            f();
        }
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void configurationChanged(int i, int i2, int i3) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView == null || mBridgeClickMiniCardView.getVisibility() != 0) {
            return;
        }
        this.p.resizeMiniCard(i, i2);
    }

    public void webviewshow() {
        try {
            HashMap map = new HashMap();
            map.put("type", "3");
            map.put("update", "1");
            m.a().a("2000133", this.f2526b, map);
        } catch (Exception unused) {
        }
        a(this.n, this.p, this.r, this.v);
    }

    public void install(CampaignEx campaignEx) {
        this.e.a(105, campaignEx);
    }

    public void orientation(Configuration configuration) {
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.n, this.p, this.r, this.v};
        for (int i = 0; i < 4; i++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0) {
                mBridgeH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void setNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        super.setNotifyListener(aVar);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u};
        for (int i = 0; i < 8; i++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i];
            if (mBridgeBaseView != null) {
                if (mBridgeBaseView instanceof MBridgeClickMiniCardView) {
                    mBridgeBaseView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(this.p, aVar));
                } else {
                    mBridgeBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (view != null) {
            a(view);
            super.addView(view);
        } else {
            aa.d(MBridgeBaseView.TAG, "view is null");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            a(view);
            super.addView(view, layoutParams);
        } else {
            aa.d(MBridgeBaseView.TAG, "view is null");
        }
    }

    public boolean canBackPress() {
        if (this.q != null) {
            return false;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            return mBridgeH5EndCardView.canBackPress();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.t;
        if (mBridgeLandingPageView != null) {
            return mBridgeLandingPageView.canBackPress();
        }
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            return mBridgePlayableView.canBackPress();
        }
        return false;
    }

    public boolean endcardIsPlayable() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        return mBridgeH5EndCardView != null && mBridgeH5EndCardView.isPlayable();
    }

    public void setShowingTransparent(boolean z) {
        this.E = z;
    }

    public boolean getShowingTransparent() {
        return this.E;
    }

    public String getUnitID() {
        return this.x;
    }

    public void setUnitID(String str) {
        this.x = str;
    }

    public void setVideoInteractiveType(int i) {
        if (this.f2526b != null && this.f2526b.isDynamicView()) {
            int iA = com.mbridge.msdk.video.dynview.i.a.a(this.f2526b);
            if (iA == 100) {
                this.y = i;
                return;
            } else {
                this.y = iA;
                return;
            }
        }
        this.y = i;
    }

    public void setEndscreenType(int i) {
        this.z = i;
    }

    public int getVideoInteractiveType() {
        return this.y;
    }

    public void setCloseDelayTime(int i) {
        this.A = i;
    }

    public void setPlayCloseBtnTm(int i) {
        this.B = i;
    }

    private void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th) {
                aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    private void a() {
        if (this.f2526b != null) {
            boolean zIsDynamicView = this.f2526b.isDynamicView();
            boolean zJ = af.j(this.f2526b.getendcard_url());
            if (zIsDynamicView && !zJ) {
                e();
                return;
            }
        }
        if (this.z == 2 && !this.J) {
            b();
        } else {
            e();
        }
    }

    private void b() {
        if (this.r == null) {
            a(this.R, 2);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.isLoadSuccess()) {
            this.J = true;
            addView(this.r);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.r.excuteTask();
            this.r.setNotchValue(this.Q, this.L, this.M, this.N, this.O);
            n nVar = new n();
            nVar.m(this.f2526b.getRequestId());
            nVar.o(this.f2526b.getRequestIdNotice());
            nVar.q(this.f2526b.getId());
            nVar.b(this.f2526b.isMraid() ? n.a : n.f2098b);
            com.mbridge.msdk.foundation.same.report.n.a(nVar, this.a, this.x);
        } else {
            e();
            MBridgeH5EndCardView mBridgeH5EndCardView2 = this.r;
            if (mBridgeH5EndCardView2 != null) {
                mBridgeH5EndCardView2.reportRenderResult("timeout", 3);
                this.r.setError(true);
            }
        }
        MBridgeH5EndCardView mBridgeH5EndCardView3 = this.r;
        if (mBridgeH5EndCardView3 != null) {
            mBridgeH5EndCardView3.setUnitId(this.x);
        }
    }

    private void e() {
        this.z = 1;
        if (this.q == null) {
            a(this.R, 2);
        }
        addView(this.q);
        onConfigurationChanged(getResources().getConfiguration());
        this.q.notifyShowListener();
        this.T = true;
        bringToFront();
    }

    private void f() {
        if (this.p == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.E && this.F) {
            this.F = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.p, layoutParams);
    }

    private void g() {
        if (this.v == null) {
            MBridgeAlertWebview mBridgeAlertWebview = new MBridgeAlertWebview(this.a);
            this.v = mBridgeAlertWebview;
            mBridgeAlertWebview.setUnitId(this.x);
            this.v.setCampaign(this.f2526b);
        }
        this.v.preLoadData(this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Integer num) {
        this.R = bVar;
        if (this.f2526b != null) {
            if (num == null) {
                num = Integer.valueOf(this.f2526b.getVideo_end_type());
            }
            if (!isLast()) {
                h();
            }
            int iIntValue = num.intValue();
            if (iIntValue != 1) {
                if (iIntValue == 3) {
                    if (this.s == null) {
                        this.s = new MBridgeVastEndCardView(this.a);
                    }
                    this.s.setCampaign(this.f2526b);
                    this.s.setNotifyListener(new l(this.e));
                    this.s.preLoadData(bVar);
                    return;
                }
                if (iIntValue == 4) {
                    if (this.t == null) {
                        this.t = new MBridgeLandingPageView(this.a);
                    }
                    this.t.setCampaign(this.f2526b);
                    this.t.setNotifyListener(new i(this.e));
                    return;
                }
                if (iIntValue != 5) {
                    if (this.z == 2) {
                        boolean zIsDynamicView = this.f2526b.isDynamicView();
                        boolean zJ = af.j(this.f2526b.getendcard_url());
                        if ((this.f2526b == null || !zIsDynamicView || zJ) && this.f2526b.getAdSpaceT() != 2) {
                            if (this.r == null) {
                                this.r = new MBridgeH5EndCardView(this.a);
                                try {
                                    HashMap map = new HashMap();
                                    map.put("type", "3");
                                    m.a().a("2000154", this.f2526b, map);
                                } catch (Throwable th) {
                                    aa.d(MBridgeBaseView.TAG, th.getMessage());
                                }
                            }
                            if (this.f2526b.getDynamicTempCode() == 5 && this.e != null && (this.e instanceof k)) {
                                ((k) this.e).a(this.f2526b);
                            }
                            this.r.setCampaign(this.f2526b);
                            this.r.setCloseDelayShowTime(this.A);
                            this.r.setNotifyListener(new i(this.e));
                            this.r.setUnitId(this.x);
                            this.r.setNotchValue(this.Q, this.L, this.M, this.N, this.O);
                            this.r.preLoadData(bVar);
                            if (this.E) {
                                return;
                            }
                            addView(this.r);
                            return;
                        }
                        return;
                    }
                    int iC = (this.f2526b == null || this.f2526b.getRewardTemplateMode() == null) ? 0 : this.f2526b.getRewardTemplateMode().c();
                    if (this.q == null) {
                        if (this.f2526b.isDynamicView()) {
                            i();
                        } else {
                            MBridgeNativeEndCardView mBridgeNativeEndCardView = new MBridgeNativeEndCardView(this.a, null, false, -1, this.f2526b.getAdSpaceT() == 2, iC, this.f2526b.getMof_tplid());
                            this.q = mBridgeNativeEndCardView;
                            mBridgeNativeEndCardView.setCampaign(this.f2526b);
                        }
                    }
                    this.q.setLayout();
                    if (this.f2526b.isDynamicView()) {
                        if (a.a().a(this.f2526b.getRequestId() + "_" + this.f2526b.getId())) {
                            try {
                                a.a().a(this.q, this.f2526b.getRequestId() + "_" + this.f2526b.getId(), new i(this.e));
                            } catch (Exception e) {
                                aa.d(MBridgeBaseView.TAG, e.getMessage());
                            }
                        } else {
                            try {
                                String strA = al.a(this.f2526b.getendcard_url(), "mof");
                                if (!TextUtils.isEmpty(strA) && Integer.parseInt(strA) == 1) {
                                    a.a().a(this.f2526b, this.q, new i(this.e), 2);
                                }
                            } catch (Exception e2) {
                                aa.d(MBridgeBaseView.TAG, e2.getMessage());
                            }
                        }
                    }
                    this.q.setUnitId(this.x);
                    this.q.setCloseBtnDelay(this.A);
                    this.q.setNotifyListener(new i(this.e));
                    this.q.preLoadData(bVar);
                    this.q.setNotchPadding(this.L, this.M, this.N, this.O);
                }
            }
        }
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        return viewGroup != null && viewGroup.indexOfChild(this) == 0;
    }

    private void h() {
        this.D = false;
        this.T = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof MBridgeContainerView) {
                    i++;
                } else {
                    viewGroup.bringChildToFront(childAt);
                }
            }
        }
    }

    private void b(int i) {
        if (i != -3) {
            if (i == -2) {
                if (this.f2526b == null || this.f2526b.getVideo_end_type() != 2) {
                    return;
                }
                if (this.p == null) {
                    this.p = new MBridgeClickMiniCardView(this.a);
                }
                this.p.setCampaign(this.f2526b);
                this.p.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(this.p, this.e));
                this.p.preLoadData(this.R);
                setMatchParent();
                f();
                h();
                return;
            }
            if (this.o == null) {
                this.o = new MBridgeClickCTAView(this.a);
            }
            this.o.setCampaign(this.f2526b);
            this.o.setUnitId(this.x);
            this.o.setNotifyListener(new i(this.e));
            this.o.preLoadData(this.R);
        }
    }

    private void a(MBridgeH5EndCardView... mBridgeH5EndCardViewArr) {
        for (MBridgeH5EndCardView mBridgeH5EndCardView : mBridgeH5EndCardViewArr) {
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0 && mBridgeH5EndCardView.getParent() != null && !isLast()) {
                mBridgeH5EndCardView.webviewshow();
            }
        }
    }

    public CampaignEx getReSetCampaign() {
        if (!this.f2526b.isDynamicView() || !TextUtils.isEmpty(this.f2526b.getendcard_url())) {
            return null;
        }
        int size = this.U.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.U.get(i2) != null && this.U.get(i2).getId() == this.f2526b.getId()) {
                i = i2 - 1;
                break;
            }
        }
        if (i < 0 || i >= size || this.U.get(i) == null) {
            return null;
        }
        return this.U.get(i);
    }

    private void i() {
        if (this.f2526b == null) {
            return;
        }
        String str = this.f2526b.getendcard_url();
        boolean zIsEmpty = TextUtils.isEmpty(str);
        int i = TTAdConstant.DEEPLINK_FALLBACK_CODE;
        if (!zIsEmpty) {
            try {
                i = Integer.parseInt(al.a(str, "ecid"));
            } catch (Throwable th) {
                aa.d(MBridgeBaseView.TAG, th.getMessage());
            }
        }
        this.q = new MBridgeNativeEndCardView(this.a, null, true, i, this.f2526b.getAdSpaceT() == 2, this.l, this.f2526b.getMof_tplid());
        if (this.f2526b.getDynamicTempCode() == 5) {
            if (this.e != null && (this.e instanceof k)) {
                ((k) this.e).a(this.f2526b);
            }
            this.q.setCampaign(this.f2526b);
            return;
        }
        this.q.setCampaign(this.f2526b);
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.p;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMBridgeClickMiniCardViewTransparent();
            this.p.setMBridgeClickMiniCardViewClickable(false);
        }
    }

    public void onPlayableBackPress() {
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.onBackPress();
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.D) {
            this.e.a(107, "");
        }
    }

    public void onEndcardBackPress() {
        if (this.q != null || this.s != null) {
            this.e.a(104, "");
            try {
                a.a().b();
                return;
            } catch (Exception e) {
                aa.d(MBridgeBaseView.TAG, e.getMessage());
                return;
            }
        }
        if (this.t != null) {
            this.e.a(103, "");
            return;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.onBackPress();
        }
    }

    public void release() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.release();
            this.r = null;
        }
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.release();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.t;
        if (mBridgeLandingPageView != null) {
            mBridgeLandingPageView.release();
        }
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.clearMoreOfferBitmap();
            this.q.release();
        }
    }

    public MBridgeH5EndCardView getH5EndCardView() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        return mBridgeH5EndCardView == null ? this.n : mBridgeH5EndCardView;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void hideAlertWebview() {
        if (isLast()) {
            return;
        }
        if (this.S && !this.T) {
            h();
            this.S = false;
        }
        MBridgeAlertWebview mBridgeAlertWebview = this.v;
        if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
            return;
        }
        removeView(this.v);
        MBridgeClickCTAView mBridgeClickCTAView = this.o;
        if (mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null) {
            return;
        }
        setWrapContent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void ivRewardAdsWithoutVideo(String str) {
        this.e.a(103, str);
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        aa.d(MBridgeBaseView.TAG, "NOTCH ContainerView " + String.format("%1s-%2s-%3s-%4s-%5s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i)));
        this.P = i;
        this.L = i2;
        this.M = i3;
        this.N = i4;
        this.O = i5;
        this.Q = o.a(i, i2, i3, i4, i5);
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setNotchPadding(i2, i3, i4, i5);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.r;
        if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.q != null) {
            this.r.setNotchValue(this.Q, i2, i3, i4, i5);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.r.q, "oncutoutfetched", Base64.encodeToString(this.Q.getBytes(), 0));
        }
        MBridgePlayableView mBridgePlayableView = this.n;
        if (mBridgePlayableView != null && mBridgePlayableView.q != null) {
            this.n.setNotchValue(this.Q, i2, i3, i4, i5);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.n.q, "oncutoutfetched", Base64.encodeToString(this.Q.getBytes(), 0));
        }
        MBridgeOrderCampView mBridgeOrderCampView = this.w;
        if (mBridgeOrderCampView != null) {
            mBridgeOrderCampView.setNotchPadding(i2, i3, i4, i5);
        }
    }

    public void setOnResume() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnResume();
        }
    }

    public void setOnPause() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnPause();
        }
    }

    public void setRewardStatus(boolean z) {
        this.K = z;
    }
}
