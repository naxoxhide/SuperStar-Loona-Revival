package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzego implements zzeeu {
    private final zzcrs zza;
    private final zzefv zzb;
    private final zzgad zzc;
    private final zzcxn zzd;
    private final ScheduledExecutorService zze;

    public zzego(zzcrs zzcrsVar, zzefv zzefvVar, zzcxn zzcxnVar, ScheduledExecutorService scheduledExecutorService, zzgad zzgadVar) {
        this.zza = zzcrsVar;
        this.zzb = zzefvVar;
        this.zzd = zzcxnVar;
        this.zze = scheduledExecutorService;
        this.zzc = zzgadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(final zzfde zzfdeVar, final zzfcr zzfcrVar) {
        return this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzegm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc(zzfdeVar, zzfcrVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final boolean zzb(zzfde zzfdeVar, zzfcr zzfcrVar) {
        return zzfdeVar.zza.zza.zza() != null && this.zzb.zzb(zzfdeVar, zzfcrVar);
    }

    final /* synthetic */ zzcqv zzc(final zzfde zzfdeVar, final zzfcr zzfcrVar) throws Exception {
        return this.zza.zzb(new zzctm(zzfdeVar, zzfcrVar, null), new zzcsf(zzfdeVar.zza.zza.zza(), new Runnable() { // from class: com.google.android.gms.internal.ads.zzegl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf(zzfdeVar, zzfcrVar);
            }
        })).zza();
    }

    final /* synthetic */ void zzf(zzfde zzfdeVar, zzfcr zzfcrVar) {
        zzfzt.zzr(zzfzt.zzo(this.zzb.zza(zzfdeVar, zzfcrVar), zzfcrVar.zzT, TimeUnit.SECONDS, this.zze), new zzegn(this), this.zzc);
    }
}
