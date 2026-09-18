package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcro implements zzhbc {
    private final zzcrc zza;
    private final zzhbp zzb;
    private final zzhbp zzc;

    public zzcro(zzcrc zzcrcVar, zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzcrcVar;
        this.zzb = zzhbpVar;
        this.zzc = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcst zzcstVar = (zzcst) this.zzb.zzb();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        return new zzdev(zzcstVar, zzgadVar);
    }
}
