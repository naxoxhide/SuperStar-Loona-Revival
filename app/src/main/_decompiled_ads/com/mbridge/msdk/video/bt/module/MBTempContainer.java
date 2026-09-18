package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.iab.omid.library.mmadbridge.adsession.media.VastProperties;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MBTempContainer extends AbstractJSContainer {
    private static final String y = "MBTempContainer";
    private CampaignEx A;
    private com.mbridge.msdk.videocommon.download.a B;
    private h C;
    private com.mbridge.msdk.video.bt.module.a.b D;
    private com.mbridge.msdk.video.dynview.e.a E;
    private int F;
    private String G;
    private com.mbridge.msdk.video.signal.factory.b H;
    private int I;
    private int J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private String Q;
    private String R;
    private List<CampaignEx> S;
    private int T;
    private LayoutInflater U;
    private int V;
    private int W;
    protected boolean a;
    private View aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private com.mbridge.msdk.mbsignalcommon.mraid.d al;
    private AdSession am;
    private MediaEvents an;
    private Runnable ao;
    private boolean ap;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f2470b;
    protected a c;
    protected WindVaneWebView d;
    protected MBridgeVideoView e;
    protected MBridgeContainerView f;
    protected Handler g;
    protected Runnable h;
    protected Runnable i;
    private View z;

    public void preload() {
    }

    public void setMediaPlayerUrl(String str) {
    }

    public MBTempContainer(Context context) {
        super(context);
        this.F = 1;
        this.G = "";
        this.I = com.mbridge.msdk.foundation.same.a.s;
        this.K = false;
        this.Q = "";
        this.S = new ArrayList();
        this.T = 0;
        this.a = false;
        this.f2470b = false;
        this.c = new a.C0515a();
        this.g = new Handler();
        this.V = 0;
        this.W = 0;
        this.h = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.getActivityProxy().h() != 0) {
                    MBTempContainer.this.V = -3;
                } else {
                    MBTempContainer.this.defaultLoad(-1, "WebView load timeout");
                }
            }
        };
        this.i = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.getActivityProxy().h() != 0) {
                    MBTempContainer.this.V = -4;
                } else {
                    MBTempContainer.this.defaultLoad(-3, "Signal Communication connect timeout");
                }
            }
        };
        this.ab = false;
        this.ac = false;
        this.ad = false;
        this.af = false;
        this.ag = false;
        this.ah = false;
        this.ai = false;
        this.aj = false;
        this.ak = false;
        this.am = null;
        this.an = null;
        this.ao = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.3
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.aa != null) {
                    MBTempContainer.this.aa.setVisibility(8);
                }
            }
        };
        this.ap = false;
        init(context);
    }

    public MBTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = 1;
        this.G = "";
        this.I = com.mbridge.msdk.foundation.same.a.s;
        this.K = false;
        this.Q = "";
        this.S = new ArrayList();
        this.T = 0;
        this.a = false;
        this.f2470b = false;
        this.c = new a.C0515a();
        this.g = new Handler();
        this.V = 0;
        this.W = 0;
        this.h = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.getActivityProxy().h() != 0) {
                    MBTempContainer.this.V = -3;
                } else {
                    MBTempContainer.this.defaultLoad(-1, "WebView load timeout");
                }
            }
        };
        this.i = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.getActivityProxy().h() != 0) {
                    MBTempContainer.this.V = -4;
                } else {
                    MBTempContainer.this.defaultLoad(-3, "Signal Communication connect timeout");
                }
            }
        };
        this.ab = false;
        this.ac = false;
        this.ad = false;
        this.af = false;
        this.ag = false;
        this.ah = false;
        this.ai = false;
        this.aj = false;
        this.ak = false;
        this.am = null;
        this.an = null;
        this.ao = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.3
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.aa != null) {
                    MBTempContainer.this.aa.setVisibility(8);
                }
            }
        };
        this.ap = false;
        init(context);
    }

    public void init(Context context) {
        this.U = LayoutInflater.from(context);
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setCampOrderViewData(List<CampaignEx> list, int i) {
        if (list != null) {
            this.S = list;
        }
        this.T = i;
    }

    public void registerErrorListener(a aVar) {
        this.c = aVar;
    }

    public int findID(String str) {
        return t.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return t.a(getContext(), str, "layout");
    }

    public interface a {
        void a(String str);

        void a(boolean z);

        /* JADX INFO: renamed from: com.mbridge.msdk.video.bt.module.MBTempContainer$a$a, reason: collision with other inner class name */
        public static class C0515a implements a {
            private boolean a = false;

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.a
            public void a(String str) {
                aa.d("ActivityErrorListener", str);
                this.a = true;
            }

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.a
            public final void a(boolean z) {
                this.a = z;
            }
        }
    }

    public boolean isLoadSuccess() {
        return this.f2470b;
    }

    private int c() {
        j jVarB = b(this.A);
        if (jVarB != null) {
            return jVarB.j();
        }
        return 0;
    }

    private boolean d() {
        j jVarB = b(this.A);
        if (jVarB != null) {
            return jVarB.m();
        }
        return false;
    }

    private boolean e() {
        MBridgeVideoView mBridgeVideoView = this.e;
        if (mBridgeVideoView != null) {
            return mBridgeVideoView.isShowingAlertView() || this.e.isRewardPopViewShowing();
        }
        return false;
    }

    public void superDefaultLoad(int i, String str) {
        this.g.removeCallbacks(this.h);
        this.g.removeCallbacks(this.i);
        this.c.a(true);
        WindVaneWebView windVaneWebView = this.d;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    protected final void a(String str) {
        h hVar = this.C;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onPause() {
        super.onPause();
        this.ad = true;
        try {
            getJSVideoModule().videoOperate(2);
            MBridgeContainerView mBridgeContainerView = this.f;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnPause();
            }
            MBridgeVideoView mBridgeVideoView = this.e;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityPause();
            }
        } catch (Throwable th) {
            aa.b(y, th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onResume() {
        Runnable runnable;
        super.onResume();
        int i = this.V;
        if (i == -3) {
            runnable = this.h;
        } else {
            runnable = i == -4 ? this.i : null;
        }
        if (runnable != null) {
            runnable.run();
            this.V = 0;
        }
        try {
            if (this.e != null && !e() && !this.e.isMiniCardShowing() && !com.mbridge.msdk.foundation.c.b.c) {
                this.e.setCover(false);
            }
            MBridgeVideoView mBridgeVideoView = this.e;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityResume();
            }
            MBridgeContainerView mBridgeContainerView = this.f;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnResume();
            }
            if (this.ad && !e() && !com.mbridge.msdk.foundation.c.b.c) {
                getJSVideoModule().videoOperate(1);
            }
            if (this.j != null) {
                af.a(this.j.getWindow().getDecorView());
            }
            if (this.af && this.ag && this.j != null) {
                this.j.finish();
            }
        } catch (Throwable th) {
            aa.b(y, th.getMessage(), th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onStop() {
        super.onStop();
        MBridgeVideoView mBridgeVideoView = this.e;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(true);
            this.e.onActivityStop();
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        CampaignEx campaignEx;
        if (this.K) {
            return;
        }
        boolean z = true;
        this.K = true;
        super.onDestroy();
        try {
            MBridgeVideoView mBridgeVideoView = this.e;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.releasePlayer();
            }
            WindVaneWebView windVaneWebView = this.d;
            if (windVaneWebView != null) {
                ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.d.clearWebView();
                m.a().a(this.A);
                this.d.release();
            }
            if (this.D != null) {
                this.D = null;
            }
            this.g.removeCallbacks(this.h);
            this.g.removeCallbacks(this.i);
            getJSCommon().e();
            if (this.r) {
                com.mbridge.msdk.c.d.a().e(this.k);
            }
            if (!this.ab) {
                try {
                    this.ab = true;
                    CampaignEx campaignEx2 = this.A;
                    if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 2) {
                        this.ac = true;
                    }
                    if (this.C != null) {
                        if (this.r && (this.t == com.mbridge.msdk.foundation.same.a.o || this.t == com.mbridge.msdk.foundation.same.a.p)) {
                            h hVar = this.C;
                            if (this.J != 1) {
                                z = false;
                            }
                            hVar.a(z, this.I);
                        }
                        if (!this.ac) {
                            this.o.a(0);
                        }
                        this.C.a(this.ac, this.o);
                    }
                    this.g.removeCallbacks(this.ao);
                    if (((!this.r && !this.w) || ((campaignEx = this.A) != null && campaignEx.isDynamicView())) && this.ac) {
                        aa.a(y, "sendToServerRewardInfo");
                        com.mbridge.msdk.video.module.b.b.a(this.A, this.o, this.k, this.n, this.R);
                    }
                    if (!this.w) {
                        if (this.r) {
                            com.mbridge.msdk.videocommon.a.b(287, this.A);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(94, this.A);
                        }
                    }
                    MBridgeContainerView mBridgeContainerView = this.f;
                    if (mBridgeContainerView != null) {
                        mBridgeContainerView.release();
                    }
                } catch (Throwable th) {
                    aa.b(y, th.getMessage(), th);
                }
            }
            if (!this.ae) {
                f();
            }
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar = this.al;
            if (dVar != null) {
                dVar.d();
            }
            AdSession adSession = this.am;
            if (adSession != null) {
                adSession.removeAllFriendlyObstructions();
                this.am.finish();
                this.am = null;
            }
            if (!this.w) {
                if (isLoadSuccess()) {
                    this.g.postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (MBTempContainer.this.j != null) {
                                MBTempContainer.this.j.finish();
                            }
                        }
                    }, 100L);
                } else if (this.j != null) {
                    this.j.finish();
                }
            }
            if (!this.ae) {
                f();
            }
            com.mbridge.msdk.video.bt.a.c.a().f(this.G);
        } catch (Throwable th2) {
            aa.a(y, th2.getMessage());
        }
    }

    private void f() {
        p pVar = new p(getContext());
        CampaignEx campaignEx = this.A;
        if (campaignEx != null) {
            pVar.a(campaignEx.getRequestId(), this.A.getRequestIdNotice(), this.A.getId(), this.k, com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.A.getId()), this.A.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.A.getId());
            this.ae = true;
        }
    }

    public void setShowingTransparent() {
        int iA;
        boolean zD = d();
        this.af = zD;
        if (zD || (iA = t.a(getContext(), "mbridge_reward_theme", "style")) <= 1 || this.j == null) {
            return;
        }
        this.j.setTheme(iA);
    }

    private void g() {
        AdSession adSession = this.am;
        if (adSession != null) {
            try {
                adSession.addFriendlyObstruction(this.f, FriendlyObstructionPurpose.OTHER, null);
                View view = this.aa;
                if (view != null) {
                    this.am.addFriendlyObstruction(view, FriendlyObstructionPurpose.OTHER, null);
                }
                WindVaneWebView windVaneWebView = this.d;
                if (windVaneWebView != null) {
                    this.am.addFriendlyObstruction(windVaneWebView, FriendlyObstructionPurpose.OTHER, null);
                }
                AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(this.am);
                this.an = MediaEvents.createMediaEvents(this.am);
                this.am.start();
                adEventsCreateAdEvents.loaded(VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE));
                this.e.setVideoEvents(this.an);
                if (adEventsCreateAdEvents != null) {
                    adEventsCreateAdEvents.impressionOccurred();
                }
            } catch (Exception e2) {
                aa.a("omsdk", e2.getMessage());
            }
        }
    }

    public void receiveSuccess() {
        aa.a(y, "receiveSuccess ,start hybrid");
        this.g.removeCallbacks(this.i);
        this.g.postDelayed(this.ao, 250L);
    }

    public void defaultLoad(int i, String str) {
        int iE;
        int i2;
        superDefaultLoad(i, str);
        if (isLoadSuccess()) {
            if (this.A.getPlayable_ads_without_video() == 2) {
                this.f.setCampaign(this.A);
                this.f.addOrderViewData(this.S);
                this.f.setUnitID(this.k);
                this.f.setCloseDelayTime(i());
                this.f.setPlayCloseBtnTm(this.m.h());
                this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.A, this.B, this.o, b(), this.k, new d(), this.m.z(), this.w));
                this.f.preLoadData(this.H);
                this.f.showPlayableView();
            } else {
                a(i, str);
                this.aa.setVisibility(8);
                loadModuleDatas();
                int iF = this.m.f();
                int iC = c();
                int i3 = iC != 0 ? iC : iF;
                CampaignEx campaignEx = this.A;
                if (campaignEx != null && campaignEx.isDynamicView()) {
                    this.e.setContainerViewOnNotifyListener(new c(this.j, this.A));
                }
                CampaignEx campaignEx2 = this.A;
                if (campaignEx2 != null && campaignEx2.getVst() > -2) {
                    iE = this.A.getVst();
                } else {
                    iE = this.m.e();
                }
                CampaignEx campaignEx3 = this.A;
                if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5 && (i2 = this.F) > 1) {
                    iE = a(iE, i2);
                    this.A.setVst(iE);
                }
                int i4 = iE;
                this.e.setVideoSkipTime(i4);
                this.e.setNotifyListener(new com.mbridge.msdk.video.module.a.a.m(this.e, this.f, this.A, this.o, this.B, b(), this.k, i3, i4, new f(), this.m.z(), this.w, this.m.D()));
                this.e.defaultShow();
                this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.b(this.e, this.f, this.A, this.o, this.B, b(), this.k, new c(this.j, this.A), this.m.z(), this.w));
                this.f.defaultShow();
            }
            g();
            return;
        }
        a(i, str);
        if (this.j != null) {
            this.j.finish();
        }
    }

    public int getLayoutID() {
        return findLayout(this.af ? "mbridge_reward_activity_video_templete_transparent" : "mbridge_reward_activity_video_templete");
    }

    public WindVaneWebView findWindVaneWebView() {
        com.mbridge.msdk.videocommon.a.C0524a c0524aA;
        com.mbridge.msdk.videocommon.a.C0524a c0524aA2;
        try {
            if (this.w) {
                CampaignEx campaignEx = this.A;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || (c0524aA2 = com.mbridge.msdk.videocommon.a.a(this.k + "_" + this.A.getId() + "_" + this.A.getRequestId() + "_" + this.A.getRewardTemplateMode().e())) == null) {
                    return null;
                }
                return c0524aA2.a();
            }
            if (this.r) {
                c0524aA = com.mbridge.msdk.videocommon.a.a(287, this.A);
            } else {
                c0524aA = com.mbridge.msdk.videocommon.a.a(94, this.A);
            }
            if (c0524aA == null || !c0524aA.c()) {
                return null;
            }
            if (this.r) {
                com.mbridge.msdk.videocommon.a.b(287, this.A);
            } else {
                com.mbridge.msdk.videocommon.a.b(94, this.A);
            }
            WindVaneWebView windVaneWebViewA = c0524aA.a();
            if (this.af) {
                windVaneWebViewA.setWebViewTransparent();
            }
            return windVaneWebViewA;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public MBridgeVideoView findMBridgeVideoView() {
        return (MBridgeVideoView) findViewById(findID("mbridge_video_templete_videoview"));
    }

    public MBridgeContainerView findMBridgeContainerView() {
        return (MBridgeContainerView) findViewById(findID("mbridge_video_templete_container"));
    }

    public boolean initViews() {
        View viewFindViewById = findViewById(findID("mbridge_video_templete_progressbar"));
        this.aa = viewFindViewById;
        return viewFindViewById != null;
    }

    public boolean canBackPress() {
        MBridgeContainerView mBridgeContainerView = this.f;
        return mBridgeContainerView == null || mBridgeContainerView.canBackPress();
    }

    public void onBackPressed() {
        MBridgeContainerView mBridgeContainerView;
        MBridgeContainerView mBridgeContainerView2;
        MBridgeVideoView mBridgeVideoView;
        MBridgeVideoView mBridgeVideoView2;
        if (this.af && (mBridgeVideoView2 = this.e) != null) {
            mBridgeVideoView2.notifyVideoClose();
            return;
        }
        if (this.ah && (mBridgeVideoView = this.e) != null) {
            if (mBridgeVideoView.isMiniCardShowing()) {
                MBridgeContainerView mBridgeContainerView3 = this.f;
                if (mBridgeContainerView3 != null) {
                    mBridgeContainerView3.onMiniEndcardBackPress();
                    return;
                }
                return;
            }
            this.e.onBackPress();
            return;
        }
        if (this.aj && (mBridgeContainerView2 = this.f) != null) {
            mBridgeContainerView2.onPlayableBackPress();
            return;
        }
        if (this.ai && (mBridgeContainerView = this.f) != null) {
            mBridgeContainerView.onEndcardBackPress();
        }
        if (getJSCommon().b()) {
            if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                getActivityProxy().g();
                return;
            }
            return;
        }
        if (canBackPress()) {
            if (this.j == null || this.w || this.ak) {
                return;
            }
            this.ak = true;
            this.j.onBackPressed();
            return;
        }
        aa.a(y, "onBackPressed can't excute");
    }

    private void a(int i, String str) {
        try {
            n nVar = new n();
            nVar.r("2000037");
            nVar.j("code=" + i + ",desc=" + str);
            CampaignEx campaignEx = this.A;
            nVar.i((campaignEx == null || campaignEx.getRewardTemplateMode() == null) ? "" : this.A.getRewardTemplateMode().e());
            nVar.p(this.k);
            CampaignEx campaignEx2 = this.A;
            nVar.q(campaignEx2 != null ? campaignEx2.getId() : "");
            CampaignEx campaignEx3 = this.A;
            if (campaignEx3 != null && !TextUtils.isEmpty(campaignEx3.getRequestId())) {
                nVar.m(this.A.getRequestId());
            }
            CampaignEx campaignEx4 = this.A;
            if (campaignEx4 != null && !TextUtils.isEmpty(campaignEx4.getRequestIdNotice())) {
                nVar.o(this.A.getRequestIdNotice());
            }
            int iR = w.r(getContext());
            nVar.d(iR);
            nVar.u(w.a(getContext(), iR));
            com.mbridge.msdk.video.module.b.b.a(n.e(nVar), this.k);
        } catch (Throwable th) {
            aa.b(y, th.getMessage(), th);
        }
    }

    private int h() {
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (aVarB != null) {
                return (int) aVarB.h();
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    private int i() {
        CampaignEx campaignEx = this.A;
        if (campaignEx == null) {
            return 1;
        }
        boolean zB = af.b(MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE, campaignEx.getendcard_url());
        int iC = af.c(this.A.getendcard_url(), MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE);
        if (zB && iC >= 0) {
            return iC;
        }
        if (this.A.getCbd() > -2) {
            return this.A.getCbd();
        }
        return this.m.p();
    }

    private int a(int i, int i2) {
        List<CampaignEx> list;
        if (i < 0 || (list = this.S) == null || list.size() == 0 || i2 <= 1) {
            return i;
        }
        int videoLength = 0;
        for (int i3 = 0; i3 < i2 - 1; i3++) {
            if (this.S.get(i3) != null) {
                videoLength += this.S.get(i3).getVideoLength();
            }
        }
        if (i > videoLength) {
            return i - videoLength;
        }
        return 0;
    }

    private final class f extends com.mbridge.msdk.video.module.a.a.f {
        private f() {
        }

        @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
        public final void a(int i, Object obj) {
            super.a(i, obj);
            if (MBTempContainer.this.r) {
                try {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            MBTempContainer.this.I = jSONObject.getInt("Alert_window_status");
                            MBTempContainer.this.J = jSONObject.getInt("complete_info");
                        }
                    }
                } catch (Exception e) {
                    aa.d("NotifyListener", e.getMessage());
                }
            }
            if (i != 2) {
                if (i == 121) {
                    MBTempContainer.this.ac = true;
                    MBTempContainer.this.C.a(MBTempContainer.this.l, MBTempContainer.this.k);
                    MBTempContainer.this.ah = false;
                    return;
                }
                if (i == 16) {
                    MBTempContainer.this.getJSCommon().d();
                    return;
                }
                if (i != 17) {
                    switch (i) {
                        case 10:
                            MBTempContainer.this.ah = true;
                            if (MBTempContainer.this.A != null) {
                                if (!MBTempContainer.this.A.isDynamicView() || !MBTempContainer.this.w || MBTempContainer.this.A.isCampaignIsFiltered()) {
                                    MBTempContainer.this.C.a();
                                }
                                com.mbridge.msdk.video.bt.module.b.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.A, MBTempContainer.this.k, MBTempContainer.this.F);
                            }
                            break;
                    }
                }
                MBTempContainer.this.ac = true;
                if (MBTempContainer.this.f != null) {
                    MBTempContainer.this.f.setRewardStatus(true);
                    return;
                }
                return;
            }
            if (i == 12) {
                String string = "Play error but has no message.";
                try {
                    if (obj instanceof String) {
                        string = obj.toString();
                    }
                } catch (Throwable th) {
                    aa.d("NotifyListener", th.getMessage());
                }
                com.mbridge.msdk.video.bt.module.b.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.A, MBTempContainer.this.k, string, MBTempContainer.this.F);
                if (!MBTempContainer.this.ah) {
                    if (MBTempContainer.this.m.D() == 0) {
                        MBTempContainer.this.C.a("play error");
                        MBTempContainer.this.ah = false;
                        MBTempContainer.m(MBTempContainer.this);
                        return;
                    } else if (MBTempContainer.this.A == null || !MBTempContainer.this.A.isDynamicView() || !MBTempContainer.this.w || MBTempContainer.this.A.isCampaignIsFiltered()) {
                        MBTempContainer.this.C.a();
                    }
                }
            }
            MBTempContainer.this.getJSVideoModule().videoOperate(3);
            MBTempContainer.this.ah = false;
            if (MBTempContainer.this.an == null || i != 2) {
                return;
            }
            MBTempContainer.this.an.skipped();
        }
    }

    private final class c extends com.mbridge.msdk.video.module.a.a.a {
        public c(Activity activity, CampaignEx campaignEx) {
            super(activity, campaignEx);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0074  */
        @Override // com.mbridge.msdk.video.module.a.a.a, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
        public final void a(int i, Object obj) {
            if (i == 108) {
                MBTempContainer.this.getJSCommon().a(new com.mbridge.msdk.video.signal.a.c.b(MBTempContainer.this.getJSCommon(), new e()));
                MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
            } else if (i == 113) {
                MBTempContainer.this.C.a(true, MBTempContainer.this.l, MBTempContainer.this.k);
            } else if (i == 117) {
                if (MBTempContainer.this.e != null) {
                    MBTempContainer.this.e.setVisible(4);
                }
                MBTempContainer.this.ai = true;
                MBTempContainer.this.C.b(MBTempContainer.this.l, MBTempContainer.this.k);
            } else if (i == 126 || i == 128) {
                MBTempContainer.this.C.a(false, MBTempContainer.this.l, MBTempContainer.this.k);
            } else {
                switch (i) {
                    case 103:
                    case 104:
                        MBTempContainer.m(MBTempContainer.this);
                        break;
                    case 105:
                        MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                        break;
                    case 106:
                        MBTempContainer.this.C.a(true, MBTempContainer.this.l, MBTempContainer.this.k);
                        break;
                }
            }
            super.a(i, obj);
        }
    }

    private final class d extends com.mbridge.msdk.video.module.a.a.f {
        private d() {
        }

        @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
        public final void a(int i, Object obj) {
            String string;
            super.a(i, obj);
            try {
                if (obj instanceof JSONObject) {
                    string = obj.toString();
                } else {
                    string = (String) obj;
                }
                if (MBTempContainer.this.r && !TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    int iOptInt = jSONObject.optInt("type");
                    int iOptInt2 = jSONObject.optInt("complete");
                    if (iOptInt == 2) {
                        MBTempContainer.this.I = com.mbridge.msdk.foundation.same.a.u;
                    } else if (iOptInt != 3) {
                        MBTempContainer.this.I = com.mbridge.msdk.foundation.same.a.s;
                    } else {
                        MBTempContainer.this.I = com.mbridge.msdk.foundation.same.a.t;
                    }
                    MBTempContainer.this.J = iOptInt2;
                }
            } catch (Exception unused) {
                aa.d("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i == 120) {
                MBTempContainer.this.C.b(MBTempContainer.this.l, MBTempContainer.this.k);
                return;
            }
            if (i == 126) {
                MBTempContainer.this.C.a(false, MBTempContainer.this.l, MBTempContainer.this.k);
                return;
            }
            if (i != 127) {
                switch (i) {
                    case 100:
                        MBTempContainer.this.aj = true;
                        MBTempContainer.this.g.postDelayed(MBTempContainer.this.ao, 250L);
                        MBTempContainer.this.C.a();
                        break;
                    case 101:
                    case 102:
                        MBTempContainer.this.getJSCommon().d();
                        break;
                    case 103:
                        MBTempContainer.this.ac = true;
                        if (MBTempContainer.this.A.isMraid()) {
                            MBTempContainer.m(MBTempContainer.this);
                        } else {
                            MBTempContainer.this.getJSCommon().d();
                        }
                        break;
                    case 104:
                        MBTempContainer.m(MBTempContainer.this);
                        break;
                    case 105:
                        MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                        break;
                }
                return;
            }
            MBTempContainer.this.ac = true;
            MBTempContainer.this.C.a();
            MBTempContainer.this.C.b(MBTempContainer.this.l, MBTempContainer.this.k);
            MBTempContainer.this.getJSContainerModule().showEndcard(100);
        }
    }

    private class e extends com.mbridge.msdk.video.signal.a.c.a {
        private e() {
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.video.signal.c.a
        public final void a() {
            super.a();
            MBTempContainer.this.receiveSuccess();
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            MBTempContainer.F(MBTempContainer.this);
            if (MBTempContainer.this.ap) {
                MBTempContainer.this.onPause();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            MBTempContainer.this.ag = true;
            MBTempContainer.H(MBTempContainer.this);
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String strOptString = new JSONObject(MBTempContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && strOptString.equals("1.0") && MBTempContainer.this.j != null) {
                        if (!MBTempContainer.this.w) {
                            MBTempContainer.this.j.finish();
                        } else {
                            MBTempContainer.m(MBTempContainer.this);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (MBTempContainer.this.ap) {
                MBTempContainer.this.onResume();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            MBTempContainer.H(MBTempContainer.this);
            MBTempContainer.this.ag = true;
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.video.signal.c.a
        public final void a(boolean z) {
            super.a(z);
            MBTempContainer.this.C.a(z, MBTempContainer.this.l, MBTempContainer.this.k);
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.video.signal.c.a
        public final void a(int i, String str) {
            super.a(i, str);
            MBTempContainer.this.defaultLoad(i, str);
        }

        @Override // com.mbridge.msdk.video.signal.a.c.a, com.mbridge.msdk.video.signal.c.a
        public final void b() {
            super.b();
            if (MBTempContainer.this.g != null) {
                MBTempContainer.this.g.removeCallbacks(MBTempContainer.this.h);
            }
        }
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.A = campaignEx;
        if (campaignEx != null) {
            if (TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && !TextUtils.isEmpty(this.k)) {
                campaignEx.setCampaignUnitId(this.k);
            }
            AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
            if (appletsModel != null) {
                this.ap = appletsModel.isSupportWxScheme();
            }
            com.mbridge.msdk.foundation.c.b.a().a(campaignEx.getCampaignUnitId() + "_1", campaignEx);
        }
    }

    public CampaignEx getCampaign() {
        return this.A;
    }

    public void setCampaignExpired(boolean z) {
        try {
            CampaignEx campaignEx = this.A;
            if (campaignEx != null) {
                if (z) {
                    campaignEx.setSpareOfferFlag(1);
                    if (this.m != null) {
                        if (this.m.z() == 1) {
                            this.A.setCbt(1);
                        } else {
                            this.A.setCbt(0);
                        }
                    }
                } else {
                    campaignEx.setSpareOfferFlag(0);
                    this.A.setCbt(0);
                }
            }
        } catch (Exception e2) {
            aa.d(y, e2.getMessage());
        }
    }

    public void setCampaignDownLoadTask(com.mbridge.msdk.videocommon.download.a aVar) {
        this.B = aVar;
    }

    public void setShowRewardListener(h hVar) {
        this.C = hVar;
    }

    public void setMBridgeTempCallback(com.mbridge.msdk.video.bt.module.a.b bVar) {
        this.D = bVar;
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, int i) {
        this.E = aVar;
        this.F = i;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.H = bVar;
    }

    public void setInstanceId(String str) {
        this.G = str;
    }

    public String getInstanceId() {
        return this.G;
    }

    public void setWebViewFront(int i) {
        this.W = i;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        this.L = i;
        this.M = i2;
        this.N = i3;
        this.O = i4;
        this.P = i5;
        String strA = o.a(i, i2, i3, i4, i5);
        this.Q = strA;
        aa.d(y, strA);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.Q)) {
            getJSCommon().b(this.Q);
            if (this.d != null && !TextUtils.isEmpty(this.Q)) {
                g.a().a((WebView) this.d, "oncutoutfetched", Base64.encodeToString(this.Q.getBytes(), 0));
            }
        }
        MBridgeVideoView mBridgeVideoView = this.e;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setNotchPadding(i2, i3, i4, i5);
        }
        MBridgeContainerView mBridgeContainerView = this.f;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.setNotchPadding(i, i2, i3, i4, i5);
        }
    }

    public void setDeveloperExtraData(String str) {
        this.R = str;
    }

    private static final class b extends AppletSchemeCallBack {
        private CampaignEx a;

        public b(CampaignEx campaignEx) {
            this.a = campaignEx;
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        protected final void onRequestStart() {
            if (MBridgeConstans.DEBUG) {
                aa.a(MBTempContainer.y, "start request wx scheme");
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        protected final void onRequestSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                aa.a(MBTempContainer.y, "request wx scheme success");
            }
            try {
                CampaignEx campaignEx = this.a;
                if (campaignEx != null) {
                    campaignEx.setDeepLinkUrl(str);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d(MBTempContainer.y, e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        protected final void onRequestFailed(int i, String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                aa.a(MBTempContainer.y, "request wx scheme failed: errorCode: " + i + " errorMessage: " + str);
            }
            try {
                CampaignEx campaignEx = this.a;
                if (campaignEx != null) {
                    campaignEx.setClickURL(str2);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d(MBTempContainer.y, e.getMessage());
                }
            }
        }
    }

    public void onCreate() {
        ViewGroup viewGroup;
        int i;
        int iH;
        List<CampaignEx> list;
        AppletsModel appletsModel;
        if (this.m == null) {
            this.m = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.k, this.r);
        }
        try {
            if (this.A != null) {
                try {
                    appletsModel = AppletModelManager.getInstance().get(this.A);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                    }
                    appletsModel = null;
                }
                if (appletsModel != null) {
                    try {
                        if (appletsModel.can(0)) {
                            appletsModel.setUserClick(false);
                            appletsModel.requestWxAppletsScheme(0, new b(this.A));
                        }
                    } catch (Exception e3) {
                        if (appletsModel != null) {
                            appletsModel.clearRequestState();
                        }
                        if (MBridgeConstans.DEBUG) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
        this.ak = false;
        try {
            if (this.w) {
                CampaignEx campaignEx = this.A;
                if (campaignEx != null && campaignEx.isDynamicView()) {
                    this.C = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.r, this.m, this.A, this.C, b(), this.k);
                } else {
                    this.C = new com.mbridge.msdk.video.bt.module.b.c(this.D, this.G);
                }
            } else {
                this.C = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.r, this.m, this.A, this.C, b(), this.k);
            }
            CampaignEx campaignEx2 = this.A;
            if (campaignEx2 != null && campaignEx2.isActiveOm()) {
                this.am = com.mbridge.msdk.a.b.a(getContext(), false, this.A.getOmid(), this.A.getRequestId(), this.A.getId(), this.k, this.B.s(), this.A.getRequestIdNotice());
            }
            registerErrorListener(new com.mbridge.msdk.video.bt.module.b.e(this.C));
            a(this.m, this.A);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (layoutID <= 0) {
                a("layoutID not found");
                return;
            }
            View viewInflate = this.U.inflate(layoutID, (ViewGroup) null);
            this.z = viewInflate;
            addView(viewInflate, new RelativeLayout.LayoutParams(-1, -1));
            if (this.a) {
                setMatchParent();
            }
            this.d = findWindVaneWebView();
            MBridgeVideoView mBridgeVideoViewFindMBridgeVideoView = findMBridgeVideoView();
            this.e = mBridgeVideoViewFindMBridgeVideoView;
            mBridgeVideoViewFindMBridgeVideoView.setVideoLayout(this.A);
            this.e.setIsIV(this.r);
            this.e.setUnitId(this.k);
            this.e.setCamPlayOrderCallback(this.E, this.S, this.F, this.T);
            if (this.w) {
                this.e.setNotchPadding(this.M, this.N, this.O, this.P);
            }
            this.f = findMBridgeContainerView();
            if (this.w) {
                this.f.setNotchPadding(this.L, this.M, this.N, this.O, this.P);
            }
            if (!((this.e == null || this.f == null || !initViews()) ? false : true)) {
                this.c.a("not found View IDS");
                if (this.j != null) {
                    this.j.finish();
                    return;
                }
                return;
            }
            this.f2470b = true;
            WindVaneWebView windVaneWebView = this.d;
            this.H = new com.mbridge.msdk.video.signal.factory.b(this.j, windVaneWebView, this.e, this.f, this.A, new e());
            CampaignEx campaignEx3 = this.A;
            if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5 && (list = this.S) != null) {
                this.H.a(list);
            }
            registerJsFactory(this.H);
            com.mbridge.msdk.foundation.c.b.a().a(this.k + "_1", new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.5
                @Override // com.mbridge.msdk.foundation.c.a
                public final void a() {
                    String string;
                    MBTempContainer.this.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        aa.b(MBTempContainer.y, th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.d, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.c.a
                public final void b() {
                    String string;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        aa.b(MBTempContainer.y, th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.d, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.c.a
                public final void a(String str) {
                    String string;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        aa.b(MBTempContainer.y, th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.d, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
            if (windVaneWebView != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.z.findViewById(t.a(getContext(), "mbridge_video_templete_webview_parent", "id"));
                windVaneWebView.setApiManagerJSFactory(this.H);
                if (windVaneWebView.getParent() != null) {
                    defaultLoad(0, "preload template webview is null or load error");
                    return;
                }
                if (windVaneWebView.getObject() instanceof j) {
                    this.H.a((j) windVaneWebView.getObject());
                    getJSCommon().a(this.q);
                    getJSCommon().a(this.k);
                    getJSCommon().a(this.m);
                    getJSCommon().a(new e());
                    CampaignEx campaignEx4 = this.A;
                    if (campaignEx4 != null && (campaignEx4.isMraid() || this.A.isActiveOm())) {
                        com.mbridge.msdk.mbsignalcommon.mraid.d dVar = new com.mbridge.msdk.mbsignalcommon.mraid.d(getContext());
                        this.al = dVar;
                        dVar.c();
                        this.al.a();
                        this.al.a(new com.mbridge.msdk.mbsignalcommon.mraid.d.b() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.6
                            @Override // com.mbridge.msdk.mbsignalcommon.mraid.d.b
                            public final void a(double d2) {
                                aa.d(MBTempContainer.y, "volume is : " + d2);
                                try {
                                    if (!MBTempContainer.this.A.isMraid() || MBTempContainer.this.f == null || MBTempContainer.this.f.getH5EndCardView() == null) {
                                        return;
                                    }
                                    MBTempContainer.this.f.getH5EndCardView().volumeChange(d2);
                                } catch (Exception e5) {
                                    aa.d(MBTempContainer.y, e5.getMessage());
                                }
                            }
                        });
                    }
                    getJSContainerModule().readyStatus(((j) windVaneWebView.getObject()).o());
                    try {
                        if (this.d != null) {
                            int i2 = getResources().getConfiguration().orientation;
                            if (d()) {
                                i = af.j(getContext());
                                iH = af.k(getContext());
                                if (af.a(getContext())) {
                                    int iL = af.l(getContext());
                                    if (i2 == 2) {
                                        i += iL;
                                    } else {
                                        iH += iL;
                                    }
                                }
                            } else {
                                i = af.i(getContext());
                                iH = af.h(getContext());
                            }
                            int iC = this.A.getRewardTemplateMode().c();
                            if (c(this.A) == 1) {
                                iC = i2;
                            }
                            getJSNotifyProxy().a(i2, iC, i, iH);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.mbridge.msdk.foundation.same.a.k, af.e(getContext()));
                            try {
                                if (this.o != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("name", this.o.a());
                                    jSONObject2.put("amount", this.o.b());
                                    jSONObject2.put("id", this.p);
                                    jSONObject.put("userId", this.n);
                                    jSONObject.put(ReportUtil.EVENT_TYPE_REWARD, jSONObject2);
                                    jSONObject.put("playVideoMute", this.q);
                                    jSONObject.put("extra", this.R);
                                }
                            } catch (JSONException e5) {
                                aa.a(y, e5.getMessage());
                            } catch (Exception e6) {
                                aa.a(y, e6.getMessage());
                            }
                            String string = jSONObject.toString();
                            try {
                                HashMap map = new HashMap();
                                map.put("type", "2");
                                map.put("update", "1");
                                m.a().a("2000133", this.A, map);
                            } catch (Exception unused) {
                            }
                            getJSNotifyProxy().a(string);
                            g.a().a((WebView) this.d, "oncutoutfetched", Base64.encodeToString(this.Q.getBytes(), 0));
                            getJSCommon().b(true);
                            loadModuleDatas();
                            this.g.postDelayed(this.h, 2000L);
                        }
                    } catch (Exception e7) {
                        if (MBridgeConstans.DEBUG) {
                            e7.printStackTrace();
                        }
                    }
                    ((j) windVaneWebView.getObject()).l.a();
                    if (this.w) {
                        getJSCommon().e(this.W);
                    }
                }
                if (getJSCommon().a() == 1 && (viewGroup = (ViewGroup) this.z.findViewById(t.a(getContext(), "mbridge_video_templete_webview_parent", "id"))) != null) {
                    ((ViewGroup) this.z).removeView(viewGroup);
                    ((ViewGroup) this.z).addView(viewGroup, 1);
                }
                viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
                g();
                return;
            }
            defaultLoad(0, "preload template webview is null or load error");
        } catch (Throwable th) {
            th.printStackTrace();
            a("onCreate error" + th);
        }
    }

    public void loadModuleDatas() {
        int iE;
        int i;
        j jVarB = b(this.A);
        int iK = jVarB != null ? jVarB.k() : 0;
        if (iK != 0) {
            this.q = iK;
        }
        int iF = this.m.f();
        int iC = c();
        int i2 = iC != 0 ? iC : iF;
        this.e.setSoundState(this.q);
        this.e.setCampaign(this.A);
        this.e.setPlayURL(this.B.s());
        CampaignEx campaignEx = this.A;
        if (campaignEx != null && campaignEx.getVst() > -2) {
            iE = this.A.getVst();
        } else {
            iE = this.m.e();
        }
        CampaignEx campaignEx2 = this.A;
        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5 && (i = this.F) > 1) {
            iE = a(iE, i);
            this.A.setVst(iE);
        }
        this.e.setVideoSkipTime(iE);
        this.e.setCloseAlert(this.m.i());
        this.e.setBufferTimeout(h());
        int i3 = iE;
        this.e.setNotifyListener(new com.mbridge.msdk.video.module.a.a.n(this.H, this.A, this.o, this.B, b(), this.k, i2, iE, new f(), this.m.z(), this.w, this.m.D()));
        this.e.setShowingTransparent(this.af);
        this.e.setAdSession(this.am);
        if (this.r && (this.t == com.mbridge.msdk.foundation.same.a.o || this.t == com.mbridge.msdk.foundation.same.a.p)) {
            this.e.setIVRewardEnable(this.t, this.u, this.v);
            this.e.setDialogRole(getJSCommon() != null ? getJSCommon().h() : 1);
        }
        this.f.setCampaign(this.A);
        this.f.addOrderViewData(this.S);
        this.f.setUnitID(this.k);
        this.f.setCloseDelayTime(i());
        this.f.setPlayCloseBtnTm(this.m.h());
        this.f.setVideoInteractiveType(this.m.g());
        this.f.setEndscreenType(this.m.q());
        this.f.setVideoSkipTime(i3);
        this.f.setShowingTransparent(this.af);
        this.f.setJSFactory(this.H);
        if (this.A.getPlayable_ads_without_video() == 2) {
            this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.A, this.B, this.o, b(), this.k, new d(), this.m.z(), this.w));
            this.f.preLoadData(this.H);
            this.f.showPlayableView();
        } else {
            this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.c(this.H, this.A, this.o, this.B, b(), this.k, new c(this.j, this.A), this.m.z(), this.w));
            this.f.preLoadData(this.H);
            this.e.preLoadData(this.H);
        }
        if (this.af) {
            this.f.setMBridgeClickMiniCardViewTransparent();
        }
    }

    static /* synthetic */ void m(MBTempContainer mBTempContainer) {
        try {
            if (mBTempContainer.D != null) {
                if (mBTempContainer.r && (mBTempContainer.t == com.mbridge.msdk.foundation.same.a.o || mBTempContainer.t == com.mbridge.msdk.foundation.same.a.p)) {
                    com.mbridge.msdk.video.bt.module.a.b bVar = mBTempContainer.D;
                    boolean z = true;
                    if (mBTempContainer.J != 1) {
                        z = false;
                    }
                    bVar.a(z, mBTempContainer.I);
                }
                mBTempContainer.D.a(mBTempContainer.G, mBTempContainer.ac, mBTempContainer.o);
                return;
            }
            if (mBTempContainer.j != null) {
                mBTempContainer.j.finish();
            }
        } catch (Exception unused) {
            if (mBTempContainer.j != null) {
                mBTempContainer.j.finish();
            }
        }
    }

    static /* synthetic */ void F(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.j.runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.7
                @Override // java.lang.Runnable
                public final void run() {
                    MBTempContainer.this.aa.setBackgroundColor(0);
                    MBTempContainer.this.aa.setVisibility(0);
                    MBTempContainer.this.aa.bringToFront();
                }
            });
        }
    }

    static /* synthetic */ void H(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.j.runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.8
                @Override // java.lang.Runnable
                public final void run() {
                    MBTempContainer.this.aa.setVisibility(8);
                }
            });
        }
    }
}
