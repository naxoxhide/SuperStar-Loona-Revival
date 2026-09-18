package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzezm implements zzffu {
    private final zzfai zza;

    public zzezm(zzfai zzfaiVar) {
        this.zza = zzfaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final ListenableFuture zza(zzffv zzffvVar) {
        zzezn zzeznVar = (zzezn) zzffvVar;
        return ((zzezj) this.zza).zzb(zzeznVar.zzb, zzeznVar.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzb(zzffj zzffjVar) {
        zzffjVar.zza = ((zzezj) this.zza).zza();
    }
}
