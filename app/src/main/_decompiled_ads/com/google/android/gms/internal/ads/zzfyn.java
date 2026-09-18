package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfyn extends zzfyp {
    zzfyn(ListenableFuture listenableFuture, zzfza zzfzaVar) {
        super(listenableFuture, zzfzaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfyp
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) throws Exception {
        zzfza zzfzaVar = (zzfza) obj;
        ListenableFuture listenableFutureZza = zzfzaVar.zza(obj2);
        zzfsw.zzd(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzfzaVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfyp
    final /* synthetic */ void zzf(Object obj) {
        zzs((ListenableFuture) obj);
    }
}
