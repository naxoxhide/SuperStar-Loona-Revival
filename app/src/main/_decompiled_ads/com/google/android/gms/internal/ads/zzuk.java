package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzuk implements zztu, zztt {
    private final zztu zza;
    private final long zzb;
    private zztt zzc;

    public zzuk(zztu zztuVar, long j) {
        this.zza = zztuVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zza(long j, zzlv zzlvVar) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzlvVar) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzb + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzc + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzd() {
        long jZzd = this.zza.zzd();
        if (jZzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jZzd + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzf(zzxk[] zzxkVarArr, boolean[] zArr, zzvo[] zzvoVarArr, boolean[] zArr2, long j) {
        zzvo[] zzvoVarArr2 = new zzvo[zzvoVarArr.length];
        int i = 0;
        while (true) {
            zzvo zzvoVarZzc = null;
            if (i >= zzvoVarArr.length) {
                break;
            }
            zzul zzulVar = (zzul) zzvoVarArr[i];
            if (zzulVar != null) {
                zzvoVarZzc = zzulVar.zzc();
            }
            zzvoVarArr2[i] = zzvoVarZzc;
            i++;
        }
        long jZzf = this.zza.zzf(zzxkVarArr, zArr, zzvoVarArr2, zArr2, j - this.zzb);
        for (int i2 = 0; i2 < zzvoVarArr.length; i2++) {
            zzvo zzvoVar = zzvoVarArr2[i2];
            if (zzvoVar == null) {
                zzvoVarArr[i2] = null;
            } else {
                zzvo zzvoVar2 = zzvoVarArr[i2];
                if (zzvoVar2 == null || ((zzul) zzvoVar2).zzc() != zzvoVar) {
                    zzvoVarArr[i2] = new zzul(zzvoVar, this.zzb);
                }
            }
        }
        return jZzf + this.zzb;
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
        this.zza.zzj(j - this.zzb, false);
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzl(zztt zzttVar, long j) {
        this.zzc = zzttVar;
        this.zza.zzl(this, j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzo(zzks zzksVar) {
        long j = zzksVar.zza;
        long j2 = this.zzb;
        zzkq zzkqVarZza = zzksVar.zza();
        zzkqVarZza.zze(j - j2);
        return this.zza.zzo(zzkqVarZza.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzp() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zztt
    public final void zzi(zztu zztuVar) {
        zztt zzttVar = this.zzc;
        Objects.requireNonNull(zzttVar);
        zzttVar.zzi(this);
    }
}
