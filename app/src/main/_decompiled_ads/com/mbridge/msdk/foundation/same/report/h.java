package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventLibraryCommon.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {
    private static final String a = "h";

    public static com.mbridge.msdk.e.f a() {
        return new com.mbridge.msdk.e.f() { // from class: com.mbridge.msdk.foundation.same.report.h.1
            @Override // com.mbridge.msdk.e.f
            public final boolean a(com.mbridge.msdk.e.e eVar) throws Exception {
                return h.a(eVar);
            }
        };
    }

    public static com.mbridge.msdk.e.h b() {
        return new com.mbridge.msdk.e.h() { // from class: com.mbridge.msdk.foundation.same.report.h.2
            @Override // com.mbridge.msdk.e.h
            public final JSONObject a(com.mbridge.msdk.e.e eVar) {
                if (eVar == null) {
                    return null;
                }
                JSONObject jSONObjectD = eVar.d();
                if (jSONObjectD == null) {
                    jSONObjectD = new JSONObject();
                }
                try {
                    jSONObjectD.put(SDKConstants.PARAM_KEY, eVar.a());
                    Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                    int iR = w.r(contextG);
                    if (!jSONObjectD.has("network_type")) {
                        jSONObjectD.put("network_type", iR);
                        jSONObjectD.put("network_str", w.a(contextG, iR));
                    }
                    if (!jSONObjectD.has("st")) {
                        jSONObjectD.put("st", System.currentTimeMillis());
                    }
                    String strOptString = jSONObjectD.optString(MBridgeConstans.PROPERTIES_UNIT_ID, "");
                    if (!TextUtils.isEmpty(strOptString)) {
                        String str = com.mbridge.msdk.foundation.controller.b.c.get(strOptString);
                        jSONObjectD.put("u_stid", str != null ? str : "");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l) && !jSONObjectD.has(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        jSONObjectD.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m) && !jSONObjectD.has("c")) {
                        jSONObjectD.put("c", com.mbridge.msdk.foundation.same.a.m);
                    }
                } catch (Exception e) {
                    aa.d(h.a, e.getMessage());
                }
                return jSONObjectD;
            }
        };
    }

    public static JSONObject c() {
        return a.a();
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            jSONObject.remove(DeviceRequestsHelper.DEVICE_INFO_MODEL);
            jSONObject.remove("brand");
            jSONObject.remove("screen_size");
            jSONObject.remove("sub_ip");
            jSONObject.remove("network_type");
            jSONObject.remove("useragent");
            jSONObject.remove("ua");
            jSONObject.remove("language");
            jSONObject.remove("network_str");
            jSONObject.remove("mnc");
            jSONObject.remove("mcc");
            jSONObject.remove(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME);
            jSONObject.remove("gp_version");
            jSONObject.remove(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE);
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
            jSONObject.remove(com.mbridge.msdk.foundation.same.net.g.d.f);
            jSONObject.remove(com.mbridge.msdk.foundation.same.net.g.d.g);
            jSONObject.remove("power_rate");
            jSONObject.remove("charging");
            jSONObject.remove(TapjoyConstants.TJC_DEVICE_TIMEZONE);
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return;
        }
        jSONObject.remove("gaid");
        jSONObject.remove("gaid2");
        jSONObject.remove("oaid");
        jSONObject.remove("az_aid_info");
    }

    static /* synthetic */ boolean a(com.mbridge.msdk.e.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        String strA = eVar.a();
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB == null) {
            return true;
        }
        return g.a(cVarB, strA);
    }
}
