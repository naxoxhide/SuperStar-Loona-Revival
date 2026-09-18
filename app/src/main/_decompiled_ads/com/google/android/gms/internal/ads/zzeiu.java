package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeiu implements zzfza {
    private final zzfhr zza;
    private final zzcxn zzb;
    private final zzfjt zzc;
    private final zzfjx zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcta zzg;
    private final zzeio zzh;
    private final zzeez zzi;
    private final Context zzj;
    private final zzfje zzk;
    private final zzehy zzl;

    zzeiu(Context context, zzfhr zzfhrVar, zzeio zzeioVar, zzcxn zzcxnVar, zzfjt zzfjtVar, zzfjx zzfjxVar, zzcta zzctaVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzeez zzeezVar, zzfje zzfjeVar, zzehy zzehyVar) {
        this.zzj = context;
        this.zza = zzfhrVar;
        this.zzh = zzeioVar;
        this.zzb = zzcxnVar;
        this.zzc = zzfjtVar;
        this.zzd = zzfjxVar;
        this.zzg = zzctaVar;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzeezVar;
        this.zzk = zzfjeVar;
        this.zzl = zzehyVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0057  */
    static String zzc(zzfde zzfdeVar) {
        String str = "No fill.";
        String str2 = true != ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfr)).booleanValue() ? "No ad config." : "No fill.";
        int i = zzfdeVar.zzb.zzb.zze;
        if (i == 0) {
            str = str2;
        } else if (i >= 200 && i < 300) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfq)).booleanValue()) {
                str = str2;
            }
        } else if (i < 300 || i >= 400) {
            str = "Received error HTTP response code: " + i;
        } else {
            str = "No location header to follow redirect or too many redirects.";
        }
        zzfct zzfctVar = zzfdeVar.zzb.zzb.zzi;
        return zzfctVar != null ? zzfctVar.zza() : str;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0066  */
    /* JADX WARN: Code duplicated, block: B:19:0x0074  */
    /* JADX WARN: Code duplicated, block: B:22:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a2 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzfza
    public final /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        Iterator it;
        zzeeu zzeeuVarZza;
        int i;
        final zzfde zzfdeVar = (zzfde) obj;
        String strZzc = zzc(zzfdeVar);
        this.zzi.zzi(zzfdeVar.zzb.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzic)).booleanValue() && (i = zzfdeVar.zzb.zzb.zze) != 0 && (i < 200 || i >= 300)) {
            return zzfzt.zzg(new zzeir(3, strZzc));
        }
        zzfcv zzfcvVar = zzfdeVar.zzb.zzb;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdp)).booleanValue()) {
            for (zzfcr zzfcrVar : zzfdeVar.zzb.zza) {
                this.zzi.zzd(zzfcrVar);
                it = zzfcrVar.zza.iterator();
                while (true) {
                    if (it.hasNext()) {
                        this.zzi.zzf(zzfcrVar, 0L, zzfeo.zzd(1, null, null));
                        break;
                        break;
                    }
                    zzeeuVarZza = this.zzg.zza(zzfcrVar.zzb, (String) it.next());
                    if (zzeeuVarZza == null) {
                    }
                }
            }
        } else {
            String str = zzfcvVar.zzo;
            if (TextUtils.isEmpty(str)) {
                while (r0.hasNext()) {
                    this.zzi.zzd(zzfcrVar);
                    it = zzfcrVar.zza.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            this.zzi.zzf(zzfcrVar, 0L, zzfeo.zzd(1, null, null));
                            break;
                        }
                        zzeeuVarZza = this.zzg.zza(zzfcrVar.zzb, (String) it.next());
                        if (zzeeuVarZza == null && zzeeuVarZza.zzb(zzfdeVar, zzfcrVar)) {
                            break;
                        }
                    }
                }
            } else {
                this.zzi.zzh(str, zzfdeVar.zzb.zza);
            }
        }
        this.zzb.zzo(new zzcoy(zzfdeVar, this.zzd, this.zzc), this.zze);
        if (zzfdeVar.zzb.zzb.zzp > 1) {
            return this.zzl.zzb(zzfdeVar);
        }
        int i2 = 0;
        zzfgw zzfgwVarZza = zzfhb.zzc(zzfzt.zzg(new zzeir(3, zzc(zzfdeVar))), zzfhl.RENDER_CONFIG_INIT, this.zza).zza();
        this.zzh.zzl();
        for (final zzfcr zzfcrVar2 : zzfdeVar.zzb.zza) {
            for (String str2 : zzfcrVar2.zza) {
                final zzeeu zzeeuVarZza2 = this.zzg.zza(zzfcrVar2.zzb, str2);
                if (zzeeuVarZza2 != null && zzeeuVarZza2.zzb(zzfdeVar, zzfcrVar2)) {
                    zzfgwVarZza = this.zza.zzb(zzfhl.RENDER_CONFIG_WATERFALL, zzfgwVarZza).zzh("render-config-" + i2 + "-" + str2).zzc(Throwable.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzeis
                        @Override // com.google.android.gms.internal.ads.zzfza
                        public final ListenableFuture zza(Object obj2) {
                            return this.zza.zzb(zzfcrVar2, zzfdeVar, zzeeuVarZza2, (Throwable) obj2);
                        }
                    }).zza();
                    break;
                }
            }
            i2++;
        }
        final zzeio zzeioVar = this.zzh;
        zzeioVar.getClass();
        zzfgwVarZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeit
            @Override // java.lang.Runnable
            public final void run() {
                zzeioVar.zzj();
            }
        }, this.zze);
        return zzfgwVarZza;
    }

    final /* synthetic */ ListenableFuture zzb(zzfcr zzfcrVar, zzfde zzfdeVar, zzeeu zzeeuVar, Throwable th) throws Exception {
        zzfit zzfitVarZza = zzfis.zza(this.zzj, 12);
        zzfitVarZza.zzd(zzfcrVar.zzG);
        zzfitVarZza.zzh();
        ListenableFuture listenableFutureZzo = zzfzt.zzo(zzeeuVar.zza(zzfdeVar, zzfcrVar), zzfcrVar.zzT, TimeUnit.MILLISECONDS, this.zzf);
        this.zzh.zzf(zzfdeVar, zzfcrVar, listenableFutureZzo, this.zzc);
        zzfjd.zza(listenableFutureZzo, this.zzk, zzfitVarZza);
        return listenableFutureZzo;
    }
}
