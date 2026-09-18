package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzemr implements zzemz {
    final /* synthetic */ zzems zza;

    zzemr(zzems zzemsVar) {
        this.zza = zzemsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdfw zzdfwVar = (zzdfw) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzdfwVar;
            this.zza.zzj.zzj();
        }
    }
}
