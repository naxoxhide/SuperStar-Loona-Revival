package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfhj {
    private static final ListenableFuture zza = zzfzt.zzh(null);
    private final zzgad zzb;
    private final ScheduledExecutorService zzc;
    private final zzfhk zzd;

    public zzfhj(zzgad zzgadVar, ScheduledExecutorService scheduledExecutorService, zzfhk zzfhkVar) {
        this.zzb = zzgadVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfhkVar;
    }

    public final zzfgz zza(Object obj, ListenableFuture... listenableFutureArr) {
        return new zzfgz(this, obj, Arrays.asList(listenableFutureArr), null);
    }

    public final zzfhi zzb(Object obj, ListenableFuture listenableFuture) {
        return new zzfhi(this, obj, listenableFuture, Collections.singletonList(listenableFuture), listenableFuture);
    }

    protected abstract String zzf(Object obj);
}
