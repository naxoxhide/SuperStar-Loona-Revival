package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdon {
    private final zzcxj zza;
    private final zzcys zzb;
    private final zzczf zzc;
    private final zzczr zzd;
    private final zzdcf zze;
    private final zzdfb zzf;

    zzdon(zzcxj zzcxjVar, zzcys zzcysVar, zzczf zzczfVar, zzczr zzczrVar, zzdcf zzdcfVar, zzdfb zzdfbVar) {
        this.zza = zzcxjVar;
        this.zzb = zzcysVar;
        this.zzc = zzczfVar;
        this.zzd = zzczrVar;
        this.zze = zzdcfVar;
        this.zzf = zzdfbVar;
    }

    public final void zza(zzdoo zzdooVar) {
        final zzcys zzcysVar = this.zzb;
        zzdol zzdolVar = zzdooVar.zza;
        zzcysVar.getClass();
        zzdolVar.zzi(this.zza, this.zzc, this.zzd, this.zze, new com.google.android.gms.ads.internal.overlay.zzz() { // from class: com.google.android.gms.internal.ads.zzdom
            @Override // com.google.android.gms.ads.internal.overlay.zzz
            public final void zzg() {
                zzcysVar.zzb();
            }
        }, this.zzf);
    }
}
