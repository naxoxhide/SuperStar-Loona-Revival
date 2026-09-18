package com.tapjoy.internal;

import android.os.Handler;

/* JADX INFO: loaded from: classes4.dex */
public class g2 implements a2 {
    public static final b2 c = new b2();
    public final a2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u3 f2758b;

    public g2() {
        this.a = null;
        this.f2758b = null;
    }

    public static g2 a(z1 z1Var) {
        if (!(z1Var instanceof g2)) {
            return z1Var != null ? new g2(z1Var) : c;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.tapjoy.internal.a2
    public void b(String str) {
        this.f2758b.a(new c2(this, str));
    }

    public g2(z1 z1Var) {
        this.a = z1Var;
        Handler handlerA = w2.a();
        if (handlerA != null) {
            this.f2758b = w2.a(handlerA);
            handlerA.getLooper();
        } else if (Thread.currentThread() == h.a()) {
            this.f2758b = h.c;
        } else {
            this.f2758b = w2.a(w2.b());
        }
    }

    @Override // com.tapjoy.internal.a2
    public void a(String str) {
        this.f2758b.a(new d2(this, str));
    }

    @Override // com.tapjoy.internal.a2
    public void a(String str, a aVar) {
        this.f2758b.a(new e2(this, str, aVar));
    }

    @Override // com.tapjoy.internal.a2
    public void a(String str, String str2, a aVar) {
        this.f2758b.a(new f2(this, str, str2, aVar));
    }
}
