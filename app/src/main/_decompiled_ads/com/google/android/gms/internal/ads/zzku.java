package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzku {
    public final zztu zza;
    public final Object zzb;
    public boolean zzd;
    public boolean zze;
    public zzkv zzf;
    public boolean zzg;
    private final zzlt[] zzi;
    private final zzxq zzj;
    private final zzlj zzk;
    private zzku zzl;
    private zzxr zzn;
    private long zzo;
    private zzvx zzm = zzvx.zza;
    public final zzvo[] zzc = new zzvo[2];
    private final boolean[] zzh = new boolean[2];

    public zzku(zzlt[] zzltVarArr, long j, zzxq zzxqVar, zzxz zzxzVar, zzlj zzljVar, zzkv zzkvVar, zzxr zzxrVar) {
        this.zzi = zzltVarArr;
        this.zzo = j;
        this.zzj = zzxqVar;
        this.zzk = zzljVar;
        this.zzb = zzkvVar.zza.zza;
        this.zzf = zzkvVar;
        this.zzn = zzxrVar;
        zztw zztwVar = zzkvVar.zza;
        long j2 = zzkvVar.zzb;
        long j3 = zzkvVar.zzd;
        zztu zztuVarZzp = zzljVar.zzp(zztwVar, zzxzVar, j2);
        this.zza = j3 != -9223372036854775807L ? new zztb(zztuVarZzp, true, 0L, j3) : zztuVarZzp;
    }

    private final void zzs() {
        if (!zzu()) {
            return;
        }
        int i = 0;
        while (true) {
            zzxr zzxrVar = this.zzn;
            if (i >= zzxrVar.zza) {
                return;
            }
            zzxrVar.zzb(i);
            zzxk zzxkVar = this.zzn.zzc[i];
            i++;
        }
    }

    private final void zzt() {
        if (!zzu()) {
            return;
        }
        int i = 0;
        while (true) {
            zzxr zzxrVar = this.zzn;
            if (i >= zzxrVar.zza) {
                return;
            }
            zzxrVar.zzb(i);
            zzxk zzxkVar = this.zzn.zzc[i];
            i++;
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzxr zzxrVar, long j, boolean z) {
        return zzb(zzxrVar, j, false, new boolean[2]);
    }

    public final long zzb(zzxr zzxrVar, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzxrVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z || !zzxrVar.zza(this.zzn, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzlt[] zzltVarArr = this.zzi;
            if (i2 >= 2) {
                break;
            }
            zzltVarArr[i2].zzb();
            i2++;
        }
        zzs();
        this.zzn = zzxrVar;
        zzt();
        long jZzf = this.zza.zzf(zzxrVar.zzc, this.zzh, this.zzc, zArr, j);
        int i3 = 0;
        while (true) {
            zzlt[] zzltVarArr2 = this.zzi;
            if (i3 >= 2) {
                break;
            }
            zzltVarArr2[i3].zzb();
            i3++;
        }
        this.zze = false;
        int i4 = 0;
        while (true) {
            zzvo[] zzvoVarArr = this.zzc;
            if (i4 >= 2) {
                return jZzf;
            }
            if (zzvoVarArr[i4] != null) {
                zzdx.zzf(zzxrVar.zzb(i4));
                this.zzi[i4].zzb();
                this.zze = true;
            } else {
                zzdx.zzf(zzxrVar.zzc[i4] == null);
            }
            i4++;
        }
    }

    public final long zzc() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long jZzb = this.zze ? this.zza.zzb() : Long.MIN_VALUE;
        return jZzb == Long.MIN_VALUE ? this.zzf.zze : jZzb;
    }

    public final long zzd() {
        if (this.zzd) {
            return this.zza.zzc();
        }
        return 0L;
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzku zzg() {
        return this.zzl;
    }

    public final zzvx zzh() {
        return this.zzm;
    }

    public final zzxr zzi() {
        return this.zzn;
    }

    public final zzxr zzj(float f, zzcv zzcvVar) throws zzil {
        zzxr zzxrVarZzo = this.zzj.zzo(this.zzi, this.zzm, this.zzf.zza, zzcvVar);
        for (zzxk zzxkVar : zzxrVarZzo.zzc) {
        }
        return zzxrVarZzo;
    }

    public final void zzk(long j, float f, long j2) {
        zzdx.zzf(zzu());
        long j3 = j - this.zzo;
        zzkq zzkqVar = new zzkq();
        zzkqVar.zze(j3);
        zzkqVar.zzf(f);
        zzkqVar.zzd(j2);
        this.zza.zzo(new zzks(zzkqVar, null));
    }

    public final void zzl(float f, zzcv zzcvVar) throws zzil {
        this.zzd = true;
        this.zzm = this.zza.zzh();
        zzxr zzxrVarZzj = zzj(f, zzcvVar);
        zzkv zzkvVar = this.zzf;
        long jMax = zzkvVar.zzb;
        long j = zzkvVar.zze;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jZza = zza(zzxrVarZzj, jMax, false);
        long j2 = this.zzo;
        zzkv zzkvVar2 = this.zzf;
        this.zzo = j2 + (zzkvVar2.zzb - jZza);
        this.zzf = zzkvVar2.zzb(jZza);
    }

    public final void zzm(long j) {
        zzdx.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zztu zztuVar = this.zza;
        try {
            boolean z = zztuVar instanceof zztb;
            zzlj zzljVar = this.zzk;
            if (z) {
                zzljVar.zzi(((zztb) zztuVar).zza);
            } else {
                zzljVar.zzi(zztuVar);
            }
        } catch (RuntimeException e) {
            zzer.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzku zzkuVar) {
        if (zzkuVar == this.zzl) {
            return;
        }
        zzs();
        this.zzl = zzkuVar;
        zzt();
    }

    public final void zzp(long j) {
        this.zzo = 1000000000000L;
    }

    public final void zzq() {
        zztu zztuVar = this.zza;
        if (zztuVar instanceof zztb) {
            long j = this.zzf.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zztb) zztuVar).zzn(0L, j);
        }
    }

    public final boolean zzr() {
        return this.zzd && (!this.zze || this.zza.zzb() == Long.MIN_VALUE);
    }
}
