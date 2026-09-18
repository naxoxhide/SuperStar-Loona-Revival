package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes4.dex */
public final class z0 extends FrameLayout {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2897b;
    public int c;
    public int d;
    public float e;
    public float f;

    public z0(Context context) {
        super(context);
        this.a = -8704;
        this.f2897b = -5789785;
        this.c = -1;
        this.d = 5;
        this.e = 0.0f;
        this.f = 5.0f;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.c = i;
    }

    public void setGrayColor(int i) {
        this.f2897b = i;
    }

    public void setMaxRating(float f) {
        if (f > 0.0f) {
            this.f = f;
        }
    }

    public void setNumStars(int i) {
        if (i > 0) {
            this.d = i;
        }
    }

    public void setRating(float f) {
        float f2 = this.f;
        float f3 = this.e;
        float f4 = f / f2;
        if (f3 > 0.0f) {
            float f5 = f3 / f2;
            f4 = ((int) (f4 / f5)) * f5;
        }
        setBackground(new ShapeDrawable(new v.b(f4, this.d, this.a, this.f2897b, this.c)));
    }

    public void setStepSize(float f) {
        if (f > 0.0f) {
            this.e = f;
        }
    }

    public void setTintColor(int i) {
        this.a = i;
    }
}
