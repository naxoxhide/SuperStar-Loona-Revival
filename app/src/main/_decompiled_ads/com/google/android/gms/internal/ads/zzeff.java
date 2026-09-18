package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeff implements zzeeu {
    private final zzcqj zza;
    private final Context zzb;
    private final zzdpt zzc;
    private final zzfdn zzd;
    private final Executor zze;
    private final zzcaz zzf;
    private final zzbjl zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziE)).booleanValue();
    private final zzedz zzi;

    public zzeff(zzcqj zzcqjVar, Context context, Executor executor, zzdpt zzdptVar, zzfdn zzfdnVar, zzcaz zzcazVar, zzbjl zzbjlVar, zzedz zzedzVar) {
        this.zzb = context;
        this.zza = zzcqjVar;
        this.zze = executor;
        this.zzc = zzdptVar;
        this.zzd = zzfdnVar;
        this.zzf = zzcazVar;
        this.zzg = zzbjlVar;
        this.zzi = zzedzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(final zzfde zzfdeVar, final zzfcr zzfcrVar) {
        final zzdpx zzdpxVar = new zzdpx();
        ListenableFuture listenableFutureZzn = zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzefb
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfcrVar, zzfdeVar, zzdpxVar, obj);
            }
        }, this.zze);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefc
            @Override // java.lang.Runnable
            public final void run() {
                zzdpxVar.zzb();
            }
        }, this.zze);
        return listenableFutureZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final boolean zzb(zzfde zzfdeVar, zzfcr zzfcrVar) {
        zzfcx zzfcxVar = zzfcrVar.zzu;
        return (zzfcxVar == null || zzfcxVar.zza == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ ListenableFuture zzc(final zzfcr zzfcrVar, zzfde zzfdeVar, zzdpx zzdpxVar, Object obj) throws Exception {
        final zzcgb zzcgbVarZza = this.zzc.zza(this.zzd.zze, zzfcrVar, zzfdeVar.zzb.zzb);
        zzcgbVarZza.zzZ(zzfcrVar.zzY);
        zzdpxVar.zza(this.zzb, (View) zzcgbVarZza);
        zzcbl zzcblVar = new zzcbl();
        final zzcqg zzcqgVarZza = this.zza.zza(new zzctm(zzfdeVar, zzfcrVar, null), new zzdga(new zzefh(this.zzf, zzcblVar, zzfcrVar, zzcgbVarZza, this.zzd, this.zzh, this.zzg, this.zzi), zzcgbVarZza), new zzcqh(zzfcrVar.zzac));
        zzcqgVarZza.zzh().zzi(zzcgbVarZza, false, this.zzh ? this.zzg : null);
        zzcblVar.zzc(zzcqgVarZza);
        zzcqgVarZza.zzc().zzo(new zzcyf() { // from class: com.google.android.gms.internal.ads.zzefd
            @Override // com.google.android.gms.internal.ads.zzcyf
            public final void zzq() {
                zzcgb zzcgbVar = zzcgbVarZza;
                if (zzcgbVar.zzN() != null) {
                    zzcgbVar.zzN().zzq();
                }
            }
        }, zzcbg.zzf);
        zzcqgVarZza.zzh();
        zzfcx zzfcxVar = zzfcrVar.zzu;
        return zzfzt.zzm(zzdps.zzj(zzcgbVarZza, zzfcxVar.zzb, zzfcxVar.zza), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzefe
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj2) {
                zzcgb zzcgbVar = zzcgbVarZza;
                if (zzfcrVar.zzO) {
                    zzcgbVar.zzae();
                }
                zzcqg zzcqgVar = zzcqgVarZza;
                zzcgbVar.zzY();
                zzcgbVar.onPause();
                return zzcqgVar.zza();
            }
        }, this.zze);
    }
}
