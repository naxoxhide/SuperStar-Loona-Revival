package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class f2 implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2754b;
    public final /* synthetic */ a c;
    public final /* synthetic */ g2 d;

    public f2(g2 g2Var, String str, String str2, a aVar) {
        this.d = g2Var;
        this.a = str;
        this.f2754b = str2;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a.a(this.a, this.f2754b, this.c);
    }
}
