package com.bytedance.sdk.openadsdk.core.f0;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.z;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SingleMaterialMeta.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends q {
    private String A;
    private t A0;
    private String B;
    private com.bytedance.sdk.openadsdk.core.i0.a B0;
    private String C0;
    private JSONObject D0;
    private int E0;
    private boolean F0;
    private long G;
    private int H;
    private int I;
    private String I0;
    private b.a.a.a.a.a.a.f.b J;
    private int J0;
    private b.a.a.a.a.a.a.f.b K;
    private int K0;
    private b.a.a.a.a.a.a.f.b L;
    private boolean M;
    private String[] M0;
    private boolean N;
    private l N0;
    private boolean O;
    private String O0;
    private int P;
    private String P0;
    private boolean Q;
    private d Q0;
    private int R;
    private boolean R0;
    private Map<String, Object> S;
    private String S0;
    private q.a T;
    private String U;
    private int U0;
    private JSONObject V;
    private AdSlot b0;
    private int c0;
    private String e0;
    public long g;
    private int h;
    private int i;
    private JSONObject i0;
    private int j;
    private n k;
    private int k0;
    private n l;
    private String l0;
    private String m;
    private String m0;
    private String n;
    private k n0;
    private String q;
    private String q0;
    private String r;
    private int r0;
    private String s;
    private int s0;
    private String t;
    private int t0;
    private int u;
    private int u0;
    private c w;
    private j x;
    private int y;
    private int y0;
    private String z;
    private p z0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<n> f591b = new ArrayList();
    private final List<String> c = new ArrayList();
    private final List<FilterWord> d = new ArrayList();
    private final z e = z.a();
    public boolean f = false;
    private List<String> o = new ArrayList();
    private List<String> p = new ArrayList();
    private String v = "0";
    private String C = "";
    private int D = 0;
    private int E = 2;
    private int F = 0;
    private int W = 0;
    private int X = 1;
    private h Y = new h();
    private int Z = AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES;
    private int a0 = 0;
    private int d0 = 1;
    private int f0 = 0;
    private int g0 = 0;
    private int h0 = 0;
    private int j0 = 1;
    private int o0 = 1;
    private float p0 = 100.0f;
    private int v0 = 2;
    private int w0 = 1;
    private int x0 = 0;
    private int G0 = -1;
    private long H0 = -1;
    private int L0 = 0;
    private int T0 = 0;

    private static double b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void A(int i) {
        this.E = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int A0() {
        return this.D;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String B() {
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String B0() {
        return this.C;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void C(int i) {
        this.W = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean C0() {
        return this.Q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void D(int i) {
        this.K0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public JSONObject D0() {
        return this.i0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String E() {
        return this.O0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public List<String> E0() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String F() {
        return this.P0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String F0() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void G(int i) {
        this.R = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void H(int i) {
        this.g0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String H0() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int I() {
        JSONObject jSONObject = this.D0;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public q.a I0() {
        return this.T;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String J() {
        return this.S0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String[] J0() {
        String[] strArr = this.M0;
        return ((strArr == null || strArr.length <= 0) && !TextUtils.isEmpty(K0())) ? new String[]{K0()} : this.M0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int K() {
        return this.u0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String K0() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public com.bytedance.sdk.component.widget.b.a L() {
        com.bytedance.sdk.component.widget.b.a aVar = new com.bytedance.sdk.component.widget.b.a();
        aVar.a(this.R);
        aVar.b(this.v);
        aVar.a(N());
        return aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int L0() {
        return this.R;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public long M() {
        return this.G;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public com.bytedance.sdk.openadsdk.core.i0.a M0() {
        return this.B0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String N() {
        return this.B;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public b.a.a.a.a.a.a.f.b N0() {
        return this.J;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public JSONObject O() {
        if (this.V == null) {
            try {
                if (!TextUtils.isEmpty(this.B)) {
                    this.V = new JSONObject(this.B);
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.m.b("MaterialMeta", e.getMessage());
            }
        }
        return this.V;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int O0() {
        return this.g0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public JSONObject P() {
        return this.D0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int P0() {
        return this.y0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public long Q() {
        if (this.H0 < 0) {
            JSONObject jSONObjectO = O();
            if (jSONObjectO != null) {
                this.H0 = jSONObjectO.optLong("ad_id", 0L);
            } else {
                this.H0 = 0L;
            }
        }
        return this.H0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean Q0() {
        return this.e.a > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int R() {
        if (this.G0 < 0) {
            JSONObject jSONObjectO = O();
            if (jSONObjectO != null) {
                this.G0 = jSONObjectO.optInt("ad_slot_type", 0);
            } else {
                this.G0 = 0;
            }
        }
        return this.G0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean R0() {
        return this.R0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int S() {
        JSONObject jSONObjectO = O();
        if (jSONObjectO != null) {
            return jSONObjectO.optInt("rit", 0);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean S0() {
        return t1() == 100 || this.i == 20;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public double T() {
        return b(O());
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean T0() {
        return R() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String U() {
        JSONObject jSONObjectO;
        String strOptString = this.I0;
        if (TextUtils.isEmpty(strOptString) && (jSONObjectO = O()) != null) {
            strOptString = jSONObjectO.optString("req_id", "");
            z(strOptString);
        }
        return strOptString == null ? "" : strOptString;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean U0() {
        int i = this.i;
        return (i == 2 || i == 1) && 3 == this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int V() {
        return this.h0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean V0() {
        return this.T0 == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public List<FilterWord> W() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean W0() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String X() {
        return this.m0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean X0() {
        return f() != null && f().getDurationSlotType() == 8 && V0();
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public b.a.a.a.a.a.a.f.b Y() {
        return this.L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean Y0() {
        return R() == 8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public b.a.a.a.a.a.a.f.b Z() {
        return this.K;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean Z0() {
        return this.N;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(p pVar) {
        this.z0 = pVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int a0() {
        return this.P;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean a1() {
        return this.O;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public n b0() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean b1() {
        return this.M;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void c(boolean z) {
        this.N = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int c0() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean c1() {
        return this.E0 == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void d(boolean z) {
        this.O = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public List<n> d0() {
        return this.f591b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean d1() {
        return this.F0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void e(boolean z) {
        this.M = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int e0() {
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean e1() {
        return this.f0 == 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return this.v.equals(qVar.e()) && this.B.equals(qVar.N());
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public AdSlot f() {
        return this.b0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int f0() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean f1() {
        return R() == 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void g(String str) {
        this.q0 = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int g0() {
        return this.L0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean g1() {
        return !k1() && u1() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void h(String str) {
        this.A = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public p h0() {
        return this.z0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean h1() {
        b.a.a.a.a.a.a.f.b bVar = this.J;
        return bVar == null || bVar.k() != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void i(String str) {
        this.l0 = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public Map<String, Object> i0() {
        return this.S;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean i1() {
        return R() == 3 || R() == 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void j(String str) {
        this.s = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int j0() {
        if (this.o0 != 2) {
            this.o0 = 1;
        }
        return this.o0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean j1() {
        if (this.f591b.isEmpty()) {
            return false;
        }
        if (this.y == 4 && this.f591b.size() < 3) {
            return false;
        }
        Iterator<n> it = this.f591b.iterator();
        while (it.hasNext()) {
            if (!it.next().g()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int k() {
        d dVar = this.Q0;
        if (dVar == null) {
            return 2;
        }
        return dVar.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int k0() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean k1() {
        int i = this.T0;
        return (i == 1 || i == 3) && M0() != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public d l() {
        return this.Q0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int l0() {
        return this.w0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int m() {
        if (k1()) {
            return 2;
        }
        if (V0()) {
            return 4;
        }
        d dVar = this.Q0;
        if (dVar == null) {
            return 1;
        }
        return dVar.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int m0() {
        return this.r0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void m1() {
        this.F0 = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void n(String str) {
        this.O0 = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String n0() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public JSONObject n1() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", e0());
            jSONObject.put("interaction_method", k0());
            jSONObject.put("target_url", H0());
            jSONObject.put("app_log_url", i());
            jSONObject.put("gecko_id", X());
            jSONObject.put(ShareConstants.MEDIA_EXTENSION, P());
            jSONObject.put("ad_id", e());
            jSONObject.put("source", F0());
            jSONObject.put("screenshot", C0());
            jSONObject.put("dislike_control", u1());
            jSONObject.put("play_bar_show_time", o0());
            jSONObject.put("play_bar_style", p0());
            jSONObject.put("if_block_lp", w1());
            jSONObject.put("cache_sort", r1());
            jSONObject.put("if_sp_cache", y1());
            jSONObject.put("render_control", w0());
            jSONObject.put("mrc_report", this.E0);
            jSONObject.put("isMrcReportFinish", this.F0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SDKConstants.PARAM_GAME_REQUESTS_CTA, y());
            jSONObject2.put("other", l0());
            jSONObject.put("set_click_type", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(CampaignEx.JSON_KEY_REWARD_NAME, B0());
            jSONObject3.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, A0());
            jSONObject.put("reward_data", jSONObject3);
            if (!TextUtils.isEmpty(E()) && !TextUtils.isEmpty(F())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("adchoices_icon", E());
                jSONObject4.put("adchoices_url", F());
                jSONObject.put("dsp_adchoices", jSONObject4);
            }
            n nVarB0 = b0();
            if (nVarB0 != null && !TextUtils.isEmpty(nVarB0.d())) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("url", nVarB0.d());
                jSONObject5.put("height", nVarB0.b());
                jSONObject5.put("width", nVarB0.e());
                jSONObject.put(RewardPlus.ICON, jSONObject5);
            }
            n nVarW = w();
            if (nVarW != null && !TextUtils.isEmpty(nVarW.d())) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("url", nVarW.d());
                jSONObject6.put("height", nVarW.b());
                jSONObject6.put("width", nVarW.e());
                jSONObject.put("cover_image", jSONObject6);
            }
            Object objD0 = D0();
            if (objD0 != null) {
                jSONObject.put("session_params", objD0);
            }
            h hVarS = s();
            if (hVarS != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("click_upper_content_area", hVarS.a);
                jSONObject7.put("click_upper_non_content_area", hVarS.f577b);
                jSONObject7.put("click_lower_content_area", hVarS.c);
                jSONObject7.put("click_lower_non_content_area", hVarS.d);
                jSONObject7.put("click_button_area", hVarS.e);
                jSONObject7.put("click_video_area", hVarS.f);
                jSONObject.put("click_area", jSONObject7);
            }
            AdSlot adSlotF = f();
            if (adSlotF != null) {
                jSONObject.put("adslot", adSlotF.toJsonObj());
            }
            List<n> listD0 = d0();
            if (listD0 != null) {
                JSONArray jSONArray = new JSONArray();
                for (n nVar : listD0) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("url", nVar.d());
                    jSONObject8.put("height", nVar.b());
                    jSONObject8.put("width", nVar.e());
                    jSONObject8.put("image_preview", nVar.f());
                    jSONObject8.put("image_key", nVar.c());
                    jSONArray.put(jSONObject8);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> listE0 = E0();
            if (listE0 != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = listE0.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> listU = u();
            if (listU != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = listU.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, jSONArray3);
            }
            List<String> listQ0 = q0();
            if (listQ0 != null) {
                JSONArray jSONArray4 = new JSONArray();
                Iterator<String> it3 = listQ0.iterator();
                while (it3.hasNext()) {
                    jSONArray4.put(it3.next());
                }
                jSONObject.put("play_start", jSONArray4);
            }
            jSONObject.put("phone_num", n0());
            jSONObject.put("title", K0());
            jSONObject.put("description", B());
            jSONObject.put("ext", N());
            jSONObject.put("image_mode", c0());
            jSONObject.put("cover_click_area", t1());
            jSONObject.put("intercept_flag", v1());
            jSONObject.put("button_text", r());
            jSONObject.put("ad_logo", q1());
            jSONObject.put("video_adaptation", O0());
            jSONObject.put("feed_video_opentype", V());
            jSONObject.put("orientation", j0());
            jSONObject.put("aspect_ratio", o());
            c cVarH = h();
            if (cVarH != null) {
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, cVarH.a());
                jSONObject9.put(CampaignEx.JSON_KEY_PACKAGE_NAME, cVarH.e());
                jSONObject9.put(DownloadModel.DOWNLOAD_URL, cVarH.d());
                jSONObject9.put("score", cVarH.f());
                jSONObject9.put("comment_num", cVarH.c());
                jSONObject9.put(CampaignEx.JSON_KEY_APP_SIZE, cVarH.b());
                jSONObject.put("app", jSONObject9);
            }
            j jVarZ = z();
            if (jVarZ != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("deeplink_url", jVarZ.a());
                jSONObject10.put("fallback_url", jVarZ.b());
                jSONObject10.put("fallback_type", jVarZ.c());
                jSONObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, jSONObject10);
            }
            List<FilterWord> listW = W();
            if (listW != null) {
                JSONArray jSONArray5 = new JSONArray();
                Iterator<FilterWord> it4 = listW.iterator();
                while (it4.hasNext()) {
                    JSONObject jSONObjectB = b(it4.next());
                    if (jSONObjectB != null) {
                        jSONArray5.put(jSONObjectB);
                    }
                }
                jSONObject.put("filter_words", jSONArray5);
            }
            t0().a(jSONObject);
            jSONObject.put("count_down", s1());
            jSONObject.put("expiration_time", M());
            b.a.a.a.a.a.a.f.b bVarY = Y();
            if (bVarY != null) {
                jSONObject.put("video", bVarY.w());
            }
            b.a.a.a.a.a.a.f.b bVarZ = Z();
            if (bVarZ != null) {
                jSONObject.put("h265_video", bVarZ.w());
            }
            jSONObject.put("video_encode_type", P0());
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put("if_send_click", C());
            jSONObject.put("download_conf", jSONObject11);
            if (i0() != null) {
                JSONObject jSONObject12 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = i0().entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject12.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject12);
            }
            q.a aVarI0 = I0();
            if (aVarI0 != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("id", aVarI0.d());
                jSONObject13.put("md5", aVarI0.e());
                jSONObject13.put("url", aVarI0.f());
                jSONObject13.put("data", aVarI0.a());
                jSONObject13.put("diff_data", aVarI0.b());
                jSONObject13.put("version", aVarI0.g());
                jSONObject13.put("dynamic_creative", aVarI0.c());
                jSONObject.put("tpl_info", jSONObject13);
            }
            jSONObject.put("creative_extra", x());
            jSONObject.put("market_url", x1());
            jSONObject.put("auction_price", p());
            jSONObject.put("ad_info", p1());
            jSONObject.put("is_package_open", m0());
            jSONObject.put("playable_duration_time", r0());
            jSONObject.put("playable_endcard_close_time", s0());
            jSONObject.put("endcard_close_time", K());
            JSONObject jSONObject14 = new JSONObject();
            jSONObject14.put("render_sequence", y0());
            jSONObject14.put("backup_render_control", q());
            jSONObject14.put("reserve_time", x0());
            jSONObject14.put("render_thread", z0());
            jSONObject.put("render", jSONObject14);
            if (this.z0 == null) {
                p pVar = new p();
                this.z0 = pVar;
                pVar.a("");
                this.z0.a(10L);
                this.z0.b(20L);
            }
            JSONObject jSONObject15 = new JSONObject();
            jSONObject15.put("onlylp_loading_maxtime", this.z0.b());
            jSONObject15.put("straight_lp_showtime", this.z0.c());
            jSONObject15.put("loading_text", this.z0.a());
            jSONObject.put("interaction_method_params", jSONObject15);
            JSONObject jSONObject16 = new JSONObject();
            jSONObject16.put("splash_clickarea", k());
            jSONObject16.put("splash_layout_id", m());
            jSONObject16.put("load_wait_time", n());
            jSONObject.put("splash_control", jSONObject16);
            if (V0()) {
                jSONObject.put("dsp_html", this.C0);
            }
            if (k1()) {
                jSONObject.put("vast_json", this.B0.d());
            }
            jSONObject.put("dsp_material_type", G());
            JSONObject jSONObject17 = new JSONObject();
            jSONObject17.put("loading_landingpage_type", g0());
            String[] strArr = this.M0;
            if (strArr != null && strArr.length > 0) {
                JSONArray jSONArray6 = new JSONArray();
                for (String str : this.M0) {
                    jSONArray6.put(str);
                }
                jSONObject17.put("landingpage_text", jSONArray6);
            }
            jSONObject.put("loading_page", jSONObject17);
            jSONObject.put("deep_link_appname", this.t);
            jSONObject.put("landing_page_download_clicktype", this.u);
            l lVar = this.N0;
            if (lVar != null) {
                jSONObject.put("dsp_style", lVar.d());
            }
            jSONObject.put("jump_probability", this.U0);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void o(String str) {
        this.P0 = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int o0() {
        return this.Z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void o1() {
        this.e.e();
        b(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void p(int i) {
        this.f0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int p0() {
        if (k1()) {
            return 5;
        }
        if (o() != 100.0f || w0() == 2) {
            return 0;
        }
        return this.a0;
    }

    public String p1() {
        return this.q0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void q(String str) {
        this.S0 = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public List<String> q0() {
        return this.c;
    }

    public int q1() {
        return this.d0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String r() {
        if (!TextUtils.isEmpty(this.s)) {
            return this.s;
        }
        Context contextA = com.bytedance.sdk.openadsdk.core.o.a();
        int iE0 = e0();
        if (iE0 == 2 || iE0 == 3) {
            return contextA != null ? com.bytedance.sdk.component.utils.t.k(contextA, "tt_video_mobile_go_detail") : this.s;
        }
        if (iE0 != 4) {
            return this.s;
        }
        return contextA != null ? com.bytedance.sdk.component.utils.t.k(contextA, "tt_video_download_apk") : this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int r0() {
        int i = this.s0;
        if (i > 0) {
            return i;
        }
        return 20;
    }

    public int r1() {
        return this.j0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public h s() {
        return this.Y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int s0() {
        return this.t0;
    }

    public int s1() {
        return this.H;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void t(String str) {
        this.e0 = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public t t0() {
        return this.A0;
    }

    public int t1() {
        return this.I;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void u(String str) {
        this.n = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int u0() {
        return this.x0;
    }

    public int u1() {
        return this.F;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int v() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public long v0() {
        return this.g;
    }

    public int v1() {
        return this.c0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void w(int i) {
        this.a0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int w0() {
        int i = this.i;
        if (i == 5 || i == 6) {
            return 1;
        }
        if (X0()) {
            return 2;
        }
        return this.E;
    }

    public int w1() {
        return this.f0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String x() {
        return this.U;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int x0() {
        return this.J0;
    }

    public String x1() {
        return this.e0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int y() {
        return this.v0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int y0() {
        return this.W;
    }

    public int y1() {
        return this.k0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public j z() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int z0() {
        return this.K0;
    }

    public b.b.a.a.d.e.c.c z1() {
        q.a aVarI0 = I0();
        if (aVarI0 == null) {
            return null;
        }
        return q.a.a(aVarI0, "" + S());
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String A() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void B(int i) {
        this.J0 = Math.max(0, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int C() {
        k kVar = this.n0;
        if (kVar == null) {
            return 0;
        }
        return kVar.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String D() {
        c cVarH = h();
        if (cVarH == null || TextUtils.isEmpty(cVarH.d())) {
            return null;
        }
        return cVarH.d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void E(int i) {
        this.D = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void F(int i) {
        this.k0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int G() {
        return this.T0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String H() {
        return this.C0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void J(int i) {
        this.i = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(d dVar) {
        this.Q0 = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void b(boolean z) {
        this.R0 = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void c(int i) {
        this.j0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean d() {
        return (TextUtils.isEmpty(E()) || TextUtils.isEmpty(F())) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void e(int i) {
        a(i, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void f(String str) {
        this.v = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void g(int i) {
        this.I = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public c h() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String i() {
        return this.A;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void j(int i) {
        this.u0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void k(int i) {
        this.h0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void l(int i) {
        this.P = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public long n() {
        d dVar = this.Q0;
        if (dVar == null) {
            return 0L;
        }
        return dVar.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void o(int i) {
        this.c0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String p() {
        return this.l0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int q() {
        return this.X;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void s(String str) {
        this.m0 = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void t(int i) {
        this.o0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public List<String> u() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void v(String str) {
        this.C = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void w(String str) {
        this.z = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void x(String str) {
        this.m = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void y(String str) {
        this.q = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void z(int i) {
        this.x0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void I(int i) {
        this.y0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(t tVar) {
        this.A0 = tVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void b(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.w0 = 1;
        } else {
            this.w0 = (int) d;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void c(b.a.a.a.a.a.a.f.b bVar) {
        this.J = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void d(int i) {
        this.U0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String e() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void f(int i) {
        this.H = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public int g() {
        return this.G0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void h(int i) {
        this.F = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void i(int i) {
        this.T0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String j() {
        String strK0 = K0();
        return (h() == null || TextUtils.isEmpty(h().a())) ? strK0 : h().a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void k(String str) {
        this.U = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void l(String str) {
        this.t = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void n(int i) {
        this.h = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public float o() {
        if (this.p0 <= 0.0f) {
            this.p0 = 100.0f;
        }
        return (this.p0 * 1000.0f) / 1000.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void p(String str) {
        this.C0 = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void q(int i) {
        this.u = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void s(int i) {
        this.E0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public z t() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void u(int i) {
        this.r0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void v(int i) {
        this.Z = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public n w() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void x(int i) {
        this.s0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void y(int i) {
        this.t0 = i;
    }

    public void z(String str) {
        this.I0 = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(int i, int i2) {
        this.j = i;
        this.i = i;
        if (this.b0 == null) {
            this.i = 0;
            return;
        }
        if (i2 <= 0) {
            i2 = R();
        }
        if (this.b0.getNativeAdType() != 3 && this.b0.getDurationSlotType() != 3 && i2 != 3) {
            if (this.b0.getNativeAdType() != 7 && this.b0.getNativeAdType() != 8 && this.b0.getDurationSlotType() != 7 && this.b0.getDurationSlotType() != 8 && i2 != 7 && i2 != 8) {
                if (t.i(this)) {
                    this.i = 4;
                    return;
                }
                if (this.j == 4 && !t.i(this)) {
                    this.i = 0;
                }
                if (i >= 5) {
                    this.i = 0;
                    return;
                }
                if (this.j == 2 && e0() != 3) {
                    this.i = 0;
                    return;
                } else {
                    if (i == 0 || (i == 1 && e0() != 3)) {
                        this.i = 0;
                        return;
                    }
                    return;
                }
            }
            if (t.h(this)) {
                this.i = 12;
                return;
            }
            if (t.i(this)) {
                this.i = 9;
                return;
            }
            if (this.j == 5 && !o.b(this)) {
                this.i = 7;
            }
            if (this.j == 6 && !o.f(this)) {
                this.i = 7;
            }
            if (this.j == 8 && t1() != 100) {
                this.i = 7;
            }
            if (this.j == 19 && TextUtils.isEmpty(this.m)) {
                this.i = 7;
            }
            if (this.j == 20 && TextUtils.isEmpty(this.m)) {
                this.i = 7;
            }
            if (i < 5) {
                this.i = 7;
                return;
            }
            return;
        }
        this.i = 14;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void c(n nVar) {
        this.k = nVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void e(JSONObject jSONObject) {
        this.D0 = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void f(boolean z) {
        this.Q = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public String c(String str) {
        JSONObject jSONObjectO = O();
        return jSONObjectO != null ? jSONObjectO.optString("rit", str) : str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void f(JSONObject jSONObject) {
        this.i0 = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void b(int i) {
        this.X = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void b(n nVar) {
        this.l = nVar;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a  */
    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean c() {
        int iB;
        if (Q0()) {
            return false;
        }
        int iNextInt = new Random().nextInt(100);
        if (k1()) {
            l lVar = this.N0;
            if (lVar != null) {
                iB = lVar.b();
            } else {
                iB = 0;
            }
        } else if (t.i(this)) {
            iB = 0;
        } else {
            iB = this.U0;
        }
        return iNextInt < iB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void m(String str) {
        this.r = str;
    }

    private JSONObject b(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<FilterWord> it = filterWord.getOptions().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(b(it.next()));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void m(int i) {
        this.y = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void b(b.a.a.a.a.a.a.f.b bVar) {
        this.K = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean b() {
        if (!k1() || Q0()) {
            return false;
        }
        int iNextInt = new Random().nextInt(100);
        l lVar = this.N0;
        return lVar != null && iNextInt < lVar.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void b(long j) {
        this.g = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void r(String str) {
        this.B = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void r(int i) {
        this.L0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.v0 = 2;
        } else {
            this.v0 = (int) d;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(int i) {
        this.d0 = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(h hVar) {
        this.Y = hVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(AdSlot adSlot) {
        this.b0 = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(q.a aVar) {
        this.T = aVar;
        b.b.a.a.d.e.c.c cVarZ1 = z1();
        if (cVarZ1 != null) {
            b.b.a.a.d.e.b.a.a(cVarZ1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(k kVar) {
        this.n0 = kVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(n nVar) {
        this.f591b.add(nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(c cVar) {
        this.w = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(j jVar) {
        this.x = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(FilterWord filterWord) {
        this.d.add(filterWord);
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(long j) {
        this.G = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(Map<String, Object> map) {
        this.S = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(float f) {
        this.p0 = f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.h = 4;
        this.v = jSONObject.optString("id");
        this.z = jSONObject.optString("source");
        c cVar = new c();
        this.w = cVar;
        cVar.c(jSONObject.optString("pkg_name"));
        this.w.a(jSONObject.optString("name"));
        this.w.b(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(com.bytedance.sdk.openadsdk.core.i0.a aVar) {
        this.B0 = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(String[] strArr) {
        this.M0 = strArr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(l lVar) {
        this.N0 = lVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(b.a.a.a.a.a.a.f.b bVar) {
        this.L = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public boolean a() {
        l lVar;
        return k1() && !Q0() && (lVar = this.N0) != null && lVar.a() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f0.q
    public void a(boolean z) {
        this.f = z;
    }
}
