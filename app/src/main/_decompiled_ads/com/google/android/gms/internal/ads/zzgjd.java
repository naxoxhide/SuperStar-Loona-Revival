package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgjd implements zzgjh {
    private final zzgrx zza;
    private final zzgpe zzb;

    private zzgjd(zzgpe zzgpeVar, zzgrx zzgrxVar) {
        this.zzb = zzgpeVar;
        this.zza = zzgrxVar;
    }

    public static zzgjd zza(zzgpe zzgpeVar) {
        return new zzgjd(zzgpeVar, zzgjr.zza(zzgpeVar.zzg()));
    }

    public final zzgpe zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgjh
    public final zzgrx zzd() {
        throw null;
    }
}
