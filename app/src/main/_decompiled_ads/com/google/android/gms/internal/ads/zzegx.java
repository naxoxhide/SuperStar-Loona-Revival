package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzegx implements zzeeu {
    private final Context zza;
    private final zzdpt zzb;
    private final zzdgx zzc;
    private final zzfdn zzd;
    private final Executor zze;
    private final zzcaz zzf;
    private final zzbjl zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziE)).booleanValue();
    private final zzedz zzi;

    public zzegx(Context context, zzcaz zzcazVar, zzfdn zzfdnVar, Executor executor, zzdgx zzdgxVar, zzdpt zzdptVar, zzbjl zzbjlVar, zzedz zzedzVar) {
        this.zza = context;
        this.zzd = zzfdnVar;
        this.zzc = zzdgxVar;
        this.zze = executor;
        this.zzf = zzcazVar;
        this.zzb = zzdptVar;
        this.zzg = zzbjlVar;
        this.zzi = zzedzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(final zzfde zzfdeVar, final zzfcr zzfcrVar) {
        final zzdpx zzdpxVar = new zzdpx();
        ListenableFuture listenableFutureZzn = zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzegu
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfcrVar, zzfdeVar, zzdpxVar, obj);
            }
        }, this.zze);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegv
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
        final zzcgb zzcgbVarZza = this.zzb.zza(this.zzd.zze, zzfcrVar, zzfdeVar.zzb.zzb);
        zzcgbVarZza.zzZ(zzfcrVar.zzY);
        zzdpxVar.zza(this.zza, (View) zzcgbVarZza);
        zzcbl zzcblVar = new zzcbl();
        final zzdfx zzdfxVarZze = this.zzc.zze(new zzctm(zzfdeVar, zzfcrVar, null), new zzdga(new zzegw(this.zza, this.zzf, zzcblVar, zzfcrVar, zzcgbVarZza, this.zzd, this.zzh, this.zzg, this.zzi), zzcgbVarZza));
        zzcblVar.zzc(zzdfxVarZze);
        zzdfxVarZze.zzc().zzo(new zzcyf() { // from class: com.google.android.gms.internal.ads.zzegs
            @Override // com.google.android.gms.internal.ads.zzcyf
            public final void zzq() {
                zzcgb zzcgbVar = zzcgbVarZza;
                if (zzcgbVar.zzN() != null) {
                    zzcgbVar.zzN().zzq();
                }
            }
        }, zzcbg.zzf);
        zzdfxVarZze.zzk().zzi(zzcgbVarZza, true, this.zzh ? this.zzg : null);
        zzdfxVarZze.zzk();
        zzfcx zzfcxVar = zzfcrVar.zzu;
        return zzfzt.zzm(zzdps.zzj(zzcgbVarZza, zzfcxVar.zzb, zzfcxVar.zza), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzegt
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj2) {
                zzcgb zzcgbVar = zzcgbVarZza;
                if (zzfcrVar.zzO) {
                    zzcgbVar.zzae();
                }
                zzdfx zzdfxVar = zzdfxVarZze;
                zzcgbVar.zzY();
                zzcgbVar.onPause();
                return zzdfxVar.zzg();
            }
        }, this.zze);
    }
}
