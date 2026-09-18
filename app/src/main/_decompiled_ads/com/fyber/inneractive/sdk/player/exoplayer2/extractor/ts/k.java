package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements h {
    public final s a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1130b;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n c;
    public a d;
    public boolean e;
    public long l;
    public long m;
    public final boolean[] f = new boolean[3];
    public final n g = new n(32, 128);
    public final n h = new n(33, 128);
    public final n i = new n(34, 128);
    public final n j = new n(39, 128);
    public final n k = new n(40, 128);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k n = new com.fyber.inneractive.sdk.player.exoplayer2.util.k();

    public static final class a {
        public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.n a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f1131b;
        public boolean c;
        public int d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar) {
            this.a = nVar;
        }
    }

    public k(s sVar) {
        this.a = sVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(this.f);
        this.g.a();
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        a aVar = this.d;
        aVar.f = false;
        aVar.g = false;
        aVar.h = false;
        aVar.i = false;
        aVar.j = false;
        this.l = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        dVar.a();
        this.f1130b = dVar.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVarA = hVar.a(dVar.c(), 2);
        this.c = nVarA;
        this.d = new a(nVarA);
        this.a.a(hVar, dVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(long j, boolean z) {
        this.m = j;
    }

    /* JADX WARN: Code duplicated, block: B:149:0x031a  */
    /* JADX WARN: Code duplicated, block: B:152:0x0343  */
    /* JADX WARN: Code duplicated, block: B:155:0x036a  */
    /* JADX WARN: Code duplicated, block: B:157:0x037d  */
    /* JADX WARN: Code duplicated, block: B:159:0x0381  */
    /* JADX WARN: Code duplicated, block: B:162:0x039b  */
    /* JADX WARN: Code duplicated, block: B:165:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:166:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:169:0x03af  */
    /* JADX WARN: Code duplicated, block: B:172:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:175:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:179:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:181:0x03c5  */
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
        int i2;
        int i3;
        float f;
        long j;
        int i4;
        a aVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        a aVar2;
        while (kVar.a() > 0) {
            int i5 = kVar.c;
            byte[] bArr = kVar.a;
            this.l += (long) kVar.a();
            this.c.a(kVar, kVar.a());
            for (int i6 = kVar.f1236b; i6 < i5; i6 = i) {
                int iA = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(bArr, i6, i5, this.f);
                if (iA == i5) {
                    a(bArr, i6, i5);
                    return;
                }
                i = iA + 3;
                int i7 = (bArr[i] & 126) >> 1;
                int i8 = iA - i6;
                if (i8 > 0) {
                    a(bArr, i6, iA);
                }
                int i9 = i5 - iA;
                long j2 = this.l - ((long) i9);
                int i10 = i8 < 0 ? -i8 : 0;
                long j3 = this.m;
                if (this.e) {
                    a aVar3 = this.d;
                    if (aVar3.j && aVar3.g) {
                        aVar3.m = aVar3.c;
                        aVar3.j = false;
                    } else {
                        if (aVar3.h || aVar3.g) {
                            i2 = i5;
                            if (aVar3.i) {
                                long j4 = aVar3.f1131b;
                                aVar2 = aVar3;
                                aVar2.a.a(aVar2.l, aVar2.m ? 1 : 0, (int) (j4 - aVar2.k), i9 + ((int) (j2 - j4)), null);
                            } else {
                                aVar2 = aVar3;
                            }
                            aVar2.k = aVar2.f1131b;
                            aVar2.l = aVar2.e;
                            aVar2.i = true;
                            aVar2.m = aVar2.c;
                        }
                        i3 = 16;
                        if (this.j.a(i10)) {
                            n nVar = this.j;
                            this.n.a(this.j.d, com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar.d, nVar.e));
                            this.n.f(5);
                            com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.a.f1139b);
                        }
                        if (this.k.a(i10)) {
                            n nVar2 = this.k;
                            this.n.a(this.k.d, com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar2.d, nVar2.e));
                            this.n.f(5);
                            com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.a.f1139b);
                        }
                        j = this.m;
                        if (this.e) {
                            aVar = this.d;
                            aVar.g = false;
                            aVar.h = false;
                            aVar.e = j;
                            aVar.d = 0;
                            aVar.f1131b = j2;
                            i4 = i7;
                            if (i4 >= 32) {
                                if (aVar.j && aVar.i) {
                                    aVar.a.a(aVar.l, aVar.m ? 1 : 0, (int) (j2 - aVar.k), i9, null);
                                    z = false;
                                    aVar.i = false;
                                } else {
                                    z = false;
                                }
                                if (i4 <= 34) {
                                    z2 = true;
                                    aVar.h = !aVar.j;
                                    aVar.j = true;
                                }
                                if (i4 >= i3 || i4 > 21) {
                                    z3 = z;
                                } else {
                                    z3 = z2;
                                }
                                aVar.c = z3;
                                if (!z3 || i4 <= 9) {
                                    z4 = z2;
                                } else {
                                    z4 = z;
                                }
                                aVar.f = z4;
                            } else {
                                i3 = i3;
                                z = false;
                            }
                            z2 = true;
                            if (i4 >= i3) {
                                z3 = z;
                            } else {
                                z3 = z;
                            }
                            aVar.c = z3;
                            if (z3) {
                                z4 = z2;
                            } else {
                                z4 = z2;
                            }
                            aVar.f = z4;
                        } else {
                            i4 = i7;
                            this.g.b(i4);
                            this.h.b(i4);
                            this.i.b(i4);
                        }
                        this.j.b(i4);
                        this.k.b(i4);
                        i5 = i2;
                        bArr = bArr;
                    }
                    i2 = i5;
                    i9 = i9;
                    i3 = 16;
                    if (this.j.a(i10)) {
                        n nVar3 = this.j;
                        this.n.a(this.j.d, com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar3.d, nVar3.e));
                        this.n.f(5);
                        com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.a.f1139b);
                    }
                    if (this.k.a(i10)) {
                        n nVar4 = this.k;
                        this.n.a(this.k.d, com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar4.d, nVar4.e));
                        this.n.f(5);
                        com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.a.f1139b);
                    }
                    j = this.m;
                    if (this.e) {
                        aVar = this.d;
                        aVar.g = false;
                        aVar.h = false;
                        aVar.e = j;
                        aVar.d = 0;
                        aVar.f1131b = j2;
                        i4 = i7;
                        if (i4 >= 32) {
                            if (aVar.j) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (i4 <= 34) {
                                z2 = true;
                                aVar.h = !aVar.j;
                                aVar.j = true;
                            }
                            if (i4 >= i3) {
                                z3 = z;
                            } else {
                                z3 = z;
                            }
                            aVar.c = z3;
                            if (z3) {
                                z4 = z2;
                            } else {
                                z4 = z2;
                            }
                            aVar.f = z4;
                        } else {
                            i3 = i3;
                            z = false;
                        }
                        z2 = true;
                        if (i4 >= i3) {
                            z3 = z;
                        } else {
                            z3 = z;
                        }
                        aVar.c = z3;
                        if (z3) {
                            z4 = z2;
                        } else {
                            z4 = z2;
                        }
                        aVar.f = z4;
                    } else {
                        i4 = i7;
                        this.g.b(i4);
                        this.h.b(i4);
                        this.i.b(i4);
                    }
                    this.j.b(i4);
                    this.k.b(i4);
                    i5 = i2;
                    bArr = bArr;
                } else {
                    i2 = i5;
                    i9 = i9;
                    this.g.a(i10);
                    this.h.a(i10);
                    this.i.a(i10);
                    n nVar5 = this.g;
                    if (nVar5.c) {
                        n nVar6 = this.h;
                        if (nVar6.c) {
                            n nVar7 = this.i;
                            if (nVar7.c) {
                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar8 = this.c;
                                String str = this.f1130b;
                                int i11 = nVar5.e;
                                bArr = bArr;
                                byte[] bArr2 = new byte[nVar6.e + i11 + nVar7.e];
                                i = i;
                                System.arraycopy(nVar5.d, 0, bArr2, 0, i11);
                                i7 = i7;
                                System.arraycopy(nVar6.d, 0, bArr2, nVar5.e, nVar6.e);
                                System.arraycopy(nVar7.d, 0, bArr2, nVar5.e + nVar6.e, nVar7.e);
                                com.fyber.inneractive.sdk.player.exoplayer2.util.l lVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.l(nVar6.d, 0, nVar6.e);
                                lVar.d(44);
                                int i12 = 3;
                                int iB = lVar.b(3);
                                lVar.f();
                                lVar.d(88);
                                lVar.d(8);
                                int i13 = 0;
                                for (int i14 = 0; i14 < iB; i14++) {
                                    if (lVar.c()) {
                                        i13 += 89;
                                    }
                                    if (lVar.c()) {
                                        i13 += 8;
                                    }
                                }
                                lVar.d(i13);
                                int i15 = 2;
                                if (iB > 0) {
                                    lVar.d((8 - iB) * 2);
                                }
                                lVar.d();
                                int iD = lVar.d();
                                if (iD == 3) {
                                    lVar.f();
                                }
                                int iD2 = lVar.d();
                                int iD3 = lVar.d();
                                if (lVar.c()) {
                                    int iD4 = lVar.d();
                                    int iD5 = lVar.d();
                                    int iD6 = lVar.d();
                                    int iD7 = lVar.d();
                                    iD2 -= ((iD == 1 || iD == 2) ? 2 : 1) * (iD4 + iD5);
                                    iD3 -= (iD == 1 ? 2 : 1) * (iD6 + iD7);
                                }
                                int i16 = iD2;
                                int i17 = iD3;
                                lVar.d();
                                lVar.d();
                                int iD8 = lVar.d();
                                for (int i18 = lVar.c() ? 0 : iB; i18 <= iB; i18++) {
                                    lVar.d();
                                    lVar.d();
                                    lVar.d();
                                }
                                lVar.d();
                                lVar.d();
                                lVar.d();
                                lVar.d();
                                lVar.d();
                                lVar.d();
                                int i19 = 4;
                                if (lVar.c() && lVar.c()) {
                                    int i20 = 0;
                                    while (i20 < i19) {
                                        int i21 = 0;
                                        while (i21 < 6) {
                                            if (!lVar.c()) {
                                                lVar.d();
                                            } else {
                                                int iMin = Math.min(64, 1 << ((i20 << 1) + i19));
                                                if (i20 > 1) {
                                                    lVar.e();
                                                }
                                                for (int i22 = 0; i22 < iMin; i22++) {
                                                    lVar.e();
                                                }
                                                i12 = 3;
                                            }
                                            i21 += i20 == i12 ? i12 : 1;
                                            i19 = 4;
                                        }
                                        i20++;
                                        i15 = 2;
                                        i19 = 4;
                                    }
                                }
                                lVar.d(i15);
                                if (lVar.c()) {
                                    lVar.d(8);
                                    lVar.d();
                                    lVar.d();
                                    lVar.f();
                                }
                                int i23 = 0;
                                boolean zC = false;
                                int i24 = 0;
                                for (int iD9 = lVar.d(); i23 < iD9; iD9 = iD9) {
                                    if (i23 != 0) {
                                        zC = lVar.c();
                                    }
                                    if (zC) {
                                        lVar.f();
                                        lVar.d();
                                        for (int i25 = 0; i25 <= i24; i25++) {
                                            if (lVar.c()) {
                                                lVar.f();
                                            }
                                        }
                                    } else {
                                        int iD10 = lVar.d();
                                        int iD11 = lVar.d();
                                        int i26 = iD10 + iD11;
                                        for (int i27 = 0; i27 < iD10; i27++) {
                                            lVar.d();
                                            lVar.f();
                                        }
                                        for (int i28 = 0; i28 < iD11; i28++) {
                                            lVar.d();
                                            lVar.f();
                                        }
                                        i24 = i26;
                                    }
                                    i23++;
                                }
                                if (lVar.c()) {
                                    for (int i29 = 0; i29 < lVar.d(); i29++) {
                                        lVar.d(iD8 + 4 + 1);
                                    }
                                }
                                lVar.d(2);
                                float f2 = 1.0f;
                                if (lVar.c() && lVar.c()) {
                                    int iB2 = lVar.b(8);
                                    if (iB2 == 255) {
                                        i3 = 16;
                                        int iB3 = lVar.b(16);
                                        int iB4 = lVar.b(16);
                                        if (iB3 != 0 && iB4 != 0) {
                                            f2 = iB3 / iB4;
                                        }
                                    } else {
                                        i3 = 16;
                                        float[] fArr = com.fyber.inneractive.sdk.player.exoplayer2.util.i.f1232b;
                                        if (iB2 < fArr.length) {
                                            f = fArr[iB2];
                                        } else {
                                            Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + iB2);
                                        }
                                        nVar8.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a(str, "video/hevc", (String) null, -1, -1, i16, i17, -1.0f, (List<byte[]>) Collections.singletonList(bArr2), -1, f, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null));
                                        this.e = true;
                                    }
                                } else {
                                    i3 = 16;
                                }
                                f = f2;
                                nVar8.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a(str, "video/hevc", (String) null, -1, -1, i16, i17, -1.0f, (List<byte[]>) Collections.singletonList(bArr2), -1, f, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null));
                                this.e = true;
                            }
                            if (this.j.a(i10)) {
                                n nVar9 = this.j;
                                this.n.a(this.j.d, com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar9.d, nVar9.e));
                                this.n.f(5);
                                com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.a.f1139b);
                            }
                            if (this.k.a(i10)) {
                                n nVar10 = this.k;
                                this.n.a(this.k.d, com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar10.d, nVar10.e));
                                this.n.f(5);
                                com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.a.f1139b);
                            }
                            j = this.m;
                            if (this.e) {
                                aVar = this.d;
                                aVar.g = false;
                                aVar.h = false;
                                aVar.e = j;
                                aVar.d = 0;
                                aVar.f1131b = j2;
                                i4 = i7;
                                if (i4 >= 32) {
                                    if (aVar.j) {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    if (i4 <= 34) {
                                        z2 = true;
                                        aVar.h = !aVar.j;
                                        aVar.j = true;
                                    }
                                    if (i4 >= i3) {
                                        z3 = z;
                                    } else {
                                        z3 = z;
                                    }
                                    aVar.c = z3;
                                    if (z3) {
                                        z4 = z2;
                                    } else {
                                        z4 = z2;
                                    }
                                    aVar.f = z4;
                                } else {
                                    i3 = i3;
                                    z = false;
                                }
                                z2 = true;
                                if (i4 >= i3) {
                                    z3 = z;
                                } else {
                                    z3 = z;
                                }
                                aVar.c = z3;
                                if (z3) {
                                    z4 = z2;
                                } else {
                                    z4 = z2;
                                }
                                aVar.f = z4;
                            } else {
                                i4 = i7;
                                this.g.b(i4);
                                this.h.b(i4);
                                this.i.b(i4);
                            }
                            this.j.b(i4);
                            this.k.b(i4);
                            i5 = i2;
                            bArr = bArr;
                        }
                    }
                }
                i3 = 16;
                if (this.j.a(i10)) {
                    n nVar11 = this.j;
                    this.n.a(this.j.d, com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar11.d, nVar11.e));
                    this.n.f(5);
                    com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.a.f1139b);
                }
                if (this.k.a(i10)) {
                    n nVar12 = this.k;
                    this.n.a(this.k.d, com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(nVar12.d, nVar12.e));
                    this.n.f(5);
                    com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j3, this.n, this.a.f1139b);
                }
                j = this.m;
                if (this.e) {
                    aVar = this.d;
                    aVar.g = false;
                    aVar.h = false;
                    aVar.e = j;
                    aVar.d = 0;
                    aVar.f1131b = j2;
                    i4 = i7;
                    if (i4 >= 32) {
                        if (aVar.j) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (i4 <= 34) {
                            z2 = true;
                            aVar.h = !aVar.j;
                            aVar.j = true;
                        }
                        if (i4 >= i3) {
                            z3 = z;
                        } else {
                            z3 = z;
                        }
                        aVar.c = z3;
                        if (z3) {
                            z4 = z2;
                        } else {
                            z4 = z2;
                        }
                        aVar.f = z4;
                    } else {
                        i3 = i3;
                        z = false;
                    }
                    z2 = true;
                    if (i4 >= i3) {
                        z3 = z;
                    } else {
                        z3 = z;
                    }
                    aVar.c = z3;
                    if (z3) {
                        z4 = z2;
                    } else {
                        z4 = z2;
                    }
                    aVar.f = z4;
                } else {
                    i4 = i7;
                    this.g.b(i4);
                    this.h.b(i4);
                    this.i.b(i4);
                }
                this.j.b(i4);
                this.k.b(i4);
                i5 = i2;
                bArr = bArr;
            }
        }
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (this.e) {
            a aVar = this.d;
            if (aVar.f) {
                int i3 = aVar.d;
                int i4 = (i + 2) - i3;
                if (i4 < i2) {
                    aVar.g = (bArr[i4] & 128) != 0;
                    aVar.f = false;
                } else {
                    aVar.d = i3 + (i2 - i);
                }
            }
        } else {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }
}
