package com.tnkfactory.ad.pub.a;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/* JADX INFO: loaded from: classes4.dex */
public class j extends WebView {
    public Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f2871b;
    public boolean c;
    public a1 d;
    public boolean e;

    public class a extends WebChromeClient {

        /* JADX INFO: renamed from: com.tnkfactory.ad.pub.a.j$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0530a implements DialogInterface.OnClickListener {
            public final /* synthetic */ JsResult a;

            public DialogInterfaceOnClickListenerC0530a(JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.confirm();
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ JsResult a;

            public b(JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.confirm();
            }
        }

        public class c implements DialogInterface.OnClickListener {
            public final /* synthetic */ JsResult a;

            public c(JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.cancel();
            }
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            Context context = webView.getContext();
            DialogInterfaceOnClickListenerC0530a dialogInterfaceOnClickListenerC0530a = new DialogInterfaceOnClickListenerC0530a(jsResult);
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.Theme.Holo.Light.Dialog.NoActionBar));
                builder.setTitle((CharSequence) null);
                builder.setMessage(str2);
                builder.setPositiveButton(m0.a().a, dialogInterfaceOnClickListenerC0530a);
                builder.setCancelable(false);
                builder.show();
            } catch (Throwable unused) {
                Toast.makeText(context, str2, 1).show();
                dialogInterfaceOnClickListenerC0530a.a.confirm();
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            Context context = webView.getContext();
            b bVar = new b(jsResult);
            c cVar = new c(jsResult);
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.Theme.Holo.Light.Dialog.NoActionBar));
                builder.setTitle((CharSequence) null);
                builder.setMessage(str2);
                String str3 = m0.a().a;
                String str4 = m0.a().f2878b;
                builder.setPositiveButton(str3, bVar);
                builder.setNegativeButton(str4, cVar);
                builder.setCancelable(false);
                builder.show();
            } catch (Throwable unused) {
                Toast.makeText(context, str2, 1).show();
                bVar.a.confirm();
            }
            return true;
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            j.this.d.onTouchEvent(motionEvent);
            return false;
        }
    }

    public class c extends WebViewClient {
        public c() {
        }

        public /* synthetic */ c(j jVar, a aVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            d dVar = j.this.f2871b;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            d dVar = j.this.f2871b;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                return j.this.a(webResourceRequest != null ? webResourceRequest.getUrl().toString() : null);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return j.this.a(str);
        }
    }

    public interface d {
        void a();

        void b();
    }

    public j(Context context) {
        super(context);
        a aVar = null;
        this.a = null;
        this.f2871b = null;
        this.c = false;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDefaultTextEncodingName("utf-8");
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            getSettings().setMixedContentMode(0);
            CookieManager.getInstance().setAcceptCookie(true);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        }
        if (i >= 26) {
            getSettings().setSafeBrowsingEnabled(false);
        }
        setFocusableInTouchMode(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollContainer(false);
        setWebChromeClient(new a());
        setWebViewClient(new c(this, aVar));
        this.d = new a1(context);
        setOnTouchListener(new b());
    }

    public static void a(j jVar) {
        Handler handler = jVar.a;
        if (handler != null) {
            jVar.a.sendMessage(handler.obtainMessage(1, jVar.getPageIndex(), 0));
        }
    }

    private int getPageIndex() {
        String str = (String) getTag();
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        setLifeCycle(i);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        setLifeCycle(i);
    }

    public void setHandler(Handler handler) {
        this.a = handler;
    }

    public void setLifeCycle(int i) {
        if (i != 0) {
            this.e = true;
            onPause();
        } else if (this.e) {
            this.e = false;
            onResume();
        }
    }

    public void setPageListener(d dVar) {
        this.f2871b = dVar;
    }

    public boolean a(String str) {
        Handler handler;
        if (!this.c && this.d.a() && (handler = this.a) != null) {
            this.a.sendMessage(handler.obtainMessage(9, getPageIndex(), 0, str));
        }
        return true;
    }
}
