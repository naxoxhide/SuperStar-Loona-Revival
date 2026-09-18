package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {
    public static final long l = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a("AC-3");
    public static final long m = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a("EAC3");
    public static final long n = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a("HEVC");
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.fyber.inneractive.sdk.player.exoplayer2.util.r> f1141b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k c;
    public final SparseIntArray d;
    public final v.c e;
    public final SparseArray<v> f;
    public final SparseBooleanArray g;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.h h;
    public int i;
    public boolean j;
    public v k;

    public class a implements q {
        public final com.fyber.inneractive.sdk.player.exoplayer2.util.j a = new com.fyber.inneractive.sdk.player.exoplayer2.util.j(new byte[4]);

        public a() {
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.q
        public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
            if (kVar.l() != 0) {
                return;
            }
            kVar.f(7);
            int iA = kVar.a() / 4;
            for (int i = 0; i < iA; i++) {
                kVar.a(this.a, 4);
                int iA2 = this.a.a(16);
                this.a.c(3);
                if (iA2 == 0) {
                    this.a.c(13);
                } else {
                    int iA3 = this.a.a(13);
                    u uVar = u.this;
                    uVar.f.put(iA3, new r(uVar.new b(iA3)));
                    u.this.i++;
                }
            }
            u uVar2 = u.this;
            if (uVar2.a != 2) {
                uVar2.f.remove(0);
            }
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.q
        public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        }
    }

    public class b implements q {
        public final com.fyber.inneractive.sdk.player.exoplayer2.util.j a = new com.fyber.inneractive.sdk.player.exoplayer2.util.j(new byte[5]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<v> f1143b = new SparseArray<>();
        public final SparseIntArray c = new SparseIntArray();
        public final int d;

        public b(int i) {
            this.d = i;
        }

        /* JADX WARN: Code duplicated, block: B:109:0x01f4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:36:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:41:0x010e  */
        /* JADX WARN: Code duplicated, block: B:76:0x01db  */
        /* JADX WARN: Code duplicated, block: B:79:0x01e8  */
        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.q
        public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar;
            com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar2;
            int i;
            char c;
            v vVarA;
            int i2;
            int i3;
            int i4;
            int i5;
            b bVar = this;
            if (kVar.l() != 2) {
                return;
            }
            u uVar = u.this;
            int i6 = uVar.a;
            if (i6 == 1 || i6 == 2 || uVar.i == 1) {
                rVar = uVar.f1141b.get(0);
            } else {
                rVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.r(uVar.f1141b.get(0).a);
                u.this.f1141b.add(rVar);
            }
            kVar.f(2);
            int iQ = kVar.q();
            int i7 = 5;
            kVar.f(5);
            kVar.a(bVar.a, 2);
            int i8 = 4;
            bVar.a.c(4);
            int i9 = 12;
            kVar.f(bVar.a.a(12));
            u uVar2 = u.this;
            if (uVar2.a == 2 && uVar2.k == null) {
                v.b bVar2 = new v.b(21, null, null, new byte[0]);
                u uVar3 = u.this;
                uVar3.k = uVar3.e.a(21, bVar2);
                u uVar4 = u.this;
                uVar4.k.a(rVar, uVar4.h, new v.d(iQ, 21, 8192));
            }
            bVar.f1143b.clear();
            bVar.c.clear();
            int iA = kVar.a();
            while (iA > 0) {
                kVar.a(bVar.a, i7);
                int iA2 = bVar.a.a(8);
                bVar.a.c(3);
                int iA3 = bVar.a.a(13);
                bVar.a.c(i8);
                int iA4 = bVar.a.a(i9);
                int i10 = kVar.f1236b;
                int i11 = i10 + iA4;
                int i12 = -1;
                String strTrim = null;
                ArrayList arrayList = null;
                while (kVar.f1236b < i11) {
                    int iL = kVar.l();
                    int iL2 = kVar.f1236b + kVar.l();
                    if (iL == i7) {
                        long jM = kVar.m();
                        if (jM == u.l) {
                            i5 = 129;
                        } else if (jM == u.m) {
                            i5 = 135;
                        } else {
                            if (jM == u.n) {
                                i5 = 36;
                            }
                            i3 = iA3;
                            i4 = 4;
                        }
                        i12 = i5;
                        i3 = iA3;
                        i4 = 4;
                    } else {
                        if (iL == 106) {
                            i5 = 129;
                        } else if (iL == 122) {
                            i5 = 135;
                        } else if (iL == 123) {
                            i5 = 138;
                        } else {
                            if (iL == 10) {
                                strTrim = kVar.b(3).trim();
                            } else {
                                int i13 = 3;
                                if (iL == 89) {
                                    ArrayList arrayList2 = new ArrayList();
                                    while (kVar.f1236b < iL2) {
                                        String strTrim2 = kVar.b(i13).trim();
                                        int iL3 = kVar.l();
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar3 = rVar;
                                        byte[] bArr = new byte[4];
                                        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, 4);
                                        kVar.f1236b += 4;
                                        arrayList2.add(new v.a(strTrim2, iL3, bArr));
                                        rVar = rVar3;
                                        iQ = iQ;
                                        iA3 = iA3;
                                        i13 = 3;
                                    }
                                    iQ = iQ;
                                    rVar = rVar;
                                    i3 = iA3;
                                    i4 = 4;
                                    arrayList = arrayList2;
                                    i12 = 89;
                                }
                            }
                            i3 = iA3;
                            i4 = 4;
                        }
                        i12 = i5;
                        i3 = iA3;
                        i4 = 4;
                    }
                    kVar.f(iL2 - kVar.f1236b);
                    i8 = i4;
                    rVar = rVar;
                    iQ = iQ;
                    iA3 = i3;
                    i7 = 5;
                }
                int i14 = iQ;
                com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar4 = rVar;
                int i15 = iA3;
                int i16 = i8;
                kVar.e(i11);
                v.b bVar3 = new v.b(i12, strTrim, arrayList, Arrays.copyOfRange(kVar.a, i10, i11));
                if (iA2 == 6) {
                    iA2 = i12;
                }
                iA -= iA4 + 5;
                u uVar5 = u.this;
                int i17 = uVar5.a == 2 ? iA2 : i15;
                if (uVar5.g.get(i17)) {
                    c = 21;
                } else {
                    u uVar6 = u.this;
                    if (uVar6.a == 2) {
                        c = 21;
                        if (iA2 == 21) {
                            vVarA = uVar6.k;
                        }
                        if (u.this.a == 2) {
                            i2 = i15;
                            if (i2 < this.c.get(i17, 8192)) {
                            }
                        } else {
                            i2 = i15;
                        }
                        this.c.put(i17, i2);
                        this.f1143b.put(i17, vVarA);
                    } else {
                        c = 21;
                    }
                    vVarA = uVar6.e.a(iA2, bVar3);
                    if (u.this.a == 2) {
                        i2 = i15;
                        if (i2 < this.c.get(i17, 8192)) {
                        }
                    } else {
                        i2 = i15;
                    }
                    this.c.put(i17, i2);
                    this.f1143b.put(i17, vVarA);
                }
                bVar = this;
                i8 = i16;
                rVar = rVar4;
                iQ = i14;
                i7 = 5;
                i9 = 12;
            }
            int i18 = iQ;
            com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar5 = rVar;
            b bVar4 = bVar;
            int size = bVar4.c.size();
            int i19 = 0;
            while (i19 < size) {
                int iKeyAt = bVar4.c.keyAt(i19);
                u.this.g.put(iKeyAt, true);
                v vVarValueAt = bVar4.f1143b.valueAt(i19);
                if (vVarValueAt != null) {
                    u uVar7 = u.this;
                    if (vVarValueAt != uVar7.k) {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar = uVar7.h;
                        i = i18;
                        v.d dVar = new v.d(i, iKeyAt, 8192);
                        rVar2 = rVar5;
                        vVarValueAt.a(rVar2, hVar, dVar);
                    } else {
                        rVar2 = rVar5;
                        i = i18;
                    }
                    u.this.f.put(bVar4.c.valueAt(i19), vVarValueAt);
                } else {
                    rVar2 = rVar5;
                    i = i18;
                }
                i19++;
                rVar5 = rVar2;
                i18 = i;
            }
            u uVar8 = u.this;
            if (uVar8.a == 2) {
                if (uVar8.j) {
                    return;
                }
                uVar8.h.c();
                u uVar9 = u.this;
                uVar9.i = 0;
                uVar9.j = true;
                return;
            }
            uVar8.f.remove(bVar4.d);
            u uVar10 = u.this;
            int i20 = uVar10.a == 1 ? 0 : uVar10.i - 1;
            uVar10.i = i20;
            if (i20 == 0) {
                uVar10.h.c();
                u.this.j = true;
            }
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.q
        public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        }
    }

    public u(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar, v.c cVar) {
        this.e = (v.c) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(cVar);
        this.a = i;
        if (i == 1 || i == 2) {
            this.f1141b = Collections.singletonList(rVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f1141b = arrayList;
            arrayList.add(rVar);
        }
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(940);
        this.g = new SparseBooleanArray();
        this.f = new SparseArray<>();
        this.d = new SparseIntArray();
        a();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar) throws InterruptedException, IOException {
        byte[] bArr = this.c.a;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        bVar.a(bArr, 0, 940, false);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 == 5) {
                    bVar.c(i);
                    return true;
                }
                if (bArr[(i2 * 188) + i] != 71) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar) {
        this.h = hVar;
        hVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.m.a(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(long j, long j2) {
        int size = this.f1141b.size();
        for (int i = 0; i < size; i++) {
            this.f1141b.get(i).c = -9223372036854775807L;
        }
        this.c.r();
        this.d.clear();
        a();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) throws InterruptedException, IOException {
        v vVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = this.c;
        byte[] bArr = kVar.a;
        if (940 - kVar.f1236b < 188) {
            int iA = kVar.a();
            if (iA > 0) {
                System.arraycopy(bArr, this.c.f1236b, bArr, 0, iA);
            }
            this.c.a(bArr, iA);
        }
        while (this.c.a() < 188) {
            int i = this.c.c;
            int iA2 = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).a(bArr, i, 940 - i);
            if (iA2 == -1) {
                return -1;
            }
            this.c.d(i + iA2);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar2 = this.c;
        int i2 = kVar2.c;
        int i3 = kVar2.f1236b;
        while (i3 < i2 && bArr[i3] != 71) {
            i3++;
        }
        this.c.e(i3);
        int i4 = i3 + 188;
        if (i4 > i2) {
            return 0;
        }
        int iC = this.c.c();
        if ((8388608 & iC) != 0) {
            this.c.e(i4);
            return 0;
        }
        boolean z = true;
        boolean z2 = (4194304 & iC) != 0;
        int i5 = (2096896 & iC) >> 8;
        boolean z3 = (iC & 32) != 0;
        boolean z4 = (iC & 16) != 0;
        if (this.a != 2) {
            int i6 = iC & 15;
            int i7 = this.d.get(i5, i6 - 1);
            this.d.put(i5, i6);
            if (i7 == i6) {
                if (z4) {
                    this.c.e(i4);
                    return 0;
                }
            } else if (i6 == ((i7 + 1) & 15)) {
            }
            z = false;
        } else {
            z = false;
        }
        if (z3) {
            this.c.f(this.c.l());
        }
        if (z4 && (vVar = this.f.get(i5)) != null) {
            if (z) {
                vVar.a();
            }
            this.c.d(i4);
            vVar.a(this.c, z2);
            this.c.d(i2);
        }
        this.c.e(i4);
        return 0;
    }

    public final void a() {
        this.g.clear();
        this.f.clear();
        SparseArray<v> sparseArrayA = this.e.a();
        int size = sparseArrayA.size();
        for (int i = 0; i < size; i++) {
            this.f.put(sparseArrayA.keyAt(i), sparseArrayA.valueAt(i));
        }
        this.f.put(0, new r(new a()));
        this.k = null;
    }
}
