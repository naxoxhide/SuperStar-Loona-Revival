package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcrn implements zzhbc {
    private final zzcrc zza;
    private final zzhbp zzb;
    private final zzhbp zzc;

    public zzcrn(zzcrc zzcrcVar, zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzcrcVar;
        this.zzb = zzhbpVar;
        this.zzc = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbyg zzb() {
        return new zzbyg(((zzcic) this.zzb).zza(), ((zzcxc) this.zzc).zza().zzf);
    }
}
