package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: IdUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f630b;
    private static String c;
    private static boolean d;
    private static boolean e;

    public static String a(Context context) {
        if (f630b == null && !d) {
            synchronized (j.class) {
                if (!d) {
                    e(context);
                }
            }
        }
        return f630b;
    }

    private static Context b(Context context) {
        return context == null ? o.a() : context;
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (TextUtils.isEmpty(a) && !e) {
            synchronized (j.class) {
                if (!e) {
                    f(context);
                }
            }
        }
        try {
            if (TextUtils.isEmpty(a) && com.bytedance.sdk.openadsdk.m.b.b()) {
                a = c.a(b(context)).a("did", (String) null);
            }
        } catch (Exception unused) {
        }
        return a;
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(c) && !d) {
            synchronized (j.class) {
                if (!d) {
                    e(context);
                }
            }
        }
        return c;
    }

    private static void e(Context context) {
        Context contextB;
        if (d || (contextB = b(context)) == null) {
            return;
        }
        a();
        f630b = String.valueOf(Build.TIME);
        c = c.a(contextB).a("uuid", (String) null);
        d = true;
    }

    private static void f(Context context) {
        Context contextB;
        if (e || (contextB = b(context)) == null) {
            return;
        }
        a = c.a(contextB).a("did", (String) null);
        e = true;
    }

    public static String b() {
        try {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
            String language = locale != null ? locale.getLanguage() : "";
            if (locale == null || !"zh".equals(language)) {
                return language;
            }
            String string = locale.toString();
            if (locale.toString().length() >= 5) {
                string = string.substring(0, 5);
            }
            return Locale.SIMPLIFIED_CHINESE.toString().equals(string) ? "zh" : "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(a)) {
            c.a(context).b("did", str);
            a = str;
        }
        if (TextUtils.isEmpty(a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.g0.c.a(a);
    }

    private static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.sdk.openadsdk.utils.r.w()) {
                sb.append("MIUI-");
            } else if (com.bytedance.sdk.openadsdk.utils.r.s()) {
                sb.append("FLYME-");
            } else {
                String strH = com.bytedance.sdk.openadsdk.utils.r.h();
                if (com.bytedance.sdk.openadsdk.utils.r.d(strH)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strH)) {
                    sb.append(strH).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
