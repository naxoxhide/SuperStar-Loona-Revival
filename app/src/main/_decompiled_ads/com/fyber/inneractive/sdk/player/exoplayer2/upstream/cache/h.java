package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1207b;
    public final TreeSet<l> c = new TreeSet<>();
    public long d;

    public h(int i, String str, long j) {
        this.a = i;
        this.f1207b = str;
        this.d = j;
    }

    public int a() {
        int iHashCode = ((this.a * 31) + this.f1207b.hashCode()) * 31;
        long j = this.d;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }
}
