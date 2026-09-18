package com.tapjoy.internal;

import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitJSBridge;

/* JADX INFO: loaded from: classes4.dex */
public final class u7 implements Runnable {
    public final /* synthetic */ TJAdUnit a;

    public u7(TJAdUnit tJAdUnit) {
        this.a = tJAdUnit;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.a.e;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.onVideoError("MEDIA_ERROR_TIMED_OUT");
        }
    }
}
