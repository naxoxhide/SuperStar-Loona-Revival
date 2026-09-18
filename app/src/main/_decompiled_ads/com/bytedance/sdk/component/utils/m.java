package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f328b = 4;
    private static b.b.a.a.a c = null;
    private static String d = "";

    public static void a(int i) {
        f328b = i;
    }

    public static boolean b() {
        return f328b <= 3;
    }

    public static boolean c() {
        return a;
    }

    public static void d(String str) {
        d = str;
    }

    public static void e(String str, String str2) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.c(c(str), str2);
        }
        if (a && str2 != null && f328b <= 2) {
            Log.v(c(str), str2);
        }
    }

    public static void f(String str, String str2) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.d(c(str), str2);
        }
        if (a && str2 != null && f328b <= 5) {
            Log.w(c(str), str2);
        }
    }

    public static void a() {
        a = false;
        a(7);
    }

    public static void b(String str) {
        if (a) {
            b("Logger", str);
        }
    }

    public static void c(String str, Object... objArr) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.a(c(str), a(objArr));
        }
        if (a && objArr != null && f328b <= 4) {
            Log.i(c(str), a(objArr));
        }
    }

    public static void d() {
        a = true;
        a(3);
    }

    public static void a(String str) {
        if (a) {
            a("Logger", str);
        }
    }

    public static void d(String str, String str2) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.a(c(str), str2);
        }
        if (a && str2 != null && f328b <= 4) {
            Log.i(c(str), str2);
        }
    }

    public static void b(String str, String str2) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.b(c(str), str2);
        }
        if (a && str2 != null && f328b <= 6) {
            Log.e(c(str), str2);
        }
    }

    public static void a(String str, String str2) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.e(c(str), str2);
        }
        if (a && str2 != null && f328b <= 3) {
            Log.d(c(str), str2);
        }
    }

    public static void e(String str) {
        if (a) {
            f("Logger", str);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.a(c(str), str2, th);
        }
        if (a) {
            if (!(str2 == null && th == null) && f328b <= 5) {
                Log.w(c(str), str2, th);
            }
        }
    }

    public static void d(String str, Object... objArr) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.d(c(str), a(objArr));
        }
        if (a && objArr != null && f328b <= 5) {
            Log.w(c(str), a(objArr));
        }
    }

    public static void b(String str, String str2, Throwable th) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.b(c(str), str2, th);
        }
        if (a) {
            if (!(str2 == null && th == null) && f328b <= 6) {
                Log.e(c(str), str2, th);
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.e(c(str), str2 + Log.getStackTraceString(th));
        }
        if (a) {
            if (!(str2 == null && th == null) && f328b <= 3) {
                Log.d(c(str), str2, th);
            }
        }
    }

    public static String c(String str) {
        return TextUtils.isEmpty(d) ? str : a("[" + d + "]-[" + str + "]");
    }

    public static void b(String str, Object... objArr) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.b(c(str), a(objArr));
        }
        if (a && objArr != null && f328b <= 6) {
            Log.e(c(str), a(objArr));
        }
    }

    public static String c(String str, String str2) {
        return TextUtils.isEmpty(d) ? str : a(str2 + "]-[" + str);
    }

    public static void a(String str, Object... objArr) {
        b.b.a.a.a aVar = c;
        if (aVar != null) {
            aVar.e(c(str), a(objArr));
        }
        if (a && objArr != null && f328b <= 3) {
            Log.d(c(str), a(objArr));
        }
    }

    public static void a(String str, String str2, String str3, Throwable th) {
        if (a) {
            b(c(str, str2), str3, th);
        }
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
