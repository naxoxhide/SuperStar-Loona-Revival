package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdid implements zzbjj {
    private final WeakReference zza;

    /* synthetic */ zzdid(zzdig zzdigVar, zzdic zzdicVar) {
        this.zza = new WeakReference(zzdigVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        zzdig zzdigVar = (zzdig) this.zza.get();
        if (zzdigVar == null) {
            return;
        }
        zzdigVar.zzh.onAdClicked();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjU)).booleanValue()) {
            zzdigVar.zzi.zzbK();
            if (TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                return;
            }
            zzdigVar.zzi.zzs();
        }
    }
}
