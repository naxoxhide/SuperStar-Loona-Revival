package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgfd extends zzgcl {
    private final int zza;
    private final zzgfb zzb;

    /* synthetic */ zzgfd(int i, zzgfb zzgfbVar, zzgfc zzgfcVar) {
        this.zza = i;
        this.zzb = zzgfbVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfd)) {
            return false;
        }
        zzgfd zzgfdVar = (zzgfd) obj;
        return zzgfdVar.zza == this.zza && zzgfdVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgfd.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        return "AesGcmSiv Parameters (variant: " + String.valueOf(this.zzb) + ", " + this.zza + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzgfb zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzb != zzgfb.zzc;
    }
}
