package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrz implements zzdag, zzcyz, zzcxo {
    private final zzdsj zza;
    private final zzdst zzb;

    public zzdrz(zzdsj zzdsjVar, zzdst zzdstVar) {
        this.zza = zzdsjVar;
        this.zzb = zzdstVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcxo
    public final void zzbF(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zza.zza().put("action", "ftl");
        this.zza.zza().put("ftl", String.valueOf(zzeVar.zza));
        this.zza.zza().put("ed", zzeVar.zzc);
        this.zzb.zzf(this.zza.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzbr(zzbvg zzbvgVar) {
        this.zza.zzc(zzbvgVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzbs(zzfde zzfdeVar) {
        this.zza.zzb(zzfdeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcyz
    public final void zzr() {
        this.zza.zza().put("action", TJAdUnitConstants.String.VIDEO_LOADED);
        this.zzb.zzf(this.zza.zza());
    }
}
