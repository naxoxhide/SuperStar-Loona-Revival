package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.webkit.WebView;

/* JADX INFO: compiled from: LoadUrlUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    private static final b a;

    /* JADX INFO: compiled from: LoadUrlUtils.java */
    private static class b {
        private b() {
        }

        public void a(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: LoadUrlUtils.java */
    private static class c extends b {
        private c() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.l.b
        public void a(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            boolean z = false;
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    z = true;
                } catch (Throwable th) {
                    boolean z2 = th instanceof IllegalStateException;
                }
            }
            if (z) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static void a(WebView webView, String str) {
        a.a(webView, str);
    }
}
