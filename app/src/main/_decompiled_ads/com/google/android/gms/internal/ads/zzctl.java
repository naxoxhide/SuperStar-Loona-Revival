package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzctl {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final ListenableFuture zzc;
    private volatile boolean zzd = true;

    public zzctl(Executor executor, ScheduledExecutorService scheduledExecutorService, ListenableFuture listenableFuture) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = listenableFuture;
    }

    static /* bridge */ /* synthetic */ void zzb(final zzctl zzctlVar, List list, final zzfzp zzfzpVar) {
        if (list == null || list.isEmpty()) {
            zzctlVar.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctg
                @Override // java.lang.Runnable
                public final void run() {
                    zzfzpVar.zza(new zzdwm(3));
                }
            });
            return;
        }
        ListenableFuture listenableFutureZzh = zzfzt.zzh(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ListenableFuture listenableFuture = (ListenableFuture) it.next();
            listenableFutureZzh = zzfzt.zzn(zzfzt.zzf(listenableFutureZzh, Throwable.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzcth
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    zzfzpVar.zza((Throwable) obj);
                    return zzfzt.zzh(null);
                }
            }, zzctlVar.zza), new zzfza() { // from class: com.google.android.gms.internal.ads.zzcti
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zza(zzfzpVar, listenableFuture, (zzcsx) obj);
                }
            }, zzctlVar.zza);
        }
        zzfzt.zzr(listenableFutureZzh, new zzctk(zzctlVar, zzfzpVar), zzctlVar.zza);
    }

    final /* synthetic */ ListenableFuture zza(zzfzp zzfzpVar, ListenableFuture listenableFuture, zzcsx zzcsxVar) throws Exception {
        if (zzcsxVar != null) {
            zzfzpVar.zzb(zzcsxVar);
        }
        return zzfzt.zzo(listenableFuture, ((Long) zzbeo.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzfzp zzfzpVar) {
        zzfzt.zzr(this.zzc, new zzctj(this, zzfzpVar), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
