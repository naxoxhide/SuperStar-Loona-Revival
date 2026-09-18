package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgfo extends zzgcl {
    private final zzgfn zza;

    private zzgfo(zzgfn zzgfnVar) {
        this.zza = zzgfnVar;
    }

    public static zzgfo zzb(zzgfn zzgfnVar) {
        return new zzgfo(zzgfnVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgfo) && ((zzgfo) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgfo.class, this.zza});
    }

    public final String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.zza.toString() + ")";
    }

    public final zzgfn zza() {
        return this.zza;
    }
}
