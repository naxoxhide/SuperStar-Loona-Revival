package com.facebook.ads.redexgen.X;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X4 implements InterfaceC0839Bb {
    public static String[] A07 = {"WXHfHzHth2Al5uPNAeAj07mTCizYfL", "Ea4PVszhPWUkUOAzwMvLCDFSUaducjj7", "YmMP3hbiPsyrKpNosY6PcrNT297v1Qrn", "DJcyMwta", "hLB8mG9dKKyMH1LM5ESzC", "Vr0ZnTk4fnCFSbIFCLxfH748g1DMsTn2", "7kDa6eDxYJ9kj6HJXeCECzm6I99XwLPU", "QseCjdkBkHi9C8DCiNRIrV91qCtwuZnL"};
    public int A00;
    public int A01;
    public long A02;
    public final long A04;
    public final InterfaceC0951Gc A05;
    public byte[] A03 = new byte[65536];
    public final byte[] A06 = new byte[4096];

    public X4(InterfaceC0951Gc interfaceC0951Gc, long j, long j2) {
        this.A05 = interfaceC0951Gc;
        this.A02 = j;
        this.A04 = j2;
    }

    private int A00(int i) {
        int bytesSkipped = Math.min(this.A00, i);
        A05(bytesSkipped);
        return bytesSkipped;
    }

    private int A01(byte[] bArr, int i, int i2) {
        int i3 = this.A00;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.A03, 0, bArr, i, iMin);
        A05(iMin);
        return iMin;
    }

    private int A02(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int i4 = this.A05.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                if (i3 == 0 && z) {
                    return -1;
                }
                throw new EOFException();
            }
            return i3 + i4;
        }
        throw new InterruptedException();
    }

    private void A03(int i) {
        if (i != -1) {
            this.A02 += (long) i;
        }
    }

    private void A04(int i) {
        int i2 = this.A01 + i;
        byte[] bArr = this.A03;
        int requiredLength = bArr.length;
        if (i2 > requiredLength) {
            int requiredLength2 = bArr.length;
            int requiredLength3 = 524288 + i2;
            int newPeekCapacity = C0996Hx.A06(requiredLength2 * 2, 65536 + i2, requiredLength3);
            this.A03 = Arrays.copyOf(this.A03, newPeekCapacity);
        }
    }

    private void A05(int i) {
        int i2 = this.A00 - i;
        this.A00 = i2;
        this.A01 = 0;
        byte[] bArr = this.A03;
        byte[] newPeekBuffer = this.A03;
        if (i2 < newPeekBuffer.length - 524288) {
            bArr = new byte[65536 + i2];
        }
        System.arraycopy(newPeekBuffer, i, bArr, 0, i2);
        this.A03 = bArr;
    }

    public final boolean A06(int i, boolean z) throws InterruptedException, IOException {
        A04(i);
        int iMin = Math.min(this.A00 - this.A01, i);
        while (iMin < i) {
            iMin = A02(this.A03, this.A01, i, iMin, z);
            if (iMin == -1) {
                return false;
            }
        }
        int i2 = this.A01 + i;
        this.A01 = i2;
        int bytesPeeked = this.A00;
        this.A00 = Math.max(bytesPeeked, i2);
        return true;
    }

    public final boolean A07(int i, boolean z) throws InterruptedException, IOException {
        int iA00 = A00(i);
        while (iA00 < i && iA00 != -1) {
            int bytesSkipped = this.A06.length;
            iA00 = A02(this.A06, -iA00, Math.min(i, bytesSkipped + iA00), iA00, z);
        }
        A03(iA00);
        return iA00 != -1;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final void A3S(int i) throws InterruptedException, IOException {
        A06(i, false);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final long A7B() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final long A7V() {
        return this.A02 + ((long) this.A01);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final long A7a() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final void ADl(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        ADm(bArr, i, i2, false);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final boolean ADm(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, IOException {
        if (!A06(i2, z)) {
            return false;
        }
        System.arraycopy(this.A03, this.A01 - i2, bArr, i, i2);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0051 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0056 A[RETURN, SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final boolean AEE(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, IOException {
        int iA01 = A01(bArr, i, i2);
        while (true) {
            String[] strArr = A07;
            String str = strArr[5];
            String str2 = strArr[7];
            int iCharAt = str.charAt(6);
            int bytesRead = str2.charAt(6);
            if (iCharAt != bytesRead) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "Jrnjt2kK808bOfAL2dwi4gGQEivMT1gd";
            strArr2[7] = "BeMd7gkFpNMGNNjn1C0ltMDP7X04qF1j";
            if (iA01 < i2 && iA01 != -1) {
                iA01 = A02(bArr, i, i2, iA01, z);
            } else {
                A03(iA01);
                if (A07[3].length() == 12) {
                    if (iA01 != -1) {
                        return true;
                    }
                    return false;
                }
                A07[6] = "kVyK5NlwbVR8i9TPL7EEmQ28yX1F3goU";
                if (iA01 != -1) {
                    return true;
                }
                return false;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final void AEm() {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final int AFb(int i) throws InterruptedException, IOException {
        int bytesSkipped = A00(i);
        if (bytesSkipped == 0) {
            byte[] bArr = this.A06;
            bytesSkipped = A02(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        A03(bytesSkipped);
        return bytesSkipped;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final void AFe(int i) throws InterruptedException, IOException {
        A07(i, false);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final int read(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        int bytesRead = A01(bArr, i, i2);
        if (bytesRead == 0) {
            bytesRead = A02(bArr, i, i2, 0, true);
        }
        A03(bytesRead);
        return bytesRead;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0839Bb
    public final void readFully(byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        AEE(bArr, i, i2, false);
    }
}
