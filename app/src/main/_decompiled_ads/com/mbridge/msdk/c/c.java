package com.mbridge.msdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Setting.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static int a = 1500;
    private String M;
    private String X;
    private Map<String, a> aF;
    private b aH;
    private String aL;
    private String aM;
    private ArrayList<Integer> aQ;
    private HashMap<String, String> aR;
    private com.mbridge.msdk.c.a am;
    private com.mbridge.msdk.c.b an;
    private JSONObject ap;
    private JSONArray aq;
    private long at;
    private int au;
    private String c;
    private int d;
    private long f;
    private Map<String, String> g;
    private boolean h;
    private long i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private int o;
    private int p;
    private long q;
    private int r;
    private int s;
    private String t;
    private int u;
    private List<com.mbridge.msdk.foundation.entity.a> v;
    private int z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1912b = 0;
    private long e = 86400;
    private boolean w = false;
    private int x = 3;
    private boolean y = true;
    private String A = com.mbridge.msdk.foundation.same.net.f.d.a().e;
    private String B = com.mbridge.msdk.foundation.same.net.f.d.a().f;
    private int C = 120;
    private String D = "";
    private String E = "";
    private String F = "1.0";
    private int G = 1;
    private int H = 1;
    private int I = 1;
    private int J = 0;
    private int K = 1;
    private int L = 0;
    private int N = 30;
    private int O = 5;
    private int P = 0;
    private int Q = 0;
    private int R = 9377;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private int V = 2;
    private int W = 10;
    private boolean Y = false;
    private JSONArray Z = new JSONArray();
    private JSONArray aa = new JSONArray();
    private int ab = 0;
    private int ac = 0;
    private int ad = 0;
    private int ae = 3;
    private int af = 600;
    private int ag = 10;
    private int ah = 8000;
    private int ai = 8000;
    private int aj = 1300;
    private int ak = a;
    private int al = 1;
    private String ao = "";
    private boolean ar = false;
    private List<Integer> as = new ArrayList();
    private String av = "";
    private String aw = "";
    private String ax = "";
    private String ay = "";
    private String az = "";
    private String aA = "";
    private String aB = "";
    private String aC = "";
    private String aD = "";
    private String aE = "";
    private int aG = 0;
    private int aI = 0;
    private String aJ = "";
    private String aK = "";
    private int aN = 0;
    private boolean aO = false;
    private int aP = 120;
    private int aS = 0;
    private int aT = 0;
    private int aU = 0;
    private int aV = 0;
    private int aW = 0;
    private int aX = 1;
    private String aY = "";

    public final void a(int i) {
        this.z = i;
    }

    public final int a() {
        return this.z;
    }

    public final List<com.mbridge.msdk.foundation.entity.a> b() {
        return this.v;
    }

    public final String c() {
        return this.D;
    }

    public final int d() {
        return this.C;
    }

    public final void b(int i) {
        this.C = i;
    }

    public final int e() {
        return this.f1912b;
    }

    public final void c(int i) {
        this.f1912b = i;
    }

    public final void a(boolean z) {
        this.Y = z;
    }

    public final boolean f() {
        return this.Y;
    }

    public final com.mbridge.msdk.c.b g() {
        return this.an;
    }

    public final com.mbridge.msdk.c.a h() {
        return this.am;
    }

    public final JSONArray i() {
        return this.aq;
    }

    public final JSONObject j() {
        return this.ap;
    }

    public final String k() {
        return this.E;
    }

    public final String l() {
        return this.F;
    }

    public final int m() {
        return this.aj;
    }

    public final int n() {
        return this.ah;
    }

    public final int o() {
        return this.ai;
    }

    public final void b(boolean z) {
        this.ar = z;
    }

    public final boolean p() {
        return this.ar;
    }

    public final int q() {
        return this.ac;
    }

    public final int r() {
        return this.ad;
    }

    public final int s() {
        return this.ae;
    }

    public final int t() {
        return this.af;
    }

    public final int u() {
        return this.ag;
    }

    public final int v() {
        return this.ab;
    }

    public final JSONArray w() {
        return this.Z;
    }

    public final JSONArray x() {
        return this.aa;
    }

    public final String y() {
        return this.X;
    }

    public final void a(String str) {
        this.X = str;
    }

    public final void d(int i) {
        if (i > 0) {
            this.W = i;
        }
    }

    public final int z() {
        return this.W;
    }

    public final void e(int i) {
        this.S = i;
    }

    public final int A() {
        return this.S;
    }

    public final void f(int i) {
        this.T = i;
    }

    public final int B() {
        return this.T;
    }

    public final void g(int i) {
        this.U = i;
    }

    public final int C() {
        return this.U;
    }

    public final void h(int i) {
        this.V = i;
    }

    public final int D() {
        return this.V;
    }

    public final String E() {
        return this.A;
    }

    public final String F() {
        return this.B;
    }

    public final boolean i(int i) {
        return this.as.contains(Integer.valueOf(i));
    }

    public final int G() {
        return this.G;
    }

    public final void j(int i) {
        this.G = i;
    }

    public final int H() {
        return this.H;
    }

    public final void k(int i) {
        this.H = i;
    }

    public final int I() {
        return this.I;
    }

    public final void l(int i) {
        this.I = i;
    }

    public final int J() {
        return this.J;
    }

    public final void m(int i) {
        this.J = i;
    }

    public final int K() {
        return this.K;
    }

    public final void n(int i) {
        this.K = i;
    }

    public final int L() {
        return this.L;
    }

    public final void o(int i) {
        this.L = i;
    }

    public final int M() {
        return this.u;
    }

    public final void p(int i) {
        this.u = i;
    }

    public final String N() {
        return this.t;
    }

    public final void b(String str) {
        this.t = str;
    }

    public final int O() {
        return this.s;
    }

    public final int P() {
        return this.r;
    }

    public final long Q() {
        if (this.q <= 0) {
            this.q = 7200L;
        }
        return this.q;
    }

    public final void a(long j) {
        this.q = j;
    }

    public final int R() {
        return this.au;
    }

    public final void q(int i) {
        this.au = i;
    }

    public final long S() {
        return this.at;
    }

    public final void b(long j) {
        this.at = j;
    }

    public final boolean T() {
        return this.n;
    }

    public final void c(boolean z) {
        this.n = z;
    }

    public final long U() {
        return this.m;
    }

    public final boolean V() {
        return this.j;
    }

    public final void d(boolean z) {
        this.j = z;
    }

    public final long W() {
        return this.k;
    }

    public final void c(long j) {
        this.k = j;
    }

    public final void d(long j) {
        this.l = j;
    }

    public final String toString() {
        return " cfc=" + this.d + " getpf=" + this.e + " rurl=" + this.j;
    }

    public final int X() {
        return this.d;
    }

    public final void r(int i) {
        this.d = i;
    }

    public final long Y() {
        return this.e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static c c(String str) {
        c cVar;
        FastKV fastKVBuild;
        ArrayList arrayList;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            c cVar2 = new c();
            try {
                cVar2.ap = jSONObject;
                cVar2.c = jSONObject.optString("cc");
                cVar2.t = jSONObject.optString("mv_wildcard", "<mvpackage>mbridge</mvpackage>");
                cVar2.d = jSONObject.optInt("cfc");
                cVar2.e = jSONObject.optLong("getpf");
                cVar2.i = jSONObject.optLong("current_time");
                cVar2.h = jSONObject.optBoolean("cfb");
                cVar2.l = jSONObject.optLong("awct");
                cVar2.k = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT) == 0 ? 3600L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCT);
                cVar2.j = jSONObject.optBoolean("rurl");
                cVar2.m = jSONObject.optLong("uct");
                cVar2.n = jSONObject.optBoolean("ujds");
                cVar2.o = jSONObject.optInt("n2");
                cVar2.p = jSONObject.optInt("n3");
                cVar2.u = jSONObject.optInt("is_startup_crashsystem", 1);
                cVar2.r = jSONObject.optInt("pcrn");
                cVar2.q = jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB) == 0 ? 7200L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB);
                cVar2.r = jSONObject.optInt("pcrn", 100);
                cVar2.s = jSONObject.optInt("opent", 1);
                cVar2.at = jSONObject.optLong("sfct", 1800L);
                cVar2.H = jSONObject.optInt("upgd", 1);
                cVar2.G = jSONObject.optInt("upsrl", 1);
                cVar2.I = jSONObject.optInt("updevid", 1);
                cVar2.J = jSONObject.optInt("sc", 0);
                cVar2.K = jSONObject.optInt("up_tips", 1);
                cVar2.L = jSONObject.optInt("iseu", -1);
                cVar2.M = jSONObject.optString("jm_unit");
                try {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("atf");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            String strOptString = jSONArrayOptJSONArray.optString(i);
                            if (ak.b(strOptString)) {
                                JSONObject jSONObject2 = new JSONObject(strOptString);
                                arrayList.add(new com.mbridge.msdk.foundation.entity.a(jSONObject2.optInt("adtype"), jSONObject2.optString("unitid")));
                            }
                        }
                    }
                    if (arrayList != null) {
                        cVar2.v = arrayList;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cVar2.au = jSONObject.optInt("adct", 259200);
                cVar2.av = jSONObject.optString("confirm_title", "");
                cVar2.aw = jSONObject.optString("confirm_description", "");
                cVar2.ax = jSONObject.optString("confirm_t", "");
                cVar2.ay = jSONObject.optString("confirm_c_rv", "");
                cVar2.az = jSONObject.optString("confirm_c_play", "");
                cVar2.aA = jSONObject.optString("adchoice_icon", "");
                cVar2.aC = jSONObject.optString("adchoice_link", "");
                cVar2.aB = jSONObject.optString("adchoice_size", "");
                cVar2.aE = jSONObject.optString("platform_logo", "");
                cVar2.aD = jSONObject.optString("platform_name", "");
                cVar2.aF = f(jSONObject.optString("cdnate_cfg", ""));
                cVar2.f1912b = jSONObject.optInt("atrqt", 0);
                cVar2.aI = jSONObject.optInt("iupdid", 0);
                cVar2.C = jSONObject.optInt("mcs", 120);
                cVar2.D = jSONObject.optString("ab_id", "");
                cVar2.E = jSONObject.optString("rid", "");
                cVar2.F = jSONObject.optString("log_rate", "-1");
                cVar2.aJ = jSONObject.optString("omsdkjs_url", "");
                cVar2.aK = jSONObject.optString("omsdkjs_h5_url", "");
                cVar2.ad = jSONObject.optInt("rty_tk_clk", 0);
                cVar2.ac = jSONObject.optInt("rty_tk_imp", 0);
                cVar2.ae = jSONObject.optInt("rty_cnt", 3);
                cVar2.af = jSONObject.optInt("rty_to", 600);
                cVar2.ag = jSONObject.optInt("rty_inr", 10);
                cVar2.aJ = jSONObject.optString("omsdkjs_url", "");
                cVar2.aK = jSONObject.optString("omsdkjs_h5_url", "");
                long jOptLong = jSONObject.optLong("tcto");
                if (jOptLong == 0) {
                    cVar2.f = 10L;
                } else {
                    cVar2.f = jOptLong;
                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("jt");
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        HashMap map = new HashMap();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                            map.put(jSONObjectOptJSONObject.optString(DynamicLink.Builder.KEY_DOMAIN), jSONObjectOptJSONObject.optString("format"));
                        }
                        cVar2.g = map;
                    }
                }
                cVar2.aM = jSONObject.optString("mraid_js");
                cVar2.aL = jSONObject.optString("web_env_url");
                int iOptInt = jSONObject.optInt("alrbs", 0);
                if (iOptInt > 2 || iOptInt < 0) {
                    iOptInt = 0;
                }
                cVar2.aN = iOptInt;
                cVar2.aO = jSONObject.optBoolean("GDPR_area", false);
                cVar2.aP = jSONObject.optInt("ct", 120);
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("ercd");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        int iOptInt2 = jSONArrayOptJSONArray3.optInt(i3);
                        if (iOptInt2 != 0) {
                            arrayList2.add(Integer.valueOf(iOptInt2));
                        }
                    }
                    if (arrayList2.size() > 0) {
                        arrayList2.add(-1);
                        cVar2.aQ = arrayList2;
                    }
                }
                String strOptString2 = jSONObject.optString("hst");
                if (!TextUtils.isEmpty(strOptString2)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(u.b(strOptString2));
                        Iterator<String> itKeys = jSONObject3.keys();
                        HashMap<String, String> map2 = new HashMap<>();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject3.optString(next)) && !TextUtils.isEmpty(u.b(jSONObject3.optString(next)))) {
                                map2.put(next, jSONObject3.optString(next));
                            }
                        }
                        if (map2.size() > 0) {
                            cVar2.aR = map2;
                        }
                    } catch (Exception e2) {
                        aa.d("SETTING", e2.getMessage());
                    }
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("refactor_switch");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                        JSONObject jSONObject4 = jSONArrayOptJSONArray4.getJSONObject(i4);
                        Iterator<String> itKeys2 = jSONObject4.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            if (!TextUtils.isEmpty(next2) && jSONObject4.getBoolean(next2)) {
                                cVar2.as.add(Integer.valueOf(Integer.parseInt(next2)));
                            }
                        }
                    }
                }
                try {
                    int iOptInt3 = jSONObject.optInt("lqcnt", 30);
                    int iOptInt4 = jSONObject.optInt("lqto", 5);
                    int iOptInt5 = jSONObject.optInt("lqswt", 0);
                    int iOptInt6 = jSONObject.optInt("lqtype", 0);
                    cVar2.O = iOptInt4;
                    cVar2.N = iOptInt3;
                    cVar2.P = iOptInt5;
                    cVar2.Q = iOptInt6;
                    JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("lg_bl");
                    if (jSONArrayOptJSONArray5 == null) {
                        jSONArrayOptJSONArray5 = new JSONArray();
                        jSONArrayOptJSONArray5.put("2000088");
                    }
                    cVar2.aa = jSONArrayOptJSONArray5;
                    JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("lg_wl");
                    if (jSONArrayOptJSONArray6 == null) {
                        jSONArrayOptJSONArray6 = new JSONArray();
                        jSONArrayOptJSONArray6.put("2000041");
                        jSONArrayOptJSONArray6.put("2000042");
                        jSONArrayOptJSONArray6.put("2000032");
                        jSONArrayOptJSONArray6.put("2000079");
                    }
                    cVar2.Z = jSONArrayOptJSONArray6;
                    cVar2.ab = jSONObject.optInt("lg_wl_rt");
                    cVar2.ah = jSONObject.optInt("srml", 8000);
                    cVar2.ai = jSONObject.optInt("lrml", 8000);
                    cVar2.aj = jSONObject.optInt("wgl_d_ms", 1300);
                    int iOptInt7 = jSONObject.optInt("dp_ct", a);
                    cVar2.ak = iOptInt7;
                    com.mbridge.msdk.click.b.a.c = iOptInt7;
                    int i5 = Integer.parseInt(u.b(jSONObject.optString("lqpt")));
                    if (i5 > 0 && i5 < 65535) {
                        cVar2.R = i5;
                        com.mbridge.msdk.foundation.same.net.f.d.a().l = i5;
                        com.mbridge.msdk.foundation.same.net.f.d.a().n = i5;
                    }
                } catch (Exception unused) {
                }
                cVar2.aS = jSONObject.optInt("wvddt", 0);
                cVar2.A = jSONObject.optString("hst_st", "");
                cVar2.B = jSONObject.optString("hst_st_t", "");
                try {
                    int iOptInt8 = jSONObject.optInt("l", 3);
                    boolean z = jSONObject.optInt(CampaignEx.JSON_KEY_AD_K, 0) == 1;
                    boolean z2 = jSONObject.optInt(InneractiveMediationDefs.GENDER_MALE, 1) == 1;
                    cVar2.x = iOptInt8;
                    cVar2.w = z;
                    cVar2.y = z2;
                } catch (Exception e3) {
                    aa.d("Setting", e3.getMessage());
                }
                cVar2.aG = jSONObject.optInt("fbk_swt", 0);
                cVar2.aH = b.a(jSONObject.optJSONObject("fbk"));
                try {
                    int iOptInt9 = jSONObject.optInt("ad_connection_timeout", com.mbridge.msdk.foundation.same.a.x);
                    int iOptInt10 = jSONObject.optInt("ad_read_timeout", com.mbridge.msdk.foundation.same.a.z);
                    int iOptInt11 = jSONObject.optInt("ad_write_timeout", com.mbridge.msdk.foundation.same.a.A);
                    int iOptInt12 = jSONObject.optInt("ad_retry_count", com.mbridge.msdk.foundation.same.a.B);
                    if (iOptInt9 <= 0) {
                        iOptInt9 = com.mbridge.msdk.foundation.same.a.x;
                    }
                    cVar2.U = iOptInt9;
                    if (iOptInt10 <= 0) {
                        iOptInt10 = com.mbridge.msdk.foundation.same.a.z;
                    }
                    cVar2.S = iOptInt10;
                    if (iOptInt11 <= 0) {
                        iOptInt11 = com.mbridge.msdk.foundation.same.a.A;
                    }
                    cVar2.T = iOptInt11;
                    if (iOptInt12 < 0) {
                        iOptInt12 = com.mbridge.msdk.foundation.same.a.B;
                    }
                    cVar2.V = iOptInt12;
                    int iOptInt13 = jSONObject.optInt("max_download_task_size", 10);
                    if (iOptInt13 <= 0) {
                        iOptInt13 = 10;
                    }
                    cVar2.z = iOptInt13;
                    cVar2.d(jSONObject.optInt("max_bitmap_cache_size", 10));
                    cVar2.aV = jSONObject.optInt("t_t");
                    cVar2.aU = jSONObject.optInt("h_t");
                    int iOptInt14 = jSONObject.optInt("gtp");
                    cVar2.aW = iOptInt14;
                    com.mbridge.msdk.foundation.same.net.f.d.a().a(iOptInt14);
                } catch (Exception unused2) {
                }
                try {
                    cVar2.X = jSONObject.optString("http_track_url", "");
                } catch (Exception unused3) {
                }
                cVar2.aX = jSONObject.optInt("st_net", 1);
                cVar2.aY = jSONObject.optString("vtag", "");
                try {
                    cVar2.ar = jSONObject.optInt("check_webview", 0) != 0;
                } catch (Exception unused4) {
                    cVar2.ar = false;
                }
                String strOptString3 = jSONObject.optString("swxid");
                if (!TextUtils.isEmpty(cVar2.ao)) {
                    cVar2.ao = strOptString3;
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.b.d().i())) {
                        com.mbridge.msdk.foundation.controller.b.d().d(cVar2.ao);
                    }
                }
                cVar2.aq = jSONObject.optJSONArray("sdk_filters");
                boolean z3 = true;
                try {
                    cVar2.al = jSONObject.optInt("ch_nv_im_cb", 1);
                } catch (Exception unused5) {
                    cVar2.al = 1;
                }
                try {
                    try {
                        cVar2.Y = jSONObject.optInt("do_us_fi_re", 1) != 0;
                    } catch (Exception unused6) {
                        z3 = true;
                        cVar2.Y = z3;
                    }
                } catch (Exception unused7) {
                }
                try {
                    com.mbridge.msdk.foundation.controller.c.a();
                    try {
                        fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), u.b("H+tU+FeXHM==")).build();
                    } catch (Exception unused8) {
                        fastKVBuild = null;
                    }
                    if (fastKVBuild != null) {
                        try {
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                String strOptString4 = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                                if (!TextUtils.isEmpty(strOptString4) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.l, strOptString4)) {
                                    com.mbridge.msdk.foundation.same.a.l = strOptString4;
                                    com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
                                    try {
                                        fastKVBuild.putString(u.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.l);
                                    } catch (Exception unused9) {
                                    }
                                }
                                String strOptString5 = jSONObject.optString("c");
                                if (!TextUtils.isEmpty(strOptString5) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.m, strOptString5)) {
                                    com.mbridge.msdk.foundation.same.a.m = strOptString5;
                                    com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.m);
                                    try {
                                        fastKVBuild.putString(u.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.m);
                                    } catch (Exception unused10) {
                                    }
                                }
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        try {
                            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                            if (contextG != null) {
                                String strOptString6 = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                                if (!TextUtils.isEmpty(strOptString6) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.l, strOptString6)) {
                                    com.mbridge.msdk.foundation.same.a.l = strOptString6;
                                    com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
                                    SharedPreferences sharedPreferences = contextG.getSharedPreferences(u.b("H+tU+FeXHM=="), 0);
                                    if (sharedPreferences != null) {
                                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                                        editorEdit.putString(u.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.l);
                                        editorEdit.apply();
                                    }
                                }
                                String strOptString7 = jSONObject.optString("c");
                                if (!TextUtils.isEmpty(strOptString7) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.m, strOptString7)) {
                                    com.mbridge.msdk.foundation.same.a.m = strOptString7;
                                    com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.m);
                                    SharedPreferences sharedPreferences2 = contextG.getSharedPreferences(u.b("H+tU+FeXHM=="), 0);
                                    if (sharedPreferences2 != null) {
                                        SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                                        editorEdit2.putString(u.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.m);
                                        editorEdit2.apply();
                                    }
                                }
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                String strOptString8 = jSONObject.optString("bcp");
                if (!TextUtils.isEmpty(strOptString8)) {
                    cVar2.am = com.mbridge.msdk.c.a.a(u.b(strOptString8));
                }
                String strOptString9 = jSONObject.optString("monitor");
                if (!TextUtils.isEmpty(strOptString9)) {
                    cVar2.an = com.mbridge.msdk.c.b.a(u.b(strOptString9));
                }
                return cVar2;
            } catch (Exception e7) {
                e = e7;
                cVar = cVar2;
            }
        } catch (Exception e8) {
            e = e8;
            cVar = null;
        }
        e.printStackTrace();
        return cVar;
    }

    public final long Z() {
        return this.i;
    }

    public final long aa() {
        return this.f * 1000;
    }

    public final void e(long j) {
        this.f = j;
    }

    public static String a(Context context, String str) {
        try {
            c cVarB = d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (cVarB != null && cVarB.g != null) {
                String host = Uri.parse(str).getHost();
                Iterator<Map.Entry<String, String>> it = cVarB.g.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!TextUtils.isEmpty(host) && host.contains(key)) {
                        String str2 = cVarB.g.get(key);
                        return TextUtils.isEmpty(str2) ? "" : str2.replace("{gaid}", w.a());
                    }
                }
                return "";
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void e(boolean z) {
        this.h = z;
    }

    public final int ab() {
        return this.o;
    }

    public final int ac() {
        return this.p;
    }

    public final String ad() {
        return this.av;
    }

    public final String ae() {
        return this.aw;
    }

    public final String af() {
        return this.ax;
    }

    public final String ag() {
        return this.ay;
    }

    public final String ah() {
        return this.az;
    }

    public final void ai() {
        String language = Locale.getDefault().getLanguage();
        if (!((TextUtils.isEmpty(this.av) || TextUtils.isEmpty(this.aw) || TextUtils.isEmpty(this.ax) || TextUtils.isEmpty(this.ay)) ? false : true)) {
            if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                this.av = "确认关闭？";
                this.aw = "关闭后您将不会获得任何奖励噢~ ";
                this.ax = "确认关闭";
                this.ay = "继续观看";
            } else {
                this.av = "Confirm to close? ";
                this.aw = "You will not be rewarded after closing the window";
                this.ax = "Close it";
                this.ay = "Continue";
            }
        }
        if ((TextUtils.isEmpty(this.av) || TextUtils.isEmpty(this.aw) || TextUtils.isEmpty(this.ax) || TextUtils.isEmpty(this.az)) ? false : true) {
            return;
        }
        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
            this.av = "确认关闭？";
            this.aw = "关闭后您将不会获得任何奖励噢~ ";
            this.ax = "确认关闭";
            this.az = "继续试玩";
            return;
        }
        this.av = "Confirm to close? ";
        this.aw = "You will not be rewarded after closing the window";
        this.ax = "Close it";
        this.az = "Continue";
    }

    public final String aj() {
        return this.aA;
    }

    public final String ak() {
        return this.aB;
    }

    public final String al() {
        return this.aC;
    }

    public final Map<String, a> am() {
        return this.aF;
    }

    private static Map<String, a> f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                a aVar = new a();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    aVar.a(jSONObjectOptJSONObject);
                }
                map.put(next, aVar);
            }
            return map;
        } catch (JSONException e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return null;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public final int an() {
        return this.N;
    }

    public final int ao() {
        return this.O;
    }

    public final int ap() {
        return this.P;
    }

    public final int aq() {
        return this.Q;
    }

    public final boolean ar() {
        return this.w;
    }

    public final int as() {
        return this.x;
    }

    public final boolean at() {
        return this.y;
    }

    public final b au() {
        return this.aH;
    }

    public final int av() {
        return this.al;
    }

    public final void s(int i) {
        this.al = i;
    }

    /* JADX INFO: compiled from: Setting.java */
    public static class b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f1914b;
        private String c;
        private String d;
        private String e;
        private JSONArray f;

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            b bVar = new b();
            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            bVar.a = jSONObject.optString("title", contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_title", "string")));
            bVar.f1914b = jSONObject.optString("cancel", contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_close_close", "string")));
            bVar.c = jSONObject.optString("submit", contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_close_submit", "string")));
            bVar.d = jSONObject.optString("submit_notice", contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_submit_notice", "string")));
            bVar.e = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_PRIVACY, contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_privacy_des", "string")));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("content");
            bVar.f = jSONArrayOptJSONArray;
            if (jSONArrayOptJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                bVar.f = jSONArray;
                jSONArray.put(contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_content_not_play", "string")));
                bVar.f.put(contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_content_sound_problems", "string")));
                bVar.f.put(contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_content_misleading", "string")));
                bVar.f.put(contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_content_fraud", "string")));
                bVar.f.put(contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_content_por_violence", "string")));
                bVar.f.put(contextG.getString(t.a(contextG, "mbridge_cm_feedback_dialog_content_other", "string")));
            }
            return bVar;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.f1914b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public final JSONArray f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: Setting.java */
    public static class a {
        private List<String> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f1913b;
        private List<String> c;
        private List<String> d;

        public final List<String> a() {
            return this.a;
        }

        public final List<String> b() {
            return this.f1913b;
        }

        public final List<String> c() {
            return this.c;
        }

        public final List<String> d() {
            return this.d;
        }

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("x");
                if (jSONArrayOptJSONArray != null) {
                    this.a = o.a(jSONArrayOptJSONArray);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("y");
                if (jSONArrayOptJSONArray2 != null) {
                    this.f1913b = o.a(jSONArrayOptJSONArray2);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("width");
                if (jSONArrayOptJSONArray3 != null) {
                    this.c = o.a(jSONArrayOptJSONArray3);
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("height");
                if (jSONArrayOptJSONArray4 != null) {
                    this.d = o.a(jSONArrayOptJSONArray4);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final String aw() {
        return this.aK;
    }

    public final void d(String str) {
        this.aK = str;
    }

    public final String ax() {
        return this.aJ;
    }

    public final void e(String str) {
        this.aJ = str;
    }

    public final String ay() {
        return this.aL;
    }

    public final String az() {
        return this.aM;
    }

    public final int aA() {
        return this.aN;
    }

    public final void t(int i) {
        this.aN = i;
    }

    public final boolean aB() {
        return this.aO;
    }

    public final void f(boolean z) {
        this.aO = z;
    }

    public final int aC() {
        return this.aP;
    }

    public final void u(int i) {
        this.aP = i;
    }

    public final ArrayList<Integer> aD() {
        return this.aQ;
    }

    public final HashMap<String, String> aE() {
        return this.aR;
    }

    public final int aF() {
        return this.aS;
    }

    public final int aG() {
        return this.aT;
    }

    public final void v(int i) {
        this.aT = i;
    }

    public final String aH() {
        return this.c;
    }

    public final int aI() {
        return this.aU;
    }

    public final void w(int i) {
        this.aU = i;
    }

    public final int aJ() {
        return this.aV;
    }

    public final void x(int i) {
        this.aV = i;
    }

    public final int aK() {
        return this.aX;
    }

    public final void y(int i) {
        this.aX = i;
    }

    public final String aL() {
        return this.aY;
    }

    public final String aM() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cc", this.c);
            jSONObject.put("cfc", this.d);
            jSONObject.put("cfb", this.h);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.k);
            jSONObject.put("awct", this.l);
            jSONObject.put("rurl", this.j);
            jSONObject.put("ujds", this.n);
            jSONObject.put(CampaignEx.JSON_KEY_PLCTB, this.q);
            jSONObject.put("tcto", this.f);
            jSONObject.put("mv_wildcard", this.t);
            jSONObject.put("is_startup_crashsystem", this.u);
            jSONObject.put("sfct", this.at);
            jSONObject.put("pcrn", this.r);
            jSONObject.put("adct", this.au);
            jSONObject.put("atrqt", this.f1912b);
            jSONObject.put("omsdkjs_url", this.aJ);
            jSONObject.put("mcs", this.C);
            jSONObject.put("GDPR_area", this.aO);
            jSONObject.put("alrbs", this.aN);
            jSONObject.put("ct", this.aP);
            jSONObject.put("isDefault", this.aT);
            jSONObject.put("st_net", this.aX);
            jSONObject.put("vtag", this.aY);
            return jSONObject.toString();
        } catch (Throwable th) {
            aa.d("Setting", th.getMessage());
            return null;
        }
    }
}
