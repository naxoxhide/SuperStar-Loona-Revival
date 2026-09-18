package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f1279b;

    public static boolean a() {
        return (a == null || f1279b) ? false : true;
    }

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f1279b = cls2 != null;
    }
}
