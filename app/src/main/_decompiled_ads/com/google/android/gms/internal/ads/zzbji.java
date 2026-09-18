package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbji {
    public static final zzbjj zza = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbig
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzchc zzchcVar = (zzchc) obj;
            zzbjj zzbjjVar = zzbji.zza;
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzcat.zzj("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] strArrSplit = str.split(",");
            HashMap map2 = new HashMap();
            PackageManager packageManager = zzchcVar.getContext().getPackageManager();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(";", 2);
                boolean z = true;
                if (packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) == null) {
                    z = false;
                }
                Boolean boolValueOf = Boolean.valueOf(z);
                map2.put(str2, boolValueOf);
                com.google.android.gms.ads.internal.util.zze.zza("/canOpenURLs;" + str2 + ";" + boolValueOf);
            }
            ((zzbmd) zzchcVar).zzd("openableURLs", map2);
        }
    };
    public static final zzbjj zzb = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbii
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzchc zzchcVar = (zzchc) obj;
            zzbjj zzbjjVar = zzbji.zza;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhY)).booleanValue()) {
                zzcat.zzj("canOpenAppGmsgHandler disabled.");
                return;
            }
            String str = (String) map.get(CampaignEx.JSON_KEY_PACKAGE_NAME);
            if (TextUtils.isEmpty(str)) {
                zzcat.zzj("Package name missing in canOpenApp GMSG.");
                return;
            }
            HashMap map2 = new HashMap();
            Boolean boolValueOf = Boolean.valueOf(zzchcVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
            map2.put(str, boolValueOf);
            com.google.android.gms.ads.internal.util.zze.zza("/canOpenApp;" + str + ";" + boolValueOf);
            ((zzbmd) zzchcVar).zzd("openableApp", map2);
        }
    };
    public static final zzbjj zzc = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbil
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzbji.zzb((zzchc) obj, map);
        }
    };
    public static final zzbjj zzd = new zzbja();
    public static final zzbjj zze = new zzbjb();
    public static final zzbjj zzf = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbim
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzchc zzchcVar = (zzchc) obj;
            zzbjj zzbjjVar = zzbji.zza;
            String str = (String) map.get("u");
            if (str == null) {
                zzcat.zzj("URL missing from httpTrack GMSG.");
            } else {
                new com.google.android.gms.ads.internal.util.zzca(zzchcVar.getContext(), ((zzchk) zzchcVar).zzn().zza, str).zzb();
            }
        }
    };
    public static final zzbjj zzg = new zzbjc();
    public static final zzbjj zzh = new zzbjd();
    public static final zzbjj zzi = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbik
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzchj zzchjVar = (zzchj) obj;
            zzbjj zzbjjVar = zzbji.zza;
            String str = (String) map.get("tx");
            String str2 = (String) map.get("ty");
            String str3 = (String) map.get("td");
            try {
                int i = Integer.parseInt(str);
                int i2 = Integer.parseInt(str2);
                int i3 = Integer.parseInt(str3);
                zzaro zzaroVarZzI = zzchjVar.zzI();
                if (zzaroVarZzI != null) {
                    zzaroVarZzI.zzc().zzl(i, i2, i3);
                }
            } catch (NumberFormatException unused) {
                zzcat.zzj("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzbjj zzj = new zzbje();
    public static final zzbjj zzk = new zzbjf();
    public static final zzbjj zzl = new zzceb();
    public static final zzbjj zzm = new zzcec();
    public static final zzbjj zzn = new zzbic();
    public static final zzbjy zzo = new zzbjy();
    public static final zzbjj zzp = new zzbjg();
    public static final zzbjj zzq = new zzbjh();
    public static final zzbjj zzr = new zzbin();
    public static final zzbjj zzs = new zzbio();
    public static final zzbjj zzt = new zzbip();
    public static final zzbjj zzu = new zzbiq();
    public static final zzbjj zzv = new zzbir();
    public static final zzbjj zzw = new zzbis();
    public static final zzbjj zzx = new zzbit();
    public static final zzbjj zzy = new zzbiu();
    public static final zzbjj zzz = new zzbiv();
    public static final zzbjj zzA = new zzbiw();
    public static final zzbjj zzB = new zzbiy();
    public static final zzbjj zzC = new zzbiz();

    public static ListenableFuture zza(zzcgb zzcgbVar, String str) {
        Uri uriZza = Uri.parse(str);
        try {
            zzaro zzaroVarZzI = zzcgbVar.zzI();
            if (zzaroVarZzI != null && zzaroVarZzI.zzf(uriZza)) {
                uriZza = zzaroVarZzI.zza(uriZza, zzcgbVar.getContext(), zzcgbVar.zzF(), zzcgbVar.zzi());
            }
        } catch (zzarp unused) {
            zzcat.zzj("Unable to append parameter to URL: ".concat(str));
        }
        final String strZzb = zzbza.zzb(uriZza, zzcgbVar.getContext());
        long jLongValue = ((Long) zzbea.zze.zze()).longValue();
        return (jLongValue <= 0 || jLongValue > 233702200) ? zzfzt.zzh(strZzb) : zzfzt.zze(zzfzt.zzm(zzfzt.zze(zzfzk.zzu(zzcgbVar.zzR()), Throwable.class, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzbid
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbjj zzbjjVar = zzbji.zza;
                if (!((Boolean) zzbea.zzk.zze()).booleanValue()) {
                    return "failure_click_attok";
                }
                com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "prepareClickUrl.attestation1");
                return "failure_click_attok";
            }
        }, zzcbg.zzf), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzbie
            /* JADX WARN: Code duplicated, block: B:16:0x004f  */
            /* JADX WARN: Code duplicated, block: B:19:0x0059  */
            /* JADX WARN: Code duplicated, block: B:21:0x0067  */
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                String str2;
                String str3;
                Uri uri;
                String str4 = (String) obj;
                zzbjj zzbjjVar = zzbji.zza;
                String strReplace = strZzb;
                if (str4 != null) {
                    if (((Boolean) zzbea.zzf.zze()).booleanValue()) {
                        String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                        String host = Uri.parse(strReplace).getHost();
                        for (int i = 0; i < 3; i++) {
                            if (host.endsWith(strArr[i])) {
                                str2 = (String) zzbea.zza.zze();
                                str3 = (String) zzbea.zzb.zze();
                                if (!TextUtils.isEmpty(str2)) {
                                    strReplace = strReplace.replace(str2, str4);
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                    uri = Uri.parse(strReplace);
                                    if (!TextUtils.isEmpty(uri.getQueryParameter(str3))) {
                                        break;
                                    }
                                    return uri.buildUpon().appendQueryParameter(str3, str4).toString();
                                }
                                break;
                            }
                        }
                    } else {
                        str2 = (String) zzbea.zza.zze();
                        str3 = (String) zzbea.zzb.zze();
                        if (!TextUtils.isEmpty(str2)) {
                            strReplace = strReplace.replace(str2, str4);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            uri = Uri.parse(strReplace);
                            if (!TextUtils.isEmpty(uri.getQueryParameter(str3))) {
                                return uri.buildUpon().appendQueryParameter(str3, str4).toString();
                            }
                        }
                    }
                }
                return strReplace;
            }
        }, zzcbg.zzf), Throwable.class, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzbif
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbjj zzbjjVar = zzbji.zza;
                if (((Boolean) zzbea.zzk.zze()).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "prepareClickUrl.attestation2");
                }
                return strZzb;
            }
        }, zzcbg.zzf);
    }

    static /* synthetic */ void zzb(zzchc zzchcVar, Map map) {
        Intent uri;
        PackageManager packageManager = zzchcVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String strOptString = jSONObject2.optString("id");
                        String strOptString2 = jSONObject2.optString("u");
                        String strOptString3 = jSONObject2.optString("i");
                        String strOptString4 = jSONObject2.optString(InneractiveMediationDefs.GENDER_MALE);
                        String strOptString5 = jSONObject2.optString("p");
                        String strOptString6 = jSONObject2.optString("c");
                        String strOptString7 = jSONObject2.optString("intent_url");
                        ResolveInfo resolveInfoResolveActivity = null;
                        if (TextUtils.isEmpty(strOptString7)) {
                            uri = null;
                        } else {
                            try {
                                uri = Intent.parseUri(strOptString7, 0);
                            } catch (URISyntaxException e) {
                                zzcat.zzh("Error parsing the url: ".concat(String.valueOf(strOptString7)), e);
                                uri = null;
                            }
                        }
                        if (uri == null) {
                            uri = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                uri.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                uri.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                uri.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                uri.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split(RemoteSettings.FORWARD_SLASH_STRING, 2);
                                if (strArrSplit.length == 2) {
                                    uri.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                        }
                        Intent intent = uri;
                        try {
                            resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
                        } catch (NullPointerException e2) {
                            com.google.android.gms.ads.internal.zzt.zzo().zzu(e2, intent.toString());
                        }
                        try {
                            jSONObject.put(strOptString, resolveInfoResolveActivity != null);
                        } catch (JSONException e3) {
                            zzcat.zzh("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        zzcat.zzh("Error parsing the intent data.", e4);
                    }
                }
                ((zzbmd) zzchcVar).zze("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzbmd) zzchcVar).zze("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzbmd) zzchcVar).zze("openableIntents", new JSONObject());
        }
    }

    public static void zzc(Map map, zzdfd zzdfdVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjT)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("1") && zzdfdVar != null) {
            zzdfdVar.zzbK();
        }
    }
}
