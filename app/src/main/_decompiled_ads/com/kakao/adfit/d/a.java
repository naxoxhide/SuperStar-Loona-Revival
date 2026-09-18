package com.kakao.adfit.d;

import android.content.Context;
import android.os.Looper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.ads.R;
import com.kakao.adfit.ads.media.NativeAdVideoPlayPolicy;
import com.kakao.adfit.ads.na.AdFitAdInfoIconPosition;
import com.kakao.adfit.ads.na.AdFitNativeAdBinder;
import com.kakao.adfit.ads.na.AdFitNativeAdLayout;
import com.kakao.adfit.ads.na.AdFitNativeAdRequest;
import com.kakao.adfit.ads.na.AdFitNativeAdTemplateLayout;
import com.kakao.adfit.ads.na.AdFitVideoAutoPlayPolicy;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdFitNativeAdBinderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\n\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u00107R,\u00109\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u00109\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\n\u0010:\"\u0004\b\n\u0010;¨\u0006B"}, d2 = {"Lcom/kakao/adfit/d/a;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "layout", "", "bind", "Lcom/kakao/adfit/ads/na/AdFitNativeAdTemplateLayout;", "unbind", "Lcom/kakao/adfit/d/r$e;", "callback", "a", "(Lcom/kakao/adfit/d/r$e;)V", "", "Ljava/lang/String;", "adUnitId", "Lcom/kakao/adfit/d/p;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/p;", "nativeAd", "Lcom/kakao/adfit/a/n;", "c", "Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "()Ljava/lang/String;", "name", "Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder$OnAdClickListener;", "e", "Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder$OnAdClickListener;", "getOnAdClickListener", "()Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder$OnAdClickListener;", "setOnAdClickListener", "(Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder$OnAdClickListener;)V", "onAdClickListener", "Lcom/kakao/adfit/a/c;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/a/c;", "event", "Lcom/kakao/adfit/d/r;", "g", "Lcom/kakao/adfit/d/r;", "imageLoader", "Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;", "h", "Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;", "videoPlayPolicy", "", "i", "I", "adInfoIconGravity", "Lcom/kakao/adfit/d/b;", "j", "Lcom/kakao/adfit/d/b;", "binding", "", "()Z", "isBound", "binder", "(Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;)Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder;", "(Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder;)V", "Landroid/content/Context;", "context", "Lcom/kakao/adfit/ads/na/AdFitNativeAdRequest;", "request", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/kakao/adfit/ads/na/AdFitNativeAdRequest;Lcom/kakao/adfit/d/p;Lcom/kakao/adfit/a/n;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class a extends AdFitNativeAdBinder {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String adUnitId;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final p nativeAd;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final com.kakao.adfit.a.n options;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private AdFitNativeAdBinder.OnAdClickListener onAdClickListener;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final com.kakao.adfit.a.c event;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final r imageLoader;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final NativeAdVideoPlayPolicy videoPlayPolicy;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final int adInfoIconGravity;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private b binding;

    /* JADX INFO: renamed from: com.kakao.adfit.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdFitNativeAdBinderImpl.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class C0450a {
        public static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1732b;

        static {
            int[] iArr = new int[AdFitVideoAutoPlayPolicy.values().length];
            iArr[AdFitVideoAutoPlayPolicy.NONE.ordinal()] = 1;
            iArr[AdFitVideoAutoPlayPolicy.WIFI_ONLY.ordinal()] = 2;
            iArr[AdFitVideoAutoPlayPolicy.ALWAYS.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[AdFitAdInfoIconPosition.values().length];
            iArr2[AdFitAdInfoIconPosition.LEFT_TOP.ordinal()] = 1;
            iArr2[AdFitAdInfoIconPosition.LEFT_BOTTOM.ordinal()] = 2;
            iArr2[AdFitAdInfoIconPosition.RIGHT_TOP.ordinal()] = 3;
            iArr2[AdFitAdInfoIconPosition.RIGHT_BOTTOM.ordinal()] = 4;
            f1732b = iArr2;
        }
    }

    public a(Context context, String adUnitId, AdFitNativeAdRequest request, p nativeAd, com.kakao.adfit.a.n nVar) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        this.adUnitId = adUnitId;
        this.nativeAd = nativeAd;
        this.options = nVar;
        String str = "AdFitNativeAdBinder(\"" + adUnitId + "\")@" + hashCode();
        this.name = str;
        this.event = new com.kakao.adfit.a.c(context, nativeAd, null, 4, null);
        this.imageLoader = new r(context, nativeAd);
        NativeAdVideoPlayPolicy nativeAdVideoPlayPolicy = new NativeAdVideoPlayPolicy();
        int i2 = C0450a.a[request.getVideoAutoPlayPolicy().ordinal()];
        if (i2 == 1) {
            nativeAdVideoPlayPolicy.setWifiAutoPlayEnabled(false);
            nativeAdVideoPlayPolicy.setAutoPlayEnabled(false);
        } else if (i2 == 2) {
            nativeAdVideoPlayPolicy.setWifiAutoPlayEnabled(true);
            nativeAdVideoPlayPolicy.setAutoPlayEnabled(false);
        } else if (i2 == 3) {
            nativeAdVideoPlayPolicy.setWifiAutoPlayEnabled(true);
            nativeAdVideoPlayPolicy.setAutoPlayEnabled(true);
        }
        this.videoPlayPolicy = nativeAdVideoPlayPolicy;
        int i3 = C0450a.f1732b[request.getAdInfoIconPosition().ordinal()];
        if (i3 == 1) {
            i = 51;
        } else if (i3 == 2) {
            i = 83;
        } else if (i3 == 3) {
            i = 53;
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            i = 85;
        }
        this.adInfoIconGravity = i;
        com.kakao.adfit.k.f.a(str + " is created.");
    }

    private final boolean b() {
        return this.binding != null;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdBinder
    public void bind(AdFitNativeAdLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new RuntimeException("Must be called from the main thread.");
        }
        if (b()) {
            b bVar = this.binding;
            if (Intrinsics.areEqual(bVar != null ? bVar.getLayout() : null, layout) && Intrinsics.areEqual(a(layout), this)) {
                com.kakao.adfit.k.f.d(this.name + " is already bound. [layout = " + layout.getName() + ']');
                return;
            }
        }
        unbind();
        AdFitNativeAdBinder adFitNativeAdBinderA = a(layout);
        if (adFitNativeAdBinderA != null) {
            adFitNativeAdBinderA.unbind();
        }
        a(layout, this);
        layout.setAdUnitId$library_networkRelease(this.adUnitId);
        this.binding = new b(this, layout, this.nativeAd, this.options, this.event, this.imageLoader, this.videoPlayPolicy, this.adInfoIconGravity);
        com.kakao.adfit.k.f.a(this.name + " is bound. [layout = " + layout.getName() + ']');
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdBinder
    public AdFitNativeAdBinder.OnAdClickListener getOnAdClickListener() {
        return this.onAdClickListener;
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdBinder
    public void setOnAdClickListener(AdFitNativeAdBinder.OnAdClickListener onAdClickListener) {
        this.onAdClickListener = onAdClickListener;
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdBinder
    public void unbind() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new RuntimeException("Must be called from the main thread.");
        }
        b bVar = this.binding;
        if (bVar == null) {
            return;
        }
        this.binding = null;
        a(bVar.getLayout(), null);
        bVar.c();
        com.kakao.adfit.k.f.a(this.name + " is unbound. [layout = " + bVar.getLayout().getName() + ']');
    }

    public final void a(r.e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.imageLoader.a(callback);
    }

    private final AdFitNativeAdBinder a(AdFitNativeAdLayout adFitNativeAdLayout) {
        Object tag = adFitNativeAdLayout.getContainerView().getTag(R.id.adfit_binder);
        if (tag instanceof AdFitNativeAdBinder) {
            return (AdFitNativeAdBinder) tag;
        }
        return null;
    }

    private final void a(AdFitNativeAdLayout adFitNativeAdLayout, AdFitNativeAdBinder adFitNativeAdBinder) {
        adFitNativeAdLayout.getContainerView().setTag(R.id.adfit_binder, adFitNativeAdBinder);
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdBinder
    public void bind(AdFitNativeAdTemplateLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        bind(layout.getNativeAdLayout());
    }
}
