package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcsz implements zzcta {
    private final Map zza;

    zzcsz(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzeeu zza(int i, String str) {
        return (zzeeu) this.zza.get(str);
    }
}
