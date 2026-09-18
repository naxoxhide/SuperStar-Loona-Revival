package com.mbridge.msdk.mbnative.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.Campaign;
import java.util.List;

/* JADX INFO: compiled from: NativeReport.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void a(final Context context, List<Campaign> list, String str) {
        if (context == null || list == null) {
            return;
        }
        try {
            if (list.size() <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBufferAppend = new StringBuffer().append("key=2000048&");
            stringBufferAppend.append("st=" + System.currentTimeMillis() + "&");
            if (list != null && list.size() > 0) {
                stringBufferAppend = stringBufferAppend.append("cid=" + list.get(0).getId() + "&");
            }
            stringBufferAppend.append("network_type=" + w.r(context) + "&");
            stringBufferAppend.append("unit_id=" + str + "&");
            if (list != null && list.size() > 1) {
                CampaignEx campaignEx = (CampaignEx) list.get(0);
                if (campaignEx.isBidCampaign()) {
                    stringBufferAppend.append("hb=").append(1).append("&");
                }
                if (af.b(campaignEx)) {
                    stringBufferAppend.append("rtins_type=").append(campaignEx.getRtinsType()).append("&");
                }
                stringBufferAppend = stringBufferAppend.append("rid=" + campaignEx.getRequestId() + "&").append("rid_n=" + campaignEx.getRequestIdNotice());
            } else if (list.size() == 1) {
                CampaignEx campaignEx2 = (CampaignEx) list.get(0);
                if (campaignEx2.isBidCampaign()) {
                    stringBufferAppend.append("hb=").append(1).append("&");
                }
                if (af.b(campaignEx2)) {
                    stringBufferAppend.append("rtins_type=").append(campaignEx2.getRtinsType()).append("&");
                }
                stringBufferAppend = stringBufferAppend.append("rid=" + campaignEx2.getRequestId() + "&").append("rid_n=" + campaignEx2.getRequestIdNotice());
            }
            if (k.a().c()) {
                k.a().a(stringBufferAppend.toString());
                return;
            }
            final String string = stringBufferAppend.toString();
            if (context == null || TextUtils.isEmpty(string) || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, d.a().a, q.a(string, context, str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.mbnative.d.a.1
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str2) {
                        aa.d("NativeReport", str2);
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str2) {
                        l lVar = new l();
                        lVar.c(string);
                        lVar.a(System.currentTimeMillis());
                        lVar.a(0);
                        lVar.b("POST");
                        lVar.a(d.a().a);
                        n.a(h.a(context)).a(lVar);
                        aa.d("NativeReport", str2);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aa.d("NativeReport", e.getMessage());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(final Context context, String str, String str2, boolean z, CampaignEx campaignEx) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000047&");
                stringBufferAppend.append("network_type=" + w.r(context) + "&");
                stringBufferAppend.append("unit_id=" + str2 + "&");
                stringBufferAppend.append("st=" + System.currentTimeMillis() + "&");
                if (campaignEx != null) {
                    stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
                    stringBufferAppend.append("adtp=" + campaignEx.getAdType() + "&");
                    stringBufferAppend = stringBufferAppend.append("rid=" + campaignEx.getRequestId()).append("&").append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                }
                if (!TextUtils.isEmpty(str2)) {
                    String str3 = com.mbridge.msdk.foundation.controller.b.c.get(str2);
                    StringBuilder sbAppend = new StringBuilder().append("u_stid=");
                    if (str3 == null) {
                        str3 = "";
                    }
                    stringBufferAppend.append(sbAppend.append(str3).append("&").toString());
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                    stringBufferAppend.append("b=" + com.mbridge.msdk.foundation.same.a.l + "&");
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                    stringBufferAppend.append("c=" + com.mbridge.msdk.foundation.same.a.m + "&");
                }
                if (z) {
                    stringBufferAppend.append("hb=1&");
                }
                stringBufferAppend.append("reason=" + str);
                if (k.a().c()) {
                    k.a().a(stringBufferAppend.toString());
                    return;
                }
                final String string = stringBufferAppend.toString();
                if (context == null || TextUtils.isEmpty(string)) {
                    return;
                }
                try {
                    new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, d.a().a, q.a(string, context), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.mbnative.d.a.2
                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void onSuccess(String str4) {
                            aa.d("NativeReport", str4);
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void onFailed(String str4) {
                            l lVar = new l();
                            lVar.c(string);
                            lVar.a(System.currentTimeMillis());
                            lVar.a(0);
                            lVar.b("POST");
                            lVar.a(d.a().a);
                            n.a(h.a(context)).a(lVar);
                            aa.d("NativeReport", str4);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    aa.d("NativeReport", e.getMessage());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
