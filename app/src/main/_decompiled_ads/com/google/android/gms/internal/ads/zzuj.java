package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzuj implements zzxk {
    private final zzxk zza;
    private final zzcx zzb;

    public zzuj(zzxk zzxkVar, zzcx zzcxVar) {
        this.zza = zzxkVar;
        this.zzb = zzcxVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuj)) {
            return false;
        }
        zzuj zzujVar = (zzuj) obj;
        return this.zza.equals(zzujVar.zza) && this.zzb.equals(zzujVar.zzb);
    }

    public final int hashCode() {
        return ((this.zzb.hashCode() + 527) * 31) + this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzxo
    public final int zza(int i) {
        return this.zza.zza(0);
    }

    @Override // com.google.android.gms.internal.ads.zzxo
    public final int zzb(int i) {
        return this.zza.zzb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzxo
    public final int zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzxo
    public final zzam zzd(int i) {
        return this.zza.zzd(i);
    }

    @Override // com.google.android.gms.internal.ads.zzxo
    public final zzcx zze() {
        return this.zzb;
    }
}
