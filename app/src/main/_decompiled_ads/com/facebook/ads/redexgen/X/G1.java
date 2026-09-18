package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class G1 implements InterfaceC1557bk {
    public final List<InterfaceC1558bl> A00 = new ArrayList();

    @Override // com.facebook.ads.redexgen.X.InterfaceC1557bk
    public final InterfaceC1558bl A5m(int i) {
        return this.A00.get(i);
    }

    @Override // java.lang.Iterable
    public final Iterator<InterfaceC1558bl> iterator() {
        return this.A00.iterator();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1557bk
    public final int size() {
        return this.A00.size();
    }
}
