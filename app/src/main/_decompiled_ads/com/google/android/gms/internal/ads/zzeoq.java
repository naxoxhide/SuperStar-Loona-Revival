package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeoq implements zzetw {
    private final zzgad zza;
    private final zzfdn zzb;
    private final zzcaz zzc;
    private final zzcag zzd;

    public zzeoq(zzgad zzgadVar, zzfdn zzfdnVar, zzcaz zzcazVar, zzcag zzcagVar) {
        this.zza = zzgadVar;
        this.zzb = zzfdnVar;
        this.zzc = zzcazVar;
        this.zzd = zzcagVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 9;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeop
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzeor zzc() throws Exception {
        return new zzeor(this.zzb.zzj, this.zzc, this.zzd.zzm());
    }
}
