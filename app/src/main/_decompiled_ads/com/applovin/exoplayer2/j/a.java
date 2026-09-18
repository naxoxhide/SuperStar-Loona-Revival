package com.applovin.exoplayer2.j;

import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.common.a.ad;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.h.ac;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.l.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.exoplayer2.j.b {
    private final long TO;
    private final long TP;
    private final long TQ;
    private final float TR;
    private final float TS;
    private final s<C0105a> TT;
    private float TU;
    private int TV;
    private long TW;
    private com.applovin.exoplayer2.h.b.b TX;
    private final com.applovin.exoplayer2.k.d bO;
    private final com.applovin.exoplayer2.l.d bR;
    private int tA;

    public static class b implements d.b {
        private final float TR;
        private final float TS;
        private final int Ua;
        private final int Ub;
        private final int Uc;
        private final com.applovin.exoplayer2.l.d bR;

        public b() {
            this(10000, 25000, 25000, 0.7f, 0.75f, com.applovin.exoplayer2.l.d.abJ);
        }

        public b(int i, int i2, int i3, float f, float f2, com.applovin.exoplayer2.l.d dVar) {
            this.Ua = i;
            this.Ub = i2;
            this.Uc = i3;
            this.TR = f;
            this.TS = f2;
            this.bR = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.exoplayer2.j.d.b
        public final d[] a(d.a[] aVarArr, com.applovin.exoplayer2.k.d dVar, p.a aVar, ba baVar) {
            d dVarA;
            s sVarA = a.a(aVarArr);
            d[] dVarArr = new d[aVarArr.length];
            for (int i = 0; i < aVarArr.length; i++) {
                d.a aVar2 = aVarArr[i];
                if (aVar2 != null && aVar2.Ue.length != 0) {
                    if (aVar2.Ue.length == 1) {
                        dVarA = new e(aVar2.Ud, aVar2.Ue[0], aVar2.bs);
                    } else {
                        dVarA = a(aVar2.Ud, aVar2.Ue, aVar2.bs, dVar, (s) sVarA.get(i));
                    }
                    dVarArr[i] = dVarA;
                }
            }
            return dVarArr;
        }

        protected a a(ac acVar, int[] iArr, int i, com.applovin.exoplayer2.k.d dVar, s<C0105a> sVar) {
            return new a(acVar, iArr, i, dVar, this.Ua, this.Ub, this.Uc, this.TR, this.TS, sVar, this.bR);
        }
    }

    protected a(ac acVar, int[] iArr, int i, com.applovin.exoplayer2.k.d dVar, long j, long j2, long j3, float f, float f2, List<C0105a> list, com.applovin.exoplayer2.l.d dVar2) {
        super(acVar, iArr, i);
        if (j3 < j) {
            q.h("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j3 = j;
        }
        this.bO = dVar;
        this.TO = j * 1000;
        this.TP = j2 * 1000;
        this.TQ = j3 * 1000;
        this.TR = f;
        this.TS = f2;
        this.TT = s.d(list);
        this.bR = dVar2;
        this.TU = 1.0f;
        this.tA = 0;
        this.TW = -9223372036854775807L;
    }

    @Override // com.applovin.exoplayer2.j.b, com.applovin.exoplayer2.j.d
    public void enable() {
        this.TW = -9223372036854775807L;
        this.TX = null;
    }

    @Override // com.applovin.exoplayer2.j.b, com.applovin.exoplayer2.j.d
    public void X() {
        this.TX = null;
    }

    @Override // com.applovin.exoplayer2.j.b, com.applovin.exoplayer2.j.d
    public void v(float f) {
        this.TU = f;
    }

    @Override // com.applovin.exoplayer2.j.d
    public int ne() {
        return this.TV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static s<s<C0105a>> a(d.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVarArr.length; i++) {
            if (aVarArr[i] != null && aVarArr[i].Ue.length > 1) {
                s.a aVarGc = s.gc();
                aVarGc.t(new C0105a(0L, 0L));
                arrayList.add(aVarGc);
            } else {
                arrayList.add(null);
            }
        }
        long[][] jArrB = b(aVarArr);
        int[] iArr = new int[jArrB.length];
        long[] jArr = new long[jArrB.length];
        for (int i2 = 0; i2 < jArrB.length; i2++) {
            jArr[i2] = jArrB[i2].length == 0 ? 0L : jArrB[i2][0];
        }
        a(arrayList, jArr);
        s<Integer> sVarA = a(jArrB);
        for (int i3 = 0; i3 < sVarA.size(); i3++) {
            int iIntValue = sVarA.get(i3).intValue();
            int i4 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i4;
            jArr[iIntValue] = jArrB[iIntValue][i4];
            a(arrayList, jArr);
        }
        for (int i5 = 0; i5 < aVarArr.length; i5++) {
            if (arrayList.get(i5) != null) {
                jArr[i5] = jArr[i5] * 2;
            }
        }
        a(arrayList, jArr);
        s.a aVarGc2 = s.gc();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            s.a aVar = (s.a) arrayList.get(i6);
            aVarGc2.t(aVar == null ? s.ga() : aVar.gd());
        }
        return aVarGc2.gd();
    }

    private static long[][] b(d.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i = 0; i < aVarArr.length; i++) {
            d.a aVar = aVarArr[i];
            if (aVar == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[aVar.Ue.length];
                for (int i2 = 0; i2 < aVar.Ue.length; i2++) {
                    jArr[i][i2] = aVar.Ud.dZ(aVar.Ue[i2]).dv;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    private static s<Integer> a(long[][] jArr) {
        com.applovin.exoplayer2.common.a.ac acVarGL = ad.gI().gM().gL();
        for (int i = 0; i < jArr.length; i++) {
            if (jArr[i].length > 1) {
                int length = jArr[i].length;
                double[] dArr = new double[length];
                int i2 = 0;
                while (true) {
                    double dLog = 0.0d;
                    if (i2 >= jArr[i].length) {
                        break;
                    }
                    if (jArr[i][i2] != -1) {
                        dLog = Math.log(jArr[i][i2]);
                    }
                    dArr[i2] = dLog;
                    i2++;
                }
                int i3 = length - 1;
                double d = dArr[i3] - dArr[0];
                int i4 = 0;
                while (i4 < i3) {
                    double d2 = dArr[i4];
                    i4++;
                    acVarGL.c(Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i4]) * 0.5d) - dArr[0]) / d), Integer.valueOf(i));
                }
            }
        }
        return s.d(acVarGL.values());
    }

    private static void a(List<s.a<C0105a>> list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            s.a<C0105a> aVar = list.get(i);
            if (aVar != null) {
                aVar.t(new C0105a(j, jArr[i]));
            }
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.j.a$a, reason: collision with other inner class name */
    public static final class C0105a {
        public final long TY;
        public final long TZ;

        public C0105a(long j, long j2) {
            this.TY = j;
            this.TZ = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0105a)) {
                return false;
            }
            C0105a c0105a = (C0105a) obj;
            return this.TY == c0105a.TY && this.TZ == c0105a.TZ;
        }

        public int hashCode() {
            return (((int) this.TY) * 31) + ((int) this.TZ);
        }
    }
}
