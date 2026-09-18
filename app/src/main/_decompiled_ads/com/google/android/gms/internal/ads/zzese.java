package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzese implements zzetw {
    private final zzetw zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzese(zzetw zzetwVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzetwVar;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureZzb = this.zza.zzb();
        long j = this.zzb;
        if (j > 0) {
            listenableFutureZzb = zzfzt.zzo(listenableFutureZzb, j, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzfzt.zzf(listenableFutureZzb, Throwable.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzesd
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzh(null);
            }
        }, zzcbg.zzf);
    }
}
