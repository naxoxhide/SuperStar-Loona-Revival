package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfau implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzchw zzc;
    private final zzemk zzd;
    private final zzfbu zze;
    private zzbdg zzf;
    private final zzfjh zzg;
    private final zzfdl zzh;
    private ListenableFuture zzi;

    public zzfau(Context context, Executor executor, zzchw zzchwVar, zzemk zzemkVar, zzfbu zzfbuVar, zzfdl zzfdlVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzchwVar;
        this.zzd = zzemkVar;
        this.zzh = zzfdlVar;
        this.zze = zzfbuVar;
        this.zzg = zzchwVar.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzi;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzemy zzemyVar, zzemz zzemzVar) {
        zzdgx zzdgxVarZzf;
        zzfje zzfjeVar;
        if (str == null) {
            zzcat.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfao
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzh();
                }
            });
            return false;
        }
        if (zza()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziF)).booleanValue() && zzlVar.zzf) {
            this.zzc.zzk().zzn(true);
        }
        com.google.android.gms.ads.internal.client.zzq zzqVar = ((zzfan) zzemyVar).zza;
        zzfdl zzfdlVar = this.zzh;
        zzfdlVar.zzs(str);
        zzfdlVar.zzr(zzqVar);
        zzfdlVar.zzE(zzlVar);
        Context context = this.zza;
        zzfdn zzfdnVarZzG = zzfdlVar.zzG();
        zzfit zzfitVarZzb = zzfis.zzb(context, zzfjd.zzf(zzfdnVarZzG), 4, zzlVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhW)).booleanValue()) {
            zzdgw zzdgwVarZzg = this.zzc.zzg();
            zzcwt zzcwtVar = new zzcwt();
            zzcwtVar.zze(this.zza);
            zzcwtVar.zzi(zzfdnVarZzG);
            zzdgwVarZzg.zze(zzcwtVar.zzj());
            zzdda zzddaVar = new zzdda();
            zzddaVar.zzj(this.zzd, this.zzb);
            zzddaVar.zzk(this.zzd, this.zzb);
            zzdgwVarZzg.zzd(zzddaVar.zzn());
            zzdgwVarZzg.zzc(new zzekt(this.zzf));
            zzdgxVarZzf = zzdgwVarZzg.zzh();
        } else {
            zzdda zzddaVar2 = new zzdda();
            zzfbu zzfbuVar = this.zze;
            if (zzfbuVar != null) {
                zzddaVar2.zze(zzfbuVar, this.zzb);
                zzddaVar2.zzf(this.zze, this.zzb);
                zzddaVar2.zzb(this.zze, this.zzb);
            }
            zzdgw zzdgwVarZzg2 = this.zzc.zzg();
            zzcwt zzcwtVar2 = new zzcwt();
            zzcwtVar2.zze(this.zza);
            zzcwtVar2.zzi(zzfdnVarZzG);
            zzdgwVarZzg2.zze(zzcwtVar2.zzj());
            zzddaVar2.zzj(this.zzd, this.zzb);
            zzddaVar2.zze(this.zzd, this.zzb);
            zzddaVar2.zzf(this.zzd, this.zzb);
            zzddaVar2.zzb(this.zzd, this.zzb);
            zzddaVar2.zza(this.zzd, this.zzb);
            zzddaVar2.zzl(this.zzd, this.zzb);
            zzddaVar2.zzk(this.zzd, this.zzb);
            zzddaVar2.zzi(this.zzd, this.zzb);
            zzddaVar2.zzc(this.zzd, this.zzb);
            zzdgwVarZzg2.zzd(zzddaVar2.zzn());
            zzdgwVarZzg2.zzc(new zzekt(this.zzf));
            zzdgxVarZzf = zzdgwVarZzg2.zzh();
        }
        zzdgx zzdgxVar = zzdgxVarZzf;
        if (((Boolean) zzbdu.zzc.zze()).booleanValue()) {
            zzfje zzfjeVarZzf = zzdgxVar.zzf();
            zzfjeVarZzf.zzh(4);
            zzfjeVarZzf.zzb(zzlVar.zzp);
            zzfjeVar = zzfjeVarZzf;
        } else {
            zzfjeVar = null;
        }
        zzcue zzcueVarZza = zzdgxVar.zza();
        ListenableFuture listenableFutureZzi = zzcueVarZza.zzi(zzcueVarZza.zzj());
        this.zzi = listenableFutureZzi;
        zzfzt.zzr(listenableFutureZzi, new zzfat(this, zzemzVar, zzfjeVar, zzfitVarZzb, zzdgxVar), this.zzb);
        return true;
    }

    final /* synthetic */ void zzh() {
        this.zzd.zzbF(zzfeo.zzd(6, null, null));
    }

    public final void zzi(zzbdg zzbdgVar) {
        this.zzf = zzbdgVar;
    }
}
