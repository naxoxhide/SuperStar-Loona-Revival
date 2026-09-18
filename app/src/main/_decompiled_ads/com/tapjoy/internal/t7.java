package com.tapjoy.internal;

import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitJSBridge;

/* JADX INFO: loaded from: classes4.dex */
public final class t7 implements Runnable {
    public final /* synthetic */ TJAdUnit a;

    public t7(TJAdUnit tJAdUnit) {
        this.a = tJAdUnit;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJAdUnit tJAdUnit = this.a;
        TJAdUnitJSBridge tJAdUnitJSBridge = tJAdUnit.e;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.onVideoProgress(tJAdUnit.i.getCurrentPosition());
        }
        TJAdUnit tJAdUnit2 = this.a;
        tJAdUnit2.a.postDelayed(tJAdUnit2.F, 500L);
    }
}
