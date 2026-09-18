package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdik implements zzhbc {
    private final zzdii zza;

    public zzdik(zzdii zzdiiVar) {
        this.zza = zzdiiVar;
    }

    public final JSONObject zza() {
        JSONObject jSONObjectZzb = this.zza.zzb();
        zzhbk.zzb(jSONObjectZzb);
        return jSONObjectZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* synthetic */ Object zzb() {
        JSONObject jSONObjectZzb = this.zza.zzb();
        zzhbk.zzb(jSONObjectZzb);
        return jSONObjectZzb;
    }
}
