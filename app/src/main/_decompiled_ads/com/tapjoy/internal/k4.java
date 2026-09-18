package com.tapjoy.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public final class k4 extends z6 {
    public k4(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    public final void a(long j) {
        this.a.edit().putLong(this.f2840b, j).apply();
    }

    public final long b() {
        return this.a.getLong(this.f2840b, 0L);
    }
}
