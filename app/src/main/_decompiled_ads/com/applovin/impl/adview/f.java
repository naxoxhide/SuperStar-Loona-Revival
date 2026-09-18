package com.applovin.impl.adview;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;

/* JADX INFO: loaded from: classes.dex */
class f {
    private final WebViewRenderProcessClient agN = new WebViewRenderProcessClient() { // from class: com.applovin.impl.adview.f.1
        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            if (webView instanceof d) {
                com.applovin.impl.sdk.ad.e currentAd = ((d) webView).getCurrentAd();
                f.this.sdk.Cb().a(currentAd).a(com.applovin.impl.sdk.d.b.aSz).JJ();
                f.this.sdk.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    f.this.sdk.BL().i("AdWebViewRenderProcessClient", "WebView render process unresponsive for ad: " + currentAd);
                }
            }
        }
    };
    private final com.applovin.impl.sdk.n sdk;

    f(com.applovin.impl.sdk.n nVar) {
        this.sdk = nVar;
    }

    WebViewRenderProcessClient rt() {
        return this.agN;
    }
}
