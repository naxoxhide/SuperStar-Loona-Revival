package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements g {
    public final AssetManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0<? super c> f1201b;
    public Uri c;
    public InputStream d;
    public long e;
    public boolean f;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context, a0<? super c> a0Var) {
        this.a = context.getAssets();
        this.f1201b = a0Var;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public long a(j jVar) throws a {
        try {
            Uri uri = jVar.a;
            this.c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                path = path.substring(1);
            }
            InputStream inputStreamOpen = this.a.open(path, 1);
            this.d = inputStreamOpen;
            if (inputStreamOpen.skip(jVar.d) < jVar.d) {
                throw new EOFException();
            }
            long j = jVar.e;
            if (j != -1) {
                this.e = j;
            } else {
                long jAvailable = this.d.available();
                this.e = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.e = -1L;
                }
            }
            this.f = true;
            a0<? super c> a0Var = this.f1201b;
            if (a0Var != null) {
                ((l) a0Var).a(this, jVar);
            }
            return this.e;
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
    public void close() throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.c.a {
        /*
            r4 = this;
            r0 = 0
            r4.c = r0
            r1 = 0
            java.io.InputStream r2 = r4.d     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L1f
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L1f
        Lb:
            r4.d = r0
            boolean r0 = r4.f
            if (r0 == 0) goto L1c
            r4.f = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a0<? super com.fyber.inneractive.sdk.player.exoplayer2.upstream.c> r0 = r4.f1201b
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
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.c$a r3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.c$a     // Catch: java.lang.Throwable -> L1d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L1d
            throw r3     // Catch: java.lang.Throwable -> L1d
        L26:
            r4.d = r0
            boolean r0 = r4.f
            if (r0 == 0) goto L37
            r4.f = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a0<? super com.fyber.inneractive.sdk.player.exoplayer2.upstream.c> r0 = r4.f1201b
            if (r0 == 0) goto L37
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l r0 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) r0
            r0.a(r4)
        L37:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.c.close():void");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new a(e);
            }
        }
        int i3 = this.d.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.e == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - ((long) i3);
        }
        a0<? super c> a0Var = this.f1201b;
        if (a0Var != null) {
            l lVar = (l) a0Var;
            synchronized (lVar) {
                lVar.d += (long) i3;
            }
        }
        return i3;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public Uri a() {
        return this.c;
    }
}
