package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzclk implements zzfax {
    private final zzcjs zza;
    private final zzclk zzb = this;
    private final zzhbp zzc;
    private final zzhbp zzd;
    private final zzhbp zze;
    private final zzhbp zzf;
    private final zzhbp zzg;
    private final zzhbp zzh;
    private final zzhbp zzi;

    /* synthetic */ zzclk(zzcjs zzcjsVar, Context context, String str, com.google.android.gms.ads.internal.client.zzq zzqVar, zzclj zzcljVar) {
        this.zza = zzcjsVar;
        zzhbc zzhbcVarZza = zzhbd.zza(context);
        this.zzc = zzhbcVarZza;
        zzhbc zzhbcVarZza2 = zzhbd.zza(zzqVar);
        this.zzd = zzhbcVarZza2;
        zzhbc zzhbcVarZza3 = zzhbd.zza(str);
        this.zze = zzhbcVarZza3;
        zzhbp zzhbpVarZzc = zzhbb.zzc(new zzeml(zzcjsVar.zzn));
        this.zzf = zzhbpVarZzc;
        zzhbp zzhbpVarZzc2 = zzhbb.zzc(new zzfbv(zzcjsVar.zzaG));
        this.zzg = zzhbpVarZzc2;
        zzhbp zzhbpVarZzc3 = zzhbb.zzc(new zzfav(zzhbcVarZza, zzcjsVar.zzo, zzcjsVar.zzU, zzhbpVarZzc, zzhbpVarZzc2, zzfdp.zza()));
        this.zzh = zzhbpVarZzc3;
        this.zzi = zzhbb.zzc(new zzemt(zzhbcVarZza, zzhbcVarZza2, zzhbcVarZza3, zzhbpVarZzc3, zzhbpVarZzc, zzhbpVarZzc2, zzcjsVar.zzh, zzcjsVar.zzV, zzcjsVar.zzZ));
    }

    @Override // com.google.android.gms.internal.ads.zzfax
    public final zzems zza() {
        return (zzems) this.zzi.zzb();
    }
}
