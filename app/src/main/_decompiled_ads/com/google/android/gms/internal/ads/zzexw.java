package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzexw implements zzfzp {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzfit zzc;
    final /* synthetic */ zzexy zzd;
    final /* synthetic */ zzexz zze;

    zzexw(zzexz zzexzVar, zzemz zzemzVar, zzfje zzfjeVar, zzfit zzfitVar, zzexy zzexyVar) {
        this.zze = zzexzVar;
        this.zza = zzemzVar;
        this.zzb = zzfjeVar;
        this.zzc = zzfitVar;
        this.zzd = zzexyVar;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.gms.internal.ads.zzcqf, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        zzfje zzfjeVar;
        zzcqf zzcqfVar = (zzcqf) this.zze.zze.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzcqfVar == null ? zzfeo.zzb(th, null) : zzcqfVar.zzb().zza(th);
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (zzcqfVar != null) {
                zzcqfVar.zzc().zzbF(zzeVarZzb);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhV)).booleanValue()) {
                    this.zze.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexv
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zzd.zzbF(zzeVarZzb);
                        }
                    });
                }
            } else {
                this.zze.zzd.zzbF(zzeVarZzb);
                this.zze.zzm(this.zzd).zzh().zzb().zzc().zzh();
            }
            zzfei.zzb(zzeVarZzb.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbdu.zzc.zze()).booleanValue() || (zzfjeVar = this.zzb) == null) {
                zzfjh zzfjhVar = this.zze.zzh;
                zzfit zzfitVar = this.zzc;
                zzfitVar.zza(zzeVarZzb);
                zzfitVar.zzg(th);
                zzfitVar.zzf(false);
                zzfjhVar.zzb(zzfitVar.zzl());
            } else {
                zzfjeVar.zzc(zzeVarZzb);
                zzfit zzfitVar2 = this.zzc;
                zzfitVar2.zzg(th);
                zzfitVar2.zzf(false);
                zzfjeVar.zza(zzfitVar2);
                zzfjeVar.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfje zzfjeVar;
        zzcsx zzcsxVar = (zzcsx) obj;
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhV)).booleanValue()) {
                zzcsxVar.zzn().zzb(this.zze.zzd);
            }
            this.zza.zzb(zzcsxVar);
            if (!((Boolean) zzbdu.zzc.zze()).booleanValue() || (zzfjeVar = this.zzb) == null) {
                zzfjh zzfjhVar = this.zze.zzh;
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
