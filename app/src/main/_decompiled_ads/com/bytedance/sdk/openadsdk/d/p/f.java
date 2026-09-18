package com.bytedance.sdk.openadsdk.d.p;

import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: GetAdEventMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static AtomicInteger a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicInteger f744b = new AtomicInteger(0);
    public static AtomicInteger c = new AtomicInteger(0);
    public static AtomicInteger d = new AtomicInteger(0);
    public static AtomicInteger e = new AtomicInteger(0);
    public static AtomicInteger f = new AtomicInteger(0);
    public static AtomicInteger g = new AtomicInteger(0);
    public static AtomicInteger h = new AtomicInteger(0);

    public static JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("load_times", a.get());
            jSONObject.put("load_success", f744b.get());
            jSONObject.put("load_fail", c.get());
            jSONObject.put("load_success_and_parse_success", d.get());
            jSONObject.put("load_success_and_parse_fail", e.get());
            jSONObject.put("load_success_and_no_ad", f.get());
            jSONObject.put("load_fail_by_no_net", g.get());
            jSONObject.put("load_fail_by_io", h.get());
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void b() {
        try {
            long jA = com.bytedance.sdk.openadsdk.m.i.a.a("tt_sdk_event_get_ad", "get_ad_event_time_key", 0L);
            if (jA > 0 && System.currentTimeMillis() - jA >= 86400000) {
                d();
                com.bytedance.sdk.openadsdk.m.i.a.a("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
                return;
            }
            if (jA <= 0 || jA > System.currentTimeMillis()) {
                com.bytedance.sdk.openadsdk.m.i.a.a("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
            }
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.m.i.a.a("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            a.addAndGet(jSONObject.optInt("load_times"));
            f744b.addAndGet(jSONObject.optInt("load_success"));
            c.addAndGet(jSONObject.optInt("load_fail"));
            d.addAndGet(jSONObject.optInt("load_success_and_parse_success"));
            e.addAndGet(jSONObject.optInt("load_success_and_parse_fail"));
            f.addAndGet(jSONObject.optInt("load_success_and_no_ad"));
            g.addAndGet(jSONObject.optInt("load_fail_by_no_net"));
            h.addAndGet(jSONObject.optInt("load_fail_by_io"));
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        try {
            com.bytedance.sdk.openadsdk.m.i.a.b("tt_sdk_event_get_ad", "get_ad_event_key", a().toString());
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        try {
            com.bytedance.sdk.openadsdk.l.b.a().a("pangle_sdk_get_ad_track", com.bytedance.sdk.openadsdk.m.i.a.a("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            com.bytedance.sdk.openadsdk.m.i.a.a("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static void a(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("msg", str);
            com.bytedance.sdk.openadsdk.l.b.a().a("pangle_sdk_client_load_error", jSONObject);
        } catch (Throwable unused) {
        }
    }
}
