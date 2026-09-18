package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzefj implements zzefa {
    private final Context zza;
    private final zzcqj zzb;
    private final Executor zzc;

    zzefj(Context context, zzcqj zzcqjVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcqjVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final /* bridge */ /* synthetic */ Object zza(zzfde zzfdeVar, zzfcr zzfcrVar, final zzeex zzeexVar) throws zzfds, zzeir {
        zzcqg zzcqgVarZza = this.zzb.zza(new zzctm(zzfdeVar, zzfcrVar, zzeexVar.zza), new zzdga(new zzdhf() { // from class: com.google.android.gms.internal.ads.zzefi
            @Override // com.google.android.gms.internal.ads.zzdhf
            public final void zza(boolean z, Context context, zzcxy zzcxyVar) throws zzdhe {
                zzeex zzeexVar2 = zzeexVar;
                try {
                    ((zzfej) zzeexVar2.zzb).zzv(z);
                    ((zzfej) zzeexVar2.zzb).zzw(context);
                } catch (zzfds e) {
                    throw new zzdhe(e.getCause());
                }
            }
        }, null), new zzcqh(zzfcrVar.zzac));
        zzcqgVarZza.zzd().zzo(new zzcol((zzfej) zzeexVar.zzb), this.zzc);
        ((zzegq) zzeexVar.zzc).zzc(zzcqgVarZza.zzj());
        return zzcqgVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final void zzb(zzfde zzfdeVar, zzfcr zzfcrVar, zzeex zzeexVar) throws zzfds {
        zzfej zzfejVar = (zzfej) zzeexVar.zzb;
        zzfdn zzfdnVar = zzfdeVar.zza.zza;
        zzfejVar.zzl(this.zza, zzfdnVar.zzd, zzfcrVar.zzx.toString(), (zzbpd) zzeexVar.zzc);
    }
}
