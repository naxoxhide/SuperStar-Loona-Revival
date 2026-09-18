package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzghm extends zzghp {
    final /* synthetic */ zzghn zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzghm(zzgrx zzgrxVar, Class cls, zzghn zzghnVar) {
        super(zzgrxVar, cls, null);
        this.zza = zzghnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzghp
    public final zzgbe zza(zzgjh zzgjhVar, @Nullable zzgch zzgchVar) throws GeneralSecurityException {
        return this.zza.zza(zzgjhVar, zzgchVar);
    }
}
