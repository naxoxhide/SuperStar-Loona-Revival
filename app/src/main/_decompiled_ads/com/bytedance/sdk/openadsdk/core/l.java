package com.bytedance.sdk.openadsdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: InitHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static volatile boolean a = false;
    private static volatile HandlerThread g;
    public static long i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f640b = new AtomicBoolean(false);
    public static long c = 0;
    private static long d = 10000;
    private static volatile int e = 0;
    public static float f = 1.0f;
    private static volatile Handler h = null;

    /* JADX INFO: compiled from: InitHelper.java */
    static class a extends b.b.a.a.k.g {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strD = com.bytedance.sdk.openadsdk.core.settings.n.d(o.a());
                if ((TextUtils.isEmpty(strD) && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.n.p)) || !strD.equals(com.bytedance.sdk.openadsdk.core.settings.n.p)) {
                    com.bytedance.sdk.openadsdk.core.settings.n.j0().a(6, true);
                    com.bytedance.sdk.openadsdk.core.settings.n.p = strD;
                }
            } catch (Throwable unused) {
            }
        }
    }

    static {
        g = null;
        g = new HandlerThread("csj_init_handle", 10);
        g.start();
        i = System.currentTimeMillis();
    }

    public static void a(long j) {
        i = j;
    }

    public static int b() {
        return e;
    }

    public static Handler c() {
        return new Handler(Looper.getMainLooper());
    }

    public static long d() {
        return i;
    }

    public static boolean e() {
        return b() == 1;
    }

    public static void f() {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - c <= d) {
                return;
            }
            c = jElapsedRealtime;
            com.bytedance.sdk.openadsdk.utils.y.b(new a("onSharedPreferenceChanged"));
        } catch (Throwable unused) {
        }
    }

    public static Handler a() {
        if (g == null || !g.isAlive()) {
            synchronized (l.class) {
                if (g == null || !g.isAlive()) {
                    g = new HandlerThread("csj_init_handle", -1);
                    g.start();
                    h = new Handler(g.getLooper());
                }
            }
        } else if (h == null) {
            synchronized (l.class) {
                if (h == null) {
                    h = new Handler(g.getLooper());
                }
            }
        }
        return h;
    }

    public static void a(int i2) {
        e = i2;
    }
}
