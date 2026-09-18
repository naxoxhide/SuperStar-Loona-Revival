package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrv implements zzfhs {
    private final Map zza;
    private final zzaxv zzb;

    zzdrv(zzaxv zzaxvVar, Map map) {
        this.zza = map;
        this.zzb = zzaxvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzbG(zzfhl zzfhlVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzbH(zzfhl zzfhlVar, String str, Throwable th) {
        if (this.zza.containsKey(zzfhlVar)) {
            this.zzb.zzc(((zzdru) this.zza.get(zzfhlVar)).zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzbI(zzfhl zzfhlVar, String str) {
        if (this.zza.containsKey(zzfhlVar)) {
            this.zzb.zzc(((zzdru) this.zza.get(zzfhlVar)).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzd(zzfhl zzfhlVar, String str) {
        if (this.zza.containsKey(zzfhlVar)) {
            this.zzb.zzc(((zzdru) this.zza.get(zzfhlVar)).zzb);
        }
    }
}
