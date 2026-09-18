package com.mbridge.msdk.mbbanner.common.d;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.n;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: compiled from: BannerReport.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void a(String str, CampaignEx campaignEx, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(b.d().g());
            StringBuilder sb = new StringBuilder();
            if (campaignEx.isBidCampaign()) {
                sb.append("hb=").append(1).append("&");
            }
            sb.append(SDKConstants.PARAM_KEY).append("=").append(URLEncoder.encode("2000070", "utf-8")).append("&").append("rid_n").append("=").append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8")).append("&").append("rid").append("=").append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8")).append("&").append(BidResponsedEx.KEY_CID).append("=").append(URLEncoder.encode(campaignEx.getId(), "utf-8")).append("&").append(MBridgeConstans.PROPERTIES_UNIT_ID).append("=").append(URLEncoder.encode(str, "utf-8")).append("&").append(CampaignEx.JSON_KEY_CLICK_URL).append("=").append(URLEncoder.encode(str2, "utf-8")).append("&").append("network_type").append("=").append(URLEncoder.encode(String.valueOf(w.r(b.d().g())), "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
            } else {
                aVar.post(0, d.a().a, q.a(sb.toString(), b.d().g(), str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.mbbanner.common.d.a.1
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

    public static void a(com.mbridge.msdk.mbbanner.common.a.a aVar, String str) {
        if (aVar != null) {
            aVar.a("2000068");
            if (k.a().c()) {
                k.a().a(aVar.b());
            } else {
                n.a(aVar.b(), b.d().g(), str);
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, int i) {
        m.a().a(str, str3, str4, str2, i + "", new HashMap());
    }
}
