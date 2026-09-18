package com.fyber.inneractive.sdk.util;

/* JADX INFO: loaded from: classes2.dex */
public class k0 {
    public float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f1341b;
    public boolean c = false;

    public k0(float f, float f2) {
        this.a = f;
        this.f1341b = f2;
    }

    public static k0 a() {
        return new k0(-1.0f, -1.0f);
    }

    public String toString() {
        return "PointLocation{x=" + this.a + ", y=" + this.f1341b + '}';
    }
}
