package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0958Gl implements R6 {
    public static byte[] A05;
    public static String[] A06 = {"yJwczGSbba5UrkwzZOW60Je1LUoZxQIl", "oZp", "SLRT1bjVboXCxkvYGWPu27FVIHxKKecJ", "WHpvXVjPup", "", "gRWAa43vtpEz38T6Kt4HiTmitjJp6SmI", "", "QpBNbg2dQWhW"};
    public JSONObject A00;
    public JSONObject A01;
    public final R7 A03;
    public final List<R8> A04 = new ArrayList();
    public boolean A02 = false;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 27);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        if (A06[7].length() != 12) {
            throw new RuntimeException();
        }
        A06[3] = "GbTE4j9vTw";
        A05 = new byte[]{58, 13, 22, 28, 20, 29, 88, 93, 11, 88, 28, 25, 12, 25, 88, 13, 8, 28, 25, 12, 29, 66, 114, 82, 82, 88, 28, 25, 12, 25, 88, 82, 82, 114, 93, 11, 114, 82, 82, 88, 30, 17, 22, 31, 29, 10, 8, 10, 17, 22, 12, 88, 82, 82, 114, 93, 11, 89, 110, 117, 127, 119, 126, 59, 115, 122, 104, 59, 117, 116, 59, 125, 114, 117, 124, 126, 105, 107, 105, 114, 117, 111, 32, 23, 12, 6, 14, 7, 66, 11, 17, 66, 12, 13, 22, 66, 16, 7, 3, 6, 27, 43, 46, 59, 46, 111, 114, 114, 111, 33, 58, 35, 35, 107, 100, 99, 106, 104, 127, 125, 127, 100, 99, 121, 45, 44, 48, 45, 99, 120, 97, 97, 125, 114, 117, 124, 126, 105, 107, 105, 114, 117, 111, 59, 38, 38, 59, 117, 110, 119, 119, 77, 86, 79, 79};
    }

    static {
        A03();
    }

    public C0958Gl(R7 r7) {
        this.A03 = r7;
    }

    private boolean A04(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return false;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return true;
        }
        boolean zA02 = R5.A02(jSONObject, jSONObject2);
        String[] strArr = A06;
        if (strArr[0].charAt(8) != strArr[2].charAt(8)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[4] = "";
        strArr2[6] = "";
        return true ^ zA02;
    }

    public final synchronized boolean A05(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (jSONObject != null) {
                if (jSONObject2 == null && this.A03.A04()) {
                    throw new IllegalArgumentException(A02(132, 19, 0));
                }
                if (jSONObject2 == null || this.A03.A04()) {
                    if (!A04(this.A01, jSONObject2) && !A04(this.A00, jSONObject)) {
                        return false;
                    }
                    this.A00 = jSONObject;
                    this.A01 = jSONObject2;
                    this.A02 = true;
                    Iterator<R8> it = this.A04.iterator();
                    while (it.hasNext()) {
                        it.next().A41();
                    }
                    try {
                        Locale locale = Locale.US;
                        String strA02 = A02(0, 57, 99);
                        Object[] objArr = new Object[3];
                        objArr[0] = this.A03;
                        JSONObject jSONObject3 = this.A00;
                        objArr[1] = jSONObject3 == null ? A02(151, 4, 56) : jSONObject3.toString(2);
                        JSONObject jSONObject4 = this.A01;
                        objArr[2] = jSONObject4 == null ? A02(151, 4, 56) : jSONObject4.toString(2);
                        String.format(locale, strA02, objArr);
                    } catch (JSONException unused) {
                    }
                    return true;
                }
                throw new IllegalArgumentException(A02(113, 19, 22));
            }
            throw new IllegalArgumentException(A02(101, 12, 84));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.R6
    public final synchronized void A3N(R8 r8) {
        this.A04.add(r8);
    }

    @Override // com.facebook.ads.redexgen.X.R6
    public final synchronized JSONObject A6b() {
        JSONObject jSONObject;
        jSONObject = this.A00;
        if (jSONObject == null) {
            throw new IllegalStateException(A02(82, 19, 121));
        }
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.R6
    public final synchronized JSONObject A6y() {
        JSONObject jSONObject;
        if (this.A03.A04()) {
            jSONObject = this.A01;
            if (jSONObject == null) {
                throw new IllegalStateException(A02(82, 19, 121));
            }
        } else {
            throw new IllegalStateException(A02(57, 25, 0));
        }
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.R6
    public final R7 A73() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.R6
    public final synchronized boolean A90() {
        return this.A02;
    }
}
