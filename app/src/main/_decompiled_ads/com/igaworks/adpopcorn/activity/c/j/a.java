package com.igaworks.adpopcorn.activity.c.j;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class a extends View {
    private BlurMaskFilter.Blur A;
    private final RectF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f1574b;
    private final Rect c;
    private final Paint d;
    private final Paint e;
    private final Paint f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private int l;
    private float m;
    private float n;
    private float o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private c v;
    private int w;
    private int x;
    private Paint.Cap y;
    private int z;

    private static final class b implements c {
        private b() {
        }

        @Override // com.igaworks.adpopcorn.activity.c.j.a.c
        public CharSequence a(int i, int i2) {
            return "";
        }
    }

    public interface c {
        CharSequence a(int i, int i2);
    }

    private static final class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new C0426a();
        int a;

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.c.j.a$d$a, reason: collision with other inner class name */
        class C0426a implements Parcelable.Creator<d> {
            C0426a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        private d(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    public a(Context context, int i) {
        this(context, null, i);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.a = new RectF();
        this.f1574b = new RectF();
        this.c = new Rect();
        this.d = new Paint(1);
        this.e = new Paint(1);
        this.f = new TextPaint(1);
        this.k = 100;
        this.v = new b();
        a(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setTextSize(this.o);
        this.d.setStyle(this.w == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.d.setStrokeWidth(this.n);
        this.d.setColor(this.p);
        this.d.setStrokeCap(this.y);
        b();
        this.e.setStyle(this.w == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.e.setStrokeWidth(this.n);
        this.e.setColor(this.s);
        this.e.setStrokeCap(this.y);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.l = 45;
        this.w = 0;
        this.x = 0;
        this.y = Paint.Cap.BUTT;
        this.m = 10.0f;
        this.o = 11.0f;
        this.n = com.igaworks.adpopcorn.cores.common.d.a(context, i);
        this.p = Color.parseColor("#fff2a670");
        this.q = Color.parseColor("#fff2a670");
        this.r = Color.parseColor("#fff2a670");
        this.s = Color.parseColor("#ffe3e3e5");
        this.t = -90;
        this.u = true;
        this.z = 0;
        this.A = BlurMaskFilter.Blur.NORMAL;
    }

    private void a(Canvas canvas) {
        int i = this.l;
        float f = (float) (6.283185307179586d / ((double) i));
        float f2 = this.g;
        float f3 = f2 - this.m;
        int i2 = (int) ((this.j / this.k) * i);
        for (int i3 = 0; i3 < this.l; i3++) {
            double d2 = i3 * (-f);
            float fCos = (((float) Math.cos(d2)) * f3) + this.h;
            float fSin = this.i - (((float) Math.sin(d2)) * f3);
            float fCos2 = this.h + (((float) Math.cos(d2)) * f2);
            float fSin2 = this.i - (((float) Math.sin(d2)) * f2);
            if (!this.u || i3 >= i2) {
                canvas.drawLine(fCos, fSin, fCos2, fSin2, this.e);
            }
            if (i3 < i2) {
                canvas.drawLine(fCos, fSin, fCos2, fSin2, this.d);
            }
        }
    }

    private void b() {
        Paint paint;
        BlurMaskFilter blurMaskFilter;
        if (this.A == null || this.z <= 0) {
            paint = this.d;
            blurMaskFilter = null;
        } else {
            setLayerType(1, this.d);
            paint = this.d;
            blurMaskFilter = new BlurMaskFilter(this.z, this.A);
        }
        paint.setMaskFilter(blurMaskFilter);
    }

    private void b(Canvas canvas) {
        int i = this.w;
        if (i == 1) {
            e(canvas);
        } else if (i != 2) {
            a(canvas);
        } else {
            d(canvas);
        }
    }

    private void c() {
        Shader linearGradient = null;
        if (this.p == this.q) {
            this.d.setShader(null);
            this.d.setColor(this.p);
            return;
        }
        int i = this.x;
        if (i == 0) {
            RectF rectF = this.a;
            float f = rectF.left;
            linearGradient = new LinearGradient(f, rectF.top, f, rectF.bottom, this.p, this.q, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, this.h, this.i);
            linearGradient.setLocalMatrix(matrix);
        } else if (i == 1) {
            linearGradient = new RadialGradient(this.h, this.i, this.g, this.p, this.q, Shader.TileMode.CLAMP);
        } else if (i == 2) {
            float f2 = (float) (-((this.y == Paint.Cap.BUTT && this.w == 2) ? 0.0d : Math.toDegrees((float) (((((double) this.n) / 3.141592653589793d) * 2.0d) / ((double) this.g)))));
            linearGradient = new SweepGradient(this.h, this.i, new int[]{this.p, this.q}, new float[]{0.0f, 1.0f});
            Matrix matrix2 = new Matrix();
            matrix2.setRotate(f2, this.h, this.i);
            linearGradient.setLocalMatrix(matrix2);
        }
        this.d.setShader(linearGradient);
    }

    private void c(Canvas canvas) {
        c cVar = this.v;
        if (cVar == null) {
            return;
        }
        CharSequence charSequenceA = cVar.a(this.j, this.k);
        if (TextUtils.isEmpty(charSequenceA)) {
            return;
        }
        this.f.setTextSize(this.o);
        this.f.setColor(this.r);
        this.f.getTextBounds(String.valueOf(charSequenceA), 0, charSequenceA.length(), this.c);
        canvas.drawText(charSequenceA, 0, charSequenceA.length(), this.h, this.i + (this.c.height() / 2), this.f);
    }

    private void d(Canvas canvas) {
        if (this.u) {
            float f = (this.j * 360.0f) / this.k;
            canvas.drawArc(this.a, f, 360.0f - f, false, this.e);
        } else {
            canvas.drawArc(this.a, 0.0f, 360.0f, false, this.e);
        }
        canvas.drawArc(this.a, 0.0f, (this.j * 360.0f) / this.k, false, this.d);
    }

    private void e(Canvas canvas) {
        if (this.u) {
            float f = (this.j * 360.0f) / this.k;
            canvas.drawArc(this.a, f, 360.0f - f, true, this.e);
        } else {
            canvas.drawArc(this.a, 0.0f, 360.0f, true, this.e);
        }
        canvas.drawArc(this.a, 0.0f, (this.j * 360.0f) / this.k, true, this.d);
    }

    public int getMax() {
        return this.k;
    }

    public int getProgress() {
        return this.j;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.t, this.h, this.i);
        b(canvas);
        canvas.restore();
        c(canvas);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setProgress(dVar.a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.a = this.j;
        return dVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1574b.left = getPaddingLeft();
        this.f1574b.top = getPaddingTop();
        this.f1574b.right = i - getPaddingRight();
        this.f1574b.bottom = i2 - getPaddingBottom();
        this.h = this.f1574b.centerX();
        this.i = this.f1574b.centerY();
        this.g = Math.min(this.f1574b.width(), this.f1574b.height()) / 2.0f;
        this.a.set(this.f1574b);
        c();
        RectF rectF = this.a;
        float f = this.n / 2.0f;
        rectF.inset(f, f);
    }

    public void setBlurRadius(int i) {
        this.z = i;
        b();
        invalidate();
    }

    public void setBlurStyle(BlurMaskFilter.Blur blur) {
        this.A = blur;
        b();
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.y = cap;
        this.d.setStrokeCap(cap);
        this.e.setStrokeCap(cap);
        invalidate();
    }

    public void setDrawBackgroundOutsideProgress(boolean z) {
        this.u = z;
        invalidate();
    }

    public void setLineCount(int i) {
        this.l = i;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.m = f;
        invalidate();
    }

    public void setMax(int i) {
        this.k = i;
        invalidate();
    }

    public void setProgress(int i) {
        this.j = i;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.s = i;
        this.e.setColor(i);
        invalidate();
    }

    public void setProgressEndColor(int i) {
        this.q = i;
        c();
        invalidate();
    }

    public void setProgressFormatter(c cVar) {
        this.v = cVar;
        invalidate();
    }

    public void setProgressStartColor(int i) {
        this.p = i;
        c();
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.n = f;
        this.a.set(this.f1574b);
        c();
        RectF rectF = this.a;
        float f2 = this.n / 2.0f;
        rectF.inset(f2, f2);
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.r = i;
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.o = f;
        invalidate();
    }

    public void setShader(int i) {
        this.x = i;
        c();
        invalidate();
    }

    public void setStartDegree(int i) {
        this.t = i;
        invalidate();
    }

    public void setStyle(int i) {
        this.w = i;
        this.d.setStyle(i == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.e.setStyle(this.w == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }
}
