package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdif implements zzbjj {
    private final WeakReference zza;

    /* synthetic */ zzdif(zzdig zzdigVar, zzdie zzdieVar) {
        this.zza = new WeakReference(zzdigVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        zzdig zzdigVar = (zzdig) this.zza.get();
        if (zzdigVar == null) {
            return;
        }
        zzdigVar.zzg.zza();
    }
}
