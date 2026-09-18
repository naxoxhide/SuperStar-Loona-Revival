package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0864Cn {
    public int A00;
    public long A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final InterfaceC0859Cg A05;
    public final C0979Hg A06 = new C0979Hg(new byte[64]);
    public final C0992Ht A07;

    public C0864Cn(InterfaceC0859Cg interfaceC0859Cg, C0992Ht c0992Ht) {
        this.A05 = interfaceC0859Cg;
        this.A07 = c0992Ht;
    }

    private void A00() {
        this.A06.A08(8);
        this.A03 = this.A06.A0F();
        this.A02 = this.A06.A0F();
        this.A06.A08(6);
        this.A00 = this.A06.A04(8);
    }

    private void A01() {
        this.A01 = 0L;
        if (this.A03) {
            this.A06.A08(4);
            long jA04 = ((long) this.A06.A04(3)) << 30;
            this.A06.A08(1);
            long pts = this.A06.A04(15) << 15;
            long j = jA04 | pts;
            this.A06.A08(1);
            long pts2 = this.A06.A04(15);
            long j2 = j | pts2;
            this.A06.A08(1);
            if (!this.A04 && this.A02) {
                this.A06.A08(4);
                long pts3 = this.A06.A04(3);
                this.A06.A08(1);
                long pts4 = (pts3 << 30) | ((long) (this.A06.A04(15) << 15));
                this.A06.A08(1);
                long pts5 = pts4 | ((long) this.A06.A04(15));
                this.A06.A08(1);
                this.A07.A07(pts5);
                this.A04 = true;
            }
            this.A01 = this.A07.A07(j2);
        }
    }

    public final void A02() {
        this.A04 = false;
        this.A05.AEv();
    }

    public final void A03(C0980Hh c0980Hh) throws C07909d {
        c0980Hh.A0c(this.A06.A00, 0, 3);
        this.A06.A07(0);
        A00();
        c0980Hh.A0c(this.A06.A00, 0, this.A00);
        this.A06.A07(0);
        A01();
        this.A05.ADj(this.A01, true);
        this.A05.A4O(c0980Hh);
        this.A05.ADi();
    }
}
