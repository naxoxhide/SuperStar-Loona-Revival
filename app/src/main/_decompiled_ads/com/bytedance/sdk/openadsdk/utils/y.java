package com.bytedance.sdk.openadsdk.utils;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: ThreadUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {
    public static ExecutorService a() {
        return b.b.a.a.k.e.c();
    }

    public static void b(b.b.a.a.k.g gVar) {
        b.b.a.a.k.e.d(gVar);
    }

    public static ExecutorService c() {
        return b.b.a.a.k.e.e();
    }

    public static ExecutorService d() {
        return b.b.a.a.k.e.f();
    }

    public static ScheduledExecutorService e() {
        return b.b.a.a.k.e.h();
    }

    public static boolean f() {
        return "csj_log".equals(Thread.currentThread().getName());
    }

    public static boolean g() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (g()) {
            runnable.run();
        } else {
            com.bytedance.sdk.openadsdk.core.l.c().post(runnable);
        }
    }

    public static ExecutorService b() {
        return b.b.a.a.k.e.d();
    }

    public static void c(b.b.a.a.k.g gVar) {
        b.b.a.a.k.e.c(gVar);
    }

    public static void d(b.b.a.a.k.g gVar) {
        if (gVar == null) {
            return;
        }
        b.b.a.a.k.e.e(gVar);
    }

    public static void b(b.b.a.a.k.g gVar, int i) {
        if (gVar == null) {
            return;
        }
        b.b.a.a.k.e.a(gVar, 5, i);
    }

    public static void c(b.b.a.a.k.g gVar, int i) {
        if (gVar == null) {
            return;
        }
        b.b.a.a.k.e.c(gVar, i);
    }

    public static void a(b.b.a.a.k.g gVar) {
        if (gVar == null) {
            return;
        }
        b.b.a.a.k.e.a(gVar);
    }

    public static void a(b.b.a.a.k.g gVar, int i) {
        if (gVar == null) {
            return;
        }
        b.b.a.a.k.e.a(gVar, i);
    }
}
