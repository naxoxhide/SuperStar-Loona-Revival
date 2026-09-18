package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdwv implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;
    private final zzhbp zzc;

    public zzdwv(zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
        this.zzc = zzhbpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        final zzaro zzaroVar = (zzaro) this.zza.zzb();
        final Context contextZza = ((zzcic) this.zzb).zza();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        ListenableFuture listenableFutureZzb = zzgadVar.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdws
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzaroVar.zzc().zzg(contextZza);
            }
        });
        zzhbk.zzb(listenableFutureZzb);
        return listenableFutureZzb;
    }
}
