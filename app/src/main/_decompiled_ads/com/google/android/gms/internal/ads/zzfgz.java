package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfgz {
    final /* synthetic */ zzfhj zza;
    private final Object zzb;
    private final List zzc;

    /* synthetic */ zzfgz(zzfhj zzfhjVar, Object obj, List list, zzfgy zzfgyVar) {
        this.zza = zzfhjVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfhi zza(Callable callable) {
        zzfzs zzfzsVarZzb = zzfzt.zzb(this.zzc);
        ListenableFuture listenableFutureZza = zzfzsVarZzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfgx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzcbg.zzf);
        ListenableFuture listenableFutureZza2 = zzfzsVarZzb.zza(callable, this.zza.zzb);
        return new zzfhi(this.zza, this.zzb, listenableFutureZza, this.zzc, listenableFutureZza2);
    }
}
