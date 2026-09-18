package com.fyber.inneractive.sdk.web;

import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1357b;
    public final Map<String, String> c;

    public b0(WebResourceRequest webResourceRequest) {
        this.a = webResourceRequest.getUrl().toString();
        this.f1357b = webResourceRequest.getMethod();
        this.c = new HashMap(webResourceRequest.getRequestHeaders() == null ? Collections.emptyMap() : webResourceRequest.getRequestHeaders());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (this.a.equals(b0Var.a) && this.f1357b.equals(b0Var.f1357b)) {
            return this.c.equals(b0Var.c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.f1357b.hashCode()) * 31) + this.c.hashCode();
    }
}
