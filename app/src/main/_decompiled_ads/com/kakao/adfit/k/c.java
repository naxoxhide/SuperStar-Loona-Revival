package com.kakao.adfit.k;

import android.util.AndroidRuntimeException;
import android.webkit.CookieManager;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AdFitCookieManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u0004\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0004\u001a\u00020\u0007¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/k/c;", "", "", "", "a", "Landroid/webkit/WebView;", "webView", "", "", "url", "cookie", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final void a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        try {
            CookieManager.getInstance().setAcceptCookie(true);
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        } catch (Throwable th) {
            if (a(th)) {
                return;
            }
            com.kakao.adfit.e.f.a.a(th);
        }
    }

    public final String a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            return CookieManager.getInstance().getCookie(url);
        } catch (Throwable th) {
            if (a(th)) {
                return null;
            }
            com.kakao.adfit.e.f.a.a(th);
            return null;
        }
    }

    public final void a(String url, String cookie) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (cookie != null && (StringsKt.isBlank(cookie) ^ true)) {
            try {
                CookieManager.getInstance().setCookie(url, cookie);
                a.a();
            } catch (Throwable th) {
                if (a(th)) {
                    return;
                }
                com.kakao.adfit.e.f.a.a(th);
            }
        }
    }

    public final void a() {
        try {
            CookieManager.getInstance().flush();
        } catch (Throwable th) {
            if (a(th)) {
                return;
            }
            com.kakao.adfit.e.f.a.a(th);
        }
    }

    private final boolean a(Throwable th) {
        return (th instanceof AndroidRuntimeException) || (th instanceof ClassNotFoundException) || (th instanceof UnsatisfiedLinkError);
    }
}
