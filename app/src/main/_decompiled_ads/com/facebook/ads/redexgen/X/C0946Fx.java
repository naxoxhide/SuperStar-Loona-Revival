package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0946Fx implements InterfaceC1548bb {
    public final /* synthetic */ C1547ba A00;

    public C0946Fx(C1547ba c1547ba) {
        this.A00 = c1547ba;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1548bb
    public final void ACr() {
        ArrayList arrayList;
        synchronized (this.A00.A06) {
            arrayList = new ArrayList(this.A00.A06.size());
            for (Runnable runnable : this.A00.A06.values()) {
                if (runnable != null) {
                    arrayList.add(runnable);
                }
            }
            this.A00.A06.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        if (this.A00.A01 == null) {
            return;
        }
        this.A00.A01.ACr();
    }
}
