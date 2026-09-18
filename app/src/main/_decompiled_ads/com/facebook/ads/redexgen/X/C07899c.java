package com.facebook.ads.redexgen.X;

import android.util.Pair;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C07899c {
    public static String[] A0C = {"Lb1", "HAO", "yCHPPE9w0w81YCKuxFE6L9DmrxkJ2tU0", "DWgdxvM8Y7BV8jWWEqdgbbwmU3UKZQmt", "Bgm", "OOw1FrSehBTCipzYy8xUBx5", "Tcr4i3yvYCwS9F", "vvoyvovICPFY35FJOKkJE7b"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public C07879a A04;
    public C07879a A05;
    public C07879a A06;
    public AbstractC08119z A07;
    public Object A08;
    public boolean A09;
    public final C08099x A0A = new C08099x();
    public final C08109y A0B = new C08109y();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 22 out of bounds for length 22
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private C07889b A02(int i, long j, long j2) {
        EW ew = new EW(i, j2);
        this.A07.A09(ew.A02, this.A0A);
        int iA04 = this.A0A.A04(j);
        long jA09 = iA04 == -1 ? Long.MIN_VALUE : this.A0A.A09(iA04);
        boolean zA0A = A0A(ew, jA09);
        return new C07889b(ew, j, jA09, -9223372036854775807L, jA09 == Long.MIN_VALUE ? this.A0A.A07() : jA09, zA0A, A0B(ew, zA0A));
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0173  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private C07889b A03(C07879a c07879a, long j) {
        long jLongValue;
        C07889b c07889b = c07879a.A02;
        if (c07889b.A06) {
            int iA03 = this.A07.A03(c07889b.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            if (iA03 == -1) {
                return null;
            }
            int i = this.A07.A0A(iA03, this.A0A, true).A00;
            Object obj = this.A0A.A03;
            long j2 = c07889b.A04.A03;
            if (this.A07.A0B(i, this.A0B).A00 == iA03) {
                Pair<Integer, Long> pairA08 = this.A07.A08(this.A0B, this.A0A, i, -9223372036854775807L, Math.max(0L, (c07879a.A07() + c07889b.A01) - j));
                if (pairA08 == null) {
                    return null;
                }
                iA03 = ((Integer) pairA08.first).intValue();
                jLongValue = ((Long) pairA08.second).longValue();
                if (c07879a.A01 != null) {
                    boolean zEquals = c07879a.A01.A09.equals(obj);
                    String[] strArr = A0C;
                    if (strArr[5].length() == strArr[7].length()) {
                        String[] strArr2 = A0C;
                        strArr2[4] = "1Mi";
                        strArr2[1] = "4wM";
                        if (zEquals) {
                            j2 = c07879a.A01.A02.A04.A03;
                        } else {
                            j2 = this.A02;
                            this.A02 = j2 + 1;
                        }
                    }
                } else {
                    j2 = this.A02;
                    this.A02 = j2 + 1;
                }
            } else {
                jLongValue = 0;
            }
            return A06(A07(iA03, jLongValue, j2), jLongValue, jLongValue);
        }
        EW ew = c07889b.A04;
        this.A07.A09(ew.A02, this.A0A);
        if (ew.A01()) {
            int i2 = ew.A00;
            int iA01 = this.A0A.A01(i2);
            if (iA01 == -1) {
                return null;
            }
            int iA04 = this.A0A.A03(i2, ew.A01);
            if (iA04 >= iA01) {
                return A02(ew.A02, c07889b.A00, ew.A03);
            }
            if (this.A0A.A0E(i2, iA04)) {
                return A01(ew.A02, i2, iA04, c07889b.A00, ew.A03);
            }
            return null;
        }
        long j3 = c07889b.A02;
        String[] strArr3 = A0C;
        if (strArr3[6].length() == strArr3[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr4 = A0C;
        strArr4[4] = "Mkh";
        strArr4[1] = "LRN";
        if (j3 != Long.MIN_VALUE) {
            int iA05 = this.A0A.A05(c07889b.A02);
            if (iA05 == -1) {
                return A02(ew.A02, c07889b.A02, ew.A03);
            }
            int iA02 = this.A0A.A02(iA05);
            if (this.A0A.A0E(iA05, iA02)) {
                return A01(ew.A02, iA05, iA02, c07889b.A02, ew.A03);
            }
            return null;
        }
        int iA00 = this.A0A.A00();
        if (iA00 == 0) {
            return null;
        }
        int i3 = iA00 - 1;
        if (this.A0A.A09(i3) == Long.MIN_VALUE) {
            C08099x c08099x = this.A0A;
            if (A0C[3].charAt(17) == 'q') {
                String[] strArr5 = A0C;
                strArr5[6] = "v4RqMCCMyohjhj";
                strArr5[0] = "VaJ";
                if (!c08099x.A0D(i3)) {
                    int iA06 = this.A0A.A02(i3);
                    if (!this.A0A.A0E(i3, iA06)) {
                        String[] strArr6 = A0C;
                        if (strArr6[6].length() == strArr6[0].length()) {
                            return null;
                        }
                        A0C[2] = "nHRVyYi6CwR1mKhXGjDN4SEBRB6Sc1lP";
                        return null;
                    }
                    long jA07 = this.A0A.A07();
                    int i4 = ew.A02;
                    String[] strArr7 = A0C;
                    if (strArr7[5].length() != strArr7[7].length()) {
                        throw new RuntimeException();
                    }
                    A0C[2] = "rKR9SUNE0wWlvttO7fw3rD4zdQIUaCm2";
                    return A01(i4, i3, iA06, jA07, ew.A03);
                }
            }
        }
        if (A0C[2].charAt(9) != 'w') {
            return null;
        }
        String[] strArr8 = A0C;
        strArr8[6] = "OaXxy4ZAPPYV9k";
        strArr8[0] = "tU4";
        return null;
        throw new RuntimeException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 19
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private C07889b A04(C07889b c07889b, EW ew) {
        long jA07;
        long j = c07889b.A03;
        long j2 = c07889b.A02;
        boolean zA0A = A0A(ew, j2);
        boolean zA0B = A0B(ew, zA0A);
        this.A07.A09(ew.A02, this.A0A);
        if (ew.A01()) {
            jA07 = this.A0A.A0A(ew.A00, ew.A01);
        } else {
            jA07 = j2 == Long.MIN_VALUE ? this.A0A.A07() : j2;
        }
        return new C07889b(ew, j, j2, c07889b.A00, jA07, zA0A, zA0B);
    }

    private long A00(int i) {
        int oldFrontPeriodIndex;
        Object obj = this.A07.A0A(i, this.A0A, true).A03;
        int holderWindowIndex = this.A0A.A00;
        Object obj2 = this.A08;
        if (obj2 != null && (oldFrontPeriodIndex = this.A07.A04(obj2)) != -1 && this.A07.A09(oldFrontPeriodIndex, this.A0A).A00 == holderWindowIndex) {
            return this.A03;
        }
        for (C07879a c07879aA0E = A0E(); c07879aA0E != null; c07879aA0E = c07879aA0E.A01) {
            Object periodUid = c07879aA0E.A09;
            if (periodUid.equals(obj)) {
                return c07879aA0E.A02.A04.A03;
            }
        }
        for (C07879a c07879aA0E2 = A0E(); c07879aA0E2 != null; c07879aA0E2 = c07879aA0E2.A01) {
            AbstractC08119z abstractC08119z = this.A07;
            Object periodUid2 = c07879aA0E2.A09;
            int iA04 = abstractC08119z.A04(periodUid2);
            if (iA04 != -1 && this.A07.A09(iA04, this.A0A).A00 == holderWindowIndex) {
                return c07879aA0E2.A02.A04.A03;
            }
        }
        long j = this.A02;
        this.A02 = 1 + j;
        return j;
    }

    private C07889b A01(int i, int i2, int i3, long j, long j2) {
        long jA06;
        EW ew = new EW(i, i2, i3, j2);
        boolean zA0A = A0A(ew, Long.MIN_VALUE);
        boolean zA0B = A0B(ew, zA0A);
        long jA0A = this.A07.A09(ew.A02, this.A0A).A0A(ew.A00, ew.A01);
        if (i3 == this.A0A.A02(i2)) {
            jA06 = this.A0A.A06();
        } else {
            jA06 = 0;
        }
        return new C07889b(ew, jA06, Long.MIN_VALUE, j, jA0A, zA0A, zA0B);
    }

    private C07889b A05(C07919e c07919e) {
        return A06(c07919e.A04, c07919e.A01, c07919e.A02);
    }

    private C07889b A06(EW ew, long j, long j2) {
        this.A07.A09(ew.A02, this.A0A);
        if (ew.A01()) {
            if (!this.A0A.A0E(ew.A00, ew.A01)) {
                return null;
            }
            return A01(ew.A02, ew.A00, ew.A01, j, ew.A03);
        }
        return A02(ew.A02, j2, ew.A03);
    }

    private EW A07(int i, long j, long j2) {
        this.A07.A09(i, this.A0A);
        int iA05 = this.A0A.A05(j);
        if (iA05 == -1) {
            return new EW(i, j2);
        }
        return new EW(i, iA05, this.A0A.A02(iA05), j2);
    }

    private boolean A08() {
        C07879a c07879aA0E = A0E();
        if (c07879aA0E == null) {
            return true;
        }
        while (true) {
            int iA03 = this.A07.A03(c07879aA0E.A02.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            while (lastValidPeriodHolder != null && !c07879aA0E.A02.A06) {
                c07879aA0E = c07879aA0E.A01;
            }
            if (iA03 == -1) {
                break;
            }
            C07879a lastValidPeriodHolder = c07879aA0E.A01;
            if (lastValidPeriodHolder == null) {
                break;
            }
            C07879a lastValidPeriodHolder2 = c07879aA0E.A01;
            int i = lastValidPeriodHolder2.A02.A04.A02;
            if (A0C[3].charAt(17) != 'q') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[4] = "04e";
            strArr[1] = "fTm";
            if (i != iA03) {
                break;
            }
            c07879aA0E = c07879aA0E.A01;
        }
        boolean readingPeriodRemoved = A0S(c07879aA0E);
        c07879aA0E.A02 = A04(c07879aA0E.A02, c07879aA0E.A02.A04);
        return (readingPeriodRemoved && A0P()) ? false : true;
    }

    private boolean A09(C07879a c07879a, C07889b c07889b) {
        C07889b c07889b2 = c07879a.A02;
        return c07889b2.A03 == c07889b.A03 && c07889b2.A02 == c07889b.A02 && c07889b2.A04.equals(c07889b.A04);
    }

    private boolean A0A(EW ew, long j) {
        int adGroupCount = this.A07.A09(ew.A02, this.A0A).A00();
        if (adGroupCount == 0) {
            return true;
        }
        int i = adGroupCount - 1;
        boolean zA01 = ew.A01();
        if (this.A0A.A09(i) != Long.MIN_VALUE) {
            return !zA01 && j == Long.MIN_VALUE;
        }
        int postrollAdCount = this.A0A.A01(i);
        if (A0C[3].charAt(17) != 'q') {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[4] = "dZB";
        strArr[1] = "bbK";
        if (postrollAdCount == -1) {
            return false;
        }
        if (((zA01 && ew.A00 == i && ew.A01 == postrollAdCount + (-1)) ? 1 : 0) == 0) {
            return !zA01 && this.A0A.A02(i) == postrollAdCount;
        }
        return true;
    }

    private boolean A0B(EW ew, boolean z) {
        return !this.A07.A0B(this.A07.A09(ew.A02, this.A0A).A00, this.A0B).A08 && this.A07.A0F(ew.A02, this.A0A, this.A0B, this.A01, this.A09) && z;
    }

    public final C07879a A0C() {
        C07879a c07879a = this.A05;
        if (c07879a != null) {
            if (c07879a == this.A06) {
                this.A06 = c07879a.A01;
            }
            this.A05.A0D();
            int i = this.A00 - 1;
            this.A00 = i;
            if (i == 0) {
                this.A04 = null;
                this.A08 = this.A05.A09;
                this.A03 = this.A05.A02.A04.A03;
            }
            C07879a c07879a2 = this.A05.A01;
            if (A0C[3].charAt(17) != 'q') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[5] = "umGBE5C5CuHWhY73AVgogVf";
            strArr[7] = "vM8t2ZsrAby17UFg4572Zd2";
            this.A05 = c07879a2;
        } else {
            C07879a c07879a3 = this.A04;
            this.A05 = c07879a3;
            this.A06 = c07879a3;
        }
        return this.A05;
    }

    public final C07879a A0D() {
        C07879a c07879a = this.A06;
        HI.A04((c07879a == null || c07879a.A01 == null) ? false : true);
        C07879a c07879a2 = this.A06.A01;
        this.A06 = c07879a2;
        return c07879a2;
    }

    public final C07879a A0E() {
        return A0P() ? this.A05 : this.A04;
    }

    public final C07879a A0F() {
        return this.A04;
    }

    public final C07879a A0G() {
        return this.A05;
    }

    public final C07879a A0H() {
        return this.A06;
    }

    public final C07889b A0I(long j, C07919e c07919e) {
        C07879a c07879a = this.A04;
        if (c07879a == null) {
            return A05(c07919e);
        }
        return A03(c07879a, j);
    }

    public final C07889b A0J(C07889b c07889b, int i) {
        return A04(c07889b, c07889b.A04.A00(i));
    }

    public final InterfaceC1337Vg A0K(InterfaceC08059s[] interfaceC08059sArr, GR gr, GU gu, EY ey, Object obj, C07889b c07889b) {
        long jA07;
        C07879a c07879a = this.A04;
        if (c07879a != null) {
            jA07 = c07879a.A07() + this.A04.A02.A01;
            String[] strArr = A0C;
            if (strArr[6].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[5] = "XFCrwzIN7SxWEMf0fznSlHt";
            strArr2[7] = "zDOSpelqL3O1zvPqWZMR4dG";
        } else {
            jA07 = c07889b.A03;
        }
        C07879a c07879a2 = new C07879a(interfaceC08059sArr, jA07, gr, gu, ey, obj, c07889b);
        if (this.A04 != null) {
            HI.A04(A0P());
            this.A04.A01 = c07879a2;
        }
        this.A08 = null;
        this.A04 = c07879a2;
        this.A00++;
        return c07879a2.A08;
    }

    public final EW A0L(int i, long j) {
        return A07(i, j, A00(i));
    }

    public final void A0M(long j) {
        C07879a c07879a = this.A04;
        if (c07879a != null) {
            c07879a.A0G(j);
        }
    }

    public final void A0N(AbstractC08119z abstractC08119z) {
        this.A07 = abstractC08119z;
    }

    public final void A0O(boolean z) {
        C07879a c07879aA0E = A0E();
        if (c07879aA0E != null) {
            this.A08 = z ? c07879aA0E.A09 : null;
            this.A03 = c07879aA0E.A02.A04.A03;
            c07879aA0E.A0D();
            A0S(c07879aA0E);
        } else if (!z) {
            this.A08 = null;
        }
        this.A05 = null;
        this.A04 = null;
        this.A06 = null;
        this.A00 = 0;
    }

    public final boolean A0P() {
        return this.A05 != null;
    }

    public final boolean A0Q() {
        C07879a c07879a = this.A04;
        return c07879a == null || (!c07879a.A02.A05 && this.A04.A0H() && this.A04.A02.A01 != -9223372036854775807L && this.A00 < 100);
    }

    public final boolean A0R(int i) {
        this.A01 = i;
        return A08();
    }

    public final boolean A0S(C07879a c07879a) {
        HI.A04(c07879a != null);
        boolean z = false;
        String[] strArr = A0C;
        if (strArr[4].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[4] = "VEc";
        strArr2[1] = "0t0";
        this.A04 = c07879a;
        while (c07879a.A01 != null) {
            c07879a = c07879a.A01;
            if (c07879a == this.A06) {
                this.A06 = this.A05;
                z = true;
            }
            c07879a.A0D();
            this.A00--;
        }
        this.A04.A01 = null;
        return z;
    }

    public final boolean A0T(InterfaceC1337Vg interfaceC1337Vg) {
        C07879a c07879a = this.A04;
        return c07879a != null && c07879a.A08 == interfaceC1337Vg;
    }

    public final boolean A0U(EW ew, long j) {
        int iA03 = ew.A02;
        C07879a c07879a = null;
        for (C07879a previousPeriodHolder = A0E(); previousPeriodHolder != null; previousPeriodHolder = previousPeriodHolder.A01) {
            if (c07879a == null) {
                C07889b periodInfo = previousPeriodHolder.A02;
                if (A0C[3].charAt(17) != 'q') {
                    throw new RuntimeException();
                }
                String[] strArr = A0C;
                strArr[6] = "pn8srZEQfSJzxw";
                strArr[0] = "zNd";
                previousPeriodHolder.A02 = A0J(periodInfo, iA03);
            } else {
                if (iA03 == -1 || !previousPeriodHolder.A09.equals(this.A07.A0A(iA03, this.A0A, true).A03)) {
                    return true ^ A0S(c07879a);
                }
                C07889b c07889bA03 = A03(c07879a, j);
                if (c07889bA03 == null) {
                    return true ^ A0S(c07879a);
                }
                previousPeriodHolder.A02 = A0J(previousPeriodHolder.A02, iA03);
                if (!A09(previousPeriodHolder, c07889bA03)) {
                    boolean zA0S = A0S(c07879a);
                    String[] strArr2 = A0C;
                    String str = strArr2[4];
                    String str2 = strArr2[1];
                    int length = str.length();
                    int periodIndex = str2.length();
                    if (length != periodIndex) {
                        return true ^ zA0S;
                    }
                    String[] strArr3 = A0C;
                    strArr3[5] = "009NTdXku0rfOoGLKxDbxOM";
                    strArr3[7] = "1WlPwvG5U3NzzyaZC20RJwC";
                    return true ^ zA0S;
                }
            }
            if (previousPeriodHolder.A02.A06) {
                iA03 = this.A07.A03(iA03, this.A0A, this.A0B, this.A01, this.A09);
            }
            c07879a = previousPeriodHolder;
        }
        return true;
    }

    public final boolean A0V(boolean z) {
        this.A09 = z;
        return A08();
    }
}
