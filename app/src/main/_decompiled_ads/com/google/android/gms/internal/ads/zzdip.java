package com.google.android.gms.internal.ads;

import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdip implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;

    public zzdip(zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcaz zzcazVarZza = ((zzcio) this.zza).zza();
        com.google.android.gms.ads.internal.zzt.zzp();
        return new zzaus(UUID.randomUUID().toString(), zzcazVarZza, "native", new JSONObject(), false, true);
    }
}
