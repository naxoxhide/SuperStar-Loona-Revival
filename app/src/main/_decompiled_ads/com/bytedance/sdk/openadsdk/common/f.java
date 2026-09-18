package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: LandingPageNewStyleManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RelativeLayout f531b;
    private final Context c;
    private SSWebView d;
    private ImageView e;
    private final String f;
    private i g;
    private g h;

    public f(Context context, q qVar, String str) {
        this.c = context;
        this.a = qVar;
        this.f = str;
        e();
    }

    private static RelativeLayout a(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.addView(new LandingPageBrowserNewTitleBar(context));
        SSWebView sSWebView = new SSWebView(context);
        sSWebView.setId(com.bytedance.sdk.openadsdk.utils.h.O);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        layoutParams.addRule(3, com.bytedance.sdk.openadsdk.utils.h.c0);
        relativeLayout.addView(sSWebView, layoutParams);
        LandingPageBrowserNewBottomBar landingPageBrowserNewBottomBar = new LandingPageBrowserNewBottomBar(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(landingPageBrowserNewBottomBar.getLayoutParams());
        layoutParams2.addRule(12);
        relativeLayout.addView(landingPageBrowserNewBottomBar, layoutParams2);
        return relativeLayout;
    }

    private void e() {
        RelativeLayout relativeLayoutA = a(this.c);
        this.f531b = relativeLayoutA;
        this.d = (SSWebView) relativeLayoutA.findViewById(com.bytedance.sdk.openadsdk.utils.h.O);
        i iVar = new i(this.c, (RelativeLayout) this.f531b.findViewById(com.bytedance.sdk.openadsdk.utils.h.c0), this.a);
        this.g = iVar;
        this.e = iVar.a();
        this.h = new g(this.c, (LinearLayout) this.f531b.findViewById(com.bytedance.sdk.openadsdk.utils.h.h0), this.d, this.a, this.f);
    }

    public View b() {
        return this.f531b;
    }

    public SSWebView c() {
        return this.d;
    }

    public void d() {
        i iVar = this.g;
        if (iVar != null) {
            iVar.b();
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void f() {
        i iVar = this.g;
        if (iVar != null) {
            iVar.g();
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.c();
        }
    }

    public ImageView a() {
        return this.e;
    }

    public void a(WebView webView, int i) {
        i iVar = this.g;
        if (iVar != null) {
            iVar.a(webView, i);
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a(webView);
        }
    }
}
