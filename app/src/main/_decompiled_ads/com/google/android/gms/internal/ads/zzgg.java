package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgg extends zzgc {
    private zzgn zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzgg() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        int i4 = zzfk.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzg(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final long zzb(zzgn zzgnVar) throws IOException {
        zzi(zzgnVar);
        this.zza = zzgnVar;
        Uri uriNormalizeScheme = zzgnVar.zza.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        zzdx.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        int i = zzfk.zza;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw zzcc.zzb("Unexpected URI format: ".concat(String.valueOf(String.valueOf(uriNormalizeScheme))), null);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw zzcc.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e);
            }
        } else {
            this.zzb = URLDecoder.decode(str, zzfsi.zza.name()).getBytes(zzfsi.zzc);
        }
        long j = zzgnVar.zzf;
        int length = this.zzb.length;
        if (j > length) {
            this.zzb = null;
            throw new zzgj(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        int i2 = (int) j;
        this.zzc = i2;
        int i3 = length - i2;
        this.zzd = i3;
        long j2 = zzgnVar.zzg;
        if (j2 != -1) {
            this.zzd = (int) Math.min(i3, j2);
        }
        zzj(zzgnVar);
        long j3 = zzgnVar.zzg;
        return j3 != -1 ? j3 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final Uri zzc() {
        zzgn zzgnVar = this.zza;
        if (zzgnVar != null) {
            return zzgnVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
