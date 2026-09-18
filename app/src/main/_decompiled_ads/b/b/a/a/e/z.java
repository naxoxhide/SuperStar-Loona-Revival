package b.b.a.a.e;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* JADX INFO: compiled from: WebViewBridge.java */
/* JADX INFO: loaded from: classes.dex */
public class z extends b.b.a.a.e.a {
    static final /* synthetic */ boolean j = true;
    protected String h;
    protected WebView i;

    /* JADX INFO: compiled from: WebViewBridge.java */
    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (z.this.e) {
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    i.a("Invoking Jsb using evaluateJavascript: " + this.a);
                    z.this.i.evaluateJavascript(this.a, null);
                } else {
                    i.a("Invoking Jsb using loadUrl: " + this.a);
                    z.this.i.loadUrl(this.a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // b.b.a.a.e.a
    protected Context a(j jVar) {
        Context context = jVar.e;
        if (context != null) {
            return context;
        }
        WebView webView = jVar.a;
        if (webView != null) {
            return webView.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // b.b.a.a.e.a
    protected void b(j jVar) {
        this.i = jVar.a;
        this.h = jVar.c;
        if (Build.VERSION.SDK_INT < 17 || jVar.n) {
            return;
        }
        c();
    }

    protected void c() {
        if (!j && this.i == null) {
            throw new AssertionError();
        }
        this.i.addJavascriptInterface(this, this.h);
    }

    protected void d() {
        this.i.removeJavascriptInterface(this.h);
    }

    @Override // b.b.a.a.e.a
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // b.b.a.a.e.a
    protected void b() {
        super.b();
        d();
    }

    @Override // b.b.a.a.e.a
    protected String a() {
        return this.i.getUrl();
    }

    @Override // b.b.a.a.e.a
    protected void b(String str, q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.h)) {
            String str2 = qVar.h;
            a(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.b(str, qVar);
    }

    private void a(String str, String str2) {
        if (this.e || TextUtils.isEmpty(str2)) {
            return;
        }
        a aVar = new a(str2);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            i.a("Received call on sub-thread, posting to main thread: " + str2);
            this.c.post(aVar);
        } else {
            aVar.run();
        }
    }

    @Override // b.b.a.a.e.a
    protected void b(String str) {
        a(str, "javascript:" + this.h + "._handleMessageFromToutiao(" + str + ")");
    }
}
