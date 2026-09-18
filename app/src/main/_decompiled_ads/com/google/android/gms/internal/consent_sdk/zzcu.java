package com.google.android.gms.internal.consent_sdk;

import android.os.Build;
import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@2.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcu {
    private static Boolean zza;

    private zzcu() {
    }

    public static void zza(WebView webView, String str) {
        boolean zBooleanValue;
        if (Build.VERSION.SDK_INT >= 19) {
            synchronized (zzcu.class) {
                if (zza == null) {
                    try {
                        webView.evaluateJavascript("(function(){})()", null);
                        zza = true;
                    } catch (IllegalStateException unused) {
                        zza = false;
                    }
                }
                zBooleanValue = zza.booleanValue();
            }
            if (zBooleanValue) {
                webView.evaluateJavascript(str, null);
                return;
            }
        }
        webView.loadUrl("javascript:".concat(str));
    }
}
