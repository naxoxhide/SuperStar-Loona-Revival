package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeii extends zzeid {
    private final zzchw zza;
    private final zzcwt zzb;
    private final zzekt zzc;
    private final zzddc zzd;
    private final zzeio zze;
    private final zzeez zzf;

    public zzeii(zzchw zzchwVar, zzcwt zzcwtVar, zzekt zzektVar, zzddc zzddcVar, zzeio zzeioVar, zzeez zzeezVar) {
        this.zza = zzchwVar;
        this.zzb = zzcwtVar;
        this.zzc = zzektVar;
        this.zzd = zzddcVar;
        this.zze = zzeioVar;
        this.zzf = zzeezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeid
    protected final ListenableFuture zzc(zzfdn zzfdnVar, Bundle bundle, zzfcr zzfcrVar, zzfde zzfdeVar) {
        zzcwt zzcwtVar = this.zzb;
        zzcwtVar.zzi(zzfdnVar);
        zzcwtVar.zzf(bundle);
        zzcwtVar.zzg(new zzcwn(zzfdeVar, zzfcrVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdp)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzchw zzchwVar = this.zza;
        zzcwt zzcwtVar2 = this.zzb;
        zzdgw zzdgwVarZzg = zzchwVar.zzg();
        zzdgwVarZzg.zze(zzcwtVar2.zzj());
        zzdgwVarZzg.zzd(this.zzd);
        zzdgwVarZzg.zzc(this.zzc);
        zzcue zzcueVarZza = zzdgwVarZzg.zzf().zza();
        return zzcueVarZza.zzi(zzcueVarZza.zzj());
    }
}
