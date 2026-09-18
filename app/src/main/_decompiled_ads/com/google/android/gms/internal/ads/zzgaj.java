package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgaj {
    public static zzgad zza(ExecutorService executorService) {
        if (executorService instanceof zzgad) {
            return (zzgad) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new zzgai((ScheduledExecutorService) executorService) : new zzgaf(executorService);
    }

    public static Executor zzb() {
        return zzfzh.INSTANCE;
    }

    static Executor zzc(Executor executor, zzfyh zzfyhVar) {
        Objects.requireNonNull(executor);
        return executor == zzfzh.INSTANCE ? executor : new zzgae(executor, zzfyhVar);
    }
}
