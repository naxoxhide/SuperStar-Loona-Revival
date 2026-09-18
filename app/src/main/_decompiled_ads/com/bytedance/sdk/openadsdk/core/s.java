package com.bytedance.sdk.openadsdk.core;

/* JADX INFO: compiled from: SingleAppData.java */
/* JADX INFO: loaded from: classes2.dex */
public class s {
    private static s f;
    private com.bytedance.sdk.openadsdk.core.f0.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.f0.q f669b;
    private com.bytedance.sdk.openadsdk.a.f.a c;
    private com.bytedance.sdk.openadsdk.a.d.b d;
    private com.bytedance.sdk.openadsdk.a.e.b e;

    private s() {
    }

    public static s g() {
        if (f == null) {
            f = new s();
        }
        return f;
    }

    public void a(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        this.f669b = qVar;
    }

    public com.bytedance.sdk.openadsdk.core.f0.a b() {
        return this.a;
    }

    public com.bytedance.sdk.openadsdk.a.e.b c() {
        return this.e;
    }

    public com.bytedance.sdk.openadsdk.a.d.b d() {
        return this.d;
    }

    public com.bytedance.sdk.openadsdk.core.f0.q e() {
        return this.f669b;
    }

    public com.bytedance.sdk.openadsdk.a.f.a f() {
        return this.c;
    }

    public void a(com.bytedance.sdk.openadsdk.a.d.b bVar) {
        this.d = bVar;
    }

    public void a(com.bytedance.sdk.openadsdk.a.f.a aVar) {
        this.c = aVar;
    }

    public void a(com.bytedance.sdk.openadsdk.a.e.b bVar) {
        this.e = bVar;
    }

    public void a() {
        this.f669b = null;
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar) {
        this.a = aVar;
    }
}
