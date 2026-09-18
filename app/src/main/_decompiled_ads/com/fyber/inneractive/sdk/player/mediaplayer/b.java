package com.fyber.inneractive.sdk.player.mediaplayer;

import com.fyber.inneractive.sdk.player.controller.g;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Runnable {
    public final /* synthetic */ com.fyber.inneractive.sdk.player.enums.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f1262b;

    public b(a aVar, com.fyber.inneractive.sdk.player.enums.b bVar) {
        this.f1262b = aVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.k kVar = this.f1262b.i;
        if (kVar != null) {
            ((g) kVar).a(this.a);
        }
    }
}
