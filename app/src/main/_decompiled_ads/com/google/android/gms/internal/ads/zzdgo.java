package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdgo implements zzhbc {
    private final zzdga zza;
    private final zzhbp zzb;
    private final zzhbp zzc;

    public zzdgo(zzdga zzdgaVar, zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzdgaVar;
        this.zzb = zzhbpVar;
        this.zzc = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdhk zzdhkVar = (zzdhk) this.zzb.zzb();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        return new zzdev(zzdhkVar, zzgadVar);
    }
}
