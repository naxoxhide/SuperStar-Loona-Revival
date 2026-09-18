package com.facebook.ads.redexgen.X;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ai, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0820Ai extends ZB {
    public final /* synthetic */ C0813Ab A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.ZB
    public final int A0O(View view, int i) {
        AbstractC06724c abstractC06724cA08 = A08();
        if (!abstractC06724cA08.A24()) {
            return 0;
        }
        C06734d c06734d = (C06734d) view.getLayoutParams();
        return A0N(abstractC06724cA08.A0k(view) - c06734d.leftMargin, abstractC06724cA08.A0n(view) + c06734d.rightMargin, abstractC06724cA08.A0e(), abstractC06724cA08.A0h() - abstractC06724cA08.A0f(), i) + this.A00.A02;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0820Ai(C0813Ab c0813Ab, YA ya) {
        super(ya);
        this.A00 = c0813Ab;
    }

    @Override // com.facebook.ads.redexgen.X.ZB
    public final float A0J(DisplayMetrics displayMetrics) {
        return this.A00.A00 / displayMetrics.densityDpi;
    }

    @Override // com.facebook.ads.redexgen.X.ZB
    public final int A0K() {
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.ZB
    public final PointF A0P(int i) {
        return this.A00.A4L(i);
    }
}
