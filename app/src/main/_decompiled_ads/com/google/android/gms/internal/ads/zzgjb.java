package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgjb {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzgjb(zzgix zzgixVar, zzgja zzgjaVar) {
        this.zza = new HashMap(zzgixVar.zza);
        this.zzb = new HashMap(zzgixVar.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzgce) this.zzb.get(cls)).zza();
        }
        throw new GeneralSecurityException("No input primitive class for " + cls.toString() + " available");
    }

    public final Object zzb(zzgbe zzgbeVar, Class cls) throws GeneralSecurityException {
        zzgiz zzgizVar = new zzgiz(zzgbeVar.getClass(), cls, null);
        if (this.zza.containsKey(zzgizVar)) {
            return ((zzgiu) this.zza.get(zzgizVar)).zza(zzgbeVar);
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + zzgizVar.toString() + " available");
    }

    public final Object zzc(zzgcd zzgcdVar, Class cls) throws GeneralSecurityException {
        if (!this.zzb.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        zzgce zzgceVar = (zzgce) this.zzb.get(cls);
        if (zzgcdVar.zzc().equals(zzgceVar.zza()) && zzgceVar.zza().equals(zzgcdVar.zzc())) {
            return zzgceVar.zzc(zzgcdVar);
        }
        throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
    }
}
