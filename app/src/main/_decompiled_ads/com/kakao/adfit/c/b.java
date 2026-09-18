package com.kakao.adfit.c;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.kakao.adfit.k.e0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageMediaView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/c/b;", "Landroid/widget/ImageView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Lcom/kakao/adfit/k/e0;", "a", "Lcom/kakao/adfit/k/e0;", "measureSpecCalculator", "", "value", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "aspectRatio", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class b extends ImageView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 measureSpecCalculator;

    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final float getAspectRatio() {
        return this.measureSpecCalculator.getAspectRatio();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        e0 e0Var = this.measureSpecCalculator;
        e0Var.a(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(e0Var.getWidthSpec(), e0Var.getHeightSpec());
    }

    public final void setAspectRatio(float f) {
        this.measureSpecCalculator.a(f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.measureSpecCalculator = new e0(this, 0.0f, 0, 0, 14, null);
    }
}
