package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgdb extends zzgcl {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzgcz zze;
    private final zzgcy zzf;

    /* synthetic */ zzgdb(int i, int i2, int i3, int i4, zzgcz zzgczVar, zzgcy zzgcyVar, zzgda zzgdaVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzgczVar;
        this.zzf = zzgcyVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgdb)) {
            return false;
        }
        zzgdb zzgdbVar = (zzgdb) obj;
        return zzgdbVar.zza == this.zza && zzgdbVar.zzb == this.zzb && zzgdbVar.zzc == this.zzc && zzgdbVar.zzd == this.zzd && zzgdbVar.zze == this.zze && zzgdbVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgdb.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        zzgcy zzgcyVar = this.zzf;
        return "AesCtrHmacAead Parameters (variant: " + String.valueOf(this.zze) + ", hashType: " + String.valueOf(zzgcyVar) + ", " + this.zzc + "-byte IV, and " + this.zzd + "-byte tags, and " + this.zza + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final zzgcy zze() {
        return this.zzf;
    }

    public final zzgcz zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return this.zze != zzgcz.zzc;
    }
}
