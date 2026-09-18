package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 {
    public static final t0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f1312b;

    static {
        t0 t0Var;
        try {
            t0Var = (t0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            t0Var = null;
        }
        a = t0Var;
        f1312b = new u0();
    }
}
