package com.igaworks.adpopcorn.a.e;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(Context context) {
        File[] fileArrListFiles;
        PackageManager packageManager = context.getPackageManager();
        try {
            if (a(packageManager, "com.androVM.vmconfig") || a(packageManager, "com.cyanogenmod.filemanager") || a(packageManager, "com.google.android.launcher.layouts.genymotion") || a(packageManager, "me.onemobile.android") || a(packageManager, "com.pop.store") || a(packageManager, "com.bluestacks.setup") || a(packageManager, "com.bluestacks.bstfolder") || a(packageManager, "com.bluestacks.BstCommandProcessor") || a(packageManager, "com.bluestacks.home") || a(packageManager, "org.greatfruit.andy") || a(packageManager, "org.greatfruit.andy.ime") || a(packageManager, "org.greatfruit.andy.appmonitor") || a(packageManager, "com.bignox.app.noxservice")) {
                return true;
            }
            File[] fileArr = {new File("/system/app", "/BstFolder.apk"), new File("/system/app", "/com.bluestacks.bstfolder.apk"), new File("/system/app", "/BstCommandProcessor.apk"), new File("/system/app", "/com.bluestacks.BstCommandProcessor.apk"), new File("/system/app", "/com.bluestacks.settings.apk"), new File("/system/priv-app", "/BstFolder.apk"), new File("/system/priv-app", "/com.bluestacks.bstfolder.apk"), new File("/system/priv-app", "/BstCommandProcessor.apk"), new File("/system/priv-app", "/com.bluestacks.BstCommandProcessor.apk"), new File("/system/priv-app", "/com.bluestacks.settings.apk"), new File("/system/app/ime.apk"), new File("/system/app/appmonitor.apk"), new File("/system/app/1clicksync.apk"), new File("/system/app/NoxService.apk")};
            for (int i = 0; i < 14; i++) {
                File file = fileArr[i];
                if (file != null && file.exists() && file.isFile()) {
                    return true;
                }
            }
            File file2 = new File("/system/priv-app");
            if (file2.exists() && (fileArrListFiles = file2.listFiles()) != null) {
                for (File file3 : fileArrListFiles) {
                    String path = file3.getPath();
                    if (path != null && (path.contains("/BstFolder.apk") || path.contains("/com.bluestacks.bstfolder.apk") || path.contains("/BstCommandProcessor.apk") || path.contains("/com.bluestacks.BstCommandProcessor.apk") || path.contains("/com.bluestacks.settings.apk"))) {
                        return true;
                    }
                }
            }
        } catch (SecurityException | Exception unused) {
        }
        return false;
    }

    private static boolean a(PackageManager packageManager, String str) {
        try {
            packageManager.getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
