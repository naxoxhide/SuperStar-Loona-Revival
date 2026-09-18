package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdts {
    private Long zza;
    private final String zzb;
    private String zzc;
    private Integer zzd;
    private String zze;
    private Integer zzf;

    /* synthetic */ zzdts(String str, zzdtr zzdtrVar) {
        this.zzb = str;
    }

    static /* bridge */ /* synthetic */ String zza(zzdts zzdtsVar) {
        String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjr);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdtsVar.zza);
            jSONObject.put("eventCategory", zzdtsVar.zzb);
            jSONObject.putOpt("event", zzdtsVar.zzc);
            jSONObject.putOpt("errorCode", zzdtsVar.zzd);
            jSONObject.putOpt("rewardType", zzdtsVar.zze);
            jSONObject.putOpt("rewardAmount", zzdtsVar.zzf);
        } catch (JSONException unused) {
            zzcat.zzj("Could not convert parameters to JSON.");
        }
        return str + "(\"h5adsEvent\"," + jSONObject.toString() + ");";
    }
}
