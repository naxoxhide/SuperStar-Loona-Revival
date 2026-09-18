package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1538bR {
    public final InterfaceC1542bV A00;
    public final String A01;
    public final Collection<C1553bg> A02;
    public final Collection<C1553bg> A03;
    public final List<Rect> A04;

    public C1538bR(String str, InterfaceC1542bV interfaceC1542bV, List<Rect> rects, Collection<C1553bg> collection, Collection<C1553bg> collection2) {
        this.A01 = str;
        this.A00 = interfaceC1542bV;
        this.A04 = new ArrayList(rects);
        this.A02 = collection;
        this.A03 = collection2;
    }
}
