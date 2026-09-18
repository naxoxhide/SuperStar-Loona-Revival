package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.b.a.a.d.d.h.h;
import com.facebook.internal.security.CertificateUtil;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicVideoView extends DynamicBaseWidgetImp implements b.b.a.a.d.d.e {
    FrameLayout A;
    boolean B;
    TextView z;

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.B = false;
        View view = new View(context);
        this.m = view;
        view.setTag(Integer.valueOf(getClickArea()));
        this.z = new TextView(context);
        this.A = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) b.b.a.a.d.g.d.a(context, 40.0f), (int) b.b.a.a.d.g.d.a(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.z.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.z.setBackground(gradientDrawable);
        this.z.setTextSize(10.0f);
        this.z.setGravity(17);
        this.z.setTextColor(-1);
        this.z.setVisibility(8);
        addView(this.A, new FrameLayout.LayoutParams(-1, -1));
        addView(this.z);
        addView(this.m, getWidgetLayoutParams());
        dynamicRootView.setVideoListener(this);
    }

    @Override // b.b.a.a.d.d.e
    public void a() {
        this.z.setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean c() {
        super.c();
        double dP = 0.0d;
        double dO = 0.0d;
        for (h hVarL = this.k; hVarL != null; hVarL = hVarL.l()) {
            double dR = dO + ((double) hVarL.r());
            double dS = dP + ((double) hVarL.s());
            dO = dR - ((double) hVarL.o());
            dP = dS - ((double) hVarL.p());
        }
        try {
            float f = (float) dO;
            int iA = (int) b.b.a.a.d.g.d.a(getContext(), f);
            int iA2 = (int) b.b.a.a.d.g.d.a(getContext(), f + this.c);
            if (b.b.a.a.d.g.b.a(getContext())) {
                int dynamicWidth = ((DynamicRoot) this.l.getChildAt(0)).getDynamicWidth();
                int i = dynamicWidth - iA2;
                iA2 = dynamicWidth - iA;
                iA = i;
            }
            if ("open_ad".equals(this.l.getRenderRequest().a())) {
                this.l.r = this.A;
            } else {
                float f2 = (float) dP;
                ((DynamicRoot) this.l.getChildAt(0)).z.a(iA, (int) b.b.a.a.d.g.d.a(getContext(), f2), iA2, (int) b.b.a.a.d.g.d.a(getContext(), f2 + this.d));
            }
        } catch (Exception unused) {
        }
        this.l.a(dO, dP, this.c, this.d, this.j.j());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean i() {
        return true;
    }

    @Override // b.b.a.a.d.d.e
    public void setTimeUpdate(int i) {
        if (this.k.n().g().h0() && i > 0 && !this.B) {
            String str = (i >= 60 ? "0" + (i / 60) : "00") + CertificateUtil.DELIMITER;
            int i2 = i % 60;
            this.z.setText(i2 > 9 ? str + i2 : str + "0" + i2);
            this.z.setVisibility(0);
            return;
        }
        this.B = true;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            c(getChildAt(i3));
        }
        this.z.setVisibility(8);
    }

    private void c(View view) {
        if (view == this.z) {
            return;
        }
        try {
            if (((Integer) view.getTag(b.b.a.a.d.d.a.f)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            c(viewGroup.getChildAt(i));
            i++;
        }
    }
}
