package com.kakao.adfit.ads.na;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.ads.R;
import com.kakao.adfit.k.e0;
import com.kakao.adfit.k.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AdFitBizBoardAdTemplateLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0003¢\u0006\u0004\b/\u00100J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0014J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b\u0007\u0010#R$\u0010)\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00061"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitBizBoardAdTemplateLayout;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView;", "Lcom/kakao/adfit/ads/na/AdFitNativeAdTemplateLayout;", "", "w", "h", "", "setContentAspectRatio", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/view/View;", "view", "removeView", "removeAllViews", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "e", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "getNativeAdLayout", "()Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "nativeAdLayout", "Lcom/kakao/adfit/ads/na/AdFitMediaView;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/ads/na/AdFitMediaView;", "getMediaView", "()Lcom/kakao/adfit/ads/na/AdFitMediaView;", "mediaView", "Lcom/kakao/adfit/k/e0;", "g", "Lcom/kakao/adfit/k/e0;", "measureSpecCalculator", "value", "getContentAspectRatio", "()F", "(F)V", "contentAspectRatio", "getContentMaxHeight", "()I", "setContentMaxHeight", "(I)V", "contentMaxHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class AdFitBizBoardAdTemplateLayout extends AdFitNativeAdView implements AdFitNativeAdTemplateLayout {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final AdFitNativeAdLayout nativeAdLayout;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final AdFitMediaView mediaView;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final e0 measureSpecCalculator;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFitBizBoardAdTemplateLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFitBizBoardAdTemplateLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdFitBizBoardAdTemplateLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final float getContentAspectRatio() {
        return this.measureSpecCalculator.getAspectRatio();
    }

    public final int getContentMaxHeight() {
        return this.measureSpecCalculator.getMaxHeight();
    }

    public final AdFitMediaView getMediaView() {
        return this.mediaView;
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdTemplateLayout
    public AdFitNativeAdLayout getNativeAdLayout() {
        return this.nativeAdLayout;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        e0 e0Var = this.measureSpecCalculator;
        e0Var.a(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(e0Var.getWidthSpec(), e0Var.getHeightSpec());
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdView, android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.mediaView);
    }

    @Override // com.kakao.adfit.ads.na.AdFitNativeAdView, android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mediaView != view) {
            super.removeView(view);
        }
    }

    public final void setContentAspectRatio(float f) {
        this.measureSpecCalculator.a(f);
    }

    public final void setContentMaxHeight(int i) {
        this.measureSpecCalculator.a(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFitBizBoardAdTemplateLayout(Context context, AttributeSet attributeSet, int i) {
        String string;
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        AdFitMediaView adFitMediaView = new AdFitMediaView(context, null, 0, 6, null);
        this.mediaView = adFitMediaView;
        e0 e0Var = new e0(this, 3.988372f, 0, 0, 4, null);
        this.measureSpecCalculator = e0Var;
        this.nativeAdLayout = new AdFitNativeAdLayout.Builder(this).setMediaView(adFitMediaView).build();
        addView(adFitMediaView, new FrameLayout.LayoutParams(-1, -2, 17));
        if (attributeSet == null) {
            if (getBackground() == null) {
                int iRgb = Color.rgb(243, 243, 243);
                float fA = j.a(context, 5.0f);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(iRgb);
                gradientDrawable.setCornerRadius(fA);
                setBackground(gradientDrawable);
                return;
            }
            return;
        }
        boolean z = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdFitBizBoardAdTemplateLayout, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…plateLayout, defStyle, 0)");
        if (getBackground() == null) {
            int iRgb2 = Color.rgb(243, 243, 243);
            iRgb2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AdFitBizBoardAdTemplateLayout_adfit_backgroundColor) ? typedArrayObtainStyledAttributes.getColor(R.styleable.AdFitBizBoardAdTemplateLayout_adfit_backgroundColor, iRgb2) : iRgb2;
            float fA2 = j.a(context, 5.0f);
            fA2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AdFitBizBoardAdTemplateLayout_adfit_backgroundCornerRadius) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AdFitBizBoardAdTemplateLayout_adfit_backgroundCornerRadius, fA2) : fA2;
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(iRgb2);
            gradientDrawable2.setCornerRadius(fA2);
            setBackground(gradientDrawable2);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AdFitBizBoardAdTemplateLayout_adfit_contentAspectRatio) && (string = typedArrayObtainStyledAttributes.getString(R.styleable.AdFitBizBoardAdTemplateLayout_adfit_contentAspectRatio)) != null) {
            List listSplit$default = StringsKt.split$default((CharSequence) string, new char[]{':'}, false, 0, 6, (Object) null);
            if (listSplit$default.size() == 2) {
                try {
                    e0Var.a(Float.parseFloat((String) listSplit$default.get(0)), Float.parseFloat((String) listSplit$default.get(1)));
                    z = true;
                } catch (NumberFormatException unused) {
                }
            }
            if (!z) {
                throw new UnsupportedOperationException("Can't convert value at index " + R.styleable.AdFitBizBoardAdTemplateLayout_adfit_contentAspectRatio + " to aspect ratio.");
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AdFitBizBoardAdTemplateLayout_adfit_contentMaxHeight)) {
            e0 e0Var2 = this.measureSpecCalculator;
            e0Var2.a(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.AdFitBizBoardAdTemplateLayout_adfit_contentMaxHeight, e0Var2.getMaxHeight()));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void setContentAspectRatio(int w, int h) {
        this.measureSpecCalculator.c(w, h);
    }

    public final void setContentAspectRatio(float w, float h) {
        this.measureSpecCalculator.a(w, h);
    }
}
