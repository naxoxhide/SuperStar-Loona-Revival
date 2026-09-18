package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztr extends zzvz {
    private final boolean zzb;
    private final zzcu zzc;
    private final zzcs zzd;
    private zztp zze;
    private zzto zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zztr(zzty zztyVar, boolean z) {
        boolean z2;
        super(zztyVar);
        if (z) {
            zztyVar.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzcu();
        this.zzd = new zzcs();
        zztyVar.zzM();
        this.zze = zztp.zzq(zztyVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zzf == null || !obj.equals(zztp.zzd)) ? obj : this.zze.zzf;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final void zzL(long j) {
        zzto zztoVar = this.zzf;
        int iZza = this.zze.zza(zztoVar.zza.zza);
        if (iZza == -1) {
            return;
        }
        zztp zztpVar = this.zze;
        zzcs zzcsVar = this.zzd;
        zztpVar.zzd(iZza, zzcsVar, false);
        long j2 = zzcsVar.zze;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        zztoVar.zzs(j);
    }

    public final zzcv zzC() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzvz
    protected final zztw zzD(zztw zztwVar) {
        Object obj = this.zze.zzf;
        Object obj2 = zztwVar.zza;
        if (obj != null && this.zze.zzf.equals(obj2)) {
            obj2 = zztp.zzd;
        }
        return zztwVar.zza(obj2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    @Override // com.google.android.gms.internal.ads.zzvz
    protected final void zzE(zzcv zzcvVar) {
        long j;
        zztw zztwVarZza = null;
        if (this.zzh) {
            this.zze = this.zze.zzp(zzcvVar);
            zzto zztoVar = this.zzf;
            if (zztoVar != null) {
                zzL(zztoVar.zzn());
            }
        } else if (zzcvVar.zzo()) {
            this.zze = this.zzi ? this.zze.zzp(zzcvVar) : zztp.zzr(zzcvVar, zzcu.zza, zztp.zzd);
        } else {
            zzcvVar.zze(0, this.zzc, 0L);
            Object obj = this.zzc.zzc;
            zzto zztoVar2 = this.zzf;
            if (zztoVar2 != null) {
                long jZzq = zztoVar2.zzq();
                this.zze.zzn(zztoVar2.zza.zza, this.zzd);
                this.zze.zze(0, this.zzc, 0L);
                if (jZzq != 0) {
                    j = jZzq;
                } else {
                    j = 0;
                }
            } else {
                j = 0;
            }
            Pair pairZzl = zzcvVar.zzl(this.zzc, this.zzd, 0, j);
            Object obj2 = pairZzl.first;
            long jLongValue = ((Long) pairZzl.second).longValue();
            this.zze = this.zzi ? this.zze.zzp(zzcvVar) : zztp.zzr(zzcvVar, obj, obj2);
            zzto zztoVar3 = this.zzf;
            if (zztoVar3 != null) {
                zzL(jLongValue);
                zztw zztwVar = zztoVar3.zza;
                zztwVarZza = zztwVar.zza(zzK(zztwVar.zza));
            }
        }
        this.zzi = true;
        this.zzh = true;
        zzo(this.zze);
        if (zztwVarZza != null) {
            zzto zztoVar4 = this.zzf;
            Objects.requireNonNull(zztoVar4);
            zztoVar4.zzr(zztwVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvz
    public final void zzF() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzB(null, ((zzvz) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzvz, com.google.android.gms.internal.ads.zzty
    public final void zzG(zztu zztuVar) {
        ((zzto) zztuVar).zzt();
        if (zztuVar == this.zzf) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvz, com.google.android.gms.internal.ads.zzty
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final zzto zzI(zztw zztwVar, zzxz zzxzVar, long j) {
        zzto zztoVar = new zzto(zztwVar, zzxzVar, j);
        zztoVar.zzu(this.zza);
        if (this.zzh) {
            zztoVar.zzr(zztwVar.zza(zzK(zztwVar.zza)));
        } else {
            this.zzf = zztoVar;
            if (!this.zzg) {
                this.zzg = true;
                zzB(null, ((zzvz) this).zza);
            }
        }
        return zztoVar;
    }

    @Override // com.google.android.gms.internal.ads.zztf, com.google.android.gms.internal.ads.zzsx
    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzsx, com.google.android.gms.internal.ads.zzty
    public final void zzt(zzbp zzbpVar) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzvv(this.zze.zzc, zzbpVar));
        } else {
            this.zze = zztp.zzq(zzbpVar);
        }
        this.zza.zzt(zzbpVar);
    }

    @Override // com.google.android.gms.internal.ads.zztf, com.google.android.gms.internal.ads.zzty
    public final void zzz() {
    }
}
