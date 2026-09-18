package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzctk implements zzfzp {
    final /* synthetic */ zzfzp zza;
    final /* synthetic */ zzctl zzb;

    zzctk(zzctl zzctlVar, zzfzp zzfzpVar) {
        this.zzb = zzctlVar;
        this.zza = zzfzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        zzcbg.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
        this.zza.zza(th);
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcbg.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
        this.zza.zzb((zzcsx) obj);
    }
}
