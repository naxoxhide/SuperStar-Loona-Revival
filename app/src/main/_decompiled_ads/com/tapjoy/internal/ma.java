package com.tapjoy.internal;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
public final class ma {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2784b;

    static {
        new ma(-1L);
    }

    public ma(long j) {
        this.a = j;
        this.f2784b = SystemClock.elapsedRealtime();
    }

    public ma() {
        this.a = 3600000L;
        try {
            this.f2784b = SystemClock.elapsedRealtime() - 3600000;
        } catch (NullPointerException unused) {
            this.f2784b = -1L;
        }
    }
}
