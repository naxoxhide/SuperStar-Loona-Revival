package com.kakao.adfit.ads.na;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakao.adfit.k.z;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AdFitNativeAdLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdLoader;", "", "()V", "isLoading", "", "()Z", "loadAd", "request", "Lcom/kakao/adfit/ads/na/AdFitNativeAdRequest;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/kakao/adfit/ads/na/AdFitNativeAdLoader$AdLoadListener;", "AdLoadListener", "Companion", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AdFitNativeAdLoader {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: AdFitNativeAdLoader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdLoader$AdLoadListener;", "", "onAdLoadError", "", "errorCode", "", "onAdLoaded", "binder", "Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder;", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface AdLoadListener {
        void onAdLoadError(int errorCode);

        void onAdLoaded(AdFitNativeAdBinder binder);
    }

    /* JADX INFO: compiled from: AdFitNativeAdLoader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdLoader$Companion;", "", "()V", "create", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLoader;", "context", "Landroid/content/Context;", "adUnitId", "", "library_networkRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AdFitNativeAdLoader create(Context context, String adUnitId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                throw new RuntimeException("Must be called from the main thread.");
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                throw new IllegalStateException("Can't create AdFitNativeAdLoader before onCreate call.");
            }
            if (StringsKt.isBlank(adUnitId)) {
                throw new IllegalArgumentException("Can't create AdFitNativeAdLoader with blank adUnitId.");
            }
            z.a.b(applicationContext);
            return a.INSTANCE.a(context, adUnitId);
        }
    }

    @JvmStatic
    public static final AdFitNativeAdLoader create(Context context, String str) {
        return INSTANCE.create(context, str);
    }

    public abstract boolean isLoading();

    public abstract boolean loadAd(AdFitNativeAdRequest request, AdLoadListener listener);
}
