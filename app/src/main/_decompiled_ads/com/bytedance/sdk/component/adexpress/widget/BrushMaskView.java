package com.bytedance.sdk.component.adexpress.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import com.bytedance.sdk.component.utils.m;

/* JADX INFO: loaded from: classes2.dex */
public class BrushMaskView extends View {
    private static final String j = "BrushMaskView";
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f299b;
    private Canvas c;
    private Paint d;
    private BitmapDrawable e;
    private Paint f;
    private Path g;
    private Path h;
    private Paint i;

    class a implements TimeInterpolator {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f300b;

        a(int i, int i2) {
            this.a = i;
            this.f300b = i2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) (this.a * f);
            if (BrushMaskView.this.c != null) {
                Canvas canvas = BrushMaskView.this.c;
                float f2 = this.f300b / 2;
                canvas.drawRect(0.0f, f2, i - 50, f2, BrushMaskView.this.f);
                BrushMaskView.this.c.drawCircle(i, this.f300b / 2, 10.0f, BrushMaskView.this.f);
            }
            BrushMaskView.this.postInvalidate();
            return f;
        }
    }

    public BrushMaskView(Context context) {
        super(context);
        a(context);
    }

    public void c() {
        a(getWidth(), getHeight());
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.f299b;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(a(i), a(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a(i, i2);
    }

    public void setEraserSize(float f) {
        this.f.setStrokeWidth(f);
        this.i.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.a.setColor(i);
    }

    public void setWatermark(int i) {
        if (i == -1) {
            this.e = null;
        } else {
            this.e = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }

    private void a(Context context) {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setDither(true);
        setMaskColor(-1426063361);
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setAntiAlias(true);
        this.d.setDither(true);
        Paint paint3 = new Paint();
        this.i = paint3;
        paint3.setColor(-7829368);
        this.i.setAlpha(100);
        this.i.setAntiAlias(true);
        this.i.setDither(true);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeCap(Paint.Cap.ROUND);
        if (Build.VERSION.SDK_INT >= 21) {
            setWatermark(-1);
        } else {
            setMaskColor(-1426063361);
        }
        Paint paint4 = new Paint();
        this.f = paint4;
        paint4.setAntiAlias(true);
        this.f.setDither(true);
        this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeCap(Paint.Cap.ROUND);
        setEraserSize(60.0f);
        this.g = new Path();
        this.h = new Path();
    }

    public void b(float f, float f2) {
        a(f, f2);
        invalidate();
    }

    public void b() {
        int width = getWidth();
        int height = getHeight();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(400L);
        valueAnimator.setIntValues(0, width);
        valueAnimator.setInterpolator(new a(width, height));
        valueAnimator.start();
    }

    private void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.f299b = bitmapCreateBitmap;
            Canvas canvas = this.c;
            if (canvas == null) {
                this.c = new Canvas(this.f299b);
            } else {
                canvas.setBitmap(bitmapCreateBitmap);
            }
            this.c.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.a);
            if (this.e != null) {
                this.e.setBounds(new Rect(0, 0, i, i2));
                this.e.draw(this.c);
            }
        } catch (Exception e) {
            m.b(j, e.getMessage());
        }
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }

    private void a(float f, float f2) {
        this.g.reset();
        this.h.reset();
        this.g.moveTo(f, f2);
        this.h.moveTo(f, f2);
    }

    public void a() {
        b();
    }
}
