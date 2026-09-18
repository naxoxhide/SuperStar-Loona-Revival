package com.mbridge.msdk.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MBridgeTrackManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, m> f2045b = new ConcurrentHashMap<>();
    private final k a;

    private m(String str, Context context, w wVar) {
        k kVar = new k(str, this);
        this.a = kVar;
        kVar.a(context);
        kVar.a(wVar);
    }

    public static m a(String str, Context context, w wVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, m> concurrentHashMap = f2045b;
        m mVar = concurrentHashMap.get(str);
        if (!y.a(mVar)) {
            return mVar;
        }
        m mVar2 = new m(str, context, wVar);
        concurrentHashMap.put(str, mVar2);
        return mVar2;
    }

    public final String b() {
        return this.a.b();
    }

    public final String c() {
        return this.a.c();
    }

    public static m[] d() {
        ConcurrentHashMap<String, m> concurrentHashMap = f2045b;
        m[] mVarArr = new m[concurrentHashMap.size()];
        int i = 0;
        try {
            Iterator<Map.Entry<String, m>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                mVarArr[i] = it.next().getValue();
                i++;
            }
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "getAllTrackManager error", e);
            }
        }
        return mVarArr;
    }

    public final void e() {
        try {
            this.a.h().a(new Runnable() { // from class: com.mbridge.msdk.e.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        t.a().c();
                        m.this.a.n().b();
                    } catch (Exception e) {
                        if (a.a) {
                            Log.e("TrackManager", "flush error", e);
                        }
                    }
                }
            });
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "flush error", e);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        this.a.a(jSONObject);
    }

    public final boolean a(String str) {
        return b(new e(str));
    }

    private boolean b(e eVar) {
        try {
            return c(eVar);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(e eVar) {
        if (y.a(eVar) || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        return this.a.a(eVar);
    }

    public final void a(final e eVar) {
        if (this.a.q()) {
            if (a.a) {
                Log.d("TrackManager", "SDK is shutdown, track event will not be processed");
                return;
            }
            return;
        }
        try {
            this.a.h().a(new Runnable() { // from class: com.mbridge.msdk.e.m.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (m.this.c(eVar)) {
                        m.this.a.g().a(eVar);
                        eVar.c(m.this.a.d().f);
                        JSONObject jSONObjectD = eVar.d();
                        if (jSONObjectD != null) {
                            try {
                                jSONObjectD.put("session_id", m.this.b());
                                long[] jArrF = m.this.f();
                                jSONObjectD.put("track_time", jArrF[0]);
                                jSONObjectD.put("track_count", jArrF[1]);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            eVar.a(jSONObjectD);
                        }
                        m.this.a.g().b(eVar);
                    }
                }
            });
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "trackEvent error", e);
            }
        }
    }

    public final long[] f() {
        return this.a.g().a();
    }

    public final String a() {
        if (!this.a.q()) {
            if (a.a) {
                Log.e("TrackManager", "MBridgeTrackManager is already running");
            }
            return this.a.b();
        }
        return this.a.a();
    }
}
