package com.applovin.impl.mediation.ads;

import android.view.ViewGroup;
import com.applovin.impl.mediation.b.d;
import com.applovin.impl.sdk.ac;
import com.applovin.impl.sdk.ad;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;

/* JADX INFO: loaded from: classes.dex */
public class b implements ad.a {
    private final ac amU;
    private final ad amV;
    private final d anN;
    private final a.InterfaceC0117a anO;
    private final n sdk;

    public b(d dVar, ViewGroup viewGroup, a.InterfaceC0117a interfaceC0117a, n nVar) {
        this.sdk = nVar;
        this.anN = dVar;
        this.anO = interfaceC0117a;
        this.amU = new ac(viewGroup, nVar);
        ad adVar = new ad(viewGroup, nVar, this);
        this.amV = adVar;
        adVar.b(dVar);
        nVar.BL();
        if (x.Fk()) {
            nVar.BL().f("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    public void destroy() {
        this.amV.Fu();
    }

    public void uy() {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.anN.yn().compareAndSet(false, true)) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            if (this.anN.getNativeAd().isExpired()) {
                x.H("MaxNativeAdView", "Attempting to display an expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            } else {
                this.sdk.BZ().a(this.anN);
            }
            this.sdk.Cw().processRawAdImpressionPostback(this.anN, this.anO);
        }
    }

    public d uz() {
        return this.anN;
    }

    @Override // com.applovin.impl.sdk.ad.a
    public void onLogVisibilityImpression() {
        bI(this.amU.a(this.anN));
    }

    private void bI(long j) {
        if (this.anN.yo().compareAndSet(false, true)) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.sdk.Cw().processViewabilityAdImpressionPostback(this.anN, j, this.anO);
        }
    }
}
