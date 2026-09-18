package com.mbridge.msdk.video.dynview.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* JADX INFO: compiled from: BackgroundDrawable.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends ShapeDrawable {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2487b;
    private float c;
    private int d;
    private int e;
    private Bitmap f;
    private Bitmap g;
    private boolean h;
    private Paint i;
    private Matrix j;

    /* JADX INFO: compiled from: BackgroundDrawable.java */
    public interface b {
        b a(Bitmap bitmap);

        b a(boolean z);

        b b(float f);

        b b(Bitmap bitmap);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    private a(C0517a c0517a) {
        super(c0517a.a);
        this.h = false;
        this.f = c0517a.f2488b;
        this.g = c0517a.c;
        this.h = c0517a.d;
        this.a = c0517a.e;
        this.d = c0517a.f;
        this.e = c0517a.g;
        this.f2487b = c0517a.h;
        this.c = c0517a.i;
        Paint paint = new Paint();
        this.i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.i.setAntiAlias(true);
        this.j = new Matrix();
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.a == 1) {
            float f = this.c / 2.0f;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (this.d + f) - this.e);
            path.lineTo(this.f2487b, (f - this.d) - this.e);
            path.lineTo(this.f2487b, 0.0f);
            if (this.h) {
                try {
                    a(canvas, path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Bitmap bitmap = this.f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        a(canvas, path, this.f);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, this.d + f + this.e);
            path2.lineTo(0.0f, this.c);
            path2.lineTo(this.f2487b, this.c);
            path2.lineTo(this.f2487b, (f - this.d) + this.e);
            if (this.h) {
                try {
                    a(canvas, path2);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            Bitmap bitmap2 = this.g;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            try {
                a(canvas, path2, this.g);
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        float f2 = this.f2487b / 2.0f;
        Path path3 = new Path();
        path3.moveTo(0.0f, 0.0f);
        path3.lineTo(0.0f, this.c);
        path3.lineTo((f2 - this.d) - this.e, this.c);
        path3.lineTo((this.d + f2) - this.e, 0.0f);
        if (this.h) {
            try {
                a(canvas, path3);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } else {
            Bitmap bitmap3 = this.f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                try {
                    a(canvas, path3, this.f);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
        Path path4 = new Path();
        path4.moveTo(this.d + f2 + this.e, 0.0f);
        path4.lineTo(this.f2487b, 0.0f);
        path4.lineTo(this.f2487b, this.c);
        path4.lineTo((f2 - this.d) + this.e, this.c);
        if (this.h) {
            try {
                a(canvas, path4);
                return;
            } catch (Exception e7) {
                e7.printStackTrace();
                return;
            }
        }
        Bitmap bitmap4 = this.g;
        if (bitmap4 == null || bitmap4.isRecycled()) {
            return;
        }
        try {
            a(canvas, path4, this.g);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        if (canvas == null || path == null || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
            float fMax = Math.max(this.f2487b / bitmap.getWidth(), this.c / bitmap.getHeight());
            if (this.j == null) {
                this.j = new Matrix();
            }
            this.j.reset();
            this.j.preScale(fMax, fMax);
        }
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(this.j);
        this.i.setShader(bitmapShader);
        canvas.drawPath(path, this.i);
    }

    private void a(Canvas canvas, Path path) {
        this.i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.i);
    }

    public static C0517a a() {
        return new C0517a();
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.video.dynview.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BackgroundDrawable.java */
    public static class C0517a implements b {
        private RectShape a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f2488b;
        private Bitmap c;
        private boolean d;
        private int e;
        private int f;
        private int g;
        private float h;
        private float i;

        private C0517a() {
            this.f = 100;
            this.g = 10;
            this.a = new RectShape();
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b a(Bitmap bitmap) {
            this.f2488b = bitmap;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b b(Bitmap bitmap) {
            this.c = bitmap;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b a(boolean z) {
            this.d = z;
            return this;
        }

        public final b a(int i) {
            this.e = i;
            return this;
        }

        public final b a(float f) {
            this.h = f;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.g.a.b
        public final b b(float f) {
            this.i = f;
            return this;
        }

        public final a a() {
            return new a(this);
        }
    }
}
