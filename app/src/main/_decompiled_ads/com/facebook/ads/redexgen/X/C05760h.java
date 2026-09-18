package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05760h {
    public static byte[] A00;
    public static String[] A01 = {"88AoqknPZ4rnlocmRSd1iIvU160OI6Up", "Xa", "c0t0ITAkOrWkNbi2AOUUle7x7Lv9c02n", "B7XNNyfmW5R2wceLmJkXAkDES3fZG3Pt", "MUV", "NALjFYAH0tlSEiNw3RaQSfKZY5jyxbRm", "XF7p93xq3OHri6co5HggQunfVTz3vEaG", "n2FdIZz9zx79PfKUryB9rXi8CBHMM9xX"};
    public static final String A02;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{111, 84, 91, 88, 86, 95, 26, 78, 85, 26, 74, 91, 72, 73, 95, 26, 80, 73, 85, 84, 26, 94, 91, 78, 91, 26, 83, 84, 26, 123, 94, 123, 89, 78, 83, 85, 84, 124, 91, 89, 78, 85, 72, 67, 20, 19, 22, 3, 22, 82, 83, 78, 84, 73, 88, 65, 94, 75, SignedBytes.MAX_POWER_OF_TWO, 113, 66, 71, SignedBytes.MAX_POWER_OF_TWO, 69, 98, 115, 96, 97, 123, 124, 117, 27, 10, 24, 24, 31, 3, 25, 4, 30, 12, 3, 39, 32, 59, 38, 49, 40, 47, 52, 41, 62, 4, 46, 41, 55, 4, 44, 62, 57, 4, Base64.padSymbol, 58, 55, 55, 57, 58, 56, 48, 49, 55, 48, 32, 123, 100, 105, 104, 98, 82, 120, 127, 97};
    }

    static {
        A03();
        A02 = C05760h.class.getSimpleName();
    }

    public static AbstractC05750g A00(YA ya, InterfaceC1004If interfaceC1004If, String str, Uri uri, Map<String, String> map, C1R c1r) {
        return A01(ya, interfaceC1004If, str, uri, map, true, false, c1r);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:29:0x00af  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:49:0x0112  */
    /* JADX WARN: Code duplicated, block: B:51:0x012e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0134 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0136  */
    /* JADX WARN: Code duplicated, block: B:56:0x013c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0142  */
    public static AbstractC05750g A01(YA ya, InterfaceC1004If interfaceC1004If, String action, Uri uri, Map<String, String> map, boolean z, boolean z2, C1R c1r) {
        C05810n c05810nA00;
        byte b2;
        if (uri == null || uri.getAuthority() == null) {
            return null;
        }
        String key = uri.getAuthority();
        String queryParameter = uri.getQueryParameter(A02(113, 9, 44));
        String queryParameter2 = uri.getQueryParameter(A02(45, 4, 86));
        if (queryParameter2 != null) {
            boolean zIsEmpty = TextUtils.isEmpty(queryParameter2);
            if (A01[2].charAt(25) != 'L') {
                throw new RuntimeException();
            }
            A01[2] = "ISDJ842CIGTTmPHzT0dMVnvZcLrwzpZ1";
            if (!zIsEmpty) {
                try {
                    JSONObject jSONObject = new JSONObject(queryParameter2);
                    Iterator<String> dataIterator = jSONObject.keys();
                    while (dataIterator.hasNext()) {
                        String next = dataIterator.next();
                        try {
                            map.put(next, jSONObject.getString(next));
                        } catch (JSONException e) {
                            e = e;
                            ya.A07().A9M(A02(64, 7, 51), C07597x.A22, new C07607y(e));
                            Log.w(A02, A02(0, 45, 27), e);
                            c05810nA00 = C05810n.A00(interfaceC1004If, ActivityUtils.A00());
                            switch (key.hashCode()) {
                                case -1458789996:
                                    if (key.equals(A02(71, 11, 74))) {
                                        b2 = -1;
                                    } else {
                                        b2 = 2;
                                    }
                                    break;
                                case 109770977:
                                    if (key.equals(A02(82, 5, 117))) {
                                        b2 = -1;
                                    } else {
                                        b2 = 0;
                                    }
                                    break;
                                case 1546100943:
                                    if (key.equals(A02(55, 9, 15))) {
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
                                    if (queryParameter != null) {
                                        return null;
                                    }
                                    if (z2) {
                                    }
                                    break;
                                case 1:
                                    if (A02(109, 4, 100).equals(uri.getQueryParameter(A02(49, 6, 28)))) {
                                        return new FF(ya, interfaceC1004If, action, uri, map, c05810nA00, z);
                                    }
                                    return z2 ? new FH(ya, interfaceC1004If, action, uri, map) : new FG(ya, interfaceC1004If, action, uri, map, c05810nA00, z);
                                case 2:
                                    return new C1513av(ya, interfaceC1004If, action, uri, map);
                                default:
                                    return new C1512au(ya, interfaceC1004If, action, uri);
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                }
            }
        }
        c05810nA00 = C05810n.A00(interfaceC1004If, ActivityUtils.A00());
        switch (key.hashCode()) {
            case -1458789996:
                if (key.equals(A02(71, 11, 74))) {
                    b2 = -1;
                } else {
                    b2 = 2;
                }
                break;
            case 109770977:
                if (key.equals(A02(82, 5, 117))) {
                    b2 = -1;
                } else {
                    b2 = 0;
                }
                break;
            case 1546100943:
                if (key.equals(A02(55, 9, 15))) {
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
                if (queryParameter != null) {
                    return null;
                }
                return (z2 || TextUtils.isEmpty(uri.getQueryParameter(A02(87, 22, 122)))) ? new FI(ya, interfaceC1004If, action, uri, map, c05810nA00, z, c1r) : new FH(ya, interfaceC1004If, action, uri, map, true);
            case 1:
                if (A02(109, 4, 100).equals(uri.getQueryParameter(A02(49, 6, 28)))) {
                    return new FF(ya, interfaceC1004If, action, uri, map, c05810nA00, z);
                }
                if (z2) {
                }
            case 2:
                return new C1513av(ya, interfaceC1004If, action, uri, map);
            default:
                return new C1512au(ya, interfaceC1004If, action, uri);
        }
    }

    public static boolean A04(String str) {
        return A02(82, 5, 117).equalsIgnoreCase(str) || A02(55, 9, 15).equalsIgnoreCase(str);
    }
}
