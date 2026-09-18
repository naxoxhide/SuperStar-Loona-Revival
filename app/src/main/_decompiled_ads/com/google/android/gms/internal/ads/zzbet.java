package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbet {
    private static final AtomicReference zzb = new AtomicReference();
    private static final AtomicReference zzc = new AtomicReference();
    static final AtomicBoolean zza = new AtomicBoolean();

    static zzber zza() {
        return (zzber) zzb.get();
    }

    static zzbes zzb() {
        return (zzbes) zzc.get();
    }

    public static void zzc(zzber zzberVar) {
        zzb.set(zzberVar);
    }
}
