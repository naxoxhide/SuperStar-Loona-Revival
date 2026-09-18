package com.applovin.exoplayer2.k;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.l.ai;
import com.facebook.ads.AdError;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public final class x extends e {
    private InputStream Zi;
    private long Zj;
    private boolean Zk;
    private AssetFileDescriptor Zr;
    private final Resources abl;
    private final String abm;
    private Uri ef;

    public static class a extends j {
        public a(String str, Throwable th, int i) {
            super(str, th, i);
        }
    }

    public x(Context context) {
        super(false);
        this.abl = context.getResources();
        this.abm = context.getPackageName();
    }

    @Override // com.applovin.exoplayer2.k.i
    public long a(l lVar) throws a {
        int identifier;
        Uri uri = lVar.ef;
        this.ef = uri;
        if (TextUtils.equals("rawresource", uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                identifier = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.", null, PointerIconCompat.TYPE_WAIT);
            }
        } else if (TextUtils.equals("android.resource", uri.getScheme())) {
            String strSubstring = (String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getPath());
            if (strSubstring.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                strSubstring = strSubstring.substring(1);
            }
            String host = uri.getHost();
            identifier = this.abl.getIdentifier((TextUtils.isEmpty(host) ? "" : host + CertificateUtil.DELIMITER) + strSubstring, "raw", this.abm);
            if (identifier == 0) {
                throw new a("Resource not found.", null, 2005);
            }
        } else {
            throw new a("URI must either use scheme rawresource or android.resource", null, PointerIconCompat.TYPE_WAIT);
        }
        b(lVar);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.abl.openRawResourceFd(identifier);
            this.Zr = assetFileDescriptorOpenRawResourceFd;
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new a("Resource is compressed: " + uri, null, 2000);
            }
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
            this.Zi = fileInputStream;
            if (length != -1) {
                try {
                    if (lVar.uc > length) {
                        throw new a(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                } catch (a e) {
                    throw e;
                } catch (IOException e2) {
                    throw new a(null, e2, 2000);
                }
            }
            long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
            long jSkip = fileInputStream.skip(lVar.uc + startOffset) - startOffset;
            if (jSkip != lVar.uc) {
                throw new a(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.Zj = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.Zj = size;
                    if (size < 0) {
                        throw new a(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
            } else {
                long j = length - jSkip;
                this.Zj = j;
                if (j < 0) {
                    throw new j(AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            }
            if (lVar.wC != -1) {
                long j2 = this.Zj;
                this.Zj = j2 == -1 ? lVar.wC : Math.min(j2, lVar.wC);
            }
            this.Zk = true;
            c(lVar);
            return lVar.wC != -1 ? lVar.wC : this.Zj;
        } catch (Resources.NotFoundException e3) {
            throw new a(null, e3, 2005);
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
                throw new a(null, e, 2000);
            }
        }
        int i3 = ((InputStream) ai.R(this.Zi)).read(bArr, i, i2);
        if (i3 == -1) {
            if (this.Zj == -1) {
                return -1;
            }
            throw new a("End of stream reached having not read sufficient data.", new EOFException(), 2000);
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

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0055 */
    @Override // com.applovin.exoplayer2.k.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void close() throws com.applovin.exoplayer2.k.x.a {
        /*
            r5 = this;
            r0 = 0
            r5.ef = r0
            r1 = 2000(0x7d0, float:2.803E-42)
            r2 = 0
            java.io.InputStream r3 = r5.Zi     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L39
            if (r3 == 0) goto Ld
            r3.close()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L39
        Ld:
            r5.Zi = r0
            android.content.res.AssetFileDescriptor r3 = r5.Zr     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
            if (r3 == 0) goto L16
            r3.close()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
        L16:
            r5.Zr = r0
            boolean r0 = r5.Zk
            if (r0 == 0) goto L21
            r5.Zk = r2
            r5.oe()
        L21:
            return
        L22:
            r1 = move-exception
            goto L2b
        L24:
            r3 = move-exception
            com.applovin.exoplayer2.k.x$a r4 = new com.applovin.exoplayer2.k.x$a     // Catch: java.lang.Throwable -> L22
            r4.<init>(r0, r3, r1)     // Catch: java.lang.Throwable -> L22
            throw r4     // Catch: java.lang.Throwable -> L22
        L2b:
            r5.Zr = r0
            boolean r0 = r5.Zk
            if (r0 == 0) goto L36
            r5.Zk = r2
            r5.oe()
        L36:
            throw r1
        L37:
            r3 = move-exception
            goto L40
        L39:
            r3 = move-exception
            com.applovin.exoplayer2.k.x$a r4 = new com.applovin.exoplayer2.k.x$a     // Catch: java.lang.Throwable -> L37
            r4.<init>(r0, r3, r1)     // Catch: java.lang.Throwable -> L37
            throw r4     // Catch: java.lang.Throwable -> L37
        L40:
            r5.Zi = r0
            android.content.res.AssetFileDescriptor r4 = r5.Zr     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            if (r4 == 0) goto L49
            r4.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
        L49:
            r5.Zr = r0
            boolean r0 = r5.Zk
            if (r0 == 0) goto L54
            r5.Zk = r2
            r5.oe()
        L54:
            throw r3
        L55:
            r1 = move-exception
            goto L5e
        L57:
            r3 = move-exception
            com.applovin.exoplayer2.k.x$a r4 = new com.applovin.exoplayer2.k.x$a     // Catch: java.lang.Throwable -> L55
            r4.<init>(r0, r3, r1)     // Catch: java.lang.Throwable -> L55
            throw r4     // Catch: java.lang.Throwable -> L55
        L5e:
            r5.Zr = r0
            boolean r0 = r5.Zk
            if (r0 == 0) goto L69
            r5.Zk = r2
            r5.oe()
        L69:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.k.x.close():void");
    }
}
