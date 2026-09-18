package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfcb implements zzfzp {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzfit zzc;
    final /* synthetic */ zzfcd zzd;
    final /* synthetic */ zzfce zze;

    zzfcb(zzfce zzfceVar, zzemz zzemzVar, zzfje zzfjeVar, zzfit zzfitVar, zzfcd zzfcdVar) {
        this.zze = zzfceVar;
        this.zza = zzemzVar;
        this.zzb = zzfjeVar;
        this.zzc = zzfitVar;
        this.zzd = zzfcdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        zzfje zzfjeVar;
        zzdpc zzdpcVar = (zzdpc) this.zze.zze.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzdpcVar == null ? zzfeo.zzb(th, null) : zzdpcVar.zzb().zza(th);
        synchronized (this.zze) {
            try {
                if (zzdpcVar != null) {
                    zzdpcVar.zza().zzbF(zzeVarZzb);
                    this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbz
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zzd.zzbF(zzeVarZzb);
                        }
                    });
                } else {
                    this.zze.zzd.zzbF(zzeVarZzb);
                    this.zze.zzk(this.zzd).zzh().zzb().zzc().zzh();
                }
                zzfei.zzb(zzeVarZzb.zza, th, "RewardedAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbdu.zzc.zze()).booleanValue() || (zzfjeVar = this.zzb) == null) {
                    zzfjh zzfjhVar = this.zze.zzg;
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
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfje zzfjeVar;
        zzdox zzdoxVar = (zzdox) obj;
        synchronized (this.zze) {
            zzdoxVar.zzn().zzd(this.zze.zzd);
            this.zza.zzb(zzdoxVar);
            zzfce zzfceVar = this.zze;
            Executor executor = zzfceVar.zzb;
            final zzfbu zzfbuVar = zzfceVar.zzd;
            zzfbuVar.getClass();
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfca
                @Override // java.lang.Runnable
                public final void run() {
                    zzfbuVar.zzr();
                }
            });
            this.zze.zzd.onAdMetadataChanged();
            if (!((Boolean) zzbdu.zzc.zze()).booleanValue() || (zzfjeVar = this.zzb) == null) {
                zzfjh zzfjhVar = this.zze.zzg;
                zzfit zzfitVar = this.zzc;
                zzfitVar.zzb(zzdoxVar.zzp().zzb);
                zzfitVar.zzd(zzdoxVar.zzl().zzg());
                zzfitVar.zzf(true);
                zzfjhVar.zzb(zzfitVar.zzl());
            } else {
                zzfjeVar.zzf(zzdoxVar.zzp().zzb);
                zzfjeVar.zze(zzdoxVar.zzl().zzg());
                zzfit zzfitVar2 = this.zzc;
                zzfitVar2.zzf(true);
                zzfjeVar.zza(zzfitVar2);
                zzfjeVar.zzg();
            }
        }
    }
}
