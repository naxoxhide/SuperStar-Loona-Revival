package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgux {
    private static final zzgux zza = new zzgut(null);
    private static final zzgux zzb = new zzguv(0 == true ? 1 : 0);

    /* synthetic */ zzgux(zzguw zzguwVar) {
    }

    static zzgux zzd() {
        return zza;
    }

    static zzgux zze() {
        return zzb;
    }

    abstract List zza(Object obj, long j);

    abstract void zzb(Object obj, long j);

    abstract void zzc(Object obj, Object obj2, long j);
}
