package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdib implements zzbjj {
    private final WeakReference zza;

    /* synthetic */ zzdib(zzdig zzdigVar, zzdia zzdiaVar) {
        this.zza = new WeakReference(zzdigVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        zzdig zzdigVar = (zzdig) this.zza.get();
        if (zzdigVar != null && "_ac".equals((String) map.get("eventName"))) {
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
}
