package com.bytedance.sdk.openadsdk.core.f0;

/* JADX INFO: compiled from: LoadingInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {
    private long a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f586b = 10000;
    private String c = "";

    public void a(long j) {
        if (j <= 0) {
            this.a = 10L;
        } else {
            this.a = j;
        }
    }

    public long b() {
        return this.a;
    }

    public long c() {
        return this.f586b;
    }

    public void b(long j) {
        if (j < 0) {
            this.f586b = 20L;
        } else {
            this.f586b = j;
        }
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
