package com.kakao.adfit.common.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: VolleyLog.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static String a = "AdFitNet";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1727b = Log.isLoggable("AdFitNet", 2);
    private static final String c = h.class.getName();

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(a, a(str, objArr), th);
    }

    public static void b(String str, Object... objArr) {
        Log.d(a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(a, a(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        if (f1727b) {
            Log.v(a, a(str, objArr));
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClassName().equals(c)) {
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
        public static final boolean c = h.f1727b;
        private final List<C0449a> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1728b = false;

        /* JADX INFO: renamed from: com.kakao.adfit.common.volley.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VolleyLog.java */
        private static class C0449a {
            public final String a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f1729b;
            public final long c;

            public C0449a(String str, long j, long j2) {
                this.a = str;
                this.f1729b = j;
                this.c = j2;
            }
        }

        a() {
        }

        public synchronized void a(String str, long j) {
            if (this.f1728b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.a.add(new C0449a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() {
            if (this.f1728b) {
                return;
            }
            a("Request on the loose");
            h.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void a(String str) {
            this.f1728b = true;
            long jA = a();
            if (jA <= 0) {
                return;
            }
            long j = this.a.get(0).c;
            h.b("(%-4d ms) %s", Long.valueOf(jA), str);
            for (C0449a c0449a : this.a) {
                long j2 = c0449a.c;
                h.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0449a.f1729b), c0449a.a);
                j = j2;
            }
        }

        private long a() {
            if (this.a.size() == 0) {
                return 0L;
            }
            long j = this.a.get(0).c;
            List<C0449a> list = this.a;
            return list.get(list.size() - 1).c - j;
        }
    }
}
