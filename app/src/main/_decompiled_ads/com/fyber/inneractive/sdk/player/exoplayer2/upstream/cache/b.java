package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.util.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.f {
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1202b;
    public final int c;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.j d;
    public File e;
    public OutputStream f;
    public FileOutputStream g;
    public long h;
    public long i;
    public o j;

    public static class a extends com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a aVar, long j, int i) {
        this.a = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(aVar);
        this.f1202b = j;
        this.c = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.f
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar) throws a {
        if (jVar.e == -1 && !jVar.a(2)) {
            this.d = null;
            return;
        }
        this.d = jVar;
        this.i = 0L;
        try {
            b();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    public final void b() throws IOException {
        long j = this.d.e;
        long jMin = j == -1 ? this.f1202b : Math.min(j - this.i, this.f1202b);
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a aVar = this.a;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar = this.d;
        this.e = aVar.a(jVar.f, this.i + jVar.c, jMin);
        FileOutputStream fileOutputStream = new FileOutputStream(this.e);
        this.g = fileOutputStream;
        if (this.c > 0) {
            o oVar = this.j;
            if (oVar == null) {
                this.j = new o(this.g, this.c);
            } else {
                oVar.a(fileOutputStream);
            }
            this.f = this.j;
        } else {
            this.f = fileOutputStream;
        }
        this.h = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.f
    public void close() throws a {
        if (this.d == null) {
            return;
        }
        try {
            a();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.f
    public void a(byte[] bArr, int i, int i2) throws a {
        if (this.d == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.h == this.f1202b) {
                    a();
                    b();
                }
                int iMin = (int) Math.min(i2 - i3, this.f1202b - this.h);
                this.f.write(bArr, i + i3, iMin);
                i3 += iMin;
                long j = iMin;
                this.h += j;
                this.i += j;
            } catch (IOException e) {
                throw new a(e);
            }
        }
    }

    public final void a() throws IOException {
        OutputStream outputStream = this.f;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            this.g.getFD().sync();
            u.a(this.f);
            this.f = null;
            File file = this.e;
            this.e = null;
            this.a.a(file);
        } catch (Throwable th) {
            u.a(this.f);
            this.f = null;
            File file2 = this.e;
            this.e = null;
            file2.delete();
            throw th;
        }
    }
}
