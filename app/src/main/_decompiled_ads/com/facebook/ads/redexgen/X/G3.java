package com.facebook.ads.redexgen.X;

import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class G3 implements RO {
    public final C0958Gl A00;
    public final RT A01;

    public G3(C0958Gl c0958Gl, RT rt) {
        this.A00 = c0958Gl;
        this.A01 = rt;
    }

    @Override // com.facebook.ads.redexgen.X.RO
    public void A3V(Map<R6, RT> map, Map<InterfaceC0954Gf, RG> map2) {
        map.put(this.A00, this.A01);
    }
}
