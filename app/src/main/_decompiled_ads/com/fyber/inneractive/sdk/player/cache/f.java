package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Runnable {
    public final /* synthetic */ h a;

    public f(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h hVar = this.a;
            c.f fVarB = hVar.f1010b.b(hVar.a());
            h hVar2 = this.a;
            hVar2.c = fVarB;
            if (fVarB == null) {
                c.C0277c c0277cA = hVar2.f1010b.a(hVar2.a());
                if (c0277cA == null) {
                    this.a.n = true;
                }
                if (c0277cA != null) {
                    h hVar3 = this.a;
                    IAlog.d("%s | start | got an editor for %s", hVar3.a, hVar3.a());
                    c0277cA.a();
                }
            }
        } catch (IOException e) {
            h hVar4 = this.a;
            IAlog.a(String.format("%s | Exception raised starting a new caching process for %s", hVar4.a, hVar4.a()), e, new Object[0]);
            t.a("Exception raised starting a new caching process", e.getMessage(), null, null);
        }
        h hVar5 = this.a;
        if (hVar5.c != null || hVar5.n) {
            h.b(hVar5, true);
            return;
        }
        h.f fVar = hVar5.h;
        if (fVar != null) {
            fVar.start();
        }
    }
}
