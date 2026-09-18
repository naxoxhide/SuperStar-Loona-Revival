package com.bytedance.sdk.openadsdk.core.i0.l;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.facebook.internal.security.CertificateUtil;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: VastTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static final Map<String, e> d = new ConcurrentHashMap();
    private static final AtomicBoolean e = new AtomicBoolean(false);
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f620b;
    private boolean c;

    /* JADX INFO: compiled from: VastTracker.java */
    static class a implements w.b {
        a() {
        }

        @Override // com.bytedance.sdk.component.utils.w.b
        public void a(Context context, Intent intent, boolean z, int i) {
            if (i == 0 || c.d.size() <= 0) {
                return;
            }
            c.g();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.i0.l.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VastTracker.java */
    static class C0203c extends g {
        final /* synthetic */ e c;
        final /* synthetic */ boolean d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ boolean g;
        final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0203c(String str, e eVar, boolean z, String str2, String str3, boolean z2, String str4) {
            super(str);
            this.c = eVar;
            this.d = z;
            this.e = str2;
            this.f = str3;
            this.g = z2;
            this.h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.c.a);
                jSONObject.put("success", this.d);
                if (!TextUtils.isEmpty(this.e)) {
                    jSONObject.put("description", this.e);
                }
                jSONObject.put("url", this.f);
                float f = this.c.c;
                if (f >= 0.0f) {
                    jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, ((double) Math.round(f * 100.0f)) / 100.0d);
                }
                if (this.g) {
                    jSONObject.put(TapjoyConstants.TJC_RETRY, true);
                }
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.c.f623b, this.h, "dsp_track_link_result", jSONObject);
        }
    }

    /* JADX INFO: compiled from: VastTracker.java */
    public static class d {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f f622b = f.TRACKING_URL;
        private boolean c = false;

        public d(String str) {
            this.a = str;
        }

        public d a(boolean z) {
            this.c = z;
            return this;
        }

        public c a() {
            return new c(this.a, this.f622b, Boolean.valueOf(this.c));
        }
    }

    /* JADX INFO: compiled from: VastTracker.java */
    public static class e {
        String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        q f623b;
        float c;

        public e(String str, q qVar) {
            this(str, qVar, -1.0f);
        }

        public e(String str, q qVar, float f) {
            this.a = str;
            this.f623b = qVar;
            this.c = f;
        }
    }

    /* JADX INFO: compiled from: VastTracker.java */
    enum f {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    static {
        w.a(new a(), o.a());
    }

    protected c(String str, f fVar, Boolean bool) {
        this.a = str;
        this.f620b = bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        if (e.compareAndSet(false, true)) {
            Map<String, e> map = d;
            HashSet<Map.Entry> hashSet = new HashSet(map.entrySet());
            map.clear();
            for (Map.Entry entry : hashSet) {
                if (entry != null) {
                    a((String) entry.getKey(), (e) entry.getValue(), true);
                }
            }
            e.set(false);
        }
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.f620b;
    }

    public boolean e() {
        return this.c;
    }

    public void f() {
        this.c = true;
    }

    public static List<String> b(List<c> list, com.bytedance.sdk.openadsdk.core.i0.k.a aVar, long j, String str) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (c cVar : list) {
            if (cVar != null && (!cVar.e() || cVar.d())) {
                arrayList.add(cVar.c());
                cVar.f();
            }
        }
        return new com.bytedance.sdk.openadsdk.core.i0.m.c(arrayList).a(aVar).b(j).a(str).b();
    }

    public static List<c> c(JSONArray jSONArray) {
        return a(jSONArray, false);
    }

    public static void a(List<c> list, com.bytedance.sdk.openadsdk.core.i0.k.a aVar, long j, String str, e eVar) {
        a(b(list, aVar, j, str), eVar);
    }

    public static void a(List<c> list, com.bytedance.sdk.openadsdk.core.i0.k.a aVar, long j, String str) {
        a(list, aVar, j, str, null);
    }

    public static void a(List<String> list, e eVar) {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                a(str, eVar, false);
            }
        }
    }

    private static void a(String str, e eVar, boolean z) {
        b.b.a.a.j.d.b bVarB = com.bytedance.sdk.openadsdk.n.c.b().d().b();
        if (bVarB == null) {
            return;
        }
        bVarB.a(true);
        bVarB.b(str);
        bVarB.a(new b(eVar, z, str));
    }

    public static JSONArray a(List<c> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i).c());
        }
        return jSONArray;
    }

    /* JADX INFO: compiled from: VastTracker.java */
    static class b extends b.b.a.a.j.c.a {
        final /* synthetic */ e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f621b;
        final /* synthetic */ String c;

        b(e eVar, boolean z, String str) {
            this.a = eVar;
            this.f621b = z;
            this.c = str;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            e eVar = this.a;
            if (eVar == null || eVar.f623b == null) {
                return;
            }
            boolean z = false;
            String str = null;
            if (bVar != null && bVar.g()) {
                z = true;
            } else if (bVar != null) {
                str = bVar.b() + CertificateUtil.DELIMITER + bVar.f();
                if (!this.f621b && (bVar.b() <= 300 || bVar.b() >= 400)) {
                    c.d.put(this.c, this.a);
                }
            }
            c.b(z, str, a0.d(this.a.f623b.R()), this.a, this.c, this.f621b);
            if (bVar == null || bVar.b() != 200 || c.d.size() <= 0) {
                return;
            }
            c.g();
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            q qVar;
            e eVar = this.a;
            if (eVar != null && (qVar = eVar.f623b) != null) {
                c.b(false, iOException != null ? iOException.getMessage() : null, a0.d(qVar.R()), this.a, this.c, this.f621b);
            }
            if (this.f621b || this.a == null) {
                return;
            }
            c.d.put(this.c, this.a);
        }
    }

    public static List<c> a(JSONArray jSONArray, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(new d(strOptString).a(z).a());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, String str, String str2, e eVar, String str3, boolean z2) {
        com.bytedance.sdk.openadsdk.d.c.a(new C0203c("dsp_track_link_result", eVar, z, str, str3, z2, str2));
    }

    public static List<com.bytedance.sdk.openadsdk.core.i0.l.b> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new com.bytedance.sdk.openadsdk.core.i0.l.b.C0202b(jSONObjectOptJSONObject.optString("content"), (float) jSONObjectOptJSONObject.optDouble("trackingFraction", 0.0d)).a());
                }
            }
        }
        return arrayList;
    }

    public static List<com.bytedance.sdk.openadsdk.core.i0.l.a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new com.bytedance.sdk.openadsdk.core.i0.l.a.C0201a(jSONObjectOptJSONObject.optString("content"), jSONObjectOptJSONObject.optLong("trackingMilliseconds", 0L)).a());
                }
            }
        }
        return arrayList;
    }
}
