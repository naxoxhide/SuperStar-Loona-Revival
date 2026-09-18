package com.facebook.ads.redexgen.X;

import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.core.view.PointerIconCompat;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class D9 {
    public static int A00;
    public static byte[] A01;
    public static String[] A02 = {"BAY", "ymxL57jYYv0jjQRcHQbZ4WAbO", "V4mYndI5uaXc7arEQ3TceizUtwuJpZsP", "bZ", "bvLsrur7DOWvoKolroRaEPylJxsC8CBw", "pPHP1LRPBsm50pfT1", "f9saOCuwOfCGSEN51CDIZYerwD3UjJFW", "NB4ZEOXNx"};
    public static final SparseIntArray A03;
    public static final SparseIntArray A04;
    public static final C0874Cy A05;
    public static final HashMap<D6, List<C0874Cy>> A06;
    public static final Map<String, Integer> A07;
    public static final Pattern A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static int A00() throws D7 {
        if (A00 == -1) {
            int iMax = 0;
            C0874Cy c0874CyA06 = A06(A07(PointerIconCompat.TYPE_CELL, 9, 38), false);
            if (c0874CyA06 != null) {
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : c0874CyA06.A0J()) {
                    iMax = Math.max(A01(codecProfileLevel.level), iMax);
                }
                iMax = Math.max(iMax, C0996Hx.A02 >= 21 ? 345600 : 172800);
            }
            A00 = iMax;
        }
        return A00;
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 109);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0067  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d8 A[Catch: Exception -> 0x0151, TRY_ENTER, TryCatch #5 {Exception -> 0x0151, blocks: (B:6:0x0022, B:8:0x002a, B:11:0x0036, B:39:0x00c8, B:42:0x00d8, B:44:0x00de, B:48:0x0112, B:49:0x014d, B:45:0x0109, B:46:0x010d), top: B:66:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0112 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static ArrayList<C0874Cy> A08(D6 d6, D8 d8, String str) throws D7 {
        int i;
        String strA07;
        try {
            ArrayList<C0874Cy> arrayList = new ArrayList<>();
            String str2 = d6.A00;
            int iA6O = d8.A6O();
            boolean zAEu = d8.AEu();
            for (int i2 = 0; i2 < iA6O; i2++) {
                MediaCodecInfo mediaCodecInfoA6P = d8.A6P(i2);
                String name = mediaCodecInfoA6P.getName();
                try {
                    if (A0C(mediaCodecInfoA6P, name, zAEu, str)) {
                        for (String str3 : mediaCodecInfoA6P.getSupportedTypes()) {
                            if (str3.equalsIgnoreCase(str2)) {
                                try {
                                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA6P.getCapabilitiesForType(str3);
                                    boolean zA94 = d8.A94(str2, capabilitiesForType);
                                    boolean zA0D = A0D(name);
                                    if (zAEu) {
                                        try {
                                            boolean z = d6.A01;
                                            if (A02[7].length() == 9) {
                                                String[] strArr = A02;
                                                strArr[3] = "CD";
                                                strArr[0] = "ZBY";
                                                if (z != zA94) {
                                                    if (!zAEu) {
                                                        try {
                                                            if (!d6.A01) {
                                                                try {
                                                                    arrayList.add(C0874Cy.A02(name, str2, capabilitiesForType, zA0D, false));
                                                                } catch (Exception e) {
                                                                    e = e;
                                                                    i = C0996Hx.A02;
                                                                    strA07 = A07(425, 14, 38);
                                                                    if (i <= 23) {
                                                                    }
                                                                    Log.e(strA07, A07(167, 22, 9) + name + A07(0, 2, 58) + str3 + A07(33, 1, 97));
                                                                    throw e;
                                                                }
                                                            }
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            String[] strArr2 = A02;
                                                            if (strArr2[3].length() == strArr2[0].length()) {
                                                                throw new RuntimeException();
                                                            }
                                                            A02[5] = "MyzIrPx41nvhJUnfD";
                                                            i = C0996Hx.A02;
                                                            strA07 = A07(425, 14, 38);
                                                            if (i <= 23 || arrayList.isEmpty()) {
                                                                Log.e(strA07, A07(167, 22, 9) + name + A07(0, 2, 58) + str3 + A07(33, 1, 97));
                                                                throw e;
                                                            }
                                                            Log.e(strA07, A07(780, 15, 115) + name + A07(2, 31, 118));
                                                        }
                                                    }
                                                    if (!zAEu && zA94) {
                                                        arrayList.add(C0874Cy.A02(name + A07(46, 7, 0), str2, capabilitiesForType, zA0D, true));
                                                        return arrayList;
                                                    }
                                                } else {
                                                    arrayList.add(C0874Cy.A02(name, str2, capabilitiesForType, zA0D, false));
                                                }
                                            }
                                            throw new RuntimeException();
                                        } catch (Exception e3) {
                                            e = e3;
                                            i = C0996Hx.A02;
                                            strA07 = A07(425, 14, 38);
                                            if (i <= 23) {
                                            }
                                            Log.e(strA07, A07(167, 22, 9) + name + A07(0, 2, 58) + str3 + A07(33, 1, 97));
                                            throw e;
                                        }
                                    }
                                    if (!zAEu) {
                                        if (!d6.A01) {
                                            arrayList.add(C0874Cy.A02(name, str2, capabilitiesForType, zA0D, false));
                                        }
                                    }
                                    if (!zAEu) {
                                        continue;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                }
                            }
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    throw new D7(e);
                }
            }
            return arrayList;
        } catch (Exception e6) {
            e = e6;
        }
    }

    public static void A0A() {
        if (A02[4].charAt(9) != 'O') {
            throw new RuntimeException();
        }
        A02[1] = "WfhNiOeVQzQSnYcncz46tqnXb";
        A01 = new byte[]{-57, -49, 3, 11, 73, 68, 76, 79, 72, 71, 3, 87, 82, 3, 84, 88, 72, 85, 92, 3, 70, 68, 83, 68, 69, 76, 79, 76, 87, 76, 72, 86, 12, -9, -92, -106, -73, -23, -23, -21, -29, -33, -28, -35, -80, -106, -101, -32, -46, -48, -30, -33, -46, -1, -28, 30, 26, 30, Base64.padSymbol, 45, 13, 13, 15, 16, 49, 47, 59, 48, 49, 62, -29, -47, -43, -48, -44, 10, -8, -4, -9, -4, -44, -62, -57, -63, -59, -31, -49, -44, -50, -45, -73, -86, -86, -92, -90, -65, -78, -78, -84, -81, -13, -26, -26, -32, -26, -72, -85, -85, -90, -85, -61, -55, -48, -63, -63, -61, -60, -27, -29, -17, -28, -27, -14, -45, -39, -32, -47, -35, -30, -34, -46, -44, -11, -13, -1, -12, -11, 2, 43, 49, 56, 53, 56, 27, 44, 77, 75, 87, 76, 77, 90, -36, -30, -23, -17, 8, 11, -5, 2, 12, -35, -2, -4, 8, -3, -2, 11, -68, -41, -33, -30, -37, -38, -106, -22, -27, -106, -25, -21, -37, -24, -17, -106, -39, -27, -38, -37, -39, -106, -67, -90, -89, -91, 49, 26, 27, 28, 25, 2, 6, 1, 48, 25, 29, 27, -31, -54, -50, -49, -64, -87, -80, -88, -60, -83, -76, -81, 18, -5, 2, 0, -3, -24, -27, -5, -23, -29, 44, 26, 23, -75, -90, -99, 18, 3, -3, 19, 24, -20, 10, 17, 18, 21, 12, 17, 10, -61, 16, 4, 15, 9, 18, 21, 16, 8, 7, -61, -28, -7, -26, -61, 6, 18, 7, 8, 6, -61, 22, 23, 21, 12, 17, 10, -35, -61, -18, 12, 19, 20, 23, 14, 19, 12, -59, 18, 6, 17, 11, 20, 23, 18, 10, 9, -59, -19, -22, -5, -24, -59, 8, 20, 9, 10, 8, -59, 24, 25, 23, 14, 19, 12, -33, -59, 8, -19, -18, -20, -35, -62, -61, -60, -17, -44, -40, -45, 6, -21, -17, -19, 3, -24, -20, -19, -61, -88, -81, -89, -5, -32, -25, -30, -50, -77, -70, -72, 5, -20, -23, -20, -45, -42, 8, -6, -28, -34, -62, -84, -87, 28, 9, 0, -1, -20, -26, 32, 35, 6, 23, 56, 54, 66, 55, 56, 69, 10, 34, 33, 38, 30, 0, 44, 33, 34, 32, 9, 38, 48, 49, -35, -2, 13, 6, -35, 33, 38, 33, 43, -28, 49, -35, 41, 38, 48, 49, -35, 48, 34, 32, 50, 47, 34, -35, 33, 34, 32, 44, 33, 34, 47, -35, 35, 44, 47, -9, -35, -32, -8, -9, -4, -12, -42, 2, -9, -8, -10, -24, 7, -4, -1, -58, -35, -16, -19, -21, -104, -87, -88, 48, 37, 51, 48, 42, 37, 14, 57, 54, 20, 6, 4, 15, -27, -4, 47, 48, 37, 38, 42, -27, -8, -8, -6, -27, -5, 28, 26, 38, 27, 28, 41, 1, -1, 10, -32, -9, 42, 43, 32, 33, 37, -32, -13, 8, -11, -32, -10, 23, 21, 33, 22, 23, 36, 12, 10, 21, -21, 2, 53, 54, 43, 44, 48, -21, -2, 19, 0, -21, 1, 34, 32, 44, 33, 34, 47, -21, 48, 34, 32, 50, 47, 34, -54, -56, -45, -87, -56, -49, -58, -87, -68, -48, -65, -60, -54, -87, -65, -64, -66, -54, -65, -64, -51, -87, -68, -68, -66, 8, 6, 17, -25, 6, 13, 4, -25, -6, 14, -3, 2, 8, -25, -3, -2, -4, 8, -3, -2, 11, -25, -3, 12, 9, -6, -4, -20, 43, 41, 52, 10, 41, 48, 39, 10, 29, 49, 32, 37, 43, 10, 32, 33, 31, 43, 32, 33, 46, 10, 46, 29, 51, -38, -40, -29, -71, -34, -48, -50, -71, -40, -37, -66, -71, -49, -16, -18, -6, -17, -16, -3, -15, -17, -6, -48, -11, -25, -27, -48, 3, 3, 5, -48, 6, 7, 5, -62, -64, -53, -95, -58, -72, -74, -95, -23, -29, -85, -95, -41, -40, -42, -7, -9, 2, -40, 17, 25, 25, 17, 22, 15, -40, 28, 11, 33, -40, 14, 15, 13, 25, 14, 15, 28, 11, 9, 20, -22, 45, 31, 43, 41, -22, 29, 49, 32, 37, 43, -22, 32, 33, 31, 43, 32, 33, 46, -22, 29, 29, 31, 14, 12, 23, -19, 48, 34, 46, 44, -19, 32, 52, 35, 40, 46, -19, 35, 36, 34, 46, 35, 36, 49, -19, 44, 47, -14, 24, 22, 33, -9, 58, 44, 56, 54, -9, 63, 50, 45, 46, 56, -9, 45, 46, 44, 56, 45, 46, 59, -9, 63, 57, 1, 63, 47, 25, 28, 32, 51, -32, -48, -70, -67, -62, -44, 49, 33, 52, 17, 15, 56, 52, 18, 21, 23, 42, 51, 75, 73, 80, 80, 73, 78, 71, 0, 67, 79, 68, 69, 67, 0, -23, 2, -1, 2, 3, 11, 2, -76, -43, -22, -41, -76, 0, -7, 10, -7, 0, -50, -76, 44, 69, 66, 69, 70, 78, 69, -9, 24, 45, 26, -9, 71, 73, 70, Base64.padSymbol, SignedBytes.MAX_POWER_OF_TWO, 67, 60, 17, -9, 12, 37, 34, 37, 38, 46, 37, -41, -1, -4, 13, -6, -41, 35, 28, 45, 28, 35, -41, 42, 43, 41, 32, 37, 30, -15, -41, 50, 75, 72, 75, 76, 84, 75, -3, 37, 34, 51, 32, -3, 77, 79, 76, 67, 70, 73, 66, -3, 80, 81, 79, 70, 75, 68, 23, -3, -7, 10, 2, 16, 14, 10, 30, -16, -34, -36, -60, -65, -88, -36, -28, -85, -87, -92, 62, 20, 13, 25, 45, 28, 33, 39, -25, 29, 25, 27, -21, 0, 20, 3, 8, 14, -50, 4, 0, 2, -46, -52, 9, 14, 2, -25, -4, -23, -73, 66, 87, 68, 19, 73, 23, 4, 12, 24, 21, 42, 40, 40, -18, -21, -4, -73, -9, 5, -14, -64, 17, 13, 19, 27, 12, -8, -20, -3, -12, -7, -16, -9, -1, -16, -20, -1, -1, 12, 14, 11, 16, 11, 17, -20, -38, -26, -20, -18, -25, -32, -29, -47, -34, -28, -33, -29, -6, -20, -7, 
        -7, -24, -11, -10, -3, -71, 9, -4, -9, -8, 2, -62, -12, 9, -10, 43, 30, 33, 33, 26, 42, 29, 32, 32, 25, 23, -26, 53, 40, 43, 43, 36, 47, 43, 52, 50, 2, -19, -10, -12, -4, -19, 96, 75, 88, 85, 76, 82, 90, 75, 2, -19, -6, -9, -12, -4, -19};
    }

    static {
        A0A();
        A05 = C0874Cy.A01(A07(657, 22, 61));
        A08 = Pattern.compile(A07(899, 10, 19));
        A06 = new HashMap<>();
        A00 = -1;
        SparseIntArray sparseIntArray = new SparseIntArray();
        A04 = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        A03 = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap map = new HashMap();
        A07 = map;
        map.put(A07(345, 3, 76), 1);
        map.put(A07(352, 3, 65), 4);
        map.put(A07(355, 3, 9), 16);
        map.put(A07(358, 3, 99), 64);
        map.put(A07(361, 3, 70), 256);
        map.put(A07(313, 4, 79), 1024);
        map.put(A07(317, 4, 36), 4096);
        map.put(A07(321, 4, 54), 16384);
        map.put(A07(325, 4, 77), 65536);
        map.put(A07(329, 4, 74), 262144);
        map.put(A07(333, 4, 10), 1048576);
        map.put(A07(337, 4, 66), 4194304);
        map.put(A07(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 4, 21), 16777216);
        map.put(A07(221, 3, 72), 2);
        map.put(A07(224, 3, 70), 8);
        map.put(A07(227, 3, 119), 32);
        map.put(A07(230, 3, 0), 128);
        map.put(A07(233, 3, 93), 512);
        map.put(A07(189, 4, 8), 2048);
        map.put(A07(193, 4, 124), 8192);
        map.put(A07(197, 4, 100), 32768);
        map.put(A07(201, 4, 123), 131072);
        map.put(A07(205, 4, 44), 524288);
        map.put(A07(209, 4, 11), 2097152);
        map.put(A07(213, 4, 15), 8388608);
        map.put(A07(217, 4, 93), 33554432);
    }

    public static int A01(int i) {
        switch (i) {
            case 1:
                return 25344;
            case 2:
                return 25344;
            case 8:
                return 101376;
            case 16:
                return 101376;
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
                return 414720;
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
                return 2097152;
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
                return 9437184;
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:9:0x001f A[RETURN] */
    public static Pair<Integer, Integer> A02(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(A07(897, 2, 85));
        byte b2 = 0;
        String str2 = strArrSplit[0];
        switch (str2.hashCode()) {
            case 3006243:
                if (str2.equals(A07(936, 4, 25))) {
                    b2 = 2;
                } else {
                    b2 = -1;
                }
                switch (b2) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
            case 3006244:
                if (str2.equals(A07(940, 4, 116))) {
                    b2 = 3;
                } else {
                    b2 = -1;
                }
                switch (b2) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
            case 3199032:
                if (!str2.equals(A07(953, 4, 25))) {
                    b2 = -1;
                }
                switch (b2) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
            case 3214780:
                String[] parts = A02;
                if (parts[4].charAt(9) != 'O') {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[2] = "MmTCu4eMbW5HStPFtCsv7ZFMn3CvoIap";
                strArr[6] = "LZKP0I4cIbW5T2P3pagUWnAfz2n8Y4ic";
                if (str2.equals(A07(957, 4, 34))) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
                switch (b2) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
            default:
                b2 = -1;
                switch (b2) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
        }
    }

    public static Pair<Integer, Integer> A03(String str, String[] strArr) {
        Integer numValueOf;
        Integer numValueOf2;
        int length = strArr.length;
        String strA07 = A07(238, 37, 54);
        String strA08 = A07(425, 14, 38);
        if (length < 2) {
            Log.w(strA08, strA07 + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                numValueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                numValueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                Log.w(strA08, strA07 + str);
                return null;
            }
            int i = A04.get(numValueOf.intValue(), -1);
            if (i == -1) {
                Log.w(strA08, A07(814, 21, 106) + numValueOf);
                return null;
            }
            int i2 = A03.get(numValueOf2.intValue(), -1);
            if (i2 == -1) {
                Log.w(strA08, A07(795, 19, 39) + numValueOf2);
                return null;
            }
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        } catch (NumberFormatException unused) {
            Log.w(strA08, strA07 + str);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a9, code lost:
    
        if (r6 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ab, code lost:
    
        android.util.Log.w(r4, A07(835, 27, 74) + r3.group(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00cd, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d7, code lost:
    
        if (r6 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f4, code lost:
    
        return new android.util.Pair<>(java.lang.Integer.valueOf(r7), r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> A04(java.lang.String r9, java.lang.String[] r10) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D9.A04(java.lang.String, java.lang.String[]):android.util.Pair");
    }

    public static C0874Cy A05() {
        return A05;
    }

    public static C0874Cy A06(String str, boolean z) throws D7 {
        List<C0874Cy> listA09 = A09(str, z);
        if (listA09.isEmpty()) {
            return null;
        }
        return listA09.get(0);
    }

    public static synchronized List<C0874Cy> A09(String str, boolean z) throws D7 {
        D6 d6 = new D6(str, z);
        HashMap<D6, List<C0874Cy>> map = A06;
        List<C0874Cy> list = map.get(d6);
        if (list != null) {
            return list;
        }
        D8 c1353Vz = C0996Hx.A02 >= 21 ? new C1353Vz(z) : new W0();
        ArrayList<C0874Cy> arrayListA08 = A08(d6, c1353Vz, str);
        if (z && arrayListA08.isEmpty() && 21 <= C0996Hx.A02 && C0996Hx.A02 <= 23) {
            c1353Vz = new W0();
            arrayListA08 = A08(d6, c1353Vz, str);
            if (!arrayListA08.isEmpty()) {
                Log.w(A07(425, 14, 38), A07(374, 51, 80) + str + A07(34, 12, 9) + arrayListA08.get(0).A02);
            }
        }
        if (A07(922, 14, 50).equals(str)) {
            arrayListA08.addAll(A08(new D6(A07(912, 10, 75), d6.A01), c1353Vz, str));
        }
        A0B(arrayListA08);
        List<C0874Cy> listUnmodifiableList = Collections.unmodifiableList(arrayListA08);
        map.put(d6, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static void A0B(List<C0874Cy> list) {
        if (C0996Hx.A02 < 26 && list.size() > 1) {
            if (A07(583, 25, 111).equals(list.get(0).A02)) {
                for (int i = 1; i < list.size(); i++) {
                    C0874Cy c0874Cy = list.get(i);
                    if (A07(657, 22, 61).equals(c0874Cy.A02)) {
                        list.remove(i);
                        list.add(0, c0874Cy);
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:116:0x0329  */
    /* JADX WARN: Code duplicated, block: B:122:0x034e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0393  */
    /* JADX WARN: Code duplicated, block: B:132:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:134:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:136:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:153:0x0426  */
    /* JADX WARN: Code duplicated, block: B:24:0x0087  */
    /* JADX WARN: Code duplicated, block: B:26:0x0097  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:45:0x010f  */
    /* JADX WARN: Code duplicated, block: B:47:0x012b  */
    /* JADX WARN: Code duplicated, block: B:52:0x013f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0148  */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02c1, code lost:
    
        if (A07(85, 5, 49).equals(com.facebook.ads.redexgen.X.C0996Hx.A03) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x03d6, code lost:
    
        if (A07(769, 5, 113).equals(com.facebook.ads.redexgen.X.C0996Hx.A03) != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
    
        if (A07(364, 10, 102).equals(r8) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0157, code lost:
    
        if (com.facebook.ads.redexgen.X.C0996Hx.A03.startsWith(A07(236, 2, 94)) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x023a, code lost:
    
        if (A07(774, 6, 120).equals(com.facebook.ads.redexgen.X.C0996Hx.A03) != false) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0C(android.media.MediaCodecInfo r7, java.lang.String r8, boolean r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 1216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D9.A0C(android.media.MediaCodecInfo, java.lang.String, boolean, java.lang.String):boolean");
    }

    public static boolean A0D(String str) {
        if (C0996Hx.A02 <= 22) {
            if ((A07(447, 10, 116).equals(C0996Hx.A06) || A07(439, 8, 11).equals(C0996Hx.A06)) && (A07(479, 22, 69).equals(str) || A07(501, 29, 80).equals(str))) {
                return true;
            }
        }
        return false;
    }
}
