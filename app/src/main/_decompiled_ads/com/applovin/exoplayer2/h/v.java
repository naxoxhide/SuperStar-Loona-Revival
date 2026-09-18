package com.applovin.exoplayer2.h;

import com.applovin.exoplayer2.l.ai;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class v {
    private long Dh;
    private final com.applovin.exoplayer2.k.b Lu;
    private final int MK;
    private a ML;
    private a MM;
    private a MN;
    private final com.applovin.exoplayer2.l.y uO;

    public v(com.applovin.exoplayer2.k.b bVar) {
        this.Lu = bVar;
        int iOc = bVar.oc();
        this.MK = iOc;
        this.uO = new com.applovin.exoplayer2.l.y(32);
        a aVar = new a(0L, iOc);
        this.ML = aVar;
        this.MM = aVar;
        this.MN = aVar;
    }

    public void Y() {
        a(this.ML);
        a aVar = new a(0L, this.MK);
        this.ML = aVar;
        this.MM = aVar;
        this.MN = aVar;
        this.Dh = 0L;
        this.Lu.ob();
    }

    public void lt() {
        this.MM = this.ML;
    }

    public void a(com.applovin.exoplayer2.c.g gVar, w.a aVar) {
        this.MM = a(this.MM, gVar, aVar, this.uO);
    }

    public void b(com.applovin.exoplayer2.c.g gVar, w.a aVar) {
        a(this.MM, gVar, aVar, this.uO);
    }

    public void aY(long j) {
        if (j == -1) {
            return;
        }
        while (j >= this.ML.zl) {
            this.Lu.a(this.ML.MQ);
            this.ML = this.ML.lv();
        }
        if (this.MM.MO < this.ML.MO) {
            this.MM = this.ML;
        }
    }

    public long lu() {
        return this.Dh;
    }

    public int a(com.applovin.exoplayer2.k.g gVar, int i, boolean z) throws IOException {
        int i2 = gVar.read(this.MN.MQ.tf, this.MN.aZ(this.Dh), dN(i));
        if (i2 != -1) {
            dO(i2);
            return i2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void c(com.applovin.exoplayer2.l.y yVar, int i) {
        while (i > 0) {
            int iDN = dN(i);
            yVar.r(this.MN.MQ.tf, this.MN.aZ(this.Dh), iDN);
            i -= iDN;
            dO(iDN);
        }
    }

    private void a(a aVar) {
        if (aVar.MP) {
            boolean z = this.MN.MP;
            int i = (z ? 1 : 0) + (((int) (this.MN.MO - aVar.MO)) / this.MK);
            com.applovin.exoplayer2.k.a[] aVarArr = new com.applovin.exoplayer2.k.a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = aVar.MQ;
                aVar = aVar.lv();
            }
            this.Lu.a(aVarArr);
        }
    }

    private int dN(int i) {
        if (!this.MN.MP) {
            this.MN.a(this.Lu.oa(), new a(this.MN.zl, this.MK));
        }
        return Math.min(i, (int) (this.MN.zl - this.Dh));
    }

    private void dO(int i) {
        long j = this.Dh + ((long) i);
        this.Dh = j;
        if (j == this.MN.zl) {
            this.MN = this.MN.MR;
        }
    }

    private static a a(a aVar, com.applovin.exoplayer2.c.g gVar, w.a aVar2, com.applovin.exoplayer2.l.y yVar) {
        if (gVar.hg()) {
            aVar = b(aVar, gVar, aVar2, yVar);
        }
        if (gVar.ha()) {
            yVar.U(4);
            a aVarA = a(aVar, aVar2.zr, yVar.hO(), 4);
            int iPD = yVar.pD();
            aVar2.zr += 4;
            aVar2.oW -= 4;
            gVar.by(iPD);
            a aVarA2 = a(aVarA, aVar2.zr, gVar.rH, iPD);
            aVar2.zr += (long) iPD;
            aVar2.oW -= iPD;
            gVar.bx(aVar2.oW);
            return a(aVarA2, aVar2.zr, gVar.rK, aVar2.oW);
        }
        gVar.by(aVar2.oW);
        return a(aVar, aVar2.zr, gVar.rH, aVar2.oW);
    }

    private static a b(a aVar, com.applovin.exoplayer2.c.g gVar, w.a aVar2, com.applovin.exoplayer2.l.y yVar) {
        long j = aVar2.zr;
        int iPp = 1;
        yVar.U(1);
        a aVarA = a(aVar, j, yVar.hO(), 1);
        long j2 = j + 1;
        byte b2 = yVar.hO()[0];
        boolean z = (b2 & 128) != 0;
        int i = b2 & 127;
        com.applovin.exoplayer2.c.c cVar = gVar.rG;
        if (cVar.rk == null) {
            cVar.rk = new byte[16];
        } else {
            Arrays.fill(cVar.rk, (byte) 0);
        }
        a aVarA2 = a(aVarA, j2, cVar.rk, i);
        long j3 = j2 + ((long) i);
        if (z) {
            yVar.U(2);
            aVarA2 = a(aVarA2, j3, yVar.hO(), 2);
            j3 += 2;
            iPp = yVar.pp();
        }
        int i2 = iPp;
        int[] iArr = cVar.rn;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cVar.ro;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            yVar.U(i3);
            aVarA2 = a(aVarA2, j3, yVar.hO(), i3);
            j3 += (long) i3;
            yVar.fx(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = yVar.pp();
                iArr4[i4] = yVar.pD();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar2.oW - ((int) (j3 - aVar2.zr));
        }
        com.applovin.exoplayer2.e.x.a aVar3 = (com.applovin.exoplayer2.e.x.a) ai.R(aVar2.xZ);
        cVar.a(i2, iArr2, iArr4, aVar3.uV, cVar.rk, aVar3.uU, aVar3.rq, aVar3.rr);
        int i5 = (int) (j3 - aVar2.zr);
        aVar2.zr += (long) i5;
        aVar2.oW -= i5;
        return aVarA2;
    }

    private static a a(a aVar, long j, ByteBuffer byteBuffer, int i) {
        a aVarA = a(aVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (aVarA.zl - j));
            byteBuffer.put(aVarA.MQ.tf, aVarA.aZ(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == aVarA.zl) {
                aVarA = aVarA.MR;
            }
        }
        return aVarA;
    }

    private static a a(a aVar, long j, byte[] bArr, int i) {
        a aVarA = a(aVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (aVarA.zl - j));
            System.arraycopy(aVarA.MQ.tf, aVarA.aZ(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == aVarA.zl) {
                aVarA = aVarA.MR;
            }
        }
        return aVarA;
    }

    private static a a(a aVar, long j) {
        while (j >= aVar.zl) {
            aVar = aVar.MR;
        }
        return aVar;
    }

    private static final class a {
        public final long MO;
        public boolean MP;
        public com.applovin.exoplayer2.k.a MQ;
        public a MR;
        public final long zl;

        public a(long j, int i) {
            this.MO = j;
            this.zl = j + ((long) i);
        }

        public void a(com.applovin.exoplayer2.k.a aVar, a aVar2) {
            this.MQ = aVar;
            this.MR = aVar2;
            this.MP = true;
        }

        public int aZ(long j) {
            return ((int) (j - this.MO)) + this.MQ.oU;
        }

        public a lv() {
            this.MQ = null;
            a aVar = this.MR;
            this.MR = null;
            return aVar;
        }
    }
}
