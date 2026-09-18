package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import b.b.a.a.d.d.h.g;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationImageView extends ImageView implements b {
    a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f264b;
    private float c;
    private float d;
    private float e;
    private g f;

    public AnimationImageView(Context context) {
        super(context);
        this.a = new a();
    }

    public g getBrickNativeValue() {
        return this.f;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.b
    public float getMarqueeValue() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.b
    public float getRippleValue() {
        return this.f264b;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.b
    public float getShineValue() {
        return this.c;
    }

    public float getStretchValue() {
        return this.e;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        g gVar;
        super.onDraw(canvas);
        this.a.a(canvas, this, this);
        if (getRippleValue() == 0.0f || (gVar = this.f) == null || gVar.L() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.a(this, i, i2);
    }

    public void setBrickNativeValue(g gVar) {
        this.f = gVar;
    }

    public void setMarqueeValue(float f) {
        this.d = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.f264b = f;
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
