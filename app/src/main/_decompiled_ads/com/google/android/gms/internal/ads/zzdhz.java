package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdhz implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;
    private final zzhbp zzc;
    private final zzhbp zzd;
    private final zzhbp zze;
    private final zzhbp zzf;

    public zzdhz(zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3, zzhbp zzhbpVar4, zzhbp zzhbpVar5, zzhbp zzhbpVar6) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
        this.zzc = zzhbpVar3;
        this.zzd = zzhbpVar4;
        this.zze = zzhbpVar5;
        this.zzf = zzhbpVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzchw zzchwVar = (zzchw) this.zza.zzb();
        zzcwt zzcwtVarZza = ((zzcxd) this.zzb).zza();
        zzddc zzddcVarZza = ((zzddv) this.zzc).zza();
        zzdho zzdhoVarZza = ((zzdhq) this.zzd).zza();
        zzdaa zzdaaVarZzb = ((zzcqu) this.zze).zzb();
        zzeio zzeioVar = (zzeio) this.zzf.zzb();
        zzcrr zzcrrVarZze = zzchwVar.zze();
        zzcrrVarZze.zzi(zzcwtVarZza.zzj());
        zzcrrVarZze.zzf(zzddcVarZza);
        zzcrrVarZze.zzd(zzdhoVarZza);
        zzcrrVarZze.zze(new zzekt(null));
        zzcrrVarZze.zzg(new zzcsp(zzdaaVarZzb, null));
        zzcrrVarZze.zzc(new zzcqs(null));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzds)).booleanValue()) {
            zzcrrVarZze.zzj(zzeiw.zzb(zzeioVar));
        }
        zzcta zzctaVarZzc = zzcrrVarZze.zzh().zzc();
        zzhbk.zzb(zzctaVarZzc);
        return zzctaVarZzc;
    }
}
