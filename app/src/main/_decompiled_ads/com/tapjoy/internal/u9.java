package com.tapjoy.internal;

import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TJWebViewActivity;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class u9 implements Runnable {
    public final /* synthetic */ TJWebViewActivity a;

    public u9(TJWebViewActivity tJWebViewActivity) {
        this.a = tJWebViewActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.a.h;
        if (tJAdUnitJSBridge == null || !tJAdUnitJSBridge.closeRequested) {
            return;
        }
        TapjoyLog.d("TJWebViewActivity", "Did not receive callback from content. Closing ad.");
        this.a.finish();
    }
}
