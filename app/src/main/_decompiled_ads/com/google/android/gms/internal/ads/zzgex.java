package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgex extends zzghu {
    final /* synthetic */ zzgey zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgex(zzgey zzgeyVar, Class cls) {
        super(cls);
        this.zza = zzgeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgnz zzgnzVarZzc = zzgoa.zzc();
        byte[] bArrZzb = zzgjf.zzb(((zzgod) zzgvjVar).zza());
        zzgnzVarZzc.zza(zzgsr.zzv(bArrZzb, 0, bArrZzb.length));
        zzgnzVarZzc.zzb(0);
        return (zzgoa) zzgnzVarZzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ zzgvj zzb(zzgsr zzgsrVar) throws zzgul {
        return zzgod.zze(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        zzgfa zzgfaVar = new zzgfa(null);
        zzgfaVar.zza(16);
        zzgfaVar.zzb(zzgfb.zza);
        map.put("AES128_GCM_SIV", zzgfaVar.zzc());
        zzgfa zzgfaVar2 = new zzgfa(null);
        zzgfaVar2.zza(16);
        zzgfaVar2.zzb(zzgfb.zzc);
        map.put("AES128_GCM_SIV_RAW", zzgfaVar2.zzc());
        zzgfa zzgfaVar3 = new zzgfa(null);
        zzgfaVar3.zza(32);
        zzgfaVar3.zzb(zzgfb.zza);
        map.put("AES256_GCM_SIV", zzgfaVar3.zzc());
        zzgfa zzgfaVar4 = new zzgfa(null);
        zzgfaVar4.zza(32);
        zzgfaVar4.zzb(zzgfb.zzc);
        map.put("AES256_GCM_SIV_RAW", zzgfaVar4.zzc());
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ void zzd(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgrv.zza(((zzgod) zzgvjVar).zza());
    }
}
