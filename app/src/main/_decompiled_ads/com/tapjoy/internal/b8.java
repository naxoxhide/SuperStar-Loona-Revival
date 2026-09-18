package com.tapjoy.internal;

import com.tapjoy.TJAdUnit;
import com.tapjoy.TJTaskHandler;

/* JADX INFO: loaded from: classes4.dex */
public final class b8 implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJTaskHandler f2733b;
    public final /* synthetic */ com.tapjoy.c c;

    public b8(com.tapjoy.c cVar, boolean z, TJTaskHandler tJTaskHandler) {
        this.c = cVar;
        this.a = z;
        this.f2733b = tJTaskHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.i.setVisibility(this.a ? 0 : 4);
        this.c.a.i.stopPlayback();
        TJAdUnit tJAdUnit = this.c.a;
        tJAdUnit.m = false;
        tJAdUnit.l = false;
        tJAdUnit.k = 0;
        this.f2733b.onComplete(Boolean.TRUE);
    }
}
