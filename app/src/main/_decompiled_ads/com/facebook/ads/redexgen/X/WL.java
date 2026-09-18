package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WL implements InterfaceC0859Cg {
    public int A00;
    public int A01;
    public int A03;
    public long A04;
    public long A05;
    public Format A06;
    public InterfaceC0848Bm A07;
    public String A08;
    public final String A0A;
    public final C0980Hh A09 = new C0980Hh(new byte[18]);
    public int A02 = 0;

    public WL(String str) {
        this.A0A = str;
    }

    private void A00() {
        byte[] bArr = this.A09.A00;
        if (this.A06 == null) {
            Format formatA03 = C0821Aj.A03(bArr, this.A08, this.A0A, null);
            this.A06 = formatA03;
            this.A07.A5j(formatA03);
        }
        this.A01 = C0821Aj.A01(bArr);
        this.A04 = (int) ((((long) C0821Aj.A02(bArr)) * 1000000) / ((long) this.A06.A0C));
    }

    private boolean A01(C0980Hh c0980Hh) {
        while (c0980Hh.A04() > 0) {
            int i = this.A03 << 8;
            this.A03 = i;
            int iA0E = i | c0980Hh.A0E();
            this.A03 = iA0E;
            if (C0821Aj.A07(iA0E)) {
                this.A09.A00[0] = (byte) ((this.A03 >> 24) & 255);
                this.A09.A00[1] = (byte) ((this.A03 >> 16) & 255);
                this.A09.A00[2] = (byte) ((this.A03 >> 8) & 255);
                this.A09.A00[3] = (byte) (this.A03 & 255);
                this.A00 = 4;
                this.A03 = 0;
                return true;
            }
        }
        return false;
    }

    private boolean A02(C0980Hh c0980Hh, byte[] bArr, int i) {
        int iMin = Math.min(c0980Hh.A04(), i - this.A00);
        int bytesToRead = this.A00;
        c0980Hh.A0c(bArr, bytesToRead, iMin);
        int bytesToRead2 = this.A00;
        int bytesToRead3 = bytesToRead2 + iMin;
        this.A00 = bytesToRead3;
        return bytesToRead3 == i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void A4O(C0980Hh c0980Hh) {
        while (c0980Hh.A04() > 0) {
            switch (this.A02) {
                case 0:
                    if (A01(c0980Hh)) {
                        this.A02 = 1;
                    }
                    break;
                case 1:
                    if (A02(c0980Hh, this.A09.A00, 18)) {
                        A00();
                        this.A09.A0Y(0);
                        this.A07.AEr(this.A09, 18);
                        this.A02 = 2;
                    }
                    break;
                case 2:
                    int iMin = Math.min(c0980Hh.A04(), this.A01 - this.A00);
                    this.A07.AEr(c0980Hh, iMin);
                    int bytesToRead = this.A00 + iMin;
                    this.A00 = bytesToRead;
                    int i = this.A01;
                    if (bytesToRead == i) {
                        this.A07.AEs(this.A05, 1, i, 0, null);
                        this.A05 += this.A04;
                        this.A02 = 0;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void A4l(InterfaceC0840Bc interfaceC0840Bc, C0870Cu c0870Cu) {
        c0870Cu.A05();
        this.A08 = c0870Cu.A04();
        this.A07 = interfaceC0840Bc.AFx(c0870Cu.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void ADi() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void ADj(long j, boolean z) {
        this.A05 = j;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void AEv() {
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }
}
