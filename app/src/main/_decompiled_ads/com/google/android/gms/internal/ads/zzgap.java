package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgap extends zzfzj {

    @CheckForNull
    private ListenableFuture zza;

    @CheckForNull
    private ScheduledFuture zzb;

    private zzgap(ListenableFuture listenableFuture) {
        Objects.requireNonNull(listenableFuture);
        this.zza = listenableFuture;
    }

    static ListenableFuture zzf(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgap zzgapVar = new zzgap(listenableFuture);
        zzgam zzgamVar = new zzgam(zzgapVar);
        zzgapVar.zzb = scheduledExecutorService.schedule(zzgamVar, j, timeUnit);
        listenableFuture.addListener(zzgamVar, zzfzh.INSTANCE);
        return zzgapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    @CheckForNull
    protected final String zza() {
        ListenableFuture listenableFuture = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (listenableFuture == null) {
            return null;
        }
        String str = "inputFuture=[" + listenableFuture.toString() + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    protected final void zzb() {
        zzr(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
