package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgve {
    zzgve() {
    }

    public static final boolean zza(Object obj) {
        return !((zzgvd) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzgvd zzgvdVarZzb = (zzgvd) obj;
        zzgvd zzgvdVar = (zzgvd) obj2;
        if (!zzgvdVar.isEmpty()) {
            if (!zzgvdVarZzb.zze()) {
                zzgvdVarZzb = zzgvdVarZzb.zzb();
            }
            zzgvdVarZzb.zzd(zzgvdVar);
        }
        return zzgvdVarZzb;
    }
}
