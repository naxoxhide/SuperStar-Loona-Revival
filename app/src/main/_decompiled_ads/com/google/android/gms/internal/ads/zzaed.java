package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaed extends zzaca {
    private final long zza;

    public zzaed(zzabn zzabnVar, long j) {
        super(zzabnVar);
        zzdx.zzd(zzabnVar.zzf() >= j);
        this.zza = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaca, com.google.android.gms.internal.ads.zzabn
    public final long zzd() {
        return super.zzd() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaca, com.google.android.gms.internal.ads.zzabn
    public final long zze() {
        return super.zze() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaca, com.google.android.gms.internal.ads.zzabn
    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
