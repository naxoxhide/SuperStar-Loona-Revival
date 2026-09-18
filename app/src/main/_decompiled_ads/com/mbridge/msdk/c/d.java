package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ai;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final String a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f1915b;
    private static HashMap<String, f> c = new HashMap<>();
    private static volatile c d = null;

    private d() {
    }

    public static synchronized d a() {
        if (f1915b == null) {
            f1915b = new d();
        }
        return f1915b;
    }

    public final boolean a(String str) {
        c cVarB = b(str);
        if (cVarB != null) {
            return cVarB.Z() + (cVarB.Y() * 1000) <= System.currentTimeMillis();
        }
        return true;
    }

    public final boolean a(String str, int i, String str2) {
        try {
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            String str3 = str + "_" + i + "_" + str2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = 0;
            long jLongValue = ((Long) ai.b(contextG, str3, 0L)).longValue();
            c cVarB = b(str);
            if (cVarB == null) {
                cVarB = a().b();
            } else {
                j = jLongValue;
            }
            if (j + (cVarB.S() * 1000) > jCurrentTimeMillis) {
                return false;
            }
            ai.a(contextG, str3, Long.valueOf(jCurrentTimeMillis));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, String str2) {
        c cVarB = b(str2);
        if (a(str2) && a(str2, 1, str)) {
            new e().a(com.mbridge.msdk.foundation.controller.b.d().g(), str2, com.mbridge.msdk.foundation.controller.b.d().j());
        }
        f fVarE = e(str2, str);
        if (cVarB != null && fVarE != null) {
            long jU = cVarB.U() * 1000;
            if (fVarE.u() + jU > System.currentTimeMillis()) {
                return false;
            }
        }
        return true;
    }

    public final void b(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a(str, str2);
        d = c.c(str2);
        if (d != null) {
            d.ai();
        }
    }

    public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return jSONObject2;
        }
        if (jSONObject2 != null && jSONObject2.length() != 0) {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    if ("unitSetting".equals(next) && jSONObject.has("unitSetting")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("unitSetting");
                        jSONArray.put(0, a((JSONObject) jSONArray.get(0), (JSONObject) jSONObject2.getJSONArray("unitSetting").get(0)));
                        jSONObject.put(next, jSONArray);
                    } else {
                        jSONObject.put(next, jSONObject2.opt(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public final c b(String str) {
        if (d == null) {
            try {
                String strB = com.mbridge.msdk.foundation.a.a.a.a().b(str);
                if (!TextUtils.isEmpty(strB)) {
                    JSONObject jSONObject = new JSONObject(strB);
                    if (jSONObject.has(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        jSONObject.remove(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                    }
                    if (jSONObject.has("c")) {
                        jSONObject.remove("c");
                    }
                    d = c.c(jSONObject.toString());
                    if (d != null) {
                        d.ai();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return d;
    }

    public final String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            String strB = com.mbridge.msdk.foundation.a.a.a.a().b(str);
            return strB == null ? "" : strB;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static void a(Context context, String str) {
        FastKV fastKVBuild;
        com.mbridge.msdk.foundation.controller.c.a();
        Map<String, Object> all = null;
        try {
            fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
        } catch (Exception unused) {
            fastKVBuild = null;
        }
        if (fastKVBuild != null) {
            try {
                all = fastKVBuild.getAll();
            } catch (Exception unused2) {
            }
            if (all != null) {
                try {
                    for (String str2 : all.keySet()) {
                        if (str2.startsWith(str + "_")) {
                            c.put(str2, f.b((String) all.get(str2)));
                        }
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            Map<String, ?> all2 = context.getSharedPreferences("mbridge", 0).getAll();
            for (String str3 : all2.keySet()) {
                if (str3.startsWith(str + "_")) {
                    c.put(str3, f.b((String) all2.get(str3)));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final f c(String str, String str2) {
        f fVarE = e(str, str2);
        return fVarE == null ? f.l() : fVarE;
    }

    public final f e(String str, String str2) {
        f fVarH = h(str, str2);
        if (fVarH != null && fVarH.j() == 0) {
            fVarH.c(1);
        }
        return fVarH;
    }

    private f h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.b.d().h();
        }
        String str3 = str + "_" + str2;
        f fVarB = null;
        if (c.containsKey(str3)) {
            return c.get(str3);
        }
        try {
            fVarB = f.b(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
            c.put(str3, fVarB);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fVarB;
    }

    public final f f(String str, String str2) {
        return h(str, str2);
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        c.put(str4, f.b(str3));
    }

    public final String d(String str) {
        return com.mbridge.msdk.foundation.a.a.a.a().b("ivreward_" + str);
    }

    public final void e(String str) {
        com.mbridge.msdk.foundation.a.a.a.a().c("ivreward_" + str);
    }

    public final void f(String str) {
        try {
            String strC = c(str);
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strC);
            jSONObject.put("current_time", System.currentTimeMillis());
            b(str, jSONObject.toString());
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    public final void g(String str, String str2) {
        try {
            String strB = com.mbridge.msdk.foundation.a.a.a.a().b(str + "_" + str2);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strB);
            jSONObject.put("current_time", System.currentTimeMillis());
            a(str, str2, jSONObject.toString());
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    public final c b() {
        c cVar = new c();
        cVar.r(1);
        cVar.e(true);
        cVar.c(3600L);
        cVar.d(0L);
        cVar.d(false);
        cVar.c(false);
        cVar.a(7200L);
        cVar.b("<mvpackage>mbridge</mvpackage>");
        cVar.p(1);
        cVar.b(1800L);
        cVar.q(259200);
        cVar.e(10L);
        cVar.k(1);
        cVar.j(1);
        cVar.l(1);
        cVar.m(0);
        cVar.n(1);
        cVar.o(-1);
        cVar.c(0);
        cVar.e(com.mbridge.msdk.c.a.b.a);
        cVar.d(com.mbridge.msdk.c.a.b.f1904b);
        cVar.b(120);
        cVar.f(false);
        cVar.t(0);
        cVar.u(120);
        cVar.v(1);
        cVar.g(com.mbridge.msdk.foundation.same.a.x);
        cVar.f(com.mbridge.msdk.foundation.same.a.A);
        cVar.e(com.mbridge.msdk.foundation.same.a.z);
        cVar.a(10);
        cVar.h(com.mbridge.msdk.foundation.same.a.B);
        cVar.d(10);
        cVar.x(0);
        cVar.w(0);
        cVar.a("");
        cVar.y(1);
        cVar.b(false);
        cVar.s(1);
        cVar.a(true);
        return cVar;
    }

    public final c g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return b();
            }
            c cVarB = b(str);
            return cVarB == null ? b() : cVarB;
        } catch (Exception unused) {
            return b();
        }
    }

    public final f d(String str, String str2) {
        f fVarH = h(str, str2);
        return fVarH == null ? f.l() : fVarH;
    }
}
