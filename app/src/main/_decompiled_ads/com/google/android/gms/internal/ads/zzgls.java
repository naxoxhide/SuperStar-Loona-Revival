package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgls implements zzgkl {
    private final zzgjv zza;

    public zzgls(zzgjv zzgjvVar) throws GeneralSecurityException {
        if (!zzghf.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        this.zza = zzgjvVar;
    }
}
