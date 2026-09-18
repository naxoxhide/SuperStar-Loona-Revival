package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.l.ai;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class l implements j {
    private static final float[] Dr = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private String Ct;
    private final af Dc;
    private final com.applovin.exoplayer2.l.y Dd;
    private final r De;
    private final boolean[] Df;
    private long Dh;
    private long Dk;
    private final a Ds;
    private b Dt;
    private boolean vJ;
    private com.applovin.exoplayer2.e.x wl;

    @Override // com.applovin.exoplayer2.e.i.j
    public void jc() {
    }

    public l() {
        this(null);
    }

    l(af afVar) {
        this.Dc = afVar;
        this.Df = new boolean[4];
        this.Ds = new a(128);
        this.Dk = -9223372036854775807L;
        if (afVar != null) {
            this.De = new r(178, 128);
            this.Dd = new com.applovin.exoplayer2.l.y();
        } else {
            this.De = null;
            this.Dd = null;
        }
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void jb() {
        com.applovin.exoplayer2.l.v.b(this.Df);
        this.Ds.Y();
        b bVar = this.Dt;
        if (bVar != null) {
            bVar.Y();
        }
        r rVar = this.De;
        if (rVar != null) {
            rVar.Y();
        }
        this.Dh = 0L;
        this.Dk = -9223372036854775807L;
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void a(com.applovin.exoplayer2.e.j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        this.wl = jVar.y(dVar.jz(), 2);
        this.Dt = new b(this.wl);
        af afVar = this.Dc;
        if (afVar != null) {
            afVar.a(jVar, dVar);
        }
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.Dk = j;
        }
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void K(com.applovin.exoplayer2.l.y yVar) {
        com.applovin.exoplayer2.l.a.N(this.Dt);
        com.applovin.exoplayer2.l.a.N(this.wl);
        int iIl = yVar.il();
        int iPk = yVar.pk();
        byte[] bArrHO = yVar.hO();
        this.Dh += (long) yVar.pj();
        this.wl.c(yVar, yVar.pj());
        while (true) {
            int iA = com.applovin.exoplayer2.l.v.a(bArrHO, iIl, iPk, this.Df);
            if (iA == iPk) {
                break;
            }
            int i = iA + 3;
            int i2 = yVar.hO()[i] & 255;
            int i3 = iA - iIl;
            int i4 = 0;
            if (!this.vJ) {
                if (i3 > 0) {
                    this.Ds.e(bArrHO, iIl, iA);
                }
                if (this.Ds.B(i2, i3 < 0 ? -i3 : 0)) {
                    com.applovin.exoplayer2.e.x xVar = this.wl;
                    a aVar = this.Ds;
                    xVar.j(a(aVar, aVar.Du, (String) com.applovin.exoplayer2.l.a.checkNotNull(this.Ct)));
                    this.vJ = true;
                }
            }
            this.Dt.e(bArrHO, iIl, iA);
            r rVar = this.De;
            if (rVar != null) {
                if (i3 > 0) {
                    rVar.g(bArrHO, iIl, iA);
                } else {
                    i4 = -i3;
                }
                if (this.De.cC(i4)) {
                    ((com.applovin.exoplayer2.l.y) ai.R(this.Dd)).l(this.De.EJ, com.applovin.exoplayer2.l.v.i(this.De.EJ, this.De.EK));
                    ((af) ai.R(this.Dc)).a(this.Dk, this.Dd);
                }
                if (i2 == 178 && yVar.hO()[iA + 2] == 1) {
                    this.De.cB(i2);
                }
            }
            int i5 = iPk - iA;
            this.Dt.a(this.Dh - ((long) i5), i5, this.vJ);
            this.Dt.g(i2, this.Dk);
            iIl = i;
        }
        if (!this.vJ) {
            this.Ds.e(bArrHO, iIl, iPk);
        }
        this.Dt.e(bArrHO, iIl, iPk);
        r rVar2 = this.De;
        if (rVar2 != null) {
            rVar2.g(bArrHO, iIl, iPk);
        }
    }

    private static com.applovin.exoplayer2.v a(a aVar, int i, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.tf, aVar.fR);
        com.applovin.exoplayer2.l.x xVar = new com.applovin.exoplayer2.l.x(bArrCopyOf);
        xVar.fz(i);
        xVar.fz(4);
        xVar.ph();
        xVar.bR(8);
        if (xVar.ik()) {
            xVar.bR(4);
            xVar.bR(3);
        }
        int iBQ = xVar.bQ(4);
        float f = 1.0f;
        if (iBQ == 15) {
            int iBQ2 = xVar.bQ(8);
            int iBQ3 = xVar.bQ(8);
            if (iBQ3 == 0) {
                com.applovin.exoplayer2.l.q.h("H263Reader", "Invalid aspect ratio");
            } else {
                f = iBQ2 / iBQ3;
            }
        } else {
            float[] fArr = Dr;
            if (iBQ < fArr.length) {
                f = fArr[iBQ];
            } else {
                com.applovin.exoplayer2.l.q.h("H263Reader", "Invalid aspect ratio");
            }
        }
        if (xVar.ik()) {
            xVar.bR(2);
            xVar.bR(1);
            if (xVar.ik()) {
                xVar.bR(15);
                xVar.ph();
                xVar.bR(15);
                xVar.ph();
                xVar.bR(15);
                xVar.ph();
                xVar.bR(3);
                xVar.bR(11);
                xVar.ph();
                xVar.bR(15);
                xVar.ph();
            }
        }
        if (xVar.bQ(2) != 0) {
            com.applovin.exoplayer2.l.q.h("H263Reader", "Unhandled video object layer shape");
        }
        xVar.ph();
        int iBQ4 = xVar.bQ(16);
        xVar.ph();
        if (xVar.ik()) {
            if (iBQ4 == 0) {
                com.applovin.exoplayer2.l.q.h("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i2 = 0;
                for (int i3 = iBQ4 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                xVar.bR(i2);
            }
        }
        xVar.ph();
        int iBQ5 = xVar.bQ(13);
        xVar.ph();
        int iBQ6 = xVar.bQ(13);
        xVar.ph();
        xVar.ph();
        return new com.applovin.exoplayer2.v.a().g(str).m("video/mp4v-es").J(iBQ5).K(iBQ6).e(f).c(Collections.singletonList(bArrCopyOf)).bT();
    }

    private static final class a {
        private static final byte[] Do = {0, 0, 1};
        private boolean Dp;
        public int Du;
        private int Z;
        public int fR;
        public byte[] tf;

        public a(int i) {
            this.tf = new byte[i];
        }

        public void Y() {
            this.Dp = false;
            this.fR = 0;
            this.Z = 0;
        }

        public boolean B(int i, int i2) {
            int i3 = this.Z;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i == 179 || i == 181) {
                                this.fR -= i2;
                                this.Dp = false;
                                return true;
                            }
                        } else if ((i & 240) != 32) {
                            com.applovin.exoplayer2.l.q.h("H263Reader", "Unexpected start code value");
                            Y();
                        } else {
                            this.Du = this.fR;
                            this.Z = 4;
                        }
                    } else if (i > 31) {
                        com.applovin.exoplayer2.l.q.h("H263Reader", "Unexpected start code value");
                        Y();
                    } else {
                        this.Z = 3;
                    }
                } else if (i != 181) {
                    com.applovin.exoplayer2.l.q.h("H263Reader", "Unexpected start code value");
                    Y();
                } else {
                    this.Z = 2;
                }
            } else if (i == 176) {
                this.Z = 1;
                this.Dp = true;
            }
            byte[] bArr = Do;
            e(bArr, 0, bArr.length);
            return false;
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.Dp) {
                int i3 = i2 - i;
                byte[] bArr2 = this.tf;
                int length = bArr2.length;
                int i4 = this.fR;
                if (length < i4 + i3) {
                    this.tf = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.tf, this.fR, i3);
                this.fR += i3;
            }
        }
    }

    private static final class b {
        private long Da;
        private long Dl;
        private boolean Dm;
        private boolean Dv;
        private boolean Dw;
        private int Dx;
        private int Dy;
        private final com.applovin.exoplayer2.e.x wl;

        public b(com.applovin.exoplayer2.e.x xVar) {
            this.wl = xVar;
        }

        public void Y() {
            this.Dv = false;
            this.Dw = false;
            this.Dm = false;
            this.Dx = -1;
        }

        public void g(int i, long j) {
            this.Dx = i;
            this.Dm = false;
            this.Dv = i == 182 || i == 179;
            this.Dw = i == 182;
            this.Dy = 0;
            this.Da = j;
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.Dw) {
                int i3 = this.Dy;
                int i4 = (i + 1) - i3;
                if (i4 < i2) {
                    this.Dm = ((bArr[i4] & 192) >> 6) == 0;
                    this.Dw = false;
                } else {
                    this.Dy = i3 + (i2 - i);
                }
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void a(long j, int i, boolean z) {
            if (this.Dx == 182 && z && this.Dv) {
                long j2 = this.Da;
                if (j2 != -9223372036854775807L) {
                    this.wl.a(j2, this.Dm ? 1 : 0, (int) (j - this.Dl), i, null);
                }
            }
            if (this.Dx != 179) {
                this.Dl = j;
            }
        }
    }
}
