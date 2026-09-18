package com.mbridge.msdk.e.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a {
    C0475a a(String str);

    void a();

    void a(String str, C0475a c0475a);

    void a(String str, boolean z);

    /* JADX INFO: renamed from: com.mbridge.msdk.e.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cache.java */
    public static class C0475a {
        public byte[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2015b;
        public long c;
        public long d;
        public long e;
        public long f;
        public Map<String, String> g = Collections.emptyMap();
        public List<g> h;

        final boolean a(long j) {
            return this.e < j;
        }
    }
}
