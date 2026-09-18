package com.bytedance.sdk.openadsdk.core.nativeexpress.q;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.r;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TemplateUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static JSONObject a(float f, float f2, boolean z, q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TapjoyConstants.TJC_PLATFORM, "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f);
            jSONObject2.put("height", f2);
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            if (!(qVar instanceof r) || !((r) qVar).s1()) {
                jSONObject.put("creative", a(false, qVar));
                jSONObject.put("template_Plugin", b(qVar.I0()));
                jSONObject.put("diff_template_Plugin", a(qVar.I0()));
                return jSONObject;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put("choose_ui_data", jSONObject3);
            com.bytedance.sdk.openadsdk.core.f0.a.C0196a c0196aQ1 = ((r) qVar).q1();
            JSONObject jSONObjectI = c0196aQ1.i();
            if (TextUtils.isEmpty(c0196aQ1.a())) {
                jSONObjectI.put("data", b(c0196aQ1));
            }
            jSONObject3.put("tpl_info", jSONObjectI);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("creatives", jSONArray);
            for (q qVar2 : ((r) qVar).r1()) {
                JSONObject jSONObjectA = a(false, qVar2);
                if (jSONObjectA != null) {
                    jSONObjectA.put("template_Plugin", b(qVar2.I0()));
                    jSONObjectA.put("diff_template_Plugin", a(qVar2.I0()));
                    jSONArray.put(jSONObjectA);
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        return true;
    }

    private static String b(q.a aVar) {
        if (aVar == null) {
            return "";
        }
        String strA = aVar.a();
        return (!TextUtils.isEmpty(strA) || b.b.a.a.d.e.b.a.c(aVar.d()) == null) ? strA : b.b.a.a.d.e.b.a.c(aVar.d()).a();
    }

    private static String a(q.a aVar) {
        return aVar != null ? aVar.b() : "";
    }

    public static JSONObject a(boolean z, q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", qVar.r());
            if (qVar.b0() != null) {
                if (qVar.b0() != null && !TextUtils.isEmpty(qVar.b0().d())) {
                    jSONObject.put(RewardPlus.ICON, qVar.b0().d());
                } else {
                    jSONObject.put(RewardPlus.ICON, "");
                }
            }
            JSONArray jSONArray = new JSONArray();
            if (qVar.d0() != null) {
                for (int i = 0; i < qVar.d0().size(); i++) {
                    n nVar = qVar.d0().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", nVar.b());
                    jSONObject2.put("width", nVar.e());
                    jSONObject2.put("url", nVar.d());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", qVar.c0());
            jSONObject.put("interaction_type", qVar.e0());
            jSONObject.put("interaction_method", qVar.k0());
            jSONObject.put("is_compliance_template", a());
            jSONObject.put("title", qVar.K0());
            jSONObject.put("description", qVar.B());
            jSONObject.put("source", qVar.F0());
            if (qVar.h() != null) {
                jSONObject.put("comment_num", qVar.h().c());
                jSONObject.put("score", qVar.h().f());
                jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, qVar.h().b());
                jSONObject.put("app", qVar.h().g());
            }
            b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
            if (bVarN0 != null) {
                JSONObject jSONObjectW = bVarN0.w();
                jSONObjectW.put("video_duration", bVarN0.s() * ((double) bVarN0.m()));
                jSONObject.put("video", jSONObjectW);
            }
            if (qVar.I0() != null) {
                jSONObject.put("dynamic_creative", qVar.I0().c());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(q qVar, String str) {
        List<n> listD0;
        if (qVar != null && (listD0 = qVar.d0()) != null && listD0.size() > 0) {
            for (n nVar : listD0) {
                if (nVar != null && TextUtils.equals(str, nVar.d())) {
                    return nVar.c();
                }
            }
        }
        return null;
    }

    public static Map<String, String> a(q qVar) {
        HashMap map = null;
        if (qVar == null) {
            return null;
        }
        List<n> listD0 = qVar.d0();
        if (listD0 != null && listD0.size() > 0) {
            map = new HashMap();
            for (n nVar : listD0) {
                if (nVar != null) {
                    map.put(nVar.d(), nVar.c());
                }
            }
        }
        return map;
    }
}
