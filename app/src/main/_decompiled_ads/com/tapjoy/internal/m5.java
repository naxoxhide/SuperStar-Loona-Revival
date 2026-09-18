package com.tapjoy.internal;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class m5 extends u5 {
    public final /* synthetic */ u5 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m5(u5 u5Var, int i) {
        super(i, List.class);
        this.m = u5Var;
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, int i, Object obj) {
        List list = (List) obj;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.m.a(w5Var, i, list.get(i2));
        }
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.tapjoy.internal.u5
    public final int a(int i, Object obj) {
        List list = (List) obj;
        int size = list.size();
        int iA = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iA += this.m.a(i, list.get(i2));
        }
        return iA;
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) {
        return Collections.singletonList(this.m.a(v5Var));
    }
}
