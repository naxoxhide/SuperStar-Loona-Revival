package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzclo implements zzfcl {
    private final zzcjs zza;
    private final zzclo zzb = this;
    private final zzhbp zzc;
    private final zzhbp zzd;
    private final zzhbp zze;
    private final zzhbp zzf;
    private final zzhbp zzg;
    private final zzhbp zzh;
    private final zzhbp zzi;
    private final zzhbp zzj;

    /* synthetic */ zzclo(zzcjs zzcjsVar, Context context, String str, zzcln zzclnVar) {
        this.zza = zzcjsVar;
        zzhbc zzhbcVarZza = zzhbd.zza(context);
        this.zzc = zzhbcVarZza;
        zzfal zzfalVar = new zzfal(zzhbcVarZza, zzcjsVar.zzaG, zzcjsVar.zzaH);
        this.zzd = zzfalVar;
        zzhbp zzhbpVarZzc = zzhbb.zzc(new zzfbv(zzcjsVar.zzaG));
        this.zze = zzhbpVarZzc;
        zzhbp zzhbpVarZzc2 = zzhbb.zzc(zzfdk.zza());
        this.zzf = zzhbpVarZzc2;
        zzhbp zzhbpVarZzc3 = zzhbb.zzc(new zzfcf(zzhbcVarZza, zzcjsVar.zzo, zzcjsVar.zzU, zzfalVar, zzhbpVarZzc, zzfdp.zza(), zzhbpVarZzc2));
        this.zzg = zzhbpVarZzc3;
        this.zzh = zzhbb.zzc(new zzfcp(zzhbpVarZzc3, zzhbpVarZzc, zzhbpVarZzc2));
        zzhbc zzhbcVarZzc = zzhbd.zzc(str);
        this.zzi = zzhbcVarZzc;
        this.zzj = zzhbb.zzc(new zzfcj(zzhbcVarZzc, zzhbpVarZzc3, zzhbcVarZza, zzhbpVarZzc, zzhbpVarZzc2, zzcjsVar.zzh, zzcjsVar.zzV, zzcjsVar.zzZ));
    }

    @Override // com.google.android.gms.internal.ads.zzfcl
    public final zzfci zza() {
        return (zzfci) this.zzj.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfcl
    public final zzfco zzb() {
        return (zzfco) this.zzh.zzb();
    }
}
