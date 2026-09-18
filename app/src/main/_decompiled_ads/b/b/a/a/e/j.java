package b.b.a.a.e;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: Environment.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    WebView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f135b;
    h d;
    Context e;
    boolean f;
    boolean g;
    boolean h;
    m i;
    n j;
    boolean n;
    boolean o;
    k p;
    String c = "IESJSBridge";
    String k = "host";
    final Set<String> l = new LinkedHashSet();
    final Set<String> m = new LinkedHashSet();

    j(WebView webView) {
        this.a = webView;
    }

    public j a(a aVar) {
        this.f135b = aVar;
        return this;
    }

    public j b(boolean z) {
        this.g = z;
        return this;
    }

    public j c() {
        this.o = true;
        return this;
    }

    private void b() {
        if ((this.a == null && !this.n && this.f135b == null) || ((TextUtils.isEmpty(this.c) && this.a != null) || this.d == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public j a(String str) {
        this.c = str;
        return this;
    }

    public j a(l lVar) {
        this.d = h.a(lVar);
        return this;
    }

    public j a(boolean z) {
        this.f = z;
        return this;
    }

    public r a() {
        b();
        return new r(this);
    }
}
