package com.bytedance.sdk.openadsdk.b.p;

import com.bytedance.sdk.component.utils.m;

/* JADX INFO: compiled from: OpenAdDisplayStat.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f519b;

    public void a(float f) {
        m.a("OpenAdDisplayStat", "open_ad", "setTotalTime() called with: time = [" + f + "]");
        this.a = f;
    }

    public float b() {
        return this.a;
    }

    public long a() {
        return this.f519b;
    }

    public void a(long j) {
        this.f519b = j;
    }
}
