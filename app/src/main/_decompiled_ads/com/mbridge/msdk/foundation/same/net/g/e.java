package com.mbridge.msdk.foundation.same.net.g;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonRequestParamsForAdd.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private static String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2149b = "";

    public static void a(d dVar, Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            dVar.a("withGP", w.x() + "");
            dVar.a("has_wx", w.f(context) + "");
            dVar.a("integrated_wx", w.g() + "");
            dVar.a("opensdk_ver", w.h() + "");
            dVar.a("wx_api_ver", w.c(com.mbridge.msdk.foundation.controller.b.d().i()) + "");
            dVar.a("mnc", w.e(com.mbridge.msdk.foundation.controller.b.d().g()));
            dVar.a("mcc", w.d(com.mbridge.msdk.foundation.controller.b.d().g()));
            String strU = w.u();
            if (!TextUtils.isEmpty(strU)) {
                dVar.a("hardware", strU);
            }
            com.mbridge.msdk.foundation.controller.authoritycontroller.a.a();
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DNT, 0) == 1) {
                dVar.a("dnt", "1");
            }
            dVar.a(d.h, com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().e() + "");
            dVar.a("adid_limit", w.b() + "");
            dVar.a("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.a.h() ? "1" : "0");
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
            dVar.a(d.f, ad.b() + "");
            dVar.a(d.g, ad.a() + "");
            dVar.a(d.d, w.s());
        }
        dVar.a("pkg_source", w.a(w.o(context), context));
        if (com.mbridge.msdk.foundation.controller.b.d().l() != null) {
            dVar.a("web_env", com.mbridge.msdk.foundation.controller.b.d().l().toString());
        }
        if (Build.VERSION.SDK_INT > 18) {
            dVar.a("http_req", "2");
        }
        a(dVar, true);
        g(dVar);
        f(dVar);
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB == null) {
            cVarB = com.mbridge.msdk.c.d.a().b();
        }
        if (cVarB.aG() == 1 || cVarB.aB()) {
            dVar.a("gdpr_consent", com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().f() + "");
        }
        h(dVar);
    }

    public static void a(d dVar) {
        dVar.a("api_version", com.mbridge.msdk.foundation.same.a.a);
    }

    public static void b(d dVar) {
        dVar.a("dyview_type", com.mbridge.msdk.foundation.same.a.f2099b);
    }

    public static void c(d dVar) {
        if (w.y() == 0) {
            return;
        }
        dVar.a("tun", w.y() + "");
    }

    public static void d(d dVar) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            dVar.a("withGP", w.x() + "");
            dVar.a("has_wx", w.f(com.mbridge.msdk.foundation.controller.b.d().g()) + "");
            dVar.a("integrated_wx", w.g() + "");
            dVar.a("opensdk_ver", w.h() + "");
            dVar.a("wx_api_ver", w.c(com.mbridge.msdk.foundation.controller.b.d().i()) + "");
            dVar.a("mnc", w.e(com.mbridge.msdk.foundation.controller.b.d().g()));
            dVar.a("mcc", w.d(com.mbridge.msdk.foundation.controller.b.d().g()));
            String strU = w.u();
            if (!TextUtils.isEmpty(strU)) {
                dVar.a("hardware", strU);
            }
            dVar.a("adid_limit", w.b() + "");
            dVar.a("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.a.h() ? "1" : "0");
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
            dVar.a(d.d, w.s());
        }
        a(dVar, false);
        g(dVar);
        f(dVar);
        h(dVar);
    }

    private static void f(d dVar) {
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                com.mbridge.msdk.foundation.same.a.l = com.mbridge.msdk.foundation.a.a.a.a().b(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                dVar.a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                com.mbridge.msdk.foundation.same.a.m = com.mbridge.msdk.foundation.a.a.a.a().b("c");
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                return;
            }
            dVar.a("c", com.mbridge.msdk.foundation.same.a.m);
        } catch (Exception e) {
            aa.d("CommonRequestParamsForAdd", e.getMessage());
        }
    }

    private static void g(d dVar) {
        int iW = w.w();
        if (iW != -1) {
            dVar.a("unknown_source", iW + "");
        }
    }

    private static void a(d dVar, boolean z) {
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB != null) {
            if (!TextUtils.isEmpty(cVarB.c()) && z) {
                dVar.a("a_stid", cVarB.c());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("dmt", w.v() + "");
                    jSONObject.put("dmf", w.t());
                    jSONObject.put("adid_limit", w.b() + "");
                    jSONObject.put("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.a.h() ? "1" : "0");
                }
                if (cVarB.I() == 1 && !TextUtils.isEmpty(w.e()) && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    jSONObject.put("az_aid_info", w.e());
                }
                if (TextUtils.isEmpty(jSONObject.toString())) {
                    return;
                }
                if (!jSONObject.equals(a)) {
                    f2149b = u.a(jSONObject.toString());
                }
                if (TextUtils.isEmpty(f2149b)) {
                    return;
                }
                dVar.a("dvi", f2149b);
            } catch (Exception e) {
                aa.d("CommonRequestParamsForAdd", e.getMessage());
            }
        }
    }

    private static void h(d dVar) {
        String strD = w.d();
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        dVar.a("az_aid_info", strD);
    }

    public static void e(d dVar) {
        if (dVar != null) {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                dVar.a(DeviceRequestsHelper.DEVICE_INFO_MODEL);
                dVar.a("brand");
                dVar.a("screen_size");
                dVar.a("sub_ip");
                dVar.a("network_type");
                dVar.a("useragent");
                dVar.a("ua");
                dVar.a("language");
                dVar.a("network_str");
                dVar.a(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME);
                dVar.a(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE);
                dVar.a("adid_limit");
                dVar.a("adid_limit_dev");
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                dVar.a(d.f);
                dVar.a(d.g);
                dVar.a("power_rate");
                dVar.a("charging");
                dVar.a(TapjoyConstants.TJC_DEVICE_TIMEZONE);
            }
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                return;
            }
            dVar.a("gaid");
            dVar.a("gaid2");
            dVar.a("az_aid_info");
        }
    }
}
