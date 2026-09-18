package com.tapjoy.internal;

import android.content.Context;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public final class s3 extends p6 {
    public final m3 d;
    public final t3 e;
    public l1 f;

    public s3(Context context, m3 m3Var, t3 t3Var) {
        super(context);
        this.d = m3Var;
        this.e = t3Var;
        addView(t3Var, new ViewGroup.LayoutParams(-1, -1));
        this.f = null;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0071  */
    @Override // com.tapjoy.internal.p6, com.tapjoy.internal.c7, android.view.View
    public final void onMeasure(int i, int i2) {
        l1 l1Var;
        l1 l1Var2;
        l1 l1VarA = l1.a(getContext());
        m3 m3Var = this.d;
        l6 l6Var = m3Var.c;
        boolean z = true;
        if ((l6Var == null || m3Var.a == null || m3Var.e == null) ? false : true) {
            if ((l6Var == null || m3Var.f2782b == null || m3Var.f == null) ? false : true) {
                l1Var = l1.d;
                if (!(l1VarA == l1Var || l1VarA.a == l1Var)) {
                    l1 l1Var3 = l1.e;
                    if (l1VarA == l1Var3 || l1VarA.a == l1Var3) {
                        l1Var = l1Var3;
                    } else {
                        int i3 = getContext().getResources().getConfiguration().orientation;
                        if (i3 != 1) {
                            l1Var2 = i3 != 2 ? l1.c : l1Var3;
                        } else {
                            l1Var2 = l1Var;
                        }
                        if (!(l1Var2 == l1Var || l1Var2.a == l1Var)) {
                            l1Var = l1Var3;
                        }
                    }
                }
                setRotationCount(0);
            } else {
                l1Var = l1.d;
                l1 l1Var4 = l1.e;
                if (l1VarA == l1Var4 || l1VarA.a == l1Var4) {
                    if ((l1VarA.f2777b != null ? l1VarA.ordinal() - l1VarA.f2777b.ordinal() : 0) == 3) {
                        setRotationCount(1);
                    } else {
                        setRotationCount(3);
                    }
                } else {
                    setRotationCount(0);
                }
            }
        } else {
            l1Var = l1.e;
            l1 l1Var5 = l1.d;
            if (l1VarA == l1Var5 || l1VarA.a == l1Var5) {
                if ((l1VarA.f2777b != null ? l1VarA.ordinal() - l1VarA.f2777b.ordinal() : 0) == 3) {
                    setRotationCount(1);
                } else {
                    setRotationCount(1);
                }
            } else {
                setRotationCount(0);
            }
        }
        if (this.f != l1Var) {
            this.f = l1Var;
            t3 t3Var = this.e;
            l1 l1Var6 = l1.e;
            if (l1Var != l1Var6 && l1Var.a != l1Var6) {
                z = false;
            }
            t3Var.setLandscape(z);
        }
        super.onMeasure(i, i2);
    }
}
