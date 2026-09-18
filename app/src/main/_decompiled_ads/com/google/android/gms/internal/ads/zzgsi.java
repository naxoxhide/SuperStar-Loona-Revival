package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgsi implements Comparator {
    zzgsi() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgsr zzgsrVar = (zzgsr) obj;
        zzgsr zzgsrVar2 = (zzgsr) obj2;
        zzgsl it = zzgsrVar.iterator();
        zzgsl it2 = zzgsrVar2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompareTo = Integer.valueOf(it.zza() & 255).compareTo(Integer.valueOf(it2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzgsrVar.zzd()).compareTo(Integer.valueOf(zzgsrVar2.zzd()));
    }
}
