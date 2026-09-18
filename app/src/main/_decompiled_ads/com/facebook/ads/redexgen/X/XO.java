package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XO implements AJ {
    public boolean A04;
    public boolean A05;
    public int[] A06;
    public int[] A07;
    public ByteBuffer A02 = AJ.A00;
    public ByteBuffer A03 = AJ.A00;
    public int A00 = -1;
    public int A01 = -1;

    public final void A00(int[] iArr) {
        this.A07 = iArr;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final boolean A4N(int i, int i2, int i3) throws AI {
        boolean z = !Arrays.equals(this.A07, this.A06);
        int[] iArr = this.A07;
        this.A06 = iArr;
        if (iArr == null) {
            this.A04 = false;
            return z;
        }
        if (i3 == 2) {
            if (!z && this.A01 == i && this.A00 == i2) {
                return false;
            }
            this.A01 = i;
            this.A00 = i2;
            boolean outputChannelsChanged = i2 != iArr.length;
            this.A04 = outputChannelsChanged;
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.A06;
                if (i4 >= iArr2.length) {
                    return true;
                }
                int i5 = iArr2[i4];
                if (i5 < i2) {
                    boolean z2 = this.A04;
                    boolean outputChannelsChanged2 = i5 != i4;
                    this.A04 = z2 | outputChannelsChanged2;
                    i4++;
                } else {
                    throw new AI(i, i2, i3);
                }
            }
        } else {
            throw new AI(i, i2, i3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final ByteBuffer A7O() {
        ByteBuffer byteBuffer = this.A03;
        ByteBuffer outputBuffer = AJ.A00;
        this.A03 = outputBuffer;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final int A7P() {
        int[] iArr = this.A06;
        return iArr == null ? this.A00 : iArr.length;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final int A7Q() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final int A7R() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final boolean A8l() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final boolean A8q() {
        return this.A05 && this.A03 == AJ.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final void AE6() {
        this.A05 = true;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final void AE7(ByteBuffer byteBuffer) {
        HI.A04(this.A06 != null);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int position = this.A00;
        int i = (iLimit - iPosition) / (position * 2);
        int position2 = this.A06.length;
        int i2 = position2 * i * 2;
        int position3 = this.A02.capacity();
        if (position3 < i2) {
            this.A02 = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        while (iPosition < iLimit) {
            for (int position4 : this.A06) {
                this.A02.putShort(byteBuffer.getShort((position4 * 2) + iPosition));
            }
            int position5 = this.A00;
            iPosition += position5 * 2;
        }
        byteBuffer.position(iLimit);
        this.A02.flip();
        this.A03 = this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final void flush() {
        this.A03 = AJ.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final void reset() {
        flush();
        this.A02 = AJ.A00;
        this.A00 = -1;
        this.A01 = -1;
        this.A06 = null;
        this.A07 = null;
        this.A04 = false;
    }
}
