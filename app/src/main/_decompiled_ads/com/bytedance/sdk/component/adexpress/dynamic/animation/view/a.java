package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import b.b.a.a.d.d.h.g;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;

/* JADX INFO: compiled from: AnimationWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f265b;
    Paint c;
    Path d = new Path();
    Path e = new Path();
    private int f;

    public a() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
    }

    public void a(Canvas canvas, b bVar, View view) {
        int iIntValue;
        int iIntValue2;
        String str;
        if (bVar.getRippleValue() != 0.0f) {
            if (b.b.a.a.d.e.a.a.d().b() != null) {
                float[] fArrA = null;
                try {
                    str = (String) view.getTag(b.b.a.a.d.d.a.e);
                    try {
                        fArrA = g.a(str);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                if (str.startsWith("#")) {
                    this.c.setColor(Color.parseColor(str));
                    this.c.setAlpha(90);
                } else if (fArrA != null) {
                    this.c.setColor(d.a(fArrA[3] * (1.0f - bVar.getRippleValue()), fArrA[0] / 256.0f, fArrA[1] / 256.0f, fArrA[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            int i = this.a;
            int i2 = this.f265b;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * bVar.getRippleValue(), this.c);
        }
        if (bVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.d.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(b.b.a.a.d.d.a.f73b)).intValue();
            } catch (Exception unused3) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int shineValue = ((int) ((((this.a * 4) + (iIntValue2 * 2)) + (this.f265b * 2)) * bVar.getShineValue())) - ((this.f265b * 2) + iIntValue2);
                float f = shineValue;
                int i3 = this.f265b;
                this.c.setShader(new LinearGradient(f, 0.0f, ((iIntValue2 + i3) / 2) + shineValue, i3 / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.c.setStrokeWidth(this.a * 2);
                Path path = this.e;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i4 = shineValue + iIntValue2;
                int i5 = this.f265b;
                canvas.drawLine(f, 0.0f, i4 + i5, i5, this.c);
            }
        }
        if (bVar.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(b.b.a.a.d.d.a.c)).intValue();
            } catch (Exception unused4) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.d.reset();
                this.d.moveTo(0.0f, 0.0f);
                this.d.lineTo(this.a * 2, 0.0f);
                this.d.lineTo(this.a * 2, this.f265b * 2);
                this.d.lineTo(0.0f, this.f265b * 2);
                this.d.lineTo(0.0f, 0.0f);
                this.c.setShader(new LinearGradient(0.0f, 0.0f, this.a * 2, this.f265b * 2, new int[]{(int) (bVar.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - bVar.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.c.setColor(SupportMenu.CATEGORY_MASK);
                this.c.setStyle(Paint.Style.STROKE);
                this.c.setStrokeWidth(iIntValue);
                canvas.drawPath(this.d, this.c);
            }
        }
    }

    public void a(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = this.f;
        int i2 = (int) (i * f);
        layoutParams.width = i2;
        view.setTranslationX((i - i2) / 2);
        if (view instanceof DynamicImageView) {
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i3).setTranslationX((-(this.f - layoutParams.width)) / 2);
                i3++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void a(View view, int i, int i2) {
        String str;
        this.a = i / 2;
        this.f265b = i2 / 2;
        if (this.f == 0 && view.getLayoutParams().width > 0) {
            this.f = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(b.b.a.a.d.d.a.d);
            try {
                this.e.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.a * 2);
            view.setPivotY(this.f265b);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.f265b);
        } else {
            view.setPivotX(this.a);
            view.setPivotY(this.f265b);
        }
    }
}
