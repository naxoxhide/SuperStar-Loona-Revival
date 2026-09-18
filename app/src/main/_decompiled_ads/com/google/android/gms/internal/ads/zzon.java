package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzon {
    public static final zzon zza = new zzon(new int[]{2}, 10);
    private static final zzfvs zzb = zzfvs.zzo(2, 5, 6);
    private static final zzfvv zzc;
    private final int[] zzd;
    private final int zze;

    static {
        zzfvu zzfvuVar = new zzfvu();
        zzfvuVar.zza(5, 6);
        zzfvuVar.zza(17, 6);
        zzfvuVar.zza(7, 6);
        zzfvuVar.zza(30, 10);
        zzfvuVar.zza(18, 6);
        zzfvuVar.zza(6, 8);
        zzfvuVar.zza(8, 8);
        zzfvuVar.zza(14, 8);
        zzc = zzfvuVar.zzc();
    }

    public zzon(int[] iArr, int i) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, 1);
        this.zzd = iArrCopyOf;
        Arrays.sort(iArrCopyOf);
        this.zze = 10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzon)) {
            return false;
        }
        zzon zzonVar = (zzon) obj;
        if (!Arrays.equals(this.zzd, zzonVar.zzd)) {
            return false;
        }
        int i = zzonVar.zze;
        return true;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzd) * 31) + 10;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=10, supportedEncodings=" + Arrays.toString(this.zzd) + "]";
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002c  */
    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0034  */
    /* JADX WARN: Code duplicated, block: B:16:0x0036 A[PHI: r0
      0x0036: PHI (r0v3 int) = (r0v2 int), (r0v6 int) binds: [B:11:0x002a, B:14:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x003a  */
    /* JADX WARN: Code duplicated, block: B:52:0x009e  */
    public final Pair zza(zzam zzamVar) {
        String str = zzamVar.zzm;
        Objects.requireNonNull(str);
        int iZza = zzcb.zza(str, zzamVar.zzj);
        zzfvv zzfvvVar = zzc;
        if (!zzfvvVar.containsKey(Integer.valueOf(iZza))) {
            return null;
        }
        int i = 6;
        if (iZza != 18) {
            if (iZza != 8) {
                if (iZza == 30 && !zzc(30)) {
                    iZza = 7;
                }
            } else if (zzc(8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else if (zzc(18)) {
            iZza = 18;
            if (iZza != 8) {
                if (iZza == 30) {
                    iZza = 7;
                }
            } else if (zzc(8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else {
            iZza = 6;
        }
        if (!zzc(iZza)) {
            return null;
        }
        int iIntValue = zzamVar.zzz;
        if (iIntValue == -1 || iZza == 18) {
            int i2 = zzamVar.zzA;
            if (i2 == -1) {
                i2 = 48000;
            }
            if (zzfk.zza >= 29) {
                iIntValue = zzom.zza(iZza, i2);
            } else {
                Integer num = (Integer) zzfvvVar.getOrDefault(Integer.valueOf(iZza), 0);
                Objects.requireNonNull(num);
                iIntValue = num.intValue();
            }
        } else if (zzamVar.zzm.equals("audio/vnd.dts.uhd;profile=p2")) {
            if (iIntValue > 10) {
                return null;
            }
        } else if (iIntValue > 10) {
            return null;
        }
        if (zzfk.zza > 28) {
            i = iIntValue;
        } else if (iIntValue == 7) {
            i = 8;
        } else if (iIntValue != 3 && iIntValue != 4 && iIntValue != 5) {
            i = iIntValue;
        }
        if (zzfk.zza <= 26 && "fugu".equals(zzfk.zzb) && i == 1) {
            i = 2;
        }
        int iZzg = zzfk.zzg(i);
        if (iZzg == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iZza), Integer.valueOf(iZzg));
    }

    public final boolean zzc(int i) {
        return Arrays.binarySearch(this.zzd, i) >= 0;
    }
}
