package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W2 implements InterfaceC0845Bj {
    public long A00;
    public long A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;

    public W2(int i, int i2, int i3, int i4, int i5, int i6) {
        this.A06 = i;
        this.A07 = i2;
        this.A02 = i3;
        this.A04 = i4;
        this.A03 = i5;
        this.A05 = i6;
    }

    public final int A00() {
        return this.A07 * this.A03 * this.A06;
    }

    public final int A01() {
        return this.A04;
    }

    public final int A02() {
        return this.A05;
    }

    public final int A03() {
        return this.A06;
    }

    public final int A04() {
        return this.A07;
    }

    public final long A05(long j) {
        long positionOffset = Math.max(0L, j - this.A01);
        long j2 = 1000000 * positionOffset;
        long positionOffset2 = this.A02;
        return j2 / positionOffset2;
    }

    public final void A06(long j, long j2) {
        this.A01 = j;
        this.A00 = j2;
    }

    public final boolean A07() {
        return (this.A01 == 0 || this.A00 == 0) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final long A6k() {
        long j = 1000000 * (this.A00 / ((long) this.A04));
        long numFrames = this.A07;
        return j / numFrames;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final C0844Bi A7l(long j) {
        long j2 = (((long) this.A02) * j) / 1000000;
        int i = this.A04;
        long positionOffset = i;
        long j3 = j2 / positionOffset;
        long positionOffset2 = i;
        long jA0E = C0996Hx.A0E(j3 * positionOffset2, 0L, this.A00 - ((long) i));
        long j4 = this.A01 + jA0E;
        long jA05 = A05(j4);
        C0846Bk seekPoint = new C0846Bk(jA05, j4);
        if (jA05 < j) {
            long j5 = this.A00;
            int i2 = this.A04;
            if (jA0E != j5 - ((long) i2)) {
                long seekTimeUs = ((long) i2) + j4;
                long seekPosition = A05(seekTimeUs);
                return new C0844Bi(seekPoint, new C0846Bk(seekPosition, seekTimeUs));
            }
        }
        return new C0844Bi(seekPoint);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final boolean A95() {
        return true;
    }
}
