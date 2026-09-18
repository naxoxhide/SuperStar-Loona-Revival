package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeyw implements zzemz {
    final /* synthetic */ zzeyx zza;

    zzeyw(zzeyx zzeyxVar) {
        this.zza = zzeyxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcqp zzcqpVar = (zzcqp) obj;
        synchronized (this.zza) {
            zzcqp zzcqpVar2 = this.zza.zza;
            if (zzcqpVar2 != null) {
                zzcqpVar2.zzb();
            }
            zzeyx zzeyxVar = this.zza;
            zzeyxVar.zza = zzcqpVar;
            zzcqpVar.zzc(zzeyxVar);
            zzeyx zzeyxVar2 = this.zza;
            zzeyxVar2.zzg.zzk(new zzcqq(zzcqpVar, zzeyxVar2, zzeyxVar2.zzg, zzeyxVar2.zzi));
            zzcqpVar.zzj();
        }
    }
}
