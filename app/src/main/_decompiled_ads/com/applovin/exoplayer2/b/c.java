package com.applovin.exoplayer2.b;

import com.facebook.ads.AdError;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static final int[] jB = {AdError.CACHE_ERROR_CODE, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    public static final class a {
        public final int dL;
        public final int dM;
        public final int jA;
        public final int jC;
        public final int jz;

        private a(int i, int i2, int i3, int i4, int i5) {
            this.jC = i;
            this.dL = i2;
            this.dM = i3;
            this.jz = i4;
            this.jA = i5;
        }
    }

    public static com.applovin.exoplayer2.v c(com.applovin.exoplayer2.l.y yVar, String str, String str2, com.applovin.exoplayer2.d.e eVar) {
        yVar.fz(1);
        return new com.applovin.exoplayer2.v.a().g(str).m("audio/ac4").N(2).O(((yVar.po() & 32) >> 5) == 1 ? 48000 : 44100).a(eVar).j(str2).bT();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    /* JADX WARN: Code duplicated, block: B:45:0x008e  */
    public static a d(com.applovin.exoplayer2.l.x xVar) {
        int i;
        int i2;
        int iBQ = xVar.bQ(16);
        int iBQ2 = xVar.bQ(16);
        if (iBQ2 == 65535) {
            iBQ2 = xVar.bQ(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iBQ2 + i;
        if (iBQ == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int iBQ3 = xVar.bQ(2);
        if (iBQ3 == 3) {
            iBQ3 += a(xVar, 2);
        }
        int i5 = iBQ3;
        int iBQ4 = xVar.bQ(10);
        if (xVar.ik() && xVar.bQ(3) > 0) {
            xVar.bR(2);
        }
        int i6 = xVar.ik() ? 48000 : 44100;
        int iBQ5 = xVar.bQ(4);
        int i7 = 0;
        if (i6 == 44100 && iBQ5 == 13) {
            i2 = jB[iBQ5];
        } else {
            if (i6 == 48000) {
                int[] iArr = jB;
                if (iBQ5 < iArr.length) {
                    i7 = iArr[iBQ5];
                    int i8 = iBQ4 % 5;
                    if (i8 == 1) {
                        if (iBQ5 != 3 || iBQ5 == 8) {
                            i7++;
                        }
                    } else if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 4 && (iBQ5 == 3 || iBQ5 == 8 || iBQ5 == 11)) {
                                i7++;
                            }
                        } else if (iBQ5 != 3) {
                            i7++;
                        } else {
                            i7++;
                        }
                    } else if (iBQ5 == 8 || iBQ5 == 11) {
                        i7++;
                    }
                }
            }
            i2 = i7;
        }
        return new a(i5, 2, i6, i4, i2);
    }

    public static int b(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i3 == 65535) {
            i3 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return d(new com.applovin.exoplayer2.l.x(bArr)).jA;
    }

    public static void a(int i, com.applovin.exoplayer2.l.y yVar) {
        yVar.U(7);
        byte[] bArrHO = yVar.hO();
        bArrHO[0] = -84;
        bArrHO[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrHO[2] = -1;
        bArrHO[3] = -1;
        bArrHO[4] = (byte) ((i >> 16) & 255);
        bArrHO[5] = (byte) ((i >> 8) & 255);
        bArrHO[6] = (byte) (i & 255);
    }

    private static int a(com.applovin.exoplayer2.l.x xVar, int i) {
        int i2 = 0;
        while (true) {
            int iBQ = i2 + xVar.bQ(i);
            if (!xVar.ik()) {
                return iBQ;
            }
            i2 = (iBQ + 1) << i;
        }
    }
}
