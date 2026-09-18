package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0956Gi implements RC {
    public static boolean A04;
    public static byte[] A05;
    public static final RA A06;
    public static final String A07;
    public long A00 = 0;
    public final RE A01;
    public final RB A02;
    public final RH A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{127, -88, -85, -100, -94, -89, -96, 89, -89, -98, -79, -83, 89, -84, -78, -89, -100, 89, -102, -83, 89, -77, -57, -40, -47, -122, -57, -39, -122, -44, -43, -122, -39, -33, -44, -55, -50, -40, -43, -44, -49, -32, -57, -38, -49, -43, -44, -122, -39, -55, -50, -53, -54, -37, -46, -53, -54, -108, -122, -78, -57, -39, -38, -122, -39, -33, -44, -55, -122, -57, -38, -122, -117, -54, -108, -122, -76, -53, -34, -38, -122, -39, -33, -44, -55, -122, -57, -38, -122, -117, -54, -108, -51, -26, -33, -33, -22, -102, -32, -23, -20, -102, -97, -34, -102, -25, -29, -26, -26, -29, -19, -88, -14, -15, -43, -8, -15, -55, -20, -15, -20, -10, -21, -24, -25};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.RC
    public final synchronized void A5g(int i) {
        long jA4v = this.A03.A4v() + (((long) i) * 1000000 * ((long) (A04 ? 1 : 1000)));
        long j = this.A00;
        if (j == 0 || j > jA4v) {
            this.A00 = jA4v;
            notifyAll();
        }
    }

    static {
        A02();
        A07 = C0956Gi.class.getSimpleName();
        A06 = new Gk();
        A04 = false;
    }

    public C0956Gi(RB rb, RH rh) {
        this.A02 = rb;
        this.A03 = rh;
        Thread scheduler = new Thread(new RD(this));
        scheduler.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        while (true) {
            synchronized (this) {
                if (this.A00 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    long jA4v = this.A03.A4v();
                    long j = this.A00;
                    if (jA4v < j) {
                        int millisToSleep = (int) ((j - jA4v) / 1000000);
                        if (millisToSleep >= 1) {
                            String.format(Locale.US, A00(92, 20, 69), Integer.valueOf(millisToSleep));
                            try {
                                long current = millisToSleep;
                                this.A03.AFf(this, current);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                    this.A00 = 0L;
                    this.A02.AEp();
                    long jA4v2 = this.A03.A4v();
                    if (this.A01 != null) {
                        throw new NullPointerException(A00(112, 13, 78));
                    }
                    synchronized (this) {
                        if (this.A00 < jA4v2) {
                            Locale locale = Locale.US;
                            String strA00 = A00(21, 71, 49);
                            long current2 = this.A00;
                            String.format(locale, strA00, Long.valueOf(jA4v2), Long.valueOf(current2));
                            this.A00 = 0L;
                        }
                    }
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.RC
    public final synchronized void A5h() {
        this.A00 = this.A03.A4v();
        String str = A00(0, 21, 4) + this.A00;
        notifyAll();
    }
}
