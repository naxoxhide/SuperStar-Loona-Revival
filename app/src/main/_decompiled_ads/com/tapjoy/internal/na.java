package com.tapjoy.internal;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
public abstract class na {
    public static volatile boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f2788b;
    public static volatile long c;
    public static volatile long d;

    static {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (na.class) {
            a = false;
            f2788b = jCurrentTimeMillis;
            c = jElapsedRealtime;
            d = f2788b - c;
            a();
            System.currentTimeMillis();
        }
    }

    public static long a() {
        return SystemClock.elapsedRealtime() + d;
    }
}
