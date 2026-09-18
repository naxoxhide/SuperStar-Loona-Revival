package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfyv extends zzfyu {
    final AtomicReferenceFieldUpdater zza;
    final AtomicIntegerFieldUpdater zzb;

    zzfyv(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super(null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    @Override // com.google.android.gms.internal.ads.zzfyu
    final int zza(zzfyy zzfyyVar) {
        return this.zzb.decrementAndGet(zzfyyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfyu
    final void zzb(zzfyy zzfyyVar, @CheckForNull Set set, Set set2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.zza;
            if (atomicReferenceFieldUpdater.compareAndSet(zzfyyVar, null, set2)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(zzfyyVar) == null);
    }
}
