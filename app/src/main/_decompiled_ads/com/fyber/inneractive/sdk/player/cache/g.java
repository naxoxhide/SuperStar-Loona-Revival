package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Runnable {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        h.f fVar;
        boolean z2 = true;
        try {
            h hVar = this.a;
            if (hVar.c == null) {
                this.a.c = hVar.f1010b.b(hVar.a());
            }
            h hVar2 = this.a;
            if (hVar2.c == null) {
                c.C0277c c0277cA = hVar2.f1010b.a(hVar2.a());
                z = c0277cA == null;
                if (c0277cA != null) {
                    try {
                        c0277cA.a();
                        h hVar3 = this.a;
                        if (hVar3.c == null && (fVar = hVar3.h) != null) {
                            fVar.start();
                            return;
                        }
                    } catch (IOException e) {
                        e = e;
                        h hVar4 = this.a;
                        IAlog.a(String.format("%s | Exception raised waiting on availbility for %s", hVar4.a, hVar4.a()), e, new Object[0]);
                    }
                }
            } else {
                z = false;
            }
        } catch (IOException e2) {
            e = e2;
            z = false;
        }
        if (z) {
            h.b(this.a, false);
            return;
        }
        h.c(this.a, true);
        this.a.o = false;
        h hVar5 = this.a;
        String strA = hVar5.a();
        h hVar6 = this.a;
        hVar5.f = new a(strA, hVar6.e, hVar6.f1010b.a(hVar6.a(), 0), false, this.a.l);
        synchronized (this.a.f.d) {
            File file = this.a.f.a;
            if (file == null || !file.exists()) {
                z2 = false;
            }
            if (z2) {
                h hVar7 = this.a;
                hVar7.d.a(hVar7.f, hVar7.l);
                h hVar8 = this.a;
                hVar8.f.e.putAll(hVar8.d.a);
                h hVar9 = this.a;
                hVar9.a(hVar9.f);
                this.a.b();
            } else {
                h.b(this.a, false);
            }
        }
    }
}
