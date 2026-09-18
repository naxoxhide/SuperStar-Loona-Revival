package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: TempSPUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, w> f835b = new HashMap();
    private SharedPreferences a;

    private w(String str, Context context) {
        if (context != null) {
            this.a = context.getSharedPreferences(str, 0);
        }
    }

    public static w a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        w wVar = f835b.get(str);
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(str, context);
        f835b.put(str, wVar2);
        return wVar2;
    }

    public String a(String str, String str2) {
        try {
            return this.a.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void a(String str) {
        try {
            this.a.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
