package com.tapjoy.internal;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q4 implements Serializable {
    public final transient g0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f2802b = 0;

    public q4(u5 u5Var, g0 g0Var) {
        Objects.requireNonNull(g0Var, "unknownFields == null");
        this.a = g0Var;
    }

    public final g0 a() {
        g0 g0Var = this.a;
        return g0Var != null ? g0Var : g0.e;
    }
}
