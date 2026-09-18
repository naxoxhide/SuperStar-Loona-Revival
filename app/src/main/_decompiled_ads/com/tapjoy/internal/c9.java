package com.tapjoy.internal;

import com.tapjoy.TJError;

/* JADX INFO: loaded from: classes4.dex */
public final class c9 implements Runnable {
    public final /* synthetic */ TJError a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.tapjoy.w f2738b;

    public c9(com.tapjoy.w wVar, TJError tJError) {
        this.f2738b = wVar;
        this.a = tJError;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2738b.a.c.contentError(this.a);
    }
}
