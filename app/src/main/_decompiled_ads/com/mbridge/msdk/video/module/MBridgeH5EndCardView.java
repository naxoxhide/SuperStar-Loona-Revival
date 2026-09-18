package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.videocommon.download.h;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.HashMap;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MBridgeH5EndCardView extends MBridgeBaseView implements g, com.mbridge.msdk.mbsignalcommon.mraid.b, com.mbridge.msdk.video.signal.g {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private long F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private String O;
    private boolean P;
    private boolean Q;
    protected View n;
    protected RelativeLayout o;
    protected ImageView p;
    protected WindVaneWebView q;
    protected Handler r;
    protected String s;
    protected boolean t;
    protected boolean u;
    protected String v;
    Handler w;
    boolean x;
    private boolean y;
    private boolean z;

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z) {
    }

    public void install(CampaignEx campaignEx) {
    }

    public void readyStatus(int i) {
    }

    public MBridgeH5EndCardView(Context context) {
        super(context);
        this.y = false;
        this.r = new Handler();
        this.t = false;
        this.u = false;
        this.z = false;
        this.A = 1;
        this.B = 1;
        this.C = false;
        this.D = false;
        this.E = 1;
        this.F = 0L;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = "";
        this.w = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (MBridgeH5EndCardView.this.G) {
                    MBridgeH5EndCardView.this.e.a(122, "");
                }
                MBridgeH5EndCardView.this.e.a(103, "");
            }
        };
        this.P = false;
        this.Q = false;
        this.x = false;
    }

    public MBridgeH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = false;
        this.r = new Handler();
        this.t = false;
        this.u = false;
        this.z = false;
        this.A = 1;
        this.B = 1;
        this.C = false;
        this.D = false;
        this.E = 1;
        this.F = 0L;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = "";
        this.w = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (MBridgeH5EndCardView.this.G) {
                    MBridgeH5EndCardView.this.e.a(122, "");
                }
                MBridgeH5EndCardView.this.e.a(103, "");
            }
        };
        this.P = false;
        this.Q = false;
        this.x = false;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_endcard_h5");
        if (iFindLayout >= 0) {
            View viewInflate = this.c.inflate(iFindLayout, (ViewGroup) null);
            this.n = viewInflate;
            try {
                this.p = (ImageView) viewInflate.findViewById(findID("mbridge_windwv_close"));
                this.o = (RelativeLayout) viewInflate.findViewById(findID("mbridge_windwv_content_rl"));
                this.q = new WindVaneWebView(getContext());
                this.q.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.o.addView(this.q);
                this.f = isNotNULL(this.p, this.q);
            } catch (Exception unused) {
                this.f = false;
            }
            addView(this.n, b());
            c();
            e();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    protected final void c() {
        super.c();
        if (this.f) {
            this.p.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeH5EndCardView.this.onCloseViewClick();
                }
            });
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.q != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.q, "onSystemDestory", "");
                new Thread(new a(this)).start();
            } else {
                this.e.a(103, "");
                this.e.a(119, "webview is null when closing webview");
            }
        } catch (Exception e2) {
            this.e.a(103, "");
            this.e.a(119, "close webview exception" + e2.getMessage());
            aa.a(MBridgeBaseView.TAG, e2.getMessage());
        }
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
    }

    private class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f2531b;

        public a(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f2531b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                aa.d("CloseRunnable", e.getMessage());
            }
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f2531b;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.w == null) {
                return;
            }
            this.f2531b.w.sendEmptyMessage(100);
        }
    }

    public void setError(boolean z) {
        this.u = z;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x011e A[EDGE_INSN: B:56:0x011e->B:57:0x011f BREAK  A[LOOP:0: B:41:0x00e4->B:51:0x010e]] */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        int iO;
        String strA = a();
        if (this.f && this.f2526b != null && !TextUtils.isEmpty(strA)) {
            this.F = System.currentTimeMillis();
            try {
                reportRenderResult("start", 0);
            } catch (Exception unused) {
            }
            BrowserView.MBDownloadListener mBDownloadListener = new BrowserView.MBDownloadListener(this.f2526b);
            mBDownloadListener.setTitle(this.f2526b.getAppName());
            this.q.setDownloadListener(mBDownloadListener);
            this.q.setCampaignId(this.f2526b.getId());
            this.q.setTempTypeForMetrics(3);
            if (this.f2526b != null) {
                this.q.setLocalRequestId(this.f2526b.getCurrentLRid());
            }
            setCloseVisible(8);
            this.q.setApiManagerJSFactory(bVar);
            if (this.f2526b.isMraid()) {
                this.q.setMraidObject(this);
            }
            final boolean z = strA.contains("wfr=1") || strA.contains("wfl=1");
            this.q.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.3
                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView, String str) {
                    super.a(webView, str);
                    if (MBridgeH5EndCardView.this.u) {
                        return;
                    }
                    MBridgeH5EndCardView.this.t = true;
                    aa.a(MBridgeBaseView.TAG, "onPageFinished,url:" + str);
                    MBridgeH5EndCardView.this.e.a(100, "");
                    if (MBridgeH5EndCardView.this.f2526b != null) {
                        n nVar = new n();
                        nVar.m(MBridgeH5EndCardView.this.f2526b.getRequestId());
                        nVar.o(MBridgeH5EndCardView.this.f2526b.getRequestIdNotice());
                        nVar.q(MBridgeH5EndCardView.this.f2526b.getId());
                        nVar.e(1);
                        nVar.t(String.valueOf(System.currentTimeMillis() - MBridgeH5EndCardView.this.F));
                        nVar.s("onPageFinished");
                        String str2 = "2";
                        if (MBridgeH5EndCardView.this.f2526b.getAdType() == 287) {
                            nVar.h("3");
                        } else if (MBridgeH5EndCardView.this.f2526b.getAdType() == 94) {
                            nVar.h("1");
                        } else if (MBridgeH5EndCardView.this.f2526b.getAdType() == 42) {
                            nVar.h("2");
                        }
                        if (MBridgeH5EndCardView.this.f2526b.isMraid()) {
                            nVar.b(n.a);
                        } else {
                            nVar.f(MBridgeH5EndCardView.this.f2526b.getendcard_url());
                            if (ak.b(MBridgeH5EndCardView.this.f2526b.getendcard_url()) && MBridgeH5EndCardView.this.f2526b.getendcard_url().contains(".zip")) {
                                str2 = "1";
                            }
                            nVar.g(str2);
                            nVar.b(n.f2098b);
                        }
                        com.mbridge.msdk.foundation.same.report.n.b(nVar, MBridgeH5EndCardView.this.v, MBridgeH5EndCardView.this.f2526b);
                    }
                    MBridgeH5EndCardView.this.e.a(120, "");
                    if (z) {
                        return;
                    }
                    try {
                        HashMap map = new HashMap();
                        map.put("result", "1");
                        map.put("type", "3");
                        m.a().a("2000155", MBridgeH5EndCardView.this.f2526b, map);
                    } catch (Throwable th) {
                        aa.d("WindVaneWebView", th.getMessage());
                    }
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView, int i, String str, String str2) {
                    super.a(webView, i, str, str2);
                    if (MBridgeH5EndCardView.this.u) {
                        return;
                    }
                    aa.a(MBridgeBaseView.TAG, "onReceivedError,url:" + str2);
                    MBridgeH5EndCardView.this.e.a(118, "onReceivedError " + i + str);
                    MBridgeH5EndCardView.this.reportRenderResult(str, 3);
                    MBridgeH5EndCardView.this.e.a(WorkQueueKt.MASK, "");
                    MBridgeH5EndCardView.this.e.a(129, "");
                    MBridgeH5EndCardView.this.u = true;
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView, int i) {
                    super.a(webView, i);
                    aa.b("WindVaneWebView", "h5EncardView readyStatus:" + i + "- isError" + MBridgeH5EndCardView.this.u);
                    MBridgeH5EndCardView.this.E = i;
                    if (!MBridgeH5EndCardView.this.u) {
                        MBridgeH5EndCardView.a(MBridgeH5EndCardView.this, System.currentTimeMillis() - MBridgeH5EndCardView.this.F, false);
                    }
                    if (z) {
                        try {
                            HashMap map = new HashMap();
                            map.put("result", i + "");
                            map.put("type", "3");
                            m.a().a("2000155", MBridgeH5EndCardView.this.f2526b, map);
                        } catch (Throwable th) {
                            aa.d("WindVaneWebView", th.getMessage());
                        }
                    }
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void c(WebView webView, int i) {
                    super.c(webView, i);
                    MBridgeH5EndCardView.this.E = i;
                    if (MBridgeH5EndCardView.this.D) {
                        return;
                    }
                    MBridgeH5EndCardView.this.D = true;
                    if (i == 1) {
                        MBridgeH5EndCardView.this.reportRenderResult("success", 4);
                    } else {
                        MBridgeH5EndCardView.this.e.a(WorkQueueKt.MASK, "");
                        MBridgeH5EndCardView.this.reportRenderResult("failed", 6);
                    }
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView) {
                    super.a(webView);
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }
            });
            if (TextUtils.isEmpty(this.f2526b.getMraid())) {
                try {
                    this.F = System.currentTimeMillis();
                    String str = this.f2526b.getendcard_url();
                    com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.v);
                    if (this.z && ak.b(str) && (str.contains("wfr=1") || (cVarA != null && cVarA.o() > 0))) {
                        if (str.contains("wfr=1")) {
                            String[] strArrSplit = str.split("&");
                            if (strArrSplit != null && strArrSplit.length > 0) {
                                int length = strArrSplit.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        iO = 20;
                                        break;
                                    }
                                    String str2 = strArrSplit[i];
                                    if (ak.b(str2) && str2.contains("to") && str2.split("=") != null && str2.split("=").length > 0) {
                                        iO = af.a((Object) str2.split("=")[1]);
                                        break;
                                    }
                                    i++;
                                }
                            } else {
                                iO = 20;
                                break;
                            }
                        } else {
                            if (cVarA == null || cVarA.o() <= 0) {
                                iO = 20;
                                break;
                            }
                            iO = cVarA.o();
                        }
                        if (iO >= 0) {
                            excuteEndCardShowTask(iO);
                        } else {
                            excuteEndCardShowTask(20);
                        }
                    }
                } catch (Throwable th) {
                    aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                }
            }
            setHtmlSource(h.a().b(strA));
            if (TextUtils.isEmpty(this.s)) {
                aa.a(MBridgeBaseView.TAG, "load url:" + strA);
                this.q.loadUrl(strA);
            } else {
                aa.a(MBridgeBaseView.TAG, "load html...");
                this.q.loadDataWithBaseURL(strA, this.s, "text/html", "UTF-8", null);
            }
        } else {
            reportRenderResult("PL URL IS NULL", 3);
            this.e.a(WorkQueueKt.MASK, "");
            this.e.a(129, "");
        }
        this.x = false;
    }

    public void reportRenderResult(String str, int i) {
        if (this.f2526b == null || this.u) {
            return;
        }
        n nVar = new n();
        nVar.m(this.f2526b.getRequestId());
        nVar.o(this.f2526b.getRequestIdNotice());
        nVar.q(this.f2526b.getId());
        nVar.e(i);
        nVar.t(String.valueOf(System.currentTimeMillis() - this.F));
        nVar.s(str);
        String str2 = "2";
        if (this.f2526b.getAdType() == 287) {
            nVar.h("3");
        } else if (this.f2526b.getAdType() == 94) {
            nVar.h("1");
        } else if (this.f2526b.getAdType() == 42) {
            nVar.h("2");
        }
        if (this.f2526b.isMraid()) {
            nVar.b(n.a);
        } else {
            nVar.f(this.f2526b.getendcard_url());
            if (ak.b(this.f2526b.getendcard_url()) && this.f2526b.getendcard_url().contains(".zip")) {
                str2 = "1";
            }
            nVar.g(str2);
            nVar.b(n.f2098b);
        }
        com.mbridge.msdk.foundation.same.report.n.b(nVar, this.v, this.f2526b);
    }

    public void startCounterEndCardShowTimer() {
        try {
            String str = this.f2526b.getendcard_url();
            int iA = 15;
            if (ak.b(str) && str.contains("wfl=1")) {
                String[] strArrSplit = str.split("&");
                if (strArrSplit != null && strArrSplit.length > 0) {
                    for (String str2 : strArrSplit) {
                        if (ak.b(str2) && str2.contains("timeout") && str2.split("=") != null && str2.split("=").length > 0) {
                            iA = af.a((Object) str2.split("=")[1]);
                        }
                    }
                }
                executeEndCardShow(iA);
            }
        } catch (Throwable th) {
            aa.a(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void notifyCloseBtn(int i) {
        if (i == 0) {
            this.I = true;
        } else {
            if (i != 1) {
                return;
            }
            this.J = true;
        }
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void toggleCloseBtn(int i) {
        int visibility = this.p.getVisibility();
        if (i == 1) {
            this.H = true;
            visibility = 0;
        } else if (i == 2) {
            this.H = false;
            visibility = 8;
            if (this.x) {
                if (!this.Q && !this.I) {
                    this.Q = true;
                    int i2 = this.B;
                    if (i2 == 0) {
                        this.L = true;
                    } else {
                        this.L = false;
                        if (i2 > -1) {
                            this.r.postDelayed(new e(this), this.B * 1000);
                        }
                    }
                }
            } else if (!this.P && !this.I) {
                this.P = true;
                int i3 = this.A;
                if (i3 == 0) {
                    this.K = true;
                } else {
                    this.K = false;
                    if (i3 > -1) {
                        this.r.postDelayed(new d(this), this.A * 1000);
                    }
                }
            }
        }
        setCloseVisible(visibility);
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f2534b;

        public d(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f2534b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f2534b;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.K = true;
            }
        }
    }

    private class e implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f2535b;

        public e(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f2535b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f2535b;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.L = true;
            }
        }
    }

    public void handlerPlayableException(String str) {
        if (this.u) {
            return;
        }
        this.u = true;
        this.t = false;
        if (this.f2526b != null) {
            n nVar = new n();
            nVar.m(this.f2526b.getRequestId());
            nVar.o(this.f2526b.getRequestIdNotice());
            nVar.q(this.f2526b.getId());
            nVar.s(str);
            com.mbridge.msdk.foundation.same.report.n.d(nVar, this.a.getApplicationContext(), this.v);
        }
    }

    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.q;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.4
                @Override // java.lang.Runnable
                public final void run() {
                    String string;
                    try {
                        aa.a(MBridgeBaseView.TAG, "webviewshow");
                        try {
                            int[] iArr = new int[2];
                            MBridgeH5EndCardView.this.q.getLocationOnScreen(iArr);
                            aa.d(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                            if (contextG != null) {
                                jSONObject.put("startX", af.a(contextG, iArr[0]));
                                jSONObject.put("startY", af.a(contextG, iArr[1]));
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.k, af.e(contextG));
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                            string = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
                        MBridgeH5EndCardView.this.e.a(109, "");
                        MBridgeH5EndCardView.d(MBridgeH5EndCardView.this);
                        MBridgeH5EndCardView.this.startCounterEndCardShowTimer();
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "oncutoutfetched", Base64.encodeToString(MBridgeH5EndCardView.this.O.getBytes(), 0));
                        MBridgeH5EndCardView.f(MBridgeH5EndCardView.this);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public void orientation(Configuration configuration) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", TJAdUnitConstants.String.LANDSCAPE);
            } else {
                jSONObject.put("orientation", TJAdUnitConstants.String.PORTRAIT);
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.q, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean canBackPress() {
        ImageView imageView = this.p;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public boolean isLoadSuccess() {
        return this.t;
    }

    public void setUnitId(String str) {
        this.v = str;
    }

    public void setCloseDelayShowTime(int i) {
        this.A = i;
    }

    public void setPlayCloseBtnTm(int i) {
        this.B = i;
    }

    public void setHtmlSource(String str) {
        this.s = str;
    }

    public void setCloseVisible(int i) {
        if (this.f) {
            this.p.setVisibility(i);
        }
    }

    public void setCloseVisibleForMraid(int i) {
        if (this.f) {
            this.M = true;
            if (i == 4) {
                this.p.setImageDrawable(new ColorDrawable(16711680));
            } else {
                this.p.setImageResource(findDrawable("mbridge_reward_close"));
            }
            this.p.setVisibility(0);
        }
    }

    protected RelativeLayout.LayoutParams b() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    protected void e() {
        if (this.f) {
            setMatchParent();
        }
    }

    protected String a() {
        if (this.f2526b != null) {
            this.G = true;
            if (this.f2526b.isMraid()) {
                this.z = false;
                String mraid = this.f2526b.getMraid();
                if (!TextUtils.isEmpty(mraid)) {
                    File file = new File(mraid);
                    try {
                        if (file.exists() && file.isFile() && file.canRead()) {
                            mraid = "file:////" + mraid;
                        } else {
                            mraid = this.f2526b.getEndScreenUrl();
                        }
                        return mraid;
                    } catch (Throwable th) {
                        if (!MBridgeConstans.DEBUG) {
                            return mraid;
                        }
                        th.printStackTrace();
                        return mraid;
                    }
                }
                return this.f2526b.getEndScreenUrl();
            }
            String str = this.f2526b.getendcard_url();
            if (!ak.a(str)) {
                this.z = true;
                String strB = com.mbridge.msdk.videocommon.download.g.a().b(str);
                if (TextUtils.isEmpty(strB)) {
                    try {
                        String path = Uri.parse(str).getPath();
                        if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                            String endScreenUrl = this.f2526b.getEndScreenUrl();
                            if (TextUtils.isEmpty(endScreenUrl)) {
                                return null;
                            }
                            this.z = false;
                            excuteTask();
                            return endScreenUrl;
                        }
                    } catch (Throwable th2) {
                        aa.d(MBridgeBaseView.TAG, th2.getMessage());
                    }
                    return str + "&native_adtype=" + this.f2526b.getAdType();
                }
                return strB + "&native_adtype=" + this.f2526b.getAdType();
            }
            this.z = false;
            return this.f2526b.getEndScreenUrl();
        }
        this.G = false;
        return null;
    }

    private class f implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f2536b;

        public f(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f2536b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f2536b;
            if (mBridgeH5EndCardView != null) {
                if (!mBridgeH5EndCardView.M) {
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }
                this.f2536b.H = true;
            }
        }
    }

    public void excuteTask() {
        if (this.z || this.A <= -1) {
            return;
        }
        this.r.postDelayed(new f(this), this.A * 1000);
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f2532b;

        public b(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f2532b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f2532b;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.D) {
                return;
            }
            this.f2532b.D = true;
            this.f2532b.t = false;
            MBridgeH5EndCardView.this.reportRenderResult("timeout", 5);
            this.f2532b.e.a(WorkQueueKt.MASK, "");
            aa.a(MBridgeBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
        }
    }

    public void executeEndCardShow(int i) {
        this.r.postDelayed(new b(this), i * 1000);
    }

    public void excuteEndCardShowTask(int i) {
        this.r.postDelayed(new c(this, i), i * 1000);
    }

    private static class c implements Runnable {
        private MBridgeH5EndCardView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2533b;

        public c(MBridgeH5EndCardView mBridgeH5EndCardView, int i) {
            this.a = mBridgeH5EndCardView;
            this.f2533b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.a;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.f2526b == null) {
                return;
            }
            try {
                if (!this.a.C) {
                    this.a.C = true;
                    n nVar = new n("2000043", 12, (this.f2533b * 1000) + "", this.a.f2526b.getendcard_url(), this.a.f2526b.getId(), this.a.v, "ready timeout", (ak.b(this.a.f2526b.getendcard_url()) && this.a.f2526b.getendcard_url().contains(".zip")) ? "1" : "2");
                    try {
                        if (this.a.f2526b.getAdType() == 287) {
                            nVar.h("3");
                        } else if (this.a.f2526b.getAdType() == 94) {
                            nVar.h("1");
                        } else if (this.a.f2526b.getAdType() == 42) {
                            nVar.h("2");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    nVar.m(this.a.f2526b.getRequestId());
                    nVar.n(this.a.f2526b.getCurrentLRid());
                    nVar.o(this.a.f2526b.getRequestIdNotice());
                    nVar.c(this.a.f2526b.getAdSpaceT());
                    MBridgeH5EndCardView.b(nVar, this.a.f2526b);
                    com.mbridge.msdk.foundation.same.report.n.a(nVar, this.a.v, this.a.f2526b);
                    this.a.isLoadSuccess();
                    return;
                }
                aa.b(MBridgeBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
            } catch (Throwable th) {
                aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    public boolean isPlayable() {
        return this.z;
    }

    public void onBackPress() {
        boolean z;
        if (this.H || (((z = this.I) && this.J) || (!(z || !this.K || this.x) || (!z && this.L && this.x)))) {
            onCloseViewClick();
        }
    }

    public void setLoadPlayable(boolean z) {
        this.x = z;
    }

    public void release() {
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.r = null;
        }
        Handler handler2 = this.w;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.w = null;
        }
        this.o.removeAllViews();
        m.a().a(this.f2526b);
        this.q.release();
        this.q = null;
    }

    public void volumeChange(double d2) {
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.q, d2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f2526b == null || !this.f2526b.isMraid()) {
            return;
        }
        if (z) {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.q, "true");
        } else {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.q, TJAdUnitConstants.String.FALSE);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 || this.N) {
            return;
        }
        this.N = true;
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        try {
            String clickURL = this.f2526b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.f2526b.setClickURL(str);
                CampaignEx mraidCampaign = getMraidCampaign();
                if (mraidCampaign != null) {
                    new p(getContext()).b(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.v, str, this.f2526b.isBidCampaign());
                }
            }
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getContext(), this.v);
            aVar.a(this);
            aVar.a(this.f2526b);
            this.f2526b.setClickURL(clickURL);
            this.e.a(126, "");
        } catch (Exception e2) {
            aa.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        try {
            onCloseViewClick();
        } catch (Exception e2) {
            aa.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        return this.f2526b;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z) {
        try {
            setCloseVisibleForMraid(z ? 4 : 0);
        } catch (Exception e2) {
            aa.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void setNotchValue(String str, int i, int i2, int i3, int i4) {
        this.O = str;
        if (this.f2526b == null || this.f2526b.getAdSpaceT() == 2) {
            return;
        }
        aa.d(MBridgeBaseView.TAG, "NOTCH H5ENDCARD " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
        int iB = af.b(getContext(), 20.0f);
        layoutParams.setMargins(i + iB, i3 + iB, i2 + iB, i4 + iB);
        this.p.setLayoutParams(layoutParams);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onStartRedirection(Campaign campaign, String str) {
        ae.a(campaign, this);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onFinishRedirection(Campaign campaign, String str) {
        ae.b(campaign, this);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onRedirectionFailed(Campaign campaign, String str) {
        ae.b(campaign, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), campaignEx.getCampaignUnitId());
            if (cVarA != null) {
                nVar.l(cVarA.l());
            }
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB != null) {
                nVar.k(aVarB.c());
            }
        } catch (Exception e2) {
            aa.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0088 A[Catch: NullPointerException -> 0x00aa, all -> 0x0126, TryCatch #1 {NullPointerException -> 0x00aa, blocks: (B:22:0x007e, B:24:0x0088, B:25:0x008e, B:27:0x0098, B:28:0x009c, B:30:0x00a6), top: B:50:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x008e A[Catch: NullPointerException -> 0x00aa, all -> 0x0126, TryCatch #1 {NullPointerException -> 0x00aa, blocks: (B:22:0x007e, B:24:0x0088, B:25:0x008e, B:27:0x0098, B:28:0x009c, B:30:0x00a6), top: B:50:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0098 A[Catch: NullPointerException -> 0x00aa, all -> 0x0126, TryCatch #1 {NullPointerException -> 0x00aa, blocks: (B:22:0x007e, B:24:0x0088, B:25:0x008e, B:27:0x0098, B:28:0x009c, B:30:0x00a6), top: B:50:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x009c A[Catch: NullPointerException -> 0x00aa, all -> 0x0126, TryCatch #1 {NullPointerException -> 0x00aa, blocks: (B:22:0x007e, B:24:0x0088, B:25:0x008e, B:27:0x0098, B:28:0x009c, B:30:0x00a6), top: B:50:0x007e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a6 A[Catch: NullPointerException -> 0x00aa, all -> 0x0126, TRY_LEAVE, TryCatch #1 {NullPointerException -> 0x00aa, blocks: (B:22:0x007e, B:24:0x0088, B:25:0x008e, B:27:0x0098, B:28:0x009c, B:30:0x00a6), top: B:50:0x007e, outer: #0 }] */
    static /* synthetic */ void a(MBridgeH5EndCardView mBridgeH5EndCardView, long j, boolean z) {
        int i;
        int i2;
        String str;
        int i3;
        String str2;
        n nVar;
        try {
            if (mBridgeH5EndCardView.C) {
                return;
            }
            mBridgeH5EndCardView.C = true;
            String str3 = (ak.b(mBridgeH5EndCardView.f2526b.getendcard_url()) && mBridgeH5EndCardView.f2526b.getendcard_url().contains(".zip")) ? "1" : "2";
            int i4 = 2;
            try {
                if (!z) {
                    if (mBridgeH5EndCardView.E == 2) {
                        i4 = 3;
                        i3 = 11;
                        str2 = "ready no";
                    } else {
                        i = 10;
                        i2 = 1;
                        str = "ready yes";
                    }
                    String str4 = str;
                    String str5 = str;
                    int i5 = i2;
                    nVar = new n("2000043", i, j + "", mBridgeH5EndCardView.f2526b.getendcard_url(), mBridgeH5EndCardView.f2526b.getId(), mBridgeH5EndCardView.v, str4, str3);
                    if (mBridgeH5EndCardView.f2526b.getAdType() == 287) {
                        nVar.h("3");
                    } else if (mBridgeH5EndCardView.f2526b.getAdType() == 94) {
                        nVar.h("1");
                    } else if (mBridgeH5EndCardView.f2526b.getAdType() == 42) {
                        nVar.h("2");
                    }
                    nVar.m(mBridgeH5EndCardView.f2526b.getRequestId());
                    nVar.n(mBridgeH5EndCardView.f2526b.getCurrentLRid());
                    nVar.o(mBridgeH5EndCardView.f2526b.getRequestIdNotice());
                    nVar.c(mBridgeH5EndCardView.f2526b.getAdSpaceT());
                    b(nVar, mBridgeH5EndCardView.f2526b);
                    com.mbridge.msdk.foundation.same.report.n.a(nVar, mBridgeH5EndCardView.v, mBridgeH5EndCardView.f2526b);
                    if (mBridgeH5EndCardView.isLoadSuccess() && i5 == 1) {
                        nVar.e(i5);
                        nVar.t(String.valueOf(j));
                        nVar.q(mBridgeH5EndCardView.f2526b.getId());
                        nVar.s(str5);
                        if (mBridgeH5EndCardView.f2526b.isMraid()) {
                            nVar.b(n.a);
                        } else {
                            nVar.f(mBridgeH5EndCardView.f2526b.getendcard_url());
                            nVar.g(str3);
                            nVar.b(n.f2098b);
                        }
                        com.mbridge.msdk.foundation.same.report.n.b(nVar, mBridgeH5EndCardView.v, mBridgeH5EndCardView.f2526b);
                        return;
                    }
                }
                i3 = 12;
                str2 = "ready timeout";
                if (mBridgeH5EndCardView.f2526b.getAdType() == 287) {
                    nVar.h("3");
                } else if (mBridgeH5EndCardView.f2526b.getAdType() == 94) {
                    nVar.h("1");
                } else if (mBridgeH5EndCardView.f2526b.getAdType() == 42) {
                    nVar.h("2");
                }
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
            i = i3;
            str = str2;
            i2 = i4;
            String str6 = str;
            String str7 = str;
            int i6 = i2;
            nVar = new n("2000043", i, j + "", mBridgeH5EndCardView.f2526b.getendcard_url(), mBridgeH5EndCardView.f2526b.getId(), mBridgeH5EndCardView.v, str6, str3);
            nVar.m(mBridgeH5EndCardView.f2526b.getRequestId());
            nVar.n(mBridgeH5EndCardView.f2526b.getCurrentLRid());
            nVar.o(mBridgeH5EndCardView.f2526b.getRequestIdNotice());
            nVar.c(mBridgeH5EndCardView.f2526b.getAdSpaceT());
            b(nVar, mBridgeH5EndCardView.f2526b);
            com.mbridge.msdk.foundation.same.report.n.a(nVar, mBridgeH5EndCardView.v, mBridgeH5EndCardView.f2526b);
            if (mBridgeH5EndCardView.isLoadSuccess()) {
            }
        } catch (Throwable th) {
            aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
        }
    }

    static /* synthetic */ void d(MBridgeH5EndCardView mBridgeH5EndCardView) {
        if (mBridgeH5EndCardView.f2526b == null || !mBridgeH5EndCardView.f2526b.isMraid()) {
            return;
        }
        int i = mBridgeH5EndCardView.getResources().getConfiguration().orientation;
        String str = AdError.UNDEFINED_DOMAIN;
        if (i != 0) {
            if (i == 1) {
                str = TJAdUnitConstants.String.PORTRAIT;
            } else if (i == 2) {
                str = TJAdUnitConstants.String.LANDSCAPE;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HashMap map = new HashMap();
        map.put("placementType", "Interstitial");
        map.put("state", "default");
        map.put("viewable", "true");
        map.put("currentAppOrientation", jSONObject);
        if (mBridgeH5EndCardView.getContext() instanceof Activity) {
            float fL = w.l(mBridgeH5EndCardView.getContext());
            float fM = w.m(mBridgeH5EndCardView.getContext());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) mBridgeH5EndCardView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.widthPixels;
            float f3 = displayMetrics.heightPixels;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBridgeH5EndCardView.q, fL, fM);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(mBridgeH5EndCardView.q, f2, f3);
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a aVarA = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
        WindVaneWebView windVaneWebView = mBridgeH5EndCardView.q;
        aVarA.a(windVaneWebView, windVaneWebView.getLeft(), mBridgeH5EndCardView.q.getTop(), mBridgeH5EndCardView.q.getWidth(), mBridgeH5EndCardView.q.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a aVarA2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
        WindVaneWebView windVaneWebView2 = mBridgeH5EndCardView.q;
        aVarA2.b(windVaneWebView2, windVaneWebView2.getLeft(), mBridgeH5EndCardView.q.getTop(), mBridgeH5EndCardView.q.getWidth(), mBridgeH5EndCardView.q.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.q, map);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.q, com.mbridge.msdk.mbsignalcommon.mraid.d.a);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.q);
    }

    static /* synthetic */ void f(MBridgeH5EndCardView mBridgeH5EndCardView) {
        if (mBridgeH5EndCardView.f2526b != null) {
            mBridgeH5EndCardView.f2526b.setCampaignUnitId(mBridgeH5EndCardView.v);
            com.mbridge.msdk.foundation.c.b.a().c(mBridgeH5EndCardView.v + "_1");
            com.mbridge.msdk.foundation.c.b.a().a(mBridgeH5EndCardView.v + "_2", mBridgeH5EndCardView.f2526b);
        }
        if (mBridgeH5EndCardView.f2526b == null || !mBridgeH5EndCardView.f2526b.isMraid()) {
            return;
        }
        ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.b.d().g());
        imageView.setBackgroundResource(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_reward_notice", "drawable"));
        ImageView imageView2 = mBridgeH5EndCardView.p;
        RelativeLayout.LayoutParams layoutParams = imageView2 != null ? (RelativeLayout.LayoutParams) imageView2.getLayoutParams() : null;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f), af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        if (layoutParams != null) {
            layoutParams2.leftMargin = layoutParams.rightMargin;
            layoutParams2.topMargin = layoutParams.topMargin;
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
        } else {
            layoutParams2.leftMargin = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f);
            layoutParams2.topMargin = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 12.0f);
        }
        mBridgeH5EndCardView.addView(imageView, layoutParams2);
        af.a(4, imageView, mBridgeH5EndCardView.f2526b, com.mbridge.msdk.foundation.controller.b.d().g(), false, new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.5
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
                    aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                    string = "";
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
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
                    aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                    string = "";
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }

            @Override // com.mbridge.msdk.foundation.c.a
            public final void a(String str) {
                String string;
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                        jSONObject.put("status", 2);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                    string = "";
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.q, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }
        });
    }
}
