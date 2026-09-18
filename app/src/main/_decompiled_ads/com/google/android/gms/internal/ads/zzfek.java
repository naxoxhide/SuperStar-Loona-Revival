package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfek {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzgad zzc;

    public zzfek(Callable callable, zzgad zzgadVar) {
        this.zzb = callable;
        this.zzc = zzgadVar;
    }

    public final synchronized ListenableFuture zza() {
        zzc(1);
        return (ListenableFuture) this.zza.poll();
    }

    public final synchronized void zzb(ListenableFuture listenableFuture) {
        this.zza.addFirst(listenableFuture);
    }

    public final synchronized void zzc(int i) {
        int size = i - this.zza.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zza.add(this.zzc.zzb(this.zzb));
        }
    }
}
