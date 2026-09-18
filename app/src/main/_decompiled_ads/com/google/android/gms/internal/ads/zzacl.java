package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzacl implements zzacm {
    private final long zza;
    private final zzack zzb;

    public zzacl(long j, long j2) {
        this.zza = j;
        zzacn zzacnVar = j2 == 0 ? zzacn.zza : new zzacn(0L, j2);
        this.zzb = new zzack(zzacnVar, zzacnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return false;
    }
}
