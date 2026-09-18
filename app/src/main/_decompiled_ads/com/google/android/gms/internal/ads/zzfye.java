package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfye extends zzfyf {
    zzfye(ListenableFuture listenableFuture, Class cls, zzfsk zzfskVar) {
        super(listenableFuture, cls, zzfskVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    final /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        return ((zzfsk) obj).apply(th);
    }

    @Override // com.google.android.gms.internal.ads.zzfyf
    final void zzf(Object obj) {
        zzc(obj);
    }
}
