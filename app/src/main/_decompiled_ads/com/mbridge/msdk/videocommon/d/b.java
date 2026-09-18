package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.videocommon.download.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardSettingManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static volatile b d;
    private volatile boolean c = false;
    private CopyOnWriteArrayList<String> e = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, c> f2659b = new ConcurrentHashMap<>();
    public static a a = null;

    private b() {
    }

    public static b a() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.e.remove(str);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0046  */
    public final a b() {
        boolean z;
        a aVar = a;
        if (aVar != null) {
            return aVar;
        }
        String strB = com.mbridge.msdk.foundation.a.a.a.a().b("reward_" + com.mbridge.msdk.foundation.controller.b.d().h());
        if (!TextUtils.isEmpty(strB)) {
            a aVarA = a.a(strB);
            if (aVarA != null) {
                if (aVarA.i() + aVarA.d() > System.currentTimeMillis()) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = true;
            }
            if (!z) {
                return aVarA;
            }
            d(com.mbridge.msdk.foundation.controller.b.d().h(), com.mbridge.msdk.foundation.controller.b.d().j());
            return c();
        }
        d(com.mbridge.msdk.foundation.controller.b.d().h(), com.mbridge.msdk.foundation.controller.b.d().j());
        return c();
    }

    private void d(String str, String str2) {
        if (this.c) {
            return;
        }
        this.c = true;
        new com.mbridge.msdk.videocommon.c.a().a(com.mbridge.msdk.foundation.controller.b.d().g(), str, str2);
    }

    public final void a(String str, String str2, String str3, com.mbridge.msdk.videocommon.c.c cVar) {
        try {
            if (!TextUtils.isEmpty(str3) && !this.e.contains(str3)) {
                if (!TextUtils.isEmpty(str3)) {
                    this.e.add(str3);
                }
                new com.mbridge.msdk.videocommon.c.a().a(com.mbridge.msdk.foundation.controller.b.d().g(), str, str2, str3, cVar);
            }
        } catch (Exception unused) {
        }
    }

    public final c a(String str, String str2) {
        c cVar;
        String str3 = ReportUtil.EVENT_TYPE_REWARD + "_" + str + "_" + str2;
        if (f2659b.containsKey(str3)) {
            boolean zA = false;
            try {
                cVar = f2659b.get(str3);
                try {
                    zA = a(cVar);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                cVar = null;
            }
            if (zA) {
                a(str, com.mbridge.msdk.foundation.controller.b.d().j(), str2, null);
            }
            return cVar;
        }
        c cVarC = c.c(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
        if (a(cVarC)) {
            a(str, com.mbridge.msdk.foundation.controller.b.d().j(), str2, null);
            return null;
        }
        f2659b.put(str3, cVarC);
        return cVarC;
    }

    public final c a(String str, String str2, boolean z) {
        c cVar;
        String str3 = "reward_" + str + "_" + str2;
        if (f2659b.containsKey(str3)) {
            boolean zA = false;
            try {
                cVar = f2659b.get(str3);
                try {
                    zA = a(cVar);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                cVar = null;
            }
            if (zA) {
                a(str, com.mbridge.msdk.foundation.controller.b.d().j(), str2, null);
            }
            return cVar;
        }
        c cVarC = c.c(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
        if (!a(cVarC)) {
            f2659b.put(str3, cVarC);
            return cVarC;
        }
        if (cVarC != null) {
            return cVarC;
        }
        a(str, com.mbridge.msdk.foundation.controller.b.d().j(), str2, null);
        return b(z);
    }

    public final a c() {
        a aVar = new a();
        HashMap map = new HashMap(5);
        map.put("1", 1000);
        map.put("9", 1000);
        map.put("8", 1000);
        HashMap map2 = new HashMap(3);
        map2.put("1", new com.mbridge.msdk.videocommon.b.c("Virtual Item", 1));
        aVar.a(map);
        aVar.b(map2);
        aVar.a(43200L);
        aVar.b(5400L);
        aVar.c(3600L);
        aVar.d(3600L);
        aVar.e(5L);
        aVar.a(1);
        return aVar;
    }

    private final boolean a(c cVar) {
        a aVarB = b();
        if (aVarB == null || cVar == null) {
            return true;
        }
        return cVar.x() + aVarB.e() <= System.currentTimeMillis();
    }

    public final void a(String str, String str2, String str3) {
        String str4 = "reward_" + str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        f2659b.put(str4, c.c(str3));
        if (TextUtils.isEmpty(c.a)) {
            return;
        }
        e(c.a, str2);
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a().a(com.mbridge.msdk.foundation.controller.b.d().h(), str, false);
        String str2 = c.a;
        if (TextUtils.isEmpty(str2) || !TextUtils.isEmpty(g.a().b(str2))) {
            return;
        }
        e(str2, str);
    }

    private void e(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            q.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, str2, 2, "alert url is exception ,url:" + str);
        } else {
            g.a().b(str, new g.d() { // from class: com.mbridge.msdk.videocommon.d.b.1
                @Override // com.mbridge.msdk.videocommon.download.g.a
                public final void a(String str3, boolean z) {
                    q.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, str2, 1, "");
                }

                @Override // com.mbridge.msdk.videocommon.download.g.a
                public final void a(String str3, String str4) {
                    q.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, str2, 2, str4);
                }
            });
        }
    }

    public final void b(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str, str2);
        a = a.a(str2);
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public static boolean c(String str) {
        JSONArray jSONArrayOptJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("unitSetting")) != null) {
                String strOptString = jSONArrayOptJSONArray.optJSONObject(0).optString("unitId");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && !TextUtils.isEmpty(strOptString)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final c c(String str, String str2) {
        String str3 = "reward_" + str + "_" + str2;
        if (f2659b.containsKey(str3)) {
            return f2659b.get(str3);
        }
        return c.c(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
    }

    private static c b(boolean z) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.mbridge.msdk.videocommon.b.b(1, 60, null));
            cVar.a((List<com.mbridge.msdk.videocommon.b.b>) arrayList);
            cVar.m(1);
            cVar.l(1);
            cVar.n(1);
            cVar.q(1);
            cVar.o(1);
            cVar.p(1);
            cVar.h(3);
            cVar.i(80);
            cVar.j(100);
            cVar.k(0);
            cVar.g(2);
            cVar.e(-1);
            cVar.x(70);
            cVar.d(2);
            if (z) {
                cVar.c(5);
            } else {
                cVar.c(-1);
            }
            cVar.b(0);
            cVar.a(0);
            cVar.f(1);
            cVar.r(1);
            cVar.t(3);
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            arrayList2.add(4);
            arrayList2.add(6);
            cVar.a(arrayList2);
            cVar.u(1);
            cVar.v(1);
            cVar.w(60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }
}
