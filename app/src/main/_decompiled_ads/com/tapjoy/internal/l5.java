package com.tapjoy.internal;

import java.io.EOFException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes4.dex */
public final class l5 extends u5 {
    public l5() {
        super(3, g0.class);
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) throws ProtocolException, EOFException {
        long jA = v5Var.a();
        b0 b0Var = (b0) v5Var.a;
        b0Var.getClass();
        return new g0(b0Var.a(jA));
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        w5Var.a((g0) obj);
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        return ((g0) obj).b();
    }
}
