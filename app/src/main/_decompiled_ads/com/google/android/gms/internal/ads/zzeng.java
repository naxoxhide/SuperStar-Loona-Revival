package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeng implements zzfzp {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzfit zzc;
    final /* synthetic */ zzdht zzd;
    final /* synthetic */ zzenh zze;

    zzeng(zzenh zzenhVar, zzemz zzemzVar, zzfje zzfjeVar, zzfit zzfitVar, zzdht zzdhtVar) {
        this.zze = zzenhVar;
        this.zza = zzemzVar;
        this.zzb = zzfjeVar;
        this.zzc = zzfitVar;
        this.zzd = zzdhtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        zzfje zzfjeVar;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zzd.zza().zza(th);
        this.zzd.zzb().zzbF(zzeVarZza);
        this.zze.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzenf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze.zzd.zza().zzbF(zzeVarZza);
            }
        });
        zzfei.zzb(zzeVarZza.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (((Boolean) zzbdu.zzc.zze()).booleanValue() && (zzfjeVar = this.zzb) != null) {
            zzfjeVar.zzc(zzeVarZza);
            zzfit zzfitVar = this.zzc;
            zzfitVar.zzg(th);
            zzfitVar.zzf(false);
            zzfjeVar.zza(zzfitVar);
            zzfjeVar.zzg();
            return;
        }
        zzenh zzenhVar = this.zze;
        zzfit zzfitVar2 = this.zzc;
        zzfjh zzfjhVar = zzenhVar.zze;
        zzfitVar2.zza(zzeVarZza);
        zzfitVar2.zzg(th);
        zzfitVar2.zzf(false);
        zzfjhVar.zzb(zzfitVar2.zzl());
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfje zzfjeVar;
        zzcsx zzcsxVar = (zzcsx) obj;
        synchronized (this.zze) {
            zzcsxVar.zzn().zza(this.zze.zzd.zzd());
            this.zza.zzb(zzcsxVar);
            this.zze.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzene
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zze.zzd.zzb().zzr();
                }
            });
            if (!((Boolean) zzbdu.zzc.zze()).booleanValue() || (zzfjeVar = this.zzb) == null) {
                zzfjh zzfjhVar = this.zze.zze;
                zzfit zzfitVar = this.zzc;
                zzfitVar.zzb(zzcsxVar.zzp().zzb);
                zzfitVar.zzd(zzcsxVar.zzl().zzg());
                zzfitVar.zzf(true);
                zzfjhVar.zzb(zzfitVar.zzl());
            } else {
                zzfjeVar.zzf(zzcsxVar.zzp().zzb);
                zzfjeVar.zze(zzcsxVar.zzl().zzg());
                zzfit zzfitVar2 = this.zzc;
                zzfitVar2.zzf(true);
                zzfjeVar.zza(zzfitVar2);
                zzfjeVar.zzg();
            }
        }
    }
}
