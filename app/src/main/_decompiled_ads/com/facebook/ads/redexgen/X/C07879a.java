package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C07879a {
    public static byte[] A0F;
    public long A00;
    public C07879a A01;
    public C07889b A02;
    public TrackGroupArray A03;
    public GS A04;
    public boolean A05;
    public boolean A06;
    public GS A07;
    public final InterfaceC1337Vg A08;
    public final Object A09;
    public final InterfaceC0916Et[] A0A;
    public final boolean[] A0B;
    public final EY A0C;
    public final GR A0D;
    public final InterfaceC08059s[] A0E;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 30);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0F = new byte[]{79, 103, 102, 107, 99, 82, 103, 112, 107, 109, 102, 74, 109, 110, 102, 103, 112, 81, 100, 115, 104, 110, 101, 33, 115, 100, 109, 100, 96, 114, 100, 33, 103, 96, 104, 109, 100, 101, 47};
    }

    public C07879a(InterfaceC08059s[] interfaceC08059sArr, long j, GR gr, GU gu, EY ey, Object obj, C07889b c07889b) {
        this.A0E = interfaceC08059sArr;
        this.A00 = j - c07889b.A03;
        this.A0D = gr;
        this.A0C = ey;
        this.A09 = HI.A01(obj);
        this.A02 = c07889b;
        this.A0A = new InterfaceC0916Et[interfaceC08059sArr.length];
        this.A0B = new boolean[interfaceC08059sArr.length];
        InterfaceC1337Vg interfaceC1337VgA4g = ey.A4g(c07889b.A04, gu);
        this.A08 = c07889b.A02 != Long.MIN_VALUE ? new BW(interfaceC1337VgA4g, true, 0L, c07889b.A02) : interfaceC1337VgA4g;
    }

    private void A02(GS gs) {
        for (int i = 0; i < i; i++) {
            boolean rendererEnabled = gs.A00(i);
            GO goA00 = gs.A01.A00(i);
            if (rendererEnabled && goA00 != null) {
                goA00.A5P();
            }
        }
    }

    private void A03(GS gs) {
        GS gs2 = this.A07;
        this.A07 = gs;
        if (gs != null) {
            A02(gs);
        }
    }

    private void A04(InterfaceC0916Et[] interfaceC0916EtArr) {
        int i = 0;
        while (true) {
            InterfaceC08059s[] interfaceC08059sArr = this.A0E;
            int i2 = interfaceC08059sArr.length;
            if (i < i2) {
                if (interfaceC08059sArr[i].A83() == 5 && this.A04.A00(i)) {
                    interfaceC0916EtArr[i] = new C1342Vl();
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void A05(InterfaceC0916Et[] interfaceC0916EtArr) {
        int i = 0;
        while (true) {
            InterfaceC08059s[] interfaceC08059sArr = this.A0E;
            int i2 = interfaceC08059sArr.length;
            if (i < i2) {
                if (interfaceC08059sArr[i].A83() == 5) {
                    interfaceC0916EtArr[i] = null;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final long A06() {
        if (this.A06) {
            return this.A08.A7M();
        }
        return 0L;
    }

    public final long A07() {
        return this.A00;
    }

    public final long A08(long j) {
        return j - A07();
    }

    public final long A09(long j) {
        return A07() + j;
    }

    public final long A0A(long j, boolean z) {
        return A0B(j, z, new boolean[this.A0E.length]);
    }

    public final long A0B(long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            int i2 = this.A04.A00;
            boolean z2 = false;
            if (i >= i2) {
                break;
            }
            boolean[] zArr2 = this.A0B;
            if (!z && this.A04.A02(this.A07, i)) {
                z2 = true;
            }
            zArr2[i] = z2;
            i++;
        }
        A05(this.A0A);
        A03(this.A04);
        GP gp = this.A04.A01;
        long jAF1 = this.A08.AF1(gp.A01(), this.A0B, this.A0A, zArr, j);
        A04(this.A0A);
        this.A05 = false;
        int i3 = 0;
        while (true) {
            InterfaceC0916Et[] interfaceC0916EtArr = this.A0A;
            if (i3 < interfaceC0916EtArr.length) {
                if (interfaceC0916EtArr[i3] != null) {
                    HI.A04(this.A04.A00(i3));
                    int i4 = this.A0E[i3].A83();
                    if (i4 != 5) {
                        this.A05 = true;
                    }
                } else {
                    HI.A04(gp.A00(i3) == null);
                }
                i3++;
            } else {
                return jAF1;
            }
        }
    }

    public final long A0C(boolean z) {
        if (!this.A06) {
            return this.A02.A03;
        }
        long jA68 = this.A08.A68();
        if (jA68 == Long.MIN_VALUE && z) {
            return this.A02.A01;
        }
        return jA68;
    }

    public final void A0D() {
        A03(null);
        try {
            if (this.A02.A02 != Long.MIN_VALUE) {
                this.A0C.AET(((BW) this.A08).A05);
            } else {
                this.A0C.AET(this.A08);
            }
        } catch (RuntimeException e) {
            Log.e(A00(0, 17, 28), A00(17, 22, 31), e);
        }
    }

    public final void A0E(float f) throws C9K {
        this.A06 = true;
        this.A03 = this.A08.A82();
        A0I(f);
        long jA0A = A0A(this.A02.A03, false);
        long j = this.A00;
        long newStartPositionUs = this.A02.A03;
        this.A00 = j + (newStartPositionUs - jA0A);
        this.A02 = this.A02.A01(jA0A);
    }

    public final void A0F(long j) {
        this.A08.A4Q(A08(j));
    }

    public final void A0G(long j) {
        if (this.A06) {
            this.A08.AEK(A08(j));
        }
    }

    public final boolean A0H() {
        return this.A06 && (!this.A05 || this.A08.A68() == Long.MIN_VALUE);
    }

    public final boolean A0I(float f) throws C9K {
        GS gsA0T = this.A0D.A0T(this.A0E, this.A03);
        GS selectorResult = this.A07;
        if (gsA0T.A01(selectorResult)) {
            return false;
        }
        this.A04 = gsA0T;
        for (GO go : gsA0T.A01.A01()) {
            if (go != null) {
                go.ACP(f);
            }
        }
        return true;
    }
}
