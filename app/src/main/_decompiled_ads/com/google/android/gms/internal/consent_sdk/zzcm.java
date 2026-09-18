package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@2.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcm {
    public String zza;
    public String zzb;
    public String zzc;
    public int zzf = 1;
    public List zzd = Collections.emptyList();
    public List zze = Collections.emptyList();
    public int zzg = 1;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:48:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:75:0x0109  */
    /* JADX WARN: Code duplicated, block: B:96:0x014f  */
    public static zzcm zza(JsonReader jsonReader) throws IOException {
        byte b2;
        byte b3;
        int i;
        zzcm zzcmVar = new zzcm();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int i2 = 4;
            int i3 = 3;
            switch (jsonReader.nextName()) {
                case "consent_signal":
                    String strNextString = jsonReader.nextString();
                    switch (strNextString) {
                        case "CONSENT_SIGNAL_UNKNOWN":
                            i2 = 1;
                            zzcmVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_PERSONALIZED_ADS":
                            i2 = 2;
                            zzcmVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_NON_PERSONALIZED_ADS":
                            i2 = 3;
                            zzcmVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_SUFFICIENT":
                            zzcmVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_COLLECT_CONSENT":
                            i2 = 5;
                            zzcmVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_NOT_REQUIRED":
                            i2 = 6;
                            zzcmVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_ERROR":
                            i2 = 7;
                            zzcmVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_PUBLISHER_MISCONFIGURATION":
                            i2 = 8;
                            zzcmVar.zzf = i2;
                            break;
                        default:
                            throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(String.valueOf(strNextString)));
                    }
                    break;
                case "consent_form_payload":
                    zzcmVar.zza = jsonReader.nextString();
                    break;
                case "consent_form_base_url":
                    zzcmVar.zzb = jsonReader.nextString();
                    break;
                case "error_message":
                    zzcmVar.zzc = jsonReader.nextString();
                    break;
                case "request_info_keys":
                    zzcmVar.zzd = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzcmVar.zzd.add(jsonReader.nextString());
                    }
                    jsonReader.endArray();
                    break;
                case "actions":
                    zzcmVar.zze = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzcl zzclVar = new zzcl();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName = jsonReader.nextName();
                            int iHashCode = strNextName.hashCode();
                            if (iHashCode != -2105551094) {
                                if (iHashCode == 1583758243 && strNextName.equals(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE)) {
                                    b2 = 0;
                                } else {
                                    b2 = -1;
                                }
                            } else if (strNextName.equals("args_json")) {
                                b2 = 1;
                            } else {
                                b2 = -1;
                            }
                            if (b2 == 0) {
                                String strNextString2 = jsonReader.nextString();
                                int iHashCode2 = strNextString2.hashCode();
                                if (iHashCode2 != 64208429) {
                                    if (iHashCode2 != 82862015) {
                                        if (iHashCode2 == 1856333582 && strNextString2.equals("UNKNOWN_ACTION_TYPE")) {
                                            b3 = 0;
                                        } else {
                                            b3 = -1;
                                        }
                                    } else if (strNextString2.equals("WRITE")) {
                                        b3 = 1;
                                    } else {
                                        b3 = -1;
                                    }
                                } else if (strNextString2.equals("CLEAR")) {
                                    b3 = 2;
                                } else {
                                    b3 = -1;
                                }
                                if (b3 == 0) {
                                    i = 1;
                                } else if (b3 == 1) {
                                    i = 2;
                                } else {
                                    if (b3 != 2) {
                                        throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.Action.ActionTypefrom: ".concat(String.valueOf(strNextString2)));
                                    }
                                    i = 3;
                                }
                                zzclVar.zzb = i;
                            } else if (b2 != 1) {
                                jsonReader.skipValue();
                            } else {
                                zzclVar.zza = jsonReader.nextString();
                            }
                        }
                        jsonReader.endObject();
                        zzcmVar.zze.add(zzclVar);
                    }
                    jsonReader.endArray();
                    break;
                case "privacy_options_required":
                    String strNextString3 = jsonReader.nextString();
                    int iHashCode3 = strNextString3.hashCode();
                    if (iHashCode3 != -1888946261) {
                        if (iHashCode3 != 389487519) {
                            if (iHashCode3 != 433141802 || !strNextString3.equals("UNKNOWN")) {
                            }
                        } else if (strNextString3.equals("REQUIRED")) {
                        }
                    } else if (strNextString3.equals("NOT_REQUIRED")) {
                    }
                    if (r7 == 0) {
                        i3 = 1;
                    } else if (r7 == 1) {
                        i3 = 2;
                    } else if (r7 != 2) {
                        throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.PrivacyOptionsRequirementStatusfrom: ".concat(String.valueOf(strNextString3)));
                    }
                    zzcmVar.zzg = i3;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return zzcmVar;
    }
}
