package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgbg implements zzgbf {
    private final zzghv zza;
    private final Class zzb;

    public zzgbg(zzghv zzghvVar, Class cls) {
        if (!zzghvVar.zzl().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzghvVar.toString(), cls.getName()));
        }
        this.zza = zzghvVar;
        this.zzb = cls;
    }

    @Override // com.google.android.gms.internal.ads.zzgbf
    public final zzgoz zza(zzgsr zzgsrVar) throws GeneralSecurityException {
        try {
            zzghu zzghuVarZza = this.zza.zza();
            zzgvj zzgvjVarZzb = zzghuVarZza.zzb(zzgsrVar);
            zzghuVarZza.zzd(zzgvjVarZzb);
            zzgvj zzgvjVarZza = zzghuVarZza.zza(zzgvjVarZzb);
            zzgow zzgowVarZza = zzgoz.zza();
            zzgowVarZza.zzb(this.zza.zzd());
            zzgowVarZza.zzc(zzgvjVarZza.zzau());
            zzgowVarZza.zza(this.zza.zzb());
            return (zzgoz) zzgowVarZza.zzal();
        } catch (zzgul e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbf
    public final Object zzb(zzgsr zzgsrVar) throws GeneralSecurityException {
        try {
            zzgvj zzgvjVarZzc = this.zza.zzc(zzgsrVar);
            if (Void.class.equals(this.zzb)) {
                throw new GeneralSecurityException("Cannot create a primitive for Void");
            }
            this.zza.zze(zzgvjVarZzc);
            return this.zza.zzk(zzgvjVarZzc, this.zzb);
        } catch (zzgul e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(String.valueOf(this.zza.zzj().getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbf
    public final String zzc() {
        return this.zza.zzd();
    }
}
