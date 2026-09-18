package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements g {
    public final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f1226b;

    public z(g gVar, f fVar) {
        this.a = (g) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(gVar);
        this.f1226b = (f) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(fVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public long a(j jVar) throws IOException {
        long jA = this.a.a(jVar);
        if (jVar.e == -1 && jA != -1) {
            jVar = new j(jVar.a, null, jVar.c, jVar.d, jA, jVar.f, jVar.g);
        }
        this.f1226b.a(jVar);
        return jA;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public void close() throws IOException {
        try {
            this.a.close();
        } finally {
            this.f1226b.close();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public int a(byte[] bArr, int i, int i2) throws IOException {
        int iA = this.a.a(bArr, i, i2);
        if (iA > 0) {
            this.f1226b.a(bArr, i, iA);
        }
        return iA;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public Uri a() {
        return this.a.a();
    }
}
