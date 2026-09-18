package com.bytedance.sdk.openadsdk.core.i0.l;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VastFractionalProgressTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends c implements Comparable<b> {
    private float f;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.i0.l.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VastFractionalProgressTracker.java */
    public static class C0202b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f619b;
        private c.f c = c.f.TRACKING_URL;
        private boolean d = false;

        public C0202b(String str, float f) {
            this.a = str;
            this.f619b = f;
        }

        public b a() {
            return new b(this.f619b, this.a, this.c, Boolean.valueOf(this.d));
        }
    }

    public boolean a(float f) {
        return this.f <= f && !e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.i0.l.c
    public void f() {
        super.f();
        int i = (this.f > 0.25f ? 1 : (this.f == 0.25f ? 0 : -1));
    }

    public JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", c());
        jSONObject.put("trackingFraction", this.f);
        return jSONObject;
    }

    private b(float f, String str, c.f fVar, Boolean bool) {
        super(str, fVar, bool);
        this.f = f;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        float f = this.f;
        float f2 = bVar.f;
        if (f > f2) {
            return 1;
        }
        return f < f2 ? -1 : 0;
    }
}
