package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.z;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.g {
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g f1204b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g d;
    public final a e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.g i;
    public boolean j;
    public Uri k;
    public int l;
    public String m;
    public long n;
    public long o;
    public g p;
    public boolean q;
    public boolean r;
    public long s;

    public interface a {
        void a(long j, long j2);
    }

    public d(com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a aVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar2, com.fyber.inneractive.sdk.player.exoplayer2.upstream.f fVar, int i, a aVar2) {
        this.a = aVar;
        this.f1204b = gVar2;
        this.f = (i & 1) != 0;
        this.g = (i & 2) != 0;
        this.h = (i & 4) != 0;
        this.d = gVar;
        if (fVar != null) {
            this.c = new z(gVar, fVar);
        } else {
            this.c = null;
        }
        this.e = aVar2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar) throws IOException {
        try {
            Uri uri = jVar.a;
            this.k = uri;
            this.l = jVar.g;
            String string = jVar.f;
            if (string == null) {
                string = uri.toString();
            }
            this.m = string;
            this.n = jVar.d;
            boolean z = (this.g && this.q) || (jVar.e == -1 && this.h);
            this.r = z;
            long j = jVar.e;
            if (j != -1 || z) {
                this.o = j;
            } else {
                long jA = this.a.a(string);
                this.o = jA;
                if (jA != -1) {
                    long j2 = jA - jVar.d;
                    this.o = j2;
                    if (j2 <= 0) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.h(0);
                    }
                }
            }
            a(true);
            return this.o;
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    public final void b() throws IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar = this.i;
        if (gVar == null) {
            return;
        }
        try {
            gVar.close();
            this.i = null;
            this.j = false;
        } finally {
            g gVar2 = this.p;
            if (gVar2 != null) {
                this.a.b(gVar2);
                this.p = null;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public void close() throws IOException {
        this.k = null;
        a aVar = this.e;
        if (aVar != null && this.s > 0) {
            aVar.a(this.a.a(), this.s);
            this.s = 0L;
        }
        try {
            b();
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.o == 0) {
            return -1;
        }
        try {
            int iA = this.i.a(bArr, i, i2);
            if (iA >= 0) {
                if (this.i == this.f1204b) {
                    this.s += (long) iA;
                }
                long j = iA;
                this.n += j;
                long j2 = this.o;
                if (j2 != -1) {
                    this.o = j2 - j;
                }
            } else {
                if (this.j) {
                    long j3 = this.n;
                    if (this.i == this.c) {
                        this.a.a(this.m, j3);
                    }
                    this.o = 0L;
                }
                b();
                long j4 = this.o;
                if ((j4 > 0 || j4 == -1) && a(false)) {
                    return a(bArr, i, i2);
                }
            }
            return iA;
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public Uri a() {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar = this.i;
        return gVar == this.d ? gVar.a() : this.k;
    }

    public final boolean a(boolean z) throws IOException {
        g gVarB;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar;
        IOException iOException = null;
        if (this.r) {
            gVarB = null;
        } else if (this.f) {
            try {
                gVarB = this.a.b(this.m, this.n);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else {
            gVarB = this.a.c(this.m, this.n);
        }
        boolean z2 = true;
        if (gVarB == null) {
            this.i = this.d;
            Uri uri = this.k;
            long j = this.n;
            jVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uri, null, j, j, this.o, this.m, this.l);
        } else if (gVarB.d) {
            Uri uriFromFile = Uri.fromFile(gVarB.e);
            long j2 = this.n - gVarB.f1206b;
            long jMin = gVarB.c - j2;
            long j3 = this.o;
            if (j3 != -1) {
                jMin = Math.min(jMin, j3);
            }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uriFromFile, null, this.n, j2, jMin, this.m, this.l);
            this.i = this.f1204b;
            jVar = jVar2;
        } else {
            long jMin2 = gVarB.c;
            if (jMin2 == -1) {
                jMin2 = this.o;
            } else {
                long j4 = this.o;
                if (j4 != -1) {
                    jMin2 = Math.min(jMin2, j4);
                }
            }
            Uri uri2 = this.k;
            long j5 = this.n;
            jVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(uri2, null, j5, j5, jMin2, this.m, this.l);
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar = this.c;
            if (gVar != null) {
                this.i = gVar;
                this.p = gVarB;
            } else {
                this.i = this.d;
                this.a.b(gVarB);
            }
        }
        this.j = jVar.e == -1;
        long jA = 0;
        try {
            jA = this.i.a(jVar);
        } catch (IOException e) {
            if (!z && this.j) {
                Throwable cause = e;
                while (true) {
                    if (cause == null) {
                        iOException = e;
                        break;
                    }
                    if ((cause instanceof com.fyber.inneractive.sdk.player.exoplayer2.upstream.h) && ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.h) cause).a == 0) {
                        break;
                    }
                    cause = cause.getCause();
                }
            } else {
                iOException = e;
                break;
            }
            if (iOException != null) {
                throw iOException;
            }
            z2 = false;
        }
        if (this.j && jA != -1) {
            this.o = jA;
            long j6 = jVar.d + jA;
            if (this.i == this.c) {
                this.a.a(this.m, j6);
            }
        }
        return z2;
    }

    public final void a(IOException iOException) {
        if (this.i == this.f1204b || (iOException instanceof com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0298a)) {
            this.q = true;
        }
    }
}
