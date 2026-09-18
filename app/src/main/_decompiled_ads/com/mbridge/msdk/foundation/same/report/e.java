package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: DefaultDecorate.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements d {
    @Override // com.mbridge.msdk.foundation.same.report.d
    public final com.mbridge.msdk.foundation.same.net.g.d a(b bVar) throws Exception {
        if (bVar == null) {
            return null;
        }
        Context contextG = bVar.d() == null ? com.mbridge.msdk.foundation.controller.b.d().g() : bVar.d();
        String strG = bVar.g();
        String strE = bVar.e();
        String strF = bVar.f();
        try {
            String strA = a(a(bVar, contextG, strE, strG));
            bVar.a(strA);
            if (TextUtils.isEmpty(strA)) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CommonReport", "decorate report data is null");
                }
                return null;
            }
            com.mbridge.msdk.foundation.same.net.g.d dVarA = q.a(contextG);
            dVarA.a("data", URLEncoder.encode(strA, "utf-8"));
            if (TextUtils.isEmpty(strE)) {
                strE = com.mbridge.msdk.foundation.controller.b.d().h();
            }
            dVarA.a("app_id", strE);
            dVarA.a("m_sdk", "msdk");
            dVarA.a("r_stid", strF);
            if (!TextUtils.isEmpty(strG)) {
                dVarA.a(MBridgeConstans.PROPERTIES_UNIT_ID, strG);
            }
            return dVarA;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d("CommonReport", "decorate report data error: " + e.getMessage());
            }
            return null;
        }
    }

    private Map<String, String> a(b bVar, Context context, String str, String str2) {
        if (bVar == null) {
            return null;
        }
        Map<String, String> mapM = bVar.m();
        if (mapM == null) {
            mapM = new HashMap<>();
        }
        if (!TextUtils.isEmpty(bVar.h())) {
            mapM.put("adtp", bVar.h());
        }
        if (!TextUtils.isEmpty(str2)) {
            mapM.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            String str3 = com.mbridge.msdk.foundation.controller.b.c.get(str2);
            if (TextUtils.isEmpty(str)) {
                str = com.mbridge.msdk.foundation.controller.b.d().h();
            }
            com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(str);
            if (cVarB == null) {
                cVarB = com.mbridge.msdk.c.d.a().b();
            }
            if (!TextUtils.isEmpty(cVarB.k())) {
                mapM.put("as_rid", cVarB.k());
            }
            try {
                String strI = bVar.i();
                String strL = cVarB.l();
                JSONArray jSONArrayW = cVarB.w();
                if (jSONArrayW != null) {
                    for (int i = 0; i < jSONArrayW.length(); i++) {
                        if (strI.equals(jSONArrayW.getString(i))) {
                            strL = "1.0";
                            break;
                        }
                    }
                }
                if (!TextUtils.isEmpty(strL)) {
                    mapM.put("log_rate", strL);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.mbridge.msdk.c.f fVarE = com.mbridge.msdk.c.d.a().e(str, str2);
            if (fVarE != null && !TextUtils.isEmpty(fVarE.b())) {
                mapM.put("us_rid", fVarE.b());
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            mapM.put("u_stid", str3);
        }
        String strI2 = bVar.i();
        if (!TextUtils.isEmpty(strI2)) {
            mapM.put(SDKConstants.PARAM_KEY, strI2);
        }
        if (context != null) {
            mapM.put("network_type", String.valueOf(w.r(context)));
            mapM.put("network_available", String.valueOf(af.d(context)));
        }
        if (bVar.o()) {
            mapM.put("duration", String.valueOf(bVar.n()));
        }
        return mapM;
    }

    private String a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            if (map.containsKey("unitId") && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                map.remove("unitId");
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (i == 0) {
                            StringBuilder sbAppend = sb.append(str).append("=");
                            if (str2 == null) {
                                str2 = "";
                            }
                            sbAppend.append(str2);
                        } else {
                            StringBuilder sbAppend2 = sb.append("&").append(str).append("=");
                            if (str2 == null) {
                                str2 = "";
                            }
                            sbAppend2.append(str2);
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("CommonReport", e.getMessage());
                }
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }
}
