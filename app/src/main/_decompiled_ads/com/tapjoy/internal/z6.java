package com.tapjoy.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z6 {
    public final SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2840b;

    public z6(SharedPreferences sharedPreferences, String str) {
        this.a = sharedPreferences;
        this.f2840b = str;
    }

    public final void a() {
        this.a.edit().remove(this.f2840b).apply();
    }
}
