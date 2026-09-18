package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.google.common.primitives.SignedBytes;
import dalvik.system.InMemoryDexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.encoding.Base64;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C06131t {
    public static byte[] A00;
    public static final AtomicBoolean A01;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 36);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{69, 24, 2, 12, 5, 124, 103, 38, 32, 124, 5, 99, 18, 120, 7, 30, 57, 10, 30, Base64.padSymbol, 37, 16, 33, 25, 42, 5, 125, 38, 123, 50, 57, 29, 35, 5, 37, 59, 5, 123, 31, 127, 10, 5, 38, 127, 25, 103, 43, 13, 117, 127, 104, 116, 113, 121, 72, 111, 119, 96, 109, 104, 101, 33, 98, 100, 115, 117, 59, 33, 18, 53, 45, 58, 55, 50, 63, 123, 40, 50, 60, 53, 52, 48, 48, 59, 48, 19, 56, 55, 59, 30, 18, 8, 17, 18, 16, 62, SignedBytes.MAX_POWER_OF_TWO, 14, 73, 59, 56, 40, 60, 63, 56, 56, 54, 58, 56, 40, 65, 56, 52, 48, 48, 59, 58, 30, 50, 58, 56, 40, 60, 56, 10, 33, 19, 72, 35, SignedBytes.MAX_POWER_OF_TWO, 49, Base64.padSymbol, 54, 3, 13, 10, 43, 16, 20, 33, 55, 43, 63, 17, 115, 63, 50, 29, 27, 76, 78, 9, 33, 50, 11, 76, 55, 23, 42, 49, 3, 11, 44, 45, 19, 0, 20, 63, 27, 72, 55, 47, 20, 13, 27, 29, 28, 60, 20, 76, 55, 22, 43, 72, 22, 17, 9, 40, 32, 51, 18, 73, 41, 50, 53, 15, 17, 8, 56, 1, 28, 28, 28, 86, 27, 82, 10, 58, 22, 115, 79, 19, 55, 17, 56, 56, 47, 1, 86, 56, 43, 41, 65, 40, 20, 29, 29, 27, 9, 46, 31, 51, 56, 26, 20, 60, 47, 40, SignedBytes.MAX_POWER_OF_TWO, 19, SignedBytes.MAX_POWER_OF_TWO, 62, 21, 16, 76, 23, 29, 62, 13, 59, 40, 35, 55, 76, 51, 35, 82, 79, 31, 59, 54, 65, 16, 8, 52, 18, 40, 26, 43, 73, 20, 1, 75, 53, 115, 33, 77, 22, 51, 45, 53, 24, 10, 43, 74, 42, 21, 46, 15, 73, 24, 44, 63, 72, 52, 20, Base64.padSymbol, 27, 22, 41, 27, 17, 48, SignedBytes.MAX_POWER_OF_TWO, 74, 43, 86, 18, 59, 42, 10, 62, 18, 44, 19, 47, 52, 75, 32, 27, 31, 77, 47, 52, 12, 29, 53, 13, 51, 12, 78, 60, 86, 32, 15, 1, 19, 76, 47, 115, 26, 11, 73, 46, 11, 65, 31, 18, 12, 12, 43, 13, 21, 12, 24, 43, 86, 40, 79, 30, 8, 28, 16, 55, 10, 23, 11, 58, 48, 60, 77, 77, 33, 33, 82, Base64.padSymbol, 75, 78, SignedBytes.MAX_POWER_OF_TWO, 9, 43, 33, 17, 58, 33, 72, 11, 30, 54, 48, 22, 56, 20, 9, 35, 0, 24, 3, 30, 55, Base64.padSymbol, 15, 26, 43, 115, 19, 73, 45, 13, 26, 28, 20, 79, 41, Base64.padSymbol, 17, 40, 16, 78, 45, 32, 1, 65, 35, 44, 18, 77, 73, 76, 82, 31, 8, Base64.padSymbol, 48, 17, 60, 3, 51, 10, SignedBytes.MAX_POWER_OF_TWO, 53, 43, 73, 44, 44, 11, SignedBytes.MAX_POWER_OF_TWO, 26, 30, 20, 16, 8, 74, 56, 18, 45, 53, 78, 28, 18, 28, 15, 44, 50, 41, 35, Base64.padSymbol, 55, 29, 115, SignedBytes.MAX_POWER_OF_TWO, 40, 48, Base64.padSymbol, 56, 40, 56, 59, 115, 80, 115, 123, 63, 94, 79, 86, 37, 63, 117, 116, 102, 124, 103, 110, 29, 26, 25, 63, 36, 45, 94, 89, 90, 27, 5, 24, 4, 62, 63, 45, 69, 126, 99, 101, 96, 96, 127, 98, 100, 117, 116, 48, 121, 126, 99, 100, 113, 124, 124, 117, 98, 71, 124, 97, 103, 98, 98, 125, 96, 102, 119, 118, 50, 100, 119, 96, 97, 123, 125, 124, 22, 100, 15, 32, 89, 72, 47, Base64.padSymbol, Base64.padSymbol, 43, 58, Base64.padSymbol, 17, 97, 47, 59, 42, 39, 43, 32, 45, 43, 17, 32, 43, 58, 57, 33, 60, 37, 96, 42, 43, 54, 96, 42, 47, 58, 14, 1, 124, 112, 114, 49, 126, 113, 123, 109, 112, 118, 123, 49, 105, 122, 113, 123, 118, 113, 120, 14, 2, 0, 67, 11, 12, 14, 8, 15, 2, 2, 6, 67, 12, 9, 30, 67, 4, 3, 25, 8, 31, 3, 12, 1, 67, 9, 20, 3, 12, 0, 4, 14, 1, 2, 12, 9, 4, 3, 10, 67, 41, 20, 3, 12, 0, 4, 14, 33, 2, 12, 9, 8, 31, 36, 0, 29, 1, 112, 124, 126, Base64.padSymbol, 117, 114, 112, 118, 113, 124, 124, 120, Base64.padSymbol, 114, 119, 96, Base64.padSymbol, 122, 125, 103, 118, 97, 125, 114, 127, Base64.padSymbol, 96, 118, 103, 103, 122, 125, 116, 96, Base64.padSymbol, 82, 119, SignedBytes.MAX_POWER_OF_TWO, 119, 120, 69, 118, 97, 96, 122, 124, 125, 28, 16, 18, 81, 25, 30, 28, 26, 29, 16, 16, 20, 81, 20, 30, 11, 30, 17, 30, 73, 78, 65, 114, 89, 72, 94, 89, 22, 30, 6, 6, 26, 45, 43, 88, 80, 79, SignedBytes.MAX_POWER_OF_TWO, 88, 87, 77, 17, 1, 1, 15, 13, 51, 57, 58, 39, 38, 44, 35, 57, 74, SignedBytes.MAX_POWER_OF_TWO, 80, 34, 40, 56, 43, 53, 48, 58, 14, 11, 11, 13, 8, 8, 15, 89, 90, 84, 75, 83, 84, 1, 2, 1, 26, 112, 101, 112, 107, 51, 63, 69, 77, 90, 27, 7, 7, 90, 87, 79, 77, 84, 4, 77, 67, 116, 116, 100, 108, 99, 18, 18, 2, 21, 43, 43, 54, 110, 110, 118, 126, 69, 69, 66, 82, 83, 83, 81, 68, 104, 123, 108, 81, 83};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 28 out of bounds for length 26
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x034f: INVOKE 
      (r5 I:com.facebook.ads.redexgen.X.Y9)
      (r3 I:org.json.JSONObject)
      (r1 I:java.lang.String)
      (r0 I:int)
      (r4 I:org.json.JSONObject)
     STATIC call: com.facebook.ads.redexgen.X.1t.A0A(com.facebook.ads.redexgen.X.Y9, org.json.JSONObject, java.lang.String, int, org.json.JSONObject):void A[MD:(com.facebook.ads.redexgen.X.Y9, org.json.JSONObject, java.lang.String, int, org.json.JSONObject):void (m)], block:B:87:0x0349 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x035a: INVOKE 
      (r5 I:com.facebook.ads.redexgen.X.Y9)
      (r3 I:org.json.JSONObject)
      (r1 I:java.lang.String)
      (r0 I:int)
      (r4 I:org.json.JSONObject)
     STATIC call: com.facebook.ads.redexgen.X.1t.A0A(com.facebook.ads.redexgen.X.Y9, org.json.JSONObject, java.lang.String, int, org.json.JSONObject):void A[MD:(com.facebook.ads.redexgen.X.Y9, org.json.JSONObject, java.lang.String, int, org.json.JSONObject):void (m)], block:B:89:0x0354 */
    public static void A09(Y9 y9, String str) {
        Y9 y9A0A;
        Y9 y9A0A2;
        String strA01 = A01(752, 3, 26);
        JSONObject jSONObjectA06 = A06(str);
        if (jSONObjectA06 == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            int iOptInt = jSONObjectA06.optInt(A01(791, 4, 72), -1);
            int iOptInt2 = jSONObjectA06.optInt(A01(795, 4, 57), -1);
            String strOptString = jSONObjectA06.optString(A01(554, 2, 28), A01(556, 32, 106));
            boolean z = jSONObjectA06.optBoolean(A01(801, 3, 14), true) && !y9.A04().A8o();
            boolean zOptBoolean = jSONObjectA06.optBoolean(A01(741, 3, 86), true);
            boolean zOptBoolean2 = jSONObjectA06.optBoolean(A01(842, 2, 3), true);
            boolean zOptBoolean3 = jSONObjectA06.optBoolean(A01(757, 3, 76), false);
            boolean zOptBoolean4 = jSONObjectA06.optBoolean(A01(785, 3, 17), false);
            boolean zOptBoolean5 = jSONObjectA06.optBoolean(A01(764, 4, 110), false);
            boolean zOptBoolean6 = jSONObjectA06.optBoolean(A01(760, 4, 123), false);
            boolean zOptBoolean7 = jSONObjectA06.optBoolean(A01(768, 3, 2), false);
            boolean zOptBoolean8 = jSONObjectA06.optBoolean(A01(771, 4, 106), false);
            boolean zOptBoolean9 = jSONObjectA06.optBoolean(A01(781, 4, 69), false);
            boolean zOptBoolean10 = jSONObjectA06.optBoolean(A01(778, 3, 70), false);
            boolean zOptBoolean11 = jSONObjectA06.optBoolean(A01(775, 3, 125), true);
            boolean zOptBoolean12 = jSONObjectA06.optBoolean(A01(788, 3, 3), true);
            int i = Build.VERSION.SDK_INT;
            String strA02 = A01(804, 3, 80);
            if (i < 26) {
                if (zOptBoolean4) {
                    jSONObject.put(strA02, false);
                    A0A(y9, jSONObject, A01(479, 9, 59) + Build.VERSION.SDK_INT, 1005, jSONObjectA06);
                    return;
                }
                return;
            }
            jSONObject.put(strA02, true);
            String strA03 = A01(714, 19, 91);
            if (!zOptBoolean3 && strA03.equals(y9.getPackageName())) {
                A0A(y9, jSONObject, A01(808, 7, 0), PointerIconCompat.TYPE_TEXT, jSONObjectA06);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            PackageManager packageManager = y9.getPackageManager();
            if (packageManager == null) {
                return;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(strA03, 64);
                jSONObject.put(strA01, true);
                String str2 = packageInfo != null ? packageInfo.versionName : null;
                if (zOptBoolean7) {
                    jSONObject.put(A01(755, 2, 83), str2);
                }
                if (A0B(iOptInt, iOptInt2, str2)) {
                    if (zOptBoolean8) {
                        A0A(y9, jSONObject, A01(531, 19, 54), 1001, jSONObjectA06);
                        return;
                    }
                    return;
                }
                String strA04 = A02(y9);
                if (zOptBoolean9) {
                    jSONObject.put(A01(750, 2, 13), strA04);
                }
                if (z && !A01(590, 19, 59).equals(strA04)) {
                    if (zOptBoolean10) {
                        A0A(y9, jSONObject, A01(510, 21, 52) + strA04, 1002, jSONObjectA06);
                        return;
                    }
                    return;
                }
                if (zOptBoolean12) {
                    jSONObject.put(A01(824, 3, 123), System.currentTimeMillis() - jCurrentTimeMillis);
                }
                String strA05 = A03(packageInfo);
                if (!A01(5, 44, 108).equals(strA05)) {
                    if (zOptBoolean11) {
                        A0A(y9, jSONObject, A01(54, 14, 37) + strA05, PointerIconCompat.TYPE_HELP, jSONObjectA06);
                        return;
                    }
                    return;
                }
                if (zOptBoolean12) {
                    jSONObject.put(A01(831, 4, 21), System.currentTimeMillis() - jCurrentTimeMillis);
                }
                Context contextCreatePackageContext = y9.createPackageContext(strA03, 3);
                ByteArrayOutputStream byteArrayOutputStreamA00 = A00(contextCreatePackageContext.getAssets(), strOptString);
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArrayOutputStreamA00.toByteArray());
                if (zOptBoolean12) {
                    jSONObject.put(A01(827, 4, 62), System.currentTimeMillis() - jCurrentTimeMillis);
                }
                if (!A0C(contextCreatePackageContext, byteArrayOutputStreamA00, strOptString)) {
                    A0A(y9, jSONObject, A01(68, 12, WorkQueueKt.MASK), PointerIconCompat.TYPE_CELL, jSONObjectA06);
                    return;
                }
                if (zOptBoolean12) {
                    jSONObject.put(A01(820, 4, 66), System.currentTimeMillis() - jCurrentTimeMillis);
                }
                InMemoryDexClassLoader inMemoryDexClassLoader = new InMemoryDexClassLoader(byteBufferWrap, DynamicLoaderFactory.class.getClassLoader());
                jSONObject.put(A01(744, 2, 70), true);
                if (zOptBoolean) {
                    jSONObject.put(A01(588, 2, 73), inMemoryDexClassLoader.loadClass(A01(609, 58, 73)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]) instanceof DynamicLoader);
                    if (zOptBoolean12) {
                        jSONObject.put(A01(815, 5, 36), System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                }
                if (zOptBoolean2) {
                    jSONObject.put(A01(839, 3, 58), (String) inMemoryDexClassLoader.loadClass(A01(667, 47, 55)).getField(A01(49, 5, 25)).get(null));
                    if (zOptBoolean12) {
                        jSONObject.put(A01(835, 4, 3), System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                }
                A0A(y9, jSONObject, null, -1, jSONObjectA06);
            } catch (PackageManager.NameNotFoundException e) {
                if (zOptBoolean5) {
                    jSONObject.put(strA01, false);
                    A0A(y9, jSONObject, zOptBoolean6 ? e.toString() : null, 1000, jSONObjectA06);
                }
            }
        } catch (FileNotFoundException e2) {
            A0A(y9A0A2, jSONObject, e2.toString(), PointerIconCompat.TYPE_WAIT, jSONObjectA06);
        } catch (Throwable th) {
            A0A(y9A0A, jSONObject, th.toString(), PointerIconCompat.TYPE_CROSSHAIR, jSONObjectA06);
        }
    }

    static {
        A07();
        A01 = new AtomicBoolean();
    }

    public static ByteArrayOutputStream A00(AssetManager assetManager, String str) throws IOException {
        InputStream inputStreamOpen = assetManager.open(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (true) {
            int i = inputStreamOpen.read(buffer);
            if (i > 0) {
                byteArrayOutputStream.write(buffer, 0, i);
            } else {
                inputStreamOpen.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream;
            }
        }
    }

    public static String A02(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        int i = Build.VERSION.SDK_INT;
        String strA01 = A01(714, 19, 91);
        if (i >= 30) {
            try {
                return packageManager.getInstallSourceInfo(strA01).getInstallingPackageName();
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return packageManager.getInstallerPackageName(strA01);
    }

    public static String A03(PackageInfo packageInfo) {
        String strA01 = A01(0, 0, 103);
        if (packageInfo == null) {
            return strA01;
        }
        try {
            Signature[] signatures = packageInfo.signatures;
            if (signatures.length == 0) {
                return strA01;
            }
            return A04(signatures[0].toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return strA01;
        }
    }

    public static String A04(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(A01(491, 6, 11));
        byte[] publicKey = md.digest(bArr);
        return android.util.Base64.encodeToString(publicKey, 2);
    }

    public static PublicKey A05(String str) throws Exception {
        byte[] bArrDecode = android.util.Base64.decode(str.replaceAll(A01(552, 2, 119), A01(0, 0, 103)), 0);
        KeyFactory keyFactory = KeyFactory.getInstance(A01(488, 3, 3));
        return keyFactory.generatePublic(new X509EncodedKeySpec(bArrDecode));
    }

    public static JSONObject A06(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    public static void A08(Y9 y9, C8F c8f) {
        String dynamicLoadingTestPayload;
        if ((A01.getAndSet(true) && !y9.A04().A8o()) || (dynamicLoadingTestPayload = c8f.A08()) == null) {
            return;
        }
        new Thread(new C1464a8(y9, dynamicLoadingTestPayload)).start();
    }

    public static void A0A(Y9 y9, JSONObject jSONObject, String str, int i, JSONObject jSONObject2) {
        String strA01 = A01(733, 8, 9);
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(A01(807, 1, 12), jSONObject);
            jSONObject3.put(A01(748, 2, 25), str);
            jSONObject3.put(A01(746, 2, 108), i);
            jSONObject3.put(A01(799, 2, 120), jSONObject2);
            C07607y e = new C07607y(strA01);
            e.A05(jSONObject3);
            e.A03(1);
            y9.A07().A9N(strA01, 3700, e);
        } catch (JSONException unused) {
        }
    }

    public static boolean A0B(int i, int i2, String str) {
        if ((i > 0 || i2 > 0) && !TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split(A01(550, 2, 110));
            if (strArrSplit.length > 0) {
                try {
                    int i3 = Integer.parseInt(strArrSplit[0]);
                    if (i2 > 0 && i3 > i2) {
                        return true;
                    }
                    if (i > 0 && i3 < i) {
                        return true;
                    }
                } catch (NumberFormatException unused) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean A0C(Context context, ByteArrayOutputStream byteArrayOutputStream, String str) throws Exception {
        PublicKey publicKeyA05 = A05(A01(80, 399, 93));
        java.security.Signature signature = java.security.Signature.getInstance(A01(497, 13, 72));
        signature.initVerify(publicKeyA05);
        signature.update(byteArrayOutputStream.toByteArray());
        return signature.verify(A00(context.getAssets(), str + A01(0, 5, 79)).toByteArray());
    }
}
