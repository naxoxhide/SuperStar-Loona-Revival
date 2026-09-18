package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements g {
    public final a0<? super q> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RandomAccessFile f1221b;
    public Uri c;
    public long d;
    public boolean e;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public q(a0<? super q> a0Var) {
        this.a = a0Var;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public long a(j jVar) throws a {
        try {
            this.c = jVar.a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(jVar.a.getPath(), CampaignEx.JSON_KEY_AD_R);
            this.f1221b = randomAccessFile;
            randomAccessFile.seek(jVar.d);
            long length = jVar.e;
            if (length == -1) {
                length = this.f1221b.length() - jVar.d;
            }
            this.d = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.e = true;
            a0<? super q> a0Var = this.a;
            if (a0Var != null) {
                ((l) a0Var).a(this, jVar);
            }
            return this.d;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x001d */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void close() throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.q.a {
        /*
            r4 = this;
            r0 = 0
            r4.c = r0
            r1 = 0
            java.io.RandomAccessFile r2 = r4.f1221b     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L1f
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L1f
        Lb:
            r4.f1221b = r0
            boolean r0 = r4.e
            if (r0 == 0) goto L1c
            r4.e = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a0<? super com.fyber.inneractive.sdk.player.exoplayer2.upstream.q> r0 = r4.a
            if (r0 == 0) goto L1c
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l r0 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) r0
            r0.a(r4)
        L1c:
            return
        L1d:
            r2 = move-exception
            goto L26
        L1f:
            r2 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.q$a r3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.q$a     // Catch: java.lang.Throwable -> L1d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L1d
            throw r3     // Catch: java.lang.Throwable -> L1d
        L26:
            r4.f1221b = r0
            boolean r0 = r4.e
            if (r0 == 0) goto L37
            r4.e = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a0<? super com.fyber.inneractive.sdk.player.exoplayer2.upstream.q> r0 = r4.a
            if (r0 == 0) goto L37
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l r0 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) r0
            r0.a(r4)
        L37:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.q.close():void");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        try {
            int i3 = this.f1221b.read(bArr, i, (int) Math.min(j, i2));
            if (i3 > 0) {
                long j2 = i3;
                this.d -= j2;
                a0<? super q> a0Var = this.a;
                if (a0Var != null) {
                    l lVar = (l) a0Var;
                    synchronized (lVar) {
                        lVar.d += j2;
                    }
                }
            }
            return i3;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public Uri a() {
        return this.c;
    }
}
