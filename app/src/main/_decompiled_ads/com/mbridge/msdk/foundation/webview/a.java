package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.out.BaseTrackingListener;

/* JADX INFO: compiled from: BackPointBrowserViewListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements BrowserView.a {
    private static String a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2233b;
    private BaseTrackingListener c;
    private CampaignEx d;
    private BrowserView f;
    private com.mbridge.msdk.click.a h;
    private long i;
    private int j;
    private CommonJumpLoader.JumpLoaderResult l;
    private String m;
    private boolean n;
    private boolean e = true;
    private boolean k = false;
    private final Runnable o = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.1
        @Override // java.lang.Runnable
        public final void run() {
            aa.d(a.a, "webview js！超时上限：" + a.this.j + "ms");
            if (a.this.h != null && a.this.l != null) {
                a.this.l.setSuccess(false);
                a.this.l.setUrl(a.this.m);
                a.this.l.setType(2);
                a.this.l.setExceptionMsg("linktype 8 time out");
                a.this.h.a(a.this.l, a.this.d, 1, false);
            }
            a aVar = a.this;
            if (aVar.d(null, aVar.m) && !a.this.k) {
                a.this.k = true;
                a aVar2 = a.this;
                aVar2.a(aVar2.f2233b, a.this.m, a.this.d);
            }
            if (a.this.c != null) {
                a.this.c.onFinishRedirection(a.this.d, a.this.m);
            }
        }
    };
    private Handler g = new Handler(Looper.getMainLooper());

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a() {
    }

    public a(Context context, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BrowserView browserView, BaseTrackingListener baseTrackingListener) {
        this.j = 10000;
        this.l = null;
        this.f2233b = context;
        this.d = campaignEx;
        this.f = browserView;
        this.c = baseTrackingListener;
        com.mbridge.msdk.c.c cVarB = d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        cVarB = cVarB == null ? d.a().b() : cVarB;
        this.h = aVar;
        this.l = new CommonJumpLoader.JumpLoaderResult();
        this.j = (int) cVarB.aa();
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a(WebView webView, String str) {
        if (this.i == 0) {
            this.i = System.currentTimeMillis();
            if (!this.n) {
                this.n = true;
                c();
            }
        }
        this.m = str;
        this.e = true;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a(WebView webView, String str, Bitmap bitmap) {
        if (this.i == 0) {
            this.i = System.currentTimeMillis();
            if (!this.n) {
                this.n = true;
                c();
            }
            this.k = false;
        }
        this.m = str;
        this.e = true;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final boolean b(WebView webView, final String str) {
        aa.d(a, "shouldOverrideUrlLoading1  " + str);
        this.e = false;
        if (ae.a.a(str) && ae.a.a(this.f2233b, str, null)) {
            this.k = true;
        }
        boolean zE = e(webView, str);
        if (zE) {
            this.i = 0L;
            this.e = false;
            d();
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.h != null && a.this.l != null) {
                        a.this.l.setSuccess(true);
                        a.this.l.setUrl(str);
                        a.this.l.setType(2);
                        a.this.h.a(a.this.l, a.this.d, 1, true);
                    }
                    if (a.this.c != null) {
                        a.this.c.onFinishRedirection(a.this.d, str);
                    }
                }
            });
        }
        return zE;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void c(WebView webView, final String str) {
        aa.d(a, "onPageFinished1  " + str);
        if (this.e) {
            this.i = 0L;
            this.e = false;
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.c != null) {
                        a.this.c.onFinishRedirection(a.this.d, str);
                    }
                    if (a.this.h == null || a.this.l == null) {
                        return;
                    }
                    a.this.l.setSuccess(true);
                    a.this.l.setUrl(str);
                    a.this.l.setType(2);
                    a.this.h.a(a.this.l, a.this.d, 1, true);
                }
            });
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d();
            Uri uri = Uri.parse(str);
            if (!(uri.getScheme().equals(ProxyConfig.MATCH_HTTP) || uri.getScheme().equals("https")) || this.k) {
                return;
            }
            this.k = true;
            a(this.f2233b, str, this.d);
        }
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a(WebView webView, int i, final String str, final String str2) {
        aa.c(a, str);
        d();
        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.4
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.c != null) {
                    a.this.c.onFinishRedirection(a.this.d, str2);
                }
                if (a.this.h == null || a.this.l == null) {
                    return;
                }
                a.this.l.setSuccess(false);
                a.this.l.setUrl(str2);
                a.this.l.setType(2);
                a.this.l.setExceptionMsg(str);
                a.this.h.a(a.this.l, a.this.d, 1, true);
            }
        });
        if (!d(webView, str2) || this.k) {
            return;
        }
        this.k = true;
        a(this.f2233b, str2, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, CampaignEx campaignEx) {
        if (context == null) {
            return;
        }
        String currentLRid = campaignEx != null ? campaignEx.getCurrentLRid() : "";
        try {
            Class.forName("com.mbridge.msdk.activity.MBCommonActivity");
            Intent intent = new Intent(context, Class.forName("com.mbridge.msdk.activity.MBCommonActivity"));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.a.put(str, this.f);
            if (ae.a.b(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
            }
            intent.putExtra("url", str);
            aa.b("url", "webview url = " + str);
            intent.setFlags(805306368);
            intent.putExtra("mvcommon", campaignEx);
            context.startActivity(intent);
        } catch (Exception unused) {
            ae.a(context, str, this.c, currentLRid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Uri uri = Uri.parse(str);
            if (uri.getScheme().equals(ProxyConfig.MATCH_HTTP) || uri.getScheme().equals("https")) {
                return true;
            }
            if (uri.getScheme().equals(SDKConstants.PARAM_INTENT)) {
                Intent uri2 = Intent.parseUri(str, 1);
                try {
                    String str2 = uri2.getPackage();
                    if (!TextUtils.isEmpty(str2) && this.f2233b.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                        return false;
                    }
                } catch (Throwable th) {
                    aa.d(a, th.getMessage());
                }
                try {
                    String stringExtra = uri2.getStringExtra("browser_fallback_url");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        Uri uri3 = Uri.parse(str);
                        if (uri3.getScheme().equals(ProxyConfig.MATCH_HTTP) || uri3.getScheme().equals("https")) {
                            return true;
                        }
                        str = stringExtra;
                    }
                } catch (Throwable th2) {
                    aa.d(a, th2.getMessage());
                }
            }
            if (!com.mbridge.msdk.click.b.d(this.f2233b, str)) {
                return true;
            }
            aa.d(a, "openDeepLink");
            return false;
        } catch (Throwable th3) {
            aa.d(a, th3.getMessage());
            return true;
        }
    }

    private boolean e(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri uri = Uri.parse(str);
            if (uri.getScheme().equals(ProxyConfig.MATCH_HTTP) || uri.getScheme().equals("https")) {
                return false;
            }
            if (uri.getScheme().equals(SDKConstants.PARAM_INTENT)) {
                Intent uri2 = Intent.parseUri(str, 1);
                try {
                    String str2 = uri2.getPackage();
                    if (!TextUtils.isEmpty(str2) && this.f2233b.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                        uri2.setFlags(268435456);
                        this.f2233b.startActivity(uri2);
                        this.k = true;
                        return true;
                    }
                    try {
                        String stringExtra = uri2.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri uri3 = Uri.parse(str);
                            if (uri3.getScheme().equals(ProxyConfig.MATCH_HTTP) || uri3.getScheme().equals("https")) {
                                webView.loadUrl(stringExtra);
                                return false;
                            }
                            str = stringExtra;
                        }
                    } catch (Throwable th) {
                        aa.d(a, th.getMessage());
                    }
                } catch (Throwable th2) {
                    aa.d(a, th2.getMessage());
                }
                aa.d(a, th.getMessage());
                return false;
            }
            if (!com.mbridge.msdk.click.b.d(this.f2233b, str)) {
                return false;
            }
            aa.d(a, "openDeepLink");
            this.k = true;
            return true;
        } catch (Throwable th3) {
            aa.d(a, th3.getMessage());
            return false;
        }
    }

    private void c() {
        this.g.postDelayed(this.o, this.j);
    }

    private void d() {
        this.g.removeCallbacks(this.o);
    }
}
