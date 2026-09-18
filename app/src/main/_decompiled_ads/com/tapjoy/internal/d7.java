package com.tapjoy.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class d7 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (na.a) {
            e7.f2750b.countDown();
            return;
        }
        f7 f7Var = new f7();
        boolean z = true;
        if (f7Var.a((int) 20000)) {
            long j = f7Var.a;
            long j2 = f7Var.f2756b;
            long j3 = f7Var.c / 2;
            synchronized (na.class) {
                na.a = true;
                na.f2788b = j;
                na.c = j2;
                na.d = na.f2788b - na.c;
                na.a();
                System.currentTimeMillis();
            }
        } else {
            z = false;
        }
        if (z) {
            e7.f2750b.countDown();
        } else {
            e7.a.schedule(this, 300L, TimeUnit.SECONDS);
        }
    }
}
