package com.applovin.exoplayer2.k;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.ApplicationMediaCapabilities;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.exoplayer2.l.ai;
import com.facebook.ads.AdError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public final class f extends e {
    private long Zj;
    private boolean Zk;
    private final ContentResolver Zq;
    private AssetFileDescriptor Zr;
    private FileInputStream Zs;
    private Uri ef;

    public static class b extends j {
        public b(IOException iOException, int i) {
            super(iOException, i);
        }
    }

    public f(Context context) {
        super(false);
        this.Zq = context.getContentResolver();
    }

    @Override // com.applovin.exoplayer2.k.i
    public long a(l lVar) throws b {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            Uri uri = lVar.ef;
            this.ef = uri;
            b(lVar);
            if ("content".equals(lVar.ef.getScheme())) {
                Bundle bundle = new Bundle();
                if (ai.acV >= 31) {
                    a.E(bundle);
                }
                assetFileDescriptorOpenAssetFileDescriptor = this.Zq.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.Zq.openAssetFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
            }
            this.Zr = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new b(new IOException("Could not open file descriptor for: " + uri), 2000);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.Zs = fileInputStream;
            if (length != -1 && lVar.uc > length) {
                throw new b(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(lVar.uc + startOffset) - startOffset;
            if (jSkip != lVar.uc) {
                throw new b(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.Zj = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.Zj = jPosition;
                    if (jPosition < 0) {
                        throw new b(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
            } else {
                long j = length - jSkip;
                this.Zj = j;
                if (j < 0) {
                    throw new b(null, AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            }
            if (lVar.wC != -1) {
                long j2 = this.Zj;
                this.Zj = j2 == -1 ? lVar.wC : Math.min(j2, lVar.wC);
            }
            this.Zk = true;
            c(lVar);
            return lVar.wC != -1 ? lVar.wC : this.Zj;
        } catch (b e) {
            throw e;
        } catch (IOException e2) {
            throw new b(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.applovin.exoplayer2.k.g
    public int read(byte[] bArr, int i, int i2) throws b {
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
                throw new b(e, 2000);
            }
        }
        int i3 = ((FileInputStream) ai.R(this.Zs)).read(bArr, i, i2);
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

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0055 */
    @Override // com.applovin.exoplayer2.k.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void close() throws com.applovin.exoplayer2.k.f.b {
        /*
            r5 = this;
            r0 = 0
            r5.ef = r0
            r1 = 2000(0x7d0, float:2.803E-42)
            r2 = 0
            java.io.FileInputStream r3 = r5.Zs     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L39
            if (r3 == 0) goto Ld
            r3.close()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L39
        Ld:
            r5.Zs = r0
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
            com.applovin.exoplayer2.k.f$b r4 = new com.applovin.exoplayer2.k.f$b     // Catch: java.lang.Throwable -> L22
            r4.<init>(r3, r1)     // Catch: java.lang.Throwable -> L22
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
            com.applovin.exoplayer2.k.f$b r4 = new com.applovin.exoplayer2.k.f$b     // Catch: java.lang.Throwable -> L37
            r4.<init>(r3, r1)     // Catch: java.lang.Throwable -> L37
            throw r4     // Catch: java.lang.Throwable -> L37
        L40:
            r5.Zs = r0
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
            com.applovin.exoplayer2.k.f$b r4 = new com.applovin.exoplayer2.k.f$b     // Catch: java.lang.Throwable -> L55
            r4.<init>(r3, r1)     // Catch: java.lang.Throwable -> L55
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
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.k.f.close():void");
    }

    private static final class a {
        public static void E(Bundle bundle) {
            bundle.putParcelable("android.provider.extra.MEDIA_CAPABILITIES", new ApplicationMediaCapabilities.Builder().addSupportedVideoMimeType("video/hevc").addSupportedHdrType("android.media.feature.hdr.dolby_vision").addSupportedHdrType("android.media.feature.hdr.hdr10").addSupportedHdrType("android.media.feature.hdr.hdr10_plus").addSupportedHdrType("android.media.feature.hdr.hlg").build());
        }
    }
}
