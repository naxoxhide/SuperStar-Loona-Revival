package com.igaworks.adpopcorn.a.f;

import com.adxcorp.util.ADXLogUtil;
import com.igaworks.adpopcorn.cores.model.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static j a(String str) {
        boolean z;
        j jVar = new j();
        try {
            jVar.b(false);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("Result")) {
                boolean z2 = jSONObject.getBoolean("Result");
                jVar.b(z2);
                z = z2;
            } else {
                z = false;
            }
            if (jSONObject.has("IsTest")) {
                com.igaworks.adpopcorn.a.d.E = jSONObject.getBoolean("IsTest");
            }
            if (jSONObject.has("ResultCode")) {
                jVar.b(jSONObject.getInt("ResultCode"));
            }
            if (jSONObject.has("ResultMsg")) {
                jVar.k(jSONObject.getString("ResultMsg"));
            }
            if (z) {
                if (jSONObject.has("LandscapeImageURL")) {
                    jVar.f(jSONObject.getString("LandscapeImageURL"));
                }
                if (jSONObject.has("IconImageURL")) {
                    jVar.e(jSONObject.getString("IconImageURL"));
                }
                if (jSONObject.has("Name")) {
                    jVar.h(jSONObject.getString("Name"));
                }
                if (jSONObject.has("Desc")) {
                    jVar.d(jSONObject.getString("Desc"));
                }
                if (jSONObject.has("VideoURL")) {
                    jVar.o(jSONObject.getString("VideoURL"));
                }
                if (jSONObject.has("RedirectURL")) {
                    jVar.j(jSONObject.getString("RedirectURL"));
                }
                if (jSONObject.has("AverageRating")) {
                    jVar.a(jSONObject.getDouble("AverageRating"));
                }
                if (jSONObject.has("NumberOfDownloads") && !jSONObject.isNull("NumberOfDownloads")) {
                    jVar.i(jSONObject.getString("NumberOfDownloads"));
                }
                if (jSONObject.has("ADType")) {
                    jVar.a(jSONObject.getInt("ADType"));
                }
                if (jSONObject.has("ClickAction") && !jSONObject.isNull("ClickAction")) {
                    jVar.c(jSONObject.getString("ClickAction"));
                }
                if (jSONObject.has("Auth") && !jSONObject.isNull("Auth")) {
                    jVar.a(jSONObject.getString("Auth"));
                }
                if (jSONObject.has("Key") && !jSONObject.isNull("Key")) {
                    jVar.b(jSONObject.getString("Key"));
                }
                if (jSONObject.has("AutoRedirect") && !jSONObject.isNull("AutoRedirect")) {
                    jVar.a(jSONObject.getBoolean("AutoRedirect"));
                }
                if (jSONObject.has("SkipAllowSeconds") && !jSONObject.isNull("SkipAllowSeconds")) {
                    jVar.c(jSONObject.getInt("SkipAllowSeconds"));
                }
                if (jSONObject.has("VideoImpressionURL") && !jSONObject.isNull("VideoImpressionURL")) {
                    jVar.n(jSONObject.getString("VideoImpressionURL"));
                }
                if (jSONObject.has("MoreClickReportURL") && !jSONObject.isNull("MoreClickReportURL")) {
                    jVar.g(jSONObject.getString("MoreClickReportURL"));
                }
            }
            return jVar;
        } catch (Exception e) {
            e.printStackTrace();
            return jVar;
        }
    }

    public static List<j> b(String str) {
        String str2 = "ADType";
        String str3 = "AverageRating";
        String str4 = "RedirectURL";
        String str5 = "VideoURL";
        String str6 = "PartiTypeCode";
        String str7 = "RewardCondition";
        String str8 = "SkipAllowSeconds";
        String str9 = ADXLogUtil.EVENT_REWARD;
        String str10 = "Key";
        JSONObject jSONObject = new JSONObject(str);
        try {
            boolean z = jSONObject.has("Result") ? jSONObject.getBoolean("Result") : false;
            if (jSONObject.has("IsTest")) {
                com.igaworks.adpopcorn.a.d.E = jSONObject.getBoolean("IsTest");
            }
            if (!z || jSONObject.getJSONArray("Videos").length() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(jSONObject.getString("Videos"));
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < jSONArray.length()) {
                j jVar = new j();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("LandscapeImageURL")) {
                    jVar.f(jSONObject2.getString("LandscapeImageURL"));
                }
                if (jSONObject2.has("IconImageURL")) {
                    jVar.e(jSONObject2.getString("IconImageURL"));
                }
                if (jSONObject2.has("Title")) {
                    jVar.h(jSONObject2.getString("Title"));
                }
                if (jSONObject2.has("Desc")) {
                    jVar.d(jSONObject2.getString("Desc"));
                }
                if (jSONObject2.has(str5)) {
                    jVar.o(jSONObject2.getString(str5));
                }
                if (jSONObject2.has(str4)) {
                    jVar.j(jSONObject2.getString(str4));
                }
                if (jSONObject2.has(str3)) {
                    jVar.a(jSONObject2.getDouble(str3));
                }
                if (jSONObject2.has("NumberOfDownloads") && !jSONObject2.isNull("NumberOfDownloads")) {
                    jVar.i(jSONObject2.getString("NumberOfDownloads"));
                }
                if (jSONObject2.has(str2)) {
                    jVar.a(jSONObject2.getInt(str2));
                }
                if (jSONObject2.has("ClickAction") && !jSONObject2.isNull("ClickAction")) {
                    jVar.c(jSONObject2.getString("ClickAction"));
                }
                if (jSONObject2.has("Auth") && !jSONObject2.isNull("Auth")) {
                    jVar.a(jSONObject2.getString("Auth"));
                }
                String str11 = str10;
                if (jSONObject2.has(str11) && !jSONObject2.isNull(str11)) {
                    jVar.b(jSONObject2.getString(str11));
                }
                String str12 = str9;
                if (jSONObject2.has(str12) && !jSONObject2.isNull(str12)) {
                    jVar.m(jSONObject2.getString(str12));
                }
                String str13 = str8;
                if (jSONObject2.has(str13) && !jSONObject2.isNull(str13)) {
                    jVar.c(jSONObject2.getInt(str13));
                }
                String str14 = str7;
                if (jSONObject2.has(str14) && !jSONObject2.isNull(str14)) {
                    jVar.l(jSONObject2.getString(str14));
                }
                String str15 = str6;
                if (jSONObject2.has(str15) && !jSONObject2.isNull(str15)) {
                    jVar.d(jSONObject2.getInt(str15));
                }
                arrayList.add(jVar);
                i++;
                str6 = str15;
                str10 = str11;
                str4 = str4;
                str2 = str2;
                jSONArray = jSONArray;
                str9 = str12;
                str5 = str5;
                str7 = str14;
                str3 = str3;
                str8 = str13;
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
