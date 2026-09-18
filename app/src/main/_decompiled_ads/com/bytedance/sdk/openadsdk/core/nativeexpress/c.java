package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.os.Build;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BrandBannerWebViewPool.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f653b;
    private static volatile c c;
    private final List<DspHtmlWebView> a = new ArrayList();

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public DspHtmlWebView a() {
        DspHtmlWebView dspHtmlWebViewRemove;
        if (b() > 0 && (dspHtmlWebViewRemove = this.a.remove(0)) != null) {
            return dspHtmlWebViewRemove;
        }
        return null;
    }

    public void b(DspHtmlWebView dspHtmlWebView) {
        if (dspHtmlWebView != null) {
            a(dspHtmlWebView);
        }
    }

    public int b() {
        return this.a.size();
    }

    public void a(DspHtmlWebView dspHtmlWebView) {
        if (dspHtmlWebView != null) {
            if (this.a.size() >= f653b) {
                dspHtmlWebView.g();
            } else {
                if (this.a.contains(dspHtmlWebView)) {
                    return;
                }
                c(dspHtmlWebView);
                this.a.add(dspHtmlWebView);
            }
        }
    }

    public void c(DspHtmlWebView dspHtmlWebView) {
        if (dspHtmlWebView == null || dspHtmlWebView.getWebView() == null) {
            return;
        }
        if (dspHtmlWebView.getParent() != null) {
            ((ViewGroup) dspHtmlWebView.getParent()).removeView(dspHtmlWebView);
        }
        try {
            dspHtmlWebView.removeAllViews();
            dspHtmlWebView.u();
            dspHtmlWebView.setWebChromeClient(null);
            dspHtmlWebView.setWebViewClient(null);
            dspHtmlWebView.setDownloadListener(null);
            dspHtmlWebView.setDefaultTextEncodingName("UTF-8");
            dspHtmlWebView.setAllowFileAccess(false);
            dspHtmlWebView.setJavaScriptEnabled(true);
            dspHtmlWebView.setAppCacheEnabled(true);
            dspHtmlWebView.setDatabaseEnabled(true);
            dspHtmlWebView.setSupportZoom(false);
            dspHtmlWebView.getWebView().setLayerType(0, null);
            dspHtmlWebView.setBackgroundColor(0);
            dspHtmlWebView.getWebView().setHorizontalScrollBarEnabled(false);
            dspHtmlWebView.getWebView().setHorizontalScrollbarOverlay(false);
            dspHtmlWebView.getWebView().setVerticalScrollBarEnabled(false);
            dspHtmlWebView.getWebView().setVerticalScrollbarOverlay(false);
            dspHtmlWebView.a(true);
            dspHtmlWebView.e();
            if (Build.VERSION.SDK_INT >= 21) {
                dspHtmlWebView.setMixedContentMode(0);
            }
        } catch (Exception unused) {
        }
    }
}
