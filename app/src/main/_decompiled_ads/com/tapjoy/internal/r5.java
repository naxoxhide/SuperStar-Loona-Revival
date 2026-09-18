package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class r5 extends u5 {
    public r5() {
        super(1, Long.class);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        w5Var.c(((Long) obj).longValue());
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        return w5.a(((Long) obj).longValue());
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) {
        return Long.valueOf(v5Var.h());
    }
}
