package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static boolean a = false;

    /* JADX INFO: compiled from: WebHelper.java */
    static class a implements com.bytedance.sdk.component.utils.b.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f714b;
        final /* synthetic */ int c;

        a(com.bytedance.sdk.openadsdk.core.f0.q qVar, String str, int i) {
            this.a = qVar;
            this.f714b = str;
            this.c = i;
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a() {
            com.bytedance.sdk.openadsdk.d.c.a(this.a, this.f714b, this.c, 0, true);
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a(Throwable th) {
            com.bytedance.sdk.openadsdk.d.c.a(this.a, this.f714b, this.c, 6, false, th.toString());
        }
    }

    public static void a(boolean z) {
        a = z;
    }

    public static boolean b(Context context, String str, com.bytedance.sdk.openadsdk.core.f0.q qVar, int i, String str2, boolean z) {
        try {
            context.startActivity(a(context, str, qVar, i, (PAGNativeAd) null, (PangleAd) null, str2, z));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context, com.bytedance.sdk.openadsdk.core.f0.q qVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str, b.c.a.a.a.a.c cVar, boolean z, int i2) {
        if (context == null || qVar == null || i == -1) {
            com.bytedance.sdk.openadsdk.d.c.a(qVar, str, 0, 1, false);
            return false;
        }
        String strA = null;
        com.bytedance.sdk.openadsdk.core.f0.j jVarZ = qVar.z();
        HashMap map = new HashMap();
        if (qVar.G() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(i2 >= 11));
        }
        if (i2 != 0 && qVar.k1()) {
            map.put("dsp_click_type", Integer.valueOf(i2));
        }
        if (jVarZ == null || TextUtils.isEmpty(jVarZ.a())) {
            strA = a(qVar);
        } else {
            if (a(context, qVar, i, str, z, map)) {
                com.bytedance.sdk.openadsdk.d.c.a(qVar, str, 0, 2, false);
                return true;
            }
            if (jVarZ.c() != 2 || qVar.c0() == 5 || qVar.c0() == 15) {
                strA = (jVarZ.c() != 1 || TextUtils.isEmpty(jVarZ.b())) ? a(qVar) : jVarZ.b();
            } else if (cVar != null) {
                if (cVar.a()) {
                    com.bytedance.sdk.openadsdk.d.c.a(qVar, str, "open_fallback_url", map);
                    com.bytedance.sdk.openadsdk.d.c.a(qVar, str, 0, 3, false);
                    return true;
                }
                if (cVar.c()) {
                    com.bytedance.sdk.openadsdk.d.c.a(qVar, str, "open_fallback_url", map);
                    com.bytedance.sdk.openadsdk.d.c.a(qVar, str, 0, 3, false);
                    return true;
                }
                com.bytedance.sdk.openadsdk.d.c.a(qVar, str, "open_fallback_url", map);
                com.bytedance.sdk.openadsdk.d.c.a(qVar, str, 0, 3, false);
                return false;
            }
            com.bytedance.sdk.openadsdk.d.c.a(qVar, str, "open_fallback_url", map);
        }
        if (qVar.G() != 0 || !strA.contains("play.google.com/store/apps/details?id=")) {
            return a(context, qVar, i, pAGNativeAd, pangleAd, str, z, strA);
        }
        String strSubstring = strA.substring(strA.indexOf("?id=") + 4);
        com.bytedance.sdk.openadsdk.d.c.a(qVar, str, 0, 4, false);
        return b.c.a.a.a.a.b.a(context, strA, strSubstring, str, qVar);
    }

    private static String a(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        if (qVar.k1() && qVar.M0() != null) {
            return qVar.M0().f();
        }
        return qVar.H0();
    }

    public static boolean a(Context context, com.bytedance.sdk.openadsdk.core.f0.q qVar, int i, String str, boolean z, Map<String, Object> map) {
        if (qVar == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.f0.j jVarZ = qVar.z();
        if (jVarZ != null && !TextUtils.isEmpty(jVarZ.a())) {
            Uri uri = Uri.parse(jVarZ.a());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (com.bytedance.sdk.openadsdk.utils.a0.a(context)) {
                if (com.bytedance.sdk.openadsdk.utils.a0.b(context, intent)) {
                    if (o.d().e0()) {
                        com.bytedance.sdk.openadsdk.utils.a0.a(qVar, str);
                    }
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    com.bytedance.sdk.openadsdk.d.c.a(qVar, str, "open_url_app", (Map<String, Object>) null);
                    try {
                        context.startActivity(intent);
                        com.bytedance.sdk.openadsdk.d.l.a().a(map).a(qVar, str);
                        return true;
                    } catch (Exception e) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("exception", e.getMessage());
                            jSONObject.put(SDKConstants.PARAM_INTENT, intent.toString());
                        } catch (Exception unused) {
                        }
                        d.a(qVar, str, -4, jSONObject);
                        ApmHelper.reportCustomError("startActivityError2", SDKConstants.PARAM_DEEP_LINK, e);
                        if (!o.d().e0()) {
                            b(context, qVar.H0(), qVar, i, str, z);
                            com.bytedance.sdk.component.utils.m.b("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", e);
                        }
                        return false;
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SDKConstants.PARAM_INTENT, intent.toString());
                } catch (Exception unused2) {
                }
                d.a(qVar, str, -3, jSONObject2);
            } else {
                try {
                    if (o.d().e0()) {
                        com.bytedance.sdk.openadsdk.utils.a0.a(qVar, str);
                    }
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    com.bytedance.sdk.openadsdk.d.c.a(qVar, str, "open_url_app", map);
                    context.startActivity(intent);
                    com.bytedance.sdk.openadsdk.d.l.a().a(map).a(qVar, str);
                    return true;
                } catch (Throwable th) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("exception", th.getMessage());
                        jSONObject3.put(SDKConstants.PARAM_INTENT, intent.toString());
                    } catch (Exception unused3) {
                    }
                    d.a(qVar, str, -4, jSONObject3);
                }
            }
            return false;
        }
        d.a(qVar, str, jVarZ == null ? -1 : -2, jVarZ != null ? jVarZ.d() : null);
        return false;
    }

    public static boolean a(Context context, com.bytedance.sdk.openadsdk.core.f0.q qVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str2) && !com.bytedance.sdk.openadsdk.core.f0.t.i(qVar)) {
            com.bytedance.sdk.openadsdk.d.c.a(qVar, str, 0, 5, false);
            return false;
        }
        if (qVar.e0() == 2) {
            if (!com.bytedance.sdk.component.utils.p.a(str2)) {
                com.bytedance.sdk.openadsdk.d.c.a(qVar, str, 0, 5, false);
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.setData(Uri.parse(str2));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                com.bytedance.sdk.component.utils.b.a(context, intent, new a(qVar, str, com.bytedance.sdk.openadsdk.utils.a0.a(o.a(), intent)));
                return true;
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.d.c.a(qVar, str, 0, 6, false, e.toString());
                return false;
            }
        }
        com.bytedance.sdk.component.utils.b.a(context, a(context, str2, qVar, i, pAGNativeAd, pangleAd, str, z), null);
        a = false;
        return true;
    }

    public static boolean a(Context context, String str, com.bytedance.sdk.openadsdk.core.f0.q qVar, int i, String str2, boolean z) {
        try {
            context.startActivity(a(context, str, qVar, i, (PAGNativeAd) null, (PangleAd) null, str2, z, true));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent a(Context context, String str, com.bytedance.sdk.openadsdk.core.f0.q qVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z) {
        return a(context, str, qVar, i, pAGNativeAd, pangleAd, str2, z, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent a(Context context, String str, com.bytedance.sdk.openadsdk.core.f0.q qVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z, boolean z2) {
        Intent intent;
        if (!z2 && com.bytedance.sdk.openadsdk.core.f0.t.i(qVar) && (pAGNativeAd != 0 || pangleAd != null)) {
            intent = new Intent(context, (Class<?>) TTPlayableLandingPageActivity.class);
            intent.putExtra("ad_pending_download", a(qVar, z));
            String strB = com.bytedance.sdk.openadsdk.core.f0.t.b(qVar);
            if (!TextUtils.isEmpty(strB)) {
                if (strB.contains("?")) {
                    str = strB + "&orientation=portrait";
                } else {
                    str = strB + "?orientation=portrait";
                }
            }
        } else {
            intent = (z2 || qVar.e0() != 3 || !(qVar.v() == 2 || (qVar.v() == 1 && a)) || qVar.W0()) ? new Intent(context, (Class<?>) TTLandingPageActivity.class) : new Intent(context, (Class<?>) TTVideoLandingPageLink2Activity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", qVar.X());
        intent.putExtra("web_title", qVar.K0());
        intent.putExtra("sdk_version", BuildConfig.VERSION_CODE);
        intent.putExtra("adid", qVar.e());
        intent.putExtra("log_extra", qVar.N());
        com.bytedance.sdk.openadsdk.m.g.a aVarH = null;
        intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, qVar.b0() == null ? null : qVar.b0().d());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, qVar.n1().toString());
        } else {
            s.g().a();
            s.g().a(qVar);
        }
        if (qVar.c0() == 5 || qVar.c0() == 15 || qVar.c0() == 50) {
            if (pAGNativeAd != 0) {
                aVarH = pAGNativeAd instanceof com.bytedance.sdk.openadsdk.m.g.a.InterfaceC0241a ? ((com.bytedance.sdk.openadsdk.m.g.a.InterfaceC0241a) pAGNativeAd).a() : null;
                if (aVarH != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVarH.a().toString());
                }
            }
            if ((pangleAd instanceof com.bytedance.sdk.openadsdk.core.bannerexpress.c) && (aVarH = ((com.bytedance.sdk.openadsdk.core.bannerexpress.c) pangleAd).h()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVarH.a().toString());
            }
            if (aVarH != null) {
                intent.putExtra("video_is_auto_play", aVarH.d);
                if (com.bytedance.sdk.component.utils.m.c()) {
                    com.bytedance.sdk.component.utils.m.d("videoDataModel", "videoDataModel=" + aVarH.a().toString());
                }
            }
        }
        return intent;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.f0.q qVar, boolean z) {
        return z && qVar != null && qVar.e0() == 4 && com.bytedance.sdk.openadsdk.core.f0.t.i(qVar);
    }
}
