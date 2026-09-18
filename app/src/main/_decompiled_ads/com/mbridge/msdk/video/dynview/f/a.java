package com.mbridge.msdk.video.dynview.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.click.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.Campaign;

/* JADX INFO: compiled from: MOfferReport.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String a = "com.mbridge.msdk.video.dynview.f.a";

    public static void a(CampaignEx campaignEx, Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBufferAppend = new StringBuffer().append("key=2000091&");
                stringBufferAppend.append("network_type=" + w.r(context) + "&");
                stringBufferAppend.append("unit_id=" + str2 + "&");
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                    stringBufferAppend.append("b=" + com.mbridge.msdk.foundation.same.a.l + "&");
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                    stringBufferAppend.append("c=" + com.mbridge.msdk.foundation.same.a.m + "&");
                }
                stringBufferAppend.append("hb=0&");
                if (!TextUtils.isEmpty(str3)) {
                    stringBufferAppend.append("rid_n=").append(str3).append("&");
                }
                stringBufferAppend.append("reason=" + str);
                if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
                    stringBufferAppend.append("&dyview=").append(af.l(campaignEx.getRewardTemplateMode().e()));
                }
                if (k.a().c()) {
                    k.a().a(stringBufferAppend.toString());
                    return;
                }
                String string = stringBufferAppend.toString();
                if (context == null || TextUtils.isEmpty(string)) {
                    return;
                }
                try {
                    new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, d.a().a, q.a(string, context), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.video.dynview.f.a.1
                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void onSuccess(String str4) {
                            aa.d(a.a, str4);
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void onFailed(String str4) {
                            aa.d(a.a, str4);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    aa.d(a, e.getMessage());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009a  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    public static void a(CampaignUnit campaignUnit, int i, int i2, String str) {
        int i3;
        String impressionURL;
        int i4;
        String str2;
        if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0 || campaignUnit.getAds().get(i) == null) {
            return;
        }
        if (i2 == 0 && campaignUnit.getAds().get(i).mMoreOfferImpShow) {
            return;
        }
        String strA = al.a(campaignUnit.getAds().get(i).getendcard_url(), "mof_testuid");
        if (TextUtils.isEmpty(strA)) {
            strA = al.a(campaignUnit.getAds().get(i).getendcard_url(), "mof_uid");
        }
        String str3 = TextUtils.isEmpty(strA) ? str : strA;
        if (i2 == 0) {
            i3 = com.mbridge.msdk.click.a.a.g;
            impressionURL = campaignUnit.getAds().get(i).getImpressionURL();
        } else {
            if (i2 != 1) {
                str2 = "";
                i4 = 0;
            } else {
                i3 = com.mbridge.msdk.click.a.a.h;
                impressionURL = campaignUnit.getAds().get(i).getOnlyImpressionURL();
            }
            if (TextUtils.isEmpty(str2)) {
            }
            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignUnit.getAds().get(i), str3, str2, false, true, i4);
        }
        i4 = i3;
        str2 = impressionURL;
        if (TextUtils.isEmpty(str2)) {
            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignUnit.getAds().get(i), str3, str2, false, true, i4);
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, View view) {
        if (context == null || campaignEx == null) {
            return;
        }
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().l() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
        }
        com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(context, str);
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup) view;
            aVar.a(new g() { // from class: com.mbridge.msdk.video.dynview.f.a.2
                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onStartRedirection(Campaign campaign, String str2) {
                    if (campaign == null) {
                        return;
                    }
                    ae.a(campaign, viewGroup);
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onFinishRedirection(Campaign campaign, String str2) {
                    if (campaign == null) {
                        return;
                    }
                    ae.b(campaign, viewGroup);
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onRedirectionFailed(Campaign campaign, String str2) {
                    if (campaign == null) {
                        return;
                    }
                    ae.b(campaign, viewGroup);
                }
            });
        }
        aVar.a(campaignEx);
    }
}
