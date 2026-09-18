package com.tapjoy.internal;

import com.tapjoy.TJAdUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class s7 implements Runnable {
    public final /* synthetic */ TJAdUnit a;

    public s7(TJAdUnit tJAdUnit) {
        this.a = tJAdUnit;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.i.getCurrentPosition() != 0) {
            TJAdUnit tJAdUnit = this.a;
            if (!tJAdUnit.m) {
                tJAdUnit.m = true;
            }
            tJAdUnit.e.onVideoStarted(tJAdUnit.k);
            this.a.F.run();
            return;
        }
        TJAdUnit tJAdUnit2 = this.a;
        if (tJAdUnit2.z) {
            tJAdUnit2.A = true;
        } else {
            tJAdUnit2.a.postDelayed(tJAdUnit2.E, 200L);
        }
    }
}
