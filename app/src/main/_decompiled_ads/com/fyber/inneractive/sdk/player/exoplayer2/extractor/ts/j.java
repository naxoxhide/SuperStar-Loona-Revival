package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements h {
    public final s a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1127b;
    public final boolean c;
    public long g;
    public String i;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n j;
    public b k;
    public boolean l;
    public long m;
    public final boolean[] h = new boolean[3];
    public final n d = new n(7, 128);
    public final n e = new n(8, 128);
    public final n f = new n(6, 128);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k n = new com.fyber.inneractive.sdk.player.exoplayer2.util.k();

    public static final class b {
        public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.n a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1128b;
        public final boolean c;
        public final SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.i.b> d = new SparseArray<>();
        public final SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.i.a> e = new SparseArray<>();
        public final com.fyber.inneractive.sdk.player.exoplayer2.util.l f;
        public byte[] g;
        public int h;
        public int i;
        public long j;
        public boolean k;
        public long l;
        public a m;
        public a n;
        public boolean o;
        public long p;
        public long q;
        public boolean r;

        public static final class a {
            public boolean a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f1129b;
            public com.fyber.inneractive.sdk.player.exoplayer2.util.i.b c;
            public int d;
            public int e;
            public int f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public a() {
            }

            public static boolean a(a aVar, a aVar2) {
                boolean z;
                boolean z2;
                if (aVar.a) {
                    if (!aVar2.a || aVar.f != aVar2.f || aVar.g != aVar2.g || aVar.h != aVar2.h) {
                        return true;
                    }
                    if (aVar.i && aVar2.i && aVar.j != aVar2.j) {
                        return true;
                    }
                    int i = aVar.d;
                    int i2 = aVar2.d;
                    if (i != i2 && (i == 0 || i2 == 0)) {
                        return true;
                    }
                    int i3 = aVar.c.h;
                    if (i3 == 0 && aVar2.c.h == 0 && (aVar.m != aVar2.m || aVar.n != aVar2.n)) {
                        return true;
                    }
                    if ((i3 == 1 && aVar2.c.h == 1 && (aVar.o != aVar2.o || aVar.p != aVar2.p)) || (z = aVar.k) != (z2 = aVar2.k)) {
                        return true;
                    }
                    if (z && z2 && aVar.l != aVar2.l) {
                        return true;
                    }
                }
                return false;
            }
        }

        public b(com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar, boolean z, boolean z2) {
            this.a = nVar;
            this.f1128b = z;
            this.c = z2;
            this.m = new a();
            this.n = new a();
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new com.fyber.inneractive.sdk.player.exoplayer2.util.l(bArr, 0, 0);
            a();
        }

        public void a() {
            this.k = false;
            this.o = false;
            a aVar = this.n;
            aVar.f1129b = false;
            aVar.a = false;
        }
    }

    public j(s sVar, boolean z, boolean z2) {
        this.a = sVar;
        this.f1127b = z;
        this.c = z2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(this.h);
        this.d.a();
        this.e.a();
        this.f.a();
        b bVar = this.k;
        bVar.k = false;
        bVar.o = false;
        b.a aVar = bVar.n;
        aVar.f1129b = false;
        aVar.a = false;
        this.g = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        dVar.a();
        this.i = dVar.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVarA = hVar.a(dVar.c(), 2);
        this.j = nVarA;
        this.k = new b(nVarA, this.f1127b, this.c);
        this.a.a(hVar, dVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(long j, boolean z) {
        this.m = j;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    /* JADX WARN: Code duplicated, block: B:63:0x01be  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f8  */
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
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        int i;
        byte[] bArr;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6 = kVar.f1236b;
        int i7 = kVar.c;
        byte[] bArr2 = kVar.a;
        this.g += (long) kVar.a();
        this.j.a(kVar, kVar.a());
        while (true) {
            int iA = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(bArr2, i6, i7, this.h);
            if (iA == i7) {
                a(bArr2, i6, i7);
                return;
            }
            int i8 = iA + 3;
            int i9 = bArr2[i8] & 31;
            int i10 = iA - i6;
            if (i10 > 0) {
                a(bArr2, i6, iA);
            }
            int i11 = i7 - iA;
            long j = this.g - ((long) i11);
            int i12 = i10 < 0 ? -i10 : 0;
            long j2 = this.m;
            if (!this.l || this.k.c) {
                this.d.a(i12);
                this.e.a(i12);
                if (!this.l) {
                    if (this.d.c && this.e.c) {
                        ArrayList arrayList = new ArrayList();
                        n nVar = this.d;
                        arrayList.add(Arrays.copyOf(nVar.d, nVar.e));
                        n nVar2 = this.e;
                        arrayList.add(Arrays.copyOf(nVar2.d, nVar2.e));
                        n nVar3 = this.d;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.i.b bVarB = com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(nVar3.d, 3, nVar3.e);
                        n nVar4 = this.e;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.i.a aVarA = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar4.d, 3, nVar4.e);
                        i = i7;
                        bArr = bArr2;
                        i2 = i8;
                        this.j.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a(this.i, "video/avc", (String) null, -1, -1, bVarB.f1234b, bVarB.c, -1.0f, arrayList, -1, bVarB.d, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null));
                        this.l = true;
                        this.k.d.append(bVarB.a, bVarB);
                        this.k.e.append(aVarA.a, aVarA);
                        this.d.a();
                        this.e.a();
                    } else {
                        i = i7;
                        bArr = bArr2;
                        i2 = i8;
                    }
                } else {
                    i = i7;
                    bArr = bArr2;
                    i2 = i8;
                    n nVar5 = this.d;
                    if (nVar5.c) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.i.b bVarB2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(nVar5.d, 3, nVar5.e);
                        this.k.d.append(bVarB2.a, bVarB2);
                        this.d.a();
                    } else {
                        n nVar6 = this.e;
                        if (nVar6.c) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.i.a aVarA2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar6.d, 3, nVar6.e);
                            this.k.e.append(aVarA2.a, aVarA2);
                            this.e.a();
                        }
                    }
                }
            } else {
                i = i7;
                bArr = bArr2;
                i2 = i8;
            }
            if (this.f.a(i12)) {
                n nVar7 = this.f;
                this.n.a(this.f.d, com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar7.d, nVar7.e));
                this.n.e(4);
                com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j2, this.n, this.a.f1139b);
            }
            b bVar = this.k;
            if (bVar.i == 9 || (bVar.c && b.a.a(bVar.n, bVar.m))) {
                if (bVar.o) {
                    long j3 = bVar.j;
                    bVar.a.a(bVar.q, bVar.r ? 1 : 0, (int) (j3 - bVar.p), i11 + ((int) (j - j3)), null);
                }
                bVar.p = bVar.j;
                bVar.q = bVar.l;
                bVar.r = false;
                i3 = 1;
                bVar.o = true;
            } else {
                i3 = 1;
            }
            boolean z2 = bVar.r;
            int i13 = bVar.i;
            if (i13 != 5) {
                if (bVar.f1128b && i13 == i3) {
                    b.a aVar = bVar.n;
                    z = aVar.f1129b && ((i5 = aVar.e) == 7 || i5 == 2);
                }
            }
            bVar.r = z | z2;
            long j4 = this.m;
            if (!this.l || this.k.c) {
                this.d.b(i9);
                this.e.b(i9);
            }
            this.f.b(i9);
            b bVar2 = this.k;
            bVar2.i = i9;
            bVar2.l = j4;
            bVar2.j = j;
            if (bVar2.f1128b) {
                i4 = 1;
                if (i9 == 1) {
                    b.a aVar2 = bVar2.m;
                    bVar2.m = bVar2.n;
                    bVar2.n = aVar2;
                    aVar2.f1129b = false;
                    aVar2.a = false;
                    bVar2.h = 0;
                    bVar2.k = true;
                }
                i7 = i;
                bArr2 = bArr;
                i6 = i2;
            } else {
                i4 = 1;
            }
            if (bVar2.c && (i9 == 5 || i9 == i4 || i9 == 2)) {
                b.a aVar3 = bVar2.m;
                bVar2.m = bVar2.n;
                bVar2.n = aVar3;
                aVar3.f1129b = false;
                aVar3.a = false;
                bVar2.h = 0;
                bVar2.k = true;
            }
            i7 = i;
            bArr2 = bArr;
            i6 = i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0127  */
    /* JADX WARN: Code duplicated, block: B:57:0x0129  */
    /* JADX WARN: Code duplicated, block: B:59:0x012c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0136  */
    /* JADX WARN: Code duplicated, block: B:63:0x013d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0142  */
    /* JADX WARN: Code duplicated, block: B:69:0x014e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0170  */
    public final void a(byte[] bArr, int i, int i2) {
        boolean zC;
        boolean zC2;
        boolean z;
        boolean z2;
        int iD;
        int i3;
        int iB;
        int i4;
        int iE;
        int iE2;
        if (!this.l || this.k.c) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        b bVar = this.k;
        if (bVar.k) {
            int i5 = i2 - i;
            byte[] bArr2 = bVar.g;
            int length = bArr2.length;
            int i6 = bVar.h + i5;
            if (length < i6) {
                bVar.g = Arrays.copyOf(bArr2, i6 * 2);
            }
            System.arraycopy(bArr, i, bVar.g, bVar.h, i5);
            int i7 = bVar.h + i5;
            bVar.h = i7;
            com.fyber.inneractive.sdk.player.exoplayer2.util.l lVar = bVar.f;
            lVar.a = bVar.g;
            lVar.c = 0;
            lVar.f1237b = i7;
            lVar.d = 0;
            lVar.a();
            if (bVar.f.a(8)) {
                bVar.f.f();
                int iB2 = bVar.f.b(2);
                bVar.f.d(5);
                if (bVar.f.b()) {
                    bVar.f.d();
                    if (bVar.f.b()) {
                        int iD2 = bVar.f.d();
                        if (!bVar.c) {
                            bVar.k = false;
                            b.a aVar = bVar.n;
                            aVar.e = iD2;
                            aVar.f1129b = true;
                            return;
                        }
                        if (bVar.f.b()) {
                            int iD3 = bVar.f.d();
                            if (bVar.e.indexOfKey(iD3) < 0) {
                                bVar.k = false;
                                return;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.i.a aVar2 = bVar.e.get(iD3);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.i.b bVar2 = bVar.d.get(aVar2.f1233b);
                            if (bVar2.e) {
                                if (!bVar.f.a(2)) {
                                    return;
                                } else {
                                    bVar.f.d(2);
                                }
                            }
                            if (bVar.f.a(bVar2.g)) {
                                int iB3 = bVar.f.b(bVar2.g);
                                if (!bVar2.f) {
                                    if (bVar.f.a(1)) {
                                        zC = bVar.f.c();
                                        if (!zC) {
                                            zC2 = false;
                                        } else {
                                            if (!bVar.f.a(1)) {
                                                return;
                                            }
                                            zC2 = bVar.f.c();
                                            z = true;
                                        }
                                        if (bVar.i == 5) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            iD = 0;
                                        } else if (!bVar.f.b()) {
                                            return;
                                        } else {
                                            iD = bVar.f.d();
                                        }
                                        i3 = bVar2.h;
                                        if (i3 != 0) {
                                            if (!bVar.f.a(bVar2.i)) {
                                                return;
                                            }
                                            iB = bVar.f.b(bVar2.i);
                                            if (aVar2.c || zC) {
                                                iE = 0;
                                                i4 = 0;
                                                iE2 = 0;
                                            } else {
                                                if (!bVar.f.b()) {
                                                    return;
                                                }
                                                iE2 = bVar.f.e();
                                                iE = 0;
                                                i4 = 0;
                                            }
                                        } else if (i3 == 1 || bVar2.j) {
                                            iB = 0;
                                            iE = 0;
                                            i4 = 0;
                                            iE2 = 0;
                                        } else {
                                            if (!bVar.f.b()) {
                                                return;
                                            }
                                            int iE3 = bVar.f.e();
                                            if (!aVar2.c || zC) {
                                                i4 = iE3;
                                                iB = 0;
                                                iE = 0;
                                                iE2 = 0;
                                            } else {
                                                if (!bVar.f.b()) {
                                                    return;
                                                }
                                                iE = bVar.f.e();
                                                iE2 = 0;
                                                i4 = iE3;
                                                iB = 0;
                                            }
                                        }
                                        b.a aVar3 = bVar.n;
                                        aVar3.c = bVar2;
                                        aVar3.d = iB2;
                                        aVar3.e = iD2;
                                        aVar3.f = iB3;
                                        aVar3.g = iD3;
                                        aVar3.h = zC;
                                        aVar3.i = z;
                                        aVar3.j = zC2;
                                        aVar3.k = z2;
                                        aVar3.l = iD;
                                        aVar3.m = iB;
                                        aVar3.n = iE2;
                                        aVar3.o = i4;
                                        aVar3.p = iE;
                                        aVar3.a = true;
                                        aVar3.f1129b = true;
                                        bVar.k = false;
                                    }
                                    return;
                                }
                                zC = false;
                                zC2 = false;
                                z = zC2;
                                if (bVar.i == 5) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    iD = 0;
                                } else if (!bVar.f.b()) {
                                    return;
                                } else {
                                    iD = bVar.f.d();
                                }
                                i3 = bVar2.h;
                                if (i3 != 0) {
                                    if (i3 == 1) {
                                    }
                                    iB = 0;
                                    iE = 0;
                                    i4 = 0;
                                    iE2 = 0;
                                } else {
                                    if (!bVar.f.a(bVar2.i)) {
                                        return;
                                    }
                                    iB = bVar.f.b(bVar2.i);
                                    if (aVar2.c) {
                                    }
                                    iE = 0;
                                    i4 = 0;
                                    iE2 = 0;
                                }
                                b.a aVar4 = bVar.n;
                                aVar4.c = bVar2;
                                aVar4.d = iB2;
                                aVar4.e = iD2;
                                aVar4.f = iB3;
                                aVar4.g = iD3;
                                aVar4.h = zC;
                                aVar4.i = z;
                                aVar4.j = zC2;
                                aVar4.k = z2;
                                aVar4.l = iD;
                                aVar4.m = iB;
                                aVar4.n = iE2;
                                aVar4.o = i4;
                                aVar4.p = iE;
                                aVar4.a = true;
                                aVar4.f1129b = true;
                                bVar.k = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
