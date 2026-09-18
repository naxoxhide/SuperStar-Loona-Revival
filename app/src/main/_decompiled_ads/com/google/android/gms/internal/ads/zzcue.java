package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcue {
    private final zzdxu zza;
    private final zzfdn zzb;
    private final zzfhr zzc;
    private final zzcnj zzd;
    private final zzeiu zze;
    private final zzdcq zzf;
    private zzfde zzg;
    private final zzdyz zzh;
    private final zzcwp zzi;
    private final Executor zzj;
    private final zzdyl zzk;
    private final zzeez zzl;
    private final zzdzp zzm;
    private final zzdzw zzn;

    zzcue(zzdxu zzdxuVar, zzfdn zzfdnVar, zzfhr zzfhrVar, zzcnj zzcnjVar, zzeiu zzeiuVar, zzdcq zzdcqVar, zzfde zzfdeVar, zzdyz zzdyzVar, zzcwp zzcwpVar, Executor executor, zzdyl zzdylVar, zzeez zzeezVar, zzdzp zzdzpVar, zzdzw zzdzwVar) {
        this.zza = zzdxuVar;
        this.zzb = zzfdnVar;
        this.zzc = zzfhrVar;
        this.zzd = zzcnjVar;
        this.zze = zzeiuVar;
        this.zzf = zzdcqVar;
        this.zzg = zzfdeVar;
        this.zzh = zzdyzVar;
        this.zzi = zzcwpVar;
        this.zzj = executor;
        this.zzk = zzdylVar;
        this.zzl = zzeezVar;
        this.zzm = zzdzpVar;
        this.zzn = zzdzwVar;
    }

    public final com.google.android.gms.ads.internal.client.zze zza(Throwable th) {
        return zzfeo.zzb(th, this.zzl);
    }

    public final zzdcq zzc() {
        return this.zzf;
    }

    final /* synthetic */ zzfde zzd(zzfde zzfdeVar) throws Exception {
        this.zzd.zza(zzfdeVar);
        return zzfdeVar;
    }

    public final ListenableFuture zze(final zzffh zzffhVar) {
        zzfgw zzfgwVarZza = this.zzc.zzb(zzfhl.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzcua
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzf(zzffhVar, (zzbvg) obj);
            }
        }).zza();
        zzfzt.zzr(zzfgwVarZza, new zzcuc(this), this.zzj);
        return zzfgwVarZza;
    }

    final /* synthetic */ ListenableFuture zzf(zzffh zzffhVar, zzbvg zzbvgVar) throws Exception {
        zzbvgVar.zzi = zzffhVar;
        return this.zzh.zza(zzbvgVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ ListenableFuture zzg(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3) throws Exception {
        return this.zzn.zzc((zzbvg) listenableFuture.get(), (JSONObject) listenableFuture2.get(), (zzbvj) listenableFuture3.get());
    }

    public final ListenableFuture zzh(zzbvg zzbvgVar) {
        zzfgw zzfgwVarZza = this.zzc.zzb(zzfhl.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbvgVar)).zza();
        zzfzt.zzr(zzfgwVarZza, new zzcud(this), this.zzj);
        return zzfgwVarZza;
    }

    public final ListenableFuture zzi(ListenableFuture listenableFuture) {
        zzfhi zzfhiVarZzf = this.zzc.zzb(zzfhl.RENDERER, listenableFuture).zze(new zzfgu() { // from class: com.google.android.gms.internal.ads.zzctv
            @Override // com.google.android.gms.internal.ads.zzfgu
            public final Object zza(Object obj) throws Exception {
                zzfde zzfdeVar = (zzfde) obj;
                this.zza.zzd(zzfdeVar);
                return zzfdeVar;
            }
        }).zzf(this.zze);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfs)).booleanValue()) {
            zzfhiVarZzf = zzfhiVarZzf.zzi(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfu)).intValue(), TimeUnit.SECONDS);
        }
        return zzfhiVarZzf.zza();
    }

    public final ListenableFuture zzj() {
        com.google.android.gms.ads.internal.client.zzl zzlVar = this.zzb.zzd;
        if (zzlVar.zzx == null && zzlVar.zzs == null) {
            return zzk(this.zzi.zzc());
        }
        zzfhr zzfhrVar = this.zzc;
        zzdxu zzdxuVar = this.zza;
        return zzfhb.zzc(zzdxuVar.zza(), zzfhl.PRELOADED_LOADER, zzfhrVar).zza();
    }

    public final ListenableFuture zzk(final ListenableFuture listenableFuture) {
        if (this.zzg != null) {
            return zzfhb.zzc(zzfzt.zzh(this.zzg), zzfhl.SERVER_TRANSACTION, this.zzc).zza();
        }
        com.google.android.gms.ads.internal.zzt.zzc().zzj();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkz)).booleanValue() || ((Boolean) zzbeh.zzc.zze()).booleanValue()) {
            zzfhi zzfhiVarZzb = this.zzc.zzb(zzfhl.SERVER_TRANSACTION, listenableFuture);
            final zzdyl zzdylVar = this.zzk;
            return zzfhiVarZzb.zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzcub
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    return zzdylVar.zzb((zzbvg) obj);
                }
            }).zza();
        }
        final zzdzp zzdzpVar = this.zzm;
        final ListenableFuture listenableFutureZzn = zzfzt.zzn(listenableFuture, new zzfza() { // from class: com.google.android.gms.internal.ads.zzctw
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzdzpVar.zza((zzbvg) obj);
            }
        }, this.zzj);
        zzfhi zzfhiVarZzb2 = this.zzc.zzb(zzfhl.BUILD_URL, listenableFutureZzn);
        final zzdyz zzdyzVar = this.zzh;
        final zzfgw zzfgwVarZza = zzfhiVarZzb2.zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzctx
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzdyzVar.zzb((JSONObject) obj);
            }
        }).zza();
        return this.zzc.zza(zzfhl.SERVER_TRANSACTION, listenableFuture, listenableFutureZzn, zzfgwVarZza).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcty
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzg(listenableFuture, listenableFutureZzn, zzfgwVarZza);
            }
        }).zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzctz
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return (ListenableFuture) obj;
            }
        }).zza();
    }

    public final void zzl(zzfde zzfdeVar) {
        this.zzg = zzfdeVar;
    }
}
