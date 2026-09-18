package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzboc implements zzcbn {
    final /* synthetic */ zzcbl zza;
    final /* synthetic */ zzbng zzb;

    zzboc(zzboe zzboeVar, zzcbl zzcblVar, zzbng zzbngVar) {
        this.zza = zzcblVar;
        this.zzb = zzbngVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbn
    public final void zza() {
        this.zza.zzd(new zzbnp("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
