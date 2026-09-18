package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class D3 implements InterfaceC1366Wm {
    public static byte[] A03;
    public final long A00;
    public final long[] A01;
    public final long[] A02;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{71, 75, 29, 9, 25, 2, 107, 47, 42, 63, 42, 107, 56, 34, 49, 46, 107, 38, 34, 56, 38, 42, 63, 40, 35, 113, 107, 0, 52, 36, 63, 5, 51, 51, Base64.padSymbol, 51, 36};
    }

    public D3(long[] jArr, long[] jArr2, long j) {
        this.A02 = jArr;
        this.A01 = jArr2;
        this.A00 = j;
    }

    public static D3 A00(long j, long j2, Bg bg, C0980Hh c0980Hh) {
        int iA0H;
        long j3 = j2;
        c0980Hh.A0Z(10);
        int numFrames = c0980Hh.A08();
        if (numFrames <= 0) {
            return null;
        }
        int sampleRate = bg.A03;
        long jA0F = C0996Hx.A0F(numFrames, ((long) (sampleRate >= 32000 ? 1152 : 576)) * 1000000, sampleRate);
        int iA0I = c0980Hh.A0I();
        int numFrames2 = c0980Hh.A0I();
        int iA0I2 = c0980Hh.A0I();
        c0980Hh.A0Z(2);
        long j4 = j3 + ((long) bg.A02);
        long[] jArr = new long[iA0I];
        long[] jArr2 = new long[iA0I];
        for (int scale = 0; scale < iA0I; scale++) {
            jArr[scale] = (((long) scale) * jA0F) / ((long) iA0I);
            jArr2[scale] = Math.max(j3, j4);
            switch (iA0I2) {
                case 1:
                    iA0H = c0980Hh.A0E();
                    break;
                case 2:
                    iA0H = c0980Hh.A0I();
                    break;
                case 3:
                    iA0H = c0980Hh.A0G();
                    break;
                case 4:
                    iA0H = c0980Hh.A0H();
                    break;
                default:
                    return null;
            }
            j3 += (long) (iA0H * numFrames2);
        }
        if (j != -1 && j != j3) {
            Log.w(A01(27, 10, 87), A01(2, 25, 74) + j + A01(0, 2, 106) + j3);
        }
        return new D3(jArr, jArr2, jA0F);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final long A6k() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final C0844Bi A7l(long j) {
        int iA0B = C0996Hx.A0B(this.A02, j, true, true);
        C0846Bk c0846Bk = new C0846Bk(this.A02[iA0B], this.A01[iA0B]);
        if (c0846Bk.A01 < j) {
            int tableIndex = this.A02.length;
            if (iA0B != tableIndex - 1) {
                int tableIndex2 = iA0B + 1;
                long j2 = this.A02[tableIndex2];
                int tableIndex3 = iA0B + 1;
                C0846Bk nextSeekPoint = new C0846Bk(j2, this.A01[tableIndex3]);
                return new C0844Bi(c0846Bk, nextSeekPoint);
            }
        }
        return new C0844Bi(c0846Bk);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1366Wm
    public final long A7z(long j) {
        return this.A02[C0996Hx.A0B(this.A01, j, true, true)];
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Bj
    public final boolean A95() {
        return true;
    }
}
