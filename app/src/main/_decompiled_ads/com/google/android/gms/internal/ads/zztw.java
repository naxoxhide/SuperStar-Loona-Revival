package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztw {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    public zztw(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    private zztw(Object obj, int i, int i2, long j, int i3) {
        this.zza = obj;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = i3;
    }

    public zztw(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zztw)) {
            return false;
        }
        zztw zztwVar = (zztw) obj;
        return this.zza.equals(zztwVar.zza) && this.zzb == zztwVar.zzb && this.zzc == zztwVar.zzc && this.zzd == zztwVar.zzd && this.zze == zztwVar.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zztw zza(Object obj) {
        return this.zza.equals(obj) ? this : new zztw(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zztw(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
