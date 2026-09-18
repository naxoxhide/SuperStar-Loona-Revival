package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeig extends zzeid {
    private final zzchw zza;
    private final zzcwt zzb;
    private final zzekt zzc;
    private final zzddc zzd;
    private final zzdho zze;
    private final zzdaa zzf;
    private final ViewGroup zzg;
    private final zzdch zzh;
    private final zzeio zzi;
    private final zzeez zzj;

    public zzeig(zzchw zzchwVar, zzcwt zzcwtVar, zzekt zzektVar, zzddc zzddcVar, zzdho zzdhoVar, zzdaa zzdaaVar, ViewGroup viewGroup, zzdch zzdchVar, zzeio zzeioVar, zzeez zzeezVar) {
        this.zza = zzchwVar;
        this.zzb = zzcwtVar;
        this.zzc = zzektVar;
        this.zzd = zzddcVar;
        this.zze = zzdhoVar;
        this.zzf = zzdaaVar;
        this.zzg = viewGroup;
        this.zzh = zzdchVar;
        this.zzi = zzeioVar;
        this.zzj = zzeezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeid
    protected final ListenableFuture zzc(zzfdn zzfdnVar, Bundle bundle, zzfcr zzfcrVar, zzfde zzfdeVar) {
        zzcwt zzcwtVar = this.zzb;
        zzcwtVar.zzi(zzfdnVar);
        zzcwtVar.zzf(bundle);
        zzcwtVar.zzg(new zzcwn(zzfdeVar, zzfcrVar, this.zzi));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdp)).booleanValue()) {
            this.zzb.zzd(this.zzj);
        }
        zzchw zzchwVar = this.zza;
        zzcwt zzcwtVar2 = this.zzb;
        zzcrr zzcrrVarZze = zzchwVar.zze();
        zzcrrVarZze.zzi(zzcwtVar2.zzj());
        zzcrrVarZze.zzf(this.zzd);
        zzcrrVarZze.zze(this.zzc);
        zzcrrVarZze.zzd(this.zze);
        zzcrrVarZze.zzg(new zzcsp(this.zzf, this.zzh));
        zzcrrVarZze.zzc(new zzcqs(this.zzg));
        zzcue zzcueVarZzd = zzcrrVarZze.zzk().zzd();
        return zzcueVarZzd.zzi(zzcueVarZzd.zzj());
    }
}
