package com.facebook.ads.redexgen.X;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import com.facebook.ads.internal.exoplayer2.thirdparty.trackselection.DefaultTrackSelector$Parameters;
import com.facebook.ads.internal.exoplayer2.thirdparty.trackselection.DefaultTrackSelector$SelectionOverride;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ay, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0836Ay extends VN {
    public static byte[] A02;
    public static String[] A03 = {"x6AsNgj7kZHrnoNYywGy3amTsD0l", "S34B6ywREx44pNmlWPMRcx17PIA7Fyf2", "1XorlyLpztZAXiZGzmiFCBwFfMWU", "T5Z409y2ECpb8uf8T6KWShvwgb", "8Qiq8HU85lCoFhvN1dBY3zigvCratExc", "EyxqnSMNDXwhS4zpORn6ov", "S8xh7faol6xkg145s9aDIWkyvYFJ4njt", "Q6jD8cwEOZ"};
    public static final int[] A04;
    public final GN A00;
    public final AtomicReference<DefaultTrackSelector$Parameters> A01;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static int A03(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int iIntValue = list.get(i6).intValue();
            if (A0L(trackGroup.A01(iIntValue), str, iArr[iIntValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    public static String A0C(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        A02 = new byte[]{96, 123, 113};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A0F(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!A0L(trackGroup.A01(iIntValue), str, iArr[iIntValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    static {
        A0E();
        A04 = new int[0];
    }

    public C0836Ay() {
        this(null);
    }

    public C0836Ay(GN gn) {
        this.A00 = gn;
        this.A01 = new AtomicReference<>(DefaultTrackSelector$Parameters.A0J);
    }

    public static int A00(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    public static int A01(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public static int A04(TrackGroup trackGroup, int[] iArr, GE ge) {
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            Format formatA01 = trackGroup.A01(i2);
            int count = iArr[i2];
            if (A0J(formatA01, count, ge)) {
                i++;
            }
        }
        return i;
    }

    public static Point A05(boolean z, int tempViewportWidth, int i, int i2, int i3) {
        if (z) {
            if ((i2 > i3) != (tempViewportWidth > i)) {
                tempViewportWidth = i;
                i = tempViewportWidth;
            }
        }
        if (i2 * i >= i3 * tempViewportWidth) {
            return new Point(tempViewportWidth, C0996Hx.A04(tempViewportWidth * i3, i2));
        }
        return new Point(C0996Hx.A04(i * i2, i3), i);
    }

    private final C0835Ax A06(int i, TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws C9K {
        TrackGroup trackGroup = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.A01; i4++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i4);
            if (A03[1].charAt(28) != 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "1NYDqnXuXqFwXvhmhx1oqfe5tY82";
            strArr[5] = "WKIyqdfHfHQHhajlNNxex4";
            int[] iArr2 = iArr[i4];
            for (int selectedTrackScore = 0; selectedTrackScore < trackGroupA01.A01; selectedTrackScore++) {
                if (A0H(iArr2[selectedTrackScore], defaultTrackSelector$Parameters.A0B)) {
                    int selectedTrackIndex = (trackGroupA01.A01(selectedTrackScore).A0D & 1) != 0 ? 2 : 1;
                    if (A0H(iArr2[selectedTrackScore], false)) {
                        selectedTrackIndex += 1000;
                    }
                    if (selectedTrackIndex > i3) {
                        trackGroup = trackGroupA01;
                        i2 = selectedTrackScore;
                        i3 = selectedTrackIndex;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new C0835Ax(trackGroup, i2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x006d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0081  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00de  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:64:0x0101  */
    /* JADX WARN: Code duplicated, block: B:78:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00ac A[SYNTHETIC] */
    public static C0835Ax A07(TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        int trackScore;
        int i;
        boolean zA0H;
        int comparisonResult;
        int formatPixelCount;
        int formatPixelCount2;
        int i2;
        String[] strArr;
        TrackGroup trackGroup = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        int groupIndex = -1;
        for (int selectedPixelCount = 0; selectedPixelCount < trackGroupArray.A01; selectedPixelCount++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(selectedPixelCount);
            List<Integer> listA0D = A0D(trackGroupA01, defaultTrackSelector$Parameters.A06, defaultTrackSelector$Parameters.A05, defaultTrackSelector$Parameters.A0F);
            int[] iArr2 = iArr[selectedPixelCount];
            int selectedTrackIndex = 0;
            while (true) {
                int i6 = trackGroupA01.A01;
                String[] strArr2 = A03;
                if (strArr2[2].length() != strArr2[5].length()) {
                    A03[0] = "lwqQHO";
                    if (selectedTrackIndex < i6) {
                        if (A0H(iArr2[selectedTrackIndex], defaultTrackSelector$Parameters.A0B)) {
                            Format formatA01 = trackGroupA01.A01(selectedTrackIndex);
                            boolean zContains = listA0D.contains(Integer.valueOf(selectedTrackIndex));
                            String[] strArr3 = A03;
                            if (strArr3[2].length() != strArr3[5].length()) {
                                A03[6] = "SiU1QSN6MQFkL93X4OOrhG4pGOhEurBM";
                                if (zContains) {
                                    i2 = formatA01.A0F;
                                    strArr = A03;
                                    if (strArr[3].length() != strArr[7].length()) {
                                        A03[1] = "4KlbdBkqrnIgKSOErHym9NPyt3h5FUou";
                                        trackScore = ((i2 != -1 || formatA01.A0F <= defaultTrackSelector$Parameters.A03) && (formatA01.A08 == -1 || formatA01.A08 <= defaultTrackSelector$Parameters.A02) && (formatA01.A04 == -1 || formatA01.A04 <= defaultTrackSelector$Parameters.A01)) ? 1 : 0;
                                    }
                                }
                                if (trackScore == 0 || defaultTrackSelector$Parameters.A0C) {
                                    if (trackScore != 0) {
                                        i = 2;
                                    } else {
                                        i = 1;
                                    }
                                    zA0H = A0H(iArr2[selectedTrackIndex], false);
                                    if (zA0H) {
                                        i += 1000;
                                    }
                                    if (i > i4) {
                                        comparisonResult = 1;
                                    } else {
                                        comparisonResult = 0;
                                    }
                                    if (i == i4) {
                                        if (defaultTrackSelector$Parameters.A0D) {
                                            if (A00(formatA01.A04, i5) < 0) {
                                                comparisonResult = 1;
                                            } else {
                                                comparisonResult = 0;
                                            }
                                        } else {
                                            formatPixelCount = formatA01.A0E();
                                            if (formatPixelCount != groupIndex) {
                                                formatPixelCount2 = A00(formatPixelCount, groupIndex);
                                            } else {
                                                int comparisonResult2 = formatA01.A04;
                                                formatPixelCount2 = A00(comparisonResult2, i5);
                                            }
                                            if (!zA0H && trackScore != 0) {
                                                comparisonResult = formatPixelCount2 > 0 ? 1 : 0;
                                            } else if (formatPixelCount2 < 0) {
                                                comparisonResult = 1;
                                            } else {
                                                comparisonResult = 0;
                                            }
                                        }
                                    }
                                    if (comparisonResult != 0) {
                                        trackGroup = trackGroupA01;
                                        i3 = selectedTrackIndex;
                                        i4 = i;
                                        i5 = formatA01.A04;
                                        groupIndex = formatA01.A0E();
                                    }
                                }
                            } else {
                                String[] strArr4 = A03;
                                strArr4[2] = "DpIh5EonHVTuVHRer6KDIMhApdM7";
                                strArr4[5] = "CmkW9iHHxPPPILgrY4olMD";
                                if (zContains) {
                                    i2 = formatA01.A0F;
                                    strArr = A03;
                                    if (strArr[3].length() != strArr[7].length()) {
                                        A03[1] = "4KlbdBkqrnIgKSOErHym9NPyt3h5FUou";
                                        if (i2 != -1) {
                                        }
                                    }
                                }
                                if (trackScore == 0) {
                                    if (trackScore != 0) {
                                        i = 2;
                                    } else {
                                        i = 1;
                                    }
                                    zA0H = A0H(iArr2[selectedTrackIndex], false);
                                    if (zA0H) {
                                        i += 1000;
                                    }
                                    if (i > i4) {
                                        comparisonResult = 1;
                                    } else {
                                        comparisonResult = 0;
                                    }
                                    if (i == i4) {
                                        if (defaultTrackSelector$Parameters.A0D) {
                                            if (A00(formatA01.A04, i5) < 0) {
                                                comparisonResult = 1;
                                            } else {
                                                comparisonResult = 0;
                                            }
                                        } else {
                                            formatPixelCount = formatA01.A0E();
                                            if (formatPixelCount != groupIndex) {
                                                formatPixelCount2 = A00(formatPixelCount, groupIndex);
                                            } else {
                                                int comparisonResult3 = formatA01.A04;
                                                formatPixelCount2 = A00(comparisonResult3, i5);
                                            }
                                            if (!zA0H) {
                                                if (formatPixelCount2 < 0) {
                                                    comparisonResult = 1;
                                                } else {
                                                    comparisonResult = 0;
                                                }
                                            } else if (formatPixelCount2 < 0) {
                                                comparisonResult = 1;
                                            } else {
                                                comparisonResult = 0;
                                            }
                                        }
                                    }
                                    if (comparisonResult != 0) {
                                        trackGroup = trackGroupA01;
                                        i3 = selectedTrackIndex;
                                        i4 = i;
                                        i5 = formatA01.A04;
                                        groupIndex = formatA01.A0E();
                                    }
                                } else {
                                    if (trackScore != 0) {
                                        i = 2;
                                    } else {
                                        i = 1;
                                    }
                                    zA0H = A0H(iArr2[selectedTrackIndex], false);
                                    if (zA0H) {
                                        i += 1000;
                                    }
                                    if (i > i4) {
                                        comparisonResult = 1;
                                    } else {
                                        comparisonResult = 0;
                                    }
                                    if (i == i4) {
                                        if (defaultTrackSelector$Parameters.A0D) {
                                            if (A00(formatA01.A04, i5) < 0) {
                                                comparisonResult = 1;
                                            } else {
                                                comparisonResult = 0;
                                            }
                                        } else {
                                            formatPixelCount = formatA01.A0E();
                                            if (formatPixelCount != groupIndex) {
                                                formatPixelCount2 = A00(formatPixelCount, groupIndex);
                                            } else {
                                                int comparisonResult4 = formatA01.A04;
                                                formatPixelCount2 = A00(comparisonResult4, i5);
                                            }
                                            if (!zA0H) {
                                                if (formatPixelCount2 < 0) {
                                                    comparisonResult = 1;
                                                } else {
                                                    comparisonResult = 0;
                                                }
                                            } else if (formatPixelCount2 < 0) {
                                                comparisonResult = 1;
                                            } else {
                                                comparisonResult = 0;
                                            }
                                        }
                                    }
                                    if (comparisonResult != 0) {
                                        trackGroup = trackGroupA01;
                                        i3 = selectedTrackIndex;
                                        i4 = i;
                                        i5 = formatA01.A04;
                                        groupIndex = formatA01.A0E();
                                    }
                                }
                            }
                            if (trackScore == 0) {
                                if (trackScore != 0) {
                                    i = 2;
                                } else {
                                    i = 1;
                                }
                                zA0H = A0H(iArr2[selectedTrackIndex], false);
                                if (zA0H) {
                                    i += 1000;
                                }
                                if (i > i4) {
                                    comparisonResult = 1;
                                } else {
                                    comparisonResult = 0;
                                }
                                if (i == i4) {
                                    if (defaultTrackSelector$Parameters.A0D) {
                                        if (A00(formatA01.A04, i5) < 0) {
                                            comparisonResult = 1;
                                        } else {
                                            comparisonResult = 0;
                                        }
                                    } else {
                                        formatPixelCount = formatA01.A0E();
                                        if (formatPixelCount != groupIndex) {
                                            formatPixelCount2 = A00(formatPixelCount, groupIndex);
                                        } else {
                                            int comparisonResult5 = formatA01.A04;
                                            formatPixelCount2 = A00(comparisonResult5, i5);
                                        }
                                        if (!zA0H) {
                                            if (formatPixelCount2 < 0) {
                                                comparisonResult = 1;
                                            } else {
                                                comparisonResult = 0;
                                            }
                                        } else if (formatPixelCount2 < 0) {
                                            comparisonResult = 1;
                                        } else {
                                            comparisonResult = 0;
                                        }
                                    }
                                }
                                if (comparisonResult != 0) {
                                    trackGroup = trackGroupA01;
                                    i3 = selectedTrackIndex;
                                    i4 = i;
                                    i5 = formatA01.A04;
                                    groupIndex = formatA01.A0E();
                                }
                            } else {
                                if (trackScore != 0) {
                                    i = 2;
                                } else {
                                    i = 1;
                                }
                                zA0H = A0H(iArr2[selectedTrackIndex], false);
                                if (zA0H) {
                                    i += 1000;
                                }
                                if (i > i4) {
                                    comparisonResult = 1;
                                } else {
                                    comparisonResult = 0;
                                }
                                if (i == i4) {
                                    if (defaultTrackSelector$Parameters.A0D) {
                                        if (A00(formatA01.A04, i5) < 0) {
                                            comparisonResult = 1;
                                        } else {
                                            comparisonResult = 0;
                                        }
                                    } else {
                                        formatPixelCount = formatA01.A0E();
                                        if (formatPixelCount != groupIndex) {
                                            formatPixelCount2 = A00(formatPixelCount, groupIndex);
                                        } else {
                                            int comparisonResult6 = formatA01.A04;
                                            formatPixelCount2 = A00(comparisonResult6, i5);
                                        }
                                        if (!zA0H) {
                                            if (formatPixelCount2 < 0) {
                                                comparisonResult = 1;
                                            } else {
                                                comparisonResult = 0;
                                            }
                                        } else if (formatPixelCount2 < 0) {
                                            comparisonResult = 1;
                                        } else {
                                            comparisonResult = 0;
                                        }
                                    }
                                }
                                if (comparisonResult != 0) {
                                    trackGroup = trackGroupA01;
                                    i3 = selectedTrackIndex;
                                    i4 = i;
                                    i5 = formatA01.A04;
                                    groupIndex = formatA01.A0E();
                                }
                            }
                        }
                        selectedTrackIndex++;
                    }
                }
                throw new RuntimeException();
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new C0835Ax(trackGroup, i3);
    }

    private final C0835Ax A08(TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws C9K {
        int i;
        int i2;
        TrackGroup trackGroup = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroupArray.A01; i5++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < trackGroupA01.A01; i6++) {
                if (A0H(iArr2[i6], defaultTrackSelector$Parameters.A0B)) {
                    Format formatA01 = trackGroupA01.A01(i6);
                    int i7 = formatA01.A0D & (defaultTrackSelector$Parameters.A00 ^ (-1));
                    boolean z = (i7 & 1) != 0;
                    boolean z2 = (i7 & 2) != 0;
                    boolean zA0K = A0K(formatA01, defaultTrackSelector$Parameters.A08);
                    if (zA0K || (defaultTrackSelector$Parameters.A0E && A0I(formatA01))) {
                        if (z) {
                            i = 8;
                        } else if (!z2) {
                            i = 6;
                        } else {
                            i = 4;
                        }
                        i2 = i + (zA0K ? 1 : 0);
                    } else if (z) {
                        i2 = 3;
                    } else if (z2) {
                        if (A0K(formatA01, defaultTrackSelector$Parameters.A07)) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                    }
                    if (A0H(iArr2[i6], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i4) {
                        trackGroup = trackGroupA01;
                        i3 = i6;
                        i4 = i2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new C0835Ax(trackGroup, i3);
    }

    public static GO A09(TrackGroupArray trackGroupArray, int[][] iArr, int i, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, GN gn) throws C9K {
        int i2;
        if (defaultTrackSelector$Parameters.A0A) {
            i2 = 24;
        } else {
            i2 = 16;
        }
        boolean z = defaultTrackSelector$Parameters.A09 && (i & i2) != 0;
        for (int i3 = 0; i3 < trackGroupArray.A01; i3++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i3);
            int[] iArrA0O = A0O(trackGroupA01, iArr[i3], z, i2, defaultTrackSelector$Parameters.A03, defaultTrackSelector$Parameters.A02, defaultTrackSelector$Parameters.A01, defaultTrackSelector$Parameters.A06, defaultTrackSelector$Parameters.A05, defaultTrackSelector$Parameters.A0F);
            if (iArrA0O.length > 0) {
                return ((GN) HI.A01(gn)).A4k(trackGroupA01, iArrA0O);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    private final GO A0A(TrackGroupArray trackGroupArray, int[][] iArr, int i, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, GN gn) throws C9K {
        int groupIndex = -1;
        int i2 = -1;
        GF trackScore = null;
        for (int i3 = 0; i3 < selectedTrackIndex; i3++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < selectedTrackIndex; i4++) {
                int selectedGroupIndex = iArr2[i4];
                if (A0H(selectedGroupIndex, defaultTrackSelector$Parameters.A0B)) {
                    Format formatA01 = trackGroupA01.A01(i4);
                    int selectedTrackIndex = iArr2[i4];
                    GF gf = new GF(formatA01, defaultTrackSelector$Parameters, selectedTrackIndex);
                    if (trackScore != null) {
                        int selectedTrackIndex2 = gf.A00(trackScore);
                        if (selectedTrackIndex2 > 0) {
                            i2 = i3;
                            groupIndex = i4;
                            trackScore = gf;
                        }
                    } else {
                        i2 = i3;
                        groupIndex = i4;
                        trackScore = gf;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        TrackGroup trackGroupA02 = trackGroupArray.A01(i2);
        if (!defaultTrackSelector$Parameters.A0D && gn != null) {
            int[] iArrA0N = A0N(trackGroupA02, iArr[i2], defaultTrackSelector$Parameters.A09);
            int selectedTrackIndex3 = iArrA0N.length;
            if (selectedTrackIndex3 > 0) {
                return gn.A4k(trackGroupA02, iArrA0N);
            }
        }
        return new C0835Ax(trackGroupA02, groupIndex);
    }

    private final GO A0B(TrackGroupArray trackGroupArray, int[][] iArr, int i, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, GN gn) throws C9K {
        GO goA09 = null;
        if (!defaultTrackSelector$Parameters.A0D && gn != null) {
            goA09 = A09(trackGroupArray, iArr, i, defaultTrackSelector$Parameters, gn);
        }
        if (goA09 == null) {
            return A07(trackGroupArray, iArr, defaultTrackSelector$Parameters);
        }
        return goA09;
    }

    public static List<Integer> A0D(TrackGroup trackGroup, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(trackGroup.A01);
        for (int i3 = 0; i3 < trackGroup.A01; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i4 = Integer.MAX_VALUE;
        for (int videoPixels = 0; videoPixels < trackGroup.A01; videoPixels++) {
            Format formatA01 = trackGroup.A01(videoPixels);
            if (formatA01.A0F > 0 && formatA01.A08 > 0) {
                Point pointA05 = A05(z, i, i2, formatA01.A0F, formatA01.A08);
                int i5 = formatA01.A0F * formatA01.A08;
                if (formatA01.A0F >= ((int) (pointA05.x * 0.98f)) && formatA01.A08 >= ((int) (pointA05.y * 0.98f)) && i5 < i4) {
                    i4 = i5;
                }
            }
        }
        if (i4 != Integer.MAX_VALUE) {
            for (int maxVideoPixelsToRetain = arrayList.size() - 1; maxVideoPixelsToRetain >= 0; maxVideoPixelsToRetain--) {
                int i6 = trackGroup.A01(((Integer) arrayList.get(maxVideoPixelsToRetain)).intValue()).A0E();
                if (i6 == -1 || i6 > i4) {
                    arrayList.remove(maxVideoPixelsToRetain);
                }
            }
        }
        return arrayList;
    }

    public static void A0G(GM gm, int[][][] iArr, C08069t[] c08069tArr, GO[] goArr, int i) {
        if (i == 0) {
            return;
        }
        int i2 = -1;
        int i3 = -1;
        boolean z = true;
        int i4 = 0;
        while (true) {
            int tunnelingAudioRendererIndex = gm.A00();
            if (i4 >= tunnelingAudioRendererIndex) {
                break;
            }
            int i5 = gm.A01(i4);
            GO go = goArr[i4];
            if ((i5 == 1 || i5 == 2) && go != null && A0M(iArr[i4], gm.A02(i4), go)) {
                if (i5 == 1) {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                } else {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i4;
                }
            }
            i4++;
        }
        if (z & ((i2 == -1 || i3 == -1) ? false : true)) {
            C08069t c08069t = new C08069t(i);
            c08069tArr[i2] = c08069t;
            c08069tArr[i3] = c08069t;
        }
    }

    public static boolean A0H(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    public static boolean A0I(Format format) {
        return TextUtils.isEmpty(format.A0N) || A0K(format, A0C(0, 3, 97));
    }

    public static boolean A0J(Format format, int i, GE ge) {
        if (!A0H(i, false) || format.A05 != ge.A00 || format.A0C != ge.A01) {
            return false;
        }
        String str = ge.A02;
        String[] strArr = A03;
        if (strArr[3].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A03[4] = "Z4TnxuroRrU42RhZWOmYjmwLcPTU1MVO";
        return str == null || TextUtils.equals(ge.A02, format.A0O);
    }

    public static boolean A0K(Format format, String str) {
        if (str != null) {
            boolean zEquals = TextUtils.equals(str, C0996Hx.A0L(format.A0N));
            if (A03[1].charAt(28) != 'F') {
                throw new RuntimeException();
            }
            A03[6] = "X09dGmvImKzkjml92Go2OBGPrO7s8ElS";
            if (zEquals) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0L(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!A0H(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !C0996Hx.A0g(format.A0O, str)) {
            return false;
        }
        if (format.A0F != -1 && format.A0F > i3) {
            return false;
        }
        int i6 = format.A08;
        String[] strArr = A03;
        if (strArr[2].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        A03[4] = "SWfcLm8XXzRqeXuobK6MjvAJ3gvDaDv7";
        if (i6 == -1 || format.A08 <= i4) {
            return format.A04 == -1 || format.A04 <= i5;
        }
        return false;
    }

    public static boolean A0M(int[][] iArr, TrackGroupArray trackGroupArray, GO go) {
        if (go == null) {
            return false;
        }
        int iA00 = trackGroupArray.A00(go.A81());
        for (int i = 0; i < go.length(); i++) {
            int trackGroupIndex = iArr[iA00][go.A75(i)] & 32;
            if (trackGroupIndex != 32) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0052  */
    public static int[] A0N(TrackGroup trackGroup, int[] iArr, boolean z) {
        int index;
        int configurationCount = 0;
        GE ge = null;
        HashSet hashSet = new HashSet();
        int i = 0;
        while (true) {
            int i2 = trackGroup.A01;
            if (A03[4].charAt(23) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "meGLfV23Rzl9igGpAxJQFKheW1LS";
            strArr[5] = "FiWVyQMXAFPncybwnc3GZ7";
            if (i < i2) {
                Format formatA01 = trackGroup.A01(i);
                GE ge2 = new GE(formatA01.A05, formatA01.A0C, z ? null : formatA01.A0O);
                if (hashSet.add(ge2)) {
                    int i3 = A04(trackGroup, iArr, ge2);
                    if (A03[1].charAt(28) != 'F') {
                        if (i3 > configurationCount) {
                            ge = ge2;
                            configurationCount = i3;
                        }
                    } else {
                        A03[1] = "qbEeyg8BdzMApnixm7aM3K2w4BJzFZ2Y";
                        if (i3 > configurationCount) {
                            ge = ge2;
                            configurationCount = i3;
                        }
                    }
                }
                i++;
            } else {
                if (configurationCount > 1) {
                    int[] iArr2 = new int[configurationCount];
                    int i4 = 0;
                    if (A03[4].charAt(23) != 'I') {
                        String[] strArr2 = A03;
                        strArr2[2] = "4LRww03tsnXN2lDzEbKe5Z8dH5qv";
                        strArr2[5] = "mlJWR4ilrpKl1KfE3NcYmb";
                        index = 0;
                    } else {
                        index = 0;
                    }
                    while (index < selectedConfigurationTrackCount) {
                        Format formatA02 = trackGroup.A01(index);
                        int configurationCount2 = iArr[index];
                        Object objA01 = HI.A01(ge);
                        if (A03[1].charAt(28) != 'F') {
                            throw new RuntimeException();
                        }
                        A03[4] = "nSxM8ZPkvfs0IWAG7eseSPBOLfK4wpcw";
                        if (A0J(formatA02, configurationCount2, (GE) objA01)) {
                            int selectedConfigurationTrackCount = i4 + 1;
                            iArr2[i4] = index;
                            i4 = selectedConfigurationTrackCount;
                        }
                        index++;
                    }
                    return iArr2;
                }
                return A04;
            }
        }
    }

    public static int[] A0O(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int selectedMimeTypeTrackCount, int i3, int i4, int i5, boolean z2) {
        int countForMimeType;
        if (trackGroup.A01 >= 2) {
            List<Integer> listA0D = A0D(trackGroup, i4, i5, z2);
            if (listA0D.size() < 2) {
                return A04;
            }
            String selectedMimeType = null;
            if (!z) {
                HashSet hashSet = new HashSet();
                int i6 = 0;
                for (int selectedMimeTypeTrackCount2 = 0; selectedMimeTypeTrackCount2 < listA0D.size(); selectedMimeTypeTrackCount2++) {
                    String str = trackGroup.A01(listA0D.get(selectedMimeTypeTrackCount2).intValue()).A0O;
                    if (hashSet.add(str) && (countForMimeType = A03(trackGroup, iArr, i, str, i2, selectedMimeTypeTrackCount, i3, listA0D)) > i6) {
                        selectedMimeType = str;
                        i6 = countForMimeType;
                    }
                }
            }
            A0F(trackGroup, iArr, i, selectedMimeType, i2, selectedMimeTypeTrackCount, i3, listA0D);
            return listA0D.size() < 2 ? A04 : C0996Hx.A0j(listA0D);
        }
        return A04;
    }

    private final GO[] A0P(GM gm, int[][][] iArr, int[] iArr2, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws C9K {
        int iA00 = gm.A00();
        GO[] goArr = new GO[iA00];
        boolean seenVideoRendererWithMappedTracks = false;
        boolean z = false;
        for (int i = 0; i < iA00; i++) {
            if (2 == gm.A01(i)) {
                if (!z) {
                    goArr[i] = A0B(gm.A02(i), iArr[i], iArr2[i], defaultTrackSelector$Parameters, this.A00);
                    z = goArr[i] != null;
                }
                seenVideoRendererWithMappedTracks |= gm.A02(i).A01 > 0;
            }
        }
        boolean z2 = false;
        int rendererCount = 0;
        for (int i2 = 0; i2 < iA00; i2++) {
            int iA01 = gm.A01(i2);
            switch (iA01) {
                case 1:
                    if (!z2) {
                        TrackGroupArray trackGroupArrayA02 = gm.A02(i2);
                        int[][] iArr3 = iArr[i2];
                        int i3 = iArr2[i2];
                        goArr[i2] = A0A(trackGroupArrayA02, iArr3, i3, defaultTrackSelector$Parameters, seenVideoRendererWithMappedTracks ? null : this.A00);
                        z2 = goArr[i2] != null;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    if (rendererCount != 0) {
                        continue;
                    } else {
                        goArr[i2] = A08(gm.A02(i2), iArr[i2], defaultTrackSelector$Parameters);
                        rendererCount = goArr[i2] != null ? 1 : 0;
                        if (A03[1].charAt(28) != 'F') {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[2] = "QJl7DztNVPNycYqDWlGKy9194VAG";
                        strArr[5] = "9kW2zRUIc2UhcVCPTVcu4Y";
                    }
                    break;
                default:
                    goArr[i2] = A06(iA01, gm.A02(i2), iArr[i2], defaultTrackSelector$Parameters);
                    break;
            }
        }
        return goArr;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0083  */
    @Override // com.facebook.ads.redexgen.X.VN
    public final Pair<C08069t[], GO[]> A0V(GM gm, int[][][] iArr, int[] iArr2) throws C9K {
        boolean z;
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = this.A01.get();
        int iA00 = gm.A00();
        GO[] goArrA0P = A0P(gm, iArr, iArr2, defaultTrackSelector$Parameters);
        for (int i = 0; i < iA00; i++) {
            if (defaultTrackSelector$Parameters.A06(i)) {
                goArrA0P[i] = null;
            } else {
                TrackGroupArray trackGroupArrayA02 = gm.A02(i);
                if (defaultTrackSelector$Parameters.A07(i, trackGroupArrayA02)) {
                    DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverrideA05 = defaultTrackSelector$Parameters.A05(i, trackGroupArrayA02);
                    if (defaultTrackSelector$SelectionOverrideA05 == null) {
                        goArrA0P[i] = null;
                    } else if (defaultTrackSelector$SelectionOverrideA05.A01 == 1) {
                        TrackGroup trackGroupA01 = trackGroupArrayA02.A01(defaultTrackSelector$SelectionOverrideA05.A00);
                        int rendererCount = defaultTrackSelector$SelectionOverrideA05.A02[0];
                        goArrA0P[i] = new C0835Ax(trackGroupA01, rendererCount);
                    } else {
                        goArrA0P[i] = ((GN) HI.A01(this.A00)).A4k(trackGroupArrayA02.A01(defaultTrackSelector$SelectionOverrideA05.A00), defaultTrackSelector$SelectionOverrideA05.A02);
                    }
                }
            }
        }
        C08069t[] rendererConfigurations = new C08069t[iA00];
        for (int i2 = 0; i2 < iA00; i2++) {
            if (!defaultTrackSelector$Parameters.A06(i2)) {
                int rendererCount2 = gm.A01(i2);
                if (rendererCount2 == 5 || goArrA0P[i2] != null) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            rendererConfigurations[i2] = z ? C08069t.A01 : null;
        }
        A0G(gm, iArr, rendererConfigurations, goArrA0P, defaultTrackSelector$Parameters.A04);
        return Pair.create(rendererConfigurations, goArrA0P);
    }
}
