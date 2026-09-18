package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VU implements FW {
    public final C0942Ft A00;
    public final Map<String, C0948Fz> A01;
    public final Map<String, C0943Fu> A02;
    public final long[] A03;

    public VU(C0942Ft c0942Ft, Map<String, C0948Fz> map, Map<String, C0943Fu> map2) {
        Map<String, C0948Fz> mapEmptyMap;
        this.A00 = c0942Ft;
        this.A02 = map2;
        if (map != null) {
            mapEmptyMap = Collections.unmodifiableMap(map);
        } else {
            mapEmptyMap = Collections.emptyMap();
        }
        this.A01 = mapEmptyMap;
        this.A03 = c0942Ft.A0F();
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final List<FV> A6T(long j) {
        return this.A00.A0D(j, this.A01, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final long A6t(int i) {
        return this.A03[i];
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final int A6u() {
        return this.A03.length;
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final int A7L(long j) {
        int iA0A = C0996Hx.A0A(this.A03, j, false, false);
        int index = this.A03.length;
        if (iA0A < index) {
            return iA0A;
        }
        return -1;
    }
}
