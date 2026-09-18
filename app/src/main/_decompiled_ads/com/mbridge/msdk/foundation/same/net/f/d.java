package com.mbridge.msdk.foundation.same.net.f;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.mbridge.msdk.e.a.a.g;
import com.mbridge.msdk.e.o;
import com.mbridge.msdk.e.w;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.same.report.t;
import com.mbridge.msdk.foundation.same.report.u;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: RequestUrlUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public int M;
    public int N;
    public boolean O;
    public ArrayList<String> P;
    public ArrayList<String> Q;
    private final String R;
    private boolean S;
    private int T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;
    public String a;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private String ah;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2147b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* JADX INFO: compiled from: RequestUrlUtil.java */
    private static class a {
        private static final d a = new d();
    }

    private d() {
        this.R = "RequestUrlUtil";
        this.S = true;
        this.T = 0;
        this.U = "/batchPaidEvent";
        this.V = "";
        this.W = DomainNameUtils.getInstance().DEFAULT_HB_HOST;
        this.a = DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS;
        this.f2147b = DomainNameUtils.getInstance().DEFAULT_HOST_REVENUE_DEFAULT;
        this.c = DomainNameUtils.getInstance().DEFAULT_HOST_MONITOR_DEFAULT;
        this.d = DomainNameUtils.getInstance().DEFAULT_HOST_API;
        this.e = DomainNameUtils.getInstance().DEFAULT_HOST_SETTING;
        this.f = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_SETTING;
        this.g = DomainNameUtils.getInstance().DEFAULT_HOST_APPLETS;
        this.h = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_ANALYTICS;
        this.i = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_REVENUE;
        this.j = DomainNameUtils.getInstance().DEFAULT_HOST_PRIVACY;
        this.k = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_MONITOR;
        this.l = 9377;
        this.m = 9988;
        this.n = 9377;
        this.o = 9377;
        this.p = false;
        this.q = 1;
        this.X = "/bid";
        this.Y = "/load";
        this.Z = "/openapi/ad/v3";
        this.aa = "/openapi/ad/v4";
        this.ab = "/openapi/ad/v5";
        this.ac = "/image";
        this.ad = "/mapping";
        this.ae = "/setting";
        this.af = "/sdk/customid";
        this.ag = "/rewardsetting";
        this.ah = "/appwall/setting";
        this.r = this.W + this.X;
        this.s = this.W + this.Y;
        this.t = this.d + this.Z;
        this.u = this.d + this.aa;
        this.v = this.d + this.ab;
        this.w = this.d + this.ac;
        this.x = this.e + this.ae;
        this.y = this.e + this.af;
        this.z = this.e + this.ag;
        this.A = this.e + this.ad;
        this.B = this.e + this.ah;
        this.C = this.f + this.ae;
        this.D = this.f + this.af;
        this.E = this.f + this.ag;
        this.F = this.f + this.ad;
        this.G = this.f + this.ah;
        this.H = this.f2147b + this.U;
        this.I = this.f2147b + this.V;
        this.J = DomainNameUtils.getInstance().DEFAULT_URL_ROVER_OFFER;
        this.K = DomainNameUtils.getInstance().DEFAULT_URL_ROVER_REPORT;
        this.L = DomainNameUtils.getInstance().DEFAULT_CDN_SPARE_SETTING_URL;
        this.M = 0;
        this.N = 0;
        this.O = false;
        this.P = DomainNameUtils.getInstance().SPARE_SETTING_HOST;
        this.Q = DomainNameUtils.getInstance().SPARE_TCP_SETTING_HOST;
    }

    public static d a() {
        return a.a;
    }

    public final int b() {
        return this.T;
    }

    public final void a(int i) {
        this.T = i;
    }

    public final String a(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split("_");
                if (strArrSplit.length > 1) {
                    return a(true, strArrSplit[1]);
                }
                return a(true, "");
            }
        } catch (Exception e) {
            aa.d("RequestUrlUtil", e.getMessage());
        }
        return i % 2 == 0 ? this.v : this.t;
    }

    public final String a(boolean z, String str) {
        if (z) {
            if (this.s.contains(JsonUtils.EMPTY_JSON) && !TextUtils.isEmpty(str)) {
                return this.s.replace(JsonUtils.EMPTY_JSON, str + "-");
            }
            return this.s.replace(JsonUtils.EMPTY_JSON, "");
        }
        return this.r.replace(JsonUtils.EMPTY_JSON, "");
    }

    public final void c() {
        HashMap<String, String> mapAE;
        com.mbridge.msdk.c.b bVarG;
        o oVar;
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB != null) {
            com.mbridge.msdk.c.a aVarH = cVarB.h();
            if (aVarH != null) {
                this.i = aVarH.c();
                this.m = aVarH.d();
                this.f2147b = aVarH.b();
                this.H = this.f2147b + this.U;
            }
            com.mbridge.msdk.c.b bVarG2 = cVarB.g();
            if (bVarG2 != null) {
                this.k = bVarG2.b();
                this.o = bVarG2.c();
                this.c = bVarG2.a();
                this.I = this.c + this.V;
                if (cVarB != null && (bVarG = cVarB.g()) != null && bVarG.e() != 1) {
                    int iA = ac.a().a("monitor", "type", ac.a().a("t_r_t", 0));
                    if (iA != 0 && iA != 1) {
                        iA = 0;
                    }
                    w.a aVarA = new w.a().a(new i()).a(new u());
                    if (iA == 1) {
                        oVar = new o(new t((byte) 2), a.a.k, a.a.o);
                    } else {
                        oVar = new o(new g(), a.a.I, 0);
                    }
                    com.mbridge.msdk.e.t.a().a(com.mbridge.msdk.foundation.controller.b.d().g(), aVarA.a(iA, oVar).e(ac.a().a("t_m_e_t", 604800000)).a(ac.a().a("t_m_e_s", 50)).d(ac.a().a("t_m_r_c", 50)).b(ac.a().a("t_m_t", 15000)).c(ac.a().a("t_m_r_t_s", 2)).a(), bVarG.d() * 1000, h.c());
                }
            }
            this.p = cVarB.aK() == 2;
            this.q = cVarB.aK();
            this.S = !cVarB.i(2);
            if (cVarB.aE() != null && cVarB.aE().size() > 0 && (mapAE = cVarB.aE()) != null && mapAE.size() > 0) {
                if (mapAE.containsKey("v") && !TextUtils.isEmpty(mapAE.get("v")) && a(mapAE.get("v"))) {
                    this.d = mapAE.get("v");
                    this.t = this.d + this.Z;
                    this.u = this.d + this.aa;
                    this.v = this.d + this.ab;
                    this.w = this.d + this.ac;
                }
                if (mapAE.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(mapAE.get(CampaignEx.JSON_KEY_HB)) && a(mapAE.get(CampaignEx.JSON_KEY_HB))) {
                    this.W = mapAE.get(CampaignEx.JSON_KEY_HB);
                    this.r = this.W + this.X;
                    this.s = this.W + this.Y;
                }
                if (mapAE.containsKey("lg") && !TextUtils.isEmpty(mapAE.get("lg"))) {
                    String str = mapAE.get("lg");
                    if (a(str)) {
                        this.a = str;
                    } else {
                        this.h = str;
                    }
                }
                if (mapAE.containsKey("lgt") && !TextUtils.isEmpty(mapAE.get("lgt"))) {
                    String str2 = mapAE.get("lgt");
                    if (a(str2)) {
                        String strB = b(str2);
                        if (!TextUtils.isEmpty(strB)) {
                            this.h = strB;
                        }
                    } else {
                        this.h = str2;
                    }
                }
                if (mapAE.containsKey(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE) && !TextUtils.isEmpty(mapAE.get(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE)) && a(mapAE.get(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE))) {
                    this.K = mapAE.get(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE);
                }
                if (mapAE.containsKey("df") && !TextUtils.isEmpty(mapAE.get("df")) && a(mapAE.get("df"))) {
                    this.J = mapAE.get("df");
                }
            }
            String strE = cVarB.E();
            if (!TextUtils.isEmpty(strE)) {
                this.e = strE;
                e();
                this.P.add(0, strE);
            }
            String strF = cVarB.F();
            if (TextUtils.isEmpty(strF)) {
                return;
            }
            this.f = strF;
            f();
            this.Q.add(0, strF);
        }
    }

    public final boolean d() {
        try {
            if (!this.p) {
                ArrayList<String> arrayList = this.P;
                if (arrayList != null && this.M <= arrayList.size() - 1) {
                    this.e = this.P.get(this.M);
                    e();
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.Q;
                if (arrayList2 != null && this.N <= arrayList2.size() - 1) {
                    if (!a(this.Q.get(this.N))) {
                        this.f = this.Q.get(this.N);
                        f();
                    }
                    return true;
                }
            }
            if (this.O) {
                this.M = 0;
                this.N = 0;
            }
            return false;
        } catch (Throwable th) {
            aa.a("RequestUrlUtil", th.getMessage());
            return false;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getHost();
        } catch (Throwable th) {
            aa.d("RequestUrlUtil", th.getMessage());
            return "";
        }
    }

    public final void e() {
        this.x = this.e + this.ae;
        this.y = this.e + this.af;
        this.z = this.e + this.ag;
        this.A = this.e + this.ad;
        this.B = this.e + this.ah;
    }

    public final void f() {
        this.C = this.f + this.ae;
        this.D = this.f + this.af;
        this.E = this.f + this.ag;
        this.F = this.f + this.ad;
        this.G = this.f + this.ah;
    }
}
