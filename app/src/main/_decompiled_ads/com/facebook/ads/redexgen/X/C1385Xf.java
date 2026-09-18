package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.DeflaterOutputStream;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1385Xf implements C8R {
    public static PackageInfo A03;
    public static EnumC1062Ko A04;
    public static String A05;
    public static boolean A06;
    public static byte[] A07;
    public static String[] A08 = {"rjWu3o3XUIKJimpXtRLH", "N3hUjd9gC1zTrolrzHWDwio6K0KaeF7v", "V8BOZxTrBek9nlJry76rEN1tEiA1lgnf", "2kaCuDD1e44XjFqxj97oS3bW7Y4jUXps", "VcJxC1jbHxk7XwGyeCWvHwY9E4qRcx1x", "dO6RHNbAuKw0kDbwpnJR", "8jPNINbp0cYAxxIn", "ugIdyp1aSJPFHYCiUHctz2XPYC5YD6Ud"};
    public static final C0U[] A09;
    public static final AtomicBoolean A0A;
    public static final AtomicInteger A0B;
    public final C6G A00;
    public final C7S A01;
    public final AnonymousClass87 A02;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A08[6].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[1] = "AJGqtkftO03LFXDJsHlFXR4ujVWNfKsn";
            strArr[7] = "0weTThgY8dzMPuXGgH30KJvXs1017h9U";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 73);
            i4++;
        }
    }

    public static void A08() {
        A07 = new byte[]{40, 13, 21, 23, 23, 17, 7, 7, 29, 22, 29, 24, 29, 0, 13, 11, 17, 26, 21, 22, 24, 17, 16, 41, 46, 56, 45, 42, 60, 87, 98, 109, 98, 111, 108, 100, 85, 68, 68, 75, 89, 93, 90, 75, 71, 80, 95, 75, 66, 81, 70, 71, 93, 91, 90, 78, 92, 71, 78, 92, 44, 62, 36, 41, 86, 67, 67, 69, 94, 85, 66, 67, 94, 88, 89, 72, 94, 83, 106, 97, 108, 108, 109, 122, 119, 124, 103, 99, 109, 102, 119, 109, 112, 124, 122, 105, 123, 62, 41, 50, 56, 48, 57, 79, 77, 92, 92, 73, 72, 83, 69, 72, 95, 21, 23, 4, 4, 31, 19, 4, 67, 70, 83, 70, 88, 87, 85, 72, 68, 66, 84, 84, 78, 73, SignedBytes.MAX_POWER_OF_TWO, 88, 72, 87, 83, 78, 72, 73, 84, 92, 89, 76, 89, 71, 72, 74, 87, 91, 93, 75, 75, 81, 86, 95, 71, 87, 72, 76, 81, 87, 86, 75, 71, 91, 87, 77, 86, 76, 74, 65, 111, 106, 127, 106, 116, 123, 121, 100, 104, 110, 120, 120, 98, 101, 108, 116, 100, 123, 127, 98, 100, 101, 120, 116, 120, 127, 106, 127, 110, 28, 29, 22, 11, 17, 12, 1, 13, 30, 5, 5, 14, 7, 20, 8, 4, 25, 14, 20, 14, 29, 14, 5, 31, 24, 48, 35, 56, 56, 51, 58, 41, 58, 57, 49, 49, 51, 50, 30, 57, 49, 52, Base64.padSymbol, 60, 120, 44, 55, 120, 58, 45, 49, 52, 60, 120, 45, 43, Base64.padSymbol, 42, 120, 44, 55, 51, Base64.padSymbol, 54, 95, 86, 68, 72, 82, 79, 88, 71, 91, 86, 78, 82, 69, 52, 57, 59, 60, 48, Base64.padSymbol, 38, 58, 56, 58, 49, 60, 38, 45, 42, 38, 52, 42, 37, 40, 51, 63, 35, 57, 62, 47, 41, 47, 40, 53, 50, 39, 42, 42, 35, 52, 75, 72, 68, 70, 75, 66, 109, 97, 107, 101, 5, 13, 12, 1, 9, 28, 1, 7, 6, 23, 27, 13, 26, 30, 1, 11, 13, 72, 67, 82, 81, 73, 84, 77, 89, 82, 95, 86, 67, SignedBytes.MAX_POWER_OF_TWO, 76, 90, 67, 90, 92, 80, 90, 92, 74, 93, 80, 70, 75, 15, 18, 18, 9, 24, 25, 96, 102, 116, 109, 116, 112, 109, 115, 98, 98, 109, 123, 124, 97, 102, 115, 126, 126, 119, 118, 96, 102, 116, 109, 116, 112, 109, 115, 98, 98, 109, 100, 119, 96, 97, 123, 125, 124, 63, 47, 62, 41, 41, 34, 51, 36, 41, 37, 43, 36, 56, 127, 111, 126, 105, 105, 98, 115, 123, 101, 104, 120, 100, 53, 34, 45, 57, 37, 39, 54, 39, 36, 47, 42, 47, 50, 63, 28, 10, 28, 28, 6, 0, 1, 16, 27, 6, 2, 10, 70, 93, 90, 71, 74, 34, 36, 50, 37, 40, 54, 48, 50, 57, 35, 66, 85, 88, 68, 85, 70, 85, 89, 71, 127, 125, 118, 125, 106, 113, 123, 53, 46, 55, 55};
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00ed A[Catch: IOException -> 0x00f5, TryCatch #0 {IOException -> 0x00f5, blocks: (B:23:0x00e8, B:25:0x00ed, B:27:0x00f2), top: B:31:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00f2 A[Catch: IOException -> 0x00f5, TRY_LEAVE, TryCatch #0 {IOException -> 0x00f5, blocks: (B:23:0x00e8, B:25:0x00ed, B:27:0x00f2), top: B:31:0x00e8 }] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final String A0B(C8P c8p) {
        A09(this.A01, true);
        ByteArrayOutputStream byteArrayOutputStream = null;
        Base64OutputStream base64OutputStream = null;
        DeflaterOutputStream deflaterOutputStream = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 0);
                deflaterOutputStream = new DeflaterOutputStream(base64OutputStream);
                Map<String, String> mapA0C = A0C();
                if (TextUtils.isEmpty(AnonymousClass62.A00().A03())) {
                    AnonymousClass62.A07(this.A01);
                }
                mapA0C.put(A03(280, 4, 52), AnonymousClass62.A00().A03());
                mapA0C.put(A03(469, 10, 62), C8W.A06(this.A02, this.A01, false));
                if (IP.A1Z(this.A01)) {
                    mapA0C.put(A03(103, 10, 69), C05890v.A01(this.A01).A0K());
                }
                Iterator<Map.Entry<String, String>> it = mapA0C.entrySet().iterator();
                while (it.hasNext()) {
                    if (!c8p.A2V(it.next().getKey())) {
                        it.remove();
                    }
                }
                deflaterOutputStream.write(new JSONObject(mapA0C).toString().getBytes());
                deflaterOutputStream.close();
                String strReplaceAll = byteArrayOutputStream.toString().replaceAll(A03(0, 1, 107), A03(0, 0, 37));
                try {
                    deflaterOutputStream.close();
                    base64OutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return strReplaceAll;
            } catch (IOException e) {
                throw new RuntimeException(A03(241, 26, 17), e);
            }
        } catch (Throwable th) {
            if (deflaterOutputStream != null) {
                try {
                    deflaterOutputStream.close();
                    if (base64OutputStream != null) {
                        base64OutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                } catch (IOException unused2) {
                    throw th;
                }
            } else {
                if (base64OutputStream != null) {
                    base64OutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x01ba  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final Map<String, String> A0C() {
        String strA6x;
        A09(this.A01, false);
        AnonymousClass86.A0B(this.A01);
        AnonymousClass86.A08(this.A01);
        HashMap map = new HashMap();
        C8O.A02(this.A01, map);
        map.put(A03(316, 6, 78), Locale.getDefault().toString());
        float f = C1066Ku.A02;
        int i = this.A01.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.A01.getResources().getDisplayMetrics().heightPixels;
        map.put(A03(203, 7, 17), String.valueOf(f));
        map.put(A03(426, 12, 101), String.valueOf((int) (i / f)));
        map.put(A03(TTAdConstant.VIDEO_INFO_CODE, 13, 37), String.valueOf((int) (i2 / f)));
        map.put(A03(64, 14, 94), AnonymousClass62.A03());
        map.put(A03(298, 9, 37), AnonymousClass62.A00().A02().name());
        map.put(A03(284, 14, 48), String.valueOf(AnonymousClass62.A00().A01()));
        map.put(A03(97, 6, 53), C8W.A03(this.A01, this.A02));
        map.put(A03(113, 7, 31), this.A02.A08());
        map.put(A03(322, 4, 105), this.A02.A09());
        map.put(A03(369, 6, 20), String.valueOf(A01(this.A01).A00));
        map.put(A03(307, 9, 47), this.A02.A0B());
        map.put(A03(438, 14, 47), EnumC1054Kg.A01());
        map.put(A03(343, 12, 79), String.valueOf(LK.A00(this.A01).A00));
        map.put(A03(452, 12, 6), LM.A02(this.A01.A08().A01()));
        String str = A05;
        if (str != null) {
            String strA03 = A03(23, 3, 33);
            String[] strArr = A08;
            if (strArr[1].charAt(17) != strArr[7].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[1] = "AqiFfSJaVcvWeekshHh0ldvtL31lvyuj";
            strArr2[7] = "9HeqxNTbWRKyR8KfBHSSaEFZWfPVqzw4";
            map.put(strA03, str);
        }
        String strA02 = C1063Kp.A02(this.A01);
        String[] strArr3 = A08;
        if (strArr3[0].length() == strArr3[5].length()) {
            String[] strArr4 = A08;
            strArr4[1] = "BCkwQrwTZAh8DbNWYHcyNfiOEn9j0AAp";
            strArr4[7] = "Pk3Ope4wXmj489nPkHNYEkNTYlpVjL8G";
            if (strA02 != null) {
                map.put(A03(55, 5, 70), strA02);
            }
        } else if (strA02 != null) {
            map.put(A03(55, 5, 70), strA02);
        }
        map.put(A03(464, 5, 90), String.valueOf(C1067Kv.A05(this.A01)));
        String strA7I = this.A01.A04().A7I();
        if (strA7I != null) {
            map.put(A03(326, 17, 1), strA7I);
        }
        map.put(A03(2, 21, 29), String.valueOf(this.A02.A0C()));
        if (this.A02.A03() != -1) {
            map.put(A03(36, 19, 93), String.valueOf(this.A02.A03()));
        }
        map.put(A03(479, 9, 93), C8M.A05(this.A01));
        map.put(A03(30, 6, 106), L0.A01(AnonymousClass86.A02()));
        if (IO.A05(this.A01) && (strA6x = this.A01.A04().A6x()) != null) {
            map.put(A03(60, 4, 36), strA6x);
        }
        String strA7N = this.A01.A04().A7N();
        if (!TextUtils.isEmpty(strA7N)) {
            map.put(A03(355, 14, 70), strA7N);
        }
        C07447g c07447gA6c = this.A01.A06().A6c();
        String strA04 = A03(174, 29, 98);
        String strA05 = A03(143, 31, 81);
        String strA06 = A03(120, 23, 78);
        if (c07447gA6c != null) {
            map.put(strA06, c07447gA6c.A08());
            map.put(strA05, String.valueOf(c07447gA6c.A05()));
            map.put(strA04, String.valueOf(c07447gA6c.A06()));
        } else {
            String strA07 = A03(495, 4, 18);
            map.put(strA06, strA07);
            map.put(strA05, strA07);
            map.put(strA04, strA07);
        }
        map.put(A03(103, 10, 69), C05890v.A01(this.A01).A0K());
        String strA08 = this.A00.A03(this.A01);
        if (strA08 != null && !TextUtils.isEmpty(strA08)) {
            map.put(A03(78, 19, 97), strA08);
        }
        map.put(A03(267, 13, 94), String.valueOf(this.A01.A03().A8O()));
        map.put(A03(228, 13, 63), String.valueOf(C07537r.A0H(this.A01)));
        StringBuilder sb = new StringBuilder();
        C0U[] c0uArr = A09;
        for (int i3 = 0; i3 < c0uArr.length; i3++) {
            sb.append(c0uArr[i3].A02() + 4000);
            if (i3 != c0uArr.length - 1) {
                sb.append(A03(1, 1, 104));
            }
        }
        map.put(A03(210, 18, 2), sb.toString());
        PackageInfo packageInfoA00 = A00(this.A01);
        map.put(A03(375, 20, 123), String.valueOf(packageInfoA00 != null));
        if (packageInfoA00 != null) {
            map.put(A03(395, 18, 123), String.valueOf(packageInfoA00.versionCode));
        }
        return map;
    }

    static {
        A08();
        A0A = new AtomicBoolean();
        A0B = new AtomicInteger(0);
        A05 = null;
        A06 = false;
        A09 = new C0U[]{C0U.A16, C0U.A0k, C0U.A17, C0U.A1F, C0U.A11, C0U.A13, C0U.A23, C0U.A24, C0U.A25};
    }

    public C1385Xf(C7S c7s, boolean z, C6G c6g) {
        this.A01 = c7s;
        this.A02 = new AnonymousClass87(c7s);
        this.A00 = c6g;
        A09(c7s, z);
    }

    public static synchronized PackageInfo A00(C7S c7s) {
        if (!A06) {
            A03 = L3.A00(c7s);
            A06 = true;
        }
        return A03;
    }

    public static synchronized EnumC1062Ko A01(C7S c7s) {
        if (A04 == null) {
            A04 = C1063Kp.A00(c7s.A04().A8o());
        }
        return A04;
    }

    public static String A04(C7S c7s, String str) {
        try {
            PackageManager packageManager = c7s.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return C1069Kx.A03(packageManager.getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e) {
            if (A0A.compareAndSet(false, true)) {
                c7s.A07().A9M(A03(488, 7, 81), C07597x.A1P, new C07607y(e));
            }
            return null;
        }
    }

    public static void A09(final C7S c7s, boolean z) {
        if (!A0B.compareAndSet(0, 1)) {
            return;
        }
        A01(c7s);
        try {
            final SharedPreferences sharedPreferencesA00 = C1041Jt.A00(c7s);
            final AnonymousClass87 anonymousClass87 = new AnonymousClass87(c7s);
            final String str = A03(26, 4, 37) + anonymousClass87.A06();
            A05 = sharedPreferencesA00.getString(str, null);
            FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: com.facebook.ads.redexgen.X.8T
                public static byte[] A04;
                public static String[] A05 = {"XdxsWQHKmAYrPa6mv803llFsbG6xUBv1", "0ZMGl2pSIAaZIEqvxPmnMQII5PMyDfzp", "xK6bN8ERsE3qlK", "WJOztIfqKvqLg1zb8DcclROO5I1m6hYl", "NZ35AS4Ok4U2uFg9Bn0RAVLmEZFAhNaA", "i6NGDYiwjEbiTB59W8H8ewYatIcL2Rm5", "tt3j", "3tQ5yRyF2hXRO3n7qZm1zDaXW"};

                public static String A01(int i, int i2, int i3) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
                    int i4 = 0;
                    while (true) {
                        int length = bArrCopyOfRange.length;
                        if (A05[2].length() != 14) {
                            throw new RuntimeException();
                        }
                        A05[0] = "ijq86j9eF5Bfako4vk0V9m1lrfYXSgO1";
                        if (i4 >= length) {
                            return new String(bArrCopyOfRange);
                        }
                        bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 105);
                        i4++;
                    }
                }

                public static void A02() {
                    A04 = new byte[]{124, 125, 115, 110, 125, 109, 106, 102, 100, 39, 104, 103, 109, 123, 102, 96, 109, 39, 127, 108, 103, 109, 96, 103, 110, 120, 104, 122, 107, 114, 78, 94, 65, 74, 78, 111, 109, 102, 109, 122, 97, 107};
                }

                static {
                    A02();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Code duplicated, block: B:10:0x0034  */
                /* JADX WARN: Code duplicated, block: B:6:0x0017  */
                /* JADX WARN: Code duplicated, block: B:8:0x001f  */
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
                public final Boolean call() throws Exception {
                    String strA0B;
                    String checksumApiFingerprint;
                    String strA01 = null;
                    if (Build.VERSION.SDK_INT < 31) {
                        String strA02 = A01(0, 1, 70);
                        String checksumApiFingerprint2 = Build.VERSION.CODENAME;
                        if (strA02.equals(checksumApiFingerprint2)) {
                            if (IP.A2C(c7s)) {
                                strA0B = anonymousClass87.A0B();
                                checksumApiFingerprint = A01(6, 19, 96);
                                if (checksumApiFingerprint.equals(strA0B)) {
                                    strA01 = C1069Kx.A01(c7s);
                                }
                            }
                        }
                    } else if (IP.A2C(c7s)) {
                        strA0B = anonymousClass87.A0B();
                        checksumApiFingerprint = A01(6, 19, 96);
                        if (checksumApiFingerprint.equals(strA0B)) {
                            strA01 = C1069Kx.A01(c7s);
                        }
                    }
                    if (strA01 == null) {
                        C7S c7s2 = c7s;
                        String checksumApiFingerprint3 = c7s2.getPackageName();
                        String unused = C1385Xf.A05 = C1385Xf.A04(c7s2, checksumApiFingerprint3);
                    } else {
                        if (IP.A1K(c7s)) {
                            C7S c7s3 = c7s;
                            String checksumApiFingerprint4 = c7s3.getPackageName();
                            String strA04 = C1385Xf.A04(c7s3, checksumApiFingerprint4);
                            String checksumApiFingerprint5 = A01(1, 5, 119);
                            C07607y c07607y = new C07607y(checksumApiFingerprint5);
                            c07607y.A03(1);
                            c07607y.A04(1);
                            c07607y.A08(false);
                            JSONObject jSONObject = new JSONObject();
                            String checksumApiFingerprint6 = A01(25, 5, 114);
                            jSONObject.put(checksumApiFingerprint6, strA01);
                            String checksumApiFingerprint7 = A01(30, 5, 68);
                            jSONObject.put(checksumApiFingerprint7, strA04);
                            c07607y.A05(jSONObject);
                            InterfaceC07587w interfaceC07587wA07 = c7s.A07();
                            int i = C07597x.A1I;
                            String checksumApiFingerprint8 = A01(35, 7, 97);
                            interfaceC07587wA07.A9N(checksumApiFingerprint8, i, c07607y);
                        }
                        String unused2 = C1385Xf.A05 = strA01;
                    }
                    SharedPreferences.Editor editorEdit = sharedPreferencesA00.edit();
                    String str2 = str;
                    String checksumApiFingerprint9 = C1385Xf.A05;
                    editorEdit.putString(str2, checksumApiFingerprint9).apply();
                    C1385Xf.A0B.set(2);
                    return true;
                }
            });
            Executors.newSingleThreadExecutor().submit(futureTask);
            if (z) {
                futureTask.get();
            }
        } catch (Exception unused) {
            A0B.set(0);
        }
    }

    public final String A0A() {
        return A0B(C8Q.A00());
    }
}
