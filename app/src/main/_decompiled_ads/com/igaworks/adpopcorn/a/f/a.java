package com.igaworks.adpopcorn.a.f;

import com.adxcorp.util.ADXLogUtil;
import com.google.common.net.HttpHeaders;
import com.igaworks.adpopcorn.nativead.custom.ApCustomRewardCPMModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    /* JADX WARN: Code duplicated, block: B:75:0x0183  */
    public static List<com.igaworks.adpopcorn.cores.model.a> a(String str, int i) {
        int i2;
        String string;
        int i3 = i;
        String str2 = "ImpressionURLs";
        String str3 = "Auth";
        String str4 = "ConditionText";
        String str5 = "PartiTypeCode";
        String str6 = "IntegrationTypeCode";
        String str7 = "IsDeeplink";
        String str8 = "Height";
        String str9 = "Id";
        String str10 = HttpHeaders.WIDTH;
        String str11 = "ImageUrl";
        String str12 = "IconUrl";
        JSONObject jSONObject = new JSONObject(str);
        try {
            String str13 = "CTA";
            boolean z = jSONObject.has("Result") ? jSONObject.getBoolean("Result") : false;
            if (jSONObject.has("IsTest")) {
                com.igaworks.adpopcorn.a.d.E = jSONObject.getBoolean("IsTest");
            }
            if (!z) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                if (!jSONObject.has("CPMCampaigns") || jSONObject.isNull("CPMCampaigns") || jSONObject.getJSONArray("CPMCampaigns").length() <= 0) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(jSONObject.getString("CPMCampaigns"));
                int length = jSONArray.length();
                if (i3 <= 0 || i3 > length) {
                    i3 = length;
                }
                int i4 = 0;
                while (i4 < i3) {
                    com.igaworks.adpopcorn.cores.model.a aVar = new com.igaworks.adpopcorn.cores.model.a();
                    int i5 = i3;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                    if (!jSONObject2.has(str5) || jSONObject2.isNull(str5)) {
                        i2 = 43;
                    } else {
                        i2 = jSONObject2.getInt(str5);
                        aVar.e(i2);
                    }
                    if (jSONObject2.has(str3) && !jSONObject2.isNull(str3)) {
                        aVar.a(jSONObject2.getString(str3));
                    }
                    String str14 = str3;
                    if (!jSONObject2.has(str9) || jSONObject2.isNull(str9)) {
                        str9 = str9;
                    } else {
                        try {
                            try {
                                string = jSONObject2.getString(str9);
                            } catch (Exception unused) {
                                string = jSONObject2.getInt(str9) + "";
                            }
                        } catch (Exception unused2) {
                            string = "0";
                        }
                        if (string != null && string.contentEquals("0")) {
                            string = String.format("%07d", Integer.valueOf(i4 + 1));
                        }
                        aVar.h(string);
                    }
                    if (jSONObject2.has("Key") && !jSONObject2.isNull("Key")) {
                        aVar.c(jSONObject2.getString("Key"));
                    }
                    if (jSONObject2.has("Name") && !jSONObject2.isNull("Name")) {
                        aVar.j(jSONObject2.getString("Name"));
                    }
                    if (jSONObject2.has(str2) && !jSONObject2.isNull(str2)) {
                        JSONArray jSONArray2 = new JSONArray(jSONObject2.getString(str2));
                        if (jSONArray2.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                                arrayList2.add(jSONArray2.getString(i6));
                            }
                            aVar.b(arrayList2);
                        }
                    }
                    if (jSONObject2.has("ClickTrackingURLs") && !jSONObject2.isNull("ClickTrackingURLs")) {
                        JSONArray jSONArray3 = new JSONArray(jSONObject2.getString("ClickTrackingURLs"));
                        if (jSONArray3.length() > 0) {
                            ArrayList arrayList3 = new ArrayList();
                            for (int i7 = 0; i7 < jSONArray3.length(); i7++) {
                                arrayList3.add(jSONArray3.getString(i7));
                            }
                            aVar.a(arrayList3);
                        }
                    }
                    if (jSONObject2.has(ADXLogUtil.EVENT_REWARD) && !jSONObject2.isNull(ADXLogUtil.EVENT_REWARD)) {
                        aVar.c(jSONObject2.getInt(ADXLogUtil.EVENT_REWARD));
                    }
                    if (jSONObject2.has("Title") && !jSONObject2.isNull("Title")) {
                        aVar.k(jSONObject2.getString("Title"));
                    }
                    if (jSONObject2.has("Description") && !jSONObject2.isNull("Description")) {
                        aVar.f(jSONObject2.getString("Description"));
                    }
                    if (jSONObject2.has("ClickUrl") && !jSONObject2.isNull("ClickUrl")) {
                        aVar.d(jSONObject2.getString("ClickUrl"));
                    }
                    str13 = str13;
                    if (jSONObject2.has(str13) && !jSONObject2.isNull(str13)) {
                        aVar.b(jSONObject2.getString(str13));
                    }
                    str12 = str12;
                    if (jSONObject2.has(str12) && !jSONObject2.isNull(str12)) {
                        aVar.g(jSONObject2.getString(str12));
                        aVar.m(jSONObject2.getString(str12));
                    }
                    String str15 = str11;
                    if (jSONObject2.has(str15) && !jSONObject2.isNull(str15)) {
                        aVar.i(jSONObject2.getString(str15));
                        aVar.l(jSONObject2.getString(str15));
                    }
                    String str16 = str10;
                    if (jSONObject2.has(str16) && !jSONObject2.isNull(str16)) {
                        aVar.d(jSONObject2.getInt(str16));
                    }
                    str8 = str8;
                    if (jSONObject2.has(str8) && !jSONObject2.isNull(str8)) {
                        aVar.a(jSONObject2.getInt(str8));
                    }
                    str7 = str7;
                    if (jSONObject2.has(str7) && !jSONObject2.isNull(str7)) {
                        aVar.c(jSONObject2.getBoolean(str7));
                    }
                    str6 = str6;
                    if (jSONObject2.has(str6) && !jSONObject2.isNull(str6)) {
                        aVar.b(jSONObject2.getInt(str6));
                    }
                    String str17 = str4;
                    if (jSONObject2.has(str17) && !jSONObject2.isNull(str17)) {
                        aVar.e(jSONObject2.getString(str17));
                    }
                    if (jSONObject2.has("RewardCurrency") && !jSONObject2.isNull("RewardCurrency")) {
                        aVar.n(jSONObject2.getString("RewardCurrency"));
                    }
                    if (i2 == 43) {
                        aVar.e(true);
                        aVar.a(false);
                    } else {
                        aVar.e(false);
                        aVar.a(true);
                    }
                    arrayList.add(aVar);
                    i4++;
                    str4 = str17;
                    str11 = str15;
                    str10 = str16;
                    i3 = i5;
                    jSONArray = jSONArray;
                    str5 = str5;
                    str3 = str14;
                    str9 = str9;
                    str2 = str2;
                }
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<ApCustomRewardCPMModel> a(List<com.igaworks.adpopcorn.cores.model.a> list) {
        try {
            ArrayList arrayList = new ArrayList();
            for (com.igaworks.adpopcorn.cores.model.a aVar : list) {
                ApCustomRewardCPMModel apCustomRewardCPMModel = new ApCustomRewardCPMModel();
                apCustomRewardCPMModel.setId(aVar.h());
                apCustomRewardCPMModel.setTitle(aVar.m());
                apCustomRewardCPMModel.setDescription(aVar.g());
                apCustomRewardCPMModel.setImageURL(aVar.i());
                apCustomRewardCPMModel.setCondition(aVar.f());
                apCustomRewardCPMModel.setCta(aVar.b());
                apCustomRewardCPMModel.setReward(aVar.l());
                arrayList.add(apCustomRewardCPMModel);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
