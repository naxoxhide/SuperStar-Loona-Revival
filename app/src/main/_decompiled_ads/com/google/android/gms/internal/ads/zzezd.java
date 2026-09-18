package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzezd implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzchw zzc;
    private final zzemk zzd;
    private final zzemo zze;
    private final ViewGroup zzf;
    private zzbdg zzg;
    private final zzdaa zzh;
    private final zzfjh zzi;
    private final zzdch zzj;
    private final zzfdl zzk;
    private ListenableFuture zzl;

    public zzezd(Context context, Executor executor, com.google.android.gms.ads.internal.client.zzq zzqVar, zzchw zzchwVar, zzemk zzemkVar, zzemo zzemoVar, zzfdl zzfdlVar, zzdch zzdchVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzchwVar;
        this.zzd = zzemkVar;
        this.zze = zzemoVar;
        this.zzk = zzfdlVar;
        this.zzh = zzchwVar.zzf();
        this.zzi = zzchwVar.zzz();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdchVar;
        zzfdlVar.zzr(zzqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzl;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzemy zzemyVar, zzemz zzemzVar) throws RemoteException {
        zzcrs zzcrsVarZzk;
        zzfje zzfjeVar;
        if (str == null) {
            zzcat.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm();
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
        zzfdl zzfdlVar = this.zzk;
        zzfdlVar.zzs(str);
        zzfdlVar.zzE(zzlVar);
        Context context = this.zza;
        zzfdn zzfdnVarZzG = zzfdlVar.zzG();
        zzfit zzfitVarZzb = zzfis.zzb(context, zzfjd.zzf(zzfdnVarZzG), 3, zzlVar);
        if (((Boolean) zzbeh.zze.zze()).booleanValue() && this.zzk.zzg().zzk) {
            zzemk zzemkVar = this.zzd;
            if (zzemkVar != null) {
                zzemkVar.zzbF(zzfeo.zzd(7, null, null));
            }
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhU)).booleanValue()) {
            zzcrr zzcrrVarZze = this.zzc.zze();
            zzcwt zzcwtVar = new zzcwt();
            zzcwtVar.zze(this.zza);
            zzcwtVar.zzi(zzfdnVarZzG);
            zzcrrVarZze.zzi(zzcwtVar.zzj());
            zzdda zzddaVar = new zzdda();
            zzddaVar.zzj(this.zzd, this.zzb);
            zzddaVar.zzk(this.zzd, this.zzb);
            zzcrrVarZze.zzf(zzddaVar.zzn());
            zzcrrVarZze.zze(new zzekt(this.zzg));
            zzcrrVarZze.zzd(new zzdho(zzdju.zza, null));
            zzcrrVarZze.zzg(new zzcsp(this.zzh, this.zzj));
            zzcrrVarZze.zzc(new zzcqs(this.zzf));
            zzcrsVarZzk = zzcrrVarZze.zzh();
        } else {
            zzcrr zzcrrVarZze2 = this.zzc.zze();
            zzcwt zzcwtVar2 = new zzcwt();
            zzcwtVar2.zze(this.zza);
            zzcwtVar2.zzi(zzfdnVarZzG);
            zzcrrVarZze2.zzi(zzcwtVar2.zzj());
            zzdda zzddaVar2 = new zzdda();
            zzddaVar2.zzj(this.zzd, this.zzb);
            zzddaVar2.zza(this.zzd, this.zzb);
            zzddaVar2.zza(this.zze, this.zzb);
            zzddaVar2.zzl(this.zzd, this.zzb);
            zzddaVar2.zzd(this.zzd, this.zzb);
            zzddaVar2.zze(this.zzd, this.zzb);
            zzddaVar2.zzf(this.zzd, this.zzb);
            zzddaVar2.zzb(this.zzd, this.zzb);
            zzddaVar2.zzk(this.zzd, this.zzb);
            zzddaVar2.zzi(this.zzd, this.zzb);
            zzcrrVarZze2.zzf(zzddaVar2.zzn());
            zzcrrVarZze2.zze(new zzekt(this.zzg));
            zzcrrVarZze2.zzd(new zzdho(zzdju.zza, null));
            zzcrrVarZze2.zzg(new zzcsp(this.zzh, this.zzj));
            zzcrrVarZze2.zzc(new zzcqs(this.zzf));
            zzcrsVarZzk = zzcrrVarZze2.zzh();
        }
        zzcrs zzcrsVar = zzcrsVarZzk;
        if (((Boolean) zzbdu.zzc.zze()).booleanValue()) {
            zzfje zzfjeVarZzj = zzcrsVar.zzj();
            zzfjeVarZzj.zzh(3);
            zzfjeVarZzj.zzb(zzlVar.zzp);
            zzfjeVar = zzfjeVarZzj;
        } else {
            zzfjeVar = null;
        }
        zzcue zzcueVarZzd = zzcrsVar.zzd();
        ListenableFuture listenableFutureZzi = zzcueVarZzd.zzi(zzcueVarZzd.zzj());
        this.zzl = listenableFutureZzi;
        zzfzt.zzr(listenableFutureZzi, new zzezc(this, zzemzVar, zzfjeVar, zzfitVarZzb, zzcrsVar), this.zzb);
        return true;
    }

    public final ViewGroup zzd() {
        return this.zzf;
    }

    public final zzfdl zzi() {
        return this.zzk;
    }

    final /* synthetic */ void zzm() {
        this.zzd.zzbF(zzfeo.zzd(6, null, null));
    }

    public final void zzn() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzo(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
        this.zze.zza(zzbeVar);
    }

    public final void zzp(zzdab zzdabVar) {
        this.zzh.zzo(zzdabVar, this.zzb);
    }

    public final void zzq(zzbdg zzbdgVar) {
        this.zzg = zzbdgVar;
    }

    public final boolean zzr() {
        Object parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        com.google.android.gms.ads.internal.zzt.zzp();
        return com.google.android.gms.ads.internal.util.zzt.zzV(view, view.getContext());
    }
}
