package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkx {
    private final zzcs zza = new zzcs();
    private final zzcu zzb = new zzcu();
    private final zzmb zzc;
    private final zzei zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzku zzh;
    private zzku zzi;
    private zzku zzj;
    private int zzk;
    private Object zzl;
    private long zzm;

    public zzkx(zzmb zzmbVar, zzei zzeiVar) {
        this.zzc = zzmbVar;
        this.zzd = zzeiVar;
    }

    private final boolean zzA(zzcv zzcvVar, zztw zztwVar) {
        if (zzC(zztwVar)) {
            return zzcvVar.zze(zzcvVar.zzn(zztwVar.zza, this.zza).zzd, this.zzb, 0L).zzq == zzcvVar.zza(zztwVar.zza);
        }
        return false;
    }

    private final boolean zzB(zzcv zzcvVar) {
        zzku zzkuVarZzg = this.zzh;
        if (zzkuVarZzg == null) {
            return true;
        }
        int iZza = zzcvVar.zza(zzkuVarZzg.zzb);
        while (true) {
            iZza = zzcvVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                Objects.requireNonNull(zzkuVarZzg);
                if (zzkuVarZzg.zzg() == null || zzkuVarZzg.zzf.zzg) {
                    break;
                }
                zzkuVarZzg = zzkuVarZzg.zzg();
            }
            zzku zzkuVarZzg2 = zzkuVarZzg.zzg();
            if (iZza == -1 || zzkuVarZzg2 == null || zzcvVar.zza(zzkuVarZzg2.zzb) != iZza) {
                break;
            }
            zzkuVarZzg = zzkuVarZzg2;
        }
        boolean zZzm = zzm(zzkuVarZzg);
        zzkuVarZzg.zzf = zzg(zzcvVar, zzkuVarZzg.zzf);
        return !zZzm;
    }

    private static final boolean zzC(zztw zztwVar) {
        return !zztwVar.zzb() && zztwVar.zze == -1;
    }

    private final long zzs(zzcv zzcvVar, Object obj, int i) {
        zzcvVar.zzn(obj, this.zza);
        this.zza.zzi(i);
        this.zza.zzk(i);
        return 0L;
    }

    private final zzkv zzt(zzcv zzcvVar, zzku zzkuVar, long j) {
        long j2;
        zzkv zzkvVar = zzkuVar.zzf;
        long jZze = (zzkuVar.zze() + zzkvVar.zze) - j;
        if (zzkvVar.zzg) {
            long j3 = 0;
            int iZzi = zzcvVar.zzi(zzcvVar.zza(zzkvVar.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (iZzi != -1) {
                int i = zzcvVar.zzd(iZzi, this.zza, true).zzd;
                Object obj = this.zza.zzc;
                Objects.requireNonNull(obj);
                long j4 = zzkvVar.zza.zzd;
                if (zzcvVar.zze(i, this.zzb, 0L).zzp == iZzi) {
                    Pair pairZzm = zzcvVar.zzm(this.zzb, this.zza, i, -9223372036854775807L, Math.max(0L, jZze));
                    if (pairZzm != null) {
                        obj = pairZzm.first;
                        long jLongValue = ((Long) pairZzm.second).longValue();
                        zzku zzkuVarZzg = zzkuVar.zzg();
                        if (zzkuVarZzg == null || !zzkuVarZzg.zzb.equals(obj)) {
                            j4 = this.zze;
                            this.zze = 1 + j4;
                        } else {
                            j4 = zzkuVarZzg.zzf.zza.zzd;
                        }
                        j2 = jLongValue;
                        j3 = -9223372036854775807L;
                    }
                } else {
                    j2 = 0;
                }
                zztw zztwVarZzx = zzx(zzcvVar, obj, j2, j4, this.zzb, this.zza);
                if (j3 != -9223372036854775807L && zzkvVar.zzc != -9223372036854775807L) {
                    zzcvVar.zzn(zzkvVar.zza.zza, this.zza).zzb();
                    this.zza.zzg();
                }
                return zzu(zzcvVar, zztwVarZzx, j3, j2);
            }
        } else {
            zztw zztwVar = zzkvVar.zza;
            zzcvVar.zzn(zztwVar.zza, this.zza);
            if (!zztwVar.zzb()) {
                int i2 = zztwVar.zze;
                if (i2 != -1) {
                    this.zza.zzm(i2);
                }
                zzcs zzcsVar = this.zza;
                int i3 = zztwVar.zze;
                int iZze = zzcsVar.zze(i3);
                zzcsVar.zzn(i3);
                if (iZze != this.zza.zza(zztwVar.zze)) {
                    return zzv(zzcvVar, zztwVar.zza, zztwVar.zze, iZze, zzkvVar.zze, zztwVar.zzd);
                }
                zzs(zzcvVar, zztwVar.zza, zztwVar.zze);
                return zzw(zzcvVar, zztwVar.zza, 0L, zzkvVar.zze, zztwVar.zzd);
            }
            int i4 = zztwVar.zzb;
            if (this.zza.zza(i4) != -1) {
                int iZzf = this.zza.zzf(i4, zztwVar.zzc);
                if (iZzf < 0) {
                    return zzv(zzcvVar, zztwVar.zza, i4, iZzf, zzkvVar.zzc, zztwVar.zzd);
                }
                long jLongValue2 = zzkvVar.zzc;
                if (jLongValue2 == -9223372036854775807L) {
                    zzcu zzcuVar = this.zzb;
                    zzcs zzcsVar2 = this.zza;
                    Pair pairZzm2 = zzcvVar.zzm(zzcuVar, zzcsVar2, zzcsVar2.zzd, -9223372036854775807L, Math.max(0L, jZze));
                    if (pairZzm2 != null) {
                        jLongValue2 = ((Long) pairZzm2.second).longValue();
                    }
                }
                zzs(zzcvVar, zztwVar.zza, zztwVar.zzb);
                return zzw(zzcvVar, zztwVar.zza, Math.max(0L, jLongValue2), zzkvVar.zzc, zztwVar.zzd);
            }
        }
        return null;
    }

    private final zzkv zzu(zzcv zzcvVar, zztw zztwVar, long j, long j2) {
        zzcvVar.zzn(zztwVar.zza, this.zza);
        return zztwVar.zzb() ? zzv(zzcvVar, zztwVar.zza, zztwVar.zzb, zztwVar.zzc, j, zztwVar.zzd) : zzw(zzcvVar, zztwVar.zza, j2, j, zztwVar.zzd);
    }

    private final zzkv zzv(zzcv zzcvVar, Object obj, int i, int i2, long j, long j2) {
        zztw zztwVar = new zztw(obj, i, i2, j2);
        long jZzh = zzcvVar.zzn(zztwVar.zza, this.zza).zzh(zztwVar.zzb, zztwVar.zzc);
        if (i2 == this.zza.zze(i)) {
            this.zza.zzj();
        }
        this.zza.zzn(zztwVar.zzb);
        return new zzkv(zztwVar, (jZzh == -9223372036854775807L || jZzh > 0) ? 0L : Math.max(0L, (-1) + jZzh), j, -9223372036854775807L, jZzh, false, false, false, false);
    }

    private final zzkv zzw(zzcv zzcvVar, Object obj, long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        long jMax = j;
        zzcvVar.zzn(obj, this.zza);
        int iZzc = this.zza.zzc(jMax);
        if (iZzc != -1) {
            this.zza.zzm(iZzc);
        }
        if (iZzc == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzn(iZzc);
        }
        zztw zztwVar = new zztw(obj, j3, iZzc);
        boolean zZzC = zzC(zztwVar);
        boolean zZzA = zzA(zzcvVar, zztwVar);
        boolean zZzz = zzz(zzcvVar, zztwVar, zZzC);
        if (iZzc != -1) {
            this.zza.zzn(iZzc);
        }
        if (iZzc != -1) {
            this.zza.zzi(iZzc);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j5 = 0;
            j6 = 0;
        } else {
            j5 = j4;
            j6 = this.zza.zze;
        }
        if (j6 != -9223372036854775807L && jMax >= j6) {
            jMax = Math.max(0L, j6 - 1);
        }
        return new zzkv(zztwVar, jMax, j2, j5, j6, false, zZzC, zZzA, zZzz);
    }

    private static zztw zzx(zzcv zzcvVar, Object obj, long j, long j2, zzcu zzcuVar, zzcs zzcsVar) {
        zzcvVar.zzn(obj, zzcsVar);
        zzcvVar.zze(zzcsVar.zzd, zzcuVar, 0L);
        zzcvVar.zza(obj);
        zzcsVar.zzb();
        zzcvVar.zzn(obj, zzcsVar);
        int iZzd = zzcsVar.zzd(j);
        return iZzd == -1 ? new zztw(obj, j2, zzcsVar.zzc(j)) : new zztw(obj, iZzd, zzcsVar.zze(iZzd), j2);
    }

    private final void zzy() {
        final zzfvp zzfvpVar = new zzfvp();
        for (zzku zzkuVarZzg = this.zzh; zzkuVarZzg != null; zzkuVarZzg = zzkuVarZzg.zzg()) {
            zzfvpVar.zzf(zzkuVarZzg.zzf.zza);
        }
        zzku zzkuVar = this.zzi;
        final zztw zztwVar = zzkuVar == null ? null : zzkuVar.zzf.zza;
        this.zzd.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj(zzfvpVar, zztwVar);
            }
        });
    }

    private final boolean zzz(zzcv zzcvVar, zztw zztwVar, boolean z) {
        int iZza = zzcvVar.zza(zztwVar.zza);
        return !zzcvVar.zze(zzcvVar.zzd(iZza, this.zza, false).zzd, this.zzb, 0L).zzj && zzcvVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg) == -1 && z;
    }

    public final zzku zza() {
        zzku zzkuVar = this.zzh;
        if (zzkuVar == null) {
            return null;
        }
        if (zzkuVar == this.zzi) {
            this.zzi = zzkuVar.zzg();
        }
        zzkuVar.zzn();
        int i = this.zzk - 1;
        this.zzk = i;
        if (i == 0) {
            this.zzj = null;
            zzku zzkuVar2 = this.zzh;
            this.zzl = zzkuVar2.zzb;
            this.zzm = zzkuVar2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzy();
        return this.zzh;
    }

    public final zzku zzb() {
        zzku zzkuVar = this.zzi;
        zzdx.zzb(zzkuVar);
        this.zzi = zzkuVar.zzg();
        zzy();
        zzku zzkuVar2 = this.zzi;
        zzdx.zzb(zzkuVar2);
        return zzkuVar2;
    }

    public final zzku zzc() {
        return this.zzj;
    }

    public final zzku zzd() {
        return this.zzh;
    }

    public final zzku zze() {
        return this.zzi;
    }

    public final zzkv zzf(long j, zzlk zzlkVar) {
        zzku zzkuVar = this.zzj;
        return zzkuVar == null ? zzu(zzlkVar.zza, zzlkVar.zzb, zzlkVar.zzc, zzlkVar.zzr) : zzt(zzlkVar.zza, zzkuVar, j);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    public final zzkv zzg(zzcv zzcvVar, zzkv zzkvVar) {
        long j;
        long jZzh;
        long j2;
        long j3;
        int i;
        int i2;
        zztw zztwVar = zzkvVar.zza;
        boolean zZzC = zzC(zztwVar);
        boolean zZzA = zzA(zzcvVar, zztwVar);
        boolean zZzz = zzz(zzcvVar, zztwVar, zZzC);
        zzcvVar.zzn(zzkvVar.zza.zza, this.zza);
        if (zztwVar.zzb() || (i2 = zztwVar.zze) == -1) {
            j = -9223372036854775807L;
        } else {
            this.zza.zzi(i2);
            j = 0;
        }
        if (!zztwVar.zzb()) {
            if (j != -9223372036854775807L) {
                j2 = 0;
                j3 = 0;
            } else {
                jZzh = this.zza.zze;
            }
            if (zztwVar.zzb()) {
                this.zza.zzn(zztwVar.zzb);
            } else {
                i = zztwVar.zze;
                if (i != -1) {
                    this.zza.zzn(i);
                }
            }
            return new zzkv(zztwVar, zzkvVar.zzb, zzkvVar.zzc, j2, j3, false, zZzC, zZzA, zZzz);
        }
        jZzh = this.zza.zzh(zztwVar.zzb, zztwVar.zzc);
        j2 = j;
        j3 = jZzh;
        if (zztwVar.zzb()) {
            this.zza.zzn(zztwVar.zzb);
        } else {
            i = zztwVar.zze;
            if (i != -1) {
                this.zza.zzn(i);
            }
        }
        return new zzkv(zztwVar, zzkvVar.zzb, zzkvVar.zzc, j2, j3, false, zZzC, zZzA, zZzz);
    }

    public final zztw zzh(zzcv zzcvVar, Object obj, long j) {
        long j2;
        int iZza;
        int i = zzcvVar.zzn(obj, this.zza).zzd;
        Object obj2 = this.zzl;
        if (obj2 == null || (iZza = zzcvVar.zza(obj2)) == -1 || zzcvVar.zzd(iZza, this.zza, false).zzd != i) {
            zzku zzkuVarZzg = this.zzh;
            while (true) {
                if (zzkuVarZzg == null) {
                    zzku zzkuVarZzg2 = this.zzh;
                    while (true) {
                        if (zzkuVarZzg2 != null) {
                            int iZza2 = zzcvVar.zza(zzkuVarZzg2.zzb);
                            if (iZza2 != -1 && zzcvVar.zzd(iZza2, this.zza, false).zzd == i) {
                                j2 = zzkuVarZzg2.zzf.zza.zzd;
                                break;
                            }
                            zzkuVarZzg2 = zzkuVarZzg2.zzg();
                        } else {
                            j2 = this.zze;
                            this.zze = 1 + j2;
                            if (this.zzh != null) {
                                break;
                            }
                            this.zzl = obj;
                            this.zzm = j2;
                            break;
                        }
                    }
                } else {
                    if (zzkuVarZzg.zzb.equals(obj)) {
                        j2 = zzkuVarZzg.zzf.zza.zzd;
                        break;
                    }
                    zzkuVarZzg = zzkuVarZzg.zzg();
                }
            }
        } else {
            j2 = this.zzm;
        }
        long j3 = j2;
        zzcvVar.zzn(obj, this.zza);
        zzcvVar.zze(this.zza.zzd, this.zzb, 0L);
        int iZza3 = zzcvVar.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcu zzcuVar = this.zzb;
            if (iZza3 < zzcuVar.zzp) {
                return zzx(zzcvVar, obj3, j, j3, zzcuVar, this.zza);
            }
            zzcvVar.zzd(iZza3, this.zza, true);
            this.zza.zzb();
            zzcs zzcsVar = this.zza;
            if (zzcsVar.zzd(zzcsVar.zze) != -1) {
                obj3 = this.zza.zzc;
                Objects.requireNonNull(obj3);
            }
            iZza3--;
        }
    }

    public final void zzi() {
        if (this.zzk == 0) {
            return;
        }
        zzku zzkuVarZzg = this.zzh;
        zzdx.zzb(zzkuVarZzg);
        this.zzl = zzkuVarZzg.zzb;
        this.zzm = zzkuVarZzg.zzf.zza.zzd;
        while (zzkuVarZzg != null) {
            zzkuVarZzg.zzn();
            zzkuVarZzg = zzkuVarZzg.zzg();
        }
        this.zzh = null;
        this.zzj = null;
        this.zzi = null;
        this.zzk = 0;
        zzy();
    }

    final /* synthetic */ void zzj(zzfvp zzfvpVar, zztw zztwVar) {
        this.zzc.zzQ(zzfvpVar.zzi(), zztwVar);
    }

    public final void zzk(long j) {
        zzku zzkuVar = this.zzj;
        if (zzkuVar != null) {
            zzkuVar.zzm(j);
        }
    }

    public final boolean zzl(zztu zztuVar) {
        zzku zzkuVar = this.zzj;
        return zzkuVar != null && zzkuVar.zza == zztuVar;
    }

    public final boolean zzm(zzku zzkuVar) {
        zzdx.zzb(zzkuVar);
        boolean z = false;
        if (zzkuVar.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzkuVar;
        while (zzkuVar.zzg() != null) {
            zzkuVar = zzkuVar.zzg();
            Objects.requireNonNull(zzkuVar);
            if (zzkuVar == this.zzi) {
                this.zzi = this.zzh;
                z = true;
            }
            zzkuVar.zzn();
            this.zzk--;
        }
        zzku zzkuVar2 = this.zzj;
        Objects.requireNonNull(zzkuVar2);
        zzkuVar2.zzo(null);
        zzy();
        return z;
    }

    public final boolean zzn() {
        zzku zzkuVar = this.zzj;
        if (zzkuVar == null) {
            return true;
        }
        if (zzkuVar.zzf.zzi || !zzkuVar.zzr() || this.zzj.zzf.zze == -9223372036854775807L) {
            return false;
        }
        return this.zzk < 100;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    public final boolean zzo(zzcv zzcvVar, long j, long j2) {
        zzkv zzkvVarZzg;
        boolean z;
        zzku zzkuVar = null;
        for (zzku zzkuVarZzg = this.zzh; zzkuVarZzg != null; zzkuVarZzg = zzkuVarZzg.zzg()) {
            zzkv zzkvVar = zzkuVarZzg.zzf;
            if (zzkuVar == null) {
                zzkvVarZzg = zzg(zzcvVar, zzkvVar);
            } else {
                zzkv zzkvVarZzt = zzt(zzcvVar, zzkuVar, j);
                if (zzkvVarZzt == null) {
                    return !zzm(zzkuVar);
                }
                if (zzkvVar.zzb != zzkvVarZzt.zzb || !zzkvVar.zza.equals(zzkvVarZzt.zza)) {
                    return !zzm(zzkuVar);
                }
                zzkvVarZzg = zzkvVarZzt;
            }
            zzkuVarZzg.zzf = zzkvVarZzg.zza(zzkvVar.zzc);
            long j3 = zzkvVar.zze;
            long j4 = zzkvVarZzg.zze;
            if (j3 != -9223372036854775807L && j3 != j4) {
                zzkuVarZzg.zzq();
                long j5 = zzkvVarZzg.zze;
                long jZze = j5 == -9223372036854775807L ? Long.MAX_VALUE : j5 + zzkuVarZzg.zze();
                if (zzkuVarZzg == this.zzi) {
                    boolean z2 = zzkuVarZzg.zzf.zzf;
                    if (j2 == Long.MIN_VALUE || j2 >= jZze) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                return (zzm(zzkuVarZzg) || z) ? false : true;
            }
            zzkuVar = zzkuVarZzg;
        }
        return true;
    }

    public final boolean zzp(zzcv zzcvVar, int i) {
        this.zzf = i;
        return zzB(zzcvVar);
    }

    public final boolean zzq(zzcv zzcvVar, boolean z) {
        this.zzg = z;
        return zzB(zzcvVar);
    }

    public final zzku zzr(zzlt[] zzltVarArr, zzxq zzxqVar, zzxz zzxzVar, zzlj zzljVar, zzkv zzkvVar, zzxr zzxrVar) {
        zzku zzkuVar = this.zzj;
        zzku zzkuVar2 = new zzku(zzltVarArr, zzkuVar == null ? 1000000000000L : (zzkuVar.zze() + zzkuVar.zzf.zze) - zzkvVar.zzb, zzxqVar, zzxzVar, zzljVar, zzkvVar, zzxrVar);
        zzku zzkuVar3 = this.zzj;
        if (zzkuVar3 != null) {
            zzkuVar3.zzo(zzkuVar2);
        } else {
            this.zzh = zzkuVar2;
            this.zzi = zzkuVar2;
        }
        this.zzl = null;
        this.zzj = zzkuVar2;
        this.zzk++;
        zzy();
        return zzkuVar2;
    }
}
