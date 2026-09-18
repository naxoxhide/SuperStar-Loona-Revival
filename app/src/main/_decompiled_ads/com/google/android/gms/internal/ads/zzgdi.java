package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdi extends zzghu {
    final /* synthetic */ zzgdj zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgdi(zzgdj zzgdjVar, Class cls) {
        super(cls);
        this.zza = zzgdjVar;
    }

    public static final zzgnc zzf(zzgnf zzgnfVar) throws GeneralSecurityException {
        zzgnb zzgnbVarZzc = zzgnc.zzc();
        zzgnbVarZzc.zzb(zzgnfVar.zzg());
        byte[] bArrZzb = zzgjf.zzb(zzgnfVar.zza());
        zzgnbVarZzc.zza(zzgsr.zzv(bArrZzb, 0, bArrZzb.length));
        zzgnbVarZzc.zzc(0);
        return (zzgnc) zzgnbVarZzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        return zzf((zzgnf) zzgvjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ zzgvj zzb(zzgsr zzgsrVar) throws zzgul {
        return zzgnf.zzf(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final void zzd(zzgnf zzgnfVar) throws GeneralSecurityException {
        zzgrv.zza(zzgnfVar.zza());
        zzgdj zzgdjVar = this.zza;
        zzgdj.zzm(zzgnfVar.zzg());
    }
}
