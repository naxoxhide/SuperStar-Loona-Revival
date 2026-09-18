package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.d;
import com.applovin.impl.mediation.i;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class MaxFullscreenAdImpl extends com.applovin.impl.mediation.ads.a implements com.applovin.impl.sdk.b.a, f.a {
    private final Object amW;
    private final a ank;
    private final com.applovin.impl.mediation.b anl;
    private com.applovin.impl.mediation.b.c anm;
    private c ann;
    private final AtomicBoolean ano;
    private final AtomicBoolean anp;
    private boolean anq;
    private boolean anr;
    private WeakReference<Activity> ans;
    private WeakReference<ViewGroup> ant;
    private WeakReference<Lifecycle> anu;
    protected final b listenerWrapper;

    public interface a {
        Activity getActivity();
    }

    public enum c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, a aVar, String str2, n nVar) {
        super(str, maxAdFormat, str2, nVar);
        this.amW = new Object();
        this.anm = null;
        this.ann = c.IDLE;
        this.ano = new AtomicBoolean();
        this.anp = new AtomicBoolean();
        this.ans = new WeakReference<>(null);
        this.ant = new WeakReference<>(null);
        this.anu = new WeakReference<>(null);
        this.ank = aVar;
        this.listenerWrapper = new b();
        this.anl = new com.applovin.impl.mediation.b(nVar);
        nVar.Ct().a(this);
        x.D(str2, "Created new " + str2 + " (" + this + ")");
    }

    public boolean isReady() {
        boolean z;
        synchronized (this.amW) {
            com.applovin.impl.mediation.b.c cVar = this.anm;
            z = cVar != null && cVar.isReady() && this.ann == c.READY;
        }
        if (!z) {
            this.sdk.Cd().cK(this.adUnitId);
        }
        return z;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        a(c.DESTROYED, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$bvRLw5z6SYGl33mSJrTZkAhvUNw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.uw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uw() {
        synchronized (this.amW) {
            if (this.anm != null) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Destroying ad for '" + this.adUnitId + "'; current ad: " + this.anm + "...");
                }
                this.sdk.Cw().destroyAd(this.anm);
            }
        }
        this.sdk.Ct().b(this);
        this.anl.tS();
        super.destroy();
    }

    public void loadAd(Activity activity) {
        loadAd(activity, d.a.PUBLISHER_INITIATED);
    }

    public void loadAd(final Activity activity, final d.a aVar) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Loading ad for '" + this.adUnitId + "'...");
        }
        if (this.ann == c.DESTROYED && (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKD)).booleanValue() || u.b(n.getApplicationContext(), this.sdk))) {
            throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
        }
        if (isReady()) {
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "An ad is already loaded for '" + this.adUnitId + "'");
            }
            x xVar3 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "MaxAdListener.onAdLoaded(ad=" + this.anm + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) this.anm, true, true);
            return;
        }
        a(c.LOADING, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$ILu7eGs8qiGwTqqP1JUiW6OAqwQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(activity, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, d.a aVar) {
        Context applicationContext = activity;
        if (activity == null) {
            if (this.sdk.CD() != null) {
                applicationContext = this.sdk.CD();
            } else {
                applicationContext = n.getApplicationContext();
            }
        }
        this.sdk.Cw().loadAd(this.adUnitId, null, this.adFormat, aVar, this.localExtraParameters, this.extraParameters, applicationContext, this.listenerWrapper);
    }

    public void showAd(final String str, final String str2, final Activity activity) {
        List<String> listXj = this.sdk.CC().xj();
        if (this.sdk.CC().xi() && listXj != null && !listXj.contains(this.anm.yz())) {
            final String str3 = "Attempting to show ad from <" + this.anm.yz() + "> which is not in the list of selected ad networks " + listXj;
            x.H(this.tag, str3);
            a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$6QPHzqNN85MLB2uuJt4JXhNgLKc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.bE(str3);
                }
            });
        } else {
            if (activity == null) {
                activity = this.sdk.CD();
            }
            if (a(activity, str)) {
                a(c.SHOWING, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$2VrkeMCKkuWOCEpdBBFqz8Q9wWU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(str, str2, activity);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bE(String str) {
        com.applovin.impl.mediation.b.c cVar = this.anm;
        d(cVar);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + cVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        m.a(this.adListener, (MaxAd) cVar, (MaxError) maxErrorImpl, true, true);
        this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity) {
        s(str, str2);
        this.anq = false;
        this.ans = new WeakReference<>(activity);
        this.sdk.Cw().showFullscreenAd(this.anm, activity, this.listenerWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAd() {
        Activity activityCD = this.ans.get();
        if (activityCD == null) {
            activityCD = this.sdk.CD();
        }
        Activity activity = activityCD;
        if (this.anq) {
            showAd(this.anm.getPlacement(), this.anm.yF(), this.ant.get(), this.anu.get(), activity);
        } else {
            showAd(this.anm.getPlacement(), this.anm.yF(), activity);
        }
    }

    public void showAd(final String str, final String str2, final ViewGroup viewGroup, final Lifecycle lifecycle, Activity activity) {
        if (viewGroup == null || lifecycle == null) {
            x.H(this.tag, "Attempting to show ad with null containerView or lifecycle.");
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, "Attempting to show ad with null containerView or lifecycle.");
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.anm + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) this.anm, (MaxError) maxErrorImpl, true, true);
            this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.anm);
            return;
        }
        if (!viewGroup.isShown() && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJU)).booleanValue()) {
            x.H(this.tag, "Attempting to show ad when containerView and/or its ancestors are not visible");
            MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-1, "Attempting to show ad when containerView and/or its ancestors are not visible");
            m.a(this.adListener, (MaxAd) this.anm, (MaxError) maxErrorImpl2, true, true);
            this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.anm);
            return;
        }
        List<String> listXj = this.sdk.CC().xj();
        if (this.sdk.CC().xi() && listXj != null && !listXj.contains(this.anm.yz())) {
            final String str3 = "Attempting to show ad from <" + this.anm.yz() + "> which is not in the list of selected ad networks " + listXj;
            x.H(this.tag, str3);
            a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$9wD-_y7jo-v5oUXCVeAvEkFFCA4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.bD(str3);
                }
            });
        } else {
            if (activity == null) {
                activity = this.sdk.CD();
            }
            final Activity activity2 = activity;
            if (a(activity2, str)) {
                a(c.SHOWING, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$avE5dukx_z8lcV9XgZC3jbiXZyk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(str, str2, activity2, viewGroup, lifecycle);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bD(String str) {
        com.applovin.impl.mediation.b.c cVar = this.anm;
        d(cVar);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + cVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        m.a(this.adListener, (MaxAd) cVar, (MaxError) maxErrorImpl, true, true);
        this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity, ViewGroup viewGroup, Lifecycle lifecycle) {
        s(str, str2);
        this.anq = true;
        this.ans = new WeakReference<>(activity);
        this.ant = new WeakReference<>(viewGroup);
        this.anu = new WeakReference<>(lifecycle);
        this.sdk.Cw().showFullscreenAd(this.anm, viewGroup, lifecycle, activity, this.listenerWrapper);
    }

    private boolean a(Activity activity, String str) {
        if (activity == null && MaxAdFormat.APP_OPEN != this.adFormat) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        }
        if (this.ann == c.DESTROYED && (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKD)).booleanValue() || u.b(n.getApplicationContext(), this.sdk))) {
            throw new IllegalStateException("Attempting to show ad that is destroyed for ad unit ID: " + this.adUnitId);
        }
        if (!isReady()) {
            String str2 = "Attempting to show ad before it is ready - please check ad readiness using " + this.tag + "#isReady()";
            x.H(this.tag, str2);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, str2);
            i iVar = new i(this.adUnitId, this.adFormat, str);
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + iVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) iVar, (MaxError) maxErrorImpl, true, true);
            if (this.anm != null) {
                this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.anm);
            }
            return false;
        }
        Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJI);
        Long l2 = (Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJC);
        if (l.longValue() > 0 && (this.anm.getTimeToLiveMillis() < l2.longValue() || this.ano.get())) {
            this.anp.set(true);
            this.sdk.BM().a(new ab(this.sdk, "handleShowOnLoadTimeoutError", new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$gnh0zJOgqxsVs9wbk2lb3Q17DhU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.uv();
                }
            }), q.b.BACKGROUND, l.longValue());
            return false;
        }
        if (u.ag(n.getApplicationContext()) != 0 && this.sdk.getSettings().shouldFailAdDisplayIfDontKeepActivitiesIsEnabled()) {
            if (u.b(n.getApplicationContext(), this.sdk)) {
                throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJT)).booleanValue()) {
                x.H(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-5602, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                x xVar2 = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.anm + ", error=" + maxErrorImpl2 + "), listener=" + this.adListener);
                }
                m.a(this.adListener, (MaxAd) this.anm, (MaxError) maxErrorImpl2, true, true);
                this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.anm);
                return false;
            }
        }
        if (this.sdk.Cd().EY() || this.sdk.Cd().EZ()) {
            x.H(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
            MaxErrorImpl maxErrorImpl3 = new MaxErrorImpl(-23, "Attempting to show ad when another fullscreen ad is already showing");
            x xVar3 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.anm + ", error=" + maxErrorImpl3 + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) this.anm, (MaxError) maxErrorImpl3, true, true);
            this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl3, this.anm);
            return false;
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJA)).booleanValue() && !com.applovin.impl.sdk.utils.i.Y(n.getApplicationContext())) {
            x.H(this.tag, "Attempting to show ad with no internet connection");
            MaxErrorImpl maxErrorImpl4 = new MaxErrorImpl(-1009);
            x xVar4 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.anm + ", error=" + maxErrorImpl4 + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) this.anm, (MaxError) maxErrorImpl4, true, true);
            this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl4, this.anm);
            return false;
        }
        String str3 = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.BLOCK_FULLSCREEN_ADS_SHOWING_IF_ACTIVITY_FINISHING);
        if ((!(StringUtils.isValidString(str3) && Boolean.valueOf(str3).booleanValue()) && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJB)).booleanValue()) || activity == null || !activity.isFinishing()) {
            return true;
        }
        x.H(this.tag, "Attempting to show ad when activity is finishing");
        MaxErrorImpl maxErrorImpl5 = new MaxErrorImpl(-5601, "Attempting to show ad when activity is finishing");
        x xVar5 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.anm + ", error=" + maxErrorImpl5 + "), listener=" + this.adListener);
        }
        m.a(this.adListener, (MaxAd) this.anm, (MaxError) maxErrorImpl5, true, true);
        this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl5, this.anm);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uv() {
        if (this.anp.compareAndSet(true, false)) {
            x.H(this.tag, "Failed to show an ad. Failed to load an ad in time to show.");
            this.sdk.Cd().cK(this.adUnitId);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, "Failed to show an ad. Failed to load an ad in time to show.");
            i iVar = new i(this.adUnitId, this.adFormat, this.anm.getPlacement());
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + iVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) iVar, (MaxError) maxErrorImpl, true, true);
            if (this.anm != null) {
                this.sdk.Cw().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.anm);
            }
        }
    }

    private void s(String str, String str2) {
        this.anl.b(this.anm);
        this.anm.setPlacement(str);
        this.anm.setCustomData(str2);
        this.sdk.Cm().V(this.anm);
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Showing ad for '" + this.adUnitId + "'; loaded ad: " + this.anm + "...");
        }
        g(this.anm);
    }

    private void ut() {
        com.applovin.impl.mediation.b.c cVar;
        synchronized (this.amW) {
            cVar = this.anm;
            this.anm = null;
        }
        this.sdk.Cw().destroyAd(cVar);
    }

    @Override // com.applovin.impl.sdk.b.a
    public void onAdExpired(g gVar) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Ad expired " + getAdUnitId());
        }
        this.ano.set(true);
        a aVar = this.ank;
        Activity activity = aVar != null ? aVar.getActivity() : null;
        if (activity == null && (activity = this.sdk.BK().Ax()) == null) {
            uu();
            this.listenerWrapper.onAdLoadFailed(this.adUnitId, MaxAdapterError.MISSING_ACTIVITY);
        } else {
            this.extraParameters.put("expired_ad_ad_unit_id", getAdUnitId());
            this.sdk.Cw().loadAd(this.adUnitId, null, this.adFormat, d.a.EXPIRED, this.localExtraParameters, this.extraParameters, activity, this.listenerWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.applovin.impl.mediation.b.c cVar) {
        if (this.sdk.BZ().a(cVar, this)) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Handle ad loaded for regular ad: " + cVar);
            }
            this.anm = cVar;
            return;
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Loaded an expired ad, running expire logic...");
        }
        onAdExpired(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uu() {
        com.applovin.impl.mediation.b.c cVar;
        if (this.ano.compareAndSet(true, false)) {
            synchronized (this.amW) {
                cVar = this.anm;
                this.anm = null;
            }
            this.sdk.Cw().destroyAd(cVar);
            this.extraParameters.remove("expired_ad_ad_unit_id");
        }
    }

    @Override // com.applovin.impl.sdk.f.a
    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.b.c cVar = this.anm;
        if (cVar == null || !cVar.xz().equalsIgnoreCase(str)) {
            return;
        }
        this.anm.bV(str2);
        m.a(this.adReviewListener, str2, this.anm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, Runnable runnable) {
        boolean z;
        c cVar2 = this.ann;
        synchronized (this.amW) {
            z = true;
            if (cVar2 == c.IDLE) {
                if (cVar != c.LOADING && cVar != c.DESTROYED) {
                    if (cVar == c.SHOWING) {
                        x.H(this.tag, "No ad is loading or loaded");
                    } else {
                        x xVar = this.logger;
                        if (x.Fk()) {
                            this.logger.i(this.tag, "Unable to transition to: " + cVar);
                        }
                    }
                    z = false;
                }
            } else if (cVar2 == c.LOADING) {
                if (cVar != c.IDLE) {
                    if (cVar == c.LOADING) {
                        x.H(this.tag, "An ad is already loading");
                    } else if (cVar != c.READY) {
                        if (cVar == c.SHOWING) {
                            x.H(this.tag, "An ad is not ready to be shown yet");
                        } else if (cVar != c.DESTROYED) {
                            x xVar2 = this.logger;
                            if (x.Fk()) {
                                this.logger.i(this.tag, "Unable to transition to: " + cVar);
                            }
                        }
                    }
                    z = false;
                }
            } else if (cVar2 == c.READY) {
                if (cVar != c.IDLE) {
                    if (cVar == c.LOADING) {
                        x.H(this.tag, "An ad is already loaded");
                    } else if (cVar == c.READY) {
                        x xVar3 = this.logger;
                        if (x.Fk()) {
                            this.logger.i(this.tag, "An ad is already marked as ready");
                        }
                    } else if (cVar != c.SHOWING && cVar != c.DESTROYED) {
                        x xVar4 = this.logger;
                        if (x.Fk()) {
                            this.logger.i(this.tag, "Unable to transition to: " + cVar);
                        }
                    }
                    z = false;
                }
            } else {
                if (cVar2 == c.SHOWING) {
                    if (cVar != c.IDLE) {
                        if (cVar == c.LOADING) {
                            x.H(this.tag, "Can not load another ad while the ad is showing");
                        } else if (cVar == c.READY) {
                            x xVar5 = this.logger;
                            if (x.Fk()) {
                                this.logger.i(this.tag, "An ad is already showing, ignoring");
                            }
                        } else if (cVar == c.SHOWING) {
                            x.H(this.tag, "The ad is already showing, not showing another one");
                        } else if (cVar != c.DESTROYED) {
                            x xVar6 = this.logger;
                            if (x.Fk()) {
                                this.logger.i(this.tag, "Unable to transition to: " + cVar);
                            }
                        }
                    }
                } else if (cVar2 == c.DESTROYED) {
                    x.H(this.tag, "No operations are allowed on a destroyed instance");
                } else {
                    x xVar7 = this.logger;
                    if (x.Fk()) {
                        this.logger.i(this.tag, "Unknown state: " + this.ann);
                    }
                }
                z = false;
            }
            if (z) {
                x xVar8 = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Transitioning from " + this.ann + " to " + cVar + "...");
                }
                this.ann = cVar;
            } else {
                x xVar9 = this.logger;
                if (x.Fk()) {
                    this.logger.h(this.tag, "Not allowed transition from " + this.ann + " to " + cVar);
                }
            }
        }
        if (!z || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MaxAd maxAd) {
        this.sdk.BZ().a((com.applovin.impl.mediation.b.c) maxAd);
        this.anl.tS();
        ut();
        this.sdk.CA().m((com.applovin.impl.mediation.b.a) maxAd);
    }

    public String toString() {
        return this.tag + "{adUnitId='" + this.adUnitId + "', adListener=" + (this.adListener == this.ank ? "this" : this.adListener) + ", revenueListener=" + this.revenueListener + ", requestListener" + this.requestListener + ", adReviewListener" + this.adReviewListener + ", isReady=" + isReady() + '}';
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b implements com.applovin.impl.mediation.ads.a.InterfaceC0117a, MaxAdListener, MaxAdRevenueListener, MaxRewardedAdListener {
        private b() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            com.applovin.impl.mediation.b.c cVar;
            synchronized (MaxFullscreenAdImpl.this.amW) {
                cVar = MaxFullscreenAdImpl.this.anm;
            }
            MaxFullscreenAdImpl.this.sdk.Cd().cM(MaxFullscreenAdImpl.this.adUnitId);
            MaxFullscreenAdImpl.this.i((com.applovin.impl.mediation.b.c) maxAd);
            if (!MaxFullscreenAdImpl.this.ano.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.a(c.READY, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$b$tQ88upDQQ0-wZURotnmAMY048bU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.f(maxAd);
                    }
                });
                return;
            }
            MaxFullscreenAdImpl.this.extraParameters.remove("expired_ad_ad_unit_id");
            if (MaxFullscreenAdImpl.this.anp.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.showAd();
            }
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxAdListener.onExpiredAdReloaded(expiredAd=" + cVar + ", newAd=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.expirationListener);
            }
            m.a(MaxFullscreenAdImpl.this.expirationListener, (MaxAd) cVar, maxAd, true, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(MaxAd maxAd) {
            if (MaxFullscreenAdImpl.this.anr) {
                MaxFullscreenAdImpl.this.showAd();
                return;
            }
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.a(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, final MaxError maxError) {
            MaxFullscreenAdImpl.this.uu();
            MaxFullscreenAdImpl.this.a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$b$wKlTIm9hLVMyAo7Dz2i96Q43NGY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(str, maxError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, MaxError maxError) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.a(MaxFullscreenAdImpl.this.adListener, str, maxError, true, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.anr = false;
            MaxFullscreenAdImpl.this.sdk.BZ().a((com.applovin.impl.mediation.b.c) maxAd);
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.b(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.anr = false;
            MaxFullscreenAdImpl.this.a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$b$vR9xalXn4TcUvAdno61DaN8pAGk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.e(maxAd);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.d(maxAd);
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.c(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.d(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.revenueListener);
            }
            m.a(MaxFullscreenAdImpl.this.revenueListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(final MaxAd maxAd, final MaxError maxError) {
            final boolean z = MaxFullscreenAdImpl.this.anr;
            MaxFullscreenAdImpl.this.anr = false;
            final com.applovin.impl.mediation.b.c cVar = (com.applovin.impl.mediation.b.c) maxAd;
            MaxFullscreenAdImpl.this.a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$b$tB6396vI8doae3DHEgjllNMPE1Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxAd, z, cVar, maxError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd, boolean z, com.applovin.impl.mediation.b.c cVar, MaxError maxError) {
            MaxFullscreenAdImpl.this.d(maxAd);
            if (!z && cVar.yc() && MaxFullscreenAdImpl.this.sdk.CB().bw(MaxFullscreenAdImpl.this.adUnitId)) {
                AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.-$$Lambda$MaxFullscreenAdImpl$b$VjFIAup_Sp2d0MprmREeEu4SuW0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.ux();
                    }
                });
                return;
            }
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxError, true, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void ux() {
            MaxFullscreenAdImpl.this.anr = true;
            MaxFullscreenAdImpl.this.loadAd(MaxFullscreenAdImpl.this.ank != null ? MaxFullscreenAdImpl.this.ank.getActivity() : null);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoStarted(MaxAd maxAd) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxRewardedAdListener.onRewardedVideoStarted(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.e(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoCompleted(MaxAd maxAd) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxRewardedAdListener.onRewardedVideoCompleted(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.f(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxRewardedAdListener.onUserRewarded(ad=" + maxAd + ", reward=" + maxReward + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward, true, true);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fk()) {
                MaxFullscreenAdImpl.this.logger.f(MaxFullscreenAdImpl.this.tag, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxFullscreenAdImpl.this.requestListener);
            }
            m.a(MaxFullscreenAdImpl.this.requestListener, str, true, true);
        }
    }
}
