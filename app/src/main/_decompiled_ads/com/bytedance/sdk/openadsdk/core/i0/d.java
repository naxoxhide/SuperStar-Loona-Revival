package com.bytedance.sdk.openadsdk.core.i0;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VideoTrackers.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private com.bytedance.sdk.openadsdk.core.i0.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> f601b = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> c = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> d = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> e = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> f = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> g = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> h = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> i = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> j = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> k = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.b> l = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.i0.l.a> m = new ArrayList();
    private final AtomicBoolean n = new AtomicBoolean(false);
    private final AtomicBoolean o = new AtomicBoolean(false);
    private long p;
    private q q;
    private boolean r;
    private boolean s;
    private boolean t;
    private String u;

    /* JADX INFO: compiled from: VideoTrackers.java */
    class a implements Runnable {
        final /* synthetic */ f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f602b;

        a(d dVar, f fVar, int i) {
            this.a = fVar;
            this.f602b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = this.a;
            if (fVar != null) {
                fVar.a(this.f602b);
            }
        }
    }

    public d(com.bytedance.sdk.openadsdk.core.i0.a aVar) {
        this.a = aVar;
    }

    public void a(com.bytedance.sdk.openadsdk.core.i0.k.a aVar) {
        a(-1L, this.f601b, aVar);
    }

    public void b(long j) {
        if (this.o.compareAndSet(false, true)) {
            a(j, this.g, (com.bytedance.sdk.openadsdk.core.i0.k.a) null);
        }
    }

    public void c(long j) {
        a(j, this.f, null, new com.bytedance.sdk.openadsdk.core.i0.l.c.e("video_progress", this.q, 1.0f));
    }

    public void d(long j) {
        if (this.n.compareAndSet(false, true)) {
            a(j, this.c, null, new com.bytedance.sdk.openadsdk.core.i0.l.c.e("show_impression", this.q));
        }
    }

    public void e(long j) {
        a(j, this.j, (com.bytedance.sdk.openadsdk.core.i0.k.a) null);
    }

    public void f(long j) {
        a(j, this.d, (com.bytedance.sdk.openadsdk.core.i0.k.a) null);
    }

    public void g(long j) {
        a(j, this.e, (com.bytedance.sdk.openadsdk.core.i0.k.a) null);
    }

    public void h(long j) {
        a(j, this.h, (com.bytedance.sdk.openadsdk.core.i0.k.a) null);
    }

    public void i(long j) {
        a(j, this.k, (com.bytedance.sdk.openadsdk.core.i0.k.a) null);
    }

    public void j(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.e.addAll(list);
    }

    public void k(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.h.addAll(list);
    }

    public void l(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.k.addAll(list);
    }

    public void a(long j) {
        a(j, this.i, null, new com.bytedance.sdk.openadsdk.core.i0.l.c.e("click", this.q));
    }

    public void c(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.g.addAll(list);
    }

    public void e(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.f601b.addAll(list);
    }

    public void f(List<com.bytedance.sdk.openadsdk.core.i0.l.b> list) {
        this.l.addAll(list);
        Collections.sort(this.l);
    }

    public void g(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.c.addAll(list);
    }

    public void h(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.j.addAll(list);
    }

    public void i(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.d.addAll(list);
    }

    public void a(long j, long j2, f fVar) {
        if (System.currentTimeMillis() - this.p >= 1000 && j >= 0 && j2 > 0) {
            this.p = System.currentTimeMillis();
            float f = j / j2;
            List<com.bytedance.sdk.openadsdk.core.i0.l.c> listA = a(j, f);
            if (f >= 0.25f && !this.r) {
                a(TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE);
                this.r = true;
                if (fVar != null) {
                    a(fVar, 6);
                }
                f = 0.25f;
            } else if (f >= 0.5f && !this.s) {
                a("midpoint");
                this.s = true;
                if (fVar != null) {
                    a(fVar, 7);
                }
                f = 0.5f;
            } else if (f >= 0.75f && !this.t) {
                a(TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE);
                this.t = true;
                if (fVar != null) {
                    a(fVar, 8);
                }
                f = 0.75f;
            }
            if (f < 0.03f) {
                f = 0.0f;
            }
            a(j, listA, null, new com.bytedance.sdk.openadsdk.core.i0.l.c.e("video_progress", this.q, f));
        }
    }

    public void b(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.i.addAll(list);
    }

    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.f601b));
        jSONObject.put("impressionTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.c));
        jSONObject.put("pauseTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.d));
        jSONObject.put("resumeTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.e));
        jSONObject.put("completeTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.f));
        jSONObject.put("closeTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.g));
        jSONObject.put("skipTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.h));
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.i));
        jSONObject.put("muteTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.j));
        jSONObject.put("unMuteTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.k));
        jSONObject.put("fractionalTrackers", b());
        jSONObject.put("absoluteTrackers", a());
        return jSONObject;
    }

    public void d(List<com.bytedance.sdk.openadsdk.core.i0.l.c> list) {
        this.f.addAll(list);
    }

    private JSONArray b() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.i0.l.b> it = this.l.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().h());
        }
        return jSONArray;
    }

    public void b(String str) {
        this.u = str;
    }

    private void a(f fVar, int i) {
        com.bytedance.sdk.component.utils.i.b().post(new a(this, fVar, i));
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", str);
            com.bytedance.sdk.openadsdk.d.c.b(this.q, this.u, "vast_play_track", jSONObject);
        } catch (Throwable unused) {
        }
    }

    private void a(long j, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list, com.bytedance.sdk.openadsdk.core.i0.k.a aVar, com.bytedance.sdk.openadsdk.core.i0.l.c.e eVar) {
        com.bytedance.sdk.openadsdk.core.i0.a aVar2 = this.a;
        com.bytedance.sdk.openadsdk.core.i0.l.c.a(list, aVar, j, aVar2 != null ? aVar2.n() : null, eVar);
    }

    private void a(long j, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list, com.bytedance.sdk.openadsdk.core.i0.k.a aVar) {
        a(j, list, aVar, null);
    }

    public List<com.bytedance.sdk.openadsdk.core.i0.l.c> a(long j, float f) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.l.size(); i++) {
            com.bytedance.sdk.openadsdk.core.i0.l.b bVar = this.l.get(i);
            if (bVar.a(f)) {
                arrayList.add(bVar);
            }
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            com.bytedance.sdk.openadsdk.core.i0.l.a aVar = this.m.get(i2);
            if (aVar.a(j)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public void a(List<com.bytedance.sdk.openadsdk.core.i0.l.a> list) {
        this.m.addAll(list);
        Collections.sort(this.m);
    }

    private JSONArray a() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.i0.l.a> it = this.m.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().h());
        }
        return jSONArray;
    }

    public void a(JSONObject jSONObject) {
        e(com.bytedance.sdk.openadsdk.core.i0.l.c.c(jSONObject.optJSONArray("errorTrackers")));
        g(com.bytedance.sdk.openadsdk.core.i0.l.c.c(jSONObject.optJSONArray("impressionTrackers")));
        i(com.bytedance.sdk.openadsdk.core.i0.l.c.a(jSONObject.optJSONArray("pauseTrackers"), true));
        j(com.bytedance.sdk.openadsdk.core.i0.l.c.a(jSONObject.optJSONArray("resumeTrackers"), true));
        d(com.bytedance.sdk.openadsdk.core.i0.l.c.c(jSONObject.optJSONArray("completeTrackers")));
        c(com.bytedance.sdk.openadsdk.core.i0.l.c.c(jSONObject.optJSONArray("closeTrackers")));
        k(com.bytedance.sdk.openadsdk.core.i0.l.c.c(jSONObject.optJSONArray("skipTrackers")));
        b(com.bytedance.sdk.openadsdk.core.i0.l.c.c(jSONObject.optJSONArray("clickTrackers")));
        h(com.bytedance.sdk.openadsdk.core.i0.l.c.a(jSONObject.optJSONArray("muteTrackers"), true));
        l(com.bytedance.sdk.openadsdk.core.i0.l.c.a(jSONObject.optJSONArray("unMuteTrackers"), true));
        f(com.bytedance.sdk.openadsdk.core.i0.l.c.b(jSONObject.optJSONArray("fractionalTrackers")));
        a(com.bytedance.sdk.openadsdk.core.i0.l.c.a(jSONObject.optJSONArray("absoluteTrackers")));
    }

    public void a(q qVar) {
        this.q = qVar;
    }

    public void a(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        a(Collections.singletonList(new com.bytedance.sdk.openadsdk.core.i0.l.a.C0201a(str, j).a()));
    }

    public void a(String str, float f) {
        if (TextUtils.isEmpty(str) || f < 0.0f) {
            return;
        }
        f(Collections.singletonList(new com.bytedance.sdk.openadsdk.core.i0.l.b.C0202b(str, f).a()));
    }

    public void a(d dVar) {
        e(dVar.f601b);
        g(dVar.c);
        i(dVar.d);
        j(dVar.e);
        d(dVar.f);
        c(dVar.g);
        k(dVar.h);
        b(dVar.i);
        h(dVar.j);
        l(dVar.k);
        f(dVar.l);
        a(dVar.m);
    }
}
