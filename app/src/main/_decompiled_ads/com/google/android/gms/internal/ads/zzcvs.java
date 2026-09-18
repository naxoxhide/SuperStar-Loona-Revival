package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcvs implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;

    public zzcvs(zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcuy zzcuyVar = (zzcuy) this.zza.zzb();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        zzfvx zzfvxVarZzn = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfy)).booleanValue() ? zzfvx.zzn(new zzdev(zzcuyVar, zzgadVar)) : zzfvx.zzm();
        zzhbk.zzb(zzfvxVarZzn);
        return zzfvxVarZzn;
    }
}
