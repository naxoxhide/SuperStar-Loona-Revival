package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbnc implements zzcbn {
    final /* synthetic */ zzbnl zza;
    final /* synthetic */ zzfit zzb;
    final /* synthetic */ zzbnm zzc;

    zzbnc(zzbnm zzbnmVar, zzbnl zzbnlVar, zzfit zzfitVar) {
        this.zzc = zzbnmVar;
        this.zza = zzbnlVar;
        this.zzb = zzfitVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbn
    public final void zza() {
        synchronized (this.zzc.zza) {
            this.zzc.zzi = 1;
            com.google.android.gms.ads.internal.util.zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbdu.zzd.zze()).booleanValue()) {
                zzbnm zzbnmVar = this.zzc;
                if (zzbnmVar.zze != null) {
                    zzfjh zzfjhVar = zzbnmVar.zze;
                    zzfit zzfitVar = this.zzb;
                    zzfitVar.zzc("Failed loading new engine");
                    zzfitVar.zzf(false);
                    zzfjhVar.zzb(zzfitVar.zzl());
                }
            }
        }
    }
}
