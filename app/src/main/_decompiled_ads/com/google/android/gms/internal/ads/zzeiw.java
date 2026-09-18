package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeiw {
    private zzeio zza;

    zzeiw() {
    }

    private zzeiw(zzeio zzeioVar) {
        this.zza = zzeioVar;
    }

    public static zzeiw zzb(zzeio zzeioVar) {
        return new zzeiw(zzeioVar);
    }

    public final zzeio zza(Clock clock, zzeip zzeipVar, zzeez zzeezVar, zzfjx zzfjxVar) {
        zzeio zzeioVar = this.zza;
        return zzeioVar != null ? zzeioVar : new zzeio(clock, zzeipVar, zzeezVar, zzfjxVar);
    }
}
