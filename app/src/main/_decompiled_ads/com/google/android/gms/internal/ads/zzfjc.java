package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfjc implements zzfzp {
    final /* synthetic */ zzfje zza;
    final /* synthetic */ zzfit zzb;

    zzfjc(zzfje zzfjeVar, zzfit zzfitVar) {
        this.zza = zzfjeVar;
        this.zzb = zzfitVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        zzfit zzfitVar = this.zzb;
        zzfitVar.zzg(th);
        zzfitVar.zzf(false);
        this.zza.zza(zzfitVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zzb(Object obj) {
    }
}
