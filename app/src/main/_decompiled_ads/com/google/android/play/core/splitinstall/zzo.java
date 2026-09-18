package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzo implements zzg {
    INSTANCE;

    private static final AtomicReference zzb = new AtomicReference(null);

    @Override // com.google.android.play.core.splitinstall.zzg
    public final zzh zza() {
        return (zzh) zzb.get();
    }

    public final void zzb(zzh zzhVar) {
        zzb.set(zzhVar);
    }
}
