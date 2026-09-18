package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1371Wr implements InterfaceC0852Bs {
    public static byte[] A07;
    public static String[] A08 = {"S6y5l6jxI9", "6mnEH66ZFffSlH4yeHJS8qNG", "YOAMbMDgHDJdJlquETda64yXe2Dsnigk", "hsyrHKVntalAWTsGKMDD", "vPfGZ", "fU8euoLNwl", "f8hQ6WKdo4yu3", "0USUeFTSnT76dGHmDwgcSkrJJgtZvyOb"};
    public int A00;
    public int A01;
    public long A02;
    public InterfaceC0853Bu A03;
    public final byte[] A06 = new byte[8];
    public final ArrayDeque<C0851Br> A05 = new ArrayDeque<>();
    public final C0855Bz A04 = new C0855Bz();

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 40);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A07 = new byte[]{124, -95, -87, -108, -97, -100, -105, 83, -104, -97, -104, -96, -104, -95, -89, 83, -89, -84, -93, -104, 83, -100, -63, -55, -76, -65, -68, -73, 115, -71, -65, -62, -76, -57, 115, -58, -68, -51, -72, -115, 115, -27, 10, 18, -3, 8, 5, 0, -68, 5, 10, 16, 1, 3, 1, 14, -68, 15, 5, 22, 1, -42, -68, -127, -94, -96, -105, -100, -107, 78, -109, -102, -109, -101, -109, -100, -94, 78, -95, -105, -88, -109, 104, 78};
    }

    static {
        A05();
    }

    private double A00(InterfaceC0839Bb interfaceC0839Bb, int i) throws InterruptedException, IOException {
        long jA02 = A02(interfaceC0839Bb, i);
        if (i == 4) {
            return Float.intBitsToFloat((int) jA02);
        }
        return Double.longBitsToDouble(jA02);
    }

    private long A01(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        interfaceC0839Bb.AEm();
        while (true) {
            interfaceC0839Bb.ADl(this.A06, 0, 4);
            int iA00 = C0855Bz.A00(this.A06[0]);
            if (iA00 != -1 && iA00 <= 4) {
                int iA01 = (int) C0855Bz.A01(this.A06, iA00, false);
                if (this.A03.A8v(iA01)) {
                    interfaceC0839Bb.AFe(iA00);
                    return iA01;
                }
            }
            interfaceC0839Bb.AFe(1);
        }
    }

    private long A02(InterfaceC0839Bb interfaceC0839Bb, int i) throws InterruptedException, IOException {
        interfaceC0839Bb.readFully(this.A06, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long value = this.A06[i2] & 255;
            j = (j << 8) | value;
        }
        return j;
    }

    private String A04(InterfaceC0839Bb interfaceC0839Bb, int i) throws InterruptedException, IOException {
        if (i == 0) {
            return A03(0, 0, 103);
        }
        byte[] bArr = new byte[i];
        interfaceC0839Bb.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0852Bs
    public final void A8f(InterfaceC0853Bu interfaceC0853Bu) {
        this.A03 = interfaceC0853Bu;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0852Bs
    public final boolean AEB(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        HI.A04(this.A03 != null);
        while (true) {
            if (!this.A05.isEmpty()) {
                long jA7a = interfaceC0839Bb.A7a();
                C0851Br c0851BrPeek = this.A05.peek();
                if (A08[4].length() == 19) {
                    throw new RuntimeException();
                }
                A08[1] = "iTM85rd";
                if (jA7a >= c0851BrPeek.A01) {
                    this.A03.A5S(this.A05.pop().A00);
                    return true;
                }
            }
            if (this.A01 == 0) {
                long jA05 = this.A04.A05(interfaceC0839Bb, true, false, 4);
                if (jA05 == -2) {
                    jA05 = A01(interfaceC0839Bb);
                }
                if (jA05 == -1) {
                    return false;
                }
                this.A00 = (int) jA05;
                this.A01 = 1;
            }
            if (this.A01 == 1) {
                this.A02 = this.A04.A05(interfaceC0839Bb, false, true, 8);
                this.A01 = 2;
            }
            int iA6l = this.A03.A6l(this.A00);
            switch (iA6l) {
                case 0:
                    int type = (int) this.A02;
                    interfaceC0839Bb.AFe(type);
                    this.A01 = 0;
                    break;
                case 1:
                    long elementContentPosition = interfaceC0839Bb.A7a();
                    this.A05.push(new C0851Br(this.A00, elementContentPosition + this.A02));
                    InterfaceC0853Bu interfaceC0853Bu = this.A03;
                    int i = this.A00;
                    long elementEndPosition = this.A02;
                    interfaceC0853Bu.AFj(i, elementContentPosition, elementEndPosition);
                    this.A01 = 0;
                    return true;
                case 2:
                    long j = this.A02;
                    if (j <= 8) {
                        this.A03.A8j(this.A00, A02(interfaceC0839Bb, (int) j));
                        this.A01 = 0;
                        return true;
                    }
                    throw new C07909d(A03(41, 22, 116) + this.A02);
                case 3:
                    long j2 = this.A02;
                    if (j2 <= 2147483647L) {
                        this.A03.AFr(this.A00, A04(interfaceC0839Bb, (int) j2));
                        this.A01 = 0;
                        return true;
                    }
                    throw new C07909d(A03(63, 21, 6) + this.A02);
                case 4:
                    this.A03.A3y(this.A00, (int) this.A02, interfaceC0839Bb);
                    if (A08[7].charAt(2) != 'S') {
                        A08[2] = "x8X2xTnJq9Kheln0ABdW7PO8kghsREvE";
                        this.A01 = 0;
                        return true;
                    }
                    A08[4] = "mGqeeb15RRoJ11oGs7LhfnjQvY";
                    this.A01 = 0;
                    return true;
                case 5:
                    long j3 = this.A02;
                    if (j3 == 4 || j3 == 8) {
                        this.A03.A5f(this.A00, A00(interfaceC0839Bb, (int) j3));
                        this.A01 = 0;
                        return true;
                    }
                    throw new C07909d(A03(21, 20, 43) + this.A02);
                default:
                    throw new C07909d(A03(0, 21, 11) + iA6l);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0852Bs
    public final void reset() {
        this.A01 = 0;
        this.A05.clear();
        this.A04.A06();
    }
}
