package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgix {
    private final Map zza;
    private final Map zzb;

    private zzgix() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgix zza(zzgiu zzgiuVar) throws GeneralSecurityException {
        zzgiz zzgizVar = new zzgiz(zzgiuVar.zzc(), zzgiuVar.zzd(), null);
        if (this.zza.containsKey(zzgizVar)) {
            zzgiu zzgiuVar2 = (zzgiu) this.zza.get(zzgizVar);
            if (!zzgiuVar2.equals(zzgiuVar) || !zzgiuVar.equals(zzgiuVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgizVar.toString()));
            }
        } else {
            this.zza.put(zzgizVar, zzgiuVar);
        }
        return this;
    }

    public final zzgix zzb(zzgce zzgceVar) throws GeneralSecurityException {
        Map map = this.zzb;
        Class clsZzb = zzgceVar.zzb();
        if (map.containsKey(clsZzb)) {
            zzgce zzgceVar2 = (zzgce) this.zzb.get(clsZzb);
            if (!zzgceVar2.equals(zzgceVar) || !zzgceVar.equals(zzgceVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(clsZzb.toString()));
            }
        } else {
            this.zzb.put(clsZzb, zzgceVar);
        }
        return this;
    }

    /* synthetic */ zzgix(zzgiw zzgiwVar) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    /* synthetic */ zzgix(zzgjb zzgjbVar, zzgiw zzgiwVar) {
        this.zza = new HashMap(zzgjbVar.zza);
        this.zzb = new HashMap(zzgjbVar.zzb);
    }
}
