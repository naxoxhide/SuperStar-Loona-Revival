package com.mbridge.msdk.videocommon.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Reward.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2654b;

    public c(String str, int i) {
        this.a = str;
        this.f2654b = i;
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final int b() {
        return this.f2654b;
    }

    public final void a(int i) {
        this.f2654b = i;
    }

    private static c c() {
        return new c("Virtual Item", 1);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a A[Catch: Exception -> 0x002f, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:3:0x0001, B:5:0x000f, B:12:0x002a, B:8:0x0017, B:10:0x001d), top: B:17:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    public static c b(String str) {
        c cVarC;
        c cVar = null;
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (TextUtils.isEmpty(str)) {
                cVarC = c();
            } else {
                if (aVarB != null && aVarB.k() != null) {
                    cVarC = aVarB.k().get(str);
                }
                if (cVar == null) {
                    return c();
                }
                return cVar;
            }
            cVar = cVarC;
            if (cVar == null) {
                return c();
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, c> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                map.put(jSONObjectOptJSONObject.optString("id"), new c(jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optInt("amount")));
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strOptString = jSONObject.optString("name");
            int iOptInt = jSONObject.optInt("amount");
            jSONObject.optString("id");
            return new c(strOptString, iOptInt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String toString() {
        return "Reward{name='" + this.a + "', amount=" + this.f2654b + '}';
    }
}
