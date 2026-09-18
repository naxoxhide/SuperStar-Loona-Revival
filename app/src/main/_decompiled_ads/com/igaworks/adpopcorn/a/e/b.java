package com.igaworks.adpopcorn.a.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static boolean a() {
        try {
            String str = Build.TAGS;
            return str != null && str.contains("test-keys");
        } catch (Exception unused) {
        }
    }

    private static boolean a(Context context) {
        File[] fileArr = {new File("/system/bin/su"), new File("/system/xbin/su"), new File("/system/app/SuperUser.apk"), new File("/sbin/su"), new File("/data/local/bin/su"), new File("/system/sd/xbin/su"), new File("/system/app/Superuser.apk"), new File("/system/su"), new File("/system/bin/.ext/.su"), new File("/system/usr/we-need-root/su-backup"), new File("/system/xbin/mu"), new File("data/data/com.noshufou.android.su")};
        for (int i = 0; i < 12; i++) {
            File file = fileArr[i];
            if (file != null && file.exists() && file.isFile()) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String[] strArr = {"com.noshufou.android.su", "com.speedsoftware.rootexplorer", "com.tegrak.lagfix", "com.devadvance.rootcloakplus", "com.devadvance.rootcloak", "eu.chainfire.supersu", "com.thirdparty.superuser", "com.koushikdutta.superuser", "com.zachspong.temprootremovejb", "com.ramdroid.appquarantine", "com.cyanogenmod.filemanager"};
        for (int i = 0; i < 11; i++) {
            try {
                packageManager.getApplicationInfo(strArr[i], 128);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        boolean zA = a(context);
        if (!zA) {
            zA = b(context);
        }
        return !zA ? a() : zA;
    }
}
