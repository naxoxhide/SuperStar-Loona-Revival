package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.o;

/* JADX INFO: compiled from: TTCustomShadowBackground.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends Drawable {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f700b;
    private int[] c;
    private float[] d;
    private LinearGradient e;
    private int f;
    private int g;
    private int h;
    private int i;
    private RectF j;
    private Paint k;

    /* JADX INFO: compiled from: TTCustomShadowBackground.java */
    public static class a {
        private int[] c;
        private float[] d;
        private LinearGradient e;
        private int h;
        private int i;
        private int a = t.b(o.a(), "tt_ssxinmian8");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f701b = t.b(o.a(), "tt_ssxinxian3");
        private int f = 10;
        private int g = 16;

        public a() {
            this.h = 0;
            this.i = 0;
            this.h = 0;
            this.i = 0;
        }

        public a a(int i) {
            this.a = i;
            return this;
        }

        public a b(int i) {
            this.h = i;
            return this;
        }

        public a c(int i) {
            this.i = i;
            return this;
        }

        public a d(int i) {
            this.f = i;
            return this;
        }

        public a e(int i) {
            this.f701b = i;
            return this;
        }

        public a a(int[] iArr) {
            this.c = iArr;
            return this;
        }

        public c a() {
            return new c(this.a, this.c, this.d, this.f701b, this.e, this.f, this.g, this.h, this.i);
        }
    }

    public c(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.c = iArr;
        this.d = fArr;
        this.f700b = i2;
        this.e = linearGradient;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
    }

    private void a() {
        int[] iArr;
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.k.setShadowLayer(this.g, this.h, this.i, this.f700b);
        if (this.j == null || (iArr = this.c) == null || iArr.length <= 1) {
            this.k.setColor(this.a);
            return;
        }
        float[] fArr = this.d;
        boolean z = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
        Paint paint2 = this.k;
        LinearGradient linearGradient = this.e;
        if (linearGradient == null) {
            RectF rectF = this.j;
            linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.c, z ? this.d : null, Shader.TileMode.CLAMP);
        }
        paint2.setShader(linearGradient);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            int i = bounds.left;
            int i2 = this.g;
            int i3 = this.h;
            int i4 = bounds.top + i2;
            int i5 = this.i;
            this.j = new RectF((i + i2) - i3, i4 - i5, (bounds.right - i2) - i3, (bounds.bottom - i2) - i5);
        }
        if (this.k == null) {
            a();
        }
        RectF rectF = this.j;
        float f = this.f;
        canvas.drawRoundRect(rectF, f, f, this.k);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public static void a(View view, a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, aVar.a());
    }
}
