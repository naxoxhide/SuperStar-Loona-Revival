package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.logger.FMPLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class IAlog {
    public static int a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.fyber.inneractive.sdk.logger.a f1329b = new com.fyber.inneractive.sdk.logger.a();
    public static final List<FMPLogger> c = new a();

    public class a extends CopyOnWriteArrayList<FMPLogger> {
        public a() {
            add(IAlog.f1329b);
        }
    }

    public static void b(String str, Object... objArr) {
        Iterator it = ((CopyOnWriteArrayList) c).iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).error(str, null, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        Iterator it = ((CopyOnWriteArrayList) c).iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).info(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        Iterator it = ((CopyOnWriteArrayList) c).iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).verbose(str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        Iterator it = ((CopyOnWriteArrayList) c).iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).warning(str, objArr);
        }
    }

    public static void a(String str, Object... objArr) {
        Iterator it = ((CopyOnWriteArrayList) c).iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).debug(str, objArr);
        }
    }

    public static void a(String str, Throwable th, Object... objArr) {
        Iterator it = ((CopyOnWriteArrayList) c).iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).error(str, th, objArr);
        }
    }

    public static void a(int i, Exception exc, String str, Object... objArr) {
        Iterator it = ((CopyOnWriteArrayList) c).iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).log(i, null, str, objArr);
        }
    }

    public static String a(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(Thread.currentThread().getName()).append("): ").append(obj.getClass().getSimpleName()).append("[").append(Integer.toHexString(System.identityHashCode(obj))).append("] ");
        return sb.toString();
    }

    public static String a(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(Thread.currentThread().getName()).append("): ").append(cls.getSimpleName()).append("[").append(Integer.toHexString(System.identityHashCode(cls))).append("] ");
        return sb.toString();
    }
}
