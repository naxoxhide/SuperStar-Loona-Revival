package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfvh {
    private static final zzfvh zza = new zzfve();
    private static final zzfvh zzb = new zzfvf(-1);
    private static final zzfvh zzc = new zzfvf(1);

    /* synthetic */ zzfvh(zzfvg zzfvgVar) {
    }

    public static zzfvh zzj() {
        return zza;
    }

    public abstract int zza();

    public abstract zzfvh zzb(int i, int i2);

    public abstract zzfvh zzc(Object obj, Object obj2, Comparator comparator);

    public abstract zzfvh zzd(boolean z, boolean z2);

    public abstract zzfvh zze(boolean z, boolean z2);
}
