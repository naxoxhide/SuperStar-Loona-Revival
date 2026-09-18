package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbsf extends zzbgr {
    final /* synthetic */ zzbsi zza;

    /* synthetic */ zzbsf(zzbsi zzbsiVar, zzbse zzbseVar) {
        this.zza = zzbsiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgs
    public final void zze(zzbgi zzbgiVar, String str) {
        zzbsi zzbsiVar = this.zza;
        if (zzbsiVar.zzb == null) {
            return;
        }
        zzbsiVar.zzb.onCustomClick(zzbsiVar.zzf(zzbgiVar), str);
    }
}
