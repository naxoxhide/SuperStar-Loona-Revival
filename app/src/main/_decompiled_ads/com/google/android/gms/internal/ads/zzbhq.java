package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbhq extends zzbgr {
    final /* synthetic */ zzbht zza;

    /* synthetic */ zzbhq(zzbht zzbhtVar, zzbhp zzbhpVar) {
        this.zza = zzbhtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgs
    public final void zze(zzbgi zzbgiVar, String str) {
        zzbht zzbhtVar = this.zza;
        if (zzbhtVar.zzb == null) {
            return;
        }
        zzbhtVar.zzb.onCustomClick(zzbhtVar.zzf(zzbgiVar), str);
    }
}
