package com.mbridge.msdk.splash.e;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.net.URLEncoder;

/* JADX INFO: compiled from: SplashReport.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void a(Context context, CampaignEx campaignEx, String str, String str2, long j, int i) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isMraid()) {
                    n nVar = new n();
                    nVar.m(campaignEx.getRequestId());
                    nVar.o(campaignEx.getRequestIdNotice());
                    nVar.q(campaignEx.getId());
                    nVar.e(i);
                    nVar.t(String.valueOf(System.currentTimeMillis() - j));
                    nVar.f("");
                    nVar.s(str2);
                    nVar.h("6");
                    nVar.b(n.a);
                    com.mbridge.msdk.foundation.same.report.n.b(nVar, str, campaignEx);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(String str, CampaignEx campaignEx) {
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        n nVar = new n("2000061", campaignEx.getId(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), str, w.r(b.d().g()));
        nVar.b(n.a);
        com.mbridge.msdk.foundation.same.report.n.b(nVar, b.d().g(), str);
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(b.d().g());
            StringBuilder sb = new StringBuilder();
            if (campaignEx.isBidCampaign()) {
                sb.append("hb=").append(1).append("&");
            }
            sb.append(SDKConstants.PARAM_KEY).append("=").append(URLEncoder.encode("2000070", "utf-8")).append("&").append("rid").append("=").append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8")).append("&").append("rid_n").append("=").append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8")).append("&").append(BidResponsedEx.KEY_CID).append("=").append(URLEncoder.encode(campaignEx.getId(), "utf-8")).append("&").append(MBridgeConstans.PROPERTIES_UNIT_ID).append("=").append(URLEncoder.encode(str, "utf-8")).append("&").append(CampaignEx.JSON_KEY_CLICK_URL).append("=").append(URLEncoder.encode(str2, "utf-8")).append("&").append("network_type").append("=").append(URLEncoder.encode(String.valueOf(w.r(b.d().g())), "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
            } else {
                aVar.post(0, d.a().a, q.a(sb.toString(), b.d().g(), str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.splash.e.a.1
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

    public static void a(CampaignEx campaignEx, String str, String str2) {
        a(campaignEx, str, 2, str2);
    }

    public static void a(CampaignEx campaignEx, String str) {
        a(campaignEx, "", 1, str);
    }

    private static void a(CampaignEx campaignEx, String str, int i, String str2) {
        a(com.mbridge.msdk.splash.a.b.a().c(campaignEx.getId()).b(str2).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).f(str).b(i).a(campaignEx.isBidCampaign()), str2);
    }

    private static void a(com.mbridge.msdk.splash.a.b bVar, String str) {
        if (bVar != null) {
            bVar.a("2000068");
            if (k.a().c()) {
                k.a().a(bVar.b());
            } else {
                com.mbridge.msdk.foundation.same.report.n.a(bVar.b(), b.d().g(), str);
            }
        }
    }

    public static void a(com.mbridge.msdk.splash.a.b bVar, String str, int i) {
        if (bVar != null) {
            bVar.a("2000069");
            bVar.a(i);
            if (k.a().c()) {
                k.a().a(bVar.b());
            } else {
                com.mbridge.msdk.foundation.same.report.n.a(bVar.b(), b.d().g(), str);
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
    }

    public static void b(CampaignEx campaignEx, String str) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(b.d().g());
            StringBuilder sb = new StringBuilder();
            sb.append(SDKConstants.PARAM_KEY).append("=").append(URLEncoder.encode("2000092", "utf-8")).append("&").append("rid").append("=").append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8")).append("&").append("rid_n").append("=").append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8")).append("&").append(BidResponsedEx.KEY_CID).append("=").append(URLEncoder.encode(campaignEx.getId(), "utf-8")).append("&").append(MBridgeConstans.PROPERTIES_UNIT_ID).append("=").append(URLEncoder.encode(str, "utf-8")).append("&").append("network_type").append("=").append(URLEncoder.encode(String.valueOf(w.r(b.d().g())), "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
            } else {
                aVar.post(0, d.a().a, q.a(sb.toString(), b.d().g(), str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.splash.e.a.2
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str2) {
                        aa.a("", "FLBClick REPORT SUCCESS");
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str2) {
                        aa.a("", "FLBClick REPORT FAILED");
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
