package com.bytedance.sdk.openadsdk.core.settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdSlotSetter.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public boolean F;
    public int G;
    public int H;
    public int I;
    public long J;
    public String K;
    public String L;
    public List<f> M;
    public List<f> N;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f671b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public int u;
    public List<String> v;
    public int w;
    public int x;
    public int y;
    public int z;

    public a(JSONObject jSONObject) {
        this.f671b = 1;
        this.c = 1;
        this.d = 2;
        this.e = 1;
        this.f = 100;
        this.g = 0;
        this.h = 2;
        this.i = 1;
        this.j = 3;
        this.k = 30;
        this.l = 1;
        this.m = 1;
        this.n = 2;
        this.o = 1500;
        this.p = 2;
        this.q = -1;
        this.r = 0;
        this.s = 5;
        this.t = false;
        this.u = 0;
        this.w = -1;
        this.x = 0;
        this.y = 0;
        this.z = 5;
        this.A = true;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = -1;
        this.F = false;
        this.G = 60000;
        this.H = 2;
        this.I = 1;
        this.M = new ArrayList();
        this.N = new ArrayList();
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("code_id");
        this.f671b = jSONObject.optInt("auto_play", 1);
        this.E = jSONObject.optInt("endcard_close_time", -1);
        this.c = jSONObject.optInt("voice_control", 1);
        this.d = jSONObject.optInt("rv_preload", 2);
        this.e = jSONObject.optInt("nv_preload", 1);
        this.f = jSONObject.optInt("proportion_watching", 100);
        this.g = jSONObject.optInt("skip_time_displayed", 0);
        this.h = jSONObject.optInt("video_skip_result", 2);
        this.i = jSONObject.optInt("reg_creative_control", 1);
        this.j = jSONObject.optInt("play_bar_show_time", 3);
        int iOptInt = jSONObject.optInt("rv_skip_time", 30);
        this.k = iOptInt;
        if (iOptInt < 0) {
            this.k = 30;
        }
        this.l = jSONObject.optInt("voice_control", 2);
        this.m = jSONObject.optInt("if_show_win", 1);
        this.n = jSONObject.optInt("sp_preload", 2);
        this.o = jSONObject.optInt("stop_time", 1500);
        this.p = jSONObject.optInt("native_playable_delay", 2);
        this.q = jSONObject.optInt("time_out_control", -1);
        this.w = jSONObject.optInt("playable_close_time", -1);
        this.r = jSONObject.optInt("playable_reward_type", 0);
        this.u = jSONObject.optInt("reward_is_callback", 0);
        this.s = jSONObject.optInt("iv_skip_time", 5);
        a(jSONObject.optJSONArray("parent_tpl_ids"));
        jSONObject.optInt("slot_type", 2);
        this.t = jSONObject.optBoolean("close_on_click", false);
        this.x = jSONObject.optInt("allow_system_back", 0);
        this.y = jSONObject.optInt("splash_skip_time", 0);
        this.z = jSONObject.optInt("splash_image_count_down_time", 5);
        this.B = jSONObject.optBoolean("splash_count_down_time_off", false);
        this.C = jSONObject.optBoolean("splash_close_on_click", false);
        int iOptInt2 = jSONObject.optInt("splash_load_strategy", 0);
        this.D = iOptInt2;
        if (iOptInt2 < 0 || iOptInt2 > 1) {
            this.D = 0;
        }
        this.A = jSONObject.optBoolean("allow_mediaview_click", true);
        int iOptInt3 = jSONObject.optInt("total_time_out", 60000);
        this.G = iOptInt3;
        if (iOptInt3 <= 0 || iOptInt3 > 1800000) {
            this.G = 60000;
        }
        int iOptInt4 = jSONObject.optInt("req_parallel_num", 2);
        this.H = iOptInt4;
        if (iOptInt4 < 1 || iOptInt4 > 4) {
            this.H = 2;
        }
        jSONObject.optInt("bidding_token_tmax", 1000);
        int iOptInt5 = jSONObject.optInt("ad_load_type", 1);
        this.I = iOptInt5;
        if (iOptInt5 < 1 || iOptInt5 > 2) {
            this.I = 1;
        }
        boolean zOptBoolean = jSONObject.optBoolean("is_mediation", false);
        this.F = zOptBoolean;
        if (zOptBoolean) {
            n.j0().F();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("mediation_config");
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString("adn_name");
                String strOptString2 = jSONObjectOptJSONObject.optString("adn_slot_id");
                int iOptInt6 = jSONObjectOptJSONObject.optInt("ad_expired_time", 3600000);
                int iOptInt7 = jSONObjectOptJSONObject.optInt("req_bidding_type", 2);
                String strOptString3 = jSONObjectOptJSONObject.optString("rit_cpm");
                int iOptInt8 = jSONObjectOptJSONObject.optInt("show_sort");
                int iOptInt9 = jSONObjectOptJSONObject.optInt("layer_time_out", 2000);
                int i2 = (iOptInt9 <= 0 || iOptInt9 > 60000) ? 2000 : iOptInt9;
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("server_params");
                if (iOptInt7 == 2) {
                    arrayList.add(new f(strOptString, strOptString2, iOptInt6, iOptInt7, strOptString3, iOptInt8, i2, jSONObjectOptJSONObject2 == null ? "" : jSONObjectOptJSONObject2.toString()));
                } else if (iOptInt7 == 0) {
                    arrayList2.add(new f(strOptString, strOptString2, iOptInt6, iOptInt7, strOptString3, iOptInt8, i2, jSONObjectOptJSONObject2 == null ? "" : jSONObjectOptJSONObject2.toString()));
                }
            }
            this.M = arrayList;
            this.N = arrayList2;
            Collections.sort(arrayList);
            Collections.sort(this.N);
        }
        if (!a(this.c)) {
            this.c = 1;
        }
        if (!a(this.l)) {
            this.l = 1;
        }
        this.J = jSONObject.optLong("waterfall_id");
        this.K = jSONObject.optString("waterfall_version");
    }

    private static boolean a(int i) {
        return i == 1 || i == 2;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        this.v = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.v.add(jSONArray.get(i).toString());
            } catch (Exception unused) {
                return;
            }
        }
    }

    public a(String str, int i) {
        this.f671b = 1;
        this.c = 1;
        this.d = 2;
        this.e = 1;
        this.f = 100;
        this.g = 0;
        this.h = 2;
        this.i = 1;
        this.j = 3;
        this.k = 30;
        this.l = 1;
        this.m = 1;
        this.n = 2;
        this.o = 1500;
        this.p = 2;
        this.q = -1;
        this.r = 0;
        this.s = 5;
        this.t = false;
        this.u = 0;
        this.w = -1;
        this.x = 0;
        this.y = 0;
        this.z = 5;
        this.A = true;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = -1;
        this.F = false;
        this.G = 60000;
        this.H = 2;
        this.I = 1;
        this.M = new ArrayList();
        this.N = new ArrayList();
        this.a = str;
        this.c = i;
    }
}
