package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzehh implements zzeew {
    private final zzdqj zza;

    public zzehh(zzdqj zzdqjVar) {
        this.zza = zzdqjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeew
    public final zzeex zza(String str, JSONObject jSONObject) throws zzfds {
        return new zzeex(this.zza.zzc(str, jSONObject), new zzegq(), str);
    }
}
