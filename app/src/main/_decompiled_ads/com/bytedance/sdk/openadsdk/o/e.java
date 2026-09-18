package com.bytedance.sdk.openadsdk.o;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayableJsBridge.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.o.g> f814b;
    private Map<String, z> c = new HashMap();
    private SensorEventListener d = new k();
    private SensorEventListener e = new r();

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class a implements z {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            return gVarC == null ? new JSONObject() : gVarC.n();
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class b implements z {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            JSONObject jSONObject2 = new JSONObject();
            int iOptInt = 2;
            if (jSONObject != null) {
                try {
                    iOptInt = jSONObject.optInt("interval_android", 2);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.o.f.a("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
            com.bytedance.sdk.openadsdk.o.i.a(e.this.a, e.this.d, iOptInt);
            jSONObject2.put("code", 0);
            return jSONObject2;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class c implements z {
        c() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.bytedance.sdk.openadsdk.o.i.a(e.this.a, e.this.d);
                jSONObject2.put("code", 0);
                return jSONObject2;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.o.f.a("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                jSONObject2.put("code", -2);
                jSONObject2.put("codeMsg", th.toString());
                return jSONObject2;
            }
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class d implements z {
        d() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            JSONObject jSONObject2 = new JSONObject();
            int iOptInt = 2;
            if (jSONObject != null) {
                try {
                    iOptInt = jSONObject.optInt("interval_android", 2);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.o.f.a("PlayableJsBridge", "invoke start_gyro_observer error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
            com.bytedance.sdk.openadsdk.o.i.b(e.this.a, e.this.e, iOptInt);
            jSONObject2.put("code", 0);
            return jSONObject2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.o.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class C0250e implements z {
        C0250e() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.bytedance.sdk.openadsdk.o.i.a(e.this.a, e.this.e);
                jSONObject2.put("code", 0);
                return jSONObject2;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.o.f.a("PlayableJsBridge", "invoke close_gyro_observer error", th);
                jSONObject2.put("code", -2);
                jSONObject2.put("codeMsg", th.toString());
                return jSONObject2;
            }
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class f implements z {
        f() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.bytedance.sdk.openadsdk.o.i.b(e.this.a);
                jSONObject2.put("code", 0);
                return jSONObject2;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.o.f.a("PlayableJsBridge", "invoke device_shake error", th);
                jSONObject2.put("code", -2);
                jSONObject2.put("codeMsg", th.toString());
                return jSONObject2;
            }
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class g implements z {
        g() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC != null) {
                return gVarC.m();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class h implements z {
        h() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null) {
                return null;
            }
            gVarC.y();
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class i implements z {
        i(e eVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class j implements z {
        j() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null || jSONObject == null) {
                return null;
            }
            gVarC.c(jSONObject.optString("event", null), jSONObject.optJSONObject("params"));
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class k implements SensorEventListener {
        k() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            com.bytedance.sdk.openadsdk.o.g gVarC;
            if (sensorEvent.sensor.getType() != 1 || (gVarC = e.this.c()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put("z", f3);
                gVarC.d("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class l implements z {
        l() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null) {
                return null;
            }
            gVarC.d(jSONObject);
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class m implements z {
        m() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null) {
                return null;
            }
            gVarC.b(jSONObject);
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class n implements z {
        n() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null) {
                return null;
            }
            gVarC.c(jSONObject);
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class o implements z {
        o() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null) {
                return null;
            }
            return gVarC.p();
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class p implements z {
        p() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null) {
                return null;
            }
            gVarC.s();
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class q implements z {
        q() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null) {
                return null;
            }
            gVarC.a(jSONObject);
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class r implements SensorEventListener {
        r() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            com.bytedance.sdk.openadsdk.o.g gVarC;
            if (sensorEvent.sensor.getType() != 4 || (gVarC = e.this.c()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put("z", degrees3);
                gVarC.d("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class s implements z {
        s() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC != null) {
                return gVarC.c();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class t implements z {
        t() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appName", "playable_sdk");
            jSONObject2.put("playableSdkEdition", "5.2.2");
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = e.this.a().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject2.put("supportList", jSONArray);
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC != null) {
                jSONObject2.put("deviceId", gVarC.g());
                jSONObject2.put("netType", gVarC.l());
                jSONObject2.put("innerAppName", gVarC.h());
                jSONObject2.put("appName", gVarC.d());
                jSONObject2.put("appVersion", gVarC.e());
                Map<String, String> mapK = gVarC.k();
                for (String str : mapK.keySet()) {
                    jSONObject2.put(str, mapK.get(str));
                }
            }
            return jSONObject2;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class u implements z {
        u(e eVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appName", "playable_sdk");
            jSONObject2.put("playableSdkEdition", "5.2.2");
            jSONObject2.put("os", "android");
            return jSONObject2;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class v implements z {
        v() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) {
            com.bytedance.sdk.openadsdk.o.a aVarB = e.this.b();
            if (aVarB == null) {
                return null;
            }
            aVarB.c(jSONObject);
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class w implements z {
        w() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) {
            com.bytedance.sdk.openadsdk.o.a aVarB = e.this.b();
            if (aVarB == null) {
                return null;
            }
            aVarB.a(jSONObject);
            return null;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class x implements z {
        x() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null) {
                return new JSONObject();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("viewStatus", gVarC.o());
            return jSONObject2;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    class y implements z {
        y() {
        }

        @Override // com.bytedance.sdk.openadsdk.o.e.z
        public JSONObject a(JSONObject jSONObject) throws Throwable {
            com.bytedance.sdk.openadsdk.o.g gVarC = e.this.c();
            if (gVarC == null) {
                return new JSONObject();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("endcard_mute", gVarC.i());
            return jSONObject2;
        }
    }

    /* JADX INFO: compiled from: PlayableJsBridge.java */
    interface z {
        JSONObject a(JSONObject jSONObject) throws Throwable;
    }

    public e(com.bytedance.sdk.openadsdk.o.g gVar) {
        this.a = gVar.f();
        this.f814b = new WeakReference<>(gVar);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.o.a b() {
        com.bytedance.sdk.openadsdk.o.g gVarC = c();
        if (gVarC == null) {
            return null;
        }
        return gVarC.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.o.g c() {
        WeakReference<com.bytedance.sdk.openadsdk.o.g> weakReference = this.f814b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void d() {
        this.c.put("adInfo", new s());
        this.c.put("appInfo", new t());
        this.c.put("playableSDKInfo", new u(this));
        this.c.put("subscribe_app_ad", new v());
        this.c.put("download_app_ad", new w());
        this.c.put("isViewable", new x());
        this.c.put("getVolume", new y());
        this.c.put("getScreenSize", new a());
        this.c.put("start_accelerometer_observer", new b());
        this.c.put("close_accelerometer_observer", new c());
        this.c.put("start_gyro_observer", new d());
        this.c.put("close_gyro_observer", new C0250e());
        this.c.put("device_shake", new f());
        this.c.put("playable_style", new g());
        this.c.put("sendReward", new h());
        this.c.put("webview_time_track", new i(this));
        this.c.put("playable_event", new j());
        this.c.put("reportAd", new l());
        this.c.put("close", new m());
        this.c.put("openAdLandPageLinks", new n());
        this.c.put("get_viewport", new o());
        this.c.put("jssdk_load_finish", new p());
        this.c.put("material_render_result", new q());
    }

    public Set<String> a() {
        return this.c.keySet();
    }

    public void e() {
        com.bytedance.sdk.openadsdk.o.i.a(this.a, this.d);
        com.bytedance.sdk.openadsdk.o.i.a(this.a, this.e);
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            z zVar = this.c.get(str);
            if (zVar == null) {
                return null;
            }
            return zVar.a(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.o.f.a("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }
}
