package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CircleRippleView extends View {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f302b;
    private int c;
    private float d;
    private int e;
    private boolean f;
    private List<Integer> g;
    private List<Integer> h;
    private Paint i;
    private Paint j;
    private float k;
    private float l;
    private int m;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        this.i.setStrokeWidth(this.m);
        this.g.add(255);
        this.h.add(0);
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setAntiAlias(true);
        this.j.setColor(Color.parseColor("#0FFFFFFF"));
        this.j.setStyle(Paint.Style.FILL);
    }

    public void b() {
        this.f = true;
        invalidate();
    }

    public void c() {
        this.f = false;
        this.h.clear();
        this.g.clear();
        this.g.add(255);
        this.h.add(0);
        invalidate();
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.i.setShader(new LinearGradient(this.k, 0.0f, this.l, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.g.size()) {
                break;
            }
            Integer num = this.g.get(i);
            this.i.setAlpha(num.intValue());
            Integer num2 = this.h.get(i);
            if (this.f302b + num2.intValue() < this.d) {
                canvas.drawCircle(this.k, this.l, this.f302b + num2.intValue(), this.i);
            }
            if (num.intValue() > 0 && num2.intValue() < this.d) {
                this.g.set(i, Integer.valueOf(num.intValue() - this.e > 0 ? num.intValue() - (this.e * 3) : 1));
                this.h.set(i, Integer.valueOf(num2.intValue() + this.e));
            }
            i++;
        }
        List<Integer> list = this.h;
        if (list.get(list.size() - 1).intValue() >= this.d / this.c) {
            this.g.add(255);
            this.h.add(0);
        }
        if (this.h.size() >= 3) {
            this.h.remove(0);
            this.g.remove(0);
        }
        this.i.setAlpha(255);
        this.i.setColor(this.a);
        canvas.drawCircle(this.k, this.l, this.f302b, this.j);
        if (this.f) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.k = f;
        this.l = i2 / 2.0f;
        float f2 = f - (this.m / 2.0f);
        this.d = f2;
        this.f302b = f2 / 4.0f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    public void setColor(int i) {
    }

    public void setCoreColor(int i) {
        this.a = i;
    }

    public void setCoreRadius(int i) {
        this.f302b = i;
    }

    public void setDiffuseSpeed(int i) {
        this.e = i;
    }

    public void setDiffuseWidth(int i) {
        this.c = i;
    }

    public void setMaxWidth(int i) {
        this.d = i;
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = SupportMenu.CATEGORY_MASK;
        this.f302b = 18.0f;
        this.c = 3;
        this.d = 50.0f;
        this.e = 2;
        this.f = false;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.m = 24;
        a();
    }
}
