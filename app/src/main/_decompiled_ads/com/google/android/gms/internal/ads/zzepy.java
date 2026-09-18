package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepy implements zzetw {
    private final zzgad zza;

    zzepy(zzgad zzgadVar) {
        this.zza = zzgadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 55;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzepx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzepz(Long.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zza()).longValue());
            }
        });
    }
}
