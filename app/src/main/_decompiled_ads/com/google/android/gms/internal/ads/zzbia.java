package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbia implements zzbjj {
    private final zzbib zza;

    public zzbia(zzbib zzbibVar) {
        this.zza = zzbibVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzcat.zzj("App event with no name parameter.");
        } else {
            this.zza.zzb(str, (String) map.get(TJAdUnitConstants.String.VIDEO_INFO));
        }
    }
}
