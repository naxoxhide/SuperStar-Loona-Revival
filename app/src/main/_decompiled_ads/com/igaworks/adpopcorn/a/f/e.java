package com.igaworks.adpopcorn.a.f;

import android.content.Context;
import com.adxcorp.util.ADXLogUtil;
import com.igaworks.adpopcorn.cores.model.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static List<h> a(Context context, String str) {
        JSONObject jSONObject = new JSONObject(str);
        try {
            boolean z = jSONObject.has("Result") ? jSONObject.getBoolean("Result") : false;
            if (jSONObject.has("IsTest")) {
                com.igaworks.adpopcorn.a.d.E = jSONObject.getBoolean("IsTest");
            }
            if (!z || jSONObject.getJSONArray("Campaigns").length() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(jSONObject.getString("Campaigns"));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("Key") && !jSONObject2.isNull("Key") && com.igaworks.adpopcorn.a.b.a().d(context, jSONObject2.getString("Key"))) {
                    com.igaworks.adpopcorn.cores.common.h.a(context, "APPopupAdInfoJsonParser", "already impressed this popup ad : " + jSONObject2.getString("Key"), 3);
                } else {
                    h hVar = new h();
                    if (jSONObject2.has("Key") && !jSONObject2.isNull("Key")) {
                        hVar.b(jSONObject2.getString("Key"));
                    }
                    if (jSONObject2.has("Auth") && !jSONObject2.isNull("Auth")) {
                        hVar.a(jSONObject2.getString("Auth"));
                    }
                    if (jSONObject2.has("PopupTitle")) {
                        hVar.g(jSONObject2.getString("PopupTitle"));
                    }
                    if (jSONObject2.has("PopupDesc")) {
                        hVar.c(jSONObject2.getString("PopupDesc"));
                    }
                    if (jSONObject2.has("PopupRewardCondition")) {
                        hVar.f(jSONObject2.getString("PopupRewardCondition"));
                    }
                    if (jSONObject2.has("PopupPortraitImgURL")) {
                        hVar.e(jSONObject2.getString("PopupPortraitImgURL"));
                    }
                    if (jSONObject2.has("PopupLandscapeImgURL")) {
                        hVar.d(jSONObject2.getString("PopupLandscapeImgURL"));
                    }
                    if (jSONObject2.has(ADXLogUtil.EVENT_REWARD) && !jSONObject2.isNull(ADXLogUtil.EVENT_REWARD)) {
                        hVar.h(jSONObject2.getString(ADXLogUtil.EVENT_REWARD));
                    }
                    arrayList.add(hVar);
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
