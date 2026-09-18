package com.tapjoy.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public final class h3 extends z6 {
    public final int c;

    public h3(SharedPreferences sharedPreferences, String str, int i) {
        super(sharedPreferences, str);
        this.c = i;
    }

    public final void a(int i) {
        this.a.edit().putInt(this.f2840b, i).apply();
    }

    public final int b() {
        return this.a.getInt(this.f2840b, this.c);
    }
}
