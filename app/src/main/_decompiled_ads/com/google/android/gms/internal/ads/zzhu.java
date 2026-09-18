package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhu extends zzcv {
    private final int zzc;
    private final zzvr zzd;

    public zzhu(boolean z, zzvr zzvrVar) {
        this.zzd = zzvrVar;
        this.zzc = zzvrVar.zzc();
    }

    private final int zzw(int i, boolean z) {
        if (z) {
            return this.zzd.zzd(i);
        }
        if (i >= this.zzc - 1) {
            return -1;
        }
        return i + 1;
    }

    private final int zzx(int i, boolean z) {
        if (z) {
            return this.zzd.zze(i);
        }
        if (i <= 0) {
            return -1;
        }
        return i - 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final int zza(Object obj) {
        int iZza;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int iZzp = zzp(obj2);
        if (iZzp == -1 || (iZza = zzu(iZzp).zza(obj3)) == -1) {
            return -1;
        }
        return zzs(iZzp) + iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final zzcs zzd(int i, zzcs zzcsVar, boolean z) {
        int iZzq = zzq(i);
        int iZzt = zzt(iZzq);
        zzu(iZzq).zzd(i - zzs(iZzq), zzcsVar, z);
        zzcsVar.zzd += iZzt;
        if (z) {
            Object objZzv = zzv(iZzq);
            Object obj = zzcsVar.zzc;
            Objects.requireNonNull(obj);
            zzcsVar.zzc = Pair.create(objZzv, obj);
        }
        return zzcsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final zzcu zze(int i, zzcu zzcuVar, long j) {
        int iZzr = zzr(i);
        int iZzt = zzt(iZzr);
        int iZzs = zzs(iZzr);
        zzu(iZzr).zze(i - iZzt, zzcuVar, j);
        Object objZzv = zzv(iZzr);
        if (!zzcu.zza.equals(zzcuVar.zzc)) {
            objZzv = Pair.create(objZzv, zzcuVar.zzc);
        }
        zzcuVar.zzc = objZzv;
        zzcuVar.zzp += iZzs;
        zzcuVar.zzq += iZzs;
        return zzcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final Object zzf(int i) {
        int iZzq = zzq(i);
        return Pair.create(zzv(iZzq), zzu(iZzq).zzf(i - zzs(iZzq)));
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final int zzg(boolean z) {
        if (this.zzc == 0) {
            return -1;
        }
        int iZza = z ? this.zzd.zza() : 0;
        while (zzu(iZza).zzo()) {
            iZza = zzw(iZza, z);
            if (iZza == -1) {
                return -1;
            }
        }
        return zzt(iZza) + zzu(iZza).zzg(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final int zzh(boolean z) {
        int i = this.zzc;
        if (i == 0) {
            return -1;
        }
        int iZzb = z ? this.zzd.zzb() : i - 1;
        while (zzu(iZzb).zzo()) {
            iZzb = zzx(iZzb, z);
            if (iZzb == -1) {
                return -1;
            }
        }
        return zzt(iZzb) + zzu(iZzb).zzh(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final int zzj(int i, int i2, boolean z) {
        int iZzr = zzr(i);
        int iZzt = zzt(iZzr);
        int iZzj = zzu(iZzr).zzj(i - iZzt, i2 == 2 ? 0 : i2, z);
        if (iZzj != -1) {
            return iZzt + iZzj;
        }
        int iZzw = zzw(iZzr, z);
        while (iZzw != -1 && zzu(iZzw).zzo()) {
            iZzw = zzw(iZzw, z);
        }
        if (iZzw != -1) {
            return zzt(iZzw) + zzu(iZzw).zzg(z);
        }
        if (i2 == 2) {
            return zzg(z);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final int zzk(int i, int i2, boolean z) {
        int iZzr = zzr(i);
        int iZzt = zzt(iZzr);
        int iZzk = zzu(iZzr).zzk(i - iZzt, 0, false);
        if (iZzk != -1) {
            return iZzt + iZzk;
        }
        int iZzx = zzx(iZzr, false);
        while (iZzx != -1 && zzu(iZzx).zzo()) {
            iZzx = zzx(iZzx, false);
        }
        if (iZzx != -1) {
            return zzt(iZzx) + zzu(iZzx).zzh(false);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final zzcs zzn(Object obj, zzcs zzcsVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int iZzp = zzp(obj2);
        int iZzt = zzt(iZzp);
        zzu(iZzp).zzn(obj3, zzcsVar);
        zzcsVar.zzd += iZzt;
        zzcsVar.zzc = obj;
        return zzcsVar;
    }

    protected abstract int zzp(Object obj);

    protected abstract int zzq(int i);

    protected abstract int zzr(int i);

    protected abstract int zzs(int i);

    protected abstract int zzt(int i);

    protected abstract zzcv zzu(int i);

    protected abstract Object zzv(int i);
}
