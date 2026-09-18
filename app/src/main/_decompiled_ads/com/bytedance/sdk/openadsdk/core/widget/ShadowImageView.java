package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowImageView extends PAGImageView {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RectF f692b;

    public ShadowImageView(Context context) {
        super(context);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setColor(Color.parseColor("#99333333"));
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(0.0f);
        this.f692b = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f692b;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f692b.right == getMeasuredWidth() && this.f692b.bottom == getMeasuredHeight()) {
            return;
        }
        this.f692b.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
