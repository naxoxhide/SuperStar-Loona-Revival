package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzejw implements zzefa {
    private final Context zza;
    private final Executor zzb;
    private final zzdpc zzc;

    public zzejw(Context context, Executor executor, zzdpc zzdpcVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdpcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zze(zzfde zzfdeVar, zzfcr zzfcrVar, zzeex zzeexVar) {
        try {
            ((zzfej) zzeexVar.zzb).zzk(zzfdeVar.zza.zza.zzd, zzfcrVar.zzx.toString());
        } catch (Exception e) {
            zzcat.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzeexVar.zza)), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final /* bridge */ /* synthetic */ Object zza(zzfde zzfdeVar, zzfcr zzfcrVar, final zzeex zzeexVar) throws zzfds, zzeir {
        zzdoy zzdoyVarZze = this.zzc.zze(new zzctm(zzfdeVar, zzfcrVar, zzeexVar.zza), new zzdoz(new zzdhf() { // from class: com.google.android.gms.internal.ads.zzejs
            @Override // com.google.android.gms.internal.ads.zzdhf
            public final void zza(boolean z, Context context, zzcxy zzcxyVar) throws zzdhe {
                zzeex zzeexVar2 = zzeexVar;
                try {
                    ((zzfej) zzeexVar2.zzb).zzv(z);
                    ((zzfej) zzeexVar2.zzb).zzA();
                } catch (zzfds e) {
                    zzcat.zzk("Cannot show rewarded video.", e);
                    throw new zzdhe(e.getCause());
                }
            }
        }));
        zzdoyVarZze.zzd().zzo(new zzcol((zzfej) zzeexVar.zzb), this.zzb);
        zzcys zzcysVarZze = zzdoyVarZze.zze();
        zzcxj zzcxjVarZzb = zzdoyVarZze.zzb();
        ((zzegr) zzeexVar.zzc).zzc(new zzejv(this, zzdoyVarZze.zza(), zzcxjVarZzb, zzcysVarZze, zzdoyVarZze.zzg()));
        return zzdoyVarZze.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final void zzb(zzfde zzfdeVar, zzfcr zzfcrVar, zzeex zzeexVar) throws zzfds {
        if (((zzfej) zzeexVar.zzb).zzC()) {
            zze(zzfdeVar, zzfcrVar, zzeexVar);
            return;
        }
        ((zzegr) zzeexVar.zzc).zzd(new zzeju(this, zzfdeVar, zzfcrVar, zzeexVar));
        Object obj = zzeexVar.zzb;
        Context context = this.zza;
        zzfdn zzfdnVar = zzfdeVar.zza.zza;
        ((zzfej) obj).zzh(context, zzfdnVar.zzd, null, (zzbwh) zzeexVar.zzc, zzfcrVar.zzx.toString());
    }
}
