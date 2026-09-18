package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcsp {
    private final zzdaa zza;
    private final zzdch zzb;

    public zzcsp(zzdaa zzdaaVar, zzdch zzdchVar) {
        this.zza = zzdaaVar;
        this.zzb = zzdchVar;
    }

    public final zzdaa zza() {
        return this.zza;
    }

    final zzdch zzb() {
        return this.zzb;
    }

    final zzdev zzc() {
        zzdch zzdchVar = this.zzb;
        return zzdchVar != null ? new zzdev(zzdchVar, zzcbg.zzf) : new zzdev(new zzcso(this), zzcbg.zzf);
    }
}
