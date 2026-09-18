package com.kakao.adfit.common.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: com.kakao.adfit.common.volley.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cache.java */
    public static class C0448a {
        public byte[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1716b;
        public long c;
        public long d;
        public long e;
        public long f;
        public Map<String, String> g = Collections.emptyMap();
        public List<com.kakao.adfit.m.b> h;

        public boolean a() {
            return a(System.currentTimeMillis());
        }

        boolean b(long j) {
            return this.f < j;
        }

        boolean a(long j) {
            return this.e < j;
        }
    }

    C0448a a(String str);

    void a();

    void a(String str, C0448a c0448a);

    void a(String str, boolean z);
}
