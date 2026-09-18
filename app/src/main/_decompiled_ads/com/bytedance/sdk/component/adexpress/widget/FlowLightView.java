package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlowLightView extends View {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f308b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int[] g;
    private Bitmap h;
    private Paint i;
    private Xfermode j;
    private PorterDuff.Mode k;
    private LinearGradient l;
    Rect m;
    Rect n;
    private final List<a> o;

    public static class a {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f309b = 0;

        public a(int i) {
            this.a = i;
        }

        public void a() {
            this.f309b += this.a;
        }
    }

    public FlowLightView(Context context) {
        super(context);
        this.k = PorterDuff.Mode.DST_IN;
        this.o = new ArrayList();
        a();
    }

    private void a() {
        this.a = t.e(getContext(), "tt_splash_unlock_image_arrow");
        this.f308b = Color.parseColor("#00ffffff");
        this.c = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.d = color;
        this.e = 10;
        this.f = 40;
        this.g = new int[]{this.f308b, this.c, color};
        setLayerType(1, null);
        this.i = new Paint(1);
        this.h = BitmapFactory.decodeResource(getResources(), this.a);
        this.j = new PorterDuffXfermode(this.k);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.h, this.m, this.n, this.i);
        canvas.save();
        Iterator<a> it = this.o.iterator();
        while (it.hasNext()) {
            a next = it.next();
            this.l = new LinearGradient(next.f309b, 0.0f, next.f309b + this.f, this.e, this.g, (float[]) null, Shader.TileMode.CLAMP);
            this.i.setColor(-1);
            this.i.setShader(this.l);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.i);
            this.i.setShader(null);
            next.a();
            if (next.f309b > getWidth()) {
                it.remove();
            }
        }
        this.i.setXfermode(this.j);
        canvas.drawBitmap(this.h, this.m, this.n, this.i);
        this.i.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.h == null) {
            return;
        }
        this.m = new Rect(0, 0, this.h.getWidth(), this.h.getHeight());
        this.n = new Rect(0, 0, getWidth(), getHeight());
    }

    public void a(int i) {
        this.o.add(new a(i));
        postInvalidate();
    }
}
