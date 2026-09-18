package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcpt implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;
    private final zzhbp zzc;

    public zzcpt(zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
        this.zzc = zzhbpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzaus zzausVar = (zzaus) this.zza.zzb();
        zzboj zzbojVar = (zzboj) this.zzb.zzb();
        zzgad zzgadVarZza = zzfge.zza();
        zzhbk.zzb(zzgadVarZza);
        return new zzcpm(zzausVar.zzc(), zzbojVar, zzgadVarZza);
    }
}
