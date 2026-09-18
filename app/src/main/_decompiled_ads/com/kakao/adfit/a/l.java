package com.kakao.adfit.a;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.ProxyConfig;
import com.kakao.adfit.common.inappbrowser.activity.IABActivity;
import com.kakao.adfit.k.a0;
import com.kakao.adfit.k.y;
import com.kakao.adfit.k.z;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AdWebView.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends WebView {
    private final AtomicBoolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f1673b;
    private int c;
    private int d;
    private final DisplayMetrics e;
    private Display f;
    private f g;
    private e h;
    private d i;
    private g j;

    /* JADX INFO: compiled from: AdWebView.java */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0 && action != 1) {
                return false;
            }
            try {
                if (view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: AdWebView.java */
    private static final class b extends WebChromeClient {

        /* JADX INFO: compiled from: AdWebView.java */
        class a implements DialogInterface.OnClickListener {
            final /* synthetic */ JsResult a;

            a(JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.confirm();
            }
        }

        private b() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            try {
                new AlertDialog.Builder(webView.getContext()).setTitle(str).setMessage(str2).setPositiveButton(R.string.ok, new a(jsResult)).setCancelable(false).show();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                com.kakao.adfit.k.f.a("Contents has been loaded");
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AdWebView.java */
    private class c extends WebViewClient {
        private final Handler a = new Handler(Looper.getMainLooper());

        /* JADX INFO: compiled from: AdWebView.java */
        class a implements Runnable {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.kakao.adfit.k.f.a("Timeout: URL = " + this.a);
                if (l.this.h != null) {
                    l.this.h.a(this.a);
                }
            }
        }

        c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            com.kakao.adfit.k.f.d("onPageFinished: " + str);
            this.a.removeCallbacksAndMessages(null);
            webView.requestLayout();
            webView.invalidate();
            l.this.a.set(true);
            if (l.this.g != null) {
                l.this.g.a(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            com.kakao.adfit.k.f.d("onPageStarted: " + str);
            this.a.removeCallbacksAndMessages(null);
            this.a.postDelayed(new a(str), 30000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            com.kakao.adfit.k.f.a("Error: " + i + ", " + str);
            this.a.removeCallbacksAndMessages(null);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            com.kakao.adfit.k.f.a("WebView's render process has exited");
            if (l.this.j == null) {
                return true;
            }
            l.this.j.a();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String string;
            if (str.startsWith(ProxyConfig.MATCH_HTTP) && str.contains("analytics.ad.daum.net")) {
                string = Uri.parse(str).buildUpon().appendQueryParameter(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, webView.isShown() ? "F" : "B").appendQueryParameter(CampaignEx.JSON_KEY_AD_R, y.c(webView.getContext()) ? "R" : "N").build().toString();
            } else {
                string = str;
            }
            com.kakao.adfit.k.f.d("shouldOverrideUrlLoading: " + string);
            if (l.this.i != null && !str.contains("info.ad.daum.net")) {
                l.this.i.a(string);
            }
            return l.this.c(string);
        }
    }

    /* JADX INFO: compiled from: AdWebView.java */
    public interface d {
        void a(String str);
    }

    /* JADX INFO: compiled from: AdWebView.java */
    public interface e {
        void a(String str);
    }

    /* JADX INFO: compiled from: AdWebView.java */
    public interface f {
        void a(String str);
    }

    /* JADX INFO: compiled from: AdWebView.java */
    public interface g {
        void a();
    }

    public l(Context context) {
        super(context);
        this.a = new AtomicBoolean(false);
        this.f1673b = new AtomicBoolean(false);
        this.e = new DisplayMetrics();
        this.f = null;
        z.a.b(context);
        try {
            a(context);
        } catch (Exception e2) {
            com.kakao.adfit.e.f.a.a(e2);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.f1673b.compareAndSet(false, true)) {
            b();
            setOnKeyListener(null);
            super.destroy();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = getDisplay();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f = null;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        Display display = this.f;
        if (display != null) {
            display.getMetrics(this.e);
        }
        int size = View.MeasureSpec.getMode(i) == 0 ? this.e.widthPixels : View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getMode(i2) == 0 ? this.e.heightPixels : View.MeasureSpec.getSize(i2);
        int i4 = this.c;
        if (i4 <= 0 || (i3 = this.d) <= 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int i5 = (size2 * i4) / i3;
        if (size < i5) {
            setMeasuredDimension(size, (i3 * size) / i4);
        } else {
            setMeasuredDimension(i5, size2);
        }
    }

    public void setCache(boolean z) {
        a(getSettings(), z);
    }

    public void setOnNewPageOpenListener(d dVar) {
        this.i = dVar;
    }

    public void setOnPageErrorListener(e eVar) {
        this.h = eVar;
    }

    public void setOnPageLoadListener(f fVar) {
        this.g = fVar;
    }

    public void setOnPrivateAdEventListener(m mVar) {
    }

    public void setOnRenderProcessGoneListener(g gVar) {
        this.j = gVar;
    }

    protected void a(Context context) {
        setBackgroundColor(0);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnTouchListener(new a());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setOverScrollMode(2);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUserAgentString(com.kakao.adfit.k.i.a(this));
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(false);
        settings.setSavePassword(false);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setLoadsImagesAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setAllowFileAccess(true);
        setCache(true);
        setWebViewClient(new c());
        setWebChromeClient(new b(null));
    }

    public void b() {
        b("javascript:document.body.innerHTML='';");
        destroyDrawingCache();
        removeAllViews();
    }

    public boolean c(String str) {
        if (a0.a.a(getContext(), str)) {
            return true;
        }
        try {
            getContext().startActivity(IABActivity.a(getContext(), str));
        } catch (Throwable th) {
            com.kakao.adfit.e.f.a.a(th);
        }
        return true;
    }

    public void b(String str) {
        String str2 = !URLUtil.isJavaScriptUrl(str) ? "javascript:" + str : str;
        try {
            if (this.a.get()) {
                com.kakao.adfit.k.f.d("Load javascript: " + str);
                loadUrl(str2);
            }
        } catch (Exception e2) {
            com.kakao.adfit.k.f.a("Failed to load javascript: " + e2, e2);
        }
    }

    private void a(WebSettings webSettings, boolean z) {
        if (z) {
            webSettings.setCacheMode(-1);
            setDrawingCacheEnabled(true);
        } else {
            webSettings.setCacheMode(2);
            clearCache(true);
            setDrawingCacheEnabled(false);
        }
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        requestLayout();
    }

    public boolean a() {
        return this.f1673b.get();
    }

    public void a(String str) {
        loadDataWithBaseURL("https://display.ad.daum.net/", str, "text/html", "utf-8", null);
    }
}
