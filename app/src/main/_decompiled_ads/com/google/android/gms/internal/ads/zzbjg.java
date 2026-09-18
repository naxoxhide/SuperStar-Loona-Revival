package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbjg implements zzbjj {
    zzbjg() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgb zzcgbVar = (zzcgb) obj;
        if (map.keySet().contains("start")) {
            zzcgbVar.zzN().zzl();
        } else if (map.keySet().contains("stop")) {
            zzcgbVar.zzN().zzm();
        } else if (map.keySet().contains("cancel")) {
            zzcgbVar.zzN().zzk();
        }
    }
}
