package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaki {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfi zza = new zzfi(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzfb zzb = new zzfb();

    zzaki(int i) {
    }

    private final int zze(zzabn zzabnVar) {
        byte[] bArr = zzfk.zzf;
        int length = bArr.length;
        this.zzb.zzE(bArr, 0);
        this.zzc = true;
        zzabnVar.zzj();
        return 0;
    }

    public final int zza(zzabn zzabnVar, zzacj zzacjVar, int i) throws IOException {
        if (i <= 0) {
            zze(zzabnVar);
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.zze) {
            long jZzd = zzabnVar.zzd();
            int iMin = (int) Math.min(112800L, jZzd);
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
            int iZzd = zzfbVar.zzd();
            for (int i2 = iZzd - 188; i2 >= iZzc; i2--) {
                byte[] bArrZzI = zzfbVar.zzI();
                int i3 = 0;
                for (int i4 = -4; i4 <= 4; i4++) {
                    int i5 = (i4 * 188) + i2;
                    if (i5 >= iZzc && i5 < iZzd && bArrZzI[i5] == 71) {
                        i3++;
                        if (i3 == 5) {
                            long jZzb = zzaks.zzb(zzfbVar, i2, i);
                            if (jZzb == -9223372036854775807L) {
                                break;
                            }
                            j = jZzb;
                            break;
                        }
                    } else {
                        i3 = 0;
                    }
                }
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        }
        if (this.zzg == -9223372036854775807L) {
            zze(zzabnVar);
            return 0;
        }
        if (this.zzd) {
            long j3 = this.zzf;
            if (j3 == -9223372036854775807L) {
                zze(zzabnVar);
                return 0;
            }
            zzfi zzfiVar = this.zza;
            long jZzb2 = zzfiVar.zzb(this.zzg) - zzfiVar.zzb(j3);
            this.zzh = jZzb2;
            if (jZzb2 < 0) {
                zzer.zzf("TsDurationReader", "Invalid duration: " + jZzb2 + ". Using TIME_UNSET instead.");
                this.zzh = -9223372036854775807L;
            }
            zze(zzabnVar);
            return 0;
        }
        int iMin2 = (int) Math.min(112800L, zzabnVar.zzd());
        if (zzabnVar.zzf() != 0) {
            zzacjVar.zza = 0L;
            return 1;
        }
        this.zzb.zzD(iMin2);
        zzabnVar.zzj();
        ((zzabc) zzabnVar).zzm(this.zzb.zzI(), 0, iMin2, false);
        zzfb zzfbVar2 = this.zzb;
        int iZzd2 = zzfbVar2.zzd();
        for (int iZzc2 = zzfbVar2.zzc(); iZzc2 < iZzd2; iZzc2++) {
            if (zzfbVar2.zzI()[iZzc2] == 71) {
                long jZzb3 = zzaks.zzb(zzfbVar2, iZzc2, i);
                if (jZzb3 != -9223372036854775807L) {
                    j = jZzb3;
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

    public final zzfi zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
