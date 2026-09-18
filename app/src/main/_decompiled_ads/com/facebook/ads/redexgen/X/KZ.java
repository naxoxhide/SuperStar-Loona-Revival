package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KZ {
    public static byte[] A00;
    public static String[] A01 = {"HfGv3264Bq2TQ34NqRtE4P30TXR", "AZVpgJ8fi5FDz5AiC", "FCmmf0GU", "NGZF99o8OEHjBvmOxlLxN", "MEp80XUn5zKurDhCJ73", "hVp2plT6ulDLwck", "CErebgOhZelO8plRL7vU3", "v0a34uu5Y8rm3tpqkSr554RtUBdvL4ru"};

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 60);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{-49, -36, -19, -44, -48, -62, -49, -19, -31, -45, -47, -29, -32, -45, -19, -30, -35, -39, -45, -36, -20, -7, 10, -14, -5, -2, 10, -20, -17, 10, -18, -6, -7, -1, -16, -7, -1, -56, -58, -47, -47, -54, -41, -28, -55, -44, -46, -58, -50, -45, -6, 24, 37, -34, 43, -41, 42, 43, 24, 41, 43, -41, -8, 44, 27, 32, 28, 37, 26, 28, 5, 28, 43, 46, 38, 41, 34, -8, 26, 43, 32, 45, 32, 43, 48, -27, -41, 4, 24, 34, 28, -41, 42, 44, 41, 28, -41, 43, 31, 24, 43, -41, 32, 43, -34, 42, -41, 32, 37, -41, 48, 38, 44, 41, -41, -8, 37, 27, 41, 38, 32, 27, 4, 24, 37, 32, 29, 28, 42, 43, -27, 47, 36, 35, -41, 29, 32, 35, 28, -27, -88, -69, -73, -75, -92, -62, -72, -75, -81, -60, -64, -65, -13, -30, -25, -29, -20, -31, -29, -52, -29, -14, -11, -19, -16, -23, -30, -76, -84, -71, -86, -84, -82, -65, -76, -63, -76, -65, -60, -58, -45, -55, -41, -44, -50, -55, -109, -50, -45, -39, -54, -45, -39, -109, -58, -56, -39, -50, -44, -45, -109, -69, -82, -86, -68, -49, -36, -46, -32, -35, -41, -46, -100, -41, -36, -30, -45, -36, -30, -100, -47, -49, -30, -45, -43, -35, -32, -25, -100, -80, -64, -67, -59, -63, -81, -80, -70, -77, -31, -15, -18, -10, -14, -28, -15, -44, -47, -53, -89, -91, -80, -80, -87, -74, -115, -88, -16, -7, -10, -14, -5, 1, -31, -4, -8, -14, -5, -75, -63, -65, -128, -77, -64, -74, -60, -63, -69, -74, -128, -76, -60, -63, -55, -59, -73, -60, -128, -77, -62, -62, -66, -69, -75, -77, -58, -69, -63, -64, -79, -69, -74, -78, -66, -68, 125, -80, -67, -77, -63, -66, -72, -77, 125, -59, -76, -67, -77, -72, -67, -74, -39, -27, -29, -92, -36, -41, -39, -37, -40, -27, -27, -31, -92, -35, -27, -27, -35, -30, -37, -26, -30, -41, -17, -23, -22, -27, -24, -37, -41, -28, -92, -67, -27, -27, -35, -30, -37, -58, -30, -41, -17, -55, -22, -27, -24, -37, -73, -60, -59, -20, -37, -24, -30, -41, -17, -69, -18, -22, -37, -24, -28, -41, -30, -73, -39, -22, -33, -20, -33, -22, -17, -72, -60, -62, -125, -69, -74, -72, -70, -73, -60, -60, -64, -125, -64, -74, -55, -74, -61, -74, -77, -62, -75, -79, -60, -75, -81, -66, -75, -57, -81, -60, -79, -78, -63, -67, 29, 22, 35, 25, 33, 26, 39, 9, 30, 34, 26, -2, 10, 10, 6, -83, -71, -71, -75, 127, 116, 116, -75, -79, -90, -66, 115, -84, -76, -76, -84, -79, -86, 115, -88, -76, -78, 116, -72, -71, -76, -73, -86, 116, -90, -75, -75, -72, 116, -17, -5, -5, -9, -6, -66, -78, -61, -68, -74, -59, -13, -6, -23, -10, -16, -27, -3, -19, -23, -34, -10, -85, -28, -20, -20, -28, -23, -30, -85, -32, -20, -22, 24, 11, 25, 15, 32, 11, -13, 21, 10, 11, 9, -4, -8, 10, -25, 12, 3, -8};
    }

    static {
        A06();
    }

    private int A00(YA ya) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = ya.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(A04(391, 19, 25), 0)) != null && !TextUtils.isEmpty(packageInfo.versionName)) {
                return Integer.parseInt(packageInfo.versionName.split(A04(166, 2, 74), 2)[0]);
            }
            return -1;
        } catch (PackageManager.NameNotFoundException | NumberFormatException unused) {
            return -1;
        }
    }

    public static Intent A01(Uri uri) {
        Intent intent = new Intent(A04(179, 26, 41), uri);
        intent.setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    public static Intent A02(YA ya, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.addCategory(A04(205, 33, 50));
        intentA01.addFlags(268435456);
        intentA01.putExtra(A04(267, 34, 22), ya.getPackageName());
        intentA01.putExtra(A04(TTAdConstant.IMAGE_LIST_SIZE_CODE, 14, 20), false);
        if (IP.A1b(ya)) {
            if (A04(424, 2, 31).equals(uri.getScheme())) {
                intentA01.setPackage(A04(391, 19, 25));
            }
        }
        return intentA01;
    }

    public static Intent A03(YA ya, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.setPackage(A04(301, 19, 19));
        intentA01.putExtra(A04(248, 8, 8), ya.getPackageName());
        intentA01.putExtra(A04(486, 7, 72), true);
        return intentA01;
    }

    private String A05(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    private void A07(YA ya, Uri uri) throws KL {
        KN.A0B(ya, A02(ya, uri));
    }

    private void A08(YA ya, Uri uri, String str) {
        AdActivityIntent adActivityIntentA04 = KN.A04(ya);
        adActivityIntentA04.addFlags(268435456);
        adActivityIntentA04.putExtra(A04(518, 8, 87), EnumC1039Jq.A02);
        adActivityIntentA04.putExtra(A04(238, 10, 67), uri.toString());
        adActivityIntentA04.putExtra(A04(256, 11, 81), str);
        adActivityIntentA04.putExtra(A04(426, 11, 121), System.currentTimeMillis());
        try {
            KN.A09(ya, adActivityIntentA04);
        } catch (KL e) {
            Throwable cause = e.getCause();
            KL cause2 = e;
            if (cause != null) {
                cause2 = e.getCause();
            }
            ya.A07().A9M(A04(168, 11, 15), C07597x.A0D, new C07607y(cause2));
            Log.e(A04(149, 17, 66), A04(50, 90, 123), cause2);
        }
    }

    private final void A09(YA ya, Uri uri, String str) throws KL, KX {
        if (A0F(ya)) {
            boolean zA0J = A0J(ya, str);
            if (!zA0J) {
                boolean canEnableSpliScreen = IP.A1u(ya);
                if (canEnableSpliScreen) {
                    boolean canEnableSpliScreen2 = KN.A0C(ya, A03(ya, uri));
                    if (canEnableSpliScreen2) {
                        return;
                    }
                }
            }
            boolean canEnableSpliScreen3 = A0H(ya, uri, str);
            if (canEnableSpliScreen3) {
                return;
            }
            Intent intentA02 = A02(ya, uri);
            intentA02.setPackage(A04(301, 19, 19));
            if (zA0J) {
                intentA02.addFlags(268472320);
            }
            KN.A0B(ya, intentA02);
            return;
        }
        throw new KX();
    }

    private final void A0A(YA ya, Uri uri, String str) throws KL {
        boolean zA05 = IQ.A05(ya);
        boolean isInAppBrowserEnabled = A0D(uri);
        if (isInAppBrowserEnabled && zA05) {
            A08(ya, uri, str);
        } else {
            ya.A0E().A8V(zA05);
            A07(ya, uri);
        }
    }

    public static void A0B(KZ kz, YA ya, Uri uri, String str) {
        kz.A0I(ya, uri, str);
    }

    public static void A0C(KZ kz, YA ya, Uri uri, String str) throws KL {
        boolean z = A0D(uri) && A04(FacebookRequestErrorClassification.ESC_APP_INACTIVE, 15, 65).equals(uri.getHost());
        boolean isGooglePlayWebLink = A04(480, 6, 21).equals(uri.getScheme());
        if (isGooglePlayWebLink || z) {
            try {
                kz.A09(ya, uri, str);
                return;
            } catch (KX unused) {
                kz.A0A(ya, uri, str);
                return;
            }
        }
        kz.A0A(ya, uri, str);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0038  */
    /* JADX WARN: Code duplicated, block: B:15:0x004e  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    public static boolean A0D(Uri uri) {
        boolean isHttpPermitted;
        boolean isHttpPermitted2;
        if (Build.VERSION.SDK_INT >= 24) {
            boolean zIsCleartextTrafficPermitted = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            String[] strArr = A01;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            A01[7] = "9DaYNTGnU6m41BFJKxw5hEDOoLHVmNBK";
            if (zIsCleartextTrafficPermitted || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(uri.getHost())) {
                isHttpPermitted = true;
            } else {
                isHttpPermitted = false;
            }
        } else {
            isHttpPermitted = true;
        }
        String scheme = uri.getScheme();
        if (isHttpPermitted) {
            boolean isHttpPermitted3 = A04(437, 4, 90).equalsIgnoreCase(scheme);
            if (!isHttpPermitted3) {
                isHttpPermitted2 = A04(475, 5, 75).equalsIgnoreCase(scheme);
                if (isHttpPermitted2) {
                    return false;
                }
            }
        } else {
            isHttpPermitted2 = A04(475, 5, 75).equalsIgnoreCase(scheme);
            if (isHttpPermitted2) {
                return false;
            }
        }
        return true;
    }

    private boolean A0E(YA ya) {
        if (!IP.A15(ya)) {
            return false;
        }
        int iA0D = IP.A0D(ya);
        if (A01[7].charAt(2) != 'a') {
            throw new RuntimeException();
        }
        A01[2] = "JMUKVK1n";
        int iA00 = A00(ya);
        return iA0D != -1 && iA00 != -1 && iA0D <= iA00 && Build.VERSION.SDK_INT >= 28;
    }

    private boolean A0F(YA ya) {
        Intent playStoreIntent = new Intent(A04(179, 26, 41), C1050Kc.A00(A04(441, 34, 9)));
        Iterator<ResolveInfo> it = ya.getPackageManager().queryIntentActivities(playStoreIntent, 0).iterator();
        while (it.hasNext()) {
            if (it.next().activityInfo.applicationInfo.packageName.equals(A04(301, 19, 19))) {
                return true;
            }
        }
        return false;
    }

    private boolean A0G(YA ya, Uri uri, String str) throws KL {
        try {
            Activity activityA0D = ya.A0D();
            String string = uri.toString();
            if (activityA0D != null && !TextUtils.isEmpty(string)) {
                Intent intent = new Intent();
                if (IP.A16(ya)) {
                    String strA06 = AbstractC1484aS.A06(str);
                    if (TextUtils.isEmpty(strA06)) {
                        return false;
                    }
                    intent.putExtra(A04(0, 20, 82), A05(strA06));
                }
                intent.setComponent(new ComponentName(A04(391, 19, 25), A04(320, 71, 58)));
                intent.putExtra(A04(140, 9, 39), string);
                intent.putExtra(A04(37, 13, 73), A05(A04(20, 17, 111)));
                if (!KN.A0C(ya, intent)) {
                    activityA0D.startActivityForResult(intent, 2);
                    return true;
                }
                return true;
            }
            return false;
        } catch (ActivityNotFoundException | IllegalStateException e) {
            ya.A0E().A9Q(e.getMessage());
            return false;
        }
    }

    private boolean A0H(YA ya, Uri uri, String str) throws KL {
        return A0E(ya) && A0G(ya, uri, str);
    }

    private final boolean A0I(YA ya, Uri uri, String str) {
        return KN.A0E(ya, uri, str);
    }

    public static boolean A0J(YA ya, String str) {
        boolean zA1G = IP.A1G(ya);
        boolean isSplitScreenEnabled = Build.VERSION.SDK_INT >= 24;
        boolean onAndAboveNOS = A0K(ya, str);
        boolean isSplitScreenSupportedInApp = zA1G && isSplitScreenEnabled && onAndAboveNOS;
        ya.A0E().A9l(onAndAboveNOS, isSplitScreenSupportedInApp);
        return isSplitScreenSupportedInApp;
    }

    public static boolean A0K(YA ya, String str) {
        ActivityInfo activityInfo;
        try {
            Activity activityA0D = ya.A0D();
            PackageManager packageManager = ya.getPackageManager();
            if (activityA0D == null || packageManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT > 32) {
                activityInfo = packageManager.getActivityInfo(activityA0D.getComponentName(), PackageManager.ComponentInfoFlags.of(0L));
            } else {
                activityInfo = packageManager.getActivityInfo(activityA0D.getComponentName(), 128);
            }
            Field declaredField = ActivityInfo.class.getDeclaredField(A04(508, 10, 106));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activityInfo);
            return (obj instanceof Integer) && ((Integer) obj).intValue() != 0;
        } catch (PackageManager.NameNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            ya.A0E().A9j(e.getMessage());
        }
        return false;
    }

    public static boolean A0L(KZ kz, YA ya, Uri uri, String str) {
        try {
            A0C(kz, ya, uri, str);
            return true;
        } catch (KL e) {
            Throwable cause = e.getCause();
            KL cause2 = e;
            if (cause != null) {
                cause2 = e.getCause();
            }
            ya.A07().A9M(A04(168, 11, 15), C07597x.A05, new C07607y(cause2));
            return false;
        }
    }
}
