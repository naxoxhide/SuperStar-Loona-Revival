package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationButton extends TextView implements b {
    a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f263b;
    private float c;
    private float d;
    private float e;

    public AnimationButton(Context context) {
        super(context);
        this.a = new a();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.b
    public float getMarqueeValue() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.b
    public float getRippleValue() {
        return this.f263b;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.b
    public float getShineValue() {
        return this.c;
    }

    public float getStretchValue() {
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.a(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.a(this, i, i2);
    }

    public void setMarqueeValue(float f) {
        this.d = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.f263b = f;
        postInvalidate();
    }

    public void setShineValue(float f) {
        this.c = f;
        postInvalidate();
    }

    public void setStretchValue(float f) {
        this.e = f;
        this.a.a(this, f);
    }
}
