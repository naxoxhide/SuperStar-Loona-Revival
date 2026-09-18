package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.google.ads.mediation.pangle.PangleConstants;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardUnitSetting.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static h H;
    public static String a;
    private int F;
    private int I;
    private JSONArray W;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2661b;
    private String c;
    private List<com.mbridge.msdk.videocommon.b.b> d;
    private long e;
    private ArrayList<Integer> u;
    private int f = -1;
    private int g = 0;
    private int h = 0;
    private int i = 1;
    private int j = 1;
    private int k = 1;
    private int l = 1;
    private int m = 5;
    private int n = 1;
    private int o = 3;
    private int p = 80;
    private int q = 100;
    private int r = 0;
    private double s = 1.0d;
    private int t = -1;
    private int v = 3;
    private int w = 1;
    private int x = 10;
    private int y = 60;
    private int z = 0;
    private int A = 70;
    private int B = 0;
    private int C = -1;
    private int D = -1;
    private int E = -1;
    private int G = 20;
    private int J = 0;
    private int K = 1;
    private String L = "";
    private int M = 1;
    private String N = "";
    private int O = 1;
    private String P = "Virtual Item";
    private String Q = "";
    private String R = "";
    private int S = 0;
    private int T = 1;
    private int U = 60;
    private String V = "";

    public final int a() {
        return this.x;
    }

    public final int b() {
        return this.y;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.u = arrayList;
    }

    public final int c() {
        return this.z;
    }

    public final void a(int i) {
        this.z = i;
    }

    public final int d() {
        return this.B;
    }

    public final void b(int i) {
        this.B = i;
    }

    public final int e() {
        return this.C;
    }

    public final void c(int i) {
        this.C = i;
    }

    public final int f() {
        return this.D;
    }

    public final void d(int i) {
        this.D = i;
    }

    public final int g() {
        return this.E;
    }

    public final void e(int i) {
        this.E = i;
    }

    public final int h() {
        return this.f;
    }

    public final int i() {
        return this.h;
    }

    public final String j() {
        return this.V;
    }

    public final String k() {
        return this.Q;
    }

    private void d(String str) {
        this.Q = str;
        com.mbridge.msdk.foundation.controller.b.c.put(this.f2661b, str);
    }

    public final String l() {
        return this.R;
    }

    public final int m() {
        return this.M;
    }

    private void y(int i) {
        if (i <= 0) {
            this.M = 1;
        } else {
            this.M = i;
        }
    }

    public final String n() {
        return this.P;
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.P = this.L;
        } else {
            this.P = str;
        }
    }

    public final int o() {
        return this.G;
    }

    public final int p() {
        return this.F;
    }

    public final void f(int i) {
        this.F = i;
    }

    public final int q() {
        return this.I;
    }

    public final void g(int i) {
        this.I = i;
    }

    public final void h(int i) {
        this.o = i;
    }

    public final void i(int i) {
        this.p = i;
    }

    public final int r() {
        return this.q;
    }

    public final void j(int i) {
        this.q = i;
    }

    public final int s() {
        return this.r;
    }

    public final void k(int i) {
        this.r = i;
    }

    public final int t() {
        return this.j;
    }

    public final void l(int i) {
        this.j = i;
    }

    public final int u() {
        return this.k;
    }

    public final void m(int i) {
        this.k = i;
    }

    public final void n(int i) {
        this.l = i;
    }

    public final int v() {
        return this.m;
    }

    public final void o(int i) {
        this.m = i;
    }

    public final int w() {
        return this.n;
    }

    public final void p(int i) {
        this.n = i;
    }

    public final void q(int i) {
        this.i = i;
    }

    public final long x() {
        return this.e;
    }

    public final void a(String str) {
        this.f2661b = str;
    }

    public final List<com.mbridge.msdk.videocommon.b.b> y() {
        return this.d;
    }

    public final void a(List<com.mbridge.msdk.videocommon.b.b> list) {
        this.d = list;
    }

    public final int z() {
        return this.w;
    }

    public final void r(int i) {
        this.w = i;
    }

    public final boolean s(int i) {
        ArrayList<Integer> arrayList = this.u;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.u.contains(Integer.valueOf(i));
    }

    public final String A() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final int B() {
        return this.v;
    }

    public final void t(int i) {
        this.v = i;
    }

    public final Queue<Integer> C() {
        LinkedList linkedList;
        Exception e;
        try {
            List<com.mbridge.msdk.videocommon.b.b> list = this.d;
            if (list == null || list.size() <= 0) {
                return null;
            }
            linkedList = new LinkedList();
            for (int i = 0; i < this.d.size(); i++) {
                try {
                    linkedList.add(Integer.valueOf(this.d.get(i).b()));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
            return linkedList;
        } catch (Exception e3) {
            linkedList = null;
            e = e3;
        }
        e.printStackTrace();
        return linkedList;
    }

    public final void u(int i) {
        this.S = i;
    }

    public final int D() {
        return this.T;
    }

    public final void v(int i) {
        this.T = i;
    }

    public final int E() {
        return this.U;
    }

    public final void w(int i) {
        this.U = i;
    }

    public static c c(String str) {
        JSONObject jSONObjectOptJSONObject;
        if (H == null) {
            H = h.a(com.mbridge.msdk.foundation.controller.b.d().g());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("vtag", "");
                String strOptString2 = jSONObject.optString("rid", "");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("unitSetting");
                if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                String strOptString3 = jSONObjectOptJSONObject.optString("unitId");
                if (TextUtils.isEmpty(strOptString3)) {
                    return null;
                }
                c cVar2 = new c();
                try {
                    cVar2.V = strOptString;
                    cVar2.R = strOptString2;
                    List<com.mbridge.msdk.videocommon.b.b> listA = com.mbridge.msdk.videocommon.b.b.a(jSONObjectOptJSONObject.optJSONArray("adSourceList"));
                    cVar2.f2661b = strOptString3;
                    cVar2.d = listA;
                    cVar2.i = jSONObjectOptJSONObject.optInt("callbackType");
                    int iOptInt = jSONObjectOptJSONObject.optInt("aqn", 1);
                    if (iOptInt <= 0) {
                        iOptInt = 1;
                    }
                    cVar2.j = iOptInt;
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("acn", 1);
                    if (iOptInt2 < 0) {
                        iOptInt2 = 1;
                    }
                    cVar2.k = iOptInt2;
                    cVar2.l = jSONObjectOptJSONObject.optInt("vcn", 5);
                    cVar2.m = jSONObjectOptJSONObject.optInt("offset", 5);
                    cVar2.n = jSONObjectOptJSONObject.optInt("dlnet", 1);
                    cVar2.I = jSONObjectOptJSONObject.optInt("endscreen_type", 2);
                    cVar2.o = jSONObjectOptJSONObject.optInt("tv_start", 3);
                    cVar2.p = jSONObjectOptJSONObject.optInt("tv_end", 80);
                    cVar2.q = jSONObjectOptJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                    cVar2.r = jSONObjectOptJSONObject.optInt("cd_rate", 0);
                    cVar2.e = jSONObject.optLong("current_time");
                    cVar2.z = jSONObjectOptJSONObject.optInt("orientation", 0);
                    cVar2.B = jSONObjectOptJSONObject.optInt("daily_play_cap", 0);
                    cVar2.C = jSONObjectOptJSONObject.optInt("video_skip_time", -1);
                    cVar2.D = jSONObjectOptJSONObject.optInt("video_skip_result", 2);
                    cVar2.E = jSONObjectOptJSONObject.optInt("video_interactive_type", -1);
                    cVar2.F = jSONObjectOptJSONObject.optInt("close_button_delay", 1);
                    cVar2.f = jSONObjectOptJSONObject.optInt("playclosebtn_tm", -1);
                    cVar2.g = jSONObjectOptJSONObject.optInt("play_ctdown", 0);
                    cVar2.h = jSONObjectOptJSONObject.optInt("close_alert", 0);
                    cVar2.G = jSONObjectOptJSONObject.optInt("rdrct", 20);
                    cVar2.A = jSONObjectOptJSONObject.optInt("load_global_timeout", 70);
                    cVar2.t = jSONObjectOptJSONObject.optInt("rfpv", -1);
                    cVar2.s = jSONObjectOptJSONObject.optDouble("vdcmp", 1.0d);
                    a = jSONObjectOptJSONObject.optString("atzu");
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("atl_type");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    try {
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i)));
                            }
                        } else {
                            arrayList.add(4);
                            arrayList.add(6);
                        }
                        cVar2.u = arrayList;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int iOptInt3 = jSONObjectOptJSONObject.optInt("atl_dyt", 0);
                    cVar2.v = iOptInt3 > 0 ? iOptInt3 : 3;
                    int iOptInt4 = jSONObjectOptJSONObject.optInt("tmorl", 1);
                    if (iOptInt4 > 2 || iOptInt4 <= 0) {
                        iOptInt4 = 1;
                    }
                    cVar2.w = iOptInt4;
                    cVar2.c = jSONObjectOptJSONObject.optString(PangleConstants.PLACEMENT_ID);
                    cVar2.x = jSONObjectOptJSONObject.optInt("ltafemty", 10);
                    cVar2.y = jSONObjectOptJSONObject.optInt("ltorwc", 60);
                    cVar2.d(jSONObjectOptJSONObject.optString("ab_id"));
                    cVar2.J = jSONObjectOptJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                    cVar2.K = jSONObjectOptJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                    cVar2.L = jSONObjectOptJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                    cVar2.y(jSONObjectOptJSONObject.optInt("amount", 1));
                    cVar2.N = jSONObjectOptJSONObject.optString(RewardPlus.ICON, "");
                    cVar2.O = jSONObjectOptJSONObject.optInt("currency_id", 1);
                    cVar2.e(jSONObjectOptJSONObject.optString("name", "Virtual Item"));
                    cVar2.T = jSONObjectOptJSONObject.optInt("video_error_rule", 1);
                    cVar2.U = jSONObjectOptJSONObject.optInt("loadtmo", 60);
                    cVar2.W = jSONObjectOptJSONObject.optJSONArray("local_cache_info");
                    return cVar2;
                } catch (Exception e2) {
                    e = e2;
                    cVar = cVar2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            e.printStackTrace();
        }
        return cVar;
    }

    public final JSONObject F() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unitId", this.f2661b);
            jSONObject.put("callbackType", this.i);
            List<com.mbridge.msdk.videocommon.b.b> list = this.d;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.mbridge.msdk.videocommon.b.b bVar : this.d) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.j);
            jSONObject.put("acn", this.k);
            jSONObject.put("vcn", this.l);
            jSONObject.put("offset", this.m);
            jSONObject.put("dlnet", this.n);
            jSONObject.put("tv_start", this.o);
            jSONObject.put("tv_end", this.p);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.q);
            jSONObject.put("endscreen_type", this.I);
            jSONObject.put("daily_play_cap", this.B);
            jSONObject.put("video_skip_time", this.C);
            jSONObject.put("video_skip_result", this.D);
            jSONObject.put("video_interactive_type", this.E);
            jSONObject.put("orientation", this.z);
            jSONObject.put("close_button_delay", this.F);
            jSONObject.put("playclosebtn_tm", this.f);
            jSONObject.put("play_ctdown", this.g);
            jSONObject.put("close_alert", this.h);
            jSONObject.put("rfpv", this.t);
            jSONObject.put("vdcmp", this.s);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<Integer> arrayList = this.u;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    Iterator<Integer> it = this.u.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.v);
            jSONObject.put("tmorl", this.w);
            jSONObject.put(PangleConstants.PLACEMENT_ID, this.c);
            jSONObject.put("ltafemty", this.x);
            jSONObject.put("ltorwc", this.y);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.J);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.K);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.L);
            jSONObject.put("amount", this.M);
            jSONObject.put(RewardPlus.ICON, this.N);
            jSONObject.put("currency_id", this.O);
            jSONObject.put("name", this.P);
            jSONObject.put("isDefault", this.S);
            jSONObject.put("video_error_rule", this.T);
            jSONObject.put("loadtmo", this.U);
            jSONObject.put("vtag", this.V);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static c a(JSONObject jSONObject) {
        c cVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar2 = new c();
            try {
                cVar2.d = com.mbridge.msdk.videocommon.b.b.a(jSONObject.optJSONArray("adSourceList"));
                cVar2.i = jSONObject.optInt("callbackType");
                int iOptInt = jSONObject.optInt("aqn", 1);
                if (iOptInt <= 0) {
                    iOptInt = 1;
                }
                cVar2.j = iOptInt;
                int iOptInt2 = jSONObject.optInt("acn", 1);
                if (iOptInt2 < 0) {
                    iOptInt2 = 1;
                }
                cVar2.k = iOptInt2;
                cVar2.l = jSONObject.optInt("vcn", 5);
                cVar2.m = jSONObject.optInt("offset", 5);
                cVar2.n = jSONObject.optInt("dlnet", 1);
                cVar2.I = jSONObject.optInt("endscreen_type", 2);
                cVar2.o = jSONObject.optInt("tv_start", 3);
                cVar2.p = jSONObject.optInt("tv_end", 80);
                cVar2.q = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                cVar2.e = jSONObject.optLong("current_time");
                cVar2.z = jSONObject.optInt("orientation", 0);
                cVar2.B = jSONObject.optInt("daily_play_cap", 0);
                cVar2.C = jSONObject.optInt("video_skip_time", -1);
                cVar2.D = jSONObject.optInt("video_skip_result", 2);
                cVar2.E = jSONObject.optInt("video_interactive_type", -1);
                cVar2.F = jSONObject.optInt("close_button_delay", 1);
                cVar2.f = jSONObject.optInt("playclosebtn_tm", -1);
                cVar2.g = jSONObject.optInt("play_ctdown", 0);
                cVar2.h = jSONObject.optInt("close_alert", 0);
                cVar2.G = jSONObject.optInt("rdrct", 20);
                cVar2.t = jSONObject.optInt("rfpv", -1);
                cVar2.s = jSONObject.optDouble("vdcmp", 1.0d);
                cVar2.A = jSONObject.optInt("load_global_timeout", 70);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                try {
                    if (jSONArrayOptJSONArray != null) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i)));
                        }
                    } else {
                        arrayList.add(4);
                        arrayList.add(6);
                    }
                    cVar2.u = arrayList;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cVar2.v = jSONObject.optInt("atl_dyt", 3);
                int iOptInt3 = jSONObject.optInt("tmorl", 1);
                if (iOptInt3 > 2 || iOptInt3 <= 0) {
                    iOptInt3 = 1;
                }
                cVar2.w = iOptInt3;
                cVar2.c = jSONObject.optString(PangleConstants.PLACEMENT_ID);
                cVar2.x = jSONObject.optInt("ltafemty", 10);
                cVar2.y = jSONObject.optInt("ltorwc", 60);
                cVar2.d(jSONObject.optString("ab_id"));
                cVar2.J = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                cVar2.K = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                cVar2.L = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                cVar2.y(jSONObject.optInt("amount", 1));
                cVar2.N = jSONObject.optString(RewardPlus.ICON, "");
                cVar2.O = jSONObject.optInt("currency_id", 1);
                cVar2.e(jSONObject.optString("name", "Virtual Item"));
                cVar2.T = jSONObject.optInt("video_error_rule", 1);
                cVar2.U = jSONObject.optInt("loadtmo", 60);
                cVar2.V = jSONObject.optString("vtag", "");
                cVar2.R = jSONObject.optString("rid", "");
                cVar2.W = jSONObject.optJSONArray("local_cache_info");
                return cVar2;
            } catch (Exception e2) {
                e = e2;
                cVar = cVar2;
                e.printStackTrace();
                return cVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final int G() {
        return this.A;
    }

    public final void x(int i) {
        this.A = i;
    }

    public final JSONArray H() {
        return this.W;
    }
}
