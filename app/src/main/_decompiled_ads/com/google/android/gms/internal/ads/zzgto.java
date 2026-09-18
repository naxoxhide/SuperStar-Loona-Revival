package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgto {
    private static final zzgtm zza = new zzgtn();
    private static final zzgtm zzb;

    static {
        zzgtm zzgtmVar;
        try {
            zzgtmVar = (zzgtm) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgtmVar = null;
        }
        zzb = zzgtmVar;
    }

    static zzgtm zza() {
        zzgtm zzgtmVar = zzb;
        if (zzgtmVar != null) {
            return zzgtmVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzgtm zzb() {
        return zza;
    }
}
