package com.tapjoy.internal;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes4.dex */
public abstract class v6 {
    public static u6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f2826b;

    public static u6 a() {
        synchronized (v6.class) {
            u6 u6Var = a;
            if (u6Var == null) {
                return new u6();
            }
            a = u6Var.f;
            u6Var.f = null;
            f2826b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return u6Var;
        }
    }

    public static void a(u6 u6Var) {
        if (u6Var.f == null && u6Var.g == null) {
            if (u6Var.d) {
                return;
            }
            synchronized (v6.class) {
                long j = f2826b + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                if (j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                f2826b = j;
                u6Var.f = a;
                u6Var.c = 0;
                u6Var.f2820b = 0;
                a = u6Var;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
