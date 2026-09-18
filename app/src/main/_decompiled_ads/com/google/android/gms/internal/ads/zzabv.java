package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabv {
    public static int zza(zzfb zzfbVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzfbVar.zzl() + 1;
            case 7:
                return zzfbVar.zzp() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzabn zzabnVar, zzabz zzabzVar) throws IOException {
        zzabnVar.zzj();
        zzabc zzabcVar = (zzabc) zzabnVar;
        zzabcVar.zzl(1, false);
        byte[] bArr = new byte[1];
        zzabcVar.zzm(bArr, 0, 1, false);
        int i = bArr[0] & 1;
        boolean z = 1 == i;
        zzabcVar.zzl(2, false);
        int i2 = 1 != i ? 6 : 7;
        zzfb zzfbVar = new zzfb(i2);
        zzfbVar.zzF(zzabq.zza(zzabnVar, zzfbVar.zzI(), 0, i2));
        zzabnVar.zzj();
        zzabu zzabuVar = new zzabu();
        if (zzd(zzfbVar, zzabzVar, z, zzabuVar)) {
            return zzabuVar.zza;
        }
        throw zzcc.zza(null, null);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x009b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ae A[RETURN] */
    public static boolean zzc(zzfb zzfbVar, zzabz zzabzVar, int i, zzabu zzabuVar) {
        int iZza;
        int iZzc = zzfbVar.zzc();
        long jZzt = zzfbVar.zzt();
        long j = jZzt >>> 16;
        if (j != i) {
            return false;
        }
        boolean z = (j & 1) == 1;
        long j2 = jZzt >> 12;
        long j3 = jZzt >> 8;
        long j4 = jZzt >> 4;
        long j5 = jZzt >> 1;
        long j6 = jZzt & 1;
        int i2 = (int) (j4 & 15);
        if (i2 > 7 ? !(i2 > 10 || zzabzVar.zzg != 2) : i2 == zzabzVar.zzg - 1) {
            int i3 = (int) (j5 & 7);
            if ((i3 == 0 || i3 == zzabzVar.zzi) && j6 != 1 && zzd(zzfbVar, zzabzVar, z, zzabuVar) && (iZza = zza(zzfbVar, (int) (j2 & 15))) != -1 && iZza <= zzabzVar.zzb) {
                int i4 = zzabzVar.zze;
                int i5 = (int) (j3 & 15);
                if (i5 != 0) {
                    if (i5 <= 11) {
                        if (i5 == zzabzVar.zzf) {
                            if (zzfbVar.zzl() == zzfk.zze(zzfbVar.zzI(), iZzc, zzfbVar.zzc() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i5 == 12) {
                        if (zzfbVar.zzl() * 1000 == i4) {
                            if (zzfbVar.zzl() == zzfk.zze(zzfbVar.zzI(), iZzc, zzfbVar.zzc() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i5 <= 14) {
                        int iZzp = zzfbVar.zzp();
                        if (i5 == 14) {
                            iZzp *= 10;
                        }
                        if (iZzp == i4) {
                            if (zzfbVar.zzl() == zzfk.zze(zzfbVar.zzI(), iZzc, zzfbVar.zzc() - 1, 0)) {
                                return true;
                            }
                        }
                    }
                } else if (zzfbVar.zzl() == zzfk.zze(zzfbVar.zzI(), iZzc, zzfbVar.zzc() - 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzd(zzfb zzfbVar, zzabz zzabzVar, boolean z, zzabu zzabuVar) {
        try {
            long jZzv = zzfbVar.zzv();
            if (!z) {
                jZzv *= (long) zzabzVar.zzb;
            }
            zzabuVar.zza = jZzv;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
