package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenu implements zzetw {
    private final zzgad zza;
    private final zzfdn zzb;
    private final zzfea zzc;

    zzenu(zzgad zzgadVar, zzfdn zzfdnVar, zzfea zzfeaVar) {
        this.zza = zzgadVar;
        this.zzb = zzfdnVar;
        this.zzc = zzfeaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 5;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzent
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzenv zzc() throws Exception {
        String strZza = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhf)).booleanValue() && "requester_type_2".equals(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(this.zzb.zzd))) {
            strZza = zzfea.zza();
        }
        return new zzenv(strZza);
    }
}
