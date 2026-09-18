package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VD implements InterfaceC0951Gc {
    public static byte[] A05;
    public static String[] A06 = {"2AQ", "PKEE8tvP1F9G5CS2asOfHv5i9NmL9OD8", "nghUlW0EKiCso94RSH6SGDaiGhOOZ9vR", "y3nJ4vSOM9HwnTFSw", "dDA", "lgpDjnw", "z3SCjqWwobuDiPiZI", "K1NyJtZzbkl5fIhEU"};
    public long A00;
    public Uri A01;
    public RandomAccessFile A02;
    public boolean A03;
    public final InterfaceC0971Gy<? super VD> A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-23};
        if (A06[3].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[2] = "0CNdTW9yzTlkWk7IYlaLkwwChYLMq6mo";
        strArr[1] = "0Hm8psTbLgTGmvvfzx0WFuRjr22Bb9pe";
        A05 = bArr;
    }

    static {
        A01();
    }

    public VD() {
        this(null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Gy != com.facebook.ads.internal.exoplayer2.thirdparty.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.thirdparty.upstream.FileDataSource> */
    public VD(InterfaceC0971Gy<? super VD> interfaceC0971Gy) {
        this.A04 = interfaceC0971Gy;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final Uri A85() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final long ADb(C0955Gg c0955Gg) throws IOException {
        try {
            this.A01 = c0955Gg.A04;
            RandomAccessFile randomAccessFile = new RandomAccessFile(c0955Gg.A04.getPath(), A00(0, 1, 20));
            this.A02 = randomAccessFile;
            randomAccessFile.seek(c0955Gg.A03);
            long length = c0955Gg.A02 == -1 ? this.A02.length() - c0955Gg.A03 : c0955Gg.A02;
            this.A00 = length;
            if (length >= 0) {
                this.A03 = true;
                InterfaceC0971Gy<? super VD> interfaceC0971Gy = this.A04;
                if (interfaceC0971Gy != null) {
                    interfaceC0971Gy.ADF(this, c0955Gg);
                }
                return this.A00;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new C0957Gj(e);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final void close() throws C0957Gj {
        this.A01 = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.A02;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.A02 = null;
                if (this.A03) {
                    this.A03 = false;
                    InterfaceC0971Gy<? super VD> interfaceC0971Gy = this.A04;
                    if (interfaceC0971Gy != null) {
                        interfaceC0971Gy.ADE(this);
                    }
                }
            } catch (IOException e) {
                throw new C0957Gj(e);
            }
        } catch (Throwable th) {
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                InterfaceC0971Gy<? super VD> interfaceC0971Gy2 = this.A04;
                if (interfaceC0971Gy2 != null) {
                    interfaceC0971Gy2.ADE(this);
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A00;
        if (j == 0) {
            return -1;
        }
        try {
            int i3 = this.A02.read(bArr, i, (int) Math.min(j, i2));
            if (i3 > 0) {
                this.A00 -= (long) i3;
                InterfaceC0971Gy<? super VD> interfaceC0971Gy = this.A04;
                if (interfaceC0971Gy != null) {
                    interfaceC0971Gy.AAm(this, i3);
                }
            }
            return i3;
        } catch (IOException e) {
            throw new C0957Gj(e);
        }
    }
}
