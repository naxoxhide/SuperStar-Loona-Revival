package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class y implements Runnable {
    public final /* synthetic */ long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f939b;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z zVar = y.this.f939b;
            zVar.e(!zVar.u);
            y.this.f939b.o = null;
        }
    }

    public y(z zVar, long j) {
        this.f939b = zVar;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f939b.J()) {
            z zVar = this.f939b;
            zVar.o = new a();
            long jA = zVar.a(this.a);
            z zVar2 = this.f939b;
            zVar2.getClass();
            u0 u0Var = new u0(TimeUnit.MILLISECONDS, jA);
            zVar2.p = u0Var;
            u0Var.e = new a0(zVar2);
            u0Var.c();
            z zVar3 = this.f939b;
            zVar3.getClass();
            IAlog.a("%sad contains custom close. Will show transparent x in %d", IAlog.a(zVar3), Long.valueOf(jA));
            this.f939b.m = null;
        } else {
            z zVar4 = this.f939b;
            zVar4.getClass();
            IAlog.a("%sad does not contain custom close. Showing close button", IAlog.a(zVar4));
            this.f939b.e(false);
        }
        Runnable runnable = this.f939b.m;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.m.f1343b.removeCallbacks(runnable);
            this.f939b.m = null;
        }
    }
}
