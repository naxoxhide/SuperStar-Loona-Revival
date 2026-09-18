package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzehq implements zzefa {
    private final Context zza;
    private final zzdht zzb;
    private final Executor zzc;

    public zzehq(Context context, zzdht zzdhtVar, Executor executor) {
        this.zza = context;
        this.zzb = zzdhtVar;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfde zzfdeVar, int i) {
        return zzfdeVar.zza.zza.zzg.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final /* bridge */ /* synthetic */ Object zza(zzfde zzfdeVar, zzfcr zzfcrVar, zzeex zzeexVar) throws zzfds, zzeir {
        zzdjj zzdjjVarZzah;
        zzbpi zzbpiVarZzD = ((zzfej) zzeexVar.zzb).zzD();
        zzbpj zzbpjVarZzE = ((zzfej) zzeexVar.zzb).zzE();
        zzbpm zzbpmVarZzd = ((zzfej) zzeexVar.zzb).zzd();
        if (zzbpmVarZzd != null && zzc(zzfdeVar, 6)) {
            zzdjjVarZzah = zzdjj.zzt(zzbpmVarZzd);
        } else if (zzbpiVarZzD != null && zzc(zzfdeVar, 6)) {
            zzdjjVarZzah = zzdjj.zzai(zzbpiVarZzD);
        } else if (zzbpiVarZzD != null && zzc(zzfdeVar, 2)) {
            zzdjjVarZzah = zzdjj.zzag(zzbpiVarZzD);
        } else if (zzbpjVarZzE != null && zzc(zzfdeVar, 6)) {
            zzdjjVarZzah = zzdjj.zzaj(zzbpjVarZzE);
        } else {
            if (zzbpjVarZzE == null || !zzc(zzfdeVar, 1)) {
                throw new zzeir(1, "No native ad mappers");
            }
            zzdjjVarZzah = zzdjj.zzah(zzbpjVarZzE);
        }
        zzfdn zzfdnVar = zzfdeVar.zza.zza;
        if (!zzfdnVar.zzg.contains(Integer.toString(zzdjjVarZzah.zzc()))) {
            throw new zzeir(1, "No corresponding native ad listener");
        }
        zzdjl zzdjlVarZze = this.zzb.zze(new zzctm(zzfdeVar, zzfcrVar, zzeexVar.zza), new zzdjv(zzdjjVarZzah), new zzdlm(zzbpjVarZzE, zzbpiVarZzD, zzbpmVarZzd));
        ((zzegq) zzeexVar.zzc).zzc(zzdjlVarZze.zzj());
        zzdjlVarZze.zzd().zzo(new zzcol((zzfej) zzeexVar.zzb), this.zzc);
        return zzdjlVarZze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzefa
    public final void zzb(zzfde zzfdeVar, zzfcr zzfcrVar, zzeex zzeexVar) throws zzfds {
        zzfej zzfejVar = (zzfej) zzeexVar.zzb;
        zzfdn zzfdnVar = zzfdeVar.zza.zza;
        String string = zzfcrVar.zzx.toString();
        String strZzl = com.google.android.gms.ads.internal.util.zzbw.zzl(zzfcrVar.zzu);
        zzbpd zzbpdVar = (zzbpd) zzeexVar.zzc;
        zzfdn zzfdnVar2 = zzfdeVar.zza.zza;
        zzfejVar.zzp(this.zza, zzfdnVar.zzd, string, strZzl, zzbpdVar, zzfdnVar2.zzi, zzfdnVar2.zzg);
    }
}
