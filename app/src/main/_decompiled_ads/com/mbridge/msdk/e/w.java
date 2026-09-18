package com.mbridge.msdk.e;

import android.util.Log;

/* JADX INFO: compiled from: TrackConfig.java */
/* JADX INFO: loaded from: classes4.dex */
public final class w {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2055b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final o g;
    public final d h;
    public final v i;
    public final f j;

    private w(a aVar) {
        this.a = aVar.a;
        this.f2055b = aVar.f2056b;
        this.c = aVar.c;
        this.d = aVar.e;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.d;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
    }

    /* JADX INFO: compiled from: TrackConfig.java */
    public static final class a {
        private o d;
        private d h;
        private v i;
        private f j;
        private int a = 50;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2056b = 15000;
        private int c = 0;
        private int e = 2;
        private int f = 50;
        private int g = 604800000;

        public final a a(int i) {
            if (i <= 0) {
                this.a = 50;
            } else {
                this.a = i;
            }
            return this;
        }

        public final a b(int i) {
            if (i < 0) {
                this.f2056b = 15000;
            } else {
                this.f2056b = i;
            }
            return this;
        }

        public final a a(int i, o oVar) {
            this.c = i;
            this.d = oVar;
            return this;
        }

        public final a c(int i) {
            if (i <= 0) {
                this.e = 2;
            } else {
                this.e = i;
            }
            return this;
        }

        public final a d(int i) {
            if (i < 0) {
                this.f = 50;
            } else {
                this.f = i;
            }
            return this;
        }

        public final a e(int i) {
            if (i < 0) {
                this.g = 604800000;
            } else {
                this.g = i;
            }
            return this;
        }

        public final a a(d dVar) {
            this.h = dVar;
            return this;
        }

        public final a a(v vVar) {
            this.i = vVar;
            return this;
        }

        public final a a(f fVar) {
            this.j = fVar;
            return this;
        }

        public final w a() {
            if (y.a(this.h) && com.mbridge.msdk.e.a.a) {
                Log.e("TrackManager", "decorate can not be null");
            }
            if (y.a(this.i) && com.mbridge.msdk.e.a.a) {
                Log.e("TrackManager", "responseHandler can not be null");
            }
            if ((y.a(this.d) || y.a(this.d.c())) && com.mbridge.msdk.e.a.a) {
                Log.e("TrackManager", "networkStackConfig or stack can not be null");
            }
            return new w(this);
        }
    }
}
