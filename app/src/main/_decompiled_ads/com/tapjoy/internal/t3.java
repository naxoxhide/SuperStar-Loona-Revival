package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class t3 extends RelativeLayout implements View.OnClickListener {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2815b;
    public View c;
    public View d;
    public FrameLayout e;
    public ImageView f;
    public l0 g;
    public final m3 h;
    public final q3 i;

    public t3(Context context, m3 m3Var, q3 q3Var) {
        w4 w4Var;
        l6 l6Var;
        super(context);
        this.f2815b = 1.0f;
        this.h = m3Var;
        this.i = q3Var;
        a();
        this.f.setImageBitmap(m3Var.c.a());
        l0 l0Var = this.g;
        if (l0Var == null || (w4Var = m3Var.l) == null || (l6Var = w4Var.a) == null) {
            return;
        }
        l0Var.setImageBitmap(l6Var.a());
    }

    public final void a() {
        Context context = getContext();
        View view = new View(context);
        this.c = view;
        boolean z = true;
        view.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.c, layoutParams);
        this.d = new View(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams2.addRule(13);
        addView(this.d, layoutParams2);
        this.e = new FrameLayout(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams3.addRule(13);
        addView(this.e, layoutParams3);
        ImageView imageView = new ImageView(context);
        this.f = imageView;
        imageView.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams4.addRule(7, this.c.getId());
        layoutParams4.addRule(6, this.c.getId());
        addView(this.f, layoutParams4);
        w4 w4Var = this.h.l;
        if (w4Var != null) {
            if (w4Var.a == null || (w4Var.f2828b == null && w4Var.c == null)) {
                z = false;
            }
            if (z) {
                l0 l0Var = new l0(context);
                this.g = l0Var;
                l0Var.setOnClickListener(this);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(0, 0);
                layoutParams5.addRule(5, this.d.getId());
                layoutParams5.addRule(8, this.d.getId());
                addView(this.g, layoutParams5);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        l0 l0Var;
        if (view == this.f) {
            this.i.c.g.cancel();
            return;
        }
        if (view != null && view == (l0Var = this.g)) {
            boolean z = !l0Var.a;
            l0Var.a = z;
            if (z) {
                l0Var.e = l0Var.c;
            } else {
                l0Var.e = l0Var.d;
            }
            l0Var.invalidate();
            r3 r3Var = this.i.c;
            r3Var.k = true ^ r3Var.k;
            return;
        }
        if (view.getTag() instanceof z0) {
            q3 q3Var = this.i;
            z0 z0Var = (z0) view.getTag();
            r3 r3Var2 = q3Var.c;
            v1 v1Var = r3Var2.d;
            LinkedHashMap linkedHashMap = r3Var2.f.k;
            String str = z0Var.f2837b;
            p1 p1Var = v1Var.f;
            p1Var.getClass();
            n1 n1VarA = p1Var.a(r1.CAMPAIGN, "click");
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
            linkedHashMap2.put("region", str);
            StringWriter stringWriter = new StringWriter();
            g4 g4Var = new g4(stringWriter);
            try {
                g4Var.a(linkedHashMap2);
                try {
                    g4Var.a.flush();
                    stringWriter.toString();
                    p1Var.a(n1VarA);
                    Activity activity = q3Var.a;
                    String str2 = z0Var.d;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                        } catch (Exception unused) {
                        }
                    }
                    if (!TextUtils.isEmpty(z0Var.e)) {
                        q3Var.c.f2755b.a(q3Var.a, z0Var.e, r9.a(z0Var.f));
                        q3Var.c.a = true;
                    }
                    q3Var.f2801b.a(q3Var.c.e, z0Var.g);
                    if (z0Var.c) {
                        q3Var.c.g.dismiss();
                    }
                } catch (IOException e) {
                    s9.a(e);
                    throw null;
                }
            } catch (IOException e2) {
                s9.a(e2);
                throw null;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x014d  */
    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        Point point;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.a) {
            this.f2815b = Math.min(size / 480.0f, size2 / 320.0f);
        } else {
            this.f2815b = Math.min(size / 320.0f, size2 / 480.0f);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = a(this.a ? 480 : 320);
        layoutParams.height = a(this.a ? 320 : 480);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.width = a(this.a ? 448 : 290);
        layoutParams2.height = a(this.a ? 290 : 448);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams3.width = layoutParams2.width;
        layoutParams3.height = layoutParams2.height;
        FrameLayout frameLayout = this.e;
        int childCount = frameLayout.getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!(i5 < childCount)) {
                break;
            }
            int i6 = i5 + 1;
            View childAt = frameLayout.getChildAt(i5);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            Rect rect = ((z0) childAt.getTag()).a;
            layoutParams4.width = a(rect.width());
            layoutParams4.height = a(rect.height());
            layoutParams4.leftMargin = a(rect.left);
            layoutParams4.topMargin = a(rect.top);
            i5 = i6;
        }
        int iA = a(0);
        this.f.setPadding(iA, iA, iA, iA);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        int iA2 = a(30);
        layoutParams5.width = iA2;
        layoutParams5.height = iA2;
        int i7 = -iA;
        layoutParams5.rightMargin = a(this.h.d.x) + i7;
        layoutParams5.topMargin = a(this.h.d.y) + i7;
        if (this.g != null) {
            int iA3 = a(this.a ? 16 : 15);
            int iA4 = a(this.a ? 15 : 16);
            this.g.setPadding(iA, iA, iA, iA);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            int iA5 = a(26);
            layoutParams6.width = iA5;
            layoutParams6.height = iA5;
            w4 w4Var = this.h.l;
            if (w4Var == null) {
                i3 = 0;
            } else {
                if (this.a) {
                    point = w4Var.f2828b;
                    if (point == null) {
                        point = w4Var.c;
                    }
                } else {
                    point = w4Var.c;
                    if (point == null) {
                        point = w4Var.f2828b;
                    }
                }
                if (point != null) {
                    i4 = point.x;
                    i3 = point.y;
                } else {
                    i3 = 0;
                }
            }
            layoutParams6.leftMargin = a(i4) + iA3;
            layoutParams6.topMargin = a(i3) + iA4;
        }
        super.onMeasure(i, i2);
    }

    public void setLandscape(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        ArrayList<z0> arrayList;
        this.a = z;
        if (z) {
            m3 m3Var = this.h;
            bitmap = m3Var.f2782b.f2779b;
            bitmap2 = m3Var.f.f2779b;
            arrayList = m3Var.j;
        } else {
            m3 m3Var2 = this.h;
            bitmap = m3Var2.a.f2779b;
            bitmap2 = m3Var2.e.f2779b;
            arrayList = m3Var2.i;
        }
        ta.a(this.c, new BitmapDrawable((Resources) null, bitmap));
        ta.a(this.d, new BitmapDrawable((Resources) null, bitmap2));
        if (this.e.getChildCount() > 0) {
            this.e.removeAllViews();
        }
        Context context = getContext();
        for (z0 z0Var : arrayList) {
            View view = new View(context);
            view.setTag(z0Var);
            view.setOnClickListener(this);
            this.e.addView(view, new FrameLayout.LayoutParams(0, 0, 51));
        }
    }

    public final int a(int i) {
        return (int) (i * this.f2815b);
    }
}
