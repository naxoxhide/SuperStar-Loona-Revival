package com.applovin.exoplayer2.k;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.applovin.exoplayer2.l.ai;
import com.facebook.ads.AdError;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e {
    private final AssetManager Zh;
    private InputStream Zi;
    private long Zj;
    private boolean Zk;
    private Uri ef;

    public static final class a extends j {
        public a(Throwable th, int i) {
            super(th, i);
        }
    }

    public c(Context context) {
        super(false);
        this.Zh = context.getAssets();
    }

    @Override // com.applovin.exoplayer2.k.i
    public long a(l lVar) throws a {
        try {
            Uri uri = lVar.ef;
            this.ef = uri;
            String strSubstring = (String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                strSubstring = strSubstring.substring(1);
            }
            b(lVar);
            InputStream inputStreamOpen = this.Zh.open(strSubstring, 1);
            this.Zi = inputStreamOpen;
            if (inputStreamOpen.skip(lVar.uc) < lVar.uc) {
                throw new a(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            if (lVar.wC != -1) {
                this.Zj = lVar.wC;
            } else {
                long jAvailable = this.Zi.available();
                this.Zj = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.Zj = -1L;
                }
            }
            this.Zk = true;
            c(lVar);
            return this.Zj;
        } catch (a e) {
            throw e;
        } catch (IOException e2) {
            throw new a(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.applovin.exoplayer2.k.g
    public int read(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.Zj;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new a(e, 2000);
            }
        }
        int i3 = ((InputStream) ai.R(this.Zi)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        long j2 = this.Zj;
        if (j2 != -1) {
            this.Zj = j2 - ((long) i3);
        }
        fe(i3);
        return i3;
    }

    @Override // com.applovin.exoplayer2.k.i
    public Uri getUri() {
        return this.ef;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0017 */
    @Override // com.applovin.exoplayer2.k.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void close() throws com.applovin.exoplayer2.k.c.a {
        /*
            r5 = this;
            r0 = 0
            r5.ef = r0
            r1 = 0
            java.io.InputStream r2 = r5.Zi     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
        Lb:
            r5.Zi = r0
            boolean r0 = r5.Zk
            if (r0 == 0) goto L16
            r5.Zk = r1
            r5.oe()
        L16:
            return
        L17:
            r2 = move-exception
            goto L22
        L19:
            r2 = move-exception
            com.applovin.exoplayer2.k.c$a r3 = new com.applovin.exoplayer2.k.c$a     // Catch: java.lang.Throwable -> L17
            r4 = 2000(0x7d0, float:2.803E-42)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L17
            throw r3     // Catch: java.lang.Throwable -> L17
        L22:
            r5.Zi = r0
            boolean r0 = r5.Zk
            if (r0 == 0) goto L2d
            r5.Zk = r1
            r5.oe()
        L2d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.k.c.close():void");
    }
}
