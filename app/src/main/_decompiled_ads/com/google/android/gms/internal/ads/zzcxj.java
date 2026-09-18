package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcxj extends zzdcz implements com.google.android.gms.ads.internal.client.zza {
    public zzcxj(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzt(new zzdcy() { // from class: com.google.android.gms.internal.ads.zzcxi
            @Override // com.google.android.gms.internal.ads.zzdcy
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zza) obj).onAdClicked();
            }
        });
    }
}
