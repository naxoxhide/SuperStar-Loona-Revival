package com.tapjoy.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class n5 extends u5 {
    public n5() {
        super(1, Boolean.class);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        w5Var.c(((Boolean) obj).booleanValue() ? 1 : 0);
    }

    @Override // com.tapjoy.internal.u5
    public final /* bridge */ /* synthetic */ int a(Object obj) {
        return 1;
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) throws IOException {
        int iG = v5Var.g();
        if (iG == 0) {
            return Boolean.FALSE;
        }
        if (iG == 1) {
            return Boolean.TRUE;
        }
        throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(iG)));
    }
}
