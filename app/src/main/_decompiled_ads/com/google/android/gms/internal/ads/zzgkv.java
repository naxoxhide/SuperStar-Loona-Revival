package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgkv extends zzgiv {
    zzgkv(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzgiv
    public final /* bridge */ /* synthetic */ Object zza(zzgvj zzgvjVar) throws GeneralSecurityException {
        zzgoo zzgooVar = (zzgoo) zzgvjVar;
        zzgol zzgolVarZzc = zzgooVar.zzg().zzc();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzgooVar.zzh().zzA(), "HMAC");
        int iZza = zzgooVar.zzg().zza();
        zzgol zzgolVar = zzgol.UNKNOWN_HASH;
        int iOrdinal = zzgolVarZzc.ordinal();
        if (iOrdinal == 1) {
            return new zzgrt(new zzgrs("HMACSHA1", secretKeySpec), iZza);
        }
        if (iOrdinal == 2) {
            return new zzgrt(new zzgrs("HMACSHA384", secretKeySpec), iZza);
        }
        if (iOrdinal == 3) {
            return new zzgrt(new zzgrs("HMACSHA256", secretKeySpec), iZza);
        }
        if (iOrdinal == 4) {
            return new zzgrt(new zzgrs("HMACSHA512", secretKeySpec), iZza);
        }
        if (iOrdinal == 5) {
            return new zzgrt(new zzgrs("HMACSHA224", secretKeySpec), iZza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
