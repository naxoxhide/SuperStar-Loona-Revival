package com.bytedance.sdk.openadsdk.b.m.p;

import android.R;
import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.f0.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.r;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardFullReportManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private final com.bytedance.sdk.openadsdk.b.m.p.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.OnClickListener f500b;
    private final com.bytedance.sdk.openadsdk.core.c0.e c;

    /* JADX INFO: compiled from: RewardFullReportManager.java */
    class a extends com.bytedance.sdk.openadsdk.core.c0.e {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.m.p.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RewardFullReportManager.java */
        class C0186a implements com.bytedance.sdk.openadsdk.b.m.p.d.a {
            C0186a() {
            }

            @Override // com.bytedance.sdk.openadsdk.b.m.p.d.a
            public void a(String str, JSONObject jSONObject) {
                h.this.a(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.b.m.p.d.a
            public void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, int i, int i2, int i3) {
                h.this.b(view, f, f2, f3, f4, sparseArray, i, i2, i3);
            }
        }

        a(Context context, q qVar, String str, int i) {
            super(context, qVar, str, i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.e
        public void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, int i, int i2, int i3, boolean z) {
            com.bytedance.sdk.component.utils.m.a("TTAD.RFReportManager", "onRewardBarClick , x = " + f);
            if (h.this.a.a.k1() && view != null) {
                Object tag = view.getTag(570425345);
                if (tag instanceof String) {
                    a((String) tag);
                }
            }
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(h.this.a.G.e()));
            if (h.this.a.u.get()) {
                map.put("click_scence", 2);
            } else if (t.h(h.this.a.a)) {
                map.put("click_scence", 3);
            } else {
                map.put("click_scence", 1);
            }
            a(map);
            h.this.a.V.onRewardBarClick(view);
            if (view.getId() == com.bytedance.sdk.openadsdk.utils.h.e1 && t.h(h.this.a.a)) {
                JSONObject jSONObject = new JSONObject();
                if (h.this.a.a.N0() != null) {
                    try {
                        jSONObject.put("playable_url", h.this.a.a.N0().d());
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.m.b("TTAD.RFReportManager", "onRewardBarClick json error", e);
                    }
                }
                com.bytedance.sdk.openadsdk.d.c.b(h.this.a.a, h.this.a.g, "click_playable_download_button_loading", jSONObject);
            }
            h.this.a.H.a(view, f, f2, f3, f4, sparseArray, i, i2, i3, new C0186a());
            com.bytedance.sdk.openadsdk.q.c.e.a(h.this.a.a, 9);
        }
    }

    /* JADX INFO: compiled from: RewardFullReportManager.java */
    class b extends com.bytedance.sdk.openadsdk.core.c0.b {
        b(Context context, q qVar, String str, int i) {
            super(context, qVar, str, i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
        public void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, boolean z) {
            try {
                h.this.b(view, f, f2, f3, f4, sparseArray, this.i, this.g, this.h);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFReportManager", "onClickReport error :" + e.getMessage());
            }
            com.bytedance.sdk.openadsdk.q.c.e.a(h.this.a.a, 9);
        }
    }

    /* JADX INFO: compiled from: RewardFullReportManager.java */
    class c implements Runnable {
        final /* synthetic */ Map a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f501b;

        c(Map map, View view) {
            this.a = map;
            this.f501b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map map;
            if (h.this.a.y.getAndSet(true)) {
                return;
            }
            q qVar = h.this.a.a;
            JSONObject jSONObject = null;
            try {
                jSONObject = this.a != null ? new JSONObject(this.a) : new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", this.f501b.getWidth());
                jSONObject2.put("height", this.f501b.getHeight());
                jSONObject2.put("alpha", this.f501b.getAlpha());
                jSONObject.put("root_view", jSONObject2.toString());
                if ((qVar instanceof r) && ((r) qVar).t1()) {
                    jSONObject.put("choose_one_ad_real_show", true);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFReportManager", "run: ", th);
            }
            com.bytedance.sdk.openadsdk.d.c.b(qVar, h.this.a.g, jSONObject);
            if (h.this.a.V instanceof com.bytedance.sdk.openadsdk.core.j0.c.b) {
                h.this.a.V.b();
            }
            com.bytedance.sdk.openadsdk.q.c.e.a(h.this.a.V.findViewById(R.id.content), qVar, (h.this.a.J == null || (map = this.a) == null || !map.containsKey("dynamic_show_type")) ? false : true ? h.this.a.J.c() : -1);
        }
    }

    /* JADX INFO: compiled from: RewardFullReportManager.java */
    class d implements com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a {
        d() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a
        public long getVideoProgress() {
            return h.this.a.G.e();
        }
    }

    public h(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.a = aVar;
        this.c = new a(aVar.V, aVar.a, aVar.g, aVar.f ? 7 : 5);
        this.f500b = new b(aVar.V, aVar.a, aVar.g, aVar.f ? 7 : 5);
    }

    private boolean d() {
        q qVar = this.a.a;
        return qVar != null && qVar.C() == 1;
    }

    public View.OnClickListener b() {
        return this.f500b;
    }

    public void c(boolean z) {
        q qVar = this.a.a;
        if (qVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.c.b bVarE = com.bytedance.sdk.openadsdk.l.c.b.o().a(z ? 7 : 8).f(String.valueOf(qVar.S())).e(this.a.a.U());
        bVarE.b(this.a.Q.g()).b(this.a.Q.i());
        bVarE.d(this.a.a.N()).a(this.a.a.e());
        com.bytedance.sdk.openadsdk.l.b.a().b(bVarE);
    }

    public com.bytedance.sdk.openadsdk.core.c0.e e() {
        this.c.b(this.a.V.findViewById(R.id.content));
        this.c.a(this.a.V.findViewById(520093713));
        if (this.a.H.a() != null) {
            this.c.a(this.a.H.a());
        }
        this.a.I.a(this.c);
        this.c.a(new d());
        com.bytedance.sdk.openadsdk.component.reward.view.e eVar = this.a.T;
        com.bytedance.sdk.openadsdk.core.c0.e eVar2 = this.c;
        eVar.a(eVar2, eVar2, this.f500b);
        this.a.S.a(this.c);
        return this.c;
    }

    public void f() {
        JSONObject jSONObject = new JSONObject();
        q qVar = this.a.a;
        if ((qVar instanceof r) && ((r) qVar).t1()) {
            try {
                jSONObject.put("choose_one_ad_real_show", true);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.m.b("TTAD.RFReportManager", "reportShow json error", e);
            }
        }
        if (this.a.x.get() && o.b(qVar)) {
            return;
        }
        this.a.x.set(true);
        com.bytedance.sdk.openadsdk.d.c.b(qVar, this.a.g, jSONObject);
        TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
        if (tTBaseVideoActivity instanceof com.bytedance.sdk.openadsdk.core.j0.c.b) {
            tTBaseVideoActivity.b();
        }
        com.bytedance.sdk.openadsdk.q.c.e.a(this.a.V.findViewById(R.id.content), qVar, -1);
    }

    public void g() {
        boolean z;
        com.bytedance.sdk.openadsdk.component.reward.view.c cVar;
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.a.V.l() || (cVar = this.a.J) == null) {
                z = false;
            } else {
                jSONObject.put("dynamic_show_type", cVar.c());
                z = true;
            }
            q qVar = this.a.a;
            if ((qVar instanceof r) && ((r) qVar).t1()) {
                jSONObject.put("choose_one_ad_real_show", true);
            }
            View viewFindViewById = this.a.V.findViewById(R.id.content);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", viewFindViewById.getWidth());
                jSONObject2.put("height", viewFindViewById.getHeight());
                jSONObject2.put("alpha", viewFindViewById.getAlpha());
            } catch (Throwable unused) {
            }
            jSONObject.put("root_view", jSONObject2.toString());
            this.a.x.set(true);
            com.bytedance.sdk.openadsdk.d.c.b(qVar, this.a.g, jSONObject);
            TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
            if (tTBaseVideoActivity instanceof com.bytedance.sdk.openadsdk.core.j0.c.b) {
                tTBaseVideoActivity.b();
            }
            com.bytedance.sdk.openadsdk.q.c.e.a(this.a.V.findViewById(R.id.content), qVar, z ? this.a.J.c() : -1);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.m.b("TTAD.RFReportManager", "reportShowWhenBindVideoAd error", e);
        }
    }

    public void h() {
        JSONObject jSONObject = new JSONObject();
        if (t.h(this.a.a)) {
            this.a.I.a(jSONObject);
        }
        if (this.a.u.get()) {
            int i = 0;
            if (this.a.Q.r()) {
                i = 1;
            } else if (this.a.Q.p()) {
                i = 2;
            }
            try {
                jSONObject.put("endcard_content", i);
            } catch (JSONException unused) {
            }
        }
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        com.bytedance.sdk.openadsdk.d.c.b(aVar.a, aVar.V.a, "click_close", jSONObject);
    }

    public void b(boolean z) {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        if (aVar == null) {
            return;
        }
        if (z || !aVar.x.get() || this.a.r <= 0) {
            this.a.r = SystemClock.elapsedRealtime();
        } else {
            String str = (SystemClock.elapsedRealtime() - this.a.r) + "";
            com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
            com.bytedance.sdk.openadsdk.d.c.a(str, aVar2.a, aVar2.V.a, aVar2.G.b());
            this.a.r = 0L;
        }
        com.bytedance.sdk.openadsdk.q.c.e.a(this.a.a, z ? 4 : 8);
    }

    public void a(Map<String, Object> map) {
        this.a.x.set(true);
        View viewFindViewById = this.a.V.findViewById(R.id.content);
        if (viewFindViewById == null) {
            viewFindViewById = this.a.V.getWindow().getDecorView();
        }
        viewFindViewById.post(new c(map, viewFindViewById));
    }

    private void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, int i, int i2, int i3) {
        if (d()) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
            if (aVar.a == null || view == null) {
                return;
            }
            TTBaseVideoActivity tTBaseVideoActivity = aVar.V;
            int id = view.getId();
            if (id == com.bytedance.sdk.openadsdk.utils.h.e || id == com.bytedance.sdk.openadsdk.utils.h.d || id == com.bytedance.sdk.openadsdk.utils.h.c || id == com.bytedance.sdk.openadsdk.utils.h.f830b || id == com.bytedance.sdk.openadsdk.utils.h.l || id == com.bytedance.sdk.openadsdk.utils.h.q0 || id == com.bytedance.sdk.openadsdk.utils.h.p || id == 520093705 || id == com.bytedance.sdk.openadsdk.utils.h.k || id == 520093707 || id == com.bytedance.sdk.openadsdk.utils.h.g) {
                int iB = b0.b(com.bytedance.sdk.openadsdk.core.o.a());
                com.bytedance.sdk.openadsdk.core.f0.i iVarA = new com.bytedance.sdk.openadsdk.core.f0.i.b().b(f).c(f2).e(f3).f(f4).a(System.currentTimeMillis()).b(0L).c(b0.a(this.a.T.d())).a(b0.a((View) null)).d(b0.c(this.a.T.d())).b(b0.c((View) null)).f(i2).c(i3).e(i).a(sparseArray).d(com.bytedance.sdk.openadsdk.core.h.a().s() ? 1 : 2).b(iB).a(b0.a(com.bytedance.sdk.openadsdk.core.o.a())).d(b0.f(com.bytedance.sdk.openadsdk.core.o.a())).a();
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(this.a.G.e()));
                com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
                com.bytedance.sdk.openadsdk.d.c.a("click_other", aVar2.a, iVarA, aVar2.g, true, (Map<String, Object>) map, -1);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.c0.e c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, int i, int i2, int i3) {
        if (view == null) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
        if (view.getId() == com.bytedance.sdk.openadsdk.utils.h.e) {
            a("click_play_star_level", null);
        } else if (view.getId() != com.bytedance.sdk.openadsdk.utils.h.d && view.getId() != com.bytedance.sdk.openadsdk.utils.h.g) {
            if (view.getId() == com.bytedance.sdk.openadsdk.utils.h.c) {
                a("click_play_source", null);
            } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.h.f830b) {
                a("click_play_logo", null);
            } else if (view.getId() != com.bytedance.sdk.openadsdk.utils.h.l && view.getId() != com.bytedance.sdk.openadsdk.utils.h.q0 && view.getId() != com.bytedance.sdk.openadsdk.utils.h.p) {
                if (view.getId() == 520093705) {
                    a("click_start_play", a());
                } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.h.k) {
                    a("click_video", a());
                } else if (view.getId() == 520093707 || view.getId() == com.bytedance.sdk.openadsdk.utils.h.h) {
                    a("fallback_endcard_click", a());
                }
            } else {
                a("click_start_play_bar", a());
            }
        } else {
            a("click_play_star_nums", null);
        }
        a(view, f, f2, f3, f4, sparseArray, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        q qVar = aVar.a;
        String str2 = aVar.g;
        if (!aVar.f) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.d.c.a(qVar, str2, str, jSONObject);
    }

    private JSONObject a() {
        try {
            long jL = this.a.G.l();
            int iJ = this.a.G.j();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jL);
                jSONObject.put("percent", iJ);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void a(boolean z) {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        if (aVar != null && z && aVar.a.Q0() && !this.a.a.R0()) {
            this.a.a.b(true);
            com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
            q qVar = aVar2.a;
            com.bytedance.sdk.openadsdk.d.c.a(qVar, aVar2.g, qVar.t());
        }
    }
}
