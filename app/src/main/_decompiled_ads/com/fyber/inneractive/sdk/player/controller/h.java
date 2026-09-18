package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f1022b;

    public h(g gVar, boolean z) {
        this.f1022b = gVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar = this.f1022b;
        if (gVar.g) {
            return;
        }
        try {
            Iterator<g.f> it = gVar.f1018b.iterator();
            while (it.hasNext()) {
                it.next().e(this.a);
            }
        } catch (Exception e) {
            if (IAlog.a <= 3) {
                g gVar2 = this.f1022b;
                gVar2.getClass();
                IAlog.a("%sonPlayerError callback threw an exception!", e, IAlog.a(gVar2));
            }
        }
    }
}
