package com.bytedance.sdk.openadsdk.core.i0;

import com.bytedance.sdk.openadsdk.core.f0.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VastResource.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    protected int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f600b;
    protected com.bytedance.sdk.openadsdk.core.i0.m.a.c c;
    protected com.bytedance.sdk.openadsdk.core.i0.m.a.d d;
    protected String e;
    protected List<com.bytedance.sdk.openadsdk.core.i0.l.c> f;
    protected List<com.bytedance.sdk.openadsdk.core.i0.l.c> g;
    protected String h;
    private String i;
    private AtomicBoolean j = new AtomicBoolean(false);
    protected String k = "endcard_click";
    private q l;

    /* JADX INFO: compiled from: VastResource.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.core.i0.m.a.d.values().length];
            a = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.core.i0.m.a.d.STATIC_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.bytedance.sdk.openadsdk.core.i0.m.a.d.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.bytedance.sdk.openadsdk.core.i0.m.a.d.IFRAME_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public c(int i, int i2, com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar, com.bytedance.sdk.openadsdk.core.i0.m.a.d dVar, String str, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list2, String str2) {
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.a = i;
        this.f600b = i2;
        this.c = cVar;
        this.d = dVar;
        this.e = str;
        this.f = list;
        this.g = list2;
        this.h = str2;
    }

    public void a(long j) {
        com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.f, null, j, this.i, new com.bytedance.sdk.openadsdk.core.i0.l.c.e(this.k, this.l));
    }

    public int b() {
        return this.f600b;
    }

    public String c() {
        int i = a.a[this.d.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.e;
            }
            if (i != 3) {
                return null;
            }
            return "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.a + "\" height=\"" + this.f600b + "\" src=\"" + this.e + "\"></iframe>";
        }
        com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar = this.c;
        if (cVar == com.bytedance.sdk.openadsdk.core.i0.m.a.c.IMAGE) {
            return "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.e + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
        }
        if (cVar == com.bytedance.sdk.openadsdk.core.i0.m.a.c.JAVASCRIPT) {
            return "<script src=\"" + this.e + "\"></script>";
        }
        return null;
    }

    public String d() {
        if (this.d == com.bytedance.sdk.openadsdk.core.i0.m.a.d.STATIC_RESOURCE && this.c == com.bytedance.sdk.openadsdk.core.i0.m.a.c.IMAGE) {
            return this.e;
        }
        return null;
    }

    public JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", this.a);
        jSONObject.put("height", this.f600b);
        jSONObject.put("creativeType", this.c.toString());
        jSONObject.put("resourceType", this.d.toString());
        jSONObject.put("contentUrl", this.e);
        jSONObject.put("clickThroughUri", this.h);
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.f));
        jSONObject.put("creativeViewTrackers", com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.g));
        return jSONObject;
    }

    public int f() {
        return this.a;
    }

    public static float a(int i, int i2, int i3, int i4, com.bytedance.sdk.openadsdk.core.i0.m.a.d dVar, com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar) {
        if (i2 == 0 || i4 == 0) {
            return 0.0f;
        }
        float f = i;
        float f2 = i3;
        return a(dVar, cVar) / ((Math.abs((f / i2) - (f2 / i4)) + Math.abs((f - f2) / f)) + 1.0f);
    }

    public void b(long j) {
        if (this.j.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.g, null, j, this.i);
        }
    }

    private static float a(com.bytedance.sdk.openadsdk.core.i0.m.a.d dVar, com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar) {
        int i = a.a[dVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 0.0f : 1.0f;
            }
            return 1.2f;
        }
        if (com.bytedance.sdk.openadsdk.core.i0.m.a.c.JAVASCRIPT.equals(cVar)) {
            return 1.0f;
        }
        return com.bytedance.sdk.openadsdk.core.i0.m.a.c.IMAGE.equals(cVar) ? 0.8f : 0.0f;
    }

    public String a() {
        return this.e;
    }

    public void a(String str) {
        this.i = str;
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("width");
        int iOptInt2 = jSONObject.optInt("height");
        String strOptString = jSONObject.optString("creativeType", com.bytedance.sdk.openadsdk.core.i0.m.a.c.NONE.toString());
        String strOptString2 = jSONObject.optString("resourceType", com.bytedance.sdk.openadsdk.core.i0.m.a.d.HTML_RESOURCE.toString());
        String strOptString3 = jSONObject.optString("contentUrl");
        String strOptString4 = jSONObject.optString("clickThroughUri");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("clickTrackers");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creativeViewTrackers");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(new com.bytedance.sdk.openadsdk.core.i0.l.c.d(jSONArrayOptJSONArray.optString(i)).a());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
            arrayList2.add(new com.bytedance.sdk.openadsdk.core.i0.l.c.d(jSONArrayOptJSONArray2.optString(i2)).a());
        }
        return new c(iOptInt, iOptInt2, com.bytedance.sdk.openadsdk.core.i0.m.a.c.valueOf(strOptString), com.bytedance.sdk.openadsdk.core.i0.m.a.d.valueOf(strOptString2), strOptString3, arrayList, arrayList2, strOptString4);
    }

    public void a(q qVar) {
        this.l = qVar;
    }
}
