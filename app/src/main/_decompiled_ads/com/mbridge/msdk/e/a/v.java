package com.mbridge.msdk.e.a;

import android.util.Log;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: VolleyLog.java */
/* JADX INFO: loaded from: classes4.dex */
public class v {
    public static String a = "TrackManager_Volley";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2034b = "com.mbridge.msdk.e.a.v";

    public static void a(String str, Object... objArr) {
    }

    public static void b(String str, Object... objArr) {
        Log.d(a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(a, d(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(a, d(str, objArr), th);
    }

    private static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClassName().equals(f2034b)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
            }
        }
        str2 = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    /* JADX INFO: compiled from: VolleyLog.java */
    static class a {
        private final List<C0476a> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2035b;

        /* JADX INFO: renamed from: com.mbridge.msdk.e.a.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VolleyLog.java */
        private static class C0476a {
            public final String a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f2036b;
            public final long c;
        }

        protected final void finalize() throws Throwable {
            long j;
            if (this.f2035b) {
                return;
            }
            this.f2035b = true;
            if (this.a.size() == 0) {
                j = 0;
            } else {
                long j2 = this.a.get(0).c;
                List<C0476a> list = this.a;
                j = list.get(list.size() - 1).c - j2;
            }
            if (j > 0) {
                long j3 = this.a.get(0).c;
                v.b("(%-4d ms) %s", Long.valueOf(j), "Request on the loose");
                for (C0476a c0476a : this.a) {
                    long j4 = c0476a.c;
                    v.b("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(c0476a.f2036b), c0476a.a);
                    j3 = j4;
                }
            }
            v.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
