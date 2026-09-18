package com.tapjoy.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class q6 extends Thread {
    public final /* synthetic */ Map a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s6 f2803b;

    public q6(s6 s6Var, HashMap map) {
        this.f2803b = s6Var;
        this.a = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        this.f2803b.e.getResponseFromURL(this.f2803b.a + this.f2803b.c, (Map<String, String>) null, (Map<String, String>) null, this.a);
    }
}
