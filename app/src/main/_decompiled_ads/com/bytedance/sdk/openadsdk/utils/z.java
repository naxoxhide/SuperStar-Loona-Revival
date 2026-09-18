package com.bytedance.sdk.openadsdk.utils;

import android.os.SystemClock;

/* JADX INFO: compiled from: TimeStamp.java */
/* JADX INFO: loaded from: classes2.dex */
public class z {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f836b;

    private z(boolean z) {
        if (z) {
            e();
        }
    }

    public static z a() {
        return new z(false);
    }

    public static z c() {
        return new z(true);
    }

    public boolean b() {
        return this.f836b > 0;
    }

    public long d() {
        return SystemClock.elapsedRealtime() - this.f836b;
    }

    public void e() {
        this.a = System.currentTimeMillis();
        this.f836b = SystemClock.elapsedRealtime();
    }

    public String toString() {
        return String.valueOf(this.a);
    }

    public long a(z zVar) {
        return Math.abs(zVar.f836b - this.f836b);
    }
}
