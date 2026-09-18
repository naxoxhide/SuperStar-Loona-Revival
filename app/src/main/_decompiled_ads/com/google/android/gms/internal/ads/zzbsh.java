package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbsh extends zzbgu {
    final /* synthetic */ zzbsi zza;

    /* synthetic */ zzbsh(zzbsi zzbsiVar, zzbsg zzbsgVar) {
        this.zza = zzbsiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgv
    public final void zze(zzbgi zzbgiVar) {
        zzbsi zzbsiVar = this.zza;
        zzbsiVar.zza.onCustomFormatAdLoaded(zzbsiVar.zzf(zzbgiVar));
    }
}
