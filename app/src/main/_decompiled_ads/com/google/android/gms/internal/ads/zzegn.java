package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzegn implements zzfzp {
    final /* synthetic */ zzego zza;

    zzegn(zzego zzegoVar) {
        this.zza = zzegoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zzbF(zzeVarZza);
        zzfei.zzb(zzeVarZza.zza, th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* synthetic */ void zzb(Object obj) {
        ((zzcqv) obj).zzj();
    }
}
