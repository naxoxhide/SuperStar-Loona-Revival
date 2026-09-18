package com.applovin.impl.sdk.a;

import android.webkit.WebView;
import com.applovin.impl.sdk.x;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public c(com.applovin.impl.sdk.ad.a aVar) {
        super(aVar);
    }

    @Override // com.applovin.impl.sdk.a.b
    protected AdSessionContext j(WebView webView) {
        AdSessionContext adSessionContextCreateHtmlAdSessionContext;
        try {
            if (this.aIu.getOpenMeasurementVerificationScriptResources().size() > 0) {
                adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createNativeAdSessionContext(this.sdk.Cn().getPartner(), this.sdk.Cn().IR(), this.aIu.getOpenMeasurementVerificationScriptResources(), this.aIu.getOpenMeasurementContentUrl(), this.aIu.getOpenMeasurementCustomReferenceData());
            } else {
                adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(this.sdk.Cn().getPartner(), webView, this.aIu.getOpenMeasurementContentUrl(), this.aIu.getOpenMeasurementCustomReferenceData());
            }
            return adSessionContextCreateHtmlAdSessionContext;
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.c(this.tag, "Failed to create ad session context", th);
            }
            return null;
        }
    }

    @Override // com.applovin.impl.sdk.a.b
    protected AdSessionConfiguration IG() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.LOADED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.c(this.tag, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }
}
