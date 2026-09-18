package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewj implements zzetw {
    final zzgad zza;
    final String zzb;
    final zzbzq zzc;

    public zzewj(zzbzq zzbzqVar, zzgad zzgadVar, String str) {
        this.zzc = zzbzqVar;
        this.zza = zzgadVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 47;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        final ListenableFuture listenableFutureZzh = zzfzt.zzh(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfL)).booleanValue()) {
            listenableFutureZzh = zzfzt.zzh(null);
        }
        final ListenableFuture listenableFutureZzh2 = zzfzt.zzh(null);
        return zzfzt.zzc(listenableFutureZzh, listenableFutureZzh2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzewi
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzewk((String) listenableFutureZzh.get(), (String) listenableFutureZzh2.get());
            }
        }, zzcbg.zza);
    }
}
