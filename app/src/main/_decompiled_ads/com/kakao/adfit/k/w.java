package com.kakao.adfit.k;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PackageUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0003J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0016"}, d2 = {"Lcom/kakao/adfit/k/w;", "", "Landroid/content/Context;", "context", "", "packageName", "", "flags", "Landroid/content/pm/PackageInfo;", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "packageInfo", "c", "Landroid/content/pm/Signature;", InAppPurchaseMetaData.KEY_SIGNATURE, "algorithm", "", "bytes", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class w {
    public static final w a = new w();

    private w() {
    }

    public static /* synthetic */ PackageInfo a(Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(str, "context.packageName");
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return a(context, str, i);
    }

    @JvmStatic
    public static final String b(Context context) {
        String strC;
        Intrinsics.checkNotNullParameter(context, "context");
        PackageInfo packageInfoA = a(context, null, 0, 6, null);
        return (packageInfoA == null || (strC = c(packageInfoA)) == null) ? "unknown" : strC;
    }

    @JvmStatic
    public static final String c(PackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        String str = packageInfo.versionName;
        return str == null ? "unknown" : str;
    }

    @JvmStatic
    public static final boolean d(Context context, String packageName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            Object systemService = context.getSystemService("activity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                runningAppProcesses = CollectionsKt.emptyList();
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(packageName, it.next().processName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final PackageInfo a(Context context, String packageName, int flags) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            return context.getPackageManager().getPackageInfo(packageName, flags);
        } catch (Exception e) {
            f.e("Failed to get application package info. [package=" + packageName + "][error=" + e + ']');
            return null;
        }
    }

    @JvmStatic
    public static final String b(PackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        return Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
    }

    @JvmStatic
    public static final int c(Context context, String packageName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Signature signatureB = b(context, packageName);
        if (signatureB != null) {
            return signatureB.hashCode();
        }
        return 0;
    }

    @JvmStatic
    public static final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.applicationInfo");
            int i = applicationInfo.labelRes;
            if (i != 0) {
                String string = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
                return string;
            }
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            if (charSequence != null) {
                return charSequence.toString();
            }
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Exception e) {
            f.e("Failed to get application name. [error=" + e + ']');
            return "unknown";
        }
    }

    @JvmStatic
    public static final Signature b(Context context, String packageName) {
        Signature[] signatureArr;
        SigningInfo signingInfo;
        Signature[] apkContentsSigners;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo packageInfoA = a(context, packageName, 134217728);
            if (packageInfoA == null || (signingInfo = packageInfoA.signingInfo) == null || (apkContentsSigners = signingInfo.getApkContentsSigners()) == null) {
                return null;
            }
            return (Signature) ArraysKt.firstOrNull(apkContentsSigners);
        }
        PackageInfo packageInfoA2 = a(context, packageName, 64);
        if (packageInfoA2 == null || (signatureArr = packageInfoA2.signatures) == null) {
            return null;
        }
        return (Signature) ArraysKt.firstOrNull(signatureArr);
    }

    @JvmStatic
    public static final String a(PackageInfo packageInfo) {
        String string;
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        return (applicationInfo == null || (string = Integer.valueOf(applicationInfo.targetSdkVersion).toString()) == null) ? "unknown" : string;
    }

    @JvmStatic
    public static final String a(Signature signature, String algorithm) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            try {
                Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
                if (certificateGenerateCertificate != null) {
                    byte[] publicKey = MessageDigest.getInstance(algorithm).digest(((X509Certificate) certificateGenerateCertificate).getEncoded());
                    Intrinsics.checkNotNullExpressionValue(publicKey, "publicKey");
                    String strA = a(publicKey);
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                    return strA;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(byteArrayInputStream, th);
                    throw th2;
                }
            }
        } catch (Exception unused) {
            return "unknown";
        }
    }

    @JvmStatic
    private static final String a(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b2 : bytes) {
            String hexString = Integer.toHexString(b2);
            int length = hexString.length();
            if (length == 1) {
                sb.append('0').append(hexString);
            } else if (length == 2) {
                sb.append(hexString);
            } else if (length > 2) {
                sb.append((CharSequence) hexString, length - 2, length);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    @JvmStatic
    public static final String a(Context context, String packageName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(packageName);
            boolean z = false;
            if (installerPackageName != null) {
                if (installerPackageName.length() > 0) {
                    z = true;
                }
            }
            return z ? installerPackageName : "unknown";
        } catch (Exception e) {
            f.e("Failed to get application installer name. [package=" + packageName + "][error=" + e + ']');
            return "unknown";
        }
    }
}
