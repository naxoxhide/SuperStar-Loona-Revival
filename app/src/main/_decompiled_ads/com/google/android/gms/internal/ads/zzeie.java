package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeie extends zzeid {
    private final zzchw zza;
    private final zzcwt zzb;
    private final zzddc zzc;
    private final zzeio zzd;
    private final zzeez zze;

    zzeie(zzchw zzchwVar, zzcwt zzcwtVar, zzddc zzddcVar, zzeio zzeioVar, zzeez zzeezVar) {
        this.zza = zzchwVar;
        this.zzb = zzcwtVar;
        this.zzc = zzddcVar;
        this.zzd = zzeioVar;
        this.zze = zzeezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeid
    protected final ListenableFuture zzc(zzfdn zzfdnVar, Bundle bundle, zzfcr zzfcrVar, zzfde zzfdeVar) {
        zzcwt zzcwtVar = this.zzb;
        zzcwtVar.zzi(zzfdnVar);
        zzcwtVar.zzf(bundle);
        zzcwtVar.zzg(new zzcwn(zzfdeVar, zzfcrVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdp)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzchw zzchwVar = this.zza;
        zzcwt zzcwtVar2 = this.zzb;
        zzcqi zzcqiVarZzd = zzchwVar.zzd();
        zzcqiVarZzd.zzd(zzcwtVar2.zzj());
        zzcqiVarZzd.zzc(this.zzc);
        zzcue zzcueVarZzb = zzcqiVarZzd.zze().zzb();
        return zzcueVarZzb.zzi(zzcueVarZzb.zzj());
    }
}
