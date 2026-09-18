package com.fyber.inneractive.sdk.util;

/* JADX INFO: loaded from: classes2.dex */
public class c0 {
    public transient a[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f1334b;
    public int c;

    public static class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f1335b;
        public a c;

        public a(int i, int i2, Object obj, a aVar) {
            this.a = i;
            this.f1335b = obj;
            this.c = aVar;
        }
    }

    public c0() {
        this(20, 0.75f);
    }

    public c0(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        }
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Illegal Load: " + f);
        }
        i = i == 0 ? 1 : i;
        this.a = new a[i];
        this.c = (int) (i * f);
    }
}
