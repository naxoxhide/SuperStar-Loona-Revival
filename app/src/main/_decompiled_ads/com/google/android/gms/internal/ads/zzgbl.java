package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgbl {
    public static zzgbk zza(String str) throws GeneralSecurityException {
        zzgbw zzgbwVar = (zzgbw) zzgcg.zze().get("AES128_GCM");
        if (zzgbwVar != null) {
            return zzgbk.zza(zzgbwVar);
        }
        throw new GeneralSecurityException("cannot find key template: AES128_GCM");
    }
}
