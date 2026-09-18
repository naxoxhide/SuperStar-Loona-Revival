package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzehx implements zzfzp {
    final /* synthetic */ zzfcr zza;
    final /* synthetic */ zzehy zzb;

    zzehx(zzehy zzehyVar, zzfcr zzfcrVar) {
        this.zzb = zzehyVar;
        this.zza = zzfcrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zzh.zzb(th, this.zza);
            if (this.zzb.zzh.zze()) {
                zzehy zzehyVar = this.zzb;
                zzehyVar.zze(zzehyVar.zzh.zza());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zzb(Object obj) {
        synchronized (this.zzb) {
            this.zzb.zzh.zzc(obj, this.zza);
            if (this.zzb.zzh.zze()) {
                zzehy zzehyVar = this.zzb;
                zzehyVar.zze(zzehyVar.zzh.zza());
            }
        }
    }
}
