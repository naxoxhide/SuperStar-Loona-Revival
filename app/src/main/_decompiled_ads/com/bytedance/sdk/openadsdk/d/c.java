package com.bytedance.sdk.openadsdk.d;

import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.y;
import com.bytedance.sdk.openadsdk.utils.z;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.tapjoy.TJAdUnitConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEventManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: compiled from: AdEventManager.java */
    static class a extends b.b.a.a.k.g {
        final /* synthetic */ JSONObject c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ q f;
        final /* synthetic */ long g;
        final /* synthetic */ String h;
        final /* synthetic */ long i;
        final /* synthetic */ long j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, JSONObject jSONObject, String str2, String str3, q qVar, long j, String str4, long j2, long j3) {
            super(str);
            this.c = jSONObject;
            this.d = str2;
            this.e = str3;
            this.f = qVar;
            this.g = j;
            this.h = str4;
            this.i = j2;
            this.j = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            q qVar;
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    String strOptString = this.c.optString("ad_extra_data", null);
                    if (strOptString != null) {
                        jSONObject = new JSONObject(strOptString);
                    }
                    if (!"click".equals(this.d)) {
                        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, DeviceUtils.d(com.bytedance.sdk.openadsdk.core.o.a()).toString());
                    }
                    this.c.put("ad_extra_data", jSONObject.toString());
                    this.c.put("tag", this.e);
                    if ("click".equals(this.d)) {
                        r.b(this.f);
                        float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - q.b(this.c.optString("log_extra"))).floatValue();
                        JSONObject jSONObject2 = this.c;
                        if (fFloatValue <= 0.0f) {
                            fFloatValue = 0.0f;
                        }
                        jSONObject2.putOpt("show_time", Float.valueOf(fFloatValue));
                        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.c(com.bytedance.sdk.openadsdk.core.o.a())) && (qVar = this.f) != null) {
                            com.bytedance.sdk.openadsdk.d.p.d.a(com.bytedance.sdk.openadsdk.q.a.a(qVar.u(), true));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            new com.bytedance.sdk.openadsdk.d.a.C0221a(this.g).b(this.h).g(this.e).d(this.d).h(String.valueOf(this.i)).c(String.valueOf(this.j)).a(this.f.i()).a(this.c, this.f).f(this.f.U()).a((com.bytedance.sdk.openadsdk.d.q.a) null);
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class b extends b.b.a.a.k.g {
        final /* synthetic */ long c;
        final /* synthetic */ JSONObject d;
        final /* synthetic */ long e;
        final /* synthetic */ q f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, long j, JSONObject jSONObject, long j2, q qVar, String str2) {
            super(str);
            this.c = j;
            this.d = jSONObject;
            this.e = j2;
            this.f = qVar;
            this.g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                long j = this.c;
                if (j != -1) {
                    jSONObject.put("duration", j);
                }
                JSONObject jSONObject2 = this.d;
                if (jSONObject2 != null) {
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } else {
                    jSONObject.put("ad_extra_data", new JSONObject().toString());
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("TTAD.AdEvent", e.getMessage());
            }
            c.a(this.e, this.f, "open_ad", this.g, jSONObject, (com.bytedance.sdk.openadsdk.d.g) null, (com.bytedance.sdk.openadsdk.d.q.a) null);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.d.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdEventManager.java */
    static class C0223c extends b.b.a.a.k.g {
        final /* synthetic */ String c;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0223c(String str, String str2, long j) {
            super(str);
            this.c = str2;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("slot", this.c);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                long jCurrentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.utils.l.e();
                if (jCurrentTimeMillis > 600000 || jCurrentTimeMillis < 0) {
                    com.bytedance.sdk.openadsdk.utils.l.a();
                } else {
                    jSONObject.put("duration", jCurrentTimeMillis);
                    q qVarF = com.bytedance.sdk.openadsdk.core.b.f(new JSONObject(com.bytedance.sdk.openadsdk.utils.l.b()));
                    if (qVarF == null) {
                    } else {
                        c.a(this.d, qVarF, com.bytedance.sdk.openadsdk.utils.l.d(), "next_load_stats", jSONObject, (com.bytedance.sdk.openadsdk.d.g) null, (com.bytedance.sdk.openadsdk.d.q.a) null);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class d implements Runnable {
        final /* synthetic */ b.b.a.a.k.g a;

        d(b.b.a.a.k.g gVar) {
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.c(this.a, 10);
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class e extends b.b.a.a.k.g {
        e(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bytedance.sdk.openadsdk.l.b.a().a("show_fail_log", new JSONObject());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.AdEvent", th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class f extends b.b.a.a.k.g {
        final /* synthetic */ q c;
        final /* synthetic */ JSONObject d;
        final /* synthetic */ String e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, q qVar, JSONObject jSONObject, String str2, long j) {
            super(str);
            this.c = qVar;
            this.d = jSONObject;
            this.e = str2;
            this.f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject;
            Object obj;
            try {
                r.a(this.c);
                jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = this.d;
                    if (jSONObject2 != null) {
                        jSONObject2.put("interaction_method", this.c.k0());
                        this.d.put("real_interaction_method", this.c.v());
                        jSONObject.put("ad_extra_data", this.d.toString());
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("interaction_method", this.c.k0());
                        jSONObject3.put("real_interaction_method", this.c.v());
                        jSONObject.put("ad_extra_data", jSONObject3.toString());
                    }
                    jSONObject.putOpt("log_extra", this.c.N());
                    float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - this.c.T()).floatValue();
                    if (fFloatValue <= 0.0f) {
                        fFloatValue = 0.0f;
                    }
                    jSONObject.putOpt("show_time", Float.valueOf(fFloatValue));
                    jSONObject.putOpt("ua_policy", Integer.valueOf(this.c.L0()));
                    String strP = this.c.p();
                    if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(strP)) {
                        try {
                            jSONObject.put("ttdsp_price", Math.round(Float.parseFloat(strP) * 100000.0f));
                        } catch (Throwable th) {
                            jSONObject.put("ttdsp_price", 0);
                            com.bytedance.sdk.component.utils.m.b("TTAD.AdEvent", th.getMessage());
                        }
                    }
                    if (this.c.i0() != null) {
                        try {
                            Object obj2 = this.c.i0().get("sdk_bidding_type");
                            if (obj2 != null && Integer.parseInt(obj2.toString()) == 2 && (obj = this.c.i0().get("price")) != null) {
                                jSONObject.put("ttdsp_price", Math.round(Double.parseDouble(obj.toString()) * 100000.0d));
                            }
                        } catch (Throwable th2) {
                            com.bytedance.sdk.component.utils.m.b("TTAD.AdEvent", "client bidding price error: ", th2);
                        }
                    }
                    com.bytedance.sdk.openadsdk.d.k.a(this.c, this.e);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONObject = null;
            }
            new com.bytedance.sdk.openadsdk.d.a.C0221a(this.f).g(this.e).d(TJAdUnitConstants.String.BEACON_SHOW_PATH).h(this.c.e()).a(this.c.i()).a(jSONObject, this.c).f(this.c.U()).a((com.bytedance.sdk.openadsdk.d.q.a) null);
            if (!this.c.c1()) {
                if (this.c.X0()) {
                    com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.c.E0(), new com.bytedance.sdk.openadsdk.core.i0.l.c.e("show_urls", this.c));
                } else {
                    c.a(this.c);
                }
            }
            com.bytedance.sdk.openadsdk.core.g0.c.d();
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class g extends b.b.a.a.k.g {
        final /* synthetic */ String c;
        final /* synthetic */ com.bytedance.sdk.openadsdk.d.g d;
        final /* synthetic */ long e;
        final /* synthetic */ q f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, String str2, com.bytedance.sdk.openadsdk.d.g gVar, long j, q qVar, String str3) {
            super(str);
            this.c = str2;
            this.d = gVar;
            this.e = j;
            this.f = qVar;
            this.g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", this.c);
                com.bytedance.sdk.openadsdk.d.g gVar = this.d;
                if (gVar != null && gVar.a() != null) {
                    jSONObject.put("ad_extra_data", this.d.a().toString());
                }
            } catch (Throwable unused) {
            }
            c.b(this.e, this.f, this.g, "ad_show_time", jSONObject);
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class h extends b.b.a.a.k.g {
        final /* synthetic */ long c;
        final /* synthetic */ z d;
        final /* synthetic */ q e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, long j, z zVar, q qVar, String str2) {
            super(str);
            this.c = j;
            this.d = zVar;
            this.e = qVar;
            this.f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("click_stay_time", this.c);
                jSONObject.put("click_time", this.d.a);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (Throwable unused) {
            }
            c.b(System.currentTimeMillis(), this.e, this.f, "stay_duration", jSONObject2);
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class i extends b.b.a.a.k.g {
        final /* synthetic */ long c;
        final /* synthetic */ q d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, long j, q qVar, String str2) {
            super(str);
            this.c = j;
            this.d = qVar;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("video_click_duration_time", this.c);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (Throwable unused) {
            }
            long j = this.c;
            if (j <= 0 || j >= 200000) {
                return;
            }
            c.b(System.currentTimeMillis(), this.d, this.e, "video_click_duration", jSONObject2);
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class j extends b.b.a.a.k.g {
        final /* synthetic */ q c;
        final /* synthetic */ boolean d;
        final /* synthetic */ long e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, q qVar, boolean z, long j, String str2) {
            super(str);
            this.c = qVar;
            this.d = z;
            this.e = j;
            this.f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("if_lp_loading_success", this.d ? 1 : 2);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
                jSONObject2.put("duration", this.e);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b(th.toString());
            }
            c.b(System.currentTimeMillis(), this.c, this.f, "lp_loading", jSONObject2);
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class k extends b.b.a.a.k.g {
        final /* synthetic */ q c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, q qVar, String str2) {
            super(str);
            this.c = qVar;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("ad_slot_type", this.c.f().getNativeAdType());
                jSONObject.put("interaction_method", this.c.k0());
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b(th.toString());
            }
            c.b(System.currentTimeMillis(), this.c, this.d, "picture_click", jSONObject2);
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class l extends b.b.a.a.k.g {
        final /* synthetic */ q c;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.i d;
        final /* synthetic */ boolean e;
        final /* synthetic */ int f;
        final /* synthetic */ Map g;
        final /* synthetic */ long h;
        final /* synthetic */ String i;
        final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(String str, q qVar, com.bytedance.sdk.openadsdk.core.f0.i iVar, boolean z, int i, Map map, long j, String str2, String str3) {
            super(str);
            this.c = qVar;
            this.d = iVar;
            this.e = z;
            this.f = i;
            this.g = map;
            this.h = j;
            this.i = str2;
            this.j = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                com.bytedance.sdk.openadsdk.core.f0.i iVar = this.d;
                if (iVar != null) {
                    JSONObject jSONObjectA = iVar.a();
                    jSONObjectA.put("is_valid", this.e);
                    int i = this.f;
                    if (i >= 1 && i <= 2) {
                        jSONObjectA.put("user_behavior_type", i);
                    }
                    Map map = this.g;
                    if (map != null) {
                        if (map.containsKey("duration")) {
                            jSONObject.put("duration", this.g.get("duration"));
                        }
                        for (Map.Entry entry : this.g.entrySet()) {
                            if (!"duration".equals(entry.getKey())) {
                                jSONObjectA.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    jSONObjectA.put("interaction_method", this.c.k0());
                    jSONObject.put("ad_extra_data", jSONObjectA.toString());
                }
                jSONObject.putOpt("log_extra", this.c.N());
                float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - this.c.T()).floatValue();
                if (fFloatValue <= 0.0f) {
                    fFloatValue = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(fFloatValue));
                jSONObject.putOpt("ua_policy", Integer.valueOf(this.c.L0()));
            } catch (Exception unused) {
            }
            new com.bytedance.sdk.openadsdk.d.a.C0221a(this.h).g(this.i).d(this.j).h(this.c.e()).a(this.c.i()).a(jSONObject, this.c).f(this.c.U()).a((com.bytedance.sdk.openadsdk.d.q.a) null);
            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.c(com.bytedance.sdk.openadsdk.core.o.a())) && "click".equals(this.j)) {
                com.bytedance.sdk.openadsdk.d.p.d.a(com.bytedance.sdk.openadsdk.q.a.a(this.c.u(), true));
            }
            if ("click".equals(this.j)) {
                r.b(this.c);
            }
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class m extends b.b.a.a.k.g {
        final /* synthetic */ JSONObject c;
        final /* synthetic */ q d;
        final /* synthetic */ long e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, JSONObject jSONObject, q qVar, long j, String str2, String str3) {
            super(str);
            this.c = jSONObject;
            this.d = qVar;
            this.e = j;
            this.f = str2;
            this.g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = this.c;
                if (jSONObject != null) {
                    jSONObject.putOpt("log_extra", this.d.N());
                    this.c.putOpt("ua_policy", Integer.valueOf(this.d.L0()));
                } else {
                    com.bytedance.sdk.component.utils.m.d("TTAD.AdEvent", "ccr log, log_extra is empty");
                }
            } catch (Exception unused) {
            }
            new com.bytedance.sdk.openadsdk.d.a.C0221a(this.e).g(this.f).d(this.g).h(this.d.e()).a(this.d.i()).a(this.c, this.d).f(this.d.U()).a((com.bytedance.sdk.openadsdk.d.q.a) null);
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    static class n extends b.b.a.a.k.g {
        final /* synthetic */ long c;
        final /* synthetic */ String d;
        final /* synthetic */ long e;
        final /* synthetic */ q f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(String str, long j, String str2, long j2, q qVar) {
            super(str);
            this.c = j;
            this.d = str2;
            this.e = j2;
            this.f = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (com.bytedance.sdk.openadsdk.core.o.d().U()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", this.c);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.m.b("TTAD.AdEvent", th.getMessage());
                }
                String str2 = this.d;
                str2.hashCode();
                str2.hashCode();
                switch (str2) {
                    case "banner_ad":
                        str = "banner_ad_loadtime";
                        break;
                    case "rewarded_video":
                        str = "rewarded_video_loadtime";
                        break;
                    case "fullscreen_interstitial_ad":
                        str = "fullscreen_interstitial_ad_loadtime";
                        break;
                    case "embeded_ad":
                        str = "embeded_ad_loadtime";
                        break;
                    case "interaction":
                        str = "interaction_loadtime";
                        break;
                    default:
                        str = "";
                        break;
                }
                c.b(this.e, this.f, this.d, str, jSONObject);
            }
        }
    }

    /* JADX INFO: compiled from: AdEventManager.java */
    public static class o {

        /* JADX INFO: compiled from: AdEventManager.java */
        static class a extends b.b.a.a.k.g {
            final /* synthetic */ q c;
            final /* synthetic */ JSONObject d;
            final /* synthetic */ String e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, q qVar, JSONObject jSONObject, String str2) {
                super(str);
                this.c = qVar;
                this.d = jSONObject;
                this.e = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strA = a0.a(this.c);
                    if (strA == null) {
                        return;
                    }
                    String str = strA + "_landingpage";
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ad_extra_data", this.d.toString());
                    c.b(System.currentTimeMillis(), this.c, str, this.e, jSONObject);
                } catch (Throwable th) {
                    Log.d("TTAD.AdEvent", "Gecko.loadEvent error", th);
                }
            }
        }

        /* JADX INFO: compiled from: AdEventManager.java */
        static class b extends b.b.a.a.k.g {
            final /* synthetic */ q c;
            final /* synthetic */ int d;
            final /* synthetic */ int e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str, q qVar, int i, int i2) {
                super(str);
                this.c = qVar;
                this.d = i;
                this.e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strA = a0.a(this.c);
                    if (strA == null) {
                        return;
                    }
                    String str = strA + "_landingpage";
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("all_times", this.d);
                    jSONObject.put("hit_times", this.e);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    c.b(System.currentTimeMillis(), this.c, str, "local_res_hit_rate", jSONObject2);
                } catch (Throwable th) {
                    Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                }
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.d.c$o$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdEventManager.java */
        static class C0224c extends b.b.a.a.k.g {
            final /* synthetic */ String c;
            final /* synthetic */ ILoader d;
            final /* synthetic */ String e;
            final /* synthetic */ q f;
            final /* synthetic */ long g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0224c(String str, String str2, ILoader iLoader, String str3, q qVar, long j) {
                super(str);
                this.c = str2;
                this.d = iLoader;
                this.e = str3;
                this.f = qVar;
                this.g = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.c == null) {
                        return;
                    }
                    int iA = com.bytedance.sdk.openadsdk.f.b.c().a(this.d, this.e);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", this.f.H0());
                    jSONObject.put("channel_name", this.f.X());
                    jSONObject.put("interceptor_status", (TextUtils.isEmpty(this.f.X()) || iA <= 0) ? 0 : 1);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("resource_count", iA);
                    jSONObject.put("resource_info", jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    jSONObject3.put("duration", this.g);
                    c.b(System.currentTimeMillis(), this.f, this.c, "landingpage_init", jSONObject3);
                } catch (Throwable th) {
                    Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                }
            }
        }

        /* JADX INFO: compiled from: AdEventManager.java */
        static class d extends b.b.a.a.k.g {
            final /* synthetic */ String c;
            final /* synthetic */ q d;
            final /* synthetic */ int e;
            final /* synthetic */ int f;
            final /* synthetic */ int g;
            final /* synthetic */ int h;
            final /* synthetic */ int i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(String str, String str2, q qVar, int i, int i2, int i3, int i4, int i5) {
                super(str);
                this.c = str2;
                this.d = qVar;
                this.e = i;
                this.f = i2;
                this.g = i3;
                this.h = i4;
                this.i = i5;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.c != null && !TextUtils.isEmpty(this.d.X())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("next_url", this.d.H0());
                        jSONObject.put("channel_name", this.d.X());
                        jSONObject.put("preload_status", this.e <= 0 ? 0 : 2);
                        jSONObject.put("first_page", this.f);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("channel_response", this.e);
                        jSONObject2.put("failResourceCount", this.g);
                        jSONObject2.put("successCount", this.h);
                        jSONObject2.put("failCount", this.i);
                        jSONObject.put("resource_info", jSONObject2);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("ad_extra_data", jSONObject.toString());
                        c.b(System.currentTimeMillis(), this.d, this.c, "landing_page_resource_detail", jSONObject3);
                    }
                } catch (Throwable th) {
                    Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                }
            }
        }

        /* JADX INFO: compiled from: AdEventManager.java */
        static class e extends b.b.a.a.k.g {
            final /* synthetic */ q c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(String str, q qVar) {
                super(str);
                this.c = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strA = a0.a(this.c);
                    if (strA != null && !TextUtils.isEmpty(this.c.X())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", this.c.H0());
                        jSONObject.put("channel_name", this.c.X());
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                        c.b(System.currentTimeMillis(), this.c, strA, "download_gecko_start", jSONObject2);
                    }
                } catch (Throwable th) {
                    Log.d("TTAD.AdEvent", "Gecko.downloadGeckoStart error", th);
                }
            }
        }

        /* JADX INFO: compiled from: AdEventManager.java */
        static class f extends b.b.a.a.k.g {
            final /* synthetic */ q c;
            final /* synthetic */ JSONObject d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(String str, q qVar, JSONObject jSONObject) {
                super(str);
                this.c = qVar;
                this.d = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strA = a0.a(this.c);
                    if (strA != null && !TextUtils.isEmpty(this.c.X())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", this.c.H0());
                        jSONObject.put("channel_name", this.c.X());
                        jSONObject.put("data", this.d);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                        c.b(System.currentTimeMillis(), this.c, strA, "download_gecko_end", jSONObject2);
                    }
                } catch (Throwable th) {
                    Log.d("TTAD.AdEvent", "Gecko.downloadGeckoEnd error", th);
                }
            }
        }

        public static void a(String str, JSONObject jSONObject, q qVar) {
            c.a(new a("res_hit", qVar, jSONObject, str));
        }

        public static void a(int i, int i2, q qVar) {
            c.a(new b("res_hit", qVar, i2, i));
        }

        public static void a(long j, q qVar, String str, ILoader iLoader, String str2) {
            c.a(new C0224c("page_init", str, iLoader, str2, qVar, j));
        }

        public static void a(int i, int i2, int i3, int i4, q qVar, String str, int i5) {
            c.a(new d("resource_detail", str, qVar, i, i5, i2, i3, i4));
        }

        public static void a(q qVar) {
            c.a(new e("download_gecko_start", qVar));
        }

        public static void a(q qVar, JSONObject jSONObject) {
            c.a(new f("download_gecko_end", qVar, jSONObject));
        }
    }

    @JProtect
    public static void b(q qVar, String str, JSONObject jSONObject) {
        if (qVar == null) {
            return;
        }
        a(new f("onShow", qVar, jSONObject, str, System.currentTimeMillis()));
    }

    @JProtect
    public static void c(q qVar, String str, String str2, JSONObject jSONObject) {
        if (qVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        b(System.currentTimeMillis(), qVar, str, str2, jSONObject);
    }

    public static void a() {
        try {
            Class.forName(c.class.getName());
        } catch (ClassNotFoundException unused) {
        }
    }

    public static void a(q qVar, String str, int i2) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("render_type", "h5");
            jSONObject2.putOpt("render_type_2", 0);
            jSONObject2.putOpt("preload_status", Integer.valueOf(i2));
            jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        c(qVar, str, "open_url_h5", jSONObject);
    }

    public static void b(q qVar, String str) {
        a(new k("pictureClick", qVar, str));
    }

    public static void b(q qVar, String str, String str2, JSONObject jSONObject) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
    }

    public static void b(q qVar, String str, String str2, JSONObject jSONObject, long j2) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        jSONObject2.put("duration", j2);
        b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
    }

    public static void a(q qVar, String str, long j2, int i2) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("render_type", "h5");
            jSONObject2.putOpt("render_type_2", 0);
            jSONObject2.putOpt("interaction_method", Integer.valueOf(qVar.k0()));
            if (i2 >= 0) {
                jSONObject2.putOpt("preload_status", Integer.valueOf(i2));
            }
            jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            jSONObject.put("duration", Math.min(j2, 600000L));
        } catch (Exception unused) {
        }
        c(qVar, str, "load", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public static void b(long j2, q qVar, String str, String str2, JSONObject jSONObject) {
        if (qVar == null) {
            return;
        }
        a(new m("sendEvent", jSONObject, qVar, j2, str, str2));
    }

    public static void b(q qVar, String str, long j2) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", j2);
        } catch (Exception unused) {
        }
        b(System.currentTimeMillis(), qVar, str, "bidding_load", jSONObject);
    }

    public static void a(long j2, q qVar, String str, String str2, JSONObject jSONObject, com.bytedance.sdk.openadsdk.d.g gVar, com.bytedance.sdk.openadsdk.d.q.a aVar) {
        if (qVar == null) {
            return;
        }
        new com.bytedance.sdk.openadsdk.d.a.C0221a(j2).h(qVar.e()).f(qVar.U()).e(qVar.N()).a(qVar.i()).g(str).d(str2).a(jSONObject, qVar).a(aVar);
    }

    public static void b(q qVar, String str, String str2) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_msg", str2);
            jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        b(System.currentTimeMillis(), qVar, str, "show_error", jSONObject);
    }

    public static void a(q qVar) {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.c(com.bytedance.sdk.openadsdk.core.o.a()))) {
            return;
        }
        com.bytedance.sdk.openadsdk.d.p.d.a(com.bytedance.sdk.openadsdk.q.a.a(qVar.E0(), true));
    }

    @JProtect
    public static void b(q qVar, String str, z zVar) {
        if (qVar == null) {
            return;
        }
        a(new n("sendLoadDuration", zVar.d(), str, System.currentTimeMillis(), qVar));
    }

    @JProtect
    public static void a(String str, q qVar, String str2, com.bytedance.sdk.openadsdk.d.g gVar) {
        if (qVar == null || gVar == null || !gVar.b()) {
            return;
        }
        a(new g("adShowTimeReport", str, gVar, System.currentTimeMillis(), qVar, str2));
    }

    public static void b() {
        b.b.a.a.k.e.c(new e("showFailLog"));
    }

    public static void b(q qVar, String str, int i2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i2);
        } catch (JSONException unused) {
        }
        b(qVar, str, "open_ad_land_page_links", jSONObject);
    }

    public static void a(q qVar, String str, z zVar) {
        if (qVar == null) {
            return;
        }
        a(new h("adBackShowTimeReport", zVar.d(), zVar, qVar, str));
    }

    public static void a(q qVar, String str, long j2) {
        if (qVar == null) {
            return;
        }
        a(new i("adClickShowTimeReport", j2, qVar, str));
    }

    public static void a(q qVar, String str, long j2, boolean z) {
        a(new j("onLpLoading", qVar, z, j2, str));
    }

    @JProtect
    public static void a(String str, q qVar, com.bytedance.sdk.openadsdk.core.f0.i iVar, String str2, boolean z, Map<String, Object> map, int i2) {
        a(new l("onClick", qVar, iVar, z, i2, map, System.currentTimeMillis(), str2, str));
    }

    public static void a(q qVar, String str, String str2, JSONObject jSONObject) {
        if (qVar == null) {
            return;
        }
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
                if (jSONObject.has("duration")) {
                    jSONObject2.put("duration", jSONObject.get("duration"));
                }
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.m.b("TTAD.AdEvent", e2.getMessage());
            }
            b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
        } else {
            a(System.currentTimeMillis(), qVar, str, str2);
        }
        if ("click".equals(str2)) {
            r.b(qVar);
        }
    }

    public static void a(q qVar, String str, int i2, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("video_choose", i2);
            jSONObject2.put("video_choose_duration", j2);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b(th.toString());
        }
        b(System.currentTimeMillis(), qVar, str, "video_choose", jSONObject);
    }

    public static void a(q qVar, String str, String str2, long j2, int i2, JSONObject jSONObject, com.bytedance.sdk.openadsdk.d.g gVar) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("duration", j2);
            jSONObject2.put("percent", i2);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (("feed_break".equals(str2) || "feed_over".equals(str2)) && gVar != null) {
                gVar.a(jSONObject);
            }
            jSONObject2.put("ad_extra_data", jSONObject.toString());
        } catch (Throwable unused) {
        }
        b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
    }

    public static void a(q qVar, String str, String str2, Map<String, Object> map) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject2.put("dp_creative_type", qVar.G());
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        b(System.currentTimeMillis(), qVar, str, str2, jSONObject);
    }

    @JProtect
    private static void a(long j2, q qVar, String str, String str2) {
        b(j2, qVar, str, str2, new JSONObject());
    }

    public static void a(q qVar, String str, String str2) {
        if (qVar == null) {
            return;
        }
        a(System.currentTimeMillis(), qVar, str, str2);
    }

    public static void a(q qVar, String str) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("reveice_ts", System.currentTimeMillis());
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        b(System.currentTimeMillis(), qVar, str, "bidding_receive", jSONObject);
    }

    public static void a(q qVar, String str, String str2, long j2, JSONObject jSONObject) {
        if (qVar == null || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("duration", j2);
            jSONObject2.put("ad_extra_data", jSONObject.toString());
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("TTAD.AdEvent", e2.getMessage());
        }
        b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
    }

    public static void a(q qVar, String str, String str2, JSONObject jSONObject, long j2) {
        if (qVar == null || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ad_extra_data", jSONObject.toString());
            jSONObject2.put("duration", j2);
        } catch (Throwable unused) {
        }
        b(System.currentTimeMillis(), qVar, str, str2, jSONObject2);
    }

    public static void a(String str, long j2) {
        com.bytedance.sdk.openadsdk.core.e0.c.b(str, j2);
    }

    @JProtect
    public static void a(q qVar, String str, String str2, String str3, long j2, long j3, JSONObject jSONObject) {
        if (qVar == null) {
            return;
        }
        a(new a("sendJsAdEvent", jSONObject, str3, str2, qVar, System.currentTimeMillis(), str, j2, j3));
    }

    public static void a(q qVar, String str, JSONObject jSONObject) {
        if (qVar == null) {
            return;
        }
        a(qVar, str, -1L, jSONObject);
    }

    public static void a(q qVar, String str, long j2, JSONObject jSONObject) {
        if (qVar == null) {
            return;
        }
        a(new b("onAppOpenAd", j2, jSONObject, System.currentTimeMillis(), qVar, str));
    }

    public static void a(AdSlot adSlot) {
        if (adSlot == null) {
            a("");
        } else if (TextUtils.isEmpty(adSlot.getBidAdm())) {
            a(adSlot.getCodeId());
        }
    }

    public static void a(String str) {
        a(new C0223c("sendLastShowAd", str, System.currentTimeMillis()));
    }

    public static void a(b.b.a.a.k.g gVar) {
        if (gVar == null) {
            return;
        }
        if (y.g()) {
            com.bytedance.sdk.component.utils.i.a().post(new d(gVar));
        } else if (!y.f()) {
            y.c(gVar, 10);
        } else {
            gVar.run();
        }
    }

    public static void a(q qVar, String str, int i2, int i3, boolean z) {
        a(qVar, str, i2, i3, z, "");
    }

    public static void a(q qVar, String str, int i2, int i3, boolean z, String str2) {
        if (qVar == null || qVar.e0() != 2) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("count", i2);
            jSONObject2.put("interceptor", i3);
            jSONObject2.put("success", z);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("exception_msg", str2);
            }
            if (i3 == 2 || i3 == 5) {
                jSONObject2.put("meta", qVar.n1().toString());
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        b(System.currentTimeMillis(), qVar, str, "open_browser", jSONObject);
    }

    public static void a(q qVar, String str, int i2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i2);
        } catch (JSONException unused) {
        }
        b(qVar, str, "download_app_ad_track", jSONObject);
    }
}
