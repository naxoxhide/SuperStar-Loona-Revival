package com.kakao.adfit.k;

import android.content.Context;

/* JADX INFO: compiled from: PermissionUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public static boolean a(Context context) {
        boolean z;
        if (a(context, "android.permission.INTERNET")) {
            z = true;
        } else {
            f.b("android.permission.INTERNET permission must be added in AndroidManifest.xml!");
            z = false;
        }
        if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return z;
        }
        f.b("android.permission.ACCESS_NETWORK_STATE permission must be added in AndroidManifest.xml!");
        return false;
    }

    public static boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }
}
