package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: compiled from: WindVaneCallJs.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    private static g a = new g();

    private g() {
    }

    public static g a() {
        return a;
    }

    public final void a(Object obj, String str, String str2) {
        String str3;
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str2)) {
                str3 = String.format("javascript:window.WindVane.fireEvent('%s', '');", str);
            } else {
                str3 = String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, j.c(str2));
            }
            if (aVar.a == null || aVar.a.isDestoryed()) {
                return;
            }
            try {
                aVar.a.loadUrl(str3);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(WebView webView, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = String.format("javascript:window.WindVane.fireEvent('%s', '');", str);
        } else {
            str3 = String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, j.c(str2));
        }
        if (webView != null) {
            if ((webView instanceof WindVaneWebView) && ((WindVaneWebView) webView).isDestoryed()) {
                return;
            }
            try {
                webView.loadUrl(str3);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Object obj, String str) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            String str2 = TextUtils.isEmpty(str) ? String.format("javascript:window.WindVane.onSuccess(%s,'');", aVar.g) : String.format("javascript:window.WindVane.onSuccess(%s,'%s');", aVar.g, j.c(str));
            if (aVar.a == null || aVar.a.isDestoryed()) {
                return;
            }
            try {
                aVar.a.loadUrl(str2);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(Object obj, String str) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str)) {
                String.format("javascript:window.WindVane.onFailure(%s,'');", aVar.g);
            } else {
                str = j.c(str);
            }
            String str2 = String.format("javascript:window.WindVane.onFailure(%s,'%s');", aVar.g, str);
            if (aVar.a == null || aVar.a.isDestoryed()) {
                return;
            }
            try {
                aVar.a.loadUrl(str2);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(WebView webView) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("api_version", "1.0.0");
            a.a(webView, com.mbridge.msdk.mbsignalcommon.base.e.j, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception unused) {
            a.a(webView, com.mbridge.msdk.mbsignalcommon.base.e.j, "");
        } catch (Throwable unused2) {
            a.a(webView, com.mbridge.msdk.mbsignalcommon.base.e.j, "");
        }
    }
}
