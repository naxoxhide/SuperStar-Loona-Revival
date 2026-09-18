package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WO implements InterfaceC0838Ba {
    public static byte[] A04;
    public static String[] A05 = {"zdP8mq1V4qx9ZCdsfAD4NG7cLFVpQAAe", "koAkuIv", "fyRTvmHGGGsRl9BV6D3JToZwd0QymLEV", "Ol6FmQC", "pWzJ4KWOtVeOprDRKRooJjLfCIz1i7Yl", "FaGWZpOEFJ3DEiDU22ljd64Ld5pUV9HD", "txEKQBUTk3v9kOkzxdvVTnLo1IME9gDG", "VQ1knBpCfCAoSCLl3kVfN2N5wBdN5LBp"};
    public static final InterfaceC0841Bd A06;
    public static final int A07;
    public boolean A00;
    public final long A01;
    public final WN A02;
    public final C0980Hh A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A05;
            if (strArr[2].charAt(21) == strArr[4].charAt(21)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[6] = "6nR4pRT1Z5KTQHbqvhpghrBhlvQkSoKV";
            strArr2[5] = "SkXTa4uQceGhkSQtr6wVij7rDC15CMq5";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 67);
            i4++;
        }
    }

    public static void A01() {
        A04 = new byte[]{66, 79, 56};
    }

    static {
        A01();
        A06 = new WP();
        A07 = C0996Hx.A08(A00(0, 3, 72));
    }

    public WO() {
        this(0L);
    }

    public WO(long j) {
        this.A01 = j;
        this.A02 = new WN(true);
        this.A03 = new C0980Hh(200);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void A8e(InterfaceC0840Bc interfaceC0840Bc) {
        this.A02.A4l(interfaceC0840Bc, new C0870Cu(0, 1));
        interfaceC0840Bc.A5T();
        interfaceC0840Bc.AEx(new X0(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final int AE9(InterfaceC0839Bb interfaceC0839Bb, C0843Bh c0843Bh) throws InterruptedException, IOException {
        int i = interfaceC0839Bb.read(this.A03.A00, 0, 200);
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
        C0979Hg c0979Hg = new C0979Hg(c0980Hh.A00);
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
        int validFramesCount = 0;
        int i = 0;
        while (true) {
            interfaceC0839Bb.ADl(c0980Hh.A00, 0, 2);
            c0980Hh.A0Y(0);
            int headerPosition = 65526 & c0980Hh.A0I();
            if (headerPosition != 65520) {
                i = 0;
                validFramesCount = 0;
                interfaceC0839Bb.AEm();
                syncBytes++;
                int headerPosition2 = syncBytes - startPosition;
                if (headerPosition2 >= 8192) {
                    return false;
                }
                interfaceC0839Bb.A3S(syncBytes);
            } else {
                i++;
                if (i >= 4 && validFramesCount > 188) {
                    return true;
                }
                interfaceC0839Bb.ADl(c0980Hh.A00, 0, 4);
                c0979Hg.A07(14);
                int headerPosition3 = c0979Hg.A04(13);
                if (headerPosition3 <= 6) {
                    return false;
                }
                interfaceC0839Bb.A3S(headerPosition3 - 6);
                validFramesCount += headerPosition3;
            }
        }
    }
}
