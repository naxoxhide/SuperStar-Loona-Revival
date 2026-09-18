package com.mbridge.msdk.c;

import android.text.TextUtils;
import com.google.ads.mediation.pangle.PangleConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UnitSetting.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private int A;
    private int B;
    private int C;
    private int M;
    private int N;
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1919b;
    private int c;
    private String e;
    private String f;
    private List<Integer> g;
    private long h;
    private List<Integer> j;
    private int k;
    private int l;
    private int m;
    private int n;
    private String o;
    private int p;
    private int s;
    private int t;
    private long u;
    private String v;
    private int w;
    private long x;
    private long y;
    private int d = 30;
    private int i = 1;
    private int q = 1;
    private int r = 5000;
    private int z = 60;
    private String D = "";
    private int E = 10;
    private int F = 60;
    private String G = "";
    private String H = "";
    private String I = "";
    private int J = 1;
    private int K = 100;
    private int L = 0;

    public final String a() {
        return this.G;
    }

    public final String b() {
        return this.I;
    }

    public final void a(int i) {
        this.B = i;
    }

    public final void b(int i) {
        this.C = i;
    }

    public final int c() {
        return this.z;
    }

    public final int d() {
        return this.A;
    }

    public final int e() {
        return this.N;
    }

    public final int f() {
        return this.K;
    }

    public final int g() {
        return this.L;
    }

    public final int h() {
        return this.M;
    }

    public final long i() {
        return this.u;
    }

    public final int j() {
        return this.s;
    }

    public final void c(int i) {
        this.s = i;
    }

    public final int k() {
        return this.t;
    }

    public static f l() {
        return new f();
    }

    public final int m() {
        return this.n;
    }

    public final int n() {
        return this.q;
    }

    public final int o() {
        return this.r;
    }

    public final int p() {
        return this.l;
    }

    public final int q() {
        return this.m;
    }

    public final String toString() {
        List<Integer> list = this.g;
        String str = "";
        if (list != null && list.size() > 0) {
            Iterator<Integer> it = this.g.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
        }
        return "offset = " + this.i + " unitId = " + this.e + " fbPlacementId = " + this.f + str;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final List<Integer> r() {
        return this.g;
    }

    public final List<Integer> s() {
        return this.j;
    }

    public static f b(String str) {
        f fVar = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            f fVar2 = new f();
            try {
                JSONObject jSONObject = new JSONObject(str);
                fVar2.e = jSONObject.optString("unitId");
                String strOptString = jSONObject.optString("ab_id");
                fVar2.G = strOptString;
                com.mbridge.msdk.foundation.controller.b.c.put(fVar2.e, strOptString);
                fVar2.I = jSONObject.optString("rid");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adSourceList");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                    }
                    fVar2.g = arrayList;
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray2.optInt(i2)));
                    }
                    fVar2.j = arrayList2;
                }
                fVar2.k = jSONObject.optInt("tpqn");
                fVar2.l = jSONObject.optInt("aqn");
                fVar2.m = jSONObject.optInt("acn");
                fVar2.n = jSONObject.optInt("wt");
                int i3 = 1;
                fVar2.q = jSONObject.optInt("iscasf", 1);
                fVar2.r = jSONObject.optInt("spmxrt", 5000);
                fVar2.h = jSONObject.optLong("current_time");
                fVar2.i = jSONObject.optInt("offset");
                fVar2.u = jSONObject.optLong("dlct", 3600L);
                fVar2.s = jSONObject.optInt("autoplay", 0);
                fVar2.t = jSONObject.optInt("dlnet", 2);
                fVar2.v = jSONObject.optString("no_offer");
                fVar2.w = jSONObject.optInt("cb_type");
                fVar2.x = jSONObject.optLong("clct", 86400L);
                fVar2.y = jSONObject.optLong("clcq", 300L);
                fVar2.K = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                fVar2.L = jSONObject.optInt("cd_rate", 0);
                fVar2.M = jSONObject.optInt("content", 1);
                fVar2.N = jSONObject.optInt("impt", 0);
                fVar2.p = jSONObject.optInt("icon_type", 1);
                fVar2.o = jSONObject.optString("no_ads_url", "");
                fVar2.a = jSONObject.optInt("playclosebtn_tm", -1);
                fVar2.f1919b = jSONObject.optInt("play_ctdown", 0);
                fVar2.c = jSONObject.optInt("close_alert", 0);
                fVar2.d = jSONObject.optInt("intershowlimit", 30);
                fVar2.z = jSONObject.optInt("refreshFq", 60);
                fVar2.A = jSONObject.optInt("closeBtn", 0);
                int iOptInt = jSONObject.optInt("tmorl", 1);
                if (iOptInt <= 2 && iOptInt > 0) {
                    i3 = iOptInt;
                }
                fVar2.J = i3;
                fVar2.D = jSONObject.optString(PangleConstants.PLACEMENT_ID, "");
                fVar2.E = jSONObject.optInt("ltafemty", 10);
                fVar2.F = jSONObject.optInt("ltorwc", 60);
                fVar2.H = jSONObject.optString("vtag", "");
                return fVar2;
            } catch (Exception e) {
                e = e;
                fVar = fVar2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return fVar;
    }

    public final JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<Integer> list = this.g;
            if (list != null && list.size() > 0) {
                int size = this.g.size();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.g.get(i));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            List<Integer> list2 = this.j;
            if (list2 != null && list2.size() > 0) {
                int size2 = this.j.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < size2; i2++) {
                    jSONArray2.put(this.j.get(i2));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", this.k);
            jSONObject.put("aqn", this.l);
            jSONObject.put("acn", this.m);
            jSONObject.put("wt", this.n);
            jSONObject.put("current_time", this.h);
            jSONObject.put("offset", this.i);
            jSONObject.put("dlct", this.u);
            jSONObject.put("autoplay", this.s);
            jSONObject.put("dlnet", this.t);
            jSONObject.put("no_offer", this.v);
            jSONObject.put("cb_type", this.w);
            jSONObject.put("clct", this.x);
            jSONObject.put("clcq", this.y);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.K);
            jSONObject.put("content", this.M);
            jSONObject.put("impt", this.N);
            jSONObject.put("icon_type", this.p);
            jSONObject.put("no_ads_url", this.o);
            jSONObject.put("playclosebtn_tm", this.a);
            jSONObject.put("play_ctdown", this.f1919b);
            jSONObject.put("close_alert", this.c);
            jSONObject.put("closeBtn", this.A);
            jSONObject.put("refreshFq", this.z);
            jSONObject.put("countdown", this.C);
            jSONObject.put("allowSkip", this.B);
            jSONObject.put("tmorl", this.J);
            jSONObject.put("unitId", this.e);
            jSONObject.put(PangleConstants.PLACEMENT_ID, this.D);
            jSONObject.put("ltafemty", this.E);
            jSONObject.put("ltorwc", this.F);
            jSONObject.put("vtag", this.H);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final long u() {
        return this.h;
    }

    public final int v() {
        return this.i;
    }

    public static f c(String str) {
        f fVarL = l();
        fVarL.s = 0;
        return fVarL;
    }

    public static f d(String str) {
        f fVar = new f();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        fVar.i = 1;
        fVar.e = str;
        fVar.g = arrayList;
        fVar.j = arrayList2;
        fVar.k = 1;
        fVar.m = -2;
        fVar.l = -2;
        fVar.n = 5;
        fVar.u = 3600L;
        fVar.t = 2;
        fVar.s = 1;
        fVar.K = 100;
        fVar.L = 0;
        fVar.M = 1;
        fVar.N = 0;
        fVar.z = 60;
        fVar.E = 10;
        fVar.F = 60;
        return fVar;
    }

    public static f e(String str) {
        f fVar = new f();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            fVar.g = arrayList;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(30);
            fVar.j = arrayList2;
            fVar.e = str;
            fVar.i = 1;
            fVar.k = 1;
            fVar.m = -2;
            fVar.l = -2;
            fVar.n = 5;
            fVar.u = 3600L;
            fVar.t = 2;
            fVar.s = 3;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fVar;
    }

    public static f f(String str) {
        f fVar = new f();
        try {
            fVar.e = str;
            fVar.i = 1;
            fVar.k = 1;
            fVar.n = 5;
            fVar.m = 1;
            fVar.l = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fVar;
    }

    public final void g(String str) {
        this.D = str;
    }

    public final int w() {
        return this.E;
    }

    public final int x() {
        return this.F;
    }

    public final String y() {
        return this.H;
    }
}
