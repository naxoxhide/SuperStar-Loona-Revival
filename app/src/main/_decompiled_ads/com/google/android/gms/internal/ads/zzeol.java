package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeol {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzeok zzb;

    final zzeok zza() {
        return this.zzb;
    }

    final void zzb(zzeok zzeokVar) {
        this.zzb = zzeokVar;
    }

    public final void zzc(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
