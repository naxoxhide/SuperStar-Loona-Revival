package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzagv implements zzagt {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long[] zzf;

    private zzagv(long j, int i, long j2, long j3, long[] jArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = j3;
        this.zze = j3 != -1 ? j + j3 : -1L;
    }

    public static zzagv zzb(long j, long j2, zzacg zzacgVar, zzfb zzfbVar) {
        int iZzo;
        int i = zzacgVar.zzg;
        int i2 = zzacgVar.zzd;
        int iZzf = zzfbVar.zzf();
        if ((iZzf & 1) != 1 || (iZzo = zzfbVar.zzo()) == 0) {
            return null;
        }
        int i3 = iZzf & 6;
        long jZzr = zzfk.zzr(iZzo, ((long) i) * 1000000, i2);
        if (i3 != 6) {
            return new zzagv(j2, zzacgVar.zzc, jZzr, -1L, null);
        }
        long jZzt = zzfbVar.zzt();
        long[] jArr = new long[100];
        for (int i4 = 0; i4 < 100; i4++) {
            jArr[i4] = zzfbVar.zzl();
        }
        if (j != -1) {
            long j3 = j2 + jZzt;
            if (j != j3) {
                zzer.zzf("XingSeeker", "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new zzagv(j2, zzacgVar.zzc, jZzr, jZzt, jArr);
    }

    private final long zze(int i) {
        return (this.zzc * ((long) i)) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzagt
    public final long zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzagt
    public final long zzd(long j) {
        if (!zzh()) {
            return 0L;
        }
        long j2 = j - this.zza;
        if (j2 <= this.zzb) {
            return 0L;
        }
        long[] jArr = this.zzf;
        zzdx.zzb(jArr);
        double d = (j2 * 256.0d) / this.zzd;
        int iZzc = zzfk.zzc(jArr, (long) d, true, true);
        long jZze = zze(iZzc);
        long j3 = jArr[iZzc];
        int i = iZzc + 1;
        long jZze2 = zze(i);
        long j4 = iZzc == 99 ? 256L : jArr[i];
        return jZze + Math.round((j3 == j4 ? 0.0d : (d - j3) / (j4 - j3)) * (jZze2 - jZze));
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        if (!zzh()) {
            zzacn zzacnVar = new zzacn(0L, this.zza + ((long) this.zzb));
            return new zzack(zzacnVar, zzacnVar);
        }
        long jMax = Math.max(0L, Math.min(j, this.zzc));
        double d = (jMax * 100.0d) / this.zzc;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr = this.zzf;
                zzdx.zzb(jArr);
                double d3 = jArr[i];
                d2 = d3 + ((d - ((double) i)) * ((i == 99 ? 256.0d : jArr[i + 1]) - d3));
            }
        }
        long j2 = this.zzd;
        zzacn zzacnVar2 = new zzacn(jMax, this.zza + Math.max(this.zzb, Math.min(Math.round((d2 / 256.0d) * j2), j2 - 1)));
        return new zzack(zzacnVar2, zzacnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return this.zzf != null;
    }
}
