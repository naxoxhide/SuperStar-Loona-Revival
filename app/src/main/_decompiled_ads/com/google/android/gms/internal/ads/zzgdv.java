package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgdv extends zzgcl {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzgdt zzd;

    /* synthetic */ zzgdv(int i, int i2, int i3, zzgdt zzgdtVar, zzgdu zzgduVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzgdtVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgdv)) {
            return false;
        }
        zzgdv zzgdvVar = (zzgdv) obj;
        if (zzgdvVar.zza == this.zza && zzgdvVar.zzb == this.zzb) {
            int i = zzgdvVar.zzc;
            if (zzgdvVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgdv.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        return "AesEax Parameters (variant: " + String.valueOf(this.zzd) + ", " + this.zzb + "-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgdt zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zzd != zzgdt.zzc;
    }
}
