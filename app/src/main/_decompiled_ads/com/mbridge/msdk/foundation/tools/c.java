package com.mbridge.msdk.foundation.tools;

/* JADX INFO: compiled from: Container.java */
/* JADX INFO: loaded from: classes4.dex */
final class c {

    /* JADX INFO: compiled from: Container.java */
    static abstract class b {
        int a;

        abstract byte a();

        b() {
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.tools.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Container.java */
    static class C0489c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f2207b;

        @Override // com.mbridge.msdk.foundation.tools.c.b
        final byte a() {
            return (byte) 1;
        }

        C0489c(int i, boolean z) {
            this.a = i;
            this.f2207b = z;
        }
    }

    /* JADX INFO: compiled from: Container.java */
    static class f extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2210b;

        @Override // com.mbridge.msdk.foundation.tools.c.b
        final byte a() {
            return (byte) 2;
        }

        f(int i, int i2) {
            this.a = i;
            this.f2210b = i2;
        }
    }

    /* JADX INFO: compiled from: Container.java */
    static class e extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f2209b;

        @Override // com.mbridge.msdk.foundation.tools.c.b
        final byte a() {
            return (byte) 3;
        }

        e(int i, float f) {
            this.a = i;
            this.f2209b = f;
        }
    }

    /* JADX INFO: compiled from: Container.java */
    static class g extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2211b;

        @Override // com.mbridge.msdk.foundation.tools.c.b
        final byte a() {
            return (byte) 4;
        }

        g(int i, long j) {
            this.a = i;
            this.f2211b = j;
        }
    }

    /* JADX INFO: compiled from: Container.java */
    static class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f2208b;

        @Override // com.mbridge.msdk.foundation.tools.c.b
        final byte a() {
            return (byte) 5;
        }

        d(int i, double d) {
            this.a = i;
            this.f2208b = d;
        }
    }

    /* JADX INFO: compiled from: Container.java */
    static abstract class j extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f2212b;
        int c;
        int d;
        boolean e;

        j(int i, int i2, Object obj, int i3, boolean z) {
            this.c = i;
            this.a = i2;
            this.f2212b = obj;
            this.d = i3;
            this.e = z;
        }
    }

    /* JADX INFO: compiled from: Container.java */
    static class i extends j {
        @Override // com.mbridge.msdk.foundation.tools.c.b
        final byte a() {
            return (byte) 6;
        }

        i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }
    }

    /* JADX INFO: compiled from: Container.java */
    static class a extends j {
        @Override // com.mbridge.msdk.foundation.tools.c.b
        final byte a() {
            return (byte) 7;
        }

        a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }
    }

    /* JADX INFO: compiled from: Container.java */
    static class h extends j {
        @Override // com.mbridge.msdk.foundation.tools.c.b
        final byte a() {
            return (byte) 8;
        }

        h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }
    }
}
