package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdoh implements zzbjj {
    final /* synthetic */ zzdoi zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzbjj zzd;

    /* synthetic */ zzdoh(zzdoi zzdoiVar, WeakReference weakReference, String str, zzbjj zzbjjVar, zzdog zzdogVar) {
        this.zza = zzdoiVar;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbjjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zzk(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
