package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcte {
    public final List zza;

    public zzcte(zzcsx zzcsxVar) {
        this.zza = Collections.singletonList(zzfzt.zzh(zzcsxVar));
    }

    public zzcte(List list) {
        this.zza = list;
    }

    public static zzeeu zza(zzeeu zzeeuVar) {
        return new zzeev(zzeeuVar, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzctd
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                return new zzcte((zzcsx) obj);
            }
        });
    }
}
