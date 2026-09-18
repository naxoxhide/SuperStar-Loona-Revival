package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class b9 implements Runnable {
    public final /* synthetic */ com.tapjoy.w a;

    public b9(com.tapjoy.w wVar) {
        this.a = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.c.contentReady();
    }
}
