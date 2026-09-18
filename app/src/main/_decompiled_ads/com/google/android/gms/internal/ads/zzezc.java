package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzezc implements zzfzp {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzfit zzc;
    final /* synthetic */ zzcrs zzd;
    final /* synthetic */ zzezd zze;

    zzezc(zzezd zzezdVar, zzemz zzemzVar, zzfje zzfjeVar, zzfit zzfitVar, zzcrs zzcrsVar) {
        this.zze = zzezdVar;
        this.zza = zzemzVar;
        this.zzb = zzfjeVar;
        this.zzc = zzfitVar;
        this.zzd = zzcrsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        zzfje zzfjeVar;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zzd.zzd().zza(th);
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zzd.zzf().zzbF(zzeVarZza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhU)).booleanValue()) {
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeza
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzbF(zzeVarZza);
                    }
                });
            }
            zzezd zzezdVar = this.zze;
            zzezdVar.zzh.zzd(zzezdVar.zzj.zzc());
            zzfei.zzb(zzeVarZza.zza, th, "BannerAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbdu.zzc.zze()).booleanValue() || (zzfjeVar = this.zzb) == null) {
                zzfjh zzfjhVar = this.zze.zzi;
                zzfit zzfitVar = this.zzc;
                zzfitVar.zza(zzeVarZza);
                zzfitVar.zzg(th);
                zzfitVar.zzf(false);
                zzfjhVar.zzb(zzfitVar.zzl());
            } else {
                zzfjeVar.zzc(zzeVarZza);
                zzfit zzfitVar2 = this.zzc;
                zzfitVar2.zzg(th);
                zzfitVar2.zzf(false);
                zzfjeVar.zza(zzfitVar2);
                zzfjeVar.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfje zzfjeVar;
        zzcqv zzcqvVar = (zzcqv) obj;
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zze.zzf.removeAllViews();
            if (zzcqvVar.zzc() != null) {
                ViewParent parent = zzcqvVar.zzc().getParent();
                if (parent instanceof ViewGroup) {
                    zzcat.zzj("Banner view provided from " + (zzcqvVar.zzl() != null ? zzcqvVar.zzl().zzg() : "") + " already has a parent view. Removing its old parent.");
                    ((ViewGroup) parent).removeView(zzcqvVar.zzc());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhU)).booleanValue()) {
                zzdbq zzdbqVarZzn = zzcqvVar.zzn();
                zzdbqVarZzn.zza(this.zze.zzd);
                zzdbqVarZzn.zzc(this.zze.zze);
            }
            this.zze.zzf.addView(zzcqvVar.zzc());
            this.zza.zzb(zzcqvVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhU)).booleanValue()) {
                zzezd zzezdVar = this.zze;
                Executor executor = zzezdVar.zzb;
                final zzemk zzemkVar = zzezdVar.zzd;
                zzemkVar.getClass();
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzezb
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzemkVar.zzr();
                    }
                });
            }
            this.zze.zzh.zzd(zzcqvVar.zza());
            if (!((Boolean) zzbdu.zzc.zze()).booleanValue() || (zzfjeVar = this.zzb) == null) {
                zzfjh zzfjhVar = this.zze.zzi;
                zzfit zzfitVar = this.zzc;
                zzfitVar.zzb(zzcqvVar.zzp().zzb);
                zzfitVar.zzd(zzcqvVar.zzl().zzg());
                zzfitVar.zzf(true);
                zzfjhVar.zzb(zzfitVar.zzl());
            } else {
                zzfjeVar.zzf(zzcqvVar.zzp().zzb);
                zzfjeVar.zze(zzcqvVar.zzl().zzg());
                zzfit zzfitVar2 = this.zzc;
                zzfitVar2.zzf(true);
                zzfjeVar.zza(zzfitVar2);
                zzfjeVar.zzg();
            }
        }
    }
}
