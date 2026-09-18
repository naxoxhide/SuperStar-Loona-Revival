package com.applovin.mediation.nativeAds.adPlacer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.b.d;
import com.applovin.impl.mediation.nativeAds.a.a;
import com.applovin.impl.mediation.nativeAds.a.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdPlacer implements b.a {
    private AppLovinSdkUtils.Size aYO;
    private MaxNativeAdViewBinder aYP;
    private final a aYQ;
    private final b aYR;
    private Listener aYS;
    protected final x logger;
    protected final n sdk;

    public interface Listener {
        void onAdClicked(MaxAd maxAd);

        void onAdLoaded(int i);

        void onAdRemoved(int i);

        void onAdRevenuePaid(MaxAd maxAd);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, Context context) {
        this(maxAdPlacerSettings, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, AppLovinSdk appLovinSdk, Context context) {
        this.aYO = AppLovinSdkUtils.Size.ZERO;
        n nVarA = appLovinSdk.a();
        this.sdk = nVarA;
        x xVarBL = nVarA.BL();
        this.logger = xVarBL;
        this.aYQ = new a(maxAdPlacerSettings);
        this.aYR = new b(maxAdPlacerSettings, context, this);
        if (x.Fk()) {
            xVarBL.f("MaxAdPlacer", "Initializing ad placer with settings: " + maxAdPlacerSettings);
        }
    }

    public void destroy() {
        if (x.Fk()) {
            this.logger.f("MaxAdPlacer", "Destroying ad placer");
        }
        clearAds();
        this.aYR.destroy();
    }

    public void setAdSize(int i, int i2) {
        this.aYO = new AppLovinSdkUtils.Size(i, i2);
    }

    public void setNativeAdViewBinder(MaxNativeAdViewBinder maxNativeAdViewBinder) {
        this.aYP = maxNativeAdViewBinder;
    }

    public void setListener(Listener listener) {
        this.aYS = listener;
    }

    public void loadAds() {
        if (x.Fk()) {
            this.logger.f("MaxAdPlacer", "Loading ads");
        }
        this.aYR.loadAds();
    }

    public void clearAds() {
        a(this.aYQ.yL(), new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.-$$Lambda$MaxAdPlacer$oHBNcLjdw_dq68Mz2pCVUP-v_eo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.MM();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void MM() {
        if (x.Fk()) {
            this.logger.f("MaxAdPlacer", "Clearing all cached ads");
        }
        this.aYQ.clearAds();
        this.aYR.clearAds();
    }

    public Collection<Integer> clearTrailingAds(final int i) {
        final Collection<Integer> collectionGr = this.aYQ.gr(i);
        if (!collectionGr.isEmpty()) {
            a(collectionGr, new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.-$$Lambda$MaxAdPlacer$x85Q4U2dYAHBS4Mo3X_ozB0eC_Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(i, collectionGr);
                }
            });
        }
        return collectionGr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, Collection collection) {
        if (x.Fk()) {
            this.logger.f("MaxAdPlacer", "Clearing trailing ads after position " + i);
        }
        this.aYQ.g(collection);
    }

    public boolean isAdPosition(int i) {
        return this.aYQ.isAdPosition(i);
    }

    public boolean isFilledPosition(int i) {
        return this.aYQ.isFilledPosition(i);
    }

    public long getAdItemId(int i) {
        if (isFilledPosition(i)) {
            return -System.identityHashCode(this.aYQ.gq(i));
        }
        return 0L;
    }

    public AppLovinSdkUtils.Size getAdSize(int i, int i2) {
        if (isFilledPosition(i)) {
            boolean z = this.aYO != AppLovinSdkUtils.Size.ZERO;
            int iMin = Math.min(z ? this.aYO.getWidth() : 360, i2);
            d dVar = (d) this.aYQ.gq(i);
            if ("small_template_1".equalsIgnoreCase(dVar.ym())) {
                return new AppLovinSdkUtils.Size(iMin, z ? this.aYO.getHeight() : 120);
            }
            if (MaxNativeAdView.MEDIUM_TEMPLATE_1.equalsIgnoreCase(dVar.ym())) {
                return new AppLovinSdkUtils.Size(iMin, (int) (((double) iMin) / (z ? ((double) this.aYO.getWidth()) / ((double) this.aYO.getHeight()) : 1.2d)));
            }
            if (z) {
                return this.aYO;
            }
            if (dVar.yk() != null) {
                View mainView = dVar.yk().getMainView();
                return new AppLovinSdkUtils.Size(mainView.getMeasuredWidth(), mainView.getMeasuredHeight());
            }
        }
        return AppLovinSdkUtils.Size.ZERO;
    }

    public void renderAd(int i, ViewGroup viewGroup) {
        MaxAd maxAdGq = this.aYQ.gq(i);
        if (maxAdGq == null) {
            if (x.Fk()) {
                this.logger.f("MaxAdPlacer", "An ad is not available for position: " + i);
                return;
            }
            return;
        }
        MaxNativeAdView maxNativeAdViewYk = ((d) maxAdGq).yk();
        if (maxNativeAdViewYk != null) {
            if (x.Fk()) {
                this.logger.f("MaxAdPlacer", "Using pre-rendered ad at position: " + i);
            }
        } else if (this.aYP != null) {
            maxNativeAdViewYk = new MaxNativeAdView(this.aYP, viewGroup.getContext());
            if (this.aYR.render(maxNativeAdViewYk, maxAdGq)) {
                if (x.Fk()) {
                    this.logger.f("MaxAdPlacer", "Rendered ad at position: " + i);
                }
            } else if (x.Fk()) {
                this.logger.i("MaxAdPlacer", "Unable to render ad at position: " + i);
            }
        } else {
            if (x.Fk()) {
                this.logger.i("MaxAdPlacer", "Unable to render ad at position: " + i + ". If you're using a custom ad template, check that nativeAdViewBinder is set.");
                return;
            }
            return;
        }
        for (int childCount = viewGroup.getChildCount(); childCount >= 0; childCount--) {
            if (viewGroup.getChildAt(childCount) instanceof MaxNativeAdView) {
                viewGroup.removeViewAt(childCount);
            }
        }
        if (maxNativeAdViewYk.getParent() != null) {
            ((ViewGroup) maxNativeAdViewYk.getParent()).removeView(maxNativeAdViewYk);
        }
        viewGroup.addView(maxNativeAdViewYk, -1, -1);
    }

    public void updateFillablePositions(int i, int i2) {
        this.aYQ.Q(i, i2);
        if (i == -1 || i2 == -1) {
            return;
        }
        ML();
    }

    public int getAdjustedCount(int i) {
        return this.aYQ.getAdjustedCount(i);
    }

    public int getAdjustedPosition(int i) {
        return this.aYQ.getAdjustedPosition(i);
    }

    public int getOriginalPosition(int i) {
        return this.aYQ.getOriginalPosition(i);
    }

    public void insertItem(int i) {
        if (x.Fk()) {
            this.logger.f("MaxAdPlacer", "Inserting item at position: " + i);
        }
        this.aYQ.insertItem(i);
    }

    public void removeItem(final int i) {
        List listEmptyList;
        if (isFilledPosition(i)) {
            listEmptyList = Collections.singletonList(Integer.valueOf(i));
        } else {
            listEmptyList = Collections.emptyList();
        }
        a(listEmptyList, new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.-$$Lambda$MaxAdPlacer$T4ljJlTNdJ1HbSqXJ8CgZukEdIU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.gZ(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gZ(int i) {
        if (x.Fk()) {
            this.logger.f("MaxAdPlacer", "Removing item at position: " + i);
        }
        this.aYQ.removeItem(i);
    }

    public void moveItem(int i, int i2) {
        this.aYQ.moveItem(i, i2);
    }

    private void ML() {
        int iYK;
        while (this.aYR.yM() && (iYK = this.aYQ.yK()) != -1) {
            if (x.Fk()) {
                this.logger.f("MaxAdPlacer", "Placing ad at position: " + iYK);
            }
            this.aYQ.a(this.aYR.yN(), iYK);
            Listener listener = this.aYS;
            if (listener != null) {
                listener.onAdLoaded(iYK);
            }
        }
    }

    private void a(Collection<Integer> collection, Runnable runnable) {
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            this.aYR.destroyAd(this.aYQ.gq(it.next().intValue()));
        }
        runnable.run();
        if (collection.isEmpty()) {
            return;
        }
        if (x.Fk()) {
            this.logger.f("MaxAdPlacer", "Removed " + collection.size() + " ads from stream: " + collection);
        }
        if (this.aYS != null) {
            Iterator<Integer> it2 = collection.iterator();
            while (it2.hasNext()) {
                this.aYS.onAdRemoved(it2.next().intValue());
            }
        }
    }

    @Override // com.applovin.impl.mediation.nativeAds.a.b.a
    public void onNativeAdLoaded() {
        if (x.Fk()) {
            this.logger.f("MaxAdPlacer", "Native ad enqueued");
        }
        ML();
    }

    @Override // com.applovin.impl.mediation.nativeAds.a.b.a
    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        if (x.Fk()) {
            this.logger.i("MaxAdPlacer", "Native ad failed to load: " + maxError);
        }
    }

    @Override // com.applovin.impl.mediation.nativeAds.a.b.a
    public void onNativeAdClicked(MaxAd maxAd) {
        Listener listener = this.aYS;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    @Override // com.applovin.impl.mediation.nativeAds.a.b.a
    public void onAdRevenuePaid(MaxAd maxAd) {
        Listener listener = this.aYS;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }
}
