package com.applovin.impl.adview;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ab;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdSize;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends ab {
    private final b agH;
    private final com.applovin.impl.sdk.x logger;
    private final com.applovin.impl.sdk.n sdk;

    public e(b bVar, com.applovin.impl.sdk.n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        this.agH = bVar;
    }

    protected b rr() {
        return this.agH;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return e(webView, url.toString());
        }
        if (!com.applovin.impl.sdk.x.Fk()) {
            return false;
        }
        this.logger.i("AdWebView", "No url found for request");
        return false;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return e(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.g("AdWebView", "Loaded resource: " + str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.g("AdWebView", "Loaded URL: " + str);
        }
        b bVar = this.agH;
        if (bVar != null) {
            bVar.d(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        b bVar = this.agH;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e currentAd = bVar.getCurrentAd();
            String str3 = "Received error with error code: " + i + " with description \\'" + str + "\\' for URL: " + str2;
            if (currentAd != null) {
                this.sdk.Cb().a(currentAd).a(com.applovin.impl.sdk.d.b.aSv, str3).JJ();
            }
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i("AdWebView", str3 + " for ad: " + currentAd);
            }
        }
        if (com.applovin.impl.sdk.utils.u.dM(str2)) {
            this.sdk.Cq().b(str2, "adWebViewReceivedError", i);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        b bVar = this.agH;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e currentAd = bVar.getCurrentAd();
            this.sdk.Cb().a(currentAd).a(com.applovin.impl.sdk.d.b.aSw).JJ();
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + currentAd);
            }
        }
        if (com.applovin.impl.sdk.utils.u.dM(webResourceRequest.getUrl().toString())) {
            this.sdk.Cq().b(webResourceRequest.getUrl().toString(), "adWebViewReceivedHttpError", webResourceResponse.getStatusCode());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        b bVar = this.agH;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e currentAd = bVar.getCurrentAd();
            String str = "Received SSL error: " + sslError;
            this.sdk.Cb().a(currentAd).a(com.applovin.impl.sdk.d.b.aSy, str).JJ();
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i("AdWebView", str + " for ad: " + currentAd);
            }
        }
    }

    @Override // com.applovin.impl.sdk.ab, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.render_process_gone"), null);
        if (this.agH == null) {
            return true;
        }
        com.applovin.impl.sdk.x.H("AdWebView", "Render process gone for ad: " + this.agH.getCurrentAd() + ". Process did crash: " + renderProcessGoneDetail.didCrash());
        com.applovin.impl.sdk.ad.e currentAd = this.agH.getCurrentAd();
        if (currentAd != null) {
            this.sdk.Cb().a(currentAd).a(com.applovin.impl.sdk.d.b.aSx).JJ();
            HashMap map = new HashMap();
            map.put("top_main_method", "onRenderProcessGone");
            map.put("details", "size=" + currentAd.getSize() + ",ad_id=" + currentAd.getAdIdNumber() + ",dsp=" + currentAd.getDspName());
            if (com.applovin.impl.sdk.utils.h.KY()) {
                map.put("source", renderProcessGoneDetail.didCrash() ? AppMeasurement.CRASH_ORIGIN : "non_crash");
            }
            this.sdk.Cq().a(com.applovin.impl.sdk.r.a.WEB_VIEW_ERROR, map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQk)).booleanValue()) {
            if (renderProcessGoneDetail.didCrash() && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQn)).booleanValue()) {
                throw new RuntimeException("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: " + (currentAd != null ? String.valueOf(currentAd.getAdIdNumber()) : "null"));
            }
            if (webView != null && webView.equals(this.agH.qZ())) {
                this.agH.destroy();
                AppLovinAdSize size = this.agH.getSize();
                if (com.applovin.impl.sdk.utils.u.b(size)) {
                    this.agH.a(size);
                    this.agH.resume();
                }
            }
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:146:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:87:0x016e  */
    protected boolean e(WebView webView, String str) {
        if (this.agH == null) {
            return true;
        }
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.g("AdWebView", "Processing click on ad URL \"" + str + "\"");
        }
        if (str != null && (webView instanceof d)) {
            Uri uri = Uri.parse(str);
            d dVar = (d) webView;
            String scheme = uri.getScheme();
            String host = uri.getHost();
            String path = uri.getPath();
            com.applovin.impl.sdk.ad.e currentAd = this.agH.getCurrentAd();
            if (currentAd == null) {
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.i("AdWebView", "Unable to process click, ad not found!");
                }
                return true;
            }
            boolean zRz = dVar.rz();
            boolean z = !currentAd.Gx() || zRz;
            if ("applovin".equals(scheme) && AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN.equals(host)) {
                if ("/adservice/close_ad".equals(path)) {
                    String str2 = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.CLOSE_URL_AD_VALUE);
                    if (StringUtils.isValidString(str2) && Boolean.parseBoolean(str2)) {
                        currentAd.setMaxAdValue("close_url", str);
                    }
                    rs();
                } else if ("/adservice/expand_ad".equals(path)) {
                    if (currentAd.Gw() && !zRz) {
                        if (com.applovin.impl.sdk.x.Fk()) {
                            this.logger.i("AdWebView", "Skipping expand command without user interaction");
                        }
                        return true;
                    }
                    b(dVar.getLastClickEvent());
                } else if ("/adservice/contract_ad".equals(path)) {
                    qT();
                } else {
                    if ("/adservice/no_op".equals(path)) {
                        return true;
                    }
                    if ("/adservice/load_url".equals(path)) {
                        if (currentAd.Gw() && !zRz) {
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.i("AdWebView", "Skipping URL load command without user interaction");
                            }
                            return true;
                        }
                        com.applovin.impl.sdk.utils.s.a(uri, this.agH, this.sdk);
                    } else if ("/adservice/track_click_now".equals(path)) {
                        if (currentAd.Gw() && !zRz) {
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.i("AdWebView", "Skipping click tracking command without user interaction");
                            }
                            return true;
                        }
                        if (currentAd instanceof com.applovin.impl.b.a) {
                            a((com.applovin.impl.b.a) currentAd, dVar);
                        } else {
                            a(dVar, Uri.parse("/adservice/track_click_now"));
                        }
                    } else if ("/adservice/deeplink".equals(path)) {
                        if (currentAd.Gw() && !zRz) {
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.i("AdWebView", "Skipping deep link plus command without user interaction");
                            }
                            return true;
                        }
                        if (currentAd instanceof com.applovin.impl.b.a) {
                            com.applovin.impl.b.a aVar = (com.applovin.impl.b.a) currentAd;
                            if (aVar.LY()) {
                                a(aVar, dVar);
                            } else {
                                a(dVar, uri);
                            }
                        } else {
                            a(dVar, uri);
                        }
                    } else if ("/adservice/postback".equals(path)) {
                        com.applovin.impl.sdk.utils.s.a(uri, currentAd, this.sdk);
                    } else if ("/playable_event".equals(path)) {
                        i(uri);
                    } else if ("/adservice/direct_download".equals(path)) {
                        Bundle bundleT = com.applovin.impl.sdk.utils.s.t(uri);
                        if (currentAd instanceof com.applovin.impl.b.a) {
                            com.applovin.impl.b.a aVar2 = (com.applovin.impl.b.a) currentAd;
                            if (aVar2.LY()) {
                                a(aVar2, dVar, bundleT);
                            } else {
                                a(dVar, currentAd.FI(), bundleT);
                            }
                        } else {
                            a(dVar, currentAd.FI(), bundleT);
                        }
                    } else if ("/template_error".equals(path)) {
                        com.applovin.impl.sdk.utils.s.b(uri, currentAd, this.sdk);
                    } else if (this.agH.qR() != null) {
                        if ("/video_began".equals(path)) {
                            this.agH.qR().a(com.applovin.impl.sdk.utils.u.a(uri.getQueryParameter("duration"), 0.0d));
                        } else if ("/video_completed".equals(path)) {
                            this.agH.qR().ru();
                        } else if ("/video_progress".equals(path)) {
                            this.agH.qR().b(com.applovin.impl.sdk.utils.u.a(uri.getQueryParameter("percent_viewed"), 0.0d));
                        } else if ("/video_waiting".equals(path)) {
                            this.agH.qR().rv();
                        } else if ("/video_resumed".equals(path)) {
                            this.agH.qR().rw();
                        }
                    } else {
                        if (com.applovin.impl.sdk.x.Fk()) {
                            this.logger.h("AdWebView", "Unknown URL: " + str);
                        }
                        if (com.applovin.impl.sdk.x.Fk()) {
                            this.logger.h("AdWebView", "Path: " + path);
                        }
                    }
                }
            } else if (z) {
                List<String> listHp = currentAd.Hp();
                List<String> listHq = currentAd.Hq();
                if ((listHp.isEmpty() || listHp.contains(scheme)) && (listHq.isEmpty() || listHq.contains(host))) {
                    if (currentAd instanceof com.applovin.impl.b.a) {
                        com.applovin.impl.b.a aVar3 = (com.applovin.impl.b.a) currentAd;
                        if (aVar3.LY()) {
                            a(aVar3, dVar);
                        } else {
                            a(dVar, uri);
                        }
                    } else {
                        a(dVar, uri);
                    }
                } else if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.i("AdWebView", "URL is not whitelisted - bypassing click");
                }
            }
        }
        return true;
    }

    private void rs() {
        this.agH.qU();
    }

    private void b(MotionEvent motionEvent) {
        this.agH.b(motionEvent);
    }

    private void qT() {
        this.agH.qT();
    }

    private void a(com.applovin.impl.b.a aVar, d dVar) {
        a(aVar, dVar, (Bundle) null);
    }

    private void a(com.applovin.impl.b.a aVar, d dVar, Bundle bundle) {
        com.applovin.impl.b.d dVarLV = aVar.LV();
        if (dVarLV != null) {
            com.applovin.impl.b.m.a(dVarLV.Mn(), this.agH.getSdk());
            a(dVar, dVarLV.Ml(), bundle);
        }
    }

    private void a(d dVar, Uri uri) {
        a(dVar, uri, (Bundle) null);
    }

    private void a(d dVar, Uri uri, Bundle bundle) {
        com.applovin.impl.sdk.ad.e currentAd = dVar.getCurrentAd();
        AppLovinAdView appLovinAdViewQY = this.agH.qY();
        if (appLovinAdViewQY != null && currentAd != null) {
            com.applovin.impl.sdk.d.d statsManagerHelper = dVar.getStatsManagerHelper();
            if (statsManagerHelper != null) {
                statsManagerHelper.JL();
            }
            if (currentAd instanceof com.applovin.impl.b.a) {
                ((com.applovin.impl.b.a) currentAd).getAdEventTracker().Je();
            }
            this.agH.a(currentAd, appLovinAdViewQY, uri, dVar.getAndClearLastClickEvent(), bundle);
            return;
        }
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        }
    }

    private void i(Uri uri) {
        String str;
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("success", false);
        String queryParameter = uri.getQueryParameter("type");
        if (booleanQueryParameter) {
            str = "Tracked event: " + queryParameter;
        } else {
            str = "Failed to track event: " + queryParameter;
        }
        com.applovin.impl.sdk.utils.u.e(str, com.applovin.impl.sdk.n.getApplicationContext());
    }
}
