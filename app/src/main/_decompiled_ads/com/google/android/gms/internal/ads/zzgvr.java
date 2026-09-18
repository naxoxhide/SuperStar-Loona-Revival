package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvr {
    private static final zzgvr zza = new zzgvr();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzgwd zzb = new zzgvb();

    private zzgvr() {
    }

    public static zzgvr zza() {
        return zza;
    }

    public final zzgwc zzb(Class cls) {
        zzguj.zzc(cls, "messageType");
        zzgwc zzgwcVarZza = (zzgwc) this.zzc.get(cls);
        if (zzgwcVarZza == null) {
            zzgwcVarZza = this.zzb.zza(cls);
            zzguj.zzc(cls, "messageType");
            zzgwc zzgwcVar = (zzgwc) this.zzc.putIfAbsent(cls, zzgwcVarZza);
            if (zzgwcVar != null) {
                return zzgwcVar;
            }
        }
        return zzgwcVarZza;
    }
}
