package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class p6 extends c7 {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f2797b;
    public final float[] c;

    public p6(Context context) {
        super(context);
        this.a = 0;
        this.f2797b = new Matrix();
        this.c = new float[2];
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.a == 0) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        int width = getWidth();
        int height = getHeight();
        canvas.clipRect(0, 0, width, height);
        try {
            ViewGroup viewGroup = (ViewGroup) getParent();
            try {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                if ((viewGroup2 instanceof ScrollView) || (viewGroup2 instanceof HorizontalScrollView)) {
                    viewGroup = viewGroup2;
                }
            } catch (Exception unused) {
            }
            int left = getLeft() - viewGroup.getScrollX();
            int top = getTop() - viewGroup.getScrollY();
            canvas.clipRect(0 - left, 0 - top, viewGroup.getWidth() - left, viewGroup.getHeight() - top);
        } catch (Exception unused2) {
        }
        canvas.rotate(this.a * 90);
        int i = this.a;
        if (i == 1) {
            canvas.translate(0.0f, -width);
        } else if (i == 2) {
            canvas.translate(-width, -height);
        } else {
            if (i != 3) {
                throw new IllegalStateException();
            }
            canvas.translate(-height, 0.0f);
        }
        this.f2797b.setRotate(this.a * (-90));
        int i2 = this.a;
        if (i2 == 1) {
            this.f2797b.postTranslate(0.0f, width - 1);
        } else if (i2 == 2) {
            this.f2797b.postTranslate(width - 1, height - 1);
        } else {
            if (i2 != 3) {
                throw new IllegalStateException();
            }
            this.f2797b.postTranslate(height - 1, 0.0f);
        }
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float[] fArr = this.c;
        fArr[0] = motionEvent.getX();
        fArr[1] = motionEvent.getY();
        this.f2797b.mapPoints(fArr);
        motionEvent.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getRotationCount() {
        return this.a;
    }

    @Override // com.tapjoy.internal.c7, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.a % 2 == 0) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i2, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void setRotationCount(int i) {
        this.a = i & 3;
    }
}
