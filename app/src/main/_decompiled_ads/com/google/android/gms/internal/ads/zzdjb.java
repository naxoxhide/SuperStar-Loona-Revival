package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdjb implements zzauw {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdje zzb;

    zzdjb(zzdje zzdjeVar, String str) {
        this.zzb = zzdjeVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void zzbt(zzauv zzauvVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbH)).booleanValue()) {
            if (zzauvVar.zzj) {
                zzdje zzdjeVar = this.zzb;
                zzdjeVar.zzy.put(this.zza, true);
                zzdje zzdjeVar2 = this.zzb;
                zzdjeVar2.zzz(zzdjeVar2.zzo.zzf(), this.zzb.zzo.zzl(), this.zzb.zzo.zzm(), true);
                return;
            }
            return;
        }
        synchronized (this) {
            if (zzauvVar.zzj) {
                zzdje zzdjeVar3 = this.zzb;
                if (zzdjeVar3.zzo == null) {
                    return;
                }
                zzdjeVar3.zzy.put(this.zza, true);
                zzdje zzdjeVar4 = this.zzb;
                zzdjeVar4.zzz(zzdjeVar4.zzo.zzf(), this.zzb.zzo.zzl(), this.zzb.zzo.zzm(), true);
            }
        }
    }
}
