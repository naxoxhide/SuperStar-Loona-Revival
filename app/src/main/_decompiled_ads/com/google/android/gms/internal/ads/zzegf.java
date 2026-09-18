package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzegf implements zzefa {
    private final Context zza;
    private final zzcrs zzb;
    private View zzc;
    private zzbpg zzd;

    public zzegf(Context context, zzcrs zzcrsVar) {
        this.zza = context;
        this.zzb = zzcrsVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzefa
    public final /* bridge */ /* synthetic */ Object zza(zzfde zzfdeVar, final zzfcr zzfcrVar, final zzeex zzeexVar) throws zzfds, zzeir {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhD)).booleanValue() && zzfcrVar.zzai) {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zZzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfds(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        view = (View) zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzegc
                            @Override // com.google.android.gms.internal.ads.zzfza
                            public final ListenableFuture zza(Object obj) {
                                return this.zza.zzc(view, zzfcrVar, obj);
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
            view = this.zzc;
        }
        zzcqw zzcqwVarZza = this.zzb.zza(new zzctm(zzfdeVar, zzfcrVar, zzeexVar.zza), new zzcrc(view, null, new zzcsv() { // from class: com.google.android.gms.internal.ads.zzegb
            @Override // com.google.android.gms.internal.ads.zzcsv
            public final com.google.android.gms.ads.internal.client.zzdq zza() throws zzfds {
                try {
                    return ((zzbqv) zzeexVar.zzb).zze();
                } catch (RemoteException e3) {
                    throw new zzfds(e3);
                }
            }
        }, (zzfcs) zzfcrVar.zzw.get(0)));
        zzcqwVarZza.zzg().zza(view);
        ((zzegq) zzeexVar.zzc).zzc(zzcqwVarZza.zzi());
        return zzcqwVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final void zzb(zzfde zzfdeVar, zzfcr zzfcrVar, zzeex zzeexVar) throws zzfds {
        try {
            ((zzbqv) zzeexVar.zzb).zzq(zzfcrVar.zzab);
            zzegd zzegdVar = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhD)).booleanValue() && zzfcrVar.zzai) {
                ((zzbqv) zzeexVar.zzb).zzk(zzfcrVar.zzW, zzfcrVar.zzx.toString(), zzfdeVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzege(this, zzeexVar, zzegdVar), (zzbpd) zzeexVar.zzc, zzfdeVar.zza.zza.zze);
            } else {
                ((zzbqv) zzeexVar.zzb).zzj(zzfcrVar.zzW, zzfcrVar.zzx.toString(), zzfdeVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzege(this, zzeexVar, zzegdVar), (zzbpd) zzeexVar.zzc, zzfdeVar.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzfds(e);
        }
    }

    final /* synthetic */ ListenableFuture zzc(View view, zzfcr zzfcrVar, Object obj) throws Exception {
        return zzfzt.zzh(zzcsj.zza(this.zza, view, zzfcrVar));
    }
}
