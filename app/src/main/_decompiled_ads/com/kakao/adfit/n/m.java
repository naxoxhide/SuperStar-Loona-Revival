package com.kakao.adfit.n;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: Volley.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: compiled from: Volley.java */
    class a implements d.c {
        private File a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f1865b;

        a(Context context) {
            this.f1865b = context;
        }

        @Override // com.kakao.adfit.n.d.c
        public File get() {
            if (this.a == null) {
                this.a = new File(this.f1865b.getCacheDir(), "com.kakao.adfit.cache");
            }
            return this.a;
        }
    }

    public static com.kakao.adfit.common.volley.f a(Context context, com.kakao.adfit.n.a aVar) {
        return aVar == null ? a(context, new g()) : a(context, new b(context, aVar));
    }

    private static com.kakao.adfit.common.volley.f a(Context context, com.kakao.adfit.m.c cVar) {
        com.kakao.adfit.common.volley.f fVar = new com.kakao.adfit.common.volley.f(new d(new a(context.getApplicationContext())), cVar);
        fVar.b();
        return fVar;
    }

    public static com.kakao.adfit.common.volley.f a(Context context) {
        return a(context, (com.kakao.adfit.n.a) null);
    }
}
