package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewn implements zzetw {
    final zzgad zza;
    final List zzb;
    final zzbbt zzc;

    public zzewn(zzbbt zzbbtVar, zzgad zzgadVar, List list) {
        this.zzc = zzbbtVar;
        this.zza = zzgadVar;
        this.zzb = list;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 48;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzewm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzewo(this.zza.zzb);
            }
        });
    }
}
