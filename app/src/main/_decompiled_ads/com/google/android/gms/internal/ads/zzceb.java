package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzceb implements zzbjj {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                com.google.android.gms.ads.internal.client.zzay.zzb();
                i = zzcam.zzx(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                zzcat.zzj("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Parse pixels for " + str + ", got string " + str2 + ", int " + i + ".");
        }
        return i;
    }

    private static void zzc(zzccq zzccqVar, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzccqVar.zzB(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzcat.zzj(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzccqVar.zzA(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzccqVar.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzccqVar.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzccqVar.zzD(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int iMin;
        int iMin2;
        Integer numValueOf;
        zzcdc zzcdcVar = (zzcdc) obj;
        String str = (String) map.get("action");
        if (str == null) {
            zzcat.zzj("Action missing from video GMSG.");
            return;
        }
        Integer numValueOf2 = map.containsKey("playerId") ? Integer.valueOf(Integer.parseInt((String) map.get("playerId"))) : null;
        Integer numZzb = zzcdcVar.zzo() != null ? zzcdcVar.zzo().zzb() : null;
        int i = 0;
        if (numValueOf2 != null && numZzb != null && !numValueOf2.equals(numZzb) && !str.equals("load")) {
            zzcat.zzi(String.format(Locale.US, "Event intended for player %s, but sent to player %d - event ignored", numValueOf2, numZzb));
            return;
        }
        if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzcat.zze("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzcat.zzj("Color parameter missing from background video GMSG.");
                return;
            }
            try {
                zzcdcVar.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                zzcat.zzj("Invalid color parameter in background video GMSG.");
                return;
            }
        }
        if ("playerBackground".equals(str)) {
            String str3 = (String) map.get("color");
            if (TextUtils.isEmpty(str3)) {
                zzcat.zzj("Color parameter missing from playerBackground video GMSG.");
                return;
            }
            try {
                zzcdcVar.zzB(Color.parseColor(str3));
                return;
            } catch (IllegalArgumentException unused2) {
                zzcat.zzj("Invalid color parameter in playerBackground video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str4 = (String) map.get("mimeTypes");
            if (str4 == null) {
                zzcat.zzj("No MIME types specified for decoder properties inspection.");
                HashMap map2 = new HashMap();
                map2.put("event", "decoderProps");
                map2.put("error", "missingMimeTypes");
                zzcdcVar.zzd("onVideoEvent", map2);
                return;
            }
            HashMap map3 = new HashMap();
            String[] strArrSplit = str4.split(",");
            int length = strArrSplit.length;
            while (i < length) {
                String str5 = strArrSplit[i];
                map3.put(str5, com.google.android.gms.ads.internal.util.zzcn.zza(str5.trim()));
                i++;
            }
            HashMap map4 = new HashMap();
            map4.put("event", "decoderProps");
            map4.put("mimeTypes", map3);
            zzcdcVar.zzd("onVideoEvent", map4);
            return;
        }
        zzccr zzccrVarZzo = zzcdcVar.zzo();
        if (zzccrVarZzo == null) {
            zzcat.zzj("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean zEquals = "new".equals(str);
        boolean zEquals2 = "position".equals(str);
        if (zEquals || zEquals2) {
            Context context = zzcdcVar.getContext();
            int iZzb = zzb(context, map, "x", 0);
            int iZzb2 = zzb(context, map, "y", 0);
            int iZzb3 = zzb(context, map, "w", -1);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdH)).booleanValue()) {
                iMin = iZzb3 == -1 ? zzcdcVar.zzh() : Math.min(iZzb3, zzcdcVar.zzh());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Calculate width with original width " + iZzb3 + ", videoHost.getVideoBoundingWidth() " + zzcdcVar.zzh() + ", x " + iZzb + ".");
                }
                iMin = Math.min(iZzb3, zzcdcVar.zzh() - iZzb);
            }
            int iZzb4 = zzb(context, map, "h", -1);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdH)).booleanValue()) {
                iMin2 = iZzb4 == -1 ? zzcdcVar.zzg() : Math.min(iZzb4, zzcdcVar.zzg());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Calculate height with original height " + iZzb4 + ", videoHost.getVideoBoundingHeight() " + zzcdcVar.zzg() + ", y " + iZzb2 + ".");
                }
                iMin2 = Math.min(iZzb4, zzcdcVar.zzg() - iZzb2);
            }
            try {
                i = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused3) {
            }
            int i2 = i;
            boolean z = Boolean.parseBoolean((String) map.get("spherical"));
            if (!zEquals || zzccrVarZzo.zza() != null) {
                zzccrVarZzo.zzc(iZzb, iZzb2, iMin, iMin2);
                return;
            }
            zzccrVarZzo.zzd(iZzb, iZzb2, iMin, iMin2, i2, z, new zzcdb((String) map.get("flags")));
            zzccq zzccqVarZza = zzccrVarZzo.zza();
            if (zzccqVarZza != null) {
                zzc(zzccqVarZza, map);
                return;
            }
            return;
        }
        zzcgx zzcgxVarZzq = zzcdcVar.zzq();
        if (zzcgxVarZzq != null) {
            if ("timeupdate".equals(str)) {
                String str6 = (String) map.get(TJAdUnitConstants.String.VIDEO_CURRENT_TIME);
                if (str6 == null) {
                    zzcat.zzj("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    zzcgxVarZzq.zzt(Float.parseFloat(str6));
                    return;
                } catch (NumberFormatException unused4) {
                    zzcat.zzj("Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str6));
                    return;
                }
            }
            if ("skip".equals(str)) {
                zzcgxVarZzq.zzu();
                return;
            }
        }
        zzccq zzccqVarZza2 = zzccrVarZzo.zza();
        if (zzccqVarZza2 == null) {
            HashMap map5 = new HashMap();
            map5.put("event", "no_video_view");
            zzcdcVar.zzd("onVideoEvent", map5);
            return;
        }
        if ("click".equals(str)) {
            Context context2 = zzcdcVar.getContext();
            int iZzb5 = zzb(context2, map, "x", 0);
            float fZzb = zzb(context2, map, "y", 0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iZzb5, fZzb, 0);
            zzccqVarZza2.zzx(motionEventObtain);
            motionEventObtain.recycle();
            return;
        }
        if (TJAdUnitConstants.String.VIDEO_CURRENT_TIME.equals(str)) {
            String str7 = (String) map.get("time");
            if (str7 == null) {
                zzcat.zzj("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzccqVarZza2.zzw((int) (Float.parseFloat(str7) * 1000.0f));
                return;
            } catch (NumberFormatException unused5) {
                zzcat.zzj("Could not parse time parameter from currentTime video GMSG: ".concat(str7));
                return;
            }
        }
        if ("hide".equals(str)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzG)).booleanValue()) {
                zzccqVarZza2.setVisibility(8);
                return;
            } else {
                zzccqVarZza2.setVisibility(4);
                return;
            }
        }
        if ("load".equals(str)) {
            zzccqVarZza2.zzr(numValueOf2);
            return;
        }
        if ("loadControl".equals(str)) {
            zzc(zzccqVarZza2, map);
            return;
        }
        if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzccqVarZza2.zzs();
                return;
            } else {
                zzccqVarZza2.zzI();
                return;
            }
        }
        if (CampaignEx.JSON_NATIVE_VIDEO_PAUSE.equals(str)) {
            zzccqVarZza2.zzu();
            return;
        }
        if ("play".equals(str)) {
            zzccqVarZza2.zzv();
            return;
        }
        if (TJAdUnitConstants.String.BEACON_SHOW_PATH.equals(str)) {
            zzccqVarZza2.setVisibility(0);
            return;
        }
        if ("src".equals(str)) {
            String str8 = (String) map.get("src");
            if (map.containsKey("periodicReportIntervalMs")) {
                try {
                    numValueOf = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
                } catch (NumberFormatException unused6) {
                    zzcat.zzj("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map.get("periodicReportIntervalMs"))));
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
            String[] strArr = {str8};
            String str9 = (String) map.get("demuxed");
            if (str9 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str9);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        strArr2[i3] = jSONArray.getString(i3);
                    }
                    strArr = strArr2;
                } catch (JSONException unused7) {
                    zzcat.zzj("Malformed demuxed URL list for playback: ".concat(str9));
                    strArr = new String[]{str8};
                }
            }
            if (numValueOf != null) {
                zzcdcVar.zzA(numValueOf.intValue());
            }
            zzccqVarZza2.zzE(str8, strArr);
            return;
        }
        if ("touchMove".equals(str)) {
            Context context3 = zzcdcVar.getContext();
            zzccqVarZza2.zzH(zzb(context3, map, "dx", 0), zzb(context3, map, "dy", 0));
            if (this.zza) {
                return;
            }
            zzcdcVar.zzu();
            this.zza = true;
            return;
        }
        if (!TapjoyConstants.TJC_VOLUME.equals(str)) {
            if (MBridgeConstans.EXTRA_KEY_WM.equals(str)) {
                zzccqVarZza2.zzn();
                return;
            } else {
                zzcat.zzj("Unknown video action: ".concat(str));
                return;
            }
        }
        String str10 = (String) map.get(TapjoyConstants.TJC_VOLUME);
        if (str10 == null) {
            zzcat.zzj("Level parameter missing from volume video GMSG.");
            return;
        }
        try {
            zzccqVarZza2.zzG(Float.parseFloat(str10));
        } catch (NumberFormatException unused8) {
            zzcat.zzj("Could not parse volume parameter from volume video GMSG: ".concat(str10));
        }
    }
}
