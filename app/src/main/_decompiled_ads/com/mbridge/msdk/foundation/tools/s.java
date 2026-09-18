package com.mbridge.msdk.foundation.tools;

import android.net.ConnectivityManager;

/* JADX INFO: compiled from: NetManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s {
    private static ConnectivityManager a;

    public static synchronized ConnectivityManager a() {
        try {
            if (a == null && com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                a = (ConnectivityManager) com.mbridge.msdk.foundation.controller.b.d().g().getSystemService("connectivity");
            }
        } catch (Exception e) {
            aa.d("NetManager", e.getMessage());
        }
        return a;
    }
}
