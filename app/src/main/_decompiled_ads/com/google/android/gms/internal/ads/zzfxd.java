package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfxd extends zzfvs {
    final /* synthetic */ zzfxe zza;

    zzfxd(zzfxe zzfxeVar) {
        this.zza = zzfxeVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzfsw.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzfxe zzfxeVar = this.zza;
        int i2 = i + i;
        Object obj = zzfxeVar.zzb[i2];
        obj.getClass();
        Object obj2 = zzfxeVar.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final boolean zzf() {
        return true;
    }
}
