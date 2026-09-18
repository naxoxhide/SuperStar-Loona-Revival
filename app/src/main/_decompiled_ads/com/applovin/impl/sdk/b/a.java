package com.applovin.impl.sdk.b;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.h;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.e.ac;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private AppLovinAd aIJ;
    private SoftReference<AppLovinAdLoadListener> aIK;
    private volatile String aIM;
    protected final AppLovinAdServiceImpl age;
    private String agi;
    protected final n sdk;
    public final Map<String, Object> agg = Collections.synchronizedMap(new HashMap());
    private final Object aIL = new Object();
    private volatile boolean aIN = false;

    public a(String str, AppLovinSdk appLovinSdk) {
        this.sdk = appLovinSdk.a();
        this.age = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.agi = str;
    }

    public void preload(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("IncentivizedAdController", "User requested preload of incentivized ad...");
        }
        this.aIK = new SoftReference<>(appLovinAdLoadListener);
        if (Jq()) {
            x.H("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.aIJ);
                return;
            }
            return;
        }
        b(new C0136a(appLovinAdLoadListener));
    }

    public boolean Jq() {
        return this.aIJ != null;
    }

    public void a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = Jt();
        }
        a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void show(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        a(appLovinAd, viewGroup, lifecycle, context, appLovinAdRewardListener == null ? Jt() : appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    private void Jr() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference<AppLovinAdLoadListener> softReference = this.aIK;
        if (softReference == null || (appLovinAdLoadListener = softReference.get()) == null) {
            return;
        }
        appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
    }

    private void b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.age.loadNextIncentivizedAd(this.agi, appLovinAdLoadListener);
    }

    private void a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.aIJ;
        }
        AppLovinAdImpl appLovinAdImpl2 = appLovinAdImpl;
        if (appLovinAdImpl2 != null) {
            a(appLovinAdImpl2, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        } else {
            x.H("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            Jr();
        }
    }

    private void a(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.aIJ;
        }
        if (appLovinAdImpl != null) {
            a(appLovinAdImpl, viewGroup, lifecycle, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        } else {
            x.H("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            Jr();
        }
    }

    private void a(e eVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.sdk.BM().a(new ac(eVar, appLovinAdRewardListener, this.sdk), q.b.REWARD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Js() {
        String str;
        synchronized (this.aIL) {
            str = this.aIM;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(String str) {
        synchronized (this.aIL) {
            this.aIM = str;
        }
    }

    public String getZoneId() {
        return this.agi;
    }

    public void setExtraInfo(String str, Object obj) {
        this.agg.put(str, obj);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        b bVar = new b(appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        AppLovinAd appLovinAdA = u.a((AppLovinAd) appLovinAdImpl, this.sdk);
        String strA = a(appLovinAdA, appLovinAdImpl);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAdImpl, strA, bVar, bVar);
            return;
        }
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create(this.sdk.getWrappingSdk(), context);
        for (String str : this.agg.keySet()) {
            appLovinInterstitialAdDialogCreate.setExtraInfo(str, this.agg.get(str));
        }
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(bVar);
        appLovinInterstitialAdDialogCreate.setAdVideoPlaybackListener(bVar);
        appLovinInterstitialAdDialogCreate.setAdClickListener(bVar);
        appLovinInterstitialAdDialogCreate.showAndRender(appLovinAdA);
        a((e) appLovinAdA, bVar);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        b bVar = new b(appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        AppLovinAd appLovinAdA = u.a((AppLovinAd) appLovinAdImpl, this.sdk);
        String strA = a(appLovinAdA, appLovinAdImpl);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAdImpl, strA, bVar, bVar);
            return;
        }
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create(this.sdk.getWrappingSdk(), context);
        for (String str : this.agg.keySet()) {
            appLovinInterstitialAdDialogCreate.setExtraInfo(str, this.agg.get(str));
        }
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(bVar);
        appLovinInterstitialAdDialogCreate.setAdVideoPlaybackListener(bVar);
        appLovinInterstitialAdDialogCreate.setAdClickListener(bVar);
        appLovinInterstitialAdDialogCreate.showAndRender(appLovinAdA, viewGroup, lifecycle);
        a((e) appLovinAdA, bVar);
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2) {
        if (appLovinAd == null) {
            x.H("IncentivizedAdController", "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.: " + appLovinAd2);
            return "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.";
        }
        if (appLovinAd2.getType() == AppLovinAdType.INCENTIVIZED || appLovinAd2.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            return null;
        }
        x.H("IncentivizedAdController", "Attempting to display ad with invalid ad type: " + appLovinAd2.getType());
        return "Attempting to display ad with invalid ad type";
    }

    private void a(AppLovinAd appLovinAd, String str, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, h hVar) {
        this.sdk.BP().a(f.aSY);
        m.a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        m.a(hVar, str);
    }

    private class b implements h, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {
        private final AppLovinAd aIQ;
        private final AppLovinAdDisplayListener aIR;
        private final AppLovinAdClickListener aIS;
        private final AppLovinAdVideoPlaybackListener aIT;
        private final AppLovinAdRewardListener aIU;

        private b(AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.aIQ = appLovinAd;
            this.aIR = appLovinAdDisplayListener;
            this.aIS = appLovinAdClickListener;
            this.aIT = appLovinAdVideoPlaybackListener;
            this.aIU = appLovinAdRewardListener;
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            m.a(this.aIR, appLovinAd);
        }

        @Override // com.applovin.impl.sdk.ad.h
        public void onAdDisplayFailed(String str) {
            AppLovinAd appLovinAdHz = this.aIQ;
            if (appLovinAdHz instanceof com.applovin.impl.sdk.ad.f) {
                appLovinAdHz = ((com.applovin.impl.sdk.ad.f) appLovinAdHz).Hz();
            }
            boolean z = this.aIR instanceof h;
            if (appLovinAdHz instanceof e) {
                f((e) appLovinAdHz);
            } else {
                String str2 = appLovinAdHz == null ? "null/expired ad" : "invalid ad of type: " + appLovinAdHz;
                a.this.sdk.BL();
                if (x.Fk()) {
                    a.this.sdk.BL().i("IncentivizedAdController", "Received `" + (z ? "adDisplayFailed" : "adHidden") + "` callback for " + str2);
                }
            }
            a.this.f(appLovinAdHz);
            if (z) {
                m.a(this.aIR, str);
            } else {
                m.b(this.aIR, this.aIQ);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            AppLovinAd appLovinAdHz = appLovinAd instanceof com.applovin.impl.sdk.ad.f ? ((com.applovin.impl.sdk.ad.f) appLovinAd).Hz() : appLovinAd;
            if (appLovinAdHz instanceof e) {
                f((e) appLovinAdHz);
            } else {
                String str = appLovinAdHz == null ? "null/expired ad" : "invalid ad of type: " + appLovinAdHz;
                a.this.sdk.BL();
                if (x.Fk()) {
                    a.this.sdk.BL().i("IncentivizedAdController", "Received `adHidden` callback for " + str);
                }
            }
            a.this.f(appLovinAdHz);
            a.this.sdk.BL();
            if (x.Fk()) {
                a.this.sdk.BL().f("IncentivizedAdController", "Notifying listener of rewarded ad dismissal");
            }
            m.b(this.aIR, appLovinAd);
        }

        private void f(e eVar) {
            int i;
            String str;
            a.this.sdk.BL();
            if (x.Fk()) {
                a.this.sdk.BL().f("IncentivizedAdController", "Finishing direct ad...");
            }
            String strJs = a.this.Js();
            if (!StringUtils.isValidString(strJs) || !a.this.aIN) {
                a.this.sdk.BL();
                if (x.Fk()) {
                    a.this.sdk.BL().i("IncentivizedAdController", "Invalid reward state - result: " + strJs + " and wasFullyEngaged: " + a.this.aIN);
                }
                a.this.sdk.BL();
                if (x.Fk()) {
                    a.this.sdk.BL().f("IncentivizedAdController", "Cancelling any incoming reward requests for this ad");
                }
                eVar.yf();
                if (a.this.aIN) {
                    a.this.sdk.BL();
                    if (x.Fk()) {
                        a.this.sdk.BL().i("IncentivizedAdController", "User close the ad after fully watching but reward validation task did not return on time");
                    }
                    i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                    str = "network_timeout";
                } else {
                    a.this.sdk.BL();
                    if (x.Fk()) {
                        a.this.sdk.BL().i("IncentivizedAdController", "User close the ad prematurely");
                    }
                    i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                    str = "user_closed_video";
                }
                eVar.a(c.dr(str));
                a.this.sdk.BL();
                if (x.Fk()) {
                    a.this.sdk.BL().f("IncentivizedAdController", "Notifying listener of reward validation failure");
                }
                m.a(this.aIU, eVar, i);
            }
            if (eVar.GU().getAndSet(true)) {
                return;
            }
            a.this.sdk.BL();
            if (x.Fk()) {
                a.this.sdk.BL().f("IncentivizedAdController", "Scheduling report rewarded ad...");
            }
            a.this.sdk.BM().a(new com.applovin.impl.sdk.e.x(eVar, a.this.sdk), q.b.REWARD);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            m.a(this.aIS, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            m.a(this.aIT, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            m.a(this.aIT, appLovinAd, d, z);
            a.this.aIN = z;
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.dq("accepted");
            m.a(this.aIU, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.dq("quota_exceeded");
            m.b(this.aIU, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.dq("rejected");
            m.c(this.aIU, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            a.this.dq("network_timeout");
            m.a(this.aIU, appLovinAd, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.aIJ;
        if (appLovinAd2 == null) {
            return;
        }
        if (!(appLovinAd2 instanceof com.applovin.impl.sdk.ad.f)) {
            if (appLovinAd == appLovinAd2) {
                this.aIJ = null;
            }
        } else {
            com.applovin.impl.sdk.ad.f fVar = (com.applovin.impl.sdk.ad.f) appLovinAd2;
            if (fVar.Hz() == null || appLovinAd == fVar.Hz()) {
                this.aIJ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: com.applovin.impl.sdk.b.a$a, reason: collision with other inner class name */
    class C0136a implements AppLovinAdLoadListener {
        private final AppLovinAdLoadListener aIP;

        C0136a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.aIP = appLovinAdLoadListener;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(final AppLovinAd appLovinAd) {
            a.this.aIJ = appLovinAd;
            if (this.aIP != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.-$$Lambda$a$a$_4fbzMnn4O_6sldnUOeIBHqO6Yg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$adReceived$0$a$a(appLovinAd);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$adReceived$0$a$a(AppLovinAd appLovinAd) {
            try {
                this.aIP.adReceived(appLovinAd);
            } catch (Throwable th) {
                x.e("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                a.this.sdk.Cq().d("IncentivizedAdController", "adLoaded", th);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(final int i) {
            if (this.aIP != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.-$$Lambda$a$a$qZCuoqflz-yPm3CQOlcKsvcybk4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.gL(i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void gL(int i) {
            try {
                this.aIP.failedToReceiveAd(i);
            } catch (Throwable th) {
                x.e("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                a.this.sdk.Cq().d("IncentivizedAdController", "adLoadFailed", th);
            }
        }
    }

    private AppLovinAdRewardListener Jt() {
        return new AppLovinAdRewardListener() { // from class: com.applovin.impl.sdk.b.a.1
            @Override // com.applovin.sdk.AppLovinAdRewardListener
            public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
                a.this.sdk.BL();
                if (x.Fk()) {
                    a.this.sdk.BL().f("IncentivizedAdController", "Reward validated: " + map);
                }
            }

            @Override // com.applovin.sdk.AppLovinAdRewardListener
            public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
                a.this.sdk.BL();
                if (x.Fk()) {
                    a.this.sdk.BL().i("IncentivizedAdController", "User over quota: " + map);
                }
            }

            @Override // com.applovin.sdk.AppLovinAdRewardListener
            public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
                a.this.sdk.BL();
                if (x.Fk()) {
                    a.this.sdk.BL().i("IncentivizedAdController", "Reward rejected: " + map);
                }
            }

            @Override // com.applovin.sdk.AppLovinAdRewardListener
            public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                a.this.sdk.BL();
                if (x.Fk()) {
                    a.this.sdk.BL().i("IncentivizedAdController", "Reward validation failed: " + i);
                }
            }
        };
    }
}
