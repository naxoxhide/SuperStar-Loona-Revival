package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.android.gms.ads.AdError;
import com.iab.omid.library.mmadbridge.ScriptInjector;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.n;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.mbbanner.view.MBBannerWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.videocommon.download.h;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.MBAdChoice;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: BannerShowManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private float A;
    com.mbridge.msdk.click.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.c f2267b;
    private boolean c;
    private CampaignEx d;
    private final MBBannerView e;
    private ImageView f;
    private MBBannerWebView g;
    private ImageView h;
    private ImageView i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private final String q;
    private final String r;
    private List<CampaignEx> s;
    private int t;
    private com.mbridge.msdk.mbbanner.common.bridge.a v;
    private AdSession w;
    private float z;
    private final long u = 15000;
    private final Handler x = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.mbbanner.common.c.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            try {
                if (c.this.w != null) {
                    AdEvents.createAdEvents(c.this.w).impressionOccurred();
                    c.this.w.finish();
                    c.this.w = null;
                }
            } catch (Throwable th) {
                aa.a("BannerShowManager", th.getMessage());
            }
        }
    };
    private final com.mbridge.msdk.foundation.same.e.a y = new com.mbridge.msdk.foundation.same.e.a() { // from class: com.mbridge.msdk.mbbanner.common.c.c.6
        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void b() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void a() {
            c.this.a("banner render failed because render is timeout");
        }
    };
    private final View.OnClickListener B = new View.OnClickListener() { // from class: com.mbridge.msdk.mbbanner.common.c.c.7
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.p) {
                c.c(c.this);
            }
        }
    };
    private com.mbridge.msdk.mbbanner.common.b.a C = new com.mbridge.msdk.mbbanner.common.b.a() { // from class: com.mbridge.msdk.mbbanner.common.c.c.8
        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(int i) {
            if (i != 2) {
                c.this.f();
            } else {
                c.d(c.this);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(String str) {
            c.c(c.this);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a() {
            c.c(c.this);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void b(int i) {
            if (i == 1) {
                c.this.d();
                c.this.a("", 1);
            } else {
                c.this.c();
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(CampaignEx campaignEx) {
            c.this.a(campaignEx);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(boolean z) {
            if (c.this.f2267b != null) {
                c.this.o = z;
                if (z) {
                    c.this.f2267b.c();
                } else {
                    c.this.f2267b.d();
                }
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(boolean z, String str) {
            try {
                if (c.this.f2267b != null) {
                    if (TextUtils.isEmpty(str)) {
                        c.this.f2267b.a();
                        c.this.f2267b.b();
                        return;
                    }
                    CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(c.this.d));
                    campaignWithBackData.setClickURL(str);
                    if (z) {
                        String str2 = c.this.q;
                        if (campaignWithBackData != null) {
                            try {
                                if (!TextUtils.isEmpty(str)) {
                                    new p(com.mbridge.msdk.foundation.controller.b.d().g()).b(campaignWithBackData.getRequestId(), campaignWithBackData.getRequestIdNotice(), campaignWithBackData.getId(), str2, str, campaignWithBackData.isBidCampaign());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    c.this.a(campaignWithBackData);
                }
            } catch (Exception e2) {
                aa.d("BannerShowManager", e2.getMessage());
            }
        }
    };
    private com.mbridge.msdk.mbsignalcommon.b.b D = new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.mbbanner.common.c.c.4
        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            c.this.l = true;
            aa.d("BannerCallJS", "fireOnSignalCommunication");
            g.a().a(webView);
            c.this.n = true;
            if (c.this.d == null || c.this.d.isHasMBTplMark()) {
                return;
            }
            c.this.d();
            c.this.a("", 1);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i, String str, String str2) {
            c.this.a(str);
            c.this.a(str, 2);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView) {
            c.this.c();
        }
    };

    public c(MBBannerView mBBannerView, com.mbridge.msdk.mbbanner.common.b.c cVar, String str, String str2, boolean z, f fVar) {
        this.c = z;
        this.e = mBBannerView;
        this.q = str2;
        this.r = str;
        this.f2267b = new com.mbridge.msdk.mbbanner.common.b.f(cVar, fVar);
    }

    public final void a(boolean z, int i) {
        this.t = i;
        if (i == 0) {
            f fVarE = d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), this.q);
            if (fVarE == null) {
                return;
            } else {
                z = fVarE.d() == 1;
            }
        }
        this.c = z;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    private boolean b() {
        String strB = b(this.d);
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        if (this.e != null) {
            if (this.g == null) {
                try {
                    MBBannerWebView mBBannerWebView = new MBBannerWebView(com.mbridge.msdk.foundation.controller.b.d().g());
                    this.g = mBBannerWebView;
                    mBBannerWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    this.g.setWebViewClient(new com.mbridge.msdk.mbbanner.view.a(this.q, this.s, this.C));
                } catch (Throwable unused) {
                    a("banner show failed because WebView is not available and try to show default", 1);
                    return false;
                }
            }
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (this.g.getVisibility() != 0) {
                this.g.setVisibility(0);
            }
            if (this.g.getParent() == null) {
                this.e.addView(this.g);
            }
            d(this.d.isMraid());
            if (this.d.isMraid()) {
                g();
            }
            this.d.setCampaignUnitId(this.q);
            com.mbridge.msdk.foundation.c.b.a().a(this.q, this.d);
            f();
            com.mbridge.msdk.mbbanner.common.bridge.a aVar = new com.mbridge.msdk.mbbanner.common.bridge.a(this.e.getContext(), this.r, this.q);
            this.v = aVar;
            aVar.a(this.s);
            this.v.a(this.C);
            this.v.a(this.t);
            this.g.setWebViewListener(this.D);
            this.g.setObject(this.v);
            if (!strB.startsWith(ShareInternalUtility.STAGING_PARAM)) {
                if (this.d.isActiveOm()) {
                    strB = com.mbridge.msdk.a.b.c(strB);
                }
                this.g.loadDataWithBaseURL(this.d.getBannerUrl(), strB, "text/html", "utf-8", null);
            } else {
                this.g.loadUrl(strB);
            }
        } else {
            a("banner render failed because banner view is null", 2);
            a("banner show failed because banner view is exception");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.e != null) {
            MBBannerWebView mBBannerWebView = this.g;
            if (mBBannerWebView != null && mBBannerWebView.getParent() != null) {
                this.e.removeView(this.g);
            }
            if (this.f == null) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
                this.f = imageView;
                imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.mbbanner.common.c.c.9
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        c.this.z = motionEvent.getRawX();
                        c.this.A = motionEvent.getRawY();
                        aa.d("BannerShowManager", c.this.z + "  " + c.this.A);
                        return false;
                    }
                });
                this.f.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.mbbanner.common.c.c.10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.this.a(BannerUtils.managerCampaignEX(com.mbridge.msdk.mbsignalcommon.communication.b.a(c.this.z, c.this.A), c.this.d));
                    }
                });
            }
            String imageUrl = this.d.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(imageUrl, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.mbbanner.common.c.c.11
                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                        if (c.this.f != null) {
                            c.this.f.setImageBitmap(bitmap);
                        }
                        c.this.l = true;
                        c.n(c.this);
                        c.this.f();
                        c.this.g();
                        if (c.this.p) {
                            return;
                        }
                        c.this.d();
                    }

                    @Override // com.mbridge.msdk.foundation.same.c.c
                    public final void onFailedLoad(String str, String str2) {
                        c.this.a("banner show failed because banner default view is exception");
                    }
                });
                return;
            } else {
                a("banner show failed because campain is exception");
                return;
            }
        }
        a("banner show failed because banner view is exception");
    }

    private String b(CampaignEx campaignEx) {
        String strInjectScriptContentIntoHtml;
        if (campaignEx == null) {
            return "";
        }
        String strB = h.a().b(campaignEx.getBannerUrl());
        if (TextUtils.isEmpty(strB)) {
            String bannerHtml = campaignEx.getBannerHtml();
            if (campaignEx.isActiveOm()) {
                try {
                    File file = new File(bannerHtml);
                    strInjectScriptContentIntoHtml = ScriptInjector.injectScriptContentIntoHtml(MBridgeConstans.OMID_JS_SERVICE_CONTENT, file.exists() ? y.a(file) : "");
                } catch (Exception unused) {
                    File file2 = new File(bannerHtml);
                    if (file2.exists() && file2.isFile() && file2.canRead()) {
                        strInjectScriptContentIntoHtml = "file:////" + bannerHtml;
                    }
                    return bannerHtml;
                }
            } else {
                File file3 = new File(bannerHtml);
                if (file3.exists() && file3.isFile() && file3.canRead()) {
                    strInjectScriptContentIntoHtml = "file:////" + bannerHtml;
                }
                return bannerHtml;
            }
            return strInjectScriptContentIntoHtml;
        }
        return ScriptInjector.injectScriptContentIntoHtml(MBridgeConstans.OMID_JS_SERVICE_CONTENT, strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.d == null || e()) {
            return;
        }
        this.x.removeCallbacks(this.y);
        com.mbridge.msdk.mbbanner.common.b.c cVar = this.f2267b;
        if (cVar != null) {
            cVar.a(str);
        }
        q.b(com.mbridge.msdk.foundation.controller.b.d().g(), this.d, this.q, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    public void d() {
        boolean z;
        boolean z2;
        MBBannerView mBBannerView;
        if (this.l && !this.m && this.f2267b != null) {
            this.m = true;
            this.x.removeCallbacks(this.y);
            CampaignEx campaignEx = this.d;
            if (campaignEx != null && !campaignEx.isCallbacked()) {
                this.d.setCallbacked(true);
                this.f2267b.a(this.s);
                com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.d.getMaitve(), this.d.getMaitve_src());
            }
        }
        if (this.l && this.j && this.k && this.m && this.d != null && !e()) {
            if (this.e != null) {
                CampaignEx campaignEx2 = this.d;
                if (an.a(this.e, campaignEx2 != null ? campaignEx2.getImpReportType() : 0) || this.o) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            if (!z && (mBBannerView = this.e) != null) {
                mBBannerView.postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.c.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.d();
                    }
                }, 1000L);
            }
            if (this.n && z) {
                int[] iArr = new int[2];
                this.e.getLocationInWindow(iArr);
                MBBannerWebView mBBannerWebView = this.g;
                float f = iArr[0];
                float f2 = iArr[1];
                aa.d("BannerCallJS", "fireOnBannerWebViewShow");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("startX", f);
                    jSONObject.put("startY", f2);
                    jSONObject.put("scale", af.e(com.mbridge.msdk.foundation.controller.b.d().g()));
                    g.a().a((WebView) mBBannerWebView, "webviewshow", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Throwable th) {
                    aa.b("BannerCallJS", "fireOnBannerWebViewShow", th);
                }
                MBBannerWebView mBBannerWebView2 = this.g;
                int i = iArr[0];
                int i2 = iArr[1];
                int width = this.e.getWidth();
                int height = this.e.getHeight();
                try {
                    int i3 = com.mbridge.msdk.foundation.controller.b.d().g().getResources().getConfiguration().orientation;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("orientation", i3 == 2 ? TJAdUnitConstants.String.LANDSCAPE : i3 == 1 ? TJAdUnitConstants.String.PORTRAIT : AdError.UNDEFINED_DOMAIN);
                    jSONObject2.put("locked", "true");
                    float fL = w.l(com.mbridge.msdk.foundation.controller.b.d().g());
                    float fM = w.m(com.mbridge.msdk.foundation.controller.b.d().g());
                    HashMap mapN = w.n(com.mbridge.msdk.foundation.controller.b.d().g());
                    int iIntValue = ((Integer) mapN.get("width")).intValue();
                    int iIntValue2 = ((Integer) mapN.get("height")).intValue();
                    HashMap map = new HashMap();
                    z2 = z;
                    try {
                        map.put("placementType", TJAdUnitConstants.String.INLINE);
                        map.put("state", "default");
                        map.put("viewable", "true");
                        map.put("currentAppOrientation", jSONObject2);
                        float f3 = i;
                        float f4 = i2;
                        float f5 = width;
                        float f6 = height;
                        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBBannerWebView2, f3, f4, f5, f6);
                        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBBannerWebView2, f3, f4, f5, f6);
                        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBBannerWebView2, fL, fM);
                        com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(mBBannerWebView2, iIntValue, iIntValue2);
                        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBBannerWebView2, map);
                        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBBannerWebView2);
                    } catch (Throwable th2) {
                        th = th2;
                        aa.b("BannerCallJS", "transInfoForMraid", th);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z2 = z;
                }
                this.n = false;
                if (!TextUtils.isEmpty(this.d.getImageUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).c(this.d.getImageUrl());
                }
                m.a().a("2000133", this.d, new HashMap());
            } else {
                z2 = z;
            }
            if (z2) {
                ImageView imageView = this.f;
                if (imageView != null && imageView.getVisibility() == 0) {
                    CampaignEx campaignEx3 = this.d;
                    if (campaignEx3 != null) {
                        if (campaignEx3 != null) {
                            c(campaignEx3, com.mbridge.msdk.foundation.controller.b.d().g(), this.q);
                            b(campaignEx3, com.mbridge.msdk.foundation.controller.b.d().g(), this.q);
                            a(campaignEx3, com.mbridge.msdk.foundation.controller.b.d().g(), this.q);
                        }
                        this.d.setReport(true);
                        com.mbridge.msdk.foundation.same.a.d.a(this.q, this.d, ReportUtil.INVENTORY_TYPE_BANNER);
                    }
                } else {
                    List<CampaignEx> list = this.s;
                    if (list != null && list.size() > 0) {
                        boolean z3 = false;
                        int i4 = 0;
                        for (int i5 = 0; i5 < this.s.size(); i5++) {
                            if (!this.s.get(i5).isHasMBTplMark() && (i5 == 0 || !this.s.get(i5).isReport())) {
                                c(this.s.get(i5), com.mbridge.msdk.foundation.controller.b.d().g(), this.q);
                                this.s.get(i5).setReport(true);
                                com.mbridge.msdk.foundation.same.a.d.a(this.q, this.s.get(i5), ReportUtil.INVENTORY_TYPE_BANNER);
                                i4 = i5;
                                z3 = true;
                            }
                        }
                        if (z3) {
                            b(this.s.get(i4), com.mbridge.msdk.foundation.controller.b.d().g(), this.q);
                            a(this.s.get(i4), com.mbridge.msdk.foundation.controller.b.d().g(), this.q);
                        }
                    }
                }
                this.p = true;
                com.mbridge.msdk.mbbanner.common.b.c cVar = this.f2267b;
                if (cVar != null) {
                    cVar.a(this.d);
                }
                try {
                    CampaignEx campaignEx4 = this.d;
                    if (campaignEx4 != null && campaignEx4.isActiveOm()) {
                        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                        MBBannerWebView mBBannerWebView3 = this.g;
                        AdSession adSessionA = com.mbridge.msdk.a.b.a(contextG, mBBannerWebView3, mBBannerWebView3.getUrl(), this.d);
                        this.w = adSessionA;
                        if (adSessionA != null) {
                            try {
                                adSessionA.registerAdView(this.g);
                                ImageView imageView2 = this.h;
                                if (imageView2 != null) {
                                    this.w.addFriendlyObstruction(imageView2, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
                                }
                                ImageView imageView3 = this.f;
                                if (imageView3 != null) {
                                    this.w.addFriendlyObstruction(imageView3, FriendlyObstructionPurpose.OTHER, null);
                                }
                                this.w.start();
                            } catch (Exception e) {
                                aa.a("OMSDK", e.getMessage());
                            }
                        } else {
                            CampaignEx campaignEx5 = this.d;
                            if (campaignEx5 != null) {
                                new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx5.getRequestId(), this.d.getRequestIdNotice(), this.d.getId(), this.q, "fetch OM failed, context null");
                            }
                        }
                    }
                } catch (Exception unused) {
                    CampaignEx campaignEx6 = this.d;
                    if (campaignEx6 != null) {
                        new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx6.getRequestId(), this.d.getRequestIdNotice(), this.d.getId(), this.q, "fetch OM failed, context null");
                    }
                }
                this.x.sendEmptyMessageDelayed(1, 1000L);
                q.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.d, this.q, "");
                BitmapDrawable bitmapDrawableA = com.mbridge.msdk.foundation.controller.b.d().a(this.q, this.d.getAdType());
                if (bitmapDrawableA != null) {
                    if (this.i == null) {
                        this.i = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
                    }
                    if (this.i.getVisibility() != 0) {
                        this.i.setVisibility(0);
                    }
                    af.a(this.i, bitmapDrawableA, this.e.getResources().getDisplayMetrics());
                    if (this.i.getParent() == null) {
                        this.e.addView(this.i, new ViewGroup.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                return;
            }
            this.d.setReport(false);
        }
    }

    private synchronized boolean e() {
        boolean zIsReport;
        zIsReport = this.d.isReport();
        if (!zIsReport) {
            this.d.setReport(true);
        }
        return zIsReport;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ImageView imageView;
        if (!this.c || (imageView = this.h) == null) {
            return;
        }
        if (imageView.getVisibility() != 0) {
            this.h.setVisibility(0);
            this.h.setOnClickListener(this.B);
        }
        if (this.h.getParent() != null || this.e == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f), af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        this.e.addView(this.h, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.e == null) {
            return;
        }
        CampaignEx campaignEx = this.d;
        if (campaignEx != null) {
            if (!(campaignEx.getPrivacyButtonTemplateVisibility() == 1)) {
                return;
            }
        }
        MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.b.d().g());
        mBAdChoice.setCampaign(this.d);
        mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.mbbanner.common.c.c.13
            @Override // com.mbridge.msdk.foundation.c.a
            public final void a() {
                String string;
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                        jSONObject.put("status", 1);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    aa.b("BannerShowManager", th.getMessage(), th);
                    string = "";
                }
                g.a().a((WebView) c.this.g, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }

            @Override // com.mbridge.msdk.foundation.c.a
            public final void b() {
                String string;
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                        jSONObject.put("status", 2);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    aa.b("BannerShowManager", th.getMessage(), th);
                    string = "";
                }
                g.a().a((WebView) c.this.g, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }

            @Override // com.mbridge.msdk.foundation.c.a
            public final void a(String str) {
                String string;
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                        jSONObject.put("status", 1);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    aa.b("BannerShowManager", th.getMessage(), th);
                    string = "";
                }
                g.a().a((WebView) c.this.g, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 6.0f), af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 6.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        this.e.addView(mBAdChoice, layoutParams);
    }

    public final void a() {
        AdSession adSession = this.w;
        if (adSession != null) {
            adSession.finish();
            this.w = null;
        }
        if (this.f2267b != null) {
            this.f2267b = null;
        }
        MBBannerWebView mBBannerWebView = this.g;
        if (mBBannerWebView != null) {
            mBBannerWebView.setWebViewListener(null);
        }
        if (this.D != null) {
            this.D = null;
        }
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
        MBBannerView mBBannerView = this.e;
        if (mBBannerView != null) {
            mBBannerView.removeAllViews();
        }
        MBBannerWebView mBBannerWebView2 = this.g;
        if (mBBannerWebView2 != null) {
            mBBannerWebView2.release();
        }
        com.mbridge.msdk.mbbanner.common.bridge.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
        if (this.C != null) {
            this.C = null;
        }
        com.mbridge.msdk.foundation.c.b.a().c(this.q);
    }

    public final void b(boolean z) {
        this.j = z;
        d();
        if (z) {
            return;
        }
        CampaignEx campaignEx = this.d;
        String str = this.q;
        if (campaignEx != null) {
            String strA = com.mbridge.msdk.mbsignalcommon.mraid.c.a(campaignEx.getId());
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str, strA, campaignEx.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.b(campaignEx.getId());
        }
    }

    public final void c(boolean z) {
        this.k = z;
        d();
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
                aa.d("BannerShowManager", th.getMessage());
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
                aa.d("BannerShowManager", th.getMessage());
            }
        }
    }

    private void c(final CampaignEx campaignEx, final Context context, String str) {
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k.a(com.mbridge.msdk.foundation.db.h.a(context)).b(campaignEx.getId());
                    } catch (Exception e) {
                        aa.d("BannerShowManager", e.getMessage());
                    }
                }
            }).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.g);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().p() == null) {
            return;
        }
        m.a().a("2000141", campaignEx, new HashMap());
        com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().p(), false, false);
    }

    public final void a(CampaignEx campaignEx) {
        if (this.p) {
            if (this.a == null) {
                this.a = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.q);
            }
            this.a.a(new NativeListener.TrackingExListener() { // from class: com.mbridge.msdk.mbbanner.common.c.c.3
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
                    ae.a(campaign, c.this.e);
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onFinishRedirection(Campaign campaign, String str) {
                    ae.b(campaign, c.this.e);
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onRedirectionFailed(Campaign campaign, String str) {
                    ae.b(campaign, c.this.e);
                }

                @Override // com.mbridge.msdk.out.NativeListener.TrackingExListener
                public final void onLeaveApp() {
                    if (c.this.f2267b != null) {
                        c.this.f2267b.b();
                    }
                }
            });
            campaignEx.setCampaignUnitId(this.q);
            this.a.a(campaignEx);
            if (!this.d.isReportClick()) {
                this.d.setReportClick(true);
                Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().l() != null) {
                    m.a().a("2000142", campaignEx, new HashMap());
                    com.mbridge.msdk.click.a.a(contextG, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
                }
            }
            com.mbridge.msdk.mbbanner.common.b.c cVar = this.f2267b;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (this.d != null) {
            com.mbridge.msdk.mbbanner.common.d.a.a(com.mbridge.msdk.mbbanner.common.a.a.a().c(this.d.getId()).b(this.q).e(this.d.getRequestId()).d(this.d.getRequestIdNotice()).g(str).a(i).a(this.d.isBidCampaign()), this.q);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (i == i3 && i2 == i4) {
            return;
        }
        MBBannerWebView mBBannerWebView = this.g;
        aa.d("BannerCallJS", "fireOnBannerViewSizeChange");
        try {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBBannerWebView, i, i2);
        } catch (Throwable th) {
            aa.b("BannerCallJS", "fireOnBannerViewSizeChange", th);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void d(boolean z) {
        if (this.e != null) {
            FeedBackButton feedBackButtonB = com.mbridge.msdk.foundation.c.b.a().b(this.q);
            if (com.mbridge.msdk.foundation.c.b.a().b() && z && feedBackButtonB != null) {
                ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(feedBackButtonB);
                }
                feedBackButtonB.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.c.b.a, com.mbridge.msdk.foundation.c.b.f2065b);
                }
                layoutParams.addRule(12);
                feedBackButtonB.setLayoutParams(layoutParams);
                this.e.addView(feedBackButtonB);
            }
            com.mbridge.msdk.foundation.c.b.a().a(this.q, new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.mbbanner.common.c.c.5
                @Override // com.mbridge.msdk.foundation.c.a
                public final void a() {
                    String string;
                    c.this.e.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        aa.b("BannerShowManager", th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) c.this.g, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.c.a
                public final void b() {
                    String string;
                    c.this.e.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        aa.b("BannerShowManager", th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) c.this.g, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.c.a
                public final void a(String str) {
                    String string;
                    c.this.e.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        aa.b("BannerShowManager", th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) c.this.g, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
            this.d.setCampaignUnitId(this.q);
            com.mbridge.msdk.foundation.c.b.a().a(this.q, this.d);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    public final void a(CampaignUnit campaignUnit) {
        CampaignEx campaignEx;
        if (campaignUnit != null) {
            ArrayList<CampaignEx> ads = campaignUnit.getAds();
            this.s = ads;
            if (ads == null || ads.size() <= 0) {
                campaignEx = null;
            } else {
                campaignEx = this.s.get(0);
            }
        } else {
            campaignEx = null;
        }
        this.d = campaignEx;
        if (campaignEx == null) {
            a("banner show failed because campain is exception");
            return;
        }
        this.x.removeCallbacks(this.y);
        if (this.c && this.h == null) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
            this.h = imageView;
            imageView.setBackgroundResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_banner_close", "drawable"));
            this.h.setVisibility(8);
            this.h.setContentDescription("closeButton");
        }
        this.l = false;
        this.m = false;
        this.p = false;
        if (!TextUtils.isEmpty(this.d.getBannerHtml()) || !TextUtils.isEmpty(this.d.getBannerUrl())) {
            com.mbridge.msdk.mbbanner.common.a.a aVarA = com.mbridge.msdk.mbbanner.common.a.a.a().c(this.d.getId()).e(this.d.getRequestId()).d(this.d.getRequestIdNotice()).b(this.q).a(this.d.isBidCampaign());
            String str = this.q;
            if (aVarA != null) {
                aVarA.a("2000067");
                if (com.mbridge.msdk.foundation.same.report.k.a().c()) {
                    com.mbridge.msdk.foundation.same.report.k.a().a(aVarA.b());
                } else {
                    n.a(aVarA.b(), com.mbridge.msdk.foundation.controller.b.d().g(), str);
                }
            }
        }
        this.x.postDelayed(this.y, 15000L);
        if (b()) {
            return;
        }
        if (!TextUtils.isEmpty(this.d.getBannerHtml()) || !TextUtils.isEmpty(this.d.getBannerUrl())) {
            a("banner render failed because res load failed", 2);
        }
        c();
    }

    static /* synthetic */ void c(c cVar) {
        MBBannerWebView mBBannerWebView = cVar.g;
        if (mBBannerWebView != null && mBBannerWebView.getParent() != null) {
            cVar.e.removeView(cVar.g);
        }
        ImageView imageView = cVar.f;
        if (imageView != null && imageView.getParent() != null) {
            cVar.f.setVisibility(8);
            cVar.e.removeView(cVar.f);
        }
        ImageView imageView2 = cVar.h;
        if (imageView2 != null && imageView2.getParent() != null) {
            cVar.e.removeView(cVar.h);
            cVar.h.setVisibility(8);
        }
        ImageView imageView3 = cVar.i;
        if (imageView3 != null && imageView3.getParent() != null) {
            cVar.e.removeView(cVar.i);
            cVar.i.setVisibility(8);
        }
        com.mbridge.msdk.mbbanner.common.a.a aVarA = com.mbridge.msdk.mbbanner.common.a.a.a().b(cVar.q).e(cVar.d.getRequestId()).d(cVar.d.getRequestIdNotice()).c(cVar.d.getId()).f(cVar.d.getCreativeId() + "").a(cVar.d.isBidCampaign());
        String str = cVar.q;
        if (aVarA != null) {
            aVarA.a("2000069");
            if (com.mbridge.msdk.foundation.same.report.k.a().c()) {
                com.mbridge.msdk.foundation.same.report.k.a().a(aVarA.b());
            } else {
                n.a(aVarA.b(), com.mbridge.msdk.foundation.controller.b.d().g(), str);
            }
        }
        BannerUtils.inserCloseId(cVar.q, cVar.s);
        com.mbridge.msdk.mbbanner.common.b.c cVar2 = cVar.f2267b;
        if (cVar2 != null) {
            cVar2.e();
        }
    }

    static /* synthetic */ void d(c cVar) {
        ImageView imageView;
        if (cVar.c && (imageView = cVar.h) != null && imageView.getVisibility() == 0) {
            cVar.h.setVisibility(8);
            cVar.h.setOnClickListener(null);
            if (cVar.e == null || cVar.h.getParent() == null) {
                return;
            }
            cVar.e.removeView(cVar.h);
        }
    }

    static /* synthetic */ void n(c cVar) {
        if (cVar.f != null) {
            MBBannerWebView mBBannerWebView = cVar.g;
            if (mBBannerWebView != null) {
                mBBannerWebView.setVisibility(8);
            }
            if (cVar.f.getVisibility() != 0) {
                cVar.f.setVisibility(0);
            }
            if (cVar.e != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                cVar.f.setScaleType(ImageView.ScaleType.FIT_XY);
                if (cVar.f.getParent() == null) {
                    cVar.e.addView(cVar.f, layoutParams);
                }
                cVar.d(true);
            }
        }
    }
}
