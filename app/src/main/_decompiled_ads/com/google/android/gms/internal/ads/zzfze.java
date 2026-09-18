package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfze extends zzfzf {
    final /* synthetic */ zzfzg zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfze(zzfzg zzfzgVar, Callable callable, Executor executor) {
        super(zzfzgVar, executor);
        this.zza = zzfzgVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgac
    final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgac
    final String zzb() {
        return this.zzc.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfzf
    final void zzc(Object obj) {
        this.zza.zzc(obj);
    }
}
