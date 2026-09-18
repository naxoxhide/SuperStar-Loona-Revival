package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeqc implements zzetw {
    private final zzgad zza;
    private final zzdqo zzb;
    private final String zzc;
    private final zzfdn zzd;

    public zzeqc(zzgad zzgadVar, zzdqo zzdqoVar, zzfdn zzfdnVar, String str) {
        this.zza = zzgadVar;
        this.zzb = zzdqoVar;
        this.zzd = zzfdnVar;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 17;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzeqd zzc() throws Exception {
        zzfdn zzfdnVar = this.zzd;
        zzdqo zzdqoVar = this.zzb;
        return new zzeqd(zzdqoVar.zzb(zzfdnVar.zzf, this.zzc), zzdqoVar.zza());
    }
}
