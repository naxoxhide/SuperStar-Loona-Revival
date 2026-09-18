package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalc implements zzacm {
    private final zzakz zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzalc(zzakz zzakzVar, int i, long j, long j2) {
        this.zza = zzakzVar;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzakzVar.zzd);
        this.zzd = j3;
        this.zze = zzb(j3);
    }

    private final long zzb(long j) {
        return zzfk.zzr(j * ((long) this.zzb), 1000000L, this.zza.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        long jMax = Math.max(0L, Math.min((((long) this.zza.zzc) * j) / (((long) this.zzb) * 1000000), this.zzd - 1));
        long j2 = ((long) this.zza.zzd) * jMax;
        long jZzb = zzb(jMax);
        zzacn zzacnVar = new zzacn(jZzb, this.zzc + j2);
        if (jZzb >= j || jMax == this.zzd - 1) {
            return new zzack(zzacnVar, zzacnVar);
        }
        long j3 = jMax + 1;
        return new zzack(zzacnVar, new zzacn(zzb(j3), this.zzc + (j3 * ((long) this.zza.zzd))));
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return true;
    }
}
