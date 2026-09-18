package com.tapjoy.internal;

import android.content.Context;
import android.webkit.WebView;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TJJSBridgeDelegate;

/* JADX INFO: loaded from: classes4.dex */
public final class x8 extends TJJSBridgeDelegate {
    public final /* synthetic */ TJEventOptimizer a;

    public x8(TJEventOptimizer tJEventOptimizer) {
        this.a = tJEventOptimizer;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final Context getContext() {
        return this.a.a;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final WebView getWebView() {
        return this.a;
    }
}
