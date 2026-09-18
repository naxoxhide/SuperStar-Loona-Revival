package com.tapjoy.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 extends z6 {
    public a0(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    public final void a(boolean z) {
        this.a.edit().putBoolean(this.f2840b, z).apply();
    }
}
