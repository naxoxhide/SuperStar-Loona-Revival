package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1033Jk {
    public static C1033Jk A00;
    public static byte[] A01;
    public static String[] A02 = {"Nd0aIJaSSdT6golxDxmvfQ8KGIhkioAs", "ixyRHf3ginhO64aTdthArc1g6ok2H3", "GbO21nRDfLqDtubwMBv4WZcS7UdykcI0", "mXXayHEFxYYogLv80iNIAWV0V8DSaho2", "P31SQSGtrqVfDfZK9ecLZSYzpsOr4NmF", "LoLWC0hqSx9uRqEUKclND68NLRAhrZnk", "BjBhbLG4paZ7rOUqjAFqxmQoWglNay8W", "K86adGKhBwKF7i3Zzr1zFaSNRf7F"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private U6 A01(YA ya, JSONObject jSONObject, long j) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONArray(A04(151, 10, 78)).getJSONObject(0);
        C8G c8gA00 = C8G.A00(jSONObject2.getJSONObject(A04(115, 10, 70)));
        String strOptString = jSONObject2.optString(A04(130, 14, 18));
        String strOptString2 = jSONObject2.optString(A04(0, 19, 98));
        String strA04 = A04(100, 15, 87);
        C8F c8f = new C8F(c8gA00, strOptString, strOptString2, jSONObject2.has(strA04) ? jSONObject2.optString(strA04) : null);
        String strA05 = A04(26, 3, 57);
        if (jSONObject2.has(strA05)) {
            JSONArray jSONArray = jSONObject2.getJSONArray(strA05);
            int i = 0;
            while (true) {
                int length = jSONArray.length();
                String[] strArr = A02;
                if (strArr[5].charAt(22) == strArr[0].charAt(22)) {
                    String[] strArr2 = A02;
                    strArr2[5] = "EVHdYwJmDBIkQbvU6cH0jf8LCXZeDjo6";
                    strArr2[0] = "LqKeHeP2dtVwdsKCNOcbJj8gANtIspsD";
                    if (i >= length) {
                        break;
                    }
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    C1014Ip.A06(ya, jSONObject3, j, null);
                    String strOptString3 = jSONObject3.optString(A04(19, 7, 39));
                    String strOptString4 = jSONObject3.optString(A04(85, 15, 63));
                    JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject(A04(63, 4, 116));
                    JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray(A04(161, 8, 90));
                    if (jSONObjectOptJSONObject != null) {
                        c8f.A0B(new C8D(strOptString3, strOptString4, jSONObjectOptJSONObject, jSONArrayOptJSONArray));
                    } else {
                        ya.A0E().A4p(AdErrorType.UNKNOWN_ERROR.getErrorCode(), A04(67, 18, 82));
                    }
                    i++;
                } else {
                    throw new RuntimeException();
                }
            }
        }
        String strA06 = A04(47, 12, 116);
        if (jSONObject2.has(strA06)) {
            c8f.A0C(jSONObject2.getJSONObject(strA06));
        }
        return new U6(c8f, jSONObject.optString(A04(29, 18, 1)));
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 119);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{116, 113, 74, 103, 112, 101, 122, 103, 97, 124, 123, 114, 74, 118, 122, 123, 115, 124, 114, 49, 52, 49, 32, 36, 53, 34, 47, 42, Base64.padSymbol, 23, 24, 41, 0, 23, 26, 31, 18, 23, 2, 31, 25, 24, 41, 3, 3, 31, 18, 96, 107, 98, 106, 109, 92, 115, 98, 113, 98, 110, 112, 23, 27, 16, 17, 103, 98, 119, 98, 65, 68, 81, 68, 106, 71, 79, SignedBytes.MAX_POWER_OF_TWO, 70, 81, 5, 76, 86, 5, 75, 80, 73, 73, 44, 41, 60, 41, 23, 37, 39, 44, 45, 36, 23, 60, 49, 56, 45, 68, 67, 76, 127, 84, 69, 83, 84, 127, 67, 79, 78, 70, 73, 71, 85, 84, 87, 88, 95, 88, 69, 88, 94, 95, 74, 93, 93, SignedBytes.MAX_POWER_OF_TWO, 93, 3, 0, 4, 17, 16, 23, 0, 58, 6, 10, 11, 3, 12, 2, 15, 7, 17, 17, 3, 5, 7, 73, 85, 88, 90, 92, 84, 92, 87, 77, 74, 89, 95, 76, 78, 70, 72, 95, 94, 69, 72, 65, 84};
    }

    static {
        A05();
        A00 = new C1033Jk();
    }

    public static synchronized C1033Jk A00() {
        return A00;
    }

    private U5 A02(JSONObject jSONObject) {
        return new U5(jSONObject.optString(A04(144, 7, 21), A04(0, 0, 87)), jSONObject.optInt(A04(59, 4, 3), 0), null);
    }

    private U5 A03(JSONObject jSONObject) {
        try {
            JSONArray placements = jSONObject.getJSONArray(A04(151, 10, 78));
            JSONObject definition = placements.getJSONObject(0);
            C8G c8gA00 = C8G.A00(definition.getJSONObject(A04(115, 10, 70)));
            String featureConfig = definition.optString(A04(130, 14, 18));
            return new U5(jSONObject.optString(A04(144, 7, 21), A04(0, 0, 87)), jSONObject.optInt(A04(59, 4, 3), 0), new C8F(c8gA00, featureConfig, definition.optString(A04(0, 19, 98)), null));
        } catch (JSONException unused) {
            return A02(jSONObject);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x0028  */
    public final C1035Jm A06(YA ya, String str, long j) throws JSONException {
        byte b2;
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(A04(169, 4, 70));
            int iHashCode = strOptString.hashCode();
            String strA04 = A04(125, 5, 88);
            switch (iHashCode) {
                case 96432:
                    if (!strOptString.equals(A04(26, 3, 57))) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case 96784904:
                    if (!strOptString.equals(strA04)) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    return A01(ya, jSONObject, j);
                case 1:
                    return A03(jSONObject);
                default:
                    JSONObject jsonResponse = jSONObject.optJSONObject(strA04);
                    if (jsonResponse != null) {
                        return A02(jsonResponse);
                    }
                    break;
            }
        }
        return new C1035Jm(EnumC1034Jl.A04);
    }
}
