package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.h;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.u;
import com.applovin.impl.adview.v;
import com.applovin.impl.adview.w;
import com.applovin.impl.sdk.ad.e;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // com.applovin.impl.adview.activity.a.a
    public /* bridge */ /* synthetic */ void a(n nVar) {
        super.a(nVar);
    }

    @Override // com.applovin.impl.adview.activity.a.a
    public /* bridge */ /* synthetic */ void k(View view) {
        super.k(view);
    }

    public c(e eVar, Activity activity, com.applovin.impl.sdk.n nVar) {
        super(eVar, activity, nVar);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x009a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0109  */
    /* JADX WARN: Code duplicated, block: B:23:0x0129  */
    /* JADX WARN: Code duplicated, block: B:25:0x013f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0147  */
    /* JADX WARN: Code duplicated, block: B:28:0x014b  */
    /* JADX WARN: Code duplicated, block: B:31:0x015a  */
    /* JADX WARN: Code duplicated, block: B:33:0x019f  */
    /* JADX WARN: Code duplicated, block: B:35:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:37:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:40:0x0211  */
    /* JADX WARN: Code duplicated, block: B:42:0x021b  */
    /* JADX WARN: Code duplicated, block: B:45:0x025e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0269  */
    /* JADX WARN: Code duplicated, block: B:49:0x026f  */
    public void a(ImageView imageView, n nVar, final w wVar, com.applovin.impl.adview.a aVar, ProgressBar progressBar, h hVar, View view, AppLovinAdView appLovinAdView, v vVar, ImageView imageView2, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        com.applovin.impl.b.a aVar2;
        int i;
        int i2;
        u uVarGn;
        if (this.aiL.Hy() == e.d.TOP) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
        } else if (this.aiL.Hy() == e.d.BOTTOM) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        } else {
            if (this.aiL.Hy() == e.d.LEFT) {
                layoutParams = new FrameLayout.LayoutParams(-2, -1, 3);
            } else if (this.aiL.Hy() == e.d.RIGHT) {
                layoutParams = new FrameLayout.LayoutParams(-2, -1, 5);
            } else {
                layoutParams = this.aiN;
            }
            appLovinAdView.setLayoutParams(this.aiN);
            this.aiM.addView(appLovinAdView);
            View view2 = new View(this.ahM);
            view2.setLayoutParams(this.aiN);
            view2.setBackgroundColor(Color.argb(254, 0, 0, 0));
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.activity.a.-$$Lambda$c$e6vPtJd8xw3tVdpx0qUE7x5te1Y
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    return c.c(view3, motionEvent);
                }
            });
            this.aiM.addView(view2);
            view.setLayoutParams(layoutParams);
            this.aiM.addView(view);
            if (wVar != null) {
                uVarGn = this.aiL.Gn();
                LinearLayout linearLayout = new LinearLayout(this.ahM);
                linearLayout.setOrientation(1);
                linearLayout.setWeightSum(100.0f);
                linearLayout.setGravity(uVarGn.rZ());
                ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                LinearLayout linearLayout2 = new LinearLayout(this.ahM);
                linearLayout2.setOrientation(0);
                linearLayout2.setWeightSum(100.0f);
                linearLayout2.setGravity(uVarGn.rZ());
                ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, 0, uVarGn.rX());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1, uVarGn.rW());
                int iDpToPx = AppLovinSdkUtils.dpToPx(this.ahM, uVarGn.rY());
                layoutParams4.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
                linearLayout2.addView(wVar, layoutParams4);
                linearLayout.addView(linearLayout2, layoutParams3);
                this.aiM.addView(linearLayout, layoutParams2);
                if (uVarGn.se() > 0.0f) {
                    wVar.setVisibility(4);
                    long jC = com.applovin.impl.sdk.utils.u.C(uVarGn.se());
                    final long jSc = uVarGn.sc();
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.adview.activity.a.-$$Lambda$c$pP7a2ljd5LtJrPXT1yUo6kXmJ5k
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.applovin.impl.sdk.utils.v.a(wVar, jSc, null);
                        }
                    }, jC);
                }
                if (uVarGn.sf() > 0.0f) {
                    long jC2 = com.applovin.impl.sdk.utils.u.C(uVarGn.sf());
                    final long jSd = uVarGn.sd();
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.adview.activity.a.-$$Lambda$c$F_hvTqjdtzHMhH5u5qib9Yz_rHg
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.applovin.impl.sdk.utils.v.b(wVar, jSd, null);
                        }
                    }, jC2);
                }
            }
            if (nVar != null) {
                if (this.aiL.GQ()) {
                    i = 48;
                    i2 = 3;
                } else {
                    i = 48;
                    i2 = 5;
                }
                a(this.aiL.GL(), i | i2, nVar);
            }
            if (imageView != null) {
                int iDpToPx2 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNe)).intValue());
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iDpToPx2, iDpToPx2, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNg)).intValue());
                int iDpToPx3 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNf)).intValue());
                layoutParams5.setMargins(iDpToPx3, iDpToPx3, iDpToPx3, iDpToPx3);
                this.aiM.addView(imageView, layoutParams5);
            }
            if (aVar != null) {
                this.aiM.addView(aVar, this.aiN);
            }
            if (hVar != null) {
                int iDpToPx4 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMR)).intValue());
                FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iDpToPx4, iDpToPx4, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMQ)).intValue());
                int iDpToPx5 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMP)).intValue());
                layoutParams6.setMargins(iDpToPx5, iDpToPx5, iDpToPx5, iDpToPx5);
                this.aiM.addView(hVar, layoutParams6);
            }
            if (progressBar != null) {
                FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, 20, 80);
                layoutParams7.setMargins(0, 0, 0, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNj)).intValue());
                this.aiM.addView(progressBar, layoutParams7);
            }
            if (imageView2 != null) {
                aVar2 = (com.applovin.impl.b.a) this.aiL;
                if (aVar2.LX()) {
                    int iDpToPx6 = AppLovinSdkUtils.dpToPx(this.ahM, aVar2.LW().getWidth());
                    int iDpToPx7 = AppLovinSdkUtils.dpToPx(this.ahM, aVar2.LW().getHeight());
                    int iDpToPx8 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPv)).intValue());
                    FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(iDpToPx6, iDpToPx7, 83);
                    layoutParams8.setMargins(iDpToPx8, iDpToPx8, iDpToPx8, iDpToPx8);
                    this.aiM.addView(imageView2, layoutParams8);
                }
            }
            if (vVar != null) {
                this.aiM.addView(vVar, this.aiN);
            }
            if (viewGroup != null) {
                viewGroup.addView(this.aiM);
            } else {
                this.ahM.setContentView(this.aiM);
            }
        }
        appLovinAdView.setLayoutParams(this.aiN);
        this.aiM.addView(appLovinAdView);
        View view3 = new View(this.ahM);
        view3.setLayoutParams(this.aiN);
        view3.setBackgroundColor(Color.argb(254, 0, 0, 0));
        view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.activity.a.-$$Lambda$c$e6vPtJd8xw3tVdpx0qUE7x5te1Y
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view4, MotionEvent motionEvent) {
                return c.c(view4, motionEvent);
            }
        });
        this.aiM.addView(view3);
        view.setLayoutParams(layoutParams);
        this.aiM.addView(view);
        if (wVar != null) {
            uVarGn = this.aiL.Gn();
            LinearLayout linearLayout3 = new LinearLayout(this.ahM);
            linearLayout3.setOrientation(1);
            linearLayout3.setWeightSum(100.0f);
            linearLayout3.setGravity(uVarGn.rZ());
            ViewGroup.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout4 = new LinearLayout(this.ahM);
            linearLayout4.setOrientation(0);
            linearLayout4.setWeightSum(100.0f);
            linearLayout4.setGravity(uVarGn.rZ());
            ViewGroup.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, 0, uVarGn.rX());
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(0, -1, uVarGn.rW());
            int iDpToPx9 = AppLovinSdkUtils.dpToPx(this.ahM, uVarGn.rY());
            layoutParams11.setMargins(iDpToPx9, iDpToPx9, iDpToPx9, iDpToPx9);
            linearLayout4.addView(wVar, layoutParams11);
            linearLayout3.addView(linearLayout4, layoutParams10);
            this.aiM.addView(linearLayout3, layoutParams9);
            if (uVarGn.se() > 0.0f) {
                wVar.setVisibility(4);
                long jC3 = com.applovin.impl.sdk.utils.u.C(uVarGn.se());
                final long jSc2 = uVarGn.sc();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.adview.activity.a.-$$Lambda$c$pP7a2ljd5LtJrPXT1yUo6kXmJ5k
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.applovin.impl.sdk.utils.v.a(wVar, jSc2, null);
                    }
                }, jC3);
            }
            if (uVarGn.sf() > 0.0f) {
                long jC4 = com.applovin.impl.sdk.utils.u.C(uVarGn.sf());
                final long jSd2 = uVarGn.sd();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.adview.activity.a.-$$Lambda$c$F_hvTqjdtzHMhH5u5qib9Yz_rHg
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.applovin.impl.sdk.utils.v.b(wVar, jSd2, null);
                    }
                }, jC4);
            }
        }
        if (nVar != null) {
            if (this.aiL.GQ()) {
                i = 48;
                i2 = 3;
            } else {
                i = 48;
                i2 = 5;
            }
            a(this.aiL.GL(), i | i2, nVar);
        }
        if (imageView != null) {
            int iDpToPx10 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNe)).intValue());
            FrameLayout.LayoutParams layoutParams12 = new FrameLayout.LayoutParams(iDpToPx10, iDpToPx10, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNg)).intValue());
            int iDpToPx11 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNf)).intValue());
            layoutParams12.setMargins(iDpToPx11, iDpToPx11, iDpToPx11, iDpToPx11);
            this.aiM.addView(imageView, layoutParams12);
        }
        if (aVar != null) {
            this.aiM.addView(aVar, this.aiN);
        }
        if (hVar != null) {
            int iDpToPx12 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMR)).intValue());
            FrameLayout.LayoutParams layoutParams13 = new FrameLayout.LayoutParams(iDpToPx12, iDpToPx12, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMQ)).intValue());
            int iDpToPx13 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMP)).intValue());
            layoutParams13.setMargins(iDpToPx13, iDpToPx13, iDpToPx13, iDpToPx13);
            this.aiM.addView(hVar, layoutParams13);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(-1, 20, 80);
            layoutParams14.setMargins(0, 0, 0, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNj)).intValue());
            this.aiM.addView(progressBar, layoutParams14);
        }
        if (imageView2 != null) {
            aVar2 = (com.applovin.impl.b.a) this.aiL;
            if (aVar2.LX()) {
                int iDpToPx14 = AppLovinSdkUtils.dpToPx(this.ahM, aVar2.LW().getWidth());
                int iDpToPx15 = AppLovinSdkUtils.dpToPx(this.ahM, aVar2.LW().getHeight());
                int iDpToPx16 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPv)).intValue());
                FrameLayout.LayoutParams layoutParams15 = new FrameLayout.LayoutParams(iDpToPx14, iDpToPx15, 83);
                layoutParams15.setMargins(iDpToPx16, iDpToPx16, iDpToPx16, iDpToPx16);
                this.aiM.addView(imageView2, layoutParams15);
            }
        }
        if (vVar != null) {
            this.aiM.addView(vVar, this.aiN);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.aiM);
        } else {
            this.ahM.setContentView(this.aiM);
        }
    }

    public void a(n nVar, v vVar, View view, ProgressBar progressBar) {
        if (view != null) {
            view.setVisibility(0);
        }
        com.applovin.impl.sdk.utils.c.a(this.aiM, view);
        if (nVar != null) {
            a(this.aiL.GL(), (this.aiL.GP() ? 3 : 5) | 48, nVar);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 20, ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNr)).booleanValue() ? 80 : 48);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNs)).intValue());
            this.aiM.addView(progressBar, layoutParams);
        }
        if (vVar != null) {
            this.aiM.addView(vVar, this.aiN);
        }
    }
}
