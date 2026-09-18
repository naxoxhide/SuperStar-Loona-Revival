package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements g {
    public final ContentResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0<? super e> f1212b;
    public Uri c;
    public AssetFileDescriptor d;
    public InputStream e;
    public long f;
    public boolean g;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public e(Context context, a0<? super e> a0Var) {
        this.a = context.getContentResolver();
        this.f1212b = a0Var;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public long a(j jVar) throws a {
        try {
            Uri uri = jVar.a;
            this.c = uri;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.a.openAssetFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
            this.d = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.c);
            }
            this.e = new FileInputStream(this.d.getFileDescriptor());
            long startOffset = this.d.getStartOffset();
            if (this.e.skip(jVar.d + startOffset) - startOffset != jVar.d) {
                throw new EOFException();
            }
            long j = jVar.e;
            if (j != -1) {
                this.f = j;
            } else {
                long length = this.d.getLength();
                this.f = length;
                if (length == -1) {
                    long jAvailable = this.e.available();
                    this.f = jAvailable;
                    if (jAvailable == 0) {
                        this.f = -1L;
                    }
                }
            }
            this.g = true;
            a0<? super e> a0Var = this.f1212b;
            if (a0Var != null) {
                ((l) a0Var).a(this, jVar);
            }
            return this.f;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0026 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0065 */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void close() throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.e.a {
        /*
            r4 = this;
            r0 = 0
            r4.c = r0
            r1 = 0
            java.io.InputStream r2 = r4.e     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
        Lb:
            r4.e = r0
            android.content.res.AssetFileDescriptor r2 = r4.d     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L28
            if (r2 == 0) goto L14
            r2.close()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L28
        L14:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L25
            r4.g = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a0<? super com.fyber.inneractive.sdk.player.exoplayer2.upstream.e> r0 = r4.f1212b
            if (r0 == 0) goto L25
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l r0 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) r0
            r0.a(r4)
        L25:
            return
        L26:
            r2 = move-exception
            goto L2f
        L28:
            r2 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.e$a r3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.e$a     // Catch: java.lang.Throwable -> L26
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L26
            throw r3     // Catch: java.lang.Throwable -> L26
        L2f:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L40
            r4.g = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a0<? super com.fyber.inneractive.sdk.player.exoplayer2.upstream.e> r0 = r4.f1212b
            if (r0 == 0) goto L40
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l r0 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) r0
            r0.a(r4)
        L40:
            throw r2
        L41:
            r2 = move-exception
            goto L4a
        L43:
            r2 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.e$a r3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.e$a     // Catch: java.lang.Throwable -> L41
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L41
            throw r3     // Catch: java.lang.Throwable -> L41
        L4a:
            r4.e = r0
            android.content.res.AssetFileDescriptor r3 = r4.d     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L67
            if (r3 == 0) goto L53
            r3.close()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L67
        L53:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L64
            r4.g = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a0<? super com.fyber.inneractive.sdk.player.exoplayer2.upstream.e> r0 = r4.f1212b
            if (r0 == 0) goto L64
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l r0 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) r0
            r0.a(r4)
        L64:
            throw r2
        L65:
            r2 = move-exception
            goto L6e
        L67:
            r2 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.e$a r3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.e$a     // Catch: java.lang.Throwable -> L65
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L65
            throw r3     // Catch: java.lang.Throwable -> L65
        L6e:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L7f
            r4.g = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a0<? super com.fyber.inneractive.sdk.player.exoplayer2.upstream.e> r0 = r4.f1212b
            if (r0 == 0) goto L7f
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l r0 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) r0
            r0.a(r4)
        L7f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.e.close():void");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
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
        int i3 = this.e.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j2 = this.f;
        if (j2 != -1) {
            this.f = j2 - ((long) i3);
        }
        a0<? super e> a0Var = this.f1212b;
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
