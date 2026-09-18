package com.facebook.ads.redexgen.X;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.io.encoding.Base64;
import kotlin.text.Typography;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class G9 {
    public static byte[] A01;
    public static String[] A02 = {"JYYG6mQudNNGYNEgDR02nAMcKzDjIK4P", "2FeNcZ4AMvklOu4dQ", "gTW6toOfk8MVsyPSs", "RutE2HgswW2Ba8ERBuDpKSxIcN55U9", "rp2dSjsGIei", "VbvhM5GUqSDZ5Gwz8nmiFAQ41xb0JLlL", "3r4p5hSJjLrlxa79edZPjpayqJig4NbN", "nYAJe"};
    public static final Pattern A03;
    public static final Pattern A04;
    public final StringBuilder A00 = new StringBuilder();

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{39, 124, 71, 101, 17, 30, 102, 114, 100, 119, 101, 17, 30, 102, 100, 100, 94, 66, 56, 31, 7, 16, 29, 24, 21, 81, 16, 29, 24, 22, 31, 28, 20, 31, 5, 81, 7, 16, 29, 4, 20, 75, 81, 25, 62, 38, 49, 60, 57, 52, 112, 49, 62, 51, 56, 63, 34, 112, 38, 49, 60, 37, 53, 106, 112, 81, 105, 107, 114, 114, 107, 108, 101, 34, 96, 99, 102, 34, 97, 119, 103, 34, 113, 103, 118, 118, 107, 108, 101, 56, 34, 105, 81, 83, 74, 74, 83, 84, 93, 26, 89, 79, 95, 26, 77, 83, 78, 82, 26, 88, 91, 94, 26, 82, 95, 91, 94, 95, 72, 0, 26, 15, 52, 49, 52, 53, 45, 52, 122, 57, 47, 63, 122, 41, 63, 46, 46, 51, 52, Base64.padSymbol, 122, 21, 39, 32, 52, 54, 54, 1, 55, 39, 18, 35, 48, 49, 39, 48, 58, 65, Base64.padSymbol, 79, 60, 88, 46, 90, 85, 45, 47, 90, 117, 45, 43, 43, 56, 90, 117, 45, 46, 90, 85, 45, 47, 46, 40, 44, 47, 57, 34, 106, 103, 98, 108, 101, 48, 60, 33, 109, 36, 76, 74, 65, 91, 74, 93, 24, 19, 25, 20, 7, 66, 99, 109, 100, 101, 120, 99, 100, 109, 42, 127, 100, 121, 127, 122, 122, 101, 120, 126, 111, 110, 42, 111, 100, 126, 99, 126, 115, 48, 42, 45, 44, 53, 56, 55, 62, 9, 0, 3, 17, 114, 119, 112, 123, 84, 76, 24, 28, 17, 17, 25, 16, 87, 91, 74, 73, 79, 80, 76, 86, 75, 86, 80, 81, 34, 57, 55, 56, 36, 58, 32, 51, 44, 29, 26, 15, 28, 26, 111, 74};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A0C(String str, String str2, G6 g6, List<G4> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int iA01 = 0;
        while (iA01 < str2.length()) {
            char cCharAt = str2.charAt(iA01);
            switch (cCharAt) {
                case '&':
                    int iIndexOf = str2.indexOf(59, iA01 + 1);
                    int iIndexOf2 = str2.indexOf(32, iA01 + 1);
                    if (iIndexOf == -1) {
                        iIndexOf = iIndexOf2;
                    } else if (iIndexOf2 != -1) {
                        iIndexOf = Math.min(iIndexOf, iIndexOf2);
                    }
                    if (iIndexOf == -1) {
                        spannableStringBuilder.append(cCharAt);
                        iA01++;
                    } else {
                        A07(str2.substring(iA01 + 1, iIndexOf), spannableStringBuilder);
                        if (iIndexOf == iIndexOf2) {
                            spannableStringBuilder.append((CharSequence) A03(1, 1, 17));
                        }
                        iA01 = iIndexOf + 1;
                    }
                    break;
                case '<':
                    if (iA01 + 1 < str2.length()) {
                        int i = iA01;
                        boolean z = str2.charAt(i + 1) == '/';
                        iA01 = A01(str2, i + 1);
                        boolean z2 = str2.charAt(iA01 + (-2)) == '/';
                        String strSubstring = str2.substring((z ? 2 : 1) + i, z2 ? iA01 - 2 : iA01 - 1);
                        String strA04 = A04(strSubstring);
                        if (strA04 != null && A0E(strA04)) {
                            if (z) {
                                while (!arrayDeque.isEmpty()) {
                                    G7 g7 = (G7) arrayDeque.pop();
                                    A0B(str, g7, spannableStringBuilder, list, arrayList);
                                    if (g7.A01.equals(strA04)) {
                                    }
                                    break;
                                }
                            } else if (!z2) {
                                arrayDeque.push(G7.A01(strSubstring, spannableStringBuilder.length()));
                            }
                        }
                    } else {
                        iA01++;
                    }
                    break;
                default:
                    spannableStringBuilder.append(cCharAt);
                    if (A02[6].charAt(12) == 'U') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A02;
                    strArr[0] = "1EgemSjEd6OX6IjZrpNfGkrOscE7SpVJ";
                    strArr[5] = "BPkE8PNmcvUgQGAm1QCgLjutlWPlJ3J2";
                    iA01++;
                    break;
                    break;
            }
        }
        while (!arrayDeque.isEmpty()) {
            A0B(str, (G7) arrayDeque.pop(), spannableStringBuilder, list, arrayList);
        }
        A0B(str, G7.A00(), spannableStringBuilder, list, arrayList);
        g6.A0C(spannableStringBuilder);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 15
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final boolean A0G(C0980Hh c0980Hh, G6 g6, List<G4> list) {
        String strA0P = c0980Hh.A0P();
        if (strA0P == null) {
            return false;
        }
        Pattern pattern = A03;
        Matcher matcher = pattern.matcher(strA0P);
        if (matcher.matches()) {
            return A0F(null, matcher, c0980Hh, g6, this.A00, list);
        }
        String strA0P2 = c0980Hh.A0P();
        if (strA0P2 == null) {
            return false;
        }
        Matcher matcher2 = pattern.matcher(strA0P2);
        if (matcher2.matches()) {
            return A0F(strA0P.trim(), matcher2, c0980Hh, g6, this.A00, list);
        }
        return false;
    }

    static {
        A05();
        A03 = Pattern.compile(A03(161, 26, 75));
        A04 = Pattern.compile(A03(3, 12, 0));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x005b  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    /* JADX WARN: Code duplicated, block: B:6:0x000e  */
    public static int A00(String str) {
        byte b2;
        switch (str.hashCode()) {
            case -1364013995:
                boolean zEquals = str.equals(A03(197, 6, 98));
                if (A02[7].length() != 5) {
                    A02[4] = "DMfdGkOFUxynodxW9z1tlml8oHZW88";
                    if (zEquals) {
                        b2 = 1;
                    } else {
                        b2 = -1;
                    }
                } else {
                    String[] strArr = A02;
                    strArr[2] = "ZWUMzT4FbwhCC9zvg";
                    strArr[1] = "lQdDUKdfIZs4MkB9q";
                    if (zEquals) {
                        b2 = 1;
                    } else {
                        b2 = -1;
                    }
                }
                switch (b2) {
                    case 0:
                        return 0;
                    case 1:
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    default:
                        Log.w(A03(141, 15, 15), A03(43, 22, 29) + str);
                        return Integer.MIN_VALUE;
                }
            case -1074341483:
                if (str.equals(A03(254, 6, 56))) {
                    b2 = 2;
                } else {
                    b2 = -1;
                }
                switch (b2) {
                    case 0:
                        return 0;
                    case 1:
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    default:
                        Log.w(A03(141, 15, 15), A03(43, 22, 29) + str);
                        return Integer.MIN_VALUE;
                }
            case 100571:
                if (A02[6].charAt(12) == 'U') {
                    throw new RuntimeException();
                }
                A02[4] = "1rUDZc1zpmKXAlK5wqzuXN7L1n8yuk";
                if (str.equals(A03(203, 3, 48))) {
                    b2 = 3;
                } else {
                    b2 = -1;
                }
                switch (b2) {
                    case 0:
                        return 0;
                    case 1:
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    default:
                        Log.w(A03(141, 15, 15), A03(43, 22, 29) + str);
                        return Integer.MIN_VALUE;
                }
            case 109757538:
                if (str.equals(A03(281, 5, 35))) {
                    b2 = 0;
                } else {
                    b2 = -1;
                }
                switch (b2) {
                    case 0:
                        return 0;
                    case 1:
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    default:
                        Log.w(A03(141, 15, 15), A03(43, 22, 29) + str);
                        return Integer.MIN_VALUE;
                }
            default:
                b2 = -1;
                switch (b2) {
                    case 0:
                        return 0;
                    case 1:
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    default:
                        Log.w(A03(141, 15, 15), A03(43, 22, 29) + str);
                        return Integer.MIN_VALUE;
                }
        }
    }

    public static int A01(String str, int i) {
        int iIndexOf = str.indexOf(62, i);
        if (iIndexOf == -1) {
            int index = str.length();
            return index;
        }
        int index2 = iIndexOf + 1;
        return index2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    public static Layout.Alignment A02(String str) {
        byte b2;
        switch (str.hashCode()) {
            case -1364013995:
                if (!str.equals(A03(197, 6, 98))) {
                    b2 = -1;
                } else {
                    b2 = 2;
                }
                break;
            case -1074341483:
                if (!str.equals(A03(254, 6, 56))) {
                    b2 = -1;
                } else {
                    b2 = 3;
                }
                break;
            case 100571:
                if (!str.equals(A03(203, 3, 48))) {
                    b2 = -1;
                } else {
                    b2 = 4;
                }
                break;
            case 3317767:
                if (!str.equals(A03(244, 4, 40))) {
                    b2 = -1;
                } else {
                    b2 = 1;
                }
                break;
            case 108511772:
                if (!str.equals(A03(272, 5, 29))) {
                    b2 = -1;
                } else {
                    b2 = 5;
                }
                break;
            case 109757538:
                if (!str.equals(A03(281, 5, 35))) {
                    b2 = -1;
                } else {
                    b2 = 0;
                }
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
            case 1:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 3:
                return Layout.Alignment.ALIGN_CENTER;
            case 4:
            case 5:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                Log.w(A03(141, 15, 15), A03(18, 25, 60) + str);
                return null;
        }
    }

    public static String A04(String str) {
        String strTrim = str.trim();
        if (!strTrim.isEmpty()) {
            return C0996Hx.A0m(strTrim, A03(156, 5, 44))[0];
        }
        if (A02[4].length() == 19) {
            throw new RuntimeException();
        }
        A02[3] = "n2qP40ip31gyFkT4bwxWbWgEBn8x5R";
        return null;
    }

    public static void A06(SpannableStringBuilder spannableStringBuilder, G4 g4, int i, int i2) {
        if (g4 == null) {
            return;
        }
        if (g4.A08() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(g4.A08()), i, i2, 33);
        }
        if (g4.A0O()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (g4.A0P()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (g4.A0N()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(g4.A06()), i, i2, 33);
        }
        if (g4.A0M()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(g4.A05()), i, i2, 33);
        }
        String strA0H = g4.A0H();
        if (A02[6].charAt(12) == 'U') {
            throw new RuntimeException();
        }
        A02[6] = "tzfwj6Yb5L7snAfsv0bj9UNvpNFUfxvv";
        if (strA0H != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(g4.A0H()), i, i2, 33);
        }
        if (g4.A0A() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(g4.A0A()), i, i2, 33);
        }
        switch (g4.A07()) {
            case 1:
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) g4.A04(), true), i, i2, 33);
                return;
            case 2:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(g4.A04()), i, i2, 33);
                return;
            case 3:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(g4.A04() / 100.0f), i, i2, 33);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    public static void A07(String str, SpannableStringBuilder spannableStringBuilder) {
        byte b2;
        switch (str.hashCode()) {
            case 3309:
                if (!str.equals(A03(206, 2, 62))) {
                    b2 = -1;
                } else {
                    b2 = 1;
                }
                break;
            case 3464:
                if (!str.equals(A03(252, 2, 117))) {
                    b2 = -1;
                } else {
                    b2 = 0;
                }
                break;
            case 96708:
                if (!str.equals(A03(192, 3, 28))) {
                    b2 = -1;
                } else {
                    b2 = 3;
                }
                break;
            case 3374865:
                if (!str.equals(A03(260, 4, 116))) {
                    b2 = -1;
                } else {
                    b2 = 2;
                }
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                spannableStringBuilder.append(Typography.less);
                return;
            case 1:
                spannableStringBuilder.append(Typography.greater);
                return;
            case 2:
                spannableStringBuilder.append(' ');
                return;
            case 3:
                if (A02[7].length() != 5) {
                    throw new RuntimeException();
                }
                A02[7] = "j55CB";
                spannableStringBuilder.append(Typography.amp);
                return;
            default:
                Log.w(A03(141, 15, 15), A03(209, 31, 71) + str + A03(16, 2, 40));
                return;
        }
    }

    public static void A08(String str, G6 g6) {
        String strA03 = A03(141, 15, 15);
        Matcher matcher = A04.matcher(str);
        while (true) {
            boolean zFind = matcher.find();
            if (A02[7].length() != 5) {
                throw new RuntimeException();
            }
            A02[7] = "ISZNO";
            if (zFind) {
                String strGroup = matcher.group(1);
                String strGroup2 = matcher.group(2);
                try {
                    if (A03(248, 4, 83).equals(strGroup)) {
                        A09(strGroup2, g6);
                    } else if (A03(187, 5, 70).equals(strGroup)) {
                        g6.A0B(A02(strGroup2));
                    } else if (A03(264, 8, 114).equals(strGroup)) {
                        A0A(strGroup2, g6);
                    } else if (A03(277, 4, 4).equals(strGroup)) {
                        g6.A05(GA.A00(strGroup2));
                    } else {
                        Log.w(strA03, A03(121, 20, 23) + strGroup + A03(15, 1, 19) + strGroup2);
                    }
                } catch (NumberFormatException unused) {
                    Log.w(strA03, A03(65, 26, 79) + matcher.group());
                }
            } else {
                return;
            }
        }
    }

    public static void A09(String str, G6 g6) throws NumberFormatException {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            g6.A06(A00(str.substring(iIndexOf + 1)));
            str = str.substring(0, iIndexOf);
        } else {
            g6.A06(Integer.MIN_VALUE);
        }
        if (str.endsWith(A03(2, 1, 47))) {
            g6.A03(GA.A00(str)).A07(0);
            return;
        }
        int commaIndex = Integer.parseInt(str);
        if (commaIndex < 0) {
            commaIndex--;
        }
        g6.A03(commaIndex).A07(1);
    }

    public static void A0A(String str, G6 g6) throws NumberFormatException {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            int commaIndex = iIndexOf + 1;
            g6.A08(A00(str.substring(commaIndex)));
            str = str.substring(0, iIndexOf);
        } else {
            g6.A08(Integer.MIN_VALUE);
        }
        g6.A04(GA.A00(str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0011  */
    public static void A0B(String str, G7 g7, SpannableStringBuilder spannableStringBuilder, List<G4> list, List<G8> list2) {
        byte b2;
        int i = g7.A00;
        int i2 = spannableStringBuilder.length();
        String str2 = g7.A01;
        int start = str2.hashCode();
        switch (start) {
            case 0:
                if (str2.equals(A03(0, 0, 94))) {
                    b2 = 6;
                } else {
                    b2 = -1;
                }
                break;
            case 98:
                if (str2.equals(A03(195, 1, 66))) {
                    b2 = 0;
                } else {
                    b2 = -1;
                }
                break;
            case 99:
                if (str2.equals(A03(196, 1, 10))) {
                    b2 = 3;
                } else {
                    b2 = -1;
                }
                break;
            case 105:
                if (str2.equals(A03(208, 1, 102))) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
                break;
            case 117:
                if (str2.equals(A03(286, 1, 87))) {
                    b2 = 2;
                } else {
                    b2 = -1;
                }
                break;
            case 118:
                if (str2.equals(A03(287, 1, 113))) {
                    b2 = 5;
                } else {
                    b2 = -1;
                }
                break;
            case 3314158:
                if (str2.equals(A03(240, 4, 20))) {
                    b2 = 4;
                } else {
                    b2 = -1;
                }
                break;
            default:
                b2 = -1;
                break;
        }
        String[] strArr = A02;
        String str3 = strArr[2];
        String str4 = strArr[1];
        int end = str3.length();
        int start2 = str4.length();
        if (end != start2) {
            throw new RuntimeException();
        }
        A02[4] = "fbk5bLqQNEDh8uMBzoI0ZNvOUZBwB";
        switch (b2) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, i2, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
                break;
            case 2:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                return;
        }
        list2.clear();
        A0D(list, str, g7, list2);
        int styleMatchesCount = list2.size();
        for (int end2 = 0; end2 < styleMatchesCount; end2++) {
            A06(spannableStringBuilder, list2.get(end2).A01, i, i2);
        }
    }

    public static void A0D(List<G4> list, String str, G7 g7, List<G8> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            G4 g4 = list.get(i);
            String str2 = g7.A01;
            String[] strArr = g7.A03;
            String str3 = g7.A02;
            if (A02[3].length() == 7) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[0] = "AMyBO4NnCnMpgJ1A04yWFmVBrU3uxkkG";
            strArr2[5] = "4pWDMPx0mcGHcptb8cUlFxOOK6mkNbT4";
            int i2 = g4.A09(str, str2, strArr, str3);
            if (i2 > 0) {
                list2.add(new G8(i2, g4));
            }
        }
        Collections.sort(list2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0009  */
    public static boolean A0E(String str) {
        byte b2;
        switch (str.hashCode()) {
            case 98:
                if (!str.equals(A03(195, 1, 66))) {
                    b2 = -1;
                } else {
                    b2 = 0;
                }
                break;
            case 99:
                if (!str.equals(A03(196, 1, 10))) {
                    b2 = -1;
                } else {
                    b2 = 1;
                }
                break;
            case 105:
                if (!str.equals(A03(208, 1, 102))) {
                    b2 = -1;
                } else {
                    b2 = 2;
                }
                break;
            case 117:
                if (!str.equals(A03(286, 1, 87))) {
                    b2 = -1;
                } else {
                    b2 = 4;
                }
                break;
            case 118:
                if (!str.equals(A03(287, 1, 113))) {
                    b2 = -1;
                } else {
                    b2 = 5;
                }
                break;
            case 3314158:
                if (!str.equals(A03(240, 4, 20))) {
                    b2 = -1;
                } else {
                    b2 = 3;
                }
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    public static boolean A0F(String str, Matcher matcher, C0980Hh c0980Hh, G6 g6, StringBuilder sb, List<G4> list) {
        try {
            g6.A0A(GA.A01(matcher.group(1))).A09(GA.A01(matcher.group(2)));
            A08(matcher.group(3), g6);
            sb.setLength(0);
            while (true) {
                String strA0P = c0980Hh.A0P();
                if (!TextUtils.isEmpty(strA0P)) {
                    if (sb.length() > 0) {
                        sb.append(A03(0, 1, 96));
                    }
                    sb.append(strA0P.trim());
                } else {
                    A0C(str, sb.toString(), g6, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(A03(141, 15, 15), A03(91, 30, 119) + matcher.group());
            return false;
        }
    }
}
