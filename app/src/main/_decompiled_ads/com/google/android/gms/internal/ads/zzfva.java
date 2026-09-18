package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfva extends AbstractCollection {
    final /* synthetic */ zzfvb zza;

    zzfva(zzfvb zzfvbVar) {
        this.zza = zzfvbVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzfvb zzfvbVar = this.zza;
        Map mapZzj = zzfvbVar.zzj();
        return mapZzj != null ? mapZzj.values().iterator() : new zzfuu(zzfvbVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
