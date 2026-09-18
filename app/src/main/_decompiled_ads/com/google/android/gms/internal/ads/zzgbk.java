package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgbk {

    @Nullable
    private final zzgbw zza;

    private zzgbk(zzgbw zzgbwVar) {
        this.zza = zzgbwVar;
    }

    public static zzgbk zza(zzgbw zzgbwVar) throws GeneralSecurityException {
        return new zzgbk(zzgbwVar);
    }

    public final zzgbw zzb() throws GeneralSecurityException {
        return this.zza;
    }
}
