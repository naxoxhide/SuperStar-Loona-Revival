package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzfuf extends zzfty implements SortedMap {

    @CheckForNull
    SortedSet zzd;
    final /* synthetic */ zzful zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfuf(zzful zzfulVar, SortedMap sortedMap) {
        super(zzfulVar, sortedMap);
        this.zze = zzfulVar;
    }

    @Override // java.util.SortedMap
    @CheckForNull
    public final Comparator comparator() {
        return zzf().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return zzf().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new zzfuf(this.zze, zzf().headMap(obj));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return zzf().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new zzfuf(this.zze, zzf().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new zzfuf(this.zze, zzf().tailMap(obj));
    }

    SortedMap zzf() {
        return (SortedMap) this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzfwm
    public SortedSet zzg() {
        return new zzfug(this.zze, zzf());
    }

    @Override // com.google.android.gms.internal.ads.zzfty, com.google.android.gms.internal.ads.zzfwm, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.zzd;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet sortedSetZzg = zzg();
        this.zzd = sortedSetZzg;
        return sortedSetZzg;
    }
}
