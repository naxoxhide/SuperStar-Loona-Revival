package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzehu implements zzefa {
    private final Context zza;
    private final zzdht zzb;
    private zzbpm zzc;
    private final zzcaz zzd;

    public zzehu(Context context, zzdht zzdhtVar, zzcaz zzcazVar) {
        this.zza = context;
        this.zzb = zzdhtVar;
        this.zzd = zzcazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final /* bridge */ /* synthetic */ Object zza(zzfde zzfdeVar, zzfcr zzfcrVar, zzeex zzeexVar) throws zzfds, zzeir {
        if (!zzfdeVar.zza.zza.zzg.contains(Integer.toString(6))) {
            throw new zzeir(2, "Unified must be used for RTB.");
        }
        zzdjj zzdjjVarZzt = zzdjj.zzt(this.zzc);
        zzfdn zzfdnVar = zzfdeVar.zza.zza;
        if (!zzfdnVar.zzg.contains(Integer.toString(zzdjjVarZzt.zzc()))) {
            throw new zzeir(1, "No corresponding native ad listener");
        }
        zzdjl zzdjlVarZze = this.zzb.zze(new zzctm(zzfdeVar, zzfcrVar, zzeexVar.zza), new zzdjv(zzdjjVarZzt), new zzdlm(null, null, this.zzc));
        ((zzegq) zzeexVar.zzc).zzc(zzdjlVarZze.zzi());
        return zzdjlVarZze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final void zzb(zzfde zzfdeVar, zzfcr zzfcrVar, zzeex zzeexVar) throws zzfds {
        try {
            ((zzbqv) zzeexVar.zzb).zzq(zzfcrVar.zzab);
            zzehs zzehsVar = null;
            if (this.zzd.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbF)).intValue()) {
                ((zzbqv) zzeexVar.zzb).zzm(zzfcrVar.zzW, zzfcrVar.zzx.toString(), zzfdeVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeht(this, zzeexVar, zzehsVar), (zzbpd) zzeexVar.zzc);
            } else {
                ((zzbqv) zzeexVar.zzb).zzn(zzfcrVar.zzW, zzfcrVar.zzx.toString(), zzfdeVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeht(this, zzeexVar, zzehsVar), (zzbpd) zzeexVar.zzc, zzfdeVar.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzfds(e);
        }
    }
}
