package com.applovin.exoplayer2.j;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.at;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.common.a.ai;
import com.applovin.exoplayer2.common.a.n;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.h.ac;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.applovin.exoplayer2.j.f {
    private static final int[] Ug = new int[0];
    private static final ai<Integer> Uh = ai.b(new Comparator() { // from class: com.applovin.exoplayer2.j.-$$Lambda$c$iCZ5CiGxqs-WTL2dqbiNKhIxk1g
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return c.b((Integer) obj, (Integer) obj2);
        }
    });
    private static final ai<Integer> Ui = ai.b(new Comparator() { // from class: com.applovin.exoplayer2.j.-$$Lambda$c$fV9XSeKZsRL3bCJLlJqpk07YzGk
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return c.a((Integer) obj, (Integer) obj2);
        }
    });
    private final com.applovin.exoplayer2.j.d.b Uj;
    private final AtomicReference<C0106c> Uk;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(Integer num, Integer num2) {
        return 0;
    }

    @Override // com.applovin.exoplayer2.j.j
    public boolean nh() {
        return true;
    }

    public static final class d extends i.a {
        private boolean UA;
        private boolean UB;
        private boolean UC;
        private boolean UD;
        private boolean UE;
        private boolean UF;
        private boolean UG;
        private boolean UH;
        private boolean UI;
        private final SparseArray<Map<ad, e>> UJ;
        private final SparseBooleanArray UK;
        private int Uy;
        private boolean Uz;

        @Deprecated
        public d() {
            this.UJ = new SparseArray<>();
            this.UK = new SparseBooleanArray();
            nl();
        }

        public d(Context context) {
            super(context);
            this.UJ = new SparseArray<>();
            this.UK = new SparseBooleanArray();
            nl();
        }

        private d(Bundle bundle) {
            super(bundle);
            C0106c c0106c = C0106c.Uw;
            ac(bundle.getBoolean(C0106c.t(1000), c0106c.Uz));
            ad(bundle.getBoolean(C0106c.t(1001), c0106c.UA));
            ae(bundle.getBoolean(C0106c.t(1002), c0106c.UB));
            af(bundle.getBoolean(C0106c.t(PointerIconCompat.TYPE_HELP), c0106c.UC));
            ag(bundle.getBoolean(C0106c.t(PointerIconCompat.TYPE_WAIT), c0106c.UD));
            ah(bundle.getBoolean(C0106c.t(1005), c0106c.UE));
            ai(bundle.getBoolean(C0106c.t(PointerIconCompat.TYPE_CELL), c0106c.UF));
            eR(bundle.getInt(C0106c.t(PointerIconCompat.TYPE_CROSSHAIR), c0106c.Uy));
            aj(bundle.getBoolean(C0106c.t(PointerIconCompat.TYPE_TEXT), c0106c.UG));
            ak(bundle.getBoolean(C0106c.t(PointerIconCompat.TYPE_VERTICAL_TEXT), c0106c.UH));
            al(bundle.getBoolean(C0106c.t(PointerIconCompat.TYPE_ALIAS), c0106c.UI));
            this.UJ = new SparseArray<>();
            B(bundle);
            this.UK = f(bundle.getIntArray(C0106c.t(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW)));
        }

        public d ac(boolean z) {
            this.Uz = z;
            return this;
        }

        public d ad(boolean z) {
            this.UA = z;
            return this;
        }

        public d ae(boolean z) {
            this.UB = z;
            return this;
        }

        @Override // com.applovin.exoplayer2.j.i.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d b(Context context, boolean z) {
            super.b(context, z);
            return this;
        }

        @Override // com.applovin.exoplayer2.j.i.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public d d(int i, int i2, boolean z) {
            super.d(i, i2, z);
            return this;
        }

        public d af(boolean z) {
            this.UC = z;
            return this;
        }

        public d ag(boolean z) {
            this.UD = z;
            return this;
        }

        public d ah(boolean z) {
            this.UE = z;
            return this;
        }

        public d ai(boolean z) {
            this.UF = z;
            return this;
        }

        @Override // com.applovin.exoplayer2.j.i.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public d g(Context context) {
            super.g(context);
            return this;
        }

        public d eR(int i) {
            this.Uy = i;
            return this;
        }

        public d aj(boolean z) {
            this.UG = z;
            return this;
        }

        public d ak(boolean z) {
            this.UH = z;
            return this;
        }

        public d al(boolean z) {
            this.UI = z;
            return this;
        }

        public final d a(int i, ad adVar, e eVar) {
            Map<ad, e> map = this.UJ.get(i);
            if (map == null) {
                map = new HashMap<>();
                this.UJ.put(i, map);
            }
            if (map.containsKey(adVar) && com.applovin.exoplayer2.l.ai.r(map.get(adVar), eVar)) {
                return this;
            }
            map.put(adVar, eVar);
            return this;
        }

        @Override // com.applovin.exoplayer2.j.i.a
        /* JADX INFO: renamed from: nk, reason: merged with bridge method [inline-methods] */
        public C0106c nm() {
            return new C0106c(this);
        }

        private void nl() {
            this.Uz = true;
            this.UA = false;
            this.UB = true;
            this.UC = true;
            this.UD = false;
            this.UE = false;
            this.UF = false;
            this.Uy = 0;
            this.UG = true;
            this.UH = false;
            this.UI = true;
        }

        private void B(Bundle bundle) {
            int[] intArray = bundle.getIntArray(C0106c.t(PointerIconCompat.TYPE_COPY));
            List listA = com.applovin.exoplayer2.l.c.a(ad.br, bundle.getParcelableArrayList(C0106c.t(PointerIconCompat.TYPE_NO_DROP)), s.ga());
            SparseArray sparseArrayA = com.applovin.exoplayer2.l.c.a(e.br, (SparseArray<Bundle>) bundle.getSparseParcelableArray(C0106c.t(PointerIconCompat.TYPE_ALL_SCROLL)), new SparseArray());
            if (intArray == null || intArray.length != listA.size()) {
                return;
            }
            for (int i = 0; i < intArray.length; i++) {
                a(intArray[i], (ad) listA.get(i), (e) sparseArrayA.get(i));
            }
        }

        private SparseBooleanArray f(int[] iArr) {
            if (iArr == null) {
                return new SparseBooleanArray();
            }
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
            for (int i : iArr) {
                sparseBooleanArray.append(i, true);
            }
            return sparseBooleanArray;
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.j.c$c, reason: collision with other inner class name */
    public static final class C0106c extends i implements com.applovin.exoplayer2.g {
        public static final C0106c Uw;

        @Deprecated
        public static final C0106c Ux;
        public static final com.applovin.exoplayer2.g.a<C0106c> br;
        public final boolean UA;
        public final boolean UB;
        public final boolean UC;
        public final boolean UD;
        public final boolean UE;
        public final boolean UF;
        public final boolean UG;
        public final boolean UH;
        public final boolean UI;
        private final SparseArray<Map<ad, e>> UJ;
        private final SparseBooleanArray UK;
        public final int Uy;
        public final boolean Uz;

        static {
            C0106c c0106cNm = new d().nm();
            Uw = c0106cNm;
            Ux = c0106cNm;
            br = new com.applovin.exoplayer2.g.a() { // from class: com.applovin.exoplayer2.j.-$$Lambda$c$c$NrAcLM9xEmgBaOoDQLPe25cKKgw
                @Override // com.applovin.exoplayer2.g.a
                public final com.applovin.exoplayer2.g fromBundle(Bundle bundle) {
                    return c.C0106c.A(bundle);
                }
            };
        }

        public static C0106c e(Context context) {
            return new d(context).nm();
        }

        private C0106c(d dVar) {
            super(dVar);
            this.Uz = dVar.Uz;
            this.UA = dVar.UA;
            this.UB = dVar.UB;
            this.UC = dVar.UC;
            this.UD = dVar.UD;
            this.UE = dVar.UE;
            this.UF = dVar.UF;
            this.Uy = dVar.Uy;
            this.UG = dVar.UG;
            this.UH = dVar.UH;
            this.UI = dVar.UI;
            this.UJ = dVar.UJ;
            this.UK = dVar.UK;
        }

        public final boolean eQ(int i) {
            return this.UK.get(i);
        }

        public final boolean a(int i, ad adVar) {
            Map<ad, e> map = this.UJ.get(i);
            return map != null && map.containsKey(adVar);
        }

        public final e b(int i, ad adVar) {
            Map<ad, e> map = this.UJ.get(i);
            if (map != null) {
                return map.get(adVar);
            }
            return null;
        }

        @Override // com.applovin.exoplayer2.j.i
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0106c c0106c = (C0106c) obj;
            return super.equals(c0106c) && this.Uz == c0106c.Uz && this.UA == c0106c.UA && this.UB == c0106c.UB && this.UC == c0106c.UC && this.UD == c0106c.UD && this.UE == c0106c.UE && this.UF == c0106c.UF && this.Uy == c0106c.Uy && this.UG == c0106c.UG && this.UH == c0106c.UH && this.UI == c0106c.UI && a(this.UK, c0106c.UK) && a(this.UJ, c0106c.UJ);
        }

        @Override // com.applovin.exoplayer2.j.i
        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.Uz ? 1 : 0)) * 31) + (this.UA ? 1 : 0)) * 31) + (this.UB ? 1 : 0)) * 31) + (this.UC ? 1 : 0)) * 31) + (this.UD ? 1 : 0)) * 31) + (this.UE ? 1 : 0)) * 31) + (this.UF ? 1 : 0)) * 31) + this.Uy) * 31) + (this.UG ? 1 : 0)) * 31) + (this.UH ? 1 : 0)) * 31) + (this.UI ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ C0106c A(Bundle bundle) {
            return new d(bundle).nm();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String t(int i) {
            return Integer.toString(i, 36);
        }

        private static boolean a(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean a(SparseArray<Map<ad, e>> sparseArray, SparseArray<Map<ad, e>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (iIndexOfKey < 0 || !a(sparseArray.valueAt(i), sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean a(Map<ad, e> map, Map<ad, e> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<ad, e> entry : map.entrySet()) {
                ad key = entry.getKey();
                if (!map2.containsKey(key) || !com.applovin.exoplayer2.l.ai.r(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class e implements com.applovin.exoplayer2.g {
        public static final com.applovin.exoplayer2.g.a<e> br = new com.applovin.exoplayer2.g.a() { // from class: com.applovin.exoplayer2.j.-$$Lambda$c$e$JLfhOLnvyBYEeSraHVuetEOYssQ
            @Override // com.applovin.exoplayer2.g.a
            public final com.applovin.exoplayer2.g fromBundle(Bundle bundle) {
                return c.e.C(bundle);
            }
        };
        public final int UL;
        public final int[] Ue;
        public final int bs;
        public final int fR;

        public e(int i, int[] iArr, int i2) {
            this.UL = i;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.Ue = iArrCopyOf;
            this.fR = iArr.length;
            this.bs = i2;
            Arrays.sort(iArrCopyOf);
        }

        public int hashCode() {
            return (((this.UL * 31) + Arrays.hashCode(this.Ue)) * 31) + this.bs;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.UL == eVar.UL && Arrays.equals(this.Ue, eVar.Ue) && this.bs == eVar.bs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e C(Bundle bundle) {
            boolean z = false;
            int i = bundle.getInt(t(0), -1);
            int[] intArray = bundle.getIntArray(t(1));
            int i2 = bundle.getInt(t(2), -1);
            if (i >= 0 && i2 >= 0) {
                z = true;
            }
            com.applovin.exoplayer2.l.a.checkArgument(z);
            com.applovin.exoplayer2.l.a.checkNotNull(intArray);
            return new e(i, intArray, i2);
        }

        private static String t(int i) {
            return Integer.toString(i, 36);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    @Deprecated
    public c() {
        this(C0106c.Uw, new com.applovin.exoplayer2.j.a.b());
    }

    public c(Context context) {
        this(context, new com.applovin.exoplayer2.j.a.b());
    }

    public c(Context context, com.applovin.exoplayer2.j.d.b bVar) {
        this(C0106c.e(context), bVar);
    }

    public c(C0106c c0106c, com.applovin.exoplayer2.j.d.b bVar) {
        this.Uj = bVar;
        this.Uk = new AtomicReference<>(c0106c);
    }

    @Override // com.applovin.exoplayer2.j.f
    protected final Pair<at[], com.applovin.exoplayer2.j.d[]> a(com.applovin.exoplayer2.j.f.a aVar, int[][][] iArr, int[] iArr2, p.a aVar2, ba baVar) throws com.applovin.exoplayer2.p {
        C0106c c0106c = this.Uk.get();
        int iNp = aVar.np();
        com.applovin.exoplayer2.j.d.a[] aVarArrA = a(aVar, iArr, iArr2, c0106c);
        int i = 0;
        while (true) {
            if (i >= iNp) {
                break;
            }
            int iES = aVar.eS(i);
            if (c0106c.eQ(i) || c0106c.VB.contains(Integer.valueOf(iES))) {
                aVarArrA[i] = null;
            } else {
                ad adVarET = aVar.eT(i);
                if (c0106c.a(i, adVarET)) {
                    e eVarB = c0106c.b(i, adVarET);
                    aVarArrA[i] = eVarB != null ? new com.applovin.exoplayer2.j.d.a(adVarET.eb(eVarB.UL), eVarB.Ue, eVarB.bs) : null;
                }
            }
            i++;
        }
        com.applovin.exoplayer2.j.d[] dVarArrA = this.Uj.a(aVarArrA, nq(), aVar2, baVar);
        at[] atVarArr = new at[iNp];
        for (int i2 = 0; i2 < iNp; i2++) {
            boolean z = true;
            if ((c0106c.eQ(i2) || c0106c.VB.contains(Integer.valueOf(aVar.eS(i2)))) || (aVar.eS(i2) != -2 && dVarArrA[i2] == null)) {
                z = false;
            }
            atVarArr[i2] = z ? at.hh : null;
        }
        if (c0106c.UH) {
            a(aVar, iArr, atVarArr, dVarArrA);
        }
        return Pair.create(atVarArr, dVarArrA);
    }

    protected com.applovin.exoplayer2.j.d.a[] a(com.applovin.exoplayer2.j.f.a aVar, int[][][] iArr, int[] iArr2, C0106c c0106c) throws com.applovin.exoplayer2.p {
        boolean z;
        String str;
        int i;
        a aVar2;
        String str2;
        int i2;
        int iNp = aVar.np();
        com.applovin.exoplayer2.j.d.a[] aVarArr = new com.applovin.exoplayer2.j.d.a[iNp];
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        boolean z3 = false;
        while (true) {
            z = true;
            if (i4 >= iNp) {
                break;
            }
            if (2 == aVar.eS(i4)) {
                if (!z2) {
                    aVarArr[i4] = a(aVar.eT(i4), iArr[i4], iArr2[i4], c0106c, true);
                    z2 = aVarArr[i4] != null;
                }
                z3 |= aVar.eT(i4).fR > 0;
            }
            i4++;
        }
        int i5 = 0;
        int i6 = -1;
        a aVar3 = null;
        String str3 = null;
        while (i5 < iNp) {
            if (z == aVar.eS(i5)) {
                boolean z4 = (c0106c.UI || !z3) ? z : false;
                i = i6;
                aVar2 = aVar3;
                str2 = str3;
                i2 = i5;
                Pair<com.applovin.exoplayer2.j.d.a, a> pairB = b(aVar.eT(i5), iArr[i5], iArr2[i5], c0106c, z4);
                if (pairB != null && (aVar2 == null || ((a) pairB.second).compareTo(aVar2) > 0)) {
                    if (i != -1) {
                        aVarArr[i] = null;
                    }
                    com.applovin.exoplayer2.j.d.a aVar4 = (com.applovin.exoplayer2.j.d.a) pairB.first;
                    aVarArr[i2] = aVar4;
                    str3 = aVar4.Ud.dZ(aVar4.Ue[0]).dq;
                    aVar3 = (a) pairB.second;
                    i6 = i2;
                }
                i5 = i2 + 1;
                z = true;
            } else {
                i = i6;
                aVar2 = aVar3;
                str2 = str3;
                i2 = i5;
            }
            i6 = i;
            aVar3 = aVar2;
            str3 = str2;
            i5 = i2 + 1;
            z = true;
        }
        String str4 = str3;
        int i7 = -1;
        f fVar = null;
        while (i3 < iNp) {
            int iES = aVar.eS(i3);
            if (iES == 1) {
                str = str4;
            } else if (iES == 2) {
                str = str4;
            } else if (iES == 3) {
                str = str4;
                Pair<com.applovin.exoplayer2.j.d.a, f> pairA = a(aVar.eT(i3), iArr[i3], c0106c, str);
                if (pairA != null && (fVar == null || ((f) pairA.second).compareTo(fVar) > 0)) {
                    if (i7 != -1) {
                        aVarArr[i7] = null;
                    }
                    aVarArr[i3] = (com.applovin.exoplayer2.j.d.a) pairA.first;
                    fVar = (f) pairA.second;
                    i7 = i3;
                }
            } else {
                aVarArr[i3] = a(iES, aVar.eT(i3), iArr[i3], c0106c);
                str = str4;
            }
            i3++;
            str4 = str;
        }
        return aVarArr;
    }

    protected com.applovin.exoplayer2.j.d.a a(ad adVar, int[][] iArr, int i, C0106c c0106c, boolean z) throws com.applovin.exoplayer2.p {
        com.applovin.exoplayer2.j.d.a aVarA = (c0106c.VA || c0106c.Vz || !z) ? null : a(adVar, iArr, i, c0106c);
        return aVarA == null ? a(adVar, iArr, c0106c) : aVarA;
    }

    private static com.applovin.exoplayer2.j.d.a a(ad adVar, int[][] iArr, int i, C0106c c0106c) {
        C0106c c0106c2 = c0106c;
        int i2 = c0106c2.UB ? 24 : 16;
        boolean z = c0106c2.UA && (i & i2) != 0;
        int i3 = 0;
        while (i3 < adVar.fR) {
            ac acVarEb = adVar.eb(i3);
            int i4 = i3;
            int[] iArrA = a(acVarEb, iArr[i3], z, i2, c0106c2.Vf, c0106c2.Vg, c0106c2.Vh, c0106c2.Vi, c0106c2.Vj, c0106c2.Vk, c0106c2.Vl, c0106c2.Vm, c0106c2.Vn, c0106c2.Vo, c0106c2.Vp);
            if (iArrA.length > 0) {
                return new com.applovin.exoplayer2.j.d.a(acVarEb, iArrA);
            }
            i3 = i4 + 1;
            c0106c2 = c0106c;
        }
        return null;
    }

    private static int[] a(ac acVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z2) {
        String str;
        int i12;
        int i13;
        HashSet hashSet;
        if (acVar.fR < 2) {
            return Ug;
        }
        List<Integer> listA = a(acVar, i10, i11, z2);
        if (listA.size() < 2) {
            return Ug;
        }
        if (z) {
            str = null;
        } else {
            HashSet hashSet2 = new HashSet();
            String str2 = null;
            int i14 = 0;
            int i15 = 0;
            while (i15 < listA.size()) {
                String str3 = acVar.dZ(listA.get(i15).intValue()).dz;
                if (hashSet2.add(str3)) {
                    i12 = i14;
                    i13 = i15;
                    hashSet = hashSet2;
                    int iA = a(acVar, iArr, i, str3, i2, i3, i4, i5, i6, i7, i8, i9, listA);
                    if (iA > i12) {
                        i14 = iA;
                        str2 = str3;
                    }
                    i15 = i13 + 1;
                    hashSet2 = hashSet;
                } else {
                    i12 = i14;
                    i13 = i15;
                    hashSet = hashSet2;
                }
                i14 = i12;
                i15 = i13 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        }
        b(acVar, iArr, i, str, i2, i3, i4, i5, i6, i7, i8, i9, listA);
        return listA.size() < 2 ? Ug : com.applovin.exoplayer2.common.b.c.f(listA);
    }

    private static int a(ac acVar, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iIntValue = list.get(i11).intValue();
            if (a(acVar.dZ(iIntValue), str, iArr[iIntValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                i10++;
            }
        }
        return i10;
    }

    private static void b(ac acVar, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!a(acVar.dZ(iIntValue), str, iArr[iIntValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                list.remove(size);
            }
        }
    }

    private static boolean a(v vVar, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if ((vVar.ds & 16384) != 0 || !n(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !com.applovin.exoplayer2.l.ai.r(vVar.dz, str)) {
            return false;
        }
        if (vVar.dE != -1 && (i7 > vVar.dE || vVar.dE > i3)) {
            return false;
        }
        if (vVar.height == -1 || (i8 <= vVar.height && vVar.height <= i4)) {
            return (vVar.dF == -1.0f || (((float) i9) <= vVar.dF && vVar.dF <= ((float) i5))) && vVar.dv != -1 && i10 <= vVar.dv && vVar.dv <= i6;
        }
        return false;
    }

    private static com.applovin.exoplayer2.j.d.a a(ad adVar, int[][] iArr, C0106c c0106c) {
        int i = -1;
        ac acVar = null;
        g gVar = null;
        for (int i2 = 0; i2 < adVar.fR; i2++) {
            ac acVarEb = adVar.eb(i2);
            List<Integer> listA = a(acVarEb, c0106c.Vn, c0106c.Vo, c0106c.Vp);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < acVarEb.fR; i3++) {
                v vVarDZ = acVarEb.dZ(i3);
                if ((vVarDZ.ds & 16384) == 0 && n(iArr2[i3], c0106c.UG)) {
                    g gVar2 = new g(vVarDZ, c0106c, iArr2[i3], listA.contains(Integer.valueOf(i3)));
                    if ((gVar2.UP || c0106c.Uz) && (gVar == null || gVar2.compareTo(gVar) > 0)) {
                        acVar = acVarEb;
                        i = i3;
                        gVar = gVar2;
                    }
                }
            }
        }
        if (acVar == null) {
            return null;
        }
        return new com.applovin.exoplayer2.j.d.a(acVar, i);
    }

    protected Pair<com.applovin.exoplayer2.j.d.a, a> b(ad adVar, int[][] iArr, int i, C0106c c0106c, boolean z) throws com.applovin.exoplayer2.p {
        com.applovin.exoplayer2.j.d.a aVar = null;
        a aVar2 = null;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < adVar.fR; i4++) {
            ac acVarEb = adVar.eb(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < acVarEb.fR; i5++) {
                if (n(iArr2[i5], c0106c.UG)) {
                    a aVar3 = new a(acVarEb.dZ(i5), c0106c, iArr2[i5]);
                    if ((aVar3.Ul || c0106c.UC) && (aVar2 == null || aVar3.compareTo(aVar2) > 0)) {
                        i2 = i4;
                        i3 = i5;
                        aVar2 = aVar3;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        ac acVarEb2 = adVar.eb(i2);
        if (!c0106c.VA && !c0106c.Vz && z) {
            int[] iArrA = a(acVarEb2, iArr[i2], i3, c0106c.Vu, c0106c.UD, c0106c.UE, c0106c.UF);
            if (iArrA.length > 1) {
                aVar = new com.applovin.exoplayer2.j.d.a(acVarEb2, iArrA);
            }
        }
        if (aVar == null) {
            aVar = new com.applovin.exoplayer2.j.d.a(acVarEb2, i3);
        }
        return Pair.create(aVar, (a) com.applovin.exoplayer2.l.a.checkNotNull(aVar2));
    }

    private static int[] a(ac acVar, int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3) {
        v vVarDZ = acVar.dZ(i);
        int[] iArr2 = new int[acVar.fR];
        int i3 = 0;
        for (int i4 = 0; i4 < acVar.fR; i4++) {
            if (i4 == i || a(acVar.dZ(i4), iArr[i4], vVarDZ, i2, z, z2, z3)) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return Arrays.copyOf(iArr2, i3);
    }

    private static boolean a(v vVar, int i, v vVar2, int i2, boolean z, boolean z2, boolean z3) {
        if (!n(i, false) || vVar.dv == -1 || vVar.dv > i2) {
            return false;
        }
        if (!z3 && (vVar.dL == -1 || vVar.dL != vVar2.dL)) {
            return false;
        }
        if (z || (vVar.dz != null && TextUtils.equals(vVar.dz, vVar2.dz))) {
            return z2 || (vVar.dM != -1 && vVar.dM == vVar2.dM);
        }
        return false;
    }

    protected Pair<com.applovin.exoplayer2.j.d.a, f> a(ad adVar, int[][] iArr, C0106c c0106c, String str) throws com.applovin.exoplayer2.p {
        int i = -1;
        ac acVar = null;
        f fVar = null;
        for (int i2 = 0; i2 < adVar.fR; i2++) {
            ac acVarEb = adVar.eb(i2);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < acVarEb.fR; i3++) {
                if (n(iArr2[i3], c0106c.UG)) {
                    f fVar2 = new f(acVarEb.dZ(i3), c0106c, iArr2[i3], str);
                    if (fVar2.Ul && (fVar == null || fVar2.compareTo(fVar) > 0)) {
                        acVar = acVarEb;
                        i = i3;
                        fVar = fVar2;
                    }
                }
            }
        }
        if (acVar == null) {
            return null;
        }
        return Pair.create(new com.applovin.exoplayer2.j.d.a(acVar, i), (f) com.applovin.exoplayer2.l.a.checkNotNull(fVar));
    }

    protected com.applovin.exoplayer2.j.d.a a(int i, ad adVar, int[][] iArr, C0106c c0106c) throws com.applovin.exoplayer2.p {
        ac acVar = null;
        b bVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < adVar.fR; i3++) {
            ac acVarEb = adVar.eb(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < acVarEb.fR; i4++) {
                if (n(iArr2[i4], c0106c.UG)) {
                    b bVar2 = new b(acVarEb.dZ(i4), iArr2[i4]);
                    if (bVar == null || bVar2.compareTo(bVar) > 0) {
                        acVar = acVarEb;
                        i2 = i4;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (acVar == null) {
            return null;
        }
        return new com.applovin.exoplayer2.j.d.a(acVar, i2);
    }

    private static void a(com.applovin.exoplayer2.j.f.a aVar, int[][][] iArr, at[] atVarArr, com.applovin.exoplayer2.j.d[] dVarArr) {
        boolean z;
        boolean z2 = false;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            if (i >= aVar.np()) {
                z = true;
                break;
            }
            int iES = aVar.eS(i);
            com.applovin.exoplayer2.j.d dVar = dVarArr[i];
            if ((iES == 1 || iES == 2) && dVar != null && a(iArr[i], aVar.eT(i), dVar)) {
                if (iES == 1) {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i;
                }
            }
            i++;
        }
        if (i3 != -1 && i2 != -1) {
            z2 = true;
        }
        if (z && z2) {
            at atVar = new at(true);
            atVarArr[i3] = atVar;
            atVarArr[i2] = atVar;
        }
    }

    private static boolean a(int[][] iArr, ad adVar, com.applovin.exoplayer2.j.d dVar) {
        if (dVar == null) {
            return false;
        }
        int iA = adVar.a(dVar.nf());
        for (int i = 0; i < dVar.kD(); i++) {
            if (as.ag(iArr[iA][dVar.eP(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    protected static boolean n(int i, boolean z) {
        int iAf = as.af(i);
        return iAf == 4 || (z && iAf == 3);
    }

    protected static String aI(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int a(v vVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(vVar.dq)) {
            return 4;
        }
        String strAI = aI(str);
        String strAI2 = aI(vVar.dq);
        if (strAI2 == null || strAI == null) {
            return (z && strAI2 == null) ? 1 : 0;
        }
        if (strAI2.startsWith(strAI) || strAI.startsWith(strAI2)) {
            return 3;
        }
        return com.applovin.exoplayer2.l.ai.m(strAI2, "-")[0].equals(com.applovin.exoplayer2.l.ai.m(strAI, "-")[0]) ? 2 : 0;
    }

    private static List<Integer> a(ac acVar, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(acVar.fR);
        for (int i3 = 0; i3 < acVar.fR; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < acVar.fR; i5++) {
                v vVarDZ = acVar.dZ(i5);
                if (vVarDZ.dE > 0 && vVarDZ.height > 0) {
                    Point pointA = a(z, i, i2, vVarDZ.dE, vVarDZ.height);
                    int i6 = vVarDZ.dE * vVarDZ.height;
                    if (vVarDZ.dE >= ((int) (pointA.x * 0.98f)) && vVarDZ.height >= ((int) (pointA.y * 0.98f)) && i6 < i4) {
                        i4 = i6;
                    }
                }
            }
            if (i4 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int iBS = acVar.dZ(((Integer) arrayList.get(size)).intValue()).bS();
                    if (iBS == -1 || iBS > i4) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0010  */
    private static Point a(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if ((i3 > i4) == (i > i2)) {
                i2 = i;
                i = i2;
            }
        } else {
            i2 = i;
            i = i2;
        }
        int i5 = i3 * i;
        int i6 = i4 * i2;
        if (i5 >= i6) {
            return new Point(i2, com.applovin.exoplayer2.l.ai.N(i6, i3));
        }
        return new Point(com.applovin.exoplayer2.l.ai.N(i5, i4), i);
    }

    protected static final class g implements Comparable<g> {
        public final boolean UP;
        private final boolean UQ;
        private final int UR;
        private final C0106c Um;
        private final boolean Un;
        private final int Uu;
        private final int dv;

        public g(v vVar, C0106c c0106c, int i, boolean z) {
            this.Um = c0106c;
            boolean z2 = true;
            this.UP = z && (vVar.dE == -1 || vVar.dE <= c0106c.Vf) && ((vVar.height == -1 || vVar.height <= c0106c.Vg) && ((vVar.dF == -1.0f || vVar.dF <= ((float) c0106c.Vh)) && (vVar.dv == -1 || vVar.dv <= c0106c.Vi)));
            if (!z || ((vVar.dE != -1 && vVar.dE < c0106c.Vj) || ((vVar.height != -1 && vVar.height < c0106c.Vk) || ((vVar.dF != -1.0f && vVar.dF < c0106c.Vl) || (vVar.dv != -1 && vVar.dv < c0106c.Vm))))) {
                z2 = false;
            }
            this.UQ = z2;
            this.Un = c.n(i, false);
            this.dv = vVar.dv;
            this.UR = vVar.bS();
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < c0106c.Vq.size(); i3++) {
                if (vVar.dz != null && vVar.dz.equals(c0106c.Vq.get(i3))) {
                    i2 = i3;
                    break;
                }
            }
            this.Uu = i2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            ai aiVarGO = (this.UP && this.Un) ? c.Uh : c.Uh.gO();
            return n.fP().d(this.Un, gVar.Un).d(this.UP, gVar.UP).d(this.UQ, gVar.UQ).a(Integer.valueOf(this.Uu), Integer.valueOf(gVar.Uu), ai.gP().gO()).a(Integer.valueOf(this.dv), Integer.valueOf(gVar.dv), this.Um.Vz ? c.Uh.gO() : c.Ui).a(Integer.valueOf(this.UR), Integer.valueOf(gVar.UR), aiVarGO).a(Integer.valueOf(this.dv), Integer.valueOf(gVar.dv), aiVarGO).fQ();
        }
    }

    protected static final class a implements Comparable<a> {
        public final boolean Ul;
        private final C0106c Um;
        private final boolean Un;
        private final int Uo;
        private final int Up;
        private final int Uq;
        private final int Ur;
        private final int Us;
        private final boolean Ut;
        private final int Uu;
        private final int dL;
        private final int dM;
        private final String dq;
        private final int dv;

        public a(v vVar, C0106c c0106c, int i) {
            int i2;
            int iA;
            int iA2;
            this.Um = c0106c;
            this.dq = c.aI(vVar.dq);
            this.Un = c.n(i, false);
            int i3 = 0;
            while (true) {
                i2 = Integer.MAX_VALUE;
                if (i3 >= c0106c.Vr.size()) {
                    iA = 0;
                    i3 = Integer.MAX_VALUE;
                    break;
                } else {
                    iA = c.a(vVar, c0106c.Vr.get(i3), false);
                    if (iA > 0) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.Up = i3;
            this.Uo = iA;
            this.Uq = Integer.bitCount(vVar.ds & c0106c.Vs);
            boolean z = true;
            this.Ut = (vVar.dr & 1) != 0;
            this.dL = vVar.dL;
            this.dM = vVar.dM;
            this.dv = vVar.dv;
            if ((vVar.dv != -1 && vVar.dv > c0106c.Vu) || (vVar.dL != -1 && vVar.dL > c0106c.Vt)) {
                z = false;
            }
            this.Ul = z;
            String[] strArrQa = com.applovin.exoplayer2.l.ai.qa();
            int i4 = 0;
            while (true) {
                if (i4 >= strArrQa.length) {
                    iA2 = 0;
                    i4 = Integer.MAX_VALUE;
                    break;
                } else {
                    iA2 = c.a(vVar, strArrQa[i4], false);
                    if (iA2 > 0) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            this.Ur = i4;
            this.Us = iA2;
            for (int i5 = 0; i5 < c0106c.Vv.size(); i5++) {
                if (vVar.dz != null && vVar.dz.equals(c0106c.Vv.get(i5))) {
                    i2 = i5;
                    break;
                }
            }
            this.Uu = i2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            ai aiVarGO = (this.Ul && this.Un) ? c.Uh : c.Uh.gO();
            n nVarA = n.fP().d(this.Un, aVar.Un).a(Integer.valueOf(this.Up), Integer.valueOf(aVar.Up), ai.gP().gO()).r(this.Uo, aVar.Uo).r(this.Uq, aVar.Uq).d(this.Ul, aVar.Ul).a(Integer.valueOf(this.Uu), Integer.valueOf(aVar.Uu), ai.gP().gO()).a(Integer.valueOf(this.dv), Integer.valueOf(aVar.dv), this.Um.Vz ? c.Uh.gO() : c.Ui).d(this.Ut, aVar.Ut).a(Integer.valueOf(this.Ur), Integer.valueOf(aVar.Ur), ai.gP().gO()).r(this.Us, aVar.Us).a(Integer.valueOf(this.dL), Integer.valueOf(aVar.dL), aiVarGO).a(Integer.valueOf(this.dM), Integer.valueOf(aVar.dM), aiVarGO);
            Integer numValueOf = Integer.valueOf(this.dv);
            Integer numValueOf2 = Integer.valueOf(aVar.dv);
            if (!com.applovin.exoplayer2.l.ai.r(this.dq, aVar.dq)) {
                aiVarGO = c.Ui;
            }
            return nVarA.a(numValueOf, numValueOf2, aiVarGO).fQ();
        }
    }

    protected static final class f implements Comparable<f> {
        private final boolean UM;
        private final int UN;
        private final boolean UO;
        public final boolean Ul;
        private final boolean Un;
        private final int Uo;
        private final int Up;
        private final int Uq;
        private final boolean Uv;

        public f(v vVar, C0106c c0106c, int i, String str) {
            s<String> sVarU;
            int iA;
            boolean z = false;
            this.Un = c.n(i, false);
            int i2 = vVar.dr & (~c0106c.Uy);
            this.Uv = (i2 & 1) != 0;
            this.UM = (i2 & 2) != 0;
            int i3 = Integer.MAX_VALUE;
            if (c0106c.Vw.isEmpty()) {
                sVarU = s.u("");
            } else {
                sVarU = c0106c.Vw;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= sVarU.size()) {
                    iA = 0;
                    break;
                }
                iA = c.a(vVar, sVarU.get(i4), c0106c.Vy);
                if (iA > 0) {
                    i3 = i4;
                    break;
                }
                i4++;
            }
            this.Up = i3;
            this.Uo = iA;
            int iBitCount = Integer.bitCount(vVar.ds & c0106c.Vx);
            this.Uq = iBitCount;
            this.UO = (vVar.ds & 1088) != 0;
            int iA2 = c.a(vVar, str, c.aI(str) == null);
            this.UN = iA2;
            if (iA > 0 || ((c0106c.Vw.isEmpty() && iBitCount > 0) || this.Uv || (this.UM && iA2 > 0))) {
                z = true;
            }
            this.Ul = z;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(f fVar) {
            n nVarR = n.fP().d(this.Un, fVar.Un).a(Integer.valueOf(this.Up), Integer.valueOf(fVar.Up), ai.gP().gO()).r(this.Uo, fVar.Uo).r(this.Uq, fVar.Uq).d(this.Uv, fVar.Uv).a(Boolean.valueOf(this.UM), Boolean.valueOf(fVar.UM), this.Uo == 0 ? ai.gP() : ai.gP().gO()).r(this.UN, fVar.UN);
            if (this.Uq == 0) {
                nVarR = nVarR.c(this.UO, fVar.UO);
            }
            return nVarR.fQ();
        }
    }

    protected static final class b implements Comparable<b> {
        private final boolean Un;
        private final boolean Uv;

        public b(v vVar, int i) {
            this.Uv = (vVar.dr & 1) != 0;
            this.Un = c.n(i, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return n.fP().d(this.Un, bVar.Un).d(this.Uv, bVar.Uv).fQ();
        }
    }
}
