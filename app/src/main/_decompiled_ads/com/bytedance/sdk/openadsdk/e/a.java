package com.bytedance.sdk.openadsdk.e;

import android.content.Context;
import android.text.TextUtils;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.factory.IADLoader;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ADNFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements IADTypeLoaderFactory {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ADNFactory.java */
    class C0229a implements IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener> {
        private int a;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.e.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ADNFactory.java */
        class C0230a extends g {
            final /* synthetic */ com.bytedance.sdk.openadsdk.a.e.a c;
            final /* synthetic */ AdSlot d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0230a(String str, com.bytedance.sdk.openadsdk.a.e.a aVar, AdSlot adSlot) {
                super(str);
                this.c = aVar;
                this.d = adSlot;
            }

            @Override // java.lang.Runnable
            public void run() {
                Method methodA;
                try {
                    if (com.bytedance.sdk.openadsdk.a.a.a(this.c) || (methodA = x.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, PAGAppOpenAdLoadListener.class, Integer.TYPE)) == null) {
                        return;
                    }
                    methodA.invoke(null, o.a(), this.d, this.c, Integer.valueOf(C0229a.this.a));
                } catch (Throwable th) {
                    m.b("ADNFactory", "open component maybe not exist, please check", th);
                }
            }
        }

        C0229a(a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void loadAd(String str, PAGAppOpenRequest pAGAppOpenRequest, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
            if (com.bytedance.sdk.openadsdk.a.a.a(str, pAGAppOpenRequest, pAGAppOpenAdLoadListener)) {
                return;
            }
            if (!o.d().f() && a0.x()) {
                if (pAGAppOpenAdLoadListener != null) {
                    pAGAppOpenAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                    return;
                }
                return;
            }
            AdSlot.Builder builder = new AdSlot.Builder();
            com.bytedance.sdk.openadsdk.a.a.a(builder, pAGAppOpenRequest);
            if (!TextUtils.isEmpty(pAGAppOpenRequest.getAdString())) {
                builder.withBid(pAGAppOpenRequest.getAdString());
            }
            AdSlot adSlotBuild = builder.setCodeId(str).setRequestExtraMap(pAGAppOpenRequest.getExtraInfo()).build();
            if (pAGAppOpenRequest != null) {
                this.a = pAGAppOpenRequest.getTimeout();
            }
            com.bytedance.sdk.openadsdk.a.e.a aVar = new com.bytedance.sdk.openadsdk.a.e.a(pAGAppOpenAdLoadListener);
            com.bytedance.sdk.openadsdk.a.a.a(new C0230a("loadSplashAd", aVar, adSlotBuild), aVar, adSlotBuild);
        }
    }

    /* JADX INFO: compiled from: ADNFactory.java */
    class b implements IADLoader<PAGBannerRequest, PAGBannerAdLoadListener> {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.e.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ADNFactory.java */
        class C0231a extends g {
            final /* synthetic */ com.bytedance.sdk.openadsdk.a.b.a c;
            final /* synthetic */ AdSlot d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0231a(b bVar, String str, com.bytedance.sdk.openadsdk.a.b.a aVar, AdSlot adSlot) {
                super(str);
                this.c = aVar;
                this.d = adSlot;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.a.a.a(this.c)) {
                    return;
                }
                this.d.setNativeAdType(1);
                this.d.setDurationSlotType(1);
                com.bytedance.sdk.openadsdk.core.nativeexpress.e.a(o.a()).a(this.d, 1, this.c, 5000);
            }
        }

        b(a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void loadAd(String str, PAGBannerRequest pAGBannerRequest, PAGBannerAdLoadListener pAGBannerAdLoadListener) {
            if (com.bytedance.sdk.openadsdk.a.a.a(str, pAGBannerRequest, pAGBannerAdLoadListener)) {
                return;
            }
            if (!o.d().f() && a0.x()) {
                if (pAGBannerAdLoadListener != null) {
                    pAGBannerAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                    return;
                }
                return;
            }
            AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
            com.bytedance.sdk.openadsdk.a.a.a(codeId, pAGBannerRequest);
            if (!TextUtils.isEmpty(pAGBannerRequest.getAdString())) {
                codeId.withBid(pAGBannerRequest.getAdString());
            }
            PAGBannerSize adSize = pAGBannerRequest != null ? pAGBannerRequest.getAdSize() : null;
            if (adSize != null) {
                codeId.setExpressViewAcceptedSize(adSize.getWidth(), adSize.getHeight());
            }
            AdSlot adSlotBuild = codeId.setRequestExtraMap(pAGBannerRequest.getExtraInfo()).build();
            com.bytedance.sdk.openadsdk.a.b.a aVar = new com.bytedance.sdk.openadsdk.a.b.a(pAGBannerAdLoadListener);
            com.bytedance.sdk.openadsdk.a.a.a(new C0231a(this, "loadBannerExpressAd", aVar, adSlotBuild), aVar, adSlotBuild);
        }
    }

    /* JADX INFO: compiled from: ADNFactory.java */
    class c implements IADLoader<PAGNativeRequest, PAGNativeAdLoadListener> {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.e.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ADNFactory.java */
        class C0232a extends g {
            final /* synthetic */ com.bytedance.sdk.openadsdk.a.c.e c;
            final /* synthetic */ AdSlot d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0232a(c cVar, String str, com.bytedance.sdk.openadsdk.a.c.e eVar, AdSlot adSlot) {
                super(str);
                this.c = eVar;
                this.d = adSlot;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.a.a.a(this.c)) {
                    return;
                }
                try {
                    Method methodA = x.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, PAGNativeAdLoadListener.class);
                    if (methodA != null) {
                        methodA.invoke(null, o.a(), this.d, this.c);
                    }
                } catch (Throwable th) {
                    m.c("ADNFactory", "feed component maybe not exist, pls check1", th);
                }
            }
        }

        c(a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void loadAd(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
            if (com.bytedance.sdk.openadsdk.a.a.a(str, pAGNativeRequest, pAGNativeAdLoadListener)) {
                return;
            }
            if (!o.d().f() && a0.x()) {
                if (pAGNativeAdLoadListener != null) {
                    pAGNativeAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                }
            } else {
                com.bytedance.sdk.openadsdk.a.c.e eVar = new com.bytedance.sdk.openadsdk.a.c.e(pAGNativeAdLoadListener);
                AdSlot.Builder builderWithBid = new AdSlot.Builder().setCodeId(str).withBid(pAGNativeRequest != null ? pAGNativeRequest.getAdString() : null);
                com.bytedance.sdk.openadsdk.a.a.a(builderWithBid, pAGNativeRequest);
                AdSlot adSlotBuild = builderWithBid.setRequestExtraMap(pAGNativeRequest.getExtraInfo()).build();
                com.bytedance.sdk.openadsdk.a.a.a(new C0232a(this, "loadFeedAd", eVar, adSlotBuild), eVar, adSlotBuild);
            }
        }
    }

    /* JADX INFO: compiled from: ADNFactory.java */
    class d implements IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener> {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.e.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ADNFactory.java */
        class C0233a extends g {
            final /* synthetic */ com.bytedance.sdk.openadsdk.a.f.b c;
            final /* synthetic */ AdSlot d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0233a(d dVar, String str, com.bytedance.sdk.openadsdk.a.f.b bVar, AdSlot adSlot) {
                super(str);
                this.c = bVar;
                this.d = adSlot;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.a.a.a(this.c)) {
                    return;
                }
                try {
                    Method methodA = x.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, PAGRewardedAdLoadListener.class);
                    if (methodA != null) {
                        methodA.invoke(null, o.a(), this.d, this.c);
                    }
                } catch (Throwable th) {
                    m.c("ADNFactory", "reward component maybe not exist, pls check1", th);
                }
            }
        }

        d(a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void loadAd(String str, PAGRewardedRequest pAGRewardedRequest, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
            if (com.bytedance.sdk.openadsdk.a.a.a(str, pAGRewardedRequest, pAGRewardedAdLoadListener)) {
                return;
            }
            if (!o.d().f() && a0.x()) {
                if (pAGRewardedAdLoadListener != null) {
                    pAGRewardedAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                }
            } else {
                if (!com.bytedance.sdk.openadsdk.utils.m.a(com.bytedance.sdk.openadsdk.utils.m.a, "load_reward_ad")) {
                    if (pAGRewardedAdLoadListener != null) {
                        pAGRewardedAdLoadListener.onError(-17, "Insufficient running memory");
                        return;
                    }
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                if (!TextUtils.isEmpty(pAGRewardedRequest.getAdString())) {
                    codeId.withBid(pAGRewardedRequest.getAdString());
                }
                com.bytedance.sdk.openadsdk.a.a.a(codeId, pAGRewardedRequest);
                AdSlot adSlotBuild = codeId.setRequestExtraMap(pAGRewardedRequest.getExtraInfo()).build();
                com.bytedance.sdk.openadsdk.a.f.b bVar = new com.bytedance.sdk.openadsdk.a.f.b(pAGRewardedAdLoadListener);
                com.bytedance.sdk.openadsdk.a.a.a(new C0233a(this, "loadRewardVideoAd", bVar, adSlotBuild), bVar, adSlotBuild);
            }
        }
    }

    /* JADX INFO: compiled from: ADNFactory.java */
    class e implements IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener> {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.e.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ADNFactory.java */
        class C0234a extends g {
            final /* synthetic */ com.bytedance.sdk.openadsdk.a.d.a c;
            final /* synthetic */ AdSlot d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0234a(e eVar, String str, com.bytedance.sdk.openadsdk.a.d.a aVar, AdSlot adSlot) {
                super(str);
                this.c = aVar;
                this.d = adSlot;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.a.a.a(this.c)) {
                    return;
                }
                try {
                    Method methodA = x.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, PAGInterstitialAdLoadListener.class);
                    if (methodA != null) {
                        methodA.invoke(null, o.a(), this.d, this.c);
                    }
                } catch (Throwable th) {
                    m.c("ADNFactory", "reward component maybe not exist, pls check2", th);
                }
            }
        }

        e(a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void loadAd(String str, PAGInterstitialRequest pAGInterstitialRequest, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
            if (com.bytedance.sdk.openadsdk.a.a.a(str, pAGInterstitialRequest, pAGInterstitialAdLoadListener)) {
                return;
            }
            if (!o.d().f() && a0.x()) {
                if (pAGInterstitialAdLoadListener != null) {
                    pAGInterstitialAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                }
            } else {
                if (!com.bytedance.sdk.openadsdk.utils.m.a(com.bytedance.sdk.openadsdk.utils.m.a, "load_interstitial_ad")) {
                    if (pAGInterstitialAdLoadListener != null) {
                        pAGInterstitialAdLoadListener.onError(-17, "Insufficient running memory");
                        return;
                    }
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setRequestExtraMap(pAGInterstitialRequest.getExtraInfo()).setCodeId(str);
                com.bytedance.sdk.openadsdk.a.a.a(codeId, pAGInterstitialRequest);
                if (!TextUtils.isEmpty(pAGInterstitialRequest.getAdString())) {
                    codeId.withBid(pAGInterstitialRequest.getAdString());
                }
                AdSlot adSlotBuild = codeId.build();
                com.bytedance.sdk.openadsdk.a.d.a aVar = new com.bytedance.sdk.openadsdk.a.d.a(pAGInterstitialAdLoadListener);
                com.bytedance.sdk.openadsdk.a.a.a(new C0234a(this, "loadInterstitialAd", aVar, adSlotBuild), aVar, adSlotBuild);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGBannerRequest, PAGBannerAdLoadListener> createBannerAdLoader() {
        return new b(this);
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener> createInterstitialAdLoader() {
        return new e(this);
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGNativeRequest, PAGNativeAdLoadListener> createNativeAdLoader() {
        return new c(this);
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener> createOpenAdLoader() {
        return new C0229a(this);
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener> createRewardAdLoader() {
        return new d(this);
    }
}
