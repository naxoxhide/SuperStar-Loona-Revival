package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzckm implements zzezg {
    private final Context zza;
    private final com.google.android.gms.ads.internal.client.zzq zzb;
    private final String zzc;
    private final zzcjs zzd;
    private final zzckm zze = this;
    private final zzhbp zzf;
    private final zzhbp zzg;
    private final zzhbp zzh;
    private final zzhbp zzi;
    private final zzhbp zzj;
    private final zzhbp zzk;

    /* synthetic */ zzckm(zzcjs zzcjsVar, Context context, String str, com.google.android.gms.ads.internal.client.zzq zzqVar, zzckl zzcklVar) {
        this.zzd = zzcjsVar;
        this.zza = context;
        this.zzb = zzqVar;
        this.zzc = str;
        zzhbc zzhbcVarZza = zzhbd.zza(context);
        this.zzf = zzhbcVarZza;
        zzhbc zzhbcVarZza2 = zzhbd.zza(zzqVar);
        this.zzg = zzhbcVarZza2;
        zzhbp zzhbpVarZzc = zzhbb.zzc(new zzeml(zzcjsVar.zzn));
        this.zzh = zzhbpVarZzc;
        zzhbp zzhbpVarZzc2 = zzhbb.zzc(zzemq.zza());
        this.zzi = zzhbpVarZzc2;
        zzhbp zzhbpVarZzc3 = zzhbb.zzc(zzdcj.zza());
        this.zzj = zzhbpVarZzc3;
        this.zzk = zzhbb.zzc(new zzeze(zzhbcVarZza, zzcjsVar.zzo, zzhbcVarZza2, zzcjsVar.zzU, zzhbpVarZzc, zzhbpVarZzc2, zzfdp.zza(), zzhbpVarZzc3));
    }

    @Override // com.google.android.gms.internal.ads.zzezg
    public final zzelq zza() {
        zzezd zzezdVar = (zzezd) this.zzk.zzb();
        zzemk zzemkVar = (zzemk) this.zzh.zzb();
        zzcaz zzcazVarZzd = this.zzd.zza.zzd();
        zzhbk.zzb(zzcazVarZzd);
        return new zzelq(this.zza, this.zzb, this.zzc, zzezdVar, zzemkVar, zzcazVarZzd, (zzdso) this.zzd.zzZ.zzb());
    }
}
