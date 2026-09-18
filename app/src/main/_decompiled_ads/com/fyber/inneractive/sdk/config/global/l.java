package com.fyber.inneractive.sdk.config.global;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    public final Map<String, q> a = new HashMap();

    public q a(String str) {
        return this.a.get(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((l) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return String.format("remoteConfig - features: %s", this.a.values());
    }

    public static l a(JSONObject jSONObject) throws Exception {
        l lVar = new l();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("features");
        int i = 0;
        int i2 = 0;
        while (i2 < jSONArrayOptJSONArray.length()) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
            q qVar = new q();
            qVar.f883b = jSONObject2.getString("id");
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                qVar.a = new o(jSONObjectOptJSONObject);
            } else {
                Object[] objArr = new Object[1];
                objArr[i] = qVar.f883b;
                IAlog.a("RemoteFeature fromJson. feature %s has no params!", objArr);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("experiments");
            if (jSONArrayOptJSONArray2 != null) {
                int i3 = i;
                while (i3 < jSONArrayOptJSONArray2.length()) {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i3);
                    b bVar = new b();
                    bVar.a = jSONObject3.getString("id");
                    bVar.f874b = jSONObject3.optInt("perc", 10);
                    JSONArray jSONArray = jSONObject3.getJSONArray("variants");
                    for (int i4 = i; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i4);
                        k kVar = new k();
                        kVar.f882b = jSONObject4.getString("id");
                        kVar.c = jSONObject4.getInt("perc");
                        JSONObject jSONObjectOptJSONObject2 = jSONObject4.optJSONObject("params");
                        if (jSONObjectOptJSONObject2 != null) {
                            kVar.a = new o(jSONObjectOptJSONObject2);
                        }
                        bVar.c.add(kVar);
                    }
                    b.a(bVar, jSONObject3.optJSONObject("include"), true);
                    b.a(bVar, jSONObject3.optJSONObject("exclude"), false);
                    qVar.c.put(bVar.a, bVar);
                    i3++;
                    i = 0;
                }
            }
            lVar.a.put(qVar.f883b, qVar);
            i2++;
            i = i;
        }
        return lVar;
    }
}
