package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfzt extends zzfzv {
    /* JADX WARN: Multi-variable type inference failed */
    public static zzfzs zza(Iterable iterable) {
        return new zzfzs(false, zzfvs.zzj(iterable), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzfzs zzb(Iterable iterable) {
        int i = zzfvs.zzd;
        Objects.requireNonNull(iterable);
        return new zzfzs(true, zzfvs.zzj(iterable), null);
    }

    @SafeVarargs
    public static zzfzs zzc(ListenableFuture... listenableFutureArr) {
        return new zzfzs(true, zzfvs.zzk(listenableFutureArr), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ListenableFuture zzd(Iterable iterable) {
        return new zzfzb(zzfvs.zzj(iterable), true);
    }

    public static ListenableFuture zze(ListenableFuture listenableFuture, Class cls, zzfsk zzfskVar, Executor executor) {
        zzfye zzfyeVar = new zzfye(listenableFuture, cls, zzfskVar);
        listenableFuture.addListener(zzfyeVar, zzgaj.zzc(executor, zzfyeVar));
        return zzfyeVar;
    }

    public static ListenableFuture zzf(ListenableFuture listenableFuture, Class cls, zzfza zzfzaVar, Executor executor) {
        zzfyd zzfydVar = new zzfyd(listenableFuture, cls, zzfzaVar);
        listenableFuture.addListener(zzfydVar, zzgaj.zzc(executor, zzfydVar));
        return zzfydVar;
    }

    public static ListenableFuture zzh(Object obj) {
        return obj == null ? zzfzx.zza : new zzfzx(obj);
    }

    public static ListenableFuture zzi() {
        return zzfzx.zza;
    }

    public static ListenableFuture zzj(Callable callable, Executor executor) {
        zzgas zzgasVar = new zzgas(callable);
        executor.execute(zzgasVar);
        return zzgasVar;
    }

    public static ListenableFuture zzk(zzfyz zzfyzVar, Executor executor) {
        zzgas zzgasVar = new zzgas(zzfyzVar);
        executor.execute(zzgasVar);
        return zzgasVar;
    }

    @SafeVarargs
    public static ListenableFuture zzl(ListenableFuture... listenableFutureArr) {
        return new zzfzb(zzfvs.zzk(listenableFutureArr), false);
    }

    public static ListenableFuture zzm(ListenableFuture listenableFuture, zzfsk zzfskVar, Executor executor) {
        zzfyo zzfyoVar = new zzfyo(listenableFuture, zzfskVar);
        listenableFuture.addListener(zzfyoVar, zzgaj.zzc(executor, zzfyoVar));
        return zzfyoVar;
    }

    public static ListenableFuture zzn(ListenableFuture listenableFuture, zzfza zzfzaVar, Executor executor) {
        int i = zzfyp.zzc;
        Objects.requireNonNull(executor);
        zzfyn zzfynVar = new zzfyn(listenableFuture, zzfzaVar);
        listenableFuture.addListener(zzfynVar, zzgaj.zzc(executor, zzfynVar));
        return zzfynVar;
    }

    public static ListenableFuture zzo(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : zzgap.zzf(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgau.zza(future);
        }
        throw new IllegalStateException(zzftl.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgau.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzfzi((Error) cause);
            }
            throw new zzgat(cause);
        }
    }

    public static ListenableFuture zzg(Throwable th) {
        Objects.requireNonNull(th);
        return new zzfzw(th);
    }

    public static void zzr(ListenableFuture listenableFuture, zzfzp zzfzpVar, Executor executor) {
        Objects.requireNonNull(zzfzpVar);
        listenableFuture.addListener(new zzfzq(listenableFuture, zzfzpVar), executor);
    }
}
