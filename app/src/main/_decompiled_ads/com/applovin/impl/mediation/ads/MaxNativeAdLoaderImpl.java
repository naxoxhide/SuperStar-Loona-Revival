package com.applovin.impl.mediation.ads;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.d;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class MaxNativeAdLoaderImpl extends com.applovin.impl.mediation.ads.a implements com.applovin.impl.sdk.b.a, f.a {
    public static final String KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE = "ad_request_type";
    private String amL;
    private String amQ;
    private final Object amW;
    private final a anC;
    private d.a anD;
    private MaxNativeAdListener anE;
    private final Map<String, MaxNativeAdView> anF;
    private final Set<com.applovin.impl.mediation.b.d> anG;

    public MaxNativeAdLoaderImpl(String str, n nVar) {
        super(str, MaxAdFormat.NATIVE, "MaxNativeAdLoader", nVar);
        this.anC = new a();
        this.anD = d.a.PUBLISHER_INITIATED;
        this.amW = new Object();
        this.anF = new HashMap();
        this.anG = new HashSet();
        nVar.Ct().a(this);
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Created new MaxNativeAdLoader (" + this + ")");
        }
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Loading native ad for '" + this.adUnitId + "' into '" + maxNativeAdView + "' and notifying " + this.anC + "...");
        }
        this.extraParameters.put("integration_type", maxNativeAdView != null ? "custom_ad_view" : "no_ad_view");
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        a(lowerCase, maxNativeAdView);
        this.sdk.Cw().loadAd(this.adUnitId, lowerCase, MaxAdFormat.NATIVE, this.anD, this.localExtraParameters, this.extraParameters, n.getApplicationContext(), this.anC);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (!(maxAd instanceof com.applovin.impl.mediation.b.d)) {
            x.H(this.tag, "Failed to render native ad. `ad` needs to be of type `MediatedNativeAd` to render.");
            return false;
        }
        if (maxNativeAdView == null) {
            x.H(this.tag, "Failed to render native ad. `adView` to render cannot be null.");
            return false;
        }
        com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) maxAd;
        MaxNativeAd nativeAd = dVar.getNativeAd();
        if (nativeAd == null) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, "Failed to render native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
            }
            return false;
        }
        if (nativeAd.isExpired() && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJF)).booleanValue()) {
            x.H(this.tag, "Cancelled rendering for expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            return false;
        }
        a(maxNativeAdView, dVar, nativeAd);
        b(maxNativeAdView);
        return true;
    }

    public void registerClickableViews(final List<View> list, final ViewGroup viewGroup, MaxAd maxAd) {
        com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) maxAd;
        final MaxNativeAd nativeAd = dVar.getNativeAd();
        if (nativeAd == null) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, "Failed to register native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        dVar.c(viewGroup);
        this.sdk.Cm().V(dVar);
        g(dVar);
        nativeAd.setClickableViews(list);
        nativeAd.setAdViewTracker(new b(dVar, viewGroup, this.anC, this.sdk));
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (nativeAd.prepareForInteraction(list, viewGroup)) {
                    return;
                }
                x.H(MaxNativeAdLoaderImpl.this.tag, "Failed to prepare native ad for interaction...");
            }
        };
        if (nativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(runnable);
        } else {
            this.sdk.BM().a(new ab(this.sdk, "renderMaxNativeAd", runnable), q.b.MEDIATION_MAIN);
        }
    }

    public void handleNativeAdViewRendered(MaxAd maxAd) {
        MaxNativeAd nativeAd = ((com.applovin.impl.mediation.b.d) maxAd).getNativeAd();
        if (nativeAd == null) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, "Failed to handle native ad rendered. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        b adViewTracker = nativeAd.getAdViewTracker();
        if (adViewTracker == null) {
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, "Failed to handle native ad rendered. Could not retrieve tracker. Ad might not have been registered via MaxNativeAdLoader.a(...).");
                return;
            }
            return;
        }
        adViewTracker.uy();
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Setting native ad listener: " + maxNativeAdListener);
        }
        this.anE = maxNativeAdListener;
    }

    public void setPlacement(String str) {
        this.amL = str;
    }

    public String getPlacement() {
        return this.amL;
    }

    public void setCustomData(String str) {
        u.N(str, this.tag);
        this.amQ = str;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        this.anE = null;
        this.sdk.Ct().b(this);
        synchronized (this.amW) {
            this.anF.clear();
            this.anG.clear();
        }
        super.destroy();
    }

    public void destroy(MaxAd maxAd) {
        b adViewTracker;
        if (maxAd instanceof com.applovin.impl.mediation.b.d) {
            com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) maxAd;
            if (dVar.ur()) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Native ad (" + dVar + ") has already been destroyed");
                    return;
                }
                return;
            }
            synchronized (this.amW) {
                this.anG.remove(dVar);
            }
            MaxNativeAdView maxNativeAdViewYk = dVar.yk();
            if (maxNativeAdViewYk != null && (adViewTracker = maxNativeAdViewYk.getAdViewTracker()) != null && maxAd.equals(adViewTracker.uz())) {
                maxNativeAdViewYk.recycle();
            }
            MaxNativeAd nativeAd = dVar.getNativeAd();
            if (nativeAd != null && nativeAd.getAdViewTracker() != null) {
                nativeAd.getAdViewTracker().destroy();
            }
            this.sdk.BZ().a(dVar);
            this.sdk.Cw().destroyAd(dVar);
            this.sdk.CB().o(this.adUnitId, dVar.getLoadTag());
            return;
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Destroy failed on non-native ad(" + maxAd + ")");
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setLocalExtraParameter(String str, Object obj) {
        super.setLocalExtraParameter(str, obj);
        if (KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE.equalsIgnoreCase(str) && (obj instanceof d.a)) {
            this.anD = (d.a) obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.d dVar) {
        if (dVar.yn().get()) {
            return;
        }
        this.sdk.BZ().a(dVar, this);
    }

    @Override // com.applovin.impl.sdk.b.a
    public void onAdExpired(g gVar) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Ad expired for ad unit id " + getAdUnitId());
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "MaxNativeAdListener.onNativeAdExpired(nativeAd=" + gVar + "), listener=" + this.anE);
        }
        m.b(this.anE, (MaxAd) gVar, true, true);
    }

    @Override // com.applovin.impl.sdk.f.a
    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.b.d next;
        Iterator<com.applovin.impl.mediation.b.d> it = this.anG.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!next.xz().equalsIgnoreCase(str));
        if (next != null) {
            next.bV(str2);
            m.a(this.adReviewListener, str2, next);
            synchronized (this.amW) {
                this.anG.remove(next);
            }
        }
    }

    private void a(String str, MaxNativeAdView maxNativeAdView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.amW) {
            this.anF.put(str, maxNativeAdView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MaxNativeAdView bF(String str) {
        MaxNativeAdView maxNativeAdViewRemove;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.amW) {
            maxNativeAdViewRemove = this.anF.remove(str);
        }
        return maxNativeAdViewRemove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MaxNativeAdView maxNativeAdView, final com.applovin.impl.mediation.b.d dVar, final MaxNativeAd maxNativeAd) {
        dVar.setNativeAdView(maxNativeAdView);
        g(dVar);
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl.2
            @Override // java.lang.Runnable
            public void run() {
                x xVar = MaxNativeAdLoaderImpl.this.logger;
                if (x.Fk()) {
                    MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "Rendering native ad view: " + maxNativeAdView);
                }
                maxNativeAdView.render(dVar, MaxNativeAdLoaderImpl.this.anC, MaxNativeAdLoaderImpl.this.sdk);
                maxNativeAd.setNativeAdView(maxNativeAdView);
                if (maxNativeAd.prepareForInteraction(maxNativeAdView.getClickableViews(), maxNativeAdView)) {
                    return;
                }
                maxNativeAd.prepareViewForInteraction(maxNativeAdView);
            }
        };
        if (maxNativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(runnable);
        } else {
            this.sdk.BM().a(new ab(this.sdk, "renderMaxNativeAd", runnable), q.b.MEDIATION_MAIN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MaxNativeAdView maxNativeAdView) {
        b adViewTracker = maxNativeAdView.getAdViewTracker();
        if (adViewTracker != null) {
            if (h.KU()) {
                if (maxNativeAdView.isAttachedToWindow()) {
                    adViewTracker.uy();
                }
            } else if (maxNativeAdView.getParent() != null) {
                adViewTracker.uy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class a implements com.applovin.impl.mediation.ads.a.InterfaceC0117a {
        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        private a() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxNativeAdLoaderImpl$a$dGdTkfKGULwND1cRe0bOnKFO7FE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.f(maxAd);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(MaxAd maxAd) {
            x xVar = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fk()) {
                MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "Native ad loaded");
            }
            com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) maxAd;
            dVar.setPlacement(MaxNativeAdLoaderImpl.this.amL);
            dVar.setCustomData(MaxNativeAdLoaderImpl.this.amQ);
            MaxNativeAdLoaderImpl.this.sdk.Cm().V(dVar);
            synchronized (MaxNativeAdLoaderImpl.this.amW) {
                MaxNativeAdLoaderImpl.this.anG.add(dVar);
            }
            MaxNativeAdView maxNativeAdViewBF = MaxNativeAdLoaderImpl.this.bF(dVar.getLoadTag());
            if (maxNativeAdViewBF == null) {
                x xVar2 = MaxNativeAdLoaderImpl.this.logger;
                if (x.Fk()) {
                    MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "No custom view provided, checking template");
                }
                String strYm = dVar.ym();
                if (StringUtils.isValidString(strYm)) {
                    x xVar3 = MaxNativeAdLoaderImpl.this.logger;
                    if (x.Fk()) {
                        MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "Using template: " + strYm + "...");
                    }
                    maxNativeAdViewBF = new MaxNativeAdView(strYm, n.getApplicationContext());
                }
            }
            if (maxNativeAdViewBF == null) {
                x xVar4 = MaxNativeAdLoaderImpl.this.logger;
                if (x.Fk()) {
                    MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "No native ad view to render. Returning the native ad to be rendered later.");
                }
                x xVar5 = MaxNativeAdLoaderImpl.this.logger;
                if (x.Fk()) {
                    MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=null, nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.anE);
                }
                m.a(MaxNativeAdLoaderImpl.this.anE, (MaxNativeAdView) null, maxAd, true, true);
                MaxNativeAdLoaderImpl.this.a(dVar);
                return;
            }
            c(maxNativeAdViewBF);
            MaxNativeAdLoaderImpl.this.a(maxNativeAdViewBF, dVar, dVar.getNativeAd());
            x xVar6 = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fk()) {
                MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=" + maxNativeAdViewBF + ", nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.anE);
            }
            m.a(MaxNativeAdLoaderImpl.this.anE, maxNativeAdViewBF, maxAd, true, true);
            MaxNativeAdLoaderImpl.this.a(dVar);
            MaxNativeAdLoaderImpl.this.b(maxNativeAdViewBF);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxNativeAdLoaderImpl.this.bF(((MaxErrorImpl) maxError).getLoadTag());
            x xVar = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fk()) {
                MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "MaxNativeAdListener.onNativeAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxNativeAdLoaderImpl.this.anE);
            }
            m.a(MaxNativeAdLoaderImpl.this.anE, str, maxError, true, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            x xVar = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fk()) {
                MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "MaxNativeAdListener.onNativeAdClicked(nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.anE);
            }
            m.a(MaxNativeAdLoaderImpl.this.anE, maxAd, true, true);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            x xVar = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fk()) {
                MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.revenueListener);
            }
            m.a(MaxNativeAdLoaderImpl.this.revenueListener, maxAd, true, true);
        }

        private void c(MaxNativeAdView maxNativeAdView) {
            com.applovin.impl.mediation.b.d dVarUz;
            b adViewTracker = maxNativeAdView.getAdViewTracker();
            if (adViewTracker == null || (dVarUz = adViewTracker.uz()) == null) {
                return;
            }
            x xVar = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fk()) {
                MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "Destroying previous ad");
            }
            MaxNativeAdLoaderImpl.this.destroy(dVarUz);
        }
    }

    public String toString() {
        return "MaxNativeAdLoader{adUnitId='" + this.adUnitId + "', nativeAdListener=" + this.anE + ", revenueListener=" + this.revenueListener + '}';
    }
}
