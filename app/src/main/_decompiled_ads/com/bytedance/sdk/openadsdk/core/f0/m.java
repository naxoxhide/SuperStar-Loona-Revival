package com.bytedance.sdk.openadsdk.core.f0;

import android.util.SparseArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DynamicClickInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements b.b.a.a.d.b {
    public final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f582b;
    public final float c;
    public final float d;
    public final long e;
    public final long f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final String k;
    public int l;
    public JSONObject m;
    public SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> n;
    public final boolean o;
    public int p;

    /* JADX INFO: compiled from: DynamicClickInfo.java */
    public static class b {
        private long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f583b;
        private float c;
        private float d;
        private float e;
        private float f;
        private int g;
        private int h;
        private int i;
        private int j;
        private String k;
        private int l;
        private JSONObject m;
        private int n;
        protected SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> o = new SparseArray<>();
        private boolean p;

        public b a(int i) {
            this.l = i;
            return this;
        }

        public b b(long j) {
            this.a = j;
            return this;
        }

        public b c(float f) {
            this.d = f;
            return this;
        }

        public b d(float f) {
            this.c = f;
            return this;
        }

        public b e(int i) {
            this.h = i;
            return this;
        }

        public b f(int i) {
            this.n = i;
            return this;
        }

        public b a(JSONObject jSONObject) {
            this.m = jSONObject;
            return this;
        }

        public b b(float f) {
            this.e = f;
            return this;
        }

        public b c(int i) {
            this.i = i;
            return this;
        }

        public b d(int i) {
            this.g = i;
            return this;
        }

        public b a(boolean z) {
            this.p = z;
            return this;
        }

        public b b(int i) {
            this.j = i;
            return this;
        }

        public b a(long j) {
            this.f583b = j;
            return this;
        }

        public b a(float f) {
            this.f = f;
            return this;
        }

        public b a(String str) {
            this.k = str;
            return this;
        }

        public b a(SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray) {
            this.o = sparseArray;
            return this;
        }

        public m a() {
            return new m(this);
        }
    }

    private m(b bVar) {
        this.a = bVar.f;
        this.f582b = bVar.e;
        this.c = bVar.d;
        this.d = bVar.c;
        this.e = bVar.f583b;
        this.f = bVar.a;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.n = bVar.o;
        this.o = bVar.p;
        this.l = bVar.l;
        this.m = bVar.m;
        this.p = bVar.n;
    }
}
