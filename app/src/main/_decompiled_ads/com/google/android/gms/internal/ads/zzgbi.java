package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgbi {
    private static final Logger zza = Logger.getLogger(zzgbi.class.getName());
    private final ConcurrentMap zzb;

    zzgbi() {
        this.zzb = new ConcurrentHashMap();
    }

    private final synchronized zzgbh zze(String str) throws GeneralSecurityException {
        if (!this.zzb.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzgbh) this.zzb.get(str);
    }

    private final synchronized void zzf(zzgbh zzgbhVar, boolean z) throws GeneralSecurityException {
        String strZzc = zzgbhVar.zza().zzc();
        zzgbh zzgbhVar2 = (zzgbh) this.zzb.get(strZzc);
        if (zzgbhVar2 != null && !zzgbhVar2.zza.getClass().equals(zzgbhVar.zza.getClass())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(strZzc));
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strZzc, zzgbhVar2.zza.getClass().getName(), zzgbhVar.zza.getClass().getName()));
        }
        this.zzb.putIfAbsent(strZzc, zzgbhVar);
    }

    final zzgbf zza(String str, Class cls) throws GeneralSecurityException {
        zzgbh zzgbhVarZze = zze(str);
        if (zzgbhVarZze.zza.zzl().contains(cls)) {
            try {
                return new zzgbg(zzgbhVarZze.zza, cls);
            } catch (IllegalArgumentException e) {
                throw new GeneralSecurityException("Primitive type not supported", e);
            }
        }
        String name = cls.getName();
        zzghv zzghvVar = zzgbhVarZze.zza;
        String strValueOf = String.valueOf(zzghvVar.getClass());
        Set<Class> setZzl = zzghvVar.zzl();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : setZzl) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + strValueOf + ", supported primitives: " + sb.toString());
    }

    final zzgbf zzb(String str) throws GeneralSecurityException {
        return zze(str).zza();
    }

    final synchronized void zzc(zzghv zzghvVar) throws GeneralSecurityException {
        if (!zzghf.zza(zzghvVar.zzf())) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzghvVar.getClass()) + " as it is not FIPS compatible.");
        }
        zzf(new zzgbh(zzghvVar), false);
    }

    final boolean zzd(String str) {
        return this.zzb.containsKey(str);
    }

    zzgbi(zzgbi zzgbiVar) {
        this.zzb = new ConcurrentHashMap(zzgbiVar.zzb);
    }
}
