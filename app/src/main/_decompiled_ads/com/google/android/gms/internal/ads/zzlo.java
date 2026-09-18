package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlo extends zztk {
    private final zzcu zzd;

    zzlo(zzlp zzlpVar, zzcv zzcvVar) {
        super(zzcvVar);
        this.zzd = new zzcu();
    }

    @Override // com.google.android.gms.internal.ads.zztk, com.google.android.gms.internal.ads.zzcv
    public final zzcs zzd(int i, zzcs zzcsVar, boolean z) {
        zzcs zzcsVarZzd = this.zzc.zzd(i, zzcsVar, z);
        if (this.zzc.zze(zzcsVarZzd.zzd, this.zzd, 0L).zzb()) {
            Object obj = zzcsVar.zzb;
            Object obj2 = zzcsVar.zzc;
            int i2 = zzcsVar.zzd;
            long j = zzcsVar.zze;
            long j2 = zzcsVar.zzf;
            zzcsVarZzd.zzl(obj, obj2, i2, j, 0L, zzd.zza, true);
        } else {
            zzcsVarZzd.zzg = true;
        }
        return zzcsVarZzd;
    }
}
