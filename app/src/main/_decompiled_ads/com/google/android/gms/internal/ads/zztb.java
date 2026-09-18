package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztb implements zztu, zztt {
    public final zztu zza;
    long zzb;
    private zztt zzc;
    private zzta[] zzd = new zzta[0];
    private long zze = 0;

    public zztb(zztu zztuVar, boolean z, long j, long j2) {
        this.zza = zztuVar;
        this.zzb = j2;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zza(long j, zzlv zzlvVar) {
        if (j == 0) {
            return 0L;
        }
        long jMax = Math.max(0L, Math.min(zzlvVar.zzf, j));
        long j2 = zzlvVar.zzg;
        long j3 = this.zzb;
        long jMax2 = Math.max(0L, Math.min(j2, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j));
        if (jMax != zzlvVar.zzf || jMax2 != zzlvVar.zzg) {
            zzlvVar = new zzlv(jMax, jMax2);
        }
        return this.zza.zza(j, zzlvVar);
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzb < j) {
                return jZzb;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzc < j) {
                return jZzc;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzd() {
        if (zzq()) {
            long j = this.zze;
            this.zze = -9223372036854775807L;
            long jZzd = zzd();
            return jZzd != -9223372036854775807L ? jZzd : j;
        }
        long jZzd2 = this.zza.zzd();
        if (jZzd2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        zzdx.zzf(jZzd2 >= 0);
        long j2 = this.zzb;
        zzdx.zzf(j2 == Long.MIN_VALUE || jZzd2 <= j2);
        return jZzd2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    @Override // com.google.android.gms.internal.ads.zztu
    public final long zze(long j) {
        this.zze = -9223372036854775807L;
        boolean z = false;
        for (zzta zztaVar : this.zzd) {
            if (zztaVar != null) {
                zztaVar.zzc();
            }
        }
        long jZze = this.zza.zze(j);
        if (jZze == j) {
            z = true;
        } else if (jZze >= 0) {
            long j2 = this.zzb;
            if (j2 == Long.MIN_VALUE || jZze <= j2) {
                z = true;
            }
        }
        zzdx.zzf(z);
        return jZze;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005c  */
    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzf(zzxk[] zzxkVarArr, boolean[] zArr, zzvo[] zzvoVarArr, boolean[] zArr2, long j) {
        int length = zzvoVarArr.length;
        this.zzd = new zzta[length];
        zzvo[] zzvoVarArr2 = new zzvo[length];
        int i = 0;
        while (true) {
            zzvo zzvoVar = null;
            if (i >= zzvoVarArr.length) {
                break;
            }
            zzta[] zztaVarArr = this.zzd;
            zzta zztaVar = (zzta) zzvoVarArr[i];
            zztaVarArr[i] = zztaVar;
            if (zztaVar != null) {
                zzvoVar = zztaVar.zza;
            }
            zzvoVarArr2[i] = zzvoVar;
            i++;
        }
        long jZzf = this.zza.zzf(zzxkVarArr, zArr, zzvoVarArr2, zArr2, j);
        long j2 = (zzq() && j == 0) ? 0L : j;
        this.zze = -9223372036854775807L;
        boolean z = true;
        if (jZzf != j2) {
            if (jZzf >= 0) {
                long j3 = this.zzb;
                if (j3 != Long.MIN_VALUE && jZzf > j3) {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        zzdx.zzf(z);
        for (int i2 = 0; i2 < zzvoVarArr.length; i2++) {
            zzvo zzvoVar2 = zzvoVarArr2[i2];
            if (zzvoVar2 == null) {
                this.zzd[i2] = null;
            } else {
                zzta[] zztaVarArr2 = this.zzd;
                zzta zztaVar2 = zztaVarArr2[i2];
                if (zztaVar2 == null || zztaVar2.zza != zzvoVar2) {
                    zztaVarArr2[i2] = new zzta(this, zzvoVar2);
                }
            }
            zzvoVarArr[i2] = this.zzd[i2];
        }
        return jZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzvp
    public final /* bridge */ /* synthetic */ void zzg(zzvq zzvqVar) {
        zztt zzttVar = this.zzc;
        Objects.requireNonNull(zzttVar);
        zzttVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final zzvx zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzj(long j, boolean z) {
        this.zza.zzj(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzl(zztt zzttVar, long j) {
        this.zzc = zzttVar;
        this.zza.zzl(this, j);
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final void zzm(long j) {
        this.zza.zzm(j);
    }

    public final void zzn(long j, long j2) {
        this.zzb = j2;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzo(zzks zzksVar) {
        return this.zza.zzo(zzksVar);
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzp() {
        return this.zza.zzp();
    }

    final boolean zzq() {
        return this.zze != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zztt
    public final void zzi(zztu zztuVar) {
        zztt zzttVar = this.zzc;
        Objects.requireNonNull(zzttVar);
        zzttVar.zzi(this);
    }
}
