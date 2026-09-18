package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.messaging.Constants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBConfiguration;
import com.tapjoy.TapjoyConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReportUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class q extends g {
    public static final String a = "q";

    private static String c(Context context, String str) {
        String str2 = "1";
        if (context == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pf", "1");
            jSONObject.put("ov", w.n());
            jSONObject.put("pn", w.o(context));
            jSONObject.put("vn", w.j(context));
            jSONObject.put("vc", w.i(context));
            jSONObject.put("ot", w.h(context));
            jSONObject.put("dm", w.i());
            jSONObject.put("bd", w.k());
            jSONObject.put("gaid", w.a());
            jSONObject.put("mnc", w.e(context));
            jSONObject.put("mcc", w.d(context));
            int iR = w.r(context);
            jSONObject.put("nt", iR);
            jSONObject.put("nts", w.a(context, iR));
            jSONObject.put("l", w.g(context));
            jSONObject.put("tz", w.m());
            jSONObject.put("ua", w.l());
            jSONObject.put("app_id", com.mbridge.msdk.foundation.controller.b.d().h());
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("sv", MBConfiguration.SDK_VERSION);
            jSONObject.put("ss", w.l(context) + "x" + w.m(context));
            jSONObject.put("adid_limit", w.b());
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.h()) {
                str2 = "0";
            }
            jSONObject.put("adid_limit_dev", str2);
            if (com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h()) != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    try {
                        String strQ = w.q();
                        if (!TextUtils.isEmpty(strQ)) {
                            jSONObject2.put("manufacturer", strQ);
                        }
                        int iP = w.p();
                        if (iP != -1) {
                            jSONObject2.put("sdkint", iP);
                        }
                        String strT = w.t(context);
                        if (!TextUtils.isEmpty(strT)) {
                            jSONObject2.put("is24H", strT);
                        }
                        String strR = w.r();
                        if (!TextUtils.isEmpty(strR)) {
                            jSONObject2.put("totalram", strR);
                        }
                        String strU = w.u(context);
                        if (!TextUtils.isEmpty(strU)) {
                            jSONObject2.put("totalmemory", strU);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(jSONObject2.toString())) {
                        String strA = com.mbridge.msdk.foundation.tools.u.a(jSONObject2.toString());
                        if (!TextUtils.isEmpty(strA)) {
                            jSONObject.put("dvi", URLEncoder.encode(strA, "utf-8"));
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String a(Campaign campaign, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "adtrack");
            jSONObject.put("action", str);
            jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, i);
            if (campaign != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", campaign.getId());
                jSONObject2.put("title", campaign.getAppName());
                jSONObject.put("value", jSONObject2);
            } else {
                jSONObject.put("value", "");
            }
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
        return jSONObject.toString();
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(String str, String str2, Context context, String str3) {
        String string;
        if (context != null) {
            context = context.getApplicationContext();
        }
        com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
        dVar.a("m_device_info", c(context, str3));
        dVar.a("m_action", str);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String strA = Aa.a();
                if (strA == null) {
                    strA = "";
                }
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("channel", strA);
                String str4 = com.mbridge.msdk.foundation.controller.b.c.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put("u_stid", str4 != null ? str4 : "");
                }
                string = jSONObject.toString();
            } else {
                JSONObject jSONObject2 = new JSONObject();
                String str5 = com.mbridge.msdk.foundation.controller.b.c.get(str3);
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("u_stid", str5);
                }
                string = jSONObject2.toString();
            }
            str2 = string;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        dVar.a("m_data", str2);
        dVar.a("m_sdk", "msdk");
        return dVar;
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(Context context) {
        String str = "1";
        com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
        try {
            dVar.a(TapjoyConstants.TJC_PLATFORM, "1");
            dVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, URLEncoder.encode(w.o(context)));
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                dVar.a(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE);
                dVar.a("brand", URLEncoder.encode(w.k()));
                dVar.a(DeviceRequestsHelper.DEVICE_INFO_MODEL, URLEncoder.encode(w.i()));
                dVar.a("gaid", w.a());
                dVar.a("mnc", w.e(context));
                dVar.a("mcc", w.d(context));
                int iR = w.r(context);
                dVar.a("network_type", iR + "");
                dVar.a("network_str", w.a(context, iR));
                dVar.a("language", URLEncoder.encode(w.g(context)));
                dVar.a(TapjoyConstants.TJC_DEVICE_TIMEZONE, URLEncoder.encode(w.m()));
                dVar.a("ua", URLEncoder.encode(w.l()));
                dVar.a("adid_limit", w.b() + "");
                if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.h()) {
                    str = "0";
                }
                dVar.a("adid_limit_dev", str);
            }
            dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            dVar.a("app_version_name", URLEncoder.encode(w.j(context)));
            dVar.a("orientation", URLEncoder.encode(w.h(context) + ""));
            dVar.a("screen_size", w.l(context) + "x" + w.m(context));
            com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (cVarB == null) {
                cVarB = com.mbridge.msdk.c.d.a().b();
            }
            if (cVarB != null) {
                JSONObject jSONObjectA = a(context, cVarB);
                if (!TextUtils.isEmpty(jSONObjectA.toString())) {
                    String strA = com.mbridge.msdk.foundation.tools.u.a(jSONObjectA.toString());
                    if (!TextUtils.isEmpty(strA)) {
                        dVar.a("dvi", strA);
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return dVar;
    }

    public static JSONObject a(Context context, com.mbridge.msdk.c.c cVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            String strQ = w.q();
            if (!TextUtils.isEmpty(strQ)) {
                jSONObject.put("manufacturer", strQ);
            }
            int iP = w.p();
            if (iP != -1) {
                jSONObject.put("sdkint", iP);
            }
            String strT = w.t(context);
            if (!TextUtils.isEmpty(strT)) {
                jSONObject.put("is24H", strT);
            }
            String strR = w.r();
            if (!TextUtils.isEmpty(strR)) {
                jSONObject.put("totalram", strR);
            }
            String strU = w.u(context);
            if (!TextUtils.isEmpty(strU)) {
                jSONObject.put("totalmemory", strU);
            }
            jSONObject.put("adid_limit", w.b() + "");
            jSONObject.put("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.a.h() ? "1" : "0");
        }
        if (cVar.I() == 1 && !TextUtils.isEmpty(w.e()) && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            jSONObject.put("az_aid_info", w.e());
        }
        return jSONObject;
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(Context context, String str) {
        com.mbridge.msdk.foundation.same.net.g.d dVarA = a(context);
        dVarA.a("app_id", com.mbridge.msdk.foundation.controller.b.d().h() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                dVarA.a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return dVarA;
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(String str, Context context, String str2) {
        com.mbridge.msdk.foundation.same.net.g.d dVarA = a(context);
        dVarA.a("app_id", com.mbridge.msdk.foundation.controller.b.d().h() + "");
        dVarA.a(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String str3 = com.mbridge.msdk.foundation.controller.b.c.get(str2);
                if (TextUtils.isEmpty(str)) {
                    str = "u_stid=" + (str3 != null ? str3 : "");
                } else {
                    str = str + "&u_stid=" + (str3 != null ? str3 : "");
                }
            }
            dVarA.a("data", URLEncoder.encode(str, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dVarA.a("m_sdk", "msdk");
        return dVarA;
    }

    public static com.mbridge.msdk.foundation.same.net.g.d a(String str, Context context) {
        com.mbridge.msdk.foundation.same.net.g.d dVarA = a(context);
        dVarA.a("app_id", com.mbridge.msdk.foundation.controller.b.d().h() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                dVarA.a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        dVarA.a("m_sdk", "msdk");
        return dVarA;
    }

    public static String a(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("key=" + str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                sb.append("&" + entry.getKey() + "=" + entry.getValue());
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    public static boolean a() {
        try {
            return System.currentTimeMillis() - 86400000 > ((Long) ai.b(com.mbridge.msdk.foundation.controller.b.d().g(), "privateAuthorityTimesTamp", 0L)).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b() {
        try {
            ai.a(com.mbridge.msdk.foundation.controller.b.d().g(), "privateAuthorityTimesTamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, com.mbridge.msdk.foundation.entity.e eVar, String str, boolean z, CampaignEx campaignEx) {
        String strD;
        if (eVar != null) {
            try {
                strD = eVar.d();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            strD = "";
        }
        if (context == null || TextUtils.isEmpty(strD) || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuffer stringBufferAppend = new StringBuffer().append("key=2000047&");
        if (!TextUtils.isEmpty(str)) {
            String str2 = com.mbridge.msdk.foundation.controller.b.c.get(str);
            stringBufferAppend.append("u_stid=" + (str2 != null ? str2 : "") + "&");
        }
        if (campaignEx != null) {
            stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
            stringBufferAppend.append("adtp=" + campaignEx.getAdType() + "&");
            stringBufferAppend.append("rid=" + campaignEx.getRequestId()).append("&");
            stringBufferAppend.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
        }
        stringBufferAppend.append("st=" + System.currentTimeMillis() + "&");
        stringBufferAppend.append("network_type=" + w.r(context) + "&");
        stringBufferAppend.append("unit_id=" + str + "&").append("hb=").append(z ? 1 : 0).append("&");
        stringBufferAppend.append("reason=" + strD);
        if (k.a().c()) {
            k.a().a(stringBufferAppend.toString());
        } else {
            d(context, stringBufferAppend.toString());
        }
    }

    public static void a(Context context, String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000104&");
                if (!TextUtils.isEmpty(str2)) {
                    String str7 = com.mbridge.msdk.foundation.controller.b.c.get(str2);
                    StringBuilder sbAppend = new StringBuilder().append("u_stid=");
                    if (str7 == null) {
                        str7 = "";
                    }
                    stringBufferAppend.append(sbAppend.append(str7).append("&").toString());
                }
                stringBufferAppend.append("network_type=" + w.r(context) + "&");
                if (!TextUtils.isEmpty(str3)) {
                    stringBufferAppend.append("rid=" + str3 + "&");
                }
                if (!TextUtils.isEmpty(str4)) {
                    stringBufferAppend.append("rid_n=" + str4 + "&");
                }
                if (!TextUtils.isEmpty(str5)) {
                    stringBufferAppend.append("cid=" + str5 + "&");
                }
                if (!TextUtils.isEmpty(str6)) {
                    stringBufferAppend.append("template_id=" + str6 + "&");
                }
                stringBufferAppend.append("unit_id=" + str2 + "&").append("hb=").append(z ? 1 : 0).append("&");
                stringBufferAppend.append("reason=" + str);
                if (k.a().c()) {
                    k.a().a(stringBufferAppend.toString());
                } else {
                    d(context, stringBufferAppend.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, boolean z) {
        if (context == null || list == null) {
            return;
        }
        try {
            if (list.size() <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBufferAppend = new StringBuffer().append("key=2000048&");
            stringBufferAppend.append("st=" + System.currentTimeMillis() + "&");
            stringBufferAppend.append("network_type=" + w.r(context) + "&");
            stringBufferAppend.append("unit_id=" + str + "&");
            CampaignEx campaignEx = list.get(0);
            StringBuffer stringBufferAppend2 = stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
            if (z) {
                stringBufferAppend2.append("hb=").append(1).append("&");
            }
            String requestId = campaignEx.getRequestId();
            if (!TextUtils.isEmpty(requestId)) {
                stringBufferAppend2.append("rid=").append(requestId).append("&");
            }
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (!TextUtils.isEmpty(requestIdNotice)) {
                stringBufferAppend2 = stringBufferAppend2.append("rid_n=").append(requestIdNotice).append("&");
            }
            StringBuilder sb = new StringBuilder("rtins_type=");
            for (int i = 0; i < list.size(); i++) {
                CampaignEx campaignEx2 = list.get(i);
                if (i < list.size() - 1) {
                    sb.append(campaignEx2.getRtinsType()).append(",");
                } else {
                    sb.append(campaignEx2.getRtinsType());
                }
            }
            stringBufferAppend2.append((CharSequence) sb);
            if (k.a().c()) {
                k.a().a(stringBufferAppend2.toString());
            } else {
                a(context, stringBufferAppend2.toString(), str);
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i, String str, String str2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            StringBuffer stringBufferAppend = new StringBuffer().append("key=2000114&");
            stringBufferAppend.append("network_type=" + w.r(context) + "&");
            String strEncode = "";
            stringBufferAppend.append("gh_id=" + (TextUtils.isEmpty(campaignEx.getGhId()) ? "" : URLEncoder.encode(campaignEx.getGhId(), "utf-8")) + "&");
            stringBufferAppend.append("gh_path=" + (TextUtils.isEmpty(campaignEx.getGhPath()) ? "" : URLEncoder.encode(campaignEx.getGhPath(), "utf-8")) + "&");
            stringBufferAppend.append("unit_id=" + str2 + "&");
            stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&");
            stringBufferAppend.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            stringBufferAppend.append("result=" + i + "&");
            StringBuilder sbAppend = new StringBuilder().append("reason=");
            if (!TextUtils.isEmpty(str)) {
                strEncode = URLEncoder.encode(str, "utf-8");
            }
            stringBufferAppend.append(sbAppend.append(strEncode).append("&").toString());
            stringBufferAppend.append("cid=" + campaignEx.getId());
            if (k.a().c()) {
                k.a().a(stringBufferAppend.toString());
            } else {
                a(context, stringBufferAppend.toString(), str2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBufferAppend = new StringBuffer().append("key=2000054&");
            stringBufferAppend.append("network_type=").append(w.r(context)).append("&");
            stringBufferAppend.append("unit_id=").append(str).append("&");
            stringBufferAppend.append("cid=").append(campaignEx.getId()).append("&");
            stringBufferAppend.append("reason=&");
            stringBufferAppend.append("result=2&");
            if (!TextUtils.isEmpty(str2)) {
                stringBufferAppend = stringBufferAppend.append(str2);
            }
            if (campaignEx.getAdType() == 287) {
                stringBufferAppend.append("creative=").append(URLEncoder.encode(campaignEx.getendcard_url())).append("&");
                stringBufferAppend.append("ad_type=3&");
            } else if (campaignEx.getAdType() == 94) {
                stringBufferAppend.append("creative=").append(URLEncoder.encode(campaignEx.getendcard_url())).append("&");
                stringBufferAppend.append("ad_type=1&");
            } else if (campaignEx.getAdType() == 296) {
                stringBufferAppend.append("ad_type=5&");
                stringBufferAppend.append("creative=").append(campaignEx.getCreativeId()).append("&");
            } else if (campaignEx.getAdType() == 297) {
                stringBufferAppend.append("ad_type=6&");
                stringBufferAppend.append("creative=").append(campaignEx.getCreativeId()).append("&");
            } else if (campaignEx.getAdType() == 298) {
                stringBufferAppend.append("ad_type=7&");
                stringBufferAppend.append("creative=").append(campaignEx.getCreativeId()).append("&");
            } else {
                stringBufferAppend.append("creative=").append(URLEncoder.encode(campaignEx.getendcard_url())).append("&");
                stringBufferAppend.append("ad_type=1&");
            }
            stringBufferAppend.append("devid=").append(w.a()).append("&");
            if (campaignEx != null) {
                if (campaignEx.isBidCampaign()) {
                    stringBufferAppend = stringBufferAppend.append("hb=1&");
                }
                stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&");
                stringBufferAppend.append("rid_n=").append(campaignEx.getRequestIdNotice()).append("&");
                stringBufferAppend.append("adspace_t=").append(campaignEx.getAdSpaceT());
            }
            if (k.a().c()) {
                k.a().a(stringBufferAppend.toString());
            } else {
                a(context, stringBufferAppend.toString(), str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                    StringBuffer stringBufferAppend = new StringBuffer().append("key=2000054&");
                    stringBufferAppend.append("network_type=" + w.r(context) + "&");
                    stringBufferAppend.append("unit_id=" + str + "&");
                    stringBufferAppend.append("reason=" + str2 + "&");
                    stringBufferAppend.append("result=1&");
                    stringBufferAppend.append("devid=" + w.a() + "&");
                    if (campaignEx != null) {
                        stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
                        if (campaignEx.getAdType() == 287) {
                            stringBufferAppend.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBufferAppend.append("ad_type=3&");
                        } else if (campaignEx.getAdType() == 94) {
                            stringBufferAppend.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBufferAppend.append("ad_type=1&");
                        } else if (campaignEx.getAdType() == 296) {
                            stringBufferAppend.append("ad_type=5&");
                            stringBufferAppend.append("creative=" + campaignEx.getCreativeId() + "&");
                        } else if (campaignEx.getAdType() == 297) {
                            stringBufferAppend.append("ad_type=6&");
                            stringBufferAppend.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBufferAppend.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else if (campaignEx.getAdType() == 298) {
                            stringBufferAppend.append("ad_type=7&");
                            stringBufferAppend.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBufferAppend.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else {
                            stringBufferAppend.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBufferAppend.append("ad_type=1&");
                        }
                        stringBufferAppend = stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&").append("rid_n=" + campaignEx.getRequestIdNotice());
                    }
                    if (k.a().c()) {
                        k.a().a(stringBufferAppend.toString());
                    } else {
                        a(context, stringBufferAppend.toString(), str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, int i, String str2, String str3, CampaignEx campaignEx) {
        if (campaignEx == null || context == null) {
            return;
        }
        try {
            String campaignUnitId = campaignEx.getCampaignUnitId();
            boolean zIsBidCampaign = campaignEx.isBidCampaign();
            String requestId = campaignEx.getRequestId();
            String id = campaignEx.getId();
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(campaignUnitId)) {
                return;
            }
            StringBuffer stringBufferAppend = new StringBuffer().append("key=2000108&");
            if (!TextUtils.isEmpty(campaignUnitId)) {
                String str4 = com.mbridge.msdk.foundation.controller.b.c.get(campaignUnitId);
                StringBuilder sbAppend = new StringBuilder().append("u_stid=");
                if (str4 == null) {
                    str4 = "";
                }
                stringBufferAppend.append(sbAppend.append(str4).append("&").toString());
            }
            if (!TextUtils.isEmpty(requestId)) {
                stringBufferAppend.append("rid=" + requestId + "&");
            }
            if (!TextUtils.isEmpty(id)) {
                stringBufferAppend.append("cid=" + id + "&");
            }
            stringBufferAppend.append("template_id=" + i + "&");
            if (!TextUtils.isEmpty(str)) {
                stringBufferAppend.append("ad_type=" + str + "&");
            }
            if (!TextUtils.isEmpty(str3)) {
                stringBufferAppend.append("process=" + str3 + "&");
            }
            stringBufferAppend.append("unit_id=" + campaignUnitId + "&").append("hb=").append(zIsBidCampaign ? 1 : 0).append("&");
            stringBufferAppend.append("reason=" + str2);
            if (k.a().c()) {
                k.a().a(stringBufferAppend.toString());
            } else {
                d(context, stringBufferAppend.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i, String str3) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000073&");
                stringBufferAppend.append("network_type=" + w.r(context) + "&");
                stringBufferAppend.append("unit_id=" + str2 + "&");
                stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
                stringBufferAppend.append("reason=" + str3 + "&");
                stringBufferAppend.append("result=" + i + "&");
                stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&");
                stringBufferAppend.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                stringBufferAppend.append("url=" + URLEncoder.encode(str, "utf-8"));
                if (k.a().c()) {
                    k.a().a(stringBufferAppend.toString());
                } else {
                    a(context, stringBufferAppend.toString(), str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000074&");
                stringBufferAppend.append("network_type=" + w.r(context) + "&");
                stringBufferAppend.append("unit_id=" + str2 + "&");
                stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
                stringBufferAppend.append("type=" + i + "&");
                stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&");
                stringBufferAppend.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                stringBufferAppend.append("url=" + URLEncoder.encode(str, "utf-8"));
                if (k.a().c()) {
                    k.a().a(stringBufferAppend.toString());
                } else {
                    a(context, stringBufferAppend.toString(), str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i, int i2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000075&");
                stringBufferAppend.append("network_type=" + w.r(context) + "&");
                stringBufferAppend.append("unit_id=" + str2 + "&");
                stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
                stringBufferAppend.append("type=" + i + "&");
                stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&");
                stringBufferAppend.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                stringBufferAppend.append("statue=" + i2 + "&");
                stringBufferAppend.append("url=" + URLEncoder.encode(str, "utf-8"));
                if (k.a().c()) {
                    k.a().a(stringBufferAppend.toString());
                } else {
                    a(context, stringBufferAppend.toString(), str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, int i, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBufferAppend = new StringBuffer().append("key=2000076&");
                    stringBufferAppend.append("network_type=" + w.r(context) + "&");
                    stringBufferAppend.append("unit_id=" + str2 + "&");
                    stringBufferAppend.append("reason=" + str3 + "&");
                    stringBufferAppend.append("result=" + i + "&");
                    stringBufferAppend.append("url=" + URLEncoder.encode(str, "utf-8"));
                    if (k.a().c()) {
                        k.a().a(stringBufferAppend.toString());
                    } else {
                        a(context, stringBufferAppend.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(final Context context, final String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, a(str, context, str2), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.q.1
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onSuccess(String str3) {
                    aa.d(q.a, str3);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onFailed(String str3) {
                    com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l();
                    lVar.c(str);
                    lVar.a(System.currentTimeMillis());
                    lVar.a(0);
                    lVar.b("POST");
                    lVar.a(com.mbridge.msdk.foundation.same.net.f.d.a().a);
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(lVar);
                    aa.d(q.a, str3);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            aa.d(a, e.getMessage());
        }
    }

    private static void d(final Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, a(str, context), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.q.2
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onSuccess(String str2) {
                    aa.d(q.a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onFailed(String str2) {
                    com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l();
                    lVar.c(str);
                    lVar.a(System.currentTimeMillis());
                    lVar.a(0);
                    lVar.b("POST");
                    lVar.a(com.mbridge.msdk.foundation.same.net.f.d.a().a);
                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(lVar);
                    aa.d(q.a, str2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            aa.d(a, e.getMessage());
        }
    }

    public static void a(String str) {
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.b.d().g());
        String str2 = "key=2000088&state=" + str;
        aa.d(a, str2);
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB == null || a(cVarB, str2)) {
            aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, a(str2, com.mbridge.msdk.foundation.controller.b.d().g(), ""), null);
        }
    }

    public static void a(int i, String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.b.d().g());
            StringBuilder sb = new StringBuilder();
            sb.append("key=").append("2000080").append("&");
            sb.append("reason=").append(str2).append("&");
            sb.append("ad_type=").append(i).append("&");
            sb.append("url=").append(URLEncoder.encode(str, "utf-8"));
            aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, a(sb.toString(), com.mbridge.msdk.foundation.controller.b.d().g(), ""), null);
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
    }

    public static void b(String str) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.b.d().g());
            StringBuilder sb = new StringBuilder();
            sb.append("key=").append("2000090").append("&");
            sb.append("reason=").append(TextUtils.isEmpty(str) ? "" : str).append("&");
            sb.append("result=").append(!TextUtils.isEmpty(str));
            aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, a(sb.toString(), com.mbridge.msdk.foundation.controller.b.d().g(), ""), null);
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
    }

    public static void a(String str, int i, int i2, String str2, int i3, String str3) {
        try {
            HashMap map = new HashMap();
            map.put(SDKConstants.PARAM_KEY, URLEncoder.encode("m_water_mark_result", "utf-8"));
            map.put("water_mark_result", i2 + "");
            map.put("water_mark_error_msg", URLEncoder.encode(str2, "utf-8"));
            map.put("render_result", i3 + "");
            map.put("water_mark_str", URLEncoder.encode(str3, "utf-8"));
            m.a().a("m_water_mark_result", "", str, i + "", map);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i, int i2, String str2, int i3, int i4, int i5, String str3) {
        try {
            HashMap map = new HashMap();
            map.put(SDKConstants.PARAM_KEY, URLEncoder.encode("2000094", "utf-8"));
            if (campaignEx != null) {
                map.put("rid", URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
                map.put("rid_n", URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
                map.put(BidResponsedEx.KEY_CID, URLEncoder.encode(campaignEx.getId(), "utf-8"));
                map.put("lrid", campaignEx.getCurrentLRid());
                ArrayList arrayList = new ArrayList();
                arrayList.add(campaignEx);
                map.putAll(m.a().a(arrayList));
            }
            map.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str, "utf-8"));
            if (i == 0) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = "0";
                }
                map.put("video_prg", str3 + "");
            } else {
                map.put("video_prg", i + "");
            }
            map.put("phase", i2 + "");
            map.put("feedback_content", URLEncoder.encode(str2, "utf-8"));
            map.put("feedback_close", i3 + "");
            map.put("type", i5 + "");
            map.put("ad_type", i4 + "");
            map.put("network_type", URLEncoder.encode(String.valueOf(w.r(com.mbridge.msdk.foundation.controller.b.d().g())), "utf-8"));
            m.a().a("2000094", "", str, i4 + "", map);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i, int i2, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.b.d().g());
            StringBuilder sb = new StringBuilder();
            sb.append(SDKConstants.PARAM_KEY).append("=").append(URLEncoder.encode("2000121", "utf-8")).append("&").append("rid").append("=").append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8")).append("&").append("rid_n").append("=").append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8")).append("&").append(BidResponsedEx.KEY_CID).append("=").append(URLEncoder.encode(campaignEx.getId(), "utf-8")).append("&").append(MBridgeConstans.PROPERTIES_UNIT_ID).append("=").append(URLEncoder.encode(str, "utf-8")).append("&").append("type").append("=").append(i).append("&").append("result").append("=").append(i2).append("&").append("reason").append("=").append(URLEncoder.encode(str2, "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, a(sb.toString(), com.mbridge.msdk.foundation.controller.b.d().g(), str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.q.3
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str3) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str3) {
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, a(str, context), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.q.4
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onSuccess(String str2) {
                    aa.d(q.a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onFailed(String str2) {
                    aa.d(q.a, str2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            aa.d(a, e.getMessage());
        }
    }

    public static void a(Context context, com.mbridge.msdk.foundation.entity.e eVar, String str, boolean z, CampaignUnit campaignUnit) {
        String strD;
        CampaignEx campaignEx;
        if (eVar != null) {
            try {
                strD = eVar.d();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            strD = "";
        }
        if (context == null || TextUtils.isEmpty(strD) || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuffer stringBufferAppend = new StringBuffer().append("key=m_campaign_filtered&");
        if (!TextUtils.isEmpty(str)) {
            String str2 = com.mbridge.msdk.foundation.controller.b.c.get(str);
            stringBufferAppend.append("u_stid=" + (str2 != null ? str2 : "") + "&");
        }
        if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0 && (campaignEx = campaignUnit.getAds().get(0)) != null) {
            z = campaignEx.isBidCampaign();
            stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
            stringBufferAppend.append("adtp=" + campaignEx.getAdType() + "&");
            stringBufferAppend = stringBufferAppend.append("rid=" + campaignEx.getRequestId()).append("&").append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
        }
        stringBufferAppend.append("st=" + System.currentTimeMillis() + "&");
        stringBufferAppend.append("network_type=" + w.r(context) + "&");
        stringBufferAppend.append("unit_id=" + str + "&");
        stringBufferAppend.append("hb=").append(z ? 1 : 0).append("&");
        stringBufferAppend.append("reason=" + strD);
        aa.d("CommonReport", stringBufferAppend.toString());
        if (k.a().c()) {
            k.a().a(stringBufferAppend.toString());
        } else {
            d(context, stringBufferAppend.toString());
        }
    }
}
