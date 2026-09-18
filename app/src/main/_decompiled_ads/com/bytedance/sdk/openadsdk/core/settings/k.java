package com.bytedance.sdk.openadsdk.core.settings;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingsDefaultRepository.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends m {
    static final ArrayList<String> l = new ArrayList<>(Arrays.asList(ApStyleManager.Language.JA, ApStyleManager.Language.EN, ApStyleManager.Language.KO, "zh", "th", "vi", "id", "ru", "ar", "fr", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "it", "es", "hi", DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT, "zh-Hant", "ms", "pl", "tr"));
    public boolean j;
    private Set<String> k;

    public k() {
        super("tt_sdk_settings.prop");
        this.k = Collections.synchronizedSet(new HashSet());
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.c
    public void a(JSONObject jSONObject) throws Throwable {
        c.InterfaceC0213c interfaceC0213cC = c();
        JSONObject jSONObjectG = n.j0().g();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("digest");
        this.j = (jSONObjectOptJSONObject == null || jSONObjectG == null || !jSONObjectOptJSONObject.toString().equals(jSONObjectG.toString())) ? false : true;
        if (jSONObjectOptJSONObject != null) {
            interfaceC0213cC.putString("digest", jSONObjectOptJSONObject.toString());
        } else {
            interfaceC0213cC.remove("digest");
        }
        interfaceC0213cC.putLong("data_time", jSONObject.optLong("data_time"));
        if (jSONObject.has("req_inter_min")) {
            long jOptLong = jSONObject.optLong("req_inter_min", 10L) * 60 * 1000;
            if (jOptLong < 0 || jOptLong > 86400000) {
                jOptLong = 600000;
            }
            interfaceC0213cC.putLong("req_inter_min", jOptLong);
        }
        if (jSONObject.has("lp_new_style")) {
            interfaceC0213cC.putInt("landingpage_new_style", jSONObject.optInt("lp_new_style", Integer.MAX_VALUE));
        }
        if (jSONObject.has("blank_detect_rate")) {
            int iOptInt = jSONObject.optInt("blank_detect_rate", 30);
            if (iOptInt < 0 || iOptInt > 100) {
                iOptInt = 30;
            }
            interfaceC0213cC.putInt("blank_detect_rate", iOptInt);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("feq_policy");
        if (jSONObjectOptJSONObject2 != null) {
            if (jSONObjectOptJSONObject2.has("duration")) {
                interfaceC0213cC.putLong("duration", jSONObjectOptJSONObject2.optLong("duration") * 1000);
            }
            if (jSONObjectOptJSONObject2.has("max")) {
                interfaceC0213cC.putInt("max", jSONObjectOptJSONObject2.optInt("max"));
            }
        }
        if (jSONObject.has("vbtt")) {
            interfaceC0213cC.putInt("vbtt", jSONObject.optInt("vbtt", 5));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("abtest");
        if (jSONObjectOptJSONObject3 != null) {
            if (jSONObjectOptJSONObject3.has("version")) {
                interfaceC0213cC.putString("ab_test_version", jSONObjectOptJSONObject3.optString("version"));
            }
            if (jSONObjectOptJSONObject3.has("param")) {
                interfaceC0213cC.putString("ab_test_param", jSONObjectOptJSONObject3.optString("param"));
            }
        } else {
            n.j0().s();
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("log_rate_conf");
        if (jSONObjectOptJSONObject4 != null && jSONObjectOptJSONObject4.has("global_rate")) {
            interfaceC0213cC.putFloat("global_rate", (float) jSONObjectOptJSONObject4.optDouble("global_rate", 1.0d));
        }
        if (jSONObject.has("pyload_h5")) {
            interfaceC0213cC.putString("pyload_h5", jSONObject.optString("pyload_h5"));
        }
        if (jSONObject.has("pure_pyload_h5")) {
            interfaceC0213cC.putString("playableLoadH5Url", jSONObject.optString("pure_pyload_h5"));
        }
        if (jSONObject.has("ads_url")) {
            interfaceC0213cC.putString("ads_url", jSONObject.optString("ads_url"));
        }
        if (jSONObject.has("app_log_url")) {
            interfaceC0213cC.putString("app_log_url", jSONObject.optString("app_log_url"));
        }
        if (jSONObject.has("apm_url")) {
            interfaceC0213cC.putString("apm_url", jSONObject.optString("apm_url"));
        }
        if (jSONObject.has("coppa")) {
            int iOptInt2 = jSONObject.optInt("coppa", -99);
            com.bytedance.sdk.openadsdk.core.h.a().c(iOptInt2);
            interfaceC0213cC.putInt("coppa", iOptInt2);
        }
        if (jSONObject.has(CampaignEx.JSON_KEY_PRIVACY_URL)) {
            interfaceC0213cC.putString("policy_url", jSONObject.optString(CampaignEx.JSON_KEY_PRIVACY_URL));
        }
        if (jSONObject.has("consent_url")) {
            interfaceC0213cC.putString("consent_url", jSONObject.optString("consent_url"));
        }
        if (jSONObject.has("ivrv_downward")) {
            interfaceC0213cC.putInt("ivrv_downward", jSONObject.optInt("ivrv_downward", 0));
        }
        if (jSONObject.has("dc")) {
            interfaceC0213cC.putString("dc", jSONObject.optString("dc"));
        }
        n.j0().a(jSONObject, interfaceC0213cC);
        n.j0().b(jSONObject, interfaceC0213cC);
        if (jSONObject.has("if_both_open")) {
            interfaceC0213cC.putInt("if_both_open", jSONObject.optInt("if_both_open", 0));
        }
        if (jSONObject.has("support_tnc")) {
            interfaceC0213cC.putInt("support_tnc", jSONObject.optInt("support_tnc", 1));
        }
        if (jSONObject.has("insert_js_config")) {
            interfaceC0213cC.putString("insert_js_config", jSONObject.optString("insert_js_config", ""));
        }
        if (jSONObject.has("max_tpl_cnts")) {
            interfaceC0213cC.putInt("max_tpl_cnts", jSONObject.optInt("max_tpl_cnts", 100));
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject5 != null) {
            if (jSONObjectOptJSONObject5.has("force_language")) {
                String strOptString = jSONObjectOptJSONObject5.optString("force_language");
                if (!TextUtils.isEmpty(strOptString) && l.contains(strOptString)) {
                    interfaceC0213cC.putString("force_language", strOptString);
                }
            }
            if (jSONObjectOptJSONObject5.has("fetch_tpl_timeout_ctrl")) {
                interfaceC0213cC.putInt("fetch_tpl_timeout_ctrl", jSONObjectOptJSONObject5.optInt("fetch_tpl_timeout_ctrl", 3000));
            }
            if (jSONObjectOptJSONObject5.has("fetch_tpl_second")) {
                interfaceC0213cC.putInt("fetch_tpl_second", jSONObjectOptJSONObject5.optInt("fetch_tpl_second", 0));
            }
            if (jSONObjectOptJSONObject5.has("disable_rotate_banner_on_dislike")) {
                interfaceC0213cC.putInt("disable_rotate_banner_on_dislike", jSONObjectOptJSONObject5.optInt("disable_rotate_banner_on_dislike", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject5.has("webview_cache_count")) {
                interfaceC0213cC.putInt("webview_cache_count", jSONObjectOptJSONObject5.optInt("webview_cache_count", 20));
            }
            if (jSONObjectOptJSONObject5.has("support_gzip")) {
                interfaceC0213cC.putBoolean("support_gzip", jSONObjectOptJSONObject5.optBoolean("support_gzip", false));
            }
            if (jSONObjectOptJSONObject5.has("aes_key")) {
                interfaceC0213cC.putString("aes_key", jSONObjectOptJSONObject5.optString("aes_key"));
            }
            if (jSONObjectOptJSONObject5.has("support_rtl")) {
                interfaceC0213cC.putBoolean("support_rtl", jSONObjectOptJSONObject5.optBoolean("support_rtl", false));
            }
            if (jSONObjectOptJSONObject5.has("ad_revenue_enable")) {
                interfaceC0213cC.putBoolean("ad_revenue_enable", jSONObjectOptJSONObject5.optBoolean("ad_revenue_enable", false));
            }
            if (jSONObjectOptJSONObject5.has("gecko_hosts")) {
                try {
                    this.k.clear();
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject5.optJSONArray("gecko_hosts");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            this.k.add(jSONArrayOptJSONArray.getString(i));
                        }
                    }
                    this.k = a(this.k);
                    interfaceC0213cC.putString("gecko_hosts", jSONArrayOptJSONArray.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.m.b("GeckoLog: settings json error " + th);
                }
            }
        }
        if (jSONObject.has("read_video_from_cache")) {
            interfaceC0213cC.putInt("read_video_from_cache", jSONObject.optInt("read_video_from_cache", 1));
        }
        if (jSONObject.has("use_prop")) {
            int iOptInt3 = jSONObject.optInt("use_prop", 0);
            SharedPreferences.Editor editorEdit = o.a().getSharedPreferences(null, 0).edit();
            editorEdit.putInt("use_prop", iOptInt3);
            editorEdit.apply();
        }
        b.b(jSONObject.optJSONArray("ad_slot_conf_list"));
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject(ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
        if (jSONObjectOptJSONObject6 != null) {
            if (jSONObjectOptJSONObject6.has("ad_enable")) {
                interfaceC0213cC.putInt("privacy_ad_enable", jSONObjectOptJSONObject6.optInt("ad_enable", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("personalized_ad")) {
                interfaceC0213cC.putInt("privacy_personalized_ad", jSONObjectOptJSONObject6.optInt("personalized_ad", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("sladar_enable")) {
                interfaceC0213cC.putInt("privacy_sladar_enable", jSONObjectOptJSONObject6.optInt("sladar_enable", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("app_log_enable")) {
                interfaceC0213cC.putInt("privacy_app_log_enable", jSONObjectOptJSONObject6.optInt("app_log_enable", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("debug_unlock")) {
                interfaceC0213cC.putInt("privacy_debug_unlock", jSONObjectOptJSONObject6.optInt("debug_unlock", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("fields_allowed")) {
                String strOptString2 = jSONObjectOptJSONObject6.optString("fields_allowed", "");
                if (TextUtils.isEmpty(strOptString2)) {
                    interfaceC0213cC.remove("privacy_fields_allowed");
                } else {
                    interfaceC0213cC.putString("privacy_fields_allowed", strOptString2);
                }
            }
        }
        if (jSONObject.has("video_cache_config")) {
            interfaceC0213cC.putString("video_cache_config", jSONObject.optString("video_cache_config"));
        }
        if (jSONObject.has("loaded_recall_time")) {
            int iOptInt4 = jSONObject.optInt("loaded_recall_time", 0);
            if (iOptInt4 != 0 && iOptInt4 != 1) {
                iOptInt4 = 0;
            }
            interfaceC0213cC.putInt("loadedCallbackOpportunity", iOptInt4);
        }
        if (jSONObject.has("load_strategy")) {
            int iOptInt5 = jSONObject.optInt("load_strategy", 0);
            if (iOptInt5 != 0 && iOptInt5 != 1) {
                iOptInt5 = 0;
            }
            interfaceC0213cC.putInt("load_callback_strategy", iOptInt5);
        }
        if (jSONObject.has("support_mem_dynamic")) {
            int iOptInt6 = jSONObject.optInt("support_mem_dynamic", 0);
            if (iOptInt6 != 0 && iOptInt6 != 1) {
                iOptInt6 = 0;
            }
            interfaceC0213cC.putInt("support_mem_dynamic", iOptInt6);
        }
        if (jSONObject.has("allow_blind_mode_request_ad")) {
            interfaceC0213cC.putBoolean("allow_blind_mode_request_ad", jSONObject.optBoolean("allow_blind_mode_request_ad", false));
        }
        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("bus_con");
        if (jSONObjectOptJSONObject7 != null) {
            if (jSONObjectOptJSONObject7.has("bus_con_send_log_type")) {
                interfaceC0213cC.putInt("bus_con_send_log_type", jSONObjectOptJSONObject7.optInt("bus_con_send_log_type", 1));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_sec_type")) {
                interfaceC0213cC.putInt("bus_con_sec_type", jSONObjectOptJSONObject7.optInt("bus_con_sec_type", Integer.MAX_VALUE));
            }
        }
        if (jSONObject.has("perf_con")) {
            JSONObject jSONObjectOptJSONObject8 = null;
            try {
                jSONObjectOptJSONObject8 = jSONObject.optJSONObject("perf_con");
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.m.b("SettingsDefaultRepository", th2.getMessage());
            }
            if (jSONObjectOptJSONObject8 != null) {
                try {
                    if (jSONObjectOptJSONObject8.has("perf_con_stats_rate")) {
                        String strOptString3 = jSONObjectOptJSONObject8.optString("perf_con_stats_rate");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            interfaceC0213cC.putString("perf_con_stats_rate", strOptString3);
                        }
                    }
                } catch (Throwable th3) {
                    com.bytedance.sdk.component.utils.m.b("SettingsDefaultRepository", th3.getMessage());
                }
            }
            if (jSONObjectOptJSONObject8 != null) {
                try {
                    if (jSONObjectOptJSONObject8.has("perf_con_applog_send")) {
                        String strOptString4 = jSONObjectOptJSONObject8.optString("perf_con_applog_send");
                        if (!TextUtils.isEmpty(strOptString4)) {
                            interfaceC0213cC.putString("perf_con_applog_send", strOptString4);
                        }
                    }
                } catch (Throwable th4) {
                    com.bytedance.sdk.component.utils.m.b("SettingsDefaultRepository", th4.getMessage());
                }
            }
            if (jSONObjectOptJSONObject8 != null) {
                try {
                    if (jSONObjectOptJSONObject8.has("perf_con_apm_native")) {
                        interfaceC0213cC.putInt("perf_con_apm_native", jSONObjectOptJSONObject8.optInt("perf_con_apm_native"));
                    }
                } catch (Throwable th5) {
                    com.bytedance.sdk.component.utils.m.b("SettingsDefaultRepository", th5.getMessage());
                }
            }
        }
        interfaceC0213cC.commit();
        n.j0().D();
    }

    public static Set<String> a(Set<String> set) {
        try {
            if (set == null) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        } catch (Throwable unused) {
            return new HashSet();
        }
    }
}
