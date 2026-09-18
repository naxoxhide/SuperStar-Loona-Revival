package com.mbridge.msdk.splash.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.mbridge.msdk.click.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SplashShowManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private CampaignEx c;
    private MBSplashView d;
    private com.mbridge.msdk.splash.d.d e;
    private com.mbridge.msdk.click.a f;
    private boolean g;
    private TextView h;
    private View i;
    private String j;
    private String k;
    private MBridgeIds l;
    private String n;
    private String o;
    private String p;
    private String q;
    private boolean r;
    private ImageView t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2435b = "SplashShowManager";
    private int m = 5;
    private boolean s = true;
    private View.OnClickListener u = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.c.d.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (d.this.g) {
                d.this.b(1);
                d.b(d.this, -1);
            }
        }
    };
    public Handler a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.splash.c.d.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            MBSplashWebview splashWebview;
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2 || d.this.c == null || !d.this.c.isActiveOm() || d.this.d == null || (splashWebview = d.this.d.getSplashWebview()) == null) {
                    return;
                }
                try {
                    AdSession adSession = splashWebview.getAdSession();
                    if (adSession != null) {
                        AdEvents.createAdEvents(adSession).impressionOccurred();
                    }
                    aa.a("OMSDK", "adSession.impressionOccurred()");
                    return;
                } catch (Throwable th) {
                    aa.a("OMSDK", th.getMessage());
                    if (d.this.c != null) {
                        new p(splashWebview.getContext()).a(d.this.c.getRequestId(), d.this.c.getRequestIdNotice(), d.this.c.getId(), d.this.j, "fetch OM failed, exception" + th.getMessage());
                        return;
                    }
                    return;
                }
            }
            if (!d.this.r) {
                d.this.f();
            }
            if (d.this.m <= 0) {
                d.this.b(2);
                return;
            }
            if (!com.mbridge.msdk.foundation.c.b.c) {
                d.e(d.this);
                d dVar = d.this;
                d.b(dVar, dVar.m);
                if (!d.this.s) {
                    d.this.d();
                }
            } else {
                d.this.e();
            }
            d.this.a.removeMessages(1);
            sendEmptyMessageDelayed(1, 1000L);
        }
    };
    private com.mbridge.msdk.splash.d.a v = new com.mbridge.msdk.splash.d.a() { // from class: com.mbridge.msdk.splash.c.d.3
        @Override // com.mbridge.msdk.splash.d.a
        public final void a(int i) {
            if (d.this.d != null) {
                d.this.d.changeCloseBtnState(i);
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(Object obj, String str) {
            d.this.b(1);
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(CampaignEx campaignEx) {
            d.this.a(campaignEx);
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void b(int i) {
            aa.d(d.this.f2435b, "resetCountdown" + i);
            d.this.m = i;
            d.this.a.removeMessages(1);
            d.this.a.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a() {
            d.this.b(1);
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(boolean z) {
            if (z) {
                d.this.a.removeMessages(1);
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(boolean z, String str) {
            try {
                if (d.this.e != null) {
                    if (TextUtils.isEmpty(str)) {
                        d.this.e.b(d.this.l);
                        return;
                    }
                    CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(d.this.c));
                    campaignWithBackData.setClickURL(str);
                    if (z) {
                        String str2 = d.this.j;
                        if (campaignWithBackData != null) {
                            try {
                                if (!TextUtils.isEmpty(str) && campaignWithBackData.isMraid()) {
                                    new p(com.mbridge.msdk.foundation.controller.b.d().g()).b(campaignWithBackData.getRequestId(), campaignWithBackData.getRequestIdNotice(), campaignWithBackData.getId(), str2, str, campaignWithBackData.isBidCampaign());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    d.this.a(campaignWithBackData);
                }
            } catch (Exception e2) {
                aa.d(d.this.f2435b, e2.getMessage());
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(int i, int i2) {
            if (i == 1) {
                d.this.a.removeMessages(1);
            }
            if (i == 2) {
                d.this.m = i2;
                d.this.a.removeMessages(1);
                d.this.a.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    };
    private g w = new g() { // from class: com.mbridge.msdk.splash.c.d.4
        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            ae.a(campaign, d.this.d);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            ae.b(campaign, d.this.d);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            ae.b(campaign, d.this.d);
        }
    };

    static /* synthetic */ int e(d dVar) {
        int i = dVar.m;
        dVar.m = i - 1;
        return i;
    }

    public d(Context context, String str, String str2) {
        this.n = "点击跳过|";
        this.o = "点击跳过|";
        this.p = "秒";
        this.q = "秒后自动关闭";
        this.j = str2;
        this.k = str;
        this.l = new MBridgeIds(str, str2);
        if (this.h == null) {
            TextView textView = new TextView(context);
            this.h = textView;
            textView.setGravity(1);
            this.h.setTextIsSelectable(false);
            this.h.setPadding(af.b(context, 5.0f), af.b(context, 5.0f), af.b(context, 5.0f), af.b(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            this.h.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(af.b(context, 100.0f), af.b(context, 50.0f)) : layoutParams);
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            if (contextG != null) {
                String strB = com.mbridge.msdk.foundation.controller.b.d().b();
                int identifier = contextG.getResources().getIdentifier("mbridge_splash_count_time_can_skip", "string", strB);
                int identifier2 = contextG.getResources().getIdentifier("mbridge_splash_count_time_can_skip_not", "string", strB);
                int identifier3 = contextG.getResources().getIdentifier("mbridge_splash_count_time_can_skip_s", "string", strB);
                this.o = contextG.getResources().getString(identifier);
                String string = contextG.getResources().getString(identifier2);
                this.q = string;
                this.n = string;
                this.p = contextG.getResources().getString(identifier3);
                this.h.setBackgroundResource(contextG.getResources().getIdentifier("mbridge_splash_close_bg", "drawable", com.mbridge.msdk.foundation.controller.b.d().b()));
                this.h.setTextColor(contextG.getResources().getColor(contextG.getResources().getIdentifier("mbridge_splash_count_time_skip_text_color", "color", strB)));
            }
        }
    }

    public final void a(com.mbridge.msdk.splash.d.d dVar) {
        this.e = dVar;
    }

    public final void a(int i) {
        this.m = i;
    }

    public final void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.u);
        }
        this.i = viewGroup;
    }

    public final com.mbridge.msdk.splash.d.a a() {
        return this.v;
    }

    public final void a(CampaignEx campaignEx, MBSplashView mBSplashView) {
        MBSplashView mBSplashView2;
        Context context;
        MBSplashWebview splashWebview;
        a(this.g);
        this.c = campaignEx;
        this.d = mBSplashView;
        com.mbridge.msdk.splash.signal.b splashSignalCommunicationImpl = mBSplashView.getSplashSignalCommunicationImpl();
        if (splashSignalCommunicationImpl == null) {
            splashSignalCommunicationImpl = new com.mbridge.msdk.splash.signal.b(mBSplashView.getContext(), this.k, this.j);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            splashSignalCommunicationImpl.a(arrayList);
        }
        splashSignalCommunicationImpl.b(this.m);
        splashSignalCommunicationImpl.a(this.g ? 1 : 0);
        splashSignalCommunicationImpl.a(this.v);
        mBSplashView.setSplashSignalCommunicationImpl(splashSignalCommunicationImpl);
        boolean zIsHasMBTplMark = campaignEx.isHasMBTplMark();
        View view = this.i;
        if (view == null) {
            if (zIsHasMBTplMark) {
                this.h.setVisibility(8);
            }
            g();
            a(this.h);
            mBSplashView.setCloseView(this.h);
        } else {
            if (zIsHasMBTplMark) {
                view.setVisibility(8);
            }
            a(this.i);
            mBSplashView.setCloseView(this.i);
        }
        mBSplashView.show();
        CampaignEx campaignEx2 = this.c;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && mBSplashView != null && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            try {
                AdSession adSessionA = com.mbridge.msdk.a.b.a(com.mbridge.msdk.foundation.controller.b.d().g(), splashWebview, splashWebview.getUrl(), this.c);
                if (adSessionA != null) {
                    splashWebview.setAdSession(adSessionA);
                    adSessionA.registerAdView(splashWebview);
                    adSessionA.start();
                }
                aa.a("OMSDK", "adSession.start()");
            } catch (Throwable th) {
                aa.a("OMSDK", th.getMessage());
                CampaignEx campaignEx3 = this.c;
                if (campaignEx3 != null) {
                    new p(splashWebview.getContext()).a(campaignEx3.getRequestId(), this.c.getRequestIdNotice(), this.c.getId(), this.j, "fetch OM failed, exception" + th.getMessage());
                }
            }
        }
        b.a(this.j);
        b.b(this.c.getImageUrl());
        this.a.removeMessages(1);
        this.a.sendEmptyMessageDelayed(1, 1000L);
        this.a.sendEmptyMessageDelayed(2, 1000L);
        CampaignEx campaignEx4 = this.c;
        if (campaignEx4 != null) {
            if ((campaignEx4.getPrivacyButtonTemplateVisibility() == 1) && (mBSplashView2 = this.d) != null && mBSplashView2.getSplashWebview() != null && !this.d.isDynamicView() && this.c.isMraid() && (context = this.d.getContext()) != null) {
                try {
                    int iA = t.a(context, "mbridge_splash_notice", "drawable");
                    int iB = af.b(context, 35.0f);
                    int iB2 = af.b(context, 9.0f);
                    ImageView imageView = new ImageView(context);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB, iB);
                    layoutParams.addRule(9);
                    layoutParams.addRule(10);
                    layoutParams.setMargins(iB2, iB2, iB2, iB2);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    imageView.setBackgroundResource(iA);
                    af.a(3, imageView, this.c, context, true, new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.splash.c.d.7
                        @Override // com.mbridge.msdk.foundation.c.a
                        public final void a() {
                            d.this.e();
                        }

                        @Override // com.mbridge.msdk.foundation.c.a
                        public final void b() {
                            d.this.d();
                        }

                        @Override // com.mbridge.msdk.foundation.c.a
                        public final void a(String str) {
                            d.this.d();
                        }
                    });
                    this.d.addView(imageView);
                } catch (Throwable th2) {
                    aa.d(this.f2435b, th2.getMessage());
                }
            }
        }
        if (!campaignEx.isMraid()) {
            CampaignEx campaignEx5 = this.c;
            if (campaignEx5 != null) {
                campaignEx5.setCampaignUnitId(this.j);
                com.mbridge.msdk.foundation.c.b.a().b(this.j, 3);
                com.mbridge.msdk.foundation.c.b.a().a(this.j, this.c);
            }
            if (com.mbridge.msdk.foundation.c.b.a().b() && !this.d.isDynamicView()) {
                com.mbridge.msdk.foundation.c.b.a().a(this.j, new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.splash.c.d.6
                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void a() {
                        String string;
                        d.this.e();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject.put("status", 1);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th3) {
                            aa.b(d.this.f2435b, th3.getMessage(), th3);
                            string = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) d.this.d.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void b() {
                        String string;
                        d.this.d();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject.put("status", 2);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th3) {
                            aa.b(d.this.f2435b, th3.getMessage(), th3);
                            string = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) d.this.d.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void a(String str) {
                        String string;
                        d.this.d();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject.put("status", 2);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th3) {
                            aa.b(d.this.f2435b, th3.getMessage(), th3);
                            string = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) d.this.d.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }
                });
                FeedBackButton feedBackButtonB = com.mbridge.msdk.foundation.c.b.a().b(this.j);
                if (feedBackButtonB != null) {
                    RelativeLayout.LayoutParams layoutParams2 = null;
                    try {
                        layoutParams2 = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.c.b.a, com.mbridge.msdk.foundation.c.b.f2065b);
                    }
                    layoutParams2.topMargin = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 10.0f);
                    layoutParams2.leftMargin = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 10.0f);
                    ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(feedBackButtonB);
                    }
                    this.d.addView(feedBackButtonB, layoutParams2);
                }
            }
        }
        com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.c.getMaitve(), this.c.getMaitve_src());
        try {
            BitmapDrawable bitmapDrawableA = com.mbridge.msdk.foundation.controller.b.d().a(this.j, this.c.getAdType());
            if (bitmapDrawableA != null) {
                if (this.t == null) {
                    this.t = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
                }
                if (this.t.getVisibility() != 0) {
                    this.t.setVisibility(0);
                }
                af.a(this.t, bitmapDrawableA, mBSplashView.getResources().getDisplayMetrics());
                if (this.t.getParent() == null) {
                    mBSplashView.addView(this.t, new ViewGroup.LayoutParams(-1, -1));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String b() {
        CampaignEx campaignEx = this.c;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.c.getRequestId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        MBSplashView mBSplashView;
        if (this.c == null) {
            return;
        }
        boolean z = true;
        this.r = true;
        if (this.e != null && (mBSplashView = this.d) != null) {
            if (mBSplashView.getContext() != null && (this.d.getContext() instanceof Activity) && ((Activity) this.d.getContext()).isFinishing()) {
                this.e.a(this.l, "Activity is finishing");
                return;
            } else if (this.d.isShown()) {
                this.e.a(this.l);
            } else {
                this.e.a(this.l, "SplashView or container is not visibility");
            }
        }
        if (!this.c.isReport()) {
            if (!this.d.isDynamicView()) {
                CampaignEx campaignEx = this.c;
                if (campaignEx.isHasMBTplMark()) {
                    z = false;
                } else {
                    c(campaignEx, com.mbridge.msdk.foundation.controller.b.d().g(), this.j);
                    campaignEx.setReport(true);
                    com.mbridge.msdk.foundation.same.a.d.a(this.j, campaignEx, "splash");
                }
                if (z) {
                    b(campaignEx, com.mbridge.msdk.foundation.controller.b.d().g(), this.j);
                    a(campaignEx, com.mbridge.msdk.foundation.controller.b.d().g(), this.j);
                }
            } else {
                CampaignEx campaignEx2 = this.c;
                b(campaignEx2, com.mbridge.msdk.foundation.controller.b.d().g(), this.j);
                c(campaignEx2, com.mbridge.msdk.foundation.controller.b.d().g(), this.j);
                a(campaignEx2, com.mbridge.msdk.foundation.controller.b.d().g(), this.j);
                campaignEx2.setReport(true);
                com.mbridge.msdk.foundation.same.a.d.a(this.j, campaignEx2, "splash");
            }
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            CampaignEx campaignEx3 = this.c;
            String str = this.j;
            if (campaignEx3 != null) {
                try {
                    if (campaignEx3.isMraid()) {
                        n nVar = new n();
                        nVar.m(campaignEx3.getRequestId());
                        nVar.o(campaignEx3.getRequestIdNotice());
                        nVar.q(campaignEx3.getId());
                        nVar.b(campaignEx3.isMraid() ? n.a : n.f2098b);
                        com.mbridge.msdk.foundation.same.report.n.a(nVar, contextG.getApplicationContext(), str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void a(boolean z) {
        this.g = z;
        if (z) {
            this.n = this.o;
        } else {
            this.n = this.q;
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (this.f == null) {
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.j);
            this.f = aVar;
            aVar.a(this.w);
        }
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.j);
            this.f.a(campaignEx);
        } else {
            this.f.a(this.c);
        }
        if (!this.c.isReportClick()) {
            this.c.setReportClick(true);
            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx);
        }
        com.mbridge.msdk.splash.d.d dVar = this.e;
        if (dVar != null) {
            dVar.b(this.l);
            b(3);
        }
    }

    private void g() {
        String str;
        if (this.g) {
            str = this.o + this.m + this.p;
        } else {
            str = this.m + this.q;
        }
        this.h.setText(str);
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        MBSplashWebview splashWebview;
        MBSplashView mBSplashView;
        com.mbridge.msdk.splash.d.d dVar = this.e;
        if (dVar != null) {
            dVar.a(this.l, i);
            this.e = null;
            com.mbridge.msdk.splash.e.a.a(this.j, this.c);
        }
        ImageView imageView = this.t;
        if (imageView != null && imageView.getParent() != null && (mBSplashView = this.d) != null) {
            mBSplashView.removeView(this.t);
            this.t.setVisibility(8);
        }
        this.r = false;
        com.mbridge.msdk.splash.e.a.a(this.c != null ? com.mbridge.msdk.splash.a.b.a().b(this.j).d(this.c.getRequestId()).g(this.c.getRequestIdNotice()).c(this.c.getId()).e(this.c.getCreativeId() + "").a(this.c.isBidCampaign()) : null, this.j, i);
        MBSplashView mBSplashView2 = this.d;
        if (mBSplashView2 != null && (splashWebview = mBSplashView2.getSplashWebview()) != null) {
            splashWebview.finishAdSession();
        }
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    com.mbridge.msdk.click.a.a(context, campaignEx, str, it.next(), false, true);
                }
            } catch (Throwable th) {
                aa.d(this.f2435b, th.getMessage());
            }
        }
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.h);
            } catch (Throwable th) {
                aa.d(this.f2435b, th.getMessage());
            }
        }
    }

    private void c(final CampaignEx campaignEx, final Context context, String str) {
        com.mbridge.msdk.foundation.controller.b.d().a(context);
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.c.d.5
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k.a(h.a(context)).b(campaignEx.getId());
                    } catch (Exception unused) {
                        aa.d(d.this.f2435b, "campain can't insert db");
                    }
                }
            }).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.g);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().p() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().p(), false, false);
    }

    public final void c() {
        if (this.e != null) {
            this.e = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        if (this.u != null) {
            this.u = null;
        }
        MBSplashView mBSplashView = this.d;
        if (mBSplashView != null) {
            mBSplashView.destroy();
        }
        com.mbridge.msdk.foundation.c.b.a().c(this.j);
    }

    public final void d() {
        MBSplashView mBSplashView;
        Handler handler;
        this.s = true;
        if (this.d != null && this.m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
            this.a.sendEmptyMessageDelayed(1, 1000L);
        }
        if (com.mbridge.msdk.foundation.c.b.c || (mBSplashView = this.d) == null) {
            return;
        }
        mBSplashView.onResume();
        MBSplashWebview splashWebview = this.d.getSplashWebview();
        if (splashWebview == null || splashWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.splash.signal.c.a(splashWebview, "onSystemPause", "");
    }

    public final void e() {
        Handler handler;
        this.s = false;
        if (this.d != null && this.m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
        }
        MBSplashView mBSplashView = this.d;
        if (mBSplashView != null) {
            mBSplashView.onPause();
            MBSplashWebview splashWebview = this.d.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.splash.signal.c.a(splashWebview, "onSystemPause", "");
        }
    }

    static /* synthetic */ void b(d dVar, int i) {
        MBSplashView mBSplashView = dVar.d;
        if (mBSplashView != null) {
            mBSplashView.updateCountdown(i);
            if (dVar.d.getSplashSignalCommunicationImpl() != null) {
                dVar.d.getSplashSignalCommunicationImpl().c(i);
            }
        }
        if (i < 0) {
            dVar.m = i;
            return;
        }
        com.mbridge.msdk.splash.d.d dVar2 = dVar.e;
        if (dVar2 != null) {
            dVar2.a(dVar.l, i * 1000);
        }
        if (dVar.i == null) {
            dVar.g();
        }
    }
}
