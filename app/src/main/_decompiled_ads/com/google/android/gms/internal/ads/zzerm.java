package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzerm implements zzetw {
    private final zzfcq zza;

    zzerm(zzfcq zzfcqVar) {
        this.zza = zzfcqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 25;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return zzfzt.zzh(new zzern(this.zza));
    }
}
