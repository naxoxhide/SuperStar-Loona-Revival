package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class H8 {
    public static String[] A00 = {"QVkvGuTrNYCOXAoNAePTggpZ9p9y8rjH", "Ru98bprrD7b3UUfLrlKs", "", "dJgVNsDePsDRNqW", "8CeCwhAARX5BeZctdCHITAez339E1kKv", "TdcchyCe9I3Btqth6iKX4VQ7acLjRTHE", "dxVA2OdEqxN0v6bZFx4Cf7LzvY6ZoBAr", "aJerxmZYtdmBHI5cIDnwKt2ezc6XXR2j"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x009e: INVOKE (r3 I:com.facebook.ads.redexgen.X.Gc) STATIC call: com.facebook.ads.redexgen.X.Hx.A0W(com.facebook.ads.redexgen.X.Gc):void A[MD:(com.facebook.ads.redexgen.X.Gc):void (m)], block:B:37:0x009e */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00ae: INVOKE (r3 I:com.facebook.ads.redexgen.X.Gc) STATIC call: com.facebook.ads.redexgen.X.Hx.A0W(com.facebook.ads.redexgen.X.Gc):void A[MD:(com.facebook.ads.redexgen.X.Gc):void (m)], block:B:43:0x00ae */
    public static long A00(C0955Gg c0955Gg, long j, long j2, InterfaceC0951Gc interfaceC0951Gc, byte[] bArr, C0984Hl c0984Hl, int i, H7 h7) throws InterruptedException, IOException {
        InterfaceC0951Gc interfaceC0951GcA0W;
        InterfaceC0951Gc interfaceC0951GcA0W2;
        while (true) {
            if (c0984Hl != null) {
                c0984Hl.A01(i);
            }
            try {
                break;
            } catch (C0983Hk unused) {
                C0996Hx.A0W(interfaceC0951GcA0W2);
            } catch (Throwable th) {
                C0996Hx.A0W(interfaceC0951GcA0W);
                throw th;
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        C0955Gg c0955Gg2 = new C0955Gg(c0955Gg.A04, c0955Gg.A06, j, (c0955Gg.A03 + j) - c0955Gg.A01, -1L, c0955Gg.A05, c0955Gg.A00 | 2);
        long jADb = interfaceC0951Gc.ADb(c0955Gg2);
        if (h7.A01 == -1 && jADb != -1) {
            h7.A01 = c0955Gg2.A01 + jADb;
        }
        long j3 = 0;
        while (j3 != j2) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i2 = interfaceC0951Gc.read(bArr, 0, j2 != -1 ? (int) Math.min(bArr.length, j2 - j3) : bArr.length);
            if (A00[3].length() != 15) {
                throw new RuntimeException();
            }
            A00[1] = "Mr4dmhY4u";
            if (i2 == -1) {
                if (h7.A01 != -1) {
                    break;
                }
                h7.A01 = c0955Gg2.A01 + j3;
                break;
            }
            j3 += (long) i2;
            h7.A02 += (long) i2;
        }
        C0996Hx.A0W(interfaceC0951Gc);
        return j3;
    }

    public static String A01(Uri uri) {
        return uri.toString();
    }

    public static String A02(C0955Gg c0955Gg) {
        if (c0955Gg.A05 != null) {
            return c0955Gg.A05;
        }
        Uri uri = c0955Gg.A04;
        if (A00[0].charAt(11) != 'O') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[5] = "cu8QQJDviMrw4mI2sOy5Vu7yKrvbPHoQ";
        strArr[7] = "0ihZqD29ZbZOvC3sCo5KdBScvHoXIGQ7";
        return A01(uri);
    }

    public static void A03(C0955Gg c0955Gg, H2 h2, V0 v0, byte[] bArr, C0984Hl c0984Hl, int i, H7 h7, AtomicBoolean atomicBoolean, boolean z) throws InterruptedException, IOException {
        long start;
        H7 h8 = h7;
        HI.A01(v0);
        HI.A01(bArr);
        if (h8 != null) {
            A04(c0955Gg, h2, h8);
        } else {
            h8 = new H7();
        }
        String strA02 = A02(c0955Gg);
        long j = c0955Gg.A01;
        long start2 = c0955Gg.A02;
        if (start2 != -1) {
            start = c0955Gg.A02;
        } else {
            start = h2.A6Q(strA02);
        }
        while (true) {
            long j2 = 0;
            if (start != 0) {
                if (atomicBoolean == null || !atomicBoolean.get()) {
                    long jA6B = h2.A6B(strA02, j, start != -1 ? start : Long.MAX_VALUE);
                    if (jA6B <= 0) {
                        long j3 = -jA6B;
                        jA6B = j3;
                        if (A00(c0955Gg, j, j3, v0, bArr, c0984Hl, i, h8) < jA6B) {
                            if (!z || start == -1) {
                                return;
                            } else {
                                throw new EOFException();
                            }
                        }
                    }
                    j += jA6B;
                    if (start != -1) {
                        j2 = jA6B;
                    }
                    start -= j2;
                } else {
                    throw new InterruptedException();
                }
            } else {
                return;
            }
        }
    }

    public static void A04(C0955Gg c0955Gg, H2 h2, H7 h7) {
        long left;
        String strA02 = A02(c0955Gg);
        long j = c0955Gg.A01;
        if (c0955Gg.A02 != -1) {
            left = c0955Gg.A02;
        } else {
            left = h2.A6Q(strA02);
        }
        h7.A01 = left;
        h7.A00 = 0L;
        h7.A02 = 0L;
        while (left != 0) {
            long jA6B = h2.A6B(strA02, j, left != -1 ? left : Long.MAX_VALUE);
            if (jA6B > 0) {
                h7.A00 += jA6B;
            } else {
                jA6B = -jA6B;
                if (jA6B == Long.MAX_VALUE) {
                    return;
                }
            }
            j += jA6B;
            if (left == -1) {
                jA6B = 0;
            }
            left -= jA6B;
        }
    }

    public static void A05(H2 h2, String str) {
        Iterator<H6> it = h2.A6C(str).iterator();
        while (it.hasNext()) {
            try {
                h2.AEZ(it.next());
            } catch (H0 unused) {
            }
        }
    }
}
