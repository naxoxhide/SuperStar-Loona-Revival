package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzwr implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzwr(zzam zzamVar, int i) {
        this.zza = 1 == (zzamVar.zze & 1);
        this.zzb = zzxi.zzn(i, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzwr zzwrVar) {
        return zzfvh.zzj().zzd(this.zzb, zzwrVar.zzb).zzd(this.zza, zzwrVar.zza).zza();
    }
}
