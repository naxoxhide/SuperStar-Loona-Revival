package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfrq extends zzfrm {
    final /* synthetic */ zzfrw zza;

    zzfrq(zzfrw zzfrwVar) {
        this.zza = zzfrwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfrm
    public final void zza() {
        synchronized (this.zza.zzg) {
            if (this.zza.zzl.get() > 0 && this.zza.zzl.decrementAndGet() > 0) {
                this.zza.zzc.zzc("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            zzfrw zzfrwVar = this.zza;
            if (zzfrwVar.zzn != null) {
                zzfrwVar.zzc.zzc("Unbind from service.", new Object[0]);
                zzfrw zzfrwVar2 = this.zza;
                zzfrwVar2.zzb.unbindService(zzfrwVar2.zzm);
                this.zza.zzh = false;
                this.zza.zzn = null;
                this.zza.zzm = null;
            }
            this.zza.zzw();
        }
    }
}
