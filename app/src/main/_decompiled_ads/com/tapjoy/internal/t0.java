package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class t0 extends RelativeLayout {
    public final q0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0 f2814b;
    public l1 c;
    public int d;
    public int e;
    public j4 f;
    public ArrayList g;
    public ArrayList h;

    public t0(Context context, q0 q0Var, v0 v0Var) {
        super(context);
        this.c = l1.c;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.a = q0Var;
        this.f2814b = v0Var;
    }

    public final void a() {
        u2 u2Var;
        u2 u2Var2;
        boolean z;
        boolean z2;
        j4 j4Var = null;
        for (j4 j4Var2 : this.a.a) {
            l1 l1Var = j4Var2.a;
            if (l1Var == this.c) {
                j4Var = j4Var2;
                break;
            } else if (l1Var == l1.c) {
                j4Var = j4Var2;
            }
        }
        removeAllViews();
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                u2 u2Var3 = (u2) ((WeakReference) it.next()).get();
                if (u2Var3 != null) {
                    u2Var3.d = false;
                    u2Var3.e = false;
                    u2Var3.f = true;
                    u2Var3.b();
                    u2Var3.c.post(u2Var3.j);
                }
            }
            this.g.clear();
        }
        ArrayList arrayList2 = this.h;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                u2 u2Var4 = (u2) ((WeakReference) it2.next()).get();
                if (u2Var4 != null) {
                    u2Var4.d = false;
                    u2Var4.e = false;
                    u2Var4.f = true;
                    u2Var4.b();
                    u2Var4.c.post(u2Var4.j);
                }
            }
            this.h.clear();
        }
        if (j4Var != null) {
            this.f = j4Var;
            Context context = getContext();
            for (f0 f0Var : j4Var.c) {
                RelativeLayout relativeLayout = new RelativeLayout(context);
                if (f0Var.k.c != null) {
                    u2 u2Var5 = new u2(context);
                    u2Var5.setScaleType(ImageView.ScaleType.FIT_XY);
                    l6 l6Var = f0Var.k;
                    o2 o2Var = l6Var.d;
                    byte[] bArr = l6Var.c;
                    try {
                        b7 b7Var = new b7();
                        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                        m2 m2Var = new m2(b7Var);
                        m2Var.b(o2Var, byteBufferWrap);
                        u2Var5.a = m2Var;
                        boolean z3 = u2Var5.d;
                        if (z3) {
                            u2Var5.a();
                        } else if (m2Var.n != 0) {
                            if (-1 >= m2Var.p.c) {
                                z2 = false;
                            } else {
                                m2Var.n = -1;
                                z2 = true;
                            }
                            if (z2 && !z3) {
                                u2Var5.e = true;
                                u2Var5.a();
                            }
                        }
                    } catch (Exception unused) {
                        u2Var5.a = null;
                    }
                    if (this.g == null) {
                        this.g = new ArrayList();
                    }
                    this.g.add(new WeakReference(u2Var5));
                    u2Var = u2Var5;
                } else {
                    u2Var = null;
                }
                l6 l6Var2 = f0Var.l;
                if (l6Var2 == null || l6Var2.c == null) {
                    u2Var2 = null;
                } else {
                    u2 u2Var6 = new u2(context);
                    u2Var6.setScaleType(ImageView.ScaleType.FIT_XY);
                    l6 l6Var3 = f0Var.l;
                    o2 o2Var2 = l6Var3.d;
                    byte[] bArr2 = l6Var3.c;
                    try {
                        b7 b7Var2 = new b7();
                        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr2);
                        m2 m2Var2 = new m2(b7Var2);
                        m2Var2.b(o2Var2, byteBufferWrap2);
                        u2Var6.a = m2Var2;
                        boolean z4 = u2Var6.d;
                        if (z4) {
                            u2Var6.a();
                        } else if (m2Var2.n != 0) {
                            if (-1 >= m2Var2.p.c) {
                                z = false;
                            } else {
                                m2Var2.n = -1;
                                z = true;
                            }
                            if (z && !z4) {
                                u2Var6.e = true;
                                u2Var6.a();
                            }
                        }
                    } catch (Exception unused2) {
                        u2Var6.a = null;
                    }
                    if (this.h == null) {
                        this.h = new ArrayList();
                    }
                    this.h.add(new WeakReference(u2Var6));
                    u2Var2 = u2Var6;
                }
                ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                Bitmap bitmap = f0Var.k.f2779b;
                l6 l6Var4 = f0Var.l;
                Bitmap bitmap2 = l6Var4 != null ? l6Var4.f2779b : null;
                BitmapDrawable bitmapDrawable = bitmap != null ? new BitmapDrawable((Resources) null, bitmap) : null;
                BitmapDrawable bitmapDrawable2 = bitmap2 != null ? new BitmapDrawable((Resources) null, bitmap2) : null;
                if (bitmapDrawable != null) {
                    ta.a(relativeLayout, bitmapDrawable);
                }
                if (u2Var != null) {
                    relativeLayout.addView(u2Var, layoutParams2);
                    u2Var.d = true;
                    u2Var.a();
                }
                if (u2Var2 != null) {
                    relativeLayout.addView(u2Var2, layoutParams2);
                    u2Var2.setVisibility(4);
                }
                relativeLayout.setOnTouchListener(new r0(u2Var2, bitmapDrawable2, u2Var, bitmapDrawable));
                relativeLayout.setOnClickListener(new s0(this, u2Var2, relativeLayout, u2Var, f0Var));
                relativeLayout.setTag(f0Var);
                addView(relativeLayout, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2814b.c.c();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        float f;
        float f2;
        PointF pointF;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size >= size2) {
            l1 l1Var = this.c;
            l1 l1Var2 = l1.e;
            if (l1Var != l1Var2) {
                this.c = l1Var2;
                a();
            }
        } else {
            l1 l1Var3 = this.c;
            l1 l1Var4 = l1.d;
            if (l1Var3 != l1Var4) {
                this.c = l1Var4;
                a();
            }
        }
        if (this.d != size || this.e != size2) {
            this.d = size;
            this.e = size2;
            float f3 = size;
            float f4 = size2;
            j4 j4Var = this.f;
            float f5 = 0.0f;
            if (j4Var == null || (pointF = j4Var.f2773b) == null) {
                f = 0.0f;
            } else {
                float f6 = pointF.y;
                float f7 = pointF.x;
                float f8 = (f3 * f6) / f7;
                float f9 = f8 / f4;
                if (f9 < 1.0f) {
                    f = (f4 - f8) / 2.0f;
                    f4 = f8;
                } else if (f9 > 1.0f) {
                    float f10 = (f7 * f4) / f6;
                    f5 = (f3 - f10) / 2.0f;
                    f3 = f10;
                    f = 0.0f;
                } else {
                    f = 0.0f;
                }
            }
            int childCount = getChildCount();
            int i3 = 0;
            while (true) {
                if (!(i3 < childCount)) {
                    break;
                }
                int i4 = i3 + 1;
                View childAt = getChildAt(i3);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                f0 f0Var = (f0) childAt.getTag();
                float fA = f0Var.a.a(f3, f4);
                float fA2 = f0Var.f2753b.a(f3, f4);
                float fA3 = f0Var.c.a(f3, f4);
                float fA4 = f0Var.d.a(f3, f4);
                int i5 = f0Var.e;
                int i6 = f0Var.f;
                if (i5 == 14) {
                    f2 = 2.0f;
                    fA += (f3 - fA3) / 2.0f;
                    i5 = 9;
                } else {
                    f2 = 2.0f;
                }
                if (i6 == 15) {
                    fA2 += (f4 - fA4) / f2;
                    i6 = 10;
                }
                layoutParams.addRule(i5, -1);
                layoutParams.addRule(i6, -1);
                layoutParams.width = Math.round(fA3);
                layoutParams.height = Math.round(fA4);
                if (i5 == 9) {
                    layoutParams.leftMargin = Math.round(fA + f5);
                } else if (i5 == 11) {
                    layoutParams.rightMargin = Math.round(fA + f5);
                }
                if (i6 == 10) {
                    layoutParams.topMargin = Math.round(fA2 + f);
                } else if (i6 == 12) {
                    layoutParams.bottomMargin = Math.round(fA2 + f);
                }
                i3 = i4;
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            ArrayList arrayList = this.g;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    u2 u2Var = (u2) ((WeakReference) it.next()).get();
                    if (u2Var != null) {
                        u2Var.b();
                    }
                }
            }
            ArrayList arrayList2 = this.h;
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    u2 u2Var2 = (u2) ((WeakReference) it2.next()).get();
                    if (u2Var2 != null) {
                        u2Var2.b();
                    }
                }
                return;
            }
            return;
        }
        ArrayList arrayList3 = this.h;
        if (arrayList3 != null) {
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                u2 u2Var3 = (u2) ((WeakReference) it3.next()).get();
                if (u2Var3 != null) {
                    u2Var3.setVisibility(4);
                    u2Var3.b();
                }
            }
        }
        ArrayList arrayList4 = this.g;
        if (arrayList4 != null) {
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                u2 u2Var4 = (u2) ((WeakReference) it4.next()).get();
                if (u2Var4 != null) {
                    u2Var4.setVisibility(0);
                    u2Var4.d = true;
                    u2Var4.a();
                }
            }
        }
    }
}
