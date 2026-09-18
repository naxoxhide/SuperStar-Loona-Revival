package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.AdError;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhi extends zzgc {
    private final Resources zza;
    private final String zzb;
    private Uri zzc;
    private AssetFileDescriptor zzd;
    private InputStream zze;
    private long zzf;
    private boolean zzg;

    public zzhi(Context context) {
        super(false);
        this.zza = context.getResources();
        this.zzb = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i, int i2) throws zzhh {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzf;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new zzhh(null, e, 2000);
            }
        }
        InputStream inputStream = this.zze;
        int i3 = zzfk.zza;
        int i4 = inputStream.read(bArr, i, i2);
        if (i4 == -1) {
            if (this.zzf == -1) {
                return -1;
            }
            throw new zzhh("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j2 = this.zzf;
        if (j2 != -1) {
            this.zzf = j2 - ((long) i4);
        }
        zzg(i4);
        return i4;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgi
    public final long zzb(zzgn zzgnVar) throws zzhh {
        int identifier;
        long size;
        Uri uriNormalizeScheme = zzgnVar.zza.normalizeScheme();
        this.zzc = uriNormalizeScheme;
        if (TextUtils.equals("rawresource", uriNormalizeScheme.getScheme())) {
            try {
                String lastPathSegment = uriNormalizeScheme.getLastPathSegment();
                Objects.requireNonNull(lastPathSegment);
                identifier = Integer.parseInt(lastPathSegment);
            } catch (NumberFormatException unused) {
                throw new zzhh("Resource identifier must be an integer.", null, PointerIconCompat.TYPE_WAIT);
            }
        } else {
            if (TextUtils.equals("android.resource", uriNormalizeScheme.getScheme()) && uriNormalizeScheme.getPathSegments().size() == 1) {
                String lastPathSegment2 = uriNormalizeScheme.getLastPathSegment();
                Objects.requireNonNull(lastPathSegment2);
                if (lastPathSegment2.matches("\\d+")) {
                    String lastPathSegment3 = uriNormalizeScheme.getLastPathSegment();
                    Objects.requireNonNull(lastPathSegment3);
                    identifier = Integer.parseInt(lastPathSegment3);
                }
            }
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                throw new zzhh("Unsupported URI scheme (" + uriNormalizeScheme.getScheme() + "). Only rawresource and android.resource are supported.", null, PointerIconCompat.TYPE_WAIT);
            }
            String path = uriNormalizeScheme.getPath();
            Objects.requireNonNull(path);
            if (path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                path = path.substring(1);
            }
            String host = uriNormalizeScheme.getHost();
            identifier = this.zza.getIdentifier((TextUtils.isEmpty(host) ? "" : String.valueOf(host).concat(CertificateUtil.DELIMITER)).concat(String.valueOf(path)), "raw", this.zzb);
            if (identifier == 0) {
                throw new zzhh("Resource not found.", null, 2005);
            }
        }
        zzi(zzgnVar);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.zza.openRawResourceFd(identifier);
            this.zzd = assetFileDescriptorOpenRawResourceFd;
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new zzhh("Resource is compressed: ".concat(String.valueOf(String.valueOf(uriNormalizeScheme))), null, 2000);
            }
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
            this.zze = fileInputStream;
            if (length != -1) {
                try {
                    if (zzgnVar.zzf > length) {
                        throw new zzhh(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                } catch (zzhh e) {
                    throw e;
                } catch (IOException e2) {
                    throw new zzhh(null, e2, 2000);
                }
            }
            long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
            long jSkip = fileInputStream.skip(zzgnVar.zzf + startOffset) - startOffset;
            if (jSkip != zzgnVar.zzf) {
                throw new zzhh(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.zzf = -1L;
                    size = -1;
                } else {
                    size = channel.size() - channel.position();
                    this.zzf = size;
                    if (size < 0) {
                        throw new zzhh(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
            } else {
                size = length - jSkip;
                this.zzf = size;
                if (size < 0) {
                    throw new zzgj(AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            }
            long jMin = zzgnVar.zzg;
            if (jMin != -1) {
                if (size != -1) {
                    jMin = Math.min(size, jMin);
                }
                this.zzf = jMin;
            }
            this.zzg = true;
            zzj(zzgnVar);
            long j = zzgnVar.zzg;
            return j != -1 ? j : this.zzf;
        } catch (Resources.NotFoundException e3) {
            throw new zzhh(null, e3, 2005);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final Uri zzc() {
        return this.zzc;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0055 */
    @Override // com.google.android.gms.internal.ads.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd() throws com.google.android.gms.internal.ads.zzhh {
        /*
            r5 = this;
            r0 = 0
            r5.zzc = r0
            r1 = 2000(0x7d0, float:2.803E-42)
            r2 = 0
            java.io.InputStream r3 = r5.zze     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L39
            if (r3 == 0) goto Ld
            r3.close()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L39
        Ld:
            r5.zze = r0
            android.content.res.AssetFileDescriptor r3 = r5.zzd     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
            if (r3 == 0) goto L16
            r3.close()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
        L16:
            r5.zzd = r0
            boolean r0 = r5.zzg
            if (r0 == 0) goto L21
            r5.zzg = r2
            r5.zzh()
        L21:
            return
        L22:
            r1 = move-exception
            goto L2b
        L24:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzhh r4 = new com.google.android.gms.internal.ads.zzhh     // Catch: java.lang.Throwable -> L22
            r4.<init>(r0, r3, r1)     // Catch: java.lang.Throwable -> L22
            throw r4     // Catch: java.lang.Throwable -> L22
        L2b:
            r5.zzd = r0
            boolean r0 = r5.zzg
            if (r0 == 0) goto L36
            r5.zzg = r2
            r5.zzh()
        L36:
            throw r1
        L37:
            r3 = move-exception
            goto L40
        L39:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzhh r4 = new com.google.android.gms.internal.ads.zzhh     // Catch: java.lang.Throwable -> L37
            r4.<init>(r0, r3, r1)     // Catch: java.lang.Throwable -> L37
            throw r4     // Catch: java.lang.Throwable -> L37
        L40:
            r5.zze = r0
            android.content.res.AssetFileDescriptor r4 = r5.zzd     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            if (r4 == 0) goto L49
            r4.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
        L49:
            r5.zzd = r0
            boolean r0 = r5.zzg
            if (r0 == 0) goto L54
            r5.zzg = r2
            r5.zzh()
        L54:
            throw r3
        L55:
            r1 = move-exception
            goto L5e
        L57:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzhh r4 = new com.google.android.gms.internal.ads.zzhh     // Catch: java.lang.Throwable -> L55
            r4.<init>(r0, r3, r1)     // Catch: java.lang.Throwable -> L55
            throw r4     // Catch: java.lang.Throwable -> L55
        L5e:
            r5.zzd = r0
            boolean r0 = r5.zzg
            if (r0 != 0) goto L65
            goto L6a
        L65:
            r5.zzg = r2
            r5.zzh()
        L6a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhi.zzd():void");
    }
}
