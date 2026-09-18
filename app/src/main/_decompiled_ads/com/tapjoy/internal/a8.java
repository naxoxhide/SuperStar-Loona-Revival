package com.tapjoy.internal;

import com.tapjoy.TJTaskHandler;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class a8 implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJTaskHandler f2729b;
    public final /* synthetic */ com.tapjoy.c c;

    public a8(com.tapjoy.c cVar, String str, TJTaskHandler tJTaskHandler) {
        this.c = cVar;
        this.a = str;
        this.f2729b = tJTaskHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.a.i == null) {
            this.f2729b.onComplete(Boolean.FALSE);
            return;
        }
        TapjoyLog.i("TJAdUnit", "loadVideoUrl: " + this.a);
        this.c.a.i.setVideoPath(this.a);
        this.c.a.i.setVisibility(0);
        this.c.a.i.seekTo(0);
        this.f2729b.onComplete(Boolean.TRUE);
    }
}
