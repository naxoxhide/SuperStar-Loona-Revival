package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {
    public static final z0 c = new z0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<Class<?>, d1<?>> f1316b = new ConcurrentHashMap();
    public final e1 a = new g0();

    public <T> d1<T> a(Class<T> cls) {
        d1<T> d1VarA;
        Class<?> cls2;
        Charset charset = y.a;
        Objects.requireNonNull(cls, "messageType");
        d1<T> d1Var = (d1) this.f1316b.get(cls);
        if (d1Var != null) {
            return d1Var;
        }
        g0 g0Var = (g0) this.a;
        g0Var.getClass();
        Class<?> cls3 = f1.a;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f1.a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        m0 m0VarB = g0Var.a.b(cls);
        if (!m0VarB.c()) {
            if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                if (m0VarB.a() == y0.PROTO2) {
                    t0 t0Var = v0.f1312b;
                    e0 e0Var = e0.f1281b;
                    k1<?, ?> k1Var = f1.d;
                    r<?> rVar = t.a;
                    d1VarA = r0.a(m0VarB, t0Var, e0Var, k1Var, t.a, l0.f1299b);
                } else {
                    d1VarA = r0.a(m0VarB, v0.f1312b, e0.f1281b, f1.d, (r) null, l0.f1299b);
                }
            } else {
                if (m0VarB.a() == y0.PROTO2) {
                    t0 t0Var2 = v0.a;
                    e0 e0Var2 = e0.a;
                    k1<?, ?> k1Var2 = f1.f1284b;
                    r<?> rVar2 = t.f1308b;
                    if (rVar2 == null) {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                    d1VarA = r0.a(m0VarB, t0Var2, e0Var2, k1Var2, rVar2, l0.a);
                } else {
                    d1VarA = r0.a(m0VarB, v0.a, e0.a, f1.c, (r) null, l0.a);
                }
            }
        } else if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            k1<?, ?> k1Var3 = f1.d;
            r<?> rVar3 = t.a;
            d1VarA = new s0(k1Var3, t.a, m0VarB.b());
        } else {
            k1<?, ?> k1Var4 = f1.f1284b;
            r<?> rVar4 = t.f1308b;
            if (rVar4 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            d1VarA = new s0(k1Var4, rVar4, m0VarB.b());
        }
        d1<T> d1Var2 = (d1) this.f1316b.putIfAbsent(cls, d1VarA);
        return d1Var2 != null ? d1Var2 : d1VarA;
    }
}
