package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

/* JADX INFO: compiled from: TestHelperUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class x {
    private static String a;

    public static String a(String str) {
        try {
            if (!b()) {
                return str;
            }
            String strB = com.bytedance.sdk.openadsdk.core.h.a().b();
            if (TextUtils.isEmpty(strB)) {
                return str;
            }
            Log.d("TestHelperUtils", "AnyDoorId=" + strB);
            return Uri.parse(str).buildUpon().appendQueryParameter(a(), strB).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean b() {
        return com.bytedance.sdk.component.utils.m.c() && com.bytedance.sdk.openadsdk.core.h.a().p() && com.bytedance.sdk.openadsdk.core.h.a().q();
    }

    public static boolean c() {
        return false;
    }

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return a;
    }
}
