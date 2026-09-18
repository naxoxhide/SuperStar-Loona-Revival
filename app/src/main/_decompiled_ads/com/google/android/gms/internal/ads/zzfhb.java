package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfhb {
    public static final zzfhi zza(Callable callable, Object obj, zzfhj zzfhjVar) {
        return zzb(callable, zzfhjVar.zzb, obj, zzfhjVar);
    }

    public static final zzfhi zzb(Callable callable, zzgad zzgadVar, Object obj, zzfhj zzfhjVar) {
        return new zzfhi(zzfhjVar, obj, zzfhj.zza, Collections.emptyList(), zzgadVar.zzb(callable));
    }

    public static final zzfhi zzc(ListenableFuture listenableFuture, Object obj, zzfhj zzfhjVar) {
        return new zzfhi(zzfhjVar, obj, zzfhj.zza, Collections.emptyList(), listenableFuture);
    }

    public static final zzfhi zzd(final zzfgv zzfgvVar, zzgad zzgadVar, Object obj, zzfhj zzfhjVar) {
        return zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfha
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                zzfgvVar.zza();
                return null;
            }
        }, zzgadVar, obj, zzfhjVar);
    }
}
