package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.FeedAdView;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 extends r {
    public FeedAdView f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;

    public e0(AdItem adItem, String str) {
        super(str);
        FeedAdView feedAdView = (FeedAdView) adItem;
        this.f = feedAdView;
        l0.a aVarB = l0.b(feedAdView.getContext());
        this.h = aVarB.e();
        this.i = aVarB.c();
        float f = this.h;
        this.j = f;
        this.k = f / 3.2f;
        this.g = (int) TypedValue.applyDimension(1, 90.0f, this.f.getResources().getDisplayMetrics());
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final int[] a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE && mode == 0) {
            size = this.h;
        }
        this.j = size;
        float f = this.j;
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
            size2 = this.i;
        }
        this.k = size2;
        float f2 = this.k;
        float f3 = this.j;
        if (f3 / f2 > 3.2f) {
            this.j = 3.2f * f2;
        } else {
            float f4 = f3 / 3.2f;
            this.k = f4;
            if (mode2 != 1073741824) {
                f2 = f4;
            }
        }
        return new int[]{(int) f, (int) f2};
    }

    @Override // com.tnkfactory.ad.pub.a.r
    public final void c(Context context) {
        if (!d()) {
            a(this.f, AdError.FAIL_NO_PLACEMENT_ID);
        } else if (this.d != 0) {
            a(this.f, AdError.FAIL_DUP_LOAD);
        } else {
            this.d = 1;
            new com.tnkfactory.ad.pub.b.i(context).a(this.a, 5, new a());
        }
    }

    public class a extends com.tnkfactory.ad.pub.b.r {
        public a() {
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Throwable th) {
            e0.this.d = 0;
            Logger.e(com.tnkfactory.ad.pub.a.a.a("error #2102 : ").append(th.toString()).toString());
            e0 e0Var = e0.this;
            e0Var.a(e0Var.f, AdError.FAIL_SYSTEM);
        }

        @Override // com.tnkfactory.ad.pub.b.r
        public final void a(Object obj) {
            e0 e0Var = e0.this;
            com.tnkfactory.ad.pub.a aVar = (com.tnkfactory.ad.pub.a) obj;
            e0Var.e = aVar;
            if (aVar != null && !aVar.a) {
                e0Var.d = 2;
                e0Var.b(e0Var.f);
                e0 e0Var2 = e0.this;
                e0Var2.f.post(new f0(e0Var2));
                return;
            }
            e0Var.d = 0;
            AdError adErrorC = aVar == null ? AdError.FAIL_NO_AD : aVar.c();
            e0 e0Var3 = e0.this;
            e0Var3.a(e0Var3.f, adErrorC);
        }
    }
}
