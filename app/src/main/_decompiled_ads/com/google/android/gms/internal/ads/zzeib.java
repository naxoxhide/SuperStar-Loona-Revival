package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeib extends zzeid {
    private final zzchw zza;
    private final zzdho zzb;
    private final zzcwt zzc;
    private final zzddc zzd;
    private final zzeio zze;
    private final zzeez zzf;

    public zzeib(zzchw zzchwVar, zzdho zzdhoVar, zzcwt zzcwtVar, zzddc zzddcVar, zzeio zzeioVar, zzeez zzeezVar) {
        this.zza = zzchwVar;
        this.zzb = zzdhoVar;
        this.zzc = zzcwtVar;
        this.zzd = zzddcVar;
        this.zze = zzeioVar;
        this.zzf = zzeezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeid
    protected final ListenableFuture zzc(zzfdn zzfdnVar, Bundle bundle, zzfcr zzfcrVar, zzfde zzfdeVar) {
        zzcwt zzcwtVar = this.zzc;
        zzcwtVar.zzi(zzfdnVar);
        zzcwtVar.zzf(bundle);
        zzcwtVar.zzg(new zzcwn(zzfdeVar, zzfcrVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdp)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzchw zzchwVar = this.zza;
        zzcwt zzcwtVar2 = this.zzc;
        zzdhs zzdhsVarZzh = zzchwVar.zzh();
        zzdhsVarZzh.zzf(zzcwtVar2.zzj());
        zzdhsVarZzh.zze(this.zzd);
        zzdhsVarZzh.zzd(this.zzb);
        zzdhsVarZzh.zzc(new zzcqs(null));
        zzcue zzcueVarZza = zzdhsVarZzh.zzg().zza();
        return zzcueVarZza.zzi(zzcueVarZza.zzj());
    }
}
