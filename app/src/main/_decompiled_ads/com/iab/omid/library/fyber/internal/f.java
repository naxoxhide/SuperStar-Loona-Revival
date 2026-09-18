package com.iab.omid.library.fyber.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static f f1444b = new f();
    private Context a;

    private f() {
    }

    public static f b() {
        return f1444b;
    }

    public Context a() {
        return this.a;
    }

    public void a(Context context) {
        this.a = context != null ? context.getApplicationContext() : null;
    }
}
