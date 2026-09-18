package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzghx extends zzgbe {
    private final zzgjc zza;

    public zzghx(zzgjc zzgjcVar, @Nullable zzgch zzgchVar) throws GeneralSecurityException {
        zzc(zzgjcVar, zzgchVar);
        this.zza = zzgjcVar;
    }

    private static void zzc(zzgjc zzgjcVar, @Nullable zzgch zzgchVar) throws GeneralSecurityException {
        int i = zzghw.zzb[zzgjcVar.zzb().ordinal()];
    }

    public final zzgjc zza(@Nullable zzgch zzgchVar) throws GeneralSecurityException {
        zzc(this.zza, zzgchVar);
        return this.zza;
    }

    @Nullable
    public final Integer zzb() {
        return this.zza.zzf();
    }
}
