package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ok, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1160Ok {
    public static byte[] A00;
    public static String[] A01 = {"CXRchRuqobcH0303RF", "0PvsG2xJSmQLgGTcWH9EYe7sEgRs7pRt", "Ep2muPcKb5OPprn584rkOKVS7ZwPor7u", "ESdTFl6hgzo0PrNou", "ifIc3126Iu24LMQAqXU9MKX3mrrg1qWL", "gYyPZy3RrUjZ7", "cRp6DEQTFSLuVCLvwOm8", "Iag0U1Rq9Q0ZydVPffrz8fjunI2ky4CH"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 22 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static WebResourceResponse A00(YA ya, WebResourceRequest webResourceRequest, Uri uri, String str, HashMap<String, String> map) throws IOException {
        String strA02;
        String strA03 = A02(85, 5, 49);
        C1330Uz c1330UzA0F = QN.A05(ya.A01()).A0F(ya);
        C6Q.A0H(ya, uri.toString());
        try {
            C1161Ol c1161Ol = new C1161Ol(ya.A01(), uri, c1330UzA0F);
            int iAvailable = c1161Ol.available();
            if (iAvailable <= 0) {
                A05(ya, 1, new Pair[]{new Pair(A02(61, 9, 77), String.valueOf(iAvailable))});
                return null;
            }
            String strA04 = A03(webResourceRequest.getRequestHeaders());
            if (strA04 == null) {
                ya.A0E().A5J();
                A06(map, iAvailable);
                return new WebResourceResponse(str, null, 200, A02(44, 2, 15), map, c1161Ol);
            }
            try {
                C1159Oj c1159OjA01 = A01(strA04);
                if (c1159OjA01.A03) {
                    int i = c1159OjA01.A01;
                    int i2 = c1159OjA01.A00 == -1 ? iAvailable - 1 : c1159OjA01.A00;
                    A06(map, iAvailable);
                    map.put(A02(31, 13, 81), A02(75, 6, 17) + i + A02(1, 1, 52) + i2 + A02(2, 1, 110) + iAvailable);
                    ya.A0E().A5J();
                    return new WebResourceResponse(str, null, 206, A02(46, 15, 36), map, c1161Ol);
                }
                Pair[] pairArr = new Pair[1];
                if (c1159OjA01.A02 != null) {
                    strA02 = c1159OjA01.A02;
                } else {
                    if (A01[2].charAt(11) != 'P') {
                        throw new RuntimeException();
                    }
                    A01[0] = "OMRpqA07uUbGIz9l3e";
                    strA02 = A02(90, 4, 76);
                }
                pairArr[0] = new Pair(A02(94, 5, 44), strA02);
                A05(ya, 0, pairArr);
                return null;
            } catch (NumberFormatException e) {
                A05(ya, 3, new Pair[]{new Pair(strA03, e.toString())});
                return null;
            }
        } catch (IOException e2) {
            A05(ya, 2, new Pair[]{new Pair(strA03, e2.toString())});
            return null;
        }
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-119, -68, -8, -14, -50, -16, -16, -14, -3, 1, -70, -33, -18, -5, -12, -14, 0, -46, -2, -3, 3, -12, -3, 3, -68, -37, -12, -3, -10, 3, -9, -17, 27, 26, 32, 17, 26, 32, -39, -2, 13, 26, 19, 17, -71, -75, -49, -32, -15, -13, -24, -32, -21, -97, -62, -18, -19, -13, -28, -19, -13, 9, 30, 9, 17, 20, 9, 10, 20, 13, -7, 16, 11, -4, 10, -50, -27, -32, -47, -33, -116, 4, 16, 5, 6, -15, -2, -2, -5, -2, 21, 28, 19, 19, -7, -24, -11, -18, -20};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A05(YA ya, int i, Pair<String, String>[] pairArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A02(81, 4, 70), i);
            for (Pair<String, String> pair : pairArr) {
                jSONObject.put((String) pair.first, pair.second);
            }
        } catch (JSONException unused) {
        }
        ya.A0E().A5I(jSONObject.toString());
    }

    static {
        A04();
    }

    public static C1159Oj A01(String str) {
        if (str == null) {
            C1159Oj parseResult = new C1159Oj();
            parseResult.A03 = false;
            parseResult.A02 = null;
            return parseResult;
        }
        String[] strArrSplit = str.split(A02(3, 1, 90));
        if (strArrSplit.length >= 2) {
            if (A02(70, 5, 60).equals(strArrSplit[0].toLowerCase(Locale.US).trim())) {
                if (strArrSplit[1].trim().split(A02(0, 1, 2)).length != 1) {
                    C1159Oj c1159Oj = new C1159Oj();
                    c1159Oj.A03 = false;
                    c1159Oj.A02 = str;
                    return c1159Oj;
                }
                String[] ranges = strArrSplit[1].trim().split(A02(1, 1, 52));
                C1159Oj c1159Oj2 = new C1159Oj();
                c1159Oj2.A03 = true;
                c1159Oj2.A02 = str;
                c1159Oj2.A01 = TextUtils.isEmpty(ranges[0]) ? 0 : Integer.parseInt(ranges[0]);
                if (ranges.length > 1) {
                    c1159Oj2.A00 = TextUtils.isEmpty(ranges[1]) ? -1 : Integer.parseInt(ranges[1]);
                } else {
                    c1159Oj2.A00 = -1;
                }
                return c1159Oj2;
            }
        }
        C1159Oj c1159Oj3 = new C1159Oj();
        c1159Oj3.A03 = false;
        c1159Oj3.A02 = str;
        return c1159Oj3;
    }

    public static String A03(Map<String, String> map) {
        for (String str : map.keySet()) {
            if (A02(94, 5, 44).equals(str.toLowerCase(Locale.US))) {
                return map.get(str);
            }
        }
        return null;
    }

    public static void A06(HashMap<String, String> map, int i) {
        map.put(A02(4, 13, 50), A02(70, 5, 60));
        map.put(A02(17, 14, 52), String.valueOf(i));
    }
}
