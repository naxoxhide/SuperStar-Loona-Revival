package com.google.android.gms.internal.ads;

import com.adxcorp.ads.mediation.util.ReportUtil;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdhu implements zzhbc {
    private final zzhbp zza;

    public zzdhu(zzhbp zzhbpVar) {
        this.zza = zzhbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((zzdhr) this.zza).zza().zze() != null ? Collections.singleton(ReportUtil.INVENTORY_TYPE_BANNER) : Collections.emptySet();
        zzhbk.zzb(setSingleton);
        return setSingleton;
    }
}
