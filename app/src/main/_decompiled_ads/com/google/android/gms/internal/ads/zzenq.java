package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenq implements zzetw {
    private final Clock zza;
    private final zzfdn zzb;

    zzenq(Clock clock, zzfdn zzfdnVar) {
        this.zza = clock;
        this.zzb = zzfdnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return zzfzt.zzh(new zzenr(this.zzb, this.zza.currentTimeMillis()));
    }
}
