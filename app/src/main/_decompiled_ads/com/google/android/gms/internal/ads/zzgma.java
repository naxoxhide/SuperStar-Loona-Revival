package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgma {
    private HashMap zza = new HashMap();

    public final zzgmc zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzgmc zzgmcVar = new zzgmc(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzgmcVar;
    }
}
