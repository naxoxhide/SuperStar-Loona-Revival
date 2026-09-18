package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TJAdUnitConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbhy implements zzbjj {
    private final zzbhz zza;

    public zzbhy(zzbhz zzbhzVar) {
        this.zza = zzbhzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        if (this.zza == null) {
            return;
        }
        String str = (String) map.get("name");
        if (str == null) {
            zzcat.zzi("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleZza = null;
        if (map.containsKey(TJAdUnitConstants.String.VIDEO_INFO)) {
            try {
                bundleZza = com.google.android.gms.ads.internal.util.zzbw.zza(new JSONObject((String) map.get(TJAdUnitConstants.String.VIDEO_INFO)));
            } catch (JSONException e) {
                zzcat.zzh("Failed to convert ad metadata to JSON.", e);
            }
        }
        if (bundleZza == null) {
            zzcat.zzg("Failed to convert ad metadata to Bundle.");
        } else {
            this.zza.zza(str, bundleZza);
        }
    }
}
