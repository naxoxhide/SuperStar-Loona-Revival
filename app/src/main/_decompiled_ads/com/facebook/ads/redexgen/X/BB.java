package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.UUID;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class BB extends Exception {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ WorkQueueKt.MASK);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{47, 7, 6, 11, 3, 66, 6, 13, 7, 17, 66, 12, 13, 22, 66, 17, 23, 18, 18, 13, 16, 22, 66, 23, 23, 11, 6, 88, 66};
    }

    public BB(UUID uuid) {
        super(A00(0, 29, 29) + uuid);
    }
}
