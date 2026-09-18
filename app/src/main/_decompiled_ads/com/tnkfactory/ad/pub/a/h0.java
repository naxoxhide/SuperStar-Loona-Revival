package com.tnkfactory.ad.pub.a;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.InterstitialAdItem;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class h0 extends r {
    public InterstitialAdItem f;
    public t0 g;

    public class b implements Runnable {
        public final /* synthetic */ k1 a;

        public b(k1 k1Var) {
            this.a = k1Var;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
        @Override // java.lang.Runnable
        public final void run() {
            t0 t0Var;
            h0 h0Var = h0.this;
            k1 k1Var = this.a;
            h0Var.getClass();
            Context context = k1Var.getContext();
            int[] viewSize = k1Var.getViewSize();
            int i = viewSize[0];
            int i2 = viewSize[1];
            com.tnkfactory.ad.pub.a aVar = h0Var.e;
            int i3 = t0.q;
            try {
                System.currentTimeMillis();
                t0Var = new t0(context, i, i2, aVar);
            } catch (Exception e) {
                e.printStackTrace();
                t0Var = null;
            }
            h0Var.g = t0Var;
            if (t0Var == null || !t0Var.j) {
                k1Var.a();
                h0Var.d = 0;
                com.tnkfactory.ad.pub.a aVar2 = h0Var.e;
                if (aVar2 != null) {
                    aVar2.d0.clear();
                    h0Var.e = null;
                }
                h0Var.a(h0Var.f, AdError.FAIL_AD_FRAME);
                return;
            }
            t0Var.c = new i0(h0Var);
            t0Var.i = h0Var.c;
            if (k1Var.f2874b) {
                int[] viewSize2 = k1Var.getViewSize();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewSize2[0], viewSize2[1]);
                layoutParams.gravity = 17;
                FrameLayout frameLayout = new FrameLayout(k1Var.getContext());
                frameLayout.setLayoutParams(layoutParams);
                k1Var.addView(frameLayout);
                frameLayout.addView(t0Var);
            } else {
                k1Var.addView(t0Var);
            }
            t0Var.e();
            long j = t0Var.d.S;
            if (j > 0) {
                u0 u0Var = new u0(t0Var);
                t0Var.o = u0Var;
                t0Var.e.postDelayed(u0Var, j * 1000);
            }
            y0.a(context).a(h0Var.a);
        }
    }

    public h0(AdItem adItem, String str) {
        super(str);
        this.f = (InterstitialAdItem) adItem;
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void a() {
        this.g.e.sendEmptyMessage(0);
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void c(Context context) {
        InterstitialAdItem interstitialAdItem;
        AdError adError;
        if (!d()) {
            interstitialAdItem = this.f;
            adError = AdError.FAIL_NO_PLACEMENT_ID;
        } else if (this.d != 0) {
            interstitialAdItem = this.f;
            adError = AdError.FAIL_DUP_LOAD;
        } else {
            if (a(context)) {
                this.d = 1;
                l0.a aVarB = l0.b(context);
                com.tnkfactory.ad.pub.b.j jVar = new com.tnkfactory.ad.pub.b.j(context);
                String str = this.a;
                int i = aVarB.c;
                jVar.a(str, i == 0 ? 0 : 1, new a());
                return;
            }
            interstitialAdItem = this.f;
            adError = AdError.FAIL_CANCELED;
        }
        a(interstitialAdItem, adError);
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void e(Context context) {
        InterstitialAdItem interstitialAdItem;
        AdError adError;
        int i = this.d;
        if (i == 3) {
            interstitialAdItem = this.f;
            adError = AdError.FAIL_DUP_SHOW;
        } else {
            if (i != 0 && i != 1) {
                this.d = 3;
                k1 k1Var = new k1(context);
                if (!k1Var.a(this.e.O) || ((Activity) context).isFinishing()) {
                    a(this.f, AdError.FAIL_FINISHED_ACTIVITY);
                    return;
                } else {
                    k1Var.post(new b(k1Var));
                    return;
                }
            }
            interstitialAdItem = this.f;
            adError = AdError.FAIL_SHOW_BEFORE_LOAD;
        }
        a(interstitialAdItem, adError);
    }

    public class a extends com.tnkfactory.ad.pub.b.r {
        public a() {
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Throwable th) {
            h0.this.d = 0;
            Logger.e(com.tnkfactory.ad.pub.a.a.a("error #2102 : ").append(th.toString()).toString());
            h0 h0Var = h0.this;
            h0Var.a(h0Var.f, AdError.FAIL_SYSTEM);
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Object obj) {
            h0 h0Var = h0.this;
            com.tnkfactory.ad.pub.a aVar = (com.tnkfactory.ad.pub.a) obj;
            h0Var.e = aVar;
            if (aVar != null && !aVar.a) {
                h0Var.d = 2;
                h0Var.b(h0Var.f);
            } else {
                h0Var.d = 0;
                AdError adErrorC = aVar == null ? AdError.FAIL_NO_AD : aVar.c();
                h0 h0Var2 = h0.this;
                h0Var2.a(h0Var2.f, adErrorC);
            }
        }
    }
}
