package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdjg {
    private zzbfl zza;

    public zzdjg(zzdis zzdisVar) {
        this.zza = zzdisVar;
    }

    public final synchronized zzbfl zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbfl zzbflVar) {
        this.zza = zzbflVar;
    }
}
