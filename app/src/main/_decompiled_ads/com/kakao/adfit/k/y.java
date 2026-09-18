package com.kakao.adfit.k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: RootChecker.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {
    private static volatile boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f1837b;

    private static boolean a(Context context) {
        return c() || b() || a() || b(context);
    }

    private static boolean b() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"};
        for (int i = 0; i < 12; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        if (SystemClock.elapsedRealtime() > f1837b) {
            a = a(context);
            f1837b = SystemClock.elapsedRealtime() + 86400000;
        }
        return a;
    }

    private static boolean a() {
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", DownloadCommon.DOWNLOAD_REPORT_SUCCESS});
            try {
                boolean z = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null;
                processExec.destroy();
                return z;
            } catch (Throwable unused) {
                if (processExec != null) {
                    processExec.destroy();
                }
                return false;
            }
        } catch (Throwable unused2) {
            processExec = null;
        }
    }

    private static boolean c() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean b(Context context) {
        String[] strArr = {"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"};
        PackageManager packageManager = context.getPackageManager();
        for (int i = 0; i < 6; i++) {
            try {
                packageManager.getPackageInfo(strArr[i], 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }
}
