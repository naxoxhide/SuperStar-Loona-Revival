package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6B {
    public static C6C A00;
    public static boolean A01;
    public static byte[] A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-24, -21, -12, -23, -18, -13, -25, -8, -15};
    }

    static {
        A02();
        A01 = false;
        A00 = null;
    }

    public static void A01() {
        synchronized (C6B.class) {
            if (A00 == null) {
                return;
            }
            C07607y c07607y = new C07607y(A00.AEe());
            c07607y.A03(1);
            Y9 y9A00 = C7R.A00();
            if (y9A00 != null) {
                y9A00.A07().A9M(A00(0, 9, 109), 3401, c07607y);
            }
            A00.reset();
        }
    }

    public static void A03(final long j) {
        if (j > 0) {
            A00 = new YJ();
            new Thread(j) { // from class: com.facebook.ads.redexgen.X.6D
                public final long A00;

                {
                    this.A00 = j;
                    start();
                }

                /* JADX WARN: Bottom block not found for handler: all -> 0x0011 */
                @Override // java.lang.Thread, java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() throws java.lang.Throwable {
                    /*
                        r3 = this;
                        boolean r0 = com.facebook.ads.redexgen.X.K0.A02(r3)
                        if (r0 == 0) goto L7
                        return
                    L7:
                        r2 = r3
                    L8:
                        long r0 = r2.A00     // Catch: java.lang.InterruptedException -> Ld java.lang.Throwable -> L11
                        java.lang.Thread.sleep(r0)     // Catch: java.lang.InterruptedException -> Ld java.lang.Throwable -> L11
                    Ld:
                        com.facebook.ads.redexgen.X.C6B.A01()     // Catch: java.lang.Throwable -> L11
                        goto L8
                    L11:
                        r0 = move-exception
                        com.facebook.ads.redexgen.X.K0.A00(r0, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6D.run():void");
                }
            };
        }
    }
}
