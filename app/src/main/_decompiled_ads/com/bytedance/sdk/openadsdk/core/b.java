package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdInfoFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: compiled from: AdInfoFactory.java */
    static class a implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f556b;
        final /* synthetic */ boolean c;

        a(com.bytedance.sdk.openadsdk.core.f0.a aVar, int i, boolean z) {
            this.a = aVar;
            this.f556b = i;
            this.c = z;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_id", this.a.c());
            jSONObject.put("material_error", this.f556b);
            jSONObject.put("choose_ui_error", this.c ? 1 : 0);
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("choose_ad_parsing_error").c(jSONObject.toString());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdInfoFactory.java */
    static class C0191b extends b.b.a.a.k.g {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.i0.a c;
        final /* synthetic */ long d;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.i0.k.b.a e;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.q f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0191b(String str, com.bytedance.sdk.openadsdk.core.i0.a aVar, long j, com.bytedance.sdk.openadsdk.core.i0.k.b.a aVar2, com.bytedance.sdk.openadsdk.core.f0.q qVar, String str2) {
            super(str);
            this.c = aVar;
            this.d = j;
            this.e = aVar2;
            this.f = qVar;
            this.g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.core.i0.a aVar = this.c;
                String str = "load_vast_fail";
                if (aVar == null) {
                    jSONObject.put("reason_code", -2);
                    com.bytedance.sdk.openadsdk.core.i0.k.b.a aVar2 = this.e;
                    if (aVar2 != null) {
                        jSONObject.put("error_code", aVar2.a);
                    }
                } else if (TextUtils.isEmpty(aVar.f()) || TextUtils.isEmpty(this.c.a()) || this.c.k() <= 0.0d) {
                    jSONObject.put("reason_code", -3);
                    jSONObject.put("error_code", -3);
                } else {
                    jSONObject.put("duration", System.currentTimeMillis() - this.d);
                    com.bytedance.sdk.openadsdk.core.i0.k.b.a aVar3 = this.e;
                    if (aVar3 != null) {
                        jSONObject.put("wrapper_count", aVar3.f616b);
                        jSONObject.put("impression_links_null", this.e.c);
                    }
                    str = "load_vast_success";
                }
                com.bytedance.sdk.openadsdk.d.c.b(this.f, this.g, str, jSONObject);
                com.bytedance.sdk.openadsdk.core.i0.a aVar4 = this.c;
                if (aVar4 == null || aVar4.h() == null || !TextUtils.isEmpty(this.c.h().a())) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("error_code", 1000);
                    jSONObject2.put("description", "1000:Image url is null");
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.d.c.b(this.f, this.g, "load_vast_icon_fail", jSONObject2);
                this.c.a((com.bytedance.sdk.openadsdk.core.i0.b) null);
            } catch (Exception unused2) {
            }
        }
    }

    public static Pair<com.bytedance.sdk.openadsdk.core.f0.a, ArrayList<Integer>> a(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.f0.a aVar = new com.bytedance.sdk.openadsdk.core.f0.a();
            aVar.b(jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID));
            aVar.a(jSONObject.optInt("ret"));
            aVar.a(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("gdid_encrypted");
            if (jSONObject.has("choose_ui_data")) {
                aVar.b(jSONObject.optJSONObject("choose_ui_data"));
                aVar.a(true);
            }
            String strOptString2 = jSONObject.optString("auction_price");
            if (aVar.d() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                while (i < jSONArrayOptJSONArray.length()) {
                    com.bytedance.sdk.openadsdk.core.f0.q qVarB = b(jSONArrayOptJSONArray.optJSONObject(i), adSlot, sVar);
                    int iA = a(qVarB);
                    if (iA != 200) {
                        arrayList.add(Integer.valueOf(iA));
                    } else {
                        qVarB.i(strOptString2);
                        if (!TextUtils.isEmpty(strOptString)) {
                            qVarB.q(strOptString);
                        }
                        aVar.a(qVarB);
                    }
                    i++;
                }
                i = length;
            }
            a(i, aVar);
            return new Pair<>(aVar, arrayList);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("AdInfoFactory", th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:126:0x0501 A[PHI: r14
      0x0501: PHI (r14v76 int) = (r14v75 int), (r14v104 int) binds: [B:119:0x04ed, B:124:0x04fe] A[DONT_GENERATE, DONT_INLINE]] */
    public static com.bytedance.sdk.openadsdk.core.f0.q b(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar) {
        b.a.a.a.a.a.a.f.b bVarA;
        b.a.a.a.a.a.a.f.b bVarA2;
        int i;
        com.bytedance.sdk.openadsdk.core.i0.a aVarA;
        com.bytedance.sdk.openadsdk.core.i0.k.b.a aVar;
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.f0.q qVarL1 = com.bytedance.sdk.openadsdk.core.f0.q.l1();
        qVarL1.n(jSONObject.optInt("interaction_type"));
        qVarL1.x(jSONObject.optString("target_url"));
        qVarL1.f(jSONObject.optString("ad_id"));
        qVarL1.h(jSONObject.optString("app_log_url"));
        qVarL1.w(jSONObject.optString("source"));
        int i2 = 0;
        qVarL1.h(jSONObject.optInt("dislike_control", 0));
        qVarL1.v(jSONObject.optInt("play_bar_show_time", AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES));
        qVarL1.s(jSONObject.optString("gecko_id"));
        if (jSONObject.has("set_click_type")) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("set_click_type");
            qVarL1.a(jSONObjectOptJSONObject.optDouble(SDKConstants.PARAM_GAME_REQUESTS_CTA, 2.0d));
            qVarL1.b(jSONObjectOptJSONObject.optDouble("other", 1.0d));
        }
        qVarL1.e(jSONObject.optJSONObject(ShareConstants.MEDIA_EXTENSION));
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(RewardPlus.ICON);
        qVarL1.f(jSONObject.optBoolean("screenshot", false));
        qVarL1.w(jSONObject.optInt("play_bar_style", 0));
        qVarL1.t(jSONObject.optString("market_url", ""));
        qVarL1.H(jSONObject.optInt("video_adaptation", 0));
        qVarL1.k(jSONObject.optInt("feed_video_opentype", 0));
        qVarL1.f(jSONObject.optJSONObject("session_params"));
        qVarL1.i(jSONObject.optString("auction_price", ""));
        qVarL1.s(jSONObject.optInt("mrc_report", 0));
        if (jSONObject.optBoolean("isMrcReportFinish", false)) {
            qVarL1.m1();
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("render");
        if (jSONObjectOptJSONObject3 != null) {
            qVarL1.C(jSONObjectOptJSONObject3.optInt("render_sequence", 0));
            qVarL1.b(jSONObjectOptJSONObject3.optInt("backup_render_control", 1));
            qVarL1.B(jSONObjectOptJSONObject3.optInt("reserve_time", 100));
            qVarL1.D(jSONObjectOptJSONObject3.optInt("render_thread", 0));
        }
        qVarL1.A(jSONObject.optInt("render_control", sVar != null ? sVar.f : 1));
        if (jSONObjectOptJSONObject2 != null) {
            com.bytedance.sdk.openadsdk.core.f0.n nVar = new com.bytedance.sdk.openadsdk.core.f0.n();
            nVar.b(jSONObjectOptJSONObject2.optString("url"));
            nVar.a(jSONObjectOptJSONObject2.optInt("height"));
            nVar.b(jSONObjectOptJSONObject2.optInt("width"));
            qVarL1.c(nVar);
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("reward_data");
        if (jSONObjectOptJSONObject4 != null) {
            qVarL1.E(jSONObjectOptJSONObject4.optInt(CampaignEx.JSON_KEY_REWARD_AMOUNT, 0));
            qVarL1.v(jSONObjectOptJSONObject4.optString(CampaignEx.JSON_KEY_REWARD_NAME, ""));
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("cover_image");
        if (jSONObjectOptJSONObject5 != null) {
            com.bytedance.sdk.openadsdk.core.f0.n nVar2 = new com.bytedance.sdk.openadsdk.core.f0.n();
            nVar2.b(jSONObjectOptJSONObject5.optString("url"));
            nVar2.a(jSONObjectOptJSONObject5.optInt("height"));
            nVar2.b(jSONObjectOptJSONObject5.optInt("width"));
            qVarL1.b(nVar2);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("image");
        if (jSONArrayOptJSONArray != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                com.bytedance.sdk.openadsdk.core.f0.n nVar3 = new com.bytedance.sdk.openadsdk.core.f0.n();
                JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray.optJSONObject(i3);
                nVar3.b(jSONObjectOptJSONObject6.optString("url"));
                nVar3.a(jSONObjectOptJSONObject6.optInt("height"));
                nVar3.b(jSONObjectOptJSONObject6.optInt("width"));
                nVar3.a(jSONObjectOptJSONObject6.optBoolean("image_preview"));
                nVar3.a(jSONObjectOptJSONObject6.optString("image_key"));
                qVarL1.a(nVar3);
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("show_url");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                qVarL1.E0().add(jSONArrayOptJSONArray2.optString(i4));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(CampaignEx.JSON_KEY_CLICK_URL);
        if (jSONArrayOptJSONArray3 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray3.length(); i5++) {
                qVarL1.u().add(jSONArrayOptJSONArray3.optString(i5));
            }
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("play_start");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray4.length(); i6++) {
                qVarL1.q0().add(jSONArrayOptJSONArray4.optString(i6));
            }
        }
        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("click_area");
        if (jSONObjectOptJSONObject7 != null) {
            com.bytedance.sdk.openadsdk.core.f0.h hVar = new com.bytedance.sdk.openadsdk.core.f0.h();
            hVar.a = jSONObjectOptJSONObject7.optBoolean("click_upper_content_area", true);
            hVar.f577b = jSONObjectOptJSONObject7.optBoolean("click_upper_non_content_area", true);
            hVar.c = jSONObjectOptJSONObject7.optBoolean("click_lower_content_area", true);
            hVar.d = jSONObjectOptJSONObject7.optBoolean("click_lower_non_content_area", true);
            hVar.e = jSONObjectOptJSONObject7.optBoolean("click_button_area", true);
            hVar.f = jSONObjectOptJSONObject7.optBoolean("click_video_area", true);
            qVarL1.a(hVar);
        }
        JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("adslot");
        if (jSONObjectOptJSONObject8 != null) {
            qVarL1.a(a(jSONObjectOptJSONObject8));
        } else {
            qVarL1.a(adSlot);
        }
        qVarL1.o(jSONObject.optInt("intercept_flag", 0));
        qVarL1.u(jSONObject.optString("phone_num"));
        qVarL1.y(jSONObject.optString("title"));
        qVarL1.m(jSONObject.optString("description"));
        qVarL1.j(jSONObject.optString("button_text"));
        qVarL1.a(jSONObject.optInt("ad_logo", 1));
        qVarL1.r(jSONObject.optString("ext"));
        qVarL1.g(jSONObject.optInt("cover_click_area", 0));
        qVarL1.m(jSONObject.optInt("image_mode"));
        qVarL1.t(jSONObject.optInt("orientation", 1));
        qVarL1.a((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        qVarL1.g(jSONObject.optInt("cover_click_area", 0));
        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("app");
        JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject(CampaignEx.JSON_KEY_DEEP_LINK_URL);
        qVarL1.a(b(jSONObjectOptJSONObject9));
        qVarL1.a(e(jSONObject.optJSONObject("interaction_method_params")));
        qVarL1.a(c(jSONObjectOptJSONObject10));
        qVarL1.a(new com.bytedance.sdk.openadsdk.core.f0.t(jSONObject));
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i7 = 0; i7 < jSONArrayOptJSONArray5.length(); i7++) {
                FilterWord filterWordI = i(jSONArrayOptJSONArray5.optJSONObject(i7));
                if (filterWordI != null && filterWordI.isValid()) {
                    qVarL1.a(filterWordI);
                }
            }
        }
        qVarL1.f(jSONObject.optInt("count_down"));
        qVarL1.a(jSONObject.optLong("expiration_time"));
        qVarL1.I(jSONObject.optInt("video_encode_type", 0));
        qVarL1.z(0);
        JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject11 != null) {
            bVarA = a(jSONObjectOptJSONObject11, qVarL1);
            qVarL1.a(bVarA);
        } else {
            bVarA = null;
        }
        JSONObject jSONObjectOptJSONObject12 = jSONObject.optJSONObject("h265_video");
        if (jSONObjectOptJSONObject12 != null) {
            bVarA2 = a(jSONObjectOptJSONObject12, qVarL1);
            qVarL1.b(bVarA2);
        } else {
            bVarA2 = null;
        }
        if (Build.VERSION.SDK_INT < 26 || qVarL1.P0() == 0) {
            qVarL1.c(bVarA);
            qVarL1.I(0);
        } else {
            if (bVarA2 != null && bVarA != null) {
                if (TextUtils.isEmpty(bVarA2.d())) {
                    bVarA2.b(bVarA.d());
                }
                if (TextUtils.isEmpty(bVarA2.l())) {
                    bVarA2.d(bVarA.l());
                }
                bVarA2.c(bVarA.e());
            }
            if (bVarA2 != null) {
                qVarL1.c(bVarA2);
            } else {
                qVarL1.c(bVarA);
            }
        }
        JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject("download_conf");
        if (jSONObjectOptJSONObject13 != null) {
            qVarL1.a(d(jSONObjectOptJSONObject13));
        }
        qVarL1.a(g(jSONObject.optJSONObject("media_ext")));
        JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject14 != null) {
            com.bytedance.sdk.openadsdk.core.f0.q.a aVar2 = new com.bytedance.sdk.openadsdk.core.f0.q.a();
            aVar2.d(jSONObjectOptJSONObject14.optString("id"));
            aVar2.e(jSONObjectOptJSONObject14.optString("md5"));
            aVar2.f(jSONObjectOptJSONObject14.optString("url"));
            aVar2.a(jSONObjectOptJSONObject14.optString("data"));
            aVar2.b(jSONObjectOptJSONObject14.optString("diff_data"));
            aVar2.c(jSONObjectOptJSONObject14.optString("dynamic_creative"));
            aVar2.g(jSONObjectOptJSONObject14.optString("version"));
            qVarL1.a(aVar2);
        }
        qVarL1.k(jSONObject.optString("creative_extra"));
        qVarL1.p(jSONObject.optInt("if_block_lp", 0));
        qVarL1.c(jSONObject.optInt("cache_sort", 1));
        qVarL1.F(jSONObject.optInt("if_sp_cache", 0));
        JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("splash_control");
        if (jSONObjectOptJSONObject15 != null) {
            qVarL1.a(h(jSONObjectOptJSONObject15));
        }
        qVarL1.u(jSONObject.optInt("is_package_open", 1));
        qVarL1.g(jSONObject.optString("ad_info", null));
        qVarL1.G(jSONObject.optInt("ua_policy", 2));
        qVarL1.x(jSONObject.optInt("playable_duration_time", 20));
        qVarL1.y(jSONObject.optInt("playable_endcard_close_time", -1));
        qVarL1.j(jSONObject.optInt("endcard_close_time", -1));
        qVarL1.e(jSONObject.optInt("interaction_method"));
        qVarL1.p(jSONObject.optString("dsp_html"));
        JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("loading_page");
        if (jSONObjectOptJSONObject16 != null) {
            qVarL1.r(jSONObjectOptJSONObject16.optInt("loading_landingpage_type", 0));
            JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject16.optJSONArray("landingpage_text");
            if (jSONArrayOptJSONArray6 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i8 = 0; i8 < jSONArrayOptJSONArray6.length(); i8++) {
                    String strOptString = jSONArrayOptJSONArray6.optString(i8);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                    }
                }
                qVarL1.a((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }
        int iOptInt = jSONObject.optInt("dsp_material_type", 0);
        if (iOptInt < 0 || iOptInt > 3) {
            iOptInt = 0;
        }
        if (iOptInt == 0) {
            if (jSONObject.optBoolean("is_vast", false)) {
                iOptInt = 1;
            }
            i = jSONObject.optBoolean("is_html", false) ? 2 : iOptInt;
        }
        qVarL1.i(i);
        if (i == 1 || i == 3) {
            int iG = qVarL1.g();
            if (iG < 0) {
                iG = qVarL1.f() != null ? qVarL1.f().getDurationSlotType() : qVarL1.R();
            }
            String strD = com.bytedance.sdk.openadsdk.utils.a0.d(iG);
            if (jSONObject.has("vast_json")) {
                aVarA = com.bytedance.sdk.openadsdk.core.i0.a.a(jSONObject.optJSONObject("vast_json"));
            } else {
                String strOptString2 = jSONObject.optString("dsp_vast");
                if (TextUtils.isEmpty(strOptString2)) {
                    a(qVarL1, strD);
                    return null;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Pair<com.bytedance.sdk.openadsdk.core.i0.a, com.bytedance.sdk.openadsdk.core.i0.k.b.a> pairA = a(strOptString2, qVarL1.j0(), iG);
                if (pairA != null) {
                    com.bytedance.sdk.openadsdk.core.i0.a aVar3 = (com.bytedance.sdk.openadsdk.core.i0.a) pairA.first;
                    aVar = (com.bytedance.sdk.openadsdk.core.i0.k.b.a) pairA.second;
                    aVarA = aVar3;
                } else {
                    aVarA = null;
                    aVar = null;
                }
                a(qVarL1, strD, aVarA, jCurrentTimeMillis, aVar);
            }
            if (aVarA != null) {
                aVarA.d(strD);
            }
            if (aVarA == null) {
                return null;
            }
            a(aVarA, qVarL1);
        }
        qVarL1.l(jSONObject.optString("deep_link_appname", ""));
        qVarL1.q(jSONObject.optInt("landing_page_download_clicktype", 1));
        JSONObject jSONObjectOptJSONObject17 = jSONObject.optJSONObject("dsp_style");
        if (jSONObjectOptJSONObject17 != null) {
            qVarL1.a(new com.bytedance.sdk.openadsdk.core.f0.l(jSONObjectOptJSONObject17));
        }
        JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("dsp_adchoices");
        if (jSONObjectOptJSONObject18 != null) {
            qVarL1.n(jSONObjectOptJSONObject18.optString("adchoices_icon", ""));
            qVarL1.o(jSONObjectOptJSONObject18.optString("adchoices_url", ""));
        }
        String strOptString3 = jSONObject.optString("gdid_encrypted");
        if (!TextUtils.isEmpty(strOptString3)) {
            qVarL1.q(strOptString3);
        }
        int iOptInt2 = jSONObject.optInt("jump_probability", 0);
        if (iOptInt2 >= 0 && iOptInt2 <= 100) {
            i2 = iOptInt2;
        }
        qVarL1.d(i2);
        return qVarL1;
    }

    private static com.bytedance.sdk.openadsdk.core.f0.j c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.f0.j jVar = new com.bytedance.sdk.openadsdk.core.f0.j();
        jVar.a(jSONObject.optString("deeplink_url"));
        jVar.b(jSONObject.optString("fallback_url"));
        jVar.a(jSONObject.optInt("fallback_type"));
        return jVar;
    }

    private static com.bytedance.sdk.openadsdk.core.f0.k d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.f0.k kVar = new com.bytedance.sdk.openadsdk.core.f0.k();
        kVar.a(jSONObject.optInt("if_send_click", 0));
        return kVar;
    }

    private static com.bytedance.sdk.openadsdk.core.f0.p e(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.f0.p pVar = new com.bytedance.sdk.openadsdk.core.f0.p();
        if (jSONObject == null) {
            pVar.a(10L);
            pVar.b(20L);
            pVar.a("");
            return pVar;
        }
        pVar.a(jSONObject.optLong("onlylp_loading_maxtime", 10L));
        pVar.b(jSONObject.optLong("straight_lp_showtime", 20L));
        pVar.a(jSONObject.optString("loading_text", ""));
        return pVar;
    }

    public static com.bytedance.sdk.openadsdk.core.f0.q f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return b(jSONObject, null, null);
    }

    private static Map<String, Object> g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private static com.bytedance.sdk.openadsdk.core.f0.d h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("splash_clickarea", 2);
        int iOptInt2 = jSONObject.optInt("splash_layout_id", 1);
        long jOptLong = jSONObject.optLong("load_wait_time", 0L);
        long j = jOptLong >= 0 ? jOptLong : 0L;
        com.bytedance.sdk.openadsdk.core.f0.d dVar = new com.bytedance.sdk.openadsdk.core.f0.d();
        dVar.a(iOptInt);
        dVar.b(iOptInt2);
        dVar.a(j);
        return dVar;
    }

    private static FilterWord i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    FilterWord filterWordI = i(jSONArrayOptJSONArray.optJSONObject(i));
                    if (filterWordI != null && filterWordI.isValid()) {
                        filterWord.addOption(filterWordI);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(int i, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
        if (aVar == null || i < 2) {
            return;
        }
        int size = i - (aVar.b() != null ? aVar.b().size() : 0);
        boolean z = aVar.i() && aVar.e() == null;
        if (size > 0 || z) {
            com.bytedance.sdk.openadsdk.l.b.a();
            com.bytedance.sdk.openadsdk.l.b.a("choose_ad_parsing_error", false, (com.bytedance.sdk.openadsdk.l.a) new a(aVar, size, z));
        }
    }

    private static void a(com.bytedance.sdk.openadsdk.core.f0.q qVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason_code", -1);
            jSONObject.put("error_code", -1);
            com.bytedance.sdk.openadsdk.d.c.b(qVar, str, "load_vast_fail", jSONObject);
        } catch (Exception unused) {
        }
    }

    private static void a(com.bytedance.sdk.openadsdk.core.f0.q qVar, String str, com.bytedance.sdk.openadsdk.core.i0.a aVar, long j, com.bytedance.sdk.openadsdk.core.i0.k.b.a aVar2) {
        com.bytedance.sdk.openadsdk.d.c.a(new C0191b("vast_parser", aVar, j, aVar2, qVar, str));
    }

    private static Pair<com.bytedance.sdk.openadsdk.core.i0.a, com.bytedance.sdk.openadsdk.core.i0.k.b.a> a(String str, int i, int i2) {
        int iG;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i3 = 0;
        if (i2 == 1 || i2 == 5) {
            iG = 0;
        } else {
            i3 = b0.i(o.a());
            iG = b0.g(o.a());
            if (i == 2) {
                i3 = iG;
                iG = i3;
            }
        }
        com.bytedance.sdk.openadsdk.core.i0.k.c.e eVar = new com.bytedance.sdk.openadsdk.core.i0.k.c.e(o.a(), i3, iG);
        return new Pair<>(eVar.b(str, new ArrayList()), eVar.f);
    }

    private static void a(com.bytedance.sdk.openadsdk.core.i0.a aVar, com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        aVar.a(qVar);
        int iE0 = qVar.e0();
        if (iE0 != 2 && iE0 != 3) {
            qVar.n(2);
        }
        qVar.A(1);
        qVar.a(aVar);
        if (!TextUtils.isEmpty(aVar.g())) {
            qVar.y(aVar.g());
        }
        if (!TextUtils.isEmpty(aVar.b())) {
            qVar.m(aVar.b());
        }
        qVar.x(aVar.a());
        qVar.a((com.bytedance.sdk.openadsdk.core.f0.c) null);
        b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
        if (bVarN0 == null) {
            bVarN0 = new b.a.a.a.a.a.a.f.b();
        }
        bVarN0.f(aVar.n());
        bVarN0.a(aVar.k());
        bVarN0.c((String) null);
        bVarN0.a((String) null);
        bVarN0.b((String) null);
        qVar.c(bVarN0);
        if (aVar.h() != null && !TextUtils.isEmpty(aVar.h().d())) {
            com.bytedance.sdk.openadsdk.core.f0.n nVar = new com.bytedance.sdk.openadsdk.core.f0.n();
            nVar.b(aVar.h().d());
            nVar.b(aVar.h().f());
            nVar.a(aVar.h().b());
            qVar.c(nVar);
            return;
        }
        if (qVar.b0() == null) {
            com.bytedance.sdk.openadsdk.core.f0.n nVar2 = new com.bytedance.sdk.openadsdk.core.f0.n();
            nVar2.b("https://sf16-fe-tos-sg.i18n-pglstatp.com/obj/ad-pattern-sg/static/images/2023620white.jpeg");
            nVar2.b(98);
            nVar2.a(98);
            qVar.c(nVar2);
        }
    }

    private static AdSlot a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("mCodeId", "");
        int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        float fOptDouble = (float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
        float fOptDouble2 = (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
        int iOptInt3 = jSONObject.optInt("mAdCount", 6);
        boolean zOptBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String strOptString2 = jSONObject.optString("mRewardName", "");
        int iOptInt4 = jSONObject.optInt("mRewardAmount", 0);
        String strOptString3 = jSONObject.optString("mMediaExtra", "");
        String strOptString4 = jSONObject.optString("mUserID", "");
        jSONObject.optInt("mOrientation", 2);
        int iOptInt5 = jSONObject.optInt("mNativeAdType", 0);
        boolean zOptBoolean2 = jSONObject.optBoolean("mIsAutoPlay", false);
        boolean zOptBoolean3 = jSONObject.optBoolean("mIsExpressAd", false);
        String strOptString5 = jSONObject.optString("mBidAdm", "");
        return new AdSlot.Builder().setCodeId(strOptString).setImageAcceptedSize(iOptInt, iOptInt2).setExpressViewAcceptedSize(fOptDouble, fOptDouble2).setAdCount(iOptInt3).setSupportDeepLink(zOptBoolean).setRewardName(strOptString2).setRewardAmount(iOptInt4).setMediaExtra(strOptString3).setUserID(strOptString4).setNativeAdType(iOptInt5).setIsAutoPlay(zOptBoolean2).isExpressAd(zOptBoolean3).withBid(strOptString5).setDurationSlotType(jSONObject.optInt("mDurationSlotType", 0)).build();
    }

    private static b.a.a.a.a.a.a.f.b a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        if (jSONObject == null) {
            return null;
        }
        b.a.a.a.a.a.a.f.b bVar = new b.a.a.a.a.a.a.f.b();
        bVar.a(jSONObject.optInt("cover_height"));
        bVar.b(jSONObject.optInt("cover_width"));
        bVar.e(jSONObject.optString("resolution"));
        bVar.a(jSONObject.optLong("size"));
        double dOptDouble = jSONObject.optDouble("video_duration", 0.0d);
        bVar.a(dOptDouble);
        int iOptInt = jSONObject.optInt("replay_time", 1);
        if (dOptDouble > 15.0d || qVar.w0() == 1 || !com.bytedance.sdk.openadsdk.core.f0.q.c(qVar)) {
            iOptInt = 1;
        }
        bVar.h(iOptInt);
        bVar.a(jSONObject.optString("cover_url"));
        bVar.f(jSONObject.optString("video_url"));
        bVar.b(jSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD));
        bVar.d(jSONObject.optString("playable_download_url"));
        bVar.c(jSONObject.optString("file_hash"));
        bVar.g(jSONObject.optInt("if_playable_loading_show", 0));
        bVar.f(jSONObject.optInt("remove_loading_page_type", 0));
        bVar.e(jSONObject.optInt("fallback_endcard_judge", 0));
        bVar.j(jSONObject.optInt("video_preload_size", 307200));
        bVar.i(jSONObject.optInt("reward_video_cached_type", 0));
        bVar.d(jSONObject.optInt("execute_cached_type", 0));
        bVar.c(jSONObject.optDouble("endcard_render", 0.0d) != 1.0d ? 0 : 1);
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c8  */
    private static int a(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        int iA;
        if (qVar == null) {
            return TTAdConstant.MATE_IS_NULL_CODE;
        }
        if (TextUtils.isEmpty(qVar.e()) || qVar.e().length() <= 1) {
            return TTAdConstant.AD_ID_IS_NULL_CODE;
        }
        if (qVar.G() == 0) {
            iA = a(qVar.z());
            if (iA != 200) {
                return iA;
            }
        } else {
            iA = 200;
        }
        if (qVar.V0()) {
            int iG = qVar.g();
            if (iG < 0) {
                if (qVar.f() != null) {
                    iG = qVar.f().getDurationSlotType();
                } else {
                    iG = qVar.R();
                }
            }
            String strD = com.bytedance.sdk.openadsdk.utils.a0.d(iG);
            if (qVar.X0()) {
                strD = "fullscreen_interstitial_ad";
            }
            if (TextUtils.isEmpty(qVar.H())) {
                com.bytedance.sdk.openadsdk.d.c.b(qVar, strD, "load_html_fail", (JSONObject) null);
                return TTAdConstant.MATE_IS_NULL_CODE;
            }
            com.bytedance.sdk.openadsdk.d.c.b(qVar, strD, "load_html_success", (JSONObject) null);
        }
        int iE0 = qVar.e0();
        if (iE0 == 2 || iE0 == 3) {
            if (b(qVar) && TextUtils.isEmpty(qVar.H0())) {
                return TTAdConstant.LANDING_PAGE_TYPE_CODE;
            }
        } else if (iE0 == 4 && (iA = a(qVar.h())) != 200) {
            return iA;
        }
        if (!qVar.k1()) {
            int iC0 = qVar.c0();
            if (iC0 == 15) {
                iA = a(qVar.N0(), qVar.k1());
                if (iA != 200) {
                }
            } else if (iC0 == 16) {
                iA = a(qVar.d0());
                if (iA != 200) {
                    return iA;
                }
            } else if (iC0 == 50) {
                iA = a(qVar.N0(), qVar.k1());
                if (iA != 200) {
                }
            } else if (iC0 == 2 || iC0 == 3 || iC0 == 4) {
                iA = a(qVar.d0());
                if (iA != 200) {
                    return iA;
                }
            } else if (iC0 == 5) {
                iA = a(qVar.N0(), qVar.k1());
                if (iA != 200) {
                }
            }
        }
        return iA;
    }

    private static int a(com.bytedance.sdk.openadsdk.core.f0.j jVar) {
        if (jVar == null) {
            return 200;
        }
        if (TextUtils.isEmpty(jVar.a())) {
            return TTAdConstant.DEEPLINK_UNAVAILABLE_CODE;
        }
        if (TextUtils.isEmpty(jVar.b())) {
            return TTAdConstant.DEEPLINK_FALLBACK_CODE;
        }
        if (jVar.c() == 1 || jVar.c() == 2) {
            return 200;
        }
        return TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE;
    }

    private static int a(b.a.a.a.a.a.a.f.b bVar, boolean z) {
        if (bVar == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(bVar.t())) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (z || !TextUtils.isEmpty(bVar.b())) {
            return 200;
        }
        return TTAdConstant.VIDEO_COVER_URL_CODE;
    }

    private static int a(com.bytedance.sdk.openadsdk.core.f0.c cVar) {
        if (cVar == null) {
            return TTAdConstant.DOWNLOAD_APP_INFO_CODE;
        }
        if (TextUtils.isEmpty(cVar.d())) {
            return TTAdConstant.DOWNLOAD_URL_CODE;
        }
        return 200;
    }

    private static int a(List<com.bytedance.sdk.openadsdk.core.f0.n> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (com.bytedance.sdk.openadsdk.core.f0.n nVar : list) {
            if (nVar == null) {
                return TTAdConstant.IMAGE_CODE;
            }
            if (TextUtils.isEmpty(nVar.d())) {
                return 412;
            }
        }
        return 200;
    }

    private static com.bytedance.sdk.openadsdk.core.f0.c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.f0.c cVar = new com.bytedance.sdk.openadsdk.core.f0.c();
        cVar.a(jSONObject.optString(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        cVar.c(jSONObject.optString(CampaignEx.JSON_KEY_PACKAGE_NAME));
        cVar.b(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
        cVar.a(jSONObject.optDouble("score", -1.0d));
        cVar.b(jSONObject.optInt("comment_num", -1));
        cVar.a(jSONObject.optInt(CampaignEx.JSON_KEY_APP_SIZE, 0));
        return cVar;
    }

    private static boolean b(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        return (qVar.k1() || qVar.V0()) ? false : true;
    }
}
