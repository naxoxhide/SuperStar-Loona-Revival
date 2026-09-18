package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfxb implements Comparator {
    protected zzfxb() {
    }

    public static zzfxb zzb(Comparator comparator) {
        return comparator instanceof zzfxb ? (zzfxb) comparator : new zzfvd(comparator);
    }

    public static zzfxb zzc() {
        return zzfwz.zza;
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzfxb zza() {
        return new zzfxk(this);
    }
}
