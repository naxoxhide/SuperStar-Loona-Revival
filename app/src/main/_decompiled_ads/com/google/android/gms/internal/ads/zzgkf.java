package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgkf extends zzglg {
    private final int zza;
    private final int zzb;
    private final zzgkd zzc;

    /* synthetic */ zzgkf(int i, int i2, zzgkd zzgkdVar, zzgke zzgkeVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgkdVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgkf)) {
            return false;
        }
        zzgkf zzgkfVar = (zzgkf) obj;
        return zzgkfVar.zza == this.zza && zzgkfVar.zzc() == zzc() && zzgkfVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgkf.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + String.valueOf(this.zzc) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        zzgkd zzgkdVar = this.zzc;
        if (zzgkdVar == zzgkd.zzd) {
            return this.zzb;
        }
        if (zzgkdVar == zzgkd.zza || zzgkdVar == zzgkd.zzb || zzgkdVar == zzgkd.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgkd zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zzc != zzgkd.zzd;
    }
}
