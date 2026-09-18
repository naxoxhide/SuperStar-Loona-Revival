package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzggn extends zzgcl {
    private final zzggm zza;

    private zzggn(zzggm zzggmVar) {
        this.zza = zzggmVar;
    }

    public static zzggn zzb(zzggm zzggmVar) {
        return new zzggn(zzggmVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzggn) && ((zzggn) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzggn.class, this.zza});
    }

    public final String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + this.zza.toString() + ")";
    }

    public final zzggm zza() {
        return this.zza;
    }
}
