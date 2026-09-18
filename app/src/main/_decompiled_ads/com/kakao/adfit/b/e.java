package com.kakao.adfit.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.google.android.gms.ads.RequestConfiguration;
import com.kakao.adfit.a.j;
import com.kakao.adfit.a.n;
import com.kakao.adfit.ads.AdError;
import com.kakao.adfit.ads.AdListener;
import com.kakao.adfit.k.f0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BannerAdPresenter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u00012\u00020\u0001B\u0019\u0012\u0006\u0010\"\u001a\u00020 \u0012\b\b\u0002\u0010%\u001a\u00020#¢\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0002J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u001d\u0010\b\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010$R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010&R\u0016\u0010)\u001a\u0004\u0018\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010>R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010BR\u0014\u0010E\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010DR\u001e\u0010J\u001a\u0004\u0018\u00010F8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\b\b\u0010IR\u001e\u0010M\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0019\u0010K\"\u0004\b\b\u0010LR\u001e\u0010O\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010K\"\u0004\bN\u0010LR\u001c\u0010R\u001a\u00020\u00068\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b7\u0010P\"\u0004\b\u0019\u0010QR\u001c\u0010T\u001a\u00020=8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b+\u0010D\"\u0004\b\b\u0010SR\u001c\u0010W\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b/\u0010U\"\u0004\b\b\u0010VR\u001c\u0010Y\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bX\u0010U\"\u0004\b\u0019\u0010V¨\u0006\\"}, d2 = {"Lcom/kakao/adfit/b/e;", "", "", CampaignEx.JSON_KEY_AD_K, "o", CampaignEx.JSON_KEY_AD_Q, "", "isViewableChecked", "a", "Lcom/kakao/adfit/b/a;", "bannerAd", "Lkotlin/Function0;", "onViewable", "Landroid/os/Bundle;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "", "name", "value", CampaignEx.JSON_KEY_AD_R, "p", "n", "i", "l", InneractiveMediationDefs.GENDER_MALE, "j", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "Lcom/kakao/adfit/ads/AdError;", "error", "message", "", "errorCode", "Lcom/kakao/adfit/b/c;", "Lcom/kakao/adfit/b/c;", "view", "Lcom/kakao/adfit/b/b;", "Lcom/kakao/adfit/b/b;", "config", "Lcom/kakao/adfit/b/a;", "Lcom/kakao/adfit/a/n;", "Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/kakao/adfit/k/g;", "e", "Lcom/kakao/adfit/k/g;", "viewState", "Lcom/kakao/adfit/b/h;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/b/h;", "requester", "Lcom/kakao/adfit/b/g;", "g", "Lcom/kakao/adfit/b/g;", "requestState", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "requestHandler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "requestRunnable", "", "J", "lastRequestTime", "nextRequestTime", "Lcom/kakao/adfit/k/f0;", "Lcom/kakao/adfit/k/f0;", "viewableCheck", "()J", "remainingTimeNextRequest", "Lcom/kakao/adfit/ads/AdListener;", "getAdListener", "()Lcom/kakao/adfit/ads/AdListener;", "(Lcom/kakao/adfit/ads/AdListener;)V", "adListener", "()Ljava/lang/String;", "(Ljava/lang/String;)V", OutOfContextTestingActivity.AD_UNIT_KEY, "setClientId", "clientId", "()Z", "(Z)V", "isTestMode", "(J)V", "refreshInterval", "()I", "(I)V", "refreshSequence", "getRequestTimeout", "requestTimeout", "<init>", "(Lcom/kakao/adfit/b/c;Lcom/kakao/adfit/b/b;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class e {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final com.kakao.adfit.b.c view;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.kakao.adfit.b.b config;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private com.kakao.adfit.b.a bannerAd;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final n options;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final com.kakao.adfit.k.g viewState;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final com.kakao.adfit.b.h requester;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final com.kakao.adfit.b.g requestState;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Handler requestHandler;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Runnable requestRunnable;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private long lastRequestTime;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private long nextRequestTime;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private f0 viewableCheck;

    /* JADX INFO: compiled from: BannerAdPresenter.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f1700b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Function0<Unit> function0) {
            super(0);
            this.f1700b = function0;
        }

        public final void a() {
            e.this.viewableCheck = null;
            this.f1700b.invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BannerAdPresenter.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.kakao.adfit.b.a f1701b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.kakao.adfit.b.a aVar) {
            super(0);
            this.f1701b = aVar;
        }

        public final void a() {
            e.this.d(this.f1701b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: AdRequester.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/kakao/adfit/a/a;", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "Lcom/kakao/adfit/a/b;", "Config", "Lcom/kakao/adfit/a/j;", "it", "", "a", "(Lcom/kakao/adfit/a/j;)V"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function1 {
        public c() {
            super(1);
        }

        public final void a(j it) {
            Long lA;
            Intrinsics.checkNotNullParameter(it, "it");
            Object obj = it.a().get(0);
            n options = it.getOptions();
            com.kakao.adfit.b.a aVar = (com.kakao.adfit.b.a) obj;
            com.kakao.adfit.k.f.a("Receive a banner ad: " + aVar.getName());
            e.this.requestState.d(false);
            e.this.bannerAd = aVar;
            e.this.a((options == null || (lA = options.a()) == null) ? e.this.e() : lA.longValue());
            e.this.b(aVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((j) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BannerAdPresenter.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    static final class d extends Lambda implements Function0<Unit> {
        d() {
            super(0);
        }

        public final void a() {
            e.this.a(true);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.kakao.adfit.b.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BannerAdPresenter.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/kakao/adfit/a/h;", "Lcom/kakao/adfit/b/a;", "it", "", "a", "(Lcom/kakao/adfit/a/h;)V"}, k = 3, mv = {1, 6, 0})
    static final class C0447e extends Lambda implements Function1<com.kakao.adfit.a.h<com.kakao.adfit.b.a>, Unit> {
        C0447e() {
            super(1);
        }

        public final void a(com.kakao.adfit.a.h<com.kakao.adfit.b.a> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            com.kakao.adfit.k.f.a("Request a banner ad: " + it.q());
            e.this.requestState.d(true);
            e.this.lastRequestTime = SystemClock.elapsedRealtime();
            e.this.nextRequestTime = 0L;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.kakao.adfit.a.h<com.kakao.adfit.b.a> hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BannerAdPresenter.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "errorCode", "", "message", "Lcom/kakao/adfit/a/n;", "<anonymous parameter 2>", "", "a", "(ILjava/lang/String;Lcom/kakao/adfit/a/n;)V"}, k = 3, mv = {1, 6, 0})
    static final class f extends Lambda implements Function3<Integer, String, n, Unit> {
        f() {
            super(3);
        }

        public final void a(int i, String message, n nVar) {
            Intrinsics.checkNotNullParameter(message, "message");
            com.kakao.adfit.k.f.a("Failed to receive a banner ad: " + i + ", " + message);
            e.this.requestState.d(false);
            e.this.a(i, message);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, n nVar) {
            a(num.intValue(), str, nVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BannerAdPresenter.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    static final class g extends Lambda implements Function0<Unit> {
        g() {
            super(0);
        }

        public final void a() {
            e.this.k();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: BannerAdPresenter.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    static final class h extends Lambda implements Function0<Unit> {
        h() {
            super(0);
        }

        public final void a() {
            e.this.k();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public e(com.kakao.adfit.b.c view, com.kakao.adfit.b.b config) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        this.view = view;
        this.config = config;
        this.viewState = new com.kakao.adfit.k.g(new h());
        this.requester = new com.kakao.adfit.b.h();
        this.requestState = new com.kakao.adfit.b.g(new g());
        this.requestHandler = new Handler(Looper.getMainLooper());
        this.requestRunnable = new Runnable() { // from class: com.kakao.adfit.b.-$$Lambda$e$Vz9sIO0T2nvQ5V-fsfGmAdbAxYs
            @Override // java.lang.Runnable
            public final void run() {
                e.c(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a(this$0, false, 1, null);
    }

    private final long g() {
        return this.nextRequestTime - SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        if (this.requestState.a()) {
            o();
        } else {
            q();
        }
        if (this.requestState.a() && this.viewState.d()) {
            f0 f0Var = this.viewableCheck;
            if (f0Var != null) {
                f0Var.c();
                return;
            }
            return;
        }
        f0 f0Var2 = this.viewableCheck;
        if (f0Var2 != null) {
            f0Var2.d();
        }
    }

    private final void o() {
        this.requestHandler.removeCallbacks(this.requestRunnable);
        this.requestHandler.postDelayed(this.requestRunnable, Math.max(g(), 0L));
    }

    private final void q() {
        this.requestHandler.removeCallbacks(this.requestRunnable);
    }

    public void a(int i) {
        this.config.b(i);
    }

    public void a(long j) {
        this.config.a(j);
    }

    public void a(AdListener adListener) {
        this.config.a(adListener);
    }

    public void a(String str) {
        this.config.a(str);
    }

    public void a(String name, String value) {
        this.config.a(name, value);
    }

    public String b() {
        return this.config.getAdUnit();
    }

    public void b(int i) {
        this.config.c(i);
    }

    public void b(boolean z) {
        this.config.a(z);
    }

    public String c() {
        return this.config.m();
    }

    public Bundle d() {
        return this.config.b();
    }

    public void d(com.kakao.adfit.b.a bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "bannerAd");
        this.requester.c(this.view.getA(), bannerAd);
        this.nextRequestTime = SystemClock.elapsedRealtime() + e();
        o();
    }

    public long e() {
        return this.config.getRefreshInterval();
    }

    public int f() {
        return this.config.getRefreshSequence();
    }

    public boolean h() {
        return this.config.getIsTestMode();
    }

    public void i() {
        boolean zB = this.view.b();
        if (this.viewState.c() == zB) {
            return;
        }
        this.viewState.a(zB);
        if (zB) {
            this.viewState.e(this.view.isVisible());
            this.viewState.f(this.view.f());
            this.viewState.d(this.view.a());
            this.viewState.c(this.view.c() > 0 && this.view.d() > 0);
        }
    }

    public void j() {
        this.viewState.c(this.view.c() > 0 && this.view.d() > 0);
    }

    public void l() {
        this.viewState.e(this.view.isVisible());
    }

    public void m() {
        this.viewState.d(this.view.a());
    }

    public void n() {
        this.requestState.c(true);
    }

    public void p() {
        this.requestState.c(false);
    }

    public void r() {
        if (this.requestState.e()) {
            return;
        }
        this.requestState.e(true);
        this.view.g();
    }

    public void c(com.kakao.adfit.b.a bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "bannerAd");
        this.requester.b(this.view.getA(), bannerAd);
        this.config.o();
        a(bannerAd, new b(bannerAd));
    }

    public void b(com.kakao.adfit.b.a bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "bannerAd");
        this.view.a(bannerAd);
    }

    public void a() {
        String strC = c();
        if (strC == null || StringsKt.isBlank(strC)) {
            String string = AdError.UNKNOWN_CLIENT_ID.toString();
            Intrinsics.checkNotNullExpressionValue(string, "UNKNOWN_CLIENT_ID.toString()");
            com.kakao.adfit.k.f.b(string);
        } else {
            if (this.requestState.b()) {
                return;
            }
            this.requestState.b(true);
        }
    }

    static /* synthetic */ void a(e eVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        eVar.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean isViewableChecked) {
        if (this.requestState.a()) {
            if (g() > 0 && !h()) {
                o();
                return;
            }
            if (this.bannerAd != null) {
                if (e() <= 0 || this.nextRequestTime <= 0) {
                    return;
                }
                if (!isViewableChecked) {
                    if (this.viewableCheck == null) {
                        com.kakao.adfit.b.a aVar = this.bannerAd;
                        Intrinsics.checkNotNull(aVar);
                        a(aVar, new d());
                        return;
                    }
                    return;
                }
            }
            com.kakao.adfit.k.f.c("Request Banner AD");
            a(f() + 1);
            this.requester.a(this.config, 1, new C0447e(), new c(), new f());
        }
    }

    public /* synthetic */ e(com.kakao.adfit.b.c cVar, com.kakao.adfit.b.b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, (i & 2) != 0 ? new com.kakao.adfit.b.b(cVar) : bVar);
    }

    public void a(com.kakao.adfit.b.a bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "bannerAd");
        this.requester.a(this.view.getA(), bannerAd);
        this.config.d();
    }

    public void a(AdError error, String message) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(message, "message");
        a(error.getErrorCode(), message);
    }

    public void a(int errorCode, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.config.a(errorCode);
        this.nextRequestTime = this.lastRequestTime + e();
        o();
    }

    private final void a(com.kakao.adfit.b.a bannerAd, Function0<Unit> onViewable) {
        f0 f0Var = this.viewableCheck;
        if (f0Var != null) {
            f0Var.d();
        }
        this.viewableCheck = this.view.a(bannerAd, this.options, new a(onViewable));
        if (this.requestState.a() && this.viewState.d()) {
            f0 f0Var2 = this.viewableCheck;
            Intrinsics.checkNotNull(f0Var2);
            f0Var2.c();
        }
    }
}
