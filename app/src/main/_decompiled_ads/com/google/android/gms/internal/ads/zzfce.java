package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfce implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzchw zzc;
    private final zzfbu zzd;
    private final zzfai zze;
    private final zzfdf zzf;
    private final zzfjh zzg;
    private final zzfdl zzh;
    private ListenableFuture zzi;

    public zzfce(Context context, Executor executor, zzchw zzchwVar, zzfai zzfaiVar, zzfbu zzfbuVar, zzfdl zzfdlVar, zzfdf zzfdfVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzchwVar;
        this.zze = zzfaiVar;
        this.zzd = zzfbuVar;
        this.zzh = zzfdlVar;
        this.zzf = zzfdfVar;
        this.zzg = zzchwVar.zzz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzdpb zzk(zzfag zzfagVar) {
        zzdpb zzdpbVarZzi = this.zzc.zzi();
        zzcwt zzcwtVar = new zzcwt();
        zzcwtVar.zze(this.zza);
        zzcwtVar.zzi(((zzfcd) zzfagVar).zza);
        zzcwtVar.zzh(this.zzf);
        zzdpbVarZzi.zzd(zzcwtVar.zzj());
        zzdpbVarZzi.zzc(new zzdda().zzn());
        return zzdpbVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0056  */
    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzemy zzemyVar, zzemz zzemzVar) throws RemoteException {
        zzfje zzfjeVar;
        zzbwd zzbwdVar = new zzbwd(zzlVar, str);
        if (zzbwdVar.zzb == null) {
            zzcat.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbx
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi();
                }
            });
        } else {
            ListenableFuture listenableFuture = this.zzi;
            if (listenableFuture == null || listenableFuture.isDone()) {
                if (((Boolean) zzbdu.zzc.zze()).booleanValue()) {
                    zzfai zzfaiVar = this.zze;
                    if (zzfaiVar.zzd() != null) {
                        zzfje zzfjeVarZzh = ((zzdpc) zzfaiVar.zzd()).zzh();
                        zzfjeVarZzh.zzh(5);
                        zzfjeVarZzh.zzb(zzbwdVar.zza.zzp);
                        zzfjeVar = zzfjeVarZzh;
                    } else {
                        zzfjeVar = null;
                    }
                } else {
                    zzfjeVar = null;
                }
                zzfei.zza(this.zza, zzbwdVar.zza.zzf);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziF)).booleanValue() && zzbwdVar.zza.zzf) {
                    this.zzc.zzk().zzn(true);
                }
                zzfdl zzfdlVar = this.zzh;
                zzfdlVar.zzs(zzbwdVar.zzb);
                zzfdlVar.zzr(com.google.android.gms.ads.internal.client.zzq.zzd());
                zzfdlVar.zzE(zzbwdVar.zza);
                Context context = this.zza;
                zzfdn zzfdnVarZzG = zzfdlVar.zzG();
                zzfit zzfitVarZzb = zzfis.zzb(context, zzfjd.zzf(zzfdnVarZzG), 5, zzbwdVar.zza);
                zzfcd zzfcdVar = new zzfcd(null);
                zzfcdVar.zza = zzfdnVarZzG;
                ListenableFuture listenableFutureZzc = this.zze.zzc(new zzfaj(zzfcdVar, null), new zzfah() { // from class: com.google.android.gms.internal.ads.zzfby
                    @Override // com.google.android.gms.internal.ads.zzfah
                    public final zzcwr zza(zzfag zzfagVar) {
                        return this.zza.zzk(zzfagVar);
                    }
                }, null);
                this.zzi = listenableFutureZzc;
                zzfzt.zzr(listenableFutureZzc, new zzfcb(this, zzemzVar, zzfjeVar, zzfitVarZzb, zzfcdVar), this.zzb);
                return true;
            }
        }
        return false;
    }

    final /* synthetic */ void zzi() {
        this.zzd.zzbF(zzfeo.zzd(6, null, null));
    }

    final void zzj(int i) {
        this.zzh.zzo().zza(i);
    }
}
