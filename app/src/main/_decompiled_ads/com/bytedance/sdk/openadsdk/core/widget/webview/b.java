package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.m;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SSWebSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private final WeakReference<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f706b = true;
    private boolean c = true;

    private b(Context context) {
        this.a = new WeakReference<>(context);
    }

    public static b a(Context context) {
        return new b(context);
    }

    public b b(boolean z) {
        this.f706b = z;
        return this;
    }

    public static void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            m.b(th.toString());
        }
    }

    public b a(boolean z) {
        this.c = z;
        return this;
    }

    public void a(WebView webView) {
        if (webView == null || this.a.get() == null) {
            return;
        }
        b(webView);
        WebSettings settings = webView.getSettings();
        a(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            m.b("SSWebSettings", e.getMessage());
        }
        try {
            if (this.f706b) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            m.b("SSWebSettings", th.getMessage());
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setSavePassword(false);
        try {
            if (this.c) {
                webView.setLayerType(2, null);
            } else {
                webView.setLayerType(0, null);
            }
        } catch (Throwable th2) {
            m.b("SSWebSettings", th2.getMessage());
        }
    }

    private void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            m.b(th.toString());
        }
    }
}
