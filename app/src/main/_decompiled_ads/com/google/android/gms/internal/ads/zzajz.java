package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajz {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfi zza = new zzfi(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzfb zzb = new zzfb();

    zzajz() {
    }

    public static long zzc(zzfb zzfbVar) {
        int iZzc = zzfbVar.zzc();
        if (zzfbVar.zza() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzfbVar.zzC(bArr, 0, 9);
        zzfbVar.zzG(iZzc);
        byte b2 = bArr[0];
        if ((b2 & 196) == 68) {
            byte b3 = bArr[2];
            if ((b3 & 4) == 4) {
                byte b4 = bArr[4];
                if ((b4 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j = b2;
                    long j2 = b3;
                    return ((j2 & 3) << 13) | ((j & 3) << 28) | (((56 & j) >> 3) << 30) | ((bArr[1] & 255) << 20) | (((j2 & 248) >> 3) << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b4) & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }

    private final int zzf(zzabn zzabnVar) {
        byte[] bArr = zzfk.zzf;
        int length = bArr.length;
        this.zzb.zzE(bArr, 0);
        this.zzc = true;
        zzabnVar.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final int zza(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        long j = -9223372036854775807L;
        if (!this.zze) {
            long jZzd = zzabnVar.zzd();
            int iMin = (int) Math.min(20000L, jZzd);
            long j2 = jZzd - ((long) iMin);
            if (zzabnVar.zzf() != j2) {
                zzacjVar.zza = j2;
                return 1;
            }
            this.zzb.zzD(iMin);
            zzabnVar.zzj();
            ((zzabc) zzabnVar).zzm(this.zzb.zzI(), 0, iMin, false);
            zzfb zzfbVar = this.zzb;
            int iZzc = zzfbVar.zzc();
            for (int iZzd = zzfbVar.zzd() - 4; iZzd >= iZzc; iZzd--) {
                if (zzg(zzfbVar.zzI(), iZzd) == 442) {
                    zzfbVar.zzG(iZzd + 4);
                    long jZzc = zzc(zzfbVar);
                    if (jZzc != -9223372036854775807L) {
                        j = jZzc;
                        break;
                    }
                }
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        }
        if (this.zzg == -9223372036854775807L) {
            zzf(zzabnVar);
            return 0;
        }
        if (this.zzd) {
            long j3 = this.zzf;
            if (j3 == -9223372036854775807L) {
                zzf(zzabnVar);
                return 0;
            }
            zzfi zzfiVar = this.zza;
            long jZzb = zzfiVar.zzb(this.zzg) - zzfiVar.zzb(j3);
            this.zzh = jZzb;
            if (jZzb < 0) {
                zzer.zzf("PsDurationReader", "Invalid duration: " + jZzb + ". Using TIME_UNSET instead.");
                this.zzh = -9223372036854775807L;
            }
            zzf(zzabnVar);
            return 0;
        }
        int iMin2 = (int) Math.min(20000L, zzabnVar.zzd());
        if (zzabnVar.zzf() != 0) {
            zzacjVar.zza = 0L;
            return 1;
        }
        this.zzb.zzD(iMin2);
        zzabnVar.zzj();
        ((zzabc) zzabnVar).zzm(this.zzb.zzI(), 0, iMin2, false);
        zzfb zzfbVar2 = this.zzb;
        int iZzd2 = zzfbVar2.zzd();
        for (int iZzc2 = zzfbVar2.zzc(); iZzc2 < iZzd2 - 3; iZzc2++) {
            if (zzg(zzfbVar2.zzI(), iZzc2) == 442) {
                zzfbVar2.zzG(iZzc2 + 4);
                long jZzc2 = zzc(zzfbVar2);
                if (jZzc2 != -9223372036854775807L) {
                    j = jZzc2;
                    break;
                }
            }
        }
        this.zzf = j;
        this.zzd = true;
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfi zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
