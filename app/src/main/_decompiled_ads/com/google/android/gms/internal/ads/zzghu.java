package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzghu {
    private final Class zza;

    public zzghu(Class cls) {
        this.zza = cls;
    }

    public abstract zzgvj zza(zzgvj zzgvjVar) throws GeneralSecurityException;

    public abstract zzgvj zzb(zzgsr zzgsrVar) throws zzgul;

    public Map zzc() throws GeneralSecurityException {
        return Collections.emptyMap();
    }

    public abstract void zzd(zzgvj zzgvjVar) throws GeneralSecurityException;
}
