package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgle {

    @Deprecated
    static final zzgqi zza;

    @Deprecated
    static final zzgqi zzb;

    @Deprecated
    static final zzgqi zzc;

    static {
        new zzgkx();
        zzgqi zzgqiVarZzc = zzgqi.zzc();
        zza = zzgqiVarZzc;
        zzb = zzgqiVarZzc;
        zzc = zzgqiVarZzc;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzglk.zzd();
        zzgko.zzd();
        zzgkx.zzh(true);
        if (zzghg.zzb()) {
            return;
        }
        zzgka.zzm(true);
    }
}
