package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzghv {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    @SafeVarargs
    protected zzghv(Class cls, zzgiv... zzgivVarArr) {
        this.zza = cls;
        HashMap map = new HashMap();
        for (int i = 0; i <= 0; i++) {
            zzgiv zzgivVar = zzgivVarArr[i];
            if (map.containsKey(zzgivVar.zzb())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(zzgivVar.zzb().getCanonicalName())));
            }
            map.put(zzgivVar.zzb(), zzgivVar);
        }
        this.zzc = zzgivVarArr[0].zzb();
        this.zzb = Collections.unmodifiableMap(map);
    }

    public zzghu zza() {
        throw null;
    }

    public abstract zzgoy zzb();

    public abstract zzgvj zzc(zzgsr zzgsrVar) throws zzgul;

    public abstract String zzd();

    public abstract void zze(zzgvj zzgvjVar) throws GeneralSecurityException;

    public int zzf() {
        return 1;
    }

    public final Class zzi() {
        return this.zzc;
    }

    public final Class zzj() {
        return this.zza;
    }

    public final Object zzk(zzgvj zzgvjVar, Class cls) throws GeneralSecurityException {
        zzgiv zzgivVar = (zzgiv) this.zzb.get(cls);
        if (zzgivVar != null) {
            return zzgivVar.zza(zzgvjVar);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public final Set zzl() {
        return this.zzb.keySet();
    }
}
