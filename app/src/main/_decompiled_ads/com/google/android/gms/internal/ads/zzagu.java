package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzagu implements zzagt {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzagu(long[] jArr, long[] jArr2, long j, long j2) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzagu zzb(long j, long j2, zzacg zzacgVar, zzfb zzfbVar) {
        int iZzl;
        zzfbVar.zzH(10);
        int iZzf = zzfbVar.zzf();
        if (iZzf <= 0) {
            return null;
        }
        int i = zzacgVar.zzd;
        long jZzr = zzfk.zzr(iZzf, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, i);
        int iZzp = zzfbVar.zzp();
        int iZzp2 = zzfbVar.zzp();
        int iZzp3 = zzfbVar.zzp();
        zzfbVar.zzH(2);
        long j3 = j2 + ((long) zzacgVar.zzc);
        long[] jArr = new long[iZzp];
        long[] jArr2 = new long[iZzp];
        int i2 = 0;
        long j4 = j2;
        while (i2 < iZzp) {
            int i3 = iZzp2;
            long j5 = j3;
            jArr[i2] = (((long) i2) * jZzr) / ((long) iZzp);
            jArr2[i2] = Math.max(j4, j5);
            if (iZzp3 == 1) {
                iZzl = zzfbVar.zzl();
            } else if (iZzp3 == 2) {
                iZzl = zzfbVar.zzp();
            } else if (iZzp3 == 3) {
                iZzl = zzfbVar.zzn();
            } else {
                if (iZzp3 != 4) {
                    return null;
                }
                iZzl = zzfbVar.zzo();
            }
            j4 += ((long) iZzl) * ((long) i3);
            i2++;
            j3 = j5;
            iZzp2 = i3;
            iZzp = iZzp;
        }
        if (j != -1 && j != j4) {
            zzer.zzf("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new zzagu(jArr, jArr2, jZzr, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzagt
    public final long zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzagt
    public final long zzd(long j) {
        return this.zza[zzfk.zzc(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        long[] jArr = this.zza;
        int iZzc = zzfk.zzc(jArr, j, true, true);
        zzacn zzacnVar = new zzacn(jArr[iZzc], this.zzb[iZzc]);
        if (zzacnVar.zzb < j) {
            long[] jArr2 = this.zza;
            if (iZzc != jArr2.length - 1) {
                int i = iZzc + 1;
                return new zzack(zzacnVar, new zzacn(jArr2[i], this.zzb[i]));
            }
        }
        return new zzack(zzacnVar, zzacnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return true;
    }
}
