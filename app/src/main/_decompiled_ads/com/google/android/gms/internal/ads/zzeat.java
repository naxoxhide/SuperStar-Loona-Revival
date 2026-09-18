package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeat implements zzbnt {
    zzeat() {
    }

    @Override // com.google.android.gms.internal.ads.zzbnt
    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzeau zzeauVar = (zzeau) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziY)).booleanValue()) {
            jSONObject2.put("ad_request_url", zzeauVar.zzd.zze());
            jSONObject2.put("ad_request_post_body", zzeauVar.zzd.zzd());
        }
        jSONObject2.put("base_url", zzeauVar.zzd.zzb());
        jSONObject2.put("signals", zzeauVar.zzc);
        jSONObject3.put("body", zzeauVar.zzb.zzc);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.client.zzay.zzb().zzi(zzeauVar.zzb.zzb));
        jSONObject3.put("response_code", zzeauVar.zzb.zza);
        jSONObject3.put("latency", zzeauVar.zzb.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzeauVar.zzd.zzg());
        return jSONObject;
    }
}
