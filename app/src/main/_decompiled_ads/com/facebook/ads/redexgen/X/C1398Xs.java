package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1398Xs implements InterfaceC1207Qf {
    public static byte[] A01;
    public final Y9 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-2, -45, -20, -24, -45, -10, 21, 21, 18, -45, -8, 21, 27, 26, 15, 20, 13, -45, -6, 21, 17, 11, 20, 102, 100, 86, 99, 30, 82, 88, 86, 95, 101};
    }

    public C1398Xs(Y9 y9) {
        this.A00 = y9;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1207Qf
    public final Map<String, String> A5k(boolean z) {
        HashMap map = new HashMap();
        if (!AnonymousClass62.A00().A04()) {
            map.put(A00(0, 23, 39), C8S.A00().A01(this.A00, true).A0A());
        }
        map.put(A00(23, 10, 114), C8W.A06(new AnonymousClass87(this.A00), this.A00, z));
        return map;
    }
}
