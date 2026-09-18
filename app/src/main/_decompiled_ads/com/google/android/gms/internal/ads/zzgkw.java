package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgkw extends zzghu {
    final /* synthetic */ zzgkx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgkw(zzgkx zzgkxVar, Class cls) {
        super(cls);
        this.zza = zzgkxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgor zzgorVar = (zzgor) zzgvjVar;
        zzgon zzgonVarZzc = zzgoo.zzc();
        zzgonVarZzc.zzc(0);
        zzgonVarZzc.zzb(zzgorVar.zzg());
        byte[] bArrZzb = zzgjf.zzb(zzgorVar.zza());
        zzgonVarZzc.zza(zzgsr.zzv(bArrZzb, 0, bArrZzb.length));
        return (zzgoo) zzgonVarZzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* synthetic */ zzgvj zzb(zzgsr zzgsrVar) throws zzgul {
        return zzgor.zzf(zzgsrVar, zzgtl.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", zzglq.zza);
        zzgkz zzgkzVar = new zzgkz(null);
        zzgkzVar.zzb(32);
        zzgkzVar.zzc(16);
        zzgkzVar.zzd(zzglb.zzd);
        zzgkzVar.zza(zzgla.zzc);
        map.put("HMAC_SHA256_128BITTAG_RAW", zzgkzVar.zze());
        zzgkz zzgkzVar2 = new zzgkz(null);
        zzgkzVar2.zzb(32);
        zzgkzVar2.zzc(32);
        zzgkzVar2.zzd(zzglb.zza);
        zzgkzVar2.zza(zzgla.zzc);
        map.put("HMAC_SHA256_256BITTAG", zzgkzVar2.zze());
        zzgkz zzgkzVar3 = new zzgkz(null);
        zzgkzVar3.zzb(32);
        zzgkzVar3.zzc(32);
        zzgkzVar3.zzd(zzglb.zzd);
        zzgkzVar3.zza(zzgla.zzc);
        map.put("HMAC_SHA256_256BITTAG_RAW", zzgkzVar3.zze());
        zzgkz zzgkzVar4 = new zzgkz(null);
        zzgkzVar4.zzb(64);
        zzgkzVar4.zzc(16);
        zzgkzVar4.zzd(zzglb.zza);
        zzgkzVar4.zza(zzgla.zze);
        map.put("HMAC_SHA512_128BITTAG", zzgkzVar4.zze());
        zzgkz zzgkzVar5 = new zzgkz(null);
        zzgkzVar5.zzb(64);
        zzgkzVar5.zzc(16);
        zzgkzVar5.zzd(zzglb.zzd);
        zzgkzVar5.zza(zzgla.zze);
        map.put("HMAC_SHA512_128BITTAG_RAW", zzgkzVar5.zze());
        zzgkz zzgkzVar6 = new zzgkz(null);
        zzgkzVar6.zzb(64);
        zzgkzVar6.zzc(32);
        zzgkzVar6.zzd(zzglb.zza);
        zzgkzVar6.zza(zzgla.zze);
        map.put("HMAC_SHA512_256BITTAG", zzgkzVar6.zze());
        zzgkz zzgkzVar7 = new zzgkz(null);
        zzgkzVar7.zzb(64);
        zzgkzVar7.zzc(32);
        zzgkzVar7.zzd(zzglb.zzd);
        zzgkzVar7.zza(zzgla.zze);
        map.put("HMAC_SHA512_256BITTAG_RAW", zzgkzVar7.zze());
        map.put("HMAC_SHA512_512BITTAG", zzglq.zzd);
        zzgkz zzgkzVar8 = new zzgkz(null);
        zzgkzVar8.zzb(64);
        zzgkzVar8.zzc(64);
        zzgkzVar8.zzd(zzglb.zzd);
        zzgkzVar8.zza(zzgla.zze);
        map.put("HMAC_SHA512_512BITTAG_RAW", zzgkzVar8.zze());
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.ads.zzghu
    public final /* bridge */ /* synthetic */ void zzd(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgor zzgorVar = (zzgor) zzgvjVar;
        if (zzgorVar.zza() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzgkx.zzn(zzgorVar.zzg());
    }
}
