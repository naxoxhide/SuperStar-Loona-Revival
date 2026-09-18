package com.applovin.exoplayer2.b;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    private static final int[] mk = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] ml = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] mm = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static boolean aF(int i) {
        return i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368;
    }

    public static com.applovin.exoplayer2.v a(byte[] bArr, String str, String str2, com.applovin.exoplayer2.d.e eVar) {
        com.applovin.exoplayer2.l.x xVarG = g(bArr);
        xVarG.bR(60);
        int i = mk[xVarG.bQ(6)];
        int i2 = ml[xVarG.bQ(4)];
        int iBQ = xVarG.bQ(5);
        int[] iArr = mm;
        int i3 = iBQ >= iArr.length ? -1 : (iArr[iBQ] * 1000) / 2;
        xVarG.bR(10);
        return new com.applovin.exoplayer2.v.a().g(str).m("audio/vnd.dts").G(i3).N(i + (xVarG.bQ(2) > 0 ? 1 : 0)).O(i2).a(eVar).j(str2).bT();
    }

    public static int e(byte[] bArr) {
        int i;
        byte b2;
        int i2;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 == 31) {
                i = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            } else {
                i = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i2 = b2 & 252;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    public static int e(ByteBuffer byteBuffer) {
        int i;
        byte b2;
        int i2;
        byte b3;
        int iPosition = byteBuffer.position();
        byte b4 = byteBuffer.get(iPosition);
        if (b4 != -2) {
            if (b4 == -1) {
                i = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 7);
            } else if (b4 == 31) {
                i = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 6);
            } else {
                i = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b2 = byteBuffer.get(iPosition + 5);
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b2 = byteBuffer.get(iPosition + 4);
        i2 = b2 & 252;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005f  */
    /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
    public static int f(byte[] bArr) {
        int i;
        byte b2;
        int i2;
        int i3;
        byte b3;
        boolean z = false;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i3 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b3 = bArr[9];
            } else if (b4 == 31) {
                i3 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                b3 = bArr[8];
            } else {
                i = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                b2 = bArr[7];
            }
            i2 = (((b3 & 60) >> 2) | i3) + 1;
            z = true;
            if (z) {
                return (i2 * 16) / 14;
            }
            return i2;
        }
        i = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b2 = bArr[6];
        i2 = (((b2 & 240) >> 4) | i) + 1;
        if (z) {
            return (i2 * 16) / 14;
        }
        return i2;
    }

    private static com.applovin.exoplayer2.l.x g(byte[] bArr) {
        if (bArr[0] == 127) {
            return new com.applovin.exoplayer2.l.x(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (h(bArrCopyOf)) {
            for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                byte b2 = bArrCopyOf[i];
                int i2 = i + 1;
                bArrCopyOf[i] = bArrCopyOf[i2];
                bArrCopyOf[i2] = b2;
            }
        }
        com.applovin.exoplayer2.l.x xVar = new com.applovin.exoplayer2.l.x(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            com.applovin.exoplayer2.l.x xVar2 = new com.applovin.exoplayer2.l.x(bArrCopyOf);
            while (xVar2.pf() >= 16) {
                xVar2.bR(2);
                xVar.K(xVar2.bQ(14), 14);
            }
        }
        xVar.I(bArrCopyOf);
        return xVar;
    }

    private static boolean h(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }
}
