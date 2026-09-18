package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4j, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C4j {
    public static String[] A02 = {"hO0SXlIn7n5HXEBLx", "jESNVpuYnHPlnh4DZ", "CDLwN7DwmtArlNd144q1QIOvLDqs4yZF", "JntNhgZ58kYFXbwiJ6hzeVdvPNGn00kF", "yTsWpbzmHeCmcQEDkb0QkT5J3TV6CkfD", "Lh9pded4Clz2", "gnDNjs3GBImfOnnM5uEQWokXBd1c", "C4tnEN178k9sL9bIxtVolUttiI5dEdE5"};
    public SparseArray<C06784i> A00 = new SparseArray<>();
    public int A01 = 0;

    private final long A00(long j, long j2) {
        if (j == 0) {
            return j2;
        }
        long j3 = j / 4;
        String[] strArr = A02;
        if (strArr[3].charAt(9) != strArr[7].charAt(9)) {
            throw new RuntimeException();
        }
        A02[4] = "GTVZcsVJP0WVKaHbsMtSVk9gu6Gyk4Ss";
        return (j3 * 3) + (j2 / 4);
    }

    private C06784i A01(int i) {
        C06784i c06784i = this.A00.get(i);
        if (c06784i == null) {
            C06784i c06784i2 = new C06784i();
            this.A00.put(i, c06784i2);
            return c06784i2;
        }
        return c06784i;
    }

    private final void A02() {
        for (int i = 0; i < i; i++) {
            this.A00.valueAt(i).A03.clear();
        }
    }

    public final AbstractC06894u A03(int i) {
        C06784i c06784i = this.A00.get(i);
        if (c06784i != null && !c06784i.A03.isEmpty()) {
            ArrayList<AbstractC06894u> arrayList = c06784i.A03;
            if (A02[4].charAt(1) != 'T') {
                throw new RuntimeException();
            }
            A02[6] = "6zOEmNGiTAHU1v9SGa3";
            return arrayList.remove(arrayList.size() - 1);
        }
        return null;
    }

    public final void A04() {
        this.A01--;
    }

    public final void A05(int i, long j) {
        C06784i c06784iA01 = A01(i);
        c06784iA01.A01 = A00(c06784iA01.A01, j);
    }

    public final void A06(int i, long j) {
        C06784i c06784iA01 = A01(i);
        c06784iA01.A02 = A00(c06784iA01.A02, j);
    }

    public final void A07(C4Q c4q) {
        this.A01++;
    }

    public final void A08(C4Q c4q, C4Q c4q2, boolean z) {
        if (c4q != null) {
            A04();
        }
        if (!z && this.A01 == 0) {
            A02();
        }
        if (c4q2 != null) {
            A07(c4q2);
        }
    }

    public final void A09(AbstractC06894u abstractC06894u) {
        int iA0H = abstractC06894u.A0H();
        ArrayList<AbstractC06894u> arrayList = A01(iA0H).A03;
        int i = this.A00.get(iA0H).A00;
        int viewType = arrayList.size();
        if (i <= viewType) {
            return;
        }
        abstractC06894u.A0Q();
        String[] strArr = A02;
        String str = strArr[3];
        String str2 = strArr[7];
        int iCharAt = str.charAt(9);
        int viewType2 = str2.charAt(9);
        if (iCharAt != viewType2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[1] = "TnDeXYrDbfmyODeGX";
        strArr2[5] = "ziritv0xfrad";
        arrayList.add(abstractC06894u);
    }

    public final boolean A0A(int i, long j, long j2) {
        long j3 = A01(i).A01;
        return j3 == 0 || j + j3 < j2;
    }

    public final boolean A0B(int i, long j, long j2) {
        long j3 = A01(i).A02;
        return j3 == 0 || j + j3 < j2;
    }
}
