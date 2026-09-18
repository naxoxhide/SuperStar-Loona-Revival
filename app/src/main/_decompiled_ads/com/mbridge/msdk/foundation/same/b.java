package com.mbridge.msdk.foundation.same;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;

/* JADX INFO: compiled from: SameTools.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static int a(CampaignEx campaignEx, String str) {
        int iL;
        if (campaignEx == null) {
            return -1;
        }
        try {
            if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                iL = af.l(campaignEx.getMof_template_url());
            } else {
                iL = af.l(str);
            }
            return iL;
        } catch (Exception e) {
            aa.d("SameTools", e.getMessage());
            return -1;
        }
    }
}
