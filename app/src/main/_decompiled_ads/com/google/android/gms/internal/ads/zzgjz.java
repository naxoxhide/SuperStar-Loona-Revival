package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgjz extends zzghu {
    zzgjz(zzgka zzgkaVar, Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgmq zzgmqVar = (zzgmq) zzgvjVar;
        zzgmm zzgmmVarZzc = zzgmn.zzc();
        zzgmmVarZzc.zzc(0);
        byte[] bArrZzb = zzgjf.zzb(zzgmqVar.zza());
        zzgmmVarZzc.zza(zzgsr.zzv(bArrZzb, 0, bArrZzb.length));
        zzgmmVarZzc.zzb(zzgmqVar.zzf());
        return (zzgmn) zzgmmVarZzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ zzgvj zzb(zzgsr zzgsrVar) throws zzgul {
        return zzgmq.zze(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES_CMAC", zzglq.zze);
        map.put("AES256_CMAC", zzglq.zze);
        zzgkc zzgkcVar = new zzgkc(null);
        zzgkcVar.zza(32);
        zzgkcVar.zzb(16);
        zzgkcVar.zzc(zzgkd.zzd);
        map.put("AES256_CMAC_RAW", zzgkcVar.zzd());
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ void zzd(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgmq zzgmqVar = (zzgmq) zzgvjVar;
        zzgka.zzn(zzgmqVar.zzf());
        zzgka.zzo(zzgmqVar.zza());
    }
}
