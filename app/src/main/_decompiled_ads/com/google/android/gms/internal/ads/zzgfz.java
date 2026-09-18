package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgfz extends zzghu {
    final /* synthetic */ zzgga zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgfz(zzgga zzggaVar, Class cls) {
        super(cls);
        this.zza = zzggaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgpz zzgpzVarZzc = zzgqa.zzc();
        zzgpzVarZzc.zza((zzgqd) zzgvjVar);
        zzgpzVarZzc.zzb(0);
        return (zzgqa) zzgpzVarZzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ zzgvj zzb(zzgsr zzgsrVar) throws zzgul {
        return zzgqd.zze(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ void zzd(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgqd zzgqdVar = (zzgqd) zzgvjVar;
        if (zzgfx.zzb(zzgqdVar.zza().zzg())) {
            if (zzgqdVar.zzf().isEmpty() || !zzgqdVar.zzg()) {
                throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
            }
        } else {
            throw new GeneralSecurityException("Unsupported DEK key type: " + zzgqdVar.zza().zzg() + ". Only Tink AEAD key types are supported.");
        }
    }
}
