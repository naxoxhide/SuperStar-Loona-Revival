package com.kakao.adfit.ads.na;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakao.adfit.a.h;
import com.kakao.adfit.a.j;
import com.kakao.adfit.a.n;
import com.kakao.adfit.ads.AdError;
import com.kakao.adfit.d.p;
import com.kakao.adfit.d.q;
import com.kakao.adfit.d.r;
import com.kakao.adfit.d.u;
import com.kakao.adfit.k.k;
import com.kakao.adfit.k.z;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AdFitNativeAdLoaderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u0000 32\u00020\u0001:\u0001\tB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b1\u00102J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017R\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010-R\u0014\u0010/\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/kakao/adfit/ads/na/a;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLoader;", "Landroid/content/Context;", "context", "Lcom/kakao/adfit/ads/na/AdFitNativeAdRequest;", "request", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLoader$AdLoadListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "a", "Lcom/kakao/adfit/d/a;", "binder", "", "resultMessage", "", "loadAd", "Ljava/lang/String;", "adUnitId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/lang/String;", "name", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "c", "Ljava/lang/ref/WeakReference;", "Landroid/os/Handler;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Landroid/os/Handler;", "handler", "Lcom/kakao/adfit/d/u;", "e", "Lcom/kakao/adfit/d/u;", "requester", "Lcom/kakao/adfit/a/h;", "Lcom/kakao/adfit/d/p;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/a/h;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "_isLoading", "", "h", "J", "loadingStartTime", "()J", "loadingElapsedTime", "isLoading", "()Z", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "i", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class a extends AdFitNativeAdLoader {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String adUnitId;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final WeakReference<Context> context;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Handler handler;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final u requester;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private h<p> request;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final AtomicBoolean _isLoading;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private long loadingStartTime;

    /* JADX INFO: renamed from: com.kakao.adfit.ads.na.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: AdFitNativeAdLoaderImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/kakao/adfit/ads/na/a$a;", "", "Landroid/content/Context;", "context", "", "adUnitId", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLoader;", "a", "(Landroid/content/Context;Ljava/lang/String;)Lcom/kakao/adfit/ads/na/AdFitNativeAdLoader;", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AdFitNativeAdLoader a(Context context, String adUnitId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            z.a.b(context);
            return new a(context, adUnitId, null);
        }
    }

    /* JADX INFO: compiled from: AdFitNativeAdLoaderImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/kakao/adfit/ads/na/a$b", "Lcom/kakao/adfit/d/r$e;", "", "a", "c", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class b implements r.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdFitNativeAdLoader.AdLoadListener f1692b;
        final /* synthetic */ com.kakao.adfit.d.a c;

        b(AdFitNativeAdLoader.AdLoadListener adLoadListener, com.kakao.adfit.d.a aVar) {
            this.f1692b = adLoadListener;
            this.c = aVar;
        }

        @Override // com.kakao.adfit.d.r.e
        public void a(k kVar) {
            r.e.a.a(this, kVar);
        }

        @Override // com.kakao.adfit.d.r.e
        public void b() {
            r.e.a.a(this);
        }

        @Override // com.kakao.adfit.d.r.e
        public void c() {
            a.this.a("Preparing failed.");
            Handler handler = a.this.handler;
            final AdFitNativeAdLoader.AdLoadListener adLoadListener = this.f1692b;
            handler.post(new Runnable() { // from class: com.kakao.adfit.ads.na.-$$Lambda$a$b$Rigo6XfUr6ODJS1G6xPYA8sKvrg
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.a(adLoadListener);
                }
            });
        }

        @Override // com.kakao.adfit.d.r.e
        public void a() {
            a.this.a("Native ad is prepared.");
            Handler handler = a.this.handler;
            final AdFitNativeAdLoader.AdLoadListener adLoadListener = this.f1692b;
            final com.kakao.adfit.d.a aVar = this.c;
            handler.post(new Runnable() { // from class: com.kakao.adfit.ads.na.-$$Lambda$a$b$83M7ltMDpZ-ozjVJPa-v4A2x29Y
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.a(adLoadListener, aVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(AdFitNativeAdLoader.AdLoadListener listener, com.kakao.adfit.d.a binder) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(binder, "$binder");
            listener.onAdLoaded(binder);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(AdFitNativeAdLoader.AdLoadListener listener) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onAdLoadError(AdError.NO_AD.getErrorCode());
        }
    }

    /* JADX INFO: compiled from: AdFitNativeAdLoaderImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/kakao/adfit/a/h;", "Lcom/kakao/adfit/d/p;", "it", "", "a", "(Lcom/kakao/adfit/a/h;)V"}, k = 3, mv = {1, 6, 0})
    static final class c extends Lambda implements Function1<h<p>, Unit> {
        c() {
            super(1);
        }

        public final void a(h<p> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            com.kakao.adfit.k.f.d(a.this.getName() + " request native ad. [url = " + it.q() + ']');
            a.this.request = it;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(h<p> hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdFitNativeAdLoaderImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/kakao/adfit/a/j;", "Lcom/kakao/adfit/d/p;", "response", "", "a", "(Lcom/kakao/adfit/a/j;)V"}, k = 3, mv = {1, 6, 0})
    static final class d extends Lambda implements Function1<j<p>, Unit> {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f1693b;
        final /* synthetic */ AdFitNativeAdRequest c;
        final /* synthetic */ AdFitNativeAdLoader.AdLoadListener d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, a aVar, AdFitNativeAdRequest adFitNativeAdRequest, AdFitNativeAdLoader.AdLoadListener adLoadListener) {
            super(1);
            this.a = context;
            this.f1693b = aVar;
            this.c = adFitNativeAdRequest;
            this.d = adLoadListener;
        }

        public final void a(j<p> response) {
            Intrinsics.checkNotNullParameter(response, "response");
            p pVar = (p) CollectionsKt.first((List) response.a());
            com.kakao.adfit.d.a aVar = new com.kakao.adfit.d.a(this.a, this.f1693b.adUnitId, this.c, pVar, response.getOptions());
            com.kakao.adfit.k.f.d(this.f1693b.getName() + " receive native ad. [binder = " + aVar.getName() + '/' + pVar.getName() + "] [elapsed = " + this.f1693b.a() + "ms]");
            this.f1693b.a(aVar, this.d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(j<p> jVar) {
            a(jVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdFitNativeAdLoaderImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
    static final class f extends Lambda implements Function0<Boolean> {
        public static final f a = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            com.kakao.adfit.k.b bVar = com.kakao.adfit.k.b.a;
            return Boolean.valueOf(bVar.b() || bVar.a());
        }
    }

    private a(Context context, String str) {
        this.adUnitId = str;
        String str2 = "AdFitNativeAdLoader(\"" + str + "\")@" + hashCode();
        this.name = str2;
        this.context = new WeakReference<>(context);
        this.handler = new Handler(Looper.getMainLooper());
        this.requester = new u();
        this._isLoading = new AtomicBoolean(false);
        com.kakao.adfit.k.f.a(str2 + " is created.");
    }

    public /* synthetic */ a(Context context, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str);
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdLoader
    public boolean isLoading() {
        return this._isLoading.get();
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdLoader
    public boolean loadAd(final AdFitNativeAdRequest request, final AdFitNativeAdLoader.AdLoadListener listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new RuntimeException("Must be called from the main thread.");
        }
        final Context context = this.context.get();
        if (context == null) {
            com.kakao.adfit.k.f.e("The context is cleared.");
            return false;
        }
        if (!this._isLoading.compareAndSet(false, true)) {
            com.kakao.adfit.k.f.e(this.name + " loading is already started.");
            return false;
        }
        this.loadingStartTime = SystemClock.elapsedRealtime();
        this.handler.post(new Runnable() { // from class: com.kakao.adfit.ads.na.-$$Lambda$a$1PkgcJIyhP9G2ZQD8qDUw5NskQs
            @Override // java.lang.Runnable
            public final void run() {
                a.a(this.f$0, context, request, listener);
            }
        });
        com.kakao.adfit.k.f.a(this.name + " loading is started.");
        return true;
    }

    /* JADX INFO: compiled from: AdFitNativeAdLoaderImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "errorCode", "", "message", "Lcom/kakao/adfit/a/n;", "<anonymous parameter 2>", "", "a", "(ILjava/lang/String;Lcom/kakao/adfit/a/n;)V"}, k = 3, mv = {1, 6, 0})
    static final class e extends Lambda implements Function3<Integer, String, n, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdFitNativeAdLoader.AdLoadListener f1694b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AdFitNativeAdLoader.AdLoadListener adLoadListener) {
            super(3);
            this.f1694b = adLoadListener;
        }

        public final void a(final int i, String message, n nVar) {
            Intrinsics.checkNotNullParameter(message, "message");
            a.this.a("Request failed. [error = " + i + ", " + message + ']');
            Handler handler = a.this.handler;
            final AdFitNativeAdLoader.AdLoadListener adLoadListener = this.f1694b;
            handler.post(new Runnable() { // from class: com.kakao.adfit.ads.na.-$$Lambda$a$e$FqIcDayVtRl-GAP-c-5sbRyty9U
                @Override // java.lang.Runnable
                public final void run() {
                    a.e.a(adLoadListener, i);
                }
            });
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, n nVar) {
            a(num.intValue(), str, nVar);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(AdFitNativeAdLoader.AdLoadListener listener, int i) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onAdLoadError(i);
        }
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long a() {
        return SystemClock.elapsedRealtime() - this.loadingStartTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, Context context, AdFitNativeAdRequest request, AdFitNativeAdLoader.AdLoadListener listener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        this$0.a(context, request, listener);
    }

    private final void a(Context context, AdFitNativeAdRequest request, AdFitNativeAdLoader.AdLoadListener listener) {
        q qVar = new q(context);
        qVar.a(this.adUnitId);
        qVar.a(f.a);
        qVar.a(request.getTestModeEnabled());
        this.requester.a(qVar, 1, new c(), new d(context, this, request, listener), new e(listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.kakao.adfit.d.a binder, AdFitNativeAdLoader.AdLoadListener listener) {
        binder.a(new b(listener, binder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String resultMessage) {
        this.request = null;
        this._isLoading.set(false);
        com.kakao.adfit.k.f.a(this.name + " loading is finished. " + resultMessage + " [elapsed = " + a() + "ms]");
    }
}
