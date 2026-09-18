package com.tapjoy;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Runnable {
    public final /* synthetic */ JSONObject a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONArray f2726b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ TJAdUnitJSBridge i;

    public g(TJAdUnitJSBridge tJAdUnitJSBridge, JSONObject jSONObject, JSONArray jSONArray, JSONObject jSONObject2, String str, String str2, String str3, String str4, String str5) {
        this.i = tJAdUnitJSBridge;
        this.a = jSONObject;
        this.f2726b = jSONArray;
        this.c = jSONObject2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView = this.i.f2684b.getWebView();
        if (webView != null) {
            TJSplitWebView tJSplitWebView = this.i.c;
            if (tJSplitWebView == null) {
                ViewParent parent = webView.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    this.i.c = new TJSplitWebView(this.i.f2684b.getContext(), this.a, this.i);
                    viewGroup.addView(this.i.c, new RelativeLayout.LayoutParams(-1, -1));
                    this.i.c.animateOpen(viewGroup);
                }
            } else if (tJSplitWebView != null) {
                tJSplitWebView.setExitHosts(this.f2726b);
                this.i.c.applyLayoutOption(this.c);
            }
            TJSplitWebView tJSplitWebView2 = this.i.c;
            if (tJSplitWebView2 != null) {
                String str = this.d;
                if (str != null) {
                    tJSplitWebView2.setUserAgent(str);
                }
                this.i.c.setTrigger(this.e, this.f);
                TJAdUnitJSBridge tJAdUnitJSBridge = this.i;
                tJAdUnitJSBridge.splitWebViewCallbackID = this.g;
                try {
                    tJAdUnitJSBridge.c.loadUrl(this.h);
                    return;
                } catch (Exception e) {
                    TapjoyLog.w("TJAdUnitJSBridge", e.getMessage());
                    return;
                }
            }
        }
        TJAdUnitJSBridge tJAdUnitJSBridge2 = this.i;
        tJAdUnitJSBridge2.c = null;
        tJAdUnitJSBridge2.splitWebViewCallbackID = null;
        tJAdUnitJSBridge2.invokeJSCallback(this.g, Boolean.FALSE);
    }
}
