package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzffs implements zzfzp {
    final /* synthetic */ zzffv zza;
    final /* synthetic */ zzffw zzb;

    zzffs(zzffw zzffwVar, zzffv zzffvVar) {
        this.zzb = zzffwVar;
        this.zza = zzffvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
            this.zzb.zzd.addFirst(this.zza);
            zzffw zzffwVar = this.zzb;
            if (zzffwVar.zzf == 1) {
                zzffwVar.zzh();
            }
        }
    }
}
