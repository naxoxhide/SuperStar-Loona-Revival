package b.b.a.a.d.h;

import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import b.b.a.a.e.z;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: WebViewPool.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static int d = 10;
    private static volatile e e;
    private List<SSWebView> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, c> f126b;
    private Map<Integer, d> c;

    private e() {
        new AtomicBoolean(false);
        this.a = new ArrayList();
        this.f126b = new HashMap();
        this.c = new HashMap();
        b.b.a.a.d.e.a.c cVarB = b.b.a.a.d.e.a.a.d().b();
        if (cVarB != null) {
            d = cVarB.b();
        }
    }

    public static e e() {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new e();
                }
            }
        }
        return e;
    }

    public SSWebView a() {
        SSWebView sSWebViewRemove;
        if (c() <= 0 || (sSWebViewRemove = this.a.remove(0)) == null) {
            return null;
        }
        m.a("WebViewPool", "get WebView from pool; current available count: " + c());
        return sSWebViewRemove;
    }

    public void b(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.a.size() >= d) {
            m.a("WebViewPool", "WebView pool is full，destroy webview");
            sSWebView.g();
        } else {
            if (this.a.contains(sSWebView)) {
                return;
            }
            this.a.add(sSWebView);
            m.a("WebViewPool", "recycle WebView，current available count: " + c());
        }
    }

    public void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        d(sSWebView);
        sSWebView.d("SDK_INJECT_GLOBAL");
        e(sSWebView);
        b(sSWebView);
    }

    public void d() {
        for (SSWebView sSWebView : this.a) {
            if (sSWebView != null) {
                sSWebView.g();
            }
        }
        this.a.clear();
    }

    public int c() {
        return this.a.size();
    }

    private void d(SSWebView sSWebView) {
        sSWebView.removeAllViews();
        sSWebView.u();
        sSWebView.setWebChromeClient(null);
        sSWebView.setWebViewClient(null);
        sSWebView.setDownloadListener(null);
        sSWebView.setJavaScriptEnabled(true);
        sSWebView.setAppCacheEnabled(false);
        sSWebView.setSupportZoom(false);
        sSWebView.setUseWideViewPort(true);
        sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
        sSWebView.setDomStorageEnabled(true);
        sSWebView.setBuiltInZoomControls(false);
        sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        sSWebView.setLoadWithOverviewMode(false);
        sSWebView.setUserAgentString("android_client");
        sSWebView.setDefaultTextEncodingName("UTF-8");
        sSWebView.setDefaultFontSize(16);
    }

    public int b() {
        return this.a.size();
    }

    public boolean a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        m.a("WebViewPool", "WebView render fail and abandon");
        sSWebView.g();
        return true;
    }

    public void e(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        c cVar = this.f126b.get(Integer.valueOf(sSWebView.hashCode()));
        if (cVar != null) {
            cVar.a(null);
        }
        sSWebView.d("SDK_INJECT_GLOBAL");
    }

    public void a(SSWebView sSWebView, b bVar) {
        if (sSWebView == null || bVar == null) {
            return;
        }
        c cVar = this.f126b.get(Integer.valueOf(sSWebView.hashCode()));
        if (cVar != null) {
            cVar.a(bVar);
        } else {
            cVar = new c(bVar);
            this.f126b.put(Integer.valueOf(sSWebView.hashCode()), cVar);
        }
        sSWebView.a(cVar, "SDK_INJECT_GLOBAL");
    }

    public void a(WebView webView, z zVar, String str) {
        if (webView == null || zVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        d dVar = this.c.get(Integer.valueOf(webView.hashCode()));
        if (dVar != null) {
            dVar.a(zVar);
        } else {
            dVar = new d(zVar);
            this.c.put(Integer.valueOf(webView.hashCode()), dVar);
        }
        webView.addJavascriptInterface(dVar, str);
    }

    public void a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        d dVar = this.c.get(Integer.valueOf(webView.hashCode()));
        if (dVar != null) {
            dVar.a(null);
        }
        webView.removeJavascriptInterface(str);
    }
}
