package com.mbridge.msdk.splash.a.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SplashUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String a = "a";

    public static CampaignEx a(String str, CampaignEx campaignEx) throws JSONException {
        String strValueOf;
        String strValueOf2;
        if (TextUtils.isEmpty(str)) {
            return campaignEx;
        }
        if (TextUtils.isEmpty(str) && campaignEx == null) {
            return null;
        }
        if (!str.contains("notice")) {
            try {
                JSONObject jSONObjectCampaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject);
                if (campaignWithBackData == null) {
                    campaignWithBackData = campaignEx;
                }
                if (!TextUtils.isEmpty(str)) {
                    String strOptString = jSONObjectCampaignToJsonObject.optString("unitId");
                    if (!TextUtils.isEmpty(strOptString)) {
                        campaignWithBackData.setCampaignUnitId(strOptString);
                    }
                    JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(com.mbridge.msdk.foundation.same.a.h);
                    if (jSONObjectOptJSONObject != null) {
                        String string = jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.f);
                        String string2 = jSONObjectOptJSONObject.getString(com.mbridge.msdk.foundation.same.a.g);
                        if (TextUtils.isEmpty(string)) {
                            string = "-999";
                        }
                        int i = Integer.parseInt(string);
                        if (TextUtils.isEmpty(string2)) {
                            string2 = "-999";
                        }
                        int i2 = Integer.parseInt(string2);
                        strValueOf = i != -999 ? String.valueOf(af.b(b.d().g(), i)) : "-999";
                        strValueOf2 = i2 != -999 ? String.valueOf(af.b(b.d().g(), i2)) : "-999";
                    } else {
                        strValueOf = "-999";
                        strValueOf2 = strValueOf;
                    }
                    campaignWithBackData.setClickURL(com.mbridge.msdk.click.b.a(campaignWithBackData.getClickURL(), strValueOf, strValueOf2));
                    String noticeUrl = campaignWithBackData.getNoticeUrl();
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        StringBuilder sb = new StringBuilder();
                        while (itKeys.hasNext()) {
                            StringBuilder sbAppend = sb.append("&");
                            String next = itKeys.next();
                            String strOptString2 = jSONObjectOptJSONObject.optString(next);
                            if (com.mbridge.msdk.foundation.same.a.f.equals(next) || com.mbridge.msdk.foundation.same.a.g.equals(next)) {
                                if (TextUtils.isEmpty(strOptString2)) {
                                    strOptString2 = "-999";
                                }
                                int i3 = Integer.parseInt(strOptString2);
                                strOptString2 = i3 != -999 ? String.valueOf(af.b(b.d().g(), i3)) : "-999";
                            }
                            sb = sbAppend.append(next).append("=").append(strOptString2);
                        }
                        campaignWithBackData.setNoticeUrl(noticeUrl + ((Object) sb));
                    }
                }
                return campaignWithBackData;
            } catch (Throwable unused) {
                return campaignEx;
            }
        }
        try {
            JSONObject jSONObjectCampaignToJsonObject2 = CampaignEx.campaignToJsonObject(campaignEx);
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                    jSONObjectCampaignToJsonObject2.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                }
            } catch (Exception unused2) {
            }
            Iterator<String> itKeys2 = jSONObject.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                jSONObjectCampaignToJsonObject2.put(next2, jSONObject.getString(next2));
            }
            CampaignEx campaignWithBackData2 = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject2);
            String strOptString3 = jSONObjectCampaignToJsonObject2.optString("unitId");
            if (!TextUtils.isEmpty(strOptString3)) {
                campaignWithBackData2.setCampaignUnitId(strOptString3);
            }
            return campaignWithBackData2;
        } catch (JSONException e) {
            e.printStackTrace();
            return campaignEx;
        }
    }

    public static String a(int i, float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (i == 4) {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f, -999);
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.g, -999);
            } else {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f, af.a(b.d().g(), f));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.g, af.a(b.d().g(), f2));
            }
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.i, i);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.j, b.d().g().getResources().getConfiguration().orientation);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.k, af.e(b.d().g()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.h, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
