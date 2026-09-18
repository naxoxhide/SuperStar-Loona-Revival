package com.mbridge.msdk.mbsignalcommon.communication;

import android.text.TextUtils;
import android.util.Base64;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonSignalCommunicatioImpUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static final String a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f2325b = 0;
    public static int c = 1;

    public static void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            final CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject);
            if (campaignWithBackData == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.communication.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k kVarA = k.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                        if (kVarA != null) {
                            if (!kVarA.a(campaignWithBackData.getId())) {
                                g gVar = new g();
                                gVar.a(campaignWithBackData.getId());
                                gVar.a(campaignWithBackData.getFca());
                                gVar.b(campaignWithBackData.getFcb());
                                gVar.d(0);
                                gVar.c(1);
                                gVar.a(System.currentTimeMillis());
                                kVarA.a(gVar);
                            } else {
                                kVarA.b(campaignWithBackData.getId());
                            }
                        }
                        b.a(campaignWithBackData.getCampaignUnitId(), campaignWithBackData);
                    } catch (Throwable th) {
                        aa.b(b.a, th.getMessage(), th);
                    }
                }
            }).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", f2325b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e) {
                a(obj, e.getMessage());
                aa.a(a, e.getMessage());
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public static String a(float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f, af.a(com.mbridge.msdk.foundation.controller.b.d().g(), f));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.g, af.a(com.mbridge.msdk.foundation.controller.b.d().g(), f2));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.i, 0);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.j, com.mbridge.msdk.foundation.controller.b.d().g().getResources().getConfiguration().orientation);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.k, af.e(com.mbridge.msdk.foundation.controller.b.d().g()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.h, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            aa.d(a, "code to string is error");
            return "";
        }
    }

    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            aa.a(a, e.getMessage());
        }
    }

    static /* synthetic */ void a(String str, CampaignEx campaignEx) {
        if (d.g == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        d.a(str, campaignEx, ReportUtil.INVENTORY_TYPE_BANNER);
    }
}
