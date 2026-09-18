package com.bytedance.sdk.openadsdk.b.k;

import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.v;
import com.bytedance.sdk.openadsdk.d.c;
import com.bytedance.sdk.openadsdk.l.c.b;
import com.bytedance.sdk.openadsdk.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTAppOpenAdReport.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTAppOpenAdReport.java */
    static class C0180a implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f456b;

        C0180a(int i, int i2) {
            this.a = i;
            this.f456b = i2;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timeout_type", this.a);
            jSONObject.put("user_timeout_time", this.f456b);
            return b.o().h("openad_load_ad_timeout").c(jSONObject.toString());
        }
    }

    public static void a(int i, int i2) {
        com.bytedance.sdk.openadsdk.l.b.a("openad_load_ad_timeout", false, (com.bytedance.sdk.openadsdk.l.a) new C0180a(i, i2));
    }

    public static void b(q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException e) {
            m.b("TTAppOpenAdReport", "reportCacheLoss json error", e);
        }
        c.a(qVar, "cache_loss", jSONObject);
    }

    public static void a(q qVar, int i, int i2, float f) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("skip_time", i);
            jSONObject.put("skip_show_time", i2);
            jSONObject.put("total_time", f);
        } catch (JSONException e) {
            m.b("TTAppOpenAdReport", "reportSkip json error", e);
        }
        c.a(qVar, "skip", i, jSONObject);
    }

    public static void b(q qVar, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("size", qVar.N0().p());
            jSONObject.put("video_duration", qVar.N0().s());
            jSONObject.put("order", z ? 1 : 2);
        } catch (JSONException unused) {
        }
        c.a(qVar, "download_video_duration", j, jSONObject);
    }

    public static void a(q qVar, long j, float f, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
            if (z) {
                double d = f;
                jSONObject.put("video_duration", d);
                jSONObject.put("video_percent", (int) (((j * 1.0d) / 10.0d) / d));
            } else {
                jSONObject.put("image_duration", f);
            }
        } catch (JSONException e) {
            m.b("TTAppOpenAdReport", "reportDestroy json error", e);
        }
        c.a(qVar, "destroy", jSONObject);
    }

    public static void a(q qVar) {
        c.a(qVar, "cache_expire", (JSONObject) null);
    }

    public static void a(q qVar, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("order", z ? 1 : 2);
        } catch (JSONException unused) {
        }
        c.a(qVar, "download_image_duration", j, jSONObject);
    }

    public static void a(q qVar, int i, v vVar) {
        long jD;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("open_ad_cache_type", i);
            if (vVar != null) {
                vVar.a(z.c());
                jSONObject.put("client_start_time", vVar.b());
                jSONObject.put("sever_time", vVar.g());
                jSONObject.put("network_time", vVar.e());
                jSONObject.put("client_end_time", vVar.a());
                jSONObject.put("download_resource_duration", vVar.c());
                jSONObject.put("resource_source", vVar.f());
                jSONObject.put("is_bidding", vVar.i ? 1 : 0);
                if (vVar.i) {
                    jSONObject.put("load_wait_time", vVar.j);
                }
                jD = vVar.d();
            } else {
                jD = 0;
            }
        } catch (JSONException e) {
            m.b("TTAppOpenAdReport", "reportLoadNetDuration json error", e);
        }
        c.a(qVar, "load_net_duration", jD, jSONObject);
    }

    public static void a(q qVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException unused) {
            m.b("TTAppOpenAdReport", "reportLoadCacheDuration json error");
        }
        c.a(qVar, "load_cache_duration", j, jSONObject);
    }
}
