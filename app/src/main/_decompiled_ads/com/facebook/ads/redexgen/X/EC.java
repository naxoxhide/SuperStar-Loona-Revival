package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EC extends ZB {
    public final /* synthetic */ AbstractC1428Yw A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EC(AbstractC1428Yw abstractC1428Yw, Context context) {
        super(context);
        this.A00 = abstractC1428Yw;
    }

    @Override // com.facebook.ads.redexgen.X.ZB, com.facebook.ads.redexgen.X.AbstractC06844p
    public final void A0I(View view, C06864r c06864r, C06824n c06824n) {
        AbstractC1428Yw abstractC1428Yw = this.A00;
        int[] iArrA0H = abstractC1428Yw.A0H(abstractC1428Yw.A00.getLayoutManager(), view);
        int time = iArrA0H[0];
        int dy = iArrA0H[1];
        int dx = A0M(Math.max(Math.abs(time), Math.abs(dy)));
        if (dx > 0) {
            c06824n.A04(time, dy, dx, ((ZB) this).A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.ZB
    public final float A0J(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }
}
