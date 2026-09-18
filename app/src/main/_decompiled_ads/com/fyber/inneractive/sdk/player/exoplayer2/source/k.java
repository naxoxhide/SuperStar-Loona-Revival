package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.u;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class k implements Runnable {
    public final /* synthetic */ IOException a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f1188b;

    public k(i iVar, IOException iOException) {
        this.f1188b = iVar;
        this.a = iOException;
    }

    @Override // java.lang.Runnable
    public void run() {
        l.a aVar = this.f1188b.e;
        IOException iOException = this.a;
        com.fyber.inneractive.sdk.player.controller.d dVar = ((u) aVar).a.get();
        if (dVar != null && (iOException.getCause() instanceof com.fyber.inneractive.sdk.player.cache.h.g) && dVar.B) {
            dVar.a(dVar.E, dVar.D);
        }
    }
}
