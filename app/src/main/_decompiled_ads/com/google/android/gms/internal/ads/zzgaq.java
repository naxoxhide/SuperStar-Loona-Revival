package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgaq extends zzgac {
    final /* synthetic */ zzgas zza;
    private final zzfyz zzb;

    zzgaq(zzgas zzgasVar, zzfyz zzfyzVar) {
        this.zza = zzgasVar;
        this.zzb = zzfyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgac
    final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzfyz zzfyzVar = this.zzb;
        ListenableFuture listenableFutureZza = zzfyzVar.zza();
        zzfsw.zzd(listenableFutureZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzfyzVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgac
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgac
    final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgac
    final /* synthetic */ void zze(Object obj) {
        this.zza.zzs((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgac
    final boolean zzg() {
        return this.zza.isDone();
    }
}
