package com.tnkfactory.ad.pub.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.shapes.Shape;

/* JADX INFO: loaded from: classes4.dex */
public final class v {

    public static class a extends GradientDrawable {
        public ColorStateList a = null;

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public final boolean isStateful() {
            return this.a != null;
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public final boolean onStateChange(int[] iArr) {
            ColorStateList colorStateList = this.a;
            if (colorStateList == null) {
                return false;
            }
            setColor(colorStateList.getColorForState(iArr, 0));
            return true;
        }

        @Override // android.graphics.drawable.GradientDrawable
        public final void setColor(ColorStateList colorStateList) {
            this.a = colorStateList;
            if (colorStateList == null) {
                setColor(0);
            } else {
                setColor(this.a.getColorForState(getState(), 0));
            }
        }
    }

    public static class b extends Shape {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2892b;
        public Path c = new Path();
        public Paint d = new Paint(1);
        public Paint e = new Paint(1);
        public int f;

        public b(float f, int i, int i2, int i3, int i4) {
            this.f2892b = f;
            this.a = i;
            this.d.setStyle(Paint.Style.FILL);
            this.d.setColor(i2);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setColor(i3);
            this.f = i4;
        }

        @Override // android.graphics.drawable.shapes.Shape
        public final Shape clone() {
            return new b(this.f2892b, this.a, this.d.getColor(), this.e.getColor(), this.f);
        }

        @Override // android.graphics.drawable.shapes.Shape
        public final void draw(Canvas canvas, Paint paint) {
            float width = canvas.getWidth();
            float height = canvas.getHeight();
            int i = this.a;
            int i2 = (int) (width / i);
            if (height < i2) {
                i2 = (int) height;
            }
            float f = i2;
            int i3 = ((int) (height - f)) / 2;
            int i4 = i * i2;
            int i5 = (int) (i4 * this.f2892b);
            int i6 = (i2 + i3) - 2;
            int i7 = 0;
            canvas.drawRect(new Rect(0, i3, i5, i6), this.d);
            canvas.drawRect(new Rect(i5, i3, i4, i6), this.e);
            float f2 = f / 2.0f;
            float f3 = i3 + f2;
            float f4 = 0.98f * f * 0.5f;
            float f5 = 0.4f * f4;
            double d = 6.283185307179586d / ((double) 5);
            this.c.reset();
            this.c.setFillType(Path.FillType.INVERSE_WINDING);
            while (i7 < this.a) {
                double d2 = f2;
                float f6 = f3;
                double d3 = f4;
                double d4 = d;
                double d5 = f6;
                this.c.moveTo((float) ((Math.cos(-1.5707999467849731d) * d3) + d2), (float) ((Math.sin(-1.5707999467849731d) * d3) + d5));
                double d6 = f5;
                double d7 = d4 / 2.0d;
                double d8 = d7 - 1.5707999467849731d;
                float f7 = f4;
                float f8 = f5;
                int i8 = i7;
                this.c.lineTo((float) ((Math.cos(d8) * d6) + d2), (float) ((Math.sin(d8) * d6) + d5));
                int i9 = 1;
                while (i9 < 5) {
                    double d9 = (((double) i9) * d4) - 1.5707999467849731d;
                    this.c.lineTo((float) ((Math.cos(d9) * d3) + d2), (float) ((Math.sin(d9) * d3) + d5));
                    double d10 = d9 + d7;
                    this.c.lineTo((float) ((Math.cos(d10) * d6) + d2), (float) ((Math.sin(d10) * d6) + d5));
                    i9++;
                    f7 = f7;
                    f = f;
                    f2 = f2;
                    d3 = d3;
                }
                this.c.close();
                f2 += f;
                i7 = i8 + 1;
                f4 = f7;
                f3 = f6;
                f5 = f8;
                d = d4;
            }
            paint.setColor(this.f);
            canvas.drawPath(this.c, paint);
        }

        @Override // android.graphics.drawable.shapes.Shape
        public final Object clone() {
            return new b(this.f2892b, this.a, this.d.getColor(), this.e.getColor(), this.f);
        }
    }

    public static GradientDrawable a(int i, int i2, int i3) {
        return i == 0 ? new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i2, i3}) : new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i2, i3});
    }
}
