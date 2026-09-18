package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfih implements zzfib {
    private final zzfil zza;
    private final zzfij zzb;
    private final zzfhy zzc;

    public zzfih(zzfhy zzfhyVar, zzfil zzfilVar, zzfij zzfijVar) {
        this.zzc = zzfhyVar;
        this.zza = zzfilVar;
        this.zzb = zzfijVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfib
    public final String zza(zzfia zzfiaVar) {
        zzfij zzfijVar = this.zzb;
        Map mapZzj = zzfiaVar.zzj();
        zzfijVar.zza(mapZzj);
        return this.zza.zza(mapZzj);
    }

    @Override // com.google.android.gms.internal.ads.zzfib
    public final void zzb(zzfia zzfiaVar) {
        this.zzc.zzb(zza(zzfiaVar));
    }
}
