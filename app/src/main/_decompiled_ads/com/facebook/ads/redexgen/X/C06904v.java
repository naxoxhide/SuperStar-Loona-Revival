package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4v, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C06904v {
    public static String[] A00 = {"UqypfisWbLbbWLDfIVvpiaUsz0iS", "wEiCJDeLGzLJebV", "cX", "dRMEhdR7kDOm9Ob", "SmhGT229bW5LAFpAZzaxeRYqKvMDeGhX", "QcSoUKFtoryhyFMFYIfDI81ChPsDlMu7", "SBvSWfqovIH0ljTVzoffsyrdWCNw", "n"};

    public static int A00(C06864r c06864r, C4M c4m, View view, View view2, AbstractC06724c abstractC06724c, boolean z) {
        if (abstractC06724c.A0W() == 0 || c06864r.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(abstractC06724c.A0p(view) - abstractC06724c.A0p(view2)) + 1;
        }
        int iA0C = c4m.A0C(view2);
        int iA0F = c4m.A0F(view);
        String[] strArr = A00;
        if (strArr[4].charAt(28) == strArr[5].charAt(28)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A00;
        strArr2[3] = "xd2oZUwi45Npmqe";
        strArr2[1] = "1k2xoHfklbXXQiR";
        int extend = c4m.A0B();
        return Math.min(extend, iA0C - iA0F);
    }

    public static int A01(C06864r c06864r, C4M c4m, View view, View view2, AbstractC06724c abstractC06724c, boolean z) {
        if (abstractC06724c.A0W() == 0 || c06864r.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c06864r.A03();
        }
        int iA0C = c4m.A0C(view2) - c4m.A0F(view);
        int iA0p = abstractC06724c.A0p(view);
        int laidOutArea = abstractC06724c.A0p(view2);
        float fAbs = iA0C / (Math.abs(iA0p - laidOutArea) + 1);
        int laidOutArea2 = c06864r.A03();
        return (int) (fAbs * laidOutArea2);
    }

    public static int A02(C06864r c06864r, C4M c4m, View view, View view2, AbstractC06724c abstractC06724c, boolean z, boolean z2) {
        int laidOutArea;
        if (abstractC06724c.A0W() != 0) {
            int iA03 = c06864r.A03();
            String[] strArr = A00;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[6] = "xSzU3PMpL9LC7k2G9V08vNIV3nIP";
            strArr2[0] = "UsrmTbcEPDcBULmsiiLKltF5MwgK";
            if (iA03 != 0 && view != null && view2 != null) {
                int maxPosition = Math.min(abstractC06724c.A0p(view), abstractC06724c.A0p(view2));
                int iA0p = abstractC06724c.A0p(view);
                int minPosition = abstractC06724c.A0p(view2);
                int iMax = Math.max(iA0p, minPosition);
                if (z2) {
                    int minPosition2 = c06864r.A03();
                    laidOutArea = Math.max(0, (minPosition2 - iMax) - 1);
                } else {
                    laidOutArea = Math.max(0, maxPosition);
                }
                if (!z) {
                    return laidOutArea;
                }
                int itemsBefore = c4m.A0C(view2);
                int minPosition3 = c4m.A0F(view);
                int maxPosition2 = Math.abs(itemsBefore - minPosition3);
                int itemsBefore2 = abstractC06724c.A0p(view);
                int minPosition4 = abstractC06724c.A0p(view2);
                float fAbs = laidOutArea * (maxPosition2 / (Math.abs(itemsBefore2 - minPosition4) + 1));
                int itemsBefore3 = c4m.A0A();
                int minPosition5 = c4m.A0F(view);
                return Math.round(fAbs + (itemsBefore3 - minPosition5));
            }
        }
        return 0;
    }
}
