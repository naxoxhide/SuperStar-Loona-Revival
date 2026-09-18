package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import b.b.a.a.k.g;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.MonitorCrash;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.y;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApmHelper {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f369b = null;
    private static boolean c = false;
    private static boolean d = false;
    private static d e;
    private static c f;

    static class a extends g {
        final /* synthetic */ Context c;
        final /* synthetic */ InitConfig d;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.ApmHelper$a$a, reason: collision with other inner class name */
        class C0163a implements AttachUserData {
            final /* synthetic */ MonitorCrash a;

            C0163a(a aVar, MonitorCrash monitorCrash) {
                this.a = monitorCrash;
            }

            public Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                Map<? extends String, ? extends String> mapJ = ApmHelper.j();
                if (mapJ.containsKey("render_type")) {
                    this.a.addTags("render_type", mapJ.get("render_type"));
                } else {
                    this.a.addTags("render_type", "-2");
                }
                return mapJ;
            }
        }

        class b implements d {
            final /* synthetic */ MonitorCrash a;

            b(a aVar, MonitorCrash monitorCrash) {
                this.a = monitorCrash;
            }

            @Override // com.bytedance.sdk.openadsdk.ApmHelper.d
            public void a(String str, String str2, Throwable th) {
                this.a.reportCustomErr(str, str2, th);
            }
        }

        class c implements ICrashCallback {
            c(a aVar) {
            }

            public void onCrash(CrashType crashType, String str, Thread thread) {
                if (!ApmHelper.d) {
                    ApmHelper.d(crashType.getName());
                }
                boolean unused = ApmHelper.d = true;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Context context, InitConfig initConfig) {
            super(str);
            this.c = context;
            this.d = initConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApmHelper.a) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.settings.d dVarD = o.d();
            boolean unused = ApmHelper.c = dVarD.p();
            if (!ApmHelper.c || TextUtils.isEmpty(dVarD.z())) {
                return;
            }
            String unused2 = ApmHelper.f369b = this.d.getAppId();
            String[] strArr = {"com.bytedance.sdk", "com.com.bytedance.overseas.sdk", "com.pgl.ssdk.ces", "com.bykv.vk"};
            String strC = j.c(this.c);
            String strZ = dVarD.z();
            try {
                MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(this.c, "10000001", 5411L, BuildConfig.VERSION_NAME, strArr);
                monitorCrashInitSDK.setCustomDataCallback(new C0163a(this, monitorCrashInitSDK));
                if (dVarD.A()) {
                    monitorCrashInitSDK.config().setSoList(new String[]{"libnms.so", "libtobEmbedPagEncrypt.so"});
                }
                monitorCrashInitSDK.config().setDeviceId(strC);
                monitorCrashInitSDK.setReportUrl(strZ);
                monitorCrashInitSDK.addTags("host_appid", ApmHelper.f369b);
                monitorCrashInitSDK.addTags("sdk_version", BuildConfig.VERSION_NAME);
                monitorCrashInitSDK.config().setChannel(ApmHelper.i());
                d unused3 = ApmHelper.e = new b(this, monitorCrashInitSDK);
                boolean unused4 = ApmHelper.a = true;
                ApmHelper.c(strC, strZ);
                monitorCrashInitSDK.registerCrashCallback(new c(this), CrashType.ALL);
                c cVar = ApmHelper.f;
                c unused5 = ApmHelper.f = null;
                if (cVar != null) {
                    ApmHelper.e.a(cVar.a, cVar.f371b, cVar.c);
                }
            } catch (Throwable unused6) {
                m.f("ApmHelper", "init Apm fail or not include Apm module");
                boolean unused7 = ApmHelper.a = false;
            }
        }
    }

    static class b implements com.bytedance.sdk.openadsdk.d.q.a {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f370b;

        b(String str, q qVar) {
            this.a = str;
            this.f370b = qVar;
        }

        @Override // com.bytedance.sdk.openadsdk.d.q.a
        public void a(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", this.a);
            jSONObject2.put("material", com.bytedance.sdk.component.utils.a.a(this.f370b.n1()).toString());
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        }
    }

    private static class c {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f371b;
        public final Throwable c;

        public c(String str, String str2, Throwable th) {
            this.a = str;
            this.f371b = str2;
            this.c = th;
        }
    }

    private interface d {
        void a(String str, String str2, Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i() {
        com.bytedance.sdk.openadsdk.core.settings.d dVarD = o.d();
        if (dVarD != null) {
            return dVarD.E() ? "support_mem_dynamic_1" : "support_mem_dynamic_0";
        }
        return "release";
    }

    public static void initApm(Context context, InitConfig initConfig) {
        y.c(new a("init-apm", context, initConfig));
    }

    public static boolean isIsInit() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> j() {
        HashMap map = new HashMap();
        q qVarA = com.bytedance.sdk.openadsdk.utils.b.a();
        if (qVarA != null) {
            map.put("adType", qVarA.g() + "");
            map.put("aid", qVarA.Q() + "");
            map.put(BidResponsedEx.KEY_CID, qVarA.e());
            map.put("reqId", qVarA.U());
            map.put("rit", qVarA.c("-1"));
            int iY0 = qVarA.y0();
            if (qVarA.w0() != 2) {
                iY0 = -1;
            }
            map.put("render_type", iY0 + "");
        }
        return map;
    }

    public static void reportCustomError(String str, String str2, Throwable th) {
        d dVar = e;
        if (dVar != null) {
            dVar.a(str, str2, th);
        } else {
            f = new c(str, str2, th);
        }
    }

    public static void reportPvFromBackGround() {
        if (c) {
            b(j.c(o.a()), o.d().z());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        q qVarA = com.bytedance.sdk.openadsdk.utils.b.a();
        if (qVarA != null) {
            String strA = a0.a(qVarA);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            com.bytedance.sdk.openadsdk.d.c.a(System.currentTimeMillis(), qVarA, strA, "sdk_crash_info", new JSONObject(), (com.bytedance.sdk.openadsdk.d.g) null, new b(str, qVarA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, String str2) {
        b(str, str2);
    }

    private static void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        o.c().a(c(str), "https://" + str2 + "/monitor/collect/c/session?version_code=" + BuildConfig.VERSION_CODE + "&device_platform=android&aid=10000001");
    }

    private static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject3.put("host_app_id", f369b);
            jSONObject2.putOpt("custom", jSONObject3);
            jSONObject2.put("os", "Android");
            jSONObject2.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE);
            jSONObject2.put("device_model", Build.MODEL);
            jSONObject2.put("device_brand", Build.BRAND);
            jSONObject2.put("sdk_version_name", "0.0.5");
            jSONObject2.put("channel", i());
            jSONObject2.put("aid", "10000001");
            jSONObject2.put("update_version_code", BuildConfig.VERSION_CODE);
            jSONObject2.put("bd_did", str);
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("local_time", Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("local_time_ms", System.currentTimeMillis()));
            jSONObject.putOpt("launch", jSONArray);
        } catch (JSONException e2) {
            m.b("ApmHelper", e2.getMessage());
        }
        return jSONObject;
    }
}
