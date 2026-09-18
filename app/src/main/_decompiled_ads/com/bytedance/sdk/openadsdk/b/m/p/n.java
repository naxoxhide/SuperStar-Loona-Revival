package com.bytedance.sdk.openadsdk.b.m.p;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.webkit.ProxyConfig;
import b.b.a.a.h.u;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a0;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.b0;
import org.json.JSONObject;

/* JADX INFO: compiled from: VastEndCardManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements com.bytedance.sdk.openadsdk.k.g {
    private final Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f512b;
    private SSWebView c;
    private ImageView d;
    private boolean e;
    private com.bytedance.sdk.openadsdk.core.c0.g f;
    private boolean g;
    private volatile boolean h;
    private final com.bytedance.sdk.openadsdk.b.m.p.a i;
    private int j;

    /* JADX INFO: compiled from: VastEndCardManager.java */
    class a extends com.bytedance.sdk.openadsdk.core.c0.g {
        a(n nVar, String str, com.bytedance.sdk.openadsdk.core.i0.a aVar) {
            super(str, aVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.g
        public void b() {
        }
    }

    /* JADX INFO: compiled from: VastEndCardManager.java */
    class c extends b.b.a.a.k.g {
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, int i, String str2, String str3) {
            super(str);
            this.c = i;
            this.d = str2;
            this.e = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("reason_code", this.c);
                jSONObject.put("error_code", this.c);
                String str = this.d;
                if (str != null) {
                    jSONObject.put("url", str);
                }
                com.bytedance.sdk.openadsdk.d.c.b(n.this.f512b, this.e, "load_vast_endcard_fail", jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: VastEndCardManager.java */
    class d extends WebChromeClient {
        d() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                n.this.e();
            }
        }
    }

    /* JADX INFO: compiled from: VastEndCardManager.java */
    class e extends SSWebView.r0 {
        e() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            n.this.e();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (Build.VERSION.SDK_INT < 21 || !webResourceRequest.isForMainFrame()) {
                return;
            }
            n.this.a(webResourceResponse.getStatusCode(), webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : null);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (n.this.a(str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public n(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.i = aVar;
        this.f512b = aVar.a;
        this.a = aVar.V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a(Integer.MAX_VALUE, (String) null);
    }

    public boolean d() {
        if (!this.e) {
            return false;
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.performClick();
            return true;
        }
        SSWebView sSWebView = this.c;
        if (sSWebView == null) {
            return false;
        }
        this.f.onClick(sSWebView);
        return true;
    }

    private void b() {
        this.c.l();
        this.c.setDisplayZoomControls(false);
        this.c.setWebChromeClient(new d());
        this.c.setWebViewClient(new e());
    }

    public void c() {
        DeviceUtils.AudioInfoReceiver.b(this);
        SSWebView sSWebView = this.c;
        if (sSWebView != null) {
            a0.a(sSWebView.getWebView());
        }
    }

    public void a() {
        DeviceUtils.AudioInfoReceiver.a(this);
        this.j = DeviceUtils.d();
        if (this.f512b.M0() != null) {
            this.f = new a(this, "VAST_END_CARD", this.f512b.M0());
            com.bytedance.sdk.openadsdk.core.i0.c cVarC = this.f512b.M0().c();
            if (cVarC != null) {
                String strD = cVarC.d();
                if (!TextUtils.isEmpty(strD)) {
                    this.e = true;
                    this.d = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.h);
                    a(cVarC.f(), cVarC.b(), this.f512b.M0());
                    com.bytedance.sdk.openadsdk.h.d.a(strD).b(cVarC.f()).a(cVarC.b()).d(b0.g(o.a())).c(b0.i(o.a())).a(u.BITMAP).a(new com.bytedance.sdk.openadsdk.h.b(this.f512b, strD, new b(strD)));
                    return;
                }
                this.c = (SSWebView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.i);
                b();
                String strC = cVarC.c();
                if (strC != null) {
                    this.e = true;
                    if (strC.startsWith(ProxyConfig.MATCH_HTTP)) {
                        this.c.c(strC);
                        return;
                    }
                    String strA = com.bytedance.sdk.openadsdk.core.i0.e.a(strC);
                    String str = TextUtils.isEmpty(strA) ? strC : strA;
                    this.c.setDefaultTextEncodingName("UTF -8");
                    this.c.a(null, str, "text/html", "UTF-8", null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: VastEndCardManager.java */
    class b implements b.b.a.a.h.o<Bitmap> {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // b.b.a.a.h.o
        public void a(b.b.a.a.h.k<Bitmap> kVar) {
            if (n.this.d == null || kVar == null) {
                return;
            }
            Bitmap bitmapC = kVar.c();
            if (bitmapC == null) {
                n.this.a(-1, this.a);
                return;
            }
            n.this.d.setImageBitmap(bitmapC);
            n.this.g = true;
            n.this.e();
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
            if (n.this.d != null) {
                n.this.d.setVisibility(8);
            }
            n.this.a(-2, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        if (this.h) {
            return;
        }
        this.h = true;
        String strE = this.f512b.M0() != null ? this.f512b.M0().e() : "";
        if (i == Integer.MAX_VALUE) {
            com.bytedance.sdk.openadsdk.d.c.b(this.f512b, strE, "load_vast_endcard_success", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.d.c.a(new c("load_vast_endcard_fail", i, str, strE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        q qVar;
        if (str == null || (qVar = this.f512b) == null || qVar.M0() == null || this.f == null) {
            return false;
        }
        this.f512b.M0().e(str);
        this.f.onClick(this.c);
        return true;
    }

    private void a(int i, int i2, com.bytedance.sdk.openadsdk.core.i0.a aVar) {
        Activity activity;
        if (i == 0 || i2 == 0 || this.d == null || (activity = this.a) == null) {
            return;
        }
        int i3 = b0.i(activity);
        int iG = b0.g(this.a);
        float f = i / i2;
        float f2 = i3;
        if (f <= f2 / iG) {
            i3 = (int) Math.ceil(f2 * f);
        } else {
            iG = (int) Math.ceil(f2 / f);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = iG;
        this.d.setLayoutParams(layoutParams);
        this.d.setOnClickListener(this.f);
        this.d.setOnTouchListener(this.f);
    }

    public boolean a(l lVar) {
        com.bytedance.sdk.openadsdk.core.i0.c cVarC;
        if (!this.e) {
            return false;
        }
        ImageView imageView = this.d;
        if (imageView != null && this.g) {
            imageView.setVisibility(0);
        } else {
            SSWebView sSWebView = this.c;
            if (sSWebView != null) {
                sSWebView.setVisibility(0);
                if (this.c.getWebView() != null) {
                    this.c.getWebView().setOnTouchListener(this.f);
                }
            }
        }
        q qVar = this.f512b;
        if (qVar == null || qVar.M0() == null || (cVarC = this.f512b.M0().c()) == null) {
            return true;
        }
        cVarC.b(lVar != null ? lVar.e() : -1L);
        return true;
    }

    public void a(com.bytedance.sdk.openadsdk.core.c0.e eVar) {
        com.bytedance.sdk.openadsdk.core.c0.g gVar = this.f;
        if (gVar != null) {
            gVar.a(eVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.g
    public void a(int i) {
        int i2 = this.j;
        if (i2 == 0 && i > 0) {
            this.f512b.M0().m().i(this.i.G.e());
        } else if (i2 > 0 && i == 0) {
            this.f512b.M0().m().e(this.i.G.e());
        }
        this.j = i;
    }
}
