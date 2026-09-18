package com.bytedance.sdk.openadsdk.d.r.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import b.a.a.a.a.a.a.f.c;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.d.g;
import com.bytedance.sdk.openadsdk.d.r.b.d;
import com.bytedance.sdk.openadsdk.d.r.b.e;
import com.bytedance.sdk.openadsdk.d.r.b.f;
import com.bytedance.sdk.openadsdk.d.r.b.h;
import com.bytedance.sdk.openadsdk.d.r.b.i;
import com.bytedance.sdk.openadsdk.d.r.b.j;
import com.bytedance.sdk.openadsdk.d.r.b.k;
import com.bytedance.sdk.openadsdk.d.r.b.l;
import com.bytedance.sdk.openadsdk.d.r.b.n;
import com.bytedance.sdk.openadsdk.d.r.b.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VideoEventManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final Map<b.a.a.a.a.a.a.e.a, o> a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.d.r.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VideoEventManager.java */
    static class C0227a implements com.bytedance.sdk.openadsdk.d.q.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.d.r.b.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f747b;
        final /* synthetic */ g c;

        C0227a(com.bytedance.sdk.openadsdk.d.r.b.a aVar, String str, g gVar) {
            this.a = aVar;
            this.f747b = str;
            this.c = gVar;
        }

        @Override // com.bytedance.sdk.openadsdk.d.q.a
        public void a(JSONObject jSONObject) throws JSONException {
            g gVar;
            JSONObject jSONObjectA = this.a.a();
            if (this.a.b() != null) {
                this.a.b().a(jSONObjectA);
            }
            if (("feed_play".equals(this.f747b) || "feed_over".equals(this.f747b) || "feed_break".equals(this.f747b)) && (gVar = this.c) != null) {
                gVar.a(jSONObjectA);
            }
            jSONObject.put("ad_extra_data", jSONObjectA.toString());
        }
    }

    /* JADX INFO: compiled from: VideoEventManager.java */
    static class b implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o.a f748b;
        final /* synthetic */ q c;

        b(c cVar, o.a aVar, q qVar) {
            this.a = cVar;
            this.f748b = aVar;
            this.c = qVar;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("service_duration", a.c(this.a));
            jSONObject.put("player_duration", this.f748b.k());
            jSONObject.put("cache_path_type", CacheDirFactory.getCacheType());
            jSONObject.put("url", this.a.m());
            jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, a.d(this.a));
            jSONObject.put("player_type", this.a.i());
            com.bytedance.sdk.openadsdk.l.c.b bVarH = com.bytedance.sdk.openadsdk.l.c.b.o().h("pangle_video_play_state");
            q qVar = this.c;
            return bVarH.a(qVar != null ? qVar.R() : 0).c(jSONObject.toString());
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.d.r.b.a<k> aVar) {
        a(aVar, "load_video_start");
    }

    public static void d(com.bytedance.sdk.openadsdk.d.r.b.a<l> aVar) {
        a(aVar, "load_video_success");
    }

    public static void e(b.a.a.a.a.a.a.e.a aVar, o.a aVar2) {
        o oVar;
        if (aVar == null || aVar2 == null || (oVar = a.get(aVar)) == null) {
            return;
        }
        c cVarE = oVar.e();
        q qVarA = oVar.a();
        if (cVarE == null || qVarA == null) {
            return;
        }
        long jE = aVar2.e();
        long jK = aVar2.k();
        n nVar = new n(aVar2.f());
        nVar.a(aVar2.d());
        nVar.b(jK);
        JSONObject jSONObjectA = a(qVarA, oVar.d(), oVar.c(), cVarE);
        int i = cVarE.q;
        if (i > 0) {
            try {
                jSONObjectA.put("play_time", i);
            } catch (JSONException e) {
                m.b("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.d.r.b.a aVar3 = new com.bytedance.sdk.openadsdk.d.r.b.a(qVarA, a0.a(qVarA), jSONObjectA, nVar);
        aVar3.a(aVar2.m());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jE);
            jSONObject.put("percent", aVar2.g());
            a(aVar3, "play_error", jSONObject);
        } catch (JSONException e2) {
            m.b("TTAD.VideoEventManager", "", e2);
        }
        a.remove(aVar);
    }

    public static JSONObject a(q qVar, String str, int i, c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (qVar != null) {
                b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
                if (bVarN0 != null) {
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, bVarN0.n());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(bVarN0.p()));
                    jSONObject.put("video_url", bVarN0.t());
                    jSONObject.put("player_type", cVar.i());
                    jSONObject.put("video_encode_type", cVar.t() ? 1 : 0);
                }
                jSONObject.put("dp_creative_type", qVar.G());
            }
        } catch (JSONException e) {
            m.b("TTAD.VideoEventManager", "", e);
        }
        return jSONObject;
    }

    public static void b(com.bytedance.sdk.openadsdk.d.r.b.a<j> aVar) {
        a(aVar, "load_video_error");
    }

    public static void c(b.a.a.a.a.a.a.e.a aVar, o.a aVar2) {
        o oVar;
        if (aVar == null || aVar2 == null || (oVar = a.get(aVar)) == null) {
            return;
        }
        c cVarE = oVar.e();
        q qVarA = oVar.a();
        if (cVarE == null || qVarA == null) {
            return;
        }
        long jE = aVar2.e();
        long jK = aVar2.k();
        if (jK <= 0 || jE <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.d.r.b.g gVar = new com.bytedance.sdk.openadsdk.d.r.b.g();
        gVar.a(aVar2.d());
        gVar.b(jK);
        JSONObject jSONObjectA = a(qVarA, oVar.d(), oVar.c(), cVarE);
        int i = cVarE.q;
        if (i > 0) {
            try {
                jSONObjectA.put("play_time", i);
            } catch (JSONException e) {
                m.b("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.d.r.b.a aVar3 = new com.bytedance.sdk.openadsdk.d.r.b.a(qVarA, a0.a(qVarA), jSONObjectA, gVar);
        aVar3.a(aVar2.m());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jE);
            jSONObject.put("percent", aVar2.g());
            a(aVar3, "feed_pause", jSONObject);
        } catch (JSONException e2) {
            m.b("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void d(b.a.a.a.a.a.a.e.a aVar, o.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return;
        }
        if (aVar2.c() <= 0) {
            m.d("TTAD.VideoEventManager", "Cancel log report when buffer count is 0");
            return;
        }
        o oVar = a.get(aVar);
        if (oVar == null) {
            return;
        }
        c cVarE = oVar.e();
        q qVarA = oVar.a();
        if (cVarE == null || qVarA == null) {
            return;
        }
        long jK = aVar2.k();
        com.bytedance.sdk.openadsdk.d.r.b.m mVar = new com.bytedance.sdk.openadsdk.d.r.b.m();
        mVar.a(aVar2.d());
        mVar.b(jK);
        mVar.a(aVar2.c());
        JSONObject jSONObjectA = a(qVarA, oVar.d(), oVar.c(), cVarE);
        int i = cVarE.q;
        if (i > 0) {
            try {
                jSONObjectA.put("play_time", i);
            } catch (JSONException e) {
                m.b("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.d.r.b.a aVar3 = new com.bytedance.sdk.openadsdk.d.r.b.a(qVarA, a0.a(qVarA), jSONObjectA, mVar);
        aVar3.a(aVar2.m());
        a(aVar3, "play_buffer");
    }

    public static void b(b.a.a.a.a.a.a.e.a aVar, o.a aVar2) {
        o oVar;
        if (aVar == null || aVar2 == null || (oVar = a.get(aVar)) == null) {
            return;
        }
        c cVarE = oVar.e();
        q qVarA = oVar.a();
        if (cVarE == null || qVarA == null) {
            return;
        }
        long jE = aVar2.e();
        long jK = aVar2.k();
        if (jK <= 0 || jE <= 0) {
            return;
        }
        e eVar = new e();
        eVar.a(aVar2.d());
        eVar.b(jK);
        JSONObject jSONObjectA = a(qVarA, oVar.d(), oVar.c(), cVarE);
        int i = cVarE.q;
        if (i > 0) {
            try {
                jSONObjectA.put("play_time", i);
            } catch (JSONException e) {
                m.b("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.d.r.b.a aVar3 = new com.bytedance.sdk.openadsdk.d.r.b.a(qVarA, a0.a(qVarA), jSONObjectA, eVar);
        aVar3.a(aVar2.m());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jE);
            jSONObject.put("percent", aVar2.g());
            a(aVar3, "feed_continue", jSONObject);
        } catch (JSONException e2) {
            m.b("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.d.r.b.a<i> aVar) {
        a(aVar, "load_video_cancel");
    }

    public static void a(q qVar, b.a.a.a.a.a.a.e.a aVar, c cVar) {
        if (qVar == null || aVar == null || cVar == null) {
            return;
        }
        String strA = com.bytedance.sdk.openadsdk.utils.q.a();
        int i = CacheDirFactory.getICacheDir(qVar.u0()).a(cVar) ? 1 : 2;
        a.put(aVar, new o(SystemClock.elapsedRealtime(), strA, i, cVar, qVar));
        JSONObject jSONObjectA = a(qVar, strA, i, cVar);
        String strA2 = a0.a(qVar);
        int i2 = cVar.q;
        if (i2 > 0) {
            try {
                jSONObjectA.put("play_time", i2);
            } catch (JSONException e) {
                m.b("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.d.r.b.a aVar2 = new com.bytedance.sdk.openadsdk.d.r.b.a(qVar, strA2, jSONObjectA, null);
        aVar2.a(cVar.i() == -1);
        a(aVar2, "play_start");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(c cVar) {
        return new File(cVar.b(), cVar.e()).getAbsolutePath();
    }

    public static void a(Context context, b.a.a.a.a.a.a.e.a aVar, o.a aVar2, g gVar) {
        o oVar;
        if (context == null || aVar == null || aVar2 == null || (oVar = a.get(aVar)) == null) {
            return;
        }
        c cVarE = oVar.e();
        q qVarA = oVar.a();
        if (cVarE == null || qVarA == null) {
            return;
        }
        if (!aVar2.m()) {
            a(qVarA, cVarE, aVar2);
        }
        h hVar = new h();
        hVar.a(aVar2.l() ? 1 : 0);
        hVar.a(CacheDirFactory.getICacheDir(qVarA.u0()).b(cVarE));
        hVar.b(SystemClock.elapsedRealtime() - oVar.b());
        JSONObject jSONObjectA = a(qVarA, oVar.d(), oVar.c(), cVarE);
        int i = cVarE.q;
        if (i > 0) {
            try {
                jSONObjectA.put("play_time", i);
            } catch (JSONException e) {
                m.b("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.d.r.b.a aVar3 = new com.bytedance.sdk.openadsdk.d.r.b.a(qVarA, a0.a(qVarA), jSONObjectA, hVar);
        aVar3.a(aVar2.m());
        a(aVar3, "feed_play", gVar);
    }

    public static void b(b.a.a.a.a.a.a.e.a aVar, o.a aVar2, g gVar) {
        if (aVar == null || aVar2 == null) {
            return;
        }
        d(aVar, aVar2);
        o oVar = a.get(aVar);
        if (oVar == null) {
            return;
        }
        c cVarE = oVar.e();
        q qVarA = oVar.a();
        if (cVarE == null || qVarA == null) {
            return;
        }
        long jE = aVar2.e();
        long jK = aVar2.k();
        f fVar = new f();
        fVar.a(aVar2.d());
        fVar.b(jK);
        fVar.a(aVar2.j());
        JSONObject jSONObjectA = a(qVarA, oVar.d(), oVar.c(), cVarE);
        int i = cVarE.q;
        if (i > 0) {
            try {
                jSONObjectA.put("play_time", i);
            } catch (JSONException e) {
                m.b("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.d.r.b.a aVar3 = new com.bytedance.sdk.openadsdk.d.r.b.a(qVarA, a0.a(qVarA), jSONObjectA, fVar);
        aVar3.a(aVar2.m());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jE);
            jSONObject.put("percent", aVar2.g());
            a(aVar3, "feed_over", jSONObject, gVar);
        } catch (JSONException e2) {
            m.b("TTAD.VideoEventManager", "", e2);
        }
        a.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c(c cVar) {
        if (cVar == null) {
            return 0L;
        }
        b.a.a.a.a.a.a.f.b bVarO = cVar.t() ? cVar.o() : cVar.n();
        if (bVarO != null) {
            return Double.valueOf(bVarO.s() * 1000.0d).longValue();
        }
        return 0L;
    }

    public static void a(b.a.a.a.a.a.a.e.a aVar, o.a aVar2) {
        o oVar;
        if (aVar == null || aVar2 == null || (oVar = a.get(aVar)) == null) {
            return;
        }
        c cVarE = oVar.e();
        q qVarA = oVar.a();
        if (cVarE == null || qVarA == null) {
            return;
        }
        long jE = aVar2.e();
        long jK = aVar2.k();
        com.bytedance.sdk.openadsdk.d.r.b.b bVar = new com.bytedance.sdk.openadsdk.d.r.b.b();
        bVar.a(aVar2.d());
        bVar.b(jK);
        bVar.b(aVar2.i());
        bVar.a(aVar2.h());
        com.bytedance.sdk.openadsdk.d.r.b.a aVar3 = new com.bytedance.sdk.openadsdk.d.r.b.a(qVarA, a0.a(qVarA), a(qVarA, oVar.d(), oVar.c(), cVarE), bVar);
        aVar3.a(aVar2.m());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jE);
            jSONObject.put("percent", aVar2.g());
            a(aVar3, "endcard_skip", jSONObject);
        } catch (JSONException e) {
            m.b("TTAD.VideoEventManager", "", e);
        }
    }

    public static void a(b.a.a.a.a.a.a.e.a aVar, o.a aVar2, g gVar) {
        o oVar;
        if (aVar == null || aVar2 == null || (oVar = a.get(aVar)) == null) {
            return;
        }
        c cVarE = oVar.e();
        q qVarA = oVar.a();
        if (cVarE == null || qVarA == null) {
            return;
        }
        long jE = aVar2.e();
        long jK = aVar2.k();
        d dVar = new d();
        dVar.a(aVar2.d());
        dVar.b(jK);
        dVar.a(aVar2.b());
        dVar.b(aVar2.j());
        JSONObject jSONObjectA = a(qVarA, oVar.d(), oVar.c(), cVarE);
        int i = cVarE.q;
        if (i > 0) {
            try {
                jSONObjectA.put("play_time", i);
            } catch (JSONException e) {
                m.b("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.d.r.b.a aVar3 = new com.bytedance.sdk.openadsdk.d.r.b.a(qVarA, a0.a(qVarA), jSONObjectA, dVar);
        aVar3.a(aVar2.m());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jE);
            jSONObject.put("percent", aVar2.g());
            a(aVar3, "feed_break", jSONObject, gVar);
        } catch (JSONException e2) {
            m.b("TTAD.VideoEventManager", "", e2);
        }
    }

    private static void a(com.bytedance.sdk.openadsdk.d.r.b.a aVar, String str) {
        a(aVar, str, (JSONObject) null, (g) null);
    }

    private static void a(com.bytedance.sdk.openadsdk.d.r.b.a aVar, String str, JSONObject jSONObject) {
        a(aVar, str, jSONObject, (g) null);
    }

    private static void a(com.bytedance.sdk.openadsdk.d.r.b.a aVar, String str, g gVar) {
        a(aVar, str, (JSONObject) null, gVar);
    }

    private static void a(com.bytedance.sdk.openadsdk.d.r.b.a aVar, String str, JSONObject jSONObject, g gVar) {
        if (aVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObject;
        if (aVar.e() && !TextUtils.isEmpty(aVar.d())) {
            String strD = aVar.d();
            strD.hashCode();
            if (strD.equals("stream") || strD.equals("embeded_ad")) {
                str = "customer_" + str;
            }
        }
        String str2 = str;
        com.bytedance.sdk.openadsdk.d.c.a(System.currentTimeMillis(), aVar.c(), aVar.d(), str2, jSONObject2, gVar, new C0227a(aVar, str2, gVar));
    }

    private static void a(q qVar, c cVar, o.a aVar) {
        com.bytedance.sdk.openadsdk.l.b.a();
        com.bytedance.sdk.openadsdk.l.b.a("pangle_video_play_state", false, (com.bytedance.sdk.openadsdk.l.a) new b(cVar, aVar, qVar));
    }
}
