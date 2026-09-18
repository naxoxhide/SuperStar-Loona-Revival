package com.bytedance.sdk.openadsdk.o;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: compiled from: PlayableWebSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static void a(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            f.a("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    public static void b(WebView webView) {
        a(webView);
        WebSettings settings = webView.getSettings();
        a(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable th) {
            f.a("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            settings.setSupportZoom(false);
        } catch (Throwable th2) {
            f.a("WebViewSettings", "setSupportZoom error", th2);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setDisplayZoomControls(false);
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setSavePassword(false);
        boolean z = i >= 28;
        try {
            if (i < 11 || z) {
                if (i >= 16 && z) {
                    webView.setLayerType(2, null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    webView.getSettings().setMixedContentMode(0);
                }
            }
            webView.setLayerType(0, null);
        } catch (Throwable th3) {
            f.a("WebViewSettings", "setLayerType error", th3);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
    }

    private static void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            f.a("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
        }
    }
}
