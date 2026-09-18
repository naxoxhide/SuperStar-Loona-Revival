package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgtu implements zzgvh {
    private static final zzgtu zza = new zzgtu();

    private zzgtu() {
    }

    public static zzgtu zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvh
    public final zzgvg zzb(Class cls) {
        if (!zzgtz.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzgvg) zzgtz.zzaC(cls.asSubclass(zzgtz.class)).zzb(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgvh
    public final boolean zzc(Class cls) {
        return zzgtz.class.isAssignableFrom(cls);
    }
}
