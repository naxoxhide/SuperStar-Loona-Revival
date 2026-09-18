package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvp {
    private static final zzgvo zza;
    private static final zzgvo zzb;

    static {
        zzgvo zzgvoVar;
        try {
            zzgvoVar = (zzgvo) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgvoVar = null;
        }
        zza = zzgvoVar;
        zzb = new zzgvo();
    }

    static zzgvo zza() {
        return zza;
    }

    static zzgvo zzb() {
        return zzb;
    }
}
