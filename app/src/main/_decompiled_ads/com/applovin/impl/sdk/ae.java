package com.applovin.impl.sdk;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ae extends ab {
    private WebView aFS;
    private final Set<WebView> aFT = Collections.synchronizedSet(new HashSet());
    private final x logger;
    private final n sdk;

    public ae(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
    }

    public void a(final com.applovin.impl.sdk.network.i iVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$ae$Qkg0DApFFFsQALmpGtF86oUIe_w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(iVar, appLovinPostbackListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.network.i iVar, AppLovinPostbackListener appLovinPostbackListener) {
        String strAppendQueryParameters = StringUtils.appendQueryParameters(iVar.zJ(), iVar.HP(), ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNW)).booleanValue());
        if (this.aFS == null) {
            WebView webViewCR = cR("<script>window.al_firePostback = function(url) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = url;\n    }, 100);\n}\n</script>");
            this.aFS = webViewCR;
            if (webViewCR == null) {
                if (x.Fk()) {
                    this.logger.i("WebTrackerManager", "Failed to fire postback since web view could not be created");
                }
                appLovinPostbackListener.onPostbackFailure(strAppendQueryParameters, -1);
                return;
            }
        }
        String str = "al_firePostback('" + strAppendQueryParameters + "')";
        if (com.applovin.impl.sdk.utils.h.KU()) {
            this.aFS.evaluateJavascript(str, null);
        } else {
            this.aFS.loadUrl("javascript:" + str);
        }
        appLovinPostbackListener.onPostbackSuccess(strAppendQueryParameters);
    }

    public void cQ(final String str) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            if (x.Fk()) {
                this.logger.i("WebTrackerManager", "Failed to fire tracker due to empty script string");
            }
        } else {
            if (!str.startsWith("<script")) {
                if (x.Fk()) {
                    this.logger.i("WebTrackerManager", "Failed to fire tracker due to improperly formatted script tag");
                    return;
                }
                return;
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$ae$_S-1c_SiE8GUsHgQv40Fx0XcR_w
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.cS(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void cS(String str) {
        final WebView webViewCR = cR(str);
        if (webViewCR == null) {
            if (x.Fk()) {
                this.logger.i("WebTrackerManager", "Failed to fire tracker since web view could not be created");
            }
        } else {
            this.aFT.add(webViewCR);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$ae$JEdp6b3FBBMB3J7oW9-T9tJVVg0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.i(webViewCR);
                }
            }, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNB)).intValue());
        }
    }

    private WebView cR(String str) {
        com.applovin.impl.sdk.utils.u.LD();
        WebView webViewB = com.applovin.impl.sdk.utils.u.b(n.getApplicationContext(), "web tracker");
        if (webViewB == null) {
            return null;
        }
        webViewB.getSettings().setJavaScriptEnabled(true);
        webViewB.setWebViewClient(this);
        webViewB.loadData("<html><head><link rel=\"icon\" href=\"data:,\">" + str + "</head><body></body></html>", "text/html", "UTF-8");
        return webViewB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void i(final WebView webView) {
        if (webView == null || !this.aFT.remove(webView)) {
            return;
        }
        Objects.requireNonNull(webView);
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$ae$yyRl_CxB7wekM5Upz5HSNI-cmno
            @Override // java.lang.Runnable
            public final void run() {
                webView.destroy();
            }
        });
    }

    @Override // com.applovin.impl.sdk.ab, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (webView == this.aFS) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$ae$eaqOJL_PWk1wLgcojAyTgAB2Vj8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.Fv();
                }
            });
        } else {
            i(webView);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fv() {
        this.aFS.destroy();
        this.aFS = null;
    }
}
