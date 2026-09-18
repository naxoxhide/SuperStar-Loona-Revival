package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcv {
    public static final zzcv zza = new zzcq();
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(2, 36);
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzcp
    };

    protected zzcv() {
    }

    public final boolean equals(Object obj) {
        int iZzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcv)) {
            return false;
        }
        zzcv zzcvVar = (zzcv) obj;
        if (zzcvVar.zzc() == zzc() && zzcvVar.zzb() == zzb()) {
            zzcu zzcuVar = new zzcu();
            zzcs zzcsVar = new zzcs();
            zzcu zzcuVar2 = new zzcu();
            zzcs zzcsVar2 = new zzcs();
            for (int i = 0; i < zzc(); i++) {
                if (!zze(i, zzcuVar, 0L).equals(zzcvVar.zze(i, zzcuVar2, 0L))) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < zzb(); i2++) {
                if (!zzd(i2, zzcsVar, true).equals(zzcvVar.zzd(i2, zzcsVar2, true))) {
                    return false;
                }
            }
            int iZzg = zzg(true);
            if (iZzg == zzcvVar.zzg(true) && (iZzh = zzh(true)) == zzcvVar.zzh(true)) {
                while (iZzg != iZzh) {
                    int iZzj = zzj(iZzg, 0, true);
                    if (iZzj != zzcvVar.zzj(iZzg, 0, true)) {
                        return false;
                    }
                    iZzg = iZzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        zzcu zzcuVar = new zzcu();
        zzcs zzcsVar = new zzcs();
        int iZzc = zzc() + 217;
        int i2 = 0;
        while (true) {
            i = iZzc * 31;
            if (i2 >= zzc()) {
                break;
            }
            iZzc = i + zze(i2, zzcuVar, 0L).hashCode();
            i2++;
        }
        int iZzb = i + zzb();
        for (int i3 = 0; i3 < zzb(); i3++) {
            iZzb = (iZzb * 31) + zzd(i3, zzcsVar, true).hashCode();
        }
        int iZzg = zzg(true);
        while (iZzg != -1) {
            iZzb = (iZzb * 31) + iZzg;
            iZzg = zzj(iZzg, 0, true);
        }
        return iZzb;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzcs zzd(int i, zzcs zzcsVar, boolean z);

    public abstract zzcu zze(int i, zzcu zzcuVar, long j);

    public abstract Object zzf(int i);

    public int zzg(boolean z) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i, zzcs zzcsVar, zzcu zzcuVar, int i2, boolean z) {
        int i3 = zzd(i, zzcsVar, false).zzd;
        if (zze(i3, zzcuVar, 0L).zzq != i) {
            return i + 1;
        }
        int iZzj = zzj(i3, i2, z);
        if (iZzj == -1) {
            return -1;
        }
        return zze(iZzj, zzcuVar, 0L).zzp;
    }

    public int zzj(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == zzh(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == zzh(z) ? zzg(z) : i + 1;
        }
        throw new IllegalStateException();
    }

    public int zzk(int i, int i2, boolean z) {
        if (i == zzg(false)) {
            return -1;
        }
        return i - 1;
    }

    public final Pair zzl(zzcu zzcuVar, zzcs zzcsVar, int i, long j) {
        Pair pairZzm = zzm(zzcuVar, zzcsVar, i, j, 0L);
        Objects.requireNonNull(pairZzm);
        return pairZzm;
    }

    public final Pair zzm(zzcu zzcuVar, zzcs zzcsVar, int i, long j, long j2) {
        zzdx.zza(i, 0, zzc());
        zze(i, zzcuVar, j2);
        if (j == -9223372036854775807L) {
            long j3 = zzcuVar.zzn;
            j = 0;
        }
        int i2 = zzcuVar.zzp;
        zzd(i2, zzcsVar, false);
        while (i2 < zzcuVar.zzq) {
            long j4 = zzcsVar.zzf;
            if (j == 0) {
                break;
            }
            int i3 = i2 + 1;
            long j5 = zzd(i3, zzcsVar, false).zzf;
            if (j < 0) {
                break;
            }
            i2 = i3;
        }
        zzd(i2, zzcsVar, true);
        long j6 = zzcsVar.zzf;
        long j7 = zzcsVar.zze;
        if (j7 != -9223372036854775807L) {
            j = Math.min(j, j7 - 1);
        }
        long jMax = Math.max(0L, j);
        Object obj = zzcsVar.zzc;
        Objects.requireNonNull(obj);
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public zzcs zzn(Object obj, zzcs zzcsVar) {
        return zzd(zza(obj), zzcsVar, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }
}
