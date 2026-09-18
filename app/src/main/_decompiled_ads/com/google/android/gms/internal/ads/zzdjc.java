package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdjc implements zzfzp {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdje zzb;

    zzdjc(zzdje zzdjeVar, String str, boolean z) {
        this.zzb = zzdjeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "omid native display exp");
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zze.zzT((zzcgb) obj);
        zzdje zzdjeVar = this.zzb;
        zzcbl zzcblVarZzp = zzdjeVar.zze.zzp();
        zzfkc zzfkcVarZzf = zzdjeVar.zzf(this.zza, true);
        if (zzfkcVarZzf != null && zzcblVarZzp != null) {
            zzcblVarZzp.zzc(zzfkcVarZzf);
        } else if (zzcblVarZzp != null) {
            zzcblVarZzp.cancel(false);
        }
    }
}
