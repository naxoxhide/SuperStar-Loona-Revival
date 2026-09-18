package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4Z, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C4Z {
    @Deprecated
    private final void A00(Rect rect, int i, ED ed) {
        rect.set(0, 0, 0, 0);
    }

    public final void A01(Rect rect, View view, ED ed, C06864r c06864r) {
        A00(rect, ((C06734d) view.getLayoutParams()).A00(), ed);
    }
}
