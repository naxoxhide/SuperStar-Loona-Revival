package com.mbridge.msdk.click.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y;
import java.io.File;

/* JADX INFO: compiled from: DspFilterUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static int a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f1931b = 2;
    public static int c = 1500;
    private static String d = "2000109";
    private static String e = "DspFilterUtils";

    public static boolean a(CampaignEx campaignEx, String str, int i) {
        boolean z = false;
        if (campaignEx != null && campaignEx.getTpOffer() == 1) {
            z = campaignEx.getFac() != 0;
            try {
                Context contextG = b.d().g();
                if (contextG != null && campaignEx != null) {
                    if (URLUtil.isFileUrl(str)) {
                        File file = new File(str.replace("file:////", "").replace("file:///", "").replace("file://", ""));
                        if (file.exists()) {
                            str = y.a(file);
                        }
                    }
                    StringBuffer stringBufferAppend = new StringBuffer().append("key=" + d + "&").append("type=" + i + "&").append("html=" + str + "&");
                    stringBufferAppend.append("network_type=" + w.r(contextG) + "&");
                    stringBufferAppend.append("unit_id=" + campaignEx.getCampaignUnitId() + "&");
                    String requestId = campaignEx.getRequestId();
                    if (!TextUtils.isEmpty(requestId)) {
                        stringBufferAppend.append("rid=").append(requestId).append("&");
                    }
                    if (campaignEx.isBidCampaign()) {
                        stringBufferAppend.append("hb=").append("1").append("&");
                    }
                    String requestIdNotice = campaignEx.getRequestIdNotice();
                    if (!TextUtils.isEmpty(requestIdNotice)) {
                        stringBufferAppend = stringBufferAppend.append("rid_n=").append(requestIdNotice).append("&");
                    }
                    StringBuffer stringBufferAppend2 = stringBufferAppend.append("cid=" + campaignEx.getId());
                    if (k.a().c()) {
                        k.a().a(stringBufferAppend2.toString());
                    } else {
                        q.b(contextG, stringBufferAppend2.toString());
                    }
                }
            } catch (Throwable th) {
                aa.d(e, th.getMessage());
            }
        }
        return z;
    }
}
