package b.a.a.a.a.a.a.i;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: VLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f26b = 4;
    private static String c = "";

    public static void a(int i) {
        f26b = i;
    }

    public static boolean b() {
        return a;
    }

    public static void c(String str) {
        c = str;
    }

    public static void a() {
        a = false;
        a(7);
    }

    public static void b(String str) {
        if (a) {
            c("Logger", str);
        }
    }

    public static void c() {
        a = true;
        a(3);
    }

    public static void a(String str, String str2) {
        if (a && str2 != null && f26b <= 3) {
            Log.d(a(str), str2);
        }
    }

    public static void c(String str, String str2) {
        if (a && str2 != null && f26b <= 4) {
            Log.i(a(str), str2);
        }
    }

    public static void b(String str, Object... objArr) {
        if (a && objArr != null && f26b <= 4) {
            Log.v(a(str), a(objArr));
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            if (!(str2 == null && th == null) && f26b <= 3) {
                Log.d(a(str), str2, th);
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (a) {
            if (!(str2 == null && th == null) && f26b <= 4) {
                Log.i(a(str), str2, th);
            }
        }
    }

    public static void b(String str, String str2) {
        if (a && str2 != null && f26b <= 6) {
            Log.e(a(str), str2);
        }
    }

    public static void a(String str, Object... objArr) {
        if (a && objArr != null && f26b <= 3) {
            Log.v(a(str), a(objArr));
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (a) {
            if (!(str2 == null && th == null) && f26b <= 6) {
                Log.e(a(str), str2, th);
            }
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

    private static String a(String str) {
        return TextUtils.isEmpty(c) ? str : a("[" + c + "]-[" + str + "]");
    }
}
