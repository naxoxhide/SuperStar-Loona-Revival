package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbka implements zzbjj {
    private final zzbjz zza;

    public zzbka(zzbjz zzbjzVar) {
        this.zza = zzbjzVar;
    }

    public static void zzb(zzcgb zzcgbVar, zzbjz zzbjzVar) {
        zzcgbVar.zzad("/reward", new zzbka(zzbjzVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if (!"grant".equals(str)) {
            if ("video_start".equals(str)) {
                this.zza.zzc();
                return;
            } else {
                if ("video_complete".equals(str)) {
                    this.zza.zzb();
                    return;
                }
                return;
            }
        }
        zzbwi zzbwiVar = null;
        try {
            int i = Integer.parseInt((String) map.get("amount"));
            String str2 = (String) map.get("type");
            if (!TextUtils.isEmpty(str2)) {
                zzbwiVar = new zzbwi(str2, i);
            }
        } catch (NumberFormatException e) {
            zzcat.zzk("Unable to parse reward amount.", e);
        }
        this.zza.zza(zzbwiVar);
    }
}
