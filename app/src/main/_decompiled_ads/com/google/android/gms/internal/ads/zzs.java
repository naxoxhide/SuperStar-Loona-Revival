package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Locale;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzs {
    public static final zzs zza = new zzs(1, 2, 3, null);
    public static final zzs zzb;
    public static final zzn zzc;
    private static final String zzh;
    private static final String zzi;
    private static final String zzj;
    private static final String zzk;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final byte[] zzg;
    private int zzl;

    static {
        zzr zzrVar = new zzr();
        zzrVar.zzb(1);
        zzrVar.zza(1);
        zzrVar.zzc(2);
        zzb = zzrVar.zzd();
        zzh = Integer.toString(0, 36);
        zzi = Integer.toString(1, 36);
        zzj = Integer.toString(2, 36);
        zzk = Integer.toString(3, 36);
        zzc = new zzn() { // from class: com.google.android.gms.internal.ads.zzp
        };
    }

    @Deprecated
    public zzs(int i, int i2, int i3, byte[] bArr) {
        this.zzd = i;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = bArr;
    }

    @Pure
    public static int zza(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 9) {
            return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int zzb(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 4) {
            return 10;
        }
        if (i == 13) {
            return 2;
        }
        if (i == 16) {
            return 6;
        }
        if (i != 18) {
            return (i == 6 || i == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String zzf(int i) {
        if (i == -1) {
            return "Unset color range";
        }
        if (i != 1) {
            return i != 2 ? "Undefined color range" : "Limited range";
        }
        return "Full range";
    }

    private static String zzg(int i) {
        if (i == -1) {
            return "Unset color space";
        }
        if (i == 6) {
            return "BT2020";
        }
        if (i != 1) {
            return i != 2 ? "Undefined color space" : "BT601";
        }
        return "BT709";
    }

    private static String zzh(int i) {
        if (i == -1) {
            return "Unset color transfer";
        }
        if (i == 10) {
            return "Gamma 2.2";
        }
        if (i == 1) {
            return "Linear";
        }
        if (i == 2) {
            return "sRGB";
        }
        if (i == 3) {
            return "SDR SMPTE 170M";
        }
        if (i != 6) {
            return i != 7 ? "Undefined color transfer" : "HLG";
        }
        return "ST2084 PQ";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzs zzsVar = (zzs) obj;
            if (this.zzd == zzsVar.zzd && this.zze == zzsVar.zze && this.zzf == zzsVar.zzf && Arrays.equals(this.zzg, zzsVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzl;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zzf) * 31) + Arrays.hashCode(this.zzg);
        this.zzl = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(zzg(this.zzd));
        sb.append(", ");
        sb.append(zzf(this.zze));
        sb.append(", ");
        sb.append(zzh(this.zzf));
        sb.append(", ");
        sb.append(this.zzg != null);
        sb.append(")");
        return sb.toString();
    }

    public final zzr zzc() {
        return new zzr(this, null);
    }

    public final String zzd() {
        return !zze() ? "NA" : String.format(Locale.US, "%s/%s/%s", zzg(this.zzd), zzf(this.zze), zzh(this.zzf));
    }

    public final boolean zze() {
        return (this.zzd == -1 || this.zze == -1 || this.zzf == -1) ? false : true;
    }
}
