package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfzs {
    private final boolean zza;
    private final zzfvs zzb;

    /* synthetic */ zzfzs(boolean z, zzfvs zzfvsVar, zzfzr zzfzrVar) {
        this.zza = z;
        this.zzb = zzfvsVar;
    }

    public final ListenableFuture zza(Callable callable, Executor executor) {
        return new zzfzg(this.zzb, this.zza, executor, callable);
    }
}
