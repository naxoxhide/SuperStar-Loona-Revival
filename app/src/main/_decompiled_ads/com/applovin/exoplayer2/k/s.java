package com.applovin.exoplayer2.k;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.l.ai;
import com.facebook.ads.AdError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public final class s extends e {
    private long Zj;
    private boolean Zk;
    private RandomAccessFile aaI;
    private Uri ef;

    public static class b extends j {
        public b(Throwable th, int i) {
            super(th, i);
        }

        public b(String str, Throwable th, int i) {
            super(str, th, i);
        }
    }

    public s() {
        super(false);
    }

    @Override // com.applovin.exoplayer2.k.i
    public long a(l lVar) throws b {
        Uri uri = lVar.ef;
        this.ef = uri;
        b(lVar);
        RandomAccessFile randomAccessFileF = f(uri);
        this.aaI = randomAccessFileF;
        try {
            randomAccessFileF.seek(lVar.uc);
            long length = lVar.wC == -1 ? this.aaI.length() - lVar.uc : lVar.wC;
            this.Zj = length;
            if (length < 0) {
                throw new b(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            this.Zk = true;
            c(lVar);
            return this.Zj;
        } catch (IOException e) {
            throw new b(e, 2000);
        }
    }

    @Override // com.applovin.exoplayer2.k.g
    public int read(byte[] bArr, int i, int i2) throws b {
        if (i2 == 0) {
            return 0;
        }
        if (this.Zj == 0) {
            return -1;
        }
        try {
            int i3 = ((RandomAccessFile) ai.R(this.aaI)).read(bArr, i, (int) Math.min(this.Zj, i2));
            if (i3 > 0) {
                this.Zj -= (long) i3;
                fe(i3);
            }
            return i3;
        } catch (IOException e) {
            throw new b(e, 2000);
        }
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
    public void close() throws com.applovin.exoplayer2.k.s.b {
        /*
            r5 = this;
            r0 = 0
            r5.ef = r0
            r1 = 0
            java.io.RandomAccessFile r2 = r5.aaI     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
        Lb:
            r5.aaI = r0
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
            com.applovin.exoplayer2.k.s$b r3 = new com.applovin.exoplayer2.k.s$b     // Catch: java.lang.Throwable -> L17
            r4 = 2000(0x7d0, float:2.803E-42)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L17
            throw r3     // Catch: java.lang.Throwable -> L17
        L22:
            r5.aaI = r0
            boolean r0 = r5.Zk
            if (r0 == 0) goto L2d
            r5.Zk = r1
            r5.oe()
        L2d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.k.s.close():void");
    }

    private static RandomAccessFile f(Uri uri) throws b {
        int i = AdError.INTERNAL_ERROR_2006;
        try {
            return new RandomAccessFile((String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getPath()), CampaignEx.JSON_KEY_AD_R);
        } catch (FileNotFoundException e) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new b(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e, PointerIconCompat.TYPE_WAIT);
            }
            if (ai.acV < 21 || !a.i(e.getCause())) {
                i = 2005;
            }
            throw new b(e, i);
        } catch (SecurityException e2) {
            throw new b(e2, AdError.INTERNAL_ERROR_2006);
        } catch (RuntimeException e3) {
            throw new b(e3, 2000);
        }
    }

    private static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean i(Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }
}
