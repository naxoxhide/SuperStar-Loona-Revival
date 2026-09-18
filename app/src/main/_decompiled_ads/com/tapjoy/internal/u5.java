package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u5 {
    public static final n5 d = new n5();
    public static final o5 e = new o5();
    public static final p5 f = new p5();
    public static final q5 g = new q5();
    public static final r5 h = new r5();
    public static final s5 i = new s5();
    public static final j5 j = new j5();
    public static final k5 k = new k5();
    public static final l5 l = new l5();
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f2819b;
    public m5 c;

    public u5(int i2, Class cls) {
        this.a = i2;
        this.f2819b = cls;
    }

    public int a(int i2, Object obj) {
        int iA = a(obj);
        if (this.a == 3) {
            iA += w5.a(iA);
        }
        return w5.a((i2 << 3) | 0) + iA;
    }

    public abstract int a(Object obj);

    public abstract Object a(v5 v5Var);

    public abstract void a(w5 w5Var, Object obj);

    public void a(w5 w5Var, int i2, Object obj) {
        int i3 = this.a;
        w5Var.getClass();
        w5Var.c((i2 << 3) | s1.b(i3));
        if (this.a == 3) {
            w5Var.c(a(obj));
        }
        a(w5Var, obj);
    }

    public final u5 a() {
        m5 m5Var = this.c;
        if (m5Var != null) {
            return m5Var;
        }
        m5 m5Var2 = new m5(this, this.a);
        this.c = m5Var2;
        return m5Var2;
    }
}
