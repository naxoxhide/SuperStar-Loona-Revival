package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements g {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1240b;
    public long c;
    public com.fyber.inneractive.sdk.player.exoplayer2.m d = com.fyber.inneractive.sdk.player.exoplayer2.m.d;

    public void a(long j) {
        this.f1240b = j;
        if (this.a) {
            this.c = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.g
    public com.fyber.inneractive.sdk.player.exoplayer2.m i() {
        return this.d;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.g
    public long o() {
        long j = this.f1240b;
        if (!this.a) {
            return j;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        com.fyber.inneractive.sdk.player.exoplayer2.m mVar = this.d;
        return j + (mVar.a == 1.0f ? com.fyber.inneractive.sdk.player.exoplayer2.b.a(jElapsedRealtime) : jElapsedRealtime * ((long) mVar.c));
    }

    public void a(g gVar) {
        a(gVar.o());
        this.d = gVar.i();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.g
    public com.fyber.inneractive.sdk.player.exoplayer2.m a(com.fyber.inneractive.sdk.player.exoplayer2.m mVar) {
        if (this.a) {
            a(o());
        }
        this.d = mVar;
        return mVar;
    }
}
