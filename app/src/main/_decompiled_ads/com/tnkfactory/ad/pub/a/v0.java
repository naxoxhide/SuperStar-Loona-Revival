package com.tnkfactory.ad.pub.a;

/* JADX INFO: loaded from: classes4.dex */
public final class v0 implements Runnable {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0 f2893b;

    public v0(t0 t0Var, int i) {
        this.f2893b = t0Var;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t0 t0Var = this.f2893b;
        k1 k1VarA = t0Var.a(t0Var.getParent());
        if (k1VarA != null) {
            k1VarA.a();
        }
        t0 t0Var2 = this.f2893b;
        int i = this.a;
        j0 j0Var = t0Var2.c;
        if (j0Var != null) {
            j0Var.a(i);
        }
    }
}
