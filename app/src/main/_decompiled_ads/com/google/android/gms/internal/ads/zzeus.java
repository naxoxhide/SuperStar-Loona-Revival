package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeus implements zzetv {
    private final AdvertisingIdClient.Info zza;
    private final String zzb;
    private final zzfpt zzc;

    public zzeus(AdvertisingIdClient.Info info, String str, zzfpt zzfptVar) {
        this.zza = info;
        this.zzb = str;
        this.zzc = zzfptVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetv
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            JSONObject jSONObjectZzf = com.google.android.gms.ads.internal.util.zzbw.zzf((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                String str = this.zzb;
                if (str != null) {
                    jSONObjectZzf.put("pdid", str);
                    jSONObjectZzf.put("pdidtype", "ssaid");
                    return;
                }
                return;
            }
            jSONObjectZzf.put("rdid", this.zza.getId());
            jSONObjectZzf.put("is_lat", this.zza.isLimitAdTrackingEnabled());
            jSONObjectZzf.put("idtype", "adid");
            zzfpt zzfptVar = this.zzc;
            if (zzfptVar.zzc()) {
                jSONObjectZzf.put("paidv1_id_android_3p", zzfptVar.zzb());
                jSONObjectZzf.put("paidv1_creation_time_android_3p", this.zzc.zza());
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed putting Ad ID.", e);
        }
    }
}
