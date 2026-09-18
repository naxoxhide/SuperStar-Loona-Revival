package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class j5 extends u5 {
    public j5() {
        super(2, Double.class);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        w5Var.b(Double.doubleToLongBits(((Double) obj).doubleValue()));
    }

    @Override // com.tapjoy.internal.u5
    public final /* bridge */ /* synthetic */ int a(Object obj) {
        return 8;
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) {
        return Double.valueOf(Double.longBitsToDouble(v5Var.f()));
    }
}
