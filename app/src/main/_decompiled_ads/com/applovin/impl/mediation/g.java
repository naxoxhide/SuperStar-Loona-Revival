package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdViewAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.security.CertificateUtil;
import com.tapjoy.TapjoyConstants;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private String adUnitId;
    private final com.applovin.impl.mediation.b.f amh;
    private final String ami;
    private MaxAdapter amj;
    private com.applovin.impl.mediation.b.a amk;
    private View aml;
    private MaxNativeAd amm;
    private MaxNativeAdView amn;
    private ViewGroup amo;
    private MaxAdapterResponseParameters amq;
    private final boolean amu;
    private final x logger;
    private final String name;
    private final n sdk;
    private final Handler acG = new Handler(Looper.getMainLooper());
    private final a amp = new a();
    private final AtomicBoolean amr = new AtomicBoolean(true);
    private final AtomicBoolean ams = new AtomicBoolean(false);
    private final AtomicBoolean amt = new AtomicBoolean(false);

    g(com.applovin.impl.mediation.b.f fVar, MaxAdapter maxAdapter, boolean z, n nVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        }
        if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.name = fVar.yz();
        this.amj = maxAdapter;
        this.sdk = nVar;
        this.logger = nVar.BL();
        this.amh = fVar;
        this.ami = maxAdapter.getClass().getSimpleName();
        this.amu = z;
    }

    void a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity, final Runnable runnable) {
        b(MobileAdsBridgeBase.initializeMethodName, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$P8ak0ZaNSX0dUWNUh9Eg6l9SdsE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(runnable, maxAdapterInitializationParameters, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable, MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (x.Fk()) {
            this.logger.f("MediationAdapterWrapper", "Initializing " + this.ami + " on thread: " + Thread.currentThread() + " with 'run_on_ui_thread' value: " + this.amh.yB());
        }
        this.amj.initialize(maxAdapterInitializationParameters, activity, new b(this.sdk, this.amh, jElapsedRealtime, runnable));
    }

    void a(String str, com.applovin.impl.mediation.b.a aVar) {
        this.adUnitId = str;
        this.amk = aVar;
    }

    public View ub() {
        return this.aml;
    }

    public MaxNativeAd uc() {
        return this.amm;
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.amn = maxNativeAdView;
    }

    public MaxNativeAdView ud() {
        return this.amn;
    }

    public void b(ViewGroup viewGroup) {
        this.amo = viewGroup;
    }

    public ViewGroup ue() {
        return this.amo;
    }

    public String getName() {
        return this.name;
    }

    public MediationServiceImpl.a uf() {
        return this.amp.amx;
    }

    public void a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final com.applovin.impl.mediation.b.a aVar, final Activity activity, MediationServiceImpl.a aVar2) {
        final Runnable runnable;
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (!this.amr.get()) {
            String str2 = "Mediation adapter '" + this.ami + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.";
            x.H("MediationAdapterWrapper", str2);
            aVar2.onAdLoadFailed(str, new MaxErrorImpl(-1, str2));
            return;
        }
        this.amq = maxAdapterResponseParameters;
        this.amp.a(aVar2);
        final MaxAdFormat maxAdFormatXD = aVar.xE() ? aVar.xD() : aVar.getFormat();
        if (maxAdFormatXD == MaxAdFormat.INTERSTITIAL) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$oeZ8uobTJ7LpF7jR6bGKePDpjHc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.e(maxAdapterResponseParameters, activity);
                }
            };
        } else if (maxAdFormatXD == MaxAdFormat.APP_OPEN) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$4DPKJhVzfDsUy2vr7svtbWGGOk4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d(maxAdapterResponseParameters, activity);
                }
            };
        } else if (maxAdFormatXD == MaxAdFormat.REWARDED) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$j7IIa9ZVXftrV9UoziRDFSI9ANw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c(maxAdapterResponseParameters, activity);
                }
            };
        } else if (maxAdFormatXD == MaxAdFormat.REWARDED_INTERSTITIAL) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$5dQ-Bi6nJMnzUVpTW30XfwDwjqg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(maxAdapterResponseParameters, activity);
                }
            };
        } else if (maxAdFormatXD == MaxAdFormat.NATIVE) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$xT9amkCnvtTYmqNbKsALwjN9034
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxAdapterResponseParameters, activity);
                }
            };
        } else if (maxAdFormatXD.isAdViewAd()) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$4YyhKhDaZ4QVJFkew8ahGfJKbEs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxAdapterResponseParameters, maxAdFormatXD, activity);
                }
            };
        } else {
            throw new IllegalStateException("Failed to load " + aVar + ": " + aVar.getFormat() + " (" + aVar.xD() + ") is not a supported ad format");
        }
        a("load_ad", maxAdFormatXD, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$M9XiKNQXBirYOediqpSbwMeeHXY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(runnable, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxInterstitialAdapter) this.amj).loadInterstitialAd(maxAdapterResponseParameters, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxAppOpenAdapter) this.amj).loadAppOpenAd(maxAdapterResponseParameters, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxRewardedAdapter) this.amj).loadRewardedAd(maxAdapterResponseParameters, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxRewardedInterstitialAdapter) this.amj).loadRewardedInterstitialAd(maxAdapterResponseParameters, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MediationAdapterBase) this.amj).loadNativeAd(maxAdapterResponseParameters, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity) {
        ((MaxAdViewAdapter) this.amj).loadAdViewAd(maxAdapterResponseParameters, maxAdFormat, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable, com.applovin.impl.mediation.b.a aVar) {
        try {
            runnable.run();
        } catch (Throwable th) {
            String str = "Failed to start loading ad for " + this.name + " due to: " + th;
            x.H("MediationAdapterWrapper", str);
            this.amp.a("load_ad", new MaxErrorImpl(-1, str));
            this.sdk.Cq().d("MediationAdapterWrapper", "load_ad:" + this.amh.vt(), th);
            bC("load_ad");
            this.sdk.Cu().a(this.amh.vt(), "load_ad", this.amk);
        }
        if (this.ams.get()) {
            return;
        }
        long jYD = this.amh.yD();
        if (jYD > 0) {
            if (x.Fk()) {
                this.logger.f("MediationAdapterWrapper", "Setting timeout " + jYD + "ms. for " + aVar);
            }
            this.sdk.BM().a(new d(), q.b.MEDIATION_TIMEOUT, jYD);
        } else if (x.Fk()) {
            this.logger.f("MediationAdapterWrapper", "Negative timeout set for " + aVar + ", not scheduling a timeout");
        }
    }

    public void a(final com.applovin.impl.mediation.b.a aVar, final Activity activity) {
        Runnable runnable;
        if (b(aVar, activity)) {
            if (aVar.xE()) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$x03iMSeIigCSWiySfC3azQNadFc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(aVar, activity);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$5SAO1LBTTgBAHGCkmIWfI3SSmus
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.f(activity);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.APP_OPEN) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$MHzSummBDVRQY1OfZz_YwqAwXAQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.e(activity);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$cnLLdwQw3aRSE-N2PopbrZ4ouGs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(activity);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$xotCWhlHL563thi-t5ET41Lojtg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(activity);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a(runnable, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(com.applovin.impl.mediation.b.a aVar, Activity activity) {
        this.sdk.Cx().a((com.applovin.impl.mediation.b.c) aVar, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Activity activity) {
        ((MaxInterstitialAdapter) this.amj).showInterstitialAd(this.amq, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Activity activity) {
        ((MaxAppOpenAdapter) this.amj).showAppOpenAd(this.amq, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Activity activity) {
        ((MaxRewardedAdapter) this.amj).showRewardedAd(this.amq, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Activity activity) {
        ((MaxRewardedInterstitialAdapter) this.amj).showRewardedInterstitialAd(this.amq, activity, this.amp);
    }

    public void a(com.applovin.impl.mediation.b.a aVar, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity) {
        Runnable runnable;
        if (b(aVar, activity)) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$jea-7DE7FiIskWmmvMYM4RPbj04
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(viewGroup, lifecycle, activity);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$Wn2MzEAcSAiuzjP73onqiLFN3K4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(viewGroup, lifecycle, activity);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a(runnable, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxInterstitialAdViewAdapter) this.amj).showInterstitialAd(this.amq, viewGroup, lifecycle, activity, this.amp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxRewardedAdViewAdapter) this.amj).showRewardedAd(this.amq, viewGroup, lifecycle, activity, this.amp);
    }

    private boolean b(com.applovin.impl.mediation.b.a aVar, Activity activity) {
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (aVar.xB() == null) {
            x.H("MediationAdapterWrapper", "Adapter has been garbage collected");
            this.amp.a("ad_show", new MaxErrorImpl(-1, "Adapter has been garbage collected"), (Bundle) null);
            return false;
        }
        if (aVar.xB() != this) {
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        }
        if (activity == null && MaxAdFormat.APP_OPEN != aVar.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        }
        if (!this.amr.get()) {
            String str = "Mediation adapter '" + this.ami + "' is disabled. Showing ads with this adapter is disabled.";
            x.H("MediationAdapterWrapper", str);
            this.amp.a("ad_show", new MaxErrorImpl(-1, str), (Bundle) null);
            return false;
        }
        if (ug()) {
            return true;
        }
        throw new IllegalStateException("Mediation adapter '" + this.ami + "' does not have an ad loaded. Please load an ad first");
    }

    private void a(final Runnable runnable, com.applovin.impl.mediation.b.a aVar) {
        a("show_ad", aVar.getFormat(), new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$lYj4Vernnf6DKtahIfuIcJ15Mfw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            String str = "Failed to start displaying ad for " + this.name + " due to: " + th;
            x.H("MediationAdapterWrapper", str);
            this.amp.a("show_ad", new MaxErrorImpl(-1, str), (Bundle) null);
            this.sdk.Cq().d("MediationAdapterWrapper", "show_ad:" + this.amh.vt(), th);
            bC("show_ad");
            this.sdk.Cu().a(this.amh.vt(), "show_ad", this.amk);
        }
    }

    public boolean isEnabled() {
        return this.amr.get();
    }

    public boolean ug() {
        return this.ams.get() && this.amt.get();
    }

    public String getSdkVersion() {
        MaxAdapter maxAdapter = this.amj;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th) {
            x.e("MediationAdapterWrapper", "Failed to get adapter's SDK version for " + this.name, th);
            this.sdk.Cq().d("MediationAdapterWrapper", "sdk_version:" + this.amh.vt(), th);
            bC("sdk_version");
            this.sdk.Cu().a(this.amh.vt(), "sdk_version", this.amk);
            return null;
        }
    }

    public String getAdapterVersion() {
        MaxAdapter maxAdapter = this.amj;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th) {
            x.e("MediationAdapterWrapper", "Failed to get adapter version for " + this.name, th);
            this.sdk.Cq().d("MediationAdapterWrapper", "adapter_version:" + this.amh.vt(), th);
            bC(TapjoyConstants.TJC_ADAPTER_VERSION);
            this.sdk.Cu().a(this.amh.vt(), TapjoyConstants.TJC_ADAPTER_VERSION, this.amk);
            return null;
        }
    }

    void a(final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, final com.applovin.impl.mediation.b.h hVar, final Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        if (!this.amr.get()) {
            x.H("MediationAdapterWrapper", "Mediation adapter '" + this.ami + "' is disabled. Signal collection ads with this adapter is disabled.");
            maxSignalCollectionListener.onSignalCollectionFailed("The adapter (" + this.ami + ") is disabled");
            return;
        }
        final c cVar = new c(hVar, maxSignalCollectionListener);
        MaxAdapter maxAdapter = this.amj;
        if (maxAdapter instanceof MaxSignalProvider) {
            final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
            b("collect_signal", new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$V4ccbrjSUr8EXv_sgfZWxq9KA94
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxSignalProvider, maxAdapterSignalCollectionParameters, activity, cVar, hVar);
                }
            });
        } else {
            b("The adapter (" + this.ami + ") does not support signal collection", cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxSignalProvider maxSignalProvider, MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, final c cVar, com.applovin.impl.mediation.b.h hVar) {
        try {
            maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters, activity, new MaxSignalCollectionListener() { // from class: com.applovin.impl.mediation.g.1
                @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
                public void onSignalCollected(String str) {
                    g.this.a(str, cVar);
                }

                @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
                public void onSignalCollectionFailed(String str) {
                    g.this.b(str, cVar);
                }
            });
        } catch (Throwable th) {
            String str = "Failed signal collection for " + this.name + " due to: " + th;
            x.H("MediationAdapterWrapper", str);
            b(str, cVar);
            this.sdk.Cq().d("MediationAdapterWrapper", "collect_signal:" + this.amh.vt(), th);
            bC("collect_signal");
            this.sdk.Cu().a(this.amh.vt(), "collect_signal", this.amk);
        }
        if (cVar.amB.get()) {
            return;
        }
        if (hVar.yD() == 0) {
            if (x.Fk()) {
                this.logger.f("MediationAdapterWrapper", "Failing signal collection " + hVar + " since it has 0 timeout");
            }
            b("The adapter (" + this.ami + ") has 0 timeout", cVar);
        } else {
            if (hVar.yD() > 0) {
                if (x.Fk()) {
                    this.logger.f("MediationAdapterWrapper", "Setting timeout " + hVar.yD() + "ms. for " + hVar);
                }
                this.sdk.BM().a(new e(cVar), q.b.MEDIATION_TIMEOUT, hVar.yD());
                return;
            }
            if (x.Fk()) {
                this.logger.f("MediationAdapterWrapper", "Negative timeout set for " + hVar + ", not scheduling a timeout");
            }
        }
    }

    void destroy() {
        if (this.amu) {
            return;
        }
        b("destroy", new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$yPJgZf6ZAm_aFUOCATPpRgx62x4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.uh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh() {
        bC("destroy");
        this.amj.onDestroy();
        this.amj = null;
        this.aml = null;
        this.amm = null;
        this.amn = null;
        this.amo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, c cVar) {
        if (!cVar.amB.compareAndSet(false, true) || cVar.amA == null) {
            return;
        }
        cVar.amA.onSignalCollected(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, c cVar) {
        if (!cVar.amB.compareAndSet(false, true) || cVar.amA == null) {
            return;
        }
        cVar.amA.onSignalCollectionFailed(str);
    }

    private void bC(String str) {
        if (x.Fk()) {
            this.logger.g("MediationAdapterWrapper", "Marking " + this.ami + " as disabled due to: " + str);
        }
        this.amr.set(false);
    }

    private void b(String str, Runnable runnable) {
        a(str, (MaxAdFormat) null, runnable);
    }

    private void a(final String str, MaxAdFormat maxAdFormat, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$kxtVMnRNofoy57UlSq-gSaYdMQc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(str, runnable);
            }
        };
        if (a(str, maxAdFormat)) {
            this.acG.post(runnable2);
        } else {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, Runnable runnable) {
        try {
            if (x.Fk()) {
                this.logger.f("MediationAdapterWrapper", this.ami + ": running " + str + "...");
            }
            runnable.run();
            if (x.Fk()) {
                this.logger.f("MediationAdapterWrapper", this.ami + ": finished " + str + "");
            }
        } catch (Throwable th) {
            x.e("MediationAdapterWrapper", "Failed operation " + str + " for " + this.name, th);
            bC("fail_" + str);
            if (str.equals("destroy")) {
                return;
            }
            this.sdk.Cu().a(this.amh.vt(), str, this.amk);
            this.sdk.Cq().d("MediationAdapterWrapper", "outer:" + str + CertificateUtil.DELIMITER + this.amh.vt(), th);
        }
    }

    private boolean a(String str, MaxAdFormat maxAdFormat) {
        Boolean boolShouldShowAdsOnUiThread;
        MaxAdapter maxAdapter = this.amj;
        if (maxAdapter == null) {
            return this.amh.yB();
        }
        if (MobileAdsBridgeBase.initializeMethodName.equals(str)) {
            Boolean boolShouldInitializeOnUiThread = maxAdapter.shouldInitializeOnUiThread();
            if (boolShouldInitializeOnUiThread != null) {
                return boolShouldInitializeOnUiThread.booleanValue();
            }
        } else if ("collect_signal".equals(str)) {
            Boolean boolShouldCollectSignalsOnUiThread = maxAdapter.shouldCollectSignalsOnUiThread();
            if (boolShouldCollectSignalsOnUiThread != null) {
                return boolShouldCollectSignalsOnUiThread.booleanValue();
            }
        } else if ("load_ad".equals(str) && maxAdFormat != null) {
            Boolean boolShouldLoadAdsOnUiThread = maxAdapter.shouldLoadAdsOnUiThread(maxAdFormat);
            if (boolShouldLoadAdsOnUiThread != null) {
                return boolShouldLoadAdsOnUiThread.booleanValue();
            }
        } else if ("show_ad".equals(str) && maxAdFormat != null && (boolShouldShowAdsOnUiThread = maxAdapter.shouldShowAdsOnUiThread(maxAdFormat)) != null) {
            return boolShouldShowAdsOnUiThread.booleanValue();
        }
        return this.amh.yB();
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.ami + "'}";
    }

    private class d extends com.applovin.impl.sdk.e.d {
        private d() {
            super("TaskTimeoutMediatedAd", g.this.sdk);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.ams.get()) {
                return;
            }
            if (g.this.amk.xC()) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, g.this.ami + " is timing out, considering JS Tag ad loaded: " + g.this.amk);
                }
                c(g.this.amk);
                return;
            }
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, g.this.ami + " is timing out " + g.this.amk + "...");
            }
            c(g.this.amk);
            g.this.amp.a(this.tag, new MaxErrorImpl(-5101, "Adapter timed out"));
        }

        private void c(com.applovin.impl.mediation.b.a aVar) {
            if (aVar != null) {
                this.sdk.Cy().e(aVar);
            }
        }
    }

    private class e extends com.applovin.impl.sdk.e.d {
        private final c amC;

        private e(c cVar) {
            super("TaskTimeoutSignalCollection", g.this.sdk);
            this.amC = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.amC.amB.get()) {
                return;
            }
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, g.this.ami + " is timing out " + this.amC.amz + "...");
            }
            g.this.b("The adapter (" + g.this.ami + ") timed out", this.amC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class a implements MaxAdViewAdapterListener, MaxAppOpenAdapterListener, MaxInterstitialAdapterListener, MaxNativeAdAdapterListener, MaxRewardedAdapterListener, MaxRewardedInterstitialAdapterListener {
        private MediationServiceImpl.a amx;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MediationServiceImpl.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("No listener specified");
            }
            this.amx = aVar;
        }

        private void a(String str, final Bundle bundle) {
            if (g.this.amk.xO().get()) {
                x unused = g.this.logger;
                if (x.Fk()) {
                    g.this.logger.i("MediationAdapterWrapper", g.this.ami + ": blocking ad loaded callback for " + g.this.amk + " since onAdHidden() has been called");
                }
                g.this.sdk.Cf().b(g.this.amk, str);
                return;
            }
            g.this.amt.set(true);
            a(str, this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$hIhoIqdHGwVaxRwH3kCP3DUnux0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.R(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void R(Bundle bundle) {
            if (g.this.ams.compareAndSet(false, true)) {
                this.amx.a(g.this.amk, bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, final MaxError maxError) {
            if (g.this.amk.xO().get()) {
                x unused = g.this.logger;
                if (x.Fk()) {
                    g.this.logger.i("MediationAdapterWrapper", g.this.ami + ": blocking ad load failed callback for " + g.this.amk + " since onAdHidden() has been called");
                }
                g.this.sdk.Cf().b(g.this.amk, str);
                return;
            }
            a(str, this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$KC9ggPEQlTfJdrirD04cNiekdII
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError) {
            if (g.this.ams.compareAndSet(false, true)) {
                this.amx.onAdLoadFailed(g.this.adUnitId, maxError);
            }
        }

        private void b(String str, final Bundle bundle) {
            if (g.this.amk.xO().get()) {
                x unused = g.this.logger;
                if (x.Fk()) {
                    g.this.logger.i("MediationAdapterWrapper", g.this.ami + ": blocking ad displayed callback for " + g.this.amk + " since onAdHidden() has been called");
                }
                g.this.sdk.Cf().b(g.this.amk, str);
                return;
            }
            if (g.this.amk.xN().compareAndSet(false, true)) {
                a(str, this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$5WFSvup2QRt2s_7qfavA4jJdwWc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.Q(bundle);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Q(Bundle bundle) {
            this.amx.b(g.this.amk, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, final MaxError maxError, final Bundle bundle) {
            if (g.this.amk.xO().get()) {
                x unused = g.this.logger;
                if (x.Fk()) {
                    g.this.logger.i("MediationAdapterWrapper", g.this.ami + ": blocking ad display failed callback for " + g.this.amk + " since onAdHidden() has been called");
                }
                g.this.sdk.Cf().b(g.this.amk, str);
                return;
            }
            a(str, this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$BzjG_xg_vkYpmKQrxlSYmuKiXZc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxError, bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError, Bundle bundle) {
            this.amx.a(g.this.amk, maxError, bundle);
        }

        private void c(String str, final Bundle bundle) {
            if (g.this.amk.xO().compareAndSet(false, true)) {
                a(str, this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$s38KKWWirJsSb7Ddn2W-dTJInW0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.P(bundle);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void P(Bundle bundle) {
            this.amx.c(g.this.amk, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": interstitial ad loaded with extra info: " + bundle);
            }
            a("onInterstitialAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": interstitial ad failed to load with error " + maxAdapterError);
            }
            a("onInterstitialAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": interstitial ad displayed with extra info: " + bundle);
            }
            b("onInterstitialAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdClicked() {
            onInterstitialAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdClicked(final Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": interstitial ad clicked with extra info: " + bundle);
            }
            a("onInterstitialAdClicked", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$Zb1-oEXGYhxOb5fPEdi5hd1XQ8s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.O(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void O(Bundle bundle) {
            this.amx.d(g.this.amk, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdHidden() {
            onInterstitialAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": interstitial ad hidden with extra info " + bundle);
            }
            c("onInterstitialAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onInterstitialAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": interstitial ad failed to display with error " + maxAdapterError);
            }
            a("onInterstitialAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded() {
            onRewardedAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded ad loaded with extra info: " + bundle);
            }
            a("onRewardedAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded ad displayed with extra info: " + bundle);
            }
            b("onRewardedAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdClicked() {
            onRewardedAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdClicked(final Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded ad clicked with extra info: " + bundle);
            }
            a("onRewardedAdClicked", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$CTC7uLtYKpCbMDWCiYkCt-2VxJ4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.N(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void N(Bundle bundle) {
            this.amx.d(g.this.amk, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdHidden() {
            onRewardedAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded ad hidden with extra info: " + bundle);
            }
            c("onRewardedAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener, com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onUserRewarded(MaxReward maxReward) {
            onUserRewarded(maxReward, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener, com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onUserRewarded(final MaxReward maxReward, final Bundle bundle) {
            if (g.this.amk instanceof com.applovin.impl.mediation.b.c) {
                final com.applovin.impl.mediation.b.c cVar = (com.applovin.impl.mediation.b.c) g.this.amk;
                if (cVar.yh().compareAndSet(false, true)) {
                    x unused = g.this.logger;
                    if (x.Fk()) {
                        g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": user was rewarded: " + maxReward);
                    }
                    a("onUserRewarded", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$kwn_LWQcCMBQpcVybVEO7acYjKU
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(cVar, maxReward, bundle);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(com.applovin.impl.mediation.b.c cVar, MaxReward maxReward, Bundle bundle) {
            this.amx.a(cVar, maxReward, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdVideoStarted() {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded video started");
            }
            a("onRewardedAdVideoStarted", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$3wwTIsGLZoZvdxPkZfE591ECOo4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.um();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void um() {
            this.amx.onRewardedVideoStarted(g.this.amk);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdVideoCompleted() {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded video completed");
            }
            a("onRewardedAdVideoCompleted", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$uNeGp2K3gG5VFZiYLq2y9cdf4uo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.ul();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void ul() {
            this.amx.onRewardedVideoCompleted(g.this.amk);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onRewardedAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": rewarded ad display failed with error: " + maxAdapterError);
            }
            a("onRewardedAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoaded() {
            onRewardedInterstitialAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoaded(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded interstitial ad loaded with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayed() {
            onRewardedInterstitialAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded interstitial ad displayed with extra info: " + bundle);
            }
            b("onRewardedInterstitialAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onRewardedInterstitialAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": rewarded interstitial ad display failed with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdClicked() {
            onRewardedInterstitialAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdClicked(final Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded interstitial ad clicked with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdClicked", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$L0h8jXpTENN1VRPCaBjSrqUNWDc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.M(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void M(Bundle bundle) {
            this.amx.d(g.this.amk, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdHidden() {
            onRewardedInterstitialAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded interstitial ad hidden with extra info: " + bundle);
            }
            c("onRewardedInterstitialAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdVideoStarted() {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded interstitial started");
            }
            a("onRewardedInterstitialAdVideoStarted", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$_POF6cguYlcFsO8N0IAiaipaJCY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.uk();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void uk() {
            this.amx.onRewardedVideoStarted(g.this.amk);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdVideoCompleted() {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": rewarded interstitial completed");
            }
            a("onRewardedInterstitialAdVideoCompleted", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$NlOFJupp4d5R5eJLrUMYYk-dajs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.uj();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void uj() {
            this.amx.onRewardedVideoCompleted(g.this.amk);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoaded() {
            onAppOpenAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoaded(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": app open ad loaded with extra info: " + bundle);
            }
            a("onAppOpenAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": app open ad failed to load with error: " + maxAdapterError);
            }
            a("onAppOpenAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayed() {
            onAppOpenAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": app open ad displayed with extra info: " + bundle);
            }
            b("onAppOpenAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAppOpenAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": app open ad display failed with error: " + maxAdapterError);
            }
            a("onAppOpenAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdClicked() {
            onAppOpenAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdClicked(final Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": app open ad clicked with extra info: " + bundle);
            }
            a("onAppOpenAdClicked", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$gVWo5MDkmm-4PSvyVJ7Q27ngQdU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.L(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void L(Bundle bundle) {
            this.amx.d(g.this.amk, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdHidden() {
            onAppOpenAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": app open ad hidden with extra info: " + bundle);
            }
            c("onAppOpenAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": adview ad loaded with extra info: " + bundle);
            }
            g.this.aml = view;
            a("onAdViewAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": adview ad ad failed to load with error: " + maxAdapterError);
            }
            a("onAdViewAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed(Bundle bundle) {
            if (g.this.amk.xE()) {
                return;
            }
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": adview ad displayed with extra info: " + bundle);
            }
            b("onAdViewAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdClicked() {
            onAdViewAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdClicked(final Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": adview ad clicked with extra info: " + bundle);
            }
            a("onAdViewAdClicked", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$C81xqHDFN9QmKuvsZ2HULnHkzB4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.K(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void K(Bundle bundle) {
            this.amx.d(g.this.amk, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdHidden() {
            onAdViewAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": adview ad hidden with extra info: " + bundle);
            }
            c("onAdViewAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdExpanded() {
            onAdViewAdExpanded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdExpanded(final Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": adview ad expanded");
            }
            a("onAdViewAdExpanded", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$ITIIWBelM0neLoavMNKyCvnf7Zw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.J(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void J(Bundle bundle) {
            this.amx.e(g.this.amk, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdCollapsed() {
            onAdViewAdCollapsed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdCollapsed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": adview ad collapsed");
            }
            a("onAdViewAdCollapsed", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$9ruG1zXaEXTzH8TGetPXRfs_aMc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.ui();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void ui() {
            this.amx.onAdCollapsed(g.this.amk);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAdViewAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": adview ad failed to display with error: " + maxAdapterError);
            }
            a("onAdViewAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoaded(MaxNativeAd maxNativeAd, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": native ad loaded with extra info: " + bundle);
            }
            g.this.amm = maxNativeAd;
            a("onNativeAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.h("MediationAdapterWrapper", g.this.ami + ": native ad ad failed to load with error: " + maxAdapterError);
            }
            a("onNativeAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdDisplayed(Bundle bundle) {
            if (g.this.amk.xE()) {
                return;
            }
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": native ad displayed with extra info: " + bundle);
            }
            b("onNativeAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdClicked() {
            onNativeAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdClicked(final Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fk()) {
                g.this.logger.g("MediationAdapterWrapper", g.this.ami + ": native ad clicked");
            }
            a("onNativeAdClicked", this.amx, new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$6TBbqhtcm5cG4o4mOpmfX8UwFjo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.I(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void I(Bundle bundle) {
            this.amx.d(g.this.amk, bundle);
        }

        private void a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            g.this.acG.post(new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$a$pV2Bou_46pN5MuG-V7kZ1HVehmE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(runnable, maxAdListener, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Runnable runnable, MaxAdListener maxAdListener, String str) {
            try {
                runnable.run();
            } catch (Throwable th) {
                x.e("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + (maxAdListener != null ? maxAdListener.getClass().getName() : null), th);
                g.this.sdk.Cq().d("MediationAdapterWrapper", str + CertificateUtil.DELIMITER + g.this.amh.vt(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c {
        private final MaxSignalCollectionListener amA;
        private final AtomicBoolean amB = new AtomicBoolean();
        private final com.applovin.impl.mediation.b.h amz;

        c(com.applovin.impl.mediation.b.h hVar, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.amz = hVar;
            this.amA = maxSignalCollectionListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements MaxAdapter.OnCompletionListener {
        private final com.applovin.impl.mediation.b.f amh;
        private final Runnable amy;
        private final n sdk;
        private final long startTimeMillis;

        public b(n nVar, com.applovin.impl.mediation.b.f fVar, long j, Runnable runnable) {
            this.sdk = nVar;
            this.amh = fVar;
            this.startTimeMillis = j;
            this.amy = runnable;
        }

        @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
        public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$g$b$bF0m3F8Kc43iGAf8ICkecIz_wGg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(initializationStatus, str);
                }
            }, this.amh.yE());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAdapter.InitializationStatus initializationStatus, String str) {
            this.sdk.Cv().a(this.amh, SystemClock.elapsedRealtime() - this.startTimeMillis, initializationStatus, str);
            Runnable runnable = this.amy;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
