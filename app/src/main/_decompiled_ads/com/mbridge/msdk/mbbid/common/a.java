package com.mbridge.msdk.mbbid.common;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.MBConfiguration;

/* JADX INFO: compiled from: AreaBidCommon.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        long jA;
        StringBuffer stringBuffer = new StringBuffer();
        if (context != null) {
            try {
                if (com.mbridge.msdk.foundation.controller.b.d().g() == null) {
                    com.mbridge.msdk.foundation.controller.b.d().b(context);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        com.mbridge.msdk.c.c cVarB = d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB == null) {
            cVarB = d.a().b();
        }
        stringBuffer.append(w.a()).append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(w.k()).append("|");
        stringBuffer.append(w.j()).append("|");
        stringBuffer.append(w.r(context)).append("|");
        stringBuffer.append(MBConfiguration.SDK_VERSION).append("|");
        stringBuffer.append(w.l(context)).append("x").append(w.m(context)).append("|");
        stringBuffer.append(w.l()).append("|");
        stringBuffer.append("|");
        stringBuffer.append(af.a(20)).append("|");
        stringBuffer.append(System.currentTimeMillis()).append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.same.a.a).append("|");
        stringBuffer.append(w.v()).append("|");
        stringBuffer.append(w.t()).append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(ad.b()).append("|");
        stringBuffer.append(ad.a()).append("|");
        try {
            jA = v.a();
        } catch (Exception unused) {
            jA = 0;
        }
        if (jA > 0) {
            stringBuffer.append(jA).append("|");
        } else {
            stringBuffer.append("").append("|");
        }
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.a.a.a.a().b(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)).append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.a.a.a.a().b("c"));
        stringBuffer.append("|").append(w.u());
        stringBuffer.append("|").append(cVarB != null ? cVarB.c() : "");
        stringBuffer.append("|");
        stringBuffer.append(af.f());
        stringBuffer.append("|");
        String strG = af.g();
        if (TextUtils.isEmpty(strG)) {
            strG = "";
        }
        stringBuffer.append(strG);
        stringBuffer.append("|");
        stringBuffer.append(af.m(str));
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append(w.g());
        stringBuffer.append("|");
        stringBuffer.append(w.f(context));
        stringBuffer.append("|");
        stringBuffer.append(w.h() + "");
        stringBuffer.append("|");
        stringBuffer.append(w.c(com.mbridge.msdk.foundation.controller.b.d().i()) + "");
        stringBuffer.append("|");
        stringBuffer.append(w.x());
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.controller.authoritycontroller.a.g() ? "1" : "2");
        stringBuffer.append("|");
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            stringBuffer.append("");
        }
        stringBuffer.append("|").append("");
        stringBuffer.append("|").append("");
        stringBuffer.append("|").append("");
        stringBuffer.append("|").append("1");
        stringBuffer.append("|").append(com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().e());
        stringBuffer.append("|");
        if (w.y() != 0) {
            stringBuffer.append(w.y() + "");
        }
        if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
            stringBuffer.append("|").append(1);
        } else {
            stringBuffer.append("|").append("");
        }
        stringBuffer.append("|").append("");
        stringBuffer.append("|").append(str2);
        stringBuffer.append("|").append(w.e(context));
        stringBuffer.append("|").append(w.d(context));
        stringBuffer.append("|").append(w.e());
        stringBuffer.append("|").append(w.b());
        return u.a(stringBuffer.toString());
    }
}
