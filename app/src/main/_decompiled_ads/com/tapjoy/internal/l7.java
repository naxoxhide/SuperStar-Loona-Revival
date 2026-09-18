package com.tapjoy.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public final class l7 extends z6 {
    public l7(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    public final void a(String str) {
        this.a.edit().putString(this.f2840b, str).apply();
    }

    public final String b() {
        return this.a.getString(this.f2840b, null);
    }
}
