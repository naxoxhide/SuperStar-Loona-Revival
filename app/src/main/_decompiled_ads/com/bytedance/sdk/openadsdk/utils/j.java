package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: InitChecker.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    /* JADX WARN: Code duplicated, block: B:38:0x0096 A[Catch: all -> 0x00c1, TRY_LEAVE, TryCatch #0 {all -> 0x00c1, blocks: (B:35:0x008e, B:38:0x0096), top: B:46:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c9  */
    public static void a() {
        int i;
        Context contextA = com.bytedance.sdk.openadsdk.core.o.a();
        if (contextA != null && com.bytedance.sdk.component.utils.m.c()) {
            com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "The pangolin sdk access, the environment is debug, the initial configuration detection starts");
            String packageName = contextA.getPackageName();
            int i2 = contextA.getApplicationInfo().targetSdkVersion;
            boolean z = false;
            boolean z2 = true;
            try {
                String[] strArr = contextA.getPackageManager().getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr == null || strArr.length <= 0) {
                    com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "The uses-permission configuration in AndroidManifest.xml is missing, please refer to the access documentation");
                } else {
                    List<String> listB = b();
                    for (String str : strArr) {
                        if (str != null) {
                            listB.remove(str);
                        }
                    }
                    if (listB.isEmpty()) {
                        com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "AndroidManifest.xml permissions configuration is normal");
                    } else {
                        Iterator<String> it = listB.iterator();
                        while (it.hasNext()) {
                            try {
                                com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "    May be missing permissions：" + it.next() + "，Please refer to the access documentation");
                                z2 = false;
                            } catch (Throwable th) {
                                th = th;
                                com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "The usage-permission configuration error in AndroidManifest.xml, please refer to the access documentation", th);
                                z2 = z;
                                i = Build.VERSION.SDK_INT;
                                if (i >= 23) {
                                    com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "No adaptation required for dynamic permissions：target=" + i2 + "&phone=" + i + ", require=23");
                                } else {
                                    com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "No adaptation required for dynamic permissions：target=" + i2 + "&phone=" + i + ", require=23");
                                }
                                if (!z2) {
                                    com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "You have not configured permission, please refer to the access documentation, otherwise it will affect the conversion");
                                }
                                com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "End of pangolin sdk initial configuration test");
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                i = Build.VERSION.SDK_INT;
                if (i >= 23 || i2 < 23) {
                    com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "No adaptation required for dynamic permissions：target=" + i2 + "&phone=" + i + ", require=23");
                }
            } catch (Throwable th3) {
                com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "The dynamic permission is abnormal. Please check and read the access document in detail： ", th3);
            }
            if (!z2) {
                com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "You have not configured permission, please refer to the access documentation, otherwise it will affect the conversion");
            }
            com.bytedance.sdk.component.utils.m.b("TTAdSdk-InitChecker", "End of pangolin sdk initial configuration test");
        }
    }

    private static List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }
}
