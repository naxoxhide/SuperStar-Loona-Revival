package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcxn extends zzdcz implements zzcxo {
    public zzcxn(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcxo
    public final void zzbF(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzt(new zzdcy() { // from class: com.google.android.gms.internal.ads.zzcxm
            @Override // com.google.android.gms.internal.ads.zzdcy
            public final void zza(Object obj) {
                ((zzcxo) obj).zzbF(zzeVar);
            }
        });
    }
}
