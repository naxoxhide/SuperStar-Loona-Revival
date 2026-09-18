package com.bytedance.sdk.openadsdk.d.r.b;

import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: VideoLogHelperModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f762b;
    private int c;
    private b.a.a.a.a.a.a.f.c d;
    private q e;

    /* JADX INFO: compiled from: VideoLogHelperModel.java */
    public static class a {
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private b.a.a.a.a.a.a.f.a k;
        private long a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f763b = 0;
        private long c = 0;
        private boolean d = false;
        private boolean j = false;

        private void a() {
            long j = this.c;
            if (j > 0) {
                long j2 = this.a;
                if (j2 > j) {
                    this.a = j2 % j;
                }
            }
        }

        public void b(long j) {
            this.a = j;
            a();
        }

        public void c(long j) {
            this.c = j;
            a();
        }

        public long d() {
            return this.f763b;
        }

        public long e() {
            return this.a;
        }

        public b.a.a.a.a.a.a.f.a f() {
            return this.k;
        }

        public int g() {
            long j = this.c;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.a * 100) / j), 100);
        }

        public int h() {
            return this.f;
        }

        public int i() {
            return this.e;
        }

        public int j() {
            return this.h;
        }

        public long k() {
            return this.c;
        }

        public boolean l() {
            return this.d;
        }

        public boolean m() {
            return this.j;
        }

        public void d(int i) {
            this.e = i;
        }

        public void a(long j) {
            this.f763b = j;
        }

        public int b() {
            return this.g;
        }

        public void c(int i) {
            this.f = i;
        }

        public void a(int i) {
            this.g = i;
        }

        public void b(int i) {
            this.i = i;
        }

        public int c() {
            return this.i;
        }

        public void a(boolean z) {
            this.d = z;
        }

        public void a(b.a.a.a.a.a.a.f.a aVar) {
            this.k = aVar;
        }
    }

    public o(long j, String str, int i, b.a.a.a.a.a.a.f.c cVar, q qVar) {
        this.a = j;
        this.f762b = str;
        this.c = i;
        this.d = cVar;
        this.e = qVar;
    }

    public q a() {
        return this.e;
    }

    public long b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.f762b;
    }

    public b.a.a.a.a.a.a.f.c e() {
        return this.d;
    }
}
