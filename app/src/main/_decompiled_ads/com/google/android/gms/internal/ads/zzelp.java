package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzelp implements zzemz {
    final /* synthetic */ zzelq zza;

    zzelp(zzelq zzelqVar) {
        this.zza = zzelqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcqv zzcqvVar = (zzcqv) obj;
        synchronized (this.zza) {
            zzelq zzelqVar = this.zza;
            if (zzelqVar.zzi != null) {
                zzelqVar.zzi.zzb();
            }
            this.zza.zzi = zzcqvVar;
            this.zza.zzi.zzj();
        }
    }
}
