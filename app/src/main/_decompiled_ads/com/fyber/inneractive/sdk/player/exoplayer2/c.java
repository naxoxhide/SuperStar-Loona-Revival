package com.fyber.inneractive.sdk.player.exoplayer2;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1049b;
    public final long c;
    public final long d;
    public final long e;
    public int f;
    public boolean g;

    public c(com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar, int i, int i2, long j, long j2) {
        this(kVar, i, i2, j, j2, null);
    }

    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.b a() {
        return this.a;
    }

    public c(com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar, int i, int i2, long j, long j2, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        this.a = kVar;
        this.f1049b = ((long) i) * 1000;
        this.c = ((long) i2) * 1000;
        this.d = j * 1000;
        this.e = j2 * 1000;
    }

    public boolean a(long j) {
        char c;
        int i;
        boolean z = false;
        if (j > this.c) {
            c = 0;
        } else {
            c = j < this.f1049b ? (char) 2 : (char) 1;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = this.a;
        synchronized (kVar) {
            i = kVar.f * kVar.f1215b;
        }
        boolean z2 = i >= this.f;
        boolean z3 = this.g;
        if (c == 2 || (c == 1 && z3 && !z2)) {
            z = true;
        }
        this.g = z;
        return z;
    }

    public final void a(boolean z) {
        this.f = 0;
        this.g = false;
        if (z) {
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = this.a;
            synchronized (kVar) {
                if (kVar.a) {
                    synchronized (kVar) {
                        boolean z2 = kVar.e > 0;
                        kVar.e = 0;
                        if (z2) {
                            kVar.b();
                        }
                    }
                }
            }
        }
    }
}
