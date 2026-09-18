package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcot implements zzfzp {
    final /* synthetic */ zzfjx zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcou zzc;

    zzcot(zzcou zzcouVar, zzfjx zzfjxVar, String str) {
        this.zzc = zzcouVar;
        this.zza = zzfjxVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(final Throwable th) {
        zzgad zzgadVar = this.zzc.zze;
        final zzfjx zzfjxVar = this.zza;
        final String str = this.zzb;
        zzgadVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcor
            @Override // java.lang.Runnable
            public final void run() {
                zzcot zzcotVar = this.zza;
                zzcou zzcouVar = zzcotVar.zzc;
                zzcouVar.zzh = zzbty.zza(zzcouVar.zza);
                zzcotVar.zzc.zzh.zzf(th, "AttributionReporting.registerSourceAndPingClickUrl");
                zzfjxVar.zzc(str, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcou zzcouVar = this.zzc;
        final zzfjx zzfjxVar = this.zza;
        final String str = (String) obj;
        zzcouVar.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcos
            @Override // java.lang.Runnable
            public final void run() {
                zzfjxVar.zzc(str, null);
            }
        });
    }
}
