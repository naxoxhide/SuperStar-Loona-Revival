package com.facebook.ads.redexgen.X;

import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class S4 extends K8 {
    public static byte[] A01;
    public final /* synthetic */ C7K A00;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{100, 91, 86, 87, 93, 18, 69, 83, 65, 18, 92, 87, 68, 87, SignedBytes.MAX_POWER_OF_TWO, 18, 66, SignedBytes.MAX_POWER_OF_TWO, 87, 66, 83, SignedBytes.MAX_POWER_OF_TWO, 87, 86};
    }

    public S4(C7K c7k) {
        this.A00 = c7k;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        if (!this.A00.A07) {
            this.A00.A0G(A00(0, 24, 76));
        }
    }
}
