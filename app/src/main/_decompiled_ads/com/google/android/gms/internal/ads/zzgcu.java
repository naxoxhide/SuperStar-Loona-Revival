package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgcu extends zzghu {
    final /* synthetic */ zzgcv zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgcu(zzgcv zzgcvVar, Class cls) {
        super(cls);
        this.zza = zzgcvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgmz zzgmzVar = (zzgmz) zzgvjVar;
        new zzgdj();
        zzgnc zzgncVarZzf = zzgdi.zzf(zzgmzVar.zze());
        zzgvj zzgvjVarZza = new zzgkx().zza().zza(zzgmzVar.zzf());
        zzgmv zzgmvVarZzc = zzgmw.zzc();
        zzgmvVarZzc.zza(zzgncVarZzf);
        zzgmvVarZzc.zzb((zzgoo) zzgvjVarZza);
        zzgmvVarZzc.zzc(0);
        return (zzgmw) zzgmvVarZzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ zzgvj zzb(zzgsr zzgsrVar) throws zzgul {
        return zzgmz.zzd(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", zzggh.zze);
        zzgcx zzgcxVar = new zzgcx(null);
        zzgcxVar.zza(16);
        zzgcxVar.zzc(32);
        zzgcxVar.zze(16);
        zzgcxVar.zzd(16);
        zzgcxVar.zzb(zzgcy.zzc);
        zzgcxVar.zzf(zzgcz.zzc);
        map.put("AES128_CTR_HMAC_SHA256_RAW", zzgcxVar.zzg());
        map.put("AES256_CTR_HMAC_SHA256", zzggh.zzf);
        zzgcx zzgcxVar2 = new zzgcx(null);
        zzgcxVar2.zza(32);
        zzgcxVar2.zzc(32);
        zzgcxVar2.zze(32);
        zzgcxVar2.zzd(16);
        zzgcxVar2.zzb(zzgcy.zzc);
        zzgcxVar2.zzf(zzgcz.zzc);
        map.put("AES256_CTR_HMAC_SHA256_RAW", zzgcxVar2.zzg());
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ void zzd(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgmz zzgmzVar = (zzgmz) zzgvjVar;
        ((zzgdi) new zzgdj().zza()).zzd(zzgmzVar.zze());
        new zzgkx().zza().zzd(zzgmzVar.zzf());
        zzgrv.zza(zzgmzVar.zze().zza());
    }
}
