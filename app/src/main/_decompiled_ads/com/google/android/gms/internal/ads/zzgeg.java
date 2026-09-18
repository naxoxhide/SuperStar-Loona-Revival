package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgeg extends zzghu {
    final /* synthetic */ zzgeh zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgeg(zzgeh zzgehVar, Class cls) {
        super(cls);
        this.zza = zzgehVar;
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgnt zzgntVarZzc = zzgnu.zzc();
        byte[] bArrZzb = zzgjf.zzb(((zzgnx) zzgvjVar).zza());
        zzgntVarZzc.zza(zzgsr.zzv(bArrZzb, 0, bArrZzb.length));
        zzgntVarZzc.zzb(0);
        return (zzgnu) zzgntVarZzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ zzgvj zzb(zzgsr zzgsrVar) throws zzgul {
        return zzgnx.zze(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_GCM", zzggh.zza);
        zzgej zzgejVar = new zzgej(null);
        zzgejVar.zza(12);
        zzgejVar.zzb(16);
        zzgejVar.zzc(16);
        zzgejVar.zzd(zzgek.zzc);
        map.put("AES128_GCM_RAW", zzgejVar.zze());
        map.put("AES256_GCM", zzggh.zzb);
        zzgej zzgejVar2 = new zzgej(null);
        zzgejVar2.zza(12);
        zzgejVar2.zzb(32);
        zzgejVar2.zzc(16);
        zzgejVar2.zzd(zzgek.zzc);
        map.put("AES256_GCM_RAW", zzgejVar2.zze());
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ void zzd(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgrv.zza(((zzgnx) zzgvjVar).zza());
    }
}
