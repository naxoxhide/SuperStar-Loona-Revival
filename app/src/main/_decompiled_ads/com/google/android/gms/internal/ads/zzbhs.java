package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbhs extends zzbgu {
    final /* synthetic */ zzbht zza;

    /* synthetic */ zzbhs(zzbht zzbhtVar, zzbhr zzbhrVar) {
        this.zza = zzbhtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgv
    public final void zze(zzbgi zzbgiVar) {
        zzbht zzbhtVar = this.zza;
        zzbhtVar.zza.onCustomTemplateAdLoaded(zzbhtVar.zzf(zzbgiVar));
    }
}
