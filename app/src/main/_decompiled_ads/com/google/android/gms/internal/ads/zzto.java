package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzto implements zztu, zztt {
    public final zztw zza;
    private final long zzb;
    private zzty zzc;
    private zztu zzd;
    private zztt zze;
    private long zzf = -9223372036854775807L;
    private final zzxz zzg;

    public zzto(zztw zztwVar, zzxz zzxzVar, long j) {
        this.zza = zztwVar;
        this.zzg = zzxzVar;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zza(long j, zzlv zzlvVar) {
        zztu zztuVar = this.zzd;
        int i = zzfk.zza;
        return zztuVar.zza(j, zzlvVar);
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzb() {
        zztu zztuVar = this.zzd;
        int i = zzfk.zza;
        return zztuVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final long zzc() {
        zztu zztuVar = this.zzd;
        int i = zzfk.zza;
        return zztuVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzd() {
        zztu zztuVar = this.zzd;
        int i = zzfk.zza;
        return zztuVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zze(long j) {
        zztu zztuVar = this.zzd;
        int i = zzfk.zza;
        return zztuVar.zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final long zzf(zzxk[] zzxkVarArr, boolean[] zArr, zzvo[] zzvoVarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.zzf;
        if (j3 == -9223372036854775807L || j != this.zzb) {
            j2 = j;
        } else {
            this.zzf = -9223372036854775807L;
            j2 = j3;
        }
        zztu zztuVar = this.zzd;
        int i = zzfk.zza;
        return zztuVar.zzf(zzxkVarArr, zArr, zzvoVarArr, zArr2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzvp
    public final /* bridge */ /* synthetic */ void zzg(zzvq zzvqVar) {
        zztt zzttVar = this.zze;
        int i = zzfk.zza;
        zzttVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final zzvx zzh() {
        zztu zztuVar = this.zzd;
        int i = zzfk.zza;
        return zztuVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zztt
    public final void zzi(zztu zztuVar) {
        zztt zzttVar = this.zze;
        int i = zzfk.zza;
        zzttVar.zzi(this);
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzj(long j, boolean z) {
        zztu zztuVar = this.zzd;
        int i = zzfk.zza;
        zztuVar.zzj(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzk() throws IOException {
        try {
            zztu zztuVar = this.zzd;
            if (zztuVar != null) {
                zztuVar.zzk();
                return;
            }
            zzty zztyVar = this.zzc;
            if (zztyVar != null) {
                zztyVar.zzz();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu
    public final void zzl(zztt zzttVar, long j) {
        this.zze = zzttVar;
        zztu zztuVar = this.zzd;
        if (zztuVar != null) {
            zztuVar.zzl(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final void zzm(long j) {
        zztu zztuVar = this.zzd;
        int i = zzfk.zza;
        zztuVar.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzo(zzks zzksVar) {
        zztu zztuVar = this.zzd;
        return zztuVar != null && zztuVar.zzo(zzksVar);
    }

    @Override // com.google.android.gms.internal.ads.zztu, com.google.android.gms.internal.ads.zzvq
    public final boolean zzp() {
        zztu zztuVar = this.zzd;
        return zztuVar != null && zztuVar.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zztw zztwVar) {
        long jZzv = zzv(this.zzb);
        zzty zztyVar = this.zzc;
        Objects.requireNonNull(zztyVar);
        zztu zztuVarZzI = zztyVar.zzI(zztwVar, this.zzg, jZzv);
        this.zzd = zztuVarZzI;
        if (this.zze != null) {
            zztuVarZzI.zzl(this, jZzv);
        }
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzu(zzty zztyVar) {
        zzdx.zzf(this.zzc == null);
        this.zzc = zztyVar;
    }

    public final void zzt() {
        zztu zztuVar = this.zzd;
        if (zztuVar != null) {
            zzty zztyVar = this.zzc;
            Objects.requireNonNull(zztyVar);
            zztyVar.zzG(zztuVar);
        }
    }
}
