package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.Id3Frame;
import com.kbeanie.imagechooser.api.ChooserType;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6 {
    public static byte[] A00;
    public static String[] A01 = {DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "1fRxwJ5XE31BEFto", "uScK6DjhwaakoKLKywWqQqJcG3f6AUTY", "4Hlq2lRki9cJUEzjlqXKmdMa0dcUUFBD", "g78w6vvkNWOU54nDIB5PtPh0iS7AkCQe", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Krct3XGjvdQG30dTRHyGL58gGhCYlC87", "LauCO"};
    public static final int A02;
    public static final int A03;
    public static final int A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Pair<long[], long[]> A05(C1364Wk c1364Wk) {
        C1363Wj c1363WjA07;
        if (c1364Wk == null || (c1363WjA07 = c1364Wk.A07(C1.A0P)) == null) {
            return Pair.create(null, null);
        }
        C0980Hh c0980Hh = c1363WjA07.A00;
        c0980Hh.A0Y(8);
        int iA01 = C1.A01(c0980Hh.A08());
        int iA0H = c0980Hh.A0H();
        long[] jArr = new long[iA0H];
        long[] jArr2 = new long[iA0H];
        for (int i = 0; i < iA0H; i++) {
            jArr[i] = iA01 == 1 ? c0980Hh.A0N() : c0980Hh.A0M();
            jArr2[i] = iA01 == 1 ? c0980Hh.A0L() : c0980Hh.A08();
            if (c0980Hh.A0U() != 1) {
                throw new IllegalArgumentException(A0I(272, 23, 92));
            }
            c0980Hh.A0Z(2);
        }
        return Pair.create(jArr, jArr2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C5 A0B(C0980Hh c0980Hh) {
        long jA0M;
        int i;
        c0980Hh.A0Y(8);
        int iA01 = C1.A01(c0980Hh.A08());
        c0980Hh.A0Z(iA01 == 0 ? 8 : 16);
        int iA08 = c0980Hh.A08();
        c0980Hh.A0Z(4);
        boolean z = true;
        String[] strArr = A01;
        if (strArr[0].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = CampaignEx.JSON_KEY_AD_R;
        strArr2[5] = "s";
        int iA06 = c0980Hh.A06();
        int i2 = iA01 == 0 ? 4 : 8;
        for (int i3 = 0; i3 < i2; i3++) {
            if (c0980Hh.A00[iA06 + i3] != -1) {
                z = false;
                break;
            }
        }
        if (z) {
            c0980Hh.A0Z(i2);
            jA0M = -9223372036854775807L;
        } else {
            jA0M = iA01 == 0 ? c0980Hh.A0M() : c0980Hh.A0N();
            if (jA0M == 0) {
                jA0M = -9223372036854775807L;
            }
        }
        c0980Hh.A0Z(16);
        int iA09 = c0980Hh.A08();
        int iA010 = c0980Hh.A08();
        c0980Hh.A0Z(4);
        int iA011 = c0980Hh.A08();
        int iA012 = c0980Hh.A08();
        if (iA09 == 0 && iA010 == 65536 && iA011 == (-65536) && iA012 == 0) {
            i = 90;
        } else if (iA09 == 0 && iA010 == (-65536) && iA011 == 65536 && iA012 == 0) {
            i = 270;
        } else {
            i = (iA09 == (-65536) && iA010 == 0 && iA011 == 0 && iA012 == (-65536)) ? 180 : 0;
        }
        return new C5(iA08, jA0M, i);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static CM A0C(C1364Wk c1364Wk, C1363Wj c1363Wj, long j, DrmInitData drmInitData, boolean z, boolean z2) throws C07909d {
        long j2 = j;
        C1364Wk c1364WkA06 = c1364Wk.A06(C1.A0e);
        int iA02 = A02(c1364WkA06.A07(C1.A0W).A00);
        if (iA02 == -1) {
            return null;
        }
        C5 c5A0B = A0B(c1364Wk.A07(C1.A1K).A00);
        if (j2 == -9223372036854775807L) {
            j2 = c5A0B.A02;
        }
        long jA04 = A04(c1363Wj.A00);
        if (A01[6].charAt(18) != 'y') {
            throw new RuntimeException();
        }
        A01[7] = "VRI";
        long jA0F = j2 == -9223372036854775807L ? -9223372036854775807L : C0996Hx.A0F(j2, 1000000L, jA04);
        C1364Wk c1364WkA07 = c1364WkA06.A06(C1.A0i).A06(C1.A17);
        Pair<Long, String> pairA06 = A06(c1364WkA06.A07(C1.A0d).A00);
        C4 c4A0A = A0A(c1364WkA07.A07(C1.A1B).A00, c5A0B.A00, c5A0B.A01, (String) pairA06.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair<long[], long[]> pairA05 = A05(c1364Wk.A06(C1.A0O));
            jArr = (long[]) pairA05.first;
            jArr2 = (long[]) pairA05.second;
        }
        if (c4A0A.A02 == null) {
            return null;
        }
        return new CM(c5A0B.A00, iA02, ((Long) pairA06.first).longValue(), jA04, jA0F, c4A0A.A02, c4A0A.A01, c4A0A.A03, c4A0A.A00, jArr, jArr2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static CN A0D(C0980Hh c0980Hh, int i, int i2, String str) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            c0980Hh.A0Y(i3);
            int iA08 = c0980Hh.A08();
            if (c0980Hh.A08() == C1.A1H) {
                int iA01 = C1.A01(c0980Hh.A08());
                c0980Hh.A0Z(1);
                int i4 = 0;
                int i5 = 0;
                if (iA01 == 0) {
                    c0980Hh.A0Z(1);
                } else {
                    int iA0E = c0980Hh.A0E();
                    i4 = (iA0E & 240) >> 4;
                    i5 = iA0E & 15;
                }
                boolean z = c0980Hh.A0E() == 1;
                int iA0E2 = c0980Hh.A0E();
                byte[] bArr = new byte[16];
                c0980Hh.A0c(bArr, 0, bArr.length);
                byte[] bArr2 = null;
                if (z && iA0E2 == 0) {
                    int iA0E3 = c0980Hh.A0E();
                    if (A01[3].charAt(18) == 'y') {
                        throw new RuntimeException();
                    }
                    A01[6] = "4wz2pNpdOED2I1F7uwyPx7ja9AIbtNj6";
                    bArr2 = new byte[iA0E3];
                    c0980Hh.A0c(bArr2, 0, iA0E3);
                }
                return new CN(z, str, iA0E2, bArr, i4, i5, bArr2);
            }
            i3 += iA08;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0283 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:103:0x0289  */
    /* JADX WARN: Code duplicated, block: B:106:0x0301  */
    /* JADX WARN: Code duplicated, block: B:157:0x044e  */
    /* JADX WARN: Code duplicated, block: B:195:0x0511  */
    /* JADX WARN: Code duplicated, block: B:207:0x006e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x01b8 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:45:0x011d  */
    /* JADX WARN: Code duplicated, block: B:48:0x013d A[ADDED_TO_REGION, LOOP:1: B:48:0x013d->B:51:0x0154, LOOP_START, PHI: r5 r9
      0x013d: PHI (r5v27 long) = (r5v21 long), (r5v30 long) binds: [B:47:0x013b, B:51:0x0154] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r9v20 int) = (r9v19 int), (r9v22 int) binds: [B:47:0x013b, B:51:0x0154] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x013f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0154 A[LOOP:1: B:48:0x013d->B:51:0x0154, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x0162 A[ADDED_TO_REGION, LOOP:2: B:53:0x0162->B:55:0x0166, LOOP_START, PHI: r26 r27 r28
      0x0162: PHI (r26v5 int) = (r26v3 int), (r26v6 int) binds: [B:52:0x0160, B:55:0x0166] A[DONT_GENERATE, DONT_INLINE]
      0x0162: PHI (r27v7 int) = (r27v3 int), (r27v8 int) binds: [B:52:0x0160, B:55:0x0166] A[DONT_GENERATE, DONT_INLINE]
      0x0162: PHI (r28v6 int) = (r28v4 int), (r28v8 int) binds: [B:52:0x0160, B:55:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:54:0x0164 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:59:0x0182  */
    /* JADX WARN: Code duplicated, block: B:62:0x018f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0196  */
    /* JADX WARN: Code duplicated, block: B:67:0x019d  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ac A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:73:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:89:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:90:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:94:0x020a A[LOOP:8: B:92:0x0204->B:94:0x020a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:97:0x0228  */
    /* JADX WARN: Code duplicated, block: B:98:0x024f  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 39 out of bounds for length 38
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static CP A0E(CM cm, C1364Wk c1364Wk, C0842Be c0842Be) throws C07909d {
        C3 c1361Wh;
        boolean z;
        int i;
        long j;
        String strA0I;
        long[] jArr;
        int[] iArr;
        Format format;
        long[] jArr2;
        int[] iArr2;
        long[] jArr3;
        int[] iArr3;
        long j2;
        long jA0F;
        boolean z2;
        long j3;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        int i4;
        C1363Wj c1363WjA07 = c1364Wk.A07(C1.A1D);
        if (c1363WjA07 != null) {
            c1361Wh = new C1362Wi(c1363WjA07);
        } else {
            C1363Wj c1363WjA08 = c1364Wk.A07(C1.A1F);
            if (c1363WjA08 == null) {
                throw new C07909d(A0I(230, 42, 96));
            }
            c1361Wh = new C1361Wh(c1363WjA08);
        }
        int iA7g = c1361Wh.A7g();
        if (iA7g == 0) {
            return new CP(cm, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        boolean z5 = false;
        C1363Wj c1363WjA09 = c1364Wk.A07(C1.A18);
        if (c1363WjA09 == null) {
            z5 = true;
            c1363WjA09 = c1364Wk.A07(C1.A0C);
        }
        C0980Hh c0980Hh = c1363WjA09.A00;
        C0980Hh c0980Hh2 = c1364Wk.A07(C1.A1A).A00;
        int i5 = C1.A1E;
        if (A01[4].charAt(24) == 'i') {
            A01[3] = "VC45zkewNZzpqmaBl1H7tUMq9GmKccOG";
            C0980Hh c0980Hh3 = c1364Wk.A07(i5).A00;
            C1363Wj c1363WjA010 = c1364Wk.A07(C1.A1C);
            C0980Hh c0980Hh4 = c1363WjA010 != null ? c1363WjA010.A00 : null;
            C1363Wj c1363WjA011 = c1364Wk.A07(C1.A0D);
            C0980Hh c0980Hh5 = c1363WjA011 != null ? c1363WjA011.A00 : null;
            C2 c2 = new C2(c0980Hh2, c0980Hh, z5);
            c0980Hh3.A0Y(12);
            int iA0H = c0980Hh3.A0H() - 1;
            int iA0H2 = c0980Hh3.A0H();
            int iA0H3 = c0980Hh3.A0H();
            int iA0H4 = 0;
            int iA0H5 = 0;
            int iA08 = 0;
            if (c0980Hh5 != null) {
                c0980Hh5.A0Y(12);
                iA0H5 = c0980Hh5.A0H();
            }
            int iA0H6 = -1;
            int iA0H7 = 0;
            if (c0980Hh4 != null) {
                c0980Hh4.A0Y(12);
                iA0H7 = c0980Hh4.A0H();
                if (iA0H7 > 0) {
                    iA0H6 = c0980Hh4.A0H() - 1;
                } else {
                    c0980Hh4 = null;
                }
            }
            boolean zA8s = c1361Wh.A8s();
            if (A01[7].length() == 14) {
                A01[3] = "JmCEQgBO3I7S12cR5vZQ3WUXD6vvV57N";
                if (zA8s) {
                    if (!A0I(492, 9, 73).equals(cm.A07.A0O)) {
                    }
                }
                i = 0;
                j = 0;
                strA0I = A0I(128, 11, 7);
                if (z) {
                    jArr = new long[c2.A05];
                    iArr = new int[c2.A05];
                    while (c2.A02()) {
                        jArr[c2.A00] = c2.A02;
                        iArr[c2.A00] = c2.A01;
                    }
                    format = cm.A07;
                    if (A01[6].charAt(18) != 'y') {
                        C9 c9A00 = CA.A00(C0996Hx.A05(format.A0A, cm.A07.A05), jArr, iArr, iA0H3);
                        jArr2 = c9A00.A04;
                        iArr2 = c9A00.A03;
                        i = c9A00.A00;
                        jArr3 = c9A00.A05;
                        iArr3 = c9A00.A02;
                        j2 = c9A00.A01;
                    } else {
                        String[] strArr = A01;
                        strArr[0] = CampaignEx.CLICKMODE_ON;
                        strArr[5] = "P";
                        C9 c9A01 = CA.A00(C0996Hx.A05(format.A0A, cm.A07.A05), jArr, iArr, iA0H3);
                        jArr2 = c9A01.A04;
                        iArr2 = c9A01.A03;
                        i = c9A01.A00;
                        jArr3 = c9A01.A05;
                        iArr3 = c9A01.A02;
                        j2 = c9A01.A01;
                    }
                } else {
                    jArr2 = new long[iA7g];
                    iArr2 = new int[iA7g];
                    jArr3 = new long[iA7g];
                    iArr3 = new int[iA7g];
                    j3 = 0;
                    i2 = 0;
                    for (i3 = 0; i3 < iA7g; i3++) {
                        while (i2 == 0) {
                            HI.A04(c2.A02());
                            if (A01[2].charAt(2) != 't') {
                                A01[7] = "3XDIuarfTH54Gh2sDFB8u";
                                j3 = c2.A02;
                                i2 = c2.A01;
                            }
                        }
                        if (c0980Hh5 != null) {
                            while (iA0H4 == 0) {
                                iA0H4 = c0980Hh5.A0H();
                                iA08 = c0980Hh5.A08();
                                iA0H5--;
                            }
                            iA0H4--;
                        }
                        jArr2[i3] = j3;
                        iArr2[i3] = c1361Wh.AEF();
                        if (iArr2[i3] > i) {
                            i = iArr2[i3];
                        }
                        jArr3[i3] = j + ((long) iA08);
                        if (c0980Hh4 == null) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        iArr3[i3] = i4;
                        if (i3 == iA0H6) {
                            iArr3[i3] = 1;
                            iA0H7--;
                            if (iA0H7 > 0) {
                                iA0H6 = c0980Hh4.A0H() - 1;
                            }
                        }
                        j += (long) iA0H3;
                        iA0H2--;
                        if (iA0H2 != 0) {
                        }
                        j3 += (long) iArr2[i3];
                        i2--;
                    }
                    j2 = j + ((long) iA08);
                    if (iA0H4 == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    HI.A03(z3);
                    while (iA0H5 > 0) {
                        if (c0980Hh5.A0H() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        HI.A03(z4);
                        c0980Hh5.A08();
                        iA0H5--;
                    }
                    if (iA0H7 == 0) {
                        Log.w(strA0I, A0I(198, 32, 66) + cm.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i2 + A0I(61, 33, 101) + iA0H);
                    } else {
                        Log.w(strA0I, A0I(198, 32, 66) + cm.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i2 + A0I(61, 33, 101) + iA0H);
                    }
                }
                jA0F = C0996Hx.A0F(j2, 1000000L, cm.A06);
                if (cm.A08 != null) {
                }
                C0996Hx.A0a(jArr3, 1000000L, cm.A06);
                return new CP(cm, jArr2, iArr2, i, jArr3, iArr3, jA0F);
            }
            A01[4] = "hEJdTsd1BrdgtnhVHuIKNZxoiMcvZFQc";
            if (zA8s) {
                if (!A0I(492, 9, 73).equals(cm.A07.A0O) && iA0H == 0 && iA0H5 == 0 && iA0H7 == 0) {
                    z = true;
                }
            }
            i = 0;
            j = 0;
            strA0I = A0I(128, 11, 7);
            if (z) {
                jArr2 = new long[iA7g];
                iArr2 = new int[iA7g];
                jArr3 = new long[iA7g];
                iArr3 = new int[iA7g];
                j3 = 0;
                i2 = 0;
                while (i3 < iA7g) {
                    while (i2 == 0) {
                        HI.A04(c2.A02());
                        if (A01[2].charAt(2) != 't') {
                            A01[7] = "3XDIuarfTH54Gh2sDFB8u";
                            j3 = c2.A02;
                            i2 = c2.A01;
                        }
                    }
                    if (c0980Hh5 != null) {
                        while (iA0H4 == 0 && iA0H5 > 0) {
                            iA0H4 = c0980Hh5.A0H();
                            iA08 = c0980Hh5.A08();
                            iA0H5--;
                        }
                        iA0H4--;
                    }
                    jArr2[i3] = j3;
                    iArr2[i3] = c1361Wh.AEF();
                    if (iArr2[i3] > i) {
                        i = iArr2[i3];
                    }
                    jArr3[i3] = j + ((long) iA08);
                    if (c0980Hh4 == null) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    iArr3[i3] = i4;
                    if (i3 == iA0H6) {
                        iArr3[i3] = 1;
                        iA0H7--;
                        if (iA0H7 > 0) {
                            iA0H6 = c0980Hh4.A0H() - 1;
                        }
                    }
                    j += (long) iA0H3;
                    iA0H2--;
                    if (iA0H2 != 0 && iA0H > 0) {
                        iA0H2 = c0980Hh3.A0H();
                        iA0H3 = c0980Hh3.A08();
                        iA0H--;
                    }
                    j3 += (long) iArr2[i3];
                    i2--;
                }
                j2 = j + ((long) iA08);
                if (iA0H4 == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                HI.A03(z3);
                while (iA0H5 > 0) {
                    if (c0980Hh5.A0H() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    HI.A03(z4);
                    c0980Hh5.A08();
                    iA0H5--;
                }
                if (iA0H7 == 0 || iA0H2 != 0 || i2 != 0 || iA0H != 0) {
                    Log.w(strA0I, A0I(198, 32, 66) + cm.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i2 + A0I(61, 33, 101) + iA0H);
                }
            } else {
                jArr = new long[c2.A05];
                iArr = new int[c2.A05];
                while (c2.A02()) {
                    jArr[c2.A00] = c2.A02;
                    iArr[c2.A00] = c2.A01;
                }
                format = cm.A07;
                if (A01[6].charAt(18) != 'y') {
                    C9 c9A02 = CA.A00(C0996Hx.A05(format.A0A, cm.A07.A05), jArr, iArr, iA0H3);
                    jArr2 = c9A02.A04;
                    iArr2 = c9A02.A03;
                    i = c9A02.A00;
                    jArr3 = c9A02.A05;
                    iArr3 = c9A02.A02;
                    j2 = c9A02.A01;
                } else {
                    String[] strArr2 = A01;
                    strArr2[0] = CampaignEx.CLICKMODE_ON;
                    strArr2[5] = "P";
                    C9 c9A03 = CA.A00(C0996Hx.A05(format.A0A, cm.A07.A05), jArr, iArr, iA0H3);
                    jArr2 = c9A03.A04;
                    iArr2 = c9A03.A03;
                    i = c9A03.A00;
                    jArr3 = c9A03.A05;
                    iArr3 = c9A03.A02;
                    j2 = c9A03.A01;
                }
            }
            jA0F = C0996Hx.A0F(j2, 1000000L, cm.A06);
            if (cm.A08 != null || c0842Be.A03()) {
                C0996Hx.A0a(jArr3, 1000000L, cm.A06);
                return new CP(cm, jArr2, iArr2, i, jArr3, iArr3, jA0F);
            }
            if (cm.A08.length == 1 && cm.A03 == 1 && jArr3.length >= 2) {
                long j4 = cm.A09[0];
                long jA0F2 = j4 + C0996Hx.A0F(cm.A08[0], cm.A06, cm.A05);
                if (A0N(jArr3, j2, j4, jA0F2)) {
                    long jA0F3 = C0996Hx.A0F(j4 - jArr3[0], cm.A07.A0C, cm.A06);
                    long jA0F4 = C0996Hx.A0F(j2 - jA0F2, cm.A07.A0C, cm.A06);
                    if ((jA0F3 != 0 || jA0F4 != 0) && jA0F3 <= 2147483647L && jA0F4 <= 2147483647L) {
                        c0842Be.A00 = (int) jA0F3;
                        c0842Be.A01 = (int) jA0F4;
                        C0996Hx.A0a(jArr3, 1000000L, cm.A06);
                        return new CP(cm, jArr2, iArr2, i, jArr3, iArr3, jA0F);
                    }
                }
            }
            if (cm.A08.length == 1) {
                long[] jArr4 = cm.A08;
                if (A01[7].length() == 14) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A01;
                strArr3[0] = "2";
                strArr3[5] = "c";
                if (jArr4[0] == 0) {
                    long j5 = cm.A09[0];
                    for (int i6 = 0; i6 < jArr3.length; i6++) {
                        jArr3[i6] = C0996Hx.A0F(jArr3[i6] - j5, 1000000L, cm.A06);
                    }
                    return new CP(cm, jArr2, iArr2, i, jArr3, iArr3, C0996Hx.A0F(j2 - j5, 1000000L, cm.A06));
                }
            }
            boolean z6 = cm.A03 == 1;
            int i7 = 0;
            int i8 = 0;
            boolean z7 = false;
            for (int i9 = 0; i9 < cm.A08.length; i9++) {
                long j6 = cm.A09[i9];
                if (j6 != -1) {
                    long jA0F5 = C0996Hx.A0F(cm.A08[i9], cm.A06, cm.A05);
                    int iA0A = C0996Hx.A0A(jArr3, j6, true, true);
                    int iA0A2 = C0996Hx.A0A(jArr3, j6 + jA0F5, z6, false);
                    i7 += iA0A2 - iA0A;
                    z7 |= i8 != iA0A;
                    i8 = iA0A2;
                }
            }
            if (A01[1].length() != 12) {
                A01[6] = "kwnW70E81yVLGqt4h2ynIc7oXyulLjyz";
                if (i7 != iA7g) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                A01[4] = "IBcqblQzdyIwYrCXVHJIvpyFiJoNYMYn";
                if (i7 != iA7g) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            boolean z8 = z7 | z2;
            long[] jArr5 = z8 ? new long[i7] : jArr2;
            int[] iArr4 = z8 ? new int[i7] : iArr2;
            if (z8) {
                i = 0;
            }
            int[] iArr5 = z8 ? new int[i7] : iArr3;
            long[] jArr6 = new long[i7];
            long j7 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < cm.A08.length; i11++) {
                long j8 = cm.A09[i11];
                long j9 = cm.A08[i11];
                if (j8 != -1) {
                    long jA0F6 = C0996Hx.A0F(j9, cm.A06, cm.A05) + j8;
                    int iA0A3 = C0996Hx.A0A(jArr3, j8, true, true);
                    int iA0A4 = C0996Hx.A0A(jArr3, jA0F6, z6, false);
                    if (z8) {
                        int i12 = iA0A4 - iA0A3;
                        System.arraycopy(jArr2, iA0A3, jArr5, i10, i12);
                        System.arraycopy(iArr2, iA0A3, iArr4, i10, i12);
                        System.arraycopy(iArr3, iA0A3, iArr5, i10, i12);
                    }
                    if (iA0A3 < iA0A4 && (iArr5[i10] & 1) == 0) {
                        Log.w(strA0I, A0I(139, 59, 39));
                        throw new C1360Wg();
                    }
                    while (iA0A3 < iA0A4) {
                        jArr6[i10] = C0996Hx.A0F(j7, 1000000L, cm.A05) + C0996Hx.A0F(jArr3[iA0A3] - j8, 1000000L, cm.A06);
                        if (z8 && iArr4[i10] > i) {
                            i = iArr2[iA0A3];
                        }
                        i10++;
                        iA0A3++;
                    }
                    if (A01[7].length() != 14) {
                        A01[7] = "ss";
                    }
                }
                j7 += j9;
            }
            return new CP(cm, jArr5, iArr4, i, jArr6, iArr5, C0996Hx.A0F(j7, 1000000L, cm.A06));
            z = false;
            i = 0;
            j = 0;
            strA0I = A0I(128, 11, 7);
            if (z) {
                jArr2 = new long[iA7g];
                iArr2 = new int[iA7g];
                jArr3 = new long[iA7g];
                iArr3 = new int[iA7g];
                j3 = 0;
                i2 = 0;
                while (i3 < iA7g) {
                    while (i2 == 0) {
                        HI.A04(c2.A02());
                        if (A01[2].charAt(2) != 't') {
                            A01[7] = "3XDIuarfTH54Gh2sDFB8u";
                            j3 = c2.A02;
                            i2 = c2.A01;
                        }
                    }
                    if (c0980Hh5 != null) {
                        while (iA0H4 == 0) {
                            iA0H4 = c0980Hh5.A0H();
                            iA08 = c0980Hh5.A08();
                            iA0H5--;
                        }
                        iA0H4--;
                    }
                    jArr2[i3] = j3;
                    iArr2[i3] = c1361Wh.AEF();
                    if (iArr2[i3] > i) {
                        i = iArr2[i3];
                    }
                    jArr3[i3] = j + ((long) iA08);
                    if (c0980Hh4 == null) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    iArr3[i3] = i4;
                    if (i3 == iA0H6) {
                        iArr3[i3] = 1;
                        iA0H7--;
                        if (iA0H7 > 0) {
                            iA0H6 = c0980Hh4.A0H() - 1;
                        }
                    }
                    j += (long) iA0H3;
                    iA0H2--;
                    if (iA0H2 != 0) {
                    }
                    j3 += (long) iArr2[i3];
                    i2--;
                }
                j2 = j + ((long) iA08);
                if (iA0H4 == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                HI.A03(z3);
                while (iA0H5 > 0) {
                    if (c0980Hh5.A0H() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    HI.A03(z4);
                    c0980Hh5.A08();
                    iA0H5--;
                }
                if (iA0H7 == 0) {
                    Log.w(strA0I, A0I(198, 32, 66) + cm.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i2 + A0I(61, 33, 101) + iA0H);
                } else {
                    Log.w(strA0I, A0I(198, 32, 66) + cm.A00 + A0I(94, 34, 29) + iA0H7 + A0I(0, 35, 33) + iA0H2 + A0I(35, 26, 27) + i2 + A0I(61, 33, 101) + iA0H);
                }
            } else {
                jArr = new long[c2.A05];
                iArr = new int[c2.A05];
                while (c2.A02()) {
                    jArr[c2.A00] = c2.A02;
                    iArr[c2.A00] = c2.A01;
                }
                format = cm.A07;
                if (A01[6].charAt(18) != 'y') {
                    C9 c9A04 = CA.A00(C0996Hx.A05(format.A0A, cm.A07.A05), jArr, iArr, iA0H3);
                    jArr2 = c9A04.A04;
                    iArr2 = c9A04.A03;
                    i = c9A04.A00;
                    jArr3 = c9A04.A05;
                    iArr3 = c9A04.A02;
                    j2 = c9A04.A01;
                } else {
                    String[] strArr4 = A01;
                    strArr4[0] = CampaignEx.CLICKMODE_ON;
                    strArr4[5] = "P";
                    C9 c9A05 = CA.A00(C0996Hx.A05(format.A0A, cm.A07.A05), jArr, iArr, iA0H3);
                    jArr2 = c9A05.A04;
                    iArr2 = c9A05.A03;
                    i = c9A05.A00;
                    jArr3 = c9A05.A05;
                    iArr3 = c9A05.A02;
                    j2 = c9A05.A01;
                }
            }
            jA0F = C0996Hx.A0F(j2, 1000000L, cm.A06);
            if (cm.A08 != null) {
            }
            C0996Hx.A0a(jArr3, 1000000L, cm.A06);
            return new CP(cm, jArr2, iArr2, i, jArr3, iArr3, jA0F);
        }
        throw new RuntimeException();
    }

    public static String A0I(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0J() {
        A00 = new byte[]{92, 80, -94, -107, -99, -111, -103, -98, -103, -98, -105, -125, -111, -99, -96, -100, -107, -93, 113, -92, -124, -103, -99, -107, -93, -92, -111, -99, -96, 116, -107, -100, -92, -111, 80, 86, 74, -100, -113, -105, -117, -109, -104, -109, -104, -111, 125, -117, -105, -102, -106, -113, -99, 115, -104, 109, -110, -97, -104, -107, 74, -96, -108, -26, -39, -31, -43, -35, -30, -35, -30, -37, -56, -35, -31, -39, -25, -24, -43, -31, -28, -72, -39, -32, -24, -43, -73, -36, -43, -30, -37, -39, -25, -108, 102, 76, -98, -111, -103, -115, -107, -102, -107, -102, -109, 127, -91, -102, -113, -108, -98, -101, -102, -107, -90, -115, -96, -107, -101, -102, 127, -115, -103, -100, -104, -111, -97, 76, 87, -118, -123, -125, 102, 119, -120, -119, 123, -120, -119, 127, -99, -92, -91, -88, -97, -92, -99, 86, -101, -102, -97, -86, 86, -94, -97, -87, -86, 112, 86, -101, -102, -97, -86, 86, -102, -91, -101, -87, 86, -92, -91, -86, 86, -87, -86, -105, -88, -86, 86, -83, -97, -86, -98, 86, -105, 86, -87, -81, -92, -103, 86, -87, -105, -93, -90, -94, -101, 100, -102, -65, -76, -64, -65, -60, -70, -60, -59, -74, -65, -59, 113, -60, -59, -77, -67, 113, -77, -64, -55, 113, -73, -64, -61, 113, -59, -61, -78, -76, -68, 113, -61, -31, -48, -46, -38, -113, -41, -48, -30, -113, -35, -34, -113, -30, -48, -36, -33, -37, -44, -113, -29, -48, -47, -37, -44, -113, -30, -40, -23, -44, -113, -40, -35, -43, -34, -31, -36, -48, -29, -40, -34, -35, -64, -39, -34, -32, -37, -37, -38, -35, -33, -48, -49, -117, -40, -48, -49, -44, -52, -117, -35, -52, -33, -48, -103, -126, -111, -111, -115, -118, -124, -126, -107, -118, -112, -113, 80, -107, -107, -114, -115, 76, -103, -114, -115, -101, -86, -86, -90, -93, -99, -101, -82, -93, -87, -88, 105, -78, 103, -99, -101, -89, -97, -84, -101, 103, -89, -87, -82, -93, -87, -88, -88, -73, -73, -77, -80, -86, -88, -69, -80, -74, -75, 118, -65, 116, -76, -73, 123, 116, -86, -84, -88, 116, 125, 119, 127, 121, -120, -120, -124, -127, 123, 121, -116, -127, -121, -122, 71, -112, 69, -123, -120, 76, 69, -114, -116, -116, -89, -74, -74, -78, -81, -87, -89, -70, -81, -75, -76, 117, -66, 115, -73, -69, -81, -87, -79, -70, -81, -77, -85, 115, -70, -66, 121, -83, -96, -76, -93, -88, -82, 110, 114, -90, -81, -81, 126, -110, -127, -122, -116, 76, 126, -128, 80, -39, -19, -36, -31, -25, -89, -39, -28, -39, -37, 120, -116, 123, -128, -122, 70, 120, -124, -119, 68, -114, 121, -30, -10, -27, -22, -16, -80, -26, -30, -28, -76, -127, -107, -124, -119, -113, 79, -115, -112, 84, -127, 77, -116, -127, -108, -115, -49, -29, -46, -41, -35, -99, -37, -34, -45, -43, -71, -51, -68, -63, -57, -121, -54, -71, -49, -21, -1, -18, -13, -7, -71, 0, -8, -18, -72, -18, -2, -3, -96, -76, -93, -88, -82, 110, -75, -83, -93, 109, -93, -77, -78, 109, -89, -93, -36, -16, -33, -28, -22, -86, -15, -23, -33, -87, -33, -17, -18, -87, -29, -33, -74, -21, -19, -22, -31, -28, -25, -32, -72, -25, -35, -19, -69, -70, -69, -119, -17, -18, -17, -1, -65, -63, -54, -65, -65, -63, -54, -49, -55, -50, -49, -46, -54, -89, -38, -43, -45, -71, -49, -32, -53, -122, -39, -50, -43, -37, -46, -54, -122, -56, -53, -122, -42, -43, -39, -49, -38, -49, -36, -53, -127, -118, -127, -114, -123, -111, -116, -128, 63, -128, -109, -114, -116, 63, -120, -110, 63, -116, -128, -115, -125, -128, -109, -114, -111, -104, -12, -20, -5, -24, -114, 125, -113, -121, -8, -24, -19, -18, -91, -26, -7, -12, -14, -91, -18, -8, -91, -14, -26, -13, -23, -26, -7, -12, -9, -2, -8, -12, -6, -13, -31, -29, -48, -30, -76, -91, -82, -93, 96, -95, -76, -81, -83, 96, -87, -77, 96, -83, -95, -82, -92, -95, -76, -81, -78, -71, -58, -73, -54, -58, -74, -87, -92, -91, -61, -74, -79, -78, -68, 124, -128, -76, -67, -67, -112, -125, 126, 127, -119, 73, 123, -112, 125, -114, -127, 124, 125, -121, 71, -128, 125, -114, 123, -21, -34, -39, -38, -28, -92, -19, -94, -21, -29, -39, -93, -28, -29, -89, -93, -21, -27, -83, -95, -108, -113, -112, -102, 90, -93, 88, -95, -103, -113, 89, -102, -103, 93, 89, -95, -101, 100};
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x00c9 A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x008c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x012b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0136  */
    /* JADX WARN: Code duplicated, block: B:54:0x0148  */
    /* JADX WARN: Code duplicated, block: B:55:0x0154  */
    /* JADX WARN: Code duplicated, block: B:57:0x0158 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0169  */
    /* JADX WARN: Code duplicated, block: B:60:0x016c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0170 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0187  */
    /* JADX WARN: Code duplicated, block: B:65:0x018a  */
    /* JADX WARN: Code duplicated, block: B:67:0x018e  */
    /* JADX WARN: Code duplicated, block: B:68:0x0196  */
    /* JADX WARN: Code duplicated, block: B:70:0x019a  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:79:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:80:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:84:0x01db  */
    /* JADX WARN: Code duplicated, block: B:90:0x0209  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0K(C0980Hh c0980Hh, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, C4 c4, int i6) throws C07909d {
        int iA0E;
        DrmInitData drmInitDataA02 = drmInitData;
        int iIntValue = i;
        c0980Hh.A0Y(i2 + 8 + 8);
        c0980Hh.A0Z(16);
        int iA0I = c0980Hh.A0I();
        int iA0I2 = c0980Hh.A0I();
        boolean z = false;
        float fA00 = 1.0f;
        c0980Hh.A0Z(50);
        int iA06 = c0980Hh.A06();
        if (iIntValue != C1.A0S) {
            if (A01[7].length() != 14) {
                A01[2] = "PeJuctV1gZmOLx5oH2gSZJGQBpKTFEo9";
            }
            throw new RuntimeException();
        }
        Pair<Integer, CN> pairA09 = A09(c0980Hh, i2, i3);
        if (pairA09 != null) {
            iIntValue = ((Integer) pairA09.first).intValue();
            drmInitDataA02 = drmInitDataA02 == null ? null : drmInitDataA02.A02(((CN) pairA09.second).A02);
            c4.A03[i6] = (CN) pairA09.second;
        }
        c0980Hh.A0Y(iA06);
        List<byte[]> listSingletonList = null;
        String strA0I = null;
        byte[] bArrA0O = null;
        int i7 = -1;
        String[] strArr = A01;
        if (strArr[0].length() == strArr[5].length()) {
            A01[4] = "jNZq0IwPPShJWAAKA9azFLLmiQKjz3bf";
            while (iA06 - i2 < i3) {
                c0980Hh.A0Y(iA06);
                int iA07 = c0980Hh.A06();
                int iA08 = c0980Hh.A08();
                if (iA08 == 0 && c0980Hh.A06() - i2 == i3) {
                    if (strA0I == null) {
                        return;
                    }
                    c4.A02 = Format.A04(Integer.toString(i4), strA0I, null, -1, -1, iA0I, iA0I2, -1.0f, listSingletonList, i5, fA00, bArrA0O, i7, null, drmInitDataA02);
                    return;
                }
                HI.A05(iA08 > 0, A0I(574, 32, 87));
                int iA09 = c0980Hh.A08();
                if (iA09 == C1.A09) {
                    HI.A04(strA0I == null);
                    strA0I = A0I(710, 9, 11);
                    c0980Hh.A0Y(iA07 + 8);
                    C0998Hz c0998HzA00 = C0998Hz.A00(c0980Hh);
                    listSingletonList = c0998HzA00.A04;
                    c4.A00 = c0998HzA00.A02;
                    if (!z) {
                        fA00 = c0998HzA00.A00;
                    }
                } else {
                    int i8 = C1.A0Z;
                    if (A01[1].length() != 12) {
                        A01[7] = "trr";
                        if (iA09 == i8) {
                            HI.A04(strA0I == null);
                            strA0I = A0I(719, 10, 9);
                            c0980Hh.A0Y(iA07 + 8);
                            I5 i5A00 = I5.A00(c0980Hh);
                            listSingletonList = i5A00.A01;
                            c4.A00 = i5A00.A00;
                        } else {
                            int i9 = C1.A1V;
                            if (A01[4].charAt(24) != 'i') {
                                A01[4] = "BNWfK92Afgdig3u125odHn9NiRsm91NE";
                                if (iA09 == i9) {
                                    HI.A04(strA0I == null);
                                    if (iIntValue == C1.A1T) {
                                        strA0I = A0I(729, 19, 102);
                                    } else {
                                        strA0I = A0I(748, 19, 28);
                                    }
                                } else if (iA09 == C1.A0E) {
                                    HI.A04(strA0I == null);
                                    strA0I = A0I(700, 10, 62);
                                } else if (iA09 == C1.A0T) {
                                    HI.A04(strA0I == null);
                                    Pair<String, byte[]> pairA07 = A07(c0980Hh, iA07);
                                    strA0I = (String) pairA07.first;
                                    listSingletonList = Collections.singletonList((byte[]) pairA07.second);
                                } else if (iA09 == C1.A0q) {
                                    fA00 = A00(c0980Hh, iA07);
                                    z = true;
                                } else if (iA09 == C1.A1G) {
                                    bArrA0O = A0O(c0980Hh, iA07, iA08);
                                } else if (iA09 == C1.A16) {
                                    iA0E = c0980Hh.A0E();
                                    c0980Hh.A0Z(3);
                                    if (iA0E == 0) {
                                        switch (c0980Hh.A0E()) {
                                            case 0:
                                                i7 = 0;
                                                break;
                                            case 1:
                                                i7 = 1;
                                                break;
                                            case 2:
                                                i7 = 2;
                                                break;
                                            case 3:
                                                i7 = 3;
                                                if (A01[1].length() != 12) {
                                                    A01[2] = "dnuTGkt9wQcTbo6J7tdoKURT12LZQ83u";
                                                } else {
                                                    A01[2] = "ncqjdIo8Q7C9TEhGWLQwCcGeWNY5S9h6";
                                                }
                                                break;
                                        }
                                    }
                                }
                            } else {
                                String[] strArr2 = A01;
                                strArr2[0] = "R";
                                strArr2[5] = "z";
                                if (iA09 == i9) {
                                    HI.A04(strA0I == null);
                                    if (iIntValue == C1.A1T) {
                                        strA0I = A0I(729, 19, 102);
                                    } else {
                                        strA0I = A0I(748, 19, 28);
                                    }
                                } else if (iA09 == C1.A0E) {
                                    HI.A04(strA0I == null);
                                    strA0I = A0I(700, 10, 62);
                                } else if (iA09 == C1.A0T) {
                                    HI.A04(strA0I == null);
                                    Pair<String, byte[]> pairA08 = A07(c0980Hh, iA07);
                                    strA0I = (String) pairA08.first;
                                    listSingletonList = Collections.singletonList((byte[]) pairA08.second);
                                } else if (iA09 == C1.A0q) {
                                    fA00 = A00(c0980Hh, iA07);
                                    z = true;
                                } else if (iA09 == C1.A1G) {
                                    bArrA0O = A0O(c0980Hh, iA07, iA08);
                                } else if (iA09 == C1.A16) {
                                    iA0E = c0980Hh.A0E();
                                    c0980Hh.A0Z(3);
                                    if (iA0E == 0) {
                                        switch (c0980Hh.A0E()) {
                                            case 0:
                                                i7 = 0;
                                                break;
                                            case 1:
                                                i7 = 1;
                                                break;
                                            case 2:
                                                i7 = 2;
                                                break;
                                            case 3:
                                                i7 = 3;
                                                if (A01[1].length() != 12) {
                                                    A01[2] = "dnuTGkt9wQcTbo6J7tdoKURT12LZQ83u";
                                                } else {
                                                    A01[2] = "ncqjdIo8Q7C9TEhGWLQwCcGeWNY5S9h6";
                                                }
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                iA06 += iA08;
            }
            if (strA0I == null) {
                return;
            }
            c4.A02 = Format.A04(Integer.toString(i4), strA0I, null, -1, -1, iA0I, iA0I2, -1.0f, listSingletonList, i5, fA00, bArrA0O, i7, null, drmInitDataA02);
            return;
        }
        throw new RuntimeException();
    }

    static {
        A0J();
        A08 = C0996Hx.A08(A0I(696, 4, 49));
        A05 = C0996Hx.A08(A0I(662, 4, 118));
        A07 = C0996Hx.A08(A0I(692, 4, 67));
        A04 = C0996Hx.A08(A0I(636, 4, 12));
        A06 = C0996Hx.A08(A0I(TTAdConstant.STYLE_SIZE_RADIO_2_3, 4, 95));
        A02 = C0996Hx.A08(A0I(606, 4, 15));
        A03 = C0996Hx.A08(A0I(632, 4, 120));
    }

    public static float A00(C0980Hh c0980Hh, int i) {
        c0980Hh.A0Y(i + 8);
        int vSpacing = c0980Hh.A0H();
        int hSpacing = c0980Hh.A0H();
        return vSpacing / hSpacing;
    }

    public static int A01(C0980Hh c0980Hh) {
        int iA0E = c0980Hh.A0E();
        int size = iA0E & WorkQueueKt.MASK;
        while ((iA0E & 128) == 128) {
            iA0E = c0980Hh.A0E();
            int currentByte = iA0E & WorkQueueKt.MASK;
            size = (size << 7) | currentByte;
        }
        return size;
    }

    public static int A02(C0980Hh c0980Hh) {
        c0980Hh.A0Y(16);
        int iA08 = c0980Hh.A08();
        int trackType = A05;
        if (iA08 == trackType) {
            return 1;
        }
        int trackType2 = A08;
        if (iA08 == trackType2) {
            return 2;
        }
        int trackType3 = A07;
        if (iA08 == trackType3) {
            return 3;
        }
        int trackType4 = A04;
        if (iA08 == trackType4) {
            return 3;
        }
        int trackType5 = A06;
        if (iA08 == trackType5) {
            return 3;
        }
        int trackType6 = A02;
        if (iA08 == trackType6) {
            return 3;
        }
        int trackType7 = A03;
        if (iA08 == trackType7) {
            return 4;
        }
        return -1;
    }

    public static int A03(C0980Hh c0980Hh, int i, int i2) {
        int iA06 = c0980Hh.A06();
        while (childAtomPosition < i2) {
            c0980Hh.A0Y(iA06);
            int iA08 = c0980Hh.A08();
            boolean z = iA08 > 0;
            int childAtomSize = A01[4].charAt(24);
            if (childAtomSize != 105) {
                throw new RuntimeException();
            }
            A01[4] = "NygnrBLA11LVP9MJCR7n8rNii2RIBIyr";
            HI.A05(z, A0I(574, 32, 87));
            int childAtomSize2 = c0980Hh.A08();
            int childAtomPosition = C1.A0T;
            if (childAtomSize2 == childAtomPosition) {
                return iA06;
            }
            iA06 += iA08;
        }
        return -1;
    }

    public static long A04(C0980Hh c0980Hh) {
        int fullAtom = 8;
        c0980Hh.A0Y(8);
        if (C1.A01(c0980Hh.A08()) != 0) {
            fullAtom = 16;
        }
        c0980Hh.A0Z(fullAtom);
        int fullAtom2 = A01[1].length();
        if (fullAtom2 == 12) {
            throw new RuntimeException();
        }
        A01[7] = "3W9G8I03JPUdsev";
        return c0980Hh.A0M();
    }

    public static Pair<Long, String> A06(C0980Hh c0980Hh) {
        c0980Hh.A0Y(8);
        int fullAtom = C1.A01(c0980Hh.A08());
        int languageCode = fullAtom == 0 ? 8 : 16;
        c0980Hh.A0Z(languageCode);
        long jA0M = c0980Hh.A0M();
        int version = fullAtom == 0 ? 4 : 8;
        c0980Hh.A0Z(version);
        int iA0I = c0980Hh.A0I();
        int languageCode2 = iA0I >> 10;
        StringBuilder sbAppend = new StringBuilder().append(A0I(0, 0, 85)).append((char) ((languageCode2 & 31) + 96));
        int languageCode3 = iA0I >> 5;
        StringBuilder sbAppend2 = sbAppend.append((char) ((languageCode3 & 31) + 96));
        int languageCode4 = iA0I & 31;
        return Pair.create(Long.valueOf(jA0M), sbAppend2.append((char) (languageCode4 + 96)).toString());
    }

    public static Pair<String, byte[]> A07(C0980Hh c0980Hh, int i) {
        c0980Hh.A0Y(i + 8 + 4);
        c0980Hh.A0Z(1);
        A01(c0980Hh);
        c0980Hh.A0Z(2);
        int iA0E = c0980Hh.A0E();
        if ((iA0E & 128) != 0) {
            c0980Hh.A0Z(2);
        }
        int i2 = iA0E & 64;
        if (A01[6].charAt(18) != 'y') {
            throw new RuntimeException();
        }
        A01[4] = "xKeFRQRG14ulCThjCTH6nGG5i69swr7b";
        if (i2 != 0) {
            c0980Hh.A0Z(c0980Hh.A0I());
        }
        if ((iA0E & 32) != 0) {
            c0980Hh.A0Z(2);
        }
        c0980Hh.A0Z(1);
        A01(c0980Hh);
        String mimeType = C0973Ha.A03(c0980Hh.A0E());
        if (A0I(482, 10, 95).equals(mimeType) || A0I(501, 13, 123).equals(mimeType) || A0I(514, 16, 48).equals(mimeType)) {
            Pair<String, byte[]> pairCreate = Pair.create(mimeType, null);
            int objectTypeIndication = A01[6].charAt(18);
            if (objectTypeIndication != 121) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "4";
            strArr[5] = "i";
            return pairCreate;
        }
        c0980Hh.A0Z(12);
        c0980Hh.A0Z(1);
        int flags = A01(c0980Hh);
        byte[] bArr = new byte[flags];
        c0980Hh.A0c(bArr, 0, flags);
        return Pair.create(mimeType, bArr);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0076  */
    public static Pair<Integer, CN> A08(C0980Hh c0980Hh, int i, int i2) {
        int i3 = i + 8;
        int childAtomType = -1;
        int childAtomSize = 0;
        String schemeType = null;
        Integer dataFormat = null;
        while (childPosition < i2) {
            c0980Hh.A0Y(i3);
            int iA08 = c0980Hh.A08();
            int schemeInformationBoxPosition = c0980Hh.A08();
            int childPosition = C1.A0U;
            if (schemeInformationBoxPosition == childPosition) {
                int childPosition2 = c0980Hh.A08();
                dataFormat = Integer.valueOf(childPosition2);
            } else {
                int childPosition3 = C1.A10;
                if (schemeInformationBoxPosition == childPosition3) {
                    c0980Hh.A0Z(4);
                    schemeType = c0980Hh.A0S(4);
                } else {
                    int childPosition4 = C1.A0z;
                    if (schemeInformationBoxPosition == childPosition4) {
                        childAtomType = i3;
                        int schemeInformationBoxPosition2 = A01[1].length();
                        if (schemeInformationBoxPosition2 == 12) {
                            throw new RuntimeException();
                        }
                        A01[4] = "1Dp8zcpsjMOU2LphvBo6Szkhi7qi1syu";
                        childAtomSize = iA08;
                    } else {
                        continue;
                    }
                }
            }
            i3 += iA08;
        }
        int schemeInformationBoxPosition3 = A01[4].charAt(24);
        if (schemeInformationBoxPosition3 != 105) {
            A01[2] = "sI3X7CYNkWTnNUBuJepPqwY6PzAeX7x4";
            if (!A0I(566, 4, 77).equals(schemeType)) {
                if (!A0I(558, 4, 73).equals(schemeType) && !A0I(570, 4, 77).equals(schemeType) && !A0I(TTAdConstant.STYLE_SIZE_RADIO_9_16, 4, 125).equals(schemeType)) {
                    return null;
                }
            }
        } else {
            A01[1] = "yPyTXv33PIzdo";
            if (!A0I(566, 4, 77).equals(schemeType)) {
                if (!A0I(558, 4, 73).equals(schemeType)) {
                    return null;
                }
            }
        }
        boolean z = true;
        int schemeInformationBoxPosition4 = A01[3].charAt(18);
        if (schemeInformationBoxPosition4 == 121) {
            throw new RuntimeException();
        }
        A01[4] = "c3g2qilHanrF8nzgjzcjaWK2icn944It";
        HI.A05(dataFormat != null, A0I(610, 22, 16));
        HI.A05(childAtomType != -1, A0I(640, 22, 118));
        CN cnA0D = A0D(c0980Hh, childAtomType, childAtomSize, schemeType);
        if (cnA0D == null) {
            z = false;
        }
        HI.A05(z, A0I(670, 22, 49));
        return Pair.create(dataFormat, cnA0D);
    }

    public static Pair<Integer, CN> A09(C0980Hh c0980Hh, int i, int i2) {
        Pair<Integer, CN> pairA08;
        int iA06 = c0980Hh.A06();
        while (true) {
            int i3 = iA06 - i;
            if (A01[3].charAt(18) == 'y') {
                throw new RuntimeException();
            }
            A01[6] = "VuSqoU71mDFleviScFynwgGpV5GSmBmr";
            if (i3 < i2) {
                c0980Hh.A0Y(iA06);
                int iA08 = c0980Hh.A08();
                HI.A05(iA08 > 0, A0I(574, 32, 87));
                int childAtomSize = c0980Hh.A08();
                int childPosition = C1.A14;
                if (childAtomSize == childPosition && (pairA08 = A08(c0980Hh, iA06, iA08)) != null) {
                    return pairA08;
                }
                iA06 += iA08;
            } else {
                return null;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x009b  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x0111  */
    public static C4 A0A(C0980Hh c0980Hh, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws C07909d {
        C0980Hh c0980Hh2 = c0980Hh;
        c0980Hh2.A0Y(12);
        int iA08 = c0980Hh2.A08();
        C4 c4 = new C4(iA08);
        for (int childStartPosition = 0; childStartPosition < iA08; childStartPosition++) {
            int iA06 = c0980Hh2.A06();
            int iA09 = c0980Hh2.A08();
            HI.A05(iA09 > 0, A0I(574, 32, 87));
            int iA010 = c0980Hh2.A08();
            if (iA010 != C1.A07) {
                int i3 = C1.A08;
                if (A01[4].charAt(24) == 'i') {
                    A01[2] = "XfWsLr5EskpQolouThrY0L7T3EnzbtXq";
                    if (iA010 == i3 || iA010 == C1.A0S) {
                        A0K(c0980Hh2, iA010, iA06, iA09, i, i2, drmInitData, c4, childStartPosition);
                    } else {
                        int i4 = C1.A0m;
                        if (A01[7].length() != 14) {
                            String[] strArr = A01;
                            strArr[0] = "z";
                            strArr[5] = "6";
                            if (iA010 == i4 || iA010 == C1.A0Y || iA010 == C1.A0X || iA010 == C1.A0t || iA010 == C1.A1T) {
                                A0K(c0980Hh2, iA010, iA06, iA09, i, i2, drmInitData, c4, childStartPosition);
                            } else {
                                int i5 = C1.A1U;
                                if (A01[4].charAt(24) == 'i') {
                                    A01[6] = "2YqAUbM6XE3am7qEi8y8ENpTVaXzAM3G";
                                    if (iA010 == i5) {
                                        A0K(c0980Hh2, iA010, iA06, iA09, i, i2, drmInitData, c4, childStartPosition);
                                    } else if (iA010 != C1.A0l) {
                                        c0980Hh2 = c0980Hh2;
                                        A0M(c0980Hh2, iA010, iA06, iA09, i, str, z, drmInitData, c4, childStartPosition);
                                    } else {
                                        c0980Hh2 = c0980Hh2;
                                        A0M(c0980Hh2, iA010, iA06, iA09, i, str, z, drmInitData, c4, childStartPosition);
                                    }
                                } else if (iA010 == i5) {
                                    A0K(c0980Hh2, iA010, iA06, iA09, i, i2, drmInitData, c4, childStartPosition);
                                } else if (iA010 != C1.A0l || iA010 == C1.A0R || iA010 == C1.A05) {
                                    c0980Hh2 = c0980Hh2;
                                    A0M(c0980Hh2, iA010, iA06, iA09, i, str, z, drmInitData, c4, childStartPosition);
                                } else {
                                    int i6 = C1.A0N;
                                    if (A01[6].charAt(18) != 'y') {
                                        A01[7] = "sstJHJE2SSSA0gl";
                                        if (iA010 != i6) {
                                            if (iA010 == C1.A0J && iA010 != C1.A0K && iA010 != C1.A0L && iA010 != C1.A0M && iA010 != C1.A0w && iA010 != C1.A0x && iA010 != C1.A0b && iA010 != C1.A15 && iA010 != C1.A04 && iA010 != C1.A06) {
                                                if (iA010 == C1.A03 || iA010 == C1.A1P || iA010 == C1.A1X || iA010 == C1.A19 || iA010 == C1.A0A) {
                                                    c0980Hh2 = c0980Hh2;
                                                    iA06 = iA06;
                                                    iA09 = iA09;
                                                    A0L(c0980Hh2, iA010, iA06, iA09, i, str, c4);
                                                } else if (iA010 == C1.A0B) {
                                                    c4.A02 = Format.A0B(Integer.toString(i), A0I(315, 27, 43), null, -1, null);
                                                }
                                            }
                                        }
                                    } else {
                                        A01[4] = "NowU1j8TXSe0umpE5Ib758xlieALevMk";
                                        if (iA010 != i6) {
                                            if (iA010 == C1.A0J) {
                                            }
                                        }
                                    }
                                    c0980Hh2 = c0980Hh2;
                                    A0M(c0980Hh2, iA010, iA06, iA09, i, str, z, drmInitData, c4, childStartPosition);
                                }
                            }
                        }
                    }
                }
                throw new RuntimeException();
            }
            A0K(c0980Hh2, iA010, iA06, iA09, i, i2, drmInitData, c4, childStartPosition);
            c0980Hh2.A0Y(iA06 + iA09);
        }
        return c4;
    }

    public static Metadata A0F(C1363Wj c1363Wj, boolean z) {
        if (z) {
            return null;
        }
        C0980Hh c0980Hh = c1363Wj.A00;
        c0980Hh.A0Y(8);
        while (c0980Hh.A04() >= 8) {
            int atomPosition = c0980Hh.A06();
            int iA08 = c0980Hh.A08();
            if (c0980Hh.A08() == C1.A0h) {
                c0980Hh.A0Y(atomPosition);
                return A0H(c0980Hh, atomPosition + iA08);
            }
            c0980Hh.A0Z(iA08 - 8);
        }
        return null;
    }

    public static Metadata A0G(C0980Hh c0980Hh, int i) {
        c0980Hh.A0Z(8);
        ArrayList arrayList = new ArrayList();
        while (c0980Hh.A06() < i) {
            Id3Frame id3FrameA04 = CE.A04(c0980Hh);
            if (id3FrameA04 != null) {
                arrayList.add(id3FrameA04);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Metadata A0H(C0980Hh c0980Hh, int i) {
        c0980Hh.A0Z(12);
        while (true) {
            int iA06 = c0980Hh.A06();
            if (A01[2].charAt(2) == 't') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "B";
            strArr[5] = "e";
            if (iA06 < i) {
                int iA07 = c0980Hh.A06();
                int atomType = c0980Hh.A08();
                int atomSize = c0980Hh.A08();
                int atomPosition = C1.A0a;
                if (atomSize == atomPosition) {
                    c0980Hh.A0Y(iA07);
                    return A0G(c0980Hh, iA07 + atomType);
                }
                int atomPosition2 = atomType - 8;
                c0980Hh.A0Z(atomPosition2);
            } else {
                return null;
            }
        }
    }

    public static void A0L(C0980Hh c0980Hh, int i, int i2, int i3, int i4, String str, C4 c4) throws C07909d {
        String strA0I;
        c0980Hh.A0Y(i2 + 8 + 8);
        List listSingletonList = null;
        long j = Long.MAX_VALUE;
        if (i == C1.A03) {
            strA0I = A0I(ChooserType.REQUEST_PICK_VIDEO, 20, 18);
        } else if (i == C1.A1P) {
            strA0I = A0I(388, 28, 55);
            int i5 = (i3 - 8) - 8;
            byte[] bArr = new byte[i5];
            c0980Hh.A0c(bArr, 0, i5);
            listSingletonList = Collections.singletonList(bArr);
        } else if (i == C1.A1X) {
            strA0I = A0I(367, 21, 9);
        } else if (i == C1.A19) {
            strA0I = A0I(ChooserType.REQUEST_PICK_VIDEO, 20, 18);
            j = 0;
        } else if (i == C1.A0A) {
            strA0I = A0I(342, 25, 56);
            c4.A01 = 1;
        } else {
            throw new IllegalStateException();
        }
        c4.A02 = Format.A09(Integer.toString(i4), strA0I, null, -1, 0, str, -1, null, j, listSingletonList);
    }

    public static void A0M(C0980Hh c0980Hh, int i, int childPosition, int i2, int i3, String mimeType, boolean z, DrmInitData drmInitData, C4 c4, int i4) throws C07909d {
        int iA0I;
        int iA0F;
        int iA03;
        DrmInitData drmInitData2 = drmInitData;
        int childPosition2 = i;
        c0980Hh.A0Y(childPosition + 8 + 8);
        int quickTimeSoundDescriptionVersion = 0;
        if (z) {
            quickTimeSoundDescriptionVersion = c0980Hh.A0I();
            c0980Hh.A0Z(6);
        } else {
            c0980Hh.A0Z(8);
        }
        if (quickTimeSoundDescriptionVersion == 0 || quickTimeSoundDescriptionVersion == 1) {
            iA0I = c0980Hh.A0I();
            c0980Hh.A0Z(6);
            iA0F = c0980Hh.A0F();
            if (quickTimeSoundDescriptionVersion == 1) {
                c0980Hh.A0Z(16);
            }
        } else if (quickTimeSoundDescriptionVersion == 2) {
            c0980Hh.A0Z(16);
            iA0F = (int) Math.round(c0980Hh.A03());
            iA0I = c0980Hh.A0H();
            c0980Hh.A0Z(20);
        } else {
            return;
        }
        int channelCount = c0980Hh.A06();
        if (childPosition2 == C1.A0R) {
            Pair<Integer, CN> pairA09 = A09(c0980Hh, childPosition, i2);
            if (A01[2].charAt(2) == 't') {
                throw new RuntimeException();
            }
            A01[1] = "rXJd0uQKTdLTB";
            if (pairA09 != null) {
                childPosition2 = ((Integer) pairA09.first).intValue();
                if (drmInitData2 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData2.A02(((CN) pairA09.second).A02);
                }
                c4.A03[i4] = (CN) pairA09.second;
            }
            c0980Hh.A0Y(channelCount);
        }
        String strA0I = null;
        if (childPosition2 == C1.A05) {
            strA0I = A0I(426, 9, 14);
        } else if (childPosition2 == C1.A0N) {
            strA0I = A0I(457, 10, 114);
        } else if (childPosition2 == C1.A0J) {
            strA0I = A0I(501, 13, 123);
        } else if (childPosition2 == C1.A0L || childPosition2 == C1.A0M) {
            strA0I = A0I(514, 16, 48);
        } else if (childPosition2 == C1.A0K) {
            strA0I = A0I(530, 28, 108);
        } else if (childPosition2 == C1.A0w) {
            strA0I = A0I(416, 10, 48);
        } else if (childPosition2 == C1.A0x) {
            strA0I = A0I(445, 12, 8);
        } else if (childPosition2 == C1.A0b || childPosition2 == C1.A15) {
            strA0I = A0I(492, 9, 73);
        } else if (childPosition2 == C1.A04) {
            strA0I = A0I(482, 10, 95);
        } else {
            int atomType = C1.A06;
            int atomType2 = A01[7].length();
            if (atomType2 == 14) {
                throw new RuntimeException();
            }
            A01[1] = "HdbKXAaE1rDpPSyLEE9ktT";
            if (childPosition2 == atomType) {
                strA0I = A0I(435, 10, 105);
            }
        }
        byte[] bArr = null;
        int atomType3 = A01[4].charAt(24);
        if (atomType3 != 105) {
            throw new RuntimeException();
        }
        A01[6] = "QyfbMcdO26pfDQU6rlymYH0CLTjMRKBW";
        while (channelCount - childPosition < i2) {
            c0980Hh.A0Y(channelCount);
            int childAtomSize = c0980Hh.A08();
            HI.A05(childAtomSize > 0, A0I(574, 32, 87));
            int atomType4 = c0980Hh.A08();
            if (atomType4 == C1.A0T || (z && atomType4 == C1.A1W)) {
                if (atomType4 == C1.A0T) {
                    iA03 = channelCount;
                } else {
                    iA03 = A03(c0980Hh, channelCount, childAtomSize);
                }
                if (iA03 != -1) {
                    Pair<String, byte[]> pairA07 = A07(c0980Hh, iA03);
                    strA0I = (String) pairA07.first;
                    bArr = (byte[]) pairA07.second;
                    if (A0I(467, 15, 17).equals(strA0I)) {
                        Pair<Integer, Integer> pairA03 = HM.A03(bArr);
                        iA0F = ((Integer) pairA03.first).intValue();
                        iA0I = ((Integer) pairA03.second).intValue();
                    }
                }
            } else {
                int i5 = C1.A0F;
                if (A01[2].charAt(2) == 't') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[0] = "Q";
                strArr[5] = "M";
                if (atomType4 == i5) {
                    c0980Hh.A0Y(channelCount + 8);
                    c4.A02 = A8.A07(c0980Hh, Integer.toString(i3), mimeType, drmInitData2);
                } else if (atomType4 == C1.A0I) {
                    c0980Hh.A0Y(channelCount + 8);
                    c4.A02 = A8.A08(c0980Hh, Integer.toString(i3), mimeType, drmInitData2);
                } else if (atomType4 == C1.A0H) {
                    c4.A02 = Format.A07(Integer.toString(i3), strA0I, null, -1, -1, iA0I, iA0F, null, drmInitData2, 0, mimeType);
                } else if (atomType4 == C1.A06) {
                    bArr = new byte[childAtomSize];
                    c0980Hh.A0Y(channelCount);
                    c0980Hh.A0c(bArr, 0, childAtomSize);
                }
            }
            channelCount += childAtomSize;
        }
        if (c4.A02 != null || strA0I == null) {
            return;
        }
        int atomType5 = A0I(492, 9, 73).equals(strA0I) ? 2 : -1;
        c4.A02 = Format.A06(Integer.toString(i3), strA0I, null, -1, -1, iA0I, iA0F, atomType5, bArr != null ? Collections.singletonList(bArr) : null, drmInitData2, 0, mimeType);
    }

    public static boolean A0N(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        int latestDelayIndex = C0996Hx.A06(3, 0, length);
        int lastIndex = jArr.length;
        return jArr[0] <= j2 && j2 < jArr[latestDelayIndex] && jArr[C0996Hx.A06(lastIndex - 3, 0, length)] < j3 && j3 <= j;
    }

    public static byte[] A0O(C0980Hh c0980Hh, int i, int i2) {
        int i3 = i + 8;
        while (true) {
            int i4 = i3 - i;
            String[] strArr = A01;
            String str = strArr[0];
            String str2 = strArr[5];
            int length = str.length();
            int childPosition = str2.length();
            if (length != childPosition) {
                break;
            }
            A01[2] = "hiyhCkw83qioTZht4ycME2aPtqNlSya0";
            if (i4 >= i2) {
                if (A01[4].charAt(24) != 'i') {
                    return null;
                }
                A01[6] = "op0Xll27WP2wTMdM3NyEU8fL7oyu7ROp";
                return null;
            }
            c0980Hh.A0Y(i3);
            int iA08 = c0980Hh.A08();
            int iA09 = c0980Hh.A08();
            int i5 = C1.A0r;
            int childAtomSize = A01[2].charAt(2);
            if (childAtomSize == 116) {
                break;
            }
            String[] strArr2 = A01;
            strArr2[0] = "K";
            strArr2[5] = "V";
            if (iA09 == i5) {
                int childPosition2 = i3 + iA08;
                return Arrays.copyOfRange(c0980Hh.A00, i3, childPosition2);
            }
            i3 += iA08;
        }
        throw new RuntimeException();
    }
}
