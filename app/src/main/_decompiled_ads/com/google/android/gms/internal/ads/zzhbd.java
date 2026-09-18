package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhbd implements zzhbc, zzhaw {
    private static final zzhbd zza = new zzhbd(null);
    private final Object zzb;

    private zzhbd(Object obj) {
        this.zzb = obj;
    }

    public static zzhbc zza(Object obj) {
        zzhbk.zza(obj, "instance cannot be null");
        return new zzhbd(obj);
    }

    public static zzhbc zzc(Object obj) {
        return obj == null ? zza : new zzhbd(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final Object zzb() {
        return this.zzb;
    }
}
