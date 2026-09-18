package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfia {
    private final HashMap zza;
    private final zzfig zzb;

    private zzfia() {
        HashMap map = new HashMap();
        this.zza = map;
        this.zzb = new zzfig(com.google.android.gms.ads.internal.zzt.zzB());
        map.put("new_csi", "1");
    }

    public static zzfia zzb(String str) {
        zzfia zzfiaVar = new zzfia();
        zzfiaVar.zza.put("action", str);
        return zzfiaVar;
    }

    public static zzfia zzc(String str) {
        zzfia zzfiaVar = new zzfia();
        zzfiaVar.zza.put(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str);
        return zzfiaVar;
    }

    public final zzfia zza(String str, String str2) {
        this.zza.put(str, str2);
        return this;
    }

    public final zzfia zzd(String str) {
        this.zzb.zzb(str);
        return this;
    }

    public final zzfia zze(String str, String str2) {
        this.zzb.zzc(str, str2);
        return this;
    }

    public final zzfia zzf(zzfcr zzfcrVar) {
        this.zza.put("aai", zzfcrVar.zzy);
        return this;
    }

    public final zzfia zzg(zzfcv zzfcvVar) {
        if (!TextUtils.isEmpty(zzfcvVar.zzb)) {
            this.zza.put("gqi", zzfcvVar.zzb);
        }
        return this;
    }

    public final zzfia zzh(zzfde zzfdeVar, zzcag zzcagVar) {
        zzfdd zzfddVar = zzfdeVar.zzb;
        zzg(zzfddVar.zzb);
        if (!zzfddVar.zza.isEmpty()) {
            switch (((zzfcr) zzfddVar.zza.get(0)).zzb) {
                case 1:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, ReportUtil.INVENTORY_TYPE_BANNER);
                    break;
                case 2:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, ReportUtil.INVENTORY_TYPE_INTERSTITIAL);
                    break;
                case 3:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    if (zzcagVar != null) {
                        this.zza.put("as", true != zzcagVar.zzm() ? "0" : "1");
                    }
                    break;
                default:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "unknown");
                    break;
            }
        }
        return this;
    }

    public final zzfia zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final Map zzj() {
        HashMap map = new HashMap(this.zza);
        for (zzfif zzfifVar : this.zzb.zza()) {
            map.put(zzfifVar.zza, zzfifVar.zzb);
        }
        return map;
    }
}
