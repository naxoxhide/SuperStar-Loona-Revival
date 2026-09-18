package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class NiceImageView extends PAGImageView {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f425b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Xfermode n;
    private int o;
    private int p;
    private float q;
    private float[] r;
    private float[] s;
    private RectF t;
    private RectF u;
    private Paint v;
    private Path w;
    private Path x;

    public NiceImageView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        if (!this.f425b) {
            int i = this.d;
            if (i > 0) {
                a(canvas, i, this.e, this.u, this.r);
                return;
            }
            return;
        }
        int i2 = this.d;
        if (i2 > 0) {
            a(canvas, i2, this.e, this.q - (i2 / 2.0f));
        }
        int i3 = this.f;
        if (i3 > 0) {
            a(canvas, i3, this.g, (this.q - this.d) - (i3 / 2.0f));
        }
    }

    private void b() {
        if (this.f425b) {
            return;
        }
        this.f = 0;
    }

    private void c() {
        if (this.f425b) {
            return;
        }
        RectF rectF = this.u;
        float f = this.d / 2.0f;
        rectF.set(f, f, this.o - f, this.p - f);
    }

    private void d() {
        if (!this.f425b) {
            this.t.set(0.0f, 0.0f, this.o, this.p);
            if (this.c) {
                this.t = this.u;
                return;
            }
            return;
        }
        float fMin = Math.min(this.o, this.p) / 2.0f;
        this.q = fMin;
        RectF rectF = this.t;
        float f = this.o / 2.0f;
        float f2 = this.p / 2.0f;
        rectF.set(f - fMin, f2 - fMin, f + fMin, f2 + fMin);
    }

    public void isCircle(boolean z) {
        this.f425b = z;
        b();
        d();
        invalidate();
    }

    public void isCoverSrc(boolean z) {
        this.c = z;
        d();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.t, null, 31);
        if (!this.c) {
            int i = this.o;
            int i2 = this.d * 2;
            int i3 = this.f * 2;
            float f = ((i - i2) - i3) * 1.0f;
            float f2 = i;
            int i4 = this.p;
            float f3 = ((i4 - i2) - i3) * 1.0f;
            float f4 = i4;
            canvas.scale(f / f2, f3 / f4, f2 / 2.0f, f4 / 2.0f);
        }
        super.onDraw(canvas);
        this.v.reset();
        this.w.reset();
        if (this.f425b) {
            this.w.addCircle(this.o / 2.0f, this.p / 2.0f, this.q, Path.Direction.CCW);
        } else {
            this.w.addRoundRect(this.t, this.s, Path.Direction.CCW);
        }
        this.v.setAntiAlias(true);
        this.v.setStyle(Paint.Style.FILL);
        this.v.setXfermode(this.n);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.w, this.v);
        } else {
            this.x.addRect(this.t, Path.Direction.CCW);
            this.x.op(this.w, Path.Op.DIFFERENCE);
            canvas.drawPath(this.x, this.v);
        }
        this.v.setXfermode(null);
        int i5 = this.m;
        if (i5 != 0) {
            this.v.setColor(i5);
            canvas.drawPath(this.w, this.v);
        }
        canvas.restore();
        a(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.o = i;
        this.p = i2;
        c();
        d();
    }

    public void setBorderColor(int i) {
        this.e = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.d = b0.a(this.a, i);
        a(false);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.k = b0.a(this.a, i);
        a(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.l = b0.a(this.a, i);
        a(true);
    }

    public void setCornerRadius(int i) {
        this.h = b0.a(this.a, i);
        a(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.i = b0.a(this.a, i);
        a(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.j = b0.a(this.a, i);
        a(true);
    }

    public void setInnerBorderColor(int i) {
        this.g = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.f = b0.a(this.a, i);
        b();
        invalidate();
    }

    public void setMaskColor(int i) {
        this.m = i;
        invalidate();
    }

    public NiceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        this.g = -1;
        this.a = context;
        this.h = b0.a(context, 10.0f);
        this.r = new float[8];
        this.s = new float[8];
        this.u = new RectF();
        this.t = new RectF();
        this.v = new Paint();
        this.w = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.x = new Path();
        }
        a();
        b();
    }

    private void a(Canvas canvas, int i, int i2, float f) {
        a(i, i2);
        this.w.addCircle(this.o / 2.0f, this.p / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.w, this.v);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        a(i, i2);
        this.w.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.w, this.v);
    }

    private void a(int i, int i2) {
        this.w.reset();
        this.v.setStrokeWidth(i);
        this.v.setColor(i2);
        this.v.setStyle(Paint.Style.STROKE);
    }

    private void a() {
        if (this.f425b) {
            return;
        }
        int i = 0;
        if (this.h <= 0) {
            float[] fArr = this.r;
            float f = this.i;
            fArr[1] = f;
            fArr[0] = f;
            float f2 = this.j;
            fArr[3] = f2;
            fArr[2] = f2;
            float f3 = this.l;
            fArr[5] = f3;
            fArr[4] = f3;
            float f4 = this.k;
            fArr[7] = f4;
            fArr[6] = f4;
            float[] fArr2 = this.s;
            float f5 = this.d / 2.0f;
            float f6 = f - f5;
            fArr2[1] = f6;
            fArr2[0] = f6;
            float f7 = f2 - f5;
            fArr2[3] = f7;
            fArr2[2] = f7;
            float f8 = f3 - f5;
            fArr2[5] = f8;
            fArr2[4] = f8;
            float f9 = f4 - f5;
            fArr2[7] = f9;
            fArr2[6] = f9;
            return;
        }
        while (true) {
            float[] fArr3 = this.r;
            if (i >= fArr3.length) {
                return;
            }
            float f10 = this.h;
            fArr3[i] = f10;
            this.s[i] = f10 - (this.d / 2.0f);
            i++;
        }
    }

    private void a(boolean z) {
        if (z) {
            this.h = 0;
        }
        a();
        c();
        invalidate();
    }
}
