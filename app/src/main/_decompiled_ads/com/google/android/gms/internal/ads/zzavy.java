package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzavy implements Comparator {
    zzavy(zzawa zzawaVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzawe zzaweVar = (zzawe) obj;
        zzawe zzaweVar2 = (zzawe) obj2;
        int i = zzaweVar.zzc - zzaweVar2.zzc;
        return i != 0 ? i : (zzaweVar.zza > zzaweVar2.zza ? 1 : (zzaweVar.zza == zzaweVar2.zza ? 0 : -1));
    }
}
