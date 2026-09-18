package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {
    public static final j0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j0 f1299b;

    static {
        j0 j0Var;
        try {
            j0Var = (j0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            j0Var = null;
        }
        a = j0Var;
        f1299b = new k0();
    }
}
