package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes4.dex */
public final class r0 extends View {
    public float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2887b;
    public float c;
    public Paint d;
    public Paint e;
    public Paint f;
    public int g;
    public int h;
    public int i;

    public r0(Context context, int i) {
        super(context);
        this.i = i;
        this.d = new Paint(1);
        this.e = new Paint(1);
        this.f = new Paint(1);
        this.e.setStyle(Paint.Style.FILL);
        this.f.setStyle(Paint.Style.FILL);
        this.d.setStyle(Paint.Style.STROKE);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.c = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        float fApplyDimension = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.a = fApplyDimension;
        float f = this.c;
        this.f2887b = fApplyDimension - (0.5f * f);
        this.d.setStrokeWidth(f);
        this.e.setColor(-1);
        this.f.setColor(ViewCompat.MEASURED_SIZE_MASK);
        this.d.setColor(-4473925);
    }

    public final int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        float f = this.h * 3;
        float f2 = this.a;
        return (int) (((f * f2) - f2) + 10.0f);
    }

    public final int b(int i) {
        return View.MeasureSpec.getMode(i) == 1073741824 ? View.MeasureSpec.getSize(i) : (int) ((this.a * 2.0f) + 10.0f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int height;
        float f;
        Paint paint;
        super.onDraw(canvas);
        if (this.i == 1) {
            width = getHeight();
            height = getWidth();
        } else {
            width = getWidth();
            height = getHeight();
        }
        float f2 = height / 2.0f;
        float f3 = this.a;
        float f4 = ((width - (((this.h * f3) * 3.0f) - f3)) / 2.0f) + f3;
        float strokeWidth = this.f2887b - (this.d.getStrokeWidth() * 0.5f);
        for (int i = 0; i < this.h; i++) {
            float f5 = this.a;
            float f6 = (i * f5 * 3.0f) + f4;
            if (this.i == 1) {
                f = f6;
                f6 = f2;
            } else {
                f = f2;
            }
            if (i == this.g) {
                paint = this.e;
            } else {
                if (this.f.getAlpha() > 0) {
                    canvas.drawCircle(f6, f, strokeWidth, this.f);
                }
                f5 = this.f2887b;
                paint = this.d;
            }
            canvas.drawCircle(f6, f, f5, paint);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int iA;
        int iB;
        if (this.i == 1) {
            iA = b(i);
            iB = a(i2);
        } else {
            iA = a(i);
            iB = b(i2);
        }
        setMeasuredDimension(iA, iB);
    }

    public void setCount(int i) {
        this.h = i;
    }

    public void setLineColor(int i) {
        this.d.setColor(i);
    }

    public void setLineWidth(float f) {
        this.c = f;
        this.d.setStrokeWidth(f);
        this.f2887b = this.a - (this.c * 0.5f);
    }

    public void setOffFillColor(int i) {
        this.f.setColor(i);
    }

    public void setOffRadius(float f) {
        this.f2887b = f;
    }

    public void setOnFillColor(int i) {
        this.e.setColor(i);
    }

    public void setRadius(float f) {
        this.a = f;
        this.f2887b = f - (this.c * 0.5f);
    }
}
