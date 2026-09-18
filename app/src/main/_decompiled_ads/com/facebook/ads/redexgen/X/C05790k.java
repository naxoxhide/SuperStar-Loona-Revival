package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05790k {
    public static byte[] A00;
    public static String[] A01 = {"4Fi3cRKjKwjo", "pfwDmZC0EgnSHGG3akphHDiSxRpjxWfc", "OwKyFlCBYoW0NHpoiuFf2exuC", "FTixXnraWBf7yQ9sseM6khJqknPB2", "87lno6sBf8EnLpq9v2WrftgOrdI4V", "hcLSbPhFObKmfxN2jEGb0Jf71EM4", "MV7VLhl", "AE1L1nhQpeYYJvXkfFkincgpQRIdvuit"};

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{101, SignedBytes.MAX_POWER_OF_TWO, 4, 77, 87, 4, 77, 74, 82, 69, 72, 77, SignedBytes.MAX_POWER_OF_TWO, 69, 80, 65, SignedBytes.MAX_POWER_OF_TWO, 4, 83, 77, 80, 76, 75, 81, 80, 4, 80, 75, 79, 65, 74, 10, 10, 27, 2, 39, 38, 55, 38, 32, 55, 42, 44, 45, 28, 48, 55, 49, 42, 45, 36, 48, 35, 36, 60, 43, 38, 35, 46, 43, 62, 35, 37, 36, 21, 40, 47, 34, 43, 60, 35, 37, 56, 98, 115, 96, 97, 123, 124, 117};
    }

    static {
        A05();
    }

    public static EnumC05770i A00(JSONObject jSONObject) {
        return EnumC05770i.A00(jSONObject.optString(A02(52, 21, 114)));
    }

    public static C1515ax A01(YA ya, JSONObject jSONObject, String str) {
        return new C1515ax(jSONObject, ya, str);
    }

    public static Collection<String> A03(YA ya, JSONObject jSONObject) {
        JSONArray jSONArray = null;
        try {
            String detectionStringJSON = jSONObject.optString(A02(35, 17, 123));
            if (!TextUtils.isEmpty(detectionStringJSON)) {
                JSONArray detectionStringsArray = new JSONArray(detectionStringJSON);
                jSONArray = detectionStringsArray;
            }
        } catch (JSONException e) {
            ya.A07().A9M(A02(73, 7, 42), C07597x.A2B, new C07607y(e));
        }
        return A04(jSONArray);
    }

    public static Collection<String> A04(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.optString(i));
        }
        return hashSet;
    }

    public static boolean A06(YA ya, InterfaceC05780j interfaceC05780j, InterfaceC1004If interfaceC1004If) {
        EnumC05770i enumC05770iA77 = interfaceC05780j.A77();
        if (enumC05770iA77 != null) {
            EnumC05770i invalidationBehavior = EnumC05770i.A03;
            if (enumC05770iA77 != invalidationBehavior) {
                boolean packageInstalled = false;
                Collection<String> collectionA6g = interfaceC05780j.A6g();
                if (collectionA6g == null || collectionA6g.isEmpty()) {
                    return false;
                }
                Iterator<String> it = collectionA6g.iterator();
                while (it.hasNext()) {
                    if (L3.A04(ya, it.next())) {
                        packageInstalled = true;
                        break;
                    }
                }
                EnumC05770i invalidationBehavior2 = EnumC05770i.A02;
                if (packageInstalled != (enumC05770iA77 == invalidationBehavior2)) {
                    return false;
                }
                String strA6N = interfaceC05780j.A6N();
                boolean zIsEmpty = TextUtils.isEmpty(strA6N);
                String[] strArr = A01;
                String clientToken = strArr[7];
                if (clientToken.charAt(25) != strArr[1].charAt(25)) {
                    throw new RuntimeException();
                }
                A01[2] = "Y0XUyINdugWnNFuKX72emGLWk";
                if (!zIsEmpty) {
                    interfaceC1004If.A9T(strA6N, null);
                    return true;
                }
                ya.A07().A9M(A02(32, 3, 83), C07597x.A0Z, new C07607y(A02(0, 32, 28)));
                return true;
            }
        }
        return false;
    }
}
