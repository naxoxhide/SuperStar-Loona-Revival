package com.applovin.impl.mediation.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.d;
import com.applovin.impl.sdk.ac;
import com.applovin.impl.sdk.ad;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.v;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class MaxAdViewImpl extends com.applovin.impl.mediation.ads.a implements ad.a, e.a, f.a {
    private final Context E;
    private boolean agJ;
    private final String ajW;
    private String amL;
    private final MaxAdView amM;
    private final View amN;
    private long amO;
    private com.applovin.impl.mediation.b.b amP;
    private String amQ;
    private final a amR;
    private final c amS;
    private final e amT;
    private final ac amU;
    private final ad amV;
    private final Object amW;
    private com.applovin.impl.mediation.b.b amX;
    private boolean amY;
    private boolean amZ;
    private boolean ana;
    private boolean anb;
    private boolean anc;
    private boolean and;
    private boolean ane;
    private boolean anf;
    private boolean ang;
    private boolean anh;

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, n nVar, Context context) {
        super(str, maxAdFormat, "MaxAdView", nVar);
        this.ajW = UUID.randomUUID().toString().toLowerCase(Locale.US);
        this.amO = Long.MAX_VALUE;
        this.amW = new Object();
        this.amX = null;
        this.agJ = false;
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.E = context.getApplicationContext();
        this.amM = maxAdView;
        this.amN = view;
        this.amR = new a();
        this.amS = new c();
        this.amT = new e(nVar, this);
        this.amU = new ac(maxAdView, nVar);
        this.amV = new ad(maxAdView, nVar, this);
        nVar.Ct().a(this);
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Created new MaxAdView (" + this + ")");
        }
    }

    public void setPlacement(String str) {
        if (this.amX != null) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.h(this.tag, "Setting placement (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
            }
        }
        this.amL = str;
    }

    public String getPlacement() {
        return this.amL;
    }

    public void setCustomData(String str) {
        if (this.amX != null) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.h(this.tag, "Setting custom data (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
            }
        }
        u.N(str, this.tag);
        this.amQ = str;
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public void setPublisherBackgroundColor(int i) {
        this.amO = i;
    }

    public void stopAutoRefresh() {
        if (this.amX != null) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Pausing auto-refresh with remaining time: " + this.amT.AF() + "ms");
            }
            this.amT.AH();
            return;
        }
        if (this.anc || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJt)).booleanValue()) {
            this.amZ = true;
        } else {
            x.F(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
        }
    }

    public void startAutoRefresh() {
        this.amZ = false;
        if (this.amT.AJ()) {
            this.amT.AI();
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Resumed auto-refresh with remaining time: " + this.amT.AF() + "ms");
                return;
            }
            return;
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Ignoring call to startAutoRefresh() - ad refresh is not paused");
        }
    }

    public void loadAd() {
        loadAd(d.a.PUBLISHER_INITIATED);
    }

    public void loadAd(d.a aVar) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "" + this + " Loading ad for " + this.adUnitId + "...");
        }
        boolean z = this.anc || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJt)).booleanValue();
        if (z && !this.amT.AJ() && this.amT.AE()) {
            x.H(this.tag, "Unable to load a new ad. An ad refresh has already been scheduled in " + TimeUnit.MILLISECONDS.toSeconds(this.amT.AF()) + " seconds.");
            return;
        }
        if (z) {
            if (this.amP != null) {
                x xVar2 = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Rendering cached ad");
                }
                up();
                return;
            }
            if (this.anb) {
                x xVar3 = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Waiting for precache ad to load to render");
                }
                this.ana = true;
                return;
            }
            x xVar4 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Loading ad...");
            }
            a(aVar, this.amR);
            return;
        }
        x xVar5 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Loading ad...");
        }
        a(aVar, this.amR);
    }

    private void a(final d.a aVar, final com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        if (ur()) {
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKD)).booleanValue() || u.b(n.getApplicationContext(), this.sdk)) {
                throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
            }
            x.H(this.tag, "Failed to load new ad - this instance is already destroyed");
            return;
        }
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxAdViewImpl$vwaJHM8MLmcKR8yiQXl-ZVNN32w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(interfaceC0117a, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a, d.a aVar) {
        com.applovin.impl.mediation.b.b bVar = this.amX;
        if (bVar != null) {
            long jA = this.amU.a(bVar);
            this.extraParameters.put("visible_ad_ad_unit_id", this.amX.getAdUnitId());
            this.extraParameters.put("viewability_flags", Long.valueOf(jA));
        } else {
            this.extraParameters.remove("visible_ad_ad_unit_id");
            this.extraParameters.remove("viewability_flags");
        }
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.amM.getContext(), this.amM.getWidth());
        int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.amM.getContext(), this.amM.getHeight());
        this.extraParameters.put("viewport_width", Integer.valueOf(iPxToDp));
        this.extraParameters.put("viewport_height", Integer.valueOf(iPxToDp2));
        this.extraParameters.put("auto_refresh_stopped", Boolean.valueOf(this.amT.AJ() || this.amZ));
        this.extraParameters.put("auto_retries_disabled", Boolean.valueOf(this.and));
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Loading " + this.adFormat.getLabel().toLowerCase(Locale.ENGLISH) + " ad for '" + this.adUnitId + "' and notifying " + interfaceC0117a + "...");
        }
        this.sdk.Cw().loadAd(this.adUnitId, this.ajW, this.adFormat, aVar, this.localExtraParameters, this.extraParameters, this.E, interfaceC0117a);
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setExtraParameter(String str, String str2) {
        super.setExtraParameter(str, str2);
        r(str, str2);
    }

    private void r(String str, String str2) {
        if (AppLovinSdkExtraParameterKey.ALLOW_IMMEDIATE_AUTO_REFRESH_PAUSE.equalsIgnoreCase(str)) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Updated allow immediate auto-refresh pause and ad load to: " + str2);
            }
            this.anc = Boolean.parseBoolean(str2);
            return;
        }
        if (AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES.equalsIgnoreCase(str)) {
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Updated disable auto-retries to: " + str2);
            }
            this.and = Boolean.parseBoolean(str2);
            return;
        }
        if (AppLovinSdkExtraParameterKey.DISABLE_PRECACHE.equalsIgnoreCase(str)) {
            x xVar3 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Updated precached disabled to: " + str2);
            }
            this.ane = Boolean.parseBoolean(str2);
            return;
        }
        if (AppLovinSdkExtraParameterKey.DISABLE_AUTO_REFRESH_ON_AD_EXPAND.equals(str)) {
            x xVar4 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Updated should stop auto-refresh on ad expand to: " + str2);
            }
            this.anf = Boolean.parseBoolean(str2);
            return;
        }
        if (AppLovinSdkExtraParameterKey.FORCE_PRECACHE.equals(str)) {
            x xVar5 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Updated force precache to: " + str2);
            }
            this.ang = Boolean.parseBoolean(str2);
            return;
        }
        if (AppLovinSdkExtraParameterKey.IS_ADAPTIVE_BANNER.equalsIgnoreCase(str)) {
            x xVar6 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Updated is adaptive banner to: " + str2);
            }
            this.anh = Boolean.parseBoolean(str2);
            setLocalExtraParameter(str, str2);
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        un();
        if (this.amP != null) {
            this.sdk.Cw().destroyAd(this.amP);
        }
        synchronized (this.amW) {
            this.agJ = true;
        }
        this.amT.AG();
        this.sdk.Ct().b(this);
        this.sdk.CB().o(this.adUnitId, this.ajW);
        super.destroy();
    }

    public void onWindowVisibilityChanged(int i) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJr)).booleanValue() && this.amT.AE()) {
            if (v.gX(i)) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Ad view visible");
                }
                this.amT.AA();
                return;
            }
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Ad view hidden");
            }
            this.amT.Az();
        }
    }

    private void un() {
        com.applovin.impl.mediation.b.b bVar;
        MaxAdView maxAdView = this.amM;
        if (maxAdView != null) {
            com.applovin.impl.sdk.utils.c.a(maxAdView, this.amN);
        }
        this.amV.Fu();
        synchronized (this.amW) {
            bVar = this.amX;
        }
        if (bVar != null) {
            this.sdk.Cw().destroyAd(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.applovin.impl.mediation.b.b bVar) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxAdViewImpl$yA4htRLxMCSyB5D5A66zAGTya3Y
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final com.applovin.impl.mediation.b.b bVar) {
        View adView = bVar.getAdView();
        String str = adView == null ? "MaxAdView does not have a loaded ad view" : null;
        MaxAdView maxAdView = this.amM;
        if (maxAdView == null) {
            str = "MaxAdView does not have a parent view";
        }
        if (str != null) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, str);
            }
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, str);
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + bVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) bVar, (MaxError) maxErrorImpl, true, true);
            this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl, bVar);
            return;
        }
        un();
        g(bVar);
        if (bVar.yv()) {
            this.amV.b(bVar);
        }
        maxAdView.setDescendantFocusability(393216);
        if (bVar.xU() != Long.MAX_VALUE) {
            this.amN.setBackgroundColor((int) bVar.xU());
        } else {
            long j = this.amO;
            if (j != Long.MAX_VALUE) {
                this.amN.setBackgroundColor((int) j);
            } else {
                this.amN.setBackgroundColor(0);
            }
        }
        maxAdView.addView(adView);
        a(adView, bVar);
        this.sdk.Cm().V(bVar);
        b(bVar);
        synchronized (this.amW) {
            this.amX = bVar;
        }
        x xVar3 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Scheduling impression for ad manually...");
        }
        this.sdk.Cw().processRawAdImpressionPostback(bVar, this.amR);
        if (StringUtils.isValidString(this.amX.getAdReviewCreativeId())) {
            m.a(this.adReviewListener, this.amX.getAdReviewCreativeId(), (MaxAd) this.amX, true);
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxAdViewImpl$YpK4dYF-Ffj845MmT5BzCDYqdQg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(bVar);
            }
        }, bVar.xQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(com.applovin.impl.mediation.b.b bVar) {
        long jA = this.amU.a(bVar);
        if (!bVar.yv()) {
            a(bVar, jA);
        }
        bH(jA);
    }

    private void uo() {
        if (uq()) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Scheduling refresh precache request now");
            }
            this.anb = true;
            this.sdk.BM().a(new ab(this.sdk, "loadMaxAdForPrecacheRequest", new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxAdViewImpl$-sCfeAw3CMP53dE2OvNJCe2R2Ns
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.us();
                }
            }), com.applovin.impl.mediation.e.c.f(this.adFormat));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void us() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Loading ad for pre-cache request...");
        }
        a(d.a.SEQUENTIAL_OR_PRECACHE, this.amS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MaxError maxError) {
        if (this.sdk.b(com.applovin.impl.sdk.c.a.aJn).contains(String.valueOf(maxError.getCode()))) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f(this.tag, "Ignoring banner ad refresh for error code " + maxError.getCode());
                return;
            }
            return;
        }
        if (this.amZ || this.amT.AJ()) {
            if (this.anb) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Refresh pre-cache failed when auto-refresh is stopped");
                }
                this.anb = false;
            }
            if (this.ana) {
                x xVar2 = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Refresh pre-cache failed - MaxAdListener.onAdLoadFailed(adUnitId=" + this.adUnitId + ", error=" + maxError + "), listener=" + this.adListener);
                }
                m.a(this.adListener, this.adUnitId, maxError, true, true);
                return;
            }
            return;
        }
        this.amY = true;
        this.anb = false;
        long jLongValue = ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJm)).longValue();
        if (jLongValue >= 0) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f(this.tag, "Scheduling failed banner ad refresh " + jLongValue + " milliseconds from now for '" + this.adUnitId + "'...");
            }
            this.amT.bK(jLongValue);
        }
    }

    private void a(View view, com.applovin.impl.mediation.b.b bVar) {
        int width = bVar.getWidth();
        int height = bVar.getHeight();
        int iDpToPx = width == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), width);
        int iDpToPx2 = height != -1 ? AppLovinSdkUtils.dpToPx(view.getContext(), height) : -1;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx2);
        } else {
            layoutParams.width = iDpToPx;
            layoutParams.height = iDpToPx2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Pinning ad view to MAX ad view with width: " + iDpToPx + " and height: " + iDpToPx2 + ".");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int i : v.m(this.amM.getGravity(), 10, 14)) {
                layoutParams2.addRule(i);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    private void b(com.applovin.impl.mediation.b.b bVar) {
        int height = this.amM.getHeight();
        int width = this.amM.getWidth();
        if (height > 0 || width > 0) {
            int iPxToDp = AppLovinSdkUtils.pxToDp(this.E, height);
            int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.E, width);
            MaxAdFormat format = bVar.getFormat();
            int height2 = (this.anh ? format.getAdaptiveSize(iPxToDp2, this.amM.getContext()) : format.getSize()).getHeight();
            int iMin = Math.min(format.getSize().getWidth(), h.W(this.E).x);
            if (iPxToDp < height2 || iPxToDp2 < iMin) {
                String str = "\n**************************************************\n`MaxAdView` size " + iPxToDp2 + "x" + iPxToDp + " dp smaller than required " + (this.anh ? "adaptive " : "") + "size: " + iMin + "x" + height2 + " dp\nSome mediated networks (e.g. Google Ad Manager) may not render correctly\n**************************************************\n";
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.i("AppLovinSdk", str);
                }
            }
        }
    }

    @Override // com.applovin.impl.sdk.e.a
    public void onAdRefresh() {
        this.ana = false;
        if (this.amP != null) {
            up();
            return;
        }
        if (uq()) {
            if (this.amY) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Refreshing ad from network due to viewability requirements not met for refresh request...");
                }
                loadAd(d.a.REFRESH);
                return;
            }
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            }
            this.ana = true;
            return;
        }
        x xVar3 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Refreshing ad from network...");
        }
        loadAd(d.a.REFRESH);
    }

    private void up() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Rendering for cached ad: " + this.amP + "...");
        }
        this.amR.onAdLoaded(this.amP);
        this.amP = null;
    }

    @Override // com.applovin.impl.sdk.ad.a
    public void onLogVisibilityImpression() {
        a(this.amX, this.amU.a(this.amX));
    }

    private void a(com.applovin.impl.mediation.b.b bVar, long j) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Scheduling viewability impression for ad...");
        }
        this.sdk.Cw().processViewabilityAdImpressionPostback(bVar, j, this.amR);
    }

    private void bH(long j) {
        if (u.E(j, ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJx)).longValue()) && !this.ang) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Undesired flags matched - current: " + Long.toBinaryString(j) + ", undesired: " + Long.toBinaryString(j));
            }
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Waiting for refresh timer to manually fire request");
            }
            this.amY = true;
            return;
        }
        x xVar3 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "No undesired viewability flags matched or forcing pre-cache - scheduling viewability");
        }
        this.amY = false;
        uo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MaxAd maxAd) {
        this.anb = false;
        if (this.ana) {
            this.ana = false;
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            }
            this.amR.onAdLoaded(maxAd);
            return;
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Saving pre-cache ad...");
        }
        com.applovin.impl.mediation.b.b bVar = (com.applovin.impl.mediation.b.b) maxAd;
        this.amP = bVar;
        bVar.setPlacement(this.amL);
        this.amP.setCustomData(this.amQ);
    }

    private boolean uq() {
        if (this.ane) {
            return false;
        }
        return ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJy)).booleanValue();
    }

    private boolean ur() {
        boolean z;
        synchronized (this.amW) {
            z = this.agJ;
        }
        return z;
    }

    @Override // com.applovin.impl.sdk.f.a
    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.b.b bVar = this.amX;
        if (bVar != null && bVar.xz().equalsIgnoreCase(str)) {
            this.amX.bV(str2);
            m.a(this.adReviewListener, str2, this.amX);
            return;
        }
        com.applovin.impl.mediation.b.b bVar2 = this.amP;
        if (bVar2 == null || !bVar2.xz().equalsIgnoreCase(str)) {
            return;
        }
        this.amP.bV(str2);
    }

    private abstract class b implements com.applovin.impl.mediation.ads.a.InterfaceC0117a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener {
        private boolean anj;

        private b() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amX)) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fk()) {
                    MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.b(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amX)) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fk()) {
                    MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.c(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amX)) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fk()) {
                    MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.d(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.amX)) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fk()) {
                    MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.a(MaxAdViewImpl.this.adListener, maxAd, maxError, true, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            x xVar = MaxAdViewImpl.this.logger;
            if (x.Fk()) {
                MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.revenueListener);
            }
            m.a(MaxAdViewImpl.this.revenueListener, maxAd, true, true);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
            x xVar = MaxAdViewImpl.this.logger;
            if (x.Fk()) {
                MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxAdViewImpl.this.requestListener);
            }
            m.a(MaxAdViewImpl.this.requestListener, str, true, true);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amX)) {
                if ((MaxAdViewImpl.this.amX.xT() || MaxAdViewImpl.this.anf) && !MaxAdViewImpl.this.amT.AJ()) {
                    this.anj = true;
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fk()) {
                    MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdViewAdListener.onAdExpanded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.g(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amX)) {
                if ((MaxAdViewImpl.this.amX.xT() || MaxAdViewImpl.this.anf) && this.anj) {
                    this.anj = false;
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fk()) {
                    MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdViewAdListener.onAdCollapsed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.h(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }
    }

    private class a extends b {
        private a() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.agJ) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fk()) {
                    MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "Precache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.Cw().destroyAd(maxAd);
                return;
            }
            com.applovin.impl.mediation.b.b bVar = (com.applovin.impl.mediation.b.b) maxAd;
            bVar.setPlacement(MaxAdViewImpl.this.amL);
            bVar.setCustomData(MaxAdViewImpl.this.amQ);
            if (bVar.getAdView() != null) {
                Boolean bool = (Boolean) MaxAdViewImpl.this.sdk.a(com.applovin.impl.sdk.c.a.aJz);
                if (!bool.booleanValue()) {
                    MaxAdViewImpl.this.a(bVar);
                }
                if (bVar.xR()) {
                    long jXS = bVar.xS();
                    MaxAdViewImpl.this.sdk.BL();
                    if (x.Fk()) {
                        MaxAdViewImpl.this.sdk.BL().f(MaxAdViewImpl.this.tag, "Scheduling banner ad refresh " + jXS + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                    }
                    MaxAdViewImpl.this.amT.bK(jXS);
                    if (MaxAdViewImpl.this.amT.AJ() || MaxAdViewImpl.this.amZ) {
                        x xVar2 = MaxAdViewImpl.this.logger;
                        if (x.Fk()) {
                            MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "Pausing ad refresh for publisher");
                        }
                        MaxAdViewImpl.this.amT.AH();
                    }
                }
                x xVar3 = MaxAdViewImpl.this.logger;
                if (x.Fk()) {
                    MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.a(MaxAdViewImpl.this.adListener, maxAd, true, true);
                if (bool.booleanValue()) {
                    MaxAdViewImpl.this.a(bVar);
                    return;
                }
                return;
            }
            MaxAdViewImpl.this.sdk.Cw().destroyAd(bVar);
            onAdLoadFailed(bVar.getAdUnitId(), new MaxErrorImpl(-5001, "Ad view not fully loaded"));
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            x xVar = MaxAdViewImpl.this.logger;
            if (x.Fk()) {
                MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            m.a(MaxAdViewImpl.this.adListener, str, maxError, true, true);
            MaxAdViewImpl.this.b(maxError);
        }
    }

    private class c extends b {
        private c() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.agJ) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fk()) {
                    MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.Cw().destroyAd(maxAd);
                return;
            }
            x xVar2 = MaxAdViewImpl.this.logger;
            if (x.Fk()) {
                MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "Successfully pre-cached ad for refresh");
            }
            MaxAdViewImpl.this.c(maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            x xVar = MaxAdViewImpl.this.logger;
            if (x.Fk()) {
                MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "Failed to precache ad for refresh with error code: " + maxError.getCode());
            }
            MaxAdViewImpl.this.b(maxError);
        }
    }

    public String toString() {
        return "MaxAdView{adUnitId='" + this.adUnitId + "', adListener=" + (this.adListener == this.amM ? "this" : this.adListener) + ", isDestroyed=" + ur() + '}';
    }
}
