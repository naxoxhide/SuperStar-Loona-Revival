package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: RewardReport.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {
    private static final String a = "com.mbridge.msdk.video.bt.module.b.f";

    private static void a(final Context context, final String str, String str2) {
        if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
            context = com.mbridge.msdk.foundation.controller.b.d().g();
        }
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(context);
            com.mbridge.msdk.foundation.same.net.g.d dVarA = q.a(str, context, str2);
            dVarA.a("r_stid", com.mbridge.msdk.videocommon.d.b.a().b().b());
            aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, dVarA, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.video.bt.module.b.f.1
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onSuccess(String str3) {
                    aa.d(f.a, str3);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onFailed(final String str3) {
                    com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.b.f.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            l lVar = new l();
                            lVar.c(str);
                            lVar.a(System.currentTimeMillis());
                            lVar.a(0);
                            lVar.b("POST");
                            lVar.a(com.mbridge.msdk.foundation.same.net.f.d.a().a);
                            n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(lVar);
                            aa.d(f.a, str3);
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            aa.d(a, e.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, int i) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBufferAppend = new StringBuffer().append("key=2000054&");
            stringBufferAppend.append("network_type=" + w.r(context) + "&");
            stringBufferAppend.append("unit_id=" + str + "&");
            stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
            stringBufferAppend.append("reason=&");
            stringBufferAppend.append("templateshowtype=" + i + " offer show success&");
            stringBufferAppend.append("result=2&");
            if (campaignEx != null && campaignEx.getAdType() == 287) {
                stringBufferAppend.append("ad_type=3&");
            } else if (campaignEx == null || campaignEx.getAdType() == 94) {
                stringBufferAppend.append("ad_type=1&");
            } else {
                stringBufferAppend.append("ad_type=1&");
            }
            String str2 = campaignEx.getendcard_url();
            if (!TextUtils.isEmpty(str2)) {
                stringBufferAppend.append("creative=" + URLEncoder.encode(str2) + "&");
            }
            stringBufferAppend.append("devid=" + w.a() + "&");
            if (campaignEx != null) {
                stringBufferAppend = stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&").append("rid_n=" + campaignEx.getRequestIdNotice()).append("&");
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

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000054&");
                stringBufferAppend.append("network_type=" + w.r(context) + "&");
                stringBufferAppend.append("unit_id=" + str + "&");
                stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
                stringBufferAppend.append("reason=" + str2 + "&");
                stringBufferAppend.append("templateshowtype=" + i + "&");
                stringBufferAppend.append("reason=" + str2 + "&");
                stringBufferAppend.append("result=1&");
                if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                    stringBufferAppend.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                }
                stringBufferAppend.append("devid=" + w.a() + "&");
                if (campaignEx != null && campaignEx.getAdType() == 287) {
                    stringBufferAppend.append("ad_type=3&");
                } else if (campaignEx == null || campaignEx.getAdType() == 94) {
                    stringBufferAppend.append("ad_type=1&");
                } else {
                    stringBufferAppend.append("ad_type=1&");
                }
                if (campaignEx != null) {
                    stringBufferAppend = stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&").append("rid_n=" + campaignEx.getRequestIdNotice()).append("&").append("adspace_t=" + campaignEx.getAdSpaceT());
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

    public static void a(Context context, List<CampaignEx> list, String str) {
        if (context == null || list == null) {
            return;
        }
        try {
            if (list.size() <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBufferAppend = new StringBuffer().append("key=2000054&");
            stringBufferAppend.append("network_type=" + w.r(context) + "&");
            stringBufferAppend.append("unit_id=" + str + "&");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).getId());
            }
            stringBufferAppend.append("cid=" + arrayList.toString() + "&");
            stringBufferAppend.append("result=2&");
            if (list.get(0) != null) {
                CampaignEx campaignEx = list.get(0);
                stringBufferAppend.append("reason=&");
                stringBufferAppend.append("templateshowtype=two offer ec show success&");
                stringBufferAppend.append("ad_type=" + campaignEx.getAdType() + "&");
                stringBufferAppend.append("devid=" + w.a() + "&");
                stringBufferAppend = stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&").append("rid_n=" + campaignEx.getRequestIdNotice()).append("&");
                stringBufferAppend.append("&adspace_t=").append(campaignEx.getAdSpaceT());
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

    public static void a(Context context, List<CampaignEx> list, String str, String str2) {
        if (context == null || list == null) {
            return;
        }
        try {
            if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000054&");
                stringBufferAppend.append("network_type=" + w.r(context) + "&");
                stringBufferAppend.append("unit_id=" + str + "&");
                String[] strArr = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    strArr[i] = list.get(i).getId();
                }
                stringBufferAppend.append("cid=" + strArr + "&");
                stringBufferAppend.append("reason=" + str2 + "&");
                stringBufferAppend.append("result=1&");
                stringBufferAppend.append("devid=" + w.a() + "&");
                if (list.get(0) != null) {
                    CampaignEx campaignEx = list.get(0);
                    stringBufferAppend.append("ad_type=" + campaignEx.getAdType() + "&");
                    stringBufferAppend = stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&").append("rid_n=" + campaignEx.getRequestIdNotice()).append("&").append("templateshowtype=" + campaignEx.getMof_tplid()).append("&").append("adspace_t=" + campaignEx.getAdSpaceT());
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

    public static void a(CampaignEx campaignEx, String str, int i) {
        try {
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            if (contextG != null && campaignEx != null && !TextUtils.isEmpty(str)) {
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000115&");
                stringBufferAppend.append("network_type=" + w.r(contextG) + "&");
                stringBufferAppend.append("unit_id=" + str + "&");
                stringBufferAppend.append("cid=" + campaignEx.getId() + "&");
                stringBufferAppend.append("play_cur_time=" + i + "&");
                stringBufferAppend.append("reason=close ad in advance " + campaignEx.getMof_tplid() + "&");
                stringBufferAppend.append("result=1&");
                stringBufferAppend.append("devid=" + w.a() + "&");
                stringBufferAppend.append("ad_type=" + campaignEx.getAdType() + "&");
                StringBuffer stringBufferAppend2 = stringBufferAppend.append("rid=").append(campaignEx.getRequestId()).append("&").append("rid_n=" + campaignEx.getRequestIdNotice()).append("&").append("adspace_t=" + campaignEx.getAdSpaceT());
                if (k.a().c()) {
                    k.a().a(stringBufferAppend2.toString());
                } else {
                    a(contextG, stringBufferAppend2.toString(), str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
