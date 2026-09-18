package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvf {
    private static final zzgve zza;
    private static final zzgve zzb;

    static {
        zzgve zzgveVar;
        try {
            zzgveVar = (zzgve) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgveVar = null;
        }
        zza = zzgveVar;
        zzb = new zzgve();
    }

    static zzgve zza() {
        return zza;
    }

    static zzgve zzb() {
        return zzb;
    }
}
