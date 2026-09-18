package com.facebook.ads.redexgen.X;

import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1174Oy implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C8C A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{116, 75, 70, 71, 77, 114, 78, 67, 91, SignedBytes.MAX_POWER_OF_TWO, 67, 65, 73, 103, 80, 80, 77, 80};
    }

    public RunnableC1174Oy(C8C c8c) {
        this.A00 = c8c;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0F.ADN(A00(0, 18, 116));
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
