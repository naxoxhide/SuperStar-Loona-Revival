package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgwu {
    private static final zzgwu zza = new zzgwu(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzgwu() {
        this(0, new int[8], new Object[8], true);
    }

    private zzgwu(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzgwu zzc() {
        return zza;
    }

    static zzgwu zze(zzgwu zzgwuVar, zzgwu zzgwuVar2) {
        int i = zzgwuVar.zzb + zzgwuVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzgwuVar.zzc, i);
        System.arraycopy(zzgwuVar2.zzc, 0, iArrCopyOf, zzgwuVar.zzb, zzgwuVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzgwuVar.zzd, i);
        System.arraycopy(zzgwuVar2.zzd, 0, objArrCopyOf, zzgwuVar.zzb, zzgwuVar2.zzb);
        return new zzgwu(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzgwu zzf() {
        return new zzgwu(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgwu)) {
            return false;
        }
        zzgwu zzgwuVar = (zzgwu) obj;
        int i = this.zzb;
        if (i == zzgwuVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgwuVar.zzc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzgwuVar.zzd;
            int i3 = this.zzb;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzB;
        int iZzA;
        int iZzA2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iZzA2 = zzgtg.zzA(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzgsr zzgsrVar = (zzgsr) this.zzd[i3];
                    int i8 = zzgtg.zzf;
                    int iZzd = zzgsrVar.zzd();
                    iZzA2 = zzgtg.zzA(i7) + zzgtg.zzA(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int i9 = i5 << 3;
                    int i10 = zzgtg.zzf;
                    iZzB = ((zzgwu) this.zzd[i3]).zza();
                    int iZzA3 = zzgtg.zzA(i9);
                    iZzA = iZzA3 + iZzA3;
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(zzgul.zza());
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzA2 = zzgtg.zzA(i5 << 3) + 4;
                }
                i2 += iZzA2;
            } else {
                int i11 = i5 << 3;
                iZzB = zzgtg.zzB(((Long) this.zzd[i3]).longValue());
                iZzA = zzgtg.zzA(i11);
            }
            iZzA2 = iZzA + iZzB;
            i2 += iZzA2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzA = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzgsr zzgsrVar = (zzgsr) this.zzd[i2];
            int i4 = zzgtg.zzf;
            int iZzd = zzgsrVar.zzd();
            int iZzA2 = zzgtg.zzA(iZzd) + iZzd;
            int iZzA3 = zzgtg.zzA(16);
            int iZzA4 = zzgtg.zzA(i3);
            int iZzA5 = zzgtg.zzA(8);
            iZzA += iZzA5 + iZzA5 + iZzA3 + iZzA4 + zzgtg.zzA(24) + iZzA2;
        }
        this.zze = iZzA;
        return iZzA;
    }

    final zzgwu zzd(zzgwu zzgwuVar) {
        if (zzgwuVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzgwuVar.zzb;
        zzl(i);
        System.arraycopy(zzgwuVar.zzc, 0, this.zzc, this.zzb, zzgwuVar.zzb);
        System.arraycopy(zzgwuVar.zzd, 0, this.zzd, this.zzb, zzgwuVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzgvl.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzgth zzgthVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzgthVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzgthVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzgthVar.zzd(i4, (zzgsr) obj);
                } else if (i3 == 3) {
                    zzgthVar.zzE(i4);
                    ((zzgwu) obj).zzk(zzgthVar);
                    zzgthVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(zzgul.zza());
                    }
                    zzgthVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
