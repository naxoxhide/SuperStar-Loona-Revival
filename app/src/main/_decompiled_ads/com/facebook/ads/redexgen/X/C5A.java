package com.facebook.ads.redexgen.X;

import java.lang.reflect.Proxy;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5A {
    public static <T> T A00(T impl, Class<T> clazz) {
        ClassLoader classLoader = impl.getClass().getClassLoader();
        return clazz.cast(Proxy.newProxyInstance(classLoader, new Class[]{clazz}, new AnonymousClass59(impl, classLoader)));
    }
}
