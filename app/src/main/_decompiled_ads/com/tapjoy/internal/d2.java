package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class d2 implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g2 f2740b;

    public d2(g2 g2Var, String str) {
        this.f2740b = g2Var;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2740b.a.a(this.a);
    }
}
