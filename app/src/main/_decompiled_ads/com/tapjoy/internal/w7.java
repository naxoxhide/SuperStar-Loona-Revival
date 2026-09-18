package com.tapjoy.internal;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class w7 extends WebChromeClient {
    public final /* synthetic */ TJAdUnit a;

    public w7(TJAdUnit tJAdUnit) {
        this.a = tJAdUnit;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        TJAdUnit tJAdUnit = this.a;
        TJAdUnitJSBridge tJAdUnitJSBridge = tJAdUnit.e;
        if (tJAdUnitJSBridge == null || !tJAdUnitJSBridge.closeRequested) {
            return true;
        }
        String[] strArr = {"Uncaught", "uncaught", "Error", "error", "not defined"};
        if (tJAdUnit.d == null) {
            return true;
        }
        for (int i = 0; i < 5; i++) {
            if (consoleMessage.message().contains(strArr[i])) {
                this.a.d.a(false);
                return true;
            }
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        TapjoyLog.d("TJAdUnit", str2);
        return false;
    }
}
