package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcfc implements zzgi {
    private final zzgi zza;
    private final long zzb;
    private final zzgi zzc;
    private long zzd;
    private Uri zze;

    zzcfc(zzgi zzgiVar, int i, zzgi zzgiVar2) {
        this.zza = zzgiVar;
        this.zzb = i;
        this.zzc = zzgiVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int iZza = this.zza.zza(bArr, i, (int) Math.min(i2, j2 - j));
            long j3 = this.zzd + ((long) iZza);
            this.zzd = j3;
            i3 = iZza;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < this.zzb) {
            return i3;
        }
        int iZza2 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + iZza2;
        this.zzd += (long) iZza2;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final long zzb(zzgn zzgnVar) throws IOException {
        zzgn zzgnVar2;
        this.zze = zzgnVar.zza;
        long j = this.zzb;
        long j2 = zzgnVar.zzf;
        zzgn zzgnVar3 = null;
        if (j2 >= j) {
            zzgnVar2 = null;
        } else {
            long j3 = zzgnVar.zzg;
            long jMin = j - j2;
            if (j3 != -1) {
                jMin = Math.min(j3, jMin);
            }
            zzgnVar2 = new zzgn(zzgnVar.zza, null, j2, j2, jMin, null, 0);
        }
        long j4 = zzgnVar.zzg;
        if (j4 == -1 || zzgnVar.zzf + j4 > this.zzb) {
            long jMax = Math.max(this.zzb, zzgnVar.zzf);
            long j5 = zzgnVar.zzg;
            zzgnVar3 = new zzgn(zzgnVar.zza, null, jMax, jMax, j5 != -1 ? Math.min(j5, (zzgnVar.zzf + j5) - this.zzb) : -1L, null, 0);
        }
        long jZzb = zzgnVar2 != null ? this.zza.zzb(zzgnVar2) : 0L;
        long jZzb2 = zzgnVar3 != null ? this.zzc.zzb(zzgnVar3) : 0L;
        this.zzd = zzgnVar.zzf;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final Map zze() {
        return zzfvv.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzf(zzhk zzhkVar) {
    }
}
