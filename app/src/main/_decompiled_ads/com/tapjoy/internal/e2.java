package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class e2 implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f2748b;
    public final /* synthetic */ g2 c;

    public e2(g2 g2Var, String str, a aVar) {
        this.c = g2Var;
        this.a = str;
        this.f2748b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.a(this.a, this.f2748b);
    }
}
