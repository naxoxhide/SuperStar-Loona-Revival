package com.applovin.impl.mediation.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.hybridAds.MaxHybridMRecAdActivity;
import com.applovin.mediation.hybridAds.MaxHybridNativeAdActivity;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private final n sdk;

    public d(n nVar) {
        this.sdk = nVar;
    }

    public void a(com.applovin.impl.mediation.b.c cVar, Activity activity, MaxAdapterListener maxAdapterListener) {
        u.LD();
        if (activity == null) {
            activity = this.sdk.BK().Ax();
        }
        if (cVar.getNativeAd() != null) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("MaxHybridAdService", "Showing fullscreen native ad...");
            }
            this.sdk.BK().a(new b(cVar, this.sdk, maxAdapterListener));
            activity.startActivity(new Intent(activity, (Class<?>) MaxHybridNativeAdActivity.class));
            return;
        }
        if (cVar.getAdView() != null) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("MaxHybridAdService", "Showing fullscreen MREC ad...");
            }
            this.sdk.BK().a(new a(cVar, this.sdk, maxAdapterListener));
            activity.startActivity(new Intent(activity, (Class<?>) MaxHybridMRecAdActivity.class));
            return;
        }
        if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
        } else {
            if (maxAdapterListener instanceof MaxAppOpenAdapterListener) {
                ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
                return;
            }
            throw new IllegalStateException("Failed to display hybrid ad: neither native nor adview ad");
        }
    }

    private static class b extends com.applovin.impl.sdk.utils.a {
        private final MaxAdapterListener auo;
        private final com.applovin.impl.mediation.b.c auq;
        private final n sdk;

        public b(com.applovin.impl.mediation.b.c cVar, n nVar, MaxAdapterListener maxAdapterListener) {
            this.auq = cVar;
            this.sdk = nVar;
            this.auo = maxAdapterListener;
        }

        @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxHybridNativeAdActivity) {
                ((MaxHybridNativeAdActivity) activity).a(this.auq.xF(), this.auq.getNativeAd(), this.sdk, this.auo);
            }
        }

        @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof MaxHybridNativeAdActivity) && !activity.isChangingConfigurations() && this.auq.xO().get()) {
                this.sdk.BK().b(this);
            }
        }
    }

    private static class a extends com.applovin.impl.sdk.utils.a {
        private final MaxAdapterListener auo;
        private final com.applovin.impl.mediation.b.c auq;
        private final n sdk;

        public a(com.applovin.impl.mediation.b.c cVar, n nVar, MaxAdapterListener maxAdapterListener) {
            this.auq = cVar;
            this.sdk = nVar;
            this.auo = maxAdapterListener;
        }

        @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxHybridMRecAdActivity) {
                ((MaxHybridMRecAdActivity) activity).a(this.auq.xF(), this.auq.getAdView(), this.sdk, this.auo);
            }
        }

        @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof MaxHybridMRecAdActivity) && !activity.isChangingConfigurations() && this.auq.xO().get()) {
                this.sdk.BK().b(this);
            }
        }
    }
}
