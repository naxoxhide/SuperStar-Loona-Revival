package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbzy extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzcac zza;

    zzbzy(zzcac zzcacVar) {
        this.zza = zzcacVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzcac zzcacVar = this.zza;
        zzbco zzbcoVar = new zzbco(zzcacVar.zze, zzcacVar.zzf.zza);
        synchronized (this.zza.zza) {
            try {
                com.google.android.gms.ads.internal.zzt.zze();
                zzbcr.zza(this.zza.zzh, zzbcoVar);
            } catch (IllegalArgumentException e) {
                zzcat.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}
