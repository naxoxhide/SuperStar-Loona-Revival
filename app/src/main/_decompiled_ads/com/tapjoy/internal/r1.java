package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public enum r1 implements xa {
    APP(0),
    CAMPAIGN(1),
    CUSTOM(2),
    USAGES(3);

    public final int a;

    static {
        new u5() { // from class: com.tapjoy.internal.q1
            @Override // com.tapjoy.internal.u5
            public final void a(w5 w5Var, Object obj) {
                w5Var.c(((r1) ((xa) obj)).a);
            }

            @Override // com.tapjoy.internal.u5
            public final int a(Object obj) {
                return w5.a(((r1) ((xa) obj)).a);
            }

            @Override // com.tapjoy.internal.u5
            public final Object a(v5 v5Var) {
                r1 r1Var;
                int iG = v5Var.g();
                if (iG == 0) {
                    r1Var = r1.APP;
                } else if (iG == 1) {
                    r1Var = r1.CAMPAIGN;
                } else if (iG != 2) {
                    r1Var = iG != 3 ? null : r1.USAGES;
                } else {
                    r1Var = r1.CUSTOM;
                }
                if (r1Var != null) {
                    return r1Var;
                }
                throw new t5(iG, this.f2819b);
            }
        };
    }

    r1(int i) {
        this.a = i;
    }
}
