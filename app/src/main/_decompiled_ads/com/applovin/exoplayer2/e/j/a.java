package com.applovin.exoplayer2.e.j;

import android.util.Pair;
import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.b.y;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.k.g;
import com.applovin.exoplayer2.v;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class a implements h {
    public static final l vq = new l() { // from class: com.applovin.exoplayer2.e.j.-$$Lambda$a$WPsvVB0HT_lwH7nUYF0MMbhYl0Q
        @Override // com.applovin.exoplayer2.e.l
        public final h[] createExtractors() {
            return a.ih();
        }
    };
    private b FY;
    private j vG;
    private x vH;
    private int FZ = -1;
    private long yO = -1;

    private interface b {
        void aI(long j);

        boolean d(i iVar, long j) throws IOException;

        void h(int i, long j) throws ai;
    }

    @Override // com.applovin.exoplayer2.e.h
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new a()};
    }

    @Override // com.applovin.exoplayer2.e.h
    public boolean a(i iVar) throws IOException {
        return com.applovin.exoplayer2.e.j.c.aa(iVar) != null;
    }

    @Override // com.applovin.exoplayer2.e.h
    public void a(j jVar) {
        this.vG = jVar;
        this.vH = jVar.y(0, 1);
        jVar.ig();
    }

    @Override // com.applovin.exoplayer2.e.h
    public void o(long j, long j2) {
        b bVar = this.FY;
        if (bVar != null) {
            bVar.aI(j2);
        }
    }

    @Override // com.applovin.exoplayer2.e.h
    public int b(i iVar, u uVar) throws IOException {
        io();
        if (this.FY == null) {
            com.applovin.exoplayer2.e.j.b bVarAa = com.applovin.exoplayer2.e.j.c.aa(iVar);
            if (bVarAa == null) {
                throw ai.c("Unsupported or unrecognized wav header.", null);
            }
            if (bVarAa.Gm == 17) {
                this.FY = new C0093a(this.vG, this.vH, bVarAa);
            } else if (bVarAa.Gm == 6) {
                this.FY = new c(this.vG, this.vH, bVarAa, "audio/g711-alaw", -1);
            } else if (bVarAa.Gm == 7) {
                this.FY = new c(this.vG, this.vH, bVarAa, "audio/g711-mlaw", -1);
            } else {
                int iP = y.p(bVarAa.Gm, bVarAa.uG);
                if (iP == 0) {
                    throw ai.p("Unsupported WAV format type: " + bVarAa.Gm);
                }
                this.FY = new c(this.vG, this.vH, bVarAa, "audio/raw", iP);
            }
        }
        if (this.FZ == -1) {
            Pair<Long, Long> pairAb = com.applovin.exoplayer2.e.j.c.ab(iVar);
            this.FZ = ((Long) pairAb.first).intValue();
            long jLongValue = ((Long) pairAb.second).longValue();
            this.yO = jLongValue;
            this.FY.h(this.FZ, jLongValue);
        } else if (iVar.ie() == 0) {
            iVar.bH(this.FZ);
        }
        com.applovin.exoplayer2.l.a.checkState(this.yO != -1);
        return this.FY.d(iVar, this.yO - iVar.ie()) ? -1 : 0;
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.vH);
        com.applovin.exoplayer2.l.ai.R(this.vG);
    }

    private static final class c implements b {
        private final com.applovin.exoplayer2.e.j.b Gc;
        private long Gi;
        private int Gj;
        private long Gk;
        private final int Gl;
        private final v dU;
        private final j vG;
        private final x vH;

        public c(j jVar, x xVar, com.applovin.exoplayer2.e.j.b bVar, String str, int i) throws ai {
            this.vG = jVar;
            this.vH = xVar;
            this.Gc = bVar;
            int i2 = (bVar.Gn * bVar.uG) / 8;
            if (bVar.Gq != i2) {
                throw ai.c("Expected block size: " + i2 + "; got: " + bVar.Gq, null);
            }
            int i3 = bVar.Go * i2 * 8;
            int iMax = Math.max(i2, (bVar.Go * i2) / 10);
            this.Gl = iMax;
            this.dU = new v.a().m(str).G(i3).H(i3).I(iMax).N(bVar.Gn).O(bVar.Go).P(i).bT();
        }

        @Override // com.applovin.exoplayer2.e.j.a.b
        public void aI(long j) {
            this.Gi = j;
            this.Gj = 0;
            this.Gk = 0L;
        }

        @Override // com.applovin.exoplayer2.e.j.a.b
        public void h(int i, long j) {
            this.vG.a(new d(this.Gc, 1, i, j));
            this.vH.j(this.dU);
        }

        @Override // com.applovin.exoplayer2.e.j.a.b
        public boolean d(i iVar, long j) throws IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.Gj) < (i2 = this.Gl)) {
                int iA = this.vH.a((g) iVar, (int) Math.min(i2 - i, j2), true);
                if (iA == -1) {
                    j2 = 0;
                } else {
                    this.Gj += iA;
                    j2 -= (long) iA;
                }
            }
            int i3 = this.Gc.Gq;
            int i4 = this.Gj / i3;
            if (i4 > 0) {
                long jE = this.Gi + com.applovin.exoplayer2.l.ai.e(this.Gk, 1000000L, this.Gc.Go);
                int i5 = i4 * i3;
                int i6 = this.Gj - i5;
                this.vH.a(jE, 1, i5, i6, null);
                this.Gk += (long) i4;
                this.Gj = i6;
            }
            return j2 <= 0;
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.e.j.a$a, reason: collision with other inner class name */
    private static final class C0093a implements b {
        private static final int[] Ga = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        private static final int[] Gb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, TTAdConstant.DOWNLOAD_URL_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        private final com.applovin.exoplayer2.e.j.b Gc;
        private final int Gd;
        private final byte[] Ge;
        private final com.applovin.exoplayer2.l.y Gf;
        private final int Gg;
        private int Gh;
        private long Gi;
        private int Gj;
        private long Gk;
        private final v dU;
        private final j vG;
        private final x vH;

        private static int C(int i, int i2) {
            return i * 2 * i2;
        }

        public C0093a(j jVar, x xVar, com.applovin.exoplayer2.e.j.b bVar) throws ai {
            this.vG = jVar;
            this.vH = xVar;
            this.Gc = bVar;
            int iMax = Math.max(1, bVar.Go / 10);
            this.Gg = iMax;
            com.applovin.exoplayer2.l.y yVar = new com.applovin.exoplayer2.l.y(bVar.Gr);
            yVar.pq();
            int iPq = yVar.pq();
            this.Gd = iPq;
            int i = bVar.Gn;
            int i2 = (((bVar.Gq - (i * 4)) * 8) / (bVar.uG * i)) + 1;
            if (iPq != i2) {
                throw ai.c("Expected frames per block: " + i2 + "; got: " + iPq, null);
            }
            int iN = com.applovin.exoplayer2.l.ai.N(iMax, iPq);
            this.Ge = new byte[bVar.Gq * iN];
            this.Gf = new com.applovin.exoplayer2.l.y(iN * C(iPq, i));
            int i3 = ((bVar.Go * bVar.Gq) * 8) / iPq;
            this.dU = new v.a().m("audio/raw").G(i3).H(i3).I(C(iMax, i)).N(bVar.Gn).O(bVar.Go).P(2).bT();
        }

        @Override // com.applovin.exoplayer2.e.j.a.b
        public void aI(long j) {
            this.Gh = 0;
            this.Gi = j;
            this.Gj = 0;
            this.Gk = 0L;
        }

        @Override // com.applovin.exoplayer2.e.j.a.b
        public void h(int i, long j) {
            this.vG.a(new d(this.Gc, this.Gd, i, j));
            this.vH.j(this.dU);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0038 A[LOOP:0: B:6:0x001e->B:12:0x0038, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:23:0x003e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:25:0x001b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0020  */
        /* JADX WARN: Code duplicated, block: B:9:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0035 -> B:4:0x001b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // com.applovin.exoplayer2.e.j.a.b
        public boolean d(com.applovin.exoplayer2.e.i r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.Gg
                int r1 = r6.Gj
                int r1 = r6.cF(r1)
                int r0 = r0 - r1
                int r1 = r6.Gd
                int r0 = com.applovin.exoplayer2.l.ai.N(r0, r1)
                com.applovin.exoplayer2.e.j.b r1 = r6.Gc
                int r1 = r1.Gq
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r2 = 1
                if (r1 != 0) goto L1d
            L1b:
                r1 = r2
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L3e
                int r3 = r6.Gh
                if (r3 >= r0) goto L3e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.Ge
                int r5 = r6.Gh
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L38
                goto L1b
            L38:
                int r4 = r6.Gh
                int r4 = r4 + r3
                r6.Gh = r4
                goto L1e
            L3e:
                int r7 = r6.Gh
                com.applovin.exoplayer2.e.j.b r8 = r6.Gc
                int r8 = r8.Gq
                int r7 = r7 / r8
                if (r7 <= 0) goto L75
                byte[] r8 = r6.Ge
                com.applovin.exoplayer2.l.y r9 = r6.Gf
                r6.a(r8, r7, r9)
                int r8 = r6.Gh
                com.applovin.exoplayer2.e.j.b r9 = r6.Gc
                int r9 = r9.Gq
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.Gh = r8
                com.applovin.exoplayer2.l.y r7 = r6.Gf
                int r7 = r7.pk()
                com.applovin.exoplayer2.e.x r8 = r6.vH
                com.applovin.exoplayer2.l.y r9 = r6.Gf
                r8.c(r9, r7)
                int r8 = r6.Gj
                int r8 = r8 + r7
                r6.Gj = r8
                int r7 = r6.cF(r8)
                int r8 = r6.Gg
                if (r7 < r8) goto L75
                r6.cE(r8)
            L75:
                if (r1 == 0) goto L82
                int r7 = r6.Gj
                int r7 = r6.cF(r7)
                if (r7 <= 0) goto L82
                r6.cE(r7)
            L82:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.j.a.C0093a.d(com.applovin.exoplayer2.e.i, long):boolean");
        }

        private void cE(int i) {
            long jE = this.Gi + com.applovin.exoplayer2.l.ai.e(this.Gk, 1000000L, this.Gc.Go);
            int iCG = cG(i);
            this.vH.a(jE, 1, iCG, this.Gj - iCG, null);
            this.Gk += (long) i;
            this.Gj -= iCG;
        }

        private void a(byte[] bArr, int i, com.applovin.exoplayer2.l.y yVar) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.Gc.Gn; i3++) {
                    a(bArr, i2, i3, yVar.hO());
                }
            }
            int iCG = cG(this.Gd * i);
            yVar.fx(0);
            yVar.fA(iCG);
        }

        private void a(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3 = this.Gc.Gq;
            int i4 = this.Gc.Gn;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            int iK = (short) (((bArr[i5 + 1] & 255) << 8) | (bArr[i5] & 255));
            int iMin = Math.min(bArr[i5 + 2] & 255, 88);
            int i8 = Gb[iMin];
            int i9 = ((i * this.Gd * i4) + i2) * 2;
            bArr2[i9] = (byte) (iK & 255);
            bArr2[i9 + 1] = (byte) (iK >> 8);
            for (int i10 = 0; i10 < i7 * 2; i10++) {
                int i11 = bArr[((i10 / 8) * i4 * 4) + i6 + ((i10 / 2) % 4)] & 255;
                int i12 = i10 % 2 == 0 ? i11 & 15 : i11 >> 4;
                int i13 = ((((i12 & 7) * 2) + 1) * i8) >> 3;
                if ((i12 & 8) != 0) {
                    i13 = -i13;
                }
                iK = com.applovin.exoplayer2.l.ai.k(iK + i13, -32768, 32767);
                i9 += i4 * 2;
                bArr2[i9] = (byte) (iK & 255);
                bArr2[i9 + 1] = (byte) (iK >> 8);
                int i14 = iMin + Ga[i12];
                int[] iArr = Gb;
                iMin = com.applovin.exoplayer2.l.ai.k(i14, 0, iArr.length - 1);
                i8 = iArr[iMin];
            }
        }

        private int cF(int i) {
            return i / (this.Gc.Gn * 2);
        }

        private int cG(int i) {
            return C(i, this.Gc.Gn);
        }
    }
}
