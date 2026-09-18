package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.s;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingsFetchTask.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends b.b.a.a.k.g {
    private final b c;
    private final k d;
    private final c e;

    /* JADX INFO: compiled from: SettingsFetchTask.java */
    public interface b {
        void a(boolean z);
    }

    public l(b bVar, k kVar, c cVar) {
        super("SetF");
        this.c = bVar;
        this.d = kVar;
        this.e = cVar;
    }

    public boolean b(JSONObject jSONObject) throws Throwable {
        this.d.a(jSONObject);
        this.e.a(jSONObject);
        return this.d.j;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d("TTAD.SdkSettingsFetch", "Start Try");
        int iA = w.a(o.a(), 0L);
        if (iA == 0) {
            Log.d("TTAD.SdkSettingsFetch", "No net");
            this.c.a(false);
            return;
        }
        com.bytedance.sdk.openadsdk.l.c.c cVar = new com.bytedance.sdk.openadsdk.l.c.c();
        JSONObject jSONObjectA = a(iA);
        b.b.a.a.j.d.d dVarD = com.bytedance.sdk.openadsdk.n.c.b().d().d();
        try {
            String strA = com.bytedance.sdk.openadsdk.g.d.a(dVarD, a0.j("/api/ad/union/mediation/settings/"));
            dVarD.b(strA);
            dVarD.a("User-Agent", a0.t());
            cVar.d(strA);
        } catch (Exception unused) {
        }
        String string = a(jSONObjectA).toString();
        if (o.d().n() && v.a().c() == 1) {
            a0.a("Pangle_Debug_Mode", string, o.a());
        }
        dVarD.a(string, o.d().v());
        cVar.a(dVarD.c()).c();
        dVarD.a(new a(cVar));
        DeviceUtils.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x007a  */
    public void a(String str, Map<String, String> map) {
        int i;
        try {
            if (TextUtils.isEmpty(str) || map == null) {
                i = 1;
            } else {
                HashMap map2 = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        map2.put(key.toLowerCase(Locale.US), entry.getValue());
                    }
                }
                i = Integer.parseInt((String) map2.get("active-control"));
                long j = Long.parseLong((String) map2.get(CampaignEx.JSON_KEY_ST_TS));
                String str2 = (String) map2.get("pst");
                String strA = b.a.a.a.a.a.a.i.b.a(str + i + j);
                if (strA == null || !strA.equalsIgnoreCase(str2)) {
                    i = 1;
                }
            }
        } catch (Throwable unused) {
        }
        j.a(i);
    }

    private JSONObject a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            d dVarD = o.d();
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
            jSONObject.put("device_city", a0.m());
            if (dVarD.A("gaid")) {
                jSONObject.put("gaid", b.c.a.a.a.b.a.b().a());
            }
            jSONObject.put("gdpr", com.bytedance.sdk.openadsdk.core.h.a().h());
            jSONObject.put("coppa", com.bytedance.sdk.openadsdk.core.h.a().m());
            jSONObject.put("ccpa", com.bytedance.sdk.openadsdk.core.h.a().e());
            if (dVarD.A("mcc")) {
                jSONObject.put("mcc", s.c());
            }
            Context contextA = o.a();
            jSONObject.put("conn_type", a0.a(i));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE);
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("language", com.bytedance.sdk.openadsdk.core.j.b());
            jSONObject.put("time_zone", a0.h());
            jSONObject.put(CampaignEx.JSON_KEY_PACKAGE_NAME, a0.i());
            jSONObject.put("position", a0.v() ? 1 : 2);
            jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, a0.s());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.j.d(contextA));
            String strD = com.bytedance.sdk.openadsdk.core.h.a().d();
            if (strD != null) {
                jSONObject.put("app_id", strD);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.e.a(strD != null ? strD.concat(String.valueOf(jCurrentTimeMillis)).concat(BuildConfig.VERSION_NAME) : ""));
            jSONObject.put("tcstring", n.d(contextA));
            jSONObject.put("tcf_gdpr", n.c(contextA));
            jSONObject.put("lmt", DeviceUtils.g());
            jSONObject.put("locale_language", DeviceUtils.h());
            jSONObject.put("channel", "main");
            JSONObject jSONObjectG = dVarD.g();
            if (jSONObjectG != null) {
                jSONObject.put("digest", jSONObjectG);
            }
            jSONObject.put("data_time", dVarD.Z());
            jSONObject.put("app_set_id_scope", AppSetIdAndScope.b());
            jSONObject.put(TapjoyConstants.TJC_APP_SET_ID, AppSetIdAndScope.a());
            jSONObject.put("installed_source", AppSetIdAndScope.d());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: compiled from: SettingsFetchTask.java */
    class a extends b.b.a.a.j.c.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.c.c a;

        a(com.bytedance.sdk.openadsdk.l.c.c cVar) {
            this.a = cVar;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            JSONObject jSONObject;
            int iOptInt;
            int iB = bVar.b();
            String strA = bVar.a();
            if (o.d().n() && v.a().c() == 1) {
                a0.a("Pangle_Debug_Mode", strA, o.a());
            }
            if (bVar.g() && !TextUtils.isEmpty(strA)) {
                this.a.b(strA).a(iB).a(true).b();
                String strA2 = null;
                try {
                    jSONObject = new JSONObject(strA);
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                if (jSONObject != null && (iOptInt = jSONObject.optInt("cypher", -1)) != -1) {
                    if (iOptInt == 3) {
                        strA2 = com.bytedance.sdk.component.utils.a.a(jSONObject.optString("message"));
                        if (!TextUtils.isEmpty(strA2)) {
                            try {
                                jSONObject = new JSONObject(strA2);
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    try {
                        l.this.a(strA2, bVar.e());
                    } catch (Throwable unused3) {
                    }
                    try {
                        l.this.b(jSONObject);
                        o.d().a(System.currentTimeMillis());
                    } catch (Throwable unused4) {
                    }
                    l.this.c.a(true);
                    com.bytedance.sdk.openadsdk.core.h0.a.a();
                    return;
                }
            }
            this.a.b(strA).a(iB).c(bVar.f()).a(bVar.g()).b();
            l.this.c.a(false);
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            this.a.c(iOException != null ? iOException.getMessage() : null).a(false).b();
            l.this.c.a(false);
            com.bytedance.sdk.openadsdk.core.h0.a.a();
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.a.a(jSONObject);
    }

    public static boolean a() {
        return BinderPoolService.f796b;
    }
}
