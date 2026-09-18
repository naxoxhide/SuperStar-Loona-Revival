package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcnw implements zzcnm {
    private final zzdvm zza;

    zzcnw(zzdvm zzdvmVar) {
        this.zza = zzdvmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcnm
    public final void zza(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziV)).booleanValue()) {
                this.zza.zzm(jSONObject);
            }
        }
    }
}
