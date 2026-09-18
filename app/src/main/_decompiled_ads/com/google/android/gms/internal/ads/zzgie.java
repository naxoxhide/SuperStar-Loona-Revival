package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgie {
    private static final zzgie zza = new zzgie();
    private static final zzgid zzb = new zzgid(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzgie zza() {
        return zza;
    }

    public final zzgme zzb() {
        zzgme zzgmeVar = (zzgme) this.zzc.get();
        return zzgmeVar == null ? zzb : zzgmeVar;
    }
}
