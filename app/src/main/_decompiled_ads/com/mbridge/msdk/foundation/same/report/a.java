package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.aa;
import com.tapjoy.TapjoyConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonDeviceInfo.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static JSONObject a() {
        JSONObject jSONObject;
        try {
            jSONObject = q.a(com.mbridge.msdk.foundation.controller.b.d().g()).b();
        } catch (Exception e) {
            aa.b("CommonDeviceInfo", "getCommonProperty error", e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                com.mbridge.msdk.foundation.same.a.l = com.mbridge.msdk.foundation.a.a.a.a().b(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                com.mbridge.msdk.foundation.same.a.m = com.mbridge.msdk.foundation.a.a.a.a().b("c");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                jSONObject.put("c", com.mbridge.msdk.foundation.same.a.m);
            }
            jSONObject.put("open", com.mbridge.msdk.foundation.same.a.v);
            String strA = Aa.a();
            if (strA == null) {
                strA = "";
            }
            jSONObject.put("channel", strA);
            jSONObject.put("band_width", com.mbridge.msdk.foundation.same.net.a.a().e());
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
            com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (cVarB == null) {
                cVarB = com.mbridge.msdk.c.d.a().b();
            }
            JSONObject jSONObjectA = a(cVarB);
            if (jSONObjectA != null) {
                String string = jSONObjectA.toString();
                if (!TextUtils.isEmpty(string)) {
                    String strA2 = com.mbridge.msdk.foundation.tools.u.a(string);
                    if (!TextUtils.isEmpty(strA2)) {
                        jSONObject.put("dvi", strA2);
                    }
                }
            }
            jSONObject.put("app_id", com.mbridge.msdk.foundation.controller.b.d().h());
            jSONObject.put("m_sdk", "msdk");
            jSONObject.put("lqswt", String.valueOf(1));
            String strAH = "UNKNOWN";
            if (cVarB != null) {
                strAH = cVarB.aH();
                jSONObject.put("a_stid", cVarB.c());
            }
            jSONObject.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, strAH);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static JSONObject a(com.mbridge.msdk.c.c cVar) {
        try {
            return q.a(com.mbridge.msdk.foundation.controller.b.d().g(), cVar);
        } catch (Exception unused) {
            return null;
        }
    }
}
