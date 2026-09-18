package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzefz implements zzefa {
    private final Context zza;
    private final zzcrs zzb;
    private final Executor zzc;

    public zzefz(Context context, zzcrs zzcrsVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcrsVar;
        this.zzc = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzefa
    public final /* bridge */ /* synthetic */ Object zza(zzfde zzfdeVar, final zzfcr zzfcrVar, zzeex zzeexVar) throws zzfds, zzeir {
        final View viewZza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhD)).booleanValue() && zzfcrVar.zzai) {
            zzbpg zzbpgVarZzc = ((zzfej) zzeexVar.zzb).zzc();
            if (zzbpgVarZzc == null) {
                zzcat.zzg("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                throw new zzfds(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
            }
            try {
                viewZza = (View) ObjectWrapper.unwrap(zzbpgVarZzc.zze());
                boolean zZzf = zzbpgVarZzc.zzf();
                if (viewZza == null) {
                    throw new zzfds(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        viewZza = (View) zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzefx
                            @Override // com.google.android.gms.internal.ads.zzfza
                            public final ListenableFuture zza(Object obj) {
                                return this.zza.zzc(viewZza, zzfcrVar, obj);
                            }
                        }, zzcbg.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfds(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfds(e2);
            }
        } else {
            viewZza = ((zzfej) zzeexVar.zzb).zza();
        }
        zzcrs zzcrsVar = this.zzb;
        zzctm zzctmVar = new zzctm(zzfdeVar, zzfcrVar, zzeexVar.zza);
        final zzfej zzfejVar = (zzfej) zzeexVar.zzb;
        zzcqw zzcqwVarZza = zzcrsVar.zza(zzctmVar, new zzcrc(viewZza, null, new zzcsv() { // from class: com.google.android.gms.internal.ads.zzefy
            @Override // com.google.android.gms.internal.ads.zzcsv
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return zzfejVar.zzb();
            }
        }, (zzfcs) zzfcrVar.zzw.get(0)));
        zzcqwVarZza.zzg().zza(viewZza);
        zzcqwVarZza.zzd().zzo(new zzcol((zzfej) zzeexVar.zzb), this.zzc);
        ((zzegq) zzeexVar.zzc).zzc(zzcqwVarZza.zzj());
        return zzcqwVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final void zzb(zzfde zzfdeVar, zzfcr zzfcrVar, zzeex zzeexVar) throws zzfds {
        com.google.android.gms.ads.internal.client.zzq zzqVar;
        com.google.android.gms.ads.internal.client.zzq zzqVar2 = zzfdeVar.zza.zza.zze;
        if (zzqVar2.zzn) {
            zzqVar = new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zzd(zzqVar2.zze, zzqVar2.zzb));
        } else {
            zzqVar = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhD)).booleanValue() && zzfcrVar.zzai) ? new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zze(zzqVar2.zze, zzqVar2.zzb)) : zzfdr.zza(this.zza, zzfcrVar.zzw);
        }
        com.google.android.gms.ads.internal.client.zzq zzqVar3 = zzqVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhD)).booleanValue() && zzfcrVar.zzai) {
            Object obj = zzeexVar.zzb;
            ((zzfej) obj).zzn(this.zza, zzqVar3, zzfdeVar.zza.zza.zzd, zzfcrVar.zzx.toString(), com.google.android.gms.ads.internal.util.zzbw.zzl(zzfcrVar.zzu), (zzbpd) zzeexVar.zzc);
            return;
        }
        Object obj2 = zzeexVar.zzb;
        ((zzfej) obj2).zzm(this.zza, zzqVar3, zzfdeVar.zza.zza.zzd, zzfcrVar.zzx.toString(), com.google.android.gms.ads.internal.util.zzbw.zzl(zzfcrVar.zzu), (zzbpd) zzeexVar.zzc);
    }

    final /* synthetic */ ListenableFuture zzc(View view, zzfcr zzfcrVar, Object obj) throws Exception {
        return zzfzt.zzh(zzcsj.zza(this.zza, view, zzfcrVar));
    }
}
