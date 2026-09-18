package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcnj {
    private final Map zza;
    private final Map zzb;

    zzcnj(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfde zzfdeVar) throws Exception {
        for (zzfdc zzfdcVar : zzfdeVar.zzb.zzc) {
            if (this.zza.containsKey(zzfdcVar.zza)) {
                ((zzcnm) this.zza.get(zzfdcVar.zza)).zza(zzfdcVar.zzb);
            } else if (this.zzb.containsKey(zzfdcVar.zza)) {
                zzcnl zzcnlVar = (zzcnl) this.zzb.get(zzfdcVar.zza);
                JSONObject jSONObject = zzfdcVar.zzb;
                HashMap map = new HashMap();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString = jSONObject.optString(next);
                    if (strOptString != null) {
                        map.put(next, strOptString);
                    }
                }
                zzcnlVar.zza(map);
            }
        }
    }
}
