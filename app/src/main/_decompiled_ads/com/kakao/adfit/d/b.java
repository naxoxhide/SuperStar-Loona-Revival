package com.kakao.adfit.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.ads.R;
import com.kakao.adfit.ads.media.MediaAdView;
import com.kakao.adfit.ads.media.NativeAdVideoPlayPolicy;
import com.kakao.adfit.ads.na.AdFitNativeAdBinder;
import com.kakao.adfit.ads.na.AdFitNativeAdLayout;
import com.kakao.adfit.ads.na.AdFitNativeAdView;
import com.kakao.adfit.k.h0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AdFitNativeAdBinding.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0006\u0010\u001bBI\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010&\u001a\u00020$\u0012\b\u0010*\u001a\u0004\u0018\u00010'\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u00109\u001a\u00020\r¢\u0006\u0004\bK\u0010LJ\u0018\u0010\u0006\u001a\u00060\u0005R\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\u0006\u001a\u00020\t*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010\u0010\u001a\u00020\u000f*\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0006\u001a\u00020\u0011*\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\f\u0010\u0010\u001a\u00020\u0013*\u00020\u0012H\u0002J\f\u0010\u0006\u001a\u00020\u0014*\u00020\u0012H\u0002J\u0018\u0010\u0006\u001a\u00060\u0016R\u00020\u0000*\u00020\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0006\u001a\u00060\u0019R\u00020\u0000*\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0006\u0010\u001b\u001a\u00020\u001aR\u0017\u0010\u001f\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u0006\u0010\u001eR\u0017\u0010#\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\u0010\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R$\u0010?\u001a\u0012\u0012\u0004\u0012\u00020;0:j\b\u0012\u0004\u0012\u00020;`<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R \u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020A0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR \u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010CR\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lcom/kakao/adfit/d/b;", "", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView;", "", "layoutName", "Lcom/kakao/adfit/d/b$a;", "a", "Landroid/widget/TextView;", "text", "Lcom/kakao/adfit/d/v;", "Landroid/widget/ImageView;", "Lcom/kakao/adfit/d/p$c;", "image", "", "defaultResID", "Lcom/kakao/adfit/d/o;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/c;", "Landroid/view/View;", "Lcom/kakao/adfit/d/e;", "Lcom/kakao/adfit/d/d;", "Lcom/kakao/adfit/ads/media/MediaAdView;", "Lcom/kakao/adfit/d/b$b;", "Lcom/kakao/adfit/d/p$k;", "video", "Lcom/kakao/adfit/d/b$c;", "", "c", "Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder;", "()Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder;", "binder", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "()Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "layout", "Lcom/kakao/adfit/d/p;", "Lcom/kakao/adfit/d/p;", "ad", "Lcom/kakao/adfit/a/n;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/kakao/adfit/a/c;", "e", "Lcom/kakao/adfit/a/c;", "event", "Lcom/kakao/adfit/d/r;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/d/r;", "imageLoader", "Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;", "g", "Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;", "videoPlayPolicy", "h", "I", "adInfoIconGravity", "Ljava/util/ArrayList;", "Lcom/kakao/adfit/d/y;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "bindings", "Lkotlin/Function1;", "", "j", "Lkotlin/jvm/functions/Function1;", "handleOpenLandingPage", CampaignEx.JSON_KEY_AD_K, "notifyOnClick", "Lcom/kakao/adfit/k/h0;", "l", "Lcom/kakao/adfit/k/h0;", "viewableTracker", "<init>", "(Lcom/kakao/adfit/ads/na/AdFitNativeAdBinder;Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;Lcom/kakao/adfit/d/p;Lcom/kakao/adfit/a/n;Lcom/kakao/adfit/a/c;Lcom/kakao/adfit/d/r;Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;I)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final AdFitNativeAdBinder binder;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AdFitNativeAdLayout layout;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final p ad;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final com.kakao.adfit.a.n options;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final com.kakao.adfit.a.c event;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final r imageLoader;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final NativeAdVideoPlayPolicy videoPlayPolicy;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final int adInfoIconGravity;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final ArrayList<y> bindings;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Function1<String, Boolean> handleOpenLandingPage;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Function1<View, Unit> notifyOnClick;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final h0 viewableTracker;

    /* JADX INFO: compiled from: AdFitNativeAdBinding.kt */
    @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0014R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\"R\u0016\u0010%\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"¨\u0006*"}, d2 = {"Lcom/kakao/adfit/d/b$a;", "Lcom/kakao/adfit/d/y;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$b;", "", "j", "e", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "g", "", "Ljava/lang/String;", "layoutName", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$a;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$a;", "getDelegate", "()Lcom/kakao/adfit/ads/na/AdFitNativeAdView$a;", "delegate", "Lcom/kakao/adfit/k/g;", "Lcom/kakao/adfit/k/g;", "getViewState", "()Lcom/kakao/adfit/k/g;", "viewState", "Lcom/kakao/adfit/k/h0;", "Lcom/kakao/adfit/k/h0;", "i", "()Lcom/kakao/adfit/k/h0;", "tracker", "Lcom/kakao/adfit/k/k;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/k/k;", "disposer", "", "J", "minExposedTime", "h", "startExposedTime", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView;", "view", "<init>", "(Lcom/kakao/adfit/d/b;Ljava/lang/String;Lcom/kakao/adfit/ads/na/AdFitNativeAdView;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private final class a extends y implements AdFitNativeAdView.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String layoutName;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final AdFitNativeAdView.a delegate;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final com.kakao.adfit.k.g viewState;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private final h0 tracker;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private com.kakao.adfit.k.k disposer;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private final long minExposedTime;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        private long startExposedTime;
        final /* synthetic */ b i;

        /* JADX INFO: renamed from: com.kakao.adfit.d.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewableTracker.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(F)V"}, k = 3, mv = {1, 6, 0})
        public static final class C0451a extends Lambda implements Function1<Float, Unit> {
            final /* synthetic */ h0 a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f1735b;
            final /* synthetic */ b c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0451a(h0 h0Var, a aVar, b bVar) {
                super(1);
                this.a = h0Var;
                this.f1735b = aVar;
                this.c = bVar;
            }

            public final void a(float f) {
                if (!(f >= this.a.minRatio)) {
                    this.f1735b.startExposedTime = 0L;
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f1735b.startExposedTime <= 0) {
                    this.f1735b.startExposedTime = jElapsedRealtime;
                    return;
                }
                if (jElapsedRealtime - this.f1735b.startExposedTime < this.f1735b.minExposedTime) {
                    return;
                }
                com.kakao.adfit.k.k kVar = this.f1735b.disposer;
                if (kVar != null) {
                    kVar.a();
                }
                this.f1735b.disposer = null;
                this.c.event.getViewableEvent().c();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                a(f.floatValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.kakao.adfit.d.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdFitNativeAdBinding.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
        static final class C0452b extends Lambda implements Function0<Unit> {
            C0452b() {
                super(0);
            }

            public final void a() {
                a.this.j();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public a(b bVar, String layoutName, AdFitNativeAdView view) {
            Long lC;
            Float fB;
            Intrinsics.checkNotNullParameter(layoutName, "layoutName");
            Intrinsics.checkNotNullParameter(view, "view");
            this.i = bVar;
            this.layoutName = layoutName;
            AdFitNativeAdView.a delegate = view.getDelegate();
            this.delegate = delegate;
            com.kakao.adfit.k.g gVar = new com.kakao.adfit.k.g(new C0452b());
            this.viewState = gVar;
            String name = bVar.getLayout().getName();
            com.kakao.adfit.a.n nVar = bVar.options;
            h0 h0Var = new h0(name, view, (nVar == null || (fB = nVar.b()) == null) ? 0.5f : fB.floatValue(), 0.0f, 0L, 24, null);
            this.tracker = h0Var;
            com.kakao.adfit.a.n nVar2 = bVar.options;
            this.minExposedTime = (nVar2 == null || (lC = nVar2.c()) == null) ? 1000L : lC.longValue();
            if (!bVar.event.getViewableEvent().b()) {
                this.disposer = h0Var.a(new C0451a(h0Var, this, bVar));
            }
            delegate.a(this);
            e();
            if (gVar.d()) {
                return;
            }
            com.kakao.adfit.k.f.d(layoutName + " is background state.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j() {
            boolean zD = this.viewState.d();
            if (zD) {
                com.kakao.adfit.k.f.d(this.layoutName + " is foreground state.");
            } else {
                com.kakao.adfit.k.f.d(this.layoutName + " is background state.");
            }
            this.tracker.a(zD);
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.b
        public void e() {
            boolean zB = this.delegate.b();
            if (this.viewState.c() == zB) {
                return;
            }
            this.viewState.a(zB);
            if (zB) {
                this.viewState.e(this.delegate.isVisible());
                this.viewState.f(this.delegate.f());
                this.viewState.d(this.delegate.a());
                this.viewState.c(this.delegate.c() > 0 && this.delegate.d() > 0);
            }
        }

        @Override // com.kakao.adfit.d.y
        protected void g() {
            this.delegate.a(null);
            com.kakao.adfit.k.k kVar = this.disposer;
            if (kVar != null) {
                kVar.a();
            }
            this.disposer = null;
        }

        /* JADX INFO: renamed from: i, reason: from getter */
        public final h0 getTracker() {
            return this.tracker;
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.b
        public void b() {
            this.viewState.e(this.delegate.isVisible());
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.b
        public void c() {
            this.viewState.d(this.delegate.a());
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.b
        public void d() {
            this.viewState.c(this.delegate.c() > 0 && this.delegate.d() > 0);
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.b
        public void a() {
            this.viewState.f(this.delegate.f());
        }
    }

    /* JADX INFO: renamed from: com.kakao.adfit.d.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdFitNativeAdBinding.kt */
    @Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0006\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/d/b$b;", "Lcom/kakao/adfit/d/y;", "Lcom/kakao/adfit/d/r$c;", "", "url", "Landroid/graphics/Bitmap;", "image", "", "a", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "g", "Lcom/kakao/adfit/ads/media/MediaAdView;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/ads/media/MediaAdView;", "view", "Lcom/kakao/adfit/d/n;", "c", "Lcom/kakao/adfit/d/n;", "imageAdViewModel", "Lcom/kakao/adfit/d/p$c;", "description", "<init>", "(Lcom/kakao/adfit/d/b;Lcom/kakao/adfit/ads/media/MediaAdView;Lcom/kakao/adfit/d/p$c;Ljava/lang/String;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private final class C0453b extends y implements r.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final MediaAdView view;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final n imageAdViewModel;
        final /* synthetic */ b d;

        public C0453b(b bVar, MediaAdView view, p.c image, String str) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(image, "image");
            this.d = bVar;
            this.view = view;
            n nVar = new n(view, image);
            this.imageAdViewModel = nVar;
            view.setViewModel(nVar);
            view.setContentDescription(str);
            bVar.imageLoader.a(image.getUrl(), this);
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String str) {
            r.c.a.a(this, str);
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, Exception e) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(e, "e");
        }

        @Override // com.kakao.adfit.d.y
        protected void g() {
            this.view.setViewModel(null);
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String str, com.kakao.adfit.k.k kVar) {
            r.c.a.a(this, str, kVar);
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, Bitmap image) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(image, "image");
            this.imageAdViewModel.a(new BitmapDrawable(this.view.getResources(), image));
        }
    }

    /* JADX INFO: compiled from: AdFitNativeAdBinding.kt */
    @Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/kakao/adfit/d/b$c;", "Lcom/kakao/adfit/d/y;", "Lcom/kakao/adfit/d/r$c;", "", "url", "Landroid/graphics/Bitmap;", "image", "", "a", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "g", "Lcom/kakao/adfit/ads/media/MediaAdView;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/ads/media/MediaAdView;", "view", "Lcom/kakao/adfit/d/x;", "c", "Lcom/kakao/adfit/d/x;", "videoAdViewModel", "Lcom/kakao/adfit/k/k;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/k/k;", "viewableTrackingDisposer", "Lcom/kakao/adfit/d/p$k;", "video", "description", "Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;", "policy", "Lcom/kakao/adfit/a/c;", "event", "Lcom/kakao/adfit/k/h0;", "viewableTracker", "<init>", "(Lcom/kakao/adfit/d/b;Lcom/kakao/adfit/ads/media/MediaAdView;Lcom/kakao/adfit/d/p$k;Ljava/lang/String;Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;Lcom/kakao/adfit/a/c;Lcom/kakao/adfit/k/h0;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private final class c extends y implements r.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final MediaAdView view;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private x videoAdViewModel;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private com.kakao.adfit.k.k viewableTrackingDisposer;
        final /* synthetic */ b e;

        /* JADX INFO: compiled from: ViewableTracker.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(F)V"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function1<Float, Unit> {
            final /* synthetic */ h0 a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.kakao.adfit.a.c f1738b;
            final /* synthetic */ c c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h0 h0Var, com.kakao.adfit.a.c cVar, c cVar2) {
                super(1);
                this.a = h0Var;
                this.f1738b = cVar;
                this.c = cVar2;
            }

            public final void a(float f) {
                this.c.videoAdViewModel.a(this.f1738b.getViewableEvent().b() && ((f > this.a.minRatio ? 1 : (f == this.a.minRatio ? 0 : -1)) >= 0));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                a(f.floatValue());
                return Unit.INSTANCE;
            }
        }

        public c(b bVar, MediaAdView view, p.k video, String str, NativeAdVideoPlayPolicy policy, com.kakao.adfit.a.c event, h0 viewableTracker) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(video, "video");
            Intrinsics.checkNotNullParameter(policy, "policy");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(viewableTracker, "viewableTracker");
            this.e = bVar;
            this.view = view;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            x xVar = new x(context, view, video, policy);
            this.videoAdViewModel = xVar;
            view.setViewModel(xVar);
            view.setContentDescription(str);
            p.c image = video.getImage();
            String url = image != null ? image.getUrl() : null;
            if (url != null) {
                bVar.imageLoader.a(url, this);
            }
            this.viewableTrackingDisposer = viewableTracker.a(new a(viewableTracker, event, this));
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, Exception e) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(e, "e");
        }

        @Override // com.kakao.adfit.d.y
        protected void g() {
            this.view.setViewModel(null);
            this.videoAdViewModel.r();
            com.kakao.adfit.k.k kVar = this.viewableTrackingDisposer;
            if (kVar != null) {
                kVar.a();
            }
            this.viewableTrackingDisposer = null;
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String str) {
            r.c.a.a(this, str);
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String str, com.kakao.adfit.k.k kVar) {
            r.c.a.a(this, str, kVar);
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, Bitmap image) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(image, "image");
            this.videoAdViewModel.a(new BitmapDrawable(this.view.getResources(), image));
        }
    }

    /* JADX INFO: compiled from: AdFitNativeAdBinding.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "<anonymous parameter 0>", "", "a", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
    static final class d extends Lambda implements Function1<String, Boolean> {
        public static final d a = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: compiled from: AdFitNativeAdBinding.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "v", "", "a", "(Landroid/view/View;)V"}, k = 3, mv = {1, 6, 0})
    static final class e extends Lambda implements Function1<View, Unit> {
        e() {
            super(1);
        }

        public final void a(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            b.this.event.getClickEvent().c();
            AdFitNativeAdBinder.OnAdClickListener onAdClickListener = b.this.getBinder().getOnAdClickListener();
            if (onAdClickListener != null) {
                onAdClickListener.onAdClicked(v);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            a(view);
            return Unit.INSTANCE;
        }
    }

    public b(AdFitNativeAdBinder binder, AdFitNativeAdLayout layout, p ad, com.kakao.adfit.a.n nVar, com.kakao.adfit.a.c event, r imageLoader, NativeAdVideoPlayPolicy videoPlayPolicy, int i) {
        Intrinsics.checkNotNullParameter(binder, "binder");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(videoPlayPolicy, "videoPlayPolicy");
        this.binder = binder;
        this.layout = layout;
        this.ad = ad;
        this.options = nVar;
        this.event = event;
        this.imageLoader = imageLoader;
        this.videoPlayPolicy = videoPlayPolicy;
        this.adInfoIconGravity = i;
        ArrayList<y> arrayList = new ArrayList<>();
        this.bindings = arrayList;
        this.handleOpenLandingPage = d.a;
        this.notifyOnClick = new e();
        a aVarA = a(layout.getContainerView(), layout.getName());
        this.viewableTracker = aVarA.getTracker();
        arrayList.add(aVarA);
        ImageView imageViewG = layout.getContainerView().getDelegate().g();
        arrayList.add(a(imageViewG, ad.getAdInfoIcon(), R.drawable.adfit_icon_ad_info));
        arrayList.add(a(imageViewG));
        ViewGroup.LayoutParams layoutParams = imageViewG.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        imageViewG.requestLayout();
        View titleView = layout.getTitleView();
        TextView textView = titleView instanceof TextView ? (TextView) titleView : null;
        if (textView != null) {
            arrayList.add(a(textView, ad.getTitle()));
            arrayList.add(b(textView));
        }
        View bodyView = layout.getBodyView();
        TextView textView2 = bodyView instanceof TextView ? (TextView) bodyView : null;
        if (textView2 != null) {
            arrayList.add(a(textView2, ad.getBody()));
            arrayList.add(b(textView2));
        }
        View callToActionButton = layout.getCallToActionButton();
        TextView textView3 = callToActionButton instanceof TextView ? (TextView) callToActionButton : null;
        if (textView3 != null) {
            arrayList.add(a(textView3, ad.getCallToAction()));
            arrayList.add(b(textView3));
        }
        View profileIconView = layout.getProfileIconView();
        ImageView imageView = profileIconView instanceof ImageView ? (ImageView) profileIconView : null;
        if (imageView != null) {
            arrayList.add(a(this, imageView, ad.getProfileIcon(), 0, 2, null));
            arrayList.add(b(imageView));
        }
        View profileNameView = layout.getProfileNameView();
        TextView textView4 = profileNameView instanceof TextView ? (TextView) profileNameView : null;
        if (textView4 != null) {
            arrayList.add(a(textView4, ad.getProfileName()));
            arrayList.add(b(textView4));
        }
        View mediaView = layout.getMediaView();
        ViewGroup viewGroup = mediaView instanceof ViewGroup ? (ViewGroup) mediaView : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mediaView.context");
            MediaAdView mediaAdView = new MediaAdView(context, null, 0, 6, null);
            p.f fVar = ad.getCom.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MEDIA java.lang.String();
            if (fVar instanceof p.c) {
                arrayList.add(a(mediaAdView, (p.c) ad.getCom.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MEDIA java.lang.String()));
                arrayList.add(b(mediaAdView));
            } else if (fVar instanceof p.k) {
                arrayList.add(a(mediaAdView, (p.k) ad.getCom.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MEDIA java.lang.String()));
            }
            viewGroup.addView(mediaAdView);
        }
        event.getRenderEvent().c();
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final AdFitNativeAdBinder getBinder() {
        return this.binder;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final AdFitNativeAdLayout getLayout() {
        return this.layout;
    }

    public final void c() {
        Iterator<T> it = this.bindings.iterator();
        while (it.hasNext()) {
            ((y) it.next()).h();
        }
        this.bindings.clear();
    }

    private final a a(AdFitNativeAdView adFitNativeAdView, String str) {
        return new a(this, str, adFitNativeAdView);
    }

    private final o b(ImageView imageView, p.c cVar, int i) {
        return new o(imageView, this.imageLoader, cVar != null ? cVar.getUrl() : null, i, 0);
    }

    private final v a(TextView textView, String str) {
        return new v(textView, str);
    }

    private final com.kakao.adfit.d.e b(View view) {
        return new com.kakao.adfit.d.e(view, this.ad.getLandingUrl(), this.event.b(), this.handleOpenLandingPage, this.notifyOnClick);
    }

    static /* synthetic */ o a(b bVar, ImageView imageView, p.c cVar, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return bVar.b(imageView, cVar, i);
    }

    private final com.kakao.adfit.d.c a(ImageView imageView, p.c cVar, int i) {
        return new com.kakao.adfit.d.c(imageView, this.imageLoader, cVar, i, 0);
    }

    private final com.kakao.adfit.d.d a(View view) {
        return new com.kakao.adfit.d.d(view, this.ad.getAdInfoUrl(), this.handleOpenLandingPage);
    }

    private final C0453b a(MediaAdView mediaAdView, p.c cVar) {
        return new C0453b(this, mediaAdView, cVar, this.ad.getAltText());
    }

    private final c a(MediaAdView mediaAdView, p.k kVar) {
        return new c(this, mediaAdView, kVar, this.ad.getAltText(), this.videoPlayPolicy, this.event, this.viewableTracker);
    }
}
