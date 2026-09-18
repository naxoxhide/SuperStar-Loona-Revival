package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfyo extends zzfyp {
    zzfyo(ListenableFuture listenableFuture, zzfsk zzfskVar) {
        super(listenableFuture, zzfskVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfyp
    final /* synthetic */ Object zze(Object obj, Object obj2) throws Exception {
        return ((zzfsk) obj).apply(obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzfyp
    final void zzf(Object obj) {
        zzc(obj);
    }
}
