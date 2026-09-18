package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class o5 extends u5 {
    public o5() {
        super(1, Integer.class);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        if (iIntValue >= 0) {
            w5Var.c(iIntValue);
        } else {
            w5Var.c(iIntValue);
        }
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        if (iIntValue >= 0) {
            return w5.a(iIntValue);
        }
        return 10;
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) {
        return Integer.valueOf(v5Var.g());
    }
}
