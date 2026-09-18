package com.fyber.inneractive.sdk.measurement.tracker;

import android.webkit.WebView;
import com.fyber.inneractive.sdk.flow.q;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.Partner;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c {
    public b(Partner partner, WebView webView, q qVar) {
        super(partner, webView, qVar);
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.c
    public void a(WebView webView) {
        super.a(webView);
        StringBuilder sb = new StringBuilder("javascript:FyberMraidVideoTracker.initOmid(\"");
        sb.append(this.e.getName()).append("\",\"").append(this.e.getVersion());
        sb.append("\");");
        webView.loadUrl(sb.toString());
    }

    @Override // com.fyber.inneractive.sdk.measurement.a.InterfaceC0271a
    public void b() {
        WebView webView = this.f;
        if (webView != null) {
            webView.loadUrl("javascript:FyberMraidVideoTracker.adUserInteraction();");
        }
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.c
    public AdSessionConfiguration c() {
        try {
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            ImpressionType impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
            Owner owner = Owner.JAVASCRIPT;
            return AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    @Override // com.fyber.inneractive.sdk.measurement.a.InterfaceC0271a
    public void a() {
        WebView webView;
        if (this.d || this.a == null || (webView = this.f) == null) {
            return;
        }
        this.d = true;
        webView.loadUrl("javascript:FyberMraidVideoTracker.impression();");
    }
}
