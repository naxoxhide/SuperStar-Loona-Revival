package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.We, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1358We implements InterfaceC0838Ba {
    public static byte[] A0X;
    public static String[] A0Y = {"XdJWu", "FUlE3E4RGCFuY0n1jkLa4sDNStY", "LTfWg4MeBgD", "ea2mTe", "5aN4xnjUR54", "JRDUjTwIRED0cdRjG5ryaKaac6vLzQ8c", "s80pf3iUB", "VFz"};
    public static final InterfaceC0841Bd A0Z;
    public static final int A0a;
    public static final Format A0b;
    public static final byte[] A0c;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public InterfaceC0840Bc A0C;
    public CD A0D;
    public C0980Hh A0E;
    public boolean A0F;
    public boolean A0G;
    public InterfaceC0848Bm[] A0H;
    public InterfaceC0848Bm[] A0I;
    public final int A0J;
    public final SparseArray<CD> A0K;
    public final DrmInitData A0L;
    public final InterfaceC0848Bm A0M;
    public final CM A0N;
    public final C0980Hh A0O;
    public final C0980Hh A0P;
    public final C0980Hh A0Q;
    public final C0980Hh A0R;
    public final C0992Ht A0S;
    public final ArrayDeque<C1364Wk> A0T;
    public final ArrayDeque<CC> A0U;
    public final List<Format> A0V;
    public final byte[] A0W;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 35 out of bounds for length 35
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static int A00(CD cd, int i, long j, int i2, C0980Hh c0980Hh, int i3) {
        int iA0H;
        int iA08;
        int i4 = i3;
        long j2 = j;
        c0980Hh.A0Y(8);
        int iA00 = C1.A00(c0980Hh.A08());
        CM cm = cd.A05;
        CO co = cd.A07;
        C7 c7 = co.A07;
        co.A0E[i] = c0980Hh.A0H();
        co.A0G[i] = co.A05;
        if ((iA00 & 1) != 0) {
            long[] jArr = co.A0G;
            jArr[i] = jArr[i] + ((long) c0980Hh.A08());
        }
        boolean z = (iA00 & 4) != 0;
        int iA0H2 = c7.A01;
        if (z) {
            iA0H2 = c0980Hh.A0H();
        }
        boolean z2 = (iA00 & 256) != 0;
        boolean z3 = (iA00 & 512) != 0;
        boolean z4 = (iA00 & 1024) != 0;
        boolean z5 = (iA00 & 2048) != 0;
        long jA0F = 0;
        if (cm.A08 != null && cm.A08.length == 1 && cm.A08[0] == 0) {
            jA0F = C0996Hx.A0F(cm.A09[0], 1000L, cm.A06);
        }
        int[] iArr = co.A0D;
        int[] iArr2 = co.A0C;
        long[] jArr2 = co.A0F;
        boolean[] zArr = co.A0I;
        boolean z6 = cm.A03 == 2 && (i2 & 1) != 0;
        int i5 = i4 + co.A0E[i];
        long j3 = cm.A06;
        if (i > 0) {
            j2 = co.A06;
        }
        while (i4 < i5) {
            int iA0H3 = z2 ? c0980Hh.A0H() : c7.A00;
            if (z3) {
                iA0H = c0980Hh.A0H();
            } else {
                iA0H = c7.A03;
                if (A0Y[5].charAt(2) == 'C') {
                    throw new RuntimeException();
                }
                A0Y[6] = "dkwnFPd0";
            }
            if (i4 == 0 && z) {
                iA08 = iA0H2;
            } else {
                iA08 = z4 ? c0980Hh.A08() : c7.A01;
            }
            if (z5) {
                iArr2[i4] = (int) ((((long) c0980Hh.A08()) * 1000) / j3);
            } else {
                iArr2[i4] = 0;
            }
            jArr2[i4] = C0996Hx.A0F(j2, 1000L, j3) - jA0F;
            iArr[i4] = iA0H;
            zArr[i4] = ((iA08 >> 16) & 1) == 0 && (!z6 || i4 == 0);
            j2 += (long) iA0H3;
            i4++;
        }
        co.A06 = j2;
        return i5;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 24 out of bounds for length 23
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Pair<Long, X5> A04(C0980Hh c0980Hh, long j) throws C07909d {
        long jA0N;
        long jA0N2;
        c0980Hh.A0Y(8);
        int iA01 = C1.A01(c0980Hh.A08());
        c0980Hh.A0Z(4);
        long jA0M = c0980Hh.A0M();
        if (iA01 == 0) {
            jA0N = c0980Hh.A0M();
            jA0N2 = j + c0980Hh.A0M();
        } else {
            jA0N = c0980Hh.A0N();
            jA0N2 = j + c0980Hh.A0N();
        }
        long jA0F = C0996Hx.A0F(jA0N, 1000000L, jA0M);
        c0980Hh.A0Z(2);
        int iA0I = c0980Hh.A0I();
        int[] iArr = new int[iA0I];
        long[] jArr = new long[iA0I];
        long[] jArr2 = new long[iA0I];
        long[] jArr3 = new long[iA0I];
        long jA0F2 = jA0F;
        for (int i = 0; i < iA0I; i++) {
            int iA08 = c0980Hh.A08();
            if ((Integer.MIN_VALUE & iA08) != 0) {
                throw new C07909d(A0A(581, 28, 126));
            }
            long jA0M2 = c0980Hh.A0M();
            iArr[i] = Integer.MAX_VALUE & iA08;
            jArr[i] = jA0N2;
            jArr3[i] = jA0F2;
            jA0N += jA0M2;
            jA0F2 = C0996Hx.A0F(jA0N, 1000000L, jA0M);
            jArr2[i] = jA0F2 - jArr3[i];
            c0980Hh.A0Z(4);
            jA0N2 += (long) iArr[i];
        }
        return Pair.create(Long.valueOf(jA0F), new X5(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 12 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static CD A09(C0980Hh c0980Hh, SparseArray<CD> sparseArray) {
        c0980Hh.A0Y(8);
        int iA00 = C1.A00(c0980Hh.A08());
        CD cdA08 = A08(sparseArray, c0980Hh.A08());
        if (cdA08 == null) {
            return null;
        }
        if ((iA00 & 1) != 0) {
            long jA0N = c0980Hh.A0N();
            cdA08.A07.A05 = jA0N;
            cdA08.A07.A04 = jA0N;
        }
        C7 c7 = cdA08.A04;
        cdA08.A07.A07 = new C7((iA00 & 2) != 0 ? c0980Hh.A0H() - 1 : c7.A02, (iA00 & 8) != 0 ? c0980Hh.A0H() : c7.A00, (iA00 & 16) != 0 ? c0980Hh.A0H() : c7.A03, (iA00 & 32) != 0 ? c0980Hh.A0H() : c7.A01);
        return cdA08;
    }

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0X, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0X = new byte[]{117, 121, 84, 97, 122, 120, 53, 102, 124, 111, 112, 53, 121, 112, 102, 102, 53, 97, 125, 116, 123, 53, 125, 112, 116, 113, 112, 103, 53, 121, 112, 123, 114, 97, 125, 53, Base64.padSymbol, 96, 123, 102, 96, 101, 101, 122, 103, 97, 112, 113, 60, 59, 114, 89, 67, 69, 78, 23, 84, 88, 66, 89, 67, 23, 94, 89, 23, 68, 85, 80, 71, 23, 22, 10, 23, 6, 23, 31, 66, 89, 68, 66, 71, 71, 88, 69, 67, 82, 83, 30, 25, 119, 92, 70, SignedBytes.MAX_POWER_OF_TWO, 75, 18, 81, 93, 71, 92, 70, 18, 91, 92, 18, 65, 85, 66, 86, 18, 19, 15, 18, 3, 18, 26, 71, 92, 65, 71, 66, 66, 93, SignedBytes.MAX_POWER_OF_TWO, 70, 87, 86, 27, 28, 57, 13, 30, 24, 18, 26, 17, 11, 26, 27, 50, 15, 75, 58, 7, 11, 13, 30, 28, 11, 16, 13, 0, 46, 39, 38, 59, 32, 39, 46, 105, 39, 44, 46, 40, Base64.padSymbol, 32, 63, 44, 105, 38, 47, 47, 58, 44, Base64.padSymbol, 105, Base64.padSymbol, 38, 105, 58, 40, 36, 57, 37, 44, 105, 45, 40, Base64.padSymbol, 40, 103, 51, 26, 30, 25, 95, 30, 11, 16, 18, 95, 27, 26, 25, 22, 17, 26, 12, 95, 26, 7, 11, 26, 17, 27, 26, 27, 95, 30, 11, 16, 18, 95, 12, 22, 5, 26, 95, 87, 10, 17, 12, 10, 15, 15, 16, 13, 11, 26, 27, 86, 81, 30, 55, 51, 52, 114, 51, 38, Base64.padSymbol, 63, 114, 37, 59, 38, 58, 114, 62, 55, 60, 53, 38, 58, 114, 108, 114, 96, 99, 102, 101, 102, 106, 97, 100, 102, 101, 114, 122, 39, 60, 33, 39, 34, 34, Base64.padSymbol, 32, 38, 55, 54, 123, 124, 63, 22, 29, 20, 7, 27, 83, 30, 26, 0, 30, 18, 7, 16, 27, 73, 83, 15, 38, 38, 51, 37, 52, 96, 52, 47, 96, 37, 46, 35, 50, 57, 48, 52, 41, 47, 46, 96, 36, 33, 52, 33, 96, 55, 33, 51, 96, 46, 37, 39, 33, 52, 41, 54, 37, 110, 16, 57, 57, 44, 58, 43, 127, 43, 48, 127, 58, 49, 59, 127, 48, 57, 127, 50, 59, 62, 43, 127, 40, 62, 44, 127, 49, 58, 56, 62, 43, 54, 41, 58, 113, 106, 83, SignedBytes.MAX_POWER_OF_TWO, 87, 87, 76, 65, 76, 75, 66, 5, 113, 87, 68, 70, 78, 96, 75, 70, 87, 92, 85, 81, 76, 74, 75, 103, 74, 93, 5, 85, 68, 87, 68, 72, SignedBytes.MAX_POWER_OF_TWO, 81, SignedBytes.MAX_POWER_OF_TWO, 87, 86, 5, 76, 86, 5, 80, 75, 86, 80, 85, 85, 74, 87, 81, SignedBytes.MAX_POWER_OF_TWO, 65, 11, 14, 54, 52, 45, 45, 56, 57, 125, 45, 46, 46, 53, 125, 60, 41, 50, 48, 125, 117, 59, 60, 52, 49, 56, 57, 125, 41, 50, 125, 56, 37, 41, 47, 60, 62, 41, 125, 40, 40, 52, 57, 116, 54, 14, 12, 21, 21, 12, 11, 2, 69, 4, 17, 10, 8, 69, 18, 12, 17, 13, 69, 9, 0, 11, 2, 17, 13, 69, 91, 69, 87, 84, 81, 82, 81, 93, 86, 83, 81, 82, 69, 77, 16, 11, 22, 16, 21, 21, 10, 23, 17, 0, 1, 76, 75, 62, 5, 14, 19, 27, 14, 8, 31, 14, 15, 75, 6, 4, 4, 29, 75, 9, 4, 19, 69, 13, 54, Base64.padSymbol, 32, 40, Base64.padSymbol, 59, 44, Base64.padSymbol, 60, 120, 43, 57, 49, 55, 120, Base64.padSymbol, 54, 44, 42, 33, 120, 59, 55, 45, 54, 44, 98, 120, 76, 119, 113, 120, 119, 125, 117, 124, 125, 57, 112, 119, 125, 112, 107, 124, 122, 109, 57, 107, 124, 127, 124, 107, 124, 119, 122, 124, 58, 13, 30, 5, 13, 14, 0, 9, 76, 0, 9, 2, 11, 24, 4, 76, 8, 9, 31, 15, 30, 5, 28, 24, 5, 3, 2, 76, 5, 2, 76, 31, 11, 28, 8, 76, 10, 3, 25, 2, 8, 76, 68, 25, 2, 31, 25, 28, 28, 3, 30, 24, 9, 8, 69, 31, 14, 14, 18, 23, 29, 31, 10, 23, 17, 16, 81, 6, 83, 27, 19, 13, 25, 3, 21, 25, 23, 23, 8, 5, 4, 14, 78, 9, 4, 23, 2, 6, 25, 20, 21, 31, 95, 29, 0, 68};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0K(C1364Wk c1364Wk) throws C07909d {
        HI.A06(this.A0N == null, A0A(532, 20, 12));
        DrmInitData drmInitDataA05 = this.A0L;
        if (drmInitDataA05 == null) {
            drmInitDataA05 = A05(c1364Wk.A02);
        }
        C1364Wk c1364WkA06 = c1364Wk.A06(C1.A0n);
        SparseArray<C7> sparseArray = new SparseArray<>();
        long jA01 = -9223372036854775807L;
        int size = c1364WkA06.A02.size();
        for (int i = 0; i < size; i++) {
            C1363Wj c1363Wj = c1364WkA06.A02.get(i);
            if (((C1) c1363Wj).A00 == C1.A1N) {
                Pair<Integer, C7> pairA03 = A03(c1363Wj.A00);
                sparseArray.put(((Integer) pairA03.first).intValue(), (C7) pairA03.second);
            } else if (((C1) c1363Wj).A00 == C1.A0g) {
                jA01 = A01(c1363Wj.A00);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c1364Wk.A01.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C1364Wk c1364Wk2 = c1364Wk.A01.get(i2);
            if (((C1) c1364Wk2).A00 == C1.A1M) {
                CM cmA0C = C6.A0C(c1364Wk2, c1364Wk.A07(C1.A0o), jA01, drmInitDataA05, (this.A0J & 16) != 0, false);
                if (cmA0C != null) {
                    sparseArray2.put(cmA0C.A00, cmA0C);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.A0K.size() != 0) {
            HI.A04(this.A0K.size() == size3);
            for (int i3 = 0; i3 < size3; i3++) {
                CM cm = (CM) sparseArray2.valueAt(i3);
                this.A0K.get(cm.A00).A07(cm, A06(sparseArray, cm.A00));
            }
            return;
        }
        for (int i4 = 0; i4 < size3; i4++) {
            CM cm2 = (CM) sparseArray2.valueAt(i4);
            CD cd = new CD(this.A0C.AFx(i4, cm2.A03));
            cd.A07(cm2, A06(sparseArray, cm2.A00));
            this.A0K.put(cm2.A00, cd);
            this.A08 = Math.max(this.A08, cm2.A04);
        }
        A0C();
        this.A0C.A5T();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A0M(C1364Wk c1364Wk, SparseArray<CD> sparseArray, int i, byte[] bArr) throws C07909d {
        CD cdA09 = A09(c1364Wk.A07(C1.A1J).A00, sparseArray);
        if (cdA09 == null) {
            return;
        }
        CO co = cdA09.A07;
        long jA02 = co.A06;
        cdA09.A04();
        if (c1364Wk.A07(C1.A1I) != null && (i & 2) == 0) {
            jA02 = A02(c1364Wk.A07(C1.A1I).A00);
        }
        A0N(c1364Wk, cdA09, jA02, i);
        CN cnA00 = cdA09.A05.A00(co.A07.A02);
        C1363Wj c1363WjA07 = c1364Wk.A07(C1.A0v);
        if (c1363WjA07 != null) {
            A0P(cnA00, c1363WjA07.A00, co);
        }
        C1363Wj c1363WjA08 = c1364Wk.A07(C1.A0u);
        if (c1363WjA08 != null) {
            A0S(c1363WjA08.A00, co);
        }
        C1363Wj c1363WjA09 = c1364Wk.A07(C1.A11);
        if (c1363WjA09 != null) {
            A0T(c1363WjA09.A00, co);
        }
        C1363Wj c1363WjA010 = c1364Wk.A07(C1.A0y);
        C1363Wj c1363WjA011 = c1364Wk.A07(C1.A12);
        if (c1363WjA010 != null && c1363WjA011 != null) {
            A0V(c1363WjA010.A00, c1363WjA011.A00, cnA00 != null ? cnA00.A02 : null, co);
        }
        int size = c1364Wk.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1363Wj c1363Wj = c1364Wk.A02.get(i2);
            if (A0Y[7].length() != 3) {
                throw new RuntimeException();
            }
            A0Y[7] = "89j";
            C1363Wj c1363Wj2 = c1363Wj;
            if (((C1) c1363Wj2).A00 == C1.A1R) {
                A0U(c1363Wj2.A00, co, bArr);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A0P(CN cn, C0980Hh c0980Hh, CO co) throws C07909d {
        int i = cn.A00;
        c0980Hh.A0Y(8);
        if ((C1.A00(c0980Hh.A08()) & 1) == 1) {
            c0980Hh.A0Z(8);
        }
        int iA0E = c0980Hh.A0E();
        int iA0H = c0980Hh.A0H();
        if (iA0H != co.A00) {
            throw new C07909d(A0A(290, 17, 20) + iA0H + A0A(0, 2, 62) + co.A00);
        }
        int i2 = 0;
        if (iA0E == 0) {
            boolean[] zArr = co.A0H;
            for (int i3 = 0; i3 < iA0H; i3++) {
                int iA0E2 = c0980Hh.A0E();
                i2 += iA0E2;
                zArr[i3] = iA0E2 > i;
            }
        } else {
            i2 = 0 + (iA0E * iA0H);
            Arrays.fill(co.A0H, 0, iA0H, iA0E > i);
        }
        co.A02(i2);
        if (A0Y[6].length() == 17) {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[2] = "tC3WLCXP6DZ";
        strArr[4] = "0Zxl8CEli3D";
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A0V(C0980Hh c0980Hh, C0980Hh c0980Hh2, String str, CO co) throws C07909d {
        c0980Hh.A0Y(8);
        int iA08 = c0980Hh.A08();
        int iA09 = c0980Hh.A08();
        int i = A0a;
        if (iA09 != i) {
            return;
        }
        if (C1.A01(iA08) == 1) {
            c0980Hh.A0Z(4);
        }
        if (c0980Hh.A08() != 1) {
            throw new C07909d(A0A(50, 39, 80));
        }
        c0980Hh2.A0Y(8);
        int iA010 = c0980Hh2.A08();
        if (c0980Hh2.A08() != i) {
            return;
        }
        int iA01 = C1.A01(iA010);
        if (iA01 == 1) {
            if (c0980Hh2.A0M() == 0) {
                throw new C07909d(A0A(609, 55, 11));
            }
        } else if (iA01 >= 2) {
            c0980Hh2.A0Z(4);
        }
        if (c0980Hh2.A0M() != 1) {
            throw new C07909d(A0A(89, 39, 85));
        }
        c0980Hh2.A0Z(1);
        int iA0E = c0980Hh2.A0E();
        int i2 = (iA0E & 240) >> 4;
        int i3 = iA0E & 15;
        boolean z = c0980Hh2.A0E() == 1;
        if (z) {
            int iA0E2 = c0980Hh2.A0E();
            byte[] bArr = new byte[16];
            c0980Hh2.A0c(bArr, 0, bArr.length);
            byte[] bArr2 = null;
            if (z && iA0E2 == 0) {
                int iA0E3 = c0980Hh2.A0E();
                bArr2 = new byte[iA0E3];
                c0980Hh2.A0c(bArr2, 0, iA0E3);
            }
            co.A0A = true;
            co.A08 = new CN(z, str, iA0E2, bArr, i2, i3, bArr2);
        }
    }

    static {
        A0D();
        A0Z = new C1359Wf();
        A0a = C0996Hx.A08(A0A(682, 4, 23));
        A0c = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
        A0b = Format.A02(null, A0A(664, 18, 25), Long.MAX_VALUE);
    }

    public C1358We() {
        this(0);
    }

    public C1358We(int i) {
        this(i, null);
    }

    public C1358We(int i, C0992Ht c0992Ht) {
        this(i, c0992Ht, null, null);
    }

    public C1358We(int i, C0992Ht c0992Ht, CM cm, DrmInitData drmInitData) {
        this(i, c0992Ht, cm, drmInitData, Collections.emptyList());
    }

    public C1358We(int i, C0992Ht c0992Ht, CM cm, DrmInitData drmInitData, List<Format> closedCaptionFormats) {
        this(i, c0992Ht, cm, drmInitData, closedCaptionFormats, null);
    }

    public C1358We(int i, C0992Ht c0992Ht, CM cm, DrmInitData drmInitData, List<Format> closedCaptionFormats, InterfaceC0848Bm interfaceC0848Bm) {
        this.A0J = (cm != null ? 8 : 0) | i;
        this.A0S = c0992Ht;
        this.A0N = cm;
        this.A0L = drmInitData;
        this.A0V = Collections.unmodifiableList(closedCaptionFormats);
        this.A0M = interfaceC0848Bm;
        this.A0O = new C0980Hh(16);
        this.A0R = new C0980Hh(C0976Hd.A03);
        this.A0Q = new C0980Hh(5);
        this.A0P = new C0980Hh();
        this.A0W = new byte[16];
        this.A0T = new ArrayDeque<>();
        this.A0U = new ArrayDeque<>();
        this.A0K = new SparseArray<>();
        this.A08 = -9223372036854775807L;
        this.A0A = -9223372036854775807L;
        this.A0B = -9223372036854775807L;
        A0B();
    }

    public static long A01(C0980Hh c0980Hh) {
        c0980Hh.A0Y(8);
        int fullAtom = c0980Hh.A08();
        return C1.A01(fullAtom) == 0 ? c0980Hh.A0M() : c0980Hh.A0N();
    }

    public static long A02(C0980Hh c0980Hh) {
        c0980Hh.A0Y(8);
        int fullAtom = c0980Hh.A08();
        int version = C1.A01(fullAtom);
        return version == 1 ? c0980Hh.A0N() : c0980Hh.A0M();
    }

    public static Pair<Integer, C7> A03(C0980Hh c0980Hh) {
        c0980Hh.A0Y(12);
        int defaultSampleDescriptionIndex = c0980Hh.A08();
        int trackId = c0980Hh.A0H();
        int defaultSampleFlags = c0980Hh.A0H();
        int defaultSampleSize = c0980Hh.A0H();
        int defaultSampleDuration = c0980Hh.A08();
        return Pair.create(Integer.valueOf(defaultSampleDescriptionIndex), new C7(trackId - 1, defaultSampleFlags, defaultSampleSize, defaultSampleDuration));
    }

    public static DrmInitData A05(List<C1363Wj> list) {
        ArrayList arrayList = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C1363Wj c1363Wj = list.get(i);
            int leafChildrenSize = ((C1) c1363Wj).A00;
            if (leafChildrenSize == C1.A0s) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = c1363Wj.A00.A00;
                UUID uuidA03 = CJ.A03(bArr);
                int leafChildrenSize2 = A0Y[3].length();
                if (leafChildrenSize2 != 6) {
                    throw new RuntimeException();
                }
                A0Y[7] = "tzO";
                if (uuidA03 == null) {
                    Log.w(A0A(128, 22, 24), A0A(437, 42, 58));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA03, A0A(696, 9, 23), bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private C7 A06(SparseArray<C7> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (C7) HI.A01(sparseArray.get(i));
    }

    public static CD A07(SparseArray<CD> sparseArray) {
        CD cd = null;
        long trunOffset = Long.MAX_VALUE;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            CD cdValueAt = sparseArray.valueAt(i);
            int i2 = cdValueAt.A02;
            if (A0Y[1].length() == 5) {
                throw new RuntimeException();
            }
            A0Y[0] = "VXm0n";
            if (i2 != cdValueAt.A07.A02) {
                long nextTrackRunOffset = cdValueAt.A07.A0G[cdValueAt.A02];
                if (nextTrackRunOffset < trunOffset) {
                    cd = cdValueAt;
                    trunOffset = nextTrackRunOffset;
                }
            }
        }
        return cd;
    }

    public static CD A08(SparseArray<CD> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i);
    }

    private void A0B() {
        this.A02 = 0;
        this.A00 = 0;
    }

    private void A0C() {
        if (this.A0I == null) {
            InterfaceC0848Bm[] interfaceC0848BmArr = new InterfaceC0848Bm[2];
            this.A0I = interfaceC0848BmArr;
            int i = 0;
            InterfaceC0848Bm interfaceC0848Bm = this.A0M;
            if (interfaceC0848Bm != null) {
                interfaceC0848BmArr[0] = interfaceC0848Bm;
                i = 0 + 1;
            }
            if ((this.A0J & 4) != 0) {
                int emsgTrackOutputCount = i + 1;
                interfaceC0848BmArr[i] = this.A0C.AFx(this.A0K.size(), 4);
                i = emsgTrackOutputCount;
            }
            InterfaceC0848Bm[] interfaceC0848BmArr2 = (InterfaceC0848Bm[]) Arrays.copyOf(this.A0I, i);
            this.A0I = interfaceC0848BmArr2;
            for (InterfaceC0848Bm interfaceC0848Bm2 : interfaceC0848BmArr2) {
                interfaceC0848Bm2.A5j(A0b);
            }
        }
        InterfaceC0848Bm[] interfaceC0848BmArr3 = this.A0H;
        if (A0Y[6].length() == 17) {
            throw new RuntimeException();
        }
        A0Y[3] = "8HQd7O";
        if (interfaceC0848BmArr3 == null) {
            this.A0H = new InterfaceC0848Bm[this.A0V.size()];
            for (int i2 = 0; i2 < i; i2++) {
                InterfaceC0840Bc interfaceC0840Bc = this.A0C;
                int i3 = this.A0K.size();
                InterfaceC0848Bm output = interfaceC0840Bc.AFx(i3 + 1 + i2, 3);
                output.A5j(this.A0V.get(i2));
                this.A0H[i2] = output;
            }
        }
    }

    private void A0E(long j) {
        while (!this.A0U.isEmpty()) {
            CC ccRemoveFirst = this.A0U.removeFirst();
            this.A03 -= ccRemoveFirst.A00;
            long jA06 = j + ccRemoveFirst.A01;
            C0992Ht c0992Ht = this.A0S;
            if (c0992Ht != null) {
                jA06 = c0992Ht.A06(jA06);
            }
            InterfaceC0848Bm[] interfaceC0848BmArr = this.A0I;
            if (A0Y[7].length() != 3) {
                throw new RuntimeException();
            }
            A0Y[7] = "ltl";
            for (InterfaceC0848Bm interfaceC0848Bm : interfaceC0848BmArr) {
                interfaceC0848Bm.AEs(jA06, 1, ccRemoveFirst.A00, this.A03, null);
            }
        }
    }

    private void A0F(long j) throws C07909d {
        while (!this.A0T.isEmpty() && this.A0T.peek().A00 == j) {
            A0I(this.A0T.pop());
        }
        A0B();
    }

    private void A0G(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        int i = ((int) this.A07) - this.A00;
        C0980Hh c0980Hh = this.A0E;
        if (c0980Hh != null) {
            interfaceC0839Bb.readFully(c0980Hh.A00, 8, i);
            int atomPayloadSize = this.A01;
            A0O(new C1363Wj(atomPayloadSize, this.A0E), interfaceC0839Bb.A7a());
        } else {
            interfaceC0839Bb.AFe(i);
        }
        A0F(interfaceC0839Bb.A7a());
        String[] strArr = A0Y;
        String str = strArr[2];
        String str2 = strArr[4];
        int atomPayloadSize2 = str.length();
        if (atomPayloadSize2 != str2.length()) {
            throw new RuntimeException();
        }
        A0Y[1] = "jmSEpbOdW733bHBoDHkBty1cmj";
    }

    private void A0H(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        CD cdValueAt = null;
        long j = Long.MAX_VALUE;
        int size = this.A0K.size();
        for (int i = 0; i < size; i++) {
            CD nextTrackBundle = this.A0K.valueAt(i);
            CO co = nextTrackBundle.A07;
            if (co.A0B && co.A04 < j) {
                j = co.A04;
                cdValueAt = this.A0K.valueAt(i);
            }
        }
        if (cdValueAt == null) {
            this.A02 = 3;
            return;
        }
        int iA7a = (int) (j - interfaceC0839Bb.A7a());
        if (iA7a >= 0) {
            interfaceC0839Bb.AFe(iA7a);
            cdValueAt.A07.A04(interfaceC0839Bb);
            return;
        }
        throw new C07909d(A0A(307, 39, 39));
    }

    private void A0I(C1364Wk c1364Wk) throws C07909d {
        if (((C1) c1364Wk).A00 == C1.A0k) {
            A0K(c1364Wk);
            return;
        }
        int i = ((C1) c1364Wk).A00;
        int i2 = C1.A0j;
        String[] strArr = A0Y;
        if (strArr[2].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        A0Y[6] = "QeKmRdkmErMZReeQj8";
        if (i == i2) {
            A0J(c1364Wk);
            return;
        }
        if (this.A0T.isEmpty()) {
            return;
        }
        C1364Wk c1364WkPeek = this.A0T.peek();
        if (A0Y[6].length() != 17) {
            A0Y[1] = "g8UpS1NyodMZ5eBXtPatKQwsoR";
            c1364WkPeek.A08(c1364Wk);
        } else {
            A0Y[5] = "mkv5is6F5Mu6y6USr0b4mkDGodGLaqlp";
            c1364WkPeek.A08(c1364Wk);
        }
    }

    private void A0J(C1364Wk c1364Wk) throws C07909d {
        DrmInitData drmInitDataA05;
        A0L(c1364Wk, this.A0K, this.A0J, this.A0W);
        if (this.A0L != null) {
            drmInitDataA05 = null;
        } else {
            List<C1363Wj> list = c1364Wk.A02;
            int trackCount = A0Y[3].length();
            if (trackCount != 6) {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[2] = "YTpzURZBrt0";
            strArr[4] = "jDJUPBNch9x";
            drmInitDataA05 = A05(list);
        }
        if (drmInitDataA05 != null) {
            int i = this.A0K.size();
            for (int trackCount2 = 0; trackCount2 < i; trackCount2++) {
                this.A0K.valueAt(trackCount2).A06(drmInitDataA05);
            }
        }
        if (this.A0A != -9223372036854775807L) {
            int size = this.A0K.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.A0K.valueAt(i2).A05(this.A0A);
            }
            this.A0A = -9223372036854775807L;
        }
    }

    public static void A0L(C1364Wk c1364Wk, SparseArray<CD> sparseArray, int i, byte[] bArr) throws C07909d {
        int size = c1364Wk.A01.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1364Wk child = c1364Wk.A01.get(i2);
            int i3 = ((C1) child).A00;
            int moofContainerChildrenSize = C1.A1L;
            if (i3 == moofContainerChildrenSize) {
                A0M(child, sparseArray, i, bArr);
            }
        }
    }

    public static void A0N(C1364Wk c1364Wk, CD cd, long j, int totalSampleCount) {
        int i = 0;
        int i2 = 0;
        List<C1363Wj> list = c1364Wk.A02;
        int size = list.size();
        for (int trunSampleCount = 0; trunSampleCount < size; trunSampleCount++) {
            C1363Wj c1363Wj = list.get(trunSampleCount);
            if (((C1) c1363Wj).A00 == C1.A1O) {
                C0980Hh trunData = c1363Wj.A00;
                trunData.A0Y(12);
                int iA0H = trunData.A0H();
                if (iA0H > 0) {
                    i2 += iA0H;
                    i++;
                }
            }
        }
        cd.A02 = 0;
        cd.A00 = 0;
        cd.A01 = 0;
        cd.A07.A03(i, i2);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            C1363Wj c1363Wj2 = list.get(i5);
            int trunIndex = ((C1) c1363Wj2).A00;
            if (trunIndex == C1.A1O) {
                i4 = A00(cd, i3, j, totalSampleCount, c1363Wj2.A00, i4);
                i3++;
            }
        }
    }

    private void A0O(C1363Wj c1363Wj, long j) throws C07909d {
        if (!this.A0T.isEmpty()) {
            this.A0T.peek().A09(c1363Wj);
            return;
        }
        if (((C1) c1363Wj).A00 == C1.A13) {
            Pair<Long, X5> pairA04 = A04(c1363Wj.A00, j);
            this.A0B = ((Long) pairA04.first).longValue();
            this.A0C.AEx((InterfaceC0845Bj) pairA04.second);
            this.A0F = true;
            return;
        }
        if (((C1) c1363Wj).A00 != C1.A0Q) {
            return;
        }
        A0Q(c1363Wj.A00);
    }

    private void A0Q(C0980Hh c0980Hh) {
        InterfaceC0848Bm[] interfaceC0848BmArr = this.A0I;
        if (interfaceC0848BmArr == null || interfaceC0848BmArr.length == 0) {
            return;
        }
        c0980Hh.A0Y(12);
        int sampleSize = c0980Hh.A04();
        c0980Hh.A0Q();
        c0980Hh.A0Q();
        long jA0M = c0980Hh.A0M();
        long timescale = c0980Hh.A0M();
        long jA0F = C0996Hx.A0F(timescale, 1000000L, jA0M);
        for (InterfaceC0848Bm interfaceC0848Bm : this.A0I) {
            c0980Hh.A0Y(12);
            interfaceC0848Bm.AEr(c0980Hh, sampleSize);
        }
        long j = this.A0B;
        if (j != -9223372036854775807L) {
            long jA06 = j + jA0F;
            C0992Ht c0992Ht = this.A0S;
            if (c0992Ht != null) {
                jA06 = c0992Ht.A06(jA06);
            }
            for (InterfaceC0848Bm interfaceC0848Bm2 : this.A0I) {
                interfaceC0848Bm2.AEs(jA06, 1, sampleSize, 0, null);
            }
            return;
        }
        this.A0U.addLast(new CC(jA0F, sampleSize));
        this.A03 += sampleSize;
    }

    public static void A0R(C0980Hh c0980Hh, int i, CO co) throws C07909d {
        c0980Hh.A0Y(i + 8);
        int fullAtom = c0980Hh.A08();
        int flags = C1.A00(fullAtom);
        int fullAtom2 = flags & 1;
        if (fullAtom2 == 0) {
            int fullAtom3 = flags & 2;
            boolean z = fullAtom3 != 0;
            int sampleCount = c0980Hh.A0H();
            int fullAtom4 = co.A00;
            if (sampleCount == fullAtom4) {
                Arrays.fill(co.A0H, 0, sampleCount, z);
                int fullAtom5 = c0980Hh.A04();
                co.A02(fullAtom5);
                co.A05(c0980Hh);
                return;
            }
            StringBuilder sbAppend = new StringBuilder().append(A0A(290, 17, 20)).append(sampleCount).append(A0A(0, 2, 62));
            int fullAtom6 = co.A00;
            throw new C07909d(sbAppend.append(fullAtom6).toString());
        }
        throw new C07909d(A0A(381, 56, 66));
    }

    public static void A0S(C0980Hh c0980Hh, CO co) throws C07909d {
        c0980Hh.A0Y(8);
        int flags = c0980Hh.A08();
        int fullAtom = C1.A00(flags) & 1;
        if (fullAtom == 1) {
            c0980Hh.A0Z(8);
        }
        int iA0H = c0980Hh.A0H();
        if (iA0H == 1) {
            int entryCount = C1.A01(flags);
            co.A04 += entryCount == 0 ? c0980Hh.A0M() : c0980Hh.A0N();
            return;
        }
        throw new C07909d(A0A(552, 29, 63) + iA0H);
    }

    public static void A0T(C0980Hh c0980Hh, CO co) throws C07909d {
        A0R(c0980Hh, 0, co);
    }

    public static void A0U(C0980Hh c0980Hh, CO co, byte[] bArr) throws C07909d {
        c0980Hh.A0Y(8);
        c0980Hh.A0c(bArr, 0, 16);
        if (!Arrays.equals(bArr, A0c)) {
            return;
        }
        A0R(c0980Hh, 16, co);
    }

    public static boolean A0W(int i) {
        return i == C1.A0k || i == C1.A1M || i == C1.A0e || i == C1.A0i || i == C1.A17 || i == C1.A0j || i == C1.A1L || i == C1.A0n || i == C1.A0O;
    }

    public static boolean A0X(int i) {
        if (i != C1.A0W && i != C1.A0d && i != C1.A0o && i != C1.A13 && i != C1.A1B) {
            int i2 = C1.A1I;
            if (A0Y[6].length() != 17) {
                A0Y[0] = "0bfDB";
                if (i != i2 && i != C1.A1J && i != C1.A1K && i != C1.A1N && i != C1.A1O && i != C1.A0s && i != C1.A0v) {
                    int i3 = C1.A0u;
                    if (A0Y[1].length() != 5) {
                        A0Y[5] = "GM1eDi9JpLsxcWxFcWWsCjSZthCJdr4f";
                        if (i != i3 && i != C1.A11 && i != C1.A1R && i != C1.A0y && i != C1.A12 && i != C1.A0P) {
                            int i4 = C1.A0g;
                            if (A0Y[3].length() == 6) {
                                A0Y[7] = "Eu3";
                                if (i != i4 && i != C1.A0Q) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x007c, code lost:
    
        if (r2 >= r8) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
    
        r2 = r11.A7a() - ((long) r10.A00);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008a, code lost:
    
        if (r10.A01 != com.facebook.ads.redexgen.X.C1.A0j) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008c, code lost:
    
        r9 = r10.A0K.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        if (r8 >= r9) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
    
        r0 = r10.A0K.valueAt(r8).A07;
        r0.A03 = r2;
        r0.A04 = r2;
        r0.A05 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00af, code lost:
    
        if (com.facebook.ads.redexgen.X.C1358We.A0Y[3].length() == 6) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b1, code lost:
    
        r7 = com.facebook.ads.redexgen.X.C1358We.A0Y;
        r7[2] = "tKeeSnEBB5V";
        r7[4] = "1ppH9MP2kpM";
        r8 = r8 + 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c0, code lost:
    
        com.facebook.ads.redexgen.X.C1358We.A0Y[0] = "GrBVN";
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d4, code lost:
    
        if (r2 >= r8) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:
    
        if (r10.A01 != com.facebook.ads.redexgen.X.C1.A0c) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012e, code lost:
    
        r10.A0D = null;
        r10.A09 = r10.A07 + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0137, code lost:
    
        if (r10.A0F != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0139, code lost:
    
        r10.A0C.AEx(new com.facebook.ads.redexgen.X.X0(r10.A08, r2));
        r10.A0F = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0147, code lost:
    
        r10.A02 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x014a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0159, code lost:
    
        throw new com.facebook.ads.redexgen.X.C07909d(A0A(2, 48, 114));
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0163, code lost:
    
        if (A0X(r10.A01) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0165, code lost:
    
        r3 = r10.A00;
        r2 = com.facebook.ads.redexgen.X.C1358We.A0Y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0177, code lost:
    
        if (r2[2].length() == r2[4].length()) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x017f, code lost:
    
        com.facebook.ads.redexgen.X.C1358We.A0Y[7] = "6Yw";
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0186, code lost:
    
        if (r3 != 8) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0188, code lost:
    
        r2 = r10.A07;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x018c, code lost:
    
        if (r2 > 2147483647L) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x018e, code lost:
    
        r10.A0E = new com.facebook.ads.redexgen.X.C0980Hh((int) r2);
        java.lang.System.arraycopy(r10.A0O.A00, 0, r10.A0E.A00, 0, 8);
        r10.A02 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a8, code lost:
    
        if (r10.A07 > 2147483647L) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01aa, code lost:
    
        r10.A0E = null;
        r10.A02 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b5, code lost:
    
        if (A0W(r10.A01) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b7, code lost:
    
        r5 = (r11.A7a() + r10.A07) - 8;
        r10.A0T.push(new com.facebook.ads.redexgen.X.C1364Wk(r10.A01, r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01d4, code lost:
    
        if (r10.A07 != r10.A00) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01d6, code lost:
    
        A0F(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01d9, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01da, code lost:
    
        A0B();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01ed, code lost:
    
        throw new com.facebook.ads.redexgen.X.C07909d(A0A(241, 49, 53));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01fd, code lost:
    
        throw new com.facebook.ads.redexgen.X.C07909d(A0A(com.facebook.internal.FacebookRequestErrorClassification.EC_INVALID_TOKEN, 51, 24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x020c, code lost:
    
        throw new com.facebook.ads.redexgen.X.C07909d(A0A(479, 53, 2));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0Y(com.facebook.ads.redexgen.X.InterfaceC0839Bb r11) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 525
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1358We.A0Y(com.facebook.ads.redexgen.X.Bb):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0107 A[PHI: r0 r1 r5 r7 r8
      0x0107: PHI (r0v80 com.facebook.ads.redexgen.X.Ht) = (r0v9 com.facebook.ads.redexgen.X.Ht), (r0v84 com.facebook.ads.redexgen.X.Ht) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0107: PHI (r1v6 long) = (r1v4 long), (r1v10 long) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0107: PHI (r5v3 com.facebook.ads.redexgen.X.CM) = (r5v0 com.facebook.ads.redexgen.X.CM), (r5v4 com.facebook.ads.redexgen.X.CM) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0107: PHI (r7v3 com.facebook.ads.redexgen.X.Bm) = (r7v0 com.facebook.ads.redexgen.X.Bm), (r7v4 com.facebook.ads.redexgen.X.Bm) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0107: PHI (r8v3 int) = (r8v0 int), (r8v4 int) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:53:0x0188  */
    /* JADX WARN: Code duplicated, block: B:58:0x0191  */
    /* JADX WARN: Code duplicated, block: B:60:0x01ec  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean A0Z(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        CM cm;
        InterfaceC0848Bm interfaceC0848Bm;
        int i;
        long jA00;
        C0992Ht c0992Ht;
        CN cnA00;
        boolean z;
        int iAEq;
        int i2 = 4;
        int i3 = 1;
        int i4 = 0;
        if (this.A02 == 3) {
            if (this.A0D == null) {
                CD cdA07 = A07(this.A0K);
                if (cdA07 == null) {
                    int iA7a = (int) (this.A09 - interfaceC0839Bb.A7a());
                    if (iA7a >= 0) {
                        interfaceC0839Bb.AFe(iA7a);
                        A0B();
                        return false;
                    }
                    throw new C07909d(A0A(346, 35, 56));
                }
                int iA7a2 = (int) (cdA07.A07.A0G[cdA07.A02] - interfaceC0839Bb.A7a());
                if (iA7a2 < 0) {
                    Log.w(A0A(128, 22, 24), A0A(150, 40, 46));
                    iA7a2 = 0;
                }
                interfaceC0839Bb.AFe(iA7a2);
                if (A0Y[6].length() == 17) {
                    throw new RuntimeException();
                }
                A0Y[3] = "TF0FBE";
                this.A0D = cdA07;
            }
            this.A06 = this.A0D.A07.A0D[this.A0D.A01];
            if (this.A0D.A01 < this.A0D.A03) {
                interfaceC0839Bb.AFe(this.A06);
                this.A0D.A01();
                if (!this.A0D.A08()) {
                    this.A0D = null;
                }
                this.A02 = 3;
                return true;
            }
            if (this.A0D.A05.A02 == 1) {
                this.A06 -= 8;
                interfaceC0839Bb.AFe(8);
            }
            int iA03 = this.A0D.A03();
            this.A04 = iA03;
            this.A06 += iA03;
            this.A02 = 4;
            this.A05 = 0;
        }
        CO co = this.A0D.A07;
        CD cd = this.A0D;
        String[] strArr = A0Y;
        if (strArr[2].length() != strArr[4].length()) {
            A0Y[7] = "Pqi";
            cm = cd.A05;
            interfaceC0848Bm = this.A0D.A06;
            i = this.A0D.A01;
            jA00 = co.A00(i) * 1000;
            c0992Ht = this.A0S;
            if (c0992Ht != null) {
                jA00 = c0992Ht.A06(jA00);
            }
        } else {
            A0Y[0] = "M6XHB";
            cm = cd.A05;
            interfaceC0848Bm = this.A0D.A06;
            i = this.A0D.A01;
            jA00 = co.A00(i) * 1000;
            c0992Ht = this.A0S;
            if (c0992Ht != null) {
                jA00 = c0992Ht.A06(jA00);
            }
        }
        if (cm.A01 == 0) {
            while (true) {
                int i5 = this.A04;
                int i6 = this.A06;
                if (i5 >= i6) {
                    break;
                }
                this.A04 += interfaceC0848Bm.AEq(interfaceC0839Bb, i6 - i5, false);
            }
        } else {
            byte[] bArr = this.A0Q.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i7 = cm.A01 + 1;
            int i8 = 4 - cm.A01;
            while (this.A04 < this.A06) {
                int i9 = this.A05;
                if (A0Y[1].length() != 5) {
                    String[] strArr2 = A0Y;
                    strArr2[2] = "oY9Cfc6NZLH";
                    strArr2[4] = "IHvoiGll8tT";
                    if (i9 == 0) {
                        interfaceC0839Bb.readFully(bArr, i8, i7);
                        this.A0Q.A0Y(i4);
                        this.A05 = this.A0Q.A0H() - i3;
                        this.A0R.A0Y(i4);
                        interfaceC0848Bm.AEr(this.A0R, i2);
                        interfaceC0848Bm.AEr(this.A0Q, i3);
                        if (this.A0H.length > 0 || !C0976Hd.A0C(cm.A07.A0O, bArr[i2])) {
                            z = false;
                        } else {
                            z = true;
                        }
                        this.A0G = z;
                        this.A04 += 5;
                        this.A06 += i8;
                    } else {
                        if (this.A0G) {
                            this.A0P.A0W(i9);
                            interfaceC0839Bb.readFully(this.A0P.A00, i4, this.A05);
                            interfaceC0848Bm.AEr(this.A0P, this.A05);
                            iAEq = this.A05;
                            int iA02 = C0976Hd.A02(this.A0P.A00, this.A0P.A07());
                            this.A0P.A0Y(A0A(686, 10, 6).equals(cm.A07.A0O) ? 1 : 0);
                            this.A0P.A0X(iA02);
                            C0929Fg.A03(jA00, this.A0P, this.A0H);
                        } else {
                            iAEq = interfaceC0848Bm.AEq(interfaceC0839Bb, i9, false);
                        }
                        this.A04 += iAEq;
                        this.A05 -= iAEq;
                        i2 = 4;
                        i3 = 1;
                        i4 = 0;
                    }
                } else if (i9 == 0) {
                    interfaceC0839Bb.readFully(bArr, i8, i7);
                    this.A0Q.A0Y(i4);
                    this.A05 = this.A0Q.A0H() - i3;
                    this.A0R.A0Y(i4);
                    interfaceC0848Bm.AEr(this.A0R, i2);
                    interfaceC0848Bm.AEr(this.A0Q, i3);
                    if (this.A0H.length > 0) {
                        z = false;
                    } else {
                        z = false;
                    }
                    this.A0G = z;
                    this.A04 += 5;
                    this.A06 += i8;
                } else {
                    if (this.A0G) {
                        this.A0P.A0W(i9);
                        interfaceC0839Bb.readFully(this.A0P.A00, i4, this.A05);
                        interfaceC0848Bm.AEr(this.A0P, this.A05);
                        iAEq = this.A05;
                        int iA04 = C0976Hd.A02(this.A0P.A00, this.A0P.A07());
                        this.A0P.A0Y(A0A(686, 10, 6).equals(cm.A07.A0O) ? 1 : 0);
                        this.A0P.A0X(iA04);
                        C0929Fg.A03(jA00, this.A0P, this.A0H);
                    } else {
                        iAEq = interfaceC0848Bm.AEq(interfaceC0839Bb, i9, false);
                    }
                    this.A04 += iAEq;
                    this.A05 -= iAEq;
                    i2 = 4;
                    i3 = 1;
                    i4 = 0;
                }
            }
        }
        boolean z2 = co.A0I[i];
        C0847Bl c0847Bl = null;
        int i10 = z2;
        if (co.A0A) {
            int i11 = (z2 ? 1 : 0) | 1073741824;
            if (co.A08 != null) {
                cnA00 = co.A08;
            } else {
                cnA00 = cm.A00(co.A07.A02);
            }
            c0847Bl = cnA00.A01;
            i10 = i11;
        }
        interfaceC0848Bm.AEs(jA00, i10, this.A06, 0, c0847Bl);
        A0E(jA00);
        if (!this.A0D.A08()) {
            this.A0D = null;
        }
        this.A02 = 3;
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void A8e(InterfaceC0840Bc interfaceC0840Bc) {
        this.A0C = interfaceC0840Bc;
        CM cm = this.A0N;
        if (cm != null) {
            CD cd = new CD(interfaceC0840Bc.AFx(0, cm.A03));
            cd.A07(this.A0N, new C7(0, 0, 0, 0));
            this.A0K.put(0, cd);
            A0C();
            this.A0C.A5T();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final int AE9(InterfaceC0839Bb interfaceC0839Bb, C0843Bh c0843Bh) throws InterruptedException, IOException {
        while (true) {
            int i = this.A02;
            if (A0Y[6].length() == 17) {
                throw new RuntimeException();
            }
            A0Y[6] = "Adcvl3OLLWBEEjCvRjB7l1tHvWvuGk";
            switch (i) {
                case 0:
                    if (!A0Y(interfaceC0839Bb)) {
                        return -1;
                    }
                    break;
                    break;
                case 1:
                    A0G(interfaceC0839Bb);
                    break;
                case 2:
                    A0H(interfaceC0839Bb);
                    break;
                default:
                    if (A0Z(interfaceC0839Bb)) {
                        return 0;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void AEw(long j, long j2) {
        int size = this.A0K.size();
        for (int i = 0; i < size; i++) {
            this.A0K.valueAt(i).A04();
        }
        this.A0U.clear();
        this.A03 = 0;
        this.A0A = j2;
        this.A0T.clear();
        A0B();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final boolean AFg(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        return CK.A03(interfaceC0839Bb);
    }
}
