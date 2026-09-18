package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgug extends AbstractList {
    private final List zza;
    private final zzguf zzb;

    public zzgug(List list, zzguf zzgufVar) {
        this.zza = list;
        this.zzb = zzgufVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        zzayt zzaytVarZzb = zzayt.zzb(((Integer) this.zza.get(i)).intValue());
        return zzaytVarZzb == null ? zzayt.AD_FORMAT_TYPE_UNSPECIFIED : zzaytVarZzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
