package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcbq implements zzfzp {
    final /* synthetic */ zzcbs zza;

    zzcbq(zzcbs zzcbsVar) {
        this.zza = zzcbsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        this.zza.zzb.set(-1);
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zzb(Object obj) {
        this.zza.zzb.set(1);
    }
}
