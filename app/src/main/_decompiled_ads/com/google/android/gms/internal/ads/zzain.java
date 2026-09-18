package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzain {
    private zzacs zzb;
    private zzabp zzc;
    private zzaii zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzaig zza = new zzaig();
    private zzaik zzj = new zzaik();

    protected abstract long zza(zzfb zzfbVar);

    protected void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzaik();
            this.zzf = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1L;
        this.zzg = 0L;
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean zzc(zzfb zzfbVar, long j, zzaik zzaikVar) throws IOException;

    final int zze(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        zzdx.zzb(this.zzb);
        int i = zzfk.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (this.zza.zze(zzabnVar)) {
                long jZzf = zzabnVar.zzf();
                long j = this.zzf;
                this.zzk = jZzf - j;
                if (!zzc(this.zza.zza(), j, this.zzj)) {
                    zzam zzamVar = this.zzj.zza;
                    this.zzi = zzamVar.zzA;
                    if (!this.zzm) {
                        this.zzb.zzl(zzamVar);
                        this.zzm = true;
                    }
                    zzaii zzaiiVar = this.zzj.zzb;
                    if (zzaiiVar != null) {
                        this.zzd = zzaiiVar;
                    } else if (zzabnVar.zzd() == -1) {
                        this.zzd = new zzaim(null);
                    } else {
                        zzaih zzaihVarZzb = this.zza.zzb();
                        this.zzd = new zzaib(this, this.zzf, zzabnVar.zzd(), zzaihVarZzb.zzd + zzaihVarZzb.zze, zzaihVarZzb.zzb, (zzaihVarZzb.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                    return 0;
                }
                this.zzf = zzabnVar.zzf();
            }
            this.zzh = 3;
            return -1;
        }
        if (i2 == 1) {
            ((zzabc) zzabnVar).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        }
        if (i2 != 2) {
            return -1;
        }
        long jZzd = this.zzd.zzd(zzabnVar);
        if (jZzd >= 0) {
            zzacjVar.zza = jZzd;
            return 1;
        }
        if (jZzd < -1) {
            zzi(-(jZzd + 2));
        }
        if (!this.zzl) {
            zzacm zzacmVarZze = this.zzd.zze();
            zzdx.zzb(zzacmVarZze);
            this.zzc.zzO(zzacmVarZze);
            this.zzl = true;
        }
        if (this.zzk <= 0 && !this.zza.zze(zzabnVar)) {
            this.zzh = 3;
            return -1;
        }
        this.zzk = 0L;
        zzfb zzfbVarZza = this.zza.zza();
        long jZza = zza(zzfbVarZza);
        if (jZza >= 0) {
            long j2 = this.zzg;
            if (j2 + jZza >= this.zze) {
                long jZzf2 = zzf(j2);
                zzacq.zzb(this.zzb, zzfbVarZza, zzfbVarZza.zzd());
                this.zzb.zzt(jZzf2, 1, zzfbVarZza.zzd(), 0, null);
                this.zze = -1L;
            }
        }
        this.zzg += jZza;
        return 0;
    }

    protected final long zzf(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    protected final long zzg(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    final void zzh(zzabp zzabpVar, zzacs zzacsVar) {
        this.zzc = zzabpVar;
        this.zzb = zzacsVar;
        zzb(true);
    }

    protected void zzi(long j) {
        this.zzg = j;
    }

    final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            this.zze = zzg(j2);
            zzaii zzaiiVar = this.zzd;
            int i = zzfk.zza;
            zzaiiVar.zzg(this.zze);
            this.zzh = 2;
        }
    }
}
