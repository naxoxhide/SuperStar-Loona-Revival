package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdgp implements zzhbc {
    private final zzhbp zza;

    public zzdgp(zzhbp zzhbpVar) {
        this.zza = zzhbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdev((zzdhi) this.zza.zzb(), zzcbg.zzf));
        zzhbk.zzb(setSingleton);
        return setSingleton;
    }
}
