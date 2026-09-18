package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzexz implements zzena {
    protected final zzchw zza;
    private final Context zzb;
    private final Executor zzc;
    private final zzeyp zzd;
    private final zzfai zze;
    private final zzcaz zzf;
    private final ViewGroup zzg;
    private final zzfjh zzh;
    private final zzfdl zzi;

    @Nullable
    private ListenableFuture zzj;

    protected zzexz(Context context, Executor executor, zzchw zzchwVar, zzfai zzfaiVar, zzeyp zzeypVar, zzfdl zzfdlVar, zzcaz zzcazVar) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzchwVar;
        this.zze = zzfaiVar;
        this.zzd = zzeypVar;
        this.zzi = zzfdlVar;
        this.zzf = zzcazVar;
        this.zzg = new FrameLayout(context);
        this.zzh = zzchwVar.zzz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized zzcwr zzm(zzfag zzfagVar) {
        zzexy zzexyVar = (zzexy) zzfagVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhV)).booleanValue()) {
            zzcqs zzcqsVar = new zzcqs(this.zzg);
            zzcwt zzcwtVar = new zzcwt();
            zzcwtVar.zze(this.zzb);
            zzcwtVar.zzi(zzexyVar.zza);
            zzcwv zzcwvVarZzj = zzcwtVar.zzj();
            zzdda zzddaVar = new zzdda();
            zzddaVar.zzc(this.zzd, this.zzc);
            zzddaVar.zzl(this.zzd, this.zzc);
            return zze(zzcqsVar, zzcwvVarZzj, zzddaVar.zzn());
        }
        zzeyp zzeypVarZzi = zzeyp.zzi(this.zzd);
        zzdda zzddaVar2 = new zzdda();
        zzddaVar2.zzb(zzeypVarZzi, this.zzc);
        zzddaVar2.zzg(zzeypVarZzi, this.zzc);
        zzddaVar2.zzh(zzeypVarZzi, this.zzc);
        zzddaVar2.zzi(zzeypVarZzi, this.zzc);
        zzddaVar2.zzc(zzeypVarZzi, this.zzc);
        zzddaVar2.zzl(zzeypVarZzi, this.zzc);
        zzddaVar2.zzm(zzeypVarZzi);
        zzcqs zzcqsVar2 = new zzcqs(this.zzg);
        zzcwt zzcwtVar2 = new zzcwt();
        zzcwtVar2.zze(this.zzb);
        zzcwtVar2.zzi(zzexyVar.zza);
        return zze(zzcqsVar2, zzcwtVar2.zzj(), zzddaVar2.zzn());
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzj;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0088  */
    /* JADX WARN: Code duplicated, block: B:8:0x0025  */
    @Override // com.google.android.gms.internal.ads.zzena
    public final synchronized boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzemy zzemyVar, zzemz zzemzVar) throws RemoteException {
        boolean z;
        zzfje zzfjeVar;
        if (((Boolean) zzbdz.zzd.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkm)).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (this.zzf.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkn)).intValue() || !z) {
            Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        }
        if (str == null) {
            zzcat.zzg("Ad unit ID should not be null for app open ad.");
            this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzext
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk();
                }
            });
            return false;
        }
        if (this.zzj != null) {
            return false;
        }
        if (((Boolean) zzbdu.zzc.zze()).booleanValue()) {
            zzfai zzfaiVar = this.zze;
            if (zzfaiVar.zzd() != null) {
                zzfje zzfjeVarZzh = ((zzcqf) zzfaiVar.zzd()).zzh();
                zzfjeVarZzh.zzh(7);
                zzfjeVarZzh.zzb(zzlVar.zzp);
                zzfjeVar = zzfjeVarZzh;
            } else {
                zzfjeVar = null;
            }
        } else {
            zzfjeVar = null;
        }
        zzfei.zza(this.zzb, zzlVar.zzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziF)).booleanValue() && zzlVar.zzf) {
            this.zza.zzk().zzn(true);
        }
        zzfdl zzfdlVar = this.zzi;
        zzfdlVar.zzs(str);
        zzfdlVar.zzr(com.google.android.gms.ads.internal.client.zzq.zzb());
        zzfdlVar.zzE(zzlVar);
        Context context = this.zzb;
        zzfdn zzfdnVarZzG = zzfdlVar.zzG();
        zzfit zzfitVarZzb = zzfis.zzb(context, zzfjd.zzf(zzfdnVarZzG), 7, zzlVar);
        zzexy zzexyVar = new zzexy(null);
        zzexyVar.zza = zzfdnVarZzG;
        ListenableFuture listenableFutureZzc = this.zze.zzc(new zzfaj(zzexyVar, null), new zzfah() { // from class: com.google.android.gms.internal.ads.zzexu
            @Override // com.google.android.gms.internal.ads.zzfah
            public final zzcwr zza(zzfag zzfagVar) {
                return this.zza.zzm(zzfagVar);
            }
        }, null);
        this.zzj = listenableFutureZzc;
        zzfzt.zzr(listenableFutureZzc, new zzexw(this, zzemzVar, zzfjeVar, zzfitVarZzb, zzexyVar), this.zzc);
        return true;
    }

    protected abstract zzcwr zze(zzcqs zzcqsVar, zzcwv zzcwvVar, zzddc zzddcVar);

    final /* synthetic */ void zzk() {
        this.zzd.zzbF(zzfeo.zzd(6, null, null));
    }

    public final void zzl(com.google.android.gms.ads.internal.client.zzw zzwVar) {
        this.zzi.zzt(zzwVar);
    }
}
