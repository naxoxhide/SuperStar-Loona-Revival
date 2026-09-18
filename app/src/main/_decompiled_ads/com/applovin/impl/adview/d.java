package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.ab;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends i {
    private static WebView agI;
    private boolean agJ;
    private boolean agK;
    private final List<String> agL;
    private final Object agM;
    private com.applovin.impl.sdk.d.d agj;
    private com.applovin.impl.sdk.ad.e agq;
    private final com.applovin.impl.sdk.x logger;
    private final com.applovin.impl.sdk.n sdk;

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void rp() {
        rn();
    }

    public d(e eVar, com.applovin.impl.sdk.n nVar, Context context) {
        super(context);
        this.agL = new ArrayList();
        this.agM = new Object();
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.sdk = nVar;
        this.logger = nVar.BL();
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(eVar != null ? eVar : new ab());
        setWebChromeClient(new c(eVar != null ? eVar.rr() : null, nVar));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        if (com.applovin.impl.sdk.utils.h.La() && ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aQo)).booleanValue()) {
            setWebViewRenderProcessClient(new f(nVar).rt());
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.-$$Lambda$d$J2zYU73S1muuun2FEa0J0Oivc4E
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return d.a(view, motionEvent);
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.applovin.impl.adview.-$$Lambda$d$l-3aMc9qo_TrRhmq_t1NRgc1xtw
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.h(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h(View view) {
        if (!com.applovin.impl.sdk.x.Fk()) {
            return true;
        }
        this.logger.f("AdWebView", "Received a LongClick event.");
        return true;
    }

    public void a(com.applovin.impl.sdk.ad.e eVar) {
        if (!this.agJ) {
            this.agq = eVar;
            try {
                b(eVar);
                if (com.applovin.impl.sdk.utils.u.b(eVar.getSize())) {
                    setVisibility(0);
                }
                if (eVar instanceof com.applovin.impl.sdk.ad.a) {
                    com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
                    String strFz = aVar.Fz();
                    if (!aVar.shouldInjectOpenMeasurementScriptDuringCaching() && aVar.isOpenMeasurementEnabled()) {
                        strFz = this.sdk.Cn().dp(strFz);
                    }
                    if (com.applovin.impl.sdk.utils.u.aj(com.applovin.impl.sdk.n.getApplicationContext())) {
                        strFz = com.applovin.impl.sdk.utils.u.dL(strFz);
                    }
                    loadDataWithBaseURL(eVar.Hl(), strFz, "text/html", null, "");
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.f("AdWebView", "AppLovinAd rendered");
                        return;
                    }
                    return;
                }
                if (eVar instanceof com.applovin.impl.b.a) {
                    com.applovin.impl.b.a aVar2 = (com.applovin.impl.b.a) eVar;
                    com.applovin.impl.b.d dVarLV = aVar2.LV();
                    if (dVarLV != null) {
                        com.applovin.impl.b.i iVarMm = dVarLV.Mm();
                        Uri uriMz = iVarMm.Mz();
                        String string = uriMz != null ? uriMz.toString() : "";
                        String strMA = iVarMm.MA();
                        String strLZ = aVar2.LZ();
                        if (!StringUtils.isValidString(string) && !StringUtils.isValidString(strMA)) {
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.i("AdWebView", "Unable to load companion ad. No resources provided.");
                                return;
                            }
                            return;
                        }
                        if (iVarMm.My() == com.applovin.impl.b.i.a.STATIC) {
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.f("AdWebView", "Rendering WebView for static VAST ad");
                            }
                            String strN = n((String) this.sdk.a(com.applovin.impl.sdk.c.b.aPk), string);
                            if (aVar2.LK() && aVar2.isOpenMeasurementEnabled() && aVar2.LL()) {
                                strN = this.sdk.Cn().dp(strN);
                            }
                            loadDataWithBaseURL(eVar.Hl(), strN, "text/html", null, "");
                            return;
                        }
                        if (iVarMm.My() == com.applovin.impl.b.i.a.HTML) {
                            if (StringUtils.isValidString(strMA)) {
                                String strN2 = n(strLZ, strMA);
                                if (StringUtils.isValidString(strN2)) {
                                    strMA = strN2;
                                }
                                if (aVar2.LK() && aVar2.isOpenMeasurementEnabled() && !aVar2.shouldInjectOpenMeasurementScriptDuringCaching()) {
                                    strMA = this.sdk.Cn().dp(strMA);
                                }
                                String str = strMA;
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.logger.f("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str);
                                }
                                loadDataWithBaseURL(eVar.Hl(), str, "text/html", null, "");
                                return;
                            }
                            if (StringUtils.isValidString(string)) {
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.logger.f("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                }
                                a(string, eVar.Hl(), strLZ, this.sdk, aVar2);
                                return;
                            }
                            return;
                        }
                        if (iVarMm.My() == com.applovin.impl.b.i.a.IFRAME) {
                            if (StringUtils.isValidString(string)) {
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.logger.f("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                }
                                a(string, eVar.Hl(), strLZ, this.sdk, aVar2);
                                return;
                            } else {
                                if (StringUtils.isValidString(strMA)) {
                                    String strN3 = n(strLZ, strMA);
                                    if (StringUtils.isValidString(strN3)) {
                                        strMA = strN3;
                                    }
                                    if (aVar2.LK() && aVar2.isOpenMeasurementEnabled() && !aVar2.shouldInjectOpenMeasurementScriptDuringCaching()) {
                                        strMA = this.sdk.Cn().dp(strMA);
                                    }
                                    String str2 = strMA;
                                    if (com.applovin.impl.sdk.x.Fk()) {
                                        this.logger.f("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str2);
                                    }
                                    loadDataWithBaseURL(eVar.Hl(), str2, "text/html", null, "");
                                    return;
                                }
                                return;
                            }
                        }
                        if (com.applovin.impl.sdk.x.Fk()) {
                            this.logger.i("AdWebView", "Failed to render VAST companion ad of invalid type");
                            return;
                        }
                        return;
                    }
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.f("AdWebView", "No companion ad provided.");
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                throw new RuntimeException("Unable to render AppLovin ad (" + (eVar != null ? String.valueOf(eVar.getAdIdNumber()) : "null") + ") - " + th);
            }
        }
        com.applovin.impl.sdk.x.H("AdWebView", "Ad can not be loaded in a destroyed webview");
    }

    private void b(com.applovin.impl.sdk.ad.e eVar) {
        Boolean boolSw;
        loadUrl("about:blank");
        int iHo = this.agq.Ho();
        if (iHo >= 0) {
            setLayerType(iHo, null);
        }
        if (com.applovin.impl.sdk.utils.h.KT()) {
            getSettings().setMediaPlaybackRequiresUserGesture(eVar.Hk());
        }
        if (com.applovin.impl.sdk.utils.h.KU() && eVar.Hm()) {
            setWebContentsDebuggingEnabled(true);
        }
        y yVarHn = eVar.Hn();
        if (yVarHn != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState pluginStateSj = yVarHn.sj();
            if (pluginStateSj != null) {
                settings.setPluginState(pluginStateSj);
            }
            Boolean boolSk = yVarHn.sk();
            if (boolSk != null) {
                settings.setAllowFileAccess(boolSk.booleanValue());
            }
            Boolean boolSl = yVarHn.sl();
            if (boolSl != null) {
                settings.setLoadWithOverviewMode(boolSl.booleanValue());
            }
            Boolean boolSm = yVarHn.sm();
            if (boolSm != null) {
                settings.setUseWideViewPort(boolSm.booleanValue());
            }
            Boolean boolSn = yVarHn.sn();
            if (boolSn != null) {
                settings.setAllowContentAccess(boolSn.booleanValue());
            }
            Boolean boolSo = yVarHn.so();
            if (boolSo != null) {
                settings.setBuiltInZoomControls(boolSo.booleanValue());
            }
            Boolean boolSp = yVarHn.sp();
            if (boolSp != null) {
                settings.setDisplayZoomControls(boolSp.booleanValue());
            }
            Boolean boolSq = yVarHn.sq();
            if (boolSq != null) {
                settings.setSaveFormData(boolSq.booleanValue());
            }
            Boolean boolSr = yVarHn.sr();
            if (boolSr != null) {
                settings.setGeolocationEnabled(boolSr.booleanValue());
            }
            Boolean boolSs = yVarHn.ss();
            if (boolSs != null) {
                settings.setNeedInitialFocus(boolSs.booleanValue());
            }
            Boolean boolSt = yVarHn.st();
            if (boolSt != null) {
                settings.setAllowFileAccessFromFileURLs(boolSt.booleanValue());
            }
            Boolean boolSu = yVarHn.su();
            if (boolSu != null) {
                settings.setAllowUniversalAccessFromFileURLs(boolSu.booleanValue());
            }
            Boolean boolSx = yVarHn.sx();
            if (boolSx != null) {
                settings.setLoadsImagesAutomatically(boolSx.booleanValue());
            }
            Boolean boolSy = yVarHn.sy();
            if (boolSy != null) {
                settings.setBlockNetworkImage(boolSy.booleanValue());
            }
            if (com.applovin.impl.sdk.utils.h.KV()) {
                Integer numSi = yVarHn.si();
                if (numSi != null) {
                    settings.setMixedContentMode(numSi.intValue());
                }
                if (com.applovin.impl.sdk.utils.h.KW()) {
                    Boolean boolSv = yVarHn.sv();
                    if (boolSv != null) {
                        settings.setOffscreenPreRaster(boolSv.booleanValue());
                    }
                    if (!com.applovin.impl.sdk.utils.h.Ld() || (boolSw = yVarHn.sw()) == null) {
                        return;
                    }
                    settings.setAlgorithmicDarkeningAllowed(boolSw.booleanValue());
                }
            }
        }
    }

    public void bq(String str) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQN)).booleanValue()) {
            if (this.agK) {
                br(str);
                return;
            }
            synchronized (this.agL) {
                this.agL.add(str);
            }
            return;
        }
        br(str);
    }

    private void br(String str) {
        try {
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AdWebView", "Forwarding \"" + str + "\" to ad template");
            }
            loadUrl(str);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.c("AdWebView", "Unable to forward to template", th);
            }
            this.sdk.Cq().d("AdWebView", str, th);
        }
    }

    private void rm() {
        synchronized (this.agM) {
            Iterator<String> it = this.agL.iterator();
            while (it.hasNext()) {
                br(it.next());
            }
            this.agL.clear();
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.agJ = true;
        this.agK = false;
        super.destroy();
    }

    com.applovin.impl.sdk.ad.e getCurrentAd() {
        return this.agq;
    }

    private void a(String str, String str2, String str3, com.applovin.impl.sdk.n nVar, com.applovin.impl.b.a aVar) {
        String strN = n(str3, str);
        if (StringUtils.isValidString(strN)) {
            if (aVar.LK() && aVar.isOpenMeasurementEnabled() && !aVar.shouldInjectOpenMeasurementScriptDuringCaching()) {
                strN = nVar.Cn().dp(strN);
            }
            String str4 = strN;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AdWebView", "Rendering webview for VAST ad with resourceContents : " + str4);
            }
            loadDataWithBaseURL(str2, str4, "text/html", null, "");
            return;
        }
        String strN2 = n((String) nVar.a(com.applovin.impl.sdk.c.b.aPl), str);
        if (StringUtils.isValidString(strN2)) {
            if (aVar.LK() && aVar.isOpenMeasurementEnabled()) {
                strN2 = nVar.Cn().dp(strN2);
            }
            String str5 = strN2;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AdWebView", "Rendering webview for VAST ad with resourceContents : " + str5);
            }
            loadDataWithBaseURL(str2, str5, "text/html", null, "");
            return;
        }
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        }
        loadUrl(str);
    }

    private String n(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return str.replace("{SOURCE}", str2);
        }
        return null;
    }

    public static void a(final com.applovin.impl.sdk.network.i iVar, final com.applovin.impl.sdk.n nVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.-$$Lambda$d$5tCoTrQ5nXL8NIjIdE8AFVPBq_U
            @Override // java.lang.Runnable
            public final void run() {
                d.a(iVar, appLovinPostbackListener, nVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.sdk.network.i iVar, AppLovinPostbackListener appLovinPostbackListener, com.applovin.impl.sdk.n nVar) {
        String strZJ = iVar.zJ();
        rn();
        if (agI == null) {
            appLovinPostbackListener.onPostbackFailure(strZJ, -1);
            return;
        }
        if (iVar.HP() != null) {
            strZJ = StringUtils.appendQueryParameters(strZJ, iVar.HP(), ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNW)).booleanValue());
        }
        String str = "al_firePostback('" + strZJ + "');";
        if (com.applovin.impl.sdk.utils.h.KU()) {
            agI.evaluateJavascript(str, null);
        } else {
            agI.loadUrl("javascript:" + str);
        }
        appLovinPostbackListener.onPostbackSuccess(strZJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rn() {
        if (agI != null) {
            return;
        }
        WebView webViewB = com.applovin.impl.sdk.utils.u.b(com.applovin.impl.sdk.n.getApplicationContext(), "postbacks");
        agI = webViewB;
        if (webViewB == null) {
            return;
        }
        webViewB.getSettings().setJavaScriptEnabled(true);
        agI.loadData("<html><head>\n<script type=\"text/javascript\">\n    window.al_firePostback = function(postback) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = postback;\n    }, 100);\n};\n</script></head>\n<body></body></html>", "text/html", "UTF-8");
        agI.setWebViewClient(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.applovin.impl.adview.d$1, reason: invalid class name */
    class AnonymousClass1 extends ab {
        AnonymousClass1() {
        }

        @Override // com.applovin.impl.sdk.ab, android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView == d.agI) {
                d.agI.destroy();
                WebView unused = d.agI = null;
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.-$$Lambda$d$1$eBZSNJ-b8yGTyN_Io0bEf_xIY8c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.rp();
                    }
                });
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
    }

    public com.applovin.impl.sdk.d.d getStatsManagerHelper() {
        return this.agj;
    }

    public void setStatsManagerHelper(com.applovin.impl.sdk.d.d dVar) {
        this.agj = dVar;
    }

    public void setAdHtmlLoaded(boolean z) {
        this.agK = z;
        if (z && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQN)).booleanValue()) {
            rm();
        }
    }
}
