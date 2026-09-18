package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfve extends zzfvh {
    zzfve() {
        super(null);
    }

    static final zzfvh zzf(int i) {
        if (i < 0) {
            return zzfvh.zzb;
        }
        return i > 0 ? zzfvh.zzc : zzfvh.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final zzfvh zzb(int i, int i2) {
        int i3;
        if (i < i2) {
            i3 = -1;
        } else {
            i3 = i > i2 ? 1 : 0;
        }
        return zzf(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final zzfvh zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final zzfvh zzd(boolean z, boolean z2) {
        return zzf(zzfxz.zza(z, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final zzfvh zze(boolean z, boolean z2) {
        return zzf(zzfxz.zza(false, false));
    }
}
