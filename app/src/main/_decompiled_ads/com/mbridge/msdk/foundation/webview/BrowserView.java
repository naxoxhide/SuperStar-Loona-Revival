package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class BrowserView extends LinearLayout {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ProgressBar f2231b;
    private WebView c;
    private ToolBar d;
    private a e;
    private CampaignEx f;

    public interface a {
        void a();

        void a(WebView webView, int i, String str, String str2);

        void a(WebView webView, String str);

        void a(WebView webView, String str, Bitmap bitmap);

        boolean b(WebView webView, String str);

        void c(WebView webView, String str);
    }

    public BrowserView(Context context, CampaignEx campaignEx) {
        super(context);
        this.f = campaignEx;
        init();
    }

    public BrowserView(Context context) {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setListener(a aVar) {
        this.e = aVar;
    }

    public void loadUrl(String str) {
        WebView webView = this.c;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setWebView(WebView webView) {
        this.c = webView;
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f2231b = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.c == null) {
                this.c = a();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.c.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            aa.b("BrowserView", "webview is error", th);
        }
        this.d = new ToolBar(getContext());
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, af.b(getContext(), 40.0f)));
        this.d.setBackgroundColor(-1);
        addView(this.f2231b);
        WebView webView = this.c;
        if (webView != null) {
            addView(webView);
        }
        addView(this.d);
        this.f2231b.initResource(true);
        this.d.getItem("backward").setEnabled(false);
        this.d.getItem("forward").setEnabled(false);
        this.d.setOnItemClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BrowserView.this.c != null) {
                    BrowserView.this.c.stopLoading();
                }
                String str = (String) view.getTag();
                boolean z = false;
                if (TextUtils.equals(str, "backward")) {
                    BrowserView.this.d.getItem("forward").setEnabled(true);
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoBack()) {
                        BrowserView.this.c.goBack();
                    }
                    View item = BrowserView.this.d.getItem("backward");
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoBack()) {
                        z = true;
                    }
                    item.setEnabled(z);
                    return;
                }
                if (TextUtils.equals(str, "forward")) {
                    BrowserView.this.d.getItem("backward").setEnabled(true);
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoForward()) {
                        BrowserView.this.c.goForward();
                    }
                    View item2 = BrowserView.this.d.getItem("forward");
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoForward()) {
                        z = true;
                    }
                    item2.setEnabled(z);
                    return;
                }
                if (TextUtils.equals(str, "refresh")) {
                    BrowserView.this.d.getItem("backward").setEnabled(BrowserView.this.c != null && BrowserView.this.c.canGoBack());
                    View item3 = BrowserView.this.d.getItem("forward");
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoForward()) {
                        z = true;
                    }
                    item3.setEnabled(z);
                    if (BrowserView.this.c != null) {
                        BrowserView.this.c.loadUrl(BrowserView.this.a);
                        return;
                    }
                    return;
                }
                if (!TextUtils.equals(str, "exits") || BrowserView.this.e == null) {
                    return;
                }
                BrowserView.this.e.a();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0055 A[Catch: all -> 0x00b0, TryCatch #0 {all -> 0x00b0, blocks: (B:3:0x000b, B:10:0x004f, B:12:0x0055, B:13:0x0058, B:14:0x005e, B:16:0x0064, B:20:0x0070, B:21:0x008a, B:24:0x00a8, B:19:0x0069, B:9:0x0048, B:6:0x0043), top: B:34:0x000b, inners: #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0064 A[Catch: Exception -> 0x0068, all -> 0x00b0, TRY_LEAVE, TryCatch #2 {Exception -> 0x0068, blocks: (B:14:0x005e, B:16:0x0064), top: B:37:0x005e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0070 A[Catch: all -> 0x00b0, TRY_LEAVE, TryCatch #0 {all -> 0x00b0, blocks: (B:3:0x000b, B:10:0x004f, B:12:0x0055, B:13:0x0058, B:14:0x005e, B:16:0x0064, B:20:0x0070, B:21:0x008a, B:24:0x00a8, B:19:0x0069, B:9:0x0048, B:6:0x0043), top: B:34:0x000b, inners: #1, #2, #3 }] */
    private WebView a() {
        WebChromeClient webChromeClient;
        WebView webView = new WebView(getContext());
        try {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(5242880L);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    settings.setSafeBrowsingEnabled(false);
                } catch (Throwable th) {
                    aa.d("BrowserView", th.getMessage());
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    settings.setMediaPlaybackRequiresUserGesture(false);
                }
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        settings.setMixedContentMode(0);
                        settings.setDatabaseEnabled(true);
                        String path = getContext().getDir("database", 0).getPath();
                        settings.setDatabasePath(path);
                        settings.setGeolocationEnabled(true);
                        settings.setGeolocationDatabasePath(path);
                        try {
                            Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(settings, false);
                        } catch (Exception e) {
                            aa.d("BrowserView", e.getMessage());
                        }
                    } else {
                        settings.setDatabaseEnabled(true);
                        String path2 = getContext().getDir("database", 0).getPath();
                        settings.setDatabasePath(path2);
                        settings.setGeolocationEnabled(true);
                        settings.setGeolocationDatabasePath(path2);
                        Method declaredMethod2 = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(settings, false);
                    }
                } catch (Exception e2) {
                    aa.d("BrowserView", e2.getMessage());
                }
            } else {
                if (Build.VERSION.SDK_INT >= 17) {
                    settings.setMediaPlaybackRequiresUserGesture(false);
                }
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                    settings.setDatabaseEnabled(true);
                    String path3 = getContext().getDir("database", 0).getPath();
                    settings.setDatabasePath(path3);
                    settings.setGeolocationEnabled(true);
                    settings.setGeolocationDatabasePath(path3);
                    Method declaredMethod3 = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                    declaredMethod3.setAccessible(true);
                    declaredMethod3.invoke(settings, false);
                } else {
                    settings.setDatabaseEnabled(true);
                    String path4 = getContext().getDir("database", 0).getPath();
                    settings.setDatabasePath(path4);
                    settings.setGeolocationEnabled(true);
                    settings.setGeolocationDatabasePath(path4);
                    Method declaredMethod4 = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                    declaredMethod4.setAccessible(true);
                    declaredMethod4.invoke(settings, false);
                }
            }
        } catch (Throwable th2) {
            aa.d("BrowserView", th2.getMessage());
        }
        webView.setDownloadListener(new MBDownloadListener(this.f));
        webView.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.2
            @Override // android.webkit.WebViewClient
            public final void onLoadResource(WebView webView2, String str) {
                super.onLoadResource(webView2, str);
                aa.b("BrowserView", "onLoadResource 开始! = " + str);
                if (BrowserView.this.e != null) {
                    BrowserView.this.e.a(webView2, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                aa.b("BrowserView", "开始! = " + str);
                BrowserView.this.a = str;
                if (BrowserView.this.e != null) {
                    BrowserView.this.e.a(webView2, str, bitmap);
                }
                BrowserView.this.f2231b.setVisible(true);
                BrowserView.this.f2231b.setProgressState(5);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                aa.b("BrowserView", "js大跳! = " + str);
                BrowserView.this.d.getItem("backward").setEnabled(true);
                BrowserView.this.d.getItem("forward").setEnabled(false);
                if (BrowserView.this.e != null) {
                    BrowserView.this.e.b(webView2, str);
                }
                return false;
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str) {
                if (BrowserView.this.e != null) {
                    BrowserView.this.e.c(webView2, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i, String str, String str2) {
                if (BrowserView.this.e != null) {
                    BrowserView.this.e.a(webView2, i, str, str2);
                }
            }
        });
        if (w.o() <= 10) {
            webChromeClient = new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3
                @Override // android.webkit.WebChromeClient
                public final boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsConfirm(WebView webView2, String str, String str2, JsResult jsResult) {
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView2, int i) {
                    if (i == 100) {
                        BrowserView.this.f2231b.setProgressState(7);
                        new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                BrowserView.this.f2231b.setVisible(false);
                            }
                        }, 200L);
                    }
                }
            };
        } else {
            webChromeClient = new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4
                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView2, int i) {
                    if (i == 100) {
                        BrowserView.this.f2231b.setProgressState(7);
                        new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                BrowserView.this.f2231b.setVisible(false);
                            }
                        }, 200L);
                    }
                }
            };
        }
        webView.setWebChromeClient(webChromeClient);
        return webView;
    }

    public static final class MBDownloadListener implements DownloadListener {
        private CampaignEx campaignEx;
        private String title;

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        }

        public MBDownloadListener(CampaignEx campaignEx) {
            this.campaignEx = campaignEx;
        }

        public MBDownloadListener() {
        }

        public final void setTitle(String str) {
            this.title = str;
        }
    }

    public void destroy() {
        WebView webView = this.c;
        if (webView != null) {
            webView.stopLoading();
            this.c.setWebViewClient(null);
            this.c.destroy();
            this.c = null;
            removeAllViews();
        }
    }
}
