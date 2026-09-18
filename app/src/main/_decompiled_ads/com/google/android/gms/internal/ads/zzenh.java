package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenh implements zzena {
    private final zzfdl zza;
    private final zzchw zzb;
    private final Context zzc;
    private final zzemx zzd;
    private final zzfjh zze;
    private zzctl zzf;

    public zzenh(zzchw zzchwVar, Context context, zzemx zzemxVar, zzfdl zzfdlVar) {
        this.zzb = zzchwVar;
        this.zzc = context;
        this.zzd = zzemxVar;
        this.zza = zzfdlVar;
        this.zze = zzchwVar.zzz();
        zzfdlVar.zzu(zzemxVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        zzctl zzctlVar = this.zzf;
        return zzctlVar != null && zzctlVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzemy zzemyVar, zzemz zzemzVar) throws RemoteException {
        zzfje zzfjeVar;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzG(this.zzc) && zzlVar.zzs == null) {
            zzcat.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzenc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf();
                }
            });
            return false;
        }
        if (str == null) {
            zzcat.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzend
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzg();
                }
            });
            return false;
        }
        zzfei.zza(this.zzc, zzlVar.zzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziF)).booleanValue() && zzlVar.zzf) {
            this.zzb.zzk().zzn(true);
        }
        int i = ((zzenb) zzemyVar).zza;
        zzfdl zzfdlVar = this.zza;
        zzfdlVar.zzE(zzlVar);
        zzfdlVar.zzz(i);
        Context context = this.zzc;
        zzfdn zzfdnVarZzG = zzfdlVar.zzG();
        zzfit zzfitVarZzb = zzfis.zzb(context, zzfjd.zzf(zzfdnVarZzG), 8, zzlVar);
        com.google.android.gms.ads.internal.client.zzcb zzcbVar = zzfdnVarZzG.zzn;
        if (zzcbVar != null) {
            this.zzd.zzd().zzm(zzcbVar);
        }
        zzdhs zzdhsVarZzh = this.zzb.zzh();
        zzcwt zzcwtVar = new zzcwt();
        zzcwtVar.zze(this.zzc);
        zzcwtVar.zzi(zzfdnVarZzG);
        zzdhsVarZzh.zzf(zzcwtVar.zzj());
        zzdda zzddaVar = new zzdda();
        zzddaVar.zzk(this.zzd.zzd(), this.zzb.zzB());
        zzdhsVarZzh.zze(zzddaVar.zzn());
        zzdhsVarZzh.zzd(this.zzd.zzc());
        zzdhsVarZzh.zzc(new zzcqs(null));
        zzdht zzdhtVarZzg = zzdhsVarZzh.zzg();
        if (((Boolean) zzbdu.zzc.zze()).booleanValue()) {
            zzfje zzfjeVarZzf = zzdhtVarZzg.zzf();
            zzfjeVarZzf.zzh(8);
            zzfjeVarZzf.zzb(zzlVar.zzp);
            zzfjeVar = zzfjeVarZzf;
        } else {
            zzfjeVar = null;
        }
        this.zzb.zzx().zzc(1);
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        ScheduledExecutorService scheduledExecutorServiceZzC = this.zzb.zzC();
        zzcue zzcueVarZza = zzdhtVarZzg.zza();
        zzctl zzctlVar = new zzctl(zzgadVar, scheduledExecutorServiceZzC, zzcueVarZza.zzi(zzcueVarZza.zzj()));
        this.zzf = zzctlVar;
        zzctlVar.zze(new zzeng(this, zzemzVar, zzfjeVar, zzfitVarZzb, zzdhtVarZzg));
        return true;
    }

    final /* synthetic */ void zzf() {
        this.zzd.zza().zzbF(zzfeo.zzd(4, null, null));
    }

    final /* synthetic */ void zzg() {
        this.zzd.zza().zzbF(zzfeo.zzd(6, null, null));
    }
}
