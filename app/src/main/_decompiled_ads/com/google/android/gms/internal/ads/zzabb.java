package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzabb implements zzacm {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzabb(long j, long j2, int i, int i2, boolean z) {
        long jZzc;
        this.zza = j;
        this.zzb = j2;
        this.zzc = i2 == -1 ? 1 : i2;
        this.zze = i;
        if (j == -1) {
            this.zzd = -1L;
            jZzc = -9223372036854775807L;
        } else {
            this.zzd = j - j2;
            jZzc = zzc(j, j2, i);
        }
        this.zzf = jZzc;
    }

    private static long zzc(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / ((long) i);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        return this.zzf;
    }

    public final long zzb(long j) {
        return zzc(j, this.zzb, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -1) {
            zzacn zzacnVar = new zzacn(0L, this.zzb);
            return new zzack(zzacnVar, zzacnVar);
        }
        long j3 = ((long) this.zze) * j;
        long j4 = this.zzc;
        long jMin = ((j3 / 8000000) / j4) * j4;
        if (j2 != -1) {
            jMin = Math.min(jMin, j2 - j4);
        }
        long jMax = this.zzb + Math.max(jMin, 0L);
        long jZzb = zzb(jMax);
        zzacn zzacnVar2 = new zzacn(jZzb, jMax);
        if (this.zzd != -1 && jZzb < j) {
            long j5 = jMax + ((long) this.zzc);
            if (j5 < this.zza) {
                return new zzack(zzacnVar2, new zzacn(zzb(j5), j5));
            }
        }
        return new zzack(zzacnVar2, zzacnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return this.zzd != -1;
    }
}
