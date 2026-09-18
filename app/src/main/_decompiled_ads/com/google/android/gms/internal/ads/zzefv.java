package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzefv implements zzeeu {
    private final zzcrs zza;
    private final Context zzb;
    private final zzdpt zzc;
    private final zzfdn zzd;
    private final Executor zze;
    private final zzfsk zzf;

    public zzefv(zzcrs zzcrsVar, Context context, Executor executor, zzdpt zzdptVar, zzfdn zzfdnVar, zzfsk zzfskVar) {
        this.zzb = context;
        this.zza = zzcrsVar;
        this.zze = executor;
        this.zzc = zzdptVar;
        this.zzd = zzfdnVar;
        this.zzf = zzfskVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(final zzfde zzfdeVar, final zzfcr zzfcrVar) {
        return zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzefu
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfdeVar, zzfcrVar, obj);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final boolean zzb(zzfde zzfdeVar, zzfcr zzfcrVar) {
        zzfcx zzfcxVar = zzfcrVar.zzu;
        return (zzfcxVar == null || zzfcxVar.zza == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ ListenableFuture zzc(zzfde zzfdeVar, zzfcr zzfcrVar, Object obj) throws Exception {
        View zzdpwVar;
        com.google.android.gms.ads.internal.client.zzq zzqVarZza = zzfdr.zza(this.zzb, zzfcrVar.zzw);
        final zzcgb zzcgbVarZza = this.zzc.zza(zzqVarZza, zzfcrVar, zzfdeVar.zzb.zzb);
        zzcgbVarZza.zzZ(zzfcrVar.zzY);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhD)).booleanValue() && zzfcrVar.zzai) {
            zzdpwVar = zzcsj.zza(this.zzb, (View) zzcgbVarZza, zzfcrVar);
        } else {
            zzdpwVar = new zzdpw(this.zzb, (View) zzcgbVarZza, (com.google.android.gms.ads.internal.util.zzau) this.zzf.apply(zzfcrVar));
        }
        final zzcqw zzcqwVarZza = this.zza.zza(new zzctm(zzfdeVar, zzfcrVar, null), new zzcrc(zzdpwVar, zzcgbVarZza, new zzcsv() { // from class: com.google.android.gms.internal.ads.zzefp
            @Override // com.google.android.gms.internal.ads.zzcsv
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return zzcgbVarZza.zzq();
            }
        }, zzfdr.zzb(zzqVarZza)));
        zzcqwVarZza.zzh().zzi(zzcgbVarZza, false, null);
        zzcqwVarZza.zzc().zzo(new zzcyf() { // from class: com.google.android.gms.internal.ads.zzefq
            @Override // com.google.android.gms.internal.ads.zzcyf
            public final void zzq() {
                zzcgb zzcgbVar = zzcgbVarZza;
                if (zzcgbVar.zzN() != null) {
                    zzcgbVar.zzN().zzq();
                }
            }
        }, zzcbg.zzf);
        zzcqwVarZza.zzh();
        zzfcx zzfcxVar = zzfcrVar.zzu;
        ListenableFuture listenableFutureZzj = zzdps.zzj(zzcgbVarZza, zzfcxVar.zzb, zzfcxVar.zza);
        if (zzfcrVar.zzO) {
            listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefr
                @Override // java.lang.Runnable
                public final void run() {
                    zzcgbVarZza.zzae();
                }
            }, this.zze);
        }
        listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(zzcgbVarZza);
            }
        }, this.zze);
        return zzfzt.zzm(listenableFutureZzj, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzeft
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj2) {
                return zzcqwVarZza.zza();
            }
        }, zzcbg.zzf);
    }

    final /* synthetic */ void zzd(zzcgb zzcgbVar) {
        zzcgbVar.zzY();
        zzcgx zzcgxVarZzq = zzcgbVar.zzq();
        com.google.android.gms.ads.internal.client.zzfl zzflVar = this.zzd.zza;
        if (zzflVar == null || zzcgxVarZzq == null) {
            return;
        }
        zzcgxVarZzq.zzs(zzflVar);
    }
}
