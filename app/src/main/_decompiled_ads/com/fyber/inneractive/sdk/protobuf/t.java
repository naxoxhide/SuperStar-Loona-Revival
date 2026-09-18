package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    public static final r<?> a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r<?> f1308b;

    static {
        r<?> rVar;
        try {
            rVar = (r) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            rVar = null;
        }
        f1308b = rVar;
    }
}
