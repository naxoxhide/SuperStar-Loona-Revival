package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzckw implements zzdtq {
    private final Long zza;
    private final String zzb;
    private final zzcjs zzc;
    private final zzcla zzd;
    private final zzckw zze = this;

    /* synthetic */ zzckw(zzcjs zzcjsVar, zzcla zzclaVar, Long l, String str, zzckv zzckvVar) {
        this.zzc = zzcjsVar;
        this.zzd = zzclaVar;
        this.zza = l;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdtq
    public final zzdua zza() {
        zzcla zzclaVar = this.zzd;
        return zzdub.zza(this.zza.longValue(), zzclaVar.zza, zzdtu.zzc(zzclaVar.zzb), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdtq
    public final zzdue zzb() {
        zzcla zzclaVar = this.zzd;
        return zzduf.zza(this.zza.longValue(), zzclaVar.zza, zzdtu.zzc(zzclaVar.zzb), this.zzc, this.zzb);
    }
}
