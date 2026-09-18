package com.applovin.exoplayer2.e.g;

import android.util.Pair;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.e.r;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes.dex */
final class b {
    private static final byte[] zp = ai.bk("OpusHead");

    /* JADX INFO: renamed from: com.applovin.exoplayer2.e.g.b$b, reason: collision with other inner class name */
    private interface InterfaceC0090b {
        int iI();

        int iJ();

        int iK();
    }

    private static int ck(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static List<n> a(com.applovin.exoplayer2.e.g.a.C0089a c0089a, r rVar, long j, com.applovin.exoplayer2.d.e eVar, boolean z, boolean z2, Function<k, k> function) throws com.applovin.exoplayer2.ai {
        k kVarApply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0089a.zn.size(); i++) {
            com.applovin.exoplayer2.e.g.a.C0089a c0089a2 = c0089a.zn.get(i);
            if (c0089a2.bs == 1953653099 && (kVarApply = function.apply(a(c0089a2, (com.applovin.exoplayer2.e.g.a.b) com.applovin.exoplayer2.l.a.checkNotNull(c0089a.ci(1836476516)), j, eVar, z, z2))) != null) {
                arrayList.add(a(kVarApply, (com.applovin.exoplayer2.e.g.a.C0089a) com.applovin.exoplayer2.l.a.checkNotNull(((com.applovin.exoplayer2.e.g.a.C0089a) com.applovin.exoplayer2.l.a.checkNotNull(((com.applovin.exoplayer2.e.g.a.C0089a) com.applovin.exoplayer2.l.a.checkNotNull(c0089a2.cj(1835297121))).cj(1835626086))).cj(1937007212)), rVar));
            }
        }
        return arrayList;
    }

    public static Pair<com.applovin.exoplayer2.g.a, com.applovin.exoplayer2.g.a> b(com.applovin.exoplayer2.e.g.a.b bVar) {
        y yVar = bVar.zo;
        yVar.fx(8);
        com.applovin.exoplayer2.g.a aVarG = null;
        com.applovin.exoplayer2.g.a aVarI = null;
        while (yVar.pj() >= 8) {
            int iIl = yVar.il();
            int iPx = yVar.px();
            int iPx2 = yVar.px();
            if (iPx2 == 1835365473) {
                yVar.fx(iIl);
                aVarG = g(yVar, iIl + iPx);
            } else if (iPx2 == 1936553057) {
                yVar.fx(iIl);
                aVarI = i(yVar, iIl + iPx);
            }
            yVar.fx(iIl + iPx);
        }
        return Pair.create(aVarG, aVarI);
    }

    public static com.applovin.exoplayer2.g.a b(com.applovin.exoplayer2.e.g.a.C0089a c0089a) {
        com.applovin.exoplayer2.e.g.a.b bVarCi = c0089a.ci(1751411826);
        com.applovin.exoplayer2.e.g.a.b bVarCi2 = c0089a.ci(1801812339);
        com.applovin.exoplayer2.e.g.a.b bVarCi3 = c0089a.ci(1768715124);
        if (bVarCi == null || bVarCi2 == null || bVarCi3 == null || s(bVarCi.zo) != 1835299937) {
            return null;
        }
        y yVar = bVarCi2.zo;
        yVar.fx(12);
        int iPx = yVar.px();
        String[] strArr = new String[iPx];
        for (int i = 0; i < iPx; i++) {
            int iPx2 = yVar.px();
            yVar.fz(4);
            strArr[i] = yVar.fB(iPx2 - 8);
        }
        y yVar2 = bVarCi3.zo;
        yVar2.fx(8);
        ArrayList arrayList = new ArrayList();
        while (yVar2.pj() > 8) {
            int iIl = yVar2.il();
            int iPx3 = yVar2.px();
            int iPx4 = yVar2.px() - 1;
            if (iPx4 >= 0 && iPx4 < iPx) {
                com.applovin.exoplayer2.g.f.a aVarA = com.applovin.exoplayer2.e.g.f.a(yVar2, iIl + iPx3, strArr[iPx4]);
                if (aVarA != null) {
                    arrayList.add(aVarA);
                }
            } else {
                q.h("AtomParsers", "Skipped metadata with unknown key index: " + iPx4);
            }
            yVar2.fx(iIl + iPx3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.applovin.exoplayer2.g.a(arrayList);
    }

    public static void p(y yVar) {
        int iIl = yVar.il();
        yVar.fz(4);
        if (yVar.px() != 1751411826) {
            iIl += 4;
        }
        yVar.fx(iIl);
    }

    private static k a(com.applovin.exoplayer2.e.g.a.C0089a c0089a, com.applovin.exoplayer2.e.g.a.b bVar, long j, com.applovin.exoplayer2.d.e eVar, boolean z, boolean z2) throws com.applovin.exoplayer2.ai {
        long[] jArr;
        long[] jArr2;
        com.applovin.exoplayer2.e.g.a.C0089a c0089aCj;
        Pair<long[], long[]> pairC;
        com.applovin.exoplayer2.e.g.a.C0089a c0089a2 = (com.applovin.exoplayer2.e.g.a.C0089a) com.applovin.exoplayer2.l.a.checkNotNull(c0089a.cj(1835297121));
        int iCk = ck(s(((com.applovin.exoplayer2.e.g.a.b) com.applovin.exoplayer2.l.a.checkNotNull(c0089a2.ci(1751411826))).zo));
        if (iCk == -1) {
            return null;
        }
        f fVarR = r(((com.applovin.exoplayer2.e.g.a.b) com.applovin.exoplayer2.l.a.checkNotNull(c0089a.ci(1953196132))).zo);
        long j2 = j == -9223372036854775807L ? fVarR.zE : j;
        long jQ = q(bVar.zo);
        long jE = j2 != -9223372036854775807L ? ai.e(j2, 1000000L, jQ) : -9223372036854775807L;
        com.applovin.exoplayer2.e.g.a.C0089a c0089a3 = (com.applovin.exoplayer2.e.g.a.C0089a) com.applovin.exoplayer2.l.a.checkNotNull(((com.applovin.exoplayer2.e.g.a.C0089a) com.applovin.exoplayer2.l.a.checkNotNull(c0089a2.cj(1835626086))).cj(1937007212));
        Pair<Long, String> pairT = t(((com.applovin.exoplayer2.e.g.a.b) com.applovin.exoplayer2.l.a.checkNotNull(c0089a2.ci(1835296868))).zo);
        c cVarA = a(((com.applovin.exoplayer2.e.g.a.b) com.applovin.exoplayer2.l.a.checkNotNull(c0089a3.ci(1937011556))).zo, fVarR.zD, fVarR.dG, (String) pairT.second, eVar, z2);
        if (z || (c0089aCj = c0089a.cj(1701082227)) == null || (pairC = c(c0089aCj)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairC.first;
            jArr2 = (long[]) pairC.second;
            jArr = jArr3;
        }
        if (cVarA.dU == null) {
            return null;
        }
        return new k(fVarR.zD, iCk, ((Long) pairT.first).longValue(), jQ, jE, cVarA.dU, cVarA.zy, cVarA.zx, cVarA.wo, jArr, jArr2);
    }

    /* JADX WARN: Code duplicated, block: B:149:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:150:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:154:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:156:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:164:0x0436  */
    /* JADX WARN: Code duplicated, block: B:165:0x0438  */
    /* JADX WARN: Code duplicated, block: B:167:0x043e  */
    /* JADX WARN: Code duplicated, block: B:172:0x045d  */
    /* JADX WARN: Code duplicated, block: B:175:0x0462  */
    /* JADX WARN: Code duplicated, block: B:176:0x0465  */
    /* JADX WARN: Code duplicated, block: B:178:0x0469  */
    /* JADX WARN: Code duplicated, block: B:179:0x046c  */
    /* JADX WARN: Code duplicated, block: B:181:0x046f  */
    /* JADX WARN: Code duplicated, block: B:182:0x0471  */
    /* JADX WARN: Code duplicated, block: B:184:0x0475  */
    /* JADX WARN: Code duplicated, block: B:185:0x0478  */
    /* JADX WARN: Code duplicated, block: B:189:0x0485  */
    /* JADX WARN: Code duplicated, block: B:191:0x0493  */
    /* JADX WARN: Code duplicated, block: B:192:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:195:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:197:0x04de  */
    /* JADX WARN: Code duplicated, block: B:199:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:200:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:217:0x04ea A[SYNTHETIC] */
    private static n a(k kVar, com.applovin.exoplayer2.e.g.a.C0089a c0089a, r rVar) throws com.applovin.exoplayer2.ai {
        InterfaceC0090b eVar;
        boolean z;
        int iPD;
        int iPD2;
        int iPD3;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        k kVar2;
        int i5;
        long[] jArr;
        int[] iArr;
        int i6;
        long j;
        long[] jArr2;
        int[] iArr2;
        int iPx;
        int i7;
        int i8;
        int i9;
        boolean z3;
        int[] iArr3;
        int[] iArr4;
        long[] jArr3;
        int i10;
        boolean z4;
        int i11;
        int i12;
        long[] jArr4;
        int[] iArr5;
        int i13;
        boolean z5;
        long[] jArr5;
        int[] iArr6;
        int i14;
        int[] iArr7;
        long[] jArr6;
        int i15;
        int i16;
        long j2;
        long j3;
        int i17;
        int i18;
        long[] jArr7;
        int i19;
        int i20;
        long j4;
        int i21;
        boolean z6;
        int i22;
        boolean z7;
        com.applovin.exoplayer2.e.g.a.b bVarCi = c0089a.ci(1937011578);
        if (bVarCi != null) {
            eVar = new d(bVarCi, kVar.dU);
        } else {
            com.applovin.exoplayer2.e.g.a.b bVarCi2 = c0089a.ci(1937013298);
            if (bVarCi2 == null) {
                throw com.applovin.exoplayer2.ai.c("Track has no sample table size information", null);
            }
            eVar = new e(bVarCi2);
        }
        int iII = eVar.iI();
        if (iII == 0) {
            return new n(kVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        com.applovin.exoplayer2.e.g.a.b bVarCi3 = c0089a.ci(1937007471);
        if (bVarCi3 == null) {
            bVarCi3 = (com.applovin.exoplayer2.e.g.a.b) com.applovin.exoplayer2.l.a.checkNotNull(c0089a.ci(1668232756));
            z = true;
        } else {
            z = false;
        }
        y yVar = bVarCi3.zo;
        y yVar2 = ((com.applovin.exoplayer2.e.g.a.b) com.applovin.exoplayer2.l.a.checkNotNull(c0089a.ci(1937011555))).zo;
        y yVar3 = ((com.applovin.exoplayer2.e.g.a.b) com.applovin.exoplayer2.l.a.checkNotNull(c0089a.ci(1937011827))).zo;
        com.applovin.exoplayer2.e.g.a.b bVarCi4 = c0089a.ci(1937011571);
        y yVar4 = bVarCi4 != null ? bVarCi4.zo : null;
        com.applovin.exoplayer2.e.g.a.b bVarCi5 = c0089a.ci(1668576371);
        y yVar5 = bVarCi5 != null ? bVarCi5.zo : null;
        a aVar = new a(yVar2, yVar, z);
        yVar3.fx(12);
        int iPD4 = yVar3.pD() - 1;
        int iPD5 = yVar3.pD();
        int iPD6 = yVar3.pD();
        if (yVar5 != null) {
            yVar5.fx(12);
            iPD = yVar5.pD();
        } else {
            iPD = 0;
        }
        if (yVar4 != null) {
            yVar4.fx(12);
            iPD3 = yVar4.pD();
            if (iPD3 > 0) {
                iPD2 = yVar4.pD() - 1;
            } else {
                iPD2 = -1;
                yVar4 = null;
            }
        } else {
            iPD2 = -1;
            iPD3 = 0;
        }
        int iIJ = eVar.iJ();
        String str = kVar.dU.dz;
        if (iIJ != -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iPD4 == 0 && iPD == 0 && iPD3 == 0) {
            long[] jArr8 = new long[aVar.fR];
            int[] iArr8 = new int[aVar.fR];
            while (aVar.iH()) {
                jArr8[aVar.Y] = aVar.zr;
                iArr8[aVar.Y] = aVar.zq;
            }
            com.applovin.exoplayer2.e.g.d.a aVarA = com.applovin.exoplayer2.e.g.d.a(iIJ, jArr8, iArr8, iPD6);
            long[] jArr9 = aVarA.tS;
            int[] iArr9 = aVarA.tR;
            int i23 = aVarA.zH;
            long[] jArr10 = aVarA.zI;
            int[] iArr10 = aVarA.zJ;
            long j5 = aVarA.zE;
            kVar2 = kVar;
            i5 = iII;
            jArr = jArr9;
            iArr = iArr9;
            i6 = i23;
            iArr2 = iArr10;
            j = j5;
            jArr2 = jArr10;
        } else {
            long[] jArrCopyOf = new long[iII];
            int[] iArrCopyOf = new int[iII];
            long[] jArrCopyOf2 = new long[iII];
            int[] iArrCopyOf2 = new int[iII];
            int iPD7 = iPD2;
            int i24 = 0;
            int i25 = 0;
            int iPx2 = 0;
            int i26 = 0;
            int iPD8 = 0;
            long j6 = 0;
            long j7 = 0;
            int i27 = iPD;
            int i28 = iPD6;
            int i29 = iPD5;
            int i30 = iPD4;
            int i31 = iPD3;
            while (true) {
                i = i30;
                if (i24 >= iII) {
                    i2 = i29;
                    i3 = i26;
                    break;
                }
                long j8 = j7;
                int i32 = i26;
                boolean zIH = true;
                while (i32 == 0) {
                    zIH = aVar.iH();
                    if (!zIH) {
                        break;
                    }
                    int i33 = i29;
                    long j9 = aVar.zr;
                    i32 = aVar.zq;
                    j8 = j9;
                    i29 = i33;
                    i28 = i28;
                    iII = iII;
                }
                int i34 = iII;
                i2 = i29;
                int i35 = i28;
                if (!zIH) {
                    q.h("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i24);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i24);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i24);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i24);
                    iII = i24;
                    i3 = i32;
                    break;
                }
                if (yVar5 != null) {
                    while (iPD8 == 0 && i27 > 0) {
                        iPD8 = yVar5.pD();
                        iPx2 = yVar5.px();
                        i27--;
                    }
                    iPD8--;
                }
                int i36 = iPx2;
                jArrCopyOf[i24] = j8;
                iArrCopyOf[i24] = eVar.iK();
                if (iArrCopyOf[i24] > i25) {
                    i25 = iArrCopyOf[i24];
                }
                jArrCopyOf2[i24] = j6 + ((long) i36);
                iArrCopyOf2[i24] = yVar4 == null ? 1 : 0;
                if (i24 == iPD7) {
                    iArrCopyOf2[i24] = 1;
                    i31--;
                    if (i31 > 0) {
                        iPD7 = ((y) com.applovin.exoplayer2.l.a.checkNotNull(yVar4)).pD() - 1;
                    }
                }
                int i37 = iPD7;
                j6 += (long) i35;
                int iPD9 = i2 - 1;
                if (iPD9 != 0 || i <= 0) {
                    iPx = i35;
                    i7 = i;
                } else {
                    iPD9 = yVar3.pD();
                    iPx = yVar3.px();
                    i7 = i - 1;
                }
                int i38 = iPD9;
                long j10 = j8 + ((long) iArrCopyOf[i24]);
                i26 = i32 - 1;
                i24++;
                j7 = j10;
                iPD7 = i37;
                i28 = iPx;
                iII = i34;
                iPx2 = i36;
                i30 = i7;
                i29 = i38;
            }
            long j11 = j6 + ((long) iPx2);
            if (yVar5 == null) {
                z2 = true;
                break;
            }
            while (true) {
                if (i27 <= 0) {
                    z2 = true;
                    break;
                }
                if (yVar5.pD() != 0) {
                    z2 = false;
                    break;
                }
                yVar5.px();
                i27--;
            }
            if (i31 == 0 && i2 == 0 && i3 == 0 && i == 0) {
                i4 = iPD8;
                if (i4 == 0 && z2) {
                    kVar2 = kVar;
                }
                i5 = iII;
                jArr = jArrCopyOf;
                iArr = iArrCopyOf;
                i6 = i25;
                j = j11;
                jArr2 = jArrCopyOf2;
                iArr2 = iArrCopyOf2;
            } else {
                i4 = iPD8;
            }
            kVar2 = kVar;
            q.h("AtomParsers", "Inconsistent stbl box for track " + kVar2.zD + ": remainingSynchronizationSamples " + i31 + ", remainingSamplesAtTimestampDelta " + i2 + ", remainingSamplesInChunk " + i3 + ", remainingTimestampDeltaChanges " + i + ", remainingSamplesAtTimestampOffset " + i4 + (!z2 ? ", ctts invalid" : ""));
            i5 = iII;
            jArr = jArrCopyOf;
            iArr = iArrCopyOf;
            i6 = i25;
            j = j11;
            jArr2 = jArrCopyOf2;
            iArr2 = iArrCopyOf2;
        }
        long jE = ai.e(j, 1000000L, kVar2.AP);
        if (kVar2.AS == null) {
            ai.a(jArr2, 1000000L, kVar2.AP);
            return new n(kVar, jArr, iArr, i6, jArr2, iArr2, jE);
        }
        if (kVar2.AS.length == 1 && kVar2.bs == 1 && jArr2.length >= 2) {
            long j12 = ((long[]) com.applovin.exoplayer2.l.a.checkNotNull(kVar2.AT))[0];
            long jE2 = j12 + ai.e(kVar2.AS[0], kVar2.AP, kVar2.AQ);
            i8 = i5;
            if (a(jArr2, j, j12, jE2)) {
                long jE3 = ai.e(j12 - jArr2[0], kVar2.dU.dM, kVar2.AP);
                i9 = i6;
                long jE4 = ai.e(j - jE2, kVar2.dU.dM, kVar2.AP);
                if ((jE3 != 0 || jE4 != 0) && jE3 <= 2147483647L && jE4 <= 2147483647L) {
                    rVar.dO = (int) jE3;
                    rVar.dP = (int) jE4;
                    ai.a(jArr2, 1000000L, kVar2.AP);
                    return new n(kVar, jArr, iArr, i9, jArr2, iArr2, ai.e(kVar2.AS[0], 1000000L, kVar2.AQ));
                }
            }
            if (kVar2.AS.length != 1 && kVar2.AS[0] == 0) {
                long j13 = ((long[]) com.applovin.exoplayer2.l.a.checkNotNull(kVar2.AT))[0];
                for (int i39 = 0; i39 < jArr2.length; i39++) {
                    jArr2[i39] = ai.e(jArr2[i39] - j13, 1000000L, kVar2.AP);
                }
                return new n(kVar, jArr, iArr, i9, jArr2, iArr2, ai.e(j - j13, 1000000L, kVar2.AP));
            }
            if (kVar2.bs == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            iArr3 = new int[kVar2.AS.length];
            iArr4 = new int[kVar2.AS.length];
            jArr3 = (long[]) com.applovin.exoplayer2.l.a.checkNotNull(kVar2.AT);
            i10 = 0;
            z4 = false;
            i11 = 0;
            i12 = 0;
            while (i10 < kVar2.AS.length) {
                long[] jArr11 = jArr;
                int[] iArr11 = iArr;
                j4 = jArr3[i10];
                if (j4 != -1) {
                    i22 = i12;
                    boolean z8 = z4;
                    int i40 = i11;
                    long jE5 = ai.e(kVar2.AS[i10], kVar2.AP, kVar2.AQ);
                    iArr3[i10] = ai.a(jArr2, j4, true, true);
                    iArr4[i10] = ai.b(jArr2, j4 + jE5, z3, false);
                    while (iArr3[i10] < iArr4[i10] && (iArr2[iArr3[i10]] & 1) == 0) {
                        iArr3[i10] = iArr3[i10] + 1;
                    }
                    i11 = i40 + (iArr4[i10] - iArr3[i10]);
                    if (i22 != iArr3[i10]) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z6 = z8 | z7;
                    i21 = iArr4[i10];
                } else {
                    i21 = i12;
                    z6 = z4;
                }
                i10++;
                z4 = z6;
                i12 = i21;
                iArr = iArr11;
                jArr = jArr11;
            }
            jArr4 = jArr;
            iArr5 = iArr;
            boolean z9 = z4;
            i13 = 0;
            z5 = z9 | (i11 != i8);
            if (z5) {
                jArr5 = new long[i11];
            } else {
                jArr5 = jArr4;
            }
            if (z5) {
                iArr6 = new int[i11];
            } else {
                iArr6 = iArr5;
            }
            if (z5) {
                i14 = 0;
            } else {
                i14 = i9;
            }
            if (z5) {
                iArr7 = new int[i11];
            } else {
                iArr7 = iArr2;
            }
            jArr6 = new long[i11];
            i15 = i14;
            i16 = 0;
            j2 = 0;
            while (i13 < kVar2.AS.length) {
                j3 = kVar2.AT[i13];
                i17 = iArr3[i13];
                int[] iArr12 = iArr3;
                i18 = iArr4[i13];
                int[] iArr13 = iArr4;
                if (z5) {
                    int i41 = i18 - i17;
                    jArr7 = jArr4;
                    System.arraycopy(jArr7, i17, jArr5, i16, i41);
                    System.arraycopy(iArr5, i17, iArr6, i16, i41);
                    System.arraycopy(iArr2, i17, iArr7, i16, i41);
                } else {
                    jArr7 = jArr4;
                }
                i19 = i15;
                while (i17 < i18) {
                    int i42 = i18;
                    i20 = i19;
                    long[] jArr12 = jArr2;
                    int[] iArr14 = iArr2;
                    int[] iArr15 = iArr7;
                    long j14 = j2;
                    jArr6[i16] = ai.e(j2, 1000000L, kVar2.AQ) + ai.e(Math.max(0L, jArr2[i17] - j3), 1000000L, kVar2.AP);
                    if (z5) {
                        i19 = i20;
                        if (iArr6[i16] > i19) {
                            i19 = iArr5[i17];
                        }
                    } else {
                        i19 = i20;
                    }
                    i16++;
                    i17++;
                    i18 = i42;
                    j2 = j14;
                    jArr2 = jArr12;
                    iArr2 = iArr14;
                    iArr7 = iArr15;
                }
                i15 = i19;
                jArr4 = jArr7;
                j2 += kVar2.AS[i13];
                jArr2 = jArr2;
                iArr2 = iArr2;
                iArr4 = iArr13;
                iArr7 = iArr7;
                i13++;
                iArr3 = iArr12;
            }
            return new n(kVar, jArr5, iArr6, i15, jArr6, iArr7, ai.e(j2, 1000000L, kVar2.AQ));
        }
        i8 = i5;
        i9 = i6;
        if (kVar2.AS.length != 1) {
        }
        if (kVar2.bs == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        iArr3 = new int[kVar2.AS.length];
        iArr4 = new int[kVar2.AS.length];
        jArr3 = (long[]) com.applovin.exoplayer2.l.a.checkNotNull(kVar2.AT);
        i10 = 0;
        z4 = false;
        i11 = 0;
        i12 = 0;
        while (i10 < kVar2.AS.length) {
            long[] jArr13 = jArr;
            int[] iArr16 = iArr;
            j4 = jArr3[i10];
            if (j4 != -1) {
                i22 = i12;
                boolean z10 = z4;
                int i43 = i11;
                long jE6 = ai.e(kVar2.AS[i10], kVar2.AP, kVar2.AQ);
                iArr3[i10] = ai.a(jArr2, j4, true, true);
                iArr4[i10] = ai.b(jArr2, j4 + jE6, z3, false);
                while (iArr3[i10] < iArr4[i10]) {
                    iArr3[i10] = iArr3[i10] + 1;
                }
                i11 = i43 + (iArr4[i10] - iArr3[i10]);
                if (i22 != iArr3[i10]) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z6 = z10 | z7;
                i21 = iArr4[i10];
            } else {
                i21 = i12;
                z6 = z4;
            }
            i10++;
            z4 = z6;
            i12 = i21;
            iArr = iArr16;
            jArr = jArr13;
        }
        jArr4 = jArr;
        iArr5 = iArr;
        boolean z11 = z4;
        i13 = 0;
        z5 = z11 | (i11 != i8);
        if (z5) {
            jArr5 = new long[i11];
        } else {
            jArr5 = jArr4;
        }
        if (z5) {
            iArr6 = new int[i11];
        } else {
            iArr6 = iArr5;
        }
        if (z5) {
            i14 = 0;
        } else {
            i14 = i9;
        }
        if (z5) {
            iArr7 = new int[i11];
        } else {
            iArr7 = iArr2;
        }
        jArr6 = new long[i11];
        i15 = i14;
        i16 = 0;
        j2 = 0;
        while (i13 < kVar2.AS.length) {
            j3 = kVar2.AT[i13];
            i17 = iArr3[i13];
            int[] iArr17 = iArr3;
            i18 = iArr4[i13];
            int[] iArr18 = iArr4;
            if (z5) {
                int i44 = i18 - i17;
                jArr7 = jArr4;
                System.arraycopy(jArr7, i17, jArr5, i16, i44);
                System.arraycopy(iArr5, i17, iArr6, i16, i44);
                System.arraycopy(iArr2, i17, iArr7, i16, i44);
            } else {
                jArr7 = jArr4;
            }
            i19 = i15;
            while (i17 < i18) {
                int i45 = i18;
                i20 = i19;
                long[] jArr14 = jArr2;
                int[] iArr19 = iArr2;
                int[] iArr110 = iArr7;
                long j15 = j2;
                jArr6[i16] = ai.e(j2, 1000000L, kVar2.AQ) + ai.e(Math.max(0L, jArr2[i17] - j3), 1000000L, kVar2.AP);
                if (z5) {
                    i19 = i20;
                    if (iArr6[i16] > i19) {
                        i19 = iArr5[i17];
                    }
                } else {
                    i19 = i20;
                }
                i16++;
                i17++;
                i18 = i45;
                j2 = j15;
                jArr2 = jArr14;
                iArr2 = iArr19;
                iArr7 = iArr110;
            }
            i15 = i19;
            jArr4 = jArr7;
            j2 += kVar2.AS[i13];
            jArr2 = jArr2;
            iArr2 = iArr2;
            iArr4 = iArr18;
            iArr7 = iArr7;
            i13++;
            iArr3 = iArr17;
        }
        return new n(kVar, jArr5, iArr6, i15, jArr6, iArr7, ai.e(j2, 1000000L, kVar2.AQ));
    }

    private static com.applovin.exoplayer2.g.a g(y yVar, int i) {
        yVar.fz(8);
        p(yVar);
        while (yVar.il() < i) {
            int iIl = yVar.il();
            int iPx = yVar.px();
            if (yVar.px() == 1768715124) {
                yVar.fx(iIl);
                return h(yVar, iIl + iPx);
            }
            yVar.fx(iIl + iPx);
        }
        return null;
    }

    private static com.applovin.exoplayer2.g.a h(y yVar, int i) {
        yVar.fz(8);
        ArrayList arrayList = new ArrayList();
        while (yVar.il() < i) {
            com.applovin.exoplayer2.g.a.InterfaceC0095a interfaceC0095aZ = com.applovin.exoplayer2.e.g.f.z(yVar);
            if (interfaceC0095aZ != null) {
                arrayList.add(interfaceC0095aZ);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.applovin.exoplayer2.g.a(arrayList);
    }

    private static com.applovin.exoplayer2.g.a i(y yVar, int i) {
        yVar.fz(12);
        while (yVar.il() < i) {
            int iIl = yVar.il();
            int iPx = yVar.px();
            if (yVar.px() == 1935766900) {
                if (iPx < 14) {
                    return null;
                }
                yVar.fz(5);
                int iPo = yVar.po();
                if (iPo != 12 && iPo != 13) {
                    return null;
                }
                float f2 = iPo == 12 ? 240.0f : 120.0f;
                yVar.fz(1);
                return new com.applovin.exoplayer2.g.a(new com.applovin.exoplayer2.g.f.d(f2, yVar.po()));
            }
            yVar.fx(iIl + iPx);
        }
        return null;
    }

    private static long q(y yVar) {
        yVar.fx(8);
        yVar.fz(com.applovin.exoplayer2.e.g.a.cf(yVar.px()) != 0 ? 16 : 8);
        return yVar.pv();
    }

    private static f r(y yVar) {
        boolean z;
        yVar.fx(8);
        int iCf = com.applovin.exoplayer2.e.g.a.cf(yVar.px());
        yVar.fz(iCf == 0 ? 8 : 16);
        int iPx = yVar.px();
        yVar.fz(4);
        int iIl = yVar.il();
        int i = iCf == 0 ? 4 : 8;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            }
            if (yVar.hO()[iIl + i3] != -1) {
                z = false;
                break;
            }
            i3++;
        }
        long j = -9223372036854775807L;
        if (z) {
            yVar.fz(i);
        } else {
            long jPv = iCf == 0 ? yVar.pv() : yVar.pF();
            if (jPv != 0) {
                j = jPv;
            }
        }
        yVar.fz(16);
        int iPx2 = yVar.px();
        int iPx3 = yVar.px();
        yVar.fz(4);
        int iPx4 = yVar.px();
        int iPx5 = yVar.px();
        if (iPx2 == 0 && iPx3 == 65536 && iPx4 == -65536 && iPx5 == 0) {
            i2 = 90;
        } else if (iPx2 == 0 && iPx3 == -65536 && iPx4 == 65536 && iPx5 == 0) {
            i2 = 270;
        } else if (iPx2 == -65536 && iPx3 == 0 && iPx4 == 0 && iPx5 == -65536) {
            i2 = 180;
        }
        return new f(iPx, j, i2);
    }

    private static int s(y yVar) {
        yVar.fx(16);
        return yVar.px();
    }

    private static Pair<Long, String> t(y yVar) {
        yVar.fx(8);
        int iCf = com.applovin.exoplayer2.e.g.a.cf(yVar.px());
        yVar.fz(iCf == 0 ? 8 : 16);
        long jPv = yVar.pv();
        yVar.fz(iCf == 0 ? 4 : 8);
        int iPp = yVar.pp();
        return Pair.create(Long.valueOf(jPv), "" + ((char) (((iPp >> 10) & 31) + 96)) + ((char) (((iPp >> 5) & 31) + 96)) + ((char) ((iPp & 31) + 96)));
    }

    private static c a(y yVar, int i, int i2, String str, com.applovin.exoplayer2.d.e eVar, boolean z) throws com.applovin.exoplayer2.ai {
        int i3;
        yVar.fx(12);
        int iPx = yVar.px();
        c cVar = new c(iPx);
        for (int i4 = 0; i4 < iPx; i4++) {
            int iIl = yVar.il();
            int iPx2 = yVar.px();
            com.applovin.exoplayer2.e.k.a(iPx2 > 0, "childAtomSize must be positive");
            int iPx3 = yVar.px();
            if (iPx3 == 1635148593 || iPx3 == 1635148595 || iPx3 == 1701733238 || iPx3 == 1831958048 || iPx3 == 1836070006 || iPx3 == 1752589105 || iPx3 == 1751479857 || iPx3 == 1932670515 || iPx3 == 1211250227 || iPx3 == 1987063864 || iPx3 == 1987063865 || iPx3 == 1635135537 || iPx3 == 1685479798 || iPx3 == 1685479729 || iPx3 == 1685481573 || iPx3 == 1685481521) {
                i3 = iIl;
                a(yVar, iPx3, i3, iPx2, i, i2, eVar, cVar, i4);
            } else if (iPx3 == 1836069985 || iPx3 == 1701733217 || iPx3 == 1633889587 || iPx3 == 1700998451 || iPx3 == 1633889588 || iPx3 == 1685353315 || iPx3 == 1685353317 || iPx3 == 1685353320 || iPx3 == 1685353324 || iPx3 == 1685353336 || iPx3 == 1935764850 || iPx3 == 1935767394 || iPx3 == 1819304813 || iPx3 == 1936684916 || iPx3 == 1953984371 || iPx3 == 778924082 || iPx3 == 778924083 || iPx3 == 1835557169 || iPx3 == 1835560241 || iPx3 == 1634492771 || iPx3 == 1634492791 || iPx3 == 1970037111 || iPx3 == 1332770163 || iPx3 == 1716281667) {
                i3 = iIl;
                a(yVar, iPx3, iIl, iPx2, i, str, z, eVar, cVar, i4);
            } else {
                if (iPx3 == 1414810956 || iPx3 == 1954034535 || iPx3 == 2004251764 || iPx3 == 1937010800 || iPx3 == 1664495672) {
                    a(yVar, iPx3, iIl, iPx2, i, str, cVar);
                } else if (iPx3 == 1835365492) {
                    a(yVar, iPx3, iIl, i, cVar);
                } else if (iPx3 == 1667329389) {
                    cVar.dU = new v.a().D(i).m("application/x-camera-motion").bT();
                }
                i3 = iIl;
            }
            yVar.fx(i3 + iPx2);
        }
        return cVar;
    }

    private static void a(y yVar, int i, int i2, int i3, int i4, String str, c cVar) {
        yVar.fx(i2 + 8 + 8);
        String str2 = "application/ttml+xml";
        s sVarU = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = (i3 - 8) - 8;
                byte[] bArr = new byte[i5];
                yVar.r(bArr, 0, i5);
                sVarU = s.u(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                cVar.zy = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        cVar.dU = new v.a().D(i4).m(str2).j(str).p(j).c(sVarU).bT();
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0197 A[PHI: r3
      0x0197: PHI (r3v35 int) = (r3v34 int), (r3v36 int) binds: [B:102:0x018b, B:105:0x0190] A[DONT_GENERATE, DONT_INLINE]] */
    private static void a(y yVar, int i, int i2, int i3, int i4, int i5, com.applovin.exoplayer2.d.e eVar, c cVar, int i6) throws com.applovin.exoplayer2.ai {
        String str;
        com.applovin.exoplayer2.d.e eVar2;
        String str2;
        y yVar2 = yVar;
        int i7 = i2;
        int i8 = i3;
        com.applovin.exoplayer2.d.e eVarB = eVar;
        yVar2.fx(i7 + 8 + 8);
        yVar2.fz(16);
        int iPp = yVar.pp();
        int iPp2 = yVar.pp();
        yVar2.fz(50);
        int iIl = yVar.il();
        int iIntValue = i;
        if (iIntValue == 1701733238) {
            Pair<Integer, l> pairC = c(yVar2, i7, i8);
            if (pairC != null) {
                iIntValue = ((Integer) pairC.first).intValue();
                eVarB = eVarB == null ? null : eVarB.B(((l) pairC.second).tc);
                cVar.zx[i6] = (l) pairC.second;
            }
            yVar2.fx(iIl);
        }
        String str3 = "video/3gpp";
        if (iIntValue == 1831958048) {
            str = "video/mpeg";
        } else {
            str = iIntValue == 1211250227 ? "video/3gpp" : null;
        }
        int i9 = -1;
        float fJ = 1.0f;
        String str4 = null;
        List<byte[]> listU = null;
        byte[] bArrE = null;
        com.applovin.exoplayer2.m.b bVar = null;
        boolean z = false;
        while (true) {
            if (iIl - i7 >= i8) {
                eVar2 = eVarB;
                break;
            }
            yVar2.fx(iIl);
            int iIl2 = yVar.il();
            String str5 = str3;
            int iPx = yVar.px();
            if (iPx == 0) {
                eVar2 = eVarB;
                if (yVar.il() - i7 == i8) {
                    break;
                }
            } else {
                eVar2 = eVarB;
            }
            com.applovin.exoplayer2.e.k.a(iPx > 0, "childAtomSize must be positive");
            int iPx2 = yVar.px();
            if (iPx2 == 1635148611) {
                com.applovin.exoplayer2.e.k.a(str == null, (String) null);
                yVar2.fx(iIl2 + 8);
                com.applovin.exoplayer2.m.a aVarAs = com.applovin.exoplayer2.m.a.as(yVar);
                listU = aVarAs.dB;
                cVar.wo = aVarAs.wo;
                if (!z) {
                    fJ = aVarAs.acy;
                }
                str4 = aVarAs.dw;
                str2 = "video/avc";
            } else if (iPx2 == 1752589123) {
                com.applovin.exoplayer2.e.k.a(str == null, (String) null);
                yVar2.fx(iIl2 + 8);
                com.applovin.exoplayer2.m.f fVarAv = com.applovin.exoplayer2.m.f.av(yVar);
                listU = fVarAv.dB;
                cVar.wo = fVarAv.wo;
                str4 = fVarAv.dw;
                str2 = "video/hevc";
            } else {
                if (iPx2 == 1685480259 || iPx2 == 1685485123) {
                    com.applovin.exoplayer2.m.c cVarAu = com.applovin.exoplayer2.m.c.au(yVar);
                    if (cVarAu != null) {
                        str4 = cVarAu.dw;
                        str = "video/dolby-vision";
                    }
                } else if (iPx2 == 1987076931) {
                    com.applovin.exoplayer2.e.k.a(str == null, (String) null);
                    str2 = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (iPx2 == 1635135811) {
                    com.applovin.exoplayer2.e.k.a(str == null, (String) null);
                    str = MimeTypes.VIDEO_AV1;
                } else if (iPx2 == 1681012275) {
                    com.applovin.exoplayer2.e.k.a(str == null, (String) null);
                    str = str5;
                } else if (iPx2 == 1702061171) {
                    com.applovin.exoplayer2.e.k.a(str == null, (String) null);
                    Pair<String, byte[]> pairK = k(yVar2, iIl2);
                    String str6 = (String) pairK.first;
                    byte[] bArr = (byte[]) pairK.second;
                    if (bArr != null) {
                        listU = s.u(bArr);
                    }
                    str = str6;
                } else if (iPx2 == 1885434736) {
                    fJ = j(yVar2, iIl2);
                    z = true;
                } else if (iPx2 == 1937126244) {
                    bArrE = e(yVar2, iIl2, iPx);
                } else if (iPx2 == 1936995172) {
                    int iPo = yVar.po();
                    yVar2.fz(3);
                    if (iPo == 0) {
                        int iPo2 = yVar.po();
                        if (iPo2 != 0) {
                            int i10 = 1;
                            if (iPo2 == 1) {
                                i9 = i10;
                            } else if (iPo2 != 2) {
                                i10 = 3;
                                if (iPo2 == 3) {
                                    i9 = i10;
                                }
                            } else {
                                i9 = 2;
                            }
                        } else {
                            i9 = 0;
                        }
                    }
                } else if (iPx2 == 1668246642) {
                    int iPx3 = yVar.px();
                    boolean z2 = iPx3 == 1852009592;
                    if (z2 || iPx3 == 1852009571) {
                        int iPp3 = yVar.pp();
                        int iPp4 = yVar.pp();
                        yVar2.fz(2);
                        bVar = new com.applovin.exoplayer2.m.b(com.applovin.exoplayer2.m.b.fN(iPp3), z2 && (yVar.po() & 128) != 0 ? 1 : 2, com.applovin.exoplayer2.m.b.fO(iPp4), null);
                    } else {
                        q.h("AtomParsers", "Unsupported color type: " + com.applovin.exoplayer2.e.g.a.ch(iPx3));
                    }
                }
                iIl += iPx;
                yVar2 = yVar;
                i7 = i2;
                i8 = i3;
                str3 = str5;
                eVarB = eVar2;
            }
            str = str2;
            iIl += iPx;
            yVar2 = yVar;
            i7 = i2;
            i8 = i3;
            str3 = str5;
            eVarB = eVar2;
        }
        if (str == null) {
            return;
        }
        cVar.dU = new v.a().D(i4).m(str).k(str4).J(iPp).K(iPp2).e(fJ).L(i5).a(bArrE).M(i9).c(listU).a(eVar2).a(bVar).bT();
    }

    private static void a(y yVar, int i, int i2, int i3, c cVar) {
        yVar.fx(i2 + 8 + 8);
        if (i == 1835365492) {
            yVar.pI();
            String strPI = yVar.pI();
            if (strPI != null) {
                cVar.dU = new v.a().D(i3).m(strPI).bT();
            }
        }
    }

    private static Pair<long[], long[]> c(com.applovin.exoplayer2.e.g.a.C0089a c0089a) {
        com.applovin.exoplayer2.e.g.a.b bVarCi = c0089a.ci(1701606260);
        if (bVarCi == null) {
            return null;
        }
        y yVar = bVarCi.zo;
        yVar.fx(8);
        int iCf = com.applovin.exoplayer2.e.g.a.cf(yVar.px());
        int iPD = yVar.pD();
        long[] jArr = new long[iPD];
        long[] jArr2 = new long[iPD];
        for (int i = 0; i < iPD; i++) {
            jArr[i] = iCf == 1 ? yVar.pF() : yVar.pv();
            jArr2[i] = iCf == 1 ? yVar.pz() : yVar.px();
            if (yVar.pr() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            yVar.fz(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float j(y yVar, int i) {
        yVar.fx(i + 8);
        return yVar.pD() / yVar.pD();
    }

    /* JADX WARN: Code duplicated, block: B:102:0x015a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0169  */
    /* JADX WARN: Code duplicated, block: B:108:0x0184  */
    /* JADX WARN: Code duplicated, block: B:138:0x028c  */
    /* JADX WARN: Code duplicated, block: B:140:0x0296  */
    /* JADX WARN: Code duplicated, block: B:141:0x0298  */
    /* JADX WARN: Code duplicated, block: B:144:0x029f  */
    /* JADX WARN: Code duplicated, block: B:146:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:148:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:161:0x02c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x02c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0150  */
    private static void a(y yVar, int i, int i2, int i3, int i4, String str, boolean z, com.applovin.exoplayer2.d.e eVar, c cVar, int i5) throws com.applovin.exoplayer2.ai {
        int iPp;
        int iPB;
        int iPD;
        com.applovin.exoplayer2.d.e eVarB;
        int i6;
        String str2;
        String str3;
        List<byte[]> listU;
        int iPx;
        int iPx2;
        int iB;
        byte[] bArr;
        boolean z2;
        List<byte[]> listJ;
        int i7 = i2;
        int i8 = i3;
        yVar.fx(i7 + 8 + 8);
        if (z) {
            iPp = yVar.pp();
            yVar.fz(6);
        } else {
            yVar.fz(8);
            iPp = 0;
        }
        boolean z3 = true;
        if (iPp == 0 || iPp == 1) {
            int iPp2 = yVar.pp();
            yVar.fz(6);
            iPB = yVar.pB();
            if (iPp == 1) {
                yVar.fz(16);
            }
            iPD = iPp2;
        } else {
            if (iPp != 2) {
                return;
            }
            yVar.fz(16);
            iPB = (int) Math.round(yVar.pH());
            iPD = yVar.pD();
            yVar.fz(20);
        }
        int iIl = yVar.il();
        int iIntValue = i;
        if (iIntValue == 1701733217) {
            Pair<Integer, l> pairC = c(yVar, i7, i8);
            if (pairC != null) {
                iIntValue = ((Integer) pairC.first).intValue();
                eVarB = eVar == null ? null : eVar.B(((l) pairC.second).tc);
                cVar.zx[i5] = (l) pairC.second;
            } else {
                eVarB = eVar;
            }
            yVar.fx(iIl);
        } else {
            eVarB = eVar;
        }
        String str4 = "audio/raw";
        if (iIntValue == 1633889587) {
            str4 = "audio/ac3";
        } else if (iIntValue == 1700998451) {
            str4 = "audio/eac3";
        } else if (iIntValue == 1633889588) {
            str4 = "audio/ac4";
        } else if (iIntValue == 1685353315) {
            str4 = "audio/vnd.dts";
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str4 = "audio/vnd.dts.hd";
        } else if (iIntValue == 1685353317) {
            str4 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue == 1685353336) {
            str4 = "audio/vnd.dts.uhd;profile=p2";
        } else if (iIntValue == 1935764850) {
            str4 = "audio/3gpp";
        } else {
            if (iIntValue != 1935767394) {
                if (iIntValue == 1819304813 || iIntValue == 1936684916) {
                    i6 = 2;
                } else if (iIntValue == 1953984371) {
                    i6 = 268435456;
                } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                    str4 = "audio/mpeg";
                } else if (iIntValue == 1835557169) {
                    str4 = "audio/mha1";
                } else if (iIntValue == 1835560241) {
                    str4 = "audio/mhm1";
                } else if (iIntValue == 1634492771) {
                    str4 = "audio/alac";
                } else if (iIntValue == 1634492791) {
                    str4 = "audio/g711-alaw";
                } else if (iIntValue == 1970037111) {
                    str4 = "audio/g711-mlaw";
                } else if (iIntValue == 1332770163) {
                    str4 = "audio/opus";
                } else if (iIntValue == 1716281667) {
                    str4 = "audio/flac";
                } else {
                    i6 = -1;
                    str4 = null;
                }
                str2 = str4;
                str3 = null;
                listU = null;
                while (iIl - i7 < i8) {
                    yVar.fx(iIl);
                    iPx = yVar.px();
                    if (iPx <= 0) {
                        z3 = false;
                    }
                    com.applovin.exoplayer2.e.k.a(z3, "childAtomSize must be positive");
                    iPx2 = yVar.px();
                    if (iPx2 == 1835557187) {
                        int i9 = iPx - 13;
                        byte[] bArr2 = new byte[i9];
                        yVar.fx(iIl + 13);
                        yVar.r(bArr2, 0, i9);
                        listJ = s.u(bArr2);
                    } else {
                        if (iPx2 != 1702061171 || (z && iPx2 == 2002876005)) {
                            z3 = true;
                            if (iPx2 == 1702061171) {
                                iB = iIl;
                            } else {
                                iB = b(yVar, iIl, iPx);
                            }
                            if (iB != -1) {
                                Pair<String, byte[]> pairK = k(yVar, iB);
                                str2 = (String) pairK.first;
                                bArr = (byte[]) pairK.second;
                                if (bArr != null) {
                                    if ("audio/mp4a-latm".equals(str2)) {
                                        com.applovin.exoplayer2.b.a.C0076a c0076aB = com.applovin.exoplayer2.b.a.b(bArr);
                                        iPB = c0076aB.js;
                                        iPD = c0076aB.dL;
                                        str3 = c0076aB.dw;
                                    }
                                    listU = s.u(bArr);
                                }
                            }
                        } else {
                            if (iPx2 == 1684103987) {
                                yVar.fx(iIl + 8);
                                cVar.dU = com.applovin.exoplayer2.b.b.a(yVar, Integer.toString(i4), str, eVarB);
                            } else if (iPx2 == 1684366131) {
                                yVar.fx(iIl + 8);
                                cVar.dU = com.applovin.exoplayer2.b.b.b(yVar, Integer.toString(i4), str, eVarB);
                            } else if (iPx2 == 1684103988) {
                                yVar.fx(iIl + 8);
                                cVar.dU = com.applovin.exoplayer2.b.c.c(yVar, Integer.toString(i4), str, eVarB);
                            } else if (iPx2 == 1684305011) {
                                cVar.dU = new v.a().D(i4).m(str2).N(iPD).O(iPB).a(eVarB).j(str).bT();
                            } else if (iPx2 == 1682927731) {
                                int i10 = iPx - 8;
                                byte[] bArr3 = zp;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i10);
                                yVar.fx(iIl + 8);
                                yVar.r(bArrCopyOf, bArr3.length, i10);
                                listJ = com.applovin.exoplayer2.b.s.j(bArrCopyOf);
                            } else if (iPx2 == 1684425825) {
                                int i11 = iPx - 12;
                                byte[] bArr4 = new byte[i11 + 4];
                                bArr4[0] = 102;
                                z3 = true;
                                bArr4[1] = 76;
                                bArr4[2] = 97;
                                bArr4[3] = 67;
                                yVar.fx(iIl + 12);
                                yVar.r(bArr4, 4, i11);
                                listU = s.u(bArr4);
                            } else {
                                z3 = true;
                                if (iPx2 == 1634492771) {
                                    int i12 = iPx - 12;
                                    byte[] bArr5 = new byte[i12];
                                    yVar.fx(iIl + 12);
                                    yVar.r(bArr5, 0, i12);
                                    Pair<Integer, Integer> pairH = com.applovin.exoplayer2.l.e.H(bArr5);
                                    int iIntValue2 = ((Integer) pairH.first).intValue();
                                    int iIntValue3 = ((Integer) pairH.second).intValue();
                                    listU = s.u(bArr5);
                                    iPB = iIntValue2;
                                    iPD = iIntValue3;
                                } else {
                                    z2 = false;
                                }
                            }
                            z2 = false;
                            z3 = true;
                        }
                        iIl += iPx;
                        i7 = i2;
                        i8 = i3;
                    }
                    listU = listJ;
                    z3 = true;
                    iIl += iPx;
                    i7 = i2;
                    i8 = i3;
                }
                if (cVar.dU == null || str2 == null) {
                }
                cVar.dU = new v.a().D(i4).m(str2).k(str3).N(iPD).O(iPB).P(i6).c(listU).a(eVarB).j(str).bT();
                return;
            }
            str4 = "audio/amr-wb";
        }
        i6 = -1;
        str2 = str4;
        str3 = null;
        listU = null;
        while (iIl - i7 < i8) {
            yVar.fx(iIl);
            iPx = yVar.px();
            if (iPx <= 0) {
                z3 = false;
            }
            com.applovin.exoplayer2.e.k.a(z3, "childAtomSize must be positive");
            iPx2 = yVar.px();
            if (iPx2 == 1835557187) {
                int i13 = iPx - 13;
                byte[] bArr6 = new byte[i13];
                yVar.fx(iIl + 13);
                yVar.r(bArr6, 0, i13);
                listJ = s.u(bArr6);
            } else {
                if (iPx2 != 1702061171) {
                    z3 = true;
                    if (iPx2 == 1702061171) {
                        iB = iIl;
                    } else {
                        iB = b(yVar, iIl, iPx);
                    }
                    if (iB != -1) {
                        Pair<String, byte[]> pairK2 = k(yVar, iB);
                        str2 = (String) pairK2.first;
                        bArr = (byte[]) pairK2.second;
                        if (bArr != null) {
                            if ("audio/mp4a-latm".equals(str2)) {
                                com.applovin.exoplayer2.b.a.C0076a c0076aB2 = com.applovin.exoplayer2.b.a.b(bArr);
                                iPB = c0076aB2.js;
                                iPD = c0076aB2.dL;
                                str3 = c0076aB2.dw;
                            }
                            listU = s.u(bArr);
                        }
                    }
                } else {
                    z3 = true;
                    if (iPx2 == 1702061171) {
                        iB = iIl;
                    } else {
                        iB = b(yVar, iIl, iPx);
                    }
                    if (iB != -1) {
                        Pair<String, byte[]> pairK3 = k(yVar, iB);
                        str2 = (String) pairK3.first;
                        bArr = (byte[]) pairK3.second;
                        if (bArr != null) {
                            if ("audio/mp4a-latm".equals(str2)) {
                                com.applovin.exoplayer2.b.a.C0076a c0076aB3 = com.applovin.exoplayer2.b.a.b(bArr);
                                iPB = c0076aB3.js;
                                iPD = c0076aB3.dL;
                                str3 = c0076aB3.dw;
                            }
                            listU = s.u(bArr);
                        }
                    }
                }
                iIl += iPx;
                i7 = i2;
                i8 = i3;
            }
            listU = listJ;
            z3 = true;
            iIl += iPx;
            i7 = i2;
            i8 = i3;
        }
        if (cVar.dU == null) {
        }
    }

    private static int b(y yVar, int i, int i2) throws com.applovin.exoplayer2.ai {
        int iIl = yVar.il();
        while (iIl - i < i2) {
            yVar.fx(iIl);
            int iPx = yVar.px();
            com.applovin.exoplayer2.e.k.a(iPx > 0, "childAtomSize must be positive");
            if (yVar.px() == 1702061171) {
                return iIl;
            }
            iIl += iPx;
        }
        return -1;
    }

    private static Pair<String, byte[]> k(y yVar, int i) {
        yVar.fx(i + 8 + 4);
        yVar.fz(1);
        u(yVar);
        yVar.fz(2);
        int iPo = yVar.po();
        if ((iPo & 128) != 0) {
            yVar.fz(2);
        }
        if ((iPo & 64) != 0) {
            yVar.fz(yVar.pp());
        }
        if ((iPo & 32) != 0) {
            yVar.fz(2);
        }
        yVar.fz(1);
        u(yVar);
        String strFv = u.fv(yVar.po());
        if ("audio/mpeg".equals(strFv) || "audio/vnd.dts".equals(strFv) || "audio/vnd.dts.hd".equals(strFv)) {
            return Pair.create(strFv, null);
        }
        yVar.fz(12);
        yVar.fz(1);
        int iU = u(yVar);
        byte[] bArr = new byte[iU];
        yVar.r(bArr, 0, iU);
        return Pair.create(strFv, bArr);
    }

    private static Pair<Integer, l> c(y yVar, int i, int i2) throws com.applovin.exoplayer2.ai {
        Pair<Integer, l> pairD;
        int iIl = yVar.il();
        while (iIl - i < i2) {
            yVar.fx(iIl);
            int iPx = yVar.px();
            com.applovin.exoplayer2.e.k.a(iPx > 0, "childAtomSize must be positive");
            if (yVar.px() == 1936289382 && (pairD = d(yVar, iIl, iPx)) != null) {
                return pairD;
            }
            iIl += iPx;
        }
        return null;
    }

    static Pair<Integer, l> d(y yVar, int i, int i2) throws com.applovin.exoplayer2.ai {
        int i3 = i + 8;
        int i4 = -1;
        String strFB = null;
        Integer numValueOf = null;
        int i5 = 0;
        while (i3 - i < i2) {
            yVar.fx(i3);
            int iPx = yVar.px();
            int iPx2 = yVar.px();
            if (iPx2 == 1718775137) {
                numValueOf = Integer.valueOf(yVar.px());
            } else if (iPx2 == 1935894637) {
                yVar.fz(4);
                strFB = yVar.fB(4);
            } else if (iPx2 == 1935894633) {
                i4 = i3;
                i5 = iPx;
            }
            i3 += iPx;
        }
        if (!"cenc".equals(strFB) && !"cbc1".equals(strFB) && !"cens".equals(strFB) && !"cbcs".equals(strFB)) {
            return null;
        }
        com.applovin.exoplayer2.e.k.a(numValueOf != null, "frma atom is mandatory");
        com.applovin.exoplayer2.e.k.a(i4 != -1, "schi atom is mandatory");
        l lVarA = a(yVar, i4, i5, strFB);
        com.applovin.exoplayer2.e.k.a(lVarA != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (l) ai.R(lVarA));
    }

    private static l a(y yVar, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            yVar.fx(i5);
            int iPx = yVar.px();
            if (yVar.px() == 1952804451) {
                int iCf = com.applovin.exoplayer2.e.g.a.cf(yVar.px());
                yVar.fz(1);
                if (iCf == 0) {
                    yVar.fz(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int iPo = yVar.po();
                    i3 = iPo & 15;
                    i4 = (iPo & 240) >> 4;
                }
                boolean z = yVar.po() == 1;
                int iPo2 = yVar.po();
                byte[] bArr2 = new byte[16];
                yVar.r(bArr2, 0, 16);
                if (z && iPo2 == 0) {
                    int iPo3 = yVar.po();
                    bArr = new byte[iPo3];
                    yVar.r(bArr, 0, iPo3);
                }
                return new l(z, str, iPo2, bArr2, i4, i3, bArr);
            }
            i5 += iPx;
        }
    }

    private static byte[] e(y yVar, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            yVar.fx(i3);
            int iPx = yVar.px();
            if (yVar.px() == 1886547818) {
                return Arrays.copyOfRange(yVar.hO(), i3, iPx + i3);
            }
            i3 += iPx;
        }
        return null;
    }

    private static int u(y yVar) {
        int iPo = yVar.po();
        int i = iPo & WorkQueueKt.MASK;
        while ((iPo & 128) == 128) {
            iPo = yVar.po();
            i = (i << 7) | (iPo & WorkQueueKt.MASK);
        }
        return i;
    }

    private static boolean a(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[ai.k(4, 0, length)] && jArr[ai.k(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private static final class a {
        public int Y;
        public final int fR;
        public int zq;
        public long zr;
        private final boolean zs;
        private final y zt;
        private final y zu;
        private int zv;
        private int zw;

        public a(y yVar, y yVar2, boolean z) throws com.applovin.exoplayer2.ai {
            this.zu = yVar;
            this.zt = yVar2;
            this.zs = z;
            yVar2.fx(12);
            this.fR = yVar2.pD();
            yVar.fx(12);
            this.zw = yVar.pD();
            com.applovin.exoplayer2.e.k.a(yVar.px() == 1, "first_chunk must be 1");
            this.Y = -1;
        }

        public boolean iH() {
            long jPv;
            int i = this.Y + 1;
            this.Y = i;
            if (i == this.fR) {
                return false;
            }
            if (this.zs) {
                jPv = this.zt.pF();
            } else {
                jPv = this.zt.pv();
            }
            this.zr = jPv;
            if (this.Y == this.zv) {
                this.zq = this.zu.pD();
                this.zu.fz(4);
                int i2 = this.zw - 1;
                this.zw = i2;
                this.zv = i2 > 0 ? this.zu.pD() - 1 : -1;
            }
            return true;
        }
    }

    private static final class f {
        private final int dG;
        private final int zD;
        private final long zE;

        public f(int i, long j, int i2) {
            this.zD = i;
            this.zE = j;
            this.dG = i2;
        }
    }

    private static final class c {
        public v dU;
        public int wo;
        public final l[] zx;
        public int zy = 0;

        public c(int i) {
            this.zx = new l[i];
        }
    }

    static final class d implements InterfaceC0090b {
        private final int jA;
        private final y zo;
        private final int zz;

        public d(com.applovin.exoplayer2.e.g.a.b bVar, v vVar) {
            y yVar = bVar.zo;
            this.zo = yVar;
            yVar.fx(12);
            int iPD = yVar.pD();
            if ("audio/raw".equals(vVar.dz)) {
                int iP = ai.P(vVar.dN, vVar.dL);
                if (iPD == 0 || iPD % iP != 0) {
                    q.h("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iP + ", stsz sample size: " + iPD);
                    iPD = iP;
                }
            }
            this.zz = iPD == 0 ? -1 : iPD;
            this.jA = yVar.pD();
        }

        @Override // com.applovin.exoplayer2.e.g.b.InterfaceC0090b
        public int iI() {
            return this.jA;
        }

        @Override // com.applovin.exoplayer2.e.g.b.InterfaceC0090b
        public int iJ() {
            return this.zz;
        }

        @Override // com.applovin.exoplayer2.e.g.b.InterfaceC0090b
        public int iK() {
            int i = this.zz;
            return i == -1 ? this.zo.pD() : i;
        }
    }

    static final class e implements InterfaceC0090b {
        private final int jA;
        private final int zA;
        private int zB;
        private int zC;
        private final y zo;

        @Override // com.applovin.exoplayer2.e.g.b.InterfaceC0090b
        public int iJ() {
            return -1;
        }

        public e(com.applovin.exoplayer2.e.g.a.b bVar) {
            y yVar = bVar.zo;
            this.zo = yVar;
            yVar.fx(12);
            this.zA = yVar.pD() & 255;
            this.jA = yVar.pD();
        }

        @Override // com.applovin.exoplayer2.e.g.b.InterfaceC0090b
        public int iI() {
            return this.jA;
        }

        @Override // com.applovin.exoplayer2.e.g.b.InterfaceC0090b
        public int iK() {
            int i = this.zA;
            if (i == 8) {
                return this.zo.po();
            }
            if (i == 16) {
                return this.zo.pp();
            }
            int i2 = this.zB;
            this.zB = i2 + 1;
            if (i2 % 2 == 0) {
                int iPo = this.zo.po();
                this.zC = iPo;
                return (iPo & 240) >> 4;
            }
            return this.zC & 15;
        }
    }
}
