package com.kakao.adfit.ads.na;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakao.adfit.ads.R;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tapjoy.TJAdUnitConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdFitNativeAdView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003'B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0006¢\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0014J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0014J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J0\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0014J$\u0010\u001c\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010%\u001a\u00020!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00068"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdView;", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout$LayoutParams;", "a", "", "dp", "", "", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/view/View;", "changedView", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "onVisibilityChanged", "onWindowVisibilityChanged", "", "hasWindowFocus", "onWindowFocusChanged", "changed", "left", "top", "right", TJAdUnitConstants.String.BOTTOM, "onLayout", "child", FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "view", "removeView", "removeAllViews", "bringChildToFront", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$a;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$a;", "getDelegate$library_networkRelease", "()Lcom/kakao/adfit/ads/na/AdFitNativeAdView$a;", "delegate", "Landroid/widget/ImageView;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/widget/ImageView;", "adInfoIconView", "c", "Z", "_isAttached", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$b;", "onViewStateChangedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public class AdFitNativeAdView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a delegate;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ImageView adInfoIconView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean _isAttached;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private b onViewStateChangedListener;

    /* JADX INFO: compiled from: AdFitNativeAdView.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdView$a;", "", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "a", "", "c", "()I", "width", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "height", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Z", "isAttached", "isVisible", InneractiveMediationDefs.GENDER_FEMALE, "isWindowVisible", "hasWindowFocus", "Landroid/widget/ImageView;", "g", "()Landroid/widget/ImageView;", "adInfoIconView", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public interface a {
        void a(b listener);

        boolean a();

        boolean b();

        int c();

        int d();

        boolean f();

        ImageView g();

        boolean isVisible();
    }

    /* JADX INFO: compiled from: AdFitNativeAdView.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdView$b;", "", "", "e", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    /* JADX INFO: compiled from: AdFitNativeAdView.kt */
    @Metadata(bv = {}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"com/kakao/adfit/ads/na/AdFitNativeAdView$c", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$a;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView$b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "a", "", "c", "()I", "width", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "height", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Z", "isAttached", "isVisible", InneractiveMediationDefs.GENDER_FEMALE, "isWindowVisible", "hasWindowFocus", "Landroid/widget/ImageView;", "g", "()Landroid/widget/ImageView;", "adInfoIconView", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class c implements a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f1690b;

        c(Context context) {
            this.f1690b = context;
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.a
        public boolean a() {
            return AdFitNativeAdView.this.hasWindowFocus();
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.a
        public boolean b() {
            return AdFitNativeAdView.this._isAttached && AdFitNativeAdView.this.isAttachedToWindow();
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.a
        public int c() {
            return AdFitNativeAdView.this.getMeasuredWidth();
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.a
        public int d() {
            return AdFitNativeAdView.this.getMeasuredHeight();
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.a
        public boolean f() {
            return AdFitNativeAdView.this.getWindowVisibility() == 0;
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.a
        public ImageView g() {
            ImageView imageView = AdFitNativeAdView.this.adInfoIconView;
            if (imageView != null) {
                return imageView;
            }
            ImageView imageView2 = new ImageView(this.f1690b);
            imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView2.setImageResource(R.drawable.adfit_icon_ad_info);
            AdFitNativeAdView.this.adInfoIconView = imageView2;
            AdFitNativeAdView adFitNativeAdView = AdFitNativeAdView.this;
            adFitNativeAdView.addView(imageView2, adFitNativeAdView.a());
            return imageView2;
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.a
        public boolean isVisible() {
            return AdFitNativeAdView.this.getVisibility() == 0;
        }

        @Override // com.kakao.adfit.ads.na.AdFitNativeAdView.a
        public void a(b listener) {
            AdFitNativeAdView.this.onViewStateChangedListener = listener;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFitNativeAdView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFitNativeAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdFitNativeAdView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout.LayoutParams a() {
        int iA = a(3.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        layoutParams.setMargins(iA, iA, iA, iA);
        return layoutParams;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        super.bringChildToFront(this.adInfoIconView);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        ImageView imageView = this.adInfoIconView;
        if (imageView != view) {
            super.bringChildToFront(imageView);
        }
    }

    /* JADX INFO: renamed from: getDelegate$library_networkRelease, reason: from getter */
    public final a getDelegate() {
        return this.delegate;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this._isAttached = true;
        b bVar = this.onViewStateChangedListener;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this._isAttached = false;
        b bVar = this.onViewStateChangedListener;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        b bVar = this.onViewStateChangedListener;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        b bVar = this.onViewStateChangedListener;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        b bVar = this.onViewStateChangedListener;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        b bVar = this.onViewStateChangedListener;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.adInfoIconView, a());
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.adInfoIconView != view) {
            super.removeView(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFitNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.delegate = new c(context);
        if (!isInEditMode() && !(context instanceof Activity)) {
            throw new IllegalArgumentException("Context must be Activity context!");
        }
    }

    private final int a(float dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }
}
