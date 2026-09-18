package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfat implements zzfzp {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzfit zzc;
    final /* synthetic */ zzdgx zzd;
    final /* synthetic */ zzfau zze;

    zzfat(zzfau zzfauVar, zzemz zzemzVar, zzfje zzfjeVar, zzfit zzfitVar, zzdgx zzdgxVar) {
        this.zze = zzfauVar;
        this.zza = zzemzVar;
        this.zzb = zzfjeVar;
        this.zzc = zzfitVar;
        this.zzd = zzdgxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        zzfje zzfjeVar;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zzd.zza().zza(th);
        synchronized (this.zze) {
            this.zze.zzi = null;
            this.zzd.zzb().zzbF(zzeVarZza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhW)).booleanValue()) {
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfap
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzbF(zzeVarZza);
                    }
                });
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfaq
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zze.zzbF(zzeVarZza);
                    }
                });
            }
            zzfei.zzb(zzeVarZza.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbdu.zzc.zze()).booleanValue() || (zzfjeVar = this.zzb) == null) {
                zzfjh zzfjhVar = this.zze.zzg;
                zzfit zzfitVar = this.zzc;
                zzfitVar.zza(zzeVarZza);
                zzfitVar.zzg(th);
                zzfitVar.zzf(false);
                zzfjhVar.zzb(zzfitVar.zzl());
            } else {
                zzfjeVar.zzc(zzeVarZza);
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
        zzdfw zzdfwVar = (zzdfw) obj;
        synchronized (this.zze) {
            this.zze.zzi = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhW)).booleanValue()) {
                zzdbq zzdbqVarZzn = zzdfwVar.zzn();
                zzdbqVarZzn.zza(this.zze.zzd);
                zzdbqVarZzn.zzd(this.zze.zze);
            }
            this.zza.zzb(zzdfwVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhW)).booleanValue()) {
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfar
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzr();
                    }
                });
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfas
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zze.zzr();
                    }
                });
            }
            if (!((Boolean) zzbdu.zzc.zze()).booleanValue() || (zzfjeVar = this.zzb) == null) {
                zzfjh zzfjhVar = this.zze.zzg;
                zzfit zzfitVar = this.zzc;
                zzfitVar.zzb(zzdfwVar.zzp().zzb);
                zzfitVar.zzd(zzdfwVar.zzl().zzg());
                zzfitVar.zzf(true);
                zzfjhVar.zzb(zzfitVar.zzl());
            } else {
                zzfjeVar.zzf(zzdfwVar.zzp().zzb);
                zzfjeVar.zze(zzdfwVar.zzl().zzg());
                zzfit zzfitVar2 = this.zzc;
                zzfitVar2.zzf(true);
                zzfjeVar.zza(zzfitVar2);
                zzfjeVar.zzg();
            }
        }
    }
}
