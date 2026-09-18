package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends InputStream {
    public final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f1213b;
    public long f;
    public boolean d = false;
    public boolean e = false;
    public final byte[] c = new byte[1];

    public i(g gVar, j jVar) {
        this.a = gVar;
        this.f1213b = jVar;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.e) {
            return;
        }
        this.a.close();
        this.e = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(!this.e);
        if (!this.d) {
            this.a.a(this.f1213b);
            this.d = true;
        }
        int iA = this.a.a(bArr, i, i2);
        if (iA == -1) {
            return -1;
        }
        this.f += (long) iA;
        return iA;
    }
}
