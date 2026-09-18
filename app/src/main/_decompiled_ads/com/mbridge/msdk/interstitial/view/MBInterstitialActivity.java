package com.mbridge.msdk.interstitial.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.activity.MBBaseActivity;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.interstitial.c.a;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.mraid.c;
import com.mbridge.msdk.mbsignalcommon.mraid.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MBInterstitialActivity extends MBBaseActivity implements b {
    public static final String INTENT_CAMAPIGN = "campaign";
    public static final String INTENT_UNIT_ID = "unitId";
    public static final long WATI_JS_INVOKE = 2000;
    public static final long WEB_LOAD_TIME = 15000;
    private CampaignEx e;
    private WindVaneWebView f;
    private ImageView g;
    private a.c h;
    private boolean i;
    private d j;
    private long k;
    private boolean l;
    private boolean m;
    public ProgressBar mProgressBar;
    public String mUnitid;
    private com.mbridge.msdk.click.a o;
    private boolean c = false;
    private boolean d = false;
    public boolean mIsMBPage = false;
    private Handler n = new Handler() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
        }
    };
    Runnable a = new Runnable() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.10
        @Override // java.lang.Runnable
        public final void run() {
            if (MBInterstitialActivity.this.d) {
                return;
            }
            MBInterstitialActivity.this.c = true;
            if (MBInterstitialActivity.this.h != null) {
                MBInterstitialActivity.this.h.a("load page timeout");
                if (MBInterstitialActivity.this.f != null) {
                    MBInterstitialActivity.this.f.setVisibility(8);
                    MBInterstitialActivity.this.f.setWebViewListener(null);
                    m.a().a(MBInterstitialActivity.this.e);
                    MBInterstitialActivity.this.f.release();
                }
                MBInterstitialActivity.this.hideLoading();
            }
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f2246b = new Runnable() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.11
        @Override // java.lang.Runnable
        public final void run() {
            if (MBInterstitialActivity.this.mIsMBPage) {
                return;
            }
            if (MBInterstitialActivity.this.e != null && MBInterstitialActivity.this.e.isMraid()) {
                MBInterstitialActivity.h(MBInterstitialActivity.this);
            }
            com.mbridge.msdk.interstitial.b.a.a().a(MBInterstitialActivity.this.e, MBInterstitialActivity.this.mUnitid);
            if (MBInterstitialActivity.this.c) {
                return;
            }
            MBInterstitialActivity.this.d = true;
            MBInterstitialActivity.this.hideLoading();
            MBInterstitialActivity.this.showWebView();
        }
    };

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z) {
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            int iA = t.a(getApplicationContext(), "mbridge_interstitial_activity", "layout");
            if (iA != -1) {
                setContentView(iA);
                initView();
                a();
                this.g.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MBInterstitialActivity.this.finish();
                    }
                });
                if (this.f != null && this.e != null) {
                    BrowserView.MBDownloadListener mBDownloadListener = new BrowserView.MBDownloadListener(this.e);
                    mBDownloadListener.setTitle(this.e.getAppName());
                    this.f.setCampaignId(this.e.getId());
                    this.f.setDownloadListener(mBDownloadListener);
                }
                b();
                try {
                    CampaignEx campaignEx = this.e;
                    if (campaignEx != null && (!TextUtils.isEmpty(campaignEx.getHtmlUrl()) || this.e.isMraid())) {
                        aa.b("MBInterstitialActivity", "url:" + this.e.getHtmlUrl());
                        goneWebView();
                        this.f.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.9
                            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                            public final void a(WebView webView, int i) {
                            }

                            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                            public final void a(WebView webView, String str, Bitmap bitmap) {
                            }

                            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                            public final void b(WebView webView, int i) {
                            }

                            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                            public final boolean b(WebView webView, String str) {
                                return true;
                            }

                            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                            public final void c(WebView webView, int i) {
                            }

                            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                                MBInterstitialActivity.this.i = true;
                            }

                            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                            public final void a(WebView webView, int i, String str, String str2) {
                                try {
                                    MBInterstitialActivity.this.i = true;
                                    if (MBInterstitialActivity.this.h != null) {
                                        MBInterstitialActivity.this.h.a(str);
                                    }
                                    MBInterstitialActivity.a(MBInterstitialActivity.this, 3, str);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                            public final void a(WebView webView, String str) {
                                try {
                                    if (MBInterstitialActivity.this.i) {
                                        return;
                                    }
                                    MBInterstitialActivity.a(MBInterstitialActivity.this, 1, "");
                                    if (MBInterstitialActivity.this.a != null && MBInterstitialActivity.this.n != null) {
                                        MBInterstitialActivity.this.n.removeCallbacks(MBInterstitialActivity.this.a);
                                    }
                                    if (MBInterstitialActivity.this.h != null) {
                                        MBInterstitialActivity.this.h.a();
                                    }
                                    if (!MBInterstitialActivity.this.mIsMBPage) {
                                        MBInterstitialActivity.this.n.postDelayed(MBInterstitialActivity.this.f2246b, 2000L);
                                    }
                                    MBInterstitialActivity.e(MBInterstitialActivity.this);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    if (MBInterstitialActivity.this.h != null) {
                                        MBInterstitialActivity.this.h.a("load page failed");
                                    }
                                }
                            }
                        });
                        String htmlUrl = this.e.getHtmlUrl();
                        if (this.e.isMraid()) {
                            File file = new File(this.e.getMraid());
                            if (file.exists() && file.isFile() && file.canRead()) {
                                htmlUrl = "file:////" + this.e.getMraid();
                            }
                        }
                        this.k = System.currentTimeMillis();
                        this.f.loadUrl(htmlUrl);
                        this.n.postDelayed(this.a, 15000L);
                    } else {
                        a.c cVar = this.h;
                        if (cVar != null) {
                            cVar.a("htmlurl is null");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.mbridge.msdk.foundation.controller.b.d().a((Context) this);
                com.mbridge.msdk.foundation.c.b.a().a(this.mUnitid, this, (ViewGroup) null, (ViewGroup.LayoutParams) null, new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.7
                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void a() {
                        String string;
                        MBInterstitialActivity.this.onPause();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject.put("status", 1);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b("MBInterstitialActivity", th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) MBInterstitialActivity.this.f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void b() {
                        String string;
                        MBInterstitialActivity.this.onResume();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject.put("status", 2);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b("MBInterstitialActivity", th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) MBInterstitialActivity.this.f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void a(String str) {
                        String string;
                        MBInterstitialActivity.this.onResume();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject.put("status", 2);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b("MBInterstitialActivity", th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) MBInterstitialActivity.this.f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }
                });
                this.e.setCampaignUnitId(this.mUnitid);
                com.mbridge.msdk.foundation.c.b.a().a(this.mUnitid, this.e);
                return;
            }
            a();
            b();
            a.c cVar2 = this.h;
            if (cVar2 != null) {
                cVar2.a("not found resource");
            }
            finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CampaignEx campaignEx = this.e;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f, "true");
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        CampaignEx campaignEx = this.e;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f, TJAdUnitConstants.String.FALSE);
    }

    private void a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mUnitid = intent.getStringExtra("unitId");
            this.e = (CampaignEx) intent.getSerializableExtra("campaign");
        }
        CampaignEx campaignEx = this.e;
        if (campaignEx != null && campaignEx.isMraid()) {
            d dVar = new d(this);
            this.j = dVar;
            dVar.c();
            this.j.a(new d.b() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.12
                @Override // com.mbridge.msdk.mbsignalcommon.mraid.d.b
                public final void a(double d) {
                    com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(MBInterstitialActivity.this.f, d);
                }
            });
        }
        CampaignEx campaignEx2 = this.e;
        if (campaignEx2 != null) {
            com.mbridge.msdk.click.b.a(this, campaignEx2.getMaitve(), this.e.getMaitve_src());
        }
    }

    public void initView() {
        this.f = (WindVaneWebView) findViewById(t.a(getApplicationContext(), "mbridge_interstitial_wv", "id"));
        this.mProgressBar = (ProgressBar) findViewById(t.a(getApplicationContext(), "mbridge_interstitial_pb", "id"));
        this.g = (ImageView) findViewById(t.a(getApplicationContext(), "mbridge_interstitial_iv_close", "id"));
    }

    private void b() {
        try {
            if (a.e == null || TextUtils.isEmpty(this.mUnitid) || !a.e.containsKey(this.mUnitid)) {
                return;
            }
            this.h = a.e.get(this.mUnitid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showWebView() {
        runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.13
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (MBInterstitialActivity.this.f == null || MBInterstitialActivity.this.e == null) {
                        return;
                    }
                    MBInterstitialActivity.this.f.setVisibility(0);
                    if (MBInterstitialActivity.this.e.isMraid()) {
                        MBInterstitialActivity.j(MBInterstitialActivity.this);
                    }
                    MBInterstitialActivity.k(MBInterstitialActivity.this);
                    HashMap map = new HashMap();
                    if (!TextUtils.isEmpty(MBInterstitialActivity.this.e.getMof_template_url())) {
                        map.put("type", "1");
                    } else {
                        map.put("type", "2");
                    }
                    m.a().a("2000133", MBInterstitialActivity.this.e, map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void goneWebView() {
        try {
            runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.14
                @Override // java.lang.Runnable
                public final void run() {
                    if (MBInterstitialActivity.this.f != null) {
                        MBInterstitialActivity.this.f.setVisibility(8);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLoading() {
        try {
            runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (MBInterstitialActivity.this.mProgressBar != null) {
                        MBInterstitialActivity.this.mProgressBar.setVisibility(0);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideLoading() {
        try {
            runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (MBInterstitialActivity.this.mProgressBar != null) {
                        MBInterstitialActivity.this.mProgressBar.setVisibility(8);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            a.c cVar = this.h;
            if (cVar != null) {
                cVar.b();
            }
            com.mbridge.msdk.click.a aVar = this.o;
            if (aVar != null) {
                aVar.a(false);
                this.o.a((NativeListener.NativeTrackingListener) null);
                this.o.a();
            }
            d dVar = this.j;
            if (dVar != null) {
                dVar.d();
            }
            if (!this.l) {
                c();
            }
            if (a.e != null && !TextUtils.isEmpty(this.mUnitid)) {
                a.e.remove(this.mUnitid);
            }
            this.h = null;
            com.mbridge.msdk.foundation.c.b.a().c(this.mUnitid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (!this.l) {
            c();
        }
        if (this.m) {
            return;
        }
        reportPlayableClosed();
    }

    public void reportPlayableClosed() {
        if (this.e != null) {
            n nVar = new n("2000061", this.e.getId(), this.e.getRequestId(), this.e.getRequestIdNotice(), this.mUnitid, w.r(com.mbridge.msdk.foundation.controller.b.d().g()));
            nVar.b(this.e.isMraid() ? n.a : n.f2098b);
            com.mbridge.msdk.foundation.same.report.n.b(nVar, com.mbridge.msdk.foundation.controller.b.d().g(), this.mUnitid);
            this.m = true;
            HashMap map = new HashMap();
            map.put("type", "2");
            m.a().c(this.e.getCurrentLRid(), "2000152", map);
            m.a().a("2000134", this.e, new HashMap());
        }
    }

    private void c() {
        p pVar = new p(getApplicationContext());
        CampaignEx campaignEx = this.e;
        if (campaignEx != null) {
            pVar.a(campaignEx.getRequestId(), this.e.getRequestIdNotice(), this.e.getId(), this.mUnitid, c.a(this.e.getId()), this.e.isBidCampaign());
            c.b(this.e.getId());
            this.l = true;
        }
    }

    public void onIntersClick() {
        try {
            a.c cVar = this.h;
            if (cVar != null) {
                cVar.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public f getIntersUnitSetting() {
        try {
            if (TextUtils.isEmpty(this.mUnitid)) {
                return null;
            }
            f fVarE = com.mbridge.msdk.c.d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), this.mUnitid);
            return fVarE == null ? f.f(this.mUnitid) : fVarE;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clickTracking() {
        try {
            if (this.e != null && !ak.a(this.mUnitid)) {
                onIntersClick();
                com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getApplicationContext(), this.mUnitid);
                this.o = aVar;
                aVar.a(new NativeListener.NativeTrackingListener() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.4
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

                    @Override // com.mbridge.msdk.out.BaseTrackingListener
                    public final void onStartRedirection(Campaign campaign, String str) {
                        try {
                            MBInterstitialActivity.this.showLoading();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.mbridge.msdk.out.BaseTrackingListener
                    public final void onRedirectionFailed(Campaign campaign, String str) {
                        MBInterstitialActivity.this.hideLoading();
                    }

                    @Override // com.mbridge.msdk.out.BaseTrackingListener
                    public final void onFinishRedirection(Campaign campaign, String str) {
                        try {
                            MBInterstitialActivity.this.hideLoading();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.o.a(this.e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.e.setClickURL(str);
            CampaignEx mraidCampaign = getMraidCampaign();
            if (mraidCampaign != null) {
                new p(getApplicationContext()).b(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.mUnitid, str, mraidCampaign.isBidCampaign());
            }
        }
        clickTracking();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        finish();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        return this.e;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z) {
        if (z) {
            this.g.setImageDrawable(new ColorDrawable(0));
        } else {
            this.g.setImageResource(t.a(getApplicationContext(), "mbridge_interstitial_close", "drawable"));
        }
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity
    public void setTopControllerPadding(int i, int i2, int i3, int i4, int i5) {
        int iB = af.b(this, 10.0f);
        if (i2 <= 0) {
            i2 = iB;
        }
        if (i3 <= 0) {
            i3 = iB;
        }
        if (i4 <= 0) {
            i4 = iB;
        }
        if (i5 <= 0) {
            i5 = iB;
        }
        if (this.g != null) {
            int iB2 = af.b(this, 25.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB2, iB2);
            layoutParams.addRule(11);
            layoutParams.setMargins(i2, i4, i3, i5);
            this.g.setLayoutParams(layoutParams);
        }
    }

    static /* synthetic */ void a(MBInterstitialActivity mBInterstitialActivity, int i, String str) {
        CampaignEx campaignEx = mBInterstitialActivity.e;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        n nVar = new n();
        nVar.m(mBInterstitialActivity.e.getRequestId());
        nVar.o(mBInterstitialActivity.e.getRequestIdNotice());
        nVar.q(mBInterstitialActivity.e.getId());
        nVar.e(i);
        nVar.t(String.valueOf(System.currentTimeMillis() - mBInterstitialActivity.k));
        nVar.f("");
        nVar.s(str);
        nVar.h(CampaignEx.CLICKMODE_ON);
        nVar.b(mBInterstitialActivity.e.isMraid() ? n.a : n.f2098b);
        com.mbridge.msdk.foundation.same.report.n.b(nVar, mBInterstitialActivity.mUnitid, mBInterstitialActivity.e);
    }

    static /* synthetic */ void e(MBInterstitialActivity mBInterstitialActivity) {
        String str;
        CampaignEx campaignEx = mBInterstitialActivity.e;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        int i = mBInterstitialActivity.getResources().getConfiguration().orientation;
        if (i == 0) {
            str = AdError.UNDEFINED_DOMAIN;
        } else if (i != 1) {
            str = i != 2 ? "UNDEFINED" : TJAdUnitConstants.String.LANDSCAPE;
        } else {
            str = TJAdUnitConstants.String.PORTRAIT;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
        float fL = w.l(mBInterstitialActivity);
        float fM = w.m(mBInterstitialActivity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mBInterstitialActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.widthPixels;
        float f2 = displayMetrics.heightPixels;
        HashMap map = new HashMap();
        map.put("placementType", "Interstitial");
        map.put("state", "default");
        map.put("viewable", "true");
        map.put("currentAppOrientation", jSONObject);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBInterstitialActivity.f, fL, fM);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(mBInterstitialActivity.f, f, f2);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBInterstitialActivity.f, map);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBInterstitialActivity.f, mBInterstitialActivity.j.a());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBInterstitialActivity.f);
    }

    static /* synthetic */ void h(MBInterstitialActivity mBInterstitialActivity) {
        List<String> pv_urls;
        try {
            com.mbridge.msdk.foundation.controller.b.d().a((Context) mBInterstitialActivity);
            if (!TextUtils.isEmpty(mBInterstitialActivity.e.getImpressionURL())) {
                Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                CampaignEx campaignEx = mBInterstitialActivity.e;
                com.mbridge.msdk.click.a.a(contextG, campaignEx, mBInterstitialActivity.mUnitid, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.g);
            }
            if (!TextUtils.isEmpty(mBInterstitialActivity.e.getOnlyImpressionURL())) {
                Context contextG2 = com.mbridge.msdk.foundation.controller.b.d().g();
                CampaignEx campaignEx2 = mBInterstitialActivity.e;
                com.mbridge.msdk.click.a.a(contextG2, campaignEx2, mBInterstitialActivity.mUnitid, campaignEx2.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.h);
            }
            com.mbridge.msdk.foundation.same.a.d.a(mBInterstitialActivity.mUnitid, mBInterstitialActivity.e, ReportUtil.INVENTORY_TYPE_INTERSTITIAL);
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.6
                @Override // java.lang.Runnable
                public final void run() {
                    k.a(h.a(MBInterstitialActivity.this)).b(MBInterstitialActivity.this.e.getId());
                }
            };
            com.mbridge.msdk.foundation.controller.c.a();
            com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
            CampaignEx campaignEx3 = mBInterstitialActivity.e;
            if (campaignEx3 == null || (pv_urls = campaignEx3.getPv_urls()) == null || pv_urls.size() <= 0) {
                return;
            }
            Iterator<String> it = pv_urls.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), mBInterstitialActivity.e, mBInterstitialActivity.mUnitid, it.next(), false, true);
            }
        } catch (Throwable th) {
            aa.a("MBInterstitialActivity", th.getMessage());
        }
    }

    static /* synthetic */ void j(MBInterstitialActivity mBInterstitialActivity) {
        try {
            n nVar = new n();
            nVar.m(mBInterstitialActivity.e.getRequestId());
            nVar.o(mBInterstitialActivity.e.getRequestIdNotice());
            nVar.q(mBInterstitialActivity.e.getId());
            nVar.b(mBInterstitialActivity.e.isMraid() ? n.a : n.f2098b);
            com.mbridge.msdk.foundation.same.report.n.a(nVar, mBInterstitialActivity.getApplicationContext(), mBInterstitialActivity.mUnitid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void k(MBInterstitialActivity mBInterstitialActivity) {
        CampaignEx campaignEx = mBInterstitialActivity.e;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        mBInterstitialActivity.f.post(new Runnable() { // from class: com.mbridge.msdk.interstitial.view.MBInterstitialActivity.5
            @Override // java.lang.Runnable
            public final void run() {
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(MBInterstitialActivity.this.f, MBInterstitialActivity.this.f.getLeft(), MBInterstitialActivity.this.f.getTop(), MBInterstitialActivity.this.f.getWidth(), MBInterstitialActivity.this.f.getHeight());
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(MBInterstitialActivity.this.f, MBInterstitialActivity.this.f.getLeft(), MBInterstitialActivity.this.f.getTop(), MBInterstitialActivity.this.f.getWidth(), MBInterstitialActivity.this.f.getHeight());
            }
        });
    }
}
