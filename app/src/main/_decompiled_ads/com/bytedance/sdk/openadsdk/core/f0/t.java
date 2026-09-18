package com.bytedance.sdk.openadsdk.core.f0;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayableModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class t {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f590b;
    private boolean c;
    private int d;
    private String e;
    private String f;
    private int g;

    public t(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("playable");
        if (jSONObjectOptJSONObject != null) {
            this.f = jSONObjectOptJSONObject.optString("playable_url", "");
            this.g = jSONObjectOptJSONObject.optInt("playable_orientation", 0);
            this.f590b = jSONObjectOptJSONObject.optInt("new_style", 0);
            this.a = jSONObjectOptJSONObject.optInt("close_2_app", 0);
        }
        this.c = jSONObject.optBoolean("is_playable");
        this.d = jSONObject.optInt("playable_type", 0);
        this.e = jSONObject.optString("playable_style");
    }

    public static String b(q qVar) {
        t tVarA = a(qVar);
        if (tVarA == null) {
            return null;
        }
        return tVarA.f;
    }

    public static int c(q qVar) {
        t tVarA = a(qVar);
        if (tVarA == null) {
            return 0;
        }
        return tVarA.g;
    }

    public static String d(q qVar) {
        t tVarA = a(qVar);
        if (tVarA == null) {
            return null;
        }
        return tVarA.e;
    }

    private static int e(q qVar) {
        t tVarA = a(qVar);
        if (tVarA == null) {
            return 0;
        }
        return tVarA.d;
    }

    public static String f(q qVar) {
        if (qVar == null) {
            return null;
        }
        String strB = b(qVar);
        if (!TextUtils.isEmpty(strB)) {
            return strB;
        }
        if (qVar.v() == 20) {
            return qVar.H0();
        }
        if (qVar.N0() != null) {
            return qVar.N0().d();
        }
        return null;
    }

    public static boolean g(q qVar) {
        t tVarT0 = qVar.t0();
        return tVarT0 != null && tVarT0.c && tVarT0.f590b == 1;
    }

    public static boolean h(q qVar) {
        return i(qVar) && e(qVar) == 1;
    }

    public static boolean i(q qVar) {
        t tVarA = a(qVar);
        return (tVarA == null || !tVarA.c || TextUtils.isEmpty(f(qVar))) ? false : true;
    }

    public static boolean j(q qVar) {
        b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
        return bVarN0 != null && bVarN0.j() == 1;
    }

    public static boolean k(q qVar) {
        return ((qVar == null || qVar.N0() == null) ? 0 : qVar.N0().j()) != 1;
    }

    public static boolean l(q qVar) {
        return false;
    }

    public static boolean m(q qVar) {
        return i(qVar) && e(qVar) == 0;
    }

    public static int n(q qVar) {
        int i;
        t tVarT0 = qVar.t0();
        if (tVarT0 != null && (i = tVarT0.a) >= 0 && i <= 100) {
            return i;
        }
        return 0;
    }

    public void a(JSONObject jSONObject) {
        try {
            jSONObject.put("is_playable", this.c);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.m.b("PlayableModel", e.getMessage());
        }
        if (!TextUtils.isEmpty(this.f)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("playable_url", this.f);
                jSONObject2.put("playable_orientation", this.g);
                jSONObject2.put("new_style", this.f590b);
                jSONObject2.put("close_2_app", this.a);
                jSONObject.put("playable", jSONObject2);
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.m.b("PlayableModel", e2.getMessage());
            }
        }
        try {
            jSONObject.put("playable_type", this.d);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.m.b("PlayableModel", e3.getMessage());
        }
        try {
            jSONObject.put("playable_style", this.e);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.m.b("PlayableModel", e4.getMessage());
        }
    }

    private static t a(q qVar) {
        if (qVar == null) {
            return null;
        }
        return qVar.t0();
    }
}
