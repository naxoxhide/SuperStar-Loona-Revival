package com.applovin.exoplayer2.e.i;

import android.util.SparseArray;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class m implements j {
    private String Ct;
    private final boolean DA;
    private final boolean DB;
    private a DF;
    private boolean DG;
    private long Dh;
    private final z Dz;
    private boolean vJ;
    private com.applovin.exoplayer2.e.x wl;
    private final boolean[] Df = new boolean[3];
    private final r DC = new r(7, 128);
    private final r DD = new r(8, 128);
    private final r DE = new r(6, 128);
    private long Dk = -9223372036854775807L;
    private final com.applovin.exoplayer2.l.y DH = new com.applovin.exoplayer2.l.y();

    @Override // com.applovin.exoplayer2.e.i.j
    public void jc() {
    }

    public m(z zVar, boolean z, boolean z2) {
        this.Dz = zVar;
        this.DA = z;
        this.DB = z2;
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void jb() {
        this.Dh = 0L;
        this.DG = false;
        this.Dk = -9223372036854775807L;
        com.applovin.exoplayer2.l.v.b(this.Df);
        this.DC.Y();
        this.DD.Y();
        this.DE.Y();
        a aVar = this.DF;
        if (aVar != null) {
            aVar.Y();
        }
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void a(com.applovin.exoplayer2.e.j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        this.wl = jVar.y(dVar.jz(), 2);
        this.DF = new a(this.wl, this.DA, this.DB);
        this.Dz.a(jVar, dVar);
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.Dk = j;
        }
        this.DG |= (i & 2) != 0;
    }

    @Override // com.applovin.exoplayer2.e.i.j
    public void K(com.applovin.exoplayer2.l.y yVar) {
        jm();
        int iIl = yVar.il();
        int iPk = yVar.pk();
        byte[] bArrHO = yVar.hO();
        this.Dh += (long) yVar.pj();
        this.wl.c(yVar, yVar.pj());
        while (true) {
            int iA = com.applovin.exoplayer2.l.v.a(bArrHO, iIl, iPk, this.Df);
            if (iA == iPk) {
                f(bArrHO, iIl, iPk);
                return;
            }
            int iJ = com.applovin.exoplayer2.l.v.j(bArrHO, iA);
            int i = iA - iIl;
            if (i > 0) {
                f(bArrHO, iIl, iA);
            }
            int i2 = iPk - iA;
            long j = this.Dh - ((long) i2);
            a(j, i2, i < 0 ? -i : 0, this.Dk);
            a(j, iJ, this.Dk);
            iIl = iA + 3;
        }
    }

    private void a(long j, int i, long j2) {
        if (!this.vJ || this.DF.jo()) {
            this.DC.cB(i);
            this.DD.cB(i);
        }
        this.DE.cB(i);
        this.DF.a(j, i, j2);
    }

    private void f(byte[] bArr, int i, int i2) {
        if (!this.vJ || this.DF.jo()) {
            this.DC.g(bArr, i, i2);
            this.DD.g(bArr, i, i2);
        }
        this.DE.g(bArr, i, i2);
        this.DF.g(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (!this.vJ || this.DF.jo()) {
            this.DC.cC(i2);
            this.DD.cC(i2);
            if (!this.vJ) {
                if (this.DC.jq() && this.DD.jq()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.DC.EJ, this.DC.EK));
                    arrayList.add(Arrays.copyOf(this.DD.EJ, this.DD.EK));
                    com.applovin.exoplayer2.l.v.b bVarN = com.applovin.exoplayer2.l.v.n(this.DC.EJ, 3, this.DC.EK);
                    com.applovin.exoplayer2.l.v.a aVarO = com.applovin.exoplayer2.l.v.o(this.DD.EJ, 3, this.DD.EK);
                    this.wl.j(new com.applovin.exoplayer2.v.a().g(this.Ct).m("video/avc").k(com.applovin.exoplayer2.l.e.i(bVarN.acv, bVarN.acw, bVarN.acx)).J(bVarN.dE).K(bVarN.height).e(bVarN.acy).c(arrayList).bT());
                    this.vJ = true;
                    this.DF.a(bVarN);
                    this.DF.a(aVarO);
                    this.DC.Y();
                    this.DD.Y();
                }
            } else if (this.DC.jq()) {
                this.DF.a(com.applovin.exoplayer2.l.v.n(this.DC.EJ, 3, this.DC.EK));
                this.DC.Y();
            } else if (this.DD.jq()) {
                this.DF.a(com.applovin.exoplayer2.l.v.o(this.DD.EJ, 3, this.DD.EK));
                this.DD.Y();
            }
        }
        if (this.DE.cC(i2)) {
            this.DH.l(this.DE.EJ, com.applovin.exoplayer2.l.v.i(this.DE.EJ, this.DE.EK));
            this.DH.fx(4);
            this.Dz.a(j2, this.DH);
        }
        if (this.DF.a(j, i, this.vJ, this.DG)) {
            this.DG = false;
        }
    }

    private void jm() {
        com.applovin.exoplayer2.l.a.N(this.wl);
        ai.R(this.DF);
    }

    private static final class a {
        private final boolean DA;
        private final boolean DB;
        private int DM;
        private int DN;
        private long DO;
        private long DP;
        private C0092a DQ;
        private C0092a DR;
        private long Da;
        private long Dl;
        private boolean Dm;
        private boolean Dp;
        private boolean Dv;
        private final com.applovin.exoplayer2.e.x wl;
        private final SparseArray<com.applovin.exoplayer2.l.v.b> DI = new SparseArray<>();
        private final SparseArray<com.applovin.exoplayer2.l.v.a> DJ = new SparseArray<>();
        private byte[] DL = new byte[128];
        private final com.applovin.exoplayer2.l.z DK = new com.applovin.exoplayer2.l.z(this.DL, 0, 0);

        public a(com.applovin.exoplayer2.e.x xVar, boolean z, boolean z2) {
            this.wl = xVar;
            this.DA = z;
            this.DB = z2;
            this.DQ = new C0092a();
            this.DR = new C0092a();
            Y();
        }

        public boolean jo() {
            return this.DB;
        }

        public void a(com.applovin.exoplayer2.l.v.b bVar) {
            this.DI.append(bVar.act, bVar);
        }

        public void a(com.applovin.exoplayer2.l.v.a aVar) {
            this.DJ.append(aVar.DY, aVar);
        }

        public void Y() {
            this.Dp = false;
            this.Dv = false;
            this.DR.clear();
        }

        public void a(long j, int i, long j2) {
            this.DN = i;
            this.DP = j2;
            this.DO = j;
            if (!this.DA || i != 1) {
                if (!this.DB) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            C0092a c0092a = this.DQ;
            this.DQ = this.DR;
            this.DR = c0092a;
            c0092a.clear();
            this.DM = 0;
            this.Dp = true;
        }

        /* JADX WARN: Code duplicated, block: B:53:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:54:0x0102  */
        /* JADX WARN: Code duplicated, block: B:56:0x0106  */
        /* JADX WARN: Code duplicated, block: B:58:0x010e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:59:0x010f  */
        /* JADX WARN: Code duplicated, block: B:60:0x0118  */
        /* JADX WARN: Code duplicated, block: B:63:0x011e  */
        /* JADX WARN: Code duplicated, block: B:65:0x0128 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:66:0x0129  */
        /* JADX WARN: Code duplicated, block: B:74:0x0152  */
        public void g(byte[] bArr, int i, int i2) {
            boolean z;
            boolean z2;
            boolean zIk;
            boolean z3;
            int iPM;
            int i3;
            int iPN;
            int i4;
            int iPN2;
            int iBQ;
            if (this.Dp) {
                int i5 = i2 - i;
                byte[] bArr2 = this.DL;
                int length = bArr2.length;
                int i6 = this.DM;
                if (length < i6 + i5) {
                    this.DL = Arrays.copyOf(bArr2, (i6 + i5) * 2);
                }
                System.arraycopy(bArr, i, this.DL, this.DM, i5);
                int i7 = this.DM + i5;
                this.DM = i7;
                this.DK.s(this.DL, 0, i7);
                if (this.DK.fD(8)) {
                    this.DK.ph();
                    int iBQ2 = this.DK.bQ(2);
                    this.DK.bR(5);
                    if (this.DK.pL()) {
                        this.DK.pM();
                        if (this.DK.pL()) {
                            int iPM2 = this.DK.pM();
                            if (!this.DB) {
                                this.Dp = false;
                                this.DR.cx(iPM2);
                                return;
                            }
                            if (this.DK.pL()) {
                                int iPM3 = this.DK.pM();
                                if (this.DJ.indexOfKey(iPM3) < 0) {
                                    this.Dp = false;
                                    return;
                                }
                                com.applovin.exoplayer2.l.v.a aVar = this.DJ.get(iPM3);
                                com.applovin.exoplayer2.l.v.b bVar = this.DI.get(aVar.act);
                                if (bVar.acz) {
                                    if (!this.DK.fD(2)) {
                                        return;
                                    } else {
                                        this.DK.bR(2);
                                    }
                                }
                                if (this.DK.fD(bVar.acB)) {
                                    int iBQ3 = this.DK.bQ(bVar.acB);
                                    if (!bVar.acA) {
                                        if (this.DK.fD(1)) {
                                            boolean zIk2 = this.DK.ik();
                                            if (!zIk2) {
                                                z = zIk2;
                                                z2 = false;
                                            } else {
                                                if (!this.DK.fD(1)) {
                                                    return;
                                                }
                                                z = zIk2;
                                                z2 = true;
                                                zIk = this.DK.ik();
                                            }
                                            if (this.DN == 5) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                iPM = 0;
                                            } else if (!this.DK.pL()) {
                                                return;
                                            } else {
                                                iPM = this.DK.pM();
                                            }
                                            if (bVar.acC == 0) {
                                                if (this.DK.fD(bVar.acD)) {
                                                    iBQ = this.DK.bQ(bVar.acD);
                                                    if (aVar.acu || z) {
                                                        i3 = iBQ;
                                                        iPN = 0;
                                                    } else {
                                                        if (!this.DK.pL()) {
                                                            return;
                                                        }
                                                        iPN = this.DK.pN();
                                                        i3 = iBQ;
                                                        i4 = 0;
                                                    }
                                                    iPN2 = i4;
                                                    this.DR.a(bVar, iBQ2, iPM2, iBQ3, iPM3, z, z2, zIk, z3, iPM, i3, iPN, i4, iPN2);
                                                    this.Dp = false;
                                                }
                                                return;
                                            }
                                            if (bVar.acC == 1 || bVar.acE) {
                                                i3 = 0;
                                                iPN = 0;
                                            } else {
                                                if (!this.DK.pL()) {
                                                    return;
                                                }
                                                int iPN3 = this.DK.pN();
                                                if (!aVar.acu || z) {
                                                    i4 = iPN3;
                                                    i3 = 0;
                                                    iPN = 0;
                                                    iPN2 = 0;
                                                } else {
                                                    if (!this.DK.pL()) {
                                                        return;
                                                    }
                                                    iPN2 = this.DK.pN();
                                                    i4 = iPN3;
                                                    i3 = 0;
                                                    iPN = 0;
                                                }
                                            }
                                            this.DR.a(bVar, iBQ2, iPM2, iBQ3, iPM3, z, z2, zIk, z3, iPM, i3, iPN, i4, iPN2);
                                            this.Dp = false;
                                            i4 = iPN;
                                            iPN2 = i4;
                                            this.DR.a(bVar, iBQ2, iPM2, iBQ3, iPM3, z, z2, zIk, z3, iPM, i3, iPN, i4, iPN2);
                                            this.Dp = false;
                                        }
                                        return;
                                    }
                                    z = false;
                                    z2 = false;
                                    zIk = z2;
                                    if (this.DN == 5) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3) {
                                        iPM = 0;
                                    } else if (!this.DK.pL()) {
                                        return;
                                    } else {
                                        iPM = this.DK.pM();
                                    }
                                    if (bVar.acC == 0) {
                                        if (this.DK.fD(bVar.acD)) {
                                            return;
                                        }
                                        iBQ = this.DK.bQ(bVar.acD);
                                        if (aVar.acu) {
                                        }
                                        i3 = iBQ;
                                        iPN = 0;
                                    } else {
                                        if (bVar.acC == 1) {
                                        }
                                        i3 = 0;
                                        iPN = 0;
                                    }
                                    i4 = iPN;
                                    iPN2 = i4;
                                    this.DR.a(bVar, iBQ2, iPM2, iBQ3, iPM3, z, z2, zIk, z3, iPM, i3, iPN, i4, iPN2);
                                    this.Dp = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean a(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.DN == 9 || (this.DB && this.DR.a(this.DQ))) {
                if (z && this.Dv) {
                    cw(i + ((int) (j - this.DO)));
                }
                this.Dl = this.DO;
                this.Da = this.DP;
                this.Dm = false;
                this.Dv = true;
            }
            if (this.DA) {
                z2 = this.DR.jp();
            }
            boolean z4 = this.Dm;
            int i2 = this.DN;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.Dm = z5;
            return z5;
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
        private void cw(int i) {
            long j = this.Da;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.Dm;
            this.wl.a(j, z ? 1 : 0, (int) (this.DO - this.Dl), i, null);
        }

        /* JADX INFO: renamed from: com.applovin.exoplayer2.e.i.m$a$a, reason: collision with other inner class name */
        private static final class C0092a {
            private boolean DS;
            private boolean DT;
            private com.applovin.exoplayer2.l.v.b DU;
            private int DV;
            private int DW;
            private int DX;
            private int DY;
            private boolean DZ;
            private boolean Ea;
            private boolean Eb;
            private boolean Ec;
            private int Ed;
            private int Ee;
            private int Ef;
            private int Eg;
            private int Eh;

            private C0092a() {
            }

            public void clear() {
                this.DT = false;
                this.DS = false;
            }

            public void cx(int i) {
                this.DW = i;
                this.DT = true;
            }

            public void a(com.applovin.exoplayer2.l.v.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.DU = bVar;
                this.DV = i;
                this.DW = i2;
                this.DX = i3;
                this.DY = i4;
                this.DZ = z;
                this.Ea = z2;
                this.Eb = z3;
                this.Ec = z4;
                this.Ed = i5;
                this.Ee = i6;
                this.Ef = i7;
                this.Eg = i8;
                this.Eh = i9;
                this.DS = true;
                this.DT = true;
            }

            public boolean jp() {
                int i;
                return this.DT && ((i = this.DW) == 7 || i == 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(C0092a c0092a) {
                int i;
                int i2;
                boolean z;
                if (!this.DS) {
                    return false;
                }
                if (!c0092a.DS) {
                    return true;
                }
                com.applovin.exoplayer2.l.v.b bVar = (com.applovin.exoplayer2.l.v.b) com.applovin.exoplayer2.l.a.N(this.DU);
                com.applovin.exoplayer2.l.v.b bVar2 = (com.applovin.exoplayer2.l.v.b) com.applovin.exoplayer2.l.a.N(c0092a.DU);
                return (this.DX == c0092a.DX && this.DY == c0092a.DY && this.DZ == c0092a.DZ && (!this.Ea || !c0092a.Ea || this.Eb == c0092a.Eb) && (((i = this.DV) == (i2 = c0092a.DV) || (i != 0 && i2 != 0)) && ((bVar.acC != 0 || bVar2.acC != 0 || (this.Ee == c0092a.Ee && this.Ef == c0092a.Ef)) && ((bVar.acC != 1 || bVar2.acC != 1 || (this.Eg == c0092a.Eg && this.Eh == c0092a.Eh)) && (z = this.Ec) == c0092a.Ec && (!z || this.Ed == c0092a.Ed))))) ? false : true;
            }
        }
    }
}
