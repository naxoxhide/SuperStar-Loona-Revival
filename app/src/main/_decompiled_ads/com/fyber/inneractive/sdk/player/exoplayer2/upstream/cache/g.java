package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Comparable<g> {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1206b;
    public final long c;
    public final boolean d;
    public final File e;
    public final long f;

    public g(String str, long j, long j2, long j3, File file) {
        this.a = str;
        this.f1206b = j;
        this.c = j2;
        this.d = file != null;
        this.e = file;
        this.f = j3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        if (!this.a.equals(gVar.a)) {
            return this.a.compareTo(gVar.a);
        }
        long j = this.f1206b - gVar.f1206b;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }
}
