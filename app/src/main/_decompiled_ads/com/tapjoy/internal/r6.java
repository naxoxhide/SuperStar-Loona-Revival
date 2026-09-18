package com.tapjoy.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class r6 extends Thread {
    public final /* synthetic */ Map a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s6 f2808b;

    public r6(s6 s6Var, HashMap map) {
        this.f2808b = s6Var;
        this.a = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        this.f2808b.e.getResponseFromURL(this.f2808b.a + this.f2808b.d, (Map<String, String>) null, (Map<String, String>) null, this.a);
    }
}
