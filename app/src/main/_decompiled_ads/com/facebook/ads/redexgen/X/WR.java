package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WR implements InterfaceC0838Ba {
    public static byte[] A04;
    public static String[] A05 = {"89ZAS4gKAvfsCOhGFLRndaPlzH5Jylu0", "WDj0w8iYShPhw5JkNLQVjMzFidij1YMB", "SZD8V9ebG6DMCxkEToUDQHseHkwYH45y", "flB69VC8Ebs69L5nDVZVAs6kLxLMfW9p", "Dc9Giep11FBAOEJK", "fiVRhSZcsaoyqUlEeIiHO4czNXpaN55t", "HHz5E2PDkz6p7na9zQig", "GASwop9kiLfFsL9tAHZWlbr16muWtU3x"};
    public static final InterfaceC0841Bd A06;
    public static final int A07;
    public boolean A00;
    public final long A01;
    public final WQ A02;
    public final C0980Hh A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-8, -13, -30};
        if (A05[3].charAt(6) != 'C') {
            throw new RuntimeException();
        }
        A05[6] = "Dcf";
    }

    static {
        A01();
        A06 = new WS();
        A07 = C0996Hx.A08(A00(0, 3, 105));
    }

    public WR() {
        this(0L);
    }

    public WR(long j) {
        this.A01 = j;
        this.A02 = new WQ();
        this.A03 = new C0980Hh(2786);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void A8e(InterfaceC0840Bc interfaceC0840Bc) {
        this.A02.A4l(interfaceC0840Bc, new C0870Cu(0, 1));
        interfaceC0840Bc.A5T();
        interfaceC0840Bc.AEx(new X0(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final int AE9(InterfaceC0839Bb interfaceC0839Bb, C0843Bh c0843Bh) throws InterruptedException, IOException {
        int i = interfaceC0839Bb.read(this.A03.A00, 0, 2786);
        if (i == -1) {
            return -1;
        }
        this.A03.A0Y(0);
        this.A03.A0X(i);
        if (!this.A00) {
            this.A02.ADj(this.A01, true);
            this.A00 = true;
        }
        this.A02.A4O(this.A03);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void AEw(long j, long j2) {
        this.A00 = false;
        this.A02.AEv();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final boolean AFg(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        C0980Hh c0980Hh = new C0980Hh(10);
        int startPosition = 0;
        while (true) {
            interfaceC0839Bb.ADl(c0980Hh.A00, 0, 10);
            c0980Hh.A0Y(0);
            if (c0980Hh.A0G() != A07) {
                break;
            }
            c0980Hh.A0Z(3);
            int iA0D = c0980Hh.A0D();
            startPosition += iA0D + 10;
            interfaceC0839Bb.A3S(iA0D);
        }
        interfaceC0839Bb.AEm();
        interfaceC0839Bb.A3S(startPosition);
        int syncBytes = startPosition;
        int i = 0;
        while (true) {
            interfaceC0839Bb.ADl(c0980Hh.A00, 0, 5);
            c0980Hh.A0Y(0);
            int headerPosition = c0980Hh.A0I();
            if (headerPosition != 2935) {
                i = 0;
                interfaceC0839Bb.AEm();
                syncBytes++;
                int headerPosition2 = syncBytes - startPosition;
                if (headerPosition2 >= 8192) {
                    return false;
                }
                interfaceC0839Bb.A3S(syncBytes);
            } else {
                i++;
                if (i >= 4) {
                    return true;
                }
                int headerPosition3 = A8.A05(c0980Hh.A00);
                if (headerPosition3 == -1) {
                    return false;
                }
                interfaceC0839Bb.A3S(headerPosition3 - 5);
            }
        }
    }
}
