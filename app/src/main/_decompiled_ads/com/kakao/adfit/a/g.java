package com.kakao.adfit.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AdHttpContext.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static g e;
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.kakao.adfit.common.volley.f f1669b;
    private com.kakao.adfit.n.h c;
    private b d = new b(20);

    /* JADX INFO: compiled from: AdHttpContext.java */
    final class b implements com.kakao.adfit.n.h.e {
        private final LruCache<String, Bitmap> a;

        @Override // com.kakao.adfit.n.h.e
        public Bitmap a(String str) {
            return this.a.get(str);
        }

        private b(int i) {
            this.a = new LruCache<>(i);
        }

        @Override // com.kakao.adfit.n.h.e
        public void a(String str, Bitmap bitmap) {
            this.a.put(str, bitmap);
        }
    }

    private g(Context context) {
        com.kakao.adfit.common.volley.h.f1727b = false;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        com.kakao.adfit.common.volley.f fVarA = com.kakao.adfit.n.m.a(applicationContext);
        this.f1669b = fVarA;
        this.c = new com.kakao.adfit.n.h(fVarA, this.d);
    }

    public static synchronized g a(Context context) {
        if (e == null) {
            e = new g(context);
        }
        return e;
    }

    public <T> void a(com.kakao.adfit.common.volley.e<T> eVar) {
        this.f1669b.a(eVar);
    }

    public com.kakao.adfit.n.h a() {
        return this.c;
    }

    public void a(String str) {
        com.kakao.adfit.n.l lVar = new com.kakao.adfit.n.l(str, null, null);
        lVar.a(false);
        lVar.a((com.kakao.adfit.m.f) new com.kakao.adfit.m.a(10000, 0, 1.0f));
        a(lVar);
    }

    public void a(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
