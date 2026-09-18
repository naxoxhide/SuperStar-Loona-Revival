package com.tapjoy.internal;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
public final class x6 implements Runnable {
    public final /* synthetic */ y6 a;

    public x6(y6 y6Var) {
        this.a = y6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.f2834b.compareAndSet(true, false)) {
            p1 p1Var = this.a.a;
            p1Var.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime() - p1Var.c;
            d3 d3Var = p1Var.a;
            synchronized (d3Var) {
                long jB = d3Var.e.i.b() + jElapsedRealtime;
                d3Var.e.i.a(jB);
                d3Var.c.i = Long.valueOf(jB);
            }
            n1 n1VarA = p1Var.a(r1.APP, "session");
            p1Var.a(n1VarA);
            p1Var.c = 0L;
            p1Var.a.a(n1VarA.e.longValue(), jElapsedRealtime);
            k3.d.notifyObservers();
        }
    }
}
