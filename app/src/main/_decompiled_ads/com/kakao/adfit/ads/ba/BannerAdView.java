package com.kakao.adfit.ads.ba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakao.adfit.a.l;
import com.kakao.adfit.a.m;
import com.kakao.adfit.a.n;
import com.kakao.adfit.ads.AdError;
import com.kakao.adfit.ads.AdListener;
import com.kakao.adfit.ads.R;
import com.kakao.adfit.b.c;
import com.kakao.adfit.b.e;
import com.kakao.adfit.k.f;
import com.kakao.adfit.k.f0;
import com.kakao.adfit.k.j;
import com.kakao.adfit.k.z;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BannerAdView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 I2\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\b\b\u0002\u0010F\u001a\u00020\u0011¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0007J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004J\b\u0010#\u001a\u00020\u0004H\u0014J\b\u0010$\u001a\u00020\u0004H\u0014J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0011H\u0014J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\u0011H\u0014J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000eH\u0016J0\u00101\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0014R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00108¨\u0006J"}, d2 = {"Lcom/kakao/adfit/ads/ba/BannerAdView;", "Landroid/widget/RelativeLayout;", "Lcom/kakao/adfit/b/a;", "bannerAd", "", "a", "Lcom/kakao/adfit/ads/AdListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAdListener", "", "id", "setClientId", "adSize", "setAdUnitSize", "", "enabled", "setTestMode", "", CampaignEx.JSON_AD_IMP_KEY, "setRequestInterval", "ms", "setTimeout", "name", "value", "putExtra", "Landroid/os/Bundle;", "getExtras", "", "tag", "setTag", SDKConstants.PARAM_KEY, "loadAd", CampaignEx.JSON_NATIVE_VIDEO_RESUME, CampaignEx.JSON_NATIVE_VIDEO_PAUSE, "destroy", "onAttachedToWindow", "onDetachedFromWindow", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "onWindowVisibilityChanged", "Landroid/view/View;", "changedView", "onVisibilityChanged", "focus", "onWindowFocusChanged", "changed", "left", "top", "right", TJAdUnitConstants.String.BOTTOM, "onLayout", "Ljava/lang/String;", "Lcom/kakao/adfit/ads/ba/a;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/ads/ba/a;", "webViewHolder", "c", "Z", "_isAttached", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/b/a;", "Lcom/kakao/adfit/b/e;", "e", "Lcom/kakao/adfit/b/e;", "presenter", InneractiveMediationDefs.GENDER_FEMALE, "fieldInitialized", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class BannerAdView extends RelativeLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private String name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private a webViewHolder;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean _isAttached;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private com.kakao.adfit.b.a bannerAd;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final e presenter;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private boolean fieldInitialized;

    /* JADX INFO: renamed from: com.kakao.adfit.ads.ba.BannerAdView$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: BannerAdView.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\t\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00038@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000e\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00038@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\u0007\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/kakao/adfit/ads/ba/BannerAdView$a;", "", "Landroid/widget/TextView;", "", "color", "getTextColor$library_networkRelease", "(Landroid/widget/TextView;)I", "a", "(Landroid/widget/TextView;I)V", "textColor", "Landroid/view/View;", "getBackgroundColor$library_networkRelease", "(Landroid/view/View;)I", "(Landroid/view/View;I)V", "backgroundColor", "", "ATTR_CLIENT_ID", "Ljava/lang/String;", "ATTR_REQ_INTERVAL", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(TextView textView, int i) {
            Intrinsics.checkNotNullParameter(textView, "<this>");
            textView.setTextColor(i);
        }

        public final void a(View view, int i) {
            Intrinsics.checkNotNullParameter(view, "<this>");
            view.setBackgroundColor(i);
        }
    }

    /* JADX INFO: compiled from: BannerAdView.kt */
    @Metadata(bv = {}, d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J(\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0016R\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0018¨\u0006\u001e"}, d2 = {"com/kakao/adfit/ads/ba/BannerAdView$b", "Lcom/kakao/adfit/b/c;", "Lcom/kakao/adfit/b/a;", "bannerAd", "", "a", "g", "Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lkotlin/Function0;", "onViewable", "Lcom/kakao/adfit/k/f0;", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "context", "", "c", "()I", "width", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "height", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Z", "isAttached", "isVisible", InneractiveMediationDefs.GENDER_FEMALE, "isWindowVisible", "hasWindowFocus", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class b implements c {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BannerAdView f1680b;

        /* JADX INFO: compiled from: BannerAdView.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
        static final class a extends Lambda implements Function0<Unit> {
            final /* synthetic */ Function0<Unit> a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Function0<Unit> function0) {
                super(0);
                this.a = function0;
            }

            public final void a() {
                this.a.invoke();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        b(Context context, BannerAdView bannerAdView) {
            this.a = context;
            this.f1680b = bannerAdView;
        }

        @Override // com.kakao.adfit.b.c
        public boolean a() {
            return this.f1680b.hasWindowFocus();
        }

        @Override // com.kakao.adfit.b.c
        public boolean b() {
            return this.f1680b._isAttached && this.f1680b.isAttachedToWindow();
        }

        @Override // com.kakao.adfit.b.c
        public int c() {
            return this.f1680b.getMeasuredWidth();
        }

        @Override // com.kakao.adfit.b.c
        public int d() {
            return this.f1680b.getMeasuredHeight();
        }

        @Override // com.kakao.adfit.b.c
        /* JADX INFO: renamed from: e, reason: from getter */
        public Context getA() {
            return this.a;
        }

        @Override // com.kakao.adfit.b.c
        public boolean f() {
            return this.f1680b.getWindowVisibility() == 0;
        }

        @Override // com.kakao.adfit.b.c
        public void g() {
            this.f1680b.webViewHolder.a();
        }

        @Override // com.kakao.adfit.b.c
        public boolean isVisible() {
            return this.f1680b.getVisibility() == 0;
        }

        @Override // com.kakao.adfit.b.c
        public void a(com.kakao.adfit.b.a bannerAd) {
            Intrinsics.checkNotNullParameter(bannerAd, "bannerAd");
            this.f1680b.bannerAd = bannerAd;
            this.f1680b.a(bannerAd);
        }

        @Override // com.kakao.adfit.b.c
        public f0 a(com.kakao.adfit.b.a bannerAd, n options, Function0<Unit> onViewable) {
            Intrinsics.checkNotNullParameter(bannerAd, "bannerAd");
            Intrinsics.checkNotNullParameter(onViewable, "onViewable");
            f0.a aVar = new f0.a(this.f1680b.name, this.f1680b);
            Context context = this.a;
            com.kakao.adfit.b.a.d size = bannerAd.getSize();
            if (size instanceof com.kakao.adfit.b.a.c) {
                com.kakao.adfit.b.a.c cVar = (com.kakao.adfit.b.a.c) size;
                aVar.b(j.a(context, cVar.getMinWidth()));
                aVar.a(MathKt.roundToInt(j.a(context, (cVar.getMinWidth() * cVar.getHeight()) / cVar.getWidth())));
            } else if (size instanceof com.kakao.adfit.b.a.b) {
                com.kakao.adfit.b.a.b bVar = (com.kakao.adfit.b.a.b) size;
                aVar.b(j.a(context, bVar.getWidth()));
                aVar.a(j.a(context, bVar.getHeight()));
            }
            if (options != null) {
                Long lC = options.c();
                aVar.a(lC != null ? lC.longValue() : 1000L);
                Float fB = options.b();
                aVar.a(fB != null ? fB.floatValue() : 0.5f);
            }
            return aVar.a(new a(onViewable)).a();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerAdView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BannerAdView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final com.kakao.adfit.b.a bannerAd) {
        if (this.webViewHolder.c()) {
            return;
        }
        try {
            final l lVarA = this.webViewHolder.a(getContext());
            com.kakao.adfit.b.a.d size = bannerAd.getSize();
            int iA = -1;
            if (size instanceof com.kakao.adfit.b.a.c) {
                com.kakao.adfit.b.a.c cVar = (com.kakao.adfit.b.a.c) size;
                lVarA.a(cVar.getWidth(), cVar.getHeight());
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                lVarA.setMinimumWidth(j.a(context, cVar.getMinWidth()));
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                lVarA.setMinimumHeight(MathKt.roundToInt(j.a(context2, (cVar.getMinWidth() * cVar.getHeight()) / cVar.getWidth())));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                lVarA.setLayoutParams(layoutParams);
            } else if (size instanceof com.kakao.adfit.b.a.b) {
                com.kakao.adfit.b.a.b bVar = (com.kakao.adfit.b.a.b) size;
                if (bVar.getWidth() != 320) {
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    iA = j.a(context3, bVar.getWidth());
                }
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "context");
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, j.a(context4, bVar.getHeight()));
                layoutParams2.addRule(13);
                lVarA.setLayoutParams(layoutParams2);
            }
            Object tag = getTag(R.id.adfit_private);
            if (tag instanceof m) {
                lVarA.setOnPrivateAdEventListener((m) tag);
            }
            Object tag2 = getTag(R.id.adfit_dev_arg1);
            if ((tag2 instanceof String) && (!StringsKt.isBlank((CharSequence) tag2))) {
                lVarA.setTag(R.id.adfit_dev_arg1, tag2);
            }
            lVarA.setOnPageLoadListener(new l.f() { // from class: com.kakao.adfit.ads.ba.-$$Lambda$BannerAdView$sm1T6yRbuzou5L-z-B083ivBDc8
                @Override // com.kakao.adfit.a.l.f
                public final void a(String str) {
                    BannerAdView.b(lVarA, this, bannerAd, str);
                }
            });
            lVarA.setOnPageErrorListener(new l.e() { // from class: com.kakao.adfit.ads.ba.-$$Lambda$BannerAdView$yVfb3_DN4auMMuo3PT3iwkSgJD4
                @Override // com.kakao.adfit.a.l.e
                public final void a(String str) {
                    BannerAdView.a(lVarA, this, str);
                }
            });
            lVarA.setOnNewPageOpenListener(new l.d() { // from class: com.kakao.adfit.ads.ba.-$$Lambda$BannerAdView$gdsvIsxbOPsPSwdMdaQ-ucV9cBs
                @Override // com.kakao.adfit.a.l.d
                public final void a(String str) {
                    BannerAdView.a(lVarA, this, bannerAd, str);
                }
            });
            lVarA.setOnRenderProcessGoneListener(new l.g() { // from class: com.kakao.adfit.ads.ba.-$$Lambda$BannerAdView$S1GB2sU4Cec4af3FxJM-K8reRgg
                @Override // com.kakao.adfit.a.l.g
                public final void a() {
                    BannerAdView.a(lVarA, this, bannerAd);
                }
            });
            lVarA.a(bannerAd.getContent());
        } catch (Throwable th) {
            this.presenter.a(AdError.FAIL_TO_DRAW, "Failed to create a WebView: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(l lVar, BannerAdView this$0, com.kakao.adfit.b.a bannerAd, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerAd, "$bannerAd");
        if (lVar.a()) {
            return;
        }
        this$0.webViewHolder.a(lVar);
        this$0.presenter.c(bannerAd);
    }

    public final void destroy() {
        this.presenter.r();
        f.c("Terminated AdFit Ad");
    }

    public final Bundle getExtras() {
        return this.presenter.d();
    }

    public final void loadAd() {
        this.presenter.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        f.d("onAttachedToWindow()");
        super.onAttachedToWindow();
        if (this.fieldInitialized) {
            this._isAttached = true;
            this.presenter.i();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        f.d("onDetachedFromWindow()");
        super.onDetachedFromWindow();
        if (this.fieldInitialized) {
            this._isAttached = false;
            this.presenter.i();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.fieldInitialized) {
            this.presenter.j();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        f.d("onVisibilityChanged(): " + visibility);
        super.onVisibilityChanged(changedView, visibility);
        if (this.fieldInitialized) {
            this.presenter.l();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean focus) {
        f.d("onWindowFocusChanged(): " + focus);
        super.onWindowFocusChanged(focus);
        if (this.fieldInitialized) {
            this.presenter.m();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        f.d("onWindowVisibilityChanged(): " + visibility);
        super.onWindowVisibilityChanged(visibility);
        if (this.fieldInitialized) {
            this.presenter.l();
        }
    }

    public final void pause() {
        this.presenter.n();
        l[] lVarArrB = this.webViewHolder.b();
        Intrinsics.checkNotNullExpressionValue(lVarArrB, "webViewHolder.views");
        for (l lVar : lVarArrB) {
            if (lVar != null) {
                lVar.onPause();
            }
        }
    }

    public final void putExtra(String name, String value) {
        this.presenter.a(name, value);
    }

    public final void resume() {
        this.presenter.p();
        l[] lVarArrB = this.webViewHolder.b();
        Intrinsics.checkNotNullExpressionValue(lVarArrB, "webViewHolder.views");
        for (l lVar : lVarArrB) {
            if (lVar != null) {
                lVar.onResume();
            }
        }
    }

    public final void setAdListener(AdListener listener) {
        this.presenter.a(listener);
    }

    @Deprecated(message = "Not working")
    public final void setAdUnitSize(String adSize) {
        f.e("BannerAdView#setAdUnitSize() is deprecated");
    }

    public final void setClientId(String id) {
        if (Intrinsics.areEqual(this.presenter.b(), id)) {
            return;
        }
        this.name = "BannerAdView(\"" + (id == null ? "unknown" : id) + "\")@" + hashCode();
        this.presenter.a(id);
    }

    @Deprecated(message = "Not working")
    public final void setRequestInterval(int sec) {
        f.e("BannerAdView#setRequestInterval() is deprecated");
    }

    @Override // android.view.View
    public void setTag(Object tag) {
        super.setTag(tag);
    }

    public final void setTestMode(boolean enabled) {
        this.presenter.b(enabled);
    }

    public final void setTimeout(int ms) {
        this.presenter.b(ms);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public BannerAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.name = "BannerAdView@" + hashCode();
        this.webViewHolder = new a(this);
        this.presenter = new e(new b(context, this), null, 2, 0 == true ? 1 : 0);
        this.fieldInitialized = true;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setBackground(null);
        setPadding(0, 0, 0, 0);
        if (!isInEditMode()) {
            if (!(context instanceof Activity)) {
                throw new IllegalArgumentException("Context must be Activity context!");
            }
            z.a.b(context);
            if (attributeSet != null) {
                String attributeValue = attributeSet.getAttributeValue(null, "clientId");
                if (attributeValue != null && (StringsKt.isBlank(attributeValue) ^ true)) {
                    setClientId(attributeValue);
                }
            }
            f.a(MobileAdsBridgeBase.initializeMethodName);
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setText("AdFit Ad Area");
        textView.setTextSize(j.a(context, 25.0f));
        Companion companion = INSTANCE;
        companion.a(textView, -1);
        textView.setGravity(17);
        companion.a((View) textView, Color.argb(255, 0, 153, 204));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        textView.setLayoutParams(layoutParams);
        addView(textView);
    }

    @Override // android.view.View
    public void setTag(int key, Object tag) {
        super.setTag(key, tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(l lVar, BannerAdView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (lVar.a()) {
            return;
        }
        this$0.presenter.a(AdError.FAIL_TO_DRAW, "Page Load Error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(l lVar, BannerAdView this$0, com.kakao.adfit.b.a bannerAd, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerAd, "$bannerAd");
        if (lVar.a()) {
            return;
        }
        this$0.presenter.a(bannerAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(l lVar, BannerAdView this$0, com.kakao.adfit.b.a bannerAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerAd, "$bannerAd");
        if (lVar.a()) {
            return;
        }
        this$0.webViewHolder.a();
        this$0.webViewHolder = new a(this$0);
        if (Intrinsics.areEqual(this$0.bannerAd, bannerAd)) {
            this$0.a(bannerAd);
        }
    }
}
