package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.l;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {
    public static final int D = u.a("seig");
    public static final byte[] E = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public n A;
    public n[] B;
    public boolean C;
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<b> f1099b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k e;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k f;
    public final r g;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k h;
    public final byte[] i;
    public final Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a> j;
    public final LinkedList<a> k;
    public int l;
    public int m;
    public long n;
    public int o;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.k p;
    public long q;
    public int r;
    public long s;
    public long t;
    public b u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.h z;

    public static final class a {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1100b;

        public a(long j, int i) {
            this.a = j;
            this.f1100b = i;
        }
    }

    public d(int i, r rVar) {
        this(i, null, null);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar) throws InterruptedException, IOException {
        return g.a(gVar, true);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void b() {
    }

    public final void c() {
        if ((this.a & 4) != 0 && this.A == null) {
            n nVarA = this.z.a(this.f1099b.size(), 4);
            this.A = nVarA;
            nVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a((String) null, "application/x-emsg", Long.MAX_VALUE));
        }
        if ((this.a & 8) == 0 || this.B != null) {
            return;
        }
        n nVarA2 = this.z.a(this.f1099b.size() + 1, 3);
        nVarA2.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a((String) null, "application/cea-608", (String) null, -1, 0, (String) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null));
        this.B = new n[]{nVarA2};
    }

    public d(int i, r rVar, h hVar) {
        this.a = i | 0;
        this.g = rVar;
        this.h = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(16);
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(com.fyber.inneractive.sdk.player.exoplayer2.util.i.a);
        this.d = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(5);
        this.e = new com.fyber.inneractive.sdk.player.exoplayer2.util.k();
        this.f = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(1);
        this.i = new byte[16];
        this.j = new Stack<>();
        this.k = new LinkedList<>();
        this.f1099b = new SparseArray<>();
        this.s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        a();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar) {
        this.z = hVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(long j, long j2) {
        int size = this.f1099b.size();
        for (int i = 0; i < size; i++) {
            this.f1099b.valueAt(i).a();
        }
        this.k.clear();
        this.r = 0;
        this.j.clear();
        a();
    }

    public static final class b {
        public final j a = new j();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f1101b;
        public h c;
        public c d;
        public int e;
        public int f;
        public int g;

        public b(n nVar) {
            this.f1101b = nVar;
        }

        public void a(h hVar, c cVar) {
            hVar.getClass();
            this.c = hVar;
            cVar.getClass();
            this.d = cVar;
            this.f1101b.a(hVar.f);
            a();
        }

        public void a() {
            j jVar = this.a;
            jVar.d = 0;
            jVar.r = 0L;
            jVar.l = false;
            jVar.q = false;
            jVar.n = null;
            this.e = 0;
            this.g = 0;
            this.f = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0244 A[LOOP:5: B:99:0x023c->B:101:0x0244, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:104:0x027b  */
    /* JADX WARN: Code duplicated, block: B:161:0x0477  */
    /* JADX WARN: Code duplicated, block: B:164:0x049a  */
    /* JADX WARN: Code duplicated, block: B:166:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:168:0x04b0 A[LOOP:8: B:167:0x04ae->B:168:0x04b0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:171:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:173:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:175:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:195:0x0511  */
    /* JADX WARN: Code duplicated, block: B:197:0x0514  */
    /* JADX WARN: Code duplicated, block: B:199:0x0531  */
    /* JADX WARN: Code duplicated, block: B:200:0x0535  */
    /* JADX WARN: Code duplicated, block: B:202:0x053b  */
    /* JADX WARN: Code duplicated, block: B:244:0x058e  */
    /* JADX WARN: Code duplicated, block: B:247:0x0594  */
    /* JADX WARN: Code duplicated, block: B:249:0x059a  */
    /* JADX WARN: Code duplicated, block: B:251:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:256:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:258:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:273:0x05de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x05bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:0x05b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x05d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:298:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:299:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:304:0x01f4 A[EDGE_INSN: B:304:0x01f4->B:83:0x01f4 BREAK  A[LOOP:6: B:80:0x01e3->B:82:0x01e9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x010a  */
    /* JADX WARN: Code duplicated, block: B:57:0x011e  */
    /* JADX WARN: Code duplicated, block: B:61:0x014c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0172  */
    /* JADX WARN: Code duplicated, block: B:73:0x0174  */
    /* JADX WARN: Code duplicated, block: B:77:0x0187  */
    /* JADX WARN: Code duplicated, block: B:78:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e3 A[LOOP:6: B:80:0x01e3->B:82:0x01e9, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:82:0x01e9 A[LOOP:6: B:80:0x01e3->B:82:0x01e9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:85:0x0205  */
    /* JADX WARN: Code duplicated, block: B:86:0x0208  */
    /* JADX WARN: Code duplicated, block: B:89:0x0215  */
    /* JADX WARN: Code duplicated, block: B:91:0x0219  */
    /* JADX WARN: Code duplicated, block: B:92:0x021c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0225  */
    /* JADX WARN: Code duplicated, block: B:97:0x022b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, l lVar) throws InterruptedException, IOException {
        long j;
        long j2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar;
        long j3;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        long j4;
        boolean z4;
        long j5;
        int size;
        int i2;
        long jP;
        long jP2;
        j jVar;
        h hVar;
        n nVar;
        int i3;
        int i4;
        int i5;
        int i6;
        long jA;
        boolean z5;
        int i7;
        int i8;
        byte[] bArr;
        r rVar;
        b bVar2;
        int i9;
        int[] iArr;
        int i10;
        i iVar;
        byte[] bArr2;
        byte[] bArr3;
        int i11;
        int i12;
        int i13;
        boolean z6;
        String str;
        int i14;
        int iA;
        int i15;
        while (true) {
            while (true) {
                int i16 = this.l;
                boolean z7 = true;
                int i17 = 0;
                if (i16 == 0) {
                    if (this.o == 0) {
                        if (((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.h.a, 0, 8, true)) {
                            this.o = 8;
                            this.h.e(0);
                            this.n = this.h.m();
                            this.m = this.h.c();
                            if (this.n == 1) {
                                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.h.a, 8, 8, false);
                                this.o += 8;
                                this.n = this.h.p();
                            }
                            j = this.n;
                            j2 = this.o;
                            if (j >= j2) {
                                bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                                j3 = bVar.c - j2;
                                if (this.m == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.L) {
                                    size = this.f1099b.size();
                                    for (i2 = 0; i2 < size; i2++) {
                                        j jVar2 = this.f1099b.valueAt(i2).a;
                                        jVar2.getClass();
                                        jVar2.c = j3;
                                        jVar2.f1107b = j3;
                                    }
                                }
                                i = this.m;
                                if (i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.i) {
                                    this.u = null;
                                    this.q = j3 + this.n;
                                    if (!this.C) {
                                        this.z.a(new m.a(this.s));
                                        this.C = true;
                                    }
                                    this.l = 2;
                                    z4 = true;
                                } else {
                                    if (i != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.E || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.F || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.G || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.L || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.M || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.N || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.Q) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        j5 = (bVar.c + this.n) - 8;
                                        this.j.add(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a(this.m, j5));
                                        if (this.n == this.o) {
                                            a(j5);
                                        } else {
                                            a();
                                        }
                                        z3 = true;
                                    } else {
                                        if (i != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.T || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.S || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.D || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.B || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.U || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.x || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.y || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.P || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.z || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.A || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.V || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.d0 || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.e0 || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.i0 || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.h0 || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f0 || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.g0 || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.R || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.O || i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.G0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            if (this.o == 8) {
                                                j4 = this.n;
                                                if (j4 <= 2147483647L) {
                                                    com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.k((int) j4);
                                                    this.p = kVar;
                                                    System.arraycopy(this.h.a, 0, kVar.a, 0, 8);
                                                    z3 = true;
                                                    this.l = 1;
                                                } else {
                                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Leaf atom with length > 2147483647 (unsupported).");
                                                }
                                            } else {
                                                throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Leaf atom defines extended atom size (unsupported).");
                                            }
                                        } else if (this.n <= 2147483647L) {
                                            this.p = null;
                                            z3 = true;
                                            this.l = 1;
                                        } else {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Skipping atom with length > 2147483647 (unsupported).");
                                        }
                                    }
                                    z4 = z3;
                                }
                            } else {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Atom size less than header length (unsupported).");
                            }
                        } else {
                            z4 = false;
                        }
                    } else {
                        if (this.n == 1) {
                            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.h.a, 8, 8, false);
                            this.o += 8;
                            this.n = this.h.p();
                        }
                        j = this.n;
                        j2 = this.o;
                        if (j >= j2) {
                            bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                            j3 = bVar.c - j2;
                            if (this.m == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.L) {
                                size = this.f1099b.size();
                                while (i2 < size) {
                                    j jVar3 = this.f1099b.valueAt(i2).a;
                                    jVar3.getClass();
                                    jVar3.c = j3;
                                    jVar3.f1107b = j3;
                                }
                            }
                            i = this.m;
                            if (i == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.i) {
                                this.u = null;
                                this.q = j3 + this.n;
                                if (!this.C) {
                                    this.z.a(new m.a(this.s));
                                    this.C = true;
                                }
                                this.l = 2;
                                z4 = true;
                            } else {
                                if (i != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    j5 = (bVar.c + this.n) - 8;
                                    this.j.add(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a(this.m, j5));
                                    if (this.n == this.o) {
                                        a(j5);
                                    } else {
                                        a();
                                    }
                                    z3 = true;
                                } else {
                                    if (i != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.T) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        if (this.o == 8) {
                                            j4 = this.n;
                                            if (j4 <= 2147483647L) {
                                                com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k((int) j4);
                                                this.p = kVar2;
                                                System.arraycopy(this.h.a, 0, kVar2.a, 0, 8);
                                                z3 = true;
                                                this.l = 1;
                                            } else {
                                                throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Leaf atom with length > 2147483647 (unsupported).");
                                            }
                                        } else {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Leaf atom defines extended atom size (unsupported).");
                                        }
                                    } else if (this.n <= 2147483647L) {
                                        this.p = null;
                                        z3 = true;
                                        this.l = 1;
                                    } else {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Skipping atom with length > 2147483647 (unsupported).");
                                    }
                                }
                                z4 = z3;
                            }
                        } else {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Atom size less than header length (unsupported).");
                        }
                    }
                    if (z4) {
                        break;
                    }
                    return -1;
                }
                if (i16 == 1) {
                    int i18 = ((int) this.n) - this.o;
                    com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar3 = this.p;
                    if (kVar3 != null) {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                        bVar3.b(kVar3.a, 8, i18, false);
                        int i19 = this.m;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar4 = this.p;
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVar4 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(i19, kVar4);
                        long j6 = bVar3.c;
                        if (!this.j.isEmpty()) {
                            this.j.peek().Q0.add(bVar4);
                        } else if (i19 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.B) {
                            kVar4.e(8);
                            int iB = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar4.c());
                            kVar4.f(4);
                            long jM = kVar4.m();
                            if (iB == 0) {
                                jP = kVar4.m();
                                jP2 = kVar4.m();
                            } else {
                                jP = kVar4.p();
                                jP2 = kVar4.p();
                            }
                            long j7 = j6 + jP2;
                            long j8 = jP;
                            long jA2 = u.a(j8, 1000000L, jM);
                            kVar4.f(2);
                            int iQ = kVar4.q();
                            int[] iArr2 = new int[iQ];
                            long[] jArr = new long[iQ];
                            long[] jArr2 = new long[iQ];
                            long[] jArr3 = new long[iQ];
                            long jA3 = jA2;
                            while (i17 < iQ) {
                                int iC = kVar4.c();
                                if ((iC & Integer.MIN_VALUE) == 0) {
                                    long jM2 = kVar4.m();
                                    iArr2[i17] = iC & Integer.MAX_VALUE;
                                    jArr[i17] = j7;
                                    jArr3[i17] = jA3;
                                    j8 += jM2;
                                    int i20 = iQ;
                                    long[] jArr4 = jArr2;
                                    long[] jArr5 = jArr3;
                                    jA3 = u.a(j8, 1000000L, jM);
                                    jArr4[i17] = jA3 - jArr5[i17];
                                    kVar4.f(4);
                                    j7 += (long) iArr2[i17];
                                    i17++;
                                    jArr = jArr;
                                    jArr3 = jArr5;
                                    jArr2 = jArr4;
                                    iQ = i20;
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Unhandled indirect reference");
                                }
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jA2), new com.fyber.inneractive.sdk.player.exoplayer2.extractor.a(iArr2, jArr, jArr2, jArr3));
                            this.t = ((Long) pairCreate.first).longValue();
                            this.z.a((m) pairCreate.second);
                            this.C = true;
                        } else if (i19 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.G0 && this.A != null) {
                            kVar4.e(12);
                            kVar4.j();
                            kVar4.j();
                            long jA4 = u.a(kVar4.m(), 1000000L, kVar4.m());
                            kVar4.e(12);
                            int iA2 = kVar4.a();
                            this.A.a(kVar4, iA2);
                            long j9 = this.t;
                            if (j9 != -9223372036854775807L) {
                                this.A.a(j9 + jA4, 1, iA2, 0, null);
                            } else {
                                this.k.addLast(new a(jA4, iA2));
                                this.r += iA2;
                            }
                        }
                    } else {
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c(i18);
                    }
                    a(((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c);
                    break;
                }
                long j10 = Long.MAX_VALUE;
                if (i16 != 2) {
                    int i21 = 6;
                    if (i16 == 3) {
                        if (this.u == null) {
                            SparseArray<b> sparseArray = this.f1099b;
                            int size2 = sparseArray.size();
                            b bVar5 = null;
                            for (int i22 = 0; i22 < size2; i22++) {
                                b bVarValueAt = sparseArray.valueAt(i22);
                                int i23 = bVarValueAt.g;
                                j jVar4 = bVarValueAt.a;
                                if (i23 != jVar4.d) {
                                    long j11 = jVar4.f[i23];
                                    if (j11 < j10) {
                                        j10 = j11;
                                        bVar5 = bVarValueAt;
                                    }
                                }
                            }
                            if (bVar5 == null) {
                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar6 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                                int i24 = (int) (this.q - bVar6.c);
                                if (i24 >= 0) {
                                    bVar6.c(i24);
                                    a();
                                    z7 = false;
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Offset to end of mdat was negative.");
                                }
                            } else {
                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar7 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                                int i25 = (int) (bVar5.a.f[bVar5.g] - bVar7.c);
                                if (i25 < 0) {
                                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                    i25 = 0;
                                }
                                bVar7.c(i25);
                                this.u = bVar5;
                            }
                        }
                        b bVar8 = this.u;
                        j jVar5 = bVar8.a;
                        int[] iArr3 = jVar5.h;
                        int i26 = bVar8.e;
                        this.v = iArr3[i26];
                        if (jVar5.l) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar5 = jVar5.p;
                            int i27 = jVar5.a.a;
                            i iVar2 = jVar5.n;
                            if (iVar2 == null) {
                                iVar2 = bVar8.c.h[i27];
                            }
                            int i28 = iVar2.a;
                            boolean z8 = jVar5.m[i26];
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar6 = this.f;
                            kVar6.a[0] = (byte) ((z8 ? 128 : 0) | i28);
                            kVar6.e(0);
                            n nVar2 = bVar8.f1101b;
                            nVar2.a(this.f, 1);
                            nVar2.a(kVar5, i28);
                            if (z8) {
                                int iQ2 = kVar5.q();
                                kVar5.f(-2);
                                int i29 = (iQ2 * 6) + 2;
                                nVar2.a(kVar5, i29);
                                i15 = i28 + 1 + i29;
                            } else {
                                i15 = i28 + 1;
                            }
                            this.w = i15;
                            this.v += i15;
                        } else {
                            this.w = 0;
                        }
                        if (this.u.c.g == 1) {
                            this.v -= 8;
                            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c(8);
                        }
                        this.l = 4;
                        this.x = 0;
                        b bVar9 = this.u;
                        jVar = bVar9.a;
                        hVar = bVar9.c;
                        nVar = bVar9.f1101b;
                        i3 = bVar9.e;
                        i4 = hVar.k;
                        if (i4 != 0) {
                            while (true) {
                                i5 = this.w;
                                i6 = this.v;
                                if (i5 < i6) {
                                    break;
                                    break;
                                }
                                this.w += nVar.a(gVar, i6 - i5, false);
                            }
                        } else {
                            bArr3 = this.d.a;
                            bArr3[0] = 0;
                            bArr3[1] = 0;
                            bArr3[2] = 0;
                            i11 = i4 + 1;
                            i12 = 4 - i4;
                            while (this.w < this.v) {
                                i13 = this.x;
                                if (i13 == 0) {
                                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr3, i12, i11, false);
                                    this.d.e(0);
                                    this.x = this.d.o() - 1;
                                    this.c.e(0);
                                    nVar.a(this.c, 4);
                                    nVar.a(this.d, 1);
                                    if (this.B != null) {
                                        str = hVar.f.f;
                                        i14 = bArr3[4];
                                        byte[] bArr4 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a;
                                        if (((!"video/avc".equals(str) && (i14 & 31) == i21) || ("video/hevc".equals(str) && ((i14 & 126) >> 1) == 39)) == true) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                    } else {
                                        z6 = false;
                                    }
                                    this.y = z6;
                                    this.w += 5;
                                    this.v += i12;
                                } else {
                                    if (this.y) {
                                        this.e.c(i13);
                                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.e.a, 0, this.x, false);
                                        nVar.a(this.e, this.x);
                                        iA = this.x;
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar7 = this.e;
                                        int iA3 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(kVar7.a, kVar7.c);
                                        this.e.e("video/hevc".equals(hVar.f.f) ? 1 : 0);
                                        this.e.d(iA3);
                                        com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a((jVar.j[i3] + ((long) jVar.i[i3])) * 1000, this.e, this.B);
                                    } else {
                                        iA = nVar.a(gVar, i13, false);
                                    }
                                    this.w += iA;
                                    this.x -= iA;
                                    i21 = 6;
                                }
                            }
                        }
                        jA = (jVar.j[i3] + ((long) jVar.i[i3])) * 1000;
                        z5 = jVar.l;
                        if (z5) {
                            i7 = 1073741824;
                        } else {
                            i7 = 0;
                        }
                        int i30 = i7 | (jVar.k[i3] ? 1 : 0);
                        i8 = jVar.a.a;
                        if (z5) {
                            iVar = jVar.n;
                            if (iVar != null) {
                                bArr2 = iVar.f1106b;
                            } else {
                                bArr2 = hVar.h[i8].f1106b;
                            }
                            bArr = bArr2;
                        } else {
                            bArr = null;
                        }
                        rVar = this.g;
                        if (rVar != null) {
                            jA = rVar.a(jA);
                        }
                        nVar.a(jA, i30, this.v, 0, bArr);
                        while (!this.k.isEmpty()) {
                            a aVarRemoveFirst = this.k.removeFirst();
                            int i31 = this.r;
                            int i32 = aVarRemoveFirst.f1100b;
                            int i33 = i31 - i32;
                            this.r = i33;
                            this.A.a(jA + aVarRemoveFirst.a, 1, i32, i33, null);
                        }
                        bVar2 = this.u;
                        bVar2.e++;
                        i9 = bVar2.f + 1;
                        bVar2.f = i9;
                        iArr = jVar.g;
                        i10 = bVar2.g;
                        if (i9 == iArr[i10]) {
                            bVar2.g = i10 + 1;
                            bVar2.f = 0;
                            this.u = null;
                        }
                        this.l = 3;
                    } else {
                        b bVar10 = this.u;
                        jVar = bVar10.a;
                        hVar = bVar10.c;
                        nVar = bVar10.f1101b;
                        i3 = bVar10.e;
                        i4 = hVar.k;
                        if (i4 != 0) {
                            while (true) {
                                i5 = this.w;
                                i6 = this.v;
                                if (i5 < i6) {
                                    break;
                                }
                                this.w += nVar.a(gVar, i6 - i5, false);
                            }
                        } else {
                            bArr3 = this.d.a;
                            bArr3[0] = 0;
                            bArr3[1] = 0;
                            bArr3[2] = 0;
                            i11 = i4 + 1;
                            i12 = 4 - i4;
                            while (this.w < this.v) {
                                i13 = this.x;
                                if (i13 == 0) {
                                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr3, i12, i11, false);
                                    this.d.e(0);
                                    this.x = this.d.o() - 1;
                                    this.c.e(0);
                                    nVar.a(this.c, 4);
                                    nVar.a(this.d, 1);
                                    if (this.B != null) {
                                        str = hVar.f.f;
                                        i14 = bArr3[4];
                                        byte[] bArr5 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a;
                                        if (((!"video/avc".equals(str) && (i14 & 31) == i21) || ("video/hevc".equals(str) && ((i14 & 126) >> 1) == 39)) == true) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                    } else {
                                        z6 = false;
                                    }
                                    this.y = z6;
                                    this.w += 5;
                                    this.v += i12;
                                } else {
                                    if (this.y) {
                                        this.e.c(i13);
                                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.e.a, 0, this.x, false);
                                        nVar.a(this.e, this.x);
                                        iA = this.x;
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar8 = this.e;
                                        int iA4 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(kVar8.a, kVar8.c);
                                        this.e.e("video/hevc".equals(hVar.f.f) ? 1 : 0);
                                        this.e.d(iA4);
                                        com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a((jVar.j[i3] + ((long) jVar.i[i3])) * 1000, this.e, this.B);
                                    } else {
                                        iA = nVar.a(gVar, i13, false);
                                    }
                                    this.w += iA;
                                    this.x -= iA;
                                    i21 = 6;
                                }
                            }
                        }
                        jA = (jVar.j[i3] + ((long) jVar.i[i3])) * 1000;
                        z5 = jVar.l;
                        if (z5) {
                            i7 = 1073741824;
                        } else {
                            i7 = 0;
                        }
                        int i34 = i7 | (jVar.k[i3] ? 1 : 0);
                        i8 = jVar.a.a;
                        if (z5) {
                            iVar = jVar.n;
                            if (iVar != null) {
                                bArr2 = iVar.f1106b;
                            } else {
                                bArr2 = hVar.h[i8].f1106b;
                            }
                            bArr = bArr2;
                        } else {
                            bArr = null;
                        }
                        rVar = this.g;
                        if (rVar != null) {
                            jA = rVar.a(jA);
                        }
                        nVar.a(jA, i34, this.v, 0, bArr);
                        while (!this.k.isEmpty()) {
                            a aVarRemoveFirst2 = this.k.removeFirst();
                            int i35 = this.r;
                            int i36 = aVarRemoveFirst2.f1100b;
                            int i37 = i35 - i36;
                            this.r = i37;
                            this.A.a(jA + aVarRemoveFirst2.a, 1, i36, i37, null);
                        }
                        bVar2 = this.u;
                        bVar2.e++;
                        i9 = bVar2.f + 1;
                        bVar2.f = i9;
                        iArr = jVar.g;
                        i10 = bVar2.g;
                        if (i9 == iArr[i10]) {
                            bVar2.g = i10 + 1;
                            bVar2.f = 0;
                            this.u = null;
                        }
                        this.l = 3;
                    }
                    if (z7) {
                        return 0;
                    }
                } else {
                    int size3 = this.f1099b.size();
                    b bVarValueAt2 = null;
                    for (int i38 = 0; i38 < size3; i38++) {
                        j jVar6 = this.f1099b.valueAt(i38).a;
                        if (jVar6.q) {
                            long j12 = jVar6.c;
                            if (j12 < j10) {
                                bVarValueAt2 = this.f1099b.valueAt(i38);
                                j10 = j12;
                            }
                        }
                    }
                    if (bVarValueAt2 == null) {
                        this.l = 3;
                    } else {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar11 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                        int i39 = (int) (j10 - bVar11.c);
                        if (i39 >= 0) {
                            bVar11.c(i39);
                            j jVar7 = bVarValueAt2.a;
                            bVar11.b(jVar7.p.a, 0, jVar7.o, false);
                            jVar7.p.e(0);
                            jVar7.q = false;
                        } else {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Offset to encryption data was negative.");
                        }
                    }
                }
            }
        }
    }

    public final void a() {
        this.l = 0;
        this.o = 0;
    }

    /* JADX WARN: Code duplicated, block: B:259:0x05f9  */
    public final void a(long j) throws com.fyber.inneractive.sdk.player.exoplayer2.l {
        h hVarA;
        d dVar;
        int i;
        byte[] bArr;
        int i2;
        j jVar;
        byte[] bArr2;
        int i3;
        int i4;
        b bVar;
        int iO;
        int iC;
        loop0: while (true) {
            d dVar2 = this;
            while (true) {
                if (dVar2.j.isEmpty() || dVar2.j.peek().P0 != j) {
                    break loop0;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290aPop = dVar2.j.pop();
                int i5 = c0290aPop.a;
                int i6 = 12;
                int i7 = 8;
                int i8 = 1;
                if (i5 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C) {
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVarA = a(c0290aPop.Q0);
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290aC = c0290aPop.c(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.N);
                    SparseArray sparseArray = new SparseArray();
                    int size = c0290aC.Q0.size();
                    long jM = -9223372036854775807L;
                    int i9 = 0;
                    while (i9 < size) {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVar2 = c0290aC.Q0.get(i9);
                        int i10 = bVar2.a;
                        if (i10 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.z) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = bVar2.P0;
                            kVar.e(i6);
                            Pair pairCreate = Pair.create(Integer.valueOf(kVar.c()), new c(kVar.o() - 1, kVar.o(), kVar.o(), kVar.c()));
                            sparseArray.put(((Integer) pairCreate.first).intValue(), pairCreate.second);
                        } else if (i10 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.O) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar2 = bVar2.P0;
                            kVar2.e(8);
                            jM = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar2.c()) == 0 ? kVar2.m() : kVar2.p();
                        }
                        i9++;
                        i6 = 12;
                    }
                    SparseArray sparseArray2 = new SparseArray();
                    int size2 = c0290aPop.R0.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290a = c0290aPop.R0.get(i11);
                        if (c0290a.a == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.E && (hVarA = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a(c0290a, c0290aPop.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.D), jM, aVarA, false)) != null) {
                            sparseArray2.put(hVarA.a, hVarA);
                        }
                    }
                    int size3 = sparseArray2.size();
                    if (dVar2.f1099b.size() == 0) {
                        for (int i12 = 0; i12 < size3; i12++) {
                            h hVar = (h) sparseArray2.valueAt(i12);
                            b bVar3 = new b(dVar2.z.a(i12, hVar.f1105b));
                            bVar3.a(hVar, (c) sparseArray.get(hVar.a));
                            dVar2.f1099b.put(hVar.a, bVar3);
                            dVar2.s = Math.max(dVar2.s, hVar.e);
                        }
                        c();
                        dVar2.z.c();
                    } else {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(dVar2.f1099b.size() == size3);
                        for (int i13 = 0; i13 < size3; i13++) {
                            h hVar2 = (h) sparseArray2.valueAt(i13);
                            dVar2.f1099b.get(hVar2.a).a(hVar2, (c) sparseArray.get(hVar2.a));
                        }
                    }
                } else {
                    if (i5 == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.L) {
                        SparseArray<b> sparseArray3 = dVar2.f1099b;
                        int i14 = dVar2.a;
                        byte[] bArr3 = dVar2.i;
                        int size4 = c0290aPop.R0.size();
                        int i15 = 0;
                        while (i15 < size4) {
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0290a c0290a2 = c0290aPop.R0.get(i15);
                            if (c0290a2.a == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.M) {
                                com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar3 = c0290a2.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.y).P0;
                                kVar3.e(i7);
                                int iC2 = kVar3.c();
                                int i16 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f1093b;
                                int i17 = iC2 & ViewCompat.MEASURED_SIZE_MASK;
                                int iC3 = kVar3.c();
                                if ((i14 & 16) != 0) {
                                    iC3 = 0;
                                }
                                b bVar4 = sparseArray3.get(iC3);
                                if (bVar4 == null) {
                                    bVar4 = null;
                                } else {
                                    if ((i17 & 1) != 0) {
                                        long jP = kVar3.p();
                                        j jVar2 = bVar4.a;
                                        jVar2.f1107b = jP;
                                        jVar2.c = jP;
                                    }
                                    c cVar = bVar4.d;
                                    bVar4.a.a = new c((i17 & 2) != 0 ? kVar3.o() - i8 : cVar.a, (i17 & 8) != 0 ? kVar3.o() : cVar.f1098b, (i17 & 16) != 0 ? kVar3.o() : cVar.c, (i17 & 32) != 0 ? kVar3.o() : cVar.d);
                                }
                                if (bVar4 == null) {
                                    i = 1;
                                } else {
                                    j jVar3 = bVar4.a;
                                    long jP2 = jVar3.r;
                                    bVar4.a();
                                    int i18 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.x;
                                    if (c0290a2.d(i18) != null && (i14 & 2) == 0) {
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar4 = c0290a2.d(i18).P0;
                                        kVar4.e(i7);
                                        jP2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar4.c()) == 1 ? kVar4.p() : kVar4.m();
                                    }
                                    List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b> list = c0290a2.Q0;
                                    int size5 = list.size();
                                    sparseArray3 = sparseArray3;
                                    int i19 = 0;
                                    int i20 = 0;
                                    int i21 = 0;
                                    while (i21 < size5) {
                                        int i22 = size4;
                                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVar5 = list.get(i21);
                                        long j2 = jP2;
                                        if (bVar5.a == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.A) {
                                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar5 = bVar5.P0;
                                            kVar5.e(12);
                                            int iO2 = kVar5.o();
                                            if (iO2 > 0) {
                                                i19 += iO2;
                                                i20++;
                                            }
                                        }
                                        i21++;
                                        size4 = i22;
                                        jP2 = j2;
                                    }
                                    size4 = size4;
                                    long j3 = jP2;
                                    bVar4.g = 0;
                                    bVar4.f = 0;
                                    bVar4.e = 0;
                                    j jVar4 = bVar4.a;
                                    jVar4.d = i20;
                                    jVar4.e = i19;
                                    int[] iArr = jVar4.g;
                                    if (iArr == null || iArr.length < i20) {
                                        jVar4.f = new long[i20];
                                        jVar4.g = new int[i20];
                                    }
                                    int[] iArr2 = jVar4.h;
                                    if (iArr2 == null || iArr2.length < i19) {
                                        int i23 = (i19 * 125) / 100;
                                        jVar4.h = new int[i23];
                                        jVar4.i = new int[i23];
                                        jVar4.j = new long[i23];
                                        jVar4.k = new boolean[i23];
                                        jVar4.m = new boolean[i23];
                                    }
                                    int i24 = 0;
                                    int i25 = 0;
                                    int i26 = 0;
                                    while (true) {
                                        long jA = 0;
                                        if (i24 >= size5) {
                                            break;
                                        }
                                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVar6 = list.get(i24);
                                        if (bVar6.a == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.A) {
                                            int i27 = i25 + 1;
                                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar6 = bVar6.P0;
                                            kVar6.e(8);
                                            int iC4 = kVar6.c();
                                            int i28 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f1093b;
                                            int i29 = iC4 & ViewCompat.MEASURED_SIZE_MASK;
                                            h hVar3 = bVar4.c;
                                            j jVar5 = bVar4.a;
                                            c cVar2 = jVar5.a;
                                            jVar5.g[i25] = kVar6.o();
                                            long[] jArr = jVar5.f;
                                            jArr[i25] = jVar5.f1107b;
                                            if ((i29 & 1) != 0) {
                                                jArr[i25] = jArr[i25] + ((long) kVar6.c());
                                            }
                                            boolean z = (i29 & 4) != 0;
                                            int iO3 = cVar2.d;
                                            if (z) {
                                                iO3 = kVar6.o();
                                            }
                                            boolean z2 = (i29 & 256) != 0;
                                            boolean z3 = (i29 & 512) != 0;
                                            boolean z4 = (i29 & 1024) != 0;
                                            int i30 = iO3;
                                            boolean z5 = (i29 & 2048) != 0;
                                            long[] jArr2 = hVar3.i;
                                            if (jArr2 != null) {
                                                bVar = bVar4;
                                                if (jArr2.length == 1 && jArr2[0] == 0) {
                                                    jA = u.a(hVar3.j[0], 1000L, hVar3.c);
                                                }
                                            } else {
                                                bVar = bVar4;
                                            }
                                            int[] iArr3 = jVar5.h;
                                            int[] iArr4 = jVar5.i;
                                            long[] jArr3 = jVar5.j;
                                            boolean[] zArr = jVar5.k;
                                            boolean z6 = hVar3.f1105b == 2 && (i14 & 1) != 0;
                                            int i31 = jVar5.g[i25] + i26;
                                            boolean z7 = z4;
                                            long j4 = hVar3.c;
                                            long j5 = i25 > 0 ? jVar5.r : j3;
                                            while (i26 < i31) {
                                                if (z2) {
                                                    iO = kVar6.o();
                                                } else {
                                                    iO = cVar2.f1098b;
                                                }
                                                int iO4 = z3 ? kVar6.o() : cVar2.c;
                                                if (i26 == 0 && z) {
                                                    iC = i30;
                                                } else {
                                                    iC = z7 ? kVar6.c() : cVar2.d;
                                                }
                                                if (z5) {
                                                    iArr4[i26] = (int) (((long) (kVar6.c() * 1000)) / j4);
                                                } else {
                                                    iArr4[i26] = 0;
                                                }
                                                jArr3[i26] = u.a(j5, 1000L, j4) - jA;
                                                iArr3[i26] = iO4;
                                                zArr[i26] = ((iC >> 16) & 1) == 0 && (!z6 || i26 == 0);
                                                j5 += (long) iO;
                                                i26++;
                                                z2 = z2;
                                                z3 = z3;
                                                z = z;
                                                i31 = i31;
                                                cVar2 = cVar2;
                                                z5 = z5;
                                            }
                                            jVar5.r = j5;
                                            i25 = i27;
                                            i26 = i31;
                                        } else {
                                            c0290aPop = c0290aPop;
                                            i24 = i24;
                                            bVar = bVar4;
                                        }
                                        i24++;
                                        list = list;
                                        size5 = size5;
                                        i15 = i15;
                                        jVar3 = jVar3;
                                        c0290aPop = c0290aPop;
                                        bArr3 = bArr3;
                                        bVar4 = bVar;
                                        c0290a2 = c0290a2;
                                        i14 = i14;
                                    }
                                    c0290aPop = c0290aPop;
                                    i14 = i14;
                                    byte[] bArr4 = bArr3;
                                    j jVar6 = jVar3;
                                    i15 = i15;
                                    b bVar7 = bVar4;
                                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD = c0290a2.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.d0);
                                    if (bVarD != null) {
                                        jVar = jVar6;
                                        i iVar = bVar7.c.h[jVar.a.a];
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar7 = bVarD.P0;
                                        int i32 = iVar.a;
                                        kVar7.e(8);
                                        int iC5 = kVar7.c();
                                        int i33 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f1093b;
                                        if ((iC5 & ViewCompat.MEASURED_SIZE_MASK & 1) == 1) {
                                            kVar7.f(8);
                                        }
                                        int iL = kVar7.l();
                                        int iO5 = kVar7.o();
                                        if (iO5 == jVar.e) {
                                            if (iL == 0) {
                                                boolean[] zArr2 = jVar.m;
                                                i4 = 0;
                                                for (int i34 = 0; i34 < iO5; i34++) {
                                                    int iL2 = kVar7.l();
                                                    i4 += iL2;
                                                    zArr2[i34] = iL2 > i32;
                                                }
                                            } else {
                                                i4 = (iL * iO5) + 0;
                                                Arrays.fill(jVar.m, 0, iO5, iL > i32);
                                            }
                                            jVar.a(i4);
                                        } else {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Length mismatch: " + iO5 + ", " + jVar.e);
                                        }
                                    } else {
                                        jVar = jVar6;
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD2 = c0290a2.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.e0);
                                    if (bVarD2 != null) {
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar8 = bVarD2.P0;
                                        kVar8.e(8);
                                        int iC6 = kVar8.c();
                                        int i35 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f1093b;
                                        if ((iC6 & ViewCompat.MEASURED_SIZE_MASK & 1) == 1) {
                                            kVar8.f(8);
                                        }
                                        int iO6 = kVar8.o();
                                        if (iO6 != 1) {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Unexpected saio entry count: " + iO6);
                                        }
                                        jVar.c += com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(iC6) == 0 ? kVar8.m() : kVar8.p();
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD3 = c0290a2.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.i0);
                                    if (bVarD3 != null) {
                                        a(bVarD3.P0, 0, jVar);
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD4 = c0290a2.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f0);
                                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVarD5 = c0290a2.d(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.g0);
                                    if (bVarD4 == null || bVarD5 == null) {
                                        i = 1;
                                    } else {
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar9 = bVarD4.P0;
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar10 = bVarD5.P0;
                                        kVar9.e(8);
                                        int iC7 = kVar9.c();
                                        int iC8 = kVar9.c();
                                        int i36 = D;
                                        if (iC8 == i36) {
                                            if (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(iC7) == 1) {
                                                kVar9.f(4);
                                            }
                                            if (kVar9.c() == 1) {
                                                kVar10.e(8);
                                                int iC9 = kVar10.c();
                                                if (kVar10.c() != i36) {
                                                    i = 1;
                                                } else {
                                                    int iB = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(iC9);
                                                    if (iB != 1) {
                                                        i3 = 2;
                                                        if (iB >= 2) {
                                                            kVar10.f(4);
                                                        }
                                                    } else {
                                                        if (kVar10.m() == 0) {
                                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Variable length decription in sgpd found (unsupported)");
                                                        }
                                                        i3 = 2;
                                                    }
                                                    if (kVar10.m() == 1) {
                                                        kVar10.f(i3);
                                                        boolean z8 = kVar10.l() == 1;
                                                        if (z8) {
                                                            int iL3 = kVar10.l();
                                                            byte[] bArr5 = new byte[16];
                                                            System.arraycopy(kVar10.a, kVar10.f1236b, bArr5, 0, 16);
                                                            kVar10.f1236b += 16;
                                                            i = 1;
                                                            jVar.l = true;
                                                            jVar.n = new i(z8, iL3, bArr5);
                                                        } else {
                                                            i = 1;
                                                        }
                                                    } else {
                                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Entry count in sgpd != 1 (unsupported).");
                                                    }
                                                }
                                            } else {
                                                throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Entry count in sbgp != 1 (unsupported).");
                                            }
                                        } else {
                                            i = 1;
                                        }
                                    }
                                    int size6 = c0290a2.Q0.size();
                                    int i37 = 0;
                                    while (i37 < size6) {
                                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVar8 = c0290a2.Q0.get(i37);
                                        if (bVar8.a == com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.h0) {
                                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar11 = bVar8.P0;
                                            kVar11.e(8);
                                            bArr2 = bArr4;
                                            System.arraycopy(kVar11.a, kVar11.f1236b, bArr2, 0, 16);
                                            kVar11.f1236b += 16;
                                            if (Arrays.equals(bArr2, E)) {
                                                a(kVar11, 16, jVar);
                                            }
                                        } else {
                                            bArr2 = bArr4;
                                        }
                                        i37++;
                                        bArr4 = bArr2;
                                    }
                                    bArr = bArr4;
                                    i2 = 8;
                                }
                                i8 = i;
                                i7 = i2;
                                bArr3 = bArr;
                                sparseArray3 = sparseArray3;
                                size4 = size4;
                                c0290aPop = c0290aPop;
                                i14 = i14;
                                i15++;
                            } else {
                                i = i8;
                            }
                            bArr = bArr3;
                            i2 = i7;
                            i8 = i;
                            i7 = i2;
                            bArr3 = bArr;
                            sparseArray3 = sparseArray3;
                            size4 = size4;
                            c0290aPop = c0290aPop;
                            i14 = i14;
                            i15++;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVarA2 = a(c0290aPop.Q0);
                        if (aVarA2 != null) {
                            dVar = this;
                            int size7 = dVar.f1099b.size();
                            for (int i38 = 0; i38 < size7; i38++) {
                                b bVarValueAt = dVar.f1099b.valueAt(i38);
                                n nVar = bVarValueAt.f1101b;
                                com.fyber.inneractive.sdk.player.exoplayer2.i iVar2 = bVarValueAt.c.f;
                                nVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.i(iVar2.a, iVar2.e, iVar2.f, iVar2.c, iVar2.f1156b, iVar2.g, iVar2.j, iVar2.k, iVar2.l, iVar2.m, iVar2.n, iVar2.p, iVar2.o, iVar2.q, iVar2.r, iVar2.s, iVar2.t, iVar2.u, iVar2.v, iVar2.x, iVar2.y, iVar2.z, iVar2.w, iVar2.h, aVarA2, iVar2.d));
                            }
                        }
                    } else {
                        dVar = dVar2;
                        if (!dVar.j.isEmpty()) {
                            dVar.j.peek().R0.add(c0290aPop);
                        }
                    }
                    dVar2 = dVar;
                }
            }
        }
        a();
    }

    public static void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i, j jVar) throws com.fyber.inneractive.sdk.player.exoplayer2.l {
        kVar.e(i + 8);
        int iC = kVar.c();
        int i2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f1093b;
        int i3 = iC & ViewCompat.MEASURED_SIZE_MASK;
        if ((i3 & 1) == 0) {
            boolean z = (i3 & 2) != 0;
            int iO = kVar.o();
            if (iO == jVar.e) {
                Arrays.fill(jVar.m, 0, iO, z);
                jVar.a(kVar.a());
                kVar.a(jVar.p.a, 0, jVar.o);
                jVar.p.e(0);
                jVar.q = false;
                return;
            }
            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Length mismatch: " + iO + ", " + jVar.e);
        }
        throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    public static com.fyber.inneractive.sdk.player.exoplayer2.drm.a a(List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b> list) {
        Pair pairCreate;
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b bVar = list.get(i);
            int i2 = bVar.a;
            int i3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.V;
            if (i2 == i3) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.P0.a;
                com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(bArr);
                if (kVar.c < 32) {
                    pairCreate = null;
                } else {
                    kVar.e(0);
                    if (kVar.c() == kVar.a() + 4 && kVar.c() == i3) {
                        int iB = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(kVar.c());
                        if (iB > 1) {
                            Log.w("PsshAtomUtil", "Unsupported pssh version: " + iB);
                        } else {
                            UUID uuid = new UUID(kVar.i(), kVar.i());
                            if (iB == 1) {
                                kVar.f(kVar.o() * 16);
                            }
                            int iO = kVar.o();
                            if (iO == kVar.a()) {
                                byte[] bArr2 = new byte[iO];
                                System.arraycopy(kVar.a, kVar.f1236b, bArr2, 0, iO);
                                kVar.f1236b += iO;
                                pairCreate = Pair.create(uuid, bArr2);
                            }
                        }
                        pairCreate = null;
                    } else {
                        pairCreate = null;
                    }
                }
                UUID uuid2 = pairCreate == null ? null : (UUID) pairCreate.first;
                if (uuid2 == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b(uuid2, "video/mp4", bArr, false));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.drm.a(false, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b[]) arrayList.toArray(new com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b[arrayList.size()]));
    }
}
