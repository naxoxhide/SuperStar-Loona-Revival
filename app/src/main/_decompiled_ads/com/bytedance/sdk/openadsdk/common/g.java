package com.bytedance.sdk.openadsdk.common;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTBottomNewStyleManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SSWebView f532b;
    private final q c;
    private final String d;
    private final Context e;
    private ImageView f;
    private ImageView g;

    /* JADX INFO: compiled from: TTBottomNewStyleManager.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f532b == null || !g.this.f532b.c()) {
                return;
            }
            g.this.a("backward");
            g.this.f532b.h();
        }
    }

    /* JADX INFO: compiled from: TTBottomNewStyleManager.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f532b == null || !g.this.f532b.d()) {
                return;
            }
            g.this.a("forward");
            g.this.f532b.i();
        }
    }

    /* JADX INFO: compiled from: TTBottomNewStyleManager.java */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f532b != null) {
                g.this.b("refresh");
                g.this.f532b.r();
            }
        }
    }

    /* JADX INFO: compiled from: TTBottomNewStyleManager.java */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f532b != null) {
                g.this.b("external_btn_click");
                Intent intent = new Intent("android.intent.action.VIEW");
                String url = g.this.f532b.getUrl();
                if (TextUtils.isEmpty(url)) {
                    return;
                }
                intent.setData(Uri.parse(url));
                com.bytedance.sdk.component.utils.b.a(g.this.e, intent, null);
            }
        }
    }

    /* JADX INFO: compiled from: TTBottomNewStyleManager.java */
    class e implements View.OnClickListener {
        e(g gVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public g(Context context, LinearLayout linearLayout, SSWebView sSWebView, q qVar, String str) {
        this.e = context;
        this.a = linearLayout;
        this.f532b = sSWebView;
        this.c = qVar;
        this.d = str;
        b();
    }

    public void c() {
        if (this.a.getAlpha() == 0.0f) {
            ObjectAnimator.ofFloat(this.a, "alpha", 0.0f, 1.0f).setDuration(300L).start();
        }
    }

    private void b() {
        this.f = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.i0);
        this.g = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.j0);
        ImageView imageView = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.k0);
        ImageView imageView2 = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.l0);
        this.f.setOnClickListener(new a());
        this.g.setOnClickListener(new b());
        imageView.setOnClickListener(new c());
        imageView2.setOnClickListener(new d());
        this.a.setOnClickListener(new e(this));
        this.f.setClickable(false);
        this.g.setClickable(false);
        this.f.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
        this.g.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
    }

    public void a(WebView webView) {
        try {
            if (this.f != null) {
                if (webView.canGoBack()) {
                    this.f.setClickable(true);
                    this.f.clearColorFilter();
                } else {
                    this.f.setClickable(false);
                    this.f.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
            if (this.g != null) {
                if (webView.canGoForward()) {
                    this.g.setClickable(true);
                    this.g.clearColorFilter();
                } else {
                    this.g.setClickable(false);
                    this.g.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (this.a.getAlpha() == 1.0f) {
            ObjectAnimator.ofFloat(this.a, "alpha", 1.0f, 0.0f).setDuration(300L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        WebBackForwardList webBackForwardListCopyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f532b.getWebView() != null && (webBackForwardListCopyBackForwardList = this.f532b.getWebView().copyBackForwardList()) != null) {
                int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
                String url = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.f532b.getUrl();
                }
                String url2 = str.equals("backward") ? webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex - 1).getUrl() : "";
                int i = 1;
                if (str.equals("forward")) {
                    url2 = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex + 1).getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("next_url", url2);
                if (webBackForwardListCopyBackForwardList.getCurrentIndex() != 0) {
                    i = 0;
                }
                jSONObject2.putOpt("first_page", Integer.valueOf(i));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.d.c.c(this.c, this.d, str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        WebBackForwardList webBackForwardListCopyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f532b.getWebView() != null && (webBackForwardListCopyBackForwardList = this.f532b.getWebView().copyBackForwardList()) != null) {
                String url = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex()).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.f532b.getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("first_page", Integer.valueOf(webBackForwardListCopyBackForwardList.getCurrentIndex() == 0 ? 1 : 0));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.d.c.c(this.c, this.d, str, jSONObject);
    }
}
