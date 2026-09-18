package com.applovin.exoplayer2.e.i;

import android.util.Pair;
import com.applovin.exoplayer2.l.ai;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class k implements j {
    private static final double[] Db = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String Ct;
    private long Da;
    private final af Dc;
    private final com.applovin.exoplayer2.l.y Dd;
    private final r De;
    private final boolean[] Df;
    private final a Dg;
    private long Dh;
    private boolean Di;
    private long Dj;
    private long Dk;
    private long Dl;
    private boolean Dm;
    private boolean Dn;
    private boolean vJ;
    private com.applovin.exoplayer2.e.x wl;

    @Override // com.applovin.exoplayer2.e.i.j
    public void jc() {
    }

    public k() {
        this(null);
    }

    k(af afVar) {
        this.Dc = afVar;
        this.Df = new boolean[4];
        this.Dg = new a(128);
        if (afVar != null) {
            this.De = new r(178, 128);
            this.Dd = new com.applovin.exoplayer2.l.y();
        } else {
            this.De = null;
            this.Dd = null;
        }
        this.Dk = -9223372036854775807L;
        this.Da = -9223372036854775807L;
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void jb() {
        com.applovin.exoplayer2.l.v.b(this.Df);
        this.Dg.Y();
        r rVar = this.De;
        if (rVar != null) {
            rVar.Y();
        }
        this.Dh = 0L;
        this.Di = false;
        this.Dk = -9223372036854775807L;
        this.Da = -9223372036854775807L;
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void a(com.applovin.exoplayer2.e.j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        this.wl = jVar.y(dVar.jz(), 2);
        af afVar = this.Dc;
        if (afVar != null) {
            afVar.a(jVar, dVar);
        }
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void e(long j, int i) {
        this.Dk = j;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0114  */
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
    @Override // com.applovin.exoplayer2.e.i.j
    public void K(com.applovin.exoplayer2.l.y yVar) {
        boolean z;
        int i;
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
            int i2 = iA + 3;
            int i3 = yVar.hO()[i2] & 255;
            int i4 = iA - iIl;
            if (!this.vJ) {
                if (i4 > 0) {
                    this.Dg.e(bArrHO, iIl, iA);
                }
                if (this.Dg.B(i3, i4 < 0 ? -i4 : 0)) {
                    Pair<com.applovin.exoplayer2.v, Long> pairA = a(this.Dg, (String) com.applovin.exoplayer2.l.a.checkNotNull(this.Ct));
                    this.wl.j((com.applovin.exoplayer2.v) pairA.first);
                    this.Dj = ((Long) pairA.second).longValue();
                    this.vJ = true;
                }
            }
            r rVar = this.De;
            if (rVar != null) {
                if (i4 > 0) {
                    rVar.g(bArrHO, iIl, iA);
                    i = 0;
                } else {
                    i = -i4;
                }
                if (this.De.cC(i)) {
                    ((com.applovin.exoplayer2.l.y) ai.R(this.Dd)).l(this.De.EJ, com.applovin.exoplayer2.l.v.i(this.De.EJ, this.De.EK));
                    ((af) ai.R(this.Dc)).a(this.Da, this.Dd);
                }
                if (i3 == 178 && yVar.hO()[iA + 2] == 1) {
                    this.De.cB(i3);
                }
            }
            if (i3 == 0 || i3 == 179) {
                int i5 = iPk - iA;
                if (this.Dn && this.vJ) {
                    long j = this.Da;
                    if (j != -9223372036854775807L) {
                        this.wl.a(j, this.Dm ? 1 : 0, ((int) (this.Dh - this.Dl)) - i5, i5, null);
                    }
                }
                if (!this.Di || this.Dn) {
                    this.Dl = this.Dh - ((long) i5);
                    long j2 = this.Dk;
                    if (j2 == -9223372036854775807L) {
                        long j3 = this.Da;
                        j2 = j3 != -9223372036854775807L ? j3 + this.Dj : -9223372036854775807L;
                    }
                    this.Da = j2;
                    this.Dm = false;
                    this.Dk = -9223372036854775807L;
                    z = true;
                    this.Di = true;
                } else {
                    z = true;
                }
                this.Dn = i3 == 0 ? z : false;
            } else if (i3 == 184) {
                this.Dm = true;
            }
            iIl = i2;
        }
        if (!this.vJ) {
            this.Dg.e(bArrHO, iIl, iPk);
        }
        r rVar2 = this.De;
        if (rVar2 != null) {
            rVar2.g(bArrHO, iIl, iPk);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0075  */
    /* JADX WARN: Code duplicated, block: B:16:0x007a  */
    /* JADX WARN: Code duplicated, block: B:18:0x008c  */
    private static Pair<com.applovin.exoplayer2.v, Long> a(a aVar, String str) {
        float f;
        int i;
        float f2;
        long j;
        int i2;
        double[] dArr;
        double d;
        int i3;
        int i4;
        byte[] bArrCopyOf = Arrays.copyOf(aVar.tf, aVar.fR);
        int i5 = bArrCopyOf[4] & 255;
        int i6 = bArrCopyOf[5] & 255;
        int i7 = (i5 << 4) | (i6 >> 4);
        int i8 = ((i6 & 15) << 8) | (bArrCopyOf[6] & 255);
        int i9 = (bArrCopyOf[7] & 240) >> 4;
        if (i9 == 2) {
            f = i8 * 4;
            i = i7 * 3;
        } else {
            if (i9 != 3) {
                if (i9 != 4) {
                    f2 = 1.0f;
                } else {
                    f = i8 * 121;
                    i = i7 * 100;
                }
                com.applovin.exoplayer2.v vVarBT = new com.applovin.exoplayer2.v.a().g(str).m("video/mpeg2").J(i7).K(i8).e(f2).c(Collections.singletonList(bArrCopyOf)).bT();
                j = 0;
                i2 = (bArrCopyOf[7] & 15) - 1;
                if (i2 >= 0) {
                    dArr = Db;
                    if (i2 < dArr.length) {
                        d = dArr[i2];
                        int i10 = aVar.Dq + 9;
                        i3 = (bArrCopyOf[i10] & 96) >> 5;
                        i4 = bArrCopyOf[i10] & 31;
                        if (i3 != i4) {
                            d *= (((double) i3) + 1.0d) / ((double) (i4 + 1));
                        }
                        j = (long) (1000000.0d / d);
                    }
                }
                return Pair.create(vVarBT, Long.valueOf(j));
            }
            f = i8 * 16;
            i = i7 * 9;
        }
        f2 = f / i;
        com.applovin.exoplayer2.v vVarBT2 = new com.applovin.exoplayer2.v.a().g(str).m("video/mpeg2").J(i7).K(i8).e(f2).c(Collections.singletonList(bArrCopyOf)).bT();
        j = 0;
        i2 = (bArrCopyOf[7] & 15) - 1;
        if (i2 >= 0) {
            dArr = Db;
            if (i2 < dArr.length) {
                d = dArr[i2];
                int i11 = aVar.Dq + 9;
                i3 = (bArrCopyOf[i11] & 96) >> 5;
                i4 = bArrCopyOf[i11] & 31;
                if (i3 != i4) {
                    d *= (((double) i3) + 1.0d) / ((double) (i4 + 1));
                }
                j = (long) (1000000.0d / d);
            }
        }
        return Pair.create(vVarBT2, Long.valueOf(j));
    }

    private static final class a {
        private static final byte[] Do = {0, 0, 1};
        private boolean Dp;
        public int Dq;
        public int fR;
        public byte[] tf;

        public a(int i) {
            this.tf = new byte[i];
        }

        public void Y() {
            this.Dp = false;
            this.fR = 0;
            this.Dq = 0;
        }

        public boolean B(int i, int i2) {
            if (this.Dp) {
                int i3 = this.fR - i2;
                this.fR = i3;
                if (this.Dq == 0 && i == 181) {
                    this.Dq = i3;
                } else {
                    this.Dp = false;
                    return true;
                }
            } else if (i == 179) {
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
}
