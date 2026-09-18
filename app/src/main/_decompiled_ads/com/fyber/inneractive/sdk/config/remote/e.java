package com.fyber.inneractive.sdk.config.remote;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<h> f893b = null;
    public String c;
    public String d;

    /* JADX WARN: Code duplicated, block: B:25:0x00aa  */
    public static e a(JSONObject jSONObject) throws InvalidAppIdException {
        a aVar;
        JSONArray jSONArray;
        String str;
        String str2;
        Object obj;
        String str3;
        ArrayList arrayList;
        String str4 = null;
        String strOptString = jSONObject.optString("updateHash", null);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        e eVar = new e();
        eVar.c = strOptString;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app");
        int iOptInt = jSONObjectOptJSONObject == null ? -1 : jSONObjectOptJSONObject.optInt("id", -1);
        String str5 = "isActive";
        if (iOptInt == -1) {
            aVar = null;
        } else {
            aVar = new a();
            aVar.a = String.valueOf(iOptInt);
            aVar.f891b = jSONObjectOptJSONObject.optString("publisherId", null);
            aVar.c = f.a(jSONObjectOptJSONObject.optJSONObject("monitor"));
            aVar.d = j.a(jSONObjectOptJSONObject.optJSONObject("video"));
            aVar.e = b.a(jSONObjectOptJSONObject.optJSONObject("display"));
            aVar.f = k.a(jSONObjectOptJSONObject.optJSONObject("viewability"));
            aVar.g = jSONObjectOptJSONObject.optString("isActive", null);
            g.a(jSONObjectOptJSONObject.optJSONObject("native"));
        }
        if (aVar == null) {
            return null;
        }
        eVar.a = aVar;
        ArrayList arrayList2 = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("spots");
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            while (i < jSONArrayOptJSONArray.length()) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 == null) {
                    jSONArray = jSONArrayOptJSONArray;
                    String str6 = str4;
                    str = str5;
                    str2 = str6;
                    obj = str6;
                } else {
                    String strOptString2 = jSONObjectOptJSONObject2.optString("id", str4);
                    if (TextUtils.isEmpty(strOptString2)) {
                        jSONArray = jSONArrayOptJSONArray;
                        String str7 = str4;
                        str = str5;
                        str2 = str7;
                        obj = str7;
                    } else {
                        h hVar = new h();
                        hVar.a = strOptString2;
                        hVar.f894b = jSONObjectOptJSONObject2.optString(str5, str4);
                        hVar.c = b.a(jSONObjectOptJSONObject2.optJSONObject("display"));
                        hVar.d = f.a(jSONObjectOptJSONObject2.optJSONObject("monitor"));
                        g.a(jSONObjectOptJSONObject2.optJSONObject("native"));
                        hVar.e = j.a(jSONObjectOptJSONObject2.optJSONObject("video"));
                        hVar.f = k.a(jSONObjectOptJSONObject2.optJSONObject("viewability"));
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("units");
                        if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() == 0) {
                            jSONArray = jSONArrayOptJSONArray;
                            str = str5;
                            str3 = str4;
                            arrayList = new ArrayList();
                        } else {
                            arrayList = new ArrayList();
                            int i2 = 0;
                            while (i2 < jSONArrayOptJSONArray2.length()) {
                                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                JSONArray jSONArray2 = jSONArrayOptJSONArray;
                                if (jSONObjectOptJSONObject3 != null) {
                                    i iVar = new i();
                                    iVar.a = jSONObjectOptJSONObject3.optString("id", null);
                                    iVar.f895b = jSONObjectOptJSONObject3.optString("spotId", null);
                                    iVar.c = b.a(jSONObjectOptJSONObject3.optJSONObject("display"));
                                    iVar.d = f.a(jSONObjectOptJSONObject3.optJSONObject("monitor"));
                                    iVar.e = g.a(jSONObjectOptJSONObject3.optJSONObject("native"));
                                    iVar.f = j.a(jSONObjectOptJSONObject3.optJSONObject("video"));
                                    iVar.g = k.a(jSONObjectOptJSONObject3.optJSONObject("viewability"));
                                    arrayList.add(iVar);
                                }
                                i2++;
                                jSONArrayOptJSONArray2 = jSONArrayOptJSONArray2;
                                jSONArrayOptJSONArray = jSONArray2;
                                str5 = str5;
                            }
                            jSONArray = jSONArrayOptJSONArray;
                            str = str5;
                            str3 = null;
                        }
                        hVar.g = arrayList;
                        str2 = str3;
                        obj = hVar;
                    }
                }
                if (obj != null) {
                    arrayList2.add(obj);
                }
                i++;
                str4 = str2;
                jSONArrayOptJSONArray = jSONArray;
                str5 = str;
            }
        }
        eVar.f893b = arrayList2;
        return eVar;
    }
}
