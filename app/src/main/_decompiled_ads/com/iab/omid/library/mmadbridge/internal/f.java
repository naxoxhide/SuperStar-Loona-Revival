package com.iab.omid.library.mmadbridge.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f f1468b = new f();
    private Context a;

    private f() {
    }

    public static f b() {
        return f1468b;
    }

    public Context a() {
        return this.a;
    }

    public void a(Context context) {
        this.a = context != null ? context.getApplicationContext() : null;
    }
}
