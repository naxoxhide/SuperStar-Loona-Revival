package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzghp {
    private final zzgrx zza;
    private final Class zzb;

    /* synthetic */ zzghp(zzgrx zzgrxVar, Class cls, zzgho zzghoVar) {
        this.zza = zzgrxVar;
        this.zzb = cls;
    }

    public static zzghp zzb(zzghn zzghnVar, zzgrx zzgrxVar, Class cls) {
        return new zzghm(zzgrxVar, cls, zzghnVar);
    }

    public abstract zzgbe zza(zzgjh zzgjhVar, @Nullable zzgch zzgchVar) throws GeneralSecurityException;

    public final zzgrx zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
