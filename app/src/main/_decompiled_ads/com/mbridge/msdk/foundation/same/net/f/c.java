package com.mbridge.msdk.foundation.same.net.f;

import android.text.TextUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: RequestControlUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2145b;
    private ArrayList<Integer> c;
    private ConcurrentHashMap<String, a> d;

    /* JADX INFO: compiled from: RequestControlUtil.java */
    private static class b {
        private static final c a = new c();
    }

    private c() {
        this.a = "IDErrorUtil";
        this.c = new ArrayList<>();
        this.d = new ConcurrentHashMap<>();
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        cVarB = cVarB == null ? com.mbridge.msdk.c.d.a().b() : cVarB;
        this.f2145b = cVarB.aC() * 1000;
        if (cVarB.aD() != null && cVarB.aD().size() > 0) {
            this.c.addAll(cVarB.aD());
        } else {
            this.c.addAll(Arrays.asList(-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616));
        }
    }

    public static c a() {
        return b.a;
    }

    public final synchronized void a(String str, int i, String str2, long j) {
        if (this.d.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.c.contains(Integer.valueOf(i))) {
            this.d.put(str, new a(j, i, str2));
        }
    }

    private synchronized a a(String str) {
        a aVar;
        if (!this.d.containsKey(str) || (aVar = this.d.get(str)) == null) {
            return null;
        }
        if (aVar.f2146b == -1) {
            return aVar;
        }
        if (System.currentTimeMillis() <= aVar.a + ((long) this.f2145b)) {
            return aVar;
        }
        this.d.remove(str);
        if (this.d.size() > 0) {
            for (Map.Entry<String, a> entry : this.d.entrySet()) {
                if (System.currentTimeMillis() - entry.getValue().a > this.f2145b) {
                    this.d.remove(entry.getKey());
                }
            }
        }
        return null;
    }

    public final k a(com.mbridge.msdk.foundation.same.net.g.d dVar) {
        int i;
        String str = dVar.c().get("app_id");
        String str2 = dVar.c().get(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER);
        String str3 = dVar.c().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        String str4 = dVar.c().get("ad_type");
        String str5 = dVar.c().get(BidResponsed.KEY_TOKEN);
        String str6 = str + "_" + str2 + "_" + str3 + "_" + str4;
        a aVarA = a(str6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.mbridge.msdk.foundation.same.net.c.b("data_res_type", "1"));
        if (aVarA != null && !TextUtils.isEmpty(aVarA.c)) {
            try {
                if (aVarA.f2146b != -1) {
                    return k.a(new JSONObject(aVarA.c), new com.mbridge.msdk.foundation.same.net.e.c(200, aVarA.c.getBytes(), arrayList));
                }
                if (TextUtils.isEmpty(str5) && str4 != null && !TextUtils.isEmpty(str4) && (i = Integer.parseInt(str4)) != 287 && i != 94) {
                    if (System.currentTimeMillis() < ((long) (com.mbridge.msdk.c.d.a().d(str, str3).w() * 1000)) + aVarA.a) {
                        return k.a(new JSONObject(aVarA.c), new com.mbridge.msdk.foundation.same.net.e.c(200, aVarA.c.getBytes(), arrayList));
                    }
                    this.d.remove(str6);
                    return null;
                }
            } catch (Exception e) {
                aa.d("IDErrorUtil", e.getMessage());
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: RequestControlUtil.java */
    private static class a {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2146b;
        public String c;

        public a(long j, int i, String str) {
            this.a = j;
            this.f2146b = i;
            this.c = str;
        }
    }
}
