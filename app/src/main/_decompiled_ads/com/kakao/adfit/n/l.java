package com.kakao.adfit.n;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: StringRequest.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends com.kakao.adfit.common.volley.e<String> {
    private final Object q;
    private com.kakao.adfit.common.volley.g.b<String> r;

    public l(int i, String str, com.kakao.adfit.common.volley.g.b<String> bVar, com.kakao.adfit.common.volley.g.a aVar) {
        super(i, str, aVar);
        this.q = new Object();
        this.r = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kakao.adfit.common.volley.e
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
        com.kakao.adfit.common.volley.g.b<String> bVar;
        synchronized (this.q) {
            bVar = this.r;
        }
        if (bVar != null) {
            bVar.a(str);
        }
    }

    @Override // com.kakao.adfit.common.volley.e
    public void a() {
        super.a();
        synchronized (this.q) {
            this.r = null;
        }
    }

    @Override // com.kakao.adfit.common.volley.e
    protected com.kakao.adfit.common.volley.g<String> a(com.kakao.adfit.m.d dVar) {
        String str;
        try {
            str = new String(dVar.f1851b, e.a(dVar.c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(dVar.f1851b);
        }
        return com.kakao.adfit.common.volley.g.a(str, e.a(dVar));
    }

    public l(String str, com.kakao.adfit.common.volley.g.b<String> bVar, com.kakao.adfit.common.volley.g.a aVar) {
        this(0, str, bVar, aVar);
    }
}
