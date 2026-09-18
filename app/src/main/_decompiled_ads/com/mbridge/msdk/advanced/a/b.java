package com.mbridge.msdk.advanced.a;

import android.content.Context;
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
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.mbridge.msdk.advanced.b.d;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeAdvancedShowManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private CampaignEx c;
    private MBNativeAdvancedView d;
    private d e;
    private com.mbridge.msdk.click.a f;
    private com.mbridge.msdk.advanced.b.c g;
    private boolean h;
    private ImageView j;
    private String k;
    private String l;
    private MBridgeIds m;
    private boolean n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1881b = "NativeAdvancedShowManager";
    private int i = -1;
    private View.OnClickListener o = new View.OnClickListener() { // from class: com.mbridge.msdk.advanced.a.b.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (b.this.h) {
                b.a(b.this, 1);
            }
        }
    };
    public Handler a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.advanced.a.b.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            MBNativeAdvancedWebview advancedNativeWebview;
            super.handleMessage(message);
            if (message.what != 2 || b.this.c == null || !b.this.c.isActiveOm() || b.this.d == null || (advancedNativeWebview = b.this.d.getAdvancedNativeWebview()) == null) {
                return;
            }
            try {
                AdSession adSession = advancedNativeWebview.getAdSession();
                if (adSession != null) {
                    AdEvents.createAdEvents(adSession).impressionOccurred();
                    aa.a("OMSDK", "adSession.impressionOccurred()");
                }
            } catch (Throwable th) {
                aa.a("OMSDK", th.getMessage());
                if (b.this.c != null) {
                    new p(advancedNativeWebview.getContext()).a(b.this.c.getRequestId(), b.this.c.getRequestIdNotice(), b.this.c.getId(), b.this.k, "fetch OM failed, exception" + th.getMessage());
                }
            }
        }
    };
    private com.mbridge.msdk.advanced.b.a p = new com.mbridge.msdk.advanced.b.a() { // from class: com.mbridge.msdk.advanced.a.b.3
        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(int i) {
            b.this.i = i;
            if (b.this.d != null) {
                b.this.d.changeCloseBtnState(i);
            }
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(Object obj, String str) {
            if (b.this.d != null) {
                b.this.d.setVisibility(8);
            }
            b.a(b.this, 1);
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(CampaignEx campaignEx) {
            b.this.a(campaignEx);
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void b(int i) {
            aa.d(b.this.f1881b, "resetCountdown" + i);
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a() {
            b.a(b.this, 1);
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(boolean z) {
            if (b.this.e != null) {
                b.this.n = z;
                if (z) {
                    b.this.e.e(b.this.m);
                } else {
                    b.this.e.f(b.this.m);
                }
            }
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(boolean z, String str) {
            try {
                if (b.this.e != null) {
                    if (TextUtils.isEmpty(str)) {
                        b.this.e.b(b.this.m);
                        b.this.e.d(b.this.m);
                        return;
                    }
                    CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(b.this.c));
                    campaignWithBackData.setClickURL(str);
                    if (z) {
                        String str2 = b.this.k;
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
                    b.this.a(campaignWithBackData);
                }
            } catch (Exception e2) {
                aa.d(b.this.f1881b, e2.getMessage());
            }
        }
    };

    public final String a() {
        CampaignEx campaignEx = this.c;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.c.getRequestId();
    }

    public b(Context context, String str, String str2) {
        this.k = str2;
        this.l = str;
        this.m = new MBridgeIds(str, str2);
        if (this.j == null) {
            ImageView imageView = new ImageView(context);
            this.j = imageView;
            imageView.setPadding(af.b(context, 2.0f), af.b(context, 2.0f), af.b(context, 2.0f), af.b(context, 2.0f));
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            this.j.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            this.j.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(af.b(contextG, 29.0f), af.b(contextG, 16.0f)) : layoutParams);
            this.j.setImageResource(contextG.getResources().getIdentifier("mbridge_native_advanced_close_icon", "drawable", com.mbridge.msdk.foundation.controller.b.d().b()));
        }
    }

    public final void a(com.mbridge.msdk.advanced.b.c cVar) {
        this.g = cVar;
    }

    public final void a(d dVar) {
        this.e = dVar;
    }

    public final com.mbridge.msdk.advanced.b.a b() {
        return this.p;
    }

    public final void a(final CampaignEx campaignEx, final MBNativeAdvancedView mBNativeAdvancedView, boolean z) {
        MBNativeAdvancedWebview advancedNativeWebview;
        FeedBackButton feedBackButtonB;
        if (mBNativeAdvancedView == null) {
            return;
        }
        com.mbridge.msdk.foundation.c.b.a().a(this.k, new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.advanced.a.b.4
            @Override // com.mbridge.msdk.foundation.c.a
            public final void a() {
                String string;
                b.this.e();
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                        jSONObject.put("status", 1);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    aa.b(b.this.f1881b, th.getMessage(), th);
                    string = "";
                }
                g.a().a((WebView) mBNativeAdvancedView.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }

            @Override // com.mbridge.msdk.foundation.c.a
            public final void b() {
                String string;
                b.this.d();
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                        jSONObject.put("status", 2);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    aa.b(b.this.f1881b, th.getMessage(), th);
                    string = "";
                }
                g.a().a((WebView) mBNativeAdvancedView.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }

            @Override // com.mbridge.msdk.foundation.c.a
            public final void a(String str) {
                String string;
                b.this.d();
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                        jSONObject.put("status", 2);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    aa.b(b.this.f1881b, th.getMessage(), th);
                    string = "";
                }
                g.a().a((WebView) mBNativeAdvancedView.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }
        });
        if (campaignEx.isMraid() && com.mbridge.msdk.foundation.c.b.a().b() && (feedBackButtonB = com.mbridge.msdk.foundation.c.b.a().b(this.k)) != null) {
            RelativeLayout.LayoutParams layoutParams = null;
            try {
                layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.c.b.a, com.mbridge.msdk.foundation.c.b.f2065b);
            }
            layoutParams.addRule(12);
            ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(feedBackButtonB);
            }
            mBNativeAdvancedView.addView(feedBackButtonB, layoutParams);
        }
        this.h = this.h;
        this.c = campaignEx;
        this.d = mBNativeAdvancedView;
        com.mbridge.msdk.advanced.js.b advancedNativeSignalCommunicationImpl = mBNativeAdvancedView.getAdvancedNativeSignalCommunicationImpl();
        if (advancedNativeSignalCommunicationImpl == null) {
            advancedNativeSignalCommunicationImpl = new com.mbridge.msdk.advanced.js.b(mBNativeAdvancedView.getContext(), this.l, this.k);
            List<CampaignEx> arrayList = new ArrayList<>();
            arrayList.add(campaignEx);
            advancedNativeSignalCommunicationImpl.a(arrayList);
        }
        advancedNativeSignalCommunicationImpl.a(this.h ? 1 : 0);
        advancedNativeSignalCommunicationImpl.a(this.p);
        mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(advancedNativeSignalCommunicationImpl);
        if (campaignEx.isHasMBTplMark() || !this.h) {
            this.j.setVisibility(8);
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setOnClickListener(this.o);
        }
        mBNativeAdvancedView.setCloseView(this.j);
        boolean z2 = false;
        if (mBNativeAdvancedView.getVisibility() != 0) {
            mBNativeAdvancedView.setVisibility(0);
        }
        boolean zA = an.a(mBNativeAdvancedView.getAdvancedNativeWebview(), 0);
        com.mbridge.msdk.advanced.b.c cVar = this.g;
        if (cVar == null || zA || cVar.b() == null || this.g.b().getAlpha() < 0.5f || this.g.b().getVisibility() != 0 || this.n) {
            if (z) {
                mBNativeAdvancedView.postDelayed(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.a(campaignEx, mBNativeAdvancedView, false);
                    }
                }, 200L);
                return;
            }
            return;
        }
        mBNativeAdvancedView.show();
        com.mbridge.msdk.foundation.controller.b.d().a(mBNativeAdvancedView.getContext());
        this.c.setCampaignUnitId(this.k);
        com.mbridge.msdk.foundation.c.b.a().a(this.k, campaignEx);
        CampaignEx campaignEx2 = this.c;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && mBNativeAdvancedView != null && (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) != null) {
            try {
                AdSession adSessionA = com.mbridge.msdk.a.b.a(com.mbridge.msdk.foundation.controller.b.d().g(), advancedNativeWebview, advancedNativeWebview.getUrl(), this.c);
                advancedNativeWebview.setAdSession(adSessionA);
                if (adSessionA != null) {
                    adSessionA.registerAdView(advancedNativeWebview);
                    adSessionA.start();
                }
                aa.a("OMSDK", "adSession.start()");
            } catch (Throwable th) {
                aa.a("OMSDK", th.getMessage());
                CampaignEx campaignEx3 = this.c;
                if (campaignEx3 != null) {
                    new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx3.getRequestId(), this.c.getRequestIdNotice(), this.c.getId(), this.k, "fetch OM failed, exception" + th.getMessage());
                }
            }
        }
        if (!this.c.isReport()) {
            final CampaignEx campaignEx4 = this.c;
            if (!campaignEx4.isHasMBTplMark()) {
                final Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                String str = this.k;
                com.mbridge.msdk.foundation.controller.b.d().a(contextG);
                if (!TextUtils.isEmpty(campaignEx4.getImpressionURL())) {
                    new Thread(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                k.a(h.a(contextG)).b(campaignEx4.getId());
                            } catch (Exception unused) {
                                aa.d(b.this.f1881b, "campain can't insert db");
                            }
                        }
                    }).start();
                    com.mbridge.msdk.click.a.a(contextG, campaignEx4, str, campaignEx4.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.g);
                }
                if (!TextUtils.isEmpty(str) && campaignEx4.getNativeVideoTracking() != null && campaignEx4.getNativeVideoTracking().p() != null) {
                    com.mbridge.msdk.click.a.a(contextG, campaignEx4, str, campaignEx4.getNativeVideoTracking().p(), false, false);
                }
                campaignEx4.setReport(true);
                com.mbridge.msdk.foundation.same.a.d.a(this.k, campaignEx4, "h5_native");
                z2 = true;
            }
            if (z2) {
                Context contextG2 = com.mbridge.msdk.foundation.controller.b.d().g();
                String str2 = this.k;
                if (campaignEx4 != null) {
                    try {
                        if (!TextUtils.isEmpty(campaignEx4.getOnlyImpressionURL())) {
                            com.mbridge.msdk.click.a.a(contextG2, campaignEx4, str2, campaignEx4.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.h);
                        }
                    } catch (Throwable th2) {
                        aa.d(this.f1881b, th2.getMessage());
                    }
                }
                a(campaignEx4, com.mbridge.msdk.foundation.controller.b.d().g(), this.k);
            }
            Context contextG3 = com.mbridge.msdk.foundation.controller.b.d().g();
            CampaignEx campaignEx5 = this.c;
            String str3 = this.k;
            if (campaignEx5 != null) {
                try {
                    if (campaignEx5.isMraid()) {
                        n nVar = new n();
                        nVar.m(campaignEx5.getRequestId());
                        nVar.o(campaignEx5.getRequestIdNotice());
                        nVar.q(campaignEx5.getId());
                        nVar.b(campaignEx5.isMraid() ? n.a : n.f2098b);
                        com.mbridge.msdk.foundation.same.report.n.a(nVar, contextG3.getApplicationContext(), str3);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            d dVar = this.e;
            if (dVar != null) {
                dVar.a(this.m);
            }
        }
        int i = this.i;
        if (i != -1) {
            mBNativeAdvancedView.changeCloseBtnState(i);
        }
        c.a(this.k);
        com.mbridge.msdk.advanced.common.b.b(this.l + this.k + campaignEx.getRequestId());
        this.a.sendEmptyMessageDelayed(2, 1000L);
        com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.c.getMaitve(), this.c.getMaitve_src());
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final void a(final CampaignEx campaignEx) {
        if (this.f == null) {
            this.f = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.k);
        }
        this.f.a(new NativeListener.TrackingExListener() { // from class: com.mbridge.msdk.advanced.a.b.6
            @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
            public final void onDismissLoading(Campaign campaign) {
            }

            @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
            public final void onDownloadFinish(Campaign campaign) {
            }

            @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
            public final void onDownloadProgress(int i) {
            }

            @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
            public final void onDownloadStart(Campaign campaign) {
            }

            @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
            public final boolean onInterceptDefaultLoadingDialog() {
                return false;
            }

            @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
            public final void onShowLoading(Campaign campaign) {
            }

            @Override // com.mbridge.msdk.out.NativeListener.TrackingExListener
            public final void onLeaveApp() {
                if (b.this.e != null) {
                    b.this.e.d(b.this.m);
                }
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onStartRedirection(Campaign campaign, String str) {
                ae.a(campaignEx, b.this.d);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onFinishRedirection(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ae.b(campaign, b.this.d);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onRedirectionFailed(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ae.b(campaign, b.this.d);
            }
        });
        campaignEx.setCampaignUnitId(this.k);
        this.f.a(campaignEx);
        if (!this.c.isReportClick()) {
            this.c.setReportClick(true);
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().l() != null) {
                com.mbridge.msdk.click.a.a(contextG, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
            }
        }
        d dVar = this.e;
        if (dVar != null) {
            dVar.b(this.m);
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
                aa.d(this.f1881b, th.getMessage());
            }
        }
    }

    public final void c() {
        if (this.e != null) {
            this.e = null;
        }
        if (this.p != null) {
            this.p = null;
        }
        if (this.o != null) {
            this.o = null;
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.d;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.destroy();
        }
        if (this.g != null) {
            this.g = null;
        }
        com.mbridge.msdk.foundation.c.b.a().c(this.k);
    }

    public final void d() {
        MBNativeAdvancedWebview advancedNativeWebview;
        if (this.d == null || com.mbridge.msdk.foundation.c.b.c || (advancedNativeWebview = this.d.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.advanced.js.a.a(advancedNativeWebview, "onViewAppeared", "");
    }

    public final void e() {
        MBNativeAdvancedWebview advancedNativeWebview;
        MBNativeAdvancedView mBNativeAdvancedView = this.d;
        if (mBNativeAdvancedView == null || (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestoryed()) {
            return;
        }
        g.a().a((WebView) advancedNativeWebview, "onViewDisappeared", "");
    }

    static /* synthetic */ void a(b bVar, int i) {
        d dVar = bVar.e;
        if (dVar != null) {
            dVar.c(bVar.m);
            bVar.e = null;
            String str = bVar.k;
            CampaignEx campaignEx = bVar.c;
            if (campaignEx != null && campaignEx.isMraid()) {
                n nVar = new n("2000061", campaignEx.getId(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), str, w.r(com.mbridge.msdk.foundation.controller.b.d().g()));
                nVar.b(n.a);
                com.mbridge.msdk.foundation.same.report.n.b(nVar, com.mbridge.msdk.foundation.controller.b.d().g(), str);
            }
        }
        com.mbridge.msdk.advanced.common.c cVarA = bVar.c != null ? com.mbridge.msdk.advanced.common.c.a().b(bVar.k).d(bVar.c.getRequestId()).g(bVar.c.getRequestIdNotice()).c(bVar.c.getId()).e(bVar.c.getCreativeId() + "").a(bVar.c.isBidCampaign()) : null;
        String str2 = bVar.k;
        if (cVarA != null) {
            cVarA.a("2000069");
            cVarA.a(i);
            if (com.mbridge.msdk.foundation.same.report.k.a().c()) {
                com.mbridge.msdk.foundation.same.report.k.a().a(cVarA.b());
            } else {
                com.mbridge.msdk.foundation.same.report.n.a(cVarA.b(), com.mbridge.msdk.foundation.controller.b.d().g(), str2);
            }
        }
        MBNativeAdvancedView mBNativeAdvancedView = bVar.d;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.setVisibility(8);
            bVar.e();
            MBNativeAdvancedWebview advancedNativeWebview = bVar.d.getAdvancedNativeWebview();
            if (advancedNativeWebview != null) {
                advancedNativeWebview.finishAdSession();
            }
        }
        Handler handler = bVar.a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
