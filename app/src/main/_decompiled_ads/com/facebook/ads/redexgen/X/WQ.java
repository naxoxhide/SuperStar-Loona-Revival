package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WQ implements InterfaceC0859Cg {
    public static String[] A0C = {"jvuSXyRxFwWN5M53JxqXTqjBlHPmO5yS", "Nx6fwt5mIYqSRgPxQoB61NXpIqViXreb", "NbRu72XFqCPxMxVeHFzrnyrjREaihhdr", "Z3KBXmMomO9rJfjLZz1JQz2Kw0Fx28Ab", "zLbRIBf4nYWkQfyOEtwQDAQMGMEl8", "zvpubyWaUoinARhzufpjCqD1DbWF7ekR", "kxIGpaDKqbCPDUN5La7nQCmFVSx", "CqFgkkKKOYx1Bj1EdbgCjsaN4ksOOdQn"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public Format A05;
    public InterfaceC0848Bm A06;
    public String A07;
    public boolean A08;
    public final C0979Hg A09;
    public final C0980Hh A0A;
    public final String A0B;

    public WQ() {
        this(null);
    }

    public WQ(String str) {
        C0979Hg c0979Hg = new C0979Hg(new byte[128]);
        this.A09 = c0979Hg;
        this.A0A = new C0980Hh(c0979Hg.A00);
        this.A02 = 0;
        this.A0B = str;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0047  */
    private void A00() {
        this.A09.A07(0);
        A7 a7A09 = A8.A09(this.A09);
        if (this.A05 == null || a7A09.A00 != this.A05.A05) {
            Format formatA07 = Format.A07(this.A07, a7A09.A05, null, -1, -1, a7A09.A00, a7A09.A03, null, null, 0, this.A0B);
            this.A05 = formatA07;
            this.A06.A5j(formatA07);
        } else {
            int i = a7A09.A03;
            int i2 = this.A05.A0C;
            if (A0C[6].length() != 27) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[2] = "rmTuGOWOeoxLIH1QLptnusvxizN1V0jV";
            strArr[5] = "2RMufqWRuZFq3WutxyrHt00cbPeHqbYj";
            if (i != i2 || a7A09.A05 != this.A05.A0O) {
                Format formatA08 = Format.A07(this.A07, a7A09.A05, null, -1, -1, a7A09.A00, a7A09.A03, null, null, 0, this.A0B);
                this.A05 = formatA08;
                this.A06.A5j(formatA08);
            }
        }
        this.A01 = a7A09.A01;
        this.A03 = (((long) a7A09.A02) * 1000000) / ((long) this.A05.A0C);
    }

    private boolean A01(C0980Hh c0980Hh) {
        while (true) {
            if (c0980Hh.A04() <= 0) {
                return false;
            }
            if (!this.A08) {
                this.A08 = c0980Hh.A0E() == 11;
            } else {
                int iA0E = c0980Hh.A0E();
                if (iA0E == 119) {
                    this.A08 = false;
                    return true;
                }
                this.A08 = iA0E == 11;
            }
        }
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
        while (true) {
            int iA04 = c0980Hh.A04();
            if (A0C[3].charAt(28) != '2') {
                throw new RuntimeException();
            }
            A0C[6] = "j4ZJ9Sb1FxDogpbJuhr4W7MrwTg";
            if (iA04 > 0) {
                switch (this.A02) {
                    case 0:
                        if (A01(c0980Hh)) {
                            this.A02 = 1;
                            this.A0A.A00[0] = 11;
                            this.A0A.A00[1] = 119;
                            this.A00 = 2;
                        }
                        break;
                    case 1:
                        if (A02(c0980Hh, this.A0A.A00, 128)) {
                            A00();
                            this.A0A.A0Y(0);
                            this.A06.AEr(this.A0A, 128);
                            this.A02 = 2;
                        }
                        break;
                    case 2:
                        int iMin = Math.min(c0980Hh.A04(), this.A01 - this.A00);
                        this.A06.AEr(c0980Hh, iMin);
                        int bytesToRead = this.A00 + iMin;
                        this.A00 = bytesToRead;
                        int i = this.A01;
                        if (bytesToRead == i) {
                            this.A06.AEs(this.A04, 1, i, 0, null);
                            long j = this.A04;
                            long j2 = this.A03;
                            String[] strArr = A0C;
                            if (strArr[0].charAt(28) == strArr[7].charAt(28)) {
                                A0C[4] = "thGmrgzi8Rkjtt3yqKW2WPJBde0Fj";
                                this.A04 = j + j2;
                                this.A02 = 0;
                            } else {
                                this.A04 = j + j2;
                                this.A02 = 0;
                            }
                        }
                        break;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void A4l(InterfaceC0840Bc interfaceC0840Bc, C0870Cu c0870Cu) {
        c0870Cu.A05();
        this.A07 = c0870Cu.A04();
        this.A06 = interfaceC0840Bc.AFx(c0870Cu.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void ADi() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void ADj(long j, boolean z) {
        this.A04 = j;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0859Cg
    public final void AEv() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
    }
}
