package com.fyber.inneractive.sdk.measurement.tracker;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.m;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.AdSessionContext;
import com.iab.omid.library.fyber.adsession.Partner;
import com.iab.omid.library.fyber.publisher.AdSessionStatePublisher;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements com.fyber.inneractive.sdk.measurement.a.InterfaceC0271a {
    public AdSession a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdEvents f951b;
    public q c;
    public final Partner e;
    public WebView f;
    public boolean d = false;
    public WebViewClient g = new a();

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            c.this.a(true);
            return true;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IAlog.a("clearing webview", new Object[0]);
            WebView webView = c.this.f;
            if (webView != null) {
                webView.destroy();
                c.this.f = null;
            }
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.measurement.tracker.c$c, reason: collision with other inner class name */
    public enum EnumC0273c {
        CloseButton,
        ProgressOverlay,
        IdentifierView
    }

    public c(Partner partner, WebView webView, q<?> qVar) {
        this.e = partner;
        this.f = webView;
        this.c = qVar;
    }

    public void a(Throwable th) {
        String str = String.format("%s - %s", "OpenMeasurementTracker", th.getMessage());
        String simpleName = th.getClass().getSimpleName();
        q qVar = this.c;
        t.a(simpleName, str, qVar != null ? qVar.a : null, qVar != null ? qVar.d() : null);
    }

    public abstract AdSessionConfiguration c();

    public void a(boolean z) {
        AdSession adSession = this.a;
        if (adSession != null) {
            try {
                adSession.finish();
            } catch (Throwable th) {
                a(th);
            }
            m.f1343b.postDelayed(new b(), z ? 0 : 1000);
            this.a = null;
            this.f951b = null;
        }
    }

    public void a(WebView webView) {
        AdSessionContext adSessionContextCreateHtmlAdSessionContext;
        WebView webView2;
        try {
            AdSessionConfiguration adSessionConfigurationC = c();
            try {
                adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(this.e, webView, "", "");
            } catch (Throwable th) {
                a(th);
                adSessionContextCreateHtmlAdSessionContext = null;
            }
            AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationC, adSessionContextCreateHtmlAdSessionContext);
            this.a = adSessionCreateAdSession;
            AdSessionStatePublisher adSessionStatePublisher = adSessionCreateAdSession.getAdSessionStatePublisher();
            if (adSessionStatePublisher != null && (webView2 = adSessionStatePublisher.getWebView()) != null && webView2 != webView) {
                webView2.setWebViewClient(this.g);
            }
            this.a.registerAdView(webView);
            this.a.start();
        } catch (Throwable th2) {
            a(th2);
        }
    }
}
