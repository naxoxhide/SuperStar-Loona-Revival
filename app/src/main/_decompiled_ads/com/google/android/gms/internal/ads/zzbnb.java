package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbnb implements zzcbp {
    final /* synthetic */ zzbnl zza;
    final /* synthetic */ zzfit zzb;
    final /* synthetic */ zzbnm zzc;

    zzbnb(zzbnm zzbnmVar, zzbnl zzbnlVar, zzfit zzfitVar) {
        this.zzc = zzbnmVar;
        this.zza = zzbnlVar;
        this.zzb = zzfitVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbp
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        synchronized (this.zzc.zza) {
            this.zzc.zzi = 0;
            zzbnm zzbnmVar = this.zzc;
            if (zzbnmVar.zzh != null && this.zza != zzbnmVar.zzh) {
                com.google.android.gms.ads.internal.util.zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzc.zzh.zzb();
            }
            this.zzc.zzh = this.zza;
            if (((Boolean) zzbdu.zzd.zze()).booleanValue()) {
                zzbnm zzbnmVar2 = this.zzc;
                if (zzbnmVar2.zze != null) {
                    zzfjh zzfjhVar = zzbnmVar2.zze;
                    zzfit zzfitVar = this.zzb;
                    zzfitVar.zzf(true);
                    zzfjhVar.zzb(zzfitVar.zzl());
                }
            }
        }
    }
}
