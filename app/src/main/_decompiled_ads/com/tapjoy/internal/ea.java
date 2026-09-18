package com.tapjoy.internal;

import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes4.dex */
public final class ea implements Observer {
    public final /* synthetic */ aa a;

    public ea(aa aaVar) {
        this.a = aaVar;
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        aa aaVar;
        ga gaVar;
        k3.f2775b.deleteObserver(this);
        if (Boolean.valueOf(Boolean.TRUE.equals(obj)).booleanValue() || (gaVar = (aaVar = this.a).g) == null || gaVar.a == null) {
            return;
        }
        aaVar.e = new ja(aaVar);
        new Thread(this.a.e).start();
    }
}
