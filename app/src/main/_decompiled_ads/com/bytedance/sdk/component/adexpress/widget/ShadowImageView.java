package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowImageView extends ImageView {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RectF f315b;

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f315b;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f315b.right == getMeasuredWidth() && this.f315b.bottom == getMeasuredHeight()) {
            return;
        }
        this.f315b.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
