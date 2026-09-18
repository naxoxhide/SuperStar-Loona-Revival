package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.JsonReader;
import com.google.android.gms.ads.RequestConfiguration;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdtv extends zzbkj {
    private final zzdty zza;
    private final zzdtt zzb;
    private final Map zzc = new HashMap();

    zzdtv(zzdty zzdtyVar, zzdtt zzdttVar) {
        this.zza = zzdtyVar;
        this.zzb = zzdttVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0081  */
    private static com.google.android.gms.ads.internal.client.zzl zzc(Map map) {
        com.google.android.gms.ads.internal.client.zzm zzmVar = new com.google.android.gms.ads.internal.client.zzm();
        String str = (String) map.get("ad_request");
        if (str == null) {
            return zzmVar.zza();
        }
        JsonReader jsonReader = new JsonReader(new StringReader(Uri.decode(str)));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "extras":
                        jsonReader.beginObject();
                        Bundle bundle = new Bundle();
                        while (jsonReader.hasNext()) {
                            bundle.putString(jsonReader.nextName(), jsonReader.nextString());
                        }
                        jsonReader.endObject();
                        zzmVar.zzb(bundle);
                        break;
                    case "keywords":
                        jsonReader.beginArray();
                        ArrayList arrayList = new ArrayList();
                        while (jsonReader.hasNext()) {
                            arrayList.add(jsonReader.nextString());
                        }
                        jsonReader.endArray();
                        zzmVar.zze(arrayList);
                        break;
                    case "isTestDevice":
                        zzmVar.zzd(jsonReader.nextBoolean());
                        break;
                    case "tagForChildDirectedTreatment":
                        if (!jsonReader.nextBoolean()) {
                            zzmVar.zzg(0);
                            break;
                        } else {
                            zzmVar.zzg(1);
                            break;
                        }
                        break;
                    case "tagForUnderAgeOfConsent":
                        if (!jsonReader.nextBoolean()) {
                            zzmVar.zzh(0);
                            break;
                        } else {
                            zzmVar.zzh(1);
                            break;
                        }
                        break;
                    case "maxAdContentRating":
                        String strNextString = jsonReader.nextString();
                        if (!RequestConfiguration.zza.contains(strNextString)) {
                            break;
                        } else {
                            zzmVar.zzf(strNextString);
                            break;
                        }
                        break;
                    case "httpTimeoutMillis":
                        zzmVar.zzc(jsonReader.nextInt());
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (IOException unused) {
            zzcat.zze("Ad Request json was malformed, parsing ended early.");
        }
        com.google.android.gms.ads.internal.client.zzl zzlVarZza = zzmVar.zza();
        Bundle bundle2 = zzlVarZza.zzm.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle2 == null) {
            bundle2 = zzlVarZza.zzc;
            zzlVarZza.zzm.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundle2);
        }
        return new com.google.android.gms.ads.internal.client.zzl(zzlVarZza.zza, zzlVarZza.zzb, bundle2, zzlVarZza.zzd, zzlVarZza.zze, zzlVarZza.zzf, zzlVarZza.zzg, zzlVarZza.zzh, zzlVarZza.zzi, zzlVarZza.zzj, zzlVarZza.zzk, zzlVarZza.zzl, zzlVarZza.zzm, zzlVarZza.zzn, zzlVarZza.zzo, zzlVarZza.zzp, zzlVarZza.zzq, zzlVarZza.zzr, zzlVarZza.zzs, zzlVarZza.zzt, zzlVarZza.zzu, zzlVarZza.zzv, zzlVarZza.zzw, zzlVarZza.zzx, zzlVarZza.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzbkk
    public final void zze() {
        this.zzc.clear();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    @Override // com.google.android.gms.internal.ads.zzbkk
    public final void zzf(String str) throws RemoteException {
        byte b2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjo)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received H5 gmsg: ".concat(String.valueOf(str)));
            Uri uri = Uri.parse(str);
            com.google.android.gms.ads.internal.zzt.zzp();
            Map mapZzO = com.google.android.gms.ads.internal.util.zzt.zzO(uri);
            String str2 = (String) mapZzO.get("action");
            if (TextUtils.isEmpty(str2)) {
                zzcat.zze("H5 gmsg did not contain an action");
                return;
            }
            int iHashCode = str2.hashCode();
            if (iHashCode != 579053441) {
                if (iHashCode == 871091088 && str2.equals(MobileAdsBridgeBase.initializeMethodName)) {
                    b2 = 0;
                } else {
                    b2 = -1;
                }
            } else if (str2.equals("dispose_all")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
            if (b2 == 0) {
                this.zzc.clear();
                this.zzb.zza();
                return;
            }
            if (b2 == 1) {
                Iterator it = this.zzc.values().iterator();
                while (it.hasNext()) {
                    ((zzdto) it.next()).zza();
                }
                this.zzc.clear();
                return;
            }
            String str3 = (String) mapZzO.get("obj_id");
            try {
                str3.getClass();
                long j = Long.parseLong(str3);
                switch (str2) {
                    case "create_interstitial_ad":
                        if (this.zzc.size() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjp)).intValue()) {
                            zzcat.zzj("Could not create H5 ad, too many existing objects");
                            this.zzb.zzi(j);
                            break;
                        } else {
                            Map map = this.zzc;
                            Long lValueOf = Long.valueOf(j);
                            if (!map.containsKey(lValueOf)) {
                                String str4 = (String) mapZzO.get("ad_unit");
                                if (!TextUtils.isEmpty(str4)) {
                                    zzdtp zzdtpVarZzb = this.zza.zzb();
                                    zzdtpVarZzb.zzb(j);
                                    zzdtpVarZzb.zza(str4);
                                    this.zzc.put(lValueOf, zzdtpVarZzb.zzc().zza());
                                    this.zzb.zzh(j);
                                    com.google.android.gms.ads.internal.util.zze.zza("Created H5 interstitial #" + j + " with ad unit " + str4);
                                } else {
                                    zzcat.zzj("Could not create H5 ad, missing ad unit id");
                                    this.zzb.zzi(j);
                                }
                            } else {
                                zzcat.zze("Could not create H5 ad, object ID already exists");
                                this.zzb.zzi(j);
                            }
                            break;
                        }
                        break;
                    case "load_interstitial_ad":
                        zzdto zzdtoVar = (zzdto) this.zzc.get(Long.valueOf(j));
                        if (zzdtoVar == null) {
                            zzcat.zze("Could not load H5 ad, object ID does not exist");
                            this.zzb.zzf(j);
                            break;
                        } else {
                            zzdtoVar.zzb(zzc(mapZzO));
                            break;
                        }
                        break;
                    case "show_interstitial_ad":
                        zzdto zzdtoVar2 = (zzdto) this.zzc.get(Long.valueOf(j));
                        if (zzdtoVar2 == null) {
                            zzcat.zze("Could not show H5 ad, object ID does not exist");
                            this.zzb.zzf(j);
                            break;
                        } else {
                            zzdtoVar2.zzc();
                            break;
                        }
                        break;
                    case "create_rewarded_ad":
                        if (this.zzc.size() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjp)).intValue()) {
                            zzcat.zzj("Could not create H5 ad, too many existing objects");
                            this.zzb.zzi(j);
                            break;
                        } else {
                            Map map2 = this.zzc;
                            Long lValueOf2 = Long.valueOf(j);
                            if (!map2.containsKey(lValueOf2)) {
                                String str5 = (String) mapZzO.get("ad_unit");
                                if (!TextUtils.isEmpty(str5)) {
                                    zzdtp zzdtpVarZzb2 = this.zza.zzb();
                                    zzdtpVarZzb2.zzb(j);
                                    zzdtpVarZzb2.zza(str5);
                                    this.zzc.put(lValueOf2, zzdtpVarZzb2.zzc().zzb());
                                    this.zzb.zzh(j);
                                    com.google.android.gms.ads.internal.util.zze.zza("Created H5 rewarded #" + j + " with ad unit " + str5);
                                } else {
                                    zzcat.zzj("Could not create H5 ad, missing ad unit id");
                                    this.zzb.zzi(j);
                                }
                            } else {
                                zzcat.zze("Could not create H5 ad, object ID already exists");
                                this.zzb.zzi(j);
                            }
                            break;
                        }
                        break;
                    case "load_rewarded_ad":
                        zzdto zzdtoVar3 = (zzdto) this.zzc.get(Long.valueOf(j));
                        if (zzdtoVar3 == null) {
                            zzcat.zze("Could not load H5 ad, object ID does not exist");
                            this.zzb.zzq(j);
                            break;
                        } else {
                            zzdtoVar3.zzb(zzc(mapZzO));
                            break;
                        }
                        break;
                    case "show_rewarded_ad":
                        zzdto zzdtoVar4 = (zzdto) this.zzc.get(Long.valueOf(j));
                        if (zzdtoVar4 == null) {
                            zzcat.zze("Could not show H5 ad, object ID does not exist");
                            this.zzb.zzq(j);
                            break;
                        } else {
                            zzdtoVar4.zzc();
                            break;
                        }
                        break;
                    case "dispose":
                        Map map3 = this.zzc;
                        Long lValueOf3 = Long.valueOf(j);
                        zzdto zzdtoVar5 = (zzdto) map3.get(lValueOf3);
                        if (zzdtoVar5 == null) {
                            zzcat.zze("Could not dispose H5 ad, object ID does not exist");
                            break;
                        } else {
                            zzdtoVar5.zza();
                            this.zzc.remove(lValueOf3);
                            com.google.android.gms.ads.internal.util.zze.zza("Disposed H5 ad #" + j);
                            break;
                        }
                        break;
                    default:
                        zzcat.zze("H5 gmsg contained invalid action: ".concat(String.valueOf(str2)));
                        break;
                }
            } catch (NullPointerException | NumberFormatException unused) {
                zzcat.zze("H5 gmsg did not contain a valid object id: ".concat(String.valueOf(str3)));
            }
        }
    }
}
