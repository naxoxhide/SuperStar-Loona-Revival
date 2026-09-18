package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Np, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1139Np {
    public static final int A00 = LV.A00();

    public static void A00(YA ya, ViewGroup viewGroup, String str) {
        new T8(viewGroup, ya).A07(str);
        View view = new View(ya);
        view.setId(A00);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LV.A0R(view, ya);
        viewGroup.addView(view, 0);
    }
}
