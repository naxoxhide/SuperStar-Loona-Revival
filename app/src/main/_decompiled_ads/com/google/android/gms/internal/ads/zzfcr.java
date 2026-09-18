package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.common.primitives.SignedBytes;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import kotlin.io.encoding.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfcr {
    public final String zzA;
    public final String zzB;
    public final zzbxr zzC;
    public final String zzD;
    public final JSONObject zzE;
    public final JSONObject zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final String zzJ;
    public final String zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final int zzS;
    public final int zzT;
    public final boolean zzU;
    public final boolean zzV;
    public final String zzW;
    public final zzfdq zzX;
    public final boolean zzY;
    public final boolean zzZ;
    public final List zza;
    public final int zzaa;
    public final String zzab;
    public final int zzac;
    public final String zzad;
    public final boolean zzae;
    public final zzbtb zzaf;
    public final com.google.android.gms.ads.internal.client.zzs zzag;
    public final String zzah;
    public final boolean zzai;
    public final JSONObject zzaj;
    public final boolean zzak;
    public final JSONObject zzal;
    public final boolean zzam;
    public final String zzan;
    public final boolean zzao;
    public final String zzap;
    public final String zzaq;
    public final String zzar;
    public final boolean zzas;
    public final int zzat;
    public final String zzau;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final List zze;
    public final int zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final List zzj;
    public final List zzk;
    public final String zzl;
    public final String zzm;
    public final zzbwi zzn;
    public final List zzo;
    public final List zzp;
    public final List zzq;
    public final List zzr;
    public final int zzs;
    public final List zzt;
    public final zzfcx zzu;
    public final List zzv;
    public final List zzw;
    public final JSONObject zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARN: Code duplicated, block: B:234:0x062f A[PHI: r22 r79
      0x062f: PHI (r22v80 java.util.List) = 
      (r22v5 java.util.List)
      (r22v6 java.util.List)
      (r22v7 java.util.List)
      (r22v8 java.util.List)
      (r22v9 java.util.List)
      (r22v10 java.util.List)
      (r22v11 java.util.List)
      (r22v12 java.util.List)
      (r22v13 java.util.List)
      (r22v14 java.util.List)
      (r22v15 java.util.List)
      (r22v16 java.util.List)
      (r22v17 java.util.List)
      (r22v18 java.util.List)
      (r22v19 java.util.List)
      (r22v20 java.util.List)
      (r22v21 java.util.List)
      (r22v22 java.util.List)
      (r22v23 java.util.List)
      (r22v24 java.util.List)
      (r22v25 java.util.List)
      (r22v26 java.util.List)
      (r22v27 java.util.List)
      (r22v28 java.util.List)
      (r22v29 java.util.List)
      (r22v30 java.util.List)
      (r22v31 java.util.List)
      (r22v32 java.util.List)
      (r22v33 java.util.List)
      (r22v34 java.util.List)
      (r22v35 java.util.List)
      (r22v36 java.util.List)
      (r22v37 java.util.List)
      (r22v38 java.util.List)
      (r22v39 java.util.List)
      (r22v40 java.util.List)
      (r22v41 java.util.List)
      (r22v42 java.util.List)
      (r22v43 java.util.List)
      (r22v44 java.util.List)
      (r22v45 java.util.List)
      (r22v46 java.util.List)
      (r22v47 java.util.List)
      (r22v48 java.util.List)
      (r22v49 java.util.List)
      (r22v50 java.util.List)
      (r22v51 java.util.List)
      (r22v52 java.util.List)
      (r22v53 java.util.List)
      (r22v54 java.util.List)
      (r22v55 java.util.List)
      (r22v56 java.util.List)
      (r22v57 java.util.List)
      (r22v58 java.util.List)
      (r22v59 java.util.List)
      (r22v60 java.util.List)
      (r22v61 java.util.List)
      (r22v62 java.util.List)
      (r22v63 java.util.List)
      (r22v64 java.util.List)
      (r22v65 java.util.List)
      (r22v66 java.util.List)
      (r22v67 java.util.List)
      (r22v68 java.util.List)
      (r22v69 java.util.List)
      (r22v70 java.util.List)
      (r22v71 java.util.List)
      (r22v72 java.util.List)
      (r22v73 java.util.List)
      (r22v74 java.util.List)
      (r22v75 java.util.List)
      (r22v76 java.util.List)
      (r22v77 java.util.List)
      (r22v78 java.util.List)
      (r22v81 java.util.List)
     binds: [B:232:0x062a, B:229:0x0619, B:226:0x0608, B:223:0x05f7, B:220:0x05e6, B:217:0x05d5, B:214:0x05c3, B:211:0x05b1, B:208:0x059f, B:205:0x058d, B:202:0x057b, B:199:0x0569, B:196:0x0557, B:193:0x0545, B:190:0x0533, B:187:0x0521, B:184:0x050f, B:181:0x04fd, B:178:0x04eb, B:175:0x04d9, B:172:0x04c7, B:169:0x04b5, B:166:0x04a3, B:163:0x0491, B:160:0x0480, B:157:0x046e, B:154:0x045c, B:151:0x044a, B:148:0x0438, B:145:0x0426, B:142:0x0414, B:139:0x0402, B:136:0x03f1, B:133:0x03e0, B:130:0x03ce, B:127:0x03bd, B:124:0x03ab, B:121:0x0399, B:118:0x0387, B:115:0x0375, B:112:0x0363, B:109:0x0351, B:106:0x033f, B:103:0x032d, B:100:0x031b, B:97:0x0309, B:94:0x02f7, B:91:0x02e5, B:88:0x02d3, B:85:0x02c1, B:82:0x02af, B:79:0x029d, B:76:0x028c, B:73:0x027a, B:70:0x0268, B:67:0x0256, B:64:0x0244, B:61:0x0232, B:58:0x0221, B:55:0x020f, B:52:0x01fd, B:49:0x01eb, B:46:0x01d9, B:43:0x01c7, B:40:0x01b5, B:37:0x01a3, B:34:0x0192, B:31:0x0180, B:28:0x016e, B:25:0x015c, B:22:0x014a, B:19:0x0138, B:16:0x0126, B:13:0x0114, B:11:0x0102] A[DONT_GENERATE, DONT_INLINE]
      0x062f: PHI (r79v76 java.util.List) = 
      (r79v1 java.util.List)
      (r79v2 java.util.List)
      (r79v3 java.util.List)
      (r79v4 java.util.List)
      (r79v5 java.util.List)
      (r79v6 java.util.List)
      (r79v7 java.util.List)
      (r79v8 java.util.List)
      (r79v9 java.util.List)
      (r79v10 java.util.List)
      (r79v11 java.util.List)
      (r79v12 java.util.List)
      (r79v13 java.util.List)
      (r79v14 java.util.List)
      (r79v15 java.util.List)
      (r79v16 java.util.List)
      (r79v17 java.util.List)
      (r79v18 java.util.List)
      (r79v19 java.util.List)
      (r79v20 java.util.List)
      (r79v21 java.util.List)
      (r79v22 java.util.List)
      (r79v23 java.util.List)
      (r79v24 java.util.List)
      (r79v25 java.util.List)
      (r79v26 java.util.List)
      (r79v27 java.util.List)
      (r79v28 java.util.List)
      (r79v29 java.util.List)
      (r79v30 java.util.List)
      (r79v31 java.util.List)
      (r79v32 java.util.List)
      (r79v33 java.util.List)
      (r79v34 java.util.List)
      (r79v35 java.util.List)
      (r79v36 java.util.List)
      (r79v37 java.util.List)
      (r79v38 java.util.List)
      (r79v39 java.util.List)
      (r79v40 java.util.List)
      (r79v41 java.util.List)
      (r79v42 java.util.List)
      (r79v43 java.util.List)
      (r79v44 java.util.List)
      (r79v45 java.util.List)
      (r79v46 java.util.List)
      (r79v47 java.util.List)
      (r79v48 java.util.List)
      (r79v49 java.util.List)
      (r79v50 java.util.List)
      (r79v51 java.util.List)
      (r79v52 java.util.List)
      (r79v53 java.util.List)
      (r79v54 java.util.List)
      (r79v55 java.util.List)
      (r79v56 java.util.List)
      (r79v57 java.util.List)
      (r79v58 java.util.List)
      (r79v59 java.util.List)
      (r79v60 java.util.List)
      (r79v61 java.util.List)
      (r79v62 java.util.List)
      (r79v63 java.util.List)
      (r79v64 java.util.List)
      (r79v65 java.util.List)
      (r79v66 java.util.List)
      (r79v67 java.util.List)
      (r79v68 java.util.List)
      (r79v69 java.util.List)
      (r79v70 java.util.List)
      (r79v71 java.util.List)
      (r79v72 java.util.List)
      (r79v73 java.util.List)
      (r79v74 java.util.List)
      (r79v77 java.util.List)
     binds: [B:232:0x062a, B:229:0x0619, B:226:0x0608, B:223:0x05f7, B:220:0x05e6, B:217:0x05d5, B:214:0x05c3, B:211:0x05b1, B:208:0x059f, B:205:0x058d, B:202:0x057b, B:199:0x0569, B:196:0x0557, B:193:0x0545, B:190:0x0533, B:187:0x0521, B:184:0x050f, B:181:0x04fd, B:178:0x04eb, B:175:0x04d9, B:172:0x04c7, B:169:0x04b5, B:166:0x04a3, B:163:0x0491, B:160:0x0480, B:157:0x046e, B:154:0x045c, B:151:0x044a, B:148:0x0438, B:145:0x0426, B:142:0x0414, B:139:0x0402, B:136:0x03f1, B:133:0x03e0, B:130:0x03ce, B:127:0x03bd, B:124:0x03ab, B:121:0x0399, B:118:0x0387, B:115:0x0375, B:112:0x0363, B:109:0x0351, B:106:0x033f, B:103:0x032d, B:100:0x031b, B:97:0x0309, B:94:0x02f7, B:91:0x02e5, B:88:0x02d3, B:85:0x02c1, B:82:0x02af, B:79:0x029d, B:76:0x028c, B:73:0x027a, B:70:0x0268, B:67:0x0256, B:64:0x0244, B:61:0x0232, B:58:0x0221, B:55:0x020f, B:52:0x01fd, B:49:0x01eb, B:46:0x01d9, B:43:0x01c7, B:40:0x01b5, B:37:0x01a3, B:34:0x0192, B:31:0x0180, B:28:0x016e, B:25:0x015c, B:22:0x014a, B:19:0x0138, B:16:0x0126, B:13:0x0114, B:11:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
    zzfcr(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        List list;
        List list2;
        byte b2;
        List listEmptyList = Collections.emptyList();
        List listEmptyList2 = Collections.emptyList();
        List listEmptyList3 = Collections.emptyList();
        List listEmptyList4 = Collections.emptyList();
        List listEmptyList5 = Collections.emptyList();
        List listEmptyList6 = Collections.emptyList();
        List listEmptyList7 = Collections.emptyList();
        List listEmptyList8 = Collections.emptyList();
        List listEmptyList9 = Collections.emptyList();
        List listEmptyList10 = Collections.emptyList();
        List listEmptyList11 = Collections.emptyList();
        List listEmptyList12 = Collections.emptyList();
        List listEmptyList13 = Collections.emptyList();
        List listEmptyList14 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        zzfvs zzfvsVarZzl = zzfvs.zzl();
        zzfvs zzfvsVarZzl2 = zzfvs.zzl();
        jsonReader.beginObject();
        JSONObject jSONObjectZzh = jSONObject2;
        JSONObject jSONObjectZzh2 = jSONObject3;
        JSONObject jSONObjectZzh3 = jSONObject4;
        JSONObject jSONObjectZzh4 = jSONObject5;
        JSONObject jSONObjectZzh5 = jSONObject6;
        List listZzd = zzfvsVarZzl;
        List listZzd2 = zzfvsVarZzl2;
        int iZzd = -1;
        int iNextInt = -1;
        zzfcx zzfcxVar = null;
        zzbxr zzbxrVarZza = null;
        zzbtb zzbtbVarZza = null;
        com.google.android.gms.ads.internal.client.zzs zzsVarZza = null;
        String strNextString = null;
        String strNextString2 = "";
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String string = strNextString4;
        String strNextString5 = string;
        String strNextString6 = strNextString5;
        String strNextString7 = strNextString6;
        String strNextString8 = strNextString7;
        String strNextString9 = strNextString8;
        String strNextString10 = strNextString9;
        String strNextString11 = strNextString10;
        String strNextString12 = strNextString11;
        String strNextString13 = strNextString12;
        String strNextString14 = strNextString13;
        String strNextString15 = strNextString14;
        String strNextString16 = strNextString15;
        String strNextString17 = strNextString16;
        String strNextString18 = strNextString17;
        int iNextInt2 = 0;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        boolean zNextBoolean3 = false;
        boolean zNextBoolean4 = false;
        boolean zNextBoolean5 = false;
        boolean zNextBoolean6 = false;
        boolean zNextBoolean7 = false;
        int iNextInt3 = 0;
        boolean zNextBoolean8 = false;
        boolean zNextBoolean9 = false;
        boolean zNextBoolean10 = false;
        int iNextInt4 = 0;
        boolean zNextBoolean11 = false;
        boolean zNextBoolean12 = false;
        boolean zNextBoolean13 = false;
        boolean zNextBoolean14 = false;
        boolean zNextBoolean15 = false;
        boolean zNextBoolean16 = false;
        boolean zNextBoolean17 = false;
        int iNextInt5 = 0;
        List listZzd3 = listEmptyList11;
        List listZza = listEmptyList12;
        List listZzd4 = listEmptyList13;
        List listZza2 = listEmptyList14;
        JSONObject jSONObjectZzh6 = jSONObject;
        zzbwi zzbwiVarZza = null;
        String strNextString19 = strNextString18;
        String strNextString20 = strNextString19;
        int iZzb = 0;
        int iZzc = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            String str = strNextName == null ? "" : strNextName;
            switch (str.hashCode()) {
                case -2138196627:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_source_instance_name")) {
                        b2 = -1;
                    } else {
                        b2 = 60;
                    }
                    break;
                case -1980587809:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("debug_signals")) {
                        b2 = -1;
                    } else {
                        b2 = 29;
                    }
                    break;
                case -1965512151:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("omid_settings")) {
                        b2 = -1;
                    } else {
                        b2 = 42;
                    }
                    break;
                case -1871425831:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("recursive_server_response_data")) {
                        b2 = -1;
                    } else {
                        b2 = 70;
                    }
                    break;
                case -1843156475:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("is_consent")) {
                        b2 = -1;
                    } else {
                        b2 = 71;
                    }
                    break;
                case -1812055556:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("play_prewarm_options")) {
                        b2 = -1;
                    } else {
                        b2 = 50;
                    }
                    break;
                case -1785028569:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("parallel_key")) {
                        b2 = -1;
                    } else {
                        b2 = 73;
                    }
                    break;
                case -1776946669:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_source_name")) {
                        b2 = -1;
                    } else {
                        b2 = 58;
                    }
                    break;
                case -1662989631:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("is_interscroller")) {
                        b2 = -1;
                    } else {
                        b2 = 54;
                    }
                    break;
                case -1620470467:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("backend_query_id")) {
                        b2 = -1;
                    } else {
                        b2 = 48;
                    }
                    break;
                case -1550155393:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("nofill_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 14;
                    }
                    break;
                case -1440104884:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("is_custom_close_blocked")) {
                        b2 = -1;
                    } else {
                        b2 = 36;
                    }
                    break;
                case -1439500848:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("orientation")) {
                        b2 = -1;
                    } else {
                        b2 = 38;
                    }
                    break;
                case -1428969291:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("enable_omid")) {
                        b2 = -1;
                    } else {
                        b2 = 40;
                    }
                    break;
                case -1406227629:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("buffer_click_url_as_ready_to_ping")) {
                        b2 = -1;
                    } else {
                        b2 = 68;
                    }
                    break;
                case -1403779768:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("showable_impression_type")) {
                        b2 = -1;
                    } else {
                        b2 = 45;
                    }
                    break;
                case -1375413093:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_cover")) {
                        b2 = -1;
                    } else {
                        b2 = 55;
                    }
                    break;
                case -1360811658:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_sizes")) {
                        b2 = -1;
                    } else {
                        b2 = 20;
                    }
                    break;
                case -1306015996:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("adapters")) {
                        b2 = -1;
                    } else {
                        b2 = 21;
                    }
                    break;
                case -1303332046:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("test_mode_enabled")) {
                        b2 = -1;
                    } else {
                        b2 = 35;
                    }
                    break;
                case -1289032093:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("extras")) {
                        b2 = -1;
                    } else {
                        b2 = 30;
                    }
                    break;
                case -1240082064:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_event_value")) {
                        b2 = -1;
                    } else {
                        b2 = 52;
                    }
                    break;
                case -1234181075:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("allow_pub_rendered_attribution")) {
                        b2 = -1;
                    } else {
                        b2 = 31;
                    }
                    break;
                case -1168140544:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("presentation_error_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 15;
                    }
                    break;
                case -1152230954:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_type")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case -1146534047:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("is_scroll_aware")) {
                        b2 = -1;
                    } else {
                        b2 = 44;
                    }
                    break;
                case -1115838944:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("fill_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 13;
                    }
                    break;
                case -1081936678:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("allocation_id")) {
                        b2 = -1;
                    } else {
                        b2 = 22;
                    }
                    break;
                case -1078050970:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("video_complete_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 9;
                    }
                    break;
                case -1051269058:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("active_view")) {
                        b2 = -1;
                    } else {
                        b2 = 26;
                    }
                    break;
                case -982608540:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("valid_from_timestamp")) {
                        b2 = -1;
                    } else {
                        b2 = 11;
                    }
                    break;
                case -972056451:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_source_instance_id")) {
                        b2 = -1;
                    } else {
                        b2 = Base64.padSymbol;
                    }
                    break;
                case -776859333:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("click_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case -570101180:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("late_load_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 5;
                    }
                    break;
                case -544216775:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("safe_browsing")) {
                        b2 = -1;
                    } else {
                        b2 = 27;
                    }
                    break;
                case -437057161:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("imp_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case -404433734:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("rtb_native_required_assets")) {
                        b2 = -1;
                    } else {
                        b2 = 63;
                    }
                    break;
                case -404326515:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("render_timeout_ms")) {
                        b2 = -1;
                    } else {
                        b2 = 39;
                    }
                    break;
                case -397704715:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_close_time_ms")) {
                        b2 = -1;
                    } else {
                        b2 = 46;
                    }
                    break;
                case -388807511:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals(ShareConstants.STORY_DEEP_LINK_URL)) {
                        b2 = -1;
                    } else {
                        b2 = 65;
                    }
                    break;
                case -369773488:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("is_close_button_enabled")) {
                        b2 = -1;
                    } else {
                        b2 = 51;
                    }
                    break;
                case -213449460:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("force_disable_hardware_acceleration")) {
                        b2 = -1;
                    } else {
                        b2 = 66;
                    }
                    break;
                case -213424028:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals(MBridgeConstans.EXTRA_KEY_WM)) {
                        b2 = -1;
                    } else {
                        b2 = 47;
                    }
                    break;
                case -180214626:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("native_required_asset_viewability")) {
                        b2 = -1;
                    } else {
                        b2 = SignedBytes.MAX_POWER_OF_TWO;
                    }
                    break;
                case -154616268:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("is_offline_ad")) {
                        b2 = -1;
                    } else {
                        b2 = 62;
                    }
                    break;
                case -29338502:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("allow_custom_click_gesture")) {
                        b2 = -1;
                    } else {
                        b2 = 33;
                    }
                    break;
                case 3107:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad")) {
                        b2 = -1;
                    } else {
                        b2 = 19;
                    }
                    break;
                case 3355:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("id")) {
                        b2 = -1;
                    } else {
                        b2 = 24;
                    }
                    break;
                case 3076010:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("data")) {
                        b2 = -1;
                    } else {
                        b2 = 23;
                    }
                    break;
                case 37109963:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals(SDKAnalyticsEvents.PARAMETER_REQUEST_ID)) {
                        b2 = -1;
                    } else {
                        b2 = 69;
                    }
                    break;
                case 63195984:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("render_test_label")) {
                        b2 = -1;
                    } else {
                        b2 = 34;
                    }
                    break;
                case 107433883:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("qdata")) {
                        b2 = -1;
                    } else {
                        b2 = 25;
                    }
                    break;
                case 230323073:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_load_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case 418392395:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("is_closable_area_disabled")) {
                        b2 = -1;
                    } else {
                        b2 = 37;
                    }
                    break;
                case 542250332:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("consent_form_action_identifier")) {
                        b2 = -1;
                    } else {
                        b2 = 72;
                    }
                    break;
                case 549176928:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("presentation_error_timeout_ms")) {
                        b2 = -1;
                    } else {
                        b2 = 17;
                    }
                    break;
                case 597473788:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("debug_dialog_string")) {
                        b2 = -1;
                    } else {
                        b2 = 28;
                    }
                    break;
                case 754887508:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("container_sizes")) {
                        b2 = -1;
                    } else {
                        b2 = 18;
                    }
                    break;
                case 791122864:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("impression_type")) {
                        b2 = -1;
                    } else {
                        b2 = 6;
                    }
                    break;
                case 1010584092:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("transaction_id")) {
                        b2 = -1;
                    } else {
                        b2 = 10;
                    }
                    break;
                case 1100650276:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("rewards")) {
                        b2 = -1;
                    } else {
                        b2 = 12;
                    }
                    break;
                case 1141602460:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("adapter_response_info_key")) {
                        b2 = -1;
                    } else {
                        b2 = 57;
                    }
                    break;
                case 1186014765:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("cache_hit_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 67;
                    }
                    break;
                case 1321720943:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("allow_pub_owned_ad_view")) {
                        b2 = -1;
                    } else {
                        b2 = 32;
                    }
                    break;
                case 1437255331:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals(CampaignEx.JSON_KEY_AD_SOURCE_ID)) {
                        b2 = -1;
                    } else {
                        b2 = 59;
                    }
                    break;
                case 1637553475:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("bid_response")) {
                        b2 = -1;
                    } else {
                        b2 = 41;
                    }
                    break;
                case 1638957285:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("video_start_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 7;
                    }
                    break;
                case 1686319423:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("ad_network_class_name")) {
                        b2 = -1;
                    } else {
                        b2 = 56;
                    }
                    break;
                case 1688341040:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("video_reward_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 8;
                    }
                    break;
                case 1799285870:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("use_third_party_container_height")) {
                        b2 = -1;
                    } else {
                        b2 = 49;
                    }
                    break;
                case 1839650832:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("renderers")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case 1875425491:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("is_analytics_logging_enabled")) {
                        b2 = -1;
                    } else {
                        b2 = 43;
                    }
                    break;
                case 2068142375:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("rule_line_external_id")) {
                        b2 = -1;
                    } else {
                        b2 = 53;
                    }
                    break;
                case 2072888499:
                    list2 = listEmptyList10;
                    list = listEmptyList9;
                    if (!str.equals("manual_tracking_urls")) {
                        b2 = -1;
                    } else {
                        b2 = 16;
                    }
                    break;
                default:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    listEmptyList = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1:
                    iZzb = zzb(jsonReader.nextString());
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 2:
                    listEmptyList2 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 3:
                    listEmptyList3 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 4:
                    listEmptyList4 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 5:
                    listZzd2 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 6:
                    iZzc = zzc(jsonReader.nextInt());
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 7:
                    listEmptyList5 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 8:
                    listEmptyList6 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 9:
                    listEmptyList7 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 10:
                    strNextString20 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 11:
                    strNextString19 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 12:
                    zzbwiVarZza = zzbwi.zza(com.google.android.gms.ads.internal.util.zzbw.zze(jsonReader));
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 13:
                    listEmptyList8 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 14:
                    listEmptyList9 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    break;
                case 15:
                    listEmptyList10 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList9 = list;
                    break;
                case 16:
                    listZzd3 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 17:
                    iNextInt2 = jsonReader.nextInt();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 18:
                    listZza = zzfcs.zza(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 19:
                    zzfcxVar = new zzfcx(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 20:
                    listZza2 = zzfcs.zza(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 21:
                    listZzd4 = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 22:
                    strNextString2 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 23:
                    jSONObjectZzh6 = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 24:
                    strNextString3 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 25:
                    strNextString4 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 26:
                    string = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader).toString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 27:
                    zzbxrVarZza = zzbxr.zza(com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader));
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 28:
                    strNextString5 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 29:
                    jSONObjectZzh = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 30:
                    jSONObjectZzh2 = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 31:
                    zNextBoolean = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 32:
                    zNextBoolean2 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 33:
                    zNextBoolean3 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 34:
                    zNextBoolean4 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 35:
                    zNextBoolean5 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 36:
                    zNextBoolean6 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 37:
                    zNextBoolean7 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 38:
                    iZzd = zzd(jsonReader.nextString());
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 39:
                    iNextInt3 = jsonReader.nextInt();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 40:
                    zNextBoolean8 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 41:
                    strNextString6 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 42:
                    jSONObjectZzh3 = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 43:
                    zNextBoolean9 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 44:
                    zNextBoolean10 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 45:
                    iNextInt4 = jsonReader.nextInt();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 46:
                    iNextInt = jsonReader.nextInt();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 47:
                    strNextString7 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 48:
                    strNextString8 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 49:
                    zNextBoolean11 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 50:
                    zzbtbVarZza = zzbtb.zza(com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader));
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 51:
                    jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 52:
                    zzsVarZza = com.google.android.gms.ads.internal.client.zzs.zza(com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader));
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 53:
                    strNextString9 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 54:
                    zNextBoolean12 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 55:
                    jSONObjectZzh4 = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 56:
                    strNextString10 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 57:
                    strNextString17 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 58:
                    if (((Boolean) zzbci.zzgK.zzl()).booleanValue()) {
                        strNextString11 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 59:
                    if (((Boolean) zzbci.zzgK.zzl()).booleanValue()) {
                        strNextString12 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 60:
                    if (((Boolean) zzbci.zzgK.zzl()).booleanValue()) {
                        strNextString13 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 61:
                    if (((Boolean) zzbci.zzgK.zzl()).booleanValue()) {
                        strNextString14 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 62:
                    zNextBoolean13 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 63:
                    jSONObjectZzh5 = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 64:
                    zNextBoolean14 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 65:
                    strNextString = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 66:
                    zNextBoolean15 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 67:
                    listZzd = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 68:
                    zNextBoolean16 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 69:
                    strNextString15 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 70:
                    strNextString16 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 71:
                    zNextBoolean17 = jsonReader.nextBoolean();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 72:
                    iNextInt5 = jsonReader.nextInt();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 73:
                    strNextString18 = jsonReader.nextString();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                default:
                    jsonReader.skipValue();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
            }
        }
        jsonReader.endObject();
        this.zza = listEmptyList;
        this.zzb = iZzb;
        this.zzc = listEmptyList2;
        this.zzd = listEmptyList3;
        this.zzg = listEmptyList4;
        this.zzf = iZzc;
        this.zzi = listEmptyList5;
        this.zzj = listEmptyList6;
        this.zzk = listEmptyList7;
        this.zzl = strNextString20;
        this.zzm = strNextString19;
        this.zzn = zzbwiVarZza;
        this.zzo = listEmptyList8;
        this.zzp = listEmptyList9;
        this.zzq = listEmptyList10;
        this.zzr = listZzd3;
        this.zzs = iNextInt2;
        this.zzt = listZza;
        this.zzu = zzfcxVar;
        this.zzv = listZzd4;
        this.zzw = listZza2;
        this.zzy = strNextString2;
        this.zzx = jSONObjectZzh6;
        this.zzz = strNextString3;
        this.zzA = strNextString4;
        this.zzB = string;
        this.zzC = zzbxrVarZza;
        this.zzD = strNextString5;
        this.zzE = jSONObjectZzh;
        this.zzF = jSONObjectZzh2;
        this.zzL = zNextBoolean;
        this.zzM = zNextBoolean2;
        this.zzN = zNextBoolean3;
        this.zzO = zNextBoolean4;
        this.zzP = zNextBoolean5;
        this.zzQ = zNextBoolean6;
        this.zzR = zNextBoolean7;
        this.zzS = iZzd;
        this.zzT = iNextInt3;
        this.zzV = zNextBoolean8;
        this.zzW = strNextString6;
        this.zzX = new zzfdq(jSONObjectZzh3);
        this.zzY = zNextBoolean9;
        this.zzZ = zNextBoolean10;
        this.zzaa = iNextInt4;
        this.zzab = strNextString7;
        this.zzac = iNextInt;
        this.zzad = strNextString8;
        this.zzae = zNextBoolean11;
        this.zzaf = zzbtbVarZza;
        this.zzag = zzsVarZza;
        this.zzah = strNextString9;
        this.zzai = zNextBoolean12;
        this.zzaj = jSONObjectZzh4;
        this.zzG = strNextString10;
        this.zzH = strNextString11;
        this.zzI = strNextString12;
        this.zzJ = strNextString13;
        this.zzK = strNextString14;
        this.zzak = zNextBoolean13;
        this.zzal = jSONObjectZzh5;
        this.zzam = zNextBoolean14;
        this.zzan = strNextString;
        this.zzao = zNextBoolean15;
        this.zze = listZzd;
        this.zzU = zNextBoolean16;
        this.zzap = strNextString15;
        this.zzaq = strNextString16;
        this.zzar = strNextString17;
        this.zzas = zNextBoolean17;
        this.zzat = iNextInt5;
        this.zzh = listZzd2;
        this.zzau = strNextString18;
    }

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzb(String str) {
        if (ReportUtil.INVENTORY_TYPE_BANNER.equals(str)) {
            return 1;
        }
        if (ReportUtil.INVENTORY_TYPE_INTERSTITIAL.equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if ("native".equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        return "rewarded_interstitial".equals(str) ? 7 : 0;
    }

    private static int zzc(int i) {
        if (i == 0 || i == 1 || i == 3) {
            return i;
        }
        return 0;
    }

    private static final int zzd(String str) {
        if (TJAdUnitConstants.String.LANDSCAPE.equalsIgnoreCase(str)) {
            return 6;
        }
        return TJAdUnitConstants.String.PORTRAIT.equalsIgnoreCase(str) ? 7 : -1;
    }
}
