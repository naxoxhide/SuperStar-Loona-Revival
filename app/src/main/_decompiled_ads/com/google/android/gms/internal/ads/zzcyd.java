package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcyd extends zzdcz {
    private boolean zzb;

    public zzcyd(Set set) {
        super(set);
        this.zzb = false;
    }

    public final synchronized void zza() {
        if (this.zzb) {
            return;
        }
        zzt(new zzdcy() { // from class: com.google.android.gms.internal.ads.zzcyc
            @Override // com.google.android.gms.internal.ads.zzdcy
            public final void zza(Object obj) {
                ((zzcyf) obj).zzq();
            }
        });
        this.zzb = true;
    }
}
