package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzckc implements zzexs {
    private final zzcjs zza;
    private final zzckc zzb = this;
    private final zzhbp zzc;
    private final zzhbp zzd;
    private final zzhbp zze;
    private final zzhbp zzf;
    private final zzhbp zzg;
    private final zzhbp zzh;

    /* synthetic */ zzckc(zzcjs zzcjsVar, Context context, String str, zzckb zzckbVar) {
        this.zza = zzcjsVar;
        zzhbc zzhbcVarZza = zzhbd.zza(context);
        this.zzc = zzhbcVarZza;
        zzhbc zzhbcVarZza2 = zzhbd.zza(str);
        this.zzd = zzhbcVarZza2;
        zzfak zzfakVar = new zzfak(zzhbcVarZza, zzcjsVar.zzaG, zzcjsVar.zzaH);
        this.zze = zzfakVar;
        zzhbp zzhbpVarZzc = zzhbb.zzc(new zzeyq(zzcjsVar.zzaG));
        this.zzf = zzhbpVarZzc;
        zzhbp zzhbpVarZzc2 = zzhbb.zzc(new zzeys(zzhbcVarZza, zzcjsVar.zzo, zzcjsVar.zzU, zzfakVar, zzhbpVarZzc, zzfdp.zza(), zzcjsVar.zzh));
        this.zzg = zzhbpVarZzc2;
        this.zzh = zzhbb.zzc(new zzeyy(zzcjsVar.zzU, zzhbcVarZza, zzhbcVarZza2, zzhbpVarZzc2, zzhbpVarZzc, zzcjsVar.zzh, zzcjsVar.zzZ));
    }

    @Override // com.google.android.gms.internal.ads.zzexs
    public final zzeyx zza() {
        return (zzeyx) this.zzh.zzb();
    }
}
