package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.r;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends g {
    public final SparseArray<Map<s, b>> a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseBooleanArray f1197b = new SparseBooleanArray();

    public static final class a {
        public a(int[] iArr, s[] sVarArr, int[] iArr2, int[][][] iArr3, s sVar) {
        }
    }

    public static final class b {
    }

    /* JADX WARN: Code duplicated, block: B:109:0x027e A[LOOP:8: B:64:0x015f->B:109:0x027e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:114:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:117:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:120:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:122:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:134:0x0307  */
    /* JADX WARN: Code duplicated, block: B:140:0x0311  */
    /* JADX WARN: Code duplicated, block: B:141:0x0313  */
    /* JADX WARN: Code duplicated, block: B:144:0x031f  */
    /* JADX WARN: Code duplicated, block: B:146:0x0323  */
    /* JADX WARN: Code duplicated, block: B:147:0x0325  */
    /* JADX WARN: Code duplicated, block: B:149:0x0328  */
    /* JADX WARN: Code duplicated, block: B:151:0x032e  */
    /* JADX WARN: Code duplicated, block: B:152:0x0337  */
    /* JADX WARN: Code duplicated, block: B:161:0x034b  */
    /* JADX WARN: Code duplicated, block: B:162:0x0358  */
    /* JADX WARN: Code duplicated, block: B:167:0x0380  */
    /* JADX WARN: Code duplicated, block: B:168:0x0382  */
    /* JADX WARN: Code duplicated, block: B:169:0x0389 A[PHI: r0
      0x0389: PHI (r0v60 com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e) = 
      (r0v59 com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e)
      (r0v64 com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e)
     binds: [B:113:0x02ac, B:168:0x0382] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:172:0x0390  */
    /* JADX WARN: Code duplicated, block: B:173:0x0392  */
    /* JADX WARN: Code duplicated, block: B:399:0x0279 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:403:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x015b  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g
    public final h a(com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr, s sVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        int i;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.C0297b c0297b;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar;
        e.a aVar;
        boolean z;
        e cVar;
        int[] iArr;
        boolean z2;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar2;
        int[][] iArr2;
        String str;
        int i2;
        int i3;
        s sVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar3;
        int i4;
        e[] eVarArr;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.C0297b c0297b2;
        int i5;
        int[] iArr3;
        s[] sVarArr;
        int[] iArr4;
        int[][][] iArr5;
        s sVar3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        e cVar2;
        e eVar;
        int i6;
        int i7;
        int i8;
        int iB;
        int i9;
        r rVar;
        r rVar2;
        int i10;
        List<Integer> listA;
        int[] iArr6;
        int i11;
        r rVar3;
        int i12;
        boolean z7;
        r rVar4;
        int i13;
        s sVar4;
        i iVar;
        boolean z8;
        int i14;
        boolean zA;
        boolean z9;
        int iA;
        int i15;
        int i16;
        int i17;
        boolean z10;
        String str2;
        int[] iArr7;
        boolean z11;
        int[] iArr8;
        com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr2 = aVarArr;
        int[] iArr9 = new int[aVarArr2.length + 1];
        int length = aVarArr2.length + 1;
        r[][] rVarArr = new r[length][];
        int[][][] iArr10 = new int[aVarArr2.length + 1][][];
        for (int i18 = 0; i18 < length; i18++) {
            int i19 = sVar.a;
            rVarArr[i18] = new r[i19];
            iArr10[i18] = new int[i19][];
        }
        int length2 = aVarArr2.length;
        int[] iArr11 = new int[length2];
        for (int i20 = 0; i20 < length2; i20++) {
            aVarArr2[i20].getClass();
            iArr11[i20] = 4;
        }
        for (int i21 = 0; i21 < sVar.a; i21++) {
            r rVar5 = sVar.f1192b[i21];
            int length3 = aVarArr2.length;
            int i22 = 0;
            for (int i23 = 0; i23 < aVarArr2.length; i23++) {
                com.fyber.inneractive.sdk.player.exoplayer2.a aVar2 = aVarArr2[i23];
                int i24 = 0;
                while (i24 < rVar5.a) {
                    i iVar2 = rVar5.f1191b[i24];
                    com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b bVar4 = (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b) aVar2;
                    bVar4.getClass();
                    com.fyber.inneractive.sdk.player.exoplayer2.a aVar3 = aVar2;
                    try {
                        int iA2 = bVar4.a(bVar4.i, iVar2) & 3;
                        if (iA2 > i22) {
                            if (iA2 == 3) {
                                length3 = i23;
                                break;
                            }
                            i22 = iA2;
                            length3 = i23;
                        }
                        i24++;
                        aVar2 = aVar3;
                    } catch (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.b e) {
                        throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e, bVar4.c);
                    }
                }
            }
            if (length3 == aVarArr2.length) {
                iArr8 = new int[rVar5.a];
            } else {
                com.fyber.inneractive.sdk.player.exoplayer2.a aVar4 = aVarArr2[length3];
                int[] iArr12 = new int[rVar5.a];
                for (int i25 = 0; i25 < rVar5.a; i25++) {
                    i iVar3 = rVar5.f1191b[i25];
                    com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b bVar5 = (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b) aVar4;
                    bVar5.getClass();
                    try {
                        iArr12[i25] = bVar5.a(bVar5.i, iVar3);
                    } catch (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.b e2) {
                        throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e2, bVar5.c);
                    }
                }
                iArr8 = iArr12;
            }
            int i26 = iArr9[length3];
            rVarArr[length3][i26] = rVar5;
            iArr10[length3][i26] = iArr8;
            iArr9[length3] = iArr9[length3] + 1;
        }
        s[] sVarArr2 = new s[aVarArr2.length];
        int[] iArr13 = new int[aVarArr2.length];
        for (int i27 = 0; i27 < aVarArr2.length; i27++) {
            int i28 = iArr9[i27];
            sVarArr2[i27] = new s((r[]) Arrays.copyOf(rVarArr[i27], i28));
            iArr10[i27] = (int[][]) Arrays.copyOf(iArr10[i27], i28);
            iArr13[i27] = aVarArr2[i27].a;
        }
        s sVar5 = new s((r[]) Arrays.copyOf(rVarArr[aVarArr2.length], iArr9[aVarArr2.length]));
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar6 = (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b) this;
        int length4 = aVarArr2.length;
        e[] eVarArr2 = new e[length4];
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.C0297b c0297b3 = bVar6.d.get();
        int i29 = 0;
        boolean z12 = false;
        boolean z13 = false;
        while (i29 < length4) {
            if (2 == aVarArr2[i29].a) {
                if (z12) {
                    bVar3 = bVar6;
                    i4 = length4;
                    eVarArr = eVarArr2;
                    c0297b2 = c0297b3;
                    i5 = i29;
                    iArr3 = iArr13;
                    sVarArr = sVarArr2;
                    iArr4 = iArr11;
                    iArr5 = iArr10;
                    sVar3 = sVar5;
                    z3 = z13;
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.a aVar5 = aVarArr2[i29];
                    s sVar6 = sVarArr2[i29];
                    int[][] iArr14 = iArr10[i29];
                    sVar3 = sVar5;
                    int i30 = c0297b3.e;
                    iArr4 = iArr11;
                    int i31 = c0297b3.f;
                    iArr3 = iArr13;
                    int i32 = c0297b3.g;
                    boolean z14 = c0297b3.d;
                    iArr5 = iArr10;
                    boolean z15 = c0297b3.c;
                    int i33 = c0297b3.j;
                    i4 = length4;
                    int i34 = c0297b3.k;
                    z3 = z13;
                    boolean z16 = c0297b3.l;
                    sVarArr = sVarArr2;
                    e.a aVar6 = bVar6.c;
                    bVar3 = bVar6;
                    boolean z17 = c0297b3.h;
                    eVarArr = eVarArr2;
                    boolean z18 = c0297b3.i;
                    if (aVar6 != null) {
                        int i35 = z14 ? 12 : 8;
                        if (z15) {
                            aVar5.getClass();
                            if ((i35 & 4) != 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                        } else {
                            z10 = false;
                        }
                        c0297b2 = c0297b3;
                        int i36 = 0;
                        while (true) {
                            if (i36 < sVar6.a) {
                                r rVar6 = sVar6.f1192b[i36];
                                int[] iArr15 = iArr14[i36];
                                i5 = i29;
                                z4 = z17;
                                if (rVar6.a < 2) {
                                    iArr7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.e;
                                    z5 = z18;
                                } else {
                                    ArrayList arrayList = (ArrayList) com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(rVar6, i33, i34, z16);
                                    z5 = z18;
                                    if (arrayList.size() < 2) {
                                        iArr7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.e;
                                    } else {
                                        if (z10) {
                                            i33 = i33;
                                            i34 = i34;
                                            z6 = z16;
                                            str2 = null;
                                        } else {
                                            HashSet hashSet = new HashSet();
                                            int i37 = 0;
                                            int i38 = 0;
                                            str2 = null;
                                            while (i38 < arrayList.size()) {
                                                int i39 = i33;
                                                String str3 = rVar6.f1191b[((Integer) arrayList.get(i38)).intValue()].f;
                                                HashSet hashSet2 = hashSet;
                                                int i40 = i34;
                                                if (hashSet.add(str3)) {
                                                    int i41 = 0;
                                                    int i42 = 0;
                                                    while (i42 < arrayList.size()) {
                                                        int iIntValue = ((Integer) arrayList.get(i42)).intValue();
                                                        boolean z19 = z16;
                                                        if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(rVar6.f1191b[iIntValue], str3, iArr15[iIntValue], i35, i30, i31, i32)) {
                                                            i41++;
                                                        }
                                                        i42++;
                                                        z16 = z19;
                                                    }
                                                    z11 = z16;
                                                    if (i41 > i37) {
                                                        str2 = str3;
                                                        i37 = i41;
                                                    }
                                                } else {
                                                    z11 = z16;
                                                }
                                                i38++;
                                                i33 = i39;
                                                hashSet = hashSet2;
                                                i34 = i40;
                                                z16 = z11;
                                            }
                                            i33 = i33;
                                            i34 = i34;
                                            z6 = z16;
                                        }
                                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                                            int iIntValue2 = ((Integer) arrayList.get(size)).intValue();
                                            if (!com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(rVar6.f1191b[iIntValue2], str2, iArr15[iIntValue2], i35, i30, i31, i32)) {
                                                arrayList.remove(size);
                                            }
                                        }
                                        if (arrayList.size() < 2) {
                                            iArr7 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.e;
                                        } else {
                                            int i43 = u.a;
                                            int size2 = arrayList.size();
                                            int[] iArr16 = new int[size2];
                                            for (int i44 = 0; i44 < size2; i44++) {
                                                iArr16[i44] = ((Integer) arrayList.get(i44)).intValue();
                                            }
                                            iArr7 = iArr16;
                                        }
                                    }
                                    if (iArr7.length > 0) {
                                        cVar2 = aVar6.a(rVar6, iArr7);
                                        break;
                                    }
                                    i36++;
                                    i29 = i5;
                                    z17 = z4;
                                    z18 = z5;
                                    z10 = z10;
                                    iArr14 = iArr14;
                                    i33 = i33;
                                    i34 = i34;
                                    z16 = z6;
                                }
                                z6 = z16;
                                iArr14 = iArr14;
                                if (iArr7.length > 0) {
                                    cVar2 = aVar6.a(rVar6, iArr7);
                                    break;
                                }
                                i36++;
                                i29 = i5;
                                z17 = z4;
                                z18 = z5;
                                z10 = z10;
                                iArr14 = iArr14;
                                i33 = i33;
                                i34 = i34;
                                z16 = z6;
                            } else {
                                i33 = i33;
                                z4 = z17;
                                i34 = i34;
                                z5 = z18;
                            }
                        }
                        if (cVar2 == null) {
                            i6 = 0;
                            i7 = 0;
                            i8 = 0;
                            iB = -1;
                            i9 = -1;
                            rVar = null;
                            while (i6 < sVar6.a) {
                                rVar2 = sVar6.f1192b[i6];
                                i10 = i33;
                                int i45 = i34;
                                boolean z20 = z6;
                                listA = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(rVar2, i10, i45, z20);
                                iArr6 = iArr14[i6];
                                i11 = i7;
                                rVar3 = rVar;
                                i12 = 0;
                                while (i12 < rVar2.a) {
                                    int i46 = i10;
                                    z7 = z5;
                                    if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iArr6[i12], z7)) {
                                        iVar = rVar2.f1191b[i12];
                                        rVar4 = rVar2;
                                        z5 = z7;
                                        if (((ArrayList) listA).contains(Integer.valueOf(i12)) || (((i15 = iVar.j) != -1 && i15 > i30) || (((i16 = iVar.k) != -1 && i16 > i31) || ((i17 = iVar.f1156b) != -1 && i17 > i32)))) {
                                            z8 = false;
                                        } else {
                                            z8 = true;
                                        }
                                        if (!z8 || z4) {
                                            sVar4 = sVar6;
                                            if (z8) {
                                                i14 = 2;
                                            } else {
                                                i14 = 1;
                                            }
                                            i13 = i32;
                                            zA = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iArr6[i12], false);
                                            if (zA) {
                                                i14 += 1000;
                                            }
                                            if (i14 > i8) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            if (i14 == i8) {
                                                if (iVar.b() != iB) {
                                                    iA = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iVar.b(), iB);
                                                } else {
                                                    iA = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iVar.f1156b, i9);
                                                }
                                                z9 = zA || !z8 ? iA < 0 : iA > 0;
                                            }
                                            if (z9) {
                                                int i47 = iVar.f1156b;
                                                iB = iVar.b();
                                                i11 = i12;
                                                i9 = i47;
                                                i8 = i14;
                                                rVar3 = rVar4;
                                            }
                                        }
                                        i12++;
                                        rVar2 = rVar4;
                                        sVar6 = sVar4;
                                        i32 = i13;
                                        i10 = i46;
                                    } else {
                                        rVar4 = rVar2;
                                        z5 = z7;
                                    }
                                    sVar4 = sVar6;
                                    i13 = i32;
                                    i12++;
                                    rVar2 = rVar4;
                                    sVar6 = sVar4;
                                    i32 = i13;
                                    i10 = i46;
                                }
                                i33 = i10;
                                i6++;
                                i34 = i45;
                                z6 = z20;
                                i7 = i11;
                                rVar = rVar3;
                            }
                            if (rVar == null) {
                                eVar = null;
                            } else {
                                cVar2 = new c(rVar, i7, 0, null);
                                eVar = cVar2;
                            }
                        } else {
                            eVar = cVar2;
                        }
                        eVarArr[i5] = eVar;
                        if (eVarArr[i5] != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                    } else {
                        i33 = i33;
                        z4 = z17;
                        i34 = i34;
                        z5 = z18;
                        c0297b2 = c0297b3;
                    }
                    i5 = i29;
                    z6 = z16;
                    iArr14 = iArr14;
                    cVar2 = null;
                    if (cVar2 == null) {
                        i6 = 0;
                        i7 = 0;
                        i8 = 0;
                        iB = -1;
                        i9 = -1;
                        rVar = null;
                        while (i6 < sVar6.a) {
                            rVar2 = sVar6.f1192b[i6];
                            i10 = i33;
                            int i48 = i34;
                            boolean z21 = z6;
                            listA = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(rVar2, i10, i48, z21);
                            iArr6 = iArr14[i6];
                            i11 = i7;
                            rVar3 = rVar;
                            i12 = 0;
                            while (i12 < rVar2.a) {
                                int i49 = i10;
                                z7 = z5;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iArr6[i12], z7)) {
                                    iVar = rVar2.f1191b[i12];
                                    rVar4 = rVar2;
                                    z5 = z7;
                                    if (((ArrayList) listA).contains(Integer.valueOf(i12))) {
                                        z8 = false;
                                    } else {
                                        z8 = false;
                                    }
                                    if (!z8) {
                                    }
                                    sVar4 = sVar6;
                                    if (z8) {
                                        i14 = 2;
                                    } else {
                                        i14 = 1;
                                    }
                                    i13 = i32;
                                    zA = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iArr6[i12], false);
                                    if (zA) {
                                        i14 += 1000;
                                    }
                                    if (i14 > i8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    if (i14 == i8) {
                                        if (iVar.b() != iB) {
                                            iA = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iVar.b(), iB);
                                        } else {
                                            iA = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iVar.f1156b, i9);
                                        }
                                        if (zA) {
                                        }
                                        i12++;
                                        rVar2 = rVar4;
                                        sVar6 = sVar4;
                                        i32 = i13;
                                        i10 = i49;
                                    }
                                    if (z9) {
                                        int i410 = iVar.f1156b;
                                        iB = iVar.b();
                                        i11 = i12;
                                        i9 = i410;
                                        i8 = i14;
                                        rVar3 = rVar4;
                                    }
                                    i12++;
                                    rVar2 = rVar4;
                                    sVar6 = sVar4;
                                    i32 = i13;
                                    i10 = i49;
                                } else {
                                    rVar4 = rVar2;
                                    z5 = z7;
                                }
                                sVar4 = sVar6;
                                i13 = i32;
                                i12++;
                                rVar2 = rVar4;
                                sVar6 = sVar4;
                                i32 = i13;
                                i10 = i49;
                            }
                            i33 = i10;
                            i6++;
                            i34 = i48;
                            z6 = z21;
                            i7 = i11;
                            rVar = rVar3;
                        }
                        if (rVar == null) {
                            eVar = null;
                        } else {
                            cVar2 = new c(rVar, i7, 0, null);
                            eVar = cVar2;
                        }
                    } else {
                        eVar = cVar2;
                    }
                    eVarArr[i5] = eVar;
                    if (eVarArr[i5] != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                }
                z13 = z3 | (sVarArr[i5].a > 0);
            } else {
                bVar3 = bVar6;
                i4 = length4;
                eVarArr = eVarArr2;
                c0297b2 = c0297b3;
                i5 = i29;
                iArr3 = iArr13;
                sVarArr = sVarArr2;
                iArr4 = iArr11;
                iArr5 = iArr10;
                sVar3 = sVar5;
            }
            i29 = i5 + 1;
            aVarArr2 = aVarArr;
            sVar5 = sVar3;
            iArr11 = iArr4;
            iArr13 = iArr3;
            iArr10 = iArr5;
            length4 = i4;
            sVarArr2 = sVarArr;
            bVar6 = bVar3;
            eVarArr2 = eVarArr;
            c0297b3 = c0297b2;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar7 = bVar6;
        e[] eVarArr3 = eVarArr2;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.C0297b c0297b4 = c0297b3;
        int[] iArr17 = iArr13;
        s[] sVarArr3 = sVarArr2;
        int[] iArr18 = iArr11;
        int[][][] iArr19 = iArr10;
        s sVar7 = sVar5;
        boolean z22 = z13;
        int i50 = length4;
        boolean z23 = false;
        boolean z24 = false;
        int i51 = 0;
        while (i51 < i50) {
            int i52 = aVarArr[i51].a;
            if (i52 == 1) {
                i = i50;
                c0297b = c0297b4;
                if (z24) {
                    c0297b4 = c0297b;
                } else {
                    s sVar8 = sVarArr3[i51];
                    int[][] iArr20 = iArr19[i51];
                    String str4 = c0297b.a;
                    boolean z25 = c0297b.i;
                    boolean z26 = c0297b.c;
                    if (z22) {
                        bVar = bVar7;
                        aVar = null;
                    } else {
                        bVar = bVar7;
                        aVar = bVar.c;
                    }
                    int i53 = -1;
                    int i54 = -1;
                    int i55 = 0;
                    int i56 = 0;
                    while (i55 < sVar8.a) {
                        r rVar7 = sVar8.f1192b[i55];
                        int[] iArr21 = iArr20[i55];
                        boolean z27 = z23;
                        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.C0297b c0297b5 = c0297b;
                        int i57 = i56;
                        int i58 = i54;
                        int i59 = i53;
                        int i60 = 0;
                        while (i60 < rVar7.a) {
                            if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iArr21[i60], z25)) {
                                i iVar4 = rVar7.f1191b[i60];
                                z2 = z25;
                                int i61 = iArr21[i60];
                                bVar2 = bVar;
                                boolean z28 = (iVar4.x & 1) != 0;
                                int i62 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iVar4, str4) ? z28 ? 4 : 3 : z28 ? 2 : 1;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(i61, false)) {
                                    i62 += 1000;
                                }
                                if (i62 > i57) {
                                    i57 = i62;
                                    i58 = i60;
                                    i59 = i55;
                                }
                            } else {
                                z2 = z25;
                                bVar2 = bVar;
                            }
                            i60++;
                            z25 = z2;
                            bVar = bVar2;
                        }
                        i55++;
                        i53 = i59;
                        i54 = i58;
                        c0297b = c0297b5;
                        i56 = i57;
                        z23 = z27;
                    }
                    z23 = z23;
                    c0297b4 = c0297b;
                    bVar7 = bVar;
                    if (i53 == -1) {
                        z = true;
                        cVar = null;
                    } else {
                        r rVar8 = sVar8.f1192b[i53];
                        if (aVar != null) {
                            int[] iArr22 = iArr20[i53];
                            HashSet hashSet3 = new HashSet();
                            int i63 = 0;
                            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a aVar7 = null;
                            for (int i64 = 0; i64 < rVar8.a; i64++) {
                                i iVar5 = rVar8.f1191b[i64];
                                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a aVar8 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iVar5.r, iVar5.s, z26 ? null : iVar5.f);
                                if (hashSet3.add(aVar8)) {
                                    int i65 = 0;
                                    for (int i66 = 0; i66 < rVar8.a; i66++) {
                                        if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(rVar8.f1191b[i66], iArr22[i66], aVar8)) {
                                            i65++;
                                        }
                                    }
                                    if (i65 > i63) {
                                        aVar7 = aVar8;
                                        i63 = i65;
                                    }
                                }
                            }
                            z = true;
                            if (i63 > 1) {
                                iArr = new int[i63];
                                int i67 = 0;
                                for (int i68 = 0; i68 < rVar8.a; i68++) {
                                    if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(rVar8.f1191b[i68], iArr22[i68], aVar7)) {
                                        iArr[i67] = i68;
                                        i67++;
                                    }
                                }
                            } else {
                                iArr = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.e;
                            }
                            if (iArr.length > 0) {
                                cVar = aVar.a(rVar8, iArr);
                            }
                        } else {
                            z = true;
                        }
                        cVar = new c(rVar8, i54);
                    }
                    eVarArr3[i51] = cVar;
                    z24 = eVarArr3[i51] != null ? z : false;
                }
            } else if (i52 != 2) {
                if (i52 != 3) {
                    aVarArr[i51].getClass();
                    s sVar9 = sVarArr3[i51];
                    int[][] iArr23 = iArr19[i51];
                    c0297b = c0297b4;
                    boolean z29 = c0297b.i;
                    int i69 = 0;
                    int i70 = 0;
                    r rVar9 = null;
                    for (int i71 = 0; i71 < sVar9.a; i71++) {
                        r rVar10 = sVar9.f1192b[i71];
                        int[] iArr24 = iArr23[i71];
                        int i72 = 0;
                        while (i72 < rVar10.a) {
                            if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iArr24[i72], z29)) {
                                i3 = i50;
                                int i73 = (rVar10.f1191b[i72].x & 1) != 0 ? 2 : 1;
                                sVar2 = sVar9;
                                if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iArr24[i72], false)) {
                                    i73 += 1000;
                                }
                                if (i73 > i70) {
                                    i69 = i72;
                                    i70 = i73;
                                    rVar9 = rVar10;
                                }
                            } else {
                                i3 = i50;
                                sVar2 = sVar9;
                            }
                            i72++;
                            sVar9 = sVar2;
                            i50 = i3;
                        }
                    }
                    i = i50;
                    eVarArr3[i51] = rVar9 == null ? null : new c(rVar9, i69, 0, null);
                } else {
                    i = i50;
                    c0297b = c0297b4;
                    if (!z23) {
                        s sVar10 = sVarArr3[i51];
                        int[][] iArr25 = iArr19[i51];
                        String str5 = c0297b.f1196b;
                        String str6 = c0297b.a;
                        boolean z30 = c0297b.i;
                        int i74 = 0;
                        int i75 = 0;
                        int i76 = 0;
                        r rVar11 = null;
                        while (i74 < sVar10.a) {
                            r rVar12 = sVar10.f1192b[i74];
                            int[] iArr26 = iArr25[i74];
                            s sVar11 = sVar10;
                            int i77 = 0;
                            while (i77 < rVar12.a) {
                                if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iArr26[i77], z30)) {
                                    i iVar6 = rVar12.f1191b[i77];
                                    iArr2 = iArr25;
                                    int i78 = iVar6.x;
                                    boolean z31 = (i78 & 1) != 0;
                                    boolean z32 = (i78 & 2) != 0;
                                    if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iVar6, str5)) {
                                        i2 = z31 ? 6 : !z32 ? 5 : 4;
                                    } else if (z31) {
                                        i2 = 3;
                                    } else {
                                        if (z32) {
                                            i2 = com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iVar6, str6) ? 2 : 1;
                                        }
                                        i77++;
                                        iArr25 = iArr2;
                                        str5 = str;
                                    }
                                    str = str5;
                                    if (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b.a(iArr26[i77], false)) {
                                        i2 += 1000;
                                    }
                                    if (i2 > i76) {
                                        i76 = i2;
                                        rVar11 = rVar12;
                                        i75 = i77;
                                    }
                                    i77++;
                                    iArr25 = iArr2;
                                    str5 = str;
                                } else {
                                    iArr2 = iArr25;
                                }
                                str = str5;
                                i77++;
                                iArr25 = iArr2;
                                str5 = str;
                            }
                            i74++;
                            sVar10 = sVar11;
                        }
                        eVarArr3[i51] = rVar11 == null ? null : new c(rVar11, i75, 0, null);
                        c0297b4 = c0297b;
                        z23 = eVarArr3[i51] != null;
                    }
                }
                c0297b4 = c0297b;
            } else {
                i = i50;
            }
            i51++;
            z23 = z23;
            i50 = i;
        }
        for (int i79 = 0; i79 < aVarArr.length; i79++) {
            if (this.f1197b.get(i79)) {
                eVarArr3[i79] = null;
            } else {
                s sVar12 = sVarArr3[i79];
                Map<s, b> map = this.a.get(i79);
                if (map != null && map.containsKey(sVar12)) {
                    if (this.a.get(i79).get(sVar12) != null) {
                        r rVar13 = sVar12.f1192b[0];
                        throw null;
                    }
                    eVarArr3[i79] = null;
                }
            }
        }
        a aVar9 = new a(iArr17, sVarArr3, iArr18, iArr19, sVar7);
        o[] oVarArr = new o[aVarArr.length];
        for (int i80 = 0; i80 < aVarArr.length; i80++) {
            oVarArr[i80] = eVarArr3[i80] != null ? o.f1173b : null;
        }
        return new h(sVar, new f(eVarArr3), aVar9, oVarArr);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g
    public final void a(Object obj) {
    }
}
