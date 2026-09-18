package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfyd extends zzfyf {
    zzfyd(ListenableFuture listenableFuture, Class cls, zzfza zzfzaVar) {
        super(listenableFuture, cls, zzfzaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        zzfza zzfzaVar = (zzfza) obj;
        ListenableFuture listenableFutureZza = zzfzaVar.zza(th);
        zzfsw.zzd(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzfzaVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    final /* synthetic */ void zzf(Object obj) {
        zzs((ListenableFuture) obj);
    }
}
