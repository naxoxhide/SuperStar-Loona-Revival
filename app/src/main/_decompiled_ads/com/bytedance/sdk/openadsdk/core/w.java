package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.settings.AppSetIdAndScope;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTAdManagerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class w implements u {
    private static final Map<Integer, String> d = new a(12);
    String a = "com.union_test.internationad";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f689b = "8025677";
    private int c = 0;

    /* JADX INFO: compiled from: TTAdManagerImpl.java */
    static class a extends HashMap<Integer, String> {
        a(int i) {
            super(i);
            put(1, "abtest");
            put(2, "user_data");
            put(3, "gaid");
            put(4, "apk-sign");
            put(5, "app_set_id_scope");
            put(6, TapjoyConstants.TJC_APP_SET_ID);
            put(7, "installed_source");
            put(8, "app_running_time");
            put(9, "vendor");
            put(10, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            put(11, "user_agent_device");
            put(12, "user_agent_webview");
            put(13, "sys_compiling_time");
            put(14, "sec_did");
            put(15, "url");
            put(16, "X-Argus");
            put(17, "X-Ladon");
            put(18, "X-Khronos");
            put(19, "X-Gorgon");
            put(20, "pangle_m");
            put(21, "screen_height");
            put(22, "screen_width");
            put(23, "rom_version");
            put(24, TapjoyConstants.TJC_CARRIER_NAME);
            put(25, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME);
            put(26, "conn_type");
            put(27, "boot");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public String b() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public String b(String str) {
        int size;
        com.bytedance.sdk.openadsdk.utils.a0.c("getBiddingToken");
        com.bytedance.sdk.openadsdk.core.g0.c.c();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_init", l.e() ? 1 : 0);
            String strD = o.d().d();
            String strQ = o.d().Q();
            if (strD != null && strQ != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("version", strD);
                jSONObject3.put("param", strQ);
                jSONObject2.put("abtest", jSONObject3);
            }
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put(CampaignEx.JSON_KEY_PACKAGE_NAME, com.bytedance.sdk.openadsdk.utils.a0.i());
            jSONObject2.put("user_data", q.b(TextUtils.isEmpty(str) ? null : new AdSlot.Builder().setCodeId(str).build()));
            jSONObject2.put(CampaignEx.JSON_KEY_ST_TS, System.currentTimeMillis() / 1000);
            if (jSONObject2.toString().getBytes().length <= 2680) {
                com.bytedance.sdk.openadsdk.core.settings.d dVarD = o.d();
                if (dVarD.A("gaid")) {
                    jSONObject2.put("gaid", b.c.a.a.a.b.a.b().a());
                }
                Context contextA = o.a();
                jSONObject2.put("apk-sign", com.bytedance.sdk.openadsdk.core.g0.c.b());
                jSONObject2.put("app_set_id_scope", AppSetIdAndScope.b());
                jSONObject2.put(TapjoyConstants.TJC_APP_SET_ID, AppSetIdAndScope.a());
                jSONObject2.put("installed_source", AppSetIdAndScope.d());
                jSONObject2.put("app_running_time", (System.currentTimeMillis() - l.d()) / 1000);
                jSONObject2.put("vendor", Build.MANUFACTURER);
                jSONObject2.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
                jSONObject2.put("user_agent_device", com.bytedance.sdk.openadsdk.utils.a0.e());
                jSONObject2.put("user_agent_webview", com.bytedance.sdk.openadsdk.utils.a0.t());
                jSONObject2.put("sys_compiling_time", j.a(contextA));
                jSONObject2.put("screen_height", b0.g(contextA));
                jSONObject2.put("screen_width", b0.i(contextA));
                jSONObject2.put("rom_version", com.bytedance.sdk.openadsdk.utils.r.m());
                jSONObject2.put(TapjoyConstants.TJC_CARRIER_NAME, com.bytedance.sdk.openadsdk.utils.s.b());
                jSONObject2.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE);
                jSONObject2.put("conn_type", com.bytedance.sdk.openadsdk.utils.a0.f(contextA));
                if (dVarD.A("boot")) {
                    jSONObject2.put("boot", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + "");
                }
                com.bytedance.sdk.openadsdk.core.g0.c.a(jSONObject2);
                size = d.size();
            } else {
                size = 2;
            }
            while (size >= 1 && jSONObject2.toString().getBytes().length > 2680) {
                jSONObject2.remove(d.get(Integer.valueOf(size)));
                size--;
            }
            jSONObject = com.bytedance.sdk.component.utils.a.a(jSONObject2);
            while (size >= 1 && jSONObject.toString().getBytes().length > 4096) {
                jSONObject2.remove(d.get(Integer.valueOf(size)));
                jSONObject = com.bytedance.sdk.component.utils.a.a(jSONObject2);
                size--;
            }
            if (com.bytedance.sdk.component.utils.m.c()) {
                com.bytedance.sdk.component.utils.m.d("mssdk", "bidding token: " + jSONObject.toString() + "\nbidding token length: " + jSONObject.toString().getBytes().length);
            }
            com.bytedance.sdk.openadsdk.d.c.a(str);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.utils.m.a("TTAdManagerImpl", "bidding token: " + jSONObject.toString());
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public w c(String str) {
        h.a().g(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public w a(String str) {
        h.a().h(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public u f(int i) {
        h.a().a(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public int getCoppa() {
        return h.a().m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public int getGdpr() {
        return h.a().h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public u a() {
        com.bytedance.sdk.component.utils.m.d();
        b.b.a.a.j.a.e();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public u c(int i) {
        h.a().b(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public String d() {
        return b((String) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public u e(int i) {
        h.a().f(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public int c() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public u d(int i) {
        h.a().d(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public u a(boolean z) {
        h.a().c(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public u a(int i) {
        h.a().e(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public boolean a(String str, int i, String str2, String str3, String str4) {
        if (!this.a.equals(o.a().getPackageName()) || !this.f689b.equals(h.a().d()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Method methodA = com.bytedance.sdk.component.utils.x.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
            if (methodA != null) {
                methodA.invoke(null, str, Integer.valueOf(i), str2, str3, str4);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.c("TTAdManagerImpl", "reward component maybe not exist, pls check", th);
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public u b(int i) {
        this.c = i;
        return this;
    }
}
