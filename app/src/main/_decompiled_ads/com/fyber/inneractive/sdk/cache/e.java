package com.fyber.inneractive.sdk.cache;

/* JADX INFO: loaded from: classes2.dex */
public class e implements a<String> {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f848b;

    public e(String str, String str2) {
        this.a = str;
        this.f848b = str2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.fyber.inneractive.sdk.cache.a
    public String a(String str) throws Exception {
        return str;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public /* bridge */ /* synthetic */ void a(String str) {
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public String b() {
        return this.f848b;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public String c() {
        return this.f848b;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public boolean d() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public String a() {
        return this.a;
    }
}
