package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfcv {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final long zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzfct zzi;
    public final Bundle zzj;
    public final String zzk;
    public final String zzl;
    public final String zzm;
    public final JSONObject zzn;
    public final String zzo;
    public final int zzp;

    zzfcv(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        List listEmptyList = Collections.emptyList();
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        jsonReader.beginObject();
        int iNextInt = 0;
        String str = "";
        String strNextString = str;
        String strNextString2 = strNextString;
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String strNextString5 = strNextString4;
        String strNextString6 = strNextString5;
        zzfct zzfctVar = null;
        long jNextLong = 0;
        int iMax = 1;
        int iNextInt2 = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            String strNextString7 = str;
            if ("nofill_urls".equals(strNextName)) {
                listEmptyList = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
            } else if ("refresh_interval".equals(strNextName)) {
                iNextInt = jsonReader.nextInt();
            } else if ("gws_query_id".equals(strNextName)) {
                strNextString = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(strNextName)) {
                strNextString2 = jsonReader.nextString();
            } else if ("is_idless".equals(strNextName)) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if ("response_code".equals(strNextName)) {
                iNextInt2 = jsonReader.nextInt();
            } else if ("latency".equals(strNextName)) {
                jNextLong = jsonReader.nextLong();
            } else {
                JSONObject jSONObject2 = jSONObject;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzib)).booleanValue() && "public_error".equals(strNextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzfctVar = new zzfct(jsonReader);
                } else if ("bidding_data".equals(strNextName)) {
                    strNextString3 = jsonReader.nextString();
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjC)).booleanValue() && zzfcu.zza(strNextName, "topics_should_record_observation")) {
                        jsonReader.nextBoolean();
                    } else if ("adapter_response_replacement_key".equals(strNextName)) {
                        strNextString7 = jsonReader.nextString();
                    } else {
                        if ("response_info_extras".equals(strNextName)) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgM)).booleanValue()) {
                                try {
                                    Bundle bundleZza = com.google.android.gms.ads.internal.util.zzbw.zza(com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader));
                                    if (bundleZza != null) {
                                        bundle = bundleZza;
                                    }
                                } catch (IOException | JSONException unused) {
                                    jSONObject = jSONObject2;
                                } catch (IllegalStateException unused2) {
                                    jsonReader.skipValue();
                                    jSONObject = jSONObject2;
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if ("adRequestPostBody".equals(strNextName)) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziY)).booleanValue()) {
                                strNextString5 = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if ("adRequestUrl".equals(strNextName)) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziY)).booleanValue()) {
                                strNextString4 = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziZ)).booleanValue() && zzfcu.zza(strNextName, "adResponseBody")) {
                                strNextString6 = jsonReader.nextString();
                            } else {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziZ)).booleanValue() && zzfcu.zza(strNextName, "adResponseHeaders")) {
                                    jSONObject = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
                                } else {
                                    if (zzfcu.zza(strNextName, "max_parallel_renderers")) {
                                        iMax = Math.max(1, jsonReader.nextInt());
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                    jSONObject = jSONObject2;
                                }
                            }
                        }
                        str = strNextString7;
                    }
                    jSONObject = jSONObject2;
                    str = strNextString7;
                }
                jSONObject = jSONObject2;
            }
            str = strNextString7;
        }
        jsonReader.endObject();
        this.zza = listEmptyList;
        this.zzc = iNextInt;
        this.zzb = strNextString;
        this.zzd = strNextString2;
        this.zze = iNextInt2;
        this.zzf = jNextLong;
        this.zzi = zzfctVar;
        this.zzg = zNextBoolean;
        this.zzh = strNextString3;
        this.zzj = bundle;
        this.zzk = strNextString4;
        this.zzl = strNextString5;
        this.zzm = strNextString6;
        this.zzn = jSONObject;
        this.zzo = str;
        this.zzp = ((Long) zzbeg.zza.zze()).longValue() > 0 ? ((Long) zzbeg.zza.zze()).intValue() : iMax;
    }
}
