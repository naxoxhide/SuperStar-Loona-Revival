package com.mbridge.msdk.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: Global.java */
/* JADX INFO: loaded from: classes4.dex */
class k {
    private static x a = null;
    private static String o = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2044b;
    private final m c;
    private Context d;
    private w e;
    private JSONObject f;
    private List<String> g;
    private List<String> h;
    private volatile c i;
    private volatile l j;
    private volatile d k;
    private volatile j l;
    private volatile r m;
    private volatile boolean n = true;
    private n p;

    k(String str, m mVar) {
        this.f2044b = str;
        this.c = mVar;
    }

    final String a() {
        if (!y.a(this.d) && !y.a(this.e)) {
            try {
                n().a();
                this.n = false;
                if (TextUtils.isEmpty(o)) {
                    o = UUID.randomUUID().toString();
                }
                if (!y.a(a)) {
                    try {
                        a.a(b(), this.f2044b, this.c);
                        t.a().b();
                    } catch (Exception e) {
                        if (a.a) {
                            Log.e("TrackManager", "track manager start exception", e);
                        }
                    }
                }
                return o;
            } catch (Exception e2) {
                if (a.a) {
                    Log.e("TrackManager", "start error", e2);
                }
                this.n = true;
            }
        }
        return "";
    }

    final String b() {
        if (!TextUtils.isEmpty(o)) {
            return o;
        }
        String string = UUID.randomUUID().toString();
        o = string;
        return string;
    }

    final String c() {
        return this.f2044b;
    }

    final void a(Context context) {
        this.d = context;
    }

    final void a(w wVar) {
        this.e = wVar;
    }

    final w d() {
        w wVar = this.e;
        if (wVar != null) {
            return wVar;
        }
        w wVarA = new w.a().a();
        this.e = wVarA;
        return wVarA;
    }

    final void a(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    final JSONObject e() {
        JSONObject jSONObject = this.f;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f = jSONObject2;
        return jSONObject2;
    }

    final c f() {
        String str;
        if (y.a(this.i)) {
            synchronized (k.class) {
                if (y.a(this.i)) {
                    Context context = this.d;
                    if (TextUtils.isEmpty(this.f2044b)) {
                        str = String.format("track_manager_%s.db", "default");
                    } else {
                        str = String.format("track_manager_%s.db", this.f2044b);
                    }
                    this.i = new c(new b(context, str, "event_table"), "event_table");
                }
            }
        }
        return this.i;
    }

    final l g() {
        if (y.a(this.j)) {
            synchronized (k.class) {
                if (y.a(this.j)) {
                    this.j = new p(new g(f(), n(), h()));
                }
            }
        }
        return this.j;
    }

    final j h() {
        if (y.a(this.l)) {
            synchronized (k.class) {
                if (y.a(this.l)) {
                    this.l = new j();
                }
            }
        }
        return this.l;
    }

    final d i() {
        if (y.a(this.k)) {
            this.k = d().h;
        }
        return this.k;
    }

    final m j() {
        return this.c;
    }

    final int k() {
        if (d().a < 0) {
            return 50;
        }
        return d().a;
    }

    final int l() {
        return Math.max(d().f2055b, 0);
    }

    final int m() {
        return Math.max(d().e, 0);
    }

    final r n() {
        if (y.a(this.m)) {
            synchronized (k.class) {
                if (y.a(this.m)) {
                    this.m = new r(this);
                }
            }
        }
        return this.m;
    }

    final boolean a(e eVar) {
        if (y.a(eVar)) {
            return false;
        }
        f fVar = d().j;
        if (y.b(fVar)) {
            try {
                return fVar.a(eVar);
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "event filter apply exception", e);
                }
            }
        }
        String strA = eVar.a();
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        List<String> list = this.h;
        if (list != null) {
            try {
                return !list.contains(strA);
            } catch (Exception e2) {
                if (a.a) {
                    Log.e("TrackManager", "disallowTrackEventNames contains exception", e2);
                }
            }
        }
        List<String> list2 = this.g;
        if (list2 != null) {
            try {
                return list2.contains(strA);
            } catch (Exception e3) {
                if (a.a) {
                    Log.e("TrackManager", "allowTrackEventNames contains exception", e3);
                }
            }
        }
        return true;
    }

    final boolean o() throws IllegalStateException {
        if (y.a(d())) {
            throw new IllegalStateException("config can not be null");
        }
        if (y.a(i())) {
            throw new IllegalStateException("decorate can not be null");
        }
        if (y.a(d().i)) {
            throw new IllegalStateException("responseHandler can not be null");
        }
        if (y.a(d().g) || y.a(d().g.c())) {
            throw new IllegalStateException("networkStackConfig or stack can not be null");
        }
        if (TextUtils.isEmpty(d().g.b())) {
            throw new IllegalStateException("report url is null");
        }
        return true;
    }

    final n p() {
        if (y.a(this.p)) {
            synchronized (k.class) {
                if (y.a(this.p)) {
                    this.p = new n(d().d <= 0 ? 2 : d().d, d().g, d().i, d().c);
                }
            }
        }
        return this.p;
    }

    final boolean q() {
        return this.n;
    }
}
