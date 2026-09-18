package com.tnkfactory.ad.pub.a;

/* JADX INFO: loaded from: classes4.dex */
public final class y implements Runnable {
    public final /* synthetic */ k0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.tnkfactory.ad.pub.b f2895b;

    public y(com.tnkfactory.ad.pub.b bVar, k0 k0Var) {
        this.f2895b = bVar;
        this.a = k0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2895b.b(this.a.f2873b);
    }
}
