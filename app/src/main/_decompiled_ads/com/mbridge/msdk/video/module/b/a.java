package com.mbridge.msdk.video.module.b;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.al;
import java.util.Map;

/* JADX INFO: compiled from: RewardDynamicViewReporter.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void a(String str, CampaignEx campaignEx, Map<String, String> map) {
        String strA;
        String strA2;
        if (TextUtils.isEmpty(str) || campaignEx == null || map == null) {
            return;
        }
        String strA3 = "";
        if (campaignEx != null) {
            try {
                String currentLRid = campaignEx.getCurrentLRid();
                String mof_template_url = campaignEx.getMof_template_url();
                if (TextUtils.isEmpty(mof_template_url)) {
                    strA = "";
                    strA2 = strA;
                } else {
                    strA2 = al.a(mof_template_url, "cltp");
                    strA = al.a(mof_template_url, "xt");
                }
                if (!TextUtils.isEmpty(strA2)) {
                    map.put("cltp", strA2);
                }
                if (!TextUtils.isEmpty(strA)) {
                    map.put("xt", strA);
                }
                CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                if (rewardTemplateMode != null) {
                    String strE = rewardTemplateMode.e();
                    if (!TextUtils.isEmpty(strE)) {
                        strA3 = al.a(strE, "alecfc");
                    }
                }
                if (!TextUtils.isEmpty(strA3)) {
                    map.put("alecfc", strA3);
                }
                strA3 = currentLRid;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (map.get("type").equals("choseFromTwoShow")) {
            m.a().b(str, strA3, map);
        } else {
            m.a().a(str, strA3, map);
        }
    }
}
