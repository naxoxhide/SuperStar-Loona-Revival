package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.c;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.aa;

/* JADX INFO: compiled from: MBWebViewChecker.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static volatile Boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f2328b;
    private static Boolean c;

    public static boolean a(final Context context) {
        c cVarG;
        try {
            cVarG = d.a().g(b.d().h());
        } catch (Exception unused) {
            cVarG = null;
        }
        if (cVarG != null) {
            c = Boolean.valueOf(cVarG.p());
        } else {
            c = false;
        }
        Boolean bool = c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (a == null) {
                try {
                    a = Boolean.valueOf(c(context));
                } catch (Exception unused2) {
                    a = false;
                }
            }
            if (a == null) {
                a = new Boolean(false);
            }
            return a.booleanValue();
        }
        if (a == null && f2328b == null) {
            f2328b = new Handler(Looper.getMainLooper());
            f2328b.post(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.a == null) {
                        try {
                            Boolean unused3 = a.a = Boolean.valueOf(a.c(context));
                        } catch (Exception unused4) {
                            Boolean unused5 = a.a = false;
                        }
                    }
                }
            });
        }
        if (a == null) {
            return true;
        }
        return a.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
        } catch (Exception unused) {
            webView = null;
        }
        if (webView == null) {
            return false;
        }
        try {
            webView.destroy();
            return true;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            aa.b("MBWebViewChecker", "destroy webview error", e);
            return true;
        }
    }
}
